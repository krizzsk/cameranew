package io.codetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import f.a.a.a;
/* loaded from: classes3.dex */
public class RevealFrameLayout extends FrameLayout {
    private a a;

    public RevealFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        try {
            canvas.save();
            this.a.a(canvas, view);
            return super.drawChild(canvas, view, j2);
        } finally {
            canvas.restore();
        }
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RevealFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new a();
    }
}
