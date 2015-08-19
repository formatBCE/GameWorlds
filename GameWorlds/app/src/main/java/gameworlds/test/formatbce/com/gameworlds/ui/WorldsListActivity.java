package gameworlds.test.formatbce.com.gameworlds.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ArrayAdapter;

import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import gameworlds.test.formatbce.com.gameworlds.core.WorldsService;
import gameworlds.test.formatbce.com.gameworlds.data.AvailableWorldModel;
import gameworlds.test.formatbce.com.gameworlds.data.WorldsResponseModel;
import gameworlds.test.formatbce.com.gameworlds.utils.CleanJsonConverter;
import gameworlds.test.formatbce.com.gameworlds.utils.Constants;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by amitn on 19.08.2015
 */
public class WorldsListActivity extends ListActivity implements Callback<WorldsResponseModel> {

    public static final String EXTRA_PWD = "pwd";
    public static final String EXTRA_LOGIN = "login";
    private List<AvailableWorldModel> mItems = new ArrayList<>();
    private MaterialDialog mProgress;
    private final WorldsService mLoader = new RestAdapter.Builder()
            .setClient(new OkClient())
            .setLogLevel(RestAdapter.LogLevel.FULL)
            .setConverter(new CleanJsonConverter(new GsonBuilder().create()))
            .setEndpoint(Constants.API_ROOT_URL)
            .build()
            .create(WorldsService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String login = getIntent().getStringExtra(EXTRA_LOGIN);
        String password = getIntent().getStringExtra(EXTRA_PWD);
        if (TextUtils.isEmpty(login) || TextUtils.isEmpty(password)) {
            close("Error on login", "Login and password cannot be empty.");
        } else {
            setListAdapter(new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, mItems));
            mProgress = new MaterialDialog.Builder(this)
                    .content("Loading worlds list")
                    .cancelable(false)
                    .progress(true, 0)
                    .show();
            try {
                mLoader.loadWorlds(URLEncoder.encode(login, "UTF-8"),
                        URLEncoder.encode(password, "UTF-8"),
                        URLEncoder.encode(Constants.getDeviceType(), "UTF-8"),
                        URLEncoder.encode(Constants.getDeviceId(this), "UTF-8"),
                        this);
            } catch (UnsupportedEncodingException e) {
                close("Encoding error", "No UTF-8 encoding on device.");
            }
        }
    }

    @Override
    public void success(WorldsResponseModel result, Response response) {
        if (mProgress != null && mProgress.isShowing()) {
            mProgress.dismiss();
        }
        mItems.clear();
        mItems.addAll(result.getAllAvailableWorlds());
        ArrayAdapter adapter = ((ArrayAdapter) getListAdapter());
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        } else {
            close("Program error", "Error building list.");
        }
    }

    @Override
    public void failure(RetrofitError error) {
        close("Error loading worlds", error.getMessage());
    }

    /**
     * Closes application with informing user by dialog
     *
     * @param errTitle title of the dialog
     * @param errMsg   additional message for dialog
     */
    private void close(@NonNull String errTitle, @NonNull String errMsg) {
        if (mProgress != null && mProgress.isShowing()) {
            mProgress.dismiss();
        }
        new MaterialDialog.Builder(this)
                .cancelable(false)
                .title(errTitle)
                .content(errMsg + "\n" + "Application will be closed!")
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        finish();
                    }
                })
                .positiveText("OK")
                .show();
    }

}
