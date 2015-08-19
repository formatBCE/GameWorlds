package gameworlds.test.formatbce.com.gameworlds.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import gameworlds.test.formatbce.com.gameworlds.core.WorldsLoader;
import gameworlds.test.formatbce.com.gameworlds.data.AvailableWorldModel;
import gameworlds.test.formatbce.com.gameworlds.data.WorldsResponseModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by amitn on 19.08.2015
 */
public class WorldsListActivity extends ListActivity implements Callback<WorldsResponseModel> {

    private List<AvailableWorldModel> mItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mItems));
        WorldsLoader.loadWorlds(this);
    }

    @Override
    public void success(WorldsResponseModel result, Response response) {
        mItems.addAll(result.getAllAvailableWorlds());
        ((ArrayAdapter)getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void failure(RetrofitError error) {

    }

}
