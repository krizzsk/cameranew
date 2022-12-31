package cn.sharesdk.tencent.qzone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.RxMob;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.common.network.HttpRequest;
/* compiled from: QZoneHelper.java */
/* loaded from: classes.dex */
public class b extends e {
    private static final String[] b = {"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    private static b c;

    /* renamed from: d  reason: collision with root package name */
    private String f277d;

    /* renamed from: e  reason: collision with root package name */
    private String f278e;

    /* renamed from: f  reason: collision with root package name */
    private String f279f;

    /* renamed from: g  reason: collision with root package name */
    private String f280g;

    /* renamed from: h  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f281h;

    /* renamed from: i  reason: collision with root package name */
    private String[] f282i;

    private b(Platform platform) {
        super(platform);
        this.f281h = cn.sharesdk.framework.a.b.a();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        String redirectUri;
        ShareSDK.logApiEvent("/oauth2.0/authorize", c());
        String e2 = e();
        try {
            redirectUri = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            redirectUri = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f277d + "&redirect_uri=" + redirectUri + "&display=mobile&scope=" + e2;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g gVar) {
        return new a(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    @Override // cn.sharesdk.framework.e, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        c cVar = new c(dVar);
        cVar.a(Constants.CODE_REQUEST_MIN);
        cVar.a(this.f277d, e());
        return cVar;
    }

    private String e() {
        String[] strArr = this.f282i;
        if (strArr == null) {
            strArr = b;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : strArr) {
            if (i2 > 0) {
                sb.append(',');
            }
            sb.append(str);
            i2++;
        }
        return sb.toString();
    }

    private String f(String str) {
        if (Build.VERSION.SDK_INT > 10) {
            try {
                Class<?> cls = ReflectHelper.getClass("android.media.MediaMetadataRetriever");
                Object newInstance = cls.newInstance();
                cls.getMethod("setDataSource", String.class).invoke(newInstance, str);
                return (String) ReflectHelper.invokeInstanceMethod(newInstance, "extractMetadata", 9);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public void b(String str) {
        this.f278e = str;
    }

    public void c(String str) {
        this.f279f = str;
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f279f));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f277d));
        arrayList.add(new KVPair<>("openid", this.f278e));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f281h.a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/user/get_simple_userinfo", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public static b a(Platform platform) {
        if (c == null) {
            c = new b(platform);
        }
        return c;
    }

    public boolean b() {
        try {
            PackageInfo packageInfo = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_QZONE, 0);
            if (packageInfo == null) {
                return false;
            }
            String[] split = packageInfo.versionName.split("\\.");
            int length = split.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    iArr[i2] = ResHelper.parseInt(split[i2]);
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                    iArr[i2] = 0;
                }
            }
            return length > 1 && (iArr[0] >= 4 || iArr[1] >= 1);
        } catch (Throwable th2) {
            SSDKLog.b().d(th2);
            return false;
        }
    }

    public void a(String str) {
        this.f277d = str;
    }

    public void a(String[] strArr) {
        this.f282i = strArr;
    }

    public void a(final AuthorizeListener authorizeListener, boolean z) {
        a(new SSOListener() { // from class: cn.sharesdk.tencent.qzone.b.1
            @Override // cn.sharesdk.framework.authorize.SSOListener
            public void onCancel() {
                authorizeListener.onCancel();
            }

            @Override // cn.sharesdk.framework.authorize.SSOListener
            public void onComplete(Bundle bundle) {
                authorizeListener.onComplete(bundle);
            }

            @Override // cn.sharesdk.framework.authorize.SSOListener
            public void onFailed(Throwable th) {
                if (th != null) {
                    authorizeListener.onError(th);
                } else {
                    authorizeListener.onError(new Throwable("Unknown Throwable!"));
                }
            }
        });
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", str));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f281h.a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/oauth2.0/me", c());
        if (a.startsWith("callback")) {
            while (!a.startsWith("{") && a.length() > 0) {
                a = a.substring(1);
            }
            while (!a.endsWith("}") && a.length() > 0) {
                a = a.substring(0, a.length() - 1);
            }
        }
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public void a() {
        RxMob.Subscribable create = RxMob.create(new RxMob.OnSubscribe() { // from class: cn.sharesdk.tencent.qzone.b.2
            @Override // com.mob.tools.RxMob.OnSubscribe
            public void call(RxMob.Subscriber subscriber) {
                ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                arrayList.add(new KVPair<>("access_token", b.this.f279f));
                arrayList.add(new KVPair<>(SocialOperation.GAME_UNION_ID, "1"));
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = 10000;
                networkTimeOut.connectionTimeout = 10000;
                cn.sharesdk.framework.a.b a = cn.sharesdk.framework.a.b.a();
                try {
                    b.this.f280g = a.httpPost("https://graph.qq.com/oauth2.0/me", arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) null, networkTimeOut);
                    subscriber.onCompleted();
                } catch (Throwable unused) {
                    ((e) b.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
                    SSDKLog.b().d("qq auth, get unionId fail", new Object[0]);
                }
            }
        });
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.IMMEDIATE);
        create.subscribe(new RxMob.Subscriber() { // from class: cn.sharesdk.tencent.qzone.b.3
            @Override // com.mob.tools.RxMob.Subscriber
            public void onCompleted() {
                if (b.this.f280g == null || b.this.f280g.length() <= 0) {
                    return;
                }
                b bVar = b.this;
                bVar.f280g = bVar.f280g.replace("callback( ", "");
                b bVar2 = b.this;
                bVar2.f280g = bVar2.f280g.replace(" );", "");
                HashMap fromJson = new Hashon().fromJson(b.this.f280g);
                if (fromJson.containsKey(SocialOperation.GAME_UNION_ID)) {
                    ((e) b.this).a.getDb().put(SocialOperation.GAME_UNION_ID, (String) fromJson.get(SocialOperation.GAME_UNION_ID));
                    return;
                }
                ((e) b.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onError(Throwable th) {
                ((e) b.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
                SSDKLog.b().d("qq auth, get unionId fail", new Object[0]);
            }
        });
    }

    public HashMap<String, Object> b(String str, String str2) throws Throwable {
        String b2;
        boolean z = !TextUtils.isEmpty(str);
        String str3 = z ? "/t/add_pic_t" : "/t/add_t";
        String str4 = "https://graph.qq.com" + str3;
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f277d));
        arrayList.add(new KVPair<>("access_token", this.f279f));
        arrayList.add(new KVPair<>("openid", this.f278e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        arrayList.add(new KVPair<>(FirebaseAnalytics.Param.CONTENT, str2));
        if (z) {
            b2 = this.f281h.a(str4, arrayList, new KVPair<>("pic", str), str3, c());
        } else {
            b2 = this.f281h.b(str4, arrayList, str3, c());
        }
        if (b2 == null || b2.length() <= 0) {
            return null;
        }
        HashMap<String, Object> fromJson = new Hashon().fromJson(b2);
        if (((Integer) fromJson.get("ret")).intValue() == 0) {
            return fromJson;
        }
        throw new Throwable(b2);
    }

    public void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, PlatformActionListener platformActionListener) throws Throwable {
        String appName = TextUtils.isEmpty(str5) ? DeviceHelper.getInstance(MobSDK.getContext()).getAppName() : str5;
        if (appName.length() > 20) {
            appName = appName.substring(0, 20) + "...";
        }
        a(i2, (TextUtils.isEmpty(str) || str.length() <= 200) ? str : str.substring(0, 200), str2, str3, str4, appName, str6, platformActionListener);
    }

    public boolean d() {
        String str;
        try {
            str = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            try {
                try {
                    str = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_TIM, 0).versionName;
                } catch (Throwable unused) {
                    str = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_QQ_PAD, 0).versionName;
                }
            } catch (Throwable unused2) {
                SSDKLog.b().d(th);
                str = null;
            }
        }
        return !TextUtils.isEmpty(str);
    }

    public void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener) throws Throwable {
        String str7;
        if (!TextUtils.isEmpty(str6)) {
            str7 = Constants.VIA_TO_TYPE_QZONE;
        } else if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            str7 = "3";
        } else if (TextUtils.isEmpty(str2)) {
            if (platformActionListener != null) {
                platformActionListener.onError(null, 9, new Throwable("The param of title or titleUrl is null !"));
                return;
            }
            return;
        } else {
            str7 = "1";
        }
        a(str7, str, str2, str3, str4, str5, str6, platformActionListener);
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, PlatformActionListener platformActionListener) {
        String str8 = str5;
        try {
            StringBuilder sb = new StringBuilder();
            if (str != "3" && str != Constants.VIA_TO_TYPE_QZONE) {
                sb.append("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
            } else {
                sb.append("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
            }
            if (!TextUtils.isEmpty(str5)) {
                if (!str8.startsWith("http") && !str8.startsWith("https")) {
                    File file = new File(str8);
                    if (file.exists() && str8.startsWith("/data/")) {
                        String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "images");
                        String absolutePath = new File(cachePath, System.currentTimeMillis() + file.getName()).getAbsolutePath();
                        if (ResHelper.copyFile(str8, absolutePath)) {
                            str8 = absolutePath;
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        File file2 = new File(str8);
                        Context context = MobSDK.getContext();
                        Uri a = ShareSDKFileProvider.a(context, MobSDK.getContext().getPackageName() + ".cn.sharesdk.ShareSDKFileProvider", file2);
                        MobSDK.getContext().grantUriPermission("com.tencent.mobileqq", a, 3);
                        sb.append("&image_uri=");
                        sb.append(Base64.encodeToString(String.valueOf(a).getBytes("utf-8"), 2));
                    } else {
                        sb.append("&image_url=");
                        sb.append(Base64.encodeToString(str8.getBytes("utf-8"), 2));
                    }
                }
                sb.append("&image_url=");
                sb.append(Base64.encodeToString(str8.getBytes("utf-8"), 2));
            }
            String substring = (TextUtils.isEmpty(str4) || str4.length() <= 600) ? str4 : str4.substring(0, 600);
            if (!TextUtils.isEmpty(str7) && str.equals(Constants.VIA_TO_TYPE_QZONE)) {
                ResHelper.getFileSize(str7);
                String valueOf = String.valueOf(str6);
                String f2 = f(str7);
                sb.append("&videoPath=");
                sb.append(Base64.encodeToString(str7.getBytes("utf-8"), 2));
                sb.append("&videoSize=");
                sb.append(Base64.encodeToString(valueOf.getBytes("utf-8"), 2));
                if (!TextUtils.isEmpty(f2)) {
                    sb.append("&videoDuration=");
                    sb.append(Base64.encodeToString(f2.getBytes("utf-8"), 2));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("&title=");
                sb.append(Base64.encodeToString(str2.getBytes("utf-8"), 2));
            }
            if (!TextUtils.isEmpty(substring)) {
                sb.append("&description=");
                sb.append(Base64.encodeToString(substring.getBytes("utf-8"), 2));
            }
            sb.append("&share_id=");
            sb.append(this.f277d);
            if (!TextUtils.isEmpty(str3)) {
                sb.append("&url=");
                sb.append(Base64.encodeToString(str3.getBytes("utf-8"), 2));
            }
            sb.append("&app_name=");
            sb.append(Base64.encodeToString(str6.getBytes("utf-8"), 2));
            if (!TextUtils.isEmpty(substring)) {
                sb.append("&share_qq_ext_str=");
                sb.append(Base64.encodeToString(substring.getBytes(), 2));
            }
            sb.append("&req_type=");
            sb.append(Base64.encodeToString(str.getBytes("utf-8"), 2));
            String str9 = d() ? "1" : "0";
            sb.append("&cflag=");
            sb.append(Base64.encodeToString(str9.getBytes("utf-8"), 2));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(sb.toString()));
            if (MobSDK.getContext().getPackageManager().resolveActivity(intent, 1) != null) {
                d dVar = new d();
                dVar.a(sb.toString(), true);
                dVar.a(platformActionListener);
                dVar.a(this.f277d);
                dVar.show(MobSDK.getContext(), null);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            NLog b2 = SSDKLog.b();
            b2.d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity run catch " + th);
        }
    }

    public HashMap<String, Object> a(String str, String str2) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f279f));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f277d));
        arrayList.add(new KVPair<>("openid", this.f278e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        if (!TextUtils.isEmpty(str2)) {
            if (str2.length() > 200) {
                str2 = str2.substring(0, 199) + MobSDK.getContext().getString(ResHelper.getStringRes(MobSDK.getContext(), "ssdk_symbol_ellipsis"));
            }
            arrayList.add(new KVPair<>("photodesc", str2));
        }
        arrayList.add(new KVPair<>(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, "1"));
        KVPair<String> kVPair = new KVPair<>("picture", str);
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = this.f281h.a("https://graph.qq.com/photo/upload_pic", arrayList, kVPair, arrayList2, "/photo/upload_pic", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00fd -> B:34:0x00fe). Please submit an issue!!! */
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
        arrayList.add(new KVPair<>("access_token", this.f279f));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f277d));
        arrayList.add(new KVPair<>("openid", this.f278e));
        arrayList.add(new KVPair<>(IjkMediaMeta.IJKM_KEY_FORMAT, "json"));
        if (hashMap2 == null || hashMap2.size() <= 0) {
            kVPair = null;
        } else {
            KVPair kVPair2 = null;
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                kVPair2 = new KVPair(entry2.getKey(), entry2.getValue());
            }
            kVPair = kVPair2;
        }
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        try {
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        if ("GET".equals(str2.toUpperCase())) {
            str3 = new NetworkHelper().httpGet(str, arrayList, arrayList2, null);
        } else {
            if ("POST".equals(str2.toUpperCase())) {
                str3 = new NetworkHelper().httpPost(str, arrayList, kVPair, arrayList2, (NetworkHelper.NetworkTimeOut) null);
            }
            str3 = null;
        }
        if (str3 == null || str3.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(str3);
    }
}
