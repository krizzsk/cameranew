package com.tencent.open.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.core.content.FileProvider;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.open.log.SLog;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class l {
    private static String a = "";
    private static String b = "";
    private static String c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f8214d = "";

    /* renamed from: e  reason: collision with root package name */
    private static int f8215e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static String f8216f = "0123456789ABCDEF";

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public long b;
        public long c;

        public a(String str, int i2) {
            this.a = str;
            this.b = i2;
            if (str != null) {
                this.c = str.length();
            }
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    static class b extends Thread {
        final /* synthetic */ Context a;
        final /* synthetic */ Bundle b;

        b(Context context, Bundle bundle) {
            this.a = context;
            this.b = bundle;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                HttpUtils.openUrl2(this.a, "https://cgi.qplus.com/report/report", "GET", this.b);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.Util", "reportBernoulli has exception: " + e2.getMessage());
            }
        }
    }

    private static char a(int i2) {
        int i3 = i2 & 15;
        return (char) (i3 < 10 ? i3 + 48 : (i3 - 10) + 97);
    }

    public static Bundle a(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            try {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                    }
                }
                return bundle;
            } catch (Exception unused) {
                return null;
            }
        }
        return bundle;
    }

    public static Bundle b(String str) {
        try {
            URL url = new URL(str.replace("auth://", Constants.HTTP_PROTOCOL_PREFIX));
            Bundle a2 = a(url.getQuery());
            a2.putAll(a(url.getRef()));
            return a2;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static JSONObject c(String str) {
        try {
            URL url = new URL(str.replace("auth://", Constants.HTTP_PROTOCOL_PREFIX));
            JSONObject a2 = a((JSONObject) null, url.getQuery());
            a(a2, url.getRef());
            return a2;
        } catch (MalformedURLException unused) {
            return new JSONObject();
        }
    }

    public static JSONObject d(String str) throws JSONException {
        if (str.equals("false")) {
            str = "{value : false}";
        }
        if (str.equals("true")) {
            str = "{value : true}";
        }
        if (str.contains("allback(")) {
            str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
        }
        if (str.contains("online[0]=")) {
            str = "{online:" + str.charAt(str.length() - 2) + "}";
        }
        return new JSONObject(str);
    }

    public static boolean e(String str) {
        return str == null || str.length() == 0;
    }

    public static String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(com.adjust.sdk.Constants.MD5);
            messageDigest.update(i(str));
            byte[] digest = messageDigest.digest();
            if (digest != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    sb.append(a(b2 >>> 4));
                    sb.append(a(b2));
                }
                return sb.toString();
            }
            return str;
        } catch (NoSuchAlgorithmException e2) {
            SLog.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
            return str;
        }
    }

    private static boolean g(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
            String str = packageInfo.versionName;
            if (i.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(com.adjust.sdk.Constants.MD5);
                    messageDigest.update(signatureArr[0].toByteArray());
                    String a2 = a(messageDigest.digest());
                    messageDigest.reset();
                    if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                        return true;
                    }
                } catch (NoSuchAlgorithmException e2) {
                    SLog.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean h(String str) {
        return str != null && new File(str).exists();
    }

    public static byte[] i(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static long j(String str) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long available = fileInputStream2.available();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return available;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return 0L;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            return 0L;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String k(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(a(str.getBytes(), "JCPTZXEZ"), 3);
    }

    public static String l(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e2) {
                SLog.e("openSDK_LOG.Util", "convert2Base64String exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static File m(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                } else {
                    SLog.d("openSDK_LOG.Util", "createFile failed" + str);
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public static boolean n(String str) {
        String b2 = b();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(b2) || !str.contains(b2)) ? false : true;
    }

    public static String e(Context context, String str) {
        if (context == null) {
            return "";
        }
        String d2 = d(context, str);
        c = d2;
        return d2;
    }

    public static boolean e(Context context) {
        return i.c(context, "8.1.8") >= 0;
    }

    public static File h(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            File[] externalFilesDirs = context.getExternalFilesDirs(str);
            if (externalFilesDirs == null || externalFilesDirs.length <= 0) {
                return null;
            }
            return externalFilesDirs[0];
        }
        return context.getExternalFilesDir(str);
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return true;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.isConnectedOrConnecting()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return b;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    try {
                        split[0] = URLDecoder.decode(split[0]);
                        split[1] = URLDecoder.decode(split[1]);
                    } catch (Exception unused) {
                    }
                    try {
                        jSONObject.put(split[0], split[1]);
                    } catch (JSONException e2) {
                        SLog.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                    }
                }
            }
        }
        return jSONObject;
    }

    public static boolean c(Context context) {
        double d2;
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
        } catch (Throwable unused) {
            d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        return d2 > 6.5d;
    }

    public static String d(Context context, String str) {
        if (context == null) {
            return "";
        }
        b(context, str);
        return a;
    }

    public static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            b = str2;
            a = str2.substring(0, str2.lastIndexOf(46));
            String str3 = b;
            f8214d = str3.substring(str3.lastIndexOf(46) + 1, b.length());
            f8215e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            SLog.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static boolean f(Context context, String str) {
        boolean z = !c(context) || i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null) {
            z = false;
        }
        if (z && i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return i.c(context, str) < 0;
        }
        return z;
    }

    public static boolean d(Context context) {
        return i.c(context, "8.1.5") >= 0;
    }

    public static final boolean g(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX);
    }

    public static boolean g(Context context, String str) {
        boolean z = !c(context) || i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) == null;
        if (z && i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null) {
            z = false;
        }
        if (z) {
            return i.c(context, str) < 0;
        }
        return z;
    }

    public static boolean c() {
        Context a2 = f.a();
        return a2 != null && a2.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", a2.getPackageName()) == 0;
    }

    public static boolean f(Context context) {
        return i.c(context, "5.9.5") >= 0 || i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    public static boolean a(Context context, String str) {
        boolean z;
        try {
            z = g(context);
        } catch (Exception unused) {
            z = false;
        }
        try {
            if (z) {
                a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
            } else {
                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
            }
            return true;
        } catch (Exception unused2) {
            if (z) {
                try {
                    try {
                        try {
                            a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        } catch (Exception unused3) {
                            return false;
                        }
                    } catch (Exception unused4) {
                        a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                        return true;
                    }
                } catch (Exception unused5) {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                }
            }
            try {
                try {
                    a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                    return true;
                } catch (Exception unused6) {
                    return false;
                }
            } catch (Exception unused7) {
                a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                return true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r12, android.net.Uri r13) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.l.b(android.content.Context, android.net.Uri):java.lang.String");
    }

    private static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(1073741824);
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.setData(Uri.parse(str3));
        context.startActivity(intent);
    }

    public static void a(Context context, String str, long j2, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("appid_for_getting_config", str2);
        bundle.putString("strValue", str2);
        bundle.putString("nValue", str);
        bundle.putString("qver", com.tencent.connect.common.Constants.SDK_VERSION);
        if (j2 != 0) {
            bundle.putLong("elt", j2);
        }
        new b(context, bundle).start();
    }

    public static boolean a() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            String num = Integer.toString(b2 & Draft_75.END_OF_FRAME, 16);
            if (num.length() == 1) {
                num = "0" + num;
            }
            sb.append(num);
        }
        return sb.toString();
    }

    public static final String a(Context context) {
        CharSequence applicationLabel;
        if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
            return null;
        }
        return applicationLabel.toString();
    }

    public static final String a(String str, int i2, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        try {
            if (str.getBytes(str2).length <= i2) {
                return str;
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < str.length()) {
                int i5 = i3 + 1;
                i4 += str.substring(i3, i5).getBytes(str2).length;
                if (i4 > i2) {
                    String substring = str.substring(0, i3);
                    if (TextUtils.isEmpty(str3)) {
                        return substring;
                    }
                    return substring + str3;
                }
                i3 = i5;
            }
            return str;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
            return str;
        }
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        return a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "");
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Bundle bundle = new Bundle();
        bundle.putString("openid", str);
        bundle.putString("report_type", str2);
        bundle.putString("act_type", str3);
        bundle.putString("via", str4);
        bundle.putString(TapjoyConstants.TJC_APP_ID, str5);
        bundle.putString("result", str6);
        bundle.putString("type", str7);
        bundle.putString("login_status", str8);
        bundle.putString("need_user_auth", str9);
        bundle.putString("to_uin", str10);
        bundle.putString("call_source", str11);
        bundle.putString("to_type", str12);
        bundle.putString("platform", "1");
        return bundle;
    }

    public static String b() {
        File e2 = f.e();
        if (e2 != null) {
            if (!e2.exists()) {
                e2.mkdirs();
            }
            return e2.toString();
        }
        return null;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "1");
        bundle.putString("result", str);
        bundle.putString("code", str2);
        bundle.putString("tmcost", str3);
        bundle.putString("rate", str4);
        bundle.putString("cmd", str5);
        bundle.putString("uin", str6);
        bundle.putString("appid", str7);
        bundle.putString("share_type", str8);
        bundle.putString(SharePluginInfo.ISSUE_STACK_TYPE, str9);
        bundle.putString("os_ver", Build.VERSION.RELEASE);
        bundle.putString("network", com.tencent.open.a.a.a(f.a()));
        bundle.putString("apn", com.tencent.open.a.a.b(f.a()));
        bundle.putString("model_name", Build.MODEL);
        bundle.putString("sdk_ver", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("packagename", f.b());
        bundle.putString("app_ver", d(f.a(), f.b()));
        return bundle;
    }

    public static boolean a(Context context, boolean z) {
        return (c(context) && i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) || i.c(context, "4.1") >= 0 || i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) != null || i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
    }

    @SuppressLint({"NewApi"})
    public static String a(Context context, Uri uri) {
        Uri uri2;
        if (uri == null) {
            return null;
        }
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            String authority = uri.getAuthority();
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                String str = split[0];
                if ("primary".equals(str)) {
                    return Environment.getExternalStorageDirectory().getAbsolutePath().concat("/").concat(split[1]);
                }
                return "/storage/".concat(str).concat("/").concat(split[1]);
            } else if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId.startsWith("raw:")) {
                    return documentId.replaceFirst("raw:", "");
                }
                return b(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)));
            } else {
                if ("com.android.providers.media.documents".equals(authority)) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = split2[0];
                    if (QiniuAuthToken.TYPE_IMAGE.equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return b(context, ContentUris.withAppendedId(uri2, Long.parseLong(split2[1])));
                }
                return null;
            }
        }
        String scheme = uri.getScheme();
        if (FirebaseAnalytics.Param.CONTENT.equals(scheme)) {
            return b(context, uri);
        }
        if ("file".equals(scheme)) {
            return uri.getPath();
        }
        return null;
    }

    private static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                char[] charArray = str.toCharArray();
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    bArr2[i2] = (byte) (bArr[i2] ^ charArray[i2 % charArray.length]);
                }
                return bArr2;
            } catch (Throwable th) {
                SLog.e("Util", "xor Exception! ", th);
            }
        }
        return bArr;
    }

    public static Drawable a(String str, Context context) {
        InputStream inputStream;
        StringBuilder sb;
        InputStream inputStream2 = null;
        r1 = null;
        Drawable drawable = null;
        if (context == null) {
            SLog.e("openSDK_LOG.Util", "context null!");
            return null;
        }
        try {
            inputStream = context.getAssets().open(str);
            try {
                try {
                    drawable = Drawable.createFromStream(inputStream, str);
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                        e = e2;
                        sb = new StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        SLog.e("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                } catch (IOException e3) {
                    e = e3;
                    SLog.e("openSDK_LOG.Util", "getDrawable exception: " + e.getMessage());
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        sb = new StringBuilder();
                        sb.append("inputStream close exception: ");
                        sb.append(e.getMessage());
                        SLog.e("openSDK_LOG.Util", sb.toString());
                        return drawable;
                    }
                    return drawable;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                try {
                    inputStream2.close();
                } catch (Exception e5) {
                    SLog.e("openSDK_LOG.Util", "inputStream close exception: " + e5.getMessage());
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2.close();
            throw th;
        }
        return drawable;
    }

    public static boolean a(String str, String str2) {
        File file = new File(str);
        if (file.exists()) {
            try {
                return a(file, m(str2));
            } catch (IOException e2) {
                SLog.d("openSDK_LOG.Util", "copy fail from " + str + " to " + str2 + " ", e2);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0056 -> B:81:0x0098). Please submit an issue!!! */
    public static boolean a(File file, File file2) {
        FileOutputStream fileOutputStream;
        int read;
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        fileOutputStream2 = null;
        try {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                        file2.getParentFile().mkdirs();
                    }
                    fileOutputStream = new FileOutputStream((File) file2);
                    try {
                        file2 = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e2) {
                        e = e2;
                        file2 = 0;
                    } catch (OutOfMemoryError e3) {
                        e = e3;
                        file2 = 0;
                    } catch (Throwable th) {
                        th = th;
                        file2 = 0;
                    }
                } catch (IOException e4) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e4);
                    fileOutputStream2 = fileOutputStream2;
                    file2 = file2;
                }
            } catch (IOException e5) {
                e = e5;
                file2 = 0;
            } catch (OutOfMemoryError e6) {
                e = e6;
                file2 = 0;
            } catch (Throwable th2) {
                th = th2;
                file2 = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            byte[] bArr = new byte[102400];
            while (true) {
                read = file2.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                fileOutputStream.flush();
            }
            z = true;
            try {
                fileOutputStream.close();
            } catch (IOException e7) {
                SLog.e("openSDK_LOG.Util", "copyFile error, ", e7);
            }
            file2.close();
            fileOutputStream2 = read;
            file2 = file2;
        } catch (IOException e8) {
            e = e8;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e9) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e9);
                }
            }
            if (file2 != 0) {
                file2.close();
                fileOutputStream2 = fileOutputStream2;
                file2 = file2;
            }
            return z;
        } catch (OutOfMemoryError e10) {
            e = e10;
            fileOutputStream2 = fileOutputStream;
            file2 = file2;
            SLog.e("openSDK_LOG.Util", "copyFile error, ", e);
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e11) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e11);
                }
            }
            if (file2 != 0) {
                file2.close();
                fileOutputStream2 = fileOutputStream2;
                file2 = file2;
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e12) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e12);
                }
            }
            if (file2 != 0) {
                try {
                    file2.close();
                } catch (IOException e13) {
                    SLog.e("openSDK_LOG.Util", "copyFile error, ", e13);
                }
            }
            throw th;
        }
        return z;
    }

    public static boolean a(Context context, String str, String str2) {
        boolean a2;
        if (Build.VERSION.SDK_INT < 19) {
            a2 = context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()) == 0 ? a(str, str2) : false;
        } else {
            a2 = a(str, str2);
        }
        SLog.i("openSDK_LOG.Util", "copyFileByCheckPermission() copy success:" + a2);
        return a2;
    }

    public static String a(String str, Activity activity, String str2, IUiListener iUiListener) {
        File a2;
        File cacheDir;
        String str3;
        try {
            boolean n = n(str2);
            SLog.i("openSDK_LOG.Util", "doPublishMood() check file: isAppSpecificDir=" + n + ",hasSDPermission=" + c());
            if (!n) {
                if (f.a("Images") != null) {
                    str3 = a2.getAbsolutePath() + File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                } else {
                    if (f.a().getCacheDir() == null) {
                        SLog.e("openSDK_LOG.Util", "getMediaFileUri error, cacheDir is null");
                        return null;
                    }
                    str3 = cacheDir.getAbsolutePath() + File.separator + com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR;
                }
                File file = new File(str2);
                String absolutePath = file.getAbsolutePath();
                String str4 = str3 + File.separator + file.getName();
                str2 = a(absolutePath, str4) ? str4 : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                File file2 = new File(str2);
                String authorities = Tencent.getAuthorities(str);
                if (TextUtils.isEmpty(authorities)) {
                    SLog.e("openSDK_LOG.Util", "getMediaFileUri error, authorities is null");
                    if (iUiListener != null) {
                        iUiListener.onWarning(-19);
                    }
                    return null;
                }
                Uri uriForFile = FileProvider.getUriForFile(activity, authorities, file2);
                activity.grantUriPermission("com.tencent.mobileqq", uriForFile, 3);
                return uriForFile.toString();
            }
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error, destAppSpecific is null");
            return null;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.Util", "getMediaFileUri error", e2);
            return null;
        }
    }

    public static boolean a(Map<String, Object> map, String str, boolean z) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, params==null");
            return z;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getBoolean error, not comtain : " + str);
            return z;
        } else {
            Object obj = map.get(str);
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }
    }

    public static String a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            SLog.e("openSDK_LOG.Util", "getString error, params==null");
            return str2;
        } else if (!map.containsKey(str)) {
            SLog.e("openSDK_LOG.Util", "getString error, not comtain : " + str);
            return str2;
        } else {
            Object obj = map.get(str);
            return obj instanceof String ? (String) obj : str2;
        }
    }
}
