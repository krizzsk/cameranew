package us.pinguo.camera360.shop.view.details;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: DotLineView.kt */
/* loaded from: classes4.dex */
public final class DotLineView extends View {
    private final Paint a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotLineView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();
        float f2 = height / 30;
        float f3 = height / 6;
        for (int i2 = 0; i2 < 7; i2++) {
            canvas.drawCircle(width / 2.0f, i2 * f3, f2, this.a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DotLineView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
    }
}
