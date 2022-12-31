package us.pinguo.edit2020.bean;

import android.content.Context;
/* compiled from: BlurringFunction.kt */
/* loaded from: classes4.dex */
public final class l0 {

    /* renamed from: j  reason: collision with root package name */
    public static final a f10223j = new a(null);

    /* renamed from: k  reason: collision with root package name */
    private static final float f10224k;

    /* renamed from: l  reason: collision with root package name */
    private static final float f10225l;
    private static final float m;
    private static final float n;
    private float a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f10226d;

    /* renamed from: e  reason: collision with root package name */
    private float f10227e;

    /* renamed from: f  reason: collision with root package name */
    private float f10228f;

    /* renamed from: g  reason: collision with root package name */
    private float f10229g;

    /* renamed from: h  reason: collision with root package name */
    private float f10230h;

    /* renamed from: i  reason: collision with root package name */
    private float f10231i;

    /* compiled from: BlurringFunction.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final float a() {
            return l0.f10224k;
        }

        public final float b() {
            return l0.m;
        }

        public final float c() {
            return l0.f10225l;
        }

        public final float d() {
            return l0.n;
        }
    }

    static {
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        f10224k = us.pinguo.util.g.b(b, 40.0f);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        f10225l = us.pinguo.util.g.b(b2, 20.0f);
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        m = us.pinguo.util.g.b(b3, 50.0f);
        Context b4 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b4, "getAppContext()");
        n = us.pinguo.util.g.b(b4, 15.0f);
    }

    public l0(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.f10226d = f5;
        this.f10227e = f6;
        this.f10228f = f7;
        this.f10229g = f8;
        this.f10230h = f9;
        this.f10231i = f10;
    }

    public final float e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            return kotlin.jvm.internal.s.c(Float.valueOf(this.a), Float.valueOf(l0Var.a)) && kotlin.jvm.internal.s.c(Float.valueOf(this.b), Float.valueOf(l0Var.b)) && kotlin.jvm.internal.s.c(Float.valueOf(this.c), Float.valueOf(l0Var.c)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10226d), Float.valueOf(l0Var.f10226d)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10227e), Float.valueOf(l0Var.f10227e)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10228f), Float.valueOf(l0Var.f10228f)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10229g), Float.valueOf(l0Var.f10229g)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10230h), Float.valueOf(l0Var.f10230h)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10231i), Float.valueOf(l0Var.f10231i));
        }
        return false;
    }

    public final float f() {
        return this.b;
    }

    public final float g() {
        return this.f10229g;
    }

    public final float h() {
        return this.f10230h;
    }

    public int hashCode() {
        return (((((((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.f10226d)) * 31) + Float.floatToIntBits(this.f10227e)) * 31) + Float.floatToIntBits(this.f10228f)) * 31) + Float.floatToIntBits(this.f10229g)) * 31) + Float.floatToIntBits(this.f10230h)) * 31) + Float.floatToIntBits(this.f10231i);
    }

    public final float i() {
        return this.c;
    }

    public final float j() {
        return this.f10226d;
    }

    public final float k() {
        return this.f10227e;
    }

    public final float l() {
        return this.f10228f;
    }

    public final float m() {
        return this.f10231i;
    }

    public final void n(float f2) {
        this.a = f2;
    }

    public final void o(float f2) {
        this.b = f2;
    }

    public final void p(float f2) {
        this.f10229g = f2;
    }

    public final void q(float f2) {
        this.f10230h = f2;
    }

    public final void r(float f2) {
        this.c = f2;
    }

    public final void s(float f2) {
        this.f10226d = f2;
    }

    public final void t(float f2) {
        this.f10227e = f2;
    }

    public String toString() {
        return "ShapeHelper(centerX=" + this.a + ", centerY=" + this.b + ", innerRx=" + this.c + ", innerRy=" + this.f10226d + ", outerRx=" + this.f10227e + ", outerRy=" + this.f10228f + ", disLine1ToCenter=" + this.f10229g + ", disLines=" + this.f10230h + ", rotation=" + this.f10231i + ')';
    }

    public final void u(float f2) {
        this.f10228f = f2;
    }

    public final void v(float f2) {
        this.f10231i = f2;
    }
}
