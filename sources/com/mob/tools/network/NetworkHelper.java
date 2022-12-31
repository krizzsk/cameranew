package com.mob.tools.network;

import android.content.Context;
import android.net.Uri;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.rockerhieu.emoji.model.Emoticon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes2.dex */
public class NetworkHelper {
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    protected boolean instanceFollowRedirects = followRedirects;

    /* loaded from: classes2.dex */
    public static class NetworkTimeOut {
        public int connectionTimeout;
        public int readTimout;
    }

    /* loaded from: classes2.dex */
    public static final class SimpleX509TrustManager implements X509TrustManager {
        private String serverHost;
        private X509TrustManager standardTrustManager;

        public SimpleX509TrustManager(KeyStore keyStore, String str) {
            try {
                this.serverHost = str;
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers != null && trustManagers.length != 0) {
                    this.standardTrustManager = (X509TrustManager) trustManagers[0];
                    return;
                }
                throw new NoSuchAlgorithmException("no trust manager found.");
            } catch (Exception e2) {
                NLog mobLog = MobLog.getInstance();
                mobLog.d("failed to initialize the standard trust manager: " + e2.getMessage(), new Object[0]);
                this.standardTrustManager = null;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (x509CertificateArr != null) {
                if (x509CertificateArr.length == 1) {
                    x509CertificateArr[0].checkValidity();
                    return;
                }
                X509TrustManager x509TrustManager = this.standardTrustManager;
                if (x509TrustManager != null) {
                    if (Build.VERSION.SDK_INT >= 17) {
                        new X509TrustManagerExtensions(this.standardTrustManager).checkServerTrusted(x509CertificateArr, str, this.serverHost);
                        return;
                    } else {
                        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                        return;
                    }
                }
                throw new CertificateException("there were one more certificates but no trust manager found.");
            }
            throw new IllegalArgumentException("there were no certificates.");
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static String checkHttpRequestUrl(String str) {
        int i2;
        Uri parse;
        String scheme;
        String str2;
        try {
            if (!TextUtils.isEmpty(str) && (i2 = Build.VERSION.SDK_INT) >= 23) {
                Object invokeStaticMethod = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("android.security.NetworkSecurityPolicy"), "getInstance", new Object[0]);
                if (!((Boolean) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "isCleartextTrafficPermitted", new Object[0])).booleanValue()) {
                    str = str.trim();
                    if (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) && (parse = Uri.parse(str.trim())) != null && (scheme = parse.getScheme()) != null && scheme.equals("http")) {
                        String host = parse.getHost();
                        String path = parse.getPath();
                        if (host != null) {
                            int port = parse.getPort();
                            StringBuilder sb = new StringBuilder();
                            sb.append(host);
                            if (port > 0 && port != 80) {
                                str2 = ":" + port;
                                sb.append(str2);
                                host = sb.toString();
                                if (i2 >= 24 && ((Boolean) ReflectHelper.invokeInstanceMethod(invokeStaticMethod, "isCleartextTrafficPermitted", host)).booleanValue()) {
                                    return str;
                                }
                            }
                            str2 = "";
                            sb.append(str2);
                            host = sb.toString();
                            if (i2 >= 24) {
                                return str;
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Constants.HTTPS_PROTOCOL_PREFIX);
                        sb2.append(host);
                        if (path == null) {
                            path = "";
                        }
                        sb2.append(path);
                        return sb2.toString();
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return str;
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) throws Throwable {
        Object obj;
        boolean z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        String str2 = "methodTokens";
        try {
            obj = ReflectHelper.getInstanceField(httpURLConnection, "methodTokens");
        } catch (Throwable unused) {
            obj = null;
        }
        if (obj == null) {
            str2 = "PERMITTED_USER_METHODS";
            try {
                obj = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (Throwable unused2) {
            }
            z = true;
        } else {
            z = false;
        }
        if (obj != null) {
            String[] strArr = (String[]) obj;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = "PATCH";
            if (z) {
                ReflectHelper.setStaticField("HttpURLConnection", str2, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, str2, strArr2);
            }
        }
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new SimpleX509TrustManager(null, httpsURLConnection.getURL().getHost())}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i2 = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i2 > 0) {
            httpURLConnection.setConnectTimeout(i2);
        }
        int i3 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i3 > 0) {
            httpURLConnection.setReadTimeout(i3);
        }
        return httpURLConnection;
    }

    private HTTPPart getDataPostHttpPart(HttpURLConnection httpURLConnection, String str, byte[] bArr) throws Throwable {
        ByteArrayPart byteArrayPart = new ByteArrayPart();
        byteArrayPart.append(bArr);
        return byteArrayPart;
    }

    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) throws Throwable {
        String uuid = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "multipart/form-data; boundary=" + uuid);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                stringPart.append("--").append(uuid).append("\r\n");
                stringPart.append("Content-Disposition: form-data; name=\"").append(next.name).append("\"\r\n\r\n");
                stringPart.append(next.value).append("\r\n");
            }
        }
        multiPart.append(stringPart);
        Iterator<KVPair<String>> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            KVPair<String> next2 = it2.next();
            StringPart stringPart2 = new StringPart();
            File file = new File(next2.value);
            stringPart2.append("--").append(uuid).append("\r\n");
            stringPart2.append("Content-Disposition: form-data; name=\"").append(next2.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(next2.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (next2.value.toLowerCase().endsWith("jpg") || next2.value.toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (next2.value.toLowerCase().endsWith(Emoticon.TYPE_PNG)) {
                    contentTypeFor = "image/png";
                } else if (next2.value.toLowerCase().endsWith(Emoticon.TYPE_GIF)) {
                    contentTypeFor = "image/gif";
                } else {
                    FileInputStream fileInputStream = new FileInputStream(next2.value);
                    String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream(fileInputStream);
                    fileInputStream.close();
                    contentTypeFor = (guessContentTypeFromStream == null || guessContentTypeFromStream.length() <= 0) ? "application/octet-stream" : guessContentTypeFromStream;
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile(next2.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append("\r\n");
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(uuid).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    private Object getHttpPatch(String str) throws Throwable {
        return null;
    }

    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) throws Throwable {
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_FORM);
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(kvPairsToUrl(arrayList));
        }
        return stringPart;
    }

    private void httpPatchImpl(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j2, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        Object newInstance;
        String str2 = str;
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPatch: " + str2, new Object[0]);
        ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
        ReflectHelper.importClass("org.apache.http.params.BasicHttpParams");
        ReflectHelper.importClass("org.apache.http.params.HttpConnectionParams");
        ReflectHelper.importClass("org.apache.http.HttpVersion");
        ReflectHelper.importClass("org.apache.http.params.HttpProtocolParams");
        ReflectHelper.importClass("org.apache.http.conn.scheme.SchemeRegistry");
        ReflectHelper.importClass("org.apache.http.conn.scheme.PlainSocketFactory");
        ReflectHelper.importClass("org.apache.http.conn.scheme.Scheme");
        ReflectHelper.importClass("org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager");
        ReflectHelper.importClass("org.apache.http.impl.client.DefaultHttpClient");
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str2 = str2 + "?" + kvPairsToUrl;
            }
        }
        Object httpPatch = getHttpPatch(str2);
        if (httpPatch != null && arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                ReflectHelper.invokeInstanceMethod(httpPatch, "setHeader", next.name, next.value);
            }
        }
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j2);
        Object newInstance2 = ReflectHelper.newInstance("InputStreamEntity", filePart.toInputStream(), Long.valueOf(filePart.length() - j2));
        ReflectHelper.invokeInstanceMethod(newInstance2, "setContentEncoding", "application/offset+octet-stream");
        ReflectHelper.invokeInstanceMethod(httpPatch, "setEntity", newInstance2);
        Object newInstance3 = ReflectHelper.newInstance("BasicHttpParams", new Object[0]);
        int i2 = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i2 > 0) {
            ReflectHelper.invokeStaticMethod("HttpConnectionParams", "setConnectionTimeout", newInstance3, Integer.valueOf(i2));
        }
        if ((networkTimeOut == null ? readTimout : networkTimeOut.readTimout) > 0) {
            ReflectHelper.invokeStaticMethod("HttpConnectionParams", "setSoTimeout", newInstance3, Integer.valueOf(i2));
        }
        ReflectHelper.invokeInstanceMethod(httpPatch, "setParams", newInstance3);
        if (str2.startsWith(Constants.HTTPS_PROTOCOL_PREFIX)) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            SSLSocketFactoryEx sSLSocketFactoryEx = new SSLSocketFactoryEx(keyStore, new URL(str2).getHost());
            sSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            Object newInstance4 = ReflectHelper.newInstance("BasicHttpParams", new Object[0]);
            ReflectHelper.invokeStaticMethod("HttpProtocolParams", "setVersion", newInstance4, ReflectHelper.getStaticField("HttpVersion", "HTTP_1_1"));
            ReflectHelper.invokeStaticMethod("HttpProtocolParams", "setContentCharset", newInstance4, "UTF-8");
            Object newInstance5 = ReflectHelper.newInstance("SchemeRegistry", new Object[0]);
            Object newInstance6 = ReflectHelper.newInstance("Scheme", "http", ReflectHelper.invokeStaticMethod("PlainSocketFactory", "getSocketFactory", new Object[0]), 80);
            Object newInstance7 = ReflectHelper.newInstance("Scheme", "https", sSLSocketFactoryEx, Integer.valueOf((int) WebSocket.DEFAULT_WSS_PORT));
            ReflectHelper.invokeInstanceMethod(newInstance5, "register", newInstance6);
            ReflectHelper.invokeInstanceMethod(newInstance5, "register", newInstance7);
            newInstance = ReflectHelper.newInstance("DefaultHttpClient", ReflectHelper.newInstance("ThreadSafeClientConnManager", newInstance4, newInstance5), newInstance4);
        } else {
            newInstance = ReflectHelper.newInstance("DefaultHttpClient", new Object[0]);
        }
        Object invokeInstanceMethod = ReflectHelper.invokeInstanceMethod(newInstance, "execute", httpPatch);
        Object invokeInstanceMethod2 = ReflectHelper.invokeInstanceMethod(newInstance, "getConnectionManager", new Object[0]);
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl(invokeInstanceMethod));
                ReflectHelper.invokeInstanceMethod(invokeInstanceMethod2, "shutdown", new Object[0]);
            } finally {
            }
        } else {
            ReflectHelper.invokeInstanceMethod(invokeInstanceMethod2, "shutdown", new Object[0]);
        }
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    private String kvPairsToUrl(ArrayList<KVPair<String>> arrayList) throws Throwable {
        StringBuilder sb = new StringBuilder();
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            String urlEncode = Data.urlEncode(next.name, "utf-8");
            String str = next.value;
            String urlEncode2 = str != null ? Data.urlEncode(str, "utf-8") : "";
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(urlEncode);
            sb.append('=');
            sb.append(urlEncode2);
        }
        return sb.toString();
    }

    public static void setFollowRedirects(boolean z) {
        followRedirects = z;
    }

    public void download(String str, final OutputStream outputStream, NetworkTimeOut networkTimeOut) throws Throwable {
        final byte[] bArr = new byte[1024];
        rawGet(str, new RawNetworkCallback() { // from class: com.mob.tools.network.NetworkHelper.1
            @Override // com.mob.tools.network.RawNetworkCallback
            public void onResponse(InputStream inputStream) throws Throwable {
                int read = inputStream.read(bArr);
                while (read != -1) {
                    outputStream.write(bArr, 0, read);
                    read = inputStream.read(bArr);
                }
            }
        }, networkTimeOut);
        outputStream.flush();
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut) throws Throwable {
        return downloadCache(context, str, str2, z, networkTimeOut, null);
    }

    public void getHttpPostResponse(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (kVPair != null && kVPair.value != null && new File(kVPair.value).exists()) {
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(kVPair);
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList3);
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
        }
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpGet: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            connection.disconnect();
            String sb2 = sb.toString();
            MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            if (sb3.length() > 0) {
                sb3.append('\n');
            }
            sb3.append(readLine2);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put("error", sb3.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public ArrayList<KVPair<String[]>> httpHead(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpHead: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setRequestMethod("HEAD");
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        ArrayList<KVPair<String[]>> arrayList3 = new ArrayList<>();
        if (headerFields != null) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                List<String> value = entry.getValue();
                if (value == null) {
                    arrayList3.add(new KVPair<>(entry.getKey(), new String[0]));
                } else {
                    int size = value.size();
                    String[] strArr = new String[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        strArr[i2] = value.get(i2);
                    }
                    arrayList3.add(new KVPair<>(entry.getKey(), strArr));
                }
            }
        }
        connection.disconnect();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return arrayList3;
    }

    public void httpPatch(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j2, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            httpPatchImpl23(str, arrayList, kVPair, j2, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        } else {
            httpPatchImpl(str, arrayList, kVPair, j2, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        }
    }

    public void httpPatchImpl23(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j2, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPatch: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PATCH");
        connection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/offset+octet-stream");
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j2);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPost(str, arrayList, kVPair, arrayList2, 0, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPostFiles(str, arrayList, arrayList2, arrayList3, 0, networkTimeOut);
    }

    public String httpPostFilesChecked(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, bArr, arrayList2, i2, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.4
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode != 200 && responseCode >= 300) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("error", sb.toString());
                    hashMap2.put("status", Integer.valueOf(responseCode));
                    throw new Throwable(new Hashon().fromHashMap(hashMap2));
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                hashMap.put("resp", sb2.toString());
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        return httpPut(str, arrayList, kVPair, arrayList2, networkTimeOut, null);
    }

    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        jsonPost(str, arrayList, arrayList2, networkTimeOut, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.2
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode != 200 && responseCode != 201) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("error", sb.toString());
                    hashMap2.put("status", Integer.valueOf(responseCode));
                    throw new Throwable(new Hashon().fromHashMap(hashMap2));
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                hashMap.put("res", sb2.toString());
            }
        });
        if (hashMap.containsKey("res")) {
            return (String) hashMap.get("res");
        }
        return null;
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (ArrayList<KVPair<String>>) null, rawNetworkCallback, networkTimeOut);
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                try {
                    rawNetworkCallback.onResponse(connection.getInputStream());
                } finally {
                }
            } else {
                connection.disconnect();
            }
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(readLine);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put("error", sb.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.instanceFollowRedirects = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0212 A[Catch: all -> 0x02a0, TryCatch #0 {all -> 0x02a0, blocks: (B:79:0x01e9, B:81:0x01ef, B:83:0x01f5, B:86:0x01fa, B:88:0x0212, B:93:0x0225, B:97:0x0239, B:92:0x0221, B:99:0x0242, B:101:0x0248, B:103:0x024e, B:104:0x0251, B:106:0x025c, B:107:0x0271), top: B:124:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0242 A[Catch: all -> 0x02a0, TryCatch #0 {all -> 0x02a0, blocks: (B:79:0x01e9, B:81:0x01ef, B:83:0x01f5, B:86:0x01fa, B:88:0x0212, B:93:0x0225, B:97:0x0239, B:92:0x0221, B:99:0x0242, B:101:0x0248, B:103:0x024e, B:104:0x0251, B:106:0x025c, B:107:0x0271), top: B:124:0x01e9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String downloadCache(android.content.Context r18, java.lang.String r19, java.lang.String r20, boolean r21, com.mob.tools.network.NetworkHelper.NetworkTimeOut r22, com.mob.tools.network.FileDownloadListener r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 780
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.network.NetworkHelper.downloadCache(android.content.Context, java.lang.String, java.lang.String, boolean, com.mob.tools.network.NetworkHelper$NetworkTimeOut, com.mob.tools.network.FileDownloadListener):java.lang.String");
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, int i2, NetworkTimeOut networkTimeOut) throws Throwable {
        ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
        if (kVPair != null && kVPair.value != null && new File(kVPair.value).exists()) {
            arrayList3.add(kVPair);
        }
        return httpPostFiles(str, arrayList, arrayList3, arrayList2, i2, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i2, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.3
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode != 200 && responseCode >= 300) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("error", sb.toString());
                    hashMap2.put("status", Integer.valueOf(responseCode));
                    throw new Throwable(new Hashon().fromHashMap(hashMap2));
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                hashMap.put("resp", sb2.toString());
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, OnReadListener onReadListener) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().i("httpPut: " + str, new Object[0]);
        if (arrayList != null) {
            String kvPairsToUrl = kvPairsToUrl(arrayList);
            if (kvPairsToUrl.length() > 0) {
                str = str + "?" + kvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "application/octet-stream");
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        if (onReadListener != null) {
            filePart.setOnReadListener(onReadListener);
        }
        filePart.setFile(kVPair.value);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200 && responseCode != 201) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(readLine);
            }
            bufferedReader.close();
            HashMap hashMap = new HashMap();
            hashMap.put("error", sb.toString());
            hashMap.put("status", Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(hashMap));
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            if (sb2.length() > 0) {
                sb2.append('\n');
            }
            sb2.append(readLine2);
        }
        bufferedReader2.close();
        connection.disconnect();
        String sb3 = sb2.toString();
        MobLog.getInstance().i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return sb3;
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                rawNetworkCallback.onResponse(connection.getInputStream());
            }
            connection.disconnect();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(readLine);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap hashMap = new HashMap();
        hashMap.put("error", sb.toString());
        hashMap.put("status", Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(hashMap));
    }

    public void jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<KVPair<String>> it = arrayList.iterator();
        while (it.hasNext()) {
            KVPair<String> next = it.next();
            hashMap.put(next.name, next.value);
        }
        jsonPost(str, hashMap, arrayList2, networkTimeOut, httpResponseCallback);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, int i2, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap hashMap = new HashMap();
        httpPost(str, arrayList, i2, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.5
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode != 200 && responseCode >= 300) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                    for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(readLine);
                    }
                    bufferedReader.close();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("error", sb.toString());
                    hashMap2.put("status", Integer.valueOf(responseCode));
                    throw new Throwable(new Hashon().fromHashMap(hashMap2));
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(readLine2);
                }
                bufferedReader2.close();
                hashMap.put("resp", sb2.toString());
            }
        }, networkTimeOut);
        return (String) hashMap.get("resp");
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        httpPost(str, arrayList, arrayList2, arrayList3, 0, httpResponseCallback, networkTimeOut);
    }

    public void jsonPost(String str, HashMap<String, Object> hashMap, ArrayList<KVPair<String>> arrayList, NetworkTimeOut networkTimeOut, HttpResponseCallback httpResponseCallback) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("jsonPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestProperty("content-type", HttpRequest.CONTENT_TYPE_JSON);
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        StringPart stringPart = new StringPart();
        if (hashMap != null) {
            stringPart.append(new Hashon().fromHashMap(hashMap));
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = stringPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty("Connection", "Keep-Alive");
        if (arrayList2 != null && arrayList2.size() > 0) {
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList2);
            if (i2 >= 0) {
                connection.setChunkedStreamingMode(i2);
            }
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        }
        if (arrayList3 != null) {
            Iterator<KVPair<String>> it = arrayList3.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (ArrayList<KVPair<String>>) null, httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        if (connection.getResponseCode() == 301) {
            rawGet(connection.getHeaderField(HttpRequest.HEADER_LOCATION), (ArrayList<KVPair<String>>) null, httpResponseCallback, networkTimeOut);
        } else if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, byte[] bArr, ArrayList<KVPair<String>> arrayList2, int i2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty("Connection", "Keep-Alive");
        if (bArr != null && bArr.length > 0) {
            textPostHTTPPart = getDataPostHttpPart(connection, str, bArr);
            if (i2 >= 0) {
                connection.setChunkedStreamingMode(i2);
            }
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        }
        if (arrayList2 != null) {
            Iterator<KVPair<String>> it = arrayList2.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr2 = new byte[65536];
        for (int read = inputStream.read(bArr2); read > 0; read = inputStream.read(bArr2)) {
            outputStream.write(bArr2, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawPost(str, arrayList, hTTPPart, 0, httpResponseCallback, networkTimeOut);
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, int i2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        if (i2 >= 0) {
            connection.setChunkedStreamingMode(0);
        }
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, int i2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long currentTimeMillis = System.currentTimeMillis();
        NLog mobLog = MobLog.getInstance();
        mobLog.i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setRequestProperty("Connection", "Keep-Alive");
        if (arrayList != null) {
            Iterator<KVPair<String>> it = arrayList.iterator();
            while (it.hasNext()) {
                KVPair<String> next = it.next();
                connection.setRequestProperty(next.name, next.value);
            }
        }
        StringPart stringPart = new StringPart();
        stringPart.append(null);
        connection.setInstanceFollowRedirects(this.instanceFollowRedirects);
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = stringPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int read = inputStream.read(bArr); read > 0; read = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, read);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
            }
        }
        NLog mobLog2 = MobLog.getInstance();
        mobLog2.i("use time: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
    }
}
