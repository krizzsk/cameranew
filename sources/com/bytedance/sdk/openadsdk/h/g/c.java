package com.bytedance.sdk.openadsdk.h.g;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.o;
import java.lang.reflect.Method;
/* compiled from: StorageList.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static volatile c f2061e;
    private Context a;
    private Object b;
    private Method c;

    /* renamed from: d  reason: collision with root package name */
    private Method f2062d;

    private c() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.f2062d = null;
        Context a = o.a();
        this.a = a;
        if (a != null) {
            Object systemService = a.getSystemService("storage");
            this.b = systemService;
            try {
                this.c = systemService.getClass().getMethod("getVolumeList", new Class[0]);
                this.f2062d = this.b.getClass().getMethod("getVolumeState", String.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c a() {
        if (f2061e == null) {
            synchronized (c.class) {
                if (f2061e == null) {
                    f2061e = new c();
                }
            }
        }
        return f2061e;
    }

    public boolean b() {
        Method method;
        Object obj = this.b;
        if (obj != null && (method = this.c) != null && this.f2062d != null) {
            try {
                Object[] objArr = (Object[]) method.invoke(obj, new Object[0]);
                if (objArr != null && objArr.length != 0) {
                    Method method2 = objArr[0].getClass().getMethod("getPath", new Class[0]);
                    Method method3 = objArr[0].getClass().getMethod("isEmulated", new Class[0]);
                    if (method2 != null && method3 != null) {
                        for (Object obj2 : objArr) {
                            if (((Boolean) method3.invoke(obj2, new Object[0])).booleanValue() && this.f2062d.invoke(this.b, (String) method2.invoke(obj2, new Object[0])).equals("mounted")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
