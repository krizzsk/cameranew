package us.pinguo.common.filter.guide;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: MuskView.kt */
/* loaded from: classes4.dex */
public final class MuskView extends View {
    private Rect a;
    private final Paint b;

    public /* synthetic */ MuskView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Rect rect = this.a;
        if (rect == null || canvas == null) {
            return;
        }
        canvas.drawRect(rect, this.b);
    }

    public final void setRect(Rect rect) {
        this.a = rect;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuskView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        paint.setMaskFilter(new BlurMaskFilter(10.0f, BlurMaskFilter.Blur.INNER));
        setLayerType(1, null);
    }
}
