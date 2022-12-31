package com.google.android.material.shape;

import androidx.annotation.NonNull;
/* compiled from: OffsetEdgeTreatment.java */
/* loaded from: classes2.dex */
public final class j extends f {
    private final f a;
    private final float b;

    public j(@NonNull f fVar, float f2) {
        this.a = fVar;
        this.b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.shape.f
    public boolean b() {
        return this.a.b();
    }

    @Override // com.google.android.material.shape.f
    public void c(float f2, float f3, float f4, @NonNull n nVar) {
        this.a.c(f2, f3 - this.b, f4, nVar);
    }
}
