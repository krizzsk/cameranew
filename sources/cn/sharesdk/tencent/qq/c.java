package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mob.MobSDK;
import com.mob.tools.RxMob;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.open.SocialOperation;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.common.network.HttpRequest;
/* compiled from: QQHelper.java */
/* loaded from: classes.dex */
public class c extends cn.sharesdk.framework.e {
    private static final String[] b = {"get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t"};
    private static c c;

    /* renamed from: d  reason: collision with root package name */
    private String f258d;

    /* renamed from: e  reason: collision with root package name */
    private String[] f259e;

    /* renamed from: f  reason: collision with root package name */
    private String f260f;

    /* renamed from: g  reason: collision with root package name */
    private String f261g;

    /* renamed from: h  reason: collision with root package name */
    private String f262h;

    /* renamed from: i  reason: collision with root package name */
    private String f263i;

    private c(Platform platform) {
        super(platform);
        b();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getAuthorizeUrl() {
        String redirectUri;
        ShareSDK.logApiEvent("/oauth2.0/authorize", c());
        String d2 = d();
        try {
            redirectUri = Data.urlEncode(getRedirectUri(), "utf-8");
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            redirectUri = getRedirectUri();
        }
        return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.f258d + "&redirect_uri=" + redirectUri + "&display=mobile&scope=" + d2;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.c getAuthorizeWebviewClient(g gVar) {
        return new b(gVar);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public String getRedirectUri() {
        return "auth://tauth.qq.com/";
    }

    @Override // cn.sharesdk.framework.e, cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        d dVar2 = new d(dVar);
        dVar2.a(Constants.CODE_REQUEST_MIN);
        dVar2.a(this.f258d, d(), this.f263i);
        return dVar2;
    }

    public void b(String str) {
        this.f260f = str;
    }

    public HashMap<String, Object> c(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", str));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = cn.sharesdk.framework.a.b.a().a("https://graph.qq.com/oauth2.0/me", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/oauth2.0/me", c());
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

    public void d(String str) {
        this.f262h = str;
    }

    public HashMap<String, Object> e(String str) throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("access_token", this.f262h));
        arrayList.add(new KVPair<>("oauth_consumer_key", this.f258d));
        arrayList.add(new KVPair<>("openid", this.f260f));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpRequest.HEADER_USER_AGENT, System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
        String a = cn.sharesdk.framework.a.b.a().a("https://graph.qq.com/user/get_simple_userinfo", arrayList, arrayList2, (NetworkHelper.NetworkTimeOut) null, "/user/get_simple_userinfo", c());
        if (a == null || a.length() <= 0) {
            return null;
        }
        return new Hashon().fromJson(a);
    }

    public static c a(Platform platform) {
        if (c == null) {
            c = new c(platform);
        }
        return c;
    }

    private String d() {
        String[] strArr = this.f259e;
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

    public boolean b() {
        String str;
        String str2;
        try {
            PackageInfo packageInfo = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
            str = packageInfo.versionName;
            this.f263i = packageInfo.packageName;
        } catch (Throwable th) {
            try {
                try {
                    try {
                        try {
                            PackageInfo packageInfo2 = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_TIM, 0);
                            str2 = packageInfo2.versionName;
                            this.f263i = packageInfo2.packageName;
                        } catch (Throwable unused) {
                            PackageInfo packageInfo3 = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqqi", 0);
                            str2 = packageInfo3.versionName;
                            this.f263i = packageInfo3.packageName;
                        }
                    } catch (Throwable unused2) {
                        PackageInfo packageInfo4 = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_QQ_SPEED, 0);
                        str2 = packageInfo4.versionName;
                        this.f263i = packageInfo4.packageName;
                    }
                } catch (Throwable unused3) {
                    str = null;
                    SSDKLog.b().d(th);
                }
            } catch (Throwable unused4) {
                PackageInfo packageInfo5 = MobSDK.getContext().getPackageManager().getPackageInfo(Constants.PACKAGE_QQ_PAD, 0);
                str2 = packageInfo5.versionName;
                this.f263i = packageInfo5.packageName;
            }
            str = str2;
        }
        return !TextUtils.isEmpty(str);
    }

    public void a(String str) {
        this.f258d = str;
    }

    public void a(String[] strArr) {
        this.f259e = strArr;
    }

    public void a(final AuthorizeListener authorizeListener, boolean z) {
        a(new SSOListener() { // from class: cn.sharesdk.tencent.qq.c.1
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

    public void a() {
        RxMob.Subscribable create = RxMob.create(new RxMob.OnSubscribe() { // from class: cn.sharesdk.tencent.qq.c.2
            @Override // com.mob.tools.RxMob.OnSubscribe
            public void call(RxMob.Subscriber subscriber) {
                ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                arrayList.add(new KVPair<>("access_token", c.this.f262h));
                arrayList.add(new KVPair<>(SocialOperation.GAME_UNION_ID, "1"));
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = 10000;
                networkTimeOut.connectionTimeout = 10000;
                cn.sharesdk.framework.a.b a = cn.sharesdk.framework.a.b.a();
                try {
                    c.this.f261g = a.httpPost("https://graph.qq.com/oauth2.0/me", arrayList, (KVPair<String>) null, (ArrayList<KVPair<String>>) null, networkTimeOut);
                    subscriber.onCompleted();
                } catch (Throwable th) {
                    th.printStackTrace();
                    ((cn.sharesdk.framework.e) c.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
                    SSDKLog.b().d("qq auth,get unionId fail", new Object[0]);
                }
            }
        });
        create.subscribeOn(RxMob.Thread.NEW_THREAD);
        create.observeOn(RxMob.Thread.IMMEDIATE);
        create.subscribe(new RxMob.Subscriber() { // from class: cn.sharesdk.tencent.qq.c.3
            @Override // com.mob.tools.RxMob.Subscriber
            public void onCompleted() {
                if (c.this.f261g == null || c.this.f261g.length() <= 0) {
                    return;
                }
                c cVar = c.this;
                cVar.f261g = cVar.f261g.replace("callback( ", "");
                c cVar2 = c.this;
                cVar2.f261g = cVar2.f261g.replace(" );", "");
                HashMap fromJson = new Hashon().fromJson(c.this.f261g);
                if (fromJson.containsKey(SocialOperation.GAME_UNION_ID)) {
                    ((cn.sharesdk.framework.e) c.this).a.getDb().put(SocialOperation.GAME_UNION_ID, (String) fromJson.get(SocialOperation.GAME_UNION_ID));
                    return;
                }
                ((cn.sharesdk.framework.e) c.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
            }

            @Override // com.mob.tools.RxMob.Subscriber
            public void onError(Throwable th) {
                ((cn.sharesdk.framework.e) c.this).a.getDb().put(SocialOperation.GAME_UNION_ID, "");
                SSDKLog.b().d("qq auth,get unionId fail", new Object[0]);
            }
        });
    }

    public void a(Platform platform, Platform.ShareParams shareParams, PlatformActionListener platformActionListener) throws Throwable {
        cn.sharesdk.framework.utils.g gVar = new cn.sharesdk.framework.utils.g();
        gVar.a(this.f263i, "com.tencent.mobileqq.activity.JumpActivity");
        gVar.a(shareParams, platform);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ShareParams", shareParams);
        platformActionListener.onComplete(platform, 9, hashMap);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, PlatformActionListener platformActionListener, boolean z, int i2, String str7, String str8, String str9, int i3) {
        String str10 = str4;
        if (z) {
            a(str, str2, str3, str4, str5, str6, platformActionListener);
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " QQ QQHelper addShare weiboShare ");
        } else if (!b()) {
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, new Throwable("QQClientNotExistException"));
            }
        } else {
            SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " QQ QQHelper addShare isQQInstalled ");
            if (!TextUtils.isEmpty(str4)) {
                File file = new File(str10);
                if (file.exists() && str10.startsWith("/data/")) {
                    String cachePath = ResHelper.getCachePath(MobSDK.getContext(), "images");
                    String absolutePath = new File(cachePath, System.currentTimeMillis() + file.getName()).getAbsolutePath();
                    if (ResHelper.copyFile(str10, absolutePath)) {
                        NLog b2 = SSDKLog.b();
                        b2.d(OnekeyShare.SHARESDK_TAG, " QQ QQHelper imagePath " + absolutePath);
                        str10 = absolutePath;
                    } else {
                        str10 = null;
                        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " QQ QQHelper imagePath is null");
                    }
                }
            }
            Intent intent = new Intent();
            intent.putExtra("title", str);
            intent.putExtra("titleUrl", str2);
            intent.putExtra("summary", str3);
            intent.putExtra("imagePath", str10);
            intent.putExtra("imageUrl", str5);
            intent.putExtra("musicUrl", str6);
            intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, this.f258d);
            intent.putExtra("hidden", i2);
            intent.putExtra(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, str7);
            intent.putExtra(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, str8);
            intent.putExtra(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, str9);
            intent.putExtra("share_type", i3);
            e eVar = new e();
            eVar.a(this.a, platformActionListener);
            eVar.a(this.f258d);
            eVar.show(MobSDK.getContext(), intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:3:0x0002, B:5:0x0008, B:13:0x0019, B:15:0x006c, B:17:0x0072, B:18:0x007a, B:21:0x009c, B:24:0x00a4, B:26:0x00bb, B:27:0x00c6, B:19:0x008e), top: B:33:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008e A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:3:0x0002, B:5:0x0008, B:13:0x0019, B:15:0x006c, B:17:0x0072, B:18:0x007a, B:21:0x009c, B:24:0x00a4, B:26:0x00bb, B:27:0x00c6, B:19:0x008e), top: B:33:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, cn.sharesdk.framework.PlatformActionListener r13) {
        /*
            r6 = this;
            r7 = 9
            boolean r8 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lcc
            if (r8 == 0) goto L11
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> Lcc
            if (r8 != 0) goto Lf
            goto L11
        Lf:
            r8 = 0
            goto L12
        L11:
            r8 = 1
        L12:
            if (r8 != 0) goto L17
            java.lang.String r12 = "/t/add_t"
            goto L19
        L17:
            java.lang.String r12 = "/t/add_pic_t"
        L19:
            r4 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcc
            r12.<init>()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "https://graph.qq.com"
            r12.append(r0)     // Catch: java.lang.Throwable -> Lcc
            r12.append(r4)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r1 = r12.toString()     // Catch: java.lang.Throwable -> Lcc
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lcc
            r2.<init>()     // Catch: java.lang.Throwable -> Lcc
            com.mob.tools.network.KVPair r12 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "oauth_consumer_key"
            java.lang.String r3 = r6.f258d     // Catch: java.lang.Throwable -> Lcc
            r12.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lcc
            r2.add(r12)     // Catch: java.lang.Throwable -> Lcc
            com.mob.tools.network.KVPair r12 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "access_token"
            java.lang.String r3 = r6.f262h     // Catch: java.lang.Throwable -> Lcc
            r12.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lcc
            r2.add(r12)     // Catch: java.lang.Throwable -> Lcc
            com.mob.tools.network.KVPair r12 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "openid"
            java.lang.String r3 = r6.f260f     // Catch: java.lang.Throwable -> Lcc
            r12.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lcc
            r2.add(r12)     // Catch: java.lang.Throwable -> Lcc
            com.mob.tools.network.KVPair r12 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "format"
            java.lang.String r3 = "json"
            r12.<init>(r0, r3)     // Catch: java.lang.Throwable -> Lcc
            r2.add(r12)     // Catch: java.lang.Throwable -> Lcc
            com.mob.tools.network.KVPair r12 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r0 = "content"
            r12.<init>(r0, r9)     // Catch: java.lang.Throwable -> Lcc
            r2.add(r12)     // Catch: java.lang.Throwable -> Lcc
            if (r8 == 0) goto L8e
            boolean r8 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Lcc
            if (r8 == 0) goto L7a
            android.content.Context r8 = com.mob.MobSDK.getContext()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r10 = com.mob.tools.utils.BitmapHelper.downloadBitmap(r8, r11)     // Catch: java.lang.Throwable -> Lcc
        L7a:
            com.mob.tools.network.KVPair r3 = new com.mob.tools.network.KVPair     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r8 = "pic"
            r3.<init>(r8, r10)     // Catch: java.lang.Throwable -> Lcc
            cn.sharesdk.framework.a.b r0 = cn.sharesdk.framework.a.b.a()     // Catch: java.lang.Throwable -> Lcc
            int r5 = r6.c()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r8 = r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> Lcc
            goto L9a
        L8e:
            cn.sharesdk.framework.a.b r8 = cn.sharesdk.framework.a.b.a()     // Catch: java.lang.Throwable -> Lcc
            int r9 = r6.c()     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r8 = r8.b(r1, r2, r4, r9)     // Catch: java.lang.Throwable -> Lcc
        L9a:
            if (r8 == 0) goto Ld4
            int r9 = r8.length()     // Catch: java.lang.Throwable -> Lcc
            if (r9 <= 0) goto Ld4
            if (r13 == 0) goto Ld4
            com.mob.tools.utils.Hashon r9 = new com.mob.tools.utils.Hashon     // Catch: java.lang.Throwable -> Lcc
            r9.<init>()     // Catch: java.lang.Throwable -> Lcc
            java.util.HashMap r9 = r9.fromJson(r8)     // Catch: java.lang.Throwable -> Lcc
            java.lang.String r10 = "ret"
            java.lang.Object r10 = r9.get(r10)     // Catch: java.lang.Throwable -> Lcc
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch: java.lang.Throwable -> Lcc
            int r10 = r10.intValue()     // Catch: java.lang.Throwable -> Lcc
            if (r10 == 0) goto Lc6
            cn.sharesdk.framework.Platform r9 = r6.a     // Catch: java.lang.Throwable -> Lcc
            java.lang.Exception r10 = new java.lang.Exception     // Catch: java.lang.Throwable -> Lcc
            r10.<init>(r8)     // Catch: java.lang.Throwable -> Lcc
            r13.onError(r9, r7, r10)     // Catch: java.lang.Throwable -> Lcc
            goto Ld4
        Lc6:
            cn.sharesdk.framework.Platform r8 = r6.a     // Catch: java.lang.Throwable -> Lcc
            r13.onComplete(r8, r7, r9)     // Catch: java.lang.Throwable -> Lcc
            goto Ld4
        Lcc:
            r8 = move-exception
            if (r13 == 0) goto Ld4
            cn.sharesdk.framework.Platform r9 = r6.a
            r13.onError(r9, r7, r8)
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.tencent.qq.c.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, cn.sharesdk.framework.PlatformActionListener):void");
    }
}
