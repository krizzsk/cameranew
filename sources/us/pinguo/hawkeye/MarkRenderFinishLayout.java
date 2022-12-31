package us.pinguo.hawkeye;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class MarkRenderFinishLayout extends FrameLayout {
    private String a;

    public MarkRenderFinishLayout(Context context) {
        super(context);
        this.a = "defalut";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        b.f11145f.e(this.a);
    }

    public MarkRenderFinishLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "defalut";
    }

    public MarkRenderFinishLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = "defalut";
    }
}
