package gameworlds.test.formatbce.com.gameworlds.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amitn on 19.08.2015
 */
public class WorldsResponseModel {

    private String serverVersion;
    private List<AvailableWorldModel> allAvailableWorlds = new ArrayList<>();

    /**
     *
     * @return
     * The serverVersion
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     *
     * @return
     * The allAvailableWorlds
     */
    public List<AvailableWorldModel> getAllAvailableWorlds() {
        return allAvailableWorlds;
    }

}
