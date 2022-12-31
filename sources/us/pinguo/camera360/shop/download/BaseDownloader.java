package us.pinguo.camera360.shop.download;

import android.content.Context;
import android.net.Uri;
import com.growingio.android.sdk.collection.Constants;
import com.pinguo.album.data.download.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import us.pinguo.camera360.shop.manager.ExceptionStatManager;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes4.dex */
public class BaseDownloader {
    private Context a;

    /* loaded from: classes4.dex */
    public enum Scheme {
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        ASSETS("assets"),
        UNKNOWN("");
        
        private String scheme;
        private String uriPrefix;

        Scheme(String str) {
            this.scheme = str;
            this.uriPrefix = str + "://";
        }

        private boolean belongsTo(String str) {
            return str.toLowerCase(Locale.US).startsWith(this.uriPrefix);
        }

        public static Scheme ofUri(String str) {
            Scheme[] values;
            if (str != null) {
                for (Scheme scheme : values()) {
                    if (scheme.belongsTo(str)) {
                        return scheme;
                    }
                }
            }
            return UNKNOWN;
        }

        public String crop(String str) {
            if (belongsTo(str)) {
                return str.substring(this.uriPrefix.length());
            }
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
        }

        public String wrap(String str) {
            return this.uriPrefix + str;
        }
    }

    public BaseDownloader(Context context) {
        this.a = context;
    }

    protected HttpURLConnection a(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(100000);
        return httpURLConnection;
    }

    public InputStream b(String str, Object obj, long j2) throws IOException {
        if (!str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) && !str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            if (str.startsWith("assets://")) {
                return d(str);
            }
            if (str.startsWith(InspirePublishFragment.FILE_HEADER)) {
                return e(str);
            }
            throw new IllegalArgumentException("error url:" + str);
        }
        return f(str, j2);
    }

    public Reader c(String str, Object obj) throws IOException {
        return new InputStreamReader(b(str, obj, 0L));
    }

    protected InputStream d(String str) throws IOException {
        return this.a.getAssets().open(Scheme.ASSETS.crop(str));
    }

    protected InputStream e(String str) throws IOException {
        String crop = Scheme.FILE.crop(str);
        return new com.pinguo.album.data.download.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    protected InputStream f(String str, long j2) throws IOException {
        int responseCode;
        HttpURLConnection a = a(str);
        if (j2 > 0) {
            a.setRequestProperty("Range", "bytes=" + j2 + PGTransHeader.CONNECTOR);
        }
        int i2 = 0;
        while (true) {
            responseCode = a.getResponseCode();
            if (responseCode / 100 != 3 || i2 >= 5) {
                break;
            }
            a = a(a.getHeaderField(HttpRequest.HEADER_LOCATION));
            i2++;
        }
        if (responseCode >= 500) {
            ExceptionStatManager exceptionStatManager = ExceptionStatManager.getInstance();
            exceptionStatManager.e(3, str, "", "Download resource return Http response code is: " + responseCode, 0);
        }
        if (responseCode < 400) {
            try {
                return new com.pinguo.album.data.download.a(new BufferedInputStream(a.getInputStream(), 32768), a.getContentLength());
            } catch (IOException e2) {
                ExceptionStatManager exceptionStatManager2 = ExceptionStatManager.getInstance();
                exceptionStatManager2.e(3, str, "", "Download resource conn.getInputStream() throw IOException: " + e2.getMessage(), 0);
                b.b(a.getErrorStream());
                throw e2;
            }
        }
        throw new IOException("network request exception");
    }
}
