package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: InAppPurchaseActivityLifecycleTracker.java */
/* loaded from: classes.dex */
public class g {
    private static final String a = "com.facebook.appevents.internal.g";
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static Boolean c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f2310d = null;

    /* renamed from: e  reason: collision with root package name */
    private static ServiceConnection f2311e;

    /* renamed from: f  reason: collision with root package name */
    private static Application.ActivityLifecycleCallbacks f2312f;

    /* renamed from: g  reason: collision with root package name */
    private static Intent f2313g;

    /* renamed from: h  reason: collision with root package name */
    private static Object f2314h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InAppPurchaseActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Object unused = g.f2314h = h.a(com.facebook.f.f(), iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InAppPurchaseActivityLifecycleTracker.java */
    /* loaded from: classes.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {

        /* compiled from: InAppPurchaseActivityLifecycleTracker.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.facebook.internal.instrument.e.a.c(this)) {
                    return;
                }
                try {
                    Context f2 = com.facebook.f.f();
                    g.f(f2, h.i(f2, g.f2314h), false);
                    g.f(f2, h.j(f2, g.f2314h), true);
                } catch (Throwable th) {
                    com.facebook.internal.instrument.e.a.b(th, this);
                }
            }
        }

        /* compiled from: InAppPurchaseActivityLifecycleTracker.java */
        /* renamed from: com.facebook.appevents.internal.g$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0078b implements Runnable {
            RunnableC0078b(b bVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.facebook.internal.instrument.e.a.c(this)) {
                    return;
                }
                try {
                    Context f2 = com.facebook.f.f();
                    ArrayList<String> i2 = h.i(f2, g.f2314h);
                    if (i2.isEmpty()) {
                        i2 = h.g(f2, g.f2314h);
                    }
                    g.f(f2, i2, false);
                } catch (Throwable th) {
                    com.facebook.internal.instrument.e.a.b(th, this);
                }
            }
        }

        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                com.facebook.f.p().execute(new a(this));
            } catch (Exception unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            try {
                if (g.f2310d.booleanValue() && activity.getLocalClassName().equals("com.android.billingclient.api.ProxyBillingActivity")) {
                    com.facebook.f.p().execute(new RunnableC0078b(this));
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void e() {
        if (c != null) {
            return;
        }
        try {
            Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
            Boolean bool = Boolean.TRUE;
            c = bool;
            try {
                Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                f2310d = bool;
            } catch (ClassNotFoundException unused) {
                f2310d = Boolean.FALSE;
            }
            h.b();
            f2313g = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
            f2311e = new a();
            f2312f = new b();
        } catch (ClassNotFoundException unused2) {
            c = Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, ArrayList<String> arrayList, boolean z) {
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                String string = new JSONObject(next).getString("productId");
                hashMap.put(string, next);
                arrayList2.add(string);
            } catch (JSONException e2) {
                Log.e(a, "Error parsing in-app purchase data.", e2);
            }
        }
        for (Map.Entry<String, String> entry : h.k(context, arrayList2, f2314h, z).entrySet()) {
            c.f((String) hashMap.get(entry.getKey()), entry.getValue(), z);
        }
    }

    private static void g() {
        if (b.compareAndSet(false, true)) {
            Context f2 = com.facebook.f.f();
            if (f2 instanceof Application) {
                ((Application) f2).registerActivityLifecycleCallbacks(f2312f);
                f2.bindService(f2313g, f2311e, 1);
            }
        }
    }

    public static void h() {
        e();
        if (c.booleanValue() && c.c()) {
            g();
        }
    }
}
