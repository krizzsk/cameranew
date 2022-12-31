package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class NoneView extends View {
    public NoneView(Context context) {
        super(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public NoneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public NoneView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (getVisibility() == 0) {
            setVisibility(4);
            VdsAgent.onSetViewVisibility(this, 4);
        }
    }
}
