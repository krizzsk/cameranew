package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* compiled from: CutCornerTreatment.java */
/* loaded from: classes2.dex */
public class e extends d {
    float a = -1.0f;

    @Override // com.google.android.material.shape.d
    public void a(@NonNull n nVar, float f2, float f3, float f4) {
        nVar.o(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = f4;
        double d3 = f3;
        nVar.m((float) (Math.sin(Math.toRadians(f2)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f2)) * d2 * d3));
    }
}
