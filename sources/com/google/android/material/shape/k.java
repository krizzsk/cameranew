package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;
/* compiled from: RelativeCornerSize.java */
/* loaded from: classes2.dex */
public final class k implements c {
    private final float a;

    public k(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a = f2;
    }

    @Override // com.google.android.material.shape.c
    public float a(@NonNull RectF rectF) {
        return this.a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.a == ((k) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
