package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.d;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: AnimatedDrawableBackendImpl.java */
/* loaded from: classes.dex */
public class a implements com.facebook.imagepipeline.animated.base.a {
    private final com.facebook.imagepipeline.animated.b.a a;
    private final d b;
    private final com.facebook.imagepipeline.animated.base.b c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f2669d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f2670e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatedDrawableFrameInfo[] f2671f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f2672g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private final Rect f2673h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private final boolean f2674i;
    @GuardedBy("this")
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f2675j;

    public a(com.facebook.imagepipeline.animated.b.a aVar, d dVar, @Nullable Rect rect, boolean z) {
        this.a = aVar;
        this.b = dVar;
        com.facebook.imagepipeline.animated.base.b d2 = dVar.d();
        this.c = d2;
        int[] j2 = d2.j();
        this.f2670e = j2;
        aVar.a(j2);
        aVar.c(j2);
        aVar.b(j2);
        this.f2669d = k(d2, rect);
        this.f2674i = z;
        this.f2671f = new AnimatedDrawableFrameInfo[d2.a()];
        for (int i2 = 0; i2 < this.c.a(); i2++) {
            this.f2671f[i2] = this.c.c(i2);
        }
    }

    private synchronized void j() {
        Bitmap bitmap = this.f2675j;
        if (bitmap != null) {
            bitmap.recycle();
            this.f2675j = null;
        }
    }

    private static Rect k(com.facebook.imagepipeline.animated.base.b bVar, @Nullable Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, bVar.getWidth(), bVar.getHeight());
        }
        return new Rect(0, 0, Math.min(rect.width(), bVar.getWidth()), Math.min(rect.height(), bVar.getHeight()));
    }

    private synchronized Bitmap l(int i2, int i3) {
        Bitmap bitmap = this.f2675j;
        if (bitmap != null && (bitmap.getWidth() < i2 || this.f2675j.getHeight() < i3)) {
            j();
        }
        if (this.f2675j == null) {
            this.f2675j = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        this.f2675j.eraseColor(0);
        return this.f2675j;
    }

    private void m(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        int width;
        int height;
        int xOffset;
        int yOffset;
        if (this.f2674i) {
            float max = Math.max(cVar.getWidth() / Math.min(cVar.getWidth(), canvas.getWidth()), cVar.getHeight() / Math.min(cVar.getHeight(), canvas.getHeight()));
            width = (int) (cVar.getWidth() / max);
            height = (int) (cVar.getHeight() / max);
            xOffset = (int) (cVar.getXOffset() / max);
            yOffset = (int) (cVar.getYOffset() / max);
        } else {
            width = cVar.getWidth();
            height = cVar.getHeight();
            xOffset = cVar.getXOffset();
            yOffset = cVar.getYOffset();
        }
        synchronized (this) {
            Bitmap l2 = l(width, height);
            this.f2675j = l2;
            cVar.a(width, height, l2);
            canvas.save();
            canvas.translate(xOffset, yOffset);
            canvas.drawBitmap(this.f2675j, 0.0f, 0.0f, (Paint) null);
            canvas.restore();
        }
    }

    private void n(Canvas canvas, com.facebook.imagepipeline.animated.base.c cVar) {
        double width = this.f2669d.width() / this.c.getWidth();
        double height = this.f2669d.height() / this.c.getHeight();
        int round = (int) Math.round(cVar.getWidth() * width);
        int round2 = (int) Math.round(cVar.getHeight() * height);
        int xOffset = (int) (cVar.getXOffset() * width);
        int yOffset = (int) (cVar.getYOffset() * height);
        synchronized (this) {
            int width2 = this.f2669d.width();
            int height2 = this.f2669d.height();
            l(width2, height2);
            Bitmap bitmap = this.f2675j;
            if (bitmap != null) {
                cVar.a(round, round2, bitmap);
            }
            this.f2672g.set(0, 0, width2, height2);
            this.f2673h.set(xOffset, yOffset, width2 + xOffset, height2 + yOffset);
            Bitmap bitmap2 = this.f2675j;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.f2672g, this.f2673h, (Paint) null);
            }
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int a() {
        return this.c.a();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int b() {
        return this.c.b();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public AnimatedDrawableFrameInfo c(int i2) {
        return this.f2671f[i2];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public void d(int i2, Canvas canvas) {
        com.facebook.imagepipeline.animated.base.c i3 = this.c.i(i2);
        try {
            if (this.c.e()) {
                n(canvas, i3);
            } else {
                m(canvas, i3);
            }
        } finally {
            i3.dispose();
        }
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public com.facebook.imagepipeline.animated.base.a e(@Nullable Rect rect) {
        return k(this.c, rect).equals(this.f2669d) ? this : new a(this.a, this.b, rect, this.f2674i);
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int f(int i2) {
        return this.f2670e[i2];
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int g() {
        return this.f2669d.height();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getHeight() {
        return this.c.getHeight();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int getWidth() {
        return this.c.getWidth();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public int h() {
        return this.f2669d.width();
    }

    @Override // com.facebook.imagepipeline.animated.base.a
    public d i() {
        return this.b;
    }
}
