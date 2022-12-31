package com.hw.photomovie.render;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.hw.photomovie.d.f;
import com.hw.photomovie.segment.e;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* compiled from: GLSurfaceMovieRenderer.java */
/* loaded from: classes2.dex */
public class b extends a implements GLSurfaceView.Renderer {
    private GLSurfaceView o;
    protected volatile boolean p;
    protected boolean q = false;
    protected AtomicBoolean r = new AtomicBoolean(false);

    @Override // com.hw.photomovie.render.d
    public void a(int i2) {
        this.b = i2;
        if (this.p && !this.q) {
            this.o.requestRender();
        } else {
            onDrawFrame(null);
        }
    }

    @Override // com.hw.photomovie.render.d
    public void e() {
        this.r.set(true);
        if (this.p) {
            this.o.requestRender();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        if (this.r.get()) {
            this.r.set(false);
            GLES20.glClear(16384);
            b(this.b);
            o();
            return;
        }
        GLES20.glClear(16384);
        b(this.b);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        u(i2, i3);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.p = true;
        this.r.set(false);
        com.hw.photomovie.moviefilter.a aVar = this.f5211j;
        if (aVar != null) {
            aVar.release();
        }
        p();
        s();
    }

    public boolean r() {
        return this.p;
    }

    public void s() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        i(new com.hw.photomovie.d.d());
        e<T> eVar = this.f5217g;
        if (eVar != 0) {
            eVar.r();
        }
    }

    public void t(boolean z) {
        this.q = z;
    }

    public void u(int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        ((f) this.f5214d).c(i2, i3);
        g(0, 0, i2, i3);
    }
}
