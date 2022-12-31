package com.tapjoy;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageButton;
/* loaded from: classes3.dex */
public class TJImageButton extends ImageButton {
    private Bitmap a;
    private Bitmap b;

    public TJImageButton(Context context) {
        super(context);
    }

    public void setDisableImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setImageBitmap(z ? this.a : this.b);
    }

    public void setEnabledImageBitmap(Bitmap bitmap) {
        this.a = bitmap;
    }

    public TJImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TJImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(21)
    public TJImageButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
