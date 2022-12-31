package cn.sharesdk.framework;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import cn.sharesdk.framework.b.b.f;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    protected static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    protected static final int ACTION_GETTING_BILATERAL_LIST = 10;
    protected static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int GGP_REFUSE = 21;
    public static final int INSTAGRAM_FRIEND = 13;
    public static final int KAKAO_COMMERCE_TEMPLATE = 18;
    public static final int KAKAO_CUSTOM_TEMPLATE = 20;
    public static final int KAKAO_FEED_TEMPLATE = 16;
    public static final int KAKAO_TEXT_TEMPLATE = 19;
    public static final int KAKAO_URL_TEMPLATE = 17;
    public static final int OPEN_WXMINIPROGRAM = 12;
    public static final int QQ_MINI_PROGRAM = 15;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_LINKCARD = 14;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;
    public static final int SHARE_WXMINIPROGRAM = 11;
    public static final int SHARE_ZHIFUBAO = 10;
    private f a;
    protected final PlatformDb db;
    protected PlatformActionListener listener;
    protected final PlatformActionListener uIListener = new PlatformActionListener() { // from class: cn.sharesdk.framework.Platform.1
        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onCancel(final Platform platform, final int i2) {
            if (Platform.this.listener == null) {
                return;
            }
            try {
                if (cn.sharesdk.framework.utils.a.a()) {
                    Platform.this.listener.onCancel(platform, i2);
                } else {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.3
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            Platform.this.listener.onCancel(platform, i2);
                            return false;
                        }
                    });
                }
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onComplete(final Platform platform, final int i2, final HashMap<String, Object> hashMap) {
            if (Platform.this.listener == null) {
                return;
            }
            try {
                if (cn.sharesdk.framework.utils.a.a()) {
                    Platform.this.listener.onComplete(platform, i2, hashMap);
                } else {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.2
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            Platform.this.listener.onComplete(platform, i2, hashMap);
                            return false;
                        }
                    });
                }
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onError(final Platform platform, final int i2, final Throwable th) {
            if (Platform.this.listener == null) {
                return;
            }
            try {
                if (cn.sharesdk.framework.utils.a.a()) {
                    Platform.this.listener.onError(platform, i2, th);
                } else {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.framework.Platform.1.1
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            Platform.this.listener.onError(platform, i2, th);
                            return false;
                        }
                    });
                }
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
            }
        }
    };

    /* loaded from: classes.dex */
    public static class ShareParams extends InnerShareParams {
        public ShareParams() {
        }

        public ShareParams(HashMap<String, Object> hashMap) {
            super(hashMap);
        }

        public ShareParams(String str) {
            super(str);
        }
    }

    public Platform() {
        f fVar = new f(this);
        this.a = fVar;
        this.db = fVar.g();
        this.listener = this.a.i();
    }

    public void SSOSetting(boolean z) {
        this.a.a(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a.a(false);
        this.a.a(getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterRegister(int i2, Object obj) {
        this.a.b(i2, obj);
    }

    public void authorize() {
        authorize(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.a.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean checkAuthorize(int i2, Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyDevinfo(String str, String str2) {
        ShareSDK.a(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copyNetworkDevinfo(int i2, int i3) {
        ShareSDK.a(i2, i3);
    }

    public void customerProtocol(String str, String str2, short s, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2) {
        this.a.a(str, str2, s, hashMap, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doAuthorize(String[] strArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doCustomerProtocol(String str, String str2, int i2, HashMap<String, Object> hashMap, HashMap<String, String> hashMap2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doShare(ShareParams shareParams);

    protected abstract HashMap<String, Object> filterFriendshipInfo(int i2, HashMap<String, Object> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract f.a filterShareContent(ShareParams shareParams, HashMap<String, Object> hashMap);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void follow(String str);

    public void followFriend(String str) {
        this.a.b(str);
    }

    protected abstract HashMap<String, Object> getBilaterals(int i2, int i3, String str);

    public PlatformDb getDb() {
        return this.db;
    }

    public String getDevinfo(String str) {
        return getDevinfo(getName(), str);
    }

    protected abstract HashMap<String, Object> getFollowers(int i2, int i3, String str);

    protected abstract HashMap<String, Object> getFollowings(int i2, int i3, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void getFriendList(int i2, int i3, String str);

    public int getId() {
        return this.a.a();
    }

    public abstract String getName();

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNetworkDevinfo(String str, String str2) {
        return getNetworkDevinfo(getPlatformId(), str, str2);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.a.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getPlatformId();

    public String getShortLintk(String str, boolean z) {
        return this.a.a(str, z);
    }

    public int getSortId() {
        return this.a.b();
    }

    public void getTimeLine(String str, int i2, int i3) {
        this.a.a(str, i2, i3);
    }

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void initDevInfo(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void innerAuthorize(int i2, Object obj) {
        this.a.a(i2, obj);
    }

    public boolean isAuthValid() {
        return this.a.d();
    }

    public boolean isClientValid() {
        return false;
    }

    public boolean isSSODisable() {
        return this.a.e();
    }

    public void listFriend(int i2, int i3, String str) {
        this.a.a(i2, i3, str);
    }

    public void removeAccount(boolean z) {
        this.a.h();
        ShareSDK.removeCookieOnAuthorize(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void setNetworkDevinfo();

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.a.a(platformActionListener);
    }

    public void share(ShareParams shareParams) {
        this.a.b(shareParams);
    }

    public void showUser(String str) {
        this.a.c(str);
    }

    public void subscribeAuth(ShareParams shareParams) {
        this.a.a(shareParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void timeline(int i2, int i3, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public String uploadImageToFileServer(String str) {
        return this.a.d(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void userInfor(String str);

    public void authorize(String[] strArr) {
        this.a.a(strArr);
    }

    public String getDevinfo(String str, String str2) {
        return ShareSDK.getDevinfo(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNetworkDevinfo(int i2, String str, String str2) {
        return this.a.a(i2, str, str2);
    }

    protected String uploadImageToFileServer(Bitmap bitmap) {
        return this.a.a(bitmap);
    }
}
