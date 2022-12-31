package com.bytedance.sdk.adnet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.adnet.c.f;
import com.bytedance.sdk.adnet.core.k;
import com.bytedance.sdk.adnet.core.l;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.d.c;
import com.bytedance.sdk.adnet.face.IHttpStack;
import java.io.File;
/* compiled from: AdNetSdk.java */
/* loaded from: classes.dex */
public class a {
    public static n a = null;
    private static String b = null;
    private static b c = null;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f1159d = true;

    /* renamed from: e  reason: collision with root package name */
    private static com.bytedance.sdk.adnet.c.a f1160e;

    public static l a(Context context) {
        return k.a(context);
    }

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                File file = new File(context.getCacheDir(), "VAdNetSdk");
                file.mkdirs();
                b = file.getAbsolutePath();
            }
        } catch (Throwable th) {
            o.a(th, "init adnetsdk default directory error ", new Object[0]);
        }
        return b;
    }

    public static void c() {
        c.a(c.a.DEBUG);
    }

    public static com.bytedance.sdk.adnet.c.a d() {
        return f1160e;
    }

    public static l a(Context context, IHttpStack iHttpStack) {
        return k.a(context, iHttpStack);
    }

    public static void a(b bVar) {
        c = bVar;
    }

    public static b a() {
        b bVar = c;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static void a(boolean z) {
        f1159d = z;
    }

    public static void a(com.bytedance.sdk.adnet.c.a aVar) {
        f1160e = aVar;
    }

    public static boolean b() {
        return f1159d;
    }

    public static void a(Context context, Application application, boolean z) {
        if (context != null) {
            f.a().a(context, com.bytedance.sdk.adnet.d.f.b(context));
            if (com.bytedance.sdk.adnet.d.f.a(context) || (!com.bytedance.sdk.adnet.d.f.b(context) && z)) {
                com.bytedance.sdk.adnet.a.a.a(context).c();
                com.bytedance.sdk.adnet.a.a.a(context).a();
            }
            if (com.bytedance.sdk.adnet.d.f.b(context)) {
                com.bytedance.sdk.adnet.a.a.a(context);
                if (application != null) {
                    application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.sdk.adnet.a.1
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
                            a.a(activity);
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStarted(Activity activity) {
                        }

                        @Override // android.app.Application.ActivityLifecycleCallbacks
                        public void onActivityStopped(Activity activity) {
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("tryInitAdTTNet context is null");
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        new Thread("load_config") { // from class: com.bytedance.sdk.adnet.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                com.bytedance.sdk.adnet.a.a.a(applicationContext).c();
                com.bytedance.sdk.adnet.a.a.a(applicationContext);
                com.bytedance.sdk.adnet.a.a.b(applicationContext);
            }
        }.start();
    }
}
