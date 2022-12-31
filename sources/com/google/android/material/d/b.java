package com.google.android.material.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes2.dex */
public final class b {
    @NonNull
    private final View a;
    private boolean b = false;
    @IdRes
    private int c = 0;

    public b(a aVar) {
        this.a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.a);
        }
    }

    @IdRes
    public int b() {
        return this.c;
    }

    public boolean c() {
        return this.b;
    }

    public void d(@NonNull Bundle bundle) {
        this.b = bundle.getBoolean("expanded", false);
        this.c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.b) {
            a();
        }
    }

    @NonNull
    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.b);
        bundle.putInt("expandedComponentIdHint", this.c);
        return bundle;
    }

    public void f(@IdRes int i2) {
        this.c = i2;
    }
}
