package gameworlds.test.formatbce.com.gameworlds.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by amitn on 19.08.2015
 */
public class AvailableWorldModel {
    private String id;
    private String language;
    private String url;
    private String country;
    private WorldStatusModel worldStatus;
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
    public WorldStatusModel getWorldStatus() {
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
        return removeUTFCharacters(name);
    }

    public static String removeUTFCharacters(String data){
        Pattern p = Pattern.compile("\\\\u(\\p{XDigit}{4})");
        Matcher m = p.matcher(data);
        StringBuffer buf = new StringBuffer(data.length());
        while (m.find()) {
            String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
            m.appendReplacement(buf, Matcher.quoteReplacement(ch));
        }
        m.appendTail(buf);
        return buf.toString();
    }

}
