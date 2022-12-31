package com.unity3d.splash.services.core.webview.bridge;

import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class b {
    private Method a;
    private String b;

    static {
        new AtomicInteger(0);
    }

    public String a() {
        return this.b;
    }

    public void b(String str, Object... objArr) {
        Object[] array;
        try {
            CallbackStatus valueOf = CallbackStatus.valueOf(str);
            if (objArr == null) {
                array = new Object[]{valueOf};
            } else {
                ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
                arrayList.add(0, valueOf);
                array = arrayList.toArray();
            }
            this.a.invoke(null, array);
            WebViewApp.e().j(this);
        } catch (Exception e2) {
            DeviceLog.f("Illegal status");
            WebViewApp.e().j(this);
            throw e2;
        }
    }
}
