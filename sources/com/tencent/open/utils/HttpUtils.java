package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.l;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class HttpUtils {

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class a {
        public final String a;
        public final int b;

        /* synthetic */ a(String str, int i2, b bVar) {
            this(str, i2);
        }

        private a(String str, int i2) {
            this.a = str;
            this.b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class b extends Thread {
        final /* synthetic */ QQToken a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bundle f8201d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f8202e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ IRequestListener f8203f;

        b(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
            this.a = qQToken;
            this.b = context;
            this.c = str;
            this.f8201d = bundle;
            this.f8202e = str2;
            this.f8203f = iRequestListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                JSONObject request = HttpUtils.request(this.a, this.b, this.c, this.f8201d, this.f8202e);
                IRequestListener iRequestListener = this.f8203f;
                if (iRequestListener != null) {
                    iRequestListener.onComplete(request);
                    SLog.i("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                }
            } catch (HttpStatusException e2) {
                IRequestListener iRequestListener2 = this.f8203f;
                if (iRequestListener2 != null) {
                    iRequestListener2.onHttpStatusException(e2);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException" + e2.toString());
                }
            } catch (NetworkUnavailableException e3) {
                IRequestListener iRequestListener3 = this.f8203f;
                if (iRequestListener3 != null) {
                    iRequestListener3.onNetworkUnavailableException(e3);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException" + e3.toString());
                }
            } catch (MalformedURLException e4) {
                IRequestListener iRequestListener4 = this.f8203f;
                if (iRequestListener4 != null) {
                    iRequestListener4.onMalformedURLException(e4);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException" + e4.toString());
                }
            } catch (SocketTimeoutException e5) {
                IRequestListener iRequestListener5 = this.f8203f;
                if (iRequestListener5 != null) {
                    iRequestListener5.onSocketTimeoutException(e5);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException" + e5.toString());
                }
            } catch (ConnectTimeoutException e6) {
                IRequestListener iRequestListener6 = this.f8203f;
                if (iRequestListener6 != null) {
                    iRequestListener6.onConnectTimeoutException(e6);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException" + e6.toString());
                }
            } catch (IOException e7) {
                IRequestListener iRequestListener7 = this.f8203f;
                if (iRequestListener7 != null) {
                    iRequestListener7.onIOException(e7);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException" + e7.toString());
                }
            } catch (JSONException e8) {
                IRequestListener iRequestListener8 = this.f8203f;
                if (iRequestListener8 != null) {
                    iRequestListener8.onJSONException(e8);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException" + e8.toString());
                }
            } catch (Exception e9) {
                IRequestListener iRequestListener9 = this.f8203f;
                if (iRequestListener9 != null) {
                    iRequestListener9.onUnknowException(e9);
                    SLog.e("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException" + e9.toString());
                }
            }
        }
    }

    private HttpUtils() {
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static String b(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                String host = Proxy.getHost(context);
                return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
            }
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            i2++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                sb.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    sb.append("\r\n--" + str + "\r\n");
                }
            }
        }
        return sb.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                if (obj instanceof String[]) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i2 = 0; i2 < stringArray.length; i2++) {
                            if (i2 == 0) {
                                sb.append(URLEncoder.encode(stringArray[i2]));
                            } else {
                                sb.append(URLEncoder.encode("," + stringArray[i2]));
                            }
                        }
                    }
                } else {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return sb.toString();
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return iOException instanceof ZipException ? -54 : -2;
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int i2;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                socketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", socketFactory, (int) WebSocket.DEFAULT_WSS_PORT));
            } else {
                schemeRegistry.register(new Scheme("https", new k(), (int) WebSocket.DEFAULT_WSS_PORT));
            }
        } catch (Exception unused) {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), (int) WebSocket.DEFAULT_WSS_PORT));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        g a2 = context != null ? g.a(context, str) : null;
        int i3 = 0;
        if (a2 != null) {
            i3 = a2.a("Common_HttpConnectionTimeout");
            i2 = a2.a("Common_SocketConnectionTimeout");
        } else {
            i2 = 0;
        }
        if (i3 == 0) {
            i3 = 15000;
        }
        if (i2 == 0) {
            i2 = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i3);
        HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        a proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(proxy.a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static a getProxy(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
            String b2 = b(context);
            int a2 = a(context);
            if (!TextUtils.isEmpty(b2) && a2 >= 0) {
                return new a(b2, a2, null);
            }
        }
        return null;
    }

    public static l.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        Bundle b2;
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && ((activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable())) {
            throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient httpClient = getHttpClient(context, string, str);
        HttpGet httpGet = null;
        int i2 = 0;
        int i3 = -1;
        if (str2.equals("GET")) {
            String encodeUrl = encodeUrl(bundle2);
            i2 = 0 + encodeUrl.length();
            SLog.v("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + str);
            String str3 = str.indexOf("?") == -1 ? str + "?" : str + "&";
            if (com.tencent.open.log.d.b(bundle2) != bundle2) {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl(b2) + " -- url = " + str3);
            } else {
                SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + encodeUrl + " -- url = " + str3);
            }
            httpGet = new HttpGet(str3 + encodeUrl);
            httpGet.addHeader(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
        } else if (str2.equals("POST")) {
            httpGet = new HttpPost(str);
            httpGet.addHeader(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            Bundle bundle3 = new Bundle();
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str4, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpGet.setHeader(HttpRequest.HEADER_CONTENT_TYPE, "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpGet.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(l.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(l.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (String str5 : bundle3.keySet()) {
                    i3++;
                    byteArrayOutputStream.write(l.i("Content-Disposition: form-data; name=\"" + str5 + "\"; filename=\"" + str5 + "\"\r\n"));
                    byteArrayOutputStream.write(l.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str5);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i3 < size - 1) {
                        byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(l.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            i2 = 0 + byteArray2.length;
            byteArrayOutputStream.close();
            httpGet.setEntity(new ByteArrayEntity(byteArray2));
        }
        HttpResponse execute = httpClient.execute(httpGet);
        int statusCode = execute.getStatusLine().getStatusCode();
        SLog.i("openSDK_LOG.HttpUtils", "-->openUrl2 response cdoe =" + statusCode);
        if (statusCode == 200) {
            return new l.a(a(execute), i2);
        }
        throw new HttpStatusException(HttpStatusException.ERROR_INFO + statusCode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x016f, code lost:
        r0 = r3;
        r7 = 0;
        r11 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r18, android.content.Context r19, java.lang.String r20, android.os.Bundle r21, java.lang.String r22) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new b(qQToken, context, str, bundle, str2, iRequestListener).start();
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader(HttpRequest.HEADER_CONTENT_ENCODING);
        if (firstHeader != null && firstHeader.getValue().toLowerCase().indexOf(HttpRequest.ENCODING_GZIP) > -1) {
            content = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = content.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                content.close();
                return str;
            }
        }
    }

    private static int a(Context context) {
        if (Build.VERSION.SDK_INT < 11) {
            if (context != null) {
                int port = Proxy.getPort(context);
                return port < 0 ? Proxy.getDefaultPort() : port;
            }
            return Proxy.getDefaultPort();
        }
        String property = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }
}
