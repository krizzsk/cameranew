package us.pinguo.svideo.utils.gles;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: EglSurfaceBase.java */
/* loaded from: classes6.dex */
public class c {
    protected a a;
    private EGLSurface b = EGL10.EGL_NO_SURFACE;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(a aVar) {
        this.a = aVar;
    }

    public void a(Object obj) {
        if (this.b == EGL10.EGL_NO_SURFACE) {
            this.b = this.a.d(obj);
            return;
        }
        throw new IllegalStateException("surface already created");
    }

    public void b() {
        this.a.g(this.b);
    }

    public void c(EGLSurface eGLSurface) {
        this.a.h(this.b, eGLSurface);
    }

    public void d() {
        this.a.k(this.b);
        this.b = EGL10.EGL_NO_SURFACE;
    }

    public boolean e() {
        boolean l2 = this.a.l(this.b);
        if (!l2) {
            Log.d("Grafika", "WARNING: swapBuffers() failed");
        }
        return l2;
    }
}
