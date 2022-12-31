package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
/* compiled from: ElasticTabIndicatorInterpolator.java */
/* loaded from: classes2.dex */
class a extends b {
    private static float e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (float) (1.0d - Math.cos((f2 * 3.141592653589793d) / 2.0d));
    }

    private static float f(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return (float) Math.sin((f2 * 3.141592653589793d) / 2.0d);
    }

    @Override // com.google.android.material.tabs.b
    void c(TabLayout tabLayout, View view, View view2, float f2, @NonNull Drawable drawable) {
        float f3;
        float e2;
        RectF a = b.a(tabLayout, view);
        RectF a2 = b.a(tabLayout, view2);
        if (a.left < a2.left) {
            f3 = e(f2);
            e2 = f(f2);
        } else {
            f3 = f(f2);
            e2 = e(f2);
        }
        drawable.setBounds(com.google.android.material.animation.a.c((int) a.left, (int) a2.left, f3), drawable.getBounds().top, com.google.android.material.animation.a.c((int) a.right, (int) a2.right, e2), drawable.getBounds().bottom);
    }
}
