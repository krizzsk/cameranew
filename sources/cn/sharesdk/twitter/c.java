package cn.sharesdk.twitter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: TwitterHelper.java */
/* loaded from: classes.dex */
public class c extends e {
    private static c b;
    private cn.sharesdk.framework.utils.c c;

    /* renamed from: d  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f292d;

    /* renamed from: e  reason: collision with root package name */
    private MappedFileReader f293e;

    /* renamed from: f  reason: collision with root package name */
    private int f294f;

    /* renamed from: g  reason: collision with root package name */
    private String f295g;

    /* renamed from: h  reason: collision with root package name */
    private String f296h;

    private c(Platform platform) {
        super(platform);
        this.f294f = 0;
        this.c = new cn.sharesdk.framework.utils.c();
        this.f292d = cn.sharesdk.framework.a.b.a();
    }

    public void b(String str) {
        this.f296h = str;
    }

    public String c(String str) {
        try {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("oauth_verifier", str));
            return this.f292d.a("https://api.twitter.com/oauth/access_token", arrayList, (KVPair<String>) null, this.c.a(this.c.a("https://api.twitter.com/oauth/access_token", arrayList)), "/oauth/access_token", c());
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        long j2;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        try {
            j2 = ResHelper.parseLong(str);
        } catch (Throwable unused) {
            j2 = 0;
            str = null;
        }
        arrayList.add(new KVPair<>(AccessToken.USER_ID_KEY, str == null ? this.a.getDb().getUserId() : String.valueOf(j2)));
        String a = this.f292d.a("https://api.twitter.com/1.1/users/show.json", arrayList, this.c.a(this.c.b("https://api.twitter.com/1.1/users/show.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/users/show.json", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        return d(str, null);
    }

    public HashMap<String, Object> f(String str, String str2) throws Throwable {
        long fileSize = ResHelper.getFileSize(str2);
        this.f294f = 0;
        HashMap<String, Object> a = a(str, str2, fileSize);
        if (a != null) {
            String str3 = (String) a.get("media_id_string");
            if (TextUtils.isEmpty(str3) || b(str2, str3, fileSize) == null) {
                return null;
            }
            return a(str3, fileSize, str);
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        String a;
        try {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("oauth_callback", getRedirectUri()));
            a((String) null, (String) null);
            a = this.f292d.a("https://api.twitter.com/oauth/request_token", arrayList, (KVPair<String>) null, this.c.a(this.c.a("https://api.twitter.com/oauth/request_token", arrayList)), "/oauth/request_token", c());
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        if (a == null) {
            return null;
        }
        String[] split = a.split("&");
        HashMap hashMap = new HashMap();
        for (String str : split) {
            if (str != null) {
                String[] split2 = str.split("=");
                if (split2.length >= 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        if (hashMap.containsKey("oauth_token")) {
            String str2 = (String) hashMap.get("oauth_token");
            a(str2, (String) hashMap.get("oauth_token_secret"));
            ShareSDK.logApiEvent("/oauth/authorize", c());
            return "https://api.twitter.com/oauth/authorize?oauth_token=" + str2;
        }
        return null;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g gVar) {
        return new b(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return this.c.a().f216e;
    }

    @Override // cn.sharesdk.framework.e, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        d dVar2 = new d(dVar);
        dVar2.a(this.f295g);
        dVar2.b(this.f296h);
        return dVar2;
    }

    public HashMap<String, Object> b(String str, String str2) throws Throwable {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(AccessToken.USER_ID_KEY, str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String a = this.f292d.a("https://api.twitter.com/1.1/friends/list.json", arrayList, this.c.a(this.c.b("https://api.twitter.com/1.1/friends/list.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/friends/list.json", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public HashMap<String, Object> e(String str, String str2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> a = this.c.a(this.c.a("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList));
        a.remove(1);
        arrayList.add(new KVPair<>("status", str));
        String a2 = this.f292d.a("https://api.twitter.com/1.1/statuses/update_with_media.json", arrayList, new KVPair<>("media[]", str2), a, "/1.1/statuses/update_with_media.json", c());
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a2);
    }

    public static c a(Platform platform) {
        if (b == null) {
            b = new c(platform);
        }
        return b;
    }

    private HashMap<String, Object> f(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(TJAdUnitConstants.String.COMMAND, "FINALIZE"));
        arrayList.add(new KVPair<>("media_id", str));
        ArrayList<KVPair<String>> a = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        a.remove(1);
        String a2 = this.f292d.a("https://upload.twitter.com/1.1/media/upload.json", arrayList, (KVPair<String>) null, a, "/1.1/media/upload.json", c());
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a2);
    }

    public void a(String str) {
        this.f295g = str;
    }

    public void a(String str, String str2, String str3) {
        this.c.a(str, str2, str3);
        a(str);
        b(str2);
    }

    public HashMap<String, Object> c(String str, String str2) throws Throwable {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("nextCursor", str2));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>(AccessToken.USER_ID_KEY, str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String a = this.f292d.a("https://api.twitter.com/1.1/followers/list.json", arrayList, this.c.a(this.c.b("https://api.twitter.com/1.1/followers/list.json", arrayList)), (NetworkHelper.NetworkTimeOut) null, "/1.1/followers/list.json", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    private String b(String str, final String str2, final long j2) throws Throwable {
        MappedFileReader mappedFileReader = new MappedFileReader(str, 524288);
        this.f293e = mappedFileReader;
        byte[] a = a(mappedFileReader);
        if (a == null) {
            return null;
        }
        a(MappedFileReader.byteToBase64(a), true, new UpLoadViewCallBack() { // from class: cn.sharesdk.twitter.c.2
            @Override // cn.sharesdk.twitter.UpLoadViewCallBack
            public void onResule(String str3) throws Throwable {
                c cVar = c.this;
                byte[] a2 = cVar.a(cVar.f293e);
                if (a2 == null) {
                    if (c.this.f293e != null) {
                        c.this.f293e.close();
                        return;
                    }
                    return;
                }
                c.this.a(MappedFileReader.byteToBase64(a2), true, this, str2, j2);
            }
        }, str2, j2);
        return "Done";
    }

    public void a(String str, String str2) {
        this.c.a(str, str2);
    }

    public HashMap<String, Object> d(String str, String str2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("status", str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new KVPair<>("media_ids", str2));
        }
        String a = this.f292d.a("https://api.twitter.com/1.1/statuses/update.json", arrayList, (KVPair<String>) null, this.c.a(this.c.a("https://api.twitter.com/1.1/statuses/update.json", arrayList)), "/1.1/statuses/update.json", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public void a(final AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            b(authorizeListener);
        } else {
            a(new SSOListener() { // from class: cn.sharesdk.twitter.c.1
                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onCancel() {
                    try {
                        authorizeListener.onCancel();
                    } catch (Exception e2) {
                        SSDKLog.b().d(e2);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onComplete(Bundle bundle) {
                    try {
                        authorizeListener.onComplete(bundle);
                    } catch (Throwable th) {
                        onFailed(th);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.SSOListener
                public void onFailed(Throwable th) {
                    c.this.b(authorizeListener);
                }
            });
        }
    }

    public HashMap<String, Object> a(String str, String[] strArr) throws Throwable {
        String str2;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> a = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        a.remove(1);
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < strArr.length && arrayList2.size() <= 3; i2++) {
            try {
                str2 = strArr[i2];
            } catch (Exception unused) {
                SSDKLog.b().d(sb.toString(), new Object[0]);
            }
            if (str2.startsWith("http")) {
                str2 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str2);
            } else {
                if (!TextUtils.isEmpty(str2)) {
                    if (!new File(str2).exists()) {
                    }
                }
            }
            String a2 = this.f292d.a("https://upload.twitter.com/1.1/media/upload.json", arrayList, new KVPair<>("media", str2), a, "/1.1/media/upload.json", c());
            sb.append(strArr[i2]);
            sb.append(": ");
            sb.append(a2);
            sb.append("\n");
            if (a2 != null && a2.length() > 0) {
                arrayList2.add(new Hashon().fromJson(a2));
            }
        }
        sb.setLength(0);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (((HashMap) arrayList2.get(i3)).containsKey(QiniuAuthToken.TYPE_IMAGE)) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(String.valueOf(((HashMap) arrayList2.get(i3)).get("media_id")));
            }
        }
        return d(str, sb.toString());
    }

    private HashMap<String, Object> a(String str, long j2, String str2) throws Throwable {
        HashMap<String, Object> f2 = f(str);
        if (f2 == null || !((String) f2.get("media_id_string")).equals(str)) {
            return null;
        }
        return d(str2, str);
    }

    private HashMap<String, Object> a(String str, String str2, long j2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(TJAdUnitConstants.String.COMMAND, "INIT"));
        arrayList.add(new KVPair<>("media_type", "video/mp4"));
        arrayList.add(new KVPair<>("total_bytes", String.valueOf(j2)));
        ArrayList<KVPair<String>> a = this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList));
        a.remove(1);
        String a2 = this.f292d.a("https://upload.twitter.com/1.1/media/upload.json", arrayList, (KVPair<String>) null, a, "/1.1/media/upload.json", c());
        if (a2 == null || a2.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, UpLoadViewCallBack upLoadViewCallBack, String str2, long j2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>(TJAdUnitConstants.String.COMMAND, "APPEND"));
        arrayList.add(new KVPair<>("media_id", str2));
        if (z) {
            arrayList.add(new KVPair<>("media_data", str));
        } else {
            arrayList.add(new KVPair<>("media", str));
        }
        arrayList.add(new KVPair<>(IjkMediaPlayer.OnNativeInvokeListener.ARG_SEGMENT_INDEX, this.f294f + ""));
        this.f294f = this.f294f + 1;
        String a = this.f292d.a("https://upload.twitter.com/1.1/media/upload.json", arrayList, (KVPair<String>) null, this.c.a(this.c.a("https://upload.twitter.com/1.1/media/upload.json", arrayList)), "/1.1/media/upload.json", c());
        if (upLoadViewCallBack != null) {
            upLoadViewCallBack.onResule(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(MappedFileReader mappedFileReader) throws IOException {
        if (mappedFileReader == null || mappedFileReader.read() == -1) {
            return null;
        }
        return mappedFileReader.getArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) throws Throwable {
        KVPair kVPair;
        String str3;
        ArrayList<KVPair<String>> a;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair kVPair2 = null;
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                kVPair2 = new KVPair(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        if ("GET".equals(str2.toUpperCase())) {
            str3 = this.f292d.httpGet(str, arrayList, this.c.a(this.c.b(str, arrayList)), null);
        } else if ("POST".equals(str2.toUpperCase())) {
            if (hashMap2 != null && hashMap2.size() > 0) {
                a = this.c.a(this.c.a(str, new ArrayList<>()));
                a.remove(1);
            } else {
                a = this.c.a(this.c.a(str, arrayList));
            }
            str3 = this.f292d.httpPost(str, arrayList, kVPair, a, (NetworkHelper.NetworkTimeOut) null);
        } else {
            str3 = null;
        }
        if (str3 == null || str3.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(str3);
    }

    public void a(String str, String[] strArr, PlatformActionListener platformActionListener) {
        try {
            List<String> asList = Arrays.asList(strArr);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (String str2 : asList) {
                if (str2.startsWith("http") || str2.startsWith("https")) {
                    str2 = BitmapHelper.downloadBitmap(MobSDK.getContext(), str2);
                }
                File file = new File(str2);
                if (file.exists()) {
                    String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "images");
                    File file2 = new File(cachePath, System.currentTimeMillis() + file.getName());
                    String absolutePath = file2.getAbsolutePath();
                    file2.createNewFile();
                    if (ResHelper.copyFile(str2, absolutePath)) {
                        file = file2;
                    }
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 29) {
                        Context context = MobSDK.getContext();
                        Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                        MobSDK.getContext().grantUriPermission("com.twitter.android", a, 3);
                        arrayList.add(a);
                    } else if (i2 >= 24) {
                        arrayList.add(ResHelper.pathToContentUri(MobSDK.getContext(), file.getAbsolutePath()));
                    } else {
                        arrayList.add(Uri.fromFile(file));
                    }
                }
            }
            Intent intent = new Intent();
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (arrayList.size() <= 0) {
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
            } else {
                String str3 = "image/*";
                if (arrayList.size() == 1 && arrayList.get(0) != null) {
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", arrayList.get(0));
                    String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(((Uri) arrayList.get(0)).toString());
                    if (contentTypeFor != null && contentTypeFor.length() > 0) {
                        str3 = contentTypeFor;
                    }
                    intent.setType(str3);
                } else {
                    intent.setAction("android.intent.action.SEND_MULTIPLE");
                    intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                    intent.setType("image/*");
                }
            }
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("text", str);
            hashMap.put("imageArray", strArr);
            platformActionListener.onComplete(this.a, 9, hashMap);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                NLog b2 = SSDKLog.b();
                b2.w("Twitter system share multiple image catch: " + th);
                platformActionListener.onError(getPlatform(), 9, th);
            }
        }
    }

    public void a(String str, String str2, String str3, PlatformActionListener platformActionListener) {
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = !TextUtils.isEmpty(str3) ? BitmapHelper.downloadBitmap(MobSDK.getContext(), str3) : null;
            }
            NLog b2 = SSDKLog.b();
            b2.w("shareImage bypassApproval and resultPath is: " + str2);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("android.intent.extra.TEXT", str);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        File file = new File(str2);
                        Context context = MobSDK.getContext();
                        Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file);
                        MobSDK.getContext().grantUriPermission("com.twitter.android", a, 3);
                        intent.putExtra("android.intent.extra.STREAM", a);
                    } catch (Exception e2) {
                        NLog b3 = SSDKLog.b();
                        b3.d(OnekeyShare.SHARESDK_TAG, "doShareToQQ() getUriForFile exception:" + e2);
                    }
                }
            } else {
                Uri pathToContentUri = ResHelper.pathToContentUri(MobSDK.getContext(), str2);
                NLog b4 = SSDKLog.b();
                b4.w("pathToContentUri uri: " + pathToContentUri);
                intent.putExtra("android.intent.extra.STREAM", pathToContentUri);
            }
            intent.setType("image/*");
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("text", str);
            hashMap.put("imagePath", str2);
            platformActionListener.onComplete(this.a, 9, hashMap);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                NLog b5 = SSDKLog.b();
                b5.w("Twitter system share image catch: " + th);
                platformActionListener.onError(getPlatform(), 9, th);
            }
        }
    }

    public void a(String str, PlatformActionListener platformActionListener) {
        try {
            if (TextUtils.isEmpty(str) && platformActionListener != null) {
                platformActionListener.onError(getPlatform(), 9, new Throwable("share text but text is null"));
                return;
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setPackage("com.twitter.android");
            intent.setClassName("com.twitter.android", "com.twitter.composer.ComposerActivity");
            intent.putExtra("android.intent.extra.TEXT", str);
            intent.setType("text/plain");
            MobSDK.getContext().startActivity(intent);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("text", str);
            platformActionListener.onComplete(this.a, 9, hashMap);
        } catch (Throwable th) {
            if (platformActionListener != null) {
                NLog b2 = SSDKLog.b();
                b2.w("Twitter system share text catch: " + th);
                platformActionListener.onError(getPlatform(), 9, th);
            }
        }
    }
}
