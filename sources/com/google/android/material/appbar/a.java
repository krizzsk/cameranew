package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;
/* compiled from: ViewOffsetHelper.java */
/* loaded from: classes2.dex */
class a {
    private final View a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f4070d;

    /* renamed from: e  reason: collision with root package name */
    private int f4071e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4072f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4073g = true;

    public a(View view) {
        this.a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.a;
        ViewCompat.offsetTopAndBottom(view, this.f4070d - (view.getTop() - this.b));
        View view2 = this.a;
        ViewCompat.offsetLeftAndRight(view2, this.f4071e - (view2.getLeft() - this.c));
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f4070d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.b = this.a.getTop();
        this.c = this.a.getLeft();
    }

    public boolean e(int i2) {
        if (!this.f4073g || this.f4071e == i2) {
            return false;
        }
        this.f4071e = i2;
        a();
        return true;
    }

    public boolean f(int i2) {
        if (!this.f4072f || this.f4070d == i2) {
            return false;
        }
        this.f4070d = i2;
        a();
        return true;
    }
}
