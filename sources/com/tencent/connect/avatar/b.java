package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import us.pinguo.inspire.module.challenge.videomusic.VideoEdit2Activity;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class b extends View {
    private Rect a;
    private Paint b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.b = new Paint();
    }

    public Rect a() {
        if (this.a == null) {
            this.a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), (int) VideoEdit2Activity.MIN_SCALED_SIZE);
            int i2 = (measuredWidth - min) / 2;
            int i3 = (measuredHeight - min) / 2;
            this.a.set(i2, i3, i2 + min, min + i3);
        }
        return this.a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect a = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(Color.argb(100, 0, 0, 0));
        float f2 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f2, a.top, this.b);
        canvas.drawRect(0.0f, a.bottom, f2, measuredHeight, this.b);
        canvas.drawRect(0.0f, a.top, a.left, a.bottom, this.b);
        canvas.drawRect(a.right, a.top, f2, a.bottom, this.b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(-1);
        canvas.drawRect(a.left, a.top, a.right - 1, a.bottom, this.b);
    }
}
