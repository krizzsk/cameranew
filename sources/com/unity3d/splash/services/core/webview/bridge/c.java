package com.unity3d.splash.services.core.webview.bridge;

import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class c {
    private static HashMap a;

    private static Method a(String str, String str2, Object[] objArr) {
        if (a.containsKey(str)) {
            HashMap hashMap = (HashMap) a.get(str);
            if (hashMap.containsKey(str2)) {
                return (Method) ((HashMap) hashMap.get(str2)).get(Integer.valueOf(Arrays.deepHashCode(b(objArr))));
            }
            throw new NoSuchMethodException();
        }
        throw new NoSuchMethodException();
    }

    private static Class[] b(Object[] objArr) {
        Class[] clsArr = objArr == null ? new Class[1] : new Class[objArr.length + 1];
        if (objArr != null) {
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = objArr[i2].getClass();
            }
        }
        clsArr[clsArr.length - 1] = WebViewCallback.class;
        return clsArr;
    }

    private static Object[] c(Object[] objArr, WebViewCallback webViewCallback) {
        Object[] objArr2;
        if (objArr != null) {
            objArr2 = new Object[objArr.length + (webViewCallback != null ? 1 : 0)];
        } else if (webViewCallback == null) {
            return null;
        } else {
            objArr2 = new Object[1];
        }
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        if (webViewCallback != null) {
            objArr2[objArr2.length - 1] = webViewCallback;
        }
        return objArr2;
    }

    public static void d(String str, String str2, Object[] objArr) {
        try {
            WebViewApp.e().c(str).b(str2, c(objArr, null));
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e2) {
            DeviceLog.f("Error while invoking method");
            throw e2;
        }
    }

    public static void e(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) {
        try {
            try {
                a(str, str2, objArr).invoke(null, c(objArr, webViewCallback));
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | JSONException e2) {
                webViewCallback.a(WebViewBridgeError.INVOCATION_FAILED, str, str2, objArr, e2.getMessage());
                throw e2;
            }
        } catch (NoSuchMethodException | JSONException e3) {
            webViewCallback.a(WebViewBridgeError.METHOD_NOT_FOUND, str, str2, objArr);
            throw e3;
        }
    }

    public static void f(Class[] clsArr) {
        Method[] methods;
        if (clsArr == null) {
            return;
        }
        a = new HashMap();
        for (Class cls : clsArr) {
            if (cls != null && (cls.getPackage().getName().startsWith("com.unity3d.splash.services") || cls.getPackage().getName().startsWith("com.unity3d.splash.test"))) {
                HashMap hashMap = new HashMap();
                for (Method method : cls.getMethods()) {
                    if (method.getAnnotation(e.class) != null) {
                        String name = method.getName();
                        HashMap hashMap2 = hashMap.containsKey(name) ? (HashMap) hashMap.get(name) : new HashMap();
                        hashMap2.put(Integer.valueOf(Arrays.deepHashCode(method.getParameterTypes())), method);
                        hashMap.put(name, hashMap2);
                    }
                }
                a.put(cls.getName(), hashMap);
            }
        }
    }
}
