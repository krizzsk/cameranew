package cn.sharesdk.twitter;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.facebook.AccessToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.open.SocialConstants;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class Twitter extends Platform {
    public static final String NAME = "Twitter";
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f291d;

    /* loaded from: classes.dex */
    public static class ShareParams extends Platform.ShareParams {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        if (isAuthValid()) {
            c a = c.a(this);
            a.a(this.a, this.b, this.c);
            String token = this.db.getToken();
            String tokenSecret = this.db.getTokenSecret();
            if (token != null && tokenSecret != null) {
                a.a(token, tokenSecret);
                return true;
            }
        }
        if (i2 == 9 && this.f291d) {
            SSDKLog.b().w("twitter checkAuthorize ACTION_SHARE return true");
            return true;
        } else if (i2 == 9 && isClientValid() && this.f291d) {
            SSDKLog.b().w("twitter checkAuthorize ACTION_SHARE return true");
            return true;
        } else {
            innerAuthorize(i2, obj);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final c a = c.a(this);
        a.a(this.a, this.b, this.c);
        a.a(new AuthorizeListener() { // from class: cn.sharesdk.twitter.Twitter.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) Twitter.this).listener != null) {
                    ((Platform) Twitter.this).listener.onCancel(Twitter.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                try {
                    String string = bundle.getString("oauth_token");
                    String string2 = bundle.getString(FirebaseAnalytics.Param.SCREEN_NAME);
                    if (string != null && !string.equals("")) {
                        new RuntimeException("platformtools.bh").fillInStackTrace().printStackTrace();
                        String string3 = bundle.getString("oauth_token_secret");
                        String string4 = bundle.getString(AccessToken.USER_ID_KEY);
                        ((Platform) Twitter.this).db.putToken(string);
                        ((Platform) Twitter.this).db.putTokenSecret(string3);
                        ((Platform) Twitter.this).db.putUserId(string4);
                        ((Platform) Twitter.this).db.put("nickname", string2);
                        a.a(string, string3);
                        Twitter.this.afterRegister(1, null);
                    }
                    String string5 = bundle.getString("tk");
                    String string6 = bundle.getString(DeviceInfo.TAG_TIMESTAMPS);
                    String valueOf = String.valueOf(bundle.getLong(AccessToken.USER_ID_KEY, 0L));
                    ((Platform) Twitter.this).db.putToken(string5);
                    ((Platform) Twitter.this).db.putTokenSecret(string6);
                    ((Platform) Twitter.this).db.putUserId(valueOf);
                    ((Platform) Twitter.this).db.put("nickname", string2);
                    Twitter.this.afterRegister(1, null);
                } catch (Exception e2) {
                    SSDKLog.b().d(e2);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) Twitter.this).listener != null) {
                    ((Platform) Twitter.this).listener.onError(Twitter.this, 1, th);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap<String, Object> a = c.a(this).a(str, str2, hashMap, hashMap2);
            if (a != null && a.size() > 0) {
                if (!a.containsKey("error_code") && !a.containsKey("error")) {
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, i2, a);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, i2, new Throwable(new Hashon().fromHashMap(a)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, i2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, i2, th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        c a = c.a(this);
        try {
            String[] imageArray = shareParams.getImageArray();
            String imagePath = shareParams.getImagePath();
            String imageUrl = shareParams.getImageUrl();
            String text = shareParams.getText();
            String filePath = shareParams.getFilePath();
            String shortLintk = getShortLintk(shareParams.getUrl(), false);
            int shareType = shareParams.getShareType();
            HashMap<String, Object> hashMap = null;
            if (this.f291d) {
                SSDKLog.b().d("Twitter bypassApproval ", new Object[0]);
                if (imageArray != null && imageArray.length > 0) {
                    a.a(text, imageArray, this.listener);
                } else {
                    if (TextUtils.isEmpty(imagePath) && TextUtils.isEmpty(imageUrl)) {
                        if (!TextUtils.isEmpty(text)) {
                            a.a(text, this.listener);
                        } else {
                            PlatformActionListener platformActionListener = this.listener;
                            if (platformActionListener != null) {
                                platformActionListener.onError(this, 9, new Throwable("Please set params"));
                                return;
                            }
                        }
                    }
                    a.a(text, imagePath, imageUrl, this.listener);
                }
            } else if (shareType == 6 && !TextUtils.isEmpty(filePath)) {
                hashMap = a.f(text, filePath);
            } else if (imageArray != null && imageArray.length > 0) {
                hashMap = a.a(text, imageArray);
            } else if (!TextUtils.isEmpty(imagePath) && new File(imagePath).exists()) {
                hashMap = a.e(text, imagePath);
            } else if (!TextUtils.isEmpty(imageUrl)) {
                String downloadBitmap = BitmapHelper.downloadBitmap(MobSDK.getContext(), imageUrl);
                if (new File(downloadBitmap).exists()) {
                    hashMap = a.e(text, downloadBitmap);
                }
            } else if (!TextUtils.isEmpty(shortLintk)) {
                hashMap = a.e(shortLintk);
            } else {
                hashMap = a.e(text);
            }
            if (hashMap == null) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 8, new Throwable("response is null"));
                }
            } else if (!hashMap.containsKey("error_code") && !hashMap.containsKey("error")) {
                hashMap.put("ShareParams", shareParams);
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onComplete(this, 9, hashMap);
                }
            } else if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(hashMap)));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 9, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap) {
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (i2 == 2) {
            hashMap2.put("type", "FOLLOWING");
        } else if (i2 == 10) {
            hashMap2.put("type", "FRIENDS");
        } else if (i2 != 11) {
            return null;
        } else {
            hashMap2.put("type", "FOLLOWERS");
        }
        hashMap2.put("snsplat", Integer.valueOf(getPlatformId()));
        hashMap2.put("snsuid", this.db.getUserId());
        String valueOf = hashMap.containsKey("next_cursor") ? String.valueOf(hashMap.get("next_cursor")) : null;
        Object obj = hashMap.get("users");
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        if (arrayList2.size() <= 0) {
            return null;
        }
        Iterator it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            HashMap hashMap3 = (HashMap) it.next();
            if (hashMap3 != null) {
                HashMap hashMap4 = new HashMap();
                hashMap4.put("snsuid", String.valueOf(hashMap3.get(TapjoyAuctionFlags.AUCTION_ID)));
                hashMap4.put("nickname", String.valueOf(hashMap3.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                hashMap4.put("icon", String.valueOf(hashMap3.get("profile_image_url")));
                hashMap4.put("gender", "2");
                hashMap4.put("resume", String.valueOf(hashMap3.get(SocialConstants.PARAM_COMMENT)));
                hashMap4.put("secretType", "true".equals(String.valueOf(hashMap3.get("verified"))) ? "1" : "0");
                hashMap4.put("followerCount", String.valueOf(hashMap3.get("followers_count")));
                hashMap4.put("favouriteCount", String.valueOf(hashMap3.get("friends_count")));
                hashMap4.put("shareCount", String.valueOf(hashMap3.get("statuses_count")));
                hashMap4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(hashMap3.get("created_at")))));
                hashMap4.put("snsUserUrl", "https://twitter.com/" + hashMap3.get(FirebaseAnalytics.Param.SCREEN_NAME));
                arrayList.add(hashMap4);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        String str = valueOf + "_false";
        hashMap2.put("nextCursor", (TextUtils.isEmpty(valueOf) || "0".equals(valueOf)) ? "0_true" : "0_true");
        hashMap2.put("list", arrayList);
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        ArrayList arrayList;
        f.a aVar = new f.a();
        aVar.b = shareParams.getText();
        if (hashMap != null) {
            HashMap hashMap2 = (HashMap) hashMap.get("entities");
            if (hashMap2 != null && (arrayList = (ArrayList) hashMap2.get("media")) != null && arrayList.size() > 0 && ((HashMap) arrayList.get(0)) != null) {
                aVar.f98d.add(String.valueOf(hashMap.get("media_url")));
            }
            aVar.a = String.valueOf(hashMap.get(TapjoyAuctionFlags.AUCTION_ID));
            aVar.f101g = hashMap;
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
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        c a = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> c = a.c(userId, str);
            if (c != null && c.size() > 0 && !c.containsKey("error_code") && !c.containsKey("error")) {
                return filterFriendshipInfo(11, c);
            }
            return null;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i2, int i3, String str) {
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId)) {
            return null;
        }
        c a = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> b = a.b(userId, str);
            if (b != null && b.size() > 0 && !b.containsKey("error_code") && !b.containsKey("error")) {
                return filterFriendshipInfo(2, b);
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
        PlatformActionListener platformActionListener;
        String userId = TextUtils.isEmpty(null) ? this.db.getUserId() : null;
        if (TextUtils.isEmpty(userId)) {
            userId = this.db.getUserName();
        }
        if (TextUtils.isEmpty(userId) && (platformActionListener = this.listener) != null) {
            platformActionListener.onError(this, 2, new Throwable("The account do not authorize!"));
        }
        c a = c.a(this);
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            HashMap<String, Object> b = a.b(userId, str);
            if (b != null && b.size() > 0) {
                if (!b.containsKey("error_code") && !b.containsKey("error")) {
                    PlatformActionListener platformActionListener2 = this.listener;
                    if (platformActionListener2 != null) {
                        platformActionListener2.onComplete(this, 2, b);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(b)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 2, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener4 = this.listener;
            if (platformActionListener4 != null) {
                platformActionListener4.onError(this, 2, th);
            }
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 11;
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
        this.a = getDevinfo("ConsumerKey");
        this.b = getDevinfo("ConsumerSecret");
        this.c = getDevinfo("CallbackUrl");
        this.f291d = "true".equals(getDevinfo("BypassApproval"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        try {
            return !TextUtils.isEmpty(MobSDK.getContext().getPackageManager().getPackageInfo("com.twitter.android", 0).versionName);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo("consumer_key", "ConsumerKey");
        this.b = getNetworkDevinfo("consumer_secret", "ConsumerSecret");
        this.c = getNetworkDevinfo(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, "CallbackUrl");
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
        try {
            HashMap<String, Object> d2 = c.a(this).d(str);
            if (d2 != null && d2.size() > 0) {
                if (!d2.containsKey("error_code") && !d2.containsKey("error")) {
                    if (str == null) {
                        this.db.put("nickname", String.valueOf(d2.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                        this.db.put("icon", String.valueOf(d2.get("profile_image_url")));
                        this.db.put("gender", "2");
                        this.db.put("resume", String.valueOf(d2.get(SocialConstants.PARAM_COMMENT)));
                        this.db.put("secretType", "true".equals(String.valueOf(d2.get("verified"))) ? "1" : "0");
                        this.db.put("followerCount", String.valueOf(d2.get("followers_count")));
                        this.db.put("favouriteCount", String.valueOf(d2.get("friends_count")));
                        this.db.put("shareCount", String.valueOf(d2.get("statuses_count")));
                        this.db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(d2.get("created_at")))));
                        this.db.put("snsUserUrl", "https://twitter.com/" + d2.get(FirebaseAnalytics.Param.SCREEN_NAME));
                    }
                    PlatformActionListener platformActionListener = this.listener;
                    if (platformActionListener != null) {
                        platformActionListener.onComplete(this, 8, d2);
                        return;
                    }
                    return;
                }
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(d2)));
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, 8, new Throwable("response is null"));
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener3 = this.listener;
            if (platformActionListener3 != null) {
                platformActionListener3.onError(this, 8, th);
            }
        }
    }
}
