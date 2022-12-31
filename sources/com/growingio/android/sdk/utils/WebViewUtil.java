package com.growingio.android.sdk.utils;

import android.webkit.WebView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class WebViewUtil {
    private static final String TAG = "GIO.WebViewUtil";

    public static boolean isDestroyed(WebView webView) {
        Object obj;
        try {
            Field declaredField = WebView.class.getDeclaredField("mProvider");
            declaredField.setAccessible(true);
            obj = declaredField.get(webView);
        } catch (Exception e2) {
            LogUtil.d(TAG, "isDestroyed() should ignore: ", e2.getMessage());
        }
        if ("android.webkit.WebViewClassic".equals(obj)) {
            return isDestroyedWebViewClassic(obj);
        }
        Field declaredField2 = obj.getClass().getDeclaredField("mAwContents");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(obj);
        Method declaredMethod = obj2.getClass().getDeclaredMethod("isDestroyed", Integer.TYPE);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(obj2, 0);
        if (invoke instanceof Boolean) {
            return ((Boolean) invoke).booleanValue();
        }
        return false;
    }

    private static boolean isDestroyedWebViewClassic(Object obj) throws Exception {
        Field declaredField = obj.getClass().getDeclaredField("mWebViewCore");
        declaredField.setAccessible(true);
        return declaredField.get(obj) == null;
    }
}
