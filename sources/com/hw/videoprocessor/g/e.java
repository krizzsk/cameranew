package com.hw.videoprocessor.g;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
/* compiled from: OutputSurface.java */
@TargetApi(16)
/* loaded from: classes2.dex */
public class e implements SurfaceTexture.OnFrameAvailableListener {
    private EGL10 a;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f5280e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f5281f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5283h;

    /* renamed from: i  reason: collision with root package name */
    private g f5284i;
    private EGLDisplay b = null;
    private EGLContext c = null;

    /* renamed from: d  reason: collision with root package name */
    private EGLSurface f5279d = null;

    /* renamed from: g  reason: collision with root package name */
    private final Object f5282g = new Object();

    /* renamed from: j  reason: collision with root package name */
    private int f5285j = 0;

    public e() {
        e();
    }

    private void e() {
        g gVar = new g(this.f5285j);
        this.f5284i = gVar;
        gVar.f();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5284i.d());
        this.f5280e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f5281f = new Surface(this.f5280e);
    }

    public void a() {
        synchronized (this.f5282g) {
            while (!this.f5283h) {
                try {
                    this.f5282g.wait(5000L);
                    if (!this.f5283h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f5283h = false;
        }
        this.f5284i.a("before updateTexImage");
        this.f5280e.updateTexImage();
    }

    public void b(boolean z) {
        this.f5284i.c(this.f5280e, z);
    }

    public Surface c() {
        return this.f5281f;
    }

    public void d() {
        EGL10 egl10 = this.a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.c)) {
                EGL10 egl102 = this.a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.a.eglDestroySurface(this.b, this.f5279d);
            this.a.eglDestroyContext(this.b, this.c);
        }
        this.f5281f.release();
        this.b = null;
        this.c = null;
        this.f5279d = null;
        this.a = null;
        this.f5284i = null;
        this.f5281f = null;
        this.f5280e = null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f5282g) {
            if (!this.f5283h) {
                this.f5283h = true;
                this.f5282g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
