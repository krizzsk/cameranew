package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private int a;
    private int b;
    private int c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f4083d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f4083d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }

    private void b(@NonNull V v, int i2, long j2, TimeInterpolator timeInterpolator) {
        this.f4083d = v.animate().translationY(i2).setInterpolator(timeInterpolator).setDuration(j2).setListener(new a());
    }

    public void c(@NonNull V v, @Dimension int i2) {
        this.c = i2;
        if (this.b == 1) {
            v.setTranslationY(this.a + i2);
        }
    }

    public void d(@NonNull V v) {
        if (this.b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4083d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        b(v, this.a + this.c, 175L, com.google.android.material.animation.a.c);
    }

    public void e(@NonNull V v) {
        if (this.b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4083d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        b(v, 0, 225L, com.google.android.material.animation.a.f4032d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        this.a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.onLayoutChild(coordinatorLayout, v, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
        if (i3 > 0) {
            d(v);
        } else if (i3 < 0) {
            e(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        return i2 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
        this.b = 2;
        this.c = 0;
    }
}
