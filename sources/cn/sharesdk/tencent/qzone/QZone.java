package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.g;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class QZone extends Platform {
    public static final String NAME = "QZone";
    private String a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        b a = b.a(this);
        if (a.b() && this.b && i2 == 9) {
            return true;
        }
        if (!isAuthValid() && i2 != 9) {
            innerAuthorize(i2, obj);
            return false;
        }
        a.a(this.a);
        a.b(this.db.getUserId());
        a.c(this.db.getToken());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final b a = b.a(this);
        a.a(this.a);
        a.a(strArr);
        a.a(new AuthorizeListener() { // from class: cn.sharesdk.tencent.qzone.QZone.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) QZone.this).listener != null) {
                    ((Platform) QZone.this).listener.onCancel(QZone.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("open_id");
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                ((Platform) QZone.this).db.putToken(string2);
                ((Platform) QZone.this).db.putTokenSecret("");
                try {
                    ((Platform) QZone.this).db.putExpiresIn(ResHelper.parseLong(string3));
                } catch (Throwable th) {
                    SSDKLog.b().d(th);
                }
                ((Platform) QZone.this).db.putUserId(string);
                String string4 = bundle.getString(Constants.PARAM_PLATFORM_ID);
                String string5 = bundle.getString("pfkey");
                String string6 = bundle.getString("pay_token");
                ((Platform) QZone.this).db.put(Constants.PARAM_PLATFORM_ID, string4);
                ((Platform) QZone.this).db.put("pfkey", string5);
                ((Platform) QZone.this).db.put("pay_token", string6);
                a.b(string);
                a.c(string2);
                a.a();
                QZone.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) QZone.this).listener != null) {
                    ((Platform) QZone.this).listener.onError(QZone.this, 1, th);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        HashMap<String, Object> a = b.a(this).a(str, str2, hashMap, hashMap2);
        if (a != null && a.size() > 0) {
            if (!a.containsKey("ret")) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, i2, new Throwable());
                    return;
                }
                return;
            } else if (((Integer) a.get("ret")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, i2, new Throwable(new Hashon().fromHashMap(a)));
                    return;
                }
                return;
            } else {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this, i2, a);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener3 = this.listener;
        if (platformActionListener3 != null) {
            platformActionListener3.onError(this, i2, new Throwable());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        if (b.a(this).b() && this.b) {
            try {
                a(shareParams);
            } catch (Throwable th) {
                if (this.listener != null) {
                    this.listener.onError(this, 9, th);
                }
            }
        } else if (shareParams.isShareTencentWeibo()) {
            b(shareParams);
        } else {
            c(shareParams);
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
        aVar.b = shareParams.getText();
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        if (imagePath != null) {
            aVar.f99e.add(imagePath);
        } else if (hashMap.get("large_url") != null) {
            aVar.f98d.add(String.valueOf(hashMap.get("large_url")));
        } else if (hashMap.get("small_url") != null) {
            aVar.f98d.add(String.valueOf(hashMap.get("small_url")));
        } else if (imageUrl != null) {
            aVar.f98d.add(imageUrl);
        }
        String titleUrl = shareParams.getTitleUrl();
        if (titleUrl != null) {
            aVar.c.add(titleUrl);
        }
        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("title", shareParams.getTitle());
        hashMap2.put("titleUrl", shareParams.getTitleUrl());
        hashMap2.put("site", shareParams.getSite());
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
        return 6;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 2;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("AppId");
        this.b = "true".equals(getDevinfo("BypassApproval"));
        String str2 = this.a;
        if (str2 == null || str2.length() <= 0) {
            String devinfo = getDevinfo("QQ", "AppId");
            this.a = devinfo;
            if (devinfo == null || devinfo.length() <= 0) {
                return;
            }
            copyDevinfo("QQ", NAME);
            this.a = getDevinfo("AppId");
            SSDKLog.b().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        b a = b.a(this);
        a.a(this.a);
        return a.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        String networkDevinfo = getNetworkDevinfo(TapjoyConstants.TJC_APP_ID, "AppId");
        this.a = networkDevinfo;
        if (networkDevinfo == null || networkDevinfo.length() <= 0) {
            String networkDevinfo2 = getNetworkDevinfo(24, TapjoyConstants.TJC_APP_ID, "AppId");
            this.a = networkDevinfo2;
            if (networkDevinfo2 == null || networkDevinfo2.length() <= 0) {
                return;
            }
            copyNetworkDevinfo(24, 6);
            this.a = getNetworkDevinfo(TapjoyConstants.TJC_APP_ID, "AppId");
            SSDKLog.b().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
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
        if (str == null || str.length() < 0) {
            str = this.db.getUserId();
        }
        if (str != null && str.length() >= 0) {
            try {
                HashMap<String, Object> d2 = b.a(this).d(str);
                if (d2 != null && d2.size() > 0) {
                    if (!d2.containsKey("ret")) {
                        PlatformActionListener platformActionListener = this.listener;
                        if (platformActionListener != null) {
                            platformActionListener.onError(this, 8, new Throwable());
                            return;
                        }
                        return;
                    } else if (((Integer) d2.get("ret")).intValue() != 0) {
                        if (this.listener != null) {
                            this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(d2)));
                            return;
                        }
                        return;
                    } else {
                        if (str == this.db.getUserId()) {
                            this.db.put("nickname", String.valueOf(d2.get("nickname")));
                            if (d2.containsKey("figureurl_qq_2")) {
                                this.db.put("iconQQ", String.valueOf(d2.get("figureurl_qq_2")));
                            } else if (d2.containsKey("figureurl_qq_1")) {
                                this.db.put("iconQQ", String.valueOf(d2.get("figureurl_qq_1")));
                            }
                            if (d2.containsKey("figureurl_2")) {
                                this.db.put("icon", String.valueOf(d2.get("figureurl_2")));
                            } else if (d2.containsKey("figureurl_1")) {
                                this.db.put("icon", String.valueOf(d2.get("figureurl_1")));
                            } else if (d2.containsKey("figureurl")) {
                                this.db.put("icon", String.valueOf(d2.get("figureurl")));
                            }
                            this.db.put("secretType", String.valueOf(d2.get("is_yellow_vip")));
                            if (String.valueOf(d2.get("is_yellow_vip")).equals("1")) {
                                this.db.put("snsUserLevel", String.valueOf(d2.get("level")));
                            }
                            String valueOf = String.valueOf(d2.get("gender"));
                            int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_gender_male");
                            int stringRes2 = ResHelper.getStringRes(MobSDK.getContext(), "ssdk_gender_female");
                            if (valueOf.equals(MobSDK.getContext().getString(stringRes))) {
                                this.db.put("gender", "0");
                            } else if (valueOf.equals(MobSDK.getContext().getString(stringRes2))) {
                                this.db.put("gender", "1");
                            } else {
                                this.db.put("gender", "2");
                            }
                        }
                        if (this.listener != null) {
                            if (this.db.get("userTags") != null) {
                                d2.put("userTags", this.db.get("userTags"));
                            }
                            this.listener.onComplete(this, 8, d2);
                            return;
                        }
                        return;
                    }
                }
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 8, new Throwable());
                    return;
                }
                return;
            } catch (Throwable th) {
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onError(this, 8, th);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener4 = this.listener;
        if (platformActionListener4 != null) {
            platformActionListener4.onError(this, 8, new RuntimeException("qq account is null"));
        }
    }

    private void b(final Platform.ShareParams shareParams) {
        HashMap<String, Object> a;
        PlatformActionListener platformActionListener;
        String imageUrl = shareParams.getImageUrl();
        String imagePath = shareParams.getImagePath();
        boolean isShareTencentWeibo = shareParams.isShareTencentWeibo();
        try {
            if (TextUtils.isEmpty(imagePath) && !TextUtils.isEmpty(imageUrl)) {
                shareParams.setImagePath(BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl));
                doShare(shareParams);
            } else if (!isAuthValid()) {
                final PlatformActionListener platformActionListener2 = getPlatformActionListener();
                setPlatformActionListener(new PlatformActionListener() { // from class: cn.sharesdk.tencent.qzone.QZone.2
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i2) {
                        PlatformActionListener platformActionListener3 = platformActionListener2;
                        if (platformActionListener3 != null) {
                            platformActionListener3.onCancel(platform, 9);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
                        QZone.this.setPlatformActionListener(platformActionListener2);
                        QZone.this.doShare(shareParams);
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i2, Throwable th) {
                        PlatformActionListener platformActionListener3 = platformActionListener2;
                        if (platformActionListener3 != null) {
                            platformActionListener3.onError(platform, 9, th);
                        }
                    }
                });
                authorize();
            } else {
                String text = shareParams.getText();
                if (TextUtils.isEmpty(text)) {
                    PlatformActionListener platformActionListener3 = this.listener;
                    if (platformActionListener3 != null) {
                        platformActionListener3.onError(this, 9, new Throwable("share params' value of text is empty!"));
                        return;
                    }
                    return;
                }
                String shortLintk = getShortLintk(text, false);
                shareParams.setText(shortLintk);
                b a2 = b.a(this);
                if (isShareTencentWeibo) {
                    a = a2.b(imagePath, shortLintk);
                } else {
                    a = a2.a(imagePath, shortLintk);
                }
                if (a == null && (platformActionListener = this.listener) != null) {
                    platformActionListener.onError(this, 9, new Throwable("response is empty"));
                }
                a.put("ShareParams", shareParams);
                PlatformActionListener platformActionListener4 = this.listener;
                if (platformActionListener4 != null) {
                    platformActionListener4.onComplete(this, 9, a);
                }
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener5 = this.listener;
            if (platformActionListener5 != null) {
                platformActionListener5.onError(this, 9, th);
            }
        }
    }

    private void c(final Platform.ShareParams shareParams) {
        try {
            String imageUrl = shareParams.getImageUrl();
            String imagePath = shareParams.getImagePath();
            if (isClientValid()) {
                String str = (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) ? imageUrl : imagePath;
                String title = shareParams.getTitle();
                String titleUrl = shareParams.getTitleUrl();
                String site = shareParams.getSite();
                String text = shareParams.getText();
                String filePath = shareParams.getFilePath();
                int shareType = shareParams.getShareType();
                if (!TextUtils.isEmpty(text)) {
                    text = getShortLintk(text, false);
                    shareParams.setText(text);
                }
                String str2 = text;
                if (!TextUtils.isEmpty(titleUrl)) {
                    titleUrl = getShortLintk(titleUrl, false);
                    shareParams.setTitleUrl(titleUrl);
                }
                b.a(this).a(shareType, title, titleUrl, str2, str, site, filePath, shareParams.getQQMiniProgramAppid(), shareParams.getQQMiniProgramPath(), shareParams.getQQMiniProgramType(), shareParams.getImageUrl(), new PlatformActionListener() { // from class: cn.sharesdk.tencent.qzone.QZone.3
                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onCancel(Platform platform, int i2) {
                        if (((Platform) QZone.this).listener != null) {
                            ((Platform) QZone.this).listener.onCancel(QZone.this, 9);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
                        if (((Platform) QZone.this).listener != null) {
                            hashMap.put("ShareParams", shareParams);
                            ((Platform) QZone.this).listener.onComplete(QZone.this, 9, hashMap);
                        }
                    }

                    @Override // cn.sharesdk.framework.PlatformActionListener
                    public void onError(Platform platform, int i2, Throwable th) {
                        if (((Platform) QZone.this).listener != null) {
                            ((Platform) QZone.this).listener.onError(QZone.this, 9, th);
                        }
                    }
                });
                return;
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, new QQClientNotExistException());
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 9, th);
            }
        }
    }

    private void a(Platform.ShareParams shareParams) throws Throwable {
        g gVar = new g();
        gVar.a(Constants.PACKAGE_QZONE, "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
        gVar.a(shareParams, this);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("ShareParams", shareParams);
        this.listener.onComplete(this, 9, hashMap);
    }
}
