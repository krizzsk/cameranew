package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: OutputSurface.java */
@TargetApi(16)
/* loaded from: classes9.dex */
public class d implements SurfaceTexture.OnFrameAvailableListener {
    private EGL10 a;
    private EGLDisplay b;
    private EGLContext c;

    /* renamed from: d  reason: collision with root package name */
    private EGLSurface f11273d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f11274e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f11275f;

    /* renamed from: g  reason: collision with root package name */
    private final Object f11276g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11277h;

    /* renamed from: i  reason: collision with root package name */
    private f f11278i;

    /* renamed from: j  reason: collision with root package name */
    private int f11279j;

    /* renamed from: k  reason: collision with root package name */
    private int f11280k;

    /* renamed from: l  reason: collision with root package name */
    private int f11281l;
    private ByteBuffer m;

    public d(int i2, int i3, int i4) {
        this.b = null;
        this.c = null;
        this.f11273d = null;
        this.f11276g = new Object();
        this.f11281l = 0;
        if (i2 > 0 && i3 > 0) {
            this.f11279j = i2;
            this.f11280k = i3;
            this.f11281l = i4;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i3 * 4);
            this.m = allocateDirect;
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            d(i2, i3);
            g();
            i();
            return;
        }
        throw new IllegalArgumentException();
    }

    private void b(String str) {
        if (this.a.eglGetError() != 12288) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void d(int i2, int i3) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (!this.a.eglInitialize(eglGetDisplay, null)) {
                this.b = null;
                throw new RuntimeException("unable to initialize EGL10");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.a.eglChooseConfig(this.b, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                this.c = this.a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                b("eglCreateContext");
                if (this.c != null) {
                    this.f11273d = this.a.eglCreatePbufferSurface(this.b, eGLConfigArr[0], new int[]{12375, i2, 12374, i3, 12344});
                    b("eglCreatePbufferSurface");
                    if (this.f11273d == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        throw new RuntimeException("unable to get EGL10 display");
    }

    private void i() {
        f fVar = new f(this.f11281l);
        this.f11278i = fVar;
        fVar.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f11278i.d());
        this.f11274e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f11275f = new Surface(this.f11274e);
    }

    public void a() {
        synchronized (this.f11276g) {
            while (!this.f11277h) {
                try {
                    this.f11276g.wait(5000L);
                    if (!this.f11277h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f11277h = false;
        }
        this.f11278i.a("before updateTexImage");
        this.f11274e.updateTexImage();
    }

    public void c(boolean z) {
        this.f11278i.c(this.f11274e, z);
    }

    public ByteBuffer e() {
        this.m.rewind();
        GLES20.glReadPixels(0, 0, this.f11279j, this.f11280k, 6408, 5121, this.m);
        return this.m;
    }

    public Surface f() {
        return this.f11275f;
    }

    public void g() {
        if (this.a != null) {
            b("before makeCurrent");
            EGL10 egl10 = this.a;
            EGLDisplay eGLDisplay = this.b;
            EGLSurface eGLSurface = this.f11273d;
            if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c)) {
                throw new RuntimeException("eglMakeCurrent failed");
            }
            return;
        }
        throw new RuntimeException("not configured for makeCurrent");
    }

    public void h() {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.c)) {
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.a.eglDestroySurface(this.b, this.f11273d);
            this.a.eglDestroyContext(this.b, this.c);
        }
        this.f11275f.release();
        this.b = null;
        this.c = null;
        this.f11273d = null;
        this.a = null;
        this.f11278i = null;
        this.f11275f = null;
        this.f11274e = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f11276g) {
            if (!this.f11277h) {
                this.f11277h = true;
                this.f11276g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }

    public d() {
        this.b = null;
        this.c = null;
        this.f11273d = null;
        this.f11276g = new Object();
        this.f11281l = 0;
        i();
    }
}
