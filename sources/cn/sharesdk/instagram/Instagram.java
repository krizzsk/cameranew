package cn.sharesdk.instagram;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.tapjoy.TapjoyAuctionFlags;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class Instagram extends Platform {
    public static final String NAME = "Instagram";
    private String a;
    private String b;
    private String c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        b a = b.a(this);
        if (i2 == 9) {
            if (isClientValid()) {
                return true;
            }
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 9, new InstagramClientNotExistException());
            }
            return false;
        } else if (isAuthValid()) {
            a.a(this.a, this.b, this.c);
            a.b(this.db.getToken());
            return true;
        } else {
            innerAuthorize(i2, obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final b a = b.a(this);
        a.a(this.a, this.b, this.c);
        a.a(strArr);
        a.a(new AuthorizeListener() { // from class: cn.sharesdk.instagram.Instagram.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) Instagram.this).listener != null) {
                    ((Platform) Instagram.this).listener.onCancel(Instagram.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                String string = bundle.getString("access_token");
                String string2 = bundle.getString("username");
                String string3 = bundle.getString("bio");
                String string4 = bundle.getString("website");
                String string5 = bundle.getString("profile_picture");
                String string6 = bundle.getString("full_name");
                String string7 = bundle.getString(TapjoyAuctionFlags.AUCTION_ID);
                ((Platform) Instagram.this).db.putToken(string);
                ((Platform) Instagram.this).db.putUserId(string7);
                ((Platform) Instagram.this).db.put("nickname", string2);
                ((Platform) Instagram.this).db.put("resume", string3);
                ((Platform) Instagram.this).db.put("website", string4);
                ((Platform) Instagram.this).db.put("icon", string5);
                ((Platform) Instagram.this).db.put("full_name", string6);
                a.b(string);
                Instagram.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) Instagram.this).listener != null) {
                    ((Platform) Instagram.this).listener.onError(Instagram.this, 1, th);
                }
            }
        });
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
    public void doShare(final Platform.ShareParams shareParams) {
        PlatformActionListener platformActionListener = new PlatformActionListener() { // from class: cn.sharesdk.instagram.Instagram.2
            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onCancel(Platform platform, int i2) {
                if (((Platform) Instagram.this).listener != null) {
                    ((Platform) Instagram.this).listener.onCancel(platform, i2);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onComplete(Platform platform, int i2, HashMap<String, Object> hashMap) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                if (hashMap != null) {
                    hashMap2.putAll(hashMap);
                }
                hashMap2.put("ShareParams", shareParams);
                if (((Platform) Instagram.this).listener != null) {
                    ((Platform) Instagram.this).listener.onComplete(platform, i2, hashMap2);
                }
            }

            @Override // cn.sharesdk.framework.PlatformActionListener
            public void onError(Platform platform, int i2, Throwable th) {
                if (((Platform) Instagram.this).listener != null) {
                    ((Platform) Instagram.this).listener.onError(platform, i2, th);
                }
            }
        };
        b a = b.a(this);
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        String filePath = shareParams.getFilePath();
        String text = shareParams.getText();
        int shareType = shareParams.getShareType();
        if (shareType == 13) {
            try {
                a.a(this, shareParams, platformActionListener);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (shareType == 6 && !TextUtils.isEmpty(filePath)) {
            a.a(filePath, null, text, platformActionListener);
        } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
            a.a(imagePath, imageUrl, text, platformActionListener);
        } else {
            if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
                imagePath = filePath;
            }
            a.a(imagePath, imageUrl, text, platformActionListener);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (2 == i2) {
            hashMap2.put("type", "FOLLOWING");
        } else {
            hashMap2.put("type", "FOLLOWERS");
        }
        hashMap2.put("snsplat", Integer.valueOf(getPlatformId()));
        hashMap2.put("snsuid", this.db.getUserId());
        Object obj = hashMap.get("data");
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            HashMap hashMap3 = (HashMap) it.next();
            if (hashMap3 != null) {
                HashMap hashMap4 = new HashMap();
                String valueOf = String.valueOf(hashMap3.get("username"));
                hashMap4.put("snsuid", String.valueOf(hashMap3.get(TapjoyAuctionFlags.AUCTION_ID)));
                hashMap4.put("nickname", valueOf);
                hashMap4.put("snsUserUrl", "http://instagram.com/" + valueOf + "/#");
                hashMap4.put("icon", String.valueOf(hashMap3.get("profile_picture")));
                hashMap4.put("gender", "2");
                arrayList.add(hashMap4);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        hashMap2.put("nextCursor", "0_true");
        hashMap2.put("list", arrayList);
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (!TextUtils.isEmpty(imagePath)) {
            aVar.f99e.add(imagePath);
        } else if (!TextUtils.isEmpty(imageUrl)) {
            aVar.f98d.add(imageUrl);
        }
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
        HashMap<String, Object> e2;
        try {
            if (TextUtils.isEmpty(str)) {
                str = this.db.getUserId();
            }
            if (TextUtils.isEmpty(str)) {
                str = this.db.get("nickname");
            }
            if (!TextUtils.isEmpty(str) && (e2 = b.a(this).e(str)) != null && e2.size() > 0) {
                return filterFriendshipInfo(11, e2);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i2, int i3, String str) {
        HashMap<String, Object> d2;
        try {
            if (TextUtils.isEmpty(str)) {
                str = this.db.getUserId();
            }
            if (TextUtils.isEmpty(str)) {
                str = this.db.get("nickname");
            }
            if (!TextUtils.isEmpty(str) && (d2 = b.a(this).d(str)) != null && d2.size() > 0) {
                return filterFriendshipInfo(2, d2);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 15;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("ClientId");
        this.b = getDevinfo("ClientSecret");
        this.c = getDevinfo("RedirectUri");
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return b.a(this).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo("client_id", "ClientId");
        this.b = getNetworkDevinfo("client_secret", "ClientSecret");
        this.c = getNetworkDevinfo(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, "RedirectUri");
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
        HashMap hashMap;
        if (ShareSDK.isFBInstagram()) {
            try {
                HashMap<String, Object> c = b.a(this).c(str);
                if (c != null && c.size() > 0) {
                    String valueOf = String.valueOf(c.get(TapjoyAuctionFlags.AUCTION_ID));
                    if (!TextUtils.isEmpty(valueOf)) {
                        this.db.putUserId(valueOf);
                    }
                    String valueOf2 = String.valueOf(c.get("username"));
                    if (!TextUtils.isEmpty(valueOf2)) {
                        this.db.put("username", valueOf2);
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, c);
                        return;
                    }
                    return;
                }
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 8, new Throwable("Instagram userInfor resultInfo is empty"));
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
        boolean z = false;
        if (str == null || str.length() < 0) {
            str = this.db.getUserId();
            z = true;
        }
        if (str != null && str.length() >= 0) {
            try {
                HashMap<String, Object> c2 = b.a(this).c(str);
                if (c2 != null && c2.size() > 0) {
                    if (z && (hashMap = (HashMap) c2.get("data")) != null && hashMap.size() > 0) {
                        this.db.put("resume", String.valueOf(hashMap.get("bio")));
                        this.db.put("icon", String.valueOf(hashMap.get("profile_picture")));
                        String valueOf3 = String.valueOf(hashMap.get("username"));
                        this.db.put("nickname", valueOf3);
                        PlatformDb platformDb = this.db;
                        platformDb.put("snsUserUrl", "http://instagram.com/" + valueOf3 + "/#");
                        HashMap hashMap2 = (HashMap) hashMap.get("counts");
                        if (hashMap2 != null && hashMap2.size() > 0) {
                            this.db.put("followerCount", String.valueOf(hashMap2.get("followed_by")));
                            this.db.put("favouriteCount", String.valueOf(hashMap2.get("follows")));
                            this.db.put("shareCount", String.valueOf(hashMap2.get("media")));
                        }
                    }
                    PlatformActionListener platformActionListener4 = this.listener;
                    if (platformActionListener4 != null) {
                        platformActionListener4.onComplete(this, 8, c2);
                        return;
                    }
                    return;
                }
                PlatformActionListener platformActionListener5 = this.listener;
                if (platformActionListener5 != null) {
                    platformActionListener5.onError(this, 8, new Throwable());
                    return;
                }
                return;
            } catch (Throwable th2) {
                PlatformActionListener platformActionListener6 = this.listener;
                if (platformActionListener6 != null) {
                    platformActionListener6.onError(this, 8, th2);
                    return;
                }
                return;
            }
        }
        PlatformActionListener platformActionListener7 = this.listener;
        if (platformActionListener7 != null) {
            platformActionListener7.onError(this, 8, new RuntimeException("Instagram account is null"));
        }
    }
}
