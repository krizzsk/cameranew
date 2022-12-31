package com.shizhefei.view.indicator.c;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shizhefei.view.indicator.a;
/* compiled from: OnTransitionTextListener.java */
/* loaded from: classes3.dex */
public class a implements a.d {
    private d.i.a.a.a gradient;
    private float selectSize = -1.0f;
    private float unSelectSize = -1.0f;
    private float dFontFize = -1.0f;
    private boolean isPxSize = false;

    public a() {
    }

    public TextView getTextView(View view, int i2) {
        throw null;
    }

    @Override // com.shizhefei.view.indicator.a.d
    public void onTransition(View view, int i2, float f2) {
        TextView textView = getTextView(view, i2);
        d.i.a.a.a aVar = this.gradient;
        if (aVar != null) {
            textView.setTextColor(aVar.a((int) (100.0f * f2)));
        }
        float f3 = this.unSelectSize;
        if (f3 <= 0.0f || this.selectSize <= 0.0f) {
            return;
        }
        if (this.isPxSize) {
            textView.setTextSize(0, f3 + (this.dFontFize * f2));
        } else {
            textView.setTextSize(f3 + (this.dFontFize * f2));
        }
    }

    public final a setColor(int i2, int i3) {
        this.gradient = new d.i.a.a.a(i3, i2, 100);
        return this;
    }

    public final a setColorId(Context context, int i2, int i3) {
        Resources resources = context.getResources();
        setColor(resources.getColor(i2), resources.getColor(i3));
        return this;
    }

    public final a setSize(float f2, float f3) {
        this.isPxSize = false;
        this.selectSize = f2;
        this.unSelectSize = f3;
        this.dFontFize = f2 - f3;
        return this;
    }

    public final a setSizeId(Context context, int i2, int i3) {
        Resources resources = context.getResources();
        setSize(resources.getDimensionPixelSize(i2), resources.getDimensionPixelSize(i3));
        this.isPxSize = true;
        return this;
    }

    public final a setValueFromRes(Context context, int i2, int i3, int i4, int i5) {
        setColorId(context, i2, i3);
        setSizeId(context, i4, i5);
        return this;
    }

    public a(float f2, float f3, int i2, int i3) {
        setColor(i2, i3);
        setSize(f2, f3);
    }
}
