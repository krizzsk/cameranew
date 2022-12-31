package us.pinguo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
/* loaded from: classes6.dex */
public class CommonRoundImageView extends AppCompatImageView {
    private g a;

    public CommonRoundImageView(Context context) {
        super(context);
        this.a = new g(this, context, null, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.d(canvas);
    }

    public void setBorderRadius(int i2) {
        this.a.e(i2);
    }

    public CommonRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new g(this, context, attributeSet, 0);
    }

    public CommonRoundImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new g(this, context, attributeSet, i2);
    }
}
