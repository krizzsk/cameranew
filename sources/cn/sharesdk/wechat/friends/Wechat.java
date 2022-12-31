package cn.sharesdk.wechat.friends;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.moments.WechatMoments;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.c;
import cn.sharesdk.wechat.utils.h;
import cn.sharesdk.wechat.utils.k;
import cn.sharesdk.wechat.utils.l;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.HashMap;
import us.pinguo.androidsdk.pgedit.PGEditResultActivity2;
import us.pinguo.inspire.api.QiniuAuthToken;
/* loaded from: classes.dex */
public class Wechat extends Platform {
    public static final String NAME = "Wechat";
    private String a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private String f300d;

    /* renamed from: e  reason: collision with root package name */
    private String f301e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f302f;

    /* renamed from: g  reason: collision with root package name */
    private int f303g;

    /* renamed from: h  reason: collision with root package name */
    private IWXAPI f304h;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        if (!isClientValid()) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, i2, new WechatClientNotExistException());
            }
            return false;
        } else if (i2 == 9 || isAuthValid() || c()) {
            return true;
        } else {
            if (!TextUtils.isEmpty(getDb().get("refresh_token"))) {
                try {
                    h hVar = new h(this, 22);
                    hVar.a(this.a, this.b);
                    if (hVar.a()) {
                        return true;
                    }
                } catch (Exception e2) {
                    SSDKLog.b().d(e2);
                }
            }
            innerAuthorize(i2, obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
            l a = l.a();
            a.c(this.a);
            if (!a.c()) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 1, new WechatClientNotExistException());
                    return;
                }
                return;
            }
            h hVar = new h(this, 22);
            hVar.a(this.a, this.b);
            k kVar = new k(this);
            kVar.a(hVar);
            kVar.a(new AuthorizeListener() { // from class: cn.sharesdk.wechat.friends.Wechat.1
                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onCancel() {
                    if (((Platform) Wechat.this).listener != null) {
                        ((Platform) Wechat.this).listener.onCancel(Wechat.this, 1);
                    }
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onComplete(Bundle bundle) {
                    Wechat.this.afterRegister(1, null);
                }

                @Override // cn.sharesdk.framework.authorize.AuthorizeListener
                public void onError(Throwable th) {
                    if (((Platform) Wechat.this).listener != null) {
                        ((Platform) Wechat.this).listener.onError(Wechat.this, 1, th);
                    }
                }
            });
            try {
                IWXAPI a2 = c.a(this.a);
                this.f304h = a2;
                a.a(kVar, a2);
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 1, th);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener3 = this.listener;
        if (platformActionListener3 != null) {
            platformActionListener3.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        shareParams.set(SharePluginInfo.ISSUE_SCENE, 0);
        l a = l.a();
        this.f301e = TextUtils.isEmpty(shareParams.getWxPath()) ? this.f301e : shareParams.getWxPath();
        this.f300d = TextUtils.isEmpty(shareParams.getWxUserName()) ? this.f300d : shareParams.getWxUserName();
        this.f302f = !shareParams.toMap().containsKey("wxWithShareTicket") ? this.f302f : shareParams.getWxWithShareTicket();
        this.f303g = !shareParams.toMap().containsKey("wxMiniProgramType") ? this.f303g : shareParams.getWxMiniProgramType();
        a.a(this.f301e);
        a.b(this.f300d);
        a.a(this.f302f);
        a.a(this.f303g);
        a.c(this.a);
        k kVar = new k(this);
        this.f304h = c.a(this.a);
        if (this.c) {
            try {
                a.a(kVar, shareParams, this.listener);
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 9, th);
                    return;
                }
                return;
            }
        }
        kVar.a(shareParams, this.listener);
        try {
            a.b(kVar, this.f304h);
        } catch (Throwable th2) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 9, th2);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        String text = shareParams.getText();
        aVar.b = text;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        Bitmap imageData = shareParams.getImageData();
        if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f98d.add(imageUrl);
        } else if (imagePath != null) {
            aVar.f99e.add(imagePath);
        } else if (imageData != null) {
            aVar.f100f.add(imageData);
        }
        String url = shareParams.getUrl();
        if (url != null) {
            aVar.c.add(url);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("title", shareParams.getTitle());
        hashMap2.put("url", url);
        hashMap2.put("extInfo", null);
        hashMap2.put(FirebaseAnalytics.Param.CONTENT, text);
        hashMap2.put(QiniuAuthToken.TYPE_IMAGE, aVar.f98d);
        hashMap2.put("musicFileUrl", url);
        aVar.f101g = hashMap2;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 6);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getBilaterals(int i2, int i3, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowers(int i2, int i3, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i2, int i3, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i2, int i3, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 22;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return !this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("AppId");
        this.b = getDevinfo("AppSecret");
        this.c = "true".equals(getDevinfo("BypassApproval"));
        this.f300d = getDevinfo(TextUtils.isEmpty(getDevinfo("UserName")) ? "userName" : "UserName");
        this.f301e = getDevinfo(TextUtils.isEmpty(getDevinfo("Path")) ? PGEditResultActivity2.PATH : "Path");
        this.f302f = "true".equals(getDevinfo("WithShareTicket"));
        try {
            this.f303g = Integer.valueOf(getDevinfo("MiniprogramType")).intValue();
        } catch (Throwable unused) {
            this.f303g = 0;
        }
        String str2 = this.a;
        if (str2 == null || str2.length() <= 0) {
            this.a = getDevinfo(WechatMoments.NAME, "AppId");
            this.c = "true".equals(getDevinfo(WechatMoments.NAME, "BypassApproval"));
            String str3 = this.a;
            if (str3 != null && str3.length() > 0) {
                copyDevinfo(WechatMoments.NAME, NAME);
                this.a = getDevinfo("AppId");
                this.c = "true".equals(getDevinfo("BypassApproval"));
                SSDKLog.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            String devinfo = getDevinfo("WechatFavorite", "AppId");
            this.a = devinfo;
            if (devinfo == null || devinfo.length() <= 0) {
                return;
            }
            copyDevinfo("WechatFavorite", NAME);
            this.a = getDevinfo("AppId");
            SSDKLog.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        l a = l.a();
        a.c(this.a);
        return a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo(TapjoyConstants.TJC_APP_ID, "AppId");
        this.b = getNetworkDevinfo("app_secret", "AppSecret");
        String str = this.a;
        if (str == null || str.length() <= 0) {
            String networkDevinfo = getNetworkDevinfo(23, TapjoyConstants.TJC_APP_ID, "AppId");
            this.a = networkDevinfo;
            if (networkDevinfo != null && networkDevinfo.length() > 0) {
                copyNetworkDevinfo(23, 22);
                this.a = getNetworkDevinfo(TapjoyConstants.TJC_APP_ID, "AppId");
                SSDKLog.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
            } else {
                String networkDevinfo2 = getNetworkDevinfo(37, TapjoyConstants.TJC_APP_ID, "AppId");
                this.a = networkDevinfo2;
                if (networkDevinfo2 != null && networkDevinfo2.length() > 0) {
                    copyNetworkDevinfo(37, 22);
                    this.a = getNetworkDevinfo(TapjoyConstants.TJC_APP_ID, "AppId");
                    SSDKLog.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
                }
            }
        }
        String str2 = this.b;
        if (str2 == null || str2.length() <= 0) {
            String networkDevinfo3 = getNetworkDevinfo(23, "app_secret", "AppSecret");
            this.b = networkDevinfo3;
            if (networkDevinfo3 != null && networkDevinfo3.length() > 0) {
                copyNetworkDevinfo(23, 22);
                this.b = getNetworkDevinfo("app_secret", "AppSecret");
                SSDKLog.b().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
                return;
            }
            String networkDevinfo4 = getNetworkDevinfo(37, "app_secret", "AppSecret");
            this.b = networkDevinfo4;
            if (networkDevinfo4 == null || networkDevinfo4.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(37, 22);
            this.b = getNetworkDevinfo("app_secret", "AppSecret");
            SSDKLog.b().d("Try to use the dev info of WechatFavorite, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public void subscribeAuth(Platform.ShareParams shareParams) {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
            l a = l.a();
            a.c(this.a);
            if (!a.c()) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 1, new WechatClientNotExistException());
                    return;
                }
                return;
            }
            k kVar = new k(this);
            kVar.a(shareParams, this.listener);
            try {
                a.a(kVar);
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this, 9, null);
                }
                SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, "subscribeAuth start on Wechat");
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onError(this, 1, th);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener4 = this.listener;
        if (platformActionListener4 != null) {
            platformActionListener4.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i2, int i3, String str) {
        PlatformActionListener platformActionListener = this.listener;
        if (platformActionListener != null) {
            platformActionListener.onCancel(this, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
            h hVar = new h(this, 22);
            hVar.a(this.a, this.b);
            try {
                hVar.a(this.listener);
                return;
            } catch (Throwable th) {
                SSDKLog.b().d(th);
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 8, th);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener2 = this.listener;
        if (platformActionListener2 != null) {
            platformActionListener2.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
        }
    }

    private boolean c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        h hVar = new h(this, 22);
        hVar.a(this.a, this.b);
        return hVar.a();
    }
}
