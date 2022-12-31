package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.internal.gw;
import com.tapjoy.internal.gz;
/* loaded from: classes3.dex */
public class TapjoyLog {
    private static final String a = "TapjoyLog";
    private static int b = 6;
    private static int c = 4;

    /* renamed from: d  reason: collision with root package name */
    private static int f7283d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f7284e = false;

    /* renamed from: f  reason: collision with root package name */
    private static int f7285f = 6;

    public static void d(String str, String str2) {
        a(3, str, str2);
    }

    public static void e(String str, String str2) {
        e(str, new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.INTERNAL_ERROR, str2));
    }

    public static void i(String str, String str2) {
        a(4, str, str2);
    }

    public static boolean isLoggingEnabled() {
        return f7284e;
    }

    public static void setDebugEnabled(boolean z) {
        boolean z2;
        f7284e = z;
        gz a2 = gz.a();
        if (gw.a != z) {
            gw.a = z;
            if (z) {
                gw.a("The debug mode has been enabled");
            } else {
                gw.a("The debug mode has been disabled");
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z && a2.f7600k) {
            a2.f7598i.a();
        }
        if (f7284e) {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean z) {
        if (z) {
            a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    public static void v(String str, String str2) {
        a(2, str, str2);
    }

    public static void w(String str, String str2) {
        a(5, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(19)
    public static void a(String str, boolean z) {
        if (!z && TapjoyAppSettings.getInstance() != null && TapjoyAppSettings.getInstance().a != null) {
            d(a, "setLoggingLevel -- log setting already persisted");
            return;
        }
        if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
            f7285f = f7283d;
            if (Build.VERSION.SDK_INT >= 19) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tapjoy.TapjoyLog.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TapjoyLog.d(TapjoyLog.a, "Enabling WebView debugging");
                        WebView.setWebContentsDebuggingEnabled(true);
                    }
                });
            }
        } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
            f7285f = c;
        } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
            f7285f = b;
        } else {
            String str2 = a;
            d(str2, "unrecognized loggingLevel: " + str);
            f7285f = b;
        }
        String str3 = a;
        d(str3, "logThreshold=" + f7285f);
    }

    public static void e(String str, TapjoyErrorMessage tapjoyErrorMessage) {
        if (tapjoyErrorMessage != null) {
            if (f7285f == f7283d || tapjoyErrorMessage.getType() != TapjoyErrorMessage.ErrorType.INTERNAL_ERROR) {
                a(6, str, tapjoyErrorMessage.toString());
            }
        }
    }

    private static void a(int i2, String str, String str2) {
        String str3 = a + ":" + str;
        if (f7285f <= i2) {
            if (str2.length() > 4096) {
                int i3 = 0;
                while (i3 <= str2.length() / 4096) {
                    int i4 = i3 * 4096;
                    i3++;
                    int i5 = i3 * 4096;
                    if (i5 > str2.length()) {
                        i5 = str2.length();
                    }
                    Log.println(i2, str3, str2.substring(i4, i5));
                }
                return;
            }
            Log.println(i2, str3, str2);
        }
    }
}
