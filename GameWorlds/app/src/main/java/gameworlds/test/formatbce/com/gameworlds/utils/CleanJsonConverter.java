package gameworlds.test.formatbce.com.gameworlds.utils;

import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import retrofit.converter.ConversionException;
import retrofit.converter.GsonConverter;
import retrofit.mime.TypedInput;

/**
 * Created by amitn on 19.08.2015
 */
public class CleanJsonConverter extends GsonConverter {

    public CleanJsonConverter(Gson gson) {
        super(gson);
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        String dirty = toString(body);
        String clean = dirty.replace('(', '[').replace(')', ']').replace(';', ',').replace("\n", "").replace("\r", "").replace("\t", "").replace(" ", "").replace(",}", "}");
        Log.e("JSON", clean);
        body = new JsonTypedInput(clean.getBytes(Charset.forName("UTF-8")));
        return super.fromBody(body, type);
    }

    private String toString(TypedInput body) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(body.in()));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
