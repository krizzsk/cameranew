package us.pinguo.edit2020.view.loading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: LineProgressView.kt */
/* loaded from: classes4.dex */
public final class LineProgressView extends View {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f10784d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f10785e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context) {
        this(context, null, 0, 6, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        s.h(context, "context");
    }

    public /* synthetic */ LineProgressView(Context context, AttributeSet attributeSet, int i2, int i3, o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void a(float f2) {
        this.c = (int) (this.a * f2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        int i2 = this.a;
        int i3 = this.c;
        int i4 = this.b;
        int i5 = this.f10784d;
        canvas.drawLine(i2 - i3, i4 - (i5 / 2), i2 + i3, i4 + (i5 / 2), this.f10785e);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.a = i2 / 2;
        this.b = i3 / 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.f10784d = us.pinguo.common.widget.i.a.a(1);
        Paint paint = new Paint(1);
        this.f10785e = paint;
        paint.setColor(-1);
    }
}
