package us.pinguo.inspire.util.siliconpressor;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.net.URISyntaxException;
import us.pinguo.inspire.util.siliconpressor.videocompression.MediaController;
/* loaded from: classes9.dex */
public class SiliCompressor {
    private static final String a = "SiliCompressor";
    static volatile SiliCompressor b;
    private static Context c;

    /* loaded from: classes9.dex */
    public static class Builder {
        private final Context a;

        public Builder(Context context) {
            if (context != null) {
                this.a = context.getApplicationContext();
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public SiliCompressor a() {
            return new SiliCompressor(this.a);
        }
    }

    public SiliCompressor(Context context) {
        c = context;
    }

    public static SiliCompressor b(Context context) {
        if (b == null) {
            synchronized (SiliCompressor.class) {
                if (b == null) {
                    b = new Builder(context).a();
                }
            }
        }
        return b;
    }

    public String a(String str, String str2, int i2, int i3, int i4) throws URISyntaxException {
        if (MediaController.getInstance().a(str, new File(str2), i2, i3, i4)) {
            Log.v(a, "Video Conversion Complete");
        } else {
            Log.v(a, "Video conversion in progress");
        }
        return MediaController.c.getPath();
    }
}
