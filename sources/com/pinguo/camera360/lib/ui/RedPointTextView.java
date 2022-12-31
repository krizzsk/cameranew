package com.pinguo.camera360.lib.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.widget.AutofitTextView;
/* loaded from: classes3.dex */
public class RedPointTextView extends AutofitTextView {
    private Rect b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f6837d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f6838e;

    public RedPointTextView(Context context) {
        super(context);
        this.b = new Rect();
        this.c = false;
        c();
    }

    private void c() {
        this.f6837d = n0.c(3);
        Paint paint = new Paint();
        this.f6838e = paint;
        paint.setColor(-635856);
        this.f6838e.setStyle(Paint.Style.FILL);
        this.f6838e.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.b);
        if (this.c) {
            int width = this.b.left + getWidth();
            int i2 = this.f6837d;
            canvas.drawCircle(width - i2, this.b.top + i2, i2, this.f6838e);
        }
    }

    public void setHasRedPoint(boolean z) {
        boolean z2 = this.c != z;
        this.c = z;
        if (z2) {
            invalidate();
        }
    }

    public RedPointTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.c = false;
        c();
    }

    public RedPointTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new Rect();
        this.c = false;
        c();
    }
}
