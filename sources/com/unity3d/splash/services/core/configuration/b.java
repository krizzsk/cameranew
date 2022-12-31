package com.unity3d.splash.services.core.configuration;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class b {
    private static boolean a(Method method) {
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        Annotation[] annotations = method.getAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof JavascriptInterface) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b() {
        return d() && c();
    }

    public static boolean c() {
        if (com.unity3d.splash.services.c.b.b.a() != null) {
            DeviceLog.c("Unity Ads cache directory check OK");
            return true;
        }
        DeviceLog.f("Unity Ads cache directory check fail: no working cache directory available");
        return false;
    }

    public static boolean d() {
        String str;
        try {
            Class<?> cls = Class.forName("com.unity3d.splash.services.core.webview.bridge.d");
            Method method = cls.getMethod("handleInvocation", String.class);
            Method method2 = cls.getMethod("handleCallback", String.class, String.class, String.class);
            if (a(method) && a(method2)) {
                DeviceLog.c("Unity Ads ProGuard check OK");
                return true;
            }
            DeviceLog.f("Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge");
            return false;
        } catch (ClassNotFoundException e2) {
            e = e2;
            str = "Unity Ads ProGuard check fail: Unity Ads web bridge class not found";
            DeviceLog.g(str, e);
            return false;
        } catch (NoSuchMethodException e3) {
            e = e3;
            str = "Unity Ads ProGuard check fail: Unity Ads web bridge methods not found";
            DeviceLog.g(str, e);
            return false;
        } catch (Exception e4) {
            DeviceLog.g("Unknown exception during Unity Ads ProGuard check: " + e4.getMessage(), e4);
            return true;
        }
    }
}
