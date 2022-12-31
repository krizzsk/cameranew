package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import us.pinguo.common.gesture.a;
import us.pinguo.edit2020.bean.u0;
/* compiled from: FilterGestureView.kt */
/* loaded from: classes4.dex */
public final class FilterGestureView extends View implements a.InterfaceC0379a, GestureDetector.OnGestureListener {
    private kotlin.jvm.b.c<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, ? super Boolean, kotlin.u> A;
    private final float[] a;
    private final us.pinguo.common.gesture.a b;
    private final GestureDetector c;

    /* renamed from: d  reason: collision with root package name */
    private int f10663d;

    /* renamed from: e  reason: collision with root package name */
    private PointF f10664e;

    /* renamed from: f  reason: collision with root package name */
    private int f10665f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f10666g;

    /* renamed from: h  reason: collision with root package name */
    private k0 f10667h;

    /* renamed from: i  reason: collision with root package name */
    private float f10668i;

    /* renamed from: j  reason: collision with root package name */
    private float f10669j;

    /* renamed from: k  reason: collision with root package name */
    private float f10670k;

    /* renamed from: l  reason: collision with root package name */
    private float f10671l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private final Path r;
    private final Paint s;
    private long t;
    private float u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGestureView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new float[2];
        this.b = new us.pinguo.common.gesture.a(getContext(), this);
        this.c = new GestureDetector(getContext(), this);
        this.f10663d = -1;
        this.f10665f = -1;
        this.f10667h = new k0();
        this.f10668i = Float.NaN;
        this.f10669j = Float.NaN;
        this.m = 1.0f;
        this.r = new Path();
        Paint paint = new Paint(1);
        this.s = paint;
        this.t = -1L;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.u = us.pinguo.util.g.b(context2, 20.0f);
        this.v = true;
        this.w = true;
        this.y = true;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.common.widget.i.a.b(1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0297, code lost:
        if ((r4 == 0.0f) == false) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m(android.view.MotionEvent r34) {
        /*
            Method dump skipped, instructions count: 1886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.FilterGestureView.m(android.view.MotionEvent):void");
    }

    private final void r() {
        this.r.reset();
        k0 k0Var = this.f10667h;
        this.r.moveTo(k0Var.f().x, k0Var.f().y);
        this.r.lineTo(k0Var.g().x, k0Var.g().y);
        this.r.lineTo(k0Var.h().x, k0Var.h().y);
        this.r.lineTo(k0Var.i().x, k0Var.i().y);
        this.r.lineTo(k0Var.f().x, k0Var.f().y);
    }

    public final k0 a() {
        k0 k0Var = this.f10667h;
        k0 k0Var2 = new k0();
        k0Var2.s(k0Var.m());
        k0Var2.f().x = k0Var.f().x;
        k0Var2.f().y = k0Var.f().y;
        k0Var2.g().x = k0Var.g().x;
        k0Var2.g().y = k0Var.g().y;
        k0Var2.h().x = k0Var.h().x;
        k0Var2.h().y = k0Var.h().y;
        k0Var2.i().x = k0Var.i().x;
        k0Var2.i().y = k0Var.i().y;
        k0Var2.n(k0Var.a());
        k0Var2.k().set(k0Var.k());
        k0Var2.o(k0Var.b());
        k0Var2.l().set(k0Var.l());
        k0Var2.c().x = k0Var.c().x;
        k0Var2.c().y = k0Var.c().y;
        k0Var2.r(k0Var.j());
        k0Var2.q(k0Var.e());
        k0Var2.p(false);
        return k0Var2;
    }

    public final boolean b() {
        return this.x;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public void c(us.pinguo.common.gesture.a aVar) {
    }

    public final boolean d() {
        return this.z;
    }

    public final boolean e() {
        return this.v;
    }

    public final kotlin.jvm.b.c<String, Integer, Boolean, Float, Float, Float, Float, Float, Float, Boolean, Boolean, kotlin.u> f() {
        return this.A;
    }

    public final boolean g() {
        return this.w;
    }

    public final k0 h() {
        return this.f10667h;
    }

    public final float i() {
        return this.u;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean j(us.pinguo.common.gesture.a aVar) {
        return true;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean k(us.pinguo.common.gesture.a detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        k0 k0Var = this.f10667h;
        float i2 = detector.i();
        k0Var.n(k0Var.a() + i2);
        k0Var.k().setRotate(-i2, (((k0Var.f().x + k0Var.g().x) + k0Var.h().x) + k0Var.i().x) / 4.0f, (((k0Var.f().y + k0Var.g().y) + k0Var.h().y) + k0Var.i().y) / 4.0f);
        this.a[0] = k0Var.f().x;
        this.a[1] = k0Var.f().y;
        k0Var.k().mapPoints(this.a);
        k0Var.f().x = this.a[0];
        PointF f2 = k0Var.f();
        float[] fArr = this.a;
        f2.y = fArr[1];
        fArr[0] = k0Var.g().x;
        this.a[1] = k0Var.g().y;
        k0Var.k().mapPoints(this.a);
        k0Var.g().x = this.a[0];
        PointF g2 = k0Var.g();
        float[] fArr2 = this.a;
        g2.y = fArr2[1];
        fArr2[0] = k0Var.h().x;
        this.a[1] = k0Var.h().y;
        k0Var.k().mapPoints(this.a);
        k0Var.h().x = this.a[0];
        PointF h2 = k0Var.h();
        float[] fArr3 = this.a;
        h2.y = fArr3[1];
        fArr3[0] = k0Var.i().x;
        this.a[1] = k0Var.i().y;
        k0Var.k().mapPoints(this.a);
        k0Var.i().x = this.a[0];
        k0Var.i().y = this.a[1];
        this.f10667h.p(true);
        r();
        invalidate();
        return true;
    }

    public final boolean l() {
        return this.y;
    }

    public final PointF n(float f2, float f3, float f4, float f5) {
        PointF pointF = new PointF();
        float f6 = this.f10668i;
        float f7 = this.f10669j;
        pointF.x = (f4 * f6) + ((f2 - f6) * 0.5f) + this.f10670k;
        pointF.y = f3 - (((f5 * f7) + ((f3 - f7) * 0.5f)) + this.f10671l);
        return pointF;
    }

    public final PointF o(float f2, float f3, float f4, float f5) {
        PointF pointF = new PointF();
        float f6 = this.f10668i;
        float f7 = this.f10669j;
        float f8 = f4 - this.f10670k;
        float f9 = (f3 - f5) - this.f10671l;
        pointF.x = (f8 - ((f2 - f6) * 0.5f)) / f6;
        pointF.y = (f9 - ((f3 - f7) * 0.5f)) / f7;
        return pointF;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        if (this.z) {
            canvas.drawPath(this.r, this.s);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e2) {
        kotlin.jvm.internal.s.h(e2, "e");
        if (getVisibility() == 0) {
            RectF rectF = new RectF();
            this.r.computeBounds(rectF, true);
            Region region = new Region();
            region.setPath(this.r, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
            if (region.contains((int) e2.getX(), (int) e2.getY())) {
                kotlin.jvm.b.c<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, ? super Boolean, kotlin.u> cVar = this.A;
                if (cVar != null) {
                    Boolean bool = Boolean.FALSE;
                    Float valueOf = Float.valueOf(e2.getX());
                    Float valueOf2 = Float.valueOf(e2.getY());
                    Float valueOf3 = Float.valueOf(0.0f);
                    Float valueOf4 = Float.valueOf(0.0f);
                    Float valueOf5 = Float.valueOf(1.0f);
                    Float valueOf6 = Float.valueOf(0.0f);
                    Boolean bool2 = Boolean.TRUE;
                    cVar.invoke("", 1, bool, valueOf, valueOf2, valueOf3, valueOf4, valueOf5, valueOf6, bool2, bool2);
                }
            } else {
                kotlin.jvm.b.c<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, ? super Boolean, kotlin.u> cVar2 = this.A;
                if (cVar2 != null) {
                    Boolean bool3 = Boolean.FALSE;
                    cVar2.invoke("", 1, bool3, Float.valueOf(e2.getX()), Float.valueOf(e2.getY()), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.TRUE, bool3);
                }
            }
            return true;
        }
        return false;
    }

    public final boolean p(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (getVisibility() == 0) {
            this.b.c(event);
            m(event);
            this.c.onTouchEvent(event);
            return true;
        }
        return false;
    }

    public final void q(float f2, float f3) {
        k0 k0Var = this.f10667h;
        Matrix matrix = new Matrix();
        matrix.postTranslate(f2 - ((((k0Var.f().x + k0Var.g().x) + k0Var.h().x) + k0Var.i().x) * 0.25f), f3 - ((((k0Var.f().y + k0Var.g().y) + k0Var.h().y) + k0Var.i().y) * 0.25f));
        float[] fArr = {k0Var.f().x, k0Var.f().y};
        matrix.mapPoints(fArr);
        k0Var.f().x = fArr[0];
        k0Var.f().y = fArr[1];
        fArr[0] = k0Var.g().x;
        fArr[1] = k0Var.g().y;
        matrix.mapPoints(fArr);
        k0Var.g().x = fArr[0];
        k0Var.g().y = fArr[1];
        fArr[0] = k0Var.h().x;
        fArr[1] = k0Var.h().y;
        matrix.mapPoints(fArr);
        k0Var.h().x = fArr[0];
        k0Var.h().y = fArr[1];
        fArr[0] = k0Var.i().x;
        fArr[1] = k0Var.i().y;
        matrix.mapPoints(fArr);
        k0Var.i().x = fArr[0];
        k0Var.i().y = fArr[1];
        r();
        invalidate();
    }

    public final void s(Float f2) {
        k0 k0Var = this.f10667h;
        float f3 = (k0Var.f().x + k0Var.g().x + k0Var.h().x + k0Var.i().x) * 0.25f;
        float f4 = (k0Var.f().y + k0Var.g().y + k0Var.h().y + k0Var.i().y) * 0.25f;
        if (f2 == null) {
            k0Var.k().setRotate(k0Var.a(), f3, f4);
        } else {
            k0Var.k().setRotate(-f2.floatValue(), f3, f4);
        }
        this.a[0] = k0Var.f().x;
        this.a[1] = k0Var.f().y;
        k0Var.k().mapPoints(this.a);
        k0Var.f().x = this.a[0];
        PointF f5 = k0Var.f();
        float[] fArr = this.a;
        f5.y = fArr[1];
        fArr[0] = k0Var.g().x;
        this.a[1] = k0Var.g().y;
        k0Var.k().mapPoints(this.a);
        k0Var.g().x = this.a[0];
        PointF g2 = k0Var.g();
        float[] fArr2 = this.a;
        g2.y = fArr2[1];
        fArr2[0] = k0Var.h().x;
        this.a[1] = k0Var.h().y;
        k0Var.k().mapPoints(this.a);
        k0Var.h().x = this.a[0];
        PointF h2 = k0Var.h();
        float[] fArr3 = this.a;
        h2.y = fArr3[1];
        fArr3[0] = k0Var.i().x;
        this.a[1] = k0Var.i().y;
        k0Var.k().mapPoints(this.a);
        k0Var.i().x = this.a[0];
        k0Var.i().y = this.a[1];
        k0Var.n(f2 == null ? 0.0f : f2.floatValue());
        k0Var.k().reset();
        r();
        invalidate();
    }

    public final void setCanvasInfo(u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        k0 k0Var = this.f10667h;
        float h2 = (unityCanvasStatus.h() - this.f10668i) * 0.5f;
        float g2 = (unityCanvasStatus.g() - this.f10669j) * 0.5f;
        float f2 = ((k0Var.f().x - this.f10670k) - h2) / this.f10668i;
        float g3 = (((unityCanvasStatus.g() - k0Var.f().y) - this.f10671l) - g2) / this.f10669j;
        float f3 = ((k0Var.g().x - this.f10670k) - h2) / this.f10668i;
        float g4 = (((unityCanvasStatus.g() - k0Var.g().y) - this.f10671l) - g2) / this.f10669j;
        float f4 = ((k0Var.h().x - this.f10670k) - h2) / this.f10668i;
        float g5 = (((unityCanvasStatus.g() - k0Var.h().y) - this.f10671l) - g2) / this.f10669j;
        float f5 = ((k0Var.i().x - this.f10670k) - h2) / this.f10668i;
        float g6 = (((unityCanvasStatus.g() - k0Var.i().y) - this.f10671l) - g2) / this.f10669j;
        float f6 = ((k0Var.c().x - this.f10670k) - h2) / this.f10668i;
        float g7 = (((unityCanvasStatus.g() - k0Var.c().y) - this.f10671l) - g2) / this.f10669j;
        float h3 = (unityCanvasStatus.h() - unityCanvasStatus.e()) * 0.5f;
        float g8 = (unityCanvasStatus.g() - unityCanvasStatus.d()) * 0.5f;
        k0Var.f().x = (f2 * unityCanvasStatus.e()) + h3 + unityCanvasStatus.a();
        k0Var.f().y = unityCanvasStatus.g() - (((g3 * unityCanvasStatus.d()) + g8) + unityCanvasStatus.b());
        k0Var.g().x = (f3 * unityCanvasStatus.e()) + h3 + unityCanvasStatus.a();
        k0Var.g().y = unityCanvasStatus.g() - (((g4 * unityCanvasStatus.d()) + g8) + unityCanvasStatus.b());
        k0Var.h().x = (f4 * unityCanvasStatus.e()) + h3 + unityCanvasStatus.a();
        k0Var.h().y = unityCanvasStatus.g() - (((g5 * unityCanvasStatus.d()) + g8) + unityCanvasStatus.b());
        k0Var.i().x = (f5 * unityCanvasStatus.e()) + h3 + unityCanvasStatus.a();
        k0Var.i().y = unityCanvasStatus.g() - (((g6 * unityCanvasStatus.d()) + g8) + unityCanvasStatus.b());
        k0Var.c().x = (f6 * unityCanvasStatus.e()) + h3 + unityCanvasStatus.a();
        k0Var.c().y = unityCanvasStatus.g() - (((g7 * unityCanvasStatus.d()) + g8) + unityCanvasStatus.b());
        k0Var.r(k0Var.j() * (unityCanvasStatus.c() / this.m));
        k0Var.q(k0Var.e() * (unityCanvasStatus.c() / this.m));
        this.f10668i = unityCanvasStatus.e();
        this.f10669j = unityCanvasStatus.d();
        this.f10670k = unityCanvasStatus.a();
        this.f10671l = unityCanvasStatus.b();
        this.m = unityCanvasStatus.c();
        float width = ((getWidth() - this.f10668i) * 0.5f) + this.f10670k;
        this.n = width;
        if (width < 0.0f) {
            this.n = 0.0f;
        }
        float height = ((getHeight() - this.f10669j) * 0.5f) + this.f10671l;
        this.o = height;
        if (height < 0.0f) {
            this.o = 0.0f;
        }
        float width2 = ((getWidth() + this.f10668i) * 0.5f) + this.f10670k;
        this.p = width2;
        if (width2 > getWidth()) {
            this.p = getWidth();
        }
        float height2 = ((getHeight() + this.f10669j) * 0.5f) + this.f10671l;
        this.q = height2;
        if (height2 > getHeight()) {
            this.q = getHeight();
        }
        r();
    }

    public final void setDeltaPosition(boolean z) {
        this.x = z;
    }

    public final void setDrawRect(boolean z) {
        if (this.z != z) {
            this.z = z;
            invalidate();
        }
    }

    public final void setMultiFingerMove(boolean z) {
        this.v = z;
    }

    public final void setOnGesture(kotlin.jvm.b.c<? super String, ? super Integer, ? super Boolean, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Boolean, ? super Boolean, kotlin.u> cVar) {
        this.A = cVar;
    }

    public final void setRectActive(boolean z) {
        this.w = z;
    }

    public final void setRectInfo(k0 info, boolean z) {
        kotlin.jvm.internal.s.h(info, "info");
        if (z) {
            k0 k0Var = this.f10667h;
            k0Var.s(info.m());
            k0Var.f().x = info.f().x;
            k0Var.f().y = info.f().y;
            k0Var.g().x = info.g().x;
            k0Var.g().y = info.g().y;
            k0Var.h().x = info.h().x;
            k0Var.h().y = info.h().y;
            k0Var.i().x = info.i().x;
            k0Var.i().y = info.i().y;
            k0Var.n(info.a());
            k0Var.k().set(info.k());
            k0Var.o(info.b());
            k0Var.l().set(info.l());
            k0Var.c().x = info.c().x;
            k0Var.c().y = info.c().y;
            k0Var.r(info.j());
            k0Var.q(info.e());
            k0Var.p(info.d());
        } else {
            this.f10667h = info;
        }
        r();
        invalidate();
    }

    public final void setRectMinSize(float f2) {
        this.u = f2;
    }

    public final void setRestrictedInScreen(boolean z) {
        this.y = z;
    }

    public final void setVertices(PointF v1, PointF v2, PointF v3, PointF v4) {
        kotlin.jvm.internal.s.h(v1, "v1");
        kotlin.jvm.internal.s.h(v2, "v2");
        kotlin.jvm.internal.s.h(v3, "v3");
        kotlin.jvm.internal.s.h(v4, "v4");
        k0 k0Var = new k0();
        this.f10667h = k0Var;
        k0Var.f().x = v1.x;
        k0Var.f().y = v1.y;
        k0Var.g().x = v2.x;
        k0Var.g().y = v2.y;
        k0Var.h().x = v3.x;
        k0Var.h().y = v3.y;
        k0Var.i().x = v4.x;
        k0Var.i().y = v4.y;
        k0Var.c().x = (k0Var.f().x + k0Var.g().x + k0Var.h().x + k0Var.i().x) * 0.25f;
        k0Var.c().y = (k0Var.f().y + k0Var.g().y + k0Var.h().y + k0Var.i().y) * 0.25f;
        k0Var.r(Math.abs(k0Var.f().x - k0Var.g().x));
        k0Var.q(Math.abs(k0Var.f().y - k0Var.h().y));
        r();
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGestureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new float[2];
        this.b = new us.pinguo.common.gesture.a(getContext(), this);
        this.c = new GestureDetector(getContext(), this);
        this.f10663d = -1;
        this.f10665f = -1;
        this.f10667h = new k0();
        this.f10668i = Float.NaN;
        this.f10669j = Float.NaN;
        this.m = 1.0f;
        this.r = new Path();
        Paint paint = new Paint(1);
        this.s = paint;
        this.t = -1L;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.u = us.pinguo.util.g.b(context2, 20.0f);
        this.v = true;
        this.w = true;
        this.y = true;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.common.widget.i.a.b(1));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterGestureView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new float[2];
        this.b = new us.pinguo.common.gesture.a(getContext(), this);
        this.c = new GestureDetector(getContext(), this);
        this.f10663d = -1;
        this.f10665f = -1;
        this.f10667h = new k0();
        this.f10668i = Float.NaN;
        this.f10669j = Float.NaN;
        this.m = 1.0f;
        this.r = new Path();
        Paint paint = new Paint(1);
        this.s = paint;
        this.t = -1L;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.u = us.pinguo.util.g.b(context2, 20.0f);
        this.v = true;
        this.w = true;
        this.y = true;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(us.pinguo.common.widget.i.a.b(1));
    }
}
