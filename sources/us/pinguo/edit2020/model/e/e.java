package us.pinguo.edit2020.model.e;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.HandlerThread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: GLRenderThread.java */
/* loaded from: classes4.dex */
public class e extends HandlerThread {
    private EGL10 a;
    private EGLDisplay b;
    private EGLContext c;

    /* renamed from: d  reason: collision with root package name */
    private EGLSurface f10550d;

    /* renamed from: e  reason: collision with root package name */
    private a f10551e;

    /* compiled from: GLRenderThread.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a();
    }

    public e(a aVar) {
        super("gl thread");
        this.b = EGL10.EGL_NO_DISPLAY;
        this.c = EGL10.EGL_NO_CONTEXT;
        this.f10550d = EGL10.EGL_NO_SURFACE;
        this.f10551e = null;
        this.f10551e = aVar;
    }

    private static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": glError 0x" + Integer.toHexString(glGetError));
    }

    private void b() {
        a aVar = this.f10551e;
        if (aVar != null) {
            aVar.a();
            this.f10551e = null;
        }
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            egl10.eglDestroyContext(this.b, this.c);
            this.a.eglDestroySurface(this.b, this.f10550d);
            this.c = EGL10.EGL_NO_CONTEXT;
            this.f10550d = EGL10.EGL_NO_SURFACE;
            this.a = null;
        }
    }

    public void c(EGLContext eGLContext, SurfaceTexture surfaceTexture) {
        if (this.a != null) {
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetdisplay failed : " + GLUtils.getEGLErrorString(this.a.eglGetError()));
        } else if (!this.a.eglInitialize(eglGetDisplay, new int[2])) {
            throw new RuntimeException("eglInitialize failed : " + GLUtils.getEGLErrorString(this.a.eglGetError()));
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (this.a.eglChooseConfig(this.b, new int[]{12320, 32, 12321, 8, 12322, 8, 12323, 8, 12324, 8, 12352, 4, 12339, 4, 12344}, eGLConfigArr, 1, new int[1])) {
                int[] iArr = {12440, 2, 12344};
                if (eGLContext != null) {
                    this.c = this.a.eglCreateContext(this.b, eGLConfigArr[0], eGLContext, iArr);
                } else {
                    this.c = this.a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, iArr);
                }
                this.f10550d = this.a.eglCreateWindowSurface(this.b, eGLConfigArr[0], surfaceTexture, new int[]{12344});
                a("eglCreateWindowSurface error");
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = this.f10550d;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c)) {
                    this.c.getGL();
                    return;
                }
                throw new RuntimeException("eglMakeCurrent failed : " + GLUtils.getEGLErrorString(this.a.eglGetError()));
            }
            throw new RuntimeException("eglChooseConfig failed : " + GLUtils.getEGLErrorString(this.a.eglGetError()));
        }
    }

    public boolean d() {
        return this.a != null;
    }

    public void e() {
        this.a.eglSwapBuffers(this.b, this.f10550d);
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        b();
    }
}
