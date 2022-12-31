package us.pinguo.user;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Time;
import androidx.core.app.NotificationCompat;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.user.api.ApiRefreshToken;
import us.pinguo.user.api.UserInfoResponse;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.y0;
/* loaded from: classes6.dex */
public class User implements Cloneable {
    private static String c = null;

    /* renamed from: d  reason: collision with root package name */
    private static y0.b f12358d = null;

    /* renamed from: e  reason: collision with root package name */
    private static y0.c f12359e = null;

    /* renamed from: f  reason: collision with root package name */
    private static User f12360f = null;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f12361g = new byte[0];

    /* renamed from: h  reason: collision with root package name */
    private static z0 f12362h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f12363i = "user_start_time";
    private Info a;
    public long b = -1;

    /* loaded from: classes6.dex */
    public static class Info implements Cloneable {
        public String avatar;
        public String backgroundPic;
        public String birthday;
        public int certificated;
        public String city;
        public String country;
        public String description;
        public String email;
        public boolean firstLogin;
        public int forgetPass;
        public String gender;
        public String language;
        public long lastLoginTime;
        public String loginmode;
        public int mark;
        public String mobile;
        public String nickname;
        public String province;
        public long regDateTime;
        public int setPass;
        public ThirdSites third;
        public String token;
        public String userId;
        public y0.c vipInfo;

        /* loaded from: classes6.dex */
        public static class ThirdSites implements Cloneable {
            public FacebookSite facebook;
            public HuaweiSite huawei;
            public QQSite qzone;
            public SinaSite sina;
            public TwitterSite twitter;
            public WechatSite wechat;

            /* loaded from: classes6.dex */
            public static class FacebookSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            /* loaded from: classes6.dex */
            public static class HuaweiSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            /* loaded from: classes6.dex */
            public static class QQSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            /* loaded from: classes6.dex */
            public static class SinaSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            /* loaded from: classes6.dex */
            public static class TwitterSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            /* loaded from: classes6.dex */
            public static class WechatSite implements Cloneable {
                public long addTime;
                public String avatar;
                public String id;
                public String nickname;

                protected Object clone() throws CloneNotSupportedException {
                    return super.clone();
                }
            }

            protected Object clone() throws CloneNotSupportedException {
                ThirdSites thirdSites = (ThirdSites) super.clone();
                QQSite qQSite = this.qzone;
                if (qQSite != null) {
                    thirdSites.qzone = (QQSite) qQSite.clone();
                }
                SinaSite sinaSite = this.sina;
                if (sinaSite != null) {
                    thirdSites.sina = (SinaSite) sinaSite.clone();
                }
                FacebookSite facebookSite = this.facebook;
                if (facebookSite != null) {
                    thirdSites.facebook = (FacebookSite) facebookSite.clone();
                }
                TwitterSite twitterSite = this.twitter;
                if (twitterSite != null) {
                    thirdSites.twitter = (TwitterSite) twitterSite.clone();
                }
                WechatSite wechatSite = this.wechat;
                if (wechatSite != null) {
                    thirdSites.wechat = (WechatSite) wechatSite.clone();
                }
                HuaweiSite huaweiSite = this.huawei;
                if (huaweiSite != null) {
                    thirdSites.huawei = (HuaweiSite) huaweiSite.clone();
                }
                return thirdSites;
            }
        }

        protected Object clone() throws CloneNotSupportedException {
            Info info = (Info) super.clone();
            ThirdSites thirdSites = this.third;
            if (thirdSites != null) {
                info.third = (ThirdSites) thirdSites.clone();
            }
            return info;
        }
    }

    private User() {
        String c2 = y0.c(us.pinguo.foundation.e.b());
        us.pinguo.common.log.a.k("user->gsonResult->" + c2, new Object[0]);
        if (TextUtils.isEmpty(c2)) {
            this.a = null;
            return;
        }
        try {
            this.a = (Info) new com.google.gson.e().j(c2, Info.class);
        } catch (Exception unused) {
            this.a = null;
        }
    }

    public static void A(long j2) {
        us.pinguo.foundation.j.e().r("key_expired_toast_time", j2);
    }

    public static void B(long j2) {
        us.pinguo.foundation.j.e().r("key_expired_toast_time_gallery", j2);
    }

    public static void C(z0 z0Var) {
        f12362h = z0Var;
    }

    public static void D(boolean z) {
        us.pinguo.foundation.j.e().m("key_token_expired", z);
    }

    public static void E() {
        D(true);
        B(0L);
        A(0L);
        User d2 = d();
        if (d2.q()) {
            w(d2);
        }
        s();
    }

    public static User d() {
        us.pinguo.common.log.a.k("user->create->" + Thread.currentThread().getId(), new Object[0]);
        if (f12360f == null) {
            synchronized (f12361g) {
                us.pinguo.common.log.a.k("user->create->lock->threadId->" + Thread.currentThread().getId(), new Object[0]);
                if (f12360f == null) {
                    us.pinguo.common.log.a.k("user->create->lock->threadId->" + Thread.currentThread().getId() + "->user==null", new Object[0]);
                    f12360f = new User();
                } else {
                    us.pinguo.common.log.a.k("user->create->lock->threadId->" + Thread.currentThread().getId() + "->user!=null", new Object[0]);
                }
            }
        }
        return f12360f;
    }

    public static long f() {
        return us.pinguo.foundation.j.e().j("key_expired_toast_time", 0L);
    }

    public static String i() {
        String str = c;
        if (str != null) {
            return str;
        }
        String d2 = y0.d(us.pinguo.foundation.e.b(), "currentAccount");
        c = d2;
        if (d2 == null) {
            c = "";
        }
        return c;
    }

    public static String j() {
        String d2 = y0.d(us.pinguo.foundation.e.b(), "currentAccountType");
        return d2 == null ? "" : d2;
    }

    public static String l() {
        Info h2 = d().h();
        return h2 != null ? h2.userId : "";
    }

    public static y0.b m() {
        if (f12358d == null) {
            f12358d = y0.f(us.pinguo.foundation.e.b());
        }
        return f12358d;
    }

    private Boolean o(long j2) {
        Time time = new Time();
        time.set(j2);
        int i2 = time.year;
        int i3 = time.month;
        int i4 = time.monthDay;
        time.set(System.currentTimeMillis());
        return Boolean.valueOf(i2 == time.year && i3 == time.month && i4 == time.monthDay);
    }

    public static boolean p() {
        return us.pinguo.foundation.j.e().f("key_token_expired", false);
    }

    public static void s() {
        boolean z;
        synchronized (f12361g) {
            us.pinguo.common.log.a.k("user->logout", new Object[0]);
            us.pinguo.foundation.j.e().r("key_sync_vip_time", 0L);
            Context b = us.pinguo.foundation.e.b();
            y0.h(b, "");
            BaseInfoResult g2 = us.pinguo.user.util.n.a.g();
            if (g2 != null) {
                User user = f12360f;
                if (user != null && user.a != null) {
                    z = false;
                    if (z || !g2.isChina()) {
                        y0.o(b, 0, 0L);
                    }
                }
                z = true;
                if (z) {
                }
                y0.o(b, 0, 0L);
            }
            f12360f.a = null;
            f12360f = null;
            c = null;
            f12358d = null;
            f12359e = null;
            z0 z0Var = f12362h;
            if (z0Var != null) {
                z0Var.logout();
            }
        }
    }

    public static boolean u() {
        if (d().n()) {
            y0.b m = m();
            long b = m.b();
            if (b < 0) {
                return false;
            }
            if (Math.abs((System.currentTimeMillis() / 1000) - m.a()) > (b * 2) / 3) {
                new ApiRefreshToken(us.pinguo.foundation.e.b()).get(new j.a.c.b.d<ApiRefreshToken.NewTokenResponse>() { // from class: us.pinguo.user.User.1
                    @Override // j.a.c.b.d
                    public void onError(Exception exc) {
                        us.pinguo.common.log.a.f(exc);
                    }

                    @Override // j.a.c.b.d
                    public void onSuccess(ApiRefreshToken.NewTokenResponse newTokenResponse) {
                        T t;
                        if (newTokenResponse == null) {
                            return;
                        }
                        int i2 = newTokenResponse.status;
                        if (i2 == 420) {
                            User.E();
                        } else if (i2 != 200 || (t = newTokenResponse.data) == 0 || TextUtils.isEmpty(((ApiRefreshToken.b) t).a)) {
                        } else {
                            User d2 = User.d();
                            if (d2.n() && !d2.a.token.equals(((ApiRefreshToken.b) newTokenResponse.data).a)) {
                                d2.a.token = ((ApiRefreshToken.b) newTokenResponse.data).a;
                                User.v(d2.a);
                                T t2 = newTokenResponse.data;
                                User.x(((ApiRefreshToken.b) t2).b, ((ApiRefreshToken.b) t2).c - ((ApiRefreshToken.b) t2).b);
                                User.D(false);
                            }
                        }
                    }
                });
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x0007, B:9:0x000f, B:11:0x0013, B:17:0x001d, B:21:0x0025, B:23:0x0049, B:25:0x0051, B:27:0x005b, B:28:0x006b), top: B:33:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[Catch: all -> 0x006d, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x0007, B:9:0x000f, B:11:0x0013, B:17:0x001d, B:21:0x0025, B:23:0x0049, B:25:0x0051, B:27:0x005b, B:28:0x006b), top: B:33:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void v(us.pinguo.user.User.Info r6) {
        /*
            byte[] r0 = us.pinguo.user.User.f12361g
            monitor-enter(r0)
            if (r6 != 0) goto L7
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L7:
            us.pinguo.user.User r1 = us.pinguo.user.User.f12360f     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.User$Info r2 = r1.a     // Catch: java.lang.Throwable -> L6d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1a
            us.pinguo.user.y0$c r2 = us.pinguo.user.User.f12359e     // Catch: java.lang.Throwable -> L6d
            if (r2 == 0) goto L1a
            int r2 = r2.a     // Catch: java.lang.Throwable -> L6d
            if (r2 != 0) goto L18
            goto L1a
        L18:
            r2 = 0
            goto L1b
        L1a:
            r2 = 1
        L1b:
            if (r1 == 0) goto L25
            boolean r1 = r1.n()     // Catch: java.lang.Throwable -> L6d
            if (r1 != 0) goto L24
            goto L25
        L24:
            r3 = 0
        L25:
            us.pinguo.user.User r1 = us.pinguo.user.User.f12360f     // Catch: java.lang.Throwable -> L6d
            r1.a = r6     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "user->setUser == null"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L6d
            us.pinguo.common.log.a.k(r1, r5)     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            us.pinguo.user.User.c = r1     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.User.f12358d = r1     // Catch: java.lang.Throwable -> L6d
            com.google.gson.e r1 = new com.google.gson.e     // Catch: java.lang.Throwable -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.Class<us.pinguo.user.User$Info> r5 = us.pinguo.user.User.Info.class
            java.lang.String r1 = r1.t(r6, r5)     // Catch: java.lang.Throwable -> L6d
            android.content.Context r5 = us.pinguo.foundation.e.b()     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.y0.h(r5, r1)     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L59
            us.pinguo.user.y0$c r6 = r6.vipInfo     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.User.f12359e = r6     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.z0 r1 = us.pinguo.user.User.f12362h     // Catch: java.lang.Throwable -> L6d
            if (r1 == 0) goto L59
            r1.a(r6)     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.z0 r6 = us.pinguo.user.User.f12362h     // Catch: java.lang.Throwable -> L6d
            r6.b()     // Catch: java.lang.Throwable -> L6d
        L59:
            if (r2 == 0) goto L6b
            java.lang.String r6 = "User.save.syncVipExpireTimeFromServer"
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L6d
            us.pinguo.common.log.a.k(r6, r1)     // Catch: java.lang.Throwable -> L6d
            us.pinguo.user.api.e0 r6 = us.pinguo.user.api.e0.a     // Catch: java.lang.Throwable -> L6d
            android.content.Context r1 = us.pinguo.foundation.e.b()     // Catch: java.lang.Throwable -> L6d
            r6.f(r1)     // Catch: java.lang.Throwable -> L6d
        L6b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L6d:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.user.User.v(us.pinguo.user.User$Info):void");
    }

    public static void w(User user) {
        if (user == null) {
            return;
        }
        Info h2 = user.h();
        Context b = us.pinguo.foundation.e.b();
        if (h2 == null || b == null) {
            return;
        }
        String str = h2.loginmode;
        String str2 = null;
        if (NotificationCompat.CATEGORY_EMAIL.equals(str)) {
            str2 = h2.email;
        } else if (TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE.equals(str)) {
            str2 = h2.mobile;
        }
        if (!TextUtils.isEmpty(str)) {
            y0.j(b, "currentAccountType", str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c = str2;
        y0.j(b, "currentAccount", str2);
    }

    public static void x(long j2, long j3) {
        f12358d = null;
        if (j2 < 60) {
            j2 = -1;
        }
        y0.l(us.pinguo.foundation.e.b(), j3, j2);
    }

    public j.a.c.b.b<Void> b(String str) {
        if (!q()) {
            return new j.a.c.b.a(new IllegalArgumentException("用户不合法"));
        }
        return new j.a.c.b.c<Void, UserInfoResponse>(new us.pinguo.user.api.w(us.pinguo.foundation.e.b(), str)) { // from class: us.pinguo.user.User.2
            @Override // j.a.c.b.c
            public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
                if (userInfoResponse.status == 200) {
                    Info h2 = User.this.h();
                    h2.avatar = ((Info) userInfoResponse.data).avatar;
                    User.v(h2);
                    return null;
                }
                throw new Fault(userInfoResponse.status, userInfoResponse.message);
            }
        };
    }

    public j.a.c.b.b<Void> c(final String str) {
        if (!q()) {
            return new j.a.c.b.a(new IllegalArgumentException("用户不合法"));
        }
        if (str != null && str.equals(this.a.nickname)) {
            return new j.a.c.b.e(null);
        }
        return new j.a.c.b.c<Void, UserInfoResponse>(new us.pinguo.user.api.x(us.pinguo.foundation.e.b(), str)) { // from class: us.pinguo.user.User.3
            @Override // j.a.c.b.c
            public Void adapte(UserInfoResponse userInfoResponse) throws Exception {
                int i2 = userInfoResponse.status;
                if (i2 == 420) {
                    User.E();
                    throw null;
                } else if (i2 == 200) {
                    Info h2 = User.this.h();
                    h2.nickname = str;
                    User.v(h2);
                    return null;
                } else {
                    throw new Fault(userInfoResponse.status, userInfoResponse.message);
                }
            }
        };
    }

    public String e() {
        if (q()) {
            Info info = this.a;
            String str = info.loginmode;
            Info.ThirdSites thirdSites = info.third;
            String str2 = info.avatar;
            if (TextUtils.isEmpty(str2) && thirdSites != null) {
                Info.ThirdSites.QQSite qQSite = thirdSites.qzone;
                Info.ThirdSites.SinaSite sinaSite = thirdSites.sina;
                Info.ThirdSites.FacebookSite facebookSite = thirdSites.facebook;
                Info.ThirdSites.TwitterSite twitterSite = thirdSites.twitter;
                Info.ThirdSites.HuaweiSite huaweiSite = thirdSites.huawei;
                if (str != null) {
                    if (str.equals(Constants.SOURCE_QZONE)) {
                        if (qQSite != null) {
                            str2 = qQSite.avatar;
                        }
                    } else if (str.equals("sina")) {
                        if (sinaSite != null) {
                            str2 = sinaSite.avatar;
                        }
                    } else if (str.equals("facebook")) {
                        if (facebookSite != null) {
                            str2 = facebookSite.avatar;
                        }
                    } else if (str.equals(FindFriendHeaderCell.TWITTER)) {
                        if (twitterSite != null) {
                            str2 = twitterSite.avatar;
                        }
                    } else if (str.equals(com.adjust.sdk.Constants.REFERRER_API_HUAWEI) && huaweiSite != null) {
                        str2 = huaweiSite.avatar;
                    }
                }
            }
            return TextUtils.isEmpty(str2) ? "" : str2;
        }
        return "";
    }

    public long g() {
        return ((Long) SPUtils.get(us.pinguo.foundation.e.b(), f12363i, 0L)).longValue();
    }

    public Info h() {
        Info info = this.a;
        if (info != null) {
            try {
                return (Info) info.clone();
            } catch (Exception e2) {
                if (!us.pinguo.foundation.d.f10987f) {
                    return this.a;
                }
                throw new IllegalArgumentException(e2);
            }
        }
        return null;
    }

    public String k() {
        if (us.pinguo.foundation.d.f10990i) {
            return "1";
        }
        if (this.b == -1) {
            this.b = g();
        }
        long j2 = this.b;
        return (j2 == 0 || o(j2).booleanValue()) ? "1" : "0";
    }

    public boolean n() {
        return q();
    }

    public boolean q() {
        Info info = this.a;
        return (info == null || TextUtils.isEmpty(info.userId) || TextUtils.isEmpty(this.a.token)) ? false : true;
    }

    public y0.c r(boolean z) {
        y0.c cVar;
        Info info = this.a;
        if (info == null || (cVar = info.vipInfo) == null || System.currentTimeMillis() >= cVar.b * 1000 || !cVar.a()) {
            if (z || f12359e == null) {
                f12359e = y0.g(us.pinguo.foundation.e.b());
            }
            return f12359e;
        }
        return cVar;
    }

    public void t() {
        if (((Long) SPUtils.get(us.pinguo.foundation.e.b(), f12363i, 0L)).longValue() == 0) {
            SPUtils.put(us.pinguo.foundation.e.b(), f12363i, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void y(int i2) {
        y0.c cVar = f12359e;
        if (cVar != null) {
            cVar.a = i2;
            if (d().a != null) {
                d().a.vipInfo = f12359e;
            }
        }
        y0.m(us.pinguo.foundation.e.b(), i2);
    }

    public void z(int i2, long j2) {
        y0.c cVar = f12359e;
        if (cVar != null) {
            cVar.a = i2;
            cVar.b = j2;
            if (d().a != null) {
                d().a.vipInfo = f12359e;
            }
        }
        y0.o(us.pinguo.foundation.e.b(), i2, j2);
    }
}
