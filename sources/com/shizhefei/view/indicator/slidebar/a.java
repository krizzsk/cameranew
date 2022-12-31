package com.shizhefei.view.indicator.slidebar;

import android.content.Context;
import android.view.View;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
/* compiled from: ColorBar.java */
/* loaded from: classes3.dex */
public class a implements ScrollBar {
    protected ScrollBar.Gravity a;
    protected View b;
    protected int c;

    /* renamed from: d  reason: collision with root package name */
    protected int f7163d;

    public a(Context context, int i2, int i3) {
        this(context, i2, i3, ScrollBar.Gravity.BOTTOM);
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public View a() {
        return this.b;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public int b(int i2) {
        int i3 = this.c;
        return i3 == 0 ? i2 : i3;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public ScrollBar.Gravity c() {
        return this.a;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public int d(int i2) {
        int i3 = this.f7163d;
        return i3 == 0 ? i2 : i3;
    }

    @Override // com.shizhefei.view.indicator.slidebar.ScrollBar
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    public a(Context context, int i2, int i3, ScrollBar.Gravity gravity) {
        View view = new View(context);
        this.b = view;
        view.setBackgroundColor(i2);
        this.c = i3;
        this.a = gravity;
    }
}
