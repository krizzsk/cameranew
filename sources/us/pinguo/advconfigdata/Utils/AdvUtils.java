package us.pinguo.advconfigdata.Utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes3.dex */
public class AdvUtils {
    private static final int BUFFER_SIZE = 8192;
    private static final int CONNECTION_TIMEOUT = 5000;
    private static final String HASH_ALGORITHM = "MD5";
    private static final int MAX_SAMPLE_LENGTH = 524288;
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 4;
    public static final int NETWORK_4G = 8;
    public static final int NETWORK_NO = -1;
    public static final int NETWORK_UNKNOWN = 0;
    public static final int NETWORK_WIFI = 16;
    private static final int RADIX = 36;
    private static final String TAG = "AdvManager";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static String advDecrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                byte[] decrypt3Des = decrypt3Des(AdvBase64.decode(str.getBytes("UTF-8")), str2);
                if (decrypt3Des == null) {
                    return null;
                }
                return new String(decrypt3Des, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] build3DesKey(String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[24];
        byte[] bytes = str.getBytes("UTF-8");
        if (24 > bytes.length) {
            System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        } else {
            System.arraycopy(bytes, 0, bArr, 0, 24);
        }
        return bArr;
    }

    public static boolean checkApkExist2(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                context.getPackageManager().getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean checkPackageInstall(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static int currentNetType(Context context) {
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return -1;
        }
        if (Build.VERSION.SDK_INT > 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return -1;
            }
            return networkCapabilities.hasTransport(1) ? 16 : 8;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType() == 1 ? 16 : 8;
    }

    public static byte[] decrypt3Des(byte[] bArr, String str) {
        if (bArr != null && str != null) {
            try {
                byte[] build3DesKey = build3DesKey(str);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey, "DESede");
                Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] encrypt3Des(byte[] bArr, String str) {
        if (bArr != null && str != null) {
            try {
                byte[] build3DesKey = build3DesKey(str);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(str.getBytes("UTF-8"));
                SecretKeySpec secretKeySpec = new SecretKeySpec(build3DesKey, "DESede");
                Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, ivParameterSpec);
                return cipher.doFinal(bArr);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    public static String generateName(String str) {
        boolean endsWith;
        BigInteger abs;
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            endsWith = str.substring(0, indexOf).endsWith(".gif");
        } else {
            endsWith = str.endsWith(".gif");
        }
        boolean endsWith2 = str.endsWith(".mp4");
        boolean endsWith3 = str.endsWith(".webp");
        boolean endsWith4 = str.endsWith(".apng");
        boolean endsWith5 = str.endsWith(".png");
        boolean endsWith6 = str.endsWith(".jpg");
        try {
            abs = new BigInteger(getMD5(str.getBytes())).abs();
        } catch (Exception unused) {
            abs = new BigInteger(str.getBytes()).abs();
        }
        if (endsWith) {
            return abs.toString(36) + ".gif";
        } else if (endsWith2) {
            return abs.toString(36) + ".mp4";
        } else if (endsWith3) {
            return abs.toString(36) + ".webp";
        } else if (endsWith4) {
            return abs.toString(36) + ".apng";
        } else if (endsWith5) {
            return abs.toString(36) + ".png";
        } else if (endsWith6) {
            return abs.toString(36) + ".jpg";
        } else {
            return abs.toString(36);
        }
    }

    public static String get(String str) throws IOException, GeneralSecurityException {
        int i2;
        int i3 = 0;
        String str2 = str;
        while (!TextUtils.isEmpty(str2) && i3 < 3) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                HttpURLConnection.setFollowRedirects(true);
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (AdvConfigManager.getInstance().getAdvConfig().getTSLEnable().booleanValue() && SSLManager.getInstance().verifyDomain(str).booleanValue()) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getSSLSocketFactory(str));
                    } else {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getTrustAllSocketFactory());
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestProperty("Connection", "keep-alive");
                httpURLConnection.setRequestProperty("accept-charset", "utf-8");
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "text/xml");
                us.pinguo.advconfigdata.a.a.d(httpURLConnection, str2);
                try {
                    i2 = httpURLConnection.getResponseCode();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = 0;
                }
                if (i2 != 302 && i2 != 301) {
                    if (i2 == 200) {
                        us.pinguo.advconfigdata.a.a.b(httpURLConnection);
                        return getStringData(httpURLConnection.getInputStream());
                    }
                    throw new IOException("Http connect error,status code =" + i2);
                }
                str2 = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                i3++;
            } finally {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }

    public static String getAdvDataCacheDir(Context context) {
        String str;
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            return null;
        }
        if (externalCacheDir.getAbsolutePath().endsWith("/")) {
            str = externalCacheDir.getAbsolutePath() + "advData";
        } else {
            str = externalCacheDir.getAbsolutePath() + "/advData";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getAdvImageCacheDir(Context context) {
        File file;
        String str;
        try {
            file = context.getExternalCacheDir();
        } catch (Exception e2) {
            e2.printStackTrace();
            file = null;
        }
        if (file == null) {
            return null;
        }
        if (file.getAbsolutePath().endsWith("/")) {
            str = file.getAbsolutePath() + "adv/";
        } else {
            str = file.getAbsolutePath() + "/adv/";
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return str;
    }

    public static String getCountryAndLanguage() {
        Locale locale = Locale.getDefault();
        return locale.getLanguage() + '_' + locale.getCountry();
    }

    public static String getLikeWebView(String str) throws IOException, GeneralSecurityException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            HttpURLConnection.setFollowRedirects(true);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getTrustAllSocketFactory());
            }
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("accept-charset", "utf-8");
            us.pinguo.advconfigdata.a.a.d(httpURLConnection, str);
            if (!TextUtils.isEmpty(AdvConfigManager.getInstance().getAdvConfig().getUa())) {
                httpURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, AdvConfigManager.getInstance().getAdvConfig().getUa());
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                us.pinguo.advconfigdata.a.a.b(httpURLConnection);
                return getStringData(httpURLConnection.getInputStream());
            }
            throw new IOException("Http connect error,status code =" + responseCode);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static String getLogFileInfo() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "[" + stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "] ";
    }

    private static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static int getNetworkClass(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 4;
            case 13:
                return 8;
            default:
                return 0;
        }
    }

    public static SSLSocketFactory getSSLSocketFactory(String str) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            SSLX509TrustManager sSLX509TrustManager = new SSLX509TrustManager(null);
            sSLX509TrustManager.setUrl(str);
            sSLContext.init(null, new TrustManager[]{sSLX509TrustManager}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSigByParamList(List<String> list, String str) {
        if (list != null && list.size() != 0) {
            try {
                return AdvMD5.pinguoMD5(getStringByParams(list), str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return "";
    }

    public static String getSigByParamMap(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return getSigByParamList(arrayList, str);
    }

    public static String getStringByParams(List<String> list) {
        Collections.sort(list, new a());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static String getStringData(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                int size = byteArrayOutputStream.size();
                if (size <= 524288) {
                    String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    close(bufferedInputStream2);
                    return str;
                }
                throw new IOException("Json Data too long, length =" + size);
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                close(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static SSLSocketFactory getTrustAllSocketFactory() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new EasyX509TrustManager(null)}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getUrl(String str, Map<String, String> map) throws UnsupportedEncodingException {
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
                if (entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                }
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

    public static boolean isGp(Context context) {
        if (AdvConfigManager.getInstance().getAdvConfig() == null) {
            return false;
        }
        String appChannel = AdvConfigManager.getInstance().getAdvConfig().getAppChannel();
        if (TextUtils.isEmpty(appChannel)) {
            return false;
        }
        String lowerCase = appChannel.toLowerCase();
        return "googlemarket".equals(lowerCase) || "googleplay".equals(lowerCase);
    }

    public static boolean isHttpUrl(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("http");
    }

    public static String post(String str) throws IOException, GeneralSecurityException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            HttpURLConnection.setFollowRedirects(true);
            if (httpURLConnection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(getTrustAllSocketFactory());
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("Connection", "keep-alive");
            httpURLConnection.setRequestProperty("accept-charset", "utf-8");
            httpURLConnection.setRequestProperty(HttpRequest.HEADER_CONTENT_TYPE, "text/xml");
            us.pinguo.advconfigdata.a.a.d(httpURLConnection, str);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                us.pinguo.advconfigdata.a.a.b(httpURLConnection);
                return getStringData(httpURLConnection.getInputStream());
            }
            throw new IOException("Http connect error,status code =" + responseCode);
        } finally {
            httpURLConnection.disconnect();
        }
    }
}
