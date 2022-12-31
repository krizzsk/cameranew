package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.coremedia.iso.boxes.UserBox;
import com.tapjoy.TapjoyConstants;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: DeviceUtils.java */
/* loaded from: classes.dex */
public class g {
    public static String a(boolean z) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        boolean z2 = inetAddress instanceof Inet4Address;
                        String upperCase = inetAddress.getHostAddress().toUpperCase();
                        if (z) {
                            if (z2) {
                                return upperCase;
                            }
                        } else if (!z2) {
                            int indexOf = upperCase.indexOf(37);
                            return indexOf < 0 ? upperCase : upperCase.substring(0, indexOf);
                        }
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean b(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (b(context)) {
            return 3;
        }
        return a(context) ? 2 : 1;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("type", c(context));
            jSONObject.put("os", 1);
            jSONObject.put(TapjoyConstants.TJC_DEVICE_OS_VERSION_NAME, Build.VERSION.RELEASE + "");
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", q.b(context));
            jSONObject.put("screen_width", ac.c(context));
            jSONObject.put("screen_height", ac.d(context));
            jSONObject.put("power_on_time", SystemClock.elapsedRealtime() + "");
            jSONObject.put(TapjoyConstants.TJC_ANDROID_ID, com.bytedance.sdk.openadsdk.core.j.c(context));
            jSONObject.put(UserBox.TYPE, com.bytedance.sdk.openadsdk.core.j.d(context));
            jSONObject.put("rom_version", u.a());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.j.b(context));
            jSONObject.put(TapjoyConstants.TJC_DEVICE_TIMEZONE, ab.o());
            jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.j.a());
            jSONObject.put(TapjoyConstants.TJC_CARRIER_NAME, w.a());
            jSONObject.put("mnc", w.c());
            jSONObject.put("mcc", w.b());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        return d(context);
    }

    private static void b(JSONObject jSONObject) throws JSONException {
        if (com.bytedance.sdk.openadsdk.core.h.b().g() != 1) {
            c(jSONObject);
        }
    }

    private static void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(BigAlbumStore.PhotoTagColumns.MODEL, Build.MODEL);
        jSONObject.put("gaid", d.a.a.a.a.b.a.a().e());
    }

    public static boolean a(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void a(JSONObject jSONObject) throws JSONException {
        int f2 = com.bytedance.sdk.openadsdk.core.h.b().f();
        boolean z = true;
        if ((com.bytedance.sdk.openadsdk.core.o.h().u() == -1 && ab.m()) || com.bytedance.sdk.openadsdk.core.o.h().u() == 1) {
            if (f2 == 1 || f2 == -1) {
                return;
            }
            b(jSONObject);
        } else if (com.bytedance.sdk.openadsdk.core.o.h().u() == 1 && f2 == 0) {
            c(jSONObject);
        } else {
            boolean z2 = com.bytedance.sdk.openadsdk.core.o.h().u() == 1 && (f2 == 1 || f2 == -1);
            z = (com.bytedance.sdk.openadsdk.core.o.h().u() == -1 && f2 == 1) ? false : false;
            if (z2 || z) {
                return;
            }
            b(jSONObject);
        }
    }
}
