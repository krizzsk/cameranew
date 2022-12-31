package cn.sharesdk.sina.weibo;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import cn.sharesdk.framework.utils.SSDKLog;
import com.adjust.sdk.Constants;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.utils.Hashon;
import java.security.MessageDigest;
import java.util.HashMap;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: SinaLinkCard.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a a;
    private MobCommunicator b;
    private String c = MobSDK.getAppkey();

    /* renamed from: d  reason: collision with root package name */
    private String f224d;

    /* renamed from: e  reason: collision with root package name */
    private String f225e;

    public a() {
        String packageName = MobSDK.getContext().getPackageName();
        this.f224d = packageName;
        this.f225e = a(packageName);
    }

    public static a a() {
        synchronized (a.class) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
        }
        return a;
    }

    private synchronized MobCommunicator b() {
        if (this.b == null) {
            this.b = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        }
        return this.b;
    }

    private static Signature[] b(String str) {
        if (str != null && str.length() != 0) {
            try {
                PackageInfo packageInfo = MobSDK.getContext().getPackageManager().getPackageInfo(str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException e2) {
                SSDKLog.b().d(e2);
            }
        }
        return null;
    }

    public HashMap<String, Object> a(String str, JSONObject jSONObject, String str2, String str3, String str4, String str5) throws Throwable {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("appkey", this.c);
        hashMap.put("plat", 1);
        hashMap.put("androidPk", this.f224d);
        hashMap.put("androidPkSign", this.f225e);
        hashMap.put("summary", str);
        hashMap.put(QiniuAuthToken.TYPE_IMAGE, jSONObject);
        hashMap.put("object_type", str2);
        hashMap.put("display_name", str3);
        hashMap.put("create_at", str4);
        hashMap.put("url", str5);
        try {
            return (HashMap) b().requestSynchronized(hashMap, "http://lks.share.mob.com/share/genShareInfo", false);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message != null && message.endsWith("}")) {
                HashMap fromJson = new Hashon().fromJson(message);
                if (fromJson.containsKey("error")) {
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put("error", String.valueOf(fromJson.get("error")));
                    return hashMap2;
                }
            }
            return null;
        }
    }

    public static String a(String str) {
        Signature[] b = b(str);
        if (b == null || b.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Signature signature : b) {
            stringBuffer.append(a(signature.toByteArray()));
        }
        return stringBuffer.toString();
    }

    public static final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b : digest) {
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i3 = i2 + 1;
                cArr2[i3] = cArr[b & 15];
                i2 = i3 + 1;
            }
            return new String(cArr2);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
            return null;
        }
    }
}
