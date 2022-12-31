package com.pinguo.camera360.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.k.b.a;
import com.pinguo.lib.HardwareInfo;
import com.tapjoy.TJAdUnitConstants;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.foundation.base.e;
import us.pinguo.foundation.statistics.h;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.util.NetworkType;
import us.pinguo.util.c;
import us.pinguo.util.n;
import us.pinguo.util.p;
import us.pinguo.util.q;
/* compiled from: StatisticSetupUtils.kt */
/* loaded from: classes3.dex */
public final class StatisticSetupUtils {
    public static final StatisticSetupUtils a = new StatisticSetupUtils();
    private static final m0 b = n0.a(z0.a());

    /* compiled from: StatisticSetupUtils.kt */
    /* loaded from: classes3.dex */
    public enum NotificationStatus {
        ON,
        OFF,
        NA,
        NOT
    }

    /* compiled from: StatisticSetupUtils.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[NetworkType.values().length];
            iArr[NetworkType.NETWORK_WIFI.ordinal()] = 1;
            iArr[NetworkType.NETWORK_2G.ordinal()] = 2;
            iArr[NetworkType.NETWORK_3G.ordinal()] = 3;
            iArr[NetworkType.NETWORK_4G.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[NotificationStatus.values().length];
            iArr2[NotificationStatus.ON.ordinal()] = 1;
            iArr2[NotificationStatus.OFF.ordinal()] = 2;
            b = iArr2;
        }
    }

    private StatisticSetupUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        User d2 = User.d();
        String str = (d2 == null || !d2.n()) ? "no" : "yes";
        int c = e.c(BaseApplication.d(), "filter_fav", -1);
        int c2 = e.c(BaseApplication.d(), "filter_installed", -1);
        int c3 = e.c(BaseApplication.d(), "sticker_installed", 1);
        boolean s = CameraBusinessSettingModel.v().s();
        String str2 = CameraBusinessSettingModel.v().B() ? TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON : "off";
        String str3 = s ? "main" : "camera";
        String valueOf = c == -1 ? "na" : String.valueOf(c);
        String valueOf2 = c2 == -1 ? "na" : String.valueOf(c2);
        String valueOf3 = c3 == -1 ? "na" : String.valueOf(c3);
        HardwareInfo hardwareInfo = HardwareInfo.get();
        String valueOf4 = String.valueOf(hardwareInfo.getScore());
        String valueOf5 = String.valueOf(hardwareInfo.getMaxCpuFreq());
        String encode = Uri.encode(hardwareInfo.getHardware().toString());
        String valueOf6 = String.valueOf(hardwareInfo.getCpuCount());
        String encode2 = Uri.encode(Build.BRAND);
        String valueOf7 = String.valueOf(hardwareInfo.getMemSize());
        String t = CameraBusinessSettingModel.v().t("key_gpu_info", "");
        if (TextUtils.isEmpty(t)) {
            t = n.a();
            CameraBusinessSettingModel.v().H("key_gpu_info", t);
        }
        String encode3 = Uri.encode(t);
        String pixelDensity = hardwareInfo.getPixelDensity();
        String encode4 = Uri.encode(Build.HARDWARE);
        Context d3 = BaseApplication.d();
        s.g(d3, "getAppContext()");
        int i2 = a.a[q.b(d3).ordinal()];
        String str4 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "no_network" : "4G" : "3G" : "2G" : "wifi";
        Object systemService = BaseApplication.d().getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        a.C0243a.d(q.c((ConnectivityManager) systemService) == NetworkType.NETWORK_UNKNOWN ? "unknow-net" : "no-net");
        Context d4 = BaseApplication.d();
        s.g(d4, "getAppContext()");
        int i3 = a.b[c(d4).ordinal()];
        h.a.d0(str3, str2, str, i3 != 1 ? i3 != 2 ? "na" : "no" : "yes", valueOf, valueOf2, valueOf3, valueOf4, valueOf5, encode, valueOf6, encode2, valueOf7, encode3, pixelDensity, encode4, str4, com.pinguo.camera360.utils.a.a.a() ? "1" : "0", p.a.a());
    }

    private final NotificationStatus c(Context context) {
        if (!c.f12471e) {
            return NotificationStatus.NOT;
        }
        try {
            Object systemService = context.getSystemService("appops");
            if (systemService != null) {
                AppOpsManager appOpsManager = (AppOpsManager) systemService;
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                try {
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    Class<?> cls2 = Integer.TYPE;
                    Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                    Object obj = cls.getDeclaredField("OP_POST_NOTIFICATION").get(cls2);
                    if (obj != null) {
                        Object invoke = method.invoke(appOpsManager, Integer.valueOf(((Integer) obj).intValue()), Integer.valueOf(i2), packageName);
                        if (invoke != null) {
                            return ((Integer) invoke).intValue() == 0 ? NotificationStatus.ON : NotificationStatus.OFF;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                } catch (Exception unused) {
                    return NotificationStatus.NA;
                }
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.AppOpsManager");
        } catch (Throwable unused2) {
            return NotificationStatus.NA;
        }
    }

    public static final void d() {
        l.d(b, null, null, new StatisticSetupUtils$uploadStatisticUtils$1(null), 3, null);
    }
}
