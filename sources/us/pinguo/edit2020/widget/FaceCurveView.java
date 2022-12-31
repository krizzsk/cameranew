package us.pinguo.edit2020.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.R;
/* compiled from: FaceCurveView.kt */
/* loaded from: classes4.dex */
public final class FaceCurveView extends View {
    private final int a;
    private PointF[] b;
    private RectF[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f10924d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f10925e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10926f;

    /* renamed from: g  reason: collision with root package name */
    private final int f10927g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f10928h;

    /* renamed from: i  reason: collision with root package name */
    private int f10929i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceCurveView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = 8;
        Paint paint = new Paint(1);
        this.f10925e = paint;
        int argb = Color.argb(178, 255, 255, 255);
        this.f10926f = argb;
        this.f10927g = getResources().getColor(R.color.color_theme);
        this.f10928h = new Path();
        this.f10929i = -1;
        paint.setColor(argb);
        paint.setStyle(Paint.Style.STROKE);
        Context context2 = getContext();
        s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
    }

    private final float b(PointF pointF, PointF pointF2) {
        float f2 = pointF.x;
        float f3 = pointF2.x;
        float f4 = pointF.y;
        float f5 = pointF2.y;
        return (float) Math.sqrt(((f2 - f3) * (f2 - f3)) + ((f4 - f5) * (f4 - f5)));
    }

    public static /* synthetic */ PointF e(FaceCurveView faceCurveView, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        return faceCurveView.d(num);
    }

    public final void a() {
        this.f10929i = -1;
        this.f10924d = 0;
        this.c = null;
        this.b = null;
    }

    public final void c(PointF[] points, boolean z) {
        s.h(points, "points");
        if (points.length == 0) {
            a();
            return;
        }
        if (points.length > 48) {
            this.b = (PointF[]) kotlin.collections.j.g(points, 0, 48);
            this.f10924d = 6;
        } else {
            this.b = points;
            this.f10924d = points.length / this.a;
        }
        int i2 = this.f10924d;
        RectF[] rectFArr = new RectF[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            RectF rectF = new RectF();
            int i4 = this.a;
            PointF pointF = points[(i3 * i4) + 0];
            PointF pointF2 = points[(i4 * i3) + 1];
            rectF.left = pointF.x;
            rectF.top = pointF.y;
            rectF.right = pointF2.x;
            rectF.bottom = pointF2.y;
            rectFArr[i3] = rectF;
        }
        this.c = rectFArr;
        if (this.f10929i == -1 && z) {
            this.f10929i = 0;
        }
        if (this.f10924d >= 2) {
            invalidate();
        }
    }

    public final PointF d(Integer num) {
        RectF[] rectFArr = this.c;
        if (rectFArr == null) {
            return null;
        }
        RectF rectF = rectFArr[num == null ? this.f10929i : num.intValue()];
        float f2 = 2;
        return new PointF((rectF.right + rectF.left) / f2, (rectF.top + rectF.bottom) / f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003e A[LOOP:0: B:11:0x0017->B:24:0x003e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(android.graphics.PointF r10) {
        /*
            r9 = this;
            java.lang.String r0 = "p"
            kotlin.jvm.internal.s.h(r10, r0)
            android.graphics.RectF[] r0 = r9.c
            r1 = -1
            if (r0 == 0) goto L48
            int r2 = r0.length
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L11
            r2 = 1
            goto L12
        L11:
            r2 = 0
        L12:
            if (r2 == 0) goto L15
            goto L48
        L15:
            int r2 = r0.length
            r5 = 0
        L17:
            if (r5 >= r2) goto L41
            r6 = r0[r5]
            float r7 = r10.x
            float r8 = r6.left
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 < 0) goto L39
            float r8 = r6.right
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 > 0) goto L39
            float r7 = r10.y
            float r8 = r6.top
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 < 0) goto L39
            float r6 = r6.bottom
            int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r6 > 0) goto L39
            r6 = 1
            goto L3a
        L39:
            r6 = 0
        L3a:
            if (r6 == 0) goto L3e
            r1 = r5
            goto L41
        L3e:
            int r5 = r5 + 1
            goto L17
        L41:
            if (r1 < 0) goto L45
            r9.f10929i = r1
        L45:
            r9.invalidate()
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.widget.FaceCurveView.f(android.graphics.PointF):int");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i2;
        FaceCurveView faceCurveView = this;
        s.h(canvas, "canvas");
        PointF[] pointFArr = faceCurveView.b;
        if (pointFArr == null || (i2 = faceCurveView.f10924d) < 2) {
            return;
        }
        Paint paint = faceCurveView.f10925e;
        Path path = faceCurveView.f10928h;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i3 + 1;
            path.reset();
            if (faceCurveView.f10929i == i3) {
                paint.setColor(faceCurveView.f10927g);
            } else {
                paint.setColor(faceCurveView.f10926f);
            }
            int i5 = i3 * faceCurveView.a;
            PointF pointF = pointFArr[i5 + 2];
            PointF pointF2 = pointFArr[i5 + 3];
            PointF pointF3 = pointFArr[i5 + 4];
            PointF pointF4 = pointFArr[i5 + 5];
            PointF pointF5 = pointFArr[i5 + 6];
            PointF pointF6 = pointFArr[i5 + 7];
            float f2 = (pointF.y - pointF4.y) / (pointF.x - pointF4.x);
            PointF[] pointFArr2 = pointFArr;
            float f3 = (pointF2.y - pointF5.y) / (pointF2.x - pointF5.x);
            int i6 = i2;
            float f4 = (pointF3.y - pointF6.y) / (pointF3.x - pointF6.x);
            Paint paint2 = paint;
            double b = faceCurveView.b(pointF, pointF4) * 0.1d;
            double b2 = faceCurveView.b(pointF2, pointF5) * 0.2d;
            Path path2 = path;
            double b3 = faceCurveView.b(pointF3, pointF6) * 0.15d;
            float f5 = pointF.x < pointF4.x ? -1.0f : 1.0f;
            float f6 = 1;
            float sqrt = ((float) Math.sqrt((b * b) / ((f2 * f2) + f6))) * f5;
            float sqrt2 = ((float) Math.sqrt((b2 * b2) / ((f3 * f3) + f6))) * f5;
            float sqrt3 = f5 * ((float) Math.sqrt((b3 * b3) / ((f4 * f4) + f6)));
            float f7 = -sqrt;
            float f8 = -sqrt2;
            float f9 = -sqrt3;
            float f10 = f2 * f8;
            float f11 = pointF.x + sqrt;
            float f12 = pointF.y + (f2 * sqrt);
            float f13 = pointF3.x + sqrt3;
            float f14 = pointF3.y + (f4 * sqrt3);
            float f15 = pointF4.x + f7;
            float f16 = pointF4.y + (f2 * f7);
            float f17 = pointF6.y;
            path2.moveTo(f11, f12);
            path2.quadTo(pointF2.x + sqrt2, pointF2.y + (f3 * sqrt2), f13, f14);
            canvas.drawPath(path2, paint2);
            path2.reset();
            path2.moveTo(f15, f16);
            path2.quadTo(pointF5.x + f8, pointF5.y + f10, pointF6.x + f9, f17 + (f2 * f9));
            canvas.drawPath(path2, paint2);
            paint = paint2;
            path = path2;
            pointFArr = pointFArr2;
            i2 = i6;
            i3 = i4;
            faceCurveView = this;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    public final void setSelectFace(int i2) {
        this.f10929i = i2;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceCurveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 8;
        Paint paint = new Paint(1);
        this.f10925e = paint;
        int argb = Color.argb(178, 255, 255, 255);
        this.f10926f = argb;
        this.f10927g = getResources().getColor(R.color.color_theme);
        this.f10928h = new Path();
        this.f10929i = -1;
        paint.setColor(argb);
        paint.setStyle(Paint.Style.STROKE);
        Context context2 = getContext();
        s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaceCurveView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 8;
        Paint paint = new Paint(1);
        this.f10925e = paint;
        int argb = Color.argb(178, 255, 255, 255);
        this.f10926f = argb;
        this.f10927g = getResources().getColor(R.color.color_theme);
        this.f10928h = new Path();
        this.f10929i = -1;
        paint.setColor(argb);
        paint.setStyle(Paint.Style.STROKE);
        Context context2 = getContext();
        s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 2.0f));
    }
}
