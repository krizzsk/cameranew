package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import us.pinguo.edit2020.R;
/* compiled from: ShapeDirectionView.kt */
/* loaded from: classes4.dex */
public final class ShapeDirectionView extends View {
    private Paint a;
    private int b;
    private Drawable c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f10731d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f10732e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f10733f;

    /* renamed from: g  reason: collision with root package name */
    private float f10734g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10735h;

    /* renamed from: i  reason: collision with root package name */
    private float f10736i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10737j;

    /* renamed from: k  reason: collision with root package name */
    private final int f10738k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10739l;
    private final float m;
    private final float[] n;
    private final Matrix o;
    private final Runnable p;
    private boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeDirectionView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = -1;
        this.c = getContext().getDrawable(R.drawable.ic_shape_start);
        this.f10732e = getContext().getDrawable(R.drawable.ic_shape_end);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10734g = us.pinguo.util.g.b(context2, 48.0f);
        this.f10736i = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10738k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.b(context3, 8.0f);
        this.n = new float[]{0.0f, 0.0f};
        this.o = new Matrix();
        this.p = new Runnable() { // from class: us.pinguo.edit2020.view.x
            @Override // java.lang.Runnable
            public final void run() {
                ShapeDirectionView.g(ShapeDirectionView.this);
            }
        };
        this.q = true;
    }

    private final void a(float f2, float f3, Canvas canvas) {
        this.a.setColor(Color.parseColor("#88ffffff"));
        float f4 = this.f10734g;
        float f5 = 6;
        canvas.drawLine(f2 - (f4 / f5), f3, f2 + (f4 / f5), f3, this.a);
        float f6 = this.f10734g;
        canvas.drawLine(f2, f3 - (f6 / f5), f2, f3 + (f6 / f5), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final ShapeDirectionView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.animate().alpha(0.0f).setDuration(150L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.view.y
            @Override // java.lang.Runnable
            public final void run() {
                ShapeDirectionView.h(ShapeDirectionView.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ShapeDirectionView this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.setVisibility(4);
        VdsAgent.onSetViewVisibility(this$0, 4);
        this$0.setAlpha(1.0f);
    }

    public static /* synthetic */ void n(ShapeDirectionView shapeDirectionView, PointF pointF, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            pointF = null;
        }
        shapeDirectionView.m(pointF);
    }

    public final Drawable b() {
        return this.f10732e;
    }

    public final float c() {
        return this.f10734g;
    }

    public final boolean d() {
        return this.f10737j;
    }

    public final Drawable e() {
        return this.c;
    }

    public final void f() {
        animate().cancel();
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.p);
        }
        this.f10739l = false;
        setVisibility(4);
        VdsAgent.onSetViewVisibility(this, 4);
        setRingColor(-1);
        setAutoHide(true);
        invalidate();
    }

    public final boolean i() {
        return this.f10735h;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r6 != 5) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.s.h(r6, r0)
            float r0 = r6.getX()
            float r1 = r6.getY()
            int r2 = r6.getAction()
            int r6 = r6.getActionMasked()
            r6 = r6 & r2
            r2 = 1
            if (r6 == 0) goto Laf
            if (r6 == r2) goto Lab
            r3 = 2
            if (r6 == r3) goto L26
            r0 = 3
            if (r6 == r0) goto Lab
            r0 = 5
            if (r6 == r0) goto Lab
            goto Lbd
        L26:
            boolean r6 = r5.q
            if (r6 != 0) goto L2b
            return r2
        L2b:
            android.graphics.PointF r6 = r5.f10731d
            if (r6 != 0) goto L30
            return r2
        L30:
            boolean r3 = r5.f10739l
            if (r3 == 0) goto L4e
            boolean r3 = r5.f10735h
            if (r3 == 0) goto L3d
            r6.x = r0
            r6.y = r1
            goto L49
        L3d:
            android.graphics.PointF r6 = r5.f10733f
            if (r6 != 0) goto L42
            goto L44
        L42:
            r6.x = r0
        L44:
            if (r6 != 0) goto L47
            goto L49
        L47:
            r6.y = r1
        L49:
            r5.invalidate()
            goto Lbd
        L4e:
            float r3 = r6.x
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r5.f10738k
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L6c
            float r3 = r6.y
            float r3 = r1 - r3
            float r3 = java.lang.Math.abs(r3)
            int r4 = r5.f10738k
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto Lbd
        L6c:
            android.os.Handler r3 = r5.getHandler()
            if (r3 != 0) goto L73
            goto L78
        L73:
            java.lang.Runnable r4 = r5.p
            r3.removeCallbacks(r4)
        L78:
            android.view.ViewPropertyAnimator r3 = r5.animate()
            r3.cancel()
            int r3 = r5.getVisibility()
            r4 = 0
            if (r3 != 0) goto L88
            r3 = 1
            goto L89
        L88:
            r3 = 0
        L89:
            if (r3 != 0) goto L91
            r5.setVisibility(r4)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r5, r4)
        L91:
            r5.f10739l = r2
            boolean r3 = r5.f10735h
            if (r3 == 0) goto L98
            goto La3
        L98:
            android.graphics.PointF r6 = r5.f10733f
            if (r6 != 0) goto La3
            android.graphics.PointF r6 = new android.graphics.PointF
            r6.<init>()
            r5.f10733f = r6
        La3:
            r6.x = r0
            r6.y = r1
            r5.invalidate()
            goto Lbd
        Lab:
            r5.f()
            goto Lbd
        Laf:
            r6 = 0
            n(r5, r6, r2, r6)
            android.graphics.PointF r6 = new android.graphics.PointF
            r6.<init>(r0, r1)
            r5.f10731d = r6
            r5.invalidate()
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.ShapeDirectionView.l(android.view.MotionEvent):boolean");
    }

    public final void m(PointF pointF) {
        if (pointF != null) {
            this.f10731d = pointF;
            invalidate();
        }
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        if (this.q) {
            animate().cancel();
            setAlpha(1.0f);
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.p);
            }
            Handler handler2 = getHandler();
            if (handler2 == null) {
                return;
            }
            handler2.postDelayed(this.p, 600L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f10736i);
        this.a.setColor(this.b);
        PointF pointF = this.f10731d;
        if (pointF != null) {
            float c = c() * 0.5f;
            if (i()) {
                canvas.drawCircle(pointF.x, pointF.y, c, this.a);
                if (d()) {
                    a(pointF.x, pointF.y, canvas);
                }
            } else {
                Drawable e2 = e();
                if (e2 != null) {
                    float f2 = pointF.x;
                    float f3 = pointF.y;
                    e2.setBounds((int) (f2 - c), (int) (f3 - c), (int) (f2 + c), (int) (f3 + c));
                }
                Drawable e3 = e();
                if (e3 != null) {
                    e3.draw(canvas);
                }
            }
        }
        PointF pointF2 = this.f10733f;
        if (pointF2 == null) {
            return;
        }
        float c2 = c() * 0.5f;
        Drawable b = b();
        if (b != null) {
            float f4 = pointF2.x;
            float f5 = pointF2.y;
            b.setBounds((int) (f4 - c2), (int) (f5 - c2), (int) (f4 + c2), (int) (f5 + c2));
        }
        Drawable b2 = b();
        if (b2 != null) {
            b2.draw(canvas);
        }
        PointF pointF3 = this.f10731d;
        if (pointF3 == null) {
            return;
        }
        canvas.drawLine(pointF3.x, pointF3.y, pointF2.x, pointF2.y, this.a);
        float f6 = pointF2.y;
        float f7 = pointF3.y;
        float f8 = pointF2.x;
        float f9 = pointF3.x;
        float f10 = (f6 - f7) / (f8 - f9);
        float sqrt = ((f6 - f7) / ((float) Math.sqrt(((f8 - f9) * (f8 - f9)) + ((f6 - f7) * (f6 - f7))))) * this.m;
        float f11 = pointF2.y - sqrt;
        float f12 = pointF2.x - (sqrt / f10);
        float[] fArr = this.n;
        fArr[0] = f12;
        fArr[1] = f11;
        this.o.reset();
        this.o.setRotate(45.0f, pointF2.x, pointF2.y);
        this.o.mapPoints(this.n);
        float[] fArr2 = this.n;
        float f13 = fArr2[0];
        float f14 = fArr2[1];
        fArr2[0] = f12;
        fArr2[1] = f11;
        this.o.reset();
        this.o.setRotate(-45.0f, pointF2.x, pointF2.y);
        this.o.mapPoints(this.n);
        float[] fArr3 = this.n;
        float f15 = fArr3[0];
        float f16 = fArr3[1];
        canvas.drawLine(pointF2.x, pointF2.y, f13, f14, this.a);
        canvas.drawLine(pointF2.x, pointF2.y, f15, f16, this.a);
    }

    public final void setAutoHide(boolean z) {
        Handler handler;
        if (z != this.q) {
            this.q = z;
            if (z || (handler = getHandler()) == null) {
                return;
            }
            handler.removeCallbacks(this.p);
        }
    }

    public final void setEndDrawable(Drawable drawable) {
        this.f10732e = drawable;
    }

    public final void setIndicatorSize(float f2) {
        this.f10734g = f2;
    }

    public final void setLineWidth(float f2) {
        this.f10736i = f2;
    }

    public final void setRingColor(int i2) {
        if (i2 != this.b) {
            this.b = i2;
            invalidate();
        }
    }

    public final void setShowCross(boolean z) {
        if (this.f10737j != z) {
            this.f10737j = z;
            invalidate();
        }
    }

    public final void setSinglePointMode(boolean z) {
        this.f10735h = z;
    }

    public final void setStartDrawable(Drawable drawable) {
        this.c = drawable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeDirectionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = -1;
        this.c = getContext().getDrawable(R.drawable.ic_shape_start);
        this.f10732e = getContext().getDrawable(R.drawable.ic_shape_end);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10734g = us.pinguo.util.g.b(context2, 48.0f);
        this.f10736i = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10738k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.b(context3, 8.0f);
        this.n = new float[]{0.0f, 0.0f};
        this.o = new Matrix();
        this.p = new Runnable() { // from class: us.pinguo.edit2020.view.x
            @Override // java.lang.Runnable
            public final void run() {
                ShapeDirectionView.g(ShapeDirectionView.this);
            }
        };
        this.q = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeDirectionView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = -1;
        this.c = getContext().getDrawable(R.drawable.ic_shape_start);
        this.f10732e = getContext().getDrawable(R.drawable.ic_shape_end);
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10734g = us.pinguo.util.g.b(context2, 48.0f);
        this.f10736i = getResources().getDimension(R.dimen.body_shape_line_width);
        this.f10738k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.b(context3, 8.0f);
        this.n = new float[]{0.0f, 0.0f};
        this.o = new Matrix();
        this.p = new Runnable() { // from class: us.pinguo.edit2020.view.x
            @Override // java.lang.Runnable
            public final void run() {
                ShapeDirectionView.g(ShapeDirectionView.this);
            }
        };
        this.q = true;
    }
}
