package gameworlds.test.formatbce.com.gameworlds.core;

import gameworlds.test.formatbce.com.gameworlds.data.WorldsResponseModel;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by amitn on 19.08.2015
 */
public interface WorldsService {
    @FormUrlEncoded
    @POST("/worlds")
    void loadWorlds(@Field("login") String username,
                    @Field("password") String password,
                    @Field("deviceType") String deviceType,
                    @Field("deviceId") String deviceId,
                    Callback<WorldsResponseModel> callback);
}
