package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;
/* compiled from: ScalingUtils.java */
/* loaded from: classes.dex */
public class p {

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    public static abstract class a implements c {
        @Override // com.facebook.drawee.drawable.p.c
        public Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            b(matrix, rect, i2, i3, f2, f3, rect.width() / i2, rect.height() / i3);
            return matrix;
        }

        public abstract void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    public static class b implements c, o {

        /* renamed from: j  reason: collision with root package name */
        private final c f2560j;

        /* renamed from: k  reason: collision with root package name */
        private final c f2561k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private final Rect f2562l;
        @Nullable
        private final Rect m;
        @Nullable
        private final PointF n;
        @Nullable
        private final PointF o;
        private final float[] p = new float[9];
        private final float[] q = new float[9];
        private final float[] r = new float[9];
        private float s;

        public b(c cVar, c cVar2, @Nullable Rect rect, @Nullable Rect rect2, @Nullable PointF pointF, @Nullable PointF pointF2) {
            this.f2560j = cVar;
            this.f2561k = cVar2;
            this.f2562l = rect;
            this.m = rect2;
            this.n = pointF;
            this.o = pointF2;
        }

        @Override // com.facebook.drawee.drawable.p.c
        public Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            Rect rect2 = this.f2562l;
            Rect rect3 = rect2 != null ? rect2 : rect;
            Rect rect4 = this.m;
            Rect rect5 = rect4 != null ? rect4 : rect;
            c cVar = this.f2560j;
            PointF pointF = this.n;
            cVar.a(matrix, rect3, i2, i3, pointF == null ? f2 : pointF.x, pointF == null ? f3 : pointF.y);
            matrix.getValues(this.p);
            c cVar2 = this.f2561k;
            PointF pointF2 = this.o;
            cVar2.a(matrix, rect5, i2, i3, pointF2 == null ? f2 : pointF2.x, pointF2 == null ? f3 : pointF2.y);
            matrix.getValues(this.q);
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.r;
                float f4 = this.p[i4];
                float f5 = this.s;
                fArr[i4] = (f4 * (1.0f - f5)) + (this.q[i4] * f5);
            }
            matrix.setValues(this.r);
            return matrix;
        }

        public void b(float f2) {
            this.s = f2;
        }

        @Override // com.facebook.drawee.drawable.p.o
        public Object getState() {
            return Float.valueOf(this.s);
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", String.valueOf(this.f2560j), String.valueOf(this.n), String.valueOf(this.f2561k), String.valueOf(this.o));
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    public interface c {
        public static final c a = l.f2577j;
        public static final c b;
        public static final c c;

        /* renamed from: d  reason: collision with root package name */
        public static final c f2563d;

        /* renamed from: e  reason: collision with root package name */
        public static final c f2564e;

        /* renamed from: f  reason: collision with root package name */
        public static final c f2565f;

        /* renamed from: g  reason: collision with root package name */
        public static final c f2566g;

        /* renamed from: h  reason: collision with root package name */
        public static final c f2567h;

        /* renamed from: i  reason: collision with root package name */
        public static final c f2568i;

        static {
            c cVar = k.f2576j;
            c cVar2 = m.f2578j;
            b = j.f2575j;
            c = h.f2573j;
            f2563d = i.f2574j;
            f2564e = d.f2569j;
            f2565f = f.f2571j;
            f2566g = e.f2570j;
            f2567h = n.f2579j;
            f2568i = g.f2572j;
        }

        Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class d extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2569j = new d();

        private d() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((int) (rect.left + ((rect.width() - i2) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i3) * 0.5f) + 0.5f));
        }

        public String toString() {
            return "center";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class e extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2570j = new e();

        private e() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float height;
            float f6;
            if (f5 > f4) {
                f6 = rect.left + ((rect.width() - (i2 * f5)) * 0.5f);
                height = rect.top;
                f4 = f5;
            } else {
                height = ((rect.height() - (i3 * f4)) * 0.5f) + rect.top;
                f6 = rect.left;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_crop";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class f extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2571j = new f();

        private f() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(Math.min(f4, f5), 1.0f);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "center_inside";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class g extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2572j = new g();

        private g() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class h extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2573j = new h();

        private h() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            float width = rect.left + ((rect.width() - (i2 * min)) * 0.5f);
            float height = rect.top + ((rect.height() - (i3 * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "fit_center";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class i extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2574j = new i();

        private i() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + (rect.width() - (i2 * min)) + 0.5f), (int) (rect.top + (rect.height() - (i3 * min)) + 0.5f));
        }

        public String toString() {
            return "fit_end";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class j extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2575j = new j();

        private j() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_start";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class k extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2576j = new k();

        private k() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float height = rect.top + ((rect.height() - (i3 * f4)) * 0.5f);
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (height + 0.5f));
        }

        public String toString() {
            return "fit_x";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class l extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2577j = new l();

        private l() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f4, f5);
            matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class m extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2578j = new m();

        private m() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f5, f5);
            matrix.postTranslate((int) (rect.left + ((rect.width() - (i2 * f5)) * 0.5f) + 0.5f), (int) (rect.top + 0.5f));
        }

        public String toString() {
            return "fit_y";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    private static class n extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final c f2579j = new n();

        private n() {
        }

        @Override // com.facebook.drawee.drawable.p.a
        public void b(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float max;
            if (f5 > f4) {
                float f7 = i2 * f5;
                f6 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f2 * f7), 0.0f), rect.width() - f7);
                max = rect.top;
                f4 = f5;
            } else {
                f6 = rect.left;
                float f8 = i3 * f4;
                max = Math.max(Math.min((rect.height() * 0.5f) - (f3 * f8), 0.0f), rect.height() - f8) + rect.top;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f6 + 0.5f), (int) (max + 0.5f));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    /* compiled from: ScalingUtils.java */
    /* loaded from: classes.dex */
    public interface o {
        Object getState();
    }

    @Nullable
    public static com.facebook.drawee.drawable.o a(@Nullable Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof com.facebook.drawee.drawable.o) {
            return (com.facebook.drawee.drawable.o) drawable;
        }
        if (drawable instanceof com.facebook.drawee.drawable.c) {
            return a(((com.facebook.drawee.drawable.c) drawable).b());
        }
        if (drawable instanceof com.facebook.drawee.drawable.a) {
            com.facebook.drawee.drawable.a aVar = (com.facebook.drawee.drawable.a) drawable;
            int d2 = aVar.d();
            for (int i2 = 0; i2 < d2; i2++) {
                com.facebook.drawee.drawable.o a2 = a(aVar.b(i2));
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return null;
    }
}
