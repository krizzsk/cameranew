package us.pinguo.poker;

import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Pair;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.inspire.api.QiniuAuthToken;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.user.u0;
import us.pinguo.util.v;
/* compiled from: PokerNet.java */
/* loaded from: classes5.dex */
public class p {
    private static final String a;
    public static final String b;

    static {
        String str = us.pinguo.foundation.d.f10985d ? "http://art-qa.camera360.com" : "http://art-api.camera360.com";
        a = str;
        b = str + "/api/art/auth";
    }

    public static j a() throws IOException, JSONException {
        j b2 = j.b();
        if (b2 != null) {
            return b2;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", QiniuAuthToken.TYPE_IMAGE);
        hashMap.put("noWater", "1");
        String d2 = d(b, hashMap);
        if (d2 != null) {
            HttpRequest httpRequest = HttpRequest.get(d2);
            httpRequest.connectTimeout(10000);
            httpRequest.readTimeout(10000);
            httpRequest.trustAllHosts();
            httpRequest.trustAllCerts();
            int code = httpRequest.code();
            if (code == 200) {
                JSONObject jSONObject = new JSONObject(httpRequest.body());
                int optInt = jSONObject.optInt("status", -1);
                if (optInt == 200) {
                    j e2 = j.e(jSONObject.getJSONObject("data"));
                    if (e2.c()) {
                        e2.d();
                        return e2;
                    }
                    throw new IOException("json error:" + e2);
                }
                throw new IOException("request error, status:" + optInt);
            }
            throw new IOException("http error, code:" + code);
        }
        throw new IOException("url exception");
    }

    public static q b(String str, String str2, String str3) throws IOException, JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put(BigAlbumStore.PhotoColumns.ETAG, str3);
        hashMap.put(TJAdUnitConstants.String.STYLE, str2);
        hashMap.put("noWater", "1");
        String d2 = d(str, hashMap);
        if (str != null) {
            HttpRequest httpRequest = HttpRequest.get(d2);
            httpRequest.connectTimeout(10000);
            httpRequest.readTimeout(10000);
            httpRequest.trustAllHosts();
            httpRequest.trustAllCerts();
            int code = httpRequest.code();
            if (code == 200) {
                JSONObject jSONObject = new JSONObject(httpRequest.body());
                int optInt = jSONObject.optInt("status", -1);
                if (optInt == 200) {
                    q b2 = q.b(jSONObject.getJSONObject("data"));
                    if (b2 != null) {
                        return b2;
                    }
                    throw new IOException("creatr poker error");
                }
                throw new IOException("request error, status:" + optInt);
            }
            throw new IOException("http error, code:" + code);
        }
        throw new IOException("url exception");
    }

    public static byte[] c(String str) throws IOException {
        HttpRequest httpRequest = HttpRequest.get(str + "?_=" + System.currentTimeMillis());
        httpRequest.trustAllCerts();
        httpRequest.followRedirects(true);
        httpRequest.connectTimeout(5000);
        httpRequest.readTimeout(10000);
        int code = httpRequest.code();
        if (code == 200) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            httpRequest.receive(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } else if (code == 404) {
            return null;
        } else {
            throw new IOException("Http connect error,status code =" + code);
        }
    }

    private static String d(String str, Map<String, String> map) throws IOException {
        try {
            map.put("appName", us.pinguo.foundation.utils.p.a("camera360"));
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, us.pinguo.foundation.utils.p.a("9.9.27"));
            map.put("systemVersion", us.pinguo.foundation.utils.p.a(String.valueOf(Build.VERSION.SDK_INT)));
            map.put("platform", us.pinguo.foundation.utils.p.a(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
            String str2 = Build.MODEL;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.replaceAll(" ", "");
            }
            map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, us.pinguo.foundation.utils.p.a(str2));
            if (u0.o) {
                map.put("deviceId", "unknown");
            } else {
                map.put("deviceId", us.pinguo.foundation.utils.p.a(j.a.f.e.a(v.a())));
            }
            map.put("locale", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.v.a().toString()));
            map.put("channel", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a()));
            String f2 = f(map, "jNb93Mn69c1f2105vc4c6acf2Z4Lk");
            try {
                String g2 = g(str, map);
                return g2 + "&sig=" + f2;
            } catch (Exception e2) {
                throw new IOException(e2);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static String e(List<String> list, String str) {
        if (list != null && list.size() != 0) {
            Collections.sort(list, e.a);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : list) {
                stringBuffer.append(str2);
            }
            try {
                return us.pinguo.common.utils.f.b(stringBuffer.toString(), str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return "";
    }

    private static String f(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return e(arrayList, str);
    }

    private static String g(String str, Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        if (map != null && map.size() != 0) {
            if (str.contains("?")) {
                if (sb.charAt(sb.length() - 1) != '?' && sb.charAt(sb.length() - 1) != '&') {
                    sb.append('&');
                }
            } else if (sb.charAt(sb.length() - 1) != '?') {
                sb.append('?');
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                sb.append('&');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        int i2 = length - 1;
        if (sb.charAt(i2) == '?') {
            sb.deleteCharAt(i2);
        }
        return sb.toString();
    }

    private static String i(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        if (httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(us.pinguo.foundation.utils.p.b());
        }
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(PayResult.PAY_RESULT_ALIPAY_CHECK_IN);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charsert", "UTF-8");
        httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "multipart/form-data;boundary=" + uuid);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("--");
            sb.append(uuid);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Content-Type: text/plain; charset=");
            sb2.append("UTF-8");
            sb2.append("\r\n");
            sb.append(sb2.toString());
            sb.append("Content-Transfer-Encoding: 8bit\r\n");
            sb.append("\r\n");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        BufferedReader bufferedReader = null;
        try {
            dataOutputStream.write(sb.toString().getBytes());
            if (bArr != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("--");
                sb3.append(uuid);
                sb3.append("\r\n");
                sb3.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + str2 + "\"\r\n");
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Content-Type: image/jpeg; charset=");
                sb4.append("UTF-8");
                sb4.append("\r\n");
                sb3.append(sb4.toString());
                sb3.append("\r\n");
                dataOutputStream.write(sb3.toString().getBytes());
                dataOutputStream.write(bArr);
                dataOutputStream.write("\r\n".getBytes());
            }
            dataOutputStream.write(("--" + uuid + "--\r\n").getBytes());
            dataOutputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                if (responseCode != 401 && responseCode != 579) {
                    throw new IOException("upload failed, code:" + responseCode);
                }
                j.a();
                throw new IOException("token time out, code:" + responseCode);
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb5.append(readLine);
                    } else {
                        String sb6 = sb5.toString();
                        bufferedReader2.close();
                        dataOutputStream.close();
                        httpURLConnection.disconnect();
                        return sb6;
                    }
                }
            } catch (Throwable th) {
                bufferedReader = bufferedReader2;
                th = th;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                dataOutputStream.close();
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String j(s sVar, j jVar) throws IOException, JSONException {
        HashMap hashMap = new HashMap();
        hashMap.put("x:platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        hashMap.put("x:etag", sVar.a);
        hashMap.put("x:width", String.valueOf(sVar.c));
        hashMap.put("x:height", String.valueOf(sVar.f11748d));
        hashMap.put("token", jVar.b);
        String i2 = i(jVar.a, hashMap, new File(sVar.b).getName(), sVar.f11749e);
        if (!TextUtils.isEmpty(i2)) {
            JSONObject jSONObject = new JSONObject(i2);
            if (200 == jSONObject.optInt("status", -1)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String optString = jSONObject2.optString("etag_ori");
                if (sVar.a.equals(optString)) {
                    String optString2 = jSONObject2.optString("pic_ori");
                    if (TextUtils.isEmpty(optString2)) {
                        throw new IllegalArgumentException("error json:" + i2);
                    }
                    return optString2;
                }
                throw new IllegalArgumentException("error etag, up etag:" + sVar.a + " /receive etag:" + optString);
            }
            throw new IOException("error json:" + i2);
        }
        throw new IOException("error json:" + i2);
    }

    public static Pair<String, String> k(String str, Point point, j jVar) throws IOException, JSONException {
        HashMap hashMap = new HashMap();
        String b2 = k.b(str);
        hashMap.put("x:platform", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        hashMap.put("x:etag", b2);
        hashMap.put("x:width", String.valueOf(point.x));
        hashMap.put("x:height", String.valueOf(point.y));
        hashMap.put("token", jVar.b);
        File file = new File(str);
        String i2 = i(jVar.a, hashMap, file.getName(), us.pinguo.common.utils.e.k(file));
        if (!TextUtils.isEmpty(i2)) {
            JSONObject jSONObject = new JSONObject(i2);
            if (200 == jSONObject.optInt("status", -1)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                String optString = jSONObject2.optString("etag_ori");
                if (b2.equals(optString)) {
                    String optString2 = jSONObject2.optString("pic_ori");
                    if (!TextUtils.isEmpty(optString2)) {
                        return new Pair<>(optString2, b2);
                    }
                    throw new IllegalArgumentException("error json:" + i2);
                }
                throw new IllegalArgumentException("error etag, up etag:" + b2 + " /receive etag:" + optString);
            }
            throw new IOException("error json:" + i2);
        }
        throw new IOException("error json:" + i2);
    }
}
