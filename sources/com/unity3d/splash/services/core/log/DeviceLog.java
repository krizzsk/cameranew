package com.unity3d.splash.services.core.log;

import android.util.Log;
import com.facebook.common.callercontext.ContextChain;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class DeviceLog {
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8464d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f8465e = false;

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap f8466f;

    /* loaded from: classes3.dex */
    public enum UnityAdsLogLevel {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UnityAdsLogLevel.values().length];
            a = iArr;
            try {
                iArr[UnityAdsLogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UnityAdsLogLevel.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UnityAdsLogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UnityAdsLogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f8466f = hashMap;
        if (hashMap.size() == 0) {
            hashMap.put(UnityAdsLogLevel.INFO, new b(ContextChain.TAG_INFRA));
            hashMap.put(UnityAdsLogLevel.DEBUG, new b("d"));
            hashMap.put(UnityAdsLogLevel.WARNING, new b(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W));
            hashMap.put(UnityAdsLogLevel.ERROR, new b("e"));
        }
        if (new File("/data/local/tmp/UnityAdsForceDebugMode").exists()) {
            f8465e = true;
        }
    }

    private static String a(String str) {
        return (str == null || str.length() == 0) ? "DO NOT USE EMPTY MESSAGES, use DeviceLog.entered() instead" : str;
    }

    private static com.unity3d.splash.services.core.log.a b(UnityAdsLogLevel unityAdsLogLevel, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        b h2 = h(unityAdsLogLevel);
        if (h2 != null) {
            int i2 = 0;
            boolean z = false;
            while (i2 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (stackTraceElement.getClassName().equals(DeviceLog.class.getName())) {
                    z = true;
                }
                if (!stackTraceElement.getClassName().equals(DeviceLog.class.getName()) && z) {
                    break;
                }
                i2++;
            }
            StackTraceElement stackTraceElement2 = i2 < stackTrace.length ? stackTrace[i2] : null;
            if (stackTraceElement2 != null) {
                return new com.unity3d.splash.services.core.log.a(h2, str, stackTraceElement2);
            }
            return null;
        }
        return null;
    }

    public static void c(String str) {
        if (f8464d || f8465e) {
            if (str.length() <= 3072) {
                l(UnityAdsLogLevel.DEBUG, a(str));
                return;
            }
            c(str.substring(0, 3072));
            if (str.length() < 30720) {
                c(str.substring(3072));
            }
        }
    }

    public static void d(String str, Object... objArr) {
        c(String.format(str, objArr));
    }

    public static void e() {
        c("ENTERED METHOD");
    }

    public static void f(String str) {
        l(UnityAdsLogLevel.ERROR, a(str));
    }

    public static void g(String str, Exception exc) {
        String str2 = "";
        if (str != null) {
            str2 = "" + str;
        }
        if (exc != null) {
            str2 = str2 + ": " + exc.getMessage();
        }
        if (exc != null && exc.getCause() != null) {
            str2 = str2 + ": " + exc.getCause().getMessage();
        }
        l(UnityAdsLogLevel.ERROR, str2);
    }

    private static b h(UnityAdsLogLevel unityAdsLogLevel) {
        return (b) f8466f.get(unityAdsLogLevel);
    }

    public static void i(String str) {
        l(UnityAdsLogLevel.INFO, a(str));
    }

    public static void j(int i2) {
        if (i2 >= 8) {
            a = true;
            b = true;
            c = true;
            f8464d = true;
        } else if (i2 >= 4) {
            a = true;
            b = true;
            c = true;
            f8464d = false;
        } else if (i2 >= 2) {
            a = true;
            b = true;
            c = false;
            f8464d = false;
        } else if (i2 > 0) {
            a = true;
            b = false;
            c = false;
            f8464d = false;
        } else {
            a = false;
            b = false;
            c = false;
            f8464d = false;
        }
    }

    public static void k(String str) {
        l(UnityAdsLogLevel.WARNING, a(str));
    }

    private static void l(UnityAdsLogLevel unityAdsLogLevel, String str) {
        int i2 = a.a[unityAdsLogLevel.ordinal()];
        if (f8465e ? true : i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? true : a : b : f8464d : c) {
            m(b(unityAdsLogLevel, str));
        }
    }

    private static void m(com.unity3d.splash.services.core.log.a aVar) {
        Method method;
        if (aVar == null || aVar.a() == null) {
            return;
        }
        try {
            method = Log.class.getMethod(aVar.a().b(), String.class, String.class);
        } catch (Exception e2) {
            Log.e("UnityAds", "Writing to log failed!", e2);
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(null, aVar.a().a(), aVar.b());
            } catch (Exception e3) {
                Log.e("UnityAds", "Writing to log failed!", e3);
            }
        }
    }
}
