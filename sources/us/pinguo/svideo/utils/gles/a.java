package us.pinguo.svideo.utils.gles;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: EglCore.java */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: l  reason: collision with root package name */
    private static int f12073l = 12440;
    private EGLDisplay a;
    private EGLContext b;
    private EGLConfig c;

    /* renamed from: d  reason: collision with root package name */
    private EGL10 f12074d;

    /* renamed from: e  reason: collision with root package name */
    protected int f12075e;

    /* renamed from: f  reason: collision with root package name */
    protected int f12076f;

    /* renamed from: g  reason: collision with root package name */
    protected int f12077g;

    /* renamed from: h  reason: collision with root package name */
    protected int f12078h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12079i;

    /* renamed from: j  reason: collision with root package name */
    protected int f12080j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f12081k;

    public a(EGLContext eGLContext, int i2) {
        EGLDisplay eGLDisplay = EGL10.EGL_NO_DISPLAY;
        this.a = eGLDisplay;
        this.b = EGL10.EGL_NO_CONTEXT;
        EGLConfig eGLConfig = null;
        this.c = null;
        this.f12075e = 8;
        this.f12076f = 8;
        this.f12077g = 8;
        this.f12078h = 8;
        this.f12079i = 0;
        this.f12080j = 0;
        this.f12081k = new int[1];
        if (eGLDisplay == EGL10.EGL_NO_DISPLAY) {
            eGLContext = eGLContext == null ? EGL10.EGL_NO_CONTEXT : eGLContext;
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f12074d = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.a = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("unable to get EGL14 display");
            }
            if (this.f12074d.eglInitialize(eglGetDisplay, new int[2])) {
                if ((i2 & 2) != 0) {
                    us.pinguo.svideo.utils.b.c("Trying GLES 3", new Object[0]);
                    try {
                        eGLConfig = b(this.f12074d, this.a, 3);
                    } catch (Exception unused) {
                    }
                    if (eGLConfig != null) {
                        EGLContext eglCreateContext = this.f12074d.eglCreateContext(this.a, eGLConfig, eGLContext, new int[]{f12073l, 3, 12344});
                        if (this.f12074d.eglGetError() == 12288) {
                            this.c = eGLConfig;
                            this.b = eglCreateContext;
                        }
                    }
                }
                if (this.b == EGL10.EGL_NO_CONTEXT) {
                    us.pinguo.svideo.utils.b.c("Trying GLES 2", new Object[0]);
                    EGLConfig b = b(this.f12074d, this.a, 2);
                    if (b != null) {
                        EGLContext eglCreateContext2 = this.f12074d.eglCreateContext(this.a, b, eGLContext, new int[]{f12073l, 2, 12344});
                        a("eglCreateContext");
                        this.c = b;
                        this.b = eglCreateContext2;
                    } else {
                        throw new RuntimeException("Unable to find a suitable EGLConfig");
                    }
                }
                int[] iArr = new int[1];
                this.f12074d.eglQueryContext(this.a, this.b, f12073l, iArr);
                Log.d("Grafika", "EGLContext created, client version " + iArr[0]);
                return;
            }
            this.a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("EGL already set up");
    }

    private void a(String str) {
        int eglGetError = this.f12074d.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    @TargetApi(18)
    private int[] e(int[] iArr, int i2) {
        if (i2 == 2 || i2 == 3) {
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
            if (i2 == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }
        return iArr;
    }

    private int f(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, int i3) {
        return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f12081k) ? this.f12081k[0] : i3;
    }

    public EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, int i2) {
        int[] e2 = e(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344}, i2);
        int[] iArr = new int[1];
        if (egl10.eglChooseConfig(eGLDisplay, e2, null, 0, iArr)) {
            int i3 = iArr[0];
            if (i3 > 0) {
                EGLConfig[] eGLConfigArr = new EGLConfig[i3];
                if (egl10.eglChooseConfig(eGLDisplay, e2, eGLConfigArr, i3, iArr)) {
                    EGLConfig c = c(egl10, eGLDisplay, eGLConfigArr);
                    if (c != null) {
                        return c;
                    }
                    throw new IllegalArgumentException("No config chosen");
                }
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            throw new IllegalArgumentException("No configs match configSpec");
        }
        throw new IllegalArgumentException("eglChooseConfig failed");
    }

    public EGLConfig c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int f2 = f(egl10, eGLDisplay, eGLConfig, 12325, 0);
            int f3 = f(egl10, eGLDisplay, eGLConfig, 12326, 0);
            if (f2 >= this.f12079i && f3 >= this.f12080j) {
                int f4 = f(egl10, eGLDisplay, eGLConfig, 12324, 0);
                int f5 = f(egl10, eGLDisplay, eGLConfig, 12323, 0);
                int f6 = f(egl10, eGLDisplay, eGLConfig, 12322, 0);
                int f7 = f(egl10, eGLDisplay, eGLConfig, 12321, 0);
                if (f4 == this.f12075e && f5 == this.f12076f && f6 == this.f12077g && f7 == this.f12078h) {
                    return eGLConfig;
                }
            }
        }
        return null;
    }

    public EGLSurface d(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = this.f12074d.eglCreateWindowSurface(this.a, this.c, obj, new int[]{12344});
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.a != EGL10.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                i();
            }
        } finally {
            super.finalize();
        }
    }

    public void g(EGLSurface eGLSurface) {
        if (this.a == EGL10.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!this.f12074d.eglMakeCurrent(this.a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void h(EGLSurface eGLSurface, EGLSurface eGLSurface2) {
        if (this.a == EGL10.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!this.f12074d.eglMakeCurrent(this.a, eGLSurface, eGLSurface2, this.b)) {
            throw new RuntimeException("eglMakeCurrent(draw,read) failed");
        }
    }

    public void i() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.f12074d;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.f12074d.eglDestroyContext(this.a, this.b);
            this.f12074d.eglTerminate(this.a);
        }
        this.a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.c = null;
    }

    public void j() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
            this.f12074d.eglDestroyContext(eGLDisplay, this.b);
            this.f12074d.eglTerminate(this.a);
        }
        this.a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.c = null;
    }

    public void k(EGLSurface eGLSurface) {
        this.f12074d.eglDestroySurface(this.a, eGLSurface);
    }

    public boolean l(EGLSurface eGLSurface) {
        return this.f12074d.eglSwapBuffers(this.a, eGLSurface);
    }
}
