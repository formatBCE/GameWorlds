package gameworlds.test.formatbce.com.gameworlds.data;

/**
 * Created by amitn on 19.08.2015
 */
public class AvailableWorldModel {
    private String id;
    private String language;
    private String url;
    private String country;
    private WorldStatus worldStatus;
    private String mapURL;
    private String name;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @return The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return The worldStatus
     */
    public WorldStatus getWorldStatus() {
        return worldStatus;
    }

    /**
     * @return The mapURL
     */
    public String getMapURL() {
        return mapURL;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
