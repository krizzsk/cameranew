package us.pinguo.edit2020.model.e;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.model.e.e;
/* compiled from: TextureRenderHandler.kt */
/* loaded from: classes4.dex */
public final class h {
    private final e.a a;
    private e b;
    private Handler c;

    /* renamed from: d  reason: collision with root package name */
    private EGLContext f10566d;

    public h(e.a listener) {
        s.h(listener, "listener");
        this.a = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(h this$0, EGLContext shareCtx, SurfaceTexture surfaceTexture) {
        s.h(this$0, "this$0");
        s.h(shareCtx, "$shareCtx");
        s.h(surfaceTexture, "$surfaceTexture");
        e eVar = this$0.b;
        if (eVar == null) {
            return;
        }
        eVar.c(shareCtx, surfaceTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Runnable runnable, h this$0, kotlin.jvm.b.a aVar) {
        s.h(runnable, "$runnable");
        s.h(this$0, "this$0");
        runnable.run();
        e eVar = this$0.b;
        if (eVar != null) {
            eVar.e();
        }
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    public final void a() {
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        e eVar = this.b;
        if (eVar == null) {
            return;
        }
        eVar.quitSafely();
    }

    public final void b(final SurfaceTexture surfaceTexture) {
        Handler handler;
        s.h(surfaceTexture, "surfaceTexture");
        final EGLContext eGLContext = this.f10566d;
        if (eGLContext == null || e() || (handler = this.c) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: us.pinguo.edit2020.model.e.c
            @Override // java.lang.Runnable
            public final void run() {
                h.c(h.this, eGLContext, surfaceTexture);
            }
        });
    }

    public final void d() {
        if (this.f10566d != null) {
            return;
        }
        EGL egl = EGLContext.getEGL();
        Objects.requireNonNull(egl, "null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        this.f10566d = ((EGL10) egl).eglGetCurrentContext();
        e eVar = new e(this.a);
        eVar.start();
        this.c = new Handler(eVar.getLooper());
        this.b = eVar;
    }

    public final boolean e() {
        e eVar = this.b;
        if (eVar == null) {
            return false;
        }
        return eVar.d();
    }

    public final void h(final Runnable runnable, final kotlin.jvm.b.a<u> aVar) {
        Handler handler;
        s.h(runnable, "runnable");
        if (e() && (handler = this.c) != null) {
            handler.post(new Runnable() { // from class: us.pinguo.edit2020.model.e.d
                @Override // java.lang.Runnable
                public final void run() {
                    h.i(runnable, this, aVar);
                }
            });
        }
    }

    public final void j(Runnable runnable) {
        s.h(runnable, "runnable");
        Handler handler = this.c;
        if (handler == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }
}
