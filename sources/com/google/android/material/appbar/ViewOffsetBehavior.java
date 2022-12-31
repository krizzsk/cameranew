package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes2.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private a a;
    private int b;
    private int c;

    public ViewOffsetBehavior() {
        this.b = 0;
        this.c = 0;
    }

    public int a() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        coordinatorLayout.onLayoutChild(v, i2);
    }

    public boolean c(int i2) {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.f(i2);
        }
        this.b = i2;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        b(coordinatorLayout, v, i2);
        if (this.a == null) {
            this.a = new a(v);
        }
        this.a.d();
        this.a.a();
        int i3 = this.b;
        if (i3 != 0) {
            this.a.f(i3);
            this.b = 0;
        }
        int i4 = this.c;
        if (i4 != 0) {
            this.a.e(i4);
            this.c = 0;
            return true;
        }
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }
}
