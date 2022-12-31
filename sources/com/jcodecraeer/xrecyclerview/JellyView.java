package com.jcodecraeer.xrecyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes2.dex */
public class JellyView extends View {
    Path a;
    Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f5796d;

    public JellyView(Context context) {
        super(context);
        this.c = 0;
        this.f5796d = 0;
        a();
    }

    private void a() {
        if (isInEditMode()) {
            return;
        }
        this.a = new Path();
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(getContext().getResources().getColor(17170459));
        this.b.setAntiAlias(true);
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return this.c;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a.reset();
        this.a.lineTo(0.0f, this.c);
        this.a.quadTo(getMeasuredWidth() / 2, this.c + this.f5796d, getMeasuredWidth(), this.c);
        this.a.lineTo(getMeasuredWidth(), 0.0f);
        canvas.drawPath(this.a, this.b);
    }

    public void setJellyColor(int i2) {
        this.b.setColor(i2);
    }

    public void setJellyHeight(int i2) {
        this.f5796d = i2;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.c = i2;
    }

    public JellyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = 0;
        this.f5796d = 0;
        a();
    }

    public JellyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = 0;
        this.f5796d = 0;
        a();
    }
}
