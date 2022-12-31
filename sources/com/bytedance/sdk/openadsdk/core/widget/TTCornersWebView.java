package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.ac;
/* loaded from: classes.dex */
public class TTCornersWebView extends WebView {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f1850d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f1851e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f1852f;

    /* renamed from: g  reason: collision with root package name */
    private float[] f1853g;

    public TTCornersWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1853g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f1851e = paint;
        paint.setColor(-1);
        this.f1851e.setAntiAlias(true);
        this.f1851e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f1852f = paint2;
        paint2.setXfermode(null);
        this.f1852f.setAntiAlias(true);
        float a = ac.a(context, 14.0f);
        a(a, a, 0.0f, 0.0f);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.c = getScrollX();
        this.f1850d = getScrollY();
        Path path = new Path();
        int i2 = this.f1850d;
        path.addRoundRect(new RectF(0.0f, i2, this.c + this.a, i2 + this.b), this.f1853g, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a = getMeasuredWidth();
        this.b = getMeasuredHeight();
    }

    public TTCornersWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1853g = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f1853g;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }
}
