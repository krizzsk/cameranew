package com.ironsource.sdk.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.ironsource.environment.e;
import com.ironsource.sdk.utils.f;
import d.e.c.b;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: DeviceData.java */
/* loaded from: classes2.dex */
public class c {
    private static final String a = "c";

    public static JSONObject a(Context context) {
        f.z(context);
        String j2 = f.j();
        Boolean valueOf = Boolean.valueOf(f.y());
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(j2)) {
            try {
                com.ironsource.sdk.utils.d.d(a, "add AID and LAT");
                jSONObject.put("isLimitAdTrackingEnabled", valueOf);
                jSONObject.put("deviceIds[AID]", f.c(j2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        k(jSONObject);
        i(context, jSONObject);
        l(jSONObject);
        g(context, jSONObject);
        n(context, jSONObject);
        j(context, jSONObject);
        o(jSONObject);
        m(context, jSONObject);
        h(context, jSONObject);
        f(context, jSONObject);
        p(context, jSONObject);
        return jSONObject;
    }

    public static JSONObject c(Context context) {
        com.ironsource.sdk.utils.a h2 = com.ironsource.sdk.utils.a.h(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String d2 = h2.d();
            if (d2 != null) {
                jSONObject.put(f.c("deviceOEM"), f.c(d2));
            }
            String c = h2.c();
            if (c != null) {
                jSONObject.put(f.c("deviceModel"), f.c(c));
            }
            String e2 = h2.e();
            if (e2 != null) {
                jSONObject.put(f.c("deviceOs"), f.c(e2));
            }
            String f2 = h2.f();
            if (f2 != null) {
                jSONObject.put(f.c("deviceOSVersion"), f2.replaceAll("[^0-9/.]", ""));
            }
            String f3 = h2.f();
            if (f3 != null) {
                jSONObject.put(f.c("deviceOSVersionFull"), f.c(f3));
            }
            jSONObject.put(f.c("deviceApiLevel"), String.valueOf(h2.a()));
            String i2 = com.ironsource.sdk.utils.a.i();
            if (i2 != null) {
                jSONObject.put(f.c("SDKVersion"), f.c(i2));
            }
            if (h2.b() != null && h2.b().length() > 0) {
                jSONObject.put(f.c("mobileCarrier"), f.c(h2.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(f.c("deviceLanguage"), f.c(language.toUpperCase()));
            }
            if (d("totalDeviceRAM")) {
                jSONObject.put(f.c("totalDeviceRAM"), f.c(String.valueOf(e.L(context))));
            }
            String f4 = com.ironsource.environment.c.f(context);
            if (!TextUtils.isEmpty(f4)) {
                jSONObject.put(f.c("bundleId"), f.c(f4));
            }
            String valueOf = String.valueOf(e.l());
            if (!TextUtils.isEmpty(valueOf)) {
                jSONObject.put(f.c("deviceScreenScale"), f.c(valueOf));
            }
            String valueOf2 = String.valueOf(e.S());
            if (!TextUtils.isEmpty(valueOf2)) {
                jSONObject.put(f.c("unLocked"), f.c(valueOf2));
            }
            jSONObject.put(f.c("gpi"), PackagesInstallationService.e(context));
            jSONObject.put("mcc", d.e.c.a.b(context));
            jSONObject.put("mnc", d.e.c.a.c(context));
            jSONObject.put(f.c("phoneType"), d.e.c.a.d(context));
            jSONObject.put(f.c("simOperator"), f.c(d.e.c.a.e(context)));
            jSONObject.put(f.c("lastUpdateTime"), com.ironsource.environment.c.e(context));
            jSONObject.put(f.c("firstInstallTime"), com.ironsource.environment.c.c(context));
            jSONObject.put(f.c(RemoteConfigConstants.RequestFieldKey.APP_VERSION), f.c(com.ironsource.environment.c.b(context)));
            String d3 = com.ironsource.environment.c.d(context);
            if (!TextUtils.isEmpty(d3)) {
                jSONObject.put(f.c("installerPackageName"), f.c(d3));
            }
            jSONObject.put("localTime", f.c(String.valueOf(e.p())));
            jSONObject.put("timezoneOffset", f.c(String.valueOf(e.v())));
            String H = e.H(context);
            if (!TextUtils.isEmpty(H)) {
                jSONObject.put("icc", H);
            }
            String u = e.u();
            if (!TextUtils.isEmpty(u)) {
                jSONObject.put("tz", f.c(u));
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    private static boolean d(String str) {
        return f.l().optBoolean(str);
    }

    private static void e(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, f.c(str2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        try {
            if (d("airplaneMode")) {
                jSONObject.put(f.c("airplaneMode"), e.M(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(f.c("batteryLevel"), e.k(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        try {
            if (d("chargingType")) {
                jSONObject.put(f.c("chargingType"), e.a(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void i(Context context, JSONObject jSONObject) {
        try {
            String b = b.b(context);
            if (!TextUtils.isEmpty(b) && !b.equals(PortalFollowFeeds.TYPE_NONE)) {
                jSONObject.put(f.c("connectionType"), f.c(b));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put(f.c("hasVPN"), b.g(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void j(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(f.c("deviceVolume"), com.ironsource.sdk.utils.a.h(context).g(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void k(JSONObject jSONObject) {
        try {
            e(jSONObject, "displaySizeWidth", String.valueOf(e.y()));
            e(jSONObject, "displaySizeHeight", String.valueOf(e.x()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void l(JSONObject jSONObject) {
        try {
            jSONObject.put(f.c("diskFreeSize"), f.c(String.valueOf(e.i())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void m(Context context, JSONObject jSONObject) {
        try {
            if (d("isCharging")) {
                jSONObject.put(f.c("isCharging"), e.N(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void n(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(f.c("lpm"), e.R(context));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void o(JSONObject jSONObject) {
        try {
            if (d("sdCardAvailable")) {
                jSONObject.put(f.c("sdCardAvailable"), e.P());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void p(Context context, JSONObject jSONObject) {
        try {
            if (d("stayOnWhenPluggedIn")) {
                jSONObject.put(f.c("stayOnWhenPluggedIn"), e.T(context));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
