package us.pinguo.inspire.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes9.dex */
public class AntiAliasRelativeLayout extends RelativeLayout {
    private PaintFlagsDrawFilter a;

    public AntiAliasRelativeLayout(Context context) {
        super(context);
        this.a = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        canvas.setDrawFilter(this.a);
        return super.drawChild(canvas, view, j2);
    }

    public AntiAliasRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new PaintFlagsDrawFilter(0, 3);
    }

    public AntiAliasRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new PaintFlagsDrawFilter(0, 3);
    }
}
