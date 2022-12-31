package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.b.a;
import com.google.android.material.f.b;
/* loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private final boolean a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final float f4254d;

    public ElevationOverlayProvider(@NonNull Context context) {
        this.a = b.b(context, R.attr.elevationOverlayEnabled, false);
        this.b = a.b(context, R.attr.elevationOverlayColor, 0);
        this.c = a.b(context, R.attr.colorSurface, 0);
        this.f4254d = context.getResources().getDisplayMetrics().density;
    }

    private boolean f(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, 255) == this.c;
    }

    public float a(float f2) {
        float f3 = this.f4254d;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int b(@ColorInt int i2, float f2) {
        float a = a(f2);
        return ColorUtils.setAlphaComponent(a.h(ColorUtils.setAlphaComponent(i2, 255), this.b, a), Color.alpha(i2));
    }

    @ColorInt
    public int c(@ColorInt int i2, float f2) {
        return (this.a && f(i2)) ? b(i2, f2) : i2;
    }

    @ColorInt
    public int d(float f2) {
        return c(this.c, f2);
    }

    public boolean e() {
        return this.a;
    }
}
