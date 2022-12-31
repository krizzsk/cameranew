package us.pinguo.inspire.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class FeatureTextView extends TextView {
    private us.pinguo.ui.b.b a;

    public FeatureTextView(Context context) {
        super(context);
    }

    private void a(int i2, int i3) {
        if (this.a == null) {
            this.a = new us.pinguo.ui.b.b(this, 2, 0.5f);
        }
        this.a.a(i2, i3);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            a(((i4 - i2) - getPaddingLeft()) - getPaddingRight(), ((i5 - i3) - getPaddingTop()) - getPaddingBottom());
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        boolean z = !TextUtils.equals(charSequence, getText());
        super.setText(charSequence, bufferType);
        if (!z || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        a((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
    }

    public FeatureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FeatureTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
