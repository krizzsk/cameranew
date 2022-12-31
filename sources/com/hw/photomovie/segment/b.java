package com.hw.photomovie.segment;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.hw.photomovie.util.ScaleType;
/* compiled from: FitCenterSegment.java */
/* loaded from: classes2.dex */
public class b extends g {
    private Matrix m;
    protected RectF n;
    protected RectF o;
    private int p;

    public b(int i2) {
        super(i2);
        this.m = new Matrix();
        this.n = new RectF();
        this.o = new RectF();
        this.f5229l = ScaleType.FIT_CENTER;
    }

    private void y() {
        if (this.f5228k == null || this.f5221f.width() == 0.0f || this.f5221f.height() == 0.0f) {
            return;
        }
        com.hw.photomovie.util.c.b(this.n, (int) this.f5228k.c.width(), (int) this.f5228k.c.height(), (int) this.f5221f.width(), (int) this.f5221f.height());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(com.hw.photomovie.d.f fVar, float f2) {
        if (this.f5228k == null || !this.f5228k.c(fVar)) {
            return;
        }
        if (f2 != 1.0f) {
            this.m.setScale(f2, f2, this.n.centerX(), this.n.centerY());
            this.m.mapRect(this.o, this.n);
            fVar.l(this.f5228k.a, this.f5228k.c, this.o);
            return;
        }
        fVar.l(this.f5228k.a, this.f5228k.c, this.n);
    }

    @Override // com.hw.photomovie.segment.e
    /* renamed from: B */
    public void h(com.hw.photomovie.d.f fVar, float f2) {
        if (this.f5223h) {
            z(fVar);
            A(fVar, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.segment.g, com.hw.photomovie.segment.e
    public void n() {
        super.n();
        y();
    }

    @Override // com.hw.photomovie.segment.g, com.hw.photomovie.segment.e
    public void p() {
        super.p();
    }

    @Override // com.hw.photomovie.segment.g, com.hw.photomovie.segment.e
    public void w(int i2, int i3, int i4, int i5) {
        super.w(i2, i3, i4, i5);
        y();
    }

    protected void z(com.hw.photomovie.d.f fVar) {
        if (this.p != 0) {
            fVar.g(0.0f, 0.0f, this.f5221f.width(), this.f5221f.height(), this.p);
        }
    }
}
