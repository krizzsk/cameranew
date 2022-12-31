package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.work.PeriodicWorkRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.r;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
/* compiled from: SessionLogger.java */
/* loaded from: classes.dex */
class j {
    private static final String a = "com.facebook.appevents.internal.j";
    private static final long[] b = {PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, 900000, TapjoyConstants.SESSION_ID_INACTIVITY_TIME, 3600000, 21600000, 43200000, AdvTimeUtils.MILLIS_OF_A_DAY, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    j() {
    }

    @Nullable
    private static String a(Context context) {
        if (com.facebook.internal.instrument.e.a.c(j.class)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(str, null);
            if (string == null || string.length() != 32) {
                String a2 = f.a(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
                sharedPreferences.edit().putString(str, a2).apply();
                return a2;
            }
            return string;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, j.class);
            return null;
        }
    }

    @VisibleForTesting
    static int b(long j2) {
        if (com.facebook.internal.instrument.e.a.c(j.class)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            try {
                long[] jArr = b;
                if (i2 >= jArr.length || jArr[i2] >= j2) {
                    break;
                }
                i2++;
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, j.class);
                return 0;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, k kVar, String str2, Context context) {
        String kVar2;
        if (com.facebook.internal.instrument.e.a.c(j.class)) {
            return;
        }
        if (kVar != null) {
            try {
                kVar2 = kVar.toString();
            } catch (Throwable th) {
                com.facebook.internal.instrument.e.a.b(th, j.class);
                return;
            }
        } else {
            kVar2 = "Unclassified";
        }
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", kVar2);
        bundle.putString("fb_mobile_pckg_fp", a(context));
        bundle.putString("fb_mobile_app_cert_hash", com.facebook.internal.a0.a.a(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.g("fb_mobile_activate_app", bundle);
        if (InternalAppEventsLogger.c() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.a();
        }
    }

    private static void d() {
        if (com.facebook.internal.instrument.e.a.c(j.class)) {
            return;
        }
        try {
            r.g(LoggingBehavior.APP_EVENTS, a, "Clock skew detected");
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, j.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str, i iVar, String str2) {
        if (com.facebook.internal.instrument.e.a.c(j.class) || iVar == null) {
            return;
        }
        try {
            Long valueOf = Long.valueOf(iVar.b() - iVar.e().longValue());
            if (valueOf.longValue() < 0) {
                valueOf = 0L;
                d();
            }
            Long valueOf2 = Long.valueOf(iVar.f());
            if (valueOf2.longValue() < 0) {
                d();
                valueOf2 = 0L;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("fb_mobile_app_interruptions", iVar.c());
            bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(b(valueOf.longValue()))));
            k g2 = iVar.g();
            bundle.putString("fb_mobile_launch_source", g2 != null ? g2.toString() : "Unclassified");
            bundle.putLong("_logTime", iVar.e().longValue() / 1000);
            new InternalAppEventsLogger(str, str2, null).f("fb_mobile_deactivate_app", valueOf2.longValue() / 1000.0d, bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, j.class);
        }
    }
}
