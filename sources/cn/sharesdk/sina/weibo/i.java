package cn.sharesdk.sina.weibo;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.models.PageEvent;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: Weibo.java */
/* loaded from: classes.dex */
public class i extends cn.sharesdk.framework.e {
    private static i b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f244d;

    /* renamed from: e  reason: collision with root package name */
    private String f245e;

    /* renamed from: f  reason: collision with root package name */
    private String f246f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f247g;

    /* renamed from: h  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f248h;

    private i(Platform platform) {
        super(platform);
        this.f247g = new String[]{"follow_app_official_microblog"};
        this.f248h = cn.sharesdk.framework.a.b.a();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        return "";
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g gVar) {
        return new c(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return TextUtils.isEmpty(this.f245e) ? "https://api.weibo.com/oauth2/default.html" : this.f245e;
    }

    @Override // cn.sharesdk.framework.e, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        e eVar = new e(dVar);
        eVar.a(32973);
        eVar.a(this.c, this.f245e, this.f247g);
        return eVar;
    }

    public String b(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("client_id", this.c));
        arrayList.add(new KVPair<>("client_secret", this.f244d));
        arrayList.add(new KVPair<>(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f245e));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        arrayList.add(new KVPair<>("code", str));
        String b2 = this.f248h.b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", c());
        ShareSDK.logApiEvent("/oauth2/access_token", c());
        return b2;
    }

    public void c(String str) {
        this.f246f = str;
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        String str2 = this.f246f;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String a = this.f248h.a("https://api.weibo.com/2/users/show.json", arrayList, "/2/users/show.json", c());
        if (a != null) {
            return new Hashon().fromJson(a);
        }
        return null;
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        arrayList.add(new KVPair<>("access_token", this.f246f));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        String b2 = this.f248h.b("https://api.weibo.com/2/friendships/create.json", arrayList, "/2/friendships/create.json", c());
        if (b2 != null) {
            return new Hashon().fromJson(b2);
        }
        return null;
    }

    public static synchronized i a(Platform platform) {
        i iVar;
        synchronized (i.class) {
            if (b == null) {
                b = new i(platform);
            }
            iVar = b;
        }
        return iVar;
    }

    public HashMap<String, Object> c(int i2, int i3, String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        String str2 = this.f246f;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i2)));
        arrayList.add(new KVPair<>(PageEvent.TYPE_NAME, String.valueOf(i3)));
        String a = this.f248h.a("https://api.weibo.com/2/friendships/friends/bilateral.json", arrayList, "/2/friendships/friends/bilateral.json", c());
        if (a != null) {
            return new Hashon().fromJson(a);
        }
        return null;
    }

    public void a(String str, String str2) {
        this.c = str;
        this.f244d = str2;
    }

    public void a(String str) {
        this.f245e = str;
    }

    public void a(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.f247g = strArr;
    }

    public boolean b() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage("com.sina.weibo");
        intent.setType("image/*");
        ResolveInfo resolveActivity = MobSDK.getContext().getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setPackage("com.sina.weibog3");
            intent2.setType("image/*");
            resolveActivity = MobSDK.getContext().getPackageManager().resolveActivity(intent2, 0);
        }
        return resolveActivity != null;
    }

    private String a(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return a(objArr, str, 0, objArr.length);
    }

    public HashMap<String, Object> d(int i2, int i3, String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        String str2 = this.f246f;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i2)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i3)));
        String a = this.f248h.a("https://api.weibo.com/2/friendships/followers.json", arrayList, "/2/friendships/followers.json", c());
        if (a != null) {
            return new Hashon().fromJson(a);
        }
        return null;
    }

    private String a(Object[] objArr, String str, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        if (objArr[i2] != null) {
            sb.append(objArr[i2]);
        }
        while (true) {
            i2++;
            if (i2 < i3) {
                sb.append(str);
                if (objArr[i2] != null) {
                    sb.append(objArr[i2]);
                }
            } else {
                return sb.toString();
            }
        }
    }

    public void b(final Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) {
        String str;
        if (TextUtils.isEmpty(shareParams.getUrl())) {
            str = shareParams.getText();
        } else {
            str = shareParams.getText() + " " + shareParams.getUrl();
        }
        if (!TextUtils.isEmpty(str)) {
            shareParams.setText(this.a.getShortLintk(str, false));
        } else {
            int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_weibo_upload_content");
            if (stringRes > 0) {
                shareParams.setText(MobSDK.getContext().getResources().getString(stringRes));
            }
        }
        AuthorizeListener authorizeListener = new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.i.2
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                PlatformActionListener platformActionListener2 = platformActionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onCancel(((cn.sharesdk.framework.e) i.this).a, 9);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                if (platformActionListener != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("ShareParams", shareParams);
                    platformActionListener.onComplete(((cn.sharesdk.framework.e) i.this).a, 9, hashMap);
                }
                if (bundle != null) {
                    String string = bundle.getString("uid");
                    String string2 = bundle.getString("access_token");
                    String string3 = bundle.getString("expire_in");
                    if (!TextUtils.isEmpty(string2)) {
                        i.this.f246f = string2;
                        ((cn.sharesdk.framework.e) i.this).a.getDb().putToken(i.this.f246f);
                    }
                    ((cn.sharesdk.framework.e) i.this).a.getDb().putUserId(string);
                    try {
                        ((cn.sharesdk.framework.e) i.this).a.getDb().putExpiresIn(ResHelper.parseLong(string3));
                    } catch (Throwable unused) {
                    }
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                PlatformActionListener platformActionListener2 = platformActionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(((cn.sharesdk.framework.e) i.this).a, 9, th);
                }
            }
        };
        h hVar = new h();
        hVar.a(this.c, this.f246f);
        hVar.a(shareParams);
        hVar.a(authorizeListener);
        hVar.show(MobSDK.getContext(), null);
    }

    public void a(AuthorizeListener authorizeListener, boolean z) {
        if (z) {
            a(authorizeListener);
            return;
        }
        new d(this.c, this.f245e, a(this.f247g, ","), authorizeListener).show(MobSDK.getContext(), null);
        SSDKLog.b().w("SinaWeibo SDK Client doAuthorize ");
    }

    public boolean d() {
        Intent intent = new Intent();
        intent.setAction("com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER");
        String packageName = MobSDK.getContext().getPackageName();
        intent.putExtra("_weibo_sdkVersion", "0031405000");
        intent.putExtra("_weibo_appPackage", packageName);
        intent.putExtra("_weibo_appKey", this.c);
        intent.putExtra("_weibo_flag", 538116905);
        intent.putExtra("_weibo_sign", cn.sharesdk.sina.weibo.sdk.a.a(MobSDK.getContext(), packageName));
        NLog b2 = SSDKLog.b();
        b2.d("intent=" + intent + ", extra=" + intent.getExtras(), new Object[0]);
        MobSDK.getContext().sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
        return true;
    }

    public boolean a() {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("client_id", this.c));
        arrayList.add(new KVPair<>("client_secret", this.f244d));
        arrayList.add(new KVPair<>(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, this.f245e));
        arrayList.add(new KVPair<>("grant_type", "refresh_token"));
        arrayList.add(new KVPair<>("refresh_token", this.a.getDb().get("refresh_token")));
        try {
            String b2 = this.f248h.b("https://api.weibo.com/oauth2/access_token", arrayList, "/oauth2/access_token", c());
            if (TextUtils.isEmpty(b2) || b2.contains("error") || b2.contains("error_code")) {
                return false;
            }
            HashMap fromJson = new Hashon().fromJson(b2);
            String valueOf = String.valueOf(fromJson.get("uid"));
            String valueOf2 = String.valueOf(fromJson.get("expires_in"));
            this.f246f = String.valueOf(fromJson.get("access_token"));
            String valueOf3 = String.valueOf(fromJson.get("refresh_token"));
            String valueOf4 = String.valueOf(fromJson.get("remind_in"));
            this.a.getDb().putUserId(valueOf);
            this.a.getDb().putExpiresIn(Long.valueOf(valueOf2).longValue());
            this.a.getDb().putToken(this.f246f);
            this.a.getDb().put("refresh_token", valueOf3);
            this.a.getDb().put("remind_in", valueOf4);
            return true;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return false;
        }
    }

    public HashMap<String, Object> b(int i2, int i3, String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        String str2 = this.f246f;
        if (str2 != null) {
            arrayList.add(new KVPair<>("access_token", str2));
        }
        boolean z = true;
        try {
            ResHelper.parseLong(str);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i2)));
        arrayList.add(new KVPair<>("cursor", String.valueOf(i3)));
        String a = this.f248h.a("https://api.weibo.com/2/friendships/friends.json", arrayList, "/2/friendships/friends.json", c());
        if (a != null) {
            return new Hashon().fromJson(a);
        }
        return null;
    }

    private void a(AuthorizeListener authorizeListener) {
        new g(this.c, this.f245e, a(this.f247g, ","), authorizeListener).show(MobSDK.getContext(), null);
        SSDKLog.b().w("SinaWeibo SDK Web showWebAuthActivity ");
    }

    public void a(final Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) {
        if (shareParams == null) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, new Throwable("Please set params"));
                return;
            }
            return;
        }
        if (shareParams.getImageData() == null && TextUtils.isEmpty(shareParams.getImagePath()) && !TextUtils.isEmpty(shareParams.getImageUrl())) {
            try {
                File file = new File(BitmapHelper.downloadBitmap(MobSDK.getContext(), shareParams.getImageUrl()));
                if (file.exists()) {
                    shareParams.setImagePath(file.getAbsolutePath());
                }
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }
        if (shareParams.getImageArray() != null && shareParams.getImageArray().length > 0) {
            try {
                List<String> asList = Arrays.asList(shareParams.getImageArray());
                String[] strArr = new String[asList.size()];
                int i2 = 0;
                for (String str : asList) {
                    if (str.startsWith("http")) {
                        str = BitmapHelper.downloadBitmap(MobSDK.getContext(), str);
                    }
                    File file2 = new File(str);
                    if (file2.exists() && str.startsWith("/data/")) {
                        String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "images");
                        File file3 = new File(cachePath, System.currentTimeMillis() + file2.getName());
                        String absolutePath = file3.getAbsolutePath();
                        file3.createNewFile();
                        if (ResHelper.copyFile(str, absolutePath)) {
                            str = file3.getAbsolutePath();
                        }
                    }
                    strArr[i2] = str;
                    i2++;
                }
                shareParams.setImageArray(strArr);
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
            }
        }
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            shareParams.setText(getPlatform().getShortLintk(text, false));
        }
        AuthorizeListener authorizeListener = new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.i.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                PlatformActionListener platformActionListener2 = platformActionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onCancel(((cn.sharesdk.framework.e) i.this).a, 9);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                if (platformActionListener != null) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("ShareParams", shareParams);
                    platformActionListener.onComplete(((cn.sharesdk.framework.e) i.this).a, 9, hashMap);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th3) {
                PlatformActionListener platformActionListener2 = platformActionListener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(((cn.sharesdk.framework.e) i.this).a, 9, th3);
                }
            }
        };
        new f(this.c, this.f245e, a(this.f247g, ","), shareParams, authorizeListener).show(MobSDK.getContext(), null);
    }

    public HashMap<String, Object> a(int i2, int i3, String str) throws Throwable {
        boolean z;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("source", this.c));
        try {
            ResHelper.parseLong(str);
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            arrayList.add(new KVPair<>("uid", str));
        } else {
            arrayList.add(new KVPair<>(FirebaseAnalytics.Param.SCREEN_NAME, str));
        }
        arrayList.add(new KVPair<>("count", String.valueOf(i2)));
        arrayList.add(new KVPair<>(PageEvent.TYPE_NAME, String.valueOf(i3)));
        String a = this.f248h.a("https://api.weibo.com/2/statuses/user_timeline.json", arrayList, "/2/statuses/user_timeline.json", c());
        if (a != null) {
            return new Hashon().fromJson(a);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HashMap<String, Object> a(String str, String str2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        KVPair kVPair;
        String str3;
        if (str2 == null) {
            return null;
        }
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                arrayList.add(new KVPair<>(entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        arrayList.add(new KVPair<>("source", this.c));
        String str4 = this.f246f;
        if (str4 != null) {
            arrayList.add(new KVPair<>("access_token", str4));
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
        try {
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        if ("GET".equals(str2.toUpperCase())) {
            str3 = new NetworkHelper().httpGet(str, arrayList, null, null);
        } else {
            if ("POST".equals(str2.toUpperCase())) {
                str3 = new NetworkHelper().httpPost(str, arrayList, kVPair, (ArrayList<KVPair<String>>) null, (NetworkHelper.NetworkTimeOut) null);
            }
            str3 = null;
        }
        if (str3 == null || str3.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(str3);
    }
}
