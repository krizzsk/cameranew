package us.pinguo.edit2020.bean;
/* compiled from: UnityCanvasStatus.kt */
/* loaded from: classes4.dex */
public final class u0 {
    private float a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f10247d;

    /* renamed from: e  reason: collision with root package name */
    private float f10248e;

    /* renamed from: f  reason: collision with root package name */
    private float f10249f;

    /* renamed from: g  reason: collision with root package name */
    private float f10250g;

    /* renamed from: h  reason: collision with root package name */
    private float f10251h;

    /* renamed from: i  reason: collision with root package name */
    private float f10252i;

    public u0(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.a = f2;
        this.b = f3;
        this.c = f4;
        this.f10247d = f5;
        this.f10248e = f6;
        this.f10249f = f7;
        this.f10250g = f8;
        this.f10251h = f9;
        this.f10252i = f10;
    }

    public final float a() {
        return this.f10250g;
    }

    public final float b() {
        return this.f10251h;
    }

    public final float c() {
        return this.f10252i;
    }

    public final float d() {
        return this.f10249f;
    }

    public final float e() {
        return this.f10248e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u0) {
            u0 u0Var = (u0) obj;
            return kotlin.jvm.internal.s.c(Float.valueOf(this.a), Float.valueOf(u0Var.a)) && kotlin.jvm.internal.s.c(Float.valueOf(this.b), Float.valueOf(u0Var.b)) && kotlin.jvm.internal.s.c(Float.valueOf(this.c), Float.valueOf(u0Var.c)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10247d), Float.valueOf(u0Var.f10247d)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10248e), Float.valueOf(u0Var.f10248e)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10249f), Float.valueOf(u0Var.f10249f)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10250g), Float.valueOf(u0Var.f10250g)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10251h), Float.valueOf(u0Var.f10251h)) && kotlin.jvm.internal.s.c(Float.valueOf(this.f10252i), Float.valueOf(u0Var.f10252i));
        }
        return false;
    }

    public final float f() {
        return this.c;
    }

    public final float g() {
        return this.b;
    }

    public final float h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.f10247d)) * 31) + Float.floatToIntBits(this.f10248e)) * 31) + Float.floatToIntBits(this.f10249f)) * 31) + Float.floatToIntBits(this.f10250g)) * 31) + Float.floatToIntBits(this.f10251h)) * 31) + Float.floatToIntBits(this.f10252i);
    }

    public final boolean i() {
        return Math.abs(this.f10250g) > 0.002f || Math.abs(this.f10251h) > 0.002f || Math.abs(this.f10252i - 1.0f) > 0.002f;
    }

    public final void j(float f2) {
        this.f10250g = f2;
    }

    public final void k(float f2) {
        this.f10251h = f2;
    }

    public final void l(float f2) {
        this.f10252i = f2;
    }

    public final void m(float f2) {
        this.f10249f = f2;
    }

    public final void n(float f2) {
        this.f10248e = f2;
    }

    public final void o(float f2) {
        this.f10247d = f2;
    }

    public final void p(float f2) {
        this.c = f2;
    }

    public final void q(float f2) {
        this.b = f2;
    }

    public final void r(float f2) {
        this.a = f2;
    }

    public String toString() {
        return "\nscreenWidth:" + this.a + " screenHeight:" + this.b + "\nnewCanvasWidth:" + this.f10248e + " newCanvasHeight:" + this.f10249f + "\ncanvasOffsetX:" + this.f10250g + " canvasOffsetY:" + this.f10251h + "\ncanvasScale:" + this.f10252i;
    }
}
