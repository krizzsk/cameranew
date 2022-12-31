package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
/* loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends b {
    @Px

    /* renamed from: g  reason: collision with root package name */
    public int f4425g;
    @Px

    /* renamed from: h  reason: collision with root package name */
    public int f4426h;

    /* renamed from: i  reason: collision with root package name */
    public int f4427i;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.b
    public void e() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, CircularProgressIndicator.o);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray h2 = com.google.android.material.internal.k.h(context, attributeSet, R.styleable.CircularProgressIndicator, i2, i3, new int[0]);
        this.f4425g = Math.max(com.google.android.material.f.c.c(context, h2, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.f4426h = com.google.android.material.f.c.c(context, h2, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f4427i = h2.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        h2.recycle();
        e();
    }
}
