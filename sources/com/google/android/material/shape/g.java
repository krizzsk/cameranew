package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* compiled from: MarkerEdgeTreatment.java */
/* loaded from: classes2.dex */
public final class g extends f {
    private final float a;

    public g(float f2) {
        this.a = f2 - 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.f
    public boolean b() {
        return true;
    }

    @Override // com.google.android.material.shape.f
    public void c(float f2, float f3, float f4, @NonNull n nVar) {
        float sqrt = (float) ((this.a * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.a, 2.0d) - Math.pow(sqrt, 2.0d));
        nVar.n(f3 - sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
        nVar.m(f3, (float) (-((this.a * Math.sqrt(2.0d)) - this.a)));
        nVar.m(f3 + sqrt, ((float) (-((this.a * Math.sqrt(2.0d)) - this.a))) + sqrt2);
    }
}
