package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;
/* compiled from: CircularRevealWidget.java */
/* loaded from: classes2.dex */
public interface c extends b.a {

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes2.dex */
    public static class b implements TypeEvaluator<e> {
        public static final TypeEvaluator<e> b = new b();
        private final e a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: a */
        public e evaluate(float f2, @NonNull e eVar, @NonNull e eVar2) {
            this.a.b(com.google.android.material.e.a.d(eVar.a, eVar2.a, f2), com.google.android.material.e.a.d(eVar.b, eVar2.b, f2), com.google.android.material.e.a.d(eVar.c, eVar2.c, f2));
            return this.a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: com.google.android.material.circularreveal.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0170c extends Property<c, e> {
        public static final Property<c, e> a = new C0170c("circularReveal");

        private C0170c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: a */
        public e get(@NonNull c cVar) {
            return cVar.a();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @Nullable e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes2.dex */
    public static class d extends Property<c, Integer> {
        public static final Property<c, Integer> a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull c cVar) {
            return Integer.valueOf(cVar.c());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @NonNull Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes2.dex */
    public static class e {
        public float a;
        public float b;
        public float c;

        public boolean a() {
            return this.c == Float.MAX_VALUE;
        }

        public void b(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public void c(@NonNull e eVar) {
            b(eVar.a, eVar.b, eVar.c);
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
        }

        public e(@NonNull e eVar) {
            this(eVar.a, eVar.b, eVar.c);
        }
    }

    @Nullable
    e a();

    void b();

    @ColorInt
    int c();

    void d();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable e eVar);
}
