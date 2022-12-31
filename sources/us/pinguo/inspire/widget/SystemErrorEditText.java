package us.pinguo.inspire.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
/* loaded from: classes9.dex */
public class SystemErrorEditText extends AppCompatEditText {
    public SystemErrorEditText(Context context) {
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

    public SystemErrorEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SystemErrorEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
