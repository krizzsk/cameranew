package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.f;
import com.google.android.material.shape.n;
/* compiled from: BottomAppBarTopEdgeTreatment.java */
/* loaded from: classes2.dex */
public class a extends f implements Cloneable {
    private float a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f4107d;

    /* renamed from: e  reason: collision with root package name */
    private float f4108e;

    /* renamed from: f  reason: collision with root package name */
    private float f4109f = -1.0f;

    public a(float f2, float f3, float f4) {
        this.b = f2;
        this.a = f3;
        j(f4);
        this.f4108e = 0.0f;
    }

    @Override // com.google.android.material.shape.f
    public void c(float f2, float f3, float f4, @NonNull n nVar) {
        float f5;
        float f6;
        float f7 = this.c;
        if (f7 == 0.0f) {
            nVar.m(f2, 0.0f);
            return;
        }
        float f8 = ((this.b * 2.0f) + f7) / 2.0f;
        float f9 = f4 * this.a;
        float f10 = f3 + this.f4108e;
        float f11 = (this.f4107d * f4) + ((1.0f - f4) * f8);
        if (f11 / f8 >= 1.0f) {
            nVar.m(f2, 0.0f);
            return;
        }
        float f12 = this.f4109f;
        float f13 = f12 * f4;
        boolean z = f12 == -1.0f || Math.abs((f12 * 2.0f) - f7) < 0.1f;
        if (z) {
            f5 = f11;
            f6 = 0.0f;
        } else {
            f6 = 1.75f;
            f5 = 0.0f;
        }
        float f14 = f8 + f9;
        float f15 = f5 + f9;
        float sqrt = (float) Math.sqrt((f14 * f14) - (f15 * f15));
        float f16 = f10 - sqrt;
        float f17 = f10 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f15));
        float f18 = (90.0f - degrees) + f6;
        nVar.m(f16, 0.0f);
        float f19 = f9 * 2.0f;
        nVar.a(f16 - f9, 0.0f, f16 + f9, f19, 270.0f, degrees);
        if (z) {
            nVar.a(f10 - f8, (-f8) - f5, f10 + f8, f8 - f5, 180.0f - f18, (f18 * 2.0f) - 180.0f);
        } else {
            float f20 = this.b;
            float f21 = f13 * 2.0f;
            float f22 = f10 - f8;
            nVar.a(f22, -(f13 + f20), f22 + f20 + f21, f20 + f13, 180.0f - f18, ((f18 * 2.0f) - 180.0f) / 2.0f);
            float f23 = f10 + f8;
            float f24 = this.b;
            nVar.m(f23 - ((f24 / 2.0f) + f13), f24 + f13);
            float f25 = this.b;
            nVar.a(f23 - (f21 + f25), -(f13 + f25), f23, f25 + f13, 90.0f, f18 - 90.0f);
        }
        nVar.a(f17 - f9, 0.0f, f17 + f9, f19, 270.0f - degrees, degrees);
        nVar.m(f2, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f4107d;
    }

    public float e() {
        return this.f4109f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float i() {
        return this.f4108e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f4107d = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void k(float f2) {
        this.f4109f = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(float f2) {
        this.b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(float f2) {
        this.a = f2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void n(float f2) {
        this.c = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(float f2) {
        this.f4108e = f2;
    }
}
