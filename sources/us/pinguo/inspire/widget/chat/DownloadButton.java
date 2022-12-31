package us.pinguo.inspire.widget.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes9.dex */
public class DownloadButton extends TextView {
    private Paint a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f11349d;

    /* renamed from: e  reason: collision with root package name */
    private float f11350e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f11351f;

    public DownloadButton(Context context) {
        super(context);
        this.c = -12806145;
        this.f11349d = -13600564;
        this.f11351f = new RectF();
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.b = (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.a.setColor(this.c);
        this.f11351f.set(0.0f, 0.0f, getWidth(), getHeight());
        RectF rectF = this.f11351f;
        int i2 = this.b;
        canvas.drawRoundRect(rectF, i2, i2, this.a);
        float f2 = this.f11350e;
        if (f2 > 0.0f) {
            this.a.setColor(this.f11349d);
            canvas.save();
            canvas.clipRect(0, 0, (int) (f2 * getWidth()), getHeight());
            this.f11351f.set(0.0f, 0.0f, getWidth(), getHeight());
            RectF rectF2 = this.f11351f;
            int i3 = this.b;
            canvas.drawRoundRect(rectF2, i3, i3, this.a);
            canvas.restore();
        }
        super.onDraw(canvas);
    }

    public void setRate(float f2) {
        if (this.f11350e != f2) {
            this.f11350e = f2;
            invalidate();
        }
    }

    public DownloadButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = -12806145;
        this.f11349d = -13600564;
        this.f11351f = new RectF();
        a();
    }

    public DownloadButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.c = -12806145;
        this.f11349d = -13600564;
        this.f11351f = new RectF();
        a();
    }
}
