package us.pinguo.edit2020.view;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.gesture.Vector;
import us.pinguo.edit2020.R;
/* compiled from: AIEditCanvasView.kt */
/* loaded from: classes4.dex */
public final class AIEditCanvasView extends SurfaceView implements SurfaceHolder.Callback, d0 {
    private long A;
    private ValueAnimator B;
    private final Paint a;
    private Bitmap b;
    private Bitmap c;

    /* renamed from: d  reason: collision with root package name */
    private float f10592d;

    /* renamed from: e  reason: collision with root package name */
    private float f10593e;

    /* renamed from: f  reason: collision with root package name */
    private float f10594f;

    /* renamed from: g  reason: collision with root package name */
    private float f10595g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f10596h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f10597i;

    /* renamed from: j  reason: collision with root package name */
    private float f10598j;

    /* renamed from: k  reason: collision with root package name */
    private float f10599k;

    /* renamed from: l  reason: collision with root package name */
    private float f10600l;
    private float m;
    private final Rect n;
    private final Rect o;
    private final Rect p;
    private final Rect q;
    private float r;
    private ArrayList<Rect> s;
    private List<Rect> t;
    private float u;
    private boolean v;
    private final PointF w;
    private final PointF x;
    private final PointF y;
    private final PointF z;

    /* compiled from: AIEditCanvasView.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AIEditCanvasView.this.f10597i.set(AIEditCanvasView.this.f10596h.x, AIEditCanvasView.this.f10596h.y);
            AIEditCanvasView.this.v = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: AIEditCanvasView.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AIEditCanvasView.this.f10597i.set(AIEditCanvasView.this.f10596h.x, AIEditCanvasView.this.f10596h.y);
            AIEditCanvasView aIEditCanvasView = AIEditCanvasView.this;
            aIEditCanvasView.f10594f = aIEditCanvasView.f10592d;
            AIEditCanvasView aIEditCanvasView2 = AIEditCanvasView.this;
            aIEditCanvasView2.f10595g = aIEditCanvasView2.f10593e;
            AIEditCanvasView.this.v = false;
            AIEditCanvasView.this.o();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIEditCanvasView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIEditCanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEditCanvasView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        Paint paint = new Paint(1);
        this.a = paint;
        this.f10596h = new PointF();
        this.f10597i = new PointF();
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = 1.0f;
        this.s = new ArrayList<>();
        this.w = new PointF();
        this.x = new PointF();
        this.y = new PointF();
        this.z = new PointF();
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getContext().getResources().getColor(R.color.color_eeeeee));
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        paint.setStrokeWidth(us.pinguo.util.g.b(context2, 1.0f));
        getHolder().addCallback(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void l() {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.AIEditCanvasView.l():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AIEditCanvasView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue("x");
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Object animatedValue2 = valueAnimator.getAnimatedValue("y");
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = ((Float) animatedValue2).floatValue();
        PointF pointF = this$0.f10596h;
        PointF pointF2 = this$0.f10597i;
        pointF.set(pointF2.x - floatValue, pointF2.y - floatValue2);
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AIEditCanvasView this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue("x");
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        Object animatedValue2 = valueAnimator.getAnimatedValue("y");
        Objects.requireNonNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        float floatValue2 = ((Float) animatedValue2).floatValue();
        Object animatedValue3 = valueAnimator.getAnimatedValue("width");
        Objects.requireNonNull(animatedValue3, "null cannot be cast to non-null type kotlin.Float");
        float floatValue3 = ((Float) animatedValue3).floatValue();
        Object animatedValue4 = valueAnimator.getAnimatedValue("height");
        Objects.requireNonNull(animatedValue4, "null cannot be cast to non-null type kotlin.Float");
        float floatValue4 = ((Float) animatedValue4).floatValue();
        us.pinguo.common.log.a.c("middlePoint->" + (this$0.f10597i.x + floatValue) + ',' + (this$0.f10597i.y + floatValue2), new Object[0]);
        PointF pointF = this$0.f10596h;
        PointF pointF2 = this$0.f10597i;
        pointF.set(pointF2.x + floatValue, pointF2.y + floatValue2);
        this$0.f10592d = floatValue3;
        this$0.f10593e = floatValue4;
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.A < 16.67d) {
            return;
        }
        this.A = currentTimeMillis;
        Canvas canvas = null;
        try {
            try {
                canvas = getHolder().lockCanvas();
                t(canvas);
                if (canvas == null) {
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (canvas == null) {
                    return;
                }
            }
            getHolder().unlockCanvasAndPost(canvas);
        } catch (Throwable th) {
            if (canvas != null) {
                getHolder().unlockCanvasAndPost(canvas);
            }
            throw th;
        }
    }

    private final void t(Canvas canvas) {
        int b2;
        int b3;
        int b4;
        int b5;
        int b6;
        int b7;
        int b8;
        int b9;
        int b10;
        int b11;
        int b12;
        int b13;
        int b14;
        int b15;
        int b16;
        int b17;
        int b18;
        int b19;
        int b20;
        int b21;
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, this.f10598j, this.f10599k, this.a);
        }
        Bitmap b22 = b();
        if (b22 == null) {
            return;
        }
        Bitmap c = c();
        if (c == null) {
            c = b22;
        }
        this.f10600l = this.f10592d / b22.getWidth();
        this.m = this.f10592d / c.getWidth();
        PointF pointF = this.f10596h;
        float f2 = 2;
        float f3 = pointF.x - (this.f10592d / f2);
        float f4 = pointF.y - (this.f10593e / f2);
        float max = Math.max(0.0f, -f3);
        float f5 = -f4;
        float max2 = Math.max(0.0f, f5);
        float min = Math.min(this.f10592d, Math.max(0.0f, this.u - f3));
        float min2 = Math.min(this.f10599k - f4, (this.f10596h.y - f4) + (this.f10593e / f2));
        float min3 = Math.min(this.f10592d, Math.max(0.0f, this.u - f3));
        float max3 = Math.max(0.0f, f5);
        float min4 = Math.min(this.f10598j - f3, (this.f10596h.x - f3) + (this.f10592d / f2));
        Bitmap bitmap = c;
        float min5 = Math.min(this.f10599k - f4, (this.f10596h.y - f4) + (this.f10593e / f2));
        float f6 = this.f10600l;
        float f7 = this.m;
        Rect rect = this.n;
        b2 = kotlin.y.c.b(max / f6);
        b3 = kotlin.y.c.b(max2 / f6);
        b4 = kotlin.y.c.b(min / f6);
        b5 = kotlin.y.c.b(min2 / f6);
        rect.set(b2, b3, b4, b5);
        Rect rect2 = this.o;
        b6 = kotlin.y.c.b(min3 / f7);
        b7 = kotlin.y.c.b(max3 / f7);
        b8 = kotlin.y.c.b(min4 / f7);
        b9 = kotlin.y.c.b(min5 / f7);
        rect2.set(b6, b7, b8, b9);
        b10 = kotlin.y.c.b(f3);
        int max4 = Math.max(0, b10);
        b11 = kotlin.y.c.b(f4);
        int max5 = Math.max(0, b11);
        float f8 = min + f3;
        b12 = kotlin.y.c.b(f8);
        b13 = kotlin.y.c.b(min2 + f4);
        b14 = kotlin.y.c.b(f8);
        b15 = kotlin.y.c.b(f4);
        int max6 = Math.max(0, b15);
        b16 = kotlin.y.c.b(min4 + f3);
        b17 = kotlin.y.c.b(min5 + f4);
        this.p.set(max4, max5, b12, b13);
        this.q.set(b14, max6, b16, b17);
        us.pinguo.common.log.a.c("canvasRect->" + this.p.left + ',' + this.p.top + '-' + this.q.right + ',' + this.q.bottom, new Object[0]);
        us.pinguo.common.log.a.c("", new Object[0]);
        if (canvas != null) {
            canvas.drawBitmap(b22, this.n, this.p, this.a);
        }
        if (canvas != null) {
            canvas.drawBitmap(bitmap, this.o, this.q, this.a);
        }
        List<Rect> p = p();
        if (p == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : p) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                Rect rect3 = (Rect) obj;
                b18 = kotlin.y.c.b((rect3.left * this.f10600l) + f3);
                b19 = kotlin.y.c.b((rect3.top * this.f10600l) + f4);
                b20 = kotlin.y.c.b((rect3.right * this.f10600l) + f3);
                b21 = kotlin.y.c.b((rect3.bottom * this.f10600l) + f4);
                this.s.get(i2).set(b18, b19, b20, b21);
                us.pinguo.common.log.a.c("Face" + i2 + ':' + this.s.get(i2), new Object[0]);
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    @Override // us.pinguo.edit2020.view.d0
    public void a(int i2, float f2) {
        if (i2 >= this.s.size()) {
            return;
        }
        Rect rect = this.s.get(i2);
        kotlin.jvm.internal.s.g(rect, "scaledFaceRectList[faceIndex]");
        Rect rect2 = rect;
        Rect rect3 = this.s.get(0);
        kotlin.jvm.internal.s.g(rect3, "scaledFaceRectList[0]");
        Rect rect4 = rect3;
        float width = (this.f10598j * (i2 == 0 ? 1.0f : 0.8f)) / rect2.width();
        ValueAnimator valueAnimator = this.B;
        if (valueAnimator == null) {
            this.B = new ValueAnimator();
        } else if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int centerX = rect4.centerX() - rect2.centerX();
        int centerY = rect4.centerY() - rect2.centerY();
        float f3 = width - 1;
        float f4 = centerX;
        float centerX2 = rect2.centerX() - (f3 * f4);
        float f5 = centerY;
        float centerY2 = rect2.centerY() - (f3 * f5);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("x", 0.0f, (this.f10598j / 2.0f) - centerX2);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("y", 0.0f, (this.f10599k / 2.0f) - centerY2);
        float f6 = this.f10594f;
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("width", f6, f6 * width * f2);
        float f7 = this.f10595g;
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("height", f7, f7 * width * f2);
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("rate->", Float.valueOf(width)), new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("startPoint->");
        sb.append(this.f10596h.x);
        sb.append(',');
        sb.append(this.f10596h.y);
        sb.append(" movePoint->");
        sb.append(centerX);
        sb.append(',');
        sb.append(centerY);
        sb.append(" rateMovePoint->");
        float f8 = f4 * width;
        sb.append(f8);
        sb.append(',');
        float f9 = f5 * width;
        sb.append(f9);
        sb.append(" endPoint->");
        sb.append(this.f10597i.x + f8);
        sb.append(',');
        sb.append(this.f10597i.y + f9);
        us.pinguo.common.log.a.c(sb.toString(), new Object[0]);
        ValueAnimator valueAnimator2 = this.B;
        if (valueAnimator2 != null) {
            valueAnimator2.setValues(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        }
        ValueAnimator valueAnimator3 = this.B;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.view.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    AIEditCanvasView.n(AIEditCanvasView.this, valueAnimator4);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.B;
        if (valueAnimator4 != null) {
            valueAnimator4.addListener(new b());
        }
        ValueAnimator valueAnimator5 = this.B;
        if (valueAnimator5 != null) {
            valueAnimator5.setDuration(200L);
        }
        this.v = true;
        ValueAnimator valueAnimator6 = this.B;
        if (valueAnimator6 == null) {
            return;
        }
        valueAnimator6.start();
    }

    @Override // us.pinguo.edit2020.view.d0
    public Bitmap b() {
        return this.b;
    }

    @Override // us.pinguo.edit2020.view.d0
    public Bitmap c() {
        return this.c;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Bitmap b2;
        Bitmap b3 = b();
        if (b3 == null) {
            return;
        }
        Bitmap c = c();
        if (c == null) {
            c = b3;
        }
        this.f10598j = getWidth();
        this.f10599k = getHeight();
        Bitmap b4 = b();
        if ((b4 == null ? 0 : b4.getWidth()) / (b() == null ? 1.0f : b2.getHeight()) > getWidth() / getHeight()) {
            this.f10592d = getWidth();
            this.f10593e = (b3.getHeight() * this.f10592d) / b3.getWidth();
        } else {
            this.f10593e = getHeight();
            this.f10592d = (b3.getWidth() * this.f10593e) / b3.getHeight();
        }
        this.f10594f = this.f10592d;
        this.f10595g = this.f10593e;
        this.f10596h.set(this.f10598j / 2.0f, this.f10599k / 2.0f);
        this.f10597i.set(this.f10598j / 2.0f, this.f10599k / 2.0f);
        this.u = this.f10598j * q();
        this.f10600l = this.f10592d / b3.getWidth();
        this.m = this.f10592d / c.getWidth();
        super.onLayout(z, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Bitmap b2;
        kotlin.jvm.internal.s.h(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.w.set(event.getX(), event.getY());
        } else if (actionMasked == 1) {
            this.v = false;
            PointF pointF = this.f10597i;
            PointF pointF2 = this.f10596h;
            pointF.set(pointF2.x, pointF2.y);
            this.w.set(0.0f, 0.0f);
            this.y.set(0.0f, 0.0f);
            this.x.set(0.0f, 0.0f);
            this.z.set(0.0f, 0.0f);
            if (this.f10592d < this.f10598j * 0.8d && this.f10593e < this.f10599k * 0.8d) {
                a(0, 0.8f);
            } else {
                l();
            }
        } else if (actionMasked != 2) {
            if (actionMasked != 5) {
                if (actionMasked == 6) {
                    this.v = true;
                    this.f10594f = this.f10592d;
                    this.f10595g = this.f10593e;
                    this.w.set(0.0f, 0.0f);
                    this.y.set(0.0f, 0.0f);
                    this.x.set(0.0f, 0.0f);
                    this.z.set(0.0f, 0.0f);
                }
            } else if (event.getPointerCount() == 2) {
                this.x.set(event.getX(1), event.getY(1));
            }
        } else if (this.v) {
            return true;
        } else {
            int pointerCount = event.getPointerCount();
            if (pointerCount == 1) {
                this.y.set(event.getX(), event.getY());
                PointF pointF3 = this.y;
                float f2 = pointF3.x;
                PointF pointF4 = this.w;
                this.f10596h = us.pinguo.common.gesture.b.b(this.f10597i, new Vector(f2 - pointF4.x, pointF3.y - pointF4.y));
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " down0Point->" + this.w, new Object[0]);
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " move0Point->" + this.y, new Object[0]);
                o();
            } else if (pointerCount != 2 || (b2 = b()) == null) {
                return true;
            } else {
                this.y.set(event.getX(0), event.getY(0));
                this.z.set(event.getX(1), event.getY(1));
                us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
                float c = aVar.c(this.y, this.z) / aVar.c(this.w, this.x);
                if (((int) ((this.f10594f * c) / b2.getWidth())) >= 20 && c > 1.0f) {
                    c = (b2.getWidth() * 20) / this.f10594f;
                }
                us.pinguo.common.log.a.c("scaledBitmapWidth->" + this.f10592d + " lastScaledBitmapWidth->" + this.f10594f, new Object[0]);
                this.f10592d = this.f10594f * c;
                this.f10593e = this.f10595g * c;
                PointF b3 = aVar.b(this.w, this.x);
                PointF b4 = aVar.b(this.y, this.z);
                this.f10596h = us.pinguo.common.gesture.b.b(this.f10597i, new Vector(b4.x - b3.x, b4.y - b3.y));
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " down0Point->" + this.w, new Object[0]);
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " move0Point->" + this.y, new Object[0]);
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " down1Point->" + this.x, new Object[0]);
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " move1Point->" + this.z, new Object[0]);
                us.pinguo.common.log.a.c("pointerCount->" + event.getPointerCount() + " scale->" + c + '\n', new Object[0]);
                o();
            }
        }
        return true;
    }

    public List<Rect> p() {
        return this.t;
    }

    public float q() {
        return this.r;
    }

    @Override // us.pinguo.edit2020.view.d0
    public void setFaceRectList(List<Rect> list) {
        if (kotlin.jvm.internal.s.c(list, this.t)) {
            return;
        }
        this.t = list;
        this.s.clear();
        List<Rect> list2 = this.t;
        if (list2 == null) {
            return;
        }
        for (Rect rect : list2) {
            this.s.add(new Rect());
        }
    }

    @Override // us.pinguo.edit2020.view.d0
    public void setImageRestorationBitmap(Bitmap bitmap) {
        if (!kotlin.jvm.internal.s.c(bitmap, this.c)) {
            this.c = bitmap;
        }
        o();
    }

    @Override // us.pinguo.edit2020.view.d0
    public void setRate(float f2) {
        if (f2 == this.r) {
            return;
        }
        this.r = f2;
        this.u = getWidth() * q();
        o();
    }

    @Override // us.pinguo.edit2020.view.d0
    public void setSrcBitmap(Bitmap bitmap) {
        if (kotlin.jvm.internal.s.c(bitmap, this.b)) {
            return;
        }
        this.b = bitmap;
        o();
    }

    public final void setValueAnimator(ValueAnimator valueAnimator) {
        this.B = valueAnimator;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i2, int i3, int i4) {
        kotlin.jvm.internal.s.h(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        o();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
    }

    public /* synthetic */ AIEditCanvasView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
