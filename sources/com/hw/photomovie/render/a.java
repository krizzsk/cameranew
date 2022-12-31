package com.hw.photomovie.render;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import com.hw.photomovie.d.f;
import com.hw.photomovie.render.d;
import com.hw.photomovie.segment.e;
/* compiled from: GLMovieRenderer.java */
/* loaded from: classes2.dex */
public abstract class a extends d<f> {

    /* renamed from: h  reason: collision with root package name */
    private com.hw.photomovie.d.c f5209h;

    /* renamed from: i  reason: collision with root package name */
    private com.hw.photomovie.d.c f5210i;

    /* renamed from: j  reason: collision with root package name */
    protected com.hw.photomovie.moviefilter.a f5211j;

    /* renamed from: k  reason: collision with root package name */
    private Object f5212k = new Object();

    /* renamed from: l  reason: collision with root package name */
    private Object f5213l = new Object();
    protected volatile boolean m;
    private volatile b n;

    /* compiled from: GLMovieRenderer.java */
    /* renamed from: com.hw.photomovie.render.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0201a implements Runnable {
        final /* synthetic */ b a;

        RunnableC0201a(a aVar, b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a();
        }
    }

    /* compiled from: GLMovieRenderer.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    private void m(int i2, int i3) {
        com.hw.photomovie.d.c cVar = new com.hw.photomovie.d.c();
        this.f5209h = cVar;
        cVar.p(i2, i3);
        com.hw.photomovie.d.c cVar2 = new com.hw.photomovie.d.c();
        this.f5210i = cVar2;
        cVar2.p(i2, i3);
    }

    private void q(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    @Override // com.hw.photomovie.render.d
    public void b(int i2) {
        synchronized (this.f5212k) {
            this.m = true;
            if (this.n != null) {
                b bVar = this.n;
                this.n = null;
                q(new RunnableC0201a(this, bVar));
            }
        }
        if (this.f5211j == null) {
            super.b(i2);
            return;
        }
        if (this.f5209h == null || this.f5210i == null) {
            m(this.c.width(), this.c.height());
        }
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        GLES20.glBindFramebuffer(36160, this.f5209h.q());
        super.b(i2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        ((f) this.f5214d).n();
        synchronized (this.f5213l) {
            com.hw.photomovie.moviefilter.a aVar = this.f5211j;
            if (aVar != null) {
                aVar.a(this.a, i2, this.f5209h, this.f5210i);
            }
        }
        ((f) this.f5214d).o();
        ((f) this.f5214d).h(this.f5210i, 0, 0, this.c.width(), this.c.height());
    }

    @Override // com.hw.photomovie.render.d
    public void g(int i2, int i3, int i4, int i5) {
        super.g(i2, i3, i4, i5);
        com.hw.photomovie.d.c cVar = this.f5209h;
        if (cVar != null) {
            int i6 = i4 - i2;
            if (cVar.h() == i6 && this.f5209h.c() == i5 - i3) {
                return;
            }
            m(i6, i5 - i3);
        }
    }

    public void k(b bVar) {
        synchronized (this.f5212k) {
            if (this.m) {
                bVar.a();
            } else {
                this.n = bVar;
            }
        }
    }

    public com.hw.photomovie.moviefilter.a l() {
        return this.f5211j;
    }

    protected void n() {
        e<T> eVar = this.f5217g;
        if (eVar != 0) {
            eVar.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        n();
        f();
        p();
        com.hw.photomovie.moviefilter.a aVar = this.f5211j;
        if (aVar != null) {
            aVar.release();
        }
        ((f) this.f5214d).e();
        d.a aVar2 = this.f5216f;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        com.hw.photomovie.d.c cVar = this.f5209h;
        if (cVar != null) {
            cVar.s();
            this.f5209h = null;
        }
        com.hw.photomovie.d.c cVar2 = this.f5210i;
        if (cVar2 != null) {
            cVar2.s();
            this.f5210i = null;
        }
    }
}
