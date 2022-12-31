package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    private int a;

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ View a;
        final /* synthetic */ int b;
        final /* synthetic */ com.google.android.material.d.a c;

        a(View view, int i2, com.google.android.material.d.a aVar) {
            this.a = view;
            this.b = i2;
            this.c = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.a == this.b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                com.google.android.material.d.a aVar = this.c;
                expandableBehavior.d((View) aVar, this.a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    private boolean b(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i2 = this.a;
        return i2 == 0 || i2 == 2;
    }

    @Nullable
    protected com.google.android.material.d.a c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        List<View> dependencies = coordinatorLayout.getDependencies(view);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = dependencies.get(i2);
            if (layoutDependsOn(coordinatorLayout, view, view2)) {
                return (com.google.android.material.d.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean d(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        com.google.android.material.d.a aVar = (com.google.android.material.d.a) view2;
        if (b(aVar.a())) {
            this.a = aVar.a() ? 1 : 2;
            return d((View) aVar, view, aVar.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        com.google.android.material.d.a c;
        if (ViewCompat.isLaidOut(view) || (c = c(coordinatorLayout, view)) == null || !b(c.a())) {
            return false;
        }
        int i3 = c.a() ? 1 : 2;
        this.a = i3;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, c));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }
}
