package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.internal.s;
/* compiled from: EditBodyShapeModule.kt */
/* loaded from: classes4.dex */
public final class c {
    private float a;
    private float b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private BoldType f10884d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10885e;

    public c(float f2, float f3, boolean z, BoldType boldType, boolean z2) {
        s.h(boldType, "boldType");
        this.a = f2;
        this.b = f3;
        this.c = z;
        this.f10884d = boldType;
        this.f10885e = z2;
    }

    public final BoldType a() {
        return this.f10884d;
    }

    public final float b() {
        return this.a;
    }

    public final float c() {
        return this.b;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.f10885e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return s.c(Float.valueOf(this.a), Float.valueOf(cVar.a)) && s.c(Float.valueOf(this.b), Float.valueOf(cVar.b)) && this.c == cVar.c && this.f10884d == cVar.f10884d && this.f10885e == cVar.f10885e;
        }
        return false;
    }

    public final void f(BoldType boldType) {
        s.h(boldType, "<set-?>");
        this.f10884d = boldType;
    }

    public final void g(float f2) {
        this.a = f2;
    }

    public final void h(float f2) {
        this.b = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31;
        boolean z = this.c;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int hashCode = (((floatToIntBits + i2) * 31) + this.f10884d.hashCode()) * 31;
        boolean z2 = this.f10885e;
        return hashCode + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final void i(boolean z) {
        this.c = z;
    }

    public final void j(boolean z) {
        this.f10885e = z;
    }

    public String toString() {
        return "BoldTipHelper(intermediateScale=" + this.a + ", maxSize=" + this.b + ", needFadeout=" + this.c + ", boldType=" + this.f10884d + ", selected=" + this.f10885e + ')';
    }
}
