package gameworlds.test.formatbce.com.gameworlds.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import retrofit.mime.TypedInput;

/**
 * Created by amitn on 19.08.2015
 */
public class JsonTypedInput implements TypedInput {
    private final byte[] mStringBytes;

    JsonTypedInput(byte[] stringBytes) {
        this.mStringBytes = stringBytes;
    }


    @Override
    public String mimeType() {
        return "application/json; charset=UTF-8";
    }


    @Override
    public long length() {
        return mStringBytes.length;
    }

    @Override
    public InputStream in() throws IOException {
        return new ByteArrayInputStream(mStringBytes);
    }
}
