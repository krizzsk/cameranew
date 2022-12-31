package com.hw.photomovie.render;

import android.opengl.GLES20;
import com.hw.photomovie.render.GLTextureView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* compiled from: GLTextureMovieRender.java */
/* loaded from: classes2.dex */
public class c extends b {
    protected GLTextureView s;

    /* compiled from: GLTextureMovieRender.java */
    /* loaded from: classes2.dex */
    class a implements GLTextureView.n {
        a() {
        }

        @Override // com.hw.photomovie.render.GLTextureView.n
        public void a() {
            c.this.p = false;
            c.this.r.set(false);
        }

        @Override // com.hw.photomovie.render.GLTextureView.n
        public boolean onDrawFrame(GL10 gl10) {
            if (c.this.r.get()) {
                c.this.r.set(false);
                c.this.o();
                return false;
            }
            GLES20.glClear(16384);
            c cVar = c.this;
            cVar.b(cVar.b);
            return true;
        }

        @Override // com.hw.photomovie.render.GLTextureView.n
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            c.this.u(i2, i3);
        }

        @Override // com.hw.photomovie.render.GLTextureView.n
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            com.hw.photomovie.moviefilter.a aVar = c.this.f5211j;
            if (aVar != null) {
                aVar.release();
            }
            c.this.p();
            c.this.r.set(false);
            c.this.p = true;
            c.this.s();
        }
    }

    public c(GLTextureView gLTextureView) {
        this.s = gLTextureView;
        gLTextureView.setEGLContextClientVersion(2);
        this.s.setRenderer(new a());
        this.s.setRenderMode(0);
    }

    @Override // com.hw.photomovie.render.b, com.hw.photomovie.render.d
    public void a(int i2) {
        this.b = i2;
        if (this.q) {
            onDrawFrame(null);
        } else if (this.p) {
            this.s.n();
        } else {
            com.hw.photomovie.util.b.a("GLTextureMovieRender", "Surface not created!");
        }
    }

    @Override // com.hw.photomovie.render.b, com.hw.photomovie.render.d
    public void e() {
        this.r.set(true);
        if (this.p) {
            this.s.n();
        }
    }
}
