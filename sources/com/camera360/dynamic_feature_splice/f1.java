package com.camera360.dynamic_feature_splice;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragLinearLayout.kt */
/* loaded from: classes8.dex */
public final class f1 {
    private int a;
    private View b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f2185d;

    /* renamed from: e  reason: collision with root package name */
    private int f2186e;

    /* renamed from: f  reason: collision with root package name */
    private int f2187f;

    /* renamed from: g  reason: collision with root package name */
    private Float f2188g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2189h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2190i;

    /* renamed from: j  reason: collision with root package name */
    private BitmapDrawable f2191j;

    /* renamed from: k  reason: collision with root package name */
    private int f2192k;

    /* renamed from: l  reason: collision with root package name */
    private ValueAnimator f2193l;
    private Integer m;

    public f1() {
        v();
    }

    private final BitmapDrawable b(View view) {
        int top = view.getTop();
        int left = view.getLeft();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getResources(), us.pinguo.foundation.ui.c.a(view));
        bitmapDrawable.setBounds(new Rect(left, top, view.getWidth() + left, view.getHeight() + top));
        bitmapDrawable.setAlpha(179);
        return bitmapDrawable;
    }

    public final boolean a() {
        return this.f2189h;
    }

    public final boolean c() {
        return this.f2190i;
    }

    public final Integer d() {
        return this.m;
    }

    public final int e() {
        return this.f2185d;
    }

    public final int f() {
        return this.f2192k;
    }

    public final ValueAnimator g() {
        return this.f2193l;
    }

    public final int h() {
        return this.c;
    }

    public final int i() {
        return this.f2187f;
    }

    public final int j() {
        return this.f2186e;
    }

    public final Float k() {
        return this.f2188g;
    }

    public final View l() {
        return this.b;
    }

    public final BitmapDrawable m() {
        return this.f2191j;
    }

    public final void n() {
        this.m = null;
        this.f2190i = true;
    }

    public final void o() {
        this.f2190i = false;
    }

    public final void p(Integer num) {
        this.m = num;
    }

    public final void q(int i2) {
        this.f2192k = i2;
    }

    public final void r(ValueAnimator valueAnimator) {
        this.f2193l = valueAnimator;
    }

    public final void s(int i2) {
        this.f2186e = i2;
        w();
    }

    public final boolean t() {
        return this.f2193l != null;
    }

    public final void u(View view, int i2, float f2) {
        kotlin.jvm.internal.s.h(view, "view");
        this.b = view;
        this.a = view.getVisibility();
        this.f2191j = b(view);
        this.f2192k = i2;
        this.c = view.getTop();
        this.f2185d = view.getHeight();
        this.f2186e = 0;
        this.f2187f = 0;
        this.f2193l = null;
        this.f2188g = Float.valueOf(f2);
        View view2 = this.b;
        kotlin.jvm.internal.s.e(view2);
        view2.setVisibility(4);
        this.m = null;
        this.f2189h = true;
    }

    public final void v() {
        this.f2189h = false;
        View view = this.b;
        if (view != null) {
            view.setVisibility(this.a);
        }
        this.b = null;
        this.a = -1;
        this.f2191j = null;
        this.f2192k = -1;
        this.c = -1;
        this.f2185d = -1;
        this.f2186e = 0;
        this.f2187f = 0;
        ValueAnimator valueAnimator = this.f2193l;
        if (valueAnimator != null) {
            valueAnimator.end();
        }
        this.f2193l = null;
        this.f2188g = null;
    }

    public final void w() {
        int i2 = this.c;
        View view = this.b;
        kotlin.jvm.internal.s.e(view);
        this.f2187f = (i2 - view.getTop()) + this.f2186e;
    }
}
