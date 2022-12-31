package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.internal.p;
import com.google.android.material.tabs.TabLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TabIndicatorInterpolator.java */
/* loaded from: classes2.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        if (!tabLayout.E() && (view instanceof TabLayout.TabView)) {
            return b((TabLayout.TabView) view, 24);
        }
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF b(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i2) {
        int l2 = tabView.l();
        int k2 = tabView.k();
        int c = (int) p.c(tabView.getContext(), i2);
        if (l2 < c) {
            l2 = c;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i3 = l2 / 2;
        return new RectF(left - i3, top - (k2 / 2), i3 + left, top + (left / 2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull Drawable drawable) {
        RectF a = a(tabLayout, view);
        RectF a2 = a(tabLayout, view2);
        drawable.setBounds(com.google.android.material.animation.a.c((int) a.left, (int) a2.left, f2), drawable.getBounds().top, com.google.android.material.animation.a.c((int) a.right, (int) a2.right, f2), drawable.getBounds().bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a = a(tabLayout, view);
        drawable.setBounds((int) a.left, drawable.getBounds().top, (int) a.right, drawable.getBounds().bottom);
    }
}
