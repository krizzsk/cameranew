package com.pinguo.camera360.gallery.ui;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.ui.j;
import java.util.ArrayList;
/* compiled from: PhotoFallbackEffect.java */
/* loaded from: classes3.dex */
public class s extends com.pinguo.album.animations.b implements j.c {

    /* renamed from: k  reason: collision with root package name */
    private static final Interpolator f6632k = new DecelerateInterpolator();

    /* renamed from: e  reason: collision with root package name */
    private final int f6633e;

    /* renamed from: h  reason: collision with root package name */
    private float f6636h;

    /* renamed from: i  reason: collision with root package name */
    private b f6637i;

    /* renamed from: f  reason: collision with root package name */
    private RectF f6634f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private RectF f6635g = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<a> f6638j = new ArrayList<>();

    /* compiled from: PhotoFallbackEffect.java */
    /* loaded from: classes3.dex */
    public static class a {
        public int a;
        public int b;
        public Path c;

        /* renamed from: d  reason: collision with root package name */
        public Rect f6639d;

        /* renamed from: e  reason: collision with root package name */
        public Rect f6640e;

        /* renamed from: f  reason: collision with root package name */
        public com.pinguo.album.opengles.q f6641f;

        public a(Path path, Rect rect, com.pinguo.album.opengles.q qVar, int i2) {
            this.c = path;
            this.f6639d = rect;
            this.f6641f = qVar;
            this.b = i2;
        }
    }

    /* compiled from: PhotoFallbackEffect.java */
    /* loaded from: classes3.dex */
    public interface b {
        Rect a(int i2);

        int b(Path path);
    }

    public s(int i2) {
        i(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        j(f6632k);
        this.f6633e = i2;
    }

    private void o(com.pinguo.album.opengles.l lVar, a aVar) {
        if (aVar.f6641f.m()) {
            int width = aVar.f6641f.getWidth();
            int height = aVar.f6641f.getHeight();
            Rect rect = aVar.f6639d;
            Rect rect2 = aVar.f6640e;
            float f2 = this.f6636h;
            float f3 = 1.0f - f2;
            float height2 = ((rect2.height() / Math.min(rect.width(), rect.height())) * f2) + (1.0f * f3);
            float centerX = (rect2.centerX() * f2) + (rect.centerX() * f3);
            float centerY = (rect2.centerY() * f2) + (rect.centerY() * f3);
            float height3 = rect.height() * height2;
            float width2 = rect.width() * height2;
            int i2 = (int) (aVar.b * this.f6636h);
            if (width > height) {
                float f4 = height3 / 2.0f;
                float f5 = centerX - f4;
                float f6 = centerY - f4;
                float f7 = centerX + f4;
                float f8 = f4 + centerY;
                this.f6635g.set(f5, f6, f7, f8);
                float f9 = (width - height) / 2;
                float f10 = (width + height) / 2;
                float f11 = height;
                this.f6634f.set(f9, 0.0f, f10, f11);
                lVar.s(2);
                q(lVar, i2, centerX, centerY);
                lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
                lVar.b();
                lVar.s(1);
                lVar.z(f3);
                float f12 = width2 / 2.0f;
                this.f6635g.set(centerX - f12, f6, f5, f8);
                this.f6634f.set(0.0f, 0.0f, f9, f11);
                lVar.s(2);
                q(lVar, i2, centerX, centerY);
                lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
                lVar.b();
                this.f6635g.set(f7, f6, f12 + centerX, f8);
                this.f6634f.set(f10, 0.0f, width, f11);
                lVar.s(2);
                q(lVar, i2, centerX, centerY);
                lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
                lVar.b();
                lVar.b();
                return;
            }
            float f13 = width2 / 2.0f;
            float f14 = centerX - f13;
            float f15 = centerY - f13;
            float f16 = centerX + f13;
            float f17 = f13 + centerY;
            this.f6635g.set(f14, f15, f16, f17);
            float f18 = (height - width) / 2;
            float f19 = width;
            float f20 = (width + height) / 2;
            this.f6634f.set(0.0f, f18, f19, f20);
            lVar.s(2);
            q(lVar, i2, centerX, centerY);
            lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
            lVar.b();
            lVar.s(1);
            lVar.z(f3);
            float f21 = height3 / 2.0f;
            this.f6635g.set(f14, centerY - f21, f16, f15);
            this.f6634f.set(0.0f, 0.0f, f19, f18);
            lVar.s(2);
            q(lVar, i2, centerX, centerY);
            lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
            lVar.b();
            this.f6635g.set(f14, f17, f16, f21 + centerY);
            this.f6634f.set(0.0f, f20, f19, height);
            lVar.s(2);
            q(lVar, i2, centerX, centerY);
            lVar.i(aVar.f6641f, this.f6634f, this.f6635g);
            lVar.b();
            lVar.b();
        }
    }

    private void q(com.pinguo.album.opengles.l lVar, int i2, float f2, float f3) {
        lVar.a(f2, f3);
        lVar.v(i2, 0.0f, 0.0f, 1.0f);
        lVar.a(-f2, -f3);
    }

    @Override // com.pinguo.camera360.gallery.ui.j.c
    public boolean a(int i2) {
        int size = this.f6638j.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f6638j.get(i3).a == i2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.pinguo.album.animations.b
    protected void e(float f2) {
        this.f6636h = f2;
    }

    public void m(Path path, Rect rect, com.pinguo.album.opengles.q qVar, int i2) {
        this.f6638j.add(new a(path, rect, qVar, i2));
    }

    public boolean n(com.pinguo.album.opengles.l lVar, int i2, int i3) {
        boolean b2 = b(com.pinguo.album.animations.c.a());
        lVar.setAlpha(1.0f - this.f6636h);
        lVar.g(0.0f, 0.0f, i2, i3, this.f6633e);
        lVar.setAlpha(1.0f);
        int size = this.f6638j.size();
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = this.f6638j.get(i4);
            if (aVar.a >= 0) {
                b bVar = this.f6637i;
                aVar.f6640e = bVar.a(bVar.b(aVar.c));
                o(lVar, aVar);
            }
        }
        return b2;
    }

    public float p() {
        return this.f6636h;
    }

    public void r(b bVar) {
        this.f6637i = bVar;
        if (bVar != null) {
            int size = this.f6638j.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.f6638j.get(i2);
                aVar.a = this.f6637i.b(aVar.c);
            }
        }
    }
}
