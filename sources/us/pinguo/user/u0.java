package us.pinguo.user;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RetryPolicy;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
import java.util.TimeZone;
import org.slf4j.Marker;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.user.User;
import us.pinguo.util.NetworkType;
/* compiled from: RemoteConstants.java */
/* loaded from: classes6.dex */
public class u0 {
    public static final String a;
    public static final String b;
    public static final String c;

    /* renamed from: d  reason: collision with root package name */
    private static String f12382d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f12383e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f12384f;

    /* renamed from: g  reason: collision with root package name */
    public static final String f12385g;

    /* renamed from: h  reason: collision with root package name */
    public static final String f12386h;

    /* renamed from: i  reason: collision with root package name */
    public static final String f12387i;

    /* renamed from: j  reason: collision with root package name */
    public static final String f12388j;

    /* renamed from: k  reason: collision with root package name */
    public static final String f12389k;

    /* renamed from: l  reason: collision with root package name */
    private static final String f12390l;
    public static final String m;
    public static final String n;
    public static boolean o;
    private static String p;
    private static b q;
    public static long r;
    public static long s;
    private static String t;
    private static String u;

    /* compiled from: RemoteConstants.java */
    /* loaded from: classes6.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            a = iArr;
            try {
                iArr[NetworkType.NETWORK_WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NetworkType.NETWORK_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NetworkType.NETWORK_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NetworkType.NETWORK_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NetworkType.NETWORK_5G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: RemoteConstants.java */
    /* loaded from: classes6.dex */
    public interface b {
        String a();
    }

    static {
        String str;
        String str2;
        boolean z = us.pinguo.foundation.d.f10985d;
        a = (z && us.pinguo.foundation.d.b) ? "https://c360-bff-qa.camera360.com" : "https://c360-bff.camera360.com";
        b = z ? "https://storetest.camera360.com" : "https://store.camera360.com";
        if (z) {
            str = us.pinguo.foundation.d.b ? "https://bmall-qa.camera360.com" : "https://bmall-dev.camera360.com";
        } else {
            str = "https://bmall.camera360.com";
        }
        c = str;
        if (z) {
            str2 = "https://common-api-qa.camera360.com";
        } else {
            str2 = us.pinguo.foundation.utils.u.a() ? "https://common-api.camera360.com" : "https://common-api.360in.com";
        }
        f12382d = str2;
        r0 = str + "/api/product/query";
        f12383e = str + "/bmall/user/bind-order";
        f12384f = str + "/api/user/order";
        f12385g = str + "/api/iap/abtest-config";
        f12386h = str + "/api/iap/coupon-bind";
        f12387i = str + "/api/setting/load-json-conf";
        f12388j = str + "/api/product/classifyDefault";
        f12389k = str + "/api/iap/check-receipt";
        String str3 = z ? "http://store-server-dev.camera360.com" : "http://store.camera360.com";
        f12390l = str3;
        String str4 = str3 + "/sticker/GetClassifyStickers";
        m = f12382d + "/api/censor/image";
        n = f12382d + "/api/base/info";
        o = true;
        r = 0L;
        s = 0L;
        t = "";
        u = "";
    }

    public static RetryPolicy a() {
        return new DefaultRetryPolicy(15000, 0, 0.0f);
    }

    public static RetryPolicy b() {
        return new DefaultRetryPolicy(15000, 2, 0.0f);
    }

    @Deprecated
    public static void c(Context context, Map<String, String> map) {
        User.Info h2 = User.d().h();
        if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
            map.put("uid", us.pinguo.foundation.utils.p.a(h2.userId));
            map.put(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(h2.userId));
            map.put("userToken", us.pinguo.foundation.utils.p.a(h2.token));
            map.put("token", us.pinguo.foundation.utils.p.a(h2.token));
            o = false;
        }
        map.put("platform", us.pinguo.foundation.utils.p.a(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
        map.put("channel", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a()));
        map.put("appname", us.pinguo.foundation.utils.p.a("camera360"));
        String g2 = us.pinguo.util.s.g(us.pinguo.foundation.e.b());
        if (!TextUtils.isEmpty(g2)) {
            map.put("appversion", us.pinguo.foundation.utils.p.a(g2));
        }
        if (TextUtils.isEmpty(p)) {
            b bVar = q;
            p = bVar == null ? "" : bVar.a();
            if (us.pinguo.foundation.d.f10985d && q == null) {
                throw new RuntimeException("AidGenerator is null!");
            }
        }
        String str = (TextUtils.isEmpty(us.pinguo.foundation.utils.p.a(p)) || o) ? "unknown" : "unknown";
        map.put("deviceId", str);
        map.put("eid", str);
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, us.pinguo.foundation.utils.p.a(Build.MODEL));
        String str2 = us.pinguo.foundation.utils.v.a().getLanguage() + "_" + us.pinguo.foundation.utils.v.a().getCountry();
        us.pinguo.common.log.a.c("locale=" + str2, new Object[0]);
        if (!TextUtils.isEmpty(str2)) {
            map.put("locale", us.pinguo.foundation.utils.p.a(str2));
            map.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, us.pinguo.foundation.utils.p.a(str2));
        }
        map.put("localTime", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("UTCOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
    }

    public static void d(PGRequest.Builder builder) {
        if (builder == null) {
            return;
        }
        User.Info h2 = User.d().h();
        if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
            builder.addParam("uid", us.pinguo.foundation.utils.p.a(h2.userId));
            builder.addParam(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(h2.userId));
            builder.addParam("userToken", us.pinguo.foundation.utils.p.a(h2.token));
            builder.addParam("token", us.pinguo.foundation.utils.p.a(h2.token));
        }
        if (o) {
            builder.addParam("eid", "unknown");
        } else {
            builder.addParam("eid", us.pinguo.bigdata.f.a.w(us.pinguo.util.v.a()));
        }
    }

    public static void e(Context context, Map<String, String> map) {
        User.Info h2 = User.d().h();
        if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
            map.put("uid", us.pinguo.foundation.utils.p.a(h2.userId));
            map.put(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(h2.userId));
            map.put("userToken", us.pinguo.foundation.utils.p.a(h2.token));
            map.put("token", us.pinguo.foundation.utils.p.a(h2.token));
            o = false;
        }
        String visitUserId = AbstractGrowingIO.getInstance().getVisitUserId();
        if (!o && visitUserId != null) {
            map.put("growingIOUserId", visitUserId);
        } else {
            map.put("growingIOUserId", "not_allowed");
        }
        map.put("platform", us.pinguo.foundation.utils.p.a(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE));
        map.put("channel", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a()));
        map.put("appName", us.pinguo.foundation.utils.p.a("camera360"));
        String g2 = us.pinguo.util.s.g(context);
        if (!TextUtils.isEmpty(g2)) {
            map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, us.pinguo.foundation.utils.p.a(g2));
        }
        if (TextUtils.isEmpty(p)) {
            b bVar = q;
            p = bVar == null ? "" : bVar.a();
            if (us.pinguo.foundation.d.f10985d && q == null) {
                throw new RuntimeException("AidGenerator is null!");
            }
        }
        String str = (TextUtils.isEmpty(us.pinguo.foundation.utils.p.a(p)) || o) ? "unknown" : "unknown";
        map.put("deviceId", str);
        map.put("eid", str);
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, us.pinguo.foundation.utils.p.a(Build.MODEL));
        String str2 = us.pinguo.foundation.utils.v.a().getLanguage() + "_" + us.pinguo.foundation.utils.v.a().getCountry();
        if (!TextUtils.isEmpty(str2)) {
            map.put("locale", us.pinguo.foundation.utils.p.a(str2));
            map.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, us.pinguo.foundation.utils.p.a(str2));
        }
        map.put("localTime", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("UTCOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
        map.put("newAddToday", User.d().k());
    }

    public static void f(Context context, Map<String, String> map) {
        String str;
        map.put("PG-AppID", us.pinguo.foundation.utils.p.a("Camera360"));
        map.put("PG-Platform", us.pinguo.foundation.utils.p.a(Constants.PLATFORM_ANDROID));
        map.put("PG-Time", "" + (System.currentTimeMillis() / 1000));
        User.Info h2 = User.d().h();
        if (h2 != null && !TextUtils.isEmpty(h2.userId) && !TextUtils.isEmpty(h2.token)) {
            map.put("PG-UserID", us.pinguo.foundation.utils.p.a(h2.userId));
            map.put("PG-UserToken", us.pinguo.foundation.utils.p.a(h2.token));
            o = false;
        }
        String g2 = us.pinguo.util.s.g(context);
        if (!TextUtils.isEmpty(g2)) {
            map.put("PG-AppVersion", us.pinguo.foundation.utils.p.a(g2));
        }
        map.put("PG-OSVersion", "" + Build.VERSION.SDK_INT);
        map.put("PG-Model", us.pinguo.foundation.utils.p.a(Build.MODEL));
        if (TextUtils.isEmpty(p)) {
            b bVar = q;
            p = bVar == null ? "" : bVar.a();
            if (us.pinguo.foundation.d.f10985d && q == null) {
                throw new RuntimeException("AidGenerator is null!");
            }
        }
        String str2 = (TextUtils.isEmpty(us.pinguo.foundation.utils.p.a(p)) || o) ? "unknown" : "unknown";
        map.put("PG-AID", str2);
        map.put("PG-EID", str2);
        if (TextUtils.isEmpty(t)) {
            t = SPUtils.get(context, "oaid", "unknown").toString();
        }
        if (t.isEmpty() || o) {
            t = "unknown";
        }
        map.put("PG-OAID", t);
        if (TextUtils.isEmpty(u)) {
            u = SPUtils.get(context, "GOOGLE_AID", "").toString();
        }
        if (u.isEmpty() || o) {
            u = "unknown";
        }
        map.put("PG-AAID", u);
        String str3 = us.pinguo.foundation.utils.v.a().getLanguage() + "," + us.pinguo.foundation.utils.v.a().getCountry();
        if (!TextUtils.isEmpty(str3)) {
            map.put("PG-LL", us.pinguo.foundation.utils.p.a(str3));
        }
        map.put("PG-Channel", us.pinguo.foundation.utils.p.a(us.pinguo.foundation.utils.i.a()));
        map.put("PG-InitStamp", "" + r);
        map.put("PG-UpgradeStamp", "" + s);
        map.put("PG-Density", "" + us.pinguo.foundation.utils.n0.c(1));
        map.put("PG-ScreenSize", us.pinguo.foundation.utils.n0.i() + Marker.ANY_MARKER + us.pinguo.foundation.utils.n0.h());
        String str4 = us.pinguo.foundation.utils.v.a().getLanguage() + "_" + us.pinguo.foundation.utils.v.a().getCountry();
        map.put("PG-Language", str4);
        map.put("PG-UtcOffset", String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000));
        int i2 = a.a[us.pinguo.util.q.b(context).ordinal()];
        map.put("PG-Network", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? NetworkUtil.NETWORK_UNKNOWN : "5G" : "4G" : "3G" : "2G" : NetworkUtil.NETWORK_WIFI);
        map.put("PG-ENCH", "0");
        map.put("PG-ENCB", "0");
        map.put("PG-Locale", str4);
        if (us.pinguo.foundation.d.f10985d) {
            str = us.pinguo.foundation.d.b ? "qa" : "dev";
        } else {
            str = us.pinguo.foundation.d.c ? AdvConstants.ADV_TYPE_OPERATION : "prod";
        }
        map.put("PG-DataEnv", str);
    }

    public static void g(b bVar) {
        q = bVar;
    }
}
