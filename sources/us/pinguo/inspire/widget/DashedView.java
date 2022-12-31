package us.pinguo.inspire.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.R;
/* loaded from: classes9.dex */
public class DashedView extends View {
    private Paint a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f11315d;

    public DashedView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.b = us.pinguo.foundation.t.b.a.b(getResources(), 1.0f);
        int b = us.pinguo.foundation.t.b.a.b(getResources(), 4.0f);
        this.c = b;
        this.f11315d = b;
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setColor(getResources().getColor(R.color.text_lower));
        this.a.setStrokeWidth(this.b);
        this.a.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        float height = getHeight() / 2.0f;
        path.moveTo(0.0f, height);
        path.lineTo(getWidth(), height);
        this.a.setPathEffect(new DashPathEffect(new float[]{this.f11315d, this.c}, 0.0f));
        canvas.drawPath(path, this.a);
    }

    public DashedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DashedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
