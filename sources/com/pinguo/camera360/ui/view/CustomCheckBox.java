package com.pinguo.camera360.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
/* loaded from: classes3.dex */
public class CustomCheckBox extends CheckBox {
    public CustomCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
    }

    public CustomCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomCheckBox(Context context) {
        super(context);
    }
}
