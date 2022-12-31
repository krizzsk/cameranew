package com.hw.photomovie.segment;

import android.graphics.Bitmap;
import com.hw.photomovie.b.b;
import com.hw.photomovie.segment.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: MulitBitmapSegment.java */
/* loaded from: classes2.dex */
public abstract class f extends c implements b.a {

    /* renamed from: k  reason: collision with root package name */
    protected Map<com.hw.photomovie.b.b, a> f5226k = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private int f5227l;

    private void y() {
        if (this.f5227l != this.f5226k.size()) {
            return;
        }
        boolean z = true;
        Iterator<a> it = this.f5226k.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().a == null) {
                z = false;
                break;
            }
        }
        e.a aVar = this.f5222g;
        if (aVar != null) {
            aVar.a(z);
        }
        if (z) {
            n();
        }
    }

    @Override // com.hw.photomovie.b.b.a
    public void a(com.hw.photomovie.b.b bVar) {
    }

    @Override // com.hw.photomovie.b.b.a
    public void b(com.hw.photomovie.b.b bVar, Bitmap bitmap) {
        this.f5227l++;
        a aVar = this.f5226k.get(bVar);
        if (aVar == null) {
            return;
        }
        if (com.hw.photomovie.util.d.a(bitmap)) {
            aVar.a = new com.hw.photomovie.d.b(bitmap);
            aVar.b.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
            aVar.a(this.f5221f);
        }
        y();
    }

    @Override // com.hw.photomovie.b.b.a
    public void c(com.hw.photomovie.b.b bVar, com.hw.photomovie.b.a aVar) {
        this.f5227l++;
        y();
    }

    @Override // com.hw.photomovie.b.b.a
    public void d(com.hw.photomovie.b.b bVar, int i2, int i3) {
    }

    @Override // com.hw.photomovie.segment.e
    public void e(List<com.hw.photomovie.b.b> list) {
        super.e(list);
        this.f5227l = 0;
    }

    @Override // com.hw.photomovie.segment.e
    public void p() {
        for (a aVar : this.f5226k.values()) {
            com.hw.photomovie.d.b bVar = aVar.a;
            if (bVar != null) {
                bVar.m();
                aVar.a = null;
            }
        }
    }

    @Override // com.hw.photomovie.segment.e
    public void w(int i2, int i3, int i4, int i5) {
        super.w(i2, i3, i4, i5);
        for (a aVar : this.f5226k.values()) {
            aVar.a(this.f5221f);
        }
    }
}
