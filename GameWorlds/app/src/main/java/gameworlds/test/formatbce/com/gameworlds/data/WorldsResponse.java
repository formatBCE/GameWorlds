package gameworlds.test.formatbce.com.gameworlds.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by amitn on 19.08.2015
 */
public class WorldsResponse {

    private String serverVersion;
    private List<AvailableWorld> allAvailableWorlds = new ArrayList<>();

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
    public List<AvailableWorld> getAllAvailableWorlds() {
        return allAvailableWorlds;
    }

}
