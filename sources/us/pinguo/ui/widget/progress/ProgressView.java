package us.pinguo.ui.widget.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.timepicker.TimeModel;
import com.zhy.android.percent.support.PercentLayoutHelper;
/* loaded from: classes6.dex */
public class ProgressView extends View {
    private Paint a;
    private Paint b;
    private int c;

    public ProgressView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.a = paint;
        paint.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(8.0f);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setColor(-1);
        this.b.setTextSize(48.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        Rect rect;
        super.onDraw(canvas);
        int measuredWidth = getMeasuredWidth();
        this.a.setColor(-2130706433);
        float f2 = measuredWidth / 2;
        canvas.drawCircle(f2, f2, i2 - 8, this.a);
        this.a.setColor(-1);
        float f3 = measuredWidth - 8;
        canvas.drawArc(new RectF(8.0f, 8.0f, f3, f3), -90.0f, (this.c / 100.0f) * 360.0f, false, this.a);
        String str = String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(this.c)) + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT;
        this.b.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, i2 - ((rect.right - rect.left) / 2), i2 + ((rect.bottom - rect.top) / 2), this.b);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
