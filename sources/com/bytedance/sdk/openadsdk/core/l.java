package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.coremedia.iso.boxes.UserBox;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: InitHelper.java */
/* loaded from: classes.dex */
public class l {
    public static volatile boolean a = false;
    private static AtomicBoolean b = new AtomicBoolean(false);

    public static void a(Context context) {
        if (b.get()) {
            return;
        }
        synchronized (TTAdManagerFactory.class) {
            if (!b.get()) {
                c(context);
                b.set(true);
            }
        }
    }

    private static void c(final Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        Log.d("InitHelper", "init start: " + a);
        o.a(context.getApplicationContext());
        if (com.bytedance.sdk.openadsdk.core.g.g.a()) {
            com.bytedance.sdk.openadsdk.multipro.d.a(context);
            if (a) {
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.d(context);
                    }
                });
            } else {
                d(context);
            }
            Log.d("InitHelper", "init over: " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        e(context);
        g(context);
        com.bytedance.sdk.openadsdk.utils.y.a();
        o.h().a();
        ac.a(context);
        f(context);
        o.c().a();
        o.e().a();
        o.d().a();
        o.j().a();
        o.g().a();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
        com.bytedance.sdk.openadsdk.core.video.c.a.a().b();
        a();
        Log.d("InitHelper", "do async task: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static void e(Context context) {
        com.bytedance.embedapplog.b bVar = new com.bytedance.embedapplog.b(String.valueOf(1181), "openadsdk");
        bVar.a(1);
        com.bytedance.embedapplog.a.a(com.bytedance.sdk.openadsdk.utils.o.c());
        com.bytedance.embedapplog.a.a(context, bVar);
    }

    private static void f(Context context) {
        d.a(context).a(UserBox.TYPE, UUID.randomUUID().toString());
    }

    private static void g(Context context) {
    }

    private static void a() {
        Context a2;
        if (o.h().d() && (a2 = o.a()) != null) {
            try {
                com.bytedance.sdk.adnet.a.a(new com.bytedance.sdk.openadsdk.g.c(a2));
                com.bytedance.sdk.adnet.a.a(true);
                com.bytedance.sdk.adnet.a.a(a2, (Application) a2, com.bytedance.sdk.openadsdk.multipro.b.b());
            } catch (Exception unused) {
            }
        }
    }
}
