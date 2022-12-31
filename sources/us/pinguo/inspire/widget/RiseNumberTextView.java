package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.text.DecimalFormat;
/* loaded from: classes9.dex */
public class RiseNumberTextView extends TextView {

    /* loaded from: classes9.dex */
    public interface a {
    }

    public RiseNumberTextView(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        new DecimalFormat("##0.00");
    }

    public void setOnEnd(a aVar) {
    }

    public RiseNumberTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RiseNumberTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
