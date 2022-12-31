package com.hw.videoprocessor.g;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import java.util.Objects;
/* compiled from: InputSurface.java */
@TargetApi(18)
/* loaded from: classes2.dex */
public class d {
    private EGLDisplay a;
    private EGLContext b;
    private EGLSurface c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f5278d;

    public d(Surface surface) {
        Objects.requireNonNull(surface);
        this.f5278d = surface;
        b();
    }

    private void a(String str) {
        boolean z = false;
        while (EGL14.eglGetError() != 12288) {
            z = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void b() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                this.a = null;
                throw new RuntimeException("unable to initialize EGL14");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.b = EGL14.eglCreateContext(this.a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                a("eglCreateContext");
                if (this.b != null) {
                    this.c = EGL14.eglCreateWindowSurface(this.a, eGLConfigArr[0], this.f5278d, new int[]{12344}, 0);
                    a("eglCreateWindowSurface");
                    if (this.c == null) {
                        throw new RuntimeException("surface was null");
                    }
                    return;
                }
                throw new RuntimeException("null context");
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void c() {
        EGLDisplay eGLDisplay = this.a;
        EGLSurface eGLSurface = this.c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public void d() {
        if (EGL14.eglGetCurrentContext().equals(this.b)) {
            EGLDisplay eGLDisplay = this.a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.a, this.c);
        EGL14.eglDestroyContext(this.a, this.b);
        this.f5278d.release();
        this.a = null;
        this.b = null;
        this.c = null;
        this.f5278d = null;
    }

    public void e(long j2) {
        EGLExt.eglPresentationTimeANDROID(this.a, this.c, j2);
    }

    public boolean f() {
        return EGL14.eglSwapBuffers(this.a, this.c);
    }
}
