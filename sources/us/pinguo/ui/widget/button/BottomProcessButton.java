package us.pinguo.ui.widget.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public class BottomProcessButton extends ProcessButton {
    private int r;

    public BottomProcessButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.r = Float.valueOf(e(R.dimen.process_button_bottom_progress_height)).intValue();
    }

    @Override // us.pinguo.ui.widget.button.ProcessButton
    public void m(Canvas canvas) {
        int measuredWidth = (int) (getMeasuredWidth() * (t() / s()));
        canvas.save();
        canvas.translate(0.0f, getMeasuredHeight() - this.r);
        u().setBounds(0, 0, measuredWidth, this.r);
        u().draw(canvas);
        canvas.restore();
    }

    public BottomProcessButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomProcessButton(Context context) {
        this(context, null, 0);
    }
}
