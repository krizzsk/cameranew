package com.ironsource.mediationsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class ContextProvider {

    /* renamed from: e  reason: collision with root package name */
    private static volatile ContextProvider f5651e;
    private Activity a;
    private Context b;

    /* renamed from: d  reason: collision with root package name */
    private Handler f5652d = new Handler(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public interface a {
    }

    private ContextProvider() {
    }

    public static ContextProvider getInstance() {
        if (f5651e == null) {
            synchronized (ContextProvider.class) {
                if (f5651e == null) {
                    f5651e = new ContextProvider();
                }
            }
        }
        return f5651e;
    }

    public Context a() {
        Activity activity;
        Context context = this.b;
        return (context != null || (activity = this.a) == null) ? context : activity.getApplicationContext();
    }

    public Activity b() {
        return this.a;
    }

    public void c(Runnable runnable) {
        Handler handler = this.f5652d;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public void d(a aVar) {
        this.c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public void e(Runnable runnable) {
        Activity activity = this.a;
        if (activity != null) {
            activity.runOnUiThread(runnable);
        }
    }

    public void f(Activity activity) {
        if (activity != null) {
            this.a = activity;
        }
    }

    public void g(Context context) {
        if (context != null) {
            this.b = context;
        }
    }
}
