package com.hw.photomovie.segment;

import android.graphics.Bitmap;
import com.hw.photomovie.b.b;
import com.hw.photomovie.segment.e;
import com.hw.photomovie.util.ScaleType;
/* compiled from: SingleBitmapSegment.java */
/* loaded from: classes2.dex */
public class g extends c {

    /* renamed from: k  reason: collision with root package name */
    protected volatile com.hw.photomovie.segment.a f5228k;

    /* renamed from: l  reason: collision with root package name */
    protected ScaleType f5229l = ScaleType.CENTER_CROP;

    /* compiled from: SingleBitmapSegment.java */
    /* loaded from: classes2.dex */
    class a extends b.C0199b {
        a() {
        }

        @Override // com.hw.photomovie.b.b.a
        public void b(com.hw.photomovie.b.b bVar, Bitmap bitmap) {
            if (com.hw.photomovie.util.d.a(bitmap)) {
                com.hw.photomovie.d.b bVar2 = new com.hw.photomovie.d.b(bitmap);
                g.this.f5228k = new com.hw.photomovie.segment.a();
                com.hw.photomovie.segment.a aVar = g.this.f5228k;
                g gVar = g.this;
                aVar.f5218d = gVar.f5229l;
                gVar.f5228k.a = bVar2;
                g.this.f5228k.b.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                g.this.f5228k.c.set(g.this.f5228k.b);
                g.this.n();
            }
            e.a aVar2 = g.this.f5222g;
            if (aVar2 != null) {
                aVar2.a(true);
            }
        }

        @Override // com.hw.photomovie.b.b.a
        public void c(com.hw.photomovie.b.b bVar, com.hw.photomovie.b.a aVar) {
            e.a aVar2 = g.this.f5222g;
            if (aVar2 != null) {
                aVar2.a(false);
            }
        }
    }

    public g(int i2) {
        this.f5220e = i2;
    }

    @Override // com.hw.photomovie.segment.e
    protected boolean g() {
        return this.f5228k != null && this.f5228k.b();
    }

    @Override // com.hw.photomovie.segment.e
    public int m() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hw.photomovie.segment.e
    public void n() {
        this.f5223h = true;
        if (this.f5228k != null) {
            this.f5228k.a(this.f5221f);
        }
    }

    @Override // com.hw.photomovie.segment.e
    public void o() {
        com.hw.photomovie.b.b l2 = l(0);
        if (l2 != null) {
            l2.prepareData(4, new a());
            return;
        }
        com.hw.photomovie.util.b.a("SingleBitmapSegment", "available photoData is null,segment:" + this);
    }

    @Override // com.hw.photomovie.segment.e
    public void p() {
        if (this.f5228k != null && this.f5228k.a != null) {
            this.f5228k.a.m();
        }
        this.f5228k = null;
    }

    @Override // com.hw.photomovie.segment.e
    public void w(int i2, int i3, int i4, int i5) {
        super.w(i2, i3, i4, i5);
        if (this.f5228k != null) {
            this.f5228k.a(this.f5221f);
        }
    }
}
