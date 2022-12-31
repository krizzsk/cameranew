package com.pinguo.camera360.cloud.cropImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: UriTexture.java */
@Deprecated
/* loaded from: classes3.dex */
public class f extends e {
    public static final String a;
    public static final HttpParams b;
    public static final SchemeRegistry c;

    /* compiled from: UriTexture.java */
    /* loaded from: classes3.dex */
    class a extends Thread {
        final /* synthetic */ BitmapFactory.Options a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, BitmapFactory.Options options) {
            super(str);
            this.a = options;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(6000L);
                this.a.requestCancelDecode();
            } catch (InterruptedException unused) {
            }
        }
    }

    static {
        String a2 = com.pinguo.camera360.cloud.cropImage.a.a("hires-image-cache");
        a = a2;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpProtocolParams.setUserAgent(basicHttpParams, "Cooliris-ImageDownload");
        b = basicHttpParams;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        c = schemeRegistry;
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (new File(a2).mkdirs()) {
            return;
        }
        us.pinguo.common.log.a.u("UriTexture", "Create dir failed!", new Object[0]);
    }

    private static int a(InputStream inputStream, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        return us.pinguo.util.e.d(options, Math.min(i2, i3) / 2, i2 * i3);
    }

    public static String b(long j2, int i2) {
        return a + j2 + "_" + i2 + ".cache";
    }

    public static Bitmap c(long j2, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = false;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inDither = true;
            if (j2 != 0) {
                return BitmapFactory.decodeFile(b(j2, i2), options);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap d(Context context, String str, int i2, int i3, long j2, ClientConnectionManager clientConnectionManager) throws IOException, URISyntaxException, OutOfMemoryError {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        long a2 = str.startsWith(FirebaseAnalytics.Param.CONTENT) ? j2 : b.a(str);
        Bitmap c2 = c(a2, i2);
        if (c2 != null) {
            return c2;
        }
        boolean z = str.startsWith(FirebaseAnalytics.Param.CONTENT) || str.startsWith(InspirePublishFragment.FILE_HEADER);
        if (!str.startsWith(FirebaseAnalytics.Param.CONTENT) && !str.startsWith("file")) {
            bufferedInputStream = e(str, clientConnectionManager);
        } else {
            bufferedInputStream = new BufferedInputStream(context.getContentResolver().openInputStream(Uri.parse(str)), 16384);
        }
        if (bufferedInputStream != null) {
            options.inSampleSize = a(bufferedInputStream, i2, i3);
            if (!str.startsWith(FirebaseAnalytics.Param.CONTENT) && !str.startsWith("file")) {
                bufferedInputStream2 = e(str, clientConnectionManager);
            } else {
                bufferedInputStream2 = new BufferedInputStream(context.getContentResolver().openInputStream(Uri.parse(str)), 16384);
            }
            if (bufferedInputStream2 != null) {
                options.inDither = false;
                options.inJustDecodeBounds = false;
                new a("BitmapTimeoutThread", options).start();
                c2 = BitmapFactory.decodeStream(bufferedInputStream2, null, options);
            }
            int i4 = options.inSampleSize;
            if ((i4 > 1 || !z) && c2 != null) {
                f(a2, c2, i2 / i4);
            }
            return c2;
        }
        return null;
    }

    private static BufferedInputStream e(String str, ClientConnectionManager clientConnectionManager) {
        InputStream inputStream;
        if (clientConnectionManager == null) {
            try {
                URLConnection openConnection = new URI(str).toURL().openConnection();
                openConnection.connect();
                inputStream = openConnection.getInputStream();
            } catch (Exception e2) {
                us.pinguo.common.log.a.u("UriTexture", "Request failed: " + str, new Object[0]);
                e2.printStackTrace();
                return null;
            }
        } else {
            try {
                HttpEntity entity = new DefaultHttpClient(clientConnectionManager, b).execute(new HttpGet(str)).getEntity();
                inputStream = entity != null ? entity.getContent() : null;
            } catch (Exception unused) {
            }
        }
        if (inputStream != null) {
            return new BufferedInputStream(inputStream, 4096);
        }
        return null;
    }

    public static void f(long j2, Bitmap bitmap, int i2) {
        Exception exc;
        BufferedOutputStream bufferedOutputStream;
        String b2 = b(j2, i2);
        if (bitmap == null || b2 == null || j2 == 0) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(b2);
            if (!file.createNewFile()) {
                us.pinguo.common.log.a.u("UriTexture", "Create new file failed!", new Object[0]);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream2, 16384);
            } catch (Exception e2) {
                exc = e2;
                bufferedOutputStream = null;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                bufferedOutputStream.flush();
            } catch (Exception e3) {
                exc = e3;
                fileOutputStream = fileOutputStream2;
                exc.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
            }
        } catch (Exception e6) {
            exc = e6;
            bufferedOutputStream = null;
        }
    }
}
