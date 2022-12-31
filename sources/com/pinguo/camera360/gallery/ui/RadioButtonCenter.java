package com.pinguo.camera360.gallery.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
/* loaded from: classes3.dex */
public class RadioButtonCenter extends RadioButton {
    public RadioButtonCenter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        Drawable drawable = getCompoundDrawables()[1];
        if (drawable != null) {
            setPadding(getPaddingLeft(), (getMeasuredHeight() - drawable.getBounds().height()) / 2, getPaddingRight(), getPaddingBottom());
        }
    }
}
