package com.unity3d.splash.services;

import android.app.Activity;
import android.os.Build;
import com.unity3d.splash.services.c.b.b;
import com.unity3d.splash.services.core.configuration.d;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.util.Date;
/* loaded from: classes3.dex */
public class UnityServices {
    private static boolean a = false;

    /* loaded from: classes3.dex */
    public enum UnityServicesError {
        INVALID_ARGUMENT,
        INIT_SANITY_CHECK_FAIL
    }

    public static void a(Activity activity, String str, a aVar, boolean z, boolean z2) {
        StringBuilder sb;
        String str2;
        DeviceLog.e();
        if (a) {
            if (com.unity3d.splash.services.c.b.a.c() == null || com.unity3d.splash.services.c.b.a.c().equals(str)) {
                return;
            }
            DeviceLog.k("You are trying to re-initialize with a different gameId");
            return;
        }
        a = true;
        if (!b()) {
            DeviceLog.f("Error while initializing Unity Services: device is not supported");
            return;
        }
        DeviceLog.i("Application start initializing at " + new Date().getTime());
        b.l(System.currentTimeMillis());
        if (str == null || str.length() == 0) {
            DeviceLog.f("Error while initializing Unity Services: empty game ID, halting Unity Ads init");
            if (aVar != null) {
                aVar.a(UnityServicesError.INVALID_ARGUMENT, "Empty game ID");
            }
        } else if (activity == null) {
            DeviceLog.f("Error while initializing Unity Services: null activity, halting Unity Ads init");
            if (aVar != null) {
                aVar.a(UnityServicesError.INVALID_ARGUMENT, "Null activity");
            }
        } else {
            if (z) {
                sb = new StringBuilder("Initializing Unity Services ");
                sb.append(b.i());
                sb.append(" (");
                sb.append(b.h());
                sb.append(") with game id ");
                sb.append(str);
                str2 = " in test mode";
            } else {
                sb = new StringBuilder("Initializing Unity Services ");
                sb.append(b.i());
                sb.append(" (");
                sb.append(b.h());
                sb.append(") with game id ");
                sb.append(str);
                str2 = " in production mode";
            }
            sb.append(str2);
            DeviceLog.i(sb.toString());
            b.k(b.d());
            b.n(aVar);
            com.unity3d.splash.services.c.b.a.f(str);
            com.unity3d.splash.services.c.b.a.e(activity.getApplicationContext());
            com.unity3d.splash.services.c.b.a.d(activity.getApplication());
            b.o(z2);
            b.p(z);
            if (com.unity3d.splash.services.core.configuration.b.b()) {
                DeviceLog.i("Unity Services environment check OK");
                d.a(new com.unity3d.splash.services.core.configuration.a());
                return;
            }
            DeviceLog.f("Error during Unity Services environment check, halting Unity Services init");
            if (aVar != null) {
                aVar.a(UnityServicesError.INIT_SANITY_CHECK_FAIL, "Unity Services init environment check failed");
            }
        }
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 16;
    }
}
