package gameworlds.test.formatbce.com.gameworlds.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.Random;

/**
 * Created by amitn on 19.08.2015
 */
public class Constants {
    public static final String API_ROOT_URL = "http://backend1.lordsandknights.com/XYRALITY/WebObjects/BKLoginServer.woa/wa";

    /**
     * generates random string with length 20
     *
     * @return random string
     */
    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(20);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    public static String getDeviceId(Context cnt) {
        WifiManager wifiManager = (WifiManager) cnt.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        if (wInfo != null) {
            return wInfo.getMacAddress();
        } else {
            return Constants.random();
        }
    }
    public static String getDeviceType() {
        return String.format("%s %s",   android.os.Build.MODEL, android.os.Build.VERSION.RELEASE);
    }


}
