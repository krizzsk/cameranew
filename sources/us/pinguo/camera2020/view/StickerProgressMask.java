package us.pinguo.camera2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import us.pinguo.camera2020.R;
/* compiled from: StickerProgressMask.kt */
/* loaded from: classes3.dex */
public final class StickerProgressMask extends View {
    private final Paint a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f9300d;

    /* renamed from: e  reason: collision with root package name */
    private float f9301e;

    /* renamed from: f  reason: collision with root package name */
    private float f9302f;

    /* renamed from: g  reason: collision with root package name */
    private int f9303g;

    /* renamed from: h  reason: collision with root package name */
    private float f9304h;

    /* renamed from: i  reason: collision with root package name */
    private final float f9305i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f9306j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerProgressMask(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.f9300d = new PointF();
        this.f9303g = Color.parseColor("#4F000000");
        this.f9305i = getContext().getResources().getDimension(R.dimen.sticker_item_corner_radius);
        this.f9306j = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.f9306j.reset();
        Path path = this.f9306j;
        float f2 = this.b;
        float f3 = this.c;
        float f4 = this.f9305i;
        path.addRoundRect(0.0f, 0.0f, f2, f3, f4, f4, Path.Direction.CW);
        canvas.clipPath(this.f9306j);
        this.a.setColor(this.f9303g);
        PointF pointF = this.f9300d;
        float f5 = pointF.x;
        float f6 = this.f9301e;
        float f7 = pointF.y;
        float f8 = this.f9302f;
        float f9 = f7 + f8;
        float f10 = this.f9304h;
        canvas.drawArc(f5 - f6, f7 - f8, f5 + f6, f9, f10 - 90, 360.0f - f10, true, this.a);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.b = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        this.c = measuredHeight;
        PointF pointF = this.f9300d;
        float f2 = this.b;
        pointF.x = f2 * 0.5f;
        pointF.y = measuredHeight * 0.5f;
        this.f9301e = f2 * 0.5f * 1.4142f;
        this.f9302f = measuredHeight * 0.5f * 1.4142f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerProgressMask(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.f9300d = new PointF();
        this.f9303g = Color.parseColor("#4F000000");
        this.f9305i = getContext().getResources().getDimension(R.dimen.sticker_item_corner_radius);
        this.f9306j = new Path();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerProgressMask(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.f9300d = new PointF();
        this.f9303g = Color.parseColor("#4F000000");
        this.f9305i = getContext().getResources().getDimension(R.dimen.sticker_item_corner_radius);
        this.f9306j = new Path();
    }
}
