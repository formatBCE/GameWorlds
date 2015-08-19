package gameworlds.test.formatbce.com.gameworlds.core;

import gameworlds.test.formatbce.com.gameworlds.data.WorldsResponseModel;
import retrofit.Callback;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by amitn on 19.08.2015
 */
public interface WorldsService {
    @POST("/worlds")
    void loadWorlds(@Path(value = "section", encode = false) String section, @Query("token") String token, Callback<WorldsResponseModel> callback);
}
