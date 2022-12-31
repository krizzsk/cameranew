package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes3.dex */
public final class fn {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements InvocationHandler {
        private final Object a;
        private final Thread b;
        private final Looper c;

        public a(Object obj, Thread thread, Looper looper) {
            this.a = obj;
            this.b = thread;
            this.c = looper;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, final Method method, final Object[] objArr) {
            if (this.b == Thread.currentThread()) {
                return method.invoke(this.a, objArr);
            }
            if (method.getReturnType().equals(Void.TYPE)) {
                Runnable runnable = new Runnable() { // from class: com.tapjoy.internal.fn.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            method.invoke(a.this.a, objArr);
                        } catch (IllegalAccessException e2) {
                            throw jr.a(e2);
                        } catch (IllegalArgumentException e3) {
                            throw jr.a(e3);
                        } catch (InvocationTargetException e4) {
                            throw jr.a(e4);
                        }
                    }
                };
                if (this.c == null || !new Handler(this.c).post(runnable)) {
                    if (this.b == gr.b() && gr.a.a(runnable)) {
                        return null;
                    }
                    Looper mainLooper = Looper.getMainLooper();
                    if (mainLooper == null || !new Handler(mainLooper).post(runnable)) {
                        return method.invoke(this.a, objArr);
                    }
                    return null;
                }
                return null;
            }
            throw new UnsupportedOperationException("method not return void: " + method.getName());
        }
    }

    public static Object a(Object obj, Class cls) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(obj, Thread.currentThread(), Looper.myLooper()));
    }
}
