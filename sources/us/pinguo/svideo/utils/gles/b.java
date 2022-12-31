package us.pinguo.svideo.utils.gles;

import android.view.Surface;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: EglRecordEnv.java */
/* loaded from: classes6.dex */
public class b {
    private e a;
    private a b;

    public b(Surface surface, EGLContext eGLContext, boolean z, int i2) {
        a aVar = new a(eGLContext, i2);
        this.b = aVar;
        this.a = new e(aVar, surface, z);
    }

    public void a() {
        this.a.b();
    }

    public void b(EGLSurface eGLSurface) {
        this.a.c(eGLSurface);
    }

    public void c(boolean z) {
        if (z) {
            this.a.f();
        }
        this.b.j();
    }

    public void d(boolean z) {
        if (z) {
            this.a.f();
        }
        this.b.i();
    }

    public void e() {
        this.a.e();
    }
}
