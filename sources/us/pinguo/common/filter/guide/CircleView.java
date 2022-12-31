package us.pinguo.common.filter.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: CircleView.kt */
/* loaded from: classes4.dex */
public final class CircleView extends AppCompatImageView {
    private final Paint a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ CircleView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void init() {
        this.a.setDither(true);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = (getWidth() - paddingLeft) - paddingRight;
            int height = (getHeight() - paddingTop) - paddingBottom;
            canvas.drawCircle(paddingLeft + (width / 2.0f), paddingTop + (height / 2.0f), Math.min(width, height) / 2.0f, this.a);
        }
    }

    public final void setCircleColor(int i2) {
        this.a.setColor(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        init();
    }
}
