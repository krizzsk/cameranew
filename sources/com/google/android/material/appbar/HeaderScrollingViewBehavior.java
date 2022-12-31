package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f4065d;

    /* renamed from: e  reason: collision with root package name */
    final Rect f4066e;

    /* renamed from: f  reason: collision with root package name */
    private int f4067f;

    /* renamed from: g  reason: collision with root package name */
    private int f4068g;

    public HeaderScrollingViewBehavior() {
        this.f4065d = new Rect();
        this.f4066e = new Rect();
        this.f4067f = 0;
    }

    private static int j(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        View d2 = d(coordinatorLayout.getDependencies(view));
        if (d2 != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f4065d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, d2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + d2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            Rect rect2 = this.f4066e;
            GravityCompat.apply(j(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int e2 = e(d2);
            view.layout(rect2.left, rect2.top - e2, rect2.right, rect2.bottom - e2);
            this.f4067f = rect2.top - d2.getBottom();
            return;
        }
        super.b(coordinatorLayout, view, i2);
        this.f4067f = 0;
    }

    @Nullable
    abstract View d(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(View view) {
        if (this.f4068g == 0) {
            return 0;
        }
        float f2 = f(view);
        int i2 = this.f4068g;
        return MathUtils.clamp((int) (f2 * i2), 0, i2);
    }

    float f(View view) {
        return 1.0f;
    }

    public final int g() {
        return this.f4068g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int i() {
        return this.f4067f;
    }

    public final void k(int i2) {
        this.f4068g = i2;
    }

    protected boolean l() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        View d2;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 == -1 || i6 == -2) && (d2 = d(coordinatorLayout.getDependencies(view))) != null) {
            int size = View.MeasureSpec.getSize(i4);
            if (size > 0) {
                if (ViewCompat.getFitsSystemWindows(d2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            int h2 = size + h(d2);
            int measuredHeight = d2.getMeasuredHeight();
            if (l()) {
                view.setTranslationY(-measuredHeight);
            } else {
                h2 -= measuredHeight;
            }
            coordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec(h2, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
            return true;
        }
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4065d = new Rect();
        this.f4066e = new Rect();
        this.f4067f = 0;
    }
}
