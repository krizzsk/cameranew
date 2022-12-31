package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class RedDotTextView extends TextView {
    public RedDotTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (getText().length() == 1) {
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            int i4 = (int) (((int) (fontMetrics.bottom - fontMetrics.top)) * 1.2d);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            return;
        }
        super.onMeasure(i2, i3);
    }

    public RedDotTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedDotTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
