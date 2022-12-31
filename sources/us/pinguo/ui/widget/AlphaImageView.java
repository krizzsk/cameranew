package us.pinguo.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes6.dex */
public class AlphaImageView extends AppCompatImageView {
    public AlphaImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (us.pinguo.util.c.f12472f && getBackground() != null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        getDrawable().setAlpha(100);
        if (motionEvent.getAction() == 0) {
            getDrawable().setAlpha(100);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getDrawable().setAlpha(255);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AlphaImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AlphaImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
