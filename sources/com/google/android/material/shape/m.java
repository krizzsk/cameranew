package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes2.dex */
public class m {
    public static final com.google.android.material.shape.c m = new k(0.5f);
    d a;
    d b;
    d c;

    /* renamed from: d  reason: collision with root package name */
    d f4503d;

    /* renamed from: e  reason: collision with root package name */
    com.google.android.material.shape.c f4504e;

    /* renamed from: f  reason: collision with root package name */
    com.google.android.material.shape.c f4505f;

    /* renamed from: g  reason: collision with root package name */
    com.google.android.material.shape.c f4506g;

    /* renamed from: h  reason: collision with root package name */
    com.google.android.material.shape.c f4507h;

    /* renamed from: i  reason: collision with root package name */
    f f4508i;

    /* renamed from: j  reason: collision with root package name */
    f f4509j;

    /* renamed from: k  reason: collision with root package name */
    f f4510k;

    /* renamed from: l  reason: collision with root package name */
    f f4511l;

    /* compiled from: ShapeAppearanceModel.java */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface c {
        @NonNull
        com.google.android.material.shape.c a(@NonNull com.google.android.material.shape.c cVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, @StyleRes int i2, @StyleRes int i3) {
        return c(context, i2, i3, 0);
    }

    @NonNull
    private static b c(Context context, @StyleRes int i2, @StyleRes int i3, int i4) {
        return d(context, i2, i3, new com.google.android.material.shape.a(i4));
    }

    @NonNull
    private static b d(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull com.google.android.material.shape.c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            com.google.android.material.shape.c m2 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            com.google.android.material.shape.c m3 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, m2);
            com.google.android.material.shape.c m4 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, m2);
            com.google.android.material.shape.c m5 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, m2);
            com.google.android.material.shape.c m6 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, m2);
            b bVar = new b();
            bVar.C(i5, m3);
            bVar.G(i6, m4);
            bVar.x(i7, m5);
            bVar.t(i8, m6);
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return g(context, attributeSet, i2, i3, new com.google.android.material.shape.a(i4));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull com.google.android.material.shape.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    private static com.google.android.material.shape.c m(TypedArray typedArray, int i2, @NonNull com.google.android.material.shape.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cVar;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new com.google.android.material.shape.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new k(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    @NonNull
    public f h() {
        return this.f4510k;
    }

    @NonNull
    public d i() {
        return this.f4503d;
    }

    @NonNull
    public com.google.android.material.shape.c j() {
        return this.f4507h;
    }

    @NonNull
    public d k() {
        return this.c;
    }

    @NonNull
    public com.google.android.material.shape.c l() {
        return this.f4506g;
    }

    @NonNull
    public f n() {
        return this.f4511l;
    }

    @NonNull
    public f o() {
        return this.f4509j;
    }

    @NonNull
    public f p() {
        return this.f4508i;
    }

    @NonNull
    public d q() {
        return this.a;
    }

    @NonNull
    public com.google.android.material.shape.c r() {
        return this.f4504e;
    }

    @NonNull
    public d s() {
        return this.b;
    }

    @NonNull
    public com.google.android.material.shape.c t() {
        return this.f4505f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        boolean z = this.f4511l.getClass().equals(f.class) && this.f4509j.getClass().equals(f.class) && this.f4508i.getClass().equals(f.class) && this.f4510k.getClass().equals(f.class);
        float a2 = this.f4504e.a(rectF);
        return z && ((this.f4505f.a(rectF) > a2 ? 1 : (this.f4505f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f4507h.a(rectF) > a2 ? 1 : (this.f4507h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f4506g.a(rectF) > a2 ? 1 : (this.f4506g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.b instanceof l) && (this.a instanceof l) && (this.c instanceof l) && (this.f4503d instanceof l));
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public m w(float f2) {
        b v = v();
        v.o(f2);
        return v.m();
    }

    @NonNull
    public m x(@NonNull com.google.android.material.shape.c cVar) {
        b v = v();
        v.p(cVar);
        return v.m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public m y(@NonNull c cVar) {
        b v = v();
        v.F(cVar.a(r()));
        v.J(cVar.a(t()));
        v.w(cVar.a(j()));
        v.A(cVar.a(l()));
        return v.m();
    }

    private m(@NonNull b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f4503d = bVar.f4512d;
        this.f4504e = bVar.f4513e;
        this.f4505f = bVar.f4514f;
        this.f4506g = bVar.f4515g;
        this.f4507h = bVar.f4516h;
        this.f4508i = bVar.f4517i;
        this.f4509j = bVar.f4518j;
        this.f4510k = bVar.f4519k;
        this.f4511l = bVar.f4520l;
    }

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes2.dex */
    public static final class b {
        @NonNull
        private d a;
        @NonNull
        private d b;
        @NonNull
        private d c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private d f4512d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.material.shape.c f4513e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private com.google.android.material.shape.c f4514f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private com.google.android.material.shape.c f4515g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private com.google.android.material.shape.c f4516h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        private f f4517i;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        private f f4518j;
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private f f4519k;
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private f f4520l;

        public b() {
            this.a = i.b();
            this.b = i.b();
            this.c = i.b();
            this.f4512d = i.b();
            this.f4513e = new com.google.android.material.shape.a(0.0f);
            this.f4514f = new com.google.android.material.shape.a(0.0f);
            this.f4515g = new com.google.android.material.shape.a(0.0f);
            this.f4516h = new com.google.android.material.shape.a(0.0f);
            this.f4517i = i.c();
            this.f4518j = i.c();
            this.f4519k = i.c();
            this.f4520l = i.c();
        }

        private static float n(d dVar) {
            if (dVar instanceof l) {
                return ((l) dVar).a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(@NonNull com.google.android.material.shape.c cVar) {
            this.f4515g = cVar;
            return this;
        }

        @NonNull
        public b B(@NonNull f fVar) {
            this.f4517i = fVar;
            return this;
        }

        @NonNull
        public b C(int i2, @NonNull com.google.android.material.shape.c cVar) {
            D(i.a(i2));
            F(cVar);
            return this;
        }

        @NonNull
        public b D(@NonNull d dVar) {
            this.a = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                E(n);
            }
            return this;
        }

        @NonNull
        public b E(@Dimension float f2) {
            this.f4513e = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b F(@NonNull com.google.android.material.shape.c cVar) {
            this.f4513e = cVar;
            return this;
        }

        @NonNull
        public b G(int i2, @NonNull com.google.android.material.shape.c cVar) {
            H(i.a(i2));
            J(cVar);
            return this;
        }

        @NonNull
        public b H(@NonNull d dVar) {
            this.b = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                I(n);
            }
            return this;
        }

        @NonNull
        public b I(@Dimension float f2) {
            this.f4514f = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b J(@NonNull com.google.android.material.shape.c cVar) {
            this.f4514f = cVar;
            return this;
        }

        @NonNull
        public m m() {
            return new m(this);
        }

        @NonNull
        public b o(@Dimension float f2) {
            E(f2);
            I(f2);
            z(f2);
            v(f2);
            return this;
        }

        @NonNull
        public b p(@NonNull com.google.android.material.shape.c cVar) {
            F(cVar);
            J(cVar);
            A(cVar);
            w(cVar);
            return this;
        }

        @NonNull
        public b q(int i2, @Dimension float f2) {
            r(i.a(i2));
            o(f2);
            return this;
        }

        @NonNull
        public b r(@NonNull d dVar) {
            D(dVar);
            H(dVar);
            y(dVar);
            u(dVar);
            return this;
        }

        @NonNull
        public b s(@NonNull f fVar) {
            this.f4519k = fVar;
            return this;
        }

        @NonNull
        public b t(int i2, @NonNull com.google.android.material.shape.c cVar) {
            u(i.a(i2));
            w(cVar);
            return this;
        }

        @NonNull
        public b u(@NonNull d dVar) {
            this.f4512d = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                v(n);
            }
            return this;
        }

        @NonNull
        public b v(@Dimension float f2) {
            this.f4516h = new com.google.android.material.shape.a(f2);
            return this;
        }

        @NonNull
        public b w(@NonNull com.google.android.material.shape.c cVar) {
            this.f4516h = cVar;
            return this;
        }

        @NonNull
        public b x(int i2, @NonNull com.google.android.material.shape.c cVar) {
            y(i.a(i2));
            A(cVar);
            return this;
        }

        @NonNull
        public b y(@NonNull d dVar) {
            this.c = dVar;
            float n = n(dVar);
            if (n != -1.0f) {
                z(n);
            }
            return this;
        }

        @NonNull
        public b z(@Dimension float f2) {
            this.f4515g = new com.google.android.material.shape.a(f2);
            return this;
        }

        public b(@NonNull m mVar) {
            this.a = i.b();
            this.b = i.b();
            this.c = i.b();
            this.f4512d = i.b();
            this.f4513e = new com.google.android.material.shape.a(0.0f);
            this.f4514f = new com.google.android.material.shape.a(0.0f);
            this.f4515g = new com.google.android.material.shape.a(0.0f);
            this.f4516h = new com.google.android.material.shape.a(0.0f);
            this.f4517i = i.c();
            this.f4518j = i.c();
            this.f4519k = i.c();
            this.f4520l = i.c();
            this.a = mVar.a;
            this.b = mVar.b;
            this.c = mVar.c;
            this.f4512d = mVar.f4503d;
            this.f4513e = mVar.f4504e;
            this.f4514f = mVar.f4505f;
            this.f4515g = mVar.f4506g;
            this.f4516h = mVar.f4507h;
            this.f4517i = mVar.f4508i;
            this.f4518j = mVar.f4509j;
            this.f4519k = mVar.f4510k;
            this.f4520l = mVar.f4511l;
        }
    }

    public m() {
        this.a = i.b();
        this.b = i.b();
        this.c = i.b();
        this.f4503d = i.b();
        this.f4504e = new com.google.android.material.shape.a(0.0f);
        this.f4505f = new com.google.android.material.shape.a(0.0f);
        this.f4506g = new com.google.android.material.shape.a(0.0f);
        this.f4507h = new com.google.android.material.shape.a(0.0f);
        this.f4508i = i.c();
        this.f4509j = i.c();
        this.f4510k = i.c();
        this.f4511l = i.c();
    }
}
