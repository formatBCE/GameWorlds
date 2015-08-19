package gameworlds.test.formatbce.com.gameworlds.core;

import gameworlds.test.formatbce.com.gameworlds.data.WorldsResponseModel;
import gameworlds.test.formatbce.com.gameworlds.utils.Constants;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by amitn on 19.08.2015
 */
public class WorldsLoader {
    private static final WorldsService service = new RestAdapter.Builder()
            .setClient(new OkClient())
            .setEndpoint(Constants.API_ROOT_URL)
            .build()
            .create(WorldsService.class);

    private Callback<WorldsResponseModel> mCallback;

    public static void loadWorlds(Callback<WorldsResponseModel> callback) {
        WorldsLoader result = new WorldsLoader();
        result.mCallback = callback;
        service.loadWorlds(result.mCallback);
    }


}

