package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public final class gr {
    private static Activity b;
    private static final by c = new by();

    /* renamed from: d  reason: collision with root package name */
    private static final by f7583d = new by();
    public static final ba a = new ba() { // from class: com.tapjoy.internal.gr.1
        @Override // com.tapjoy.internal.ba
        public final boolean a(Runnable runnable) {
            GLSurfaceView gLSurfaceView = (GLSurfaceView) gr.c.a();
            if (gLSurfaceView != null) {
                gLSurfaceView.queueEvent(runnable);
                return true;
            }
            return false;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GLSurfaceView gLSurfaceView) {
        c.a(gLSurfaceView);
        gLSurfaceView.queueEvent(new Runnable() { // from class: com.tapjoy.internal.gr.2
            @Override // java.lang.Runnable
            public final void run() {
                gr.f7583d.a(Thread.currentThread());
            }
        });
    }

    public static Thread b() {
        return (Thread) f7583d.a();
    }

    public static Activity a() {
        Activity activity = b;
        return activity == null ? b.a() : activity;
    }
}
