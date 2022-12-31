package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;
/* compiled from: DrawingDelegate.java */
/* loaded from: classes2.dex */
abstract class g<S extends b> {
    S a;
    protected f b;

    public g(S s) {
        this.a = s;
    }

    abstract void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(@NonNull Canvas canvas, @NonNull Paint paint);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int e();

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull f fVar) {
        this.b = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a.e();
        a(canvas, f2);
    }
}
