package com.unity3d.splash.services.core.webview.bridge;

import com.unity3d.splash.services.core.log.DeviceLog;
import com.unity3d.splash.services.core.webview.WebViewApp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static AtomicInteger f8478d = new AtomicInteger(0);

    /* renamed from: e  reason: collision with root package name */
    private static Map f8479e;
    private ArrayList a;
    private ArrayList b;
    private int c = f8478d.getAndIncrement();

    public a() {
        if (f8479e == null) {
            f8479e = new HashMap();
        }
        f8479e.put(Integer.valueOf(this.c), this);
    }

    public static synchronized a c(int i2) {
        synchronized (a.class) {
            Map map = f8479e;
            if (map == null || !map.containsKey(Integer.valueOf(i2))) {
                return null;
            }
            return (a) f8479e.get(Integer.valueOf(i2));
        }
    }

    public void a(String str, String str2, Object[] objArr, WebViewCallback webViewCallback) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(objArr);
        arrayList.add(webViewCallback);
        this.a.add(arrayList);
    }

    public int b() {
        return this.c;
    }

    public ArrayList d() {
        return this.b;
    }

    public boolean e() {
        ArrayList arrayList = this.a;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        ArrayList arrayList2 = (ArrayList) this.a.remove(0);
        String str = (String) arrayList2.get(0);
        String str2 = (String) arrayList2.get(1);
        Object[] objArr = (Object[]) arrayList2.get(2);
        try {
            c.e(str, str2, objArr, (WebViewCallback) arrayList2.get(3));
        } catch (Exception e2) {
            DeviceLog.g(String.format("Error handling invocation %s.%s(%s)", str, str2, Arrays.toString(objArr)), e2);
        }
        return true;
    }

    public void f() {
        f8479e.remove(Integer.valueOf(b()));
        WebViewApp.e().g(this);
    }

    public void g(CallbackStatus callbackStatus, Enum r3, Object... objArr) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(callbackStatus);
        arrayList.add(r3);
        arrayList.add(objArr);
        this.b.add(arrayList);
    }
}
