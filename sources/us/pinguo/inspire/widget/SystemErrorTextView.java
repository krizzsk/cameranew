package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class SystemErrorTextView extends TextView {
    public SystemErrorTextView(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return false;
        }
    }

    public SystemErrorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SystemErrorTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
