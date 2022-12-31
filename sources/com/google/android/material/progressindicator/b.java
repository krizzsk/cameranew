package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
/* compiled from: BaseProgressIndicatorSpec.java */
/* loaded from: classes2.dex */
public abstract class b {
    @Px
    public int a;
    @Px
    public int b;
    @NonNull
    public int[] c = new int[0];
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    public int f4431d;

    /* renamed from: e  reason: collision with root package name */
    public int f4432e;

    /* renamed from: f  reason: collision with root package name */
    public int f4433f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray h2 = com.google.android.material.internal.k.h(context, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.a = com.google.android.material.f.c.c(context, h2, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(com.google.android.material.f.c.c(context, h2, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f4432e = h2.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f4433f = h2.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, h2);
        d(context, h2);
        h2.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i2 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i2)) {
            this.c = new int[]{com.google.android.material.b.a.b(context, R.attr.colorPrimary, -1)};
        } else if (typedArray.peekValue(i2).type != 1) {
            this.c = new int[]{typedArray.getColor(i2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i2, -1));
            this.c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i2 = R.styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i2)) {
            this.f4431d = typedArray.getColor(i2, -1);
            return;
        }
        this.f4431d = this.c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f2 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f4431d = com.google.android.material.b.a.a(this.f4431d, (int) (f2 * 255.0f));
    }

    public boolean a() {
        return this.f4433f != 0;
    }

    public boolean b() {
        return this.f4432e != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e();
}
