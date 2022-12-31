package cn.sharesdk.sina.weibo;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.tapjoy.TapjoyAuctionFlags;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SinaWeibo extends Platform {
    public static final String NAME = "SinaWeibo";
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f223d;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i2, Object obj) {
        i a = i.a(this);
        a.c(this.db.getToken());
        a.a(this.a, this.b);
        a.a(this.c);
        a.d();
        if (i2 == 9 || isAuthValid() || c()) {
            return true;
        }
        innerAuthorize(i2, obj);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        final i a = i.a(this);
        a.a(this.a, this.b);
        a.a(this.c);
        a.a(strArr);
        a.a(new AuthorizeListener() { // from class: cn.sharesdk.sina.weibo.SinaWeibo.1
            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onCancel() {
                if (((Platform) SinaWeibo.this).listener != null) {
                    ((Platform) SinaWeibo.this).listener.onCancel(SinaWeibo.this, 1);
                }
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onComplete(Bundle bundle) {
                long j2;
                String string = bundle.getString("uid");
                String string2 = bundle.getString("access_token");
                String string3 = bundle.getString("expires_in");
                String string4 = bundle.getString("refresh_token");
                if (bundle.containsKey("username")) {
                    ((Platform) SinaWeibo.this).db.put("nickname", bundle.getString("userName"));
                }
                ((Platform) SinaWeibo.this).db.putToken(string2);
                try {
                    j2 = ResHelper.parseLong(string3);
                } catch (Throwable unused) {
                    j2 = 0;
                }
                ((Platform) SinaWeibo.this).db.putExpiresIn(j2);
                ((Platform) SinaWeibo.this).db.put("refresh_token", string4);
                ((Platform) SinaWeibo.this).db.putUserId(string);
                a.c(string2);
                SinaWeibo.this.afterRegister(1, null);
            }

            @Override // cn.sharesdk.framework.authorize.AuthorizeListener
            public void onError(Throwable th) {
                if (((Platform) SinaWeibo.this).listener != null) {
                    ((Platform) SinaWeibo.this).listener.onError(SinaWeibo.this, 1, th);
                }
            }
        }, isSSODisable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        try {
            HashMap<String, Object> a = i.a(this).a(str, str2, hashMap, hashMap2);
            if (a != null && a.size() > 0) {
                if (a.containsKey("error_code") && ((Integer) a.get("error_code")).intValue() != 0) {
                    if (this.listener != null) {
                        this.listener.onError(this, i2, new Throwable(new Hashon().fromHashMap(a)));
                        return;
                    }
                    return;
                }
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onComplete(this, i2, a);
                    return;
                }
                return;
            }
            PlatformActionListener platformActionListener2 = this.listener;
            if (platformActionListener2 != null) {
                platformActionListener2.onError(this, i2, new Throwable());
            }
        } catch (Throwable th) {
            this.listener.onError(this, i2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doShare(Platform.ShareParams shareParams) {
        i a = i.a(this);
        a.a(this.a, this.b);
        if (this.f223d && a.b()) {
            try {
                String lcSummary = shareParams.getLcSummary();
                JSONObject lcImage = shareParams.getLcImage();
                String lcObjectType = shareParams.getLcObjectType();
                String lcDisplayName = shareParams.getLcDisplayName();
                String lcCreateAt = shareParams.getLcCreateAt();
                String lcUrl = shareParams.getLcUrl();
                if (cn.sharesdk.framework.b.a.e.a().h() && lcSummary != null && lcImage != null && lcObjectType != null && lcDisplayName != null && lcCreateAt != null && lcUrl != null) {
                    HashMap<String, Object> a2 = a.a().a(lcSummary, lcImage, lcObjectType, lcDisplayName, lcCreateAt, lcUrl);
                    if (a2 != null && a2.containsKey("error") && this.listener != null) {
                        this.listener.onError(this, 9, new Throwable("error: " + a2.get("error")));
                    } else if (a2.size() > 0 && a2.get("url") != null) {
                        String valueOf = String.valueOf(a2.get("url"));
                        String text = shareParams.getText();
                        shareParams.setText(text + valueOf);
                        a.a(shareParams, this.listener);
                        b.a().a(2);
                    }
                } else {
                    a.a(shareParams, this.listener);
                    b.a().a(3);
                }
                return;
            } catch (Throwable th) {
                this.listener.onError(this, 9, th);
                return;
            }
        }
        try {
            a.b(shareParams, this.listener);
        } catch (Throwable th2) {
            this.listener.onError(this, 9, th2);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap) {
        Object obj;
        StringBuilder sb;
        StringBuilder sb2;
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
        int parseInt = Integer.parseInt(String.valueOf(hashMap.get("current_cursor")));
        int parseInt2 = Integer.parseInt(String.valueOf(hashMap.get("total_number")));
        if (parseInt2 == 0 || (obj = hashMap.get("users")) == null) {
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
                hashMap4.put("snsuid", String.valueOf(hashMap3.get(TapjoyAuctionFlags.AUCTION_ID)));
                hashMap4.put("nickname", String.valueOf(hashMap3.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                hashMap4.put("icon", String.valueOf(hashMap3.get("avatar_hd")));
                if (String.valueOf(hashMap3.get("verified")).equals("true")) {
                    hashMap4.put("secretType", "1");
                } else {
                    hashMap4.put("secretType", "0");
                }
                hashMap4.put("secret", String.valueOf(hashMap3.get("verified_reason")));
                String valueOf = String.valueOf(hashMap3.get("gender"));
                if (valueOf.equals("m")) {
                    hashMap4.put("gender", "0");
                } else if (valueOf.equals("f")) {
                    hashMap4.put("gender", "1");
                } else {
                    hashMap4.put("gender", "2");
                }
                hashMap4.put("snsUserUrl", "http://weibo.com/" + String.valueOf(hashMap3.get("profile_url")));
                hashMap4.put("resume", String.valueOf(hashMap3.get(SocialConstants.PARAM_COMMENT)));
                hashMap4.put("followerCount", String.valueOf(hashMap3.get("followers_count")));
                hashMap4.put("favouriteCount", String.valueOf(hashMap3.get("friends_count")));
                hashMap4.put("shareCount", String.valueOf(hashMap3.get("statuses_count")));
                hashMap4.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(hashMap3.get("created_at")))));
                arrayList.add(hashMap4);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        if (10 == i2) {
            int i3 = parseInt + 1;
            if (((Integer) hashMap.get("page_count")).intValue() * i3 >= parseInt2) {
                sb2 = new StringBuilder();
                sb2.append(parseInt);
                sb2.append("_true");
            } else {
                sb2 = new StringBuilder();
                sb2.append(i3);
                sb2.append("_false");
            }
            hashMap2.put("nextCursor", sb2.toString());
        } else {
            int size = parseInt + arrayList.size();
            if (size >= parseInt2) {
                sb = new StringBuilder();
                sb.append(parseInt2);
                sb.append("_true");
            } else {
                sb = new StringBuilder();
                sb.append(size);
                sb.append("_false");
            }
            hashMap2.put("nextCursor", sb.toString());
        }
        hashMap2.put("list", arrayList);
        return hashMap2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> hashMap) {
        f.a aVar = new f.a();
        aVar.b = shareParams.getText();
        if (hashMap != null) {
            aVar.a = String.valueOf(hashMap.get(TapjoyAuctionFlags.AUCTION_ID));
            aVar.f98d.add(String.valueOf(hashMap.get("original_pic")));
            aVar.f101g = hashMap;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        try {
            HashMap<String, Object> e2 = i.a(this).e(str);
            if (e2 == null) {
                PlatformActionListener platformActionListener = this.listener;
                if (platformActionListener != null) {
                    platformActionListener.onError(this, 6, new Throwable());
                }
            } else if (e2.containsKey("error_code") && ((Integer) e2.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 6, new Throwable(new Hashon().fromHashMap(e2)));
                }
            } else {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onComplete(this, 6, e2);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 6, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getBilaterals(int i2, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> c = i.a(this).c(i2, i3, str);
            if (c == null || c.containsKey("error_code")) {
                return null;
            }
            c.put("page_count", Integer.valueOf(i2));
            c.put("current_cursor", Integer.valueOf(i3));
            return filterFriendshipInfo(10, c);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowers(int i2, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> d2 = i.a(this).d(i2, i3, str);
            if (d2 == null || d2.containsKey("error_code")) {
                return null;
            }
            d2.put("current_cursor", Integer.valueOf(i3));
            return filterFriendshipInfo(11, d2);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    @Override // cn.sharesdk.framework.Platform
    protected HashMap<String, Object> getFollowings(int i2, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HashMap<String, Object> b = i.a(this).b(i2, i3, str);
            if (b == null || b.containsKey("error_code")) {
                return null;
            }
            b.put("current_cursor", Integer.valueOf(i3));
            return filterFriendshipInfo(2, b);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i2, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 2, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> b = i.a(this).b(i2, i3, str);
            if (b == null) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 2, new Throwable());
                }
            } else if (b.containsKey("error_code") && ((Integer) b.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 2, new Throwable(new Hashon().fromHashMap(b)));
                }
            } else {
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onComplete(this, 2, b);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 2, th);
        }
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
        this.a = getDevinfo("AppKey");
        this.b = getDevinfo("AppSecret");
        this.c = getDevinfo("RedirectUrl");
        this.f223d = !"false".equals(getDevinfo("ShareByAppClient"));
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean isClientValid() {
        return i.a(this).b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
        this.a = getNetworkDevinfo("app_key", "AppKey");
        this.b = getNetworkDevinfo("app_secret", "AppSecret");
        this.c = getNetworkDevinfo(ParamKeyConstants.WebViewConstants.QUERY_REDIRECT_URI, "RedirectUrl");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i2, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        }
        if (TextUtils.isEmpty(str)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 7, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> a = i.a(this).a(i2, i3, str);
            if (a == null) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 7, new Throwable());
                }
            } else if (a.containsKey("error_code") && ((Integer) a.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 7, new Throwable(new Hashon().fromHashMap(a)));
                }
            } else {
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onComplete(this, 7, a);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 7, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(str)) {
            str = this.db.getUserId();
            z = true;
        } else {
            z = false;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.db.get("nickname");
        } else {
            z2 = z;
        }
        if (TextUtils.isEmpty(str)) {
            PlatformActionListener platformActionListener = this.listener;
            if (platformActionListener != null) {
                platformActionListener.onError(this, 8, new RuntimeException("Both weibo id and screen_name are null"));
                return;
            }
            return;
        }
        try {
            HashMap<String, Object> d2 = i.a(this).d(str);
            if (d2 == null) {
                PlatformActionListener platformActionListener2 = this.listener;
                if (platformActionListener2 != null) {
                    platformActionListener2.onError(this, 8, new Throwable());
                }
            } else if (d2.containsKey("error_code") && ((Integer) d2.get("error_code")).intValue() != 0) {
                if (this.listener != null) {
                    this.listener.onError(this, 8, new Throwable(new Hashon().fromHashMap(d2)));
                }
            } else {
                if (z2) {
                    this.db.putUserId(String.valueOf(d2.get(TapjoyAuctionFlags.AUCTION_ID)));
                    this.db.put("nickname", String.valueOf(d2.get(FirebaseAnalytics.Param.SCREEN_NAME)));
                    this.db.put("icon", String.valueOf(d2.get("avatar_hd")));
                    if (String.valueOf(d2.get("verified")).equals("true")) {
                        this.db.put("secretType", "1");
                    } else {
                        this.db.put("secretType", "0");
                    }
                    this.db.put("secret", String.valueOf(d2.get("verified_reason")));
                    String valueOf = String.valueOf(d2.get("gender"));
                    if (valueOf.equals("m")) {
                        this.db.put("gender", "0");
                    } else if (valueOf.equals("f")) {
                        this.db.put("gender", "1");
                    } else {
                        this.db.put("gender", "2");
                    }
                    PlatformDb platformDb = this.db;
                    platformDb.put("snsUserUrl", "http://weibo.com/" + String.valueOf(d2.get("profile_url")));
                    this.db.put("resume", String.valueOf(d2.get(SocialConstants.PARAM_COMMENT)));
                    this.db.put("followerCount", String.valueOf(d2.get("followers_count")));
                    this.db.put("favouriteCount", String.valueOf(d2.get("friends_count")));
                    this.db.put("shareCount", String.valueOf(d2.get("statuses_count")));
                    this.db.put("snsregat", String.valueOf(ResHelper.dateToLong(String.valueOf(d2.get("created_at")))));
                }
                PlatformActionListener platformActionListener3 = this.listener;
                if (platformActionListener3 != null) {
                    platformActionListener3.onComplete(this, 8, d2);
                }
            }
        } catch (Throwable th) {
            this.listener.onError(this, 8, th);
        }
    }

    private boolean c() {
        if (TextUtils.isEmpty(getDb().get("refresh_token"))) {
            return false;
        }
        i a = i.a(this);
        a.a(this.a, this.b);
        a.a(this.c);
        return a.a();
    }
}
