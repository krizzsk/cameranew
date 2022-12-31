package us.pinguo.edit2020.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.common.gesture.Vector;
import us.pinguo.edit2020.R;
/* compiled from: StovepipeAreaSelectorView.kt */
/* loaded from: classes4.dex */
public final class StovepipeAreaSelectorView extends View {
    private final PointF A;
    private final PointF B;
    private final PointF C;
    private final PointF D;
    private final PointF E;
    private final PointF F;
    private final PointF G;
    private final PointF H;
    private final PointF I;
    private final PointF J;
    private int K;
    private int L;
    private PointF M;
    private PointF N;
    private PointF O;
    private boolean P;
    private a a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f10936d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10937e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10938f;

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap f10939g;

    /* renamed from: h  reason: collision with root package name */
    private final Bitmap f10940h;

    /* renamed from: i  reason: collision with root package name */
    private final Bitmap f10941i;

    /* renamed from: j  reason: collision with root package name */
    private final Bitmap f10942j;

    /* renamed from: k  reason: collision with root package name */
    private final Bitmap f10943k;

    /* renamed from: l  reason: collision with root package name */
    private float f10944l;
    private float m;
    private final Paint n;
    private final Paint o;
    private final Paint p;
    private final Paint q;
    private final PointF r;
    private final PointF s;
    private final PointF t;
    private final PointF u;
    private final PointF v;
    private final PointF w;
    private final PointF x;
    private final PointF y;
    private final PointF z;

    /* compiled from: StovepipeAreaSelectorView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(float f2, float f3, float f4, float f5, float f6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StovepipeAreaSelectorView(Context context) {
        this(context, null, 0, 0, 14, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StovepipeAreaSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StovepipeAreaSelectorView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StovepipeAreaSelectorView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        s.h(context, "context");
        new LinkedHashMap();
        this.f10937e = us.pinguo.common.widget.i.a.a(28);
        this.f10939g = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_arrow_left);
        this.f10940h = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_arrow_up);
        this.f10941i = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_arrow_right);
        this.f10942j = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_arrow_down);
        this.f10943k = BitmapFactory.decodeResource(context.getResources(), R.drawable.edit_icon_xuanzhuan);
        this.m = 1.0f;
        Paint paint = new Paint();
        this.n = paint;
        Paint paint2 = new Paint();
        this.o = paint2;
        this.p = new Paint();
        Paint paint3 = new Paint();
        this.q = paint3;
        this.r = new PointF();
        this.s = new PointF();
        this.t = new PointF();
        this.u = new PointF();
        this.v = new PointF();
        this.w = new PointF();
        this.x = new PointF();
        PointF pointF = new PointF();
        this.y = pointF;
        this.z = new PointF();
        this.A = new PointF();
        this.B = new PointF();
        this.C = new PointF();
        this.D = new PointF();
        this.E = new PointF();
        this.F = new PointF();
        this.G = new PointF();
        PointF pointF2 = new PointF();
        this.H = pointF2;
        this.I = new PointF();
        this.J = new PointF();
        this.M = pointF;
        this.N = pointF2;
        this.O = new PointF();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(us.pinguo.common.widget.i.a.b(1));
        paint2.setColor(-1);
        paint.setStrokeWidth(us.pinguo.common.widget.i.a.b(1));
        paint.setAntiAlias(true);
        paint3.setColor(Color.parseColor("#50ff0000"));
    }

    private final void A(PointF pointF, PointF pointF2, PointF pointF3) {
        pointF.x = pointF2.x + pointF3.x;
        pointF.y = pointF2.y + pointF3.y;
    }

    private final void B() {
        int i2 = 0;
        PointF[] pointFArr = {this.y, this.x, this.z, this.w};
        PointF[] pointFArr2 = {this.H, this.G, this.I, this.F};
        int i3 = 0;
        while (i2 < 4) {
            PointF pointF = pointFArr[i2];
            int i4 = i3 + 1;
            if (p(pointF)) {
                this.M = pointF;
                this.N = pointFArr2[i3];
                return;
            }
            i2++;
            i3 = i4;
        }
    }

    private final void a(float f2, float f3) {
        z(this.s, this.B, f2, f3);
        z(this.t, this.C, f2, f3);
        z(this.u, this.D, f2, f3);
        z(this.v, this.E, f2, f3);
        z(this.w, this.F, f2, f3);
        z(this.x, this.G, f2, f3);
        z(this.y, this.H, f2, f3);
        z(this.z, this.I, f2, f3);
        z(this.M, this.N, f2, f3);
    }

    private final boolean b(PointF pointF, PointF pointF2, Vector vector) {
        float c = us.pinguo.common.helper.a.a.c(new PointF(pointF.x + ((PointF) vector).x, pointF.y + ((PointF) vector).y), new PointF(pointF2.x - ((PointF) vector).x, pointF2.y - ((PointF) vector).y));
        Vector vector2 = new Vector(pointF.x - pointF2.x, pointF.y - pointF2.y);
        return (!us.pinguo.common.helper.d.a.a(vector2, vector) || vector2.b() - (vector.b() * ((float) 2)) >= this.c) && c > this.c && c < this.f10936d;
    }

    private final boolean c(float f2) {
        us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
        return Math.max(aVar.c(this.B, this.D), aVar.c(this.C, this.E)) * f2 >= this.f10936d;
    }

    private final boolean d(float f2) {
        us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
        return Math.min(aVar.c(this.B, this.D), aVar.c(this.C, this.E)) * f2 <= this.c;
    }

    private final void e(Canvas canvas, Bitmap bitmap, PointF pointF, float f2) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix.postRotate((float) Math.toDegrees(f2), width / 2.0f, height / 2.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(createBitmap, pointF.x - (createBitmap.getWidth() / 2), pointF.y - (createBitmap.getHeight() / 2), this.p);
    }

    private final void f(Canvas canvas) {
        float a2 = us.pinguo.common.helper.a.a.a(this.s, this.u);
        Bitmap arrowLeftBitmap = this.f10939g;
        s.g(arrowLeftBitmap, "arrowLeftBitmap");
        e(canvas, arrowLeftBitmap, this.s, a2);
        Bitmap arrowTopBitmap = this.f10940h;
        s.g(arrowTopBitmap, "arrowTopBitmap");
        e(canvas, arrowTopBitmap, this.t, a2);
        Bitmap arrowRightBitmap = this.f10941i;
        s.g(arrowRightBitmap, "arrowRightBitmap");
        e(canvas, arrowRightBitmap, this.u, a2);
        Bitmap arrowBottomBitmap = this.f10942j;
        s.g(arrowBottomBitmap, "arrowBottomBitmap");
        e(canvas, arrowBottomBitmap, this.v, a2);
        B();
        Bitmap rotateBitmap = this.f10943k;
        s.g(rotateBitmap, "rotateBitmap");
        e(canvas, rotateBitmap, this.M, a2);
    }

    private final void g(Canvas canvas, PointF pointF, PointF pointF2) {
        this.n.setShader(new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, new int[]{Color.parseColor("#19ffffff"), Color.parseColor("#ffffff"), Color.parseColor("#19ffffff")}, (float[]) null, Shader.TileMode.CLAMP));
        if (canvas == null) {
            return;
        }
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, this.n);
    }

    private final void h(Canvas canvas) {
        g(canvas, this.w, this.z);
        g(canvas, this.x, this.y);
        if (canvas == null) {
            return;
        }
        PointF pointF = this.t;
        float f2 = pointF.x;
        float f3 = pointF.y;
        PointF pointF2 = this.v;
        canvas.drawLine(f2, f3, pointF2.x, pointF2.y, this.o);
    }

    private final void i(Canvas canvas) {
        Path path = new Path();
        PointF pointF = this.w;
        path.moveTo(pointF.x, pointF.y);
        PointF pointF2 = this.x;
        path.lineTo(pointF2.x, pointF2.y);
        PointF pointF3 = this.y;
        path.lineTo(pointF3.x, pointF3.y);
        PointF pointF4 = this.z;
        path.lineTo(pointF4.x, pointF4.y);
        PointF pointF5 = this.w;
        path.moveTo(pointF5.x, pointF5.y);
        if (canvas == null) {
            return;
        }
        canvas.drawPath(path, this.q);
    }

    private final float j() {
        return us.pinguo.common.helper.a.a.c(this.C, this.E);
    }

    private final float k() {
        return us.pinguo.common.helper.a.a.c(this.B, this.D);
    }

    private final Vector l(PointF pointF, PointF pointF2, PointF pointF3) {
        Vector vector = new Vector(pointF3.x - pointF2.x, pointF3.y - pointF2.y);
        Vector vector2 = new Vector(pointF2.x - pointF.x, pointF2.y - pointF.y);
        float f2 = ((PointF) vector).x;
        float f3 = ((PointF) vector2).x;
        float f4 = ((PointF) vector).y;
        float f5 = ((PointF) vector2).y;
        float f6 = ((f2 * f3) + (f4 * f5)) / ((f3 * f3) + (f5 * f5));
        return new Vector(((PointF) vector2).x * f6, f6 * ((PointF) vector2).y);
    }

    private final void m() {
        this.K = getWidth();
        int height = getHeight();
        this.L = height;
        int i2 = this.K;
        float f2 = i2 / 3.0f;
        this.b = f2;
        this.c = i2 / 10.0f;
        this.f10936d = i2 - this.f10937e;
        this.f10944l = 0.0f;
        this.m = 1.0f;
        PointF pointF = this.r;
        float f3 = i2 / 2.0f;
        pointF.x = f3;
        float f4 = height / 2.0f;
        pointF.y = f4;
        float f5 = f2 / 2.0f;
        float f6 = f2 / 2.0f;
        PointF pointF2 = this.s;
        pointF2.x = f3 - f5;
        pointF2.y = f4;
        PointF pointF3 = this.t;
        pointF3.x = pointF.x;
        pointF3.y = pointF.y - f6;
        PointF pointF4 = this.u;
        pointF4.x = pointF.x + f5;
        pointF4.y = pointF.y;
        PointF pointF5 = this.v;
        pointF5.x = pointF.x;
        pointF5.y = pointF.y + f6;
        PointF pointF6 = this.w;
        pointF6.x = pointF.x - f5;
        pointF6.y = pointF.y - f6;
        PointF pointF7 = this.x;
        pointF7.x = pointF.x + f5;
        pointF7.y = pointF.y - f6;
        PointF pointF8 = this.y;
        pointF8.x = pointF.x + f5;
        pointF8.y = pointF.y + f6;
        PointF pointF9 = this.z;
        pointF9.x = pointF.x - f5;
        pointF9.y = pointF.y + f6;
        this.M = pointF8;
        y();
        us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
        float c = aVar.c(this.t, this.v);
        float c2 = aVar.c(this.s, this.u);
        float a2 = aVar.a(this.t, this.v);
        a aVar2 = this.a;
        if (aVar2 == null) {
            return;
        }
        PointF pointF10 = this.r;
        aVar2.a(pointF10.x, pointF10.y, c, c2, -((float) Math.toDegrees(a2)));
    }

    private final boolean n(PointF pointF) {
        return q(this.E, pointF);
    }

    private final boolean o(PointF pointF) {
        return q(this.B, pointF);
    }

    private final boolean p(PointF pointF) {
        float f2 = this.f10937e / 2;
        return new RectF(f2, f2, this.K - f2, this.L - f2).contains(pointF.x, pointF.y);
    }

    private final boolean q(PointF pointF, PointF pointF2) {
        float f2 = this.f10937e / 2;
        float f3 = pointF.x;
        float f4 = pointF.y;
        return new RectF(f3 - f2, f4 - f2, f3 + f2, f4 + f2).contains(pointF2.x, pointF2.y);
    }

    private final boolean r(PointF pointF) {
        return q(this.D, pointF);
    }

    private final boolean s(PointF pointF) {
        return q(this.J, pointF);
    }

    private final boolean t(PointF pointF) {
        return us.pinguo.common.helper.a.a.d(pointF, this.F, this.G, this.I, this.H);
    }

    private final boolean u(PointF pointF) {
        return q(this.C, pointF);
    }

    private final void v(Vector vector) {
        us.pinguo.common.log.a.k("movePointsToVector->moveVector:" + vector + ' ', new Object[0]);
        us.pinguo.common.log.a.k("movePointsToVector->lastCenter:" + this.A + ' ', new Object[0]);
        PointF pointF = this.A;
        float f2 = pointF.x;
        if (((PointF) vector).x + f2 <= 0.0f) {
            ((PointF) vector).x = -f2;
        }
        float f3 = pointF.y;
        if (((PointF) vector).y + f3 <= 0.0f) {
            ((PointF) vector).y = -f3;
        }
        if (pointF.x + ((PointF) vector).x >= getWidth()) {
            ((PointF) vector).x = getWidth() - this.A.x;
        }
        if (this.A.y + ((PointF) vector).y >= getHeight()) {
            ((PointF) vector).y = getHeight() - this.A.y;
        }
        us.pinguo.common.log.a.k("movePointsToVector->tempVector:" + vector + ' ', new Object[0]);
        A(this.r, this.A, vector);
        A(this.s, this.B, vector);
        A(this.t, this.C, vector);
        A(this.u, this.D, vector);
        A(this.v, this.E, vector);
        A(this.w, this.F, vector);
        A(this.x, this.G, vector);
        A(this.y, this.H, vector);
        A(this.M, this.N, vector);
        A(this.z, this.I, vector);
        us.pinguo.common.log.a.k("movePointsToVector->centerPoint:" + this.r + " \n  next move", new Object[0]);
    }

    private final void y() {
        this.A.set(this.r);
        this.B.set(this.s);
        this.C.set(this.t);
        this.D.set(this.u);
        this.E.set(this.v);
        this.F.set(this.w);
        this.G.set(this.x);
        this.H.set(this.y);
        this.I.set(this.z);
    }

    private final void z(PointF pointF, PointF pointF2, float f2, float f3) {
        us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
        PointF pointF3 = this.r;
        double a2 = aVar.a(this.r, pointF2) - f2;
        pointF.x = pointF3.x + (aVar.c(pointF2, pointF3) * f3 * ((float) Math.cos(a2)));
        PointF pointF4 = this.r;
        pointF.y = pointF4.y + (aVar.c(pointF2, pointF4) * f3 * ((float) Math.sin(a2)));
        us.pinguo.common.log.a.k("\nsrcPoint:x->" + pointF2.x + " y->" + pointF2.y + "\nrotateDegree->" + Math.toDegrees(f2) + " scale->" + f3 + " \ndstPoint:x->" + pointF.x + " y->" + pointF.y + ' ', new Object[0]);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10938f) {
            i(canvas);
        }
        h(canvas);
        f(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.K == 0 && this.L == 0) {
            m();
        }
    }

    public final void setOnStovepipeSelectorListener(a aVar) {
        this.a = aVar;
    }

    public final boolean w(MotionEvent event) {
        s.h(event, "event");
        us.pinguo.common.log.a.k("pointerCount:" + event.getPointerCount() + " action:" + event.getAction() + " actionMasked:" + event.getActionMasked(), new Object[0]);
        if (event.getPointerCount() > 1) {
            this.P = true;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.P = false;
                y();
                us.pinguo.common.helper.a aVar = us.pinguo.common.helper.a.a;
                float c = aVar.c(this.t, this.v);
                float c2 = aVar.c(this.s, this.u);
                float a2 = aVar.a(this.t, this.v);
                a aVar2 = this.a;
                if (aVar2 != null) {
                    PointF pointF = this.r;
                    aVar2.a(pointF.x, pointF.y, c, c2, -((float) Math.toDegrees(a2)));
                }
                PointF pointF2 = new PointF();
                pointF2.x = event.getX();
                pointF2.y = event.getY();
                us.pinguo.common.log.a.k(s.q("ACTION_UP->upPoint:", pointF2), new Object[0]);
                this.f10938f = false;
                this.J.set(this.N);
            } else if (actionMasked != 2) {
                if (actionMasked != 3) {
                    this.f10938f = false;
                    return super.onTouchEvent(event);
                }
                this.f10938f = false;
            } else if (this.P) {
                return true;
            } else {
                PointF pointF3 = new PointF();
                pointF3.x = event.getX();
                pointF3.y = event.getY();
                if (s(this.O)) {
                    us.pinguo.common.helper.a aVar3 = us.pinguo.common.helper.a.a;
                    this.f10944l = aVar3.a(this.r, this.O) - aVar3.a(this.r, pointF3);
                    float c3 = aVar3.c(this.r, pointF3) / aVar3.c(this.r, this.O);
                    this.m = c3;
                    if (d(c3)) {
                        this.m = this.c / Math.min(k(), j());
                    }
                    if (c(this.m)) {
                        this.m = this.f10936d / Math.max(k(), j());
                    }
                    a(this.f10944l, this.m);
                    us.pinguo.common.log.a.k("ACTION_MOVE->movePoint:" + pointF3 + " rotateAngle:" + Math.toDegrees(this.f10944l) + " scale:" + this.m, new Object[0]);
                } else if (o(this.O)) {
                    Vector l2 = l(this.D, this.B, pointF3);
                    us.pinguo.common.log.a.k("ACTION_MOVE->isLeftBtnTouch->moveVector:" + l2 + ' ', new Object[0]);
                    if (!b(this.B, this.D, l2)) {
                        return true;
                    }
                    this.s.set(us.pinguo.common.gesture.b.b(this.B, l2));
                    this.w.set(us.pinguo.common.gesture.b.b(this.F, l2));
                    this.z.set(us.pinguo.common.gesture.b.b(this.I, l2));
                    this.x.set(us.pinguo.common.gesture.b.a(this.G, l2));
                    this.u.set(us.pinguo.common.gesture.b.a(this.D, l2));
                    this.y.set(us.pinguo.common.gesture.b.a(this.H, l2));
                } else if (u(this.O)) {
                    Vector l3 = l(this.E, this.C, pointF3);
                    us.pinguo.common.log.a.k("ACTION_MOVE->isTopBtnTouch->moveVector:" + l3 + ' ', new Object[0]);
                    if (!b(this.C, this.E, l3)) {
                        return true;
                    }
                    this.w.set(us.pinguo.common.gesture.b.b(this.F, l3));
                    this.t.set(us.pinguo.common.gesture.b.b(this.C, l3));
                    this.x.set(us.pinguo.common.gesture.b.b(this.G, l3));
                    this.z.set(us.pinguo.common.gesture.b.a(this.I, l3));
                    this.v.set(us.pinguo.common.gesture.b.a(this.E, l3));
                    this.y.set(us.pinguo.common.gesture.b.a(this.H, l3));
                } else if (r(this.O)) {
                    Vector l4 = l(this.B, this.D, pointF3);
                    if (!b(this.D, this.B, l4) || us.pinguo.common.helper.a.a.c(us.pinguo.common.gesture.b.b(this.B, l4), us.pinguo.common.gesture.b.a(this.D, l4)) <= this.c) {
                        return true;
                    }
                    us.pinguo.common.log.a.k("ACTION_MOVE->isRightBtnTouch->moveVector:" + l4 + ' ', new Object[0]);
                    this.u.set(us.pinguo.common.gesture.b.b(this.D, l4));
                    this.x.set(us.pinguo.common.gesture.b.b(this.G, l4));
                    this.y.set(us.pinguo.common.gesture.b.b(this.H, l4));
                    this.s.set(us.pinguo.common.gesture.b.a(this.B, l4));
                    this.w.set(us.pinguo.common.gesture.b.a(this.F, l4));
                    this.z.set(us.pinguo.common.gesture.b.a(this.I, l4));
                } else if (n(this.O)) {
                    Vector l5 = l(this.C, this.E, pointF3);
                    if (!b(this.E, this.C, l5)) {
                        return true;
                    }
                    us.pinguo.common.log.a.k("ACTION_MOVE->isBottomBtnTouch->moveVector:" + l5 + ' ', new Object[0]);
                    this.z.set(us.pinguo.common.gesture.b.b(this.I, l5));
                    this.v.set(us.pinguo.common.gesture.b.b(this.E, l5));
                    this.y.set(us.pinguo.common.gesture.b.b(this.H, l5));
                    this.w.set(us.pinguo.common.gesture.b.a(this.F, l5));
                    this.t.set(us.pinguo.common.gesture.b.a(this.C, l5));
                    this.x.set(us.pinguo.common.gesture.b.a(this.G, l5));
                } else if (t(this.O)) {
                    float f2 = pointF3.x;
                    PointF pointF4 = this.O;
                    Vector vector = new Vector(f2 - pointF4.x, pointF3.y - pointF4.y);
                    us.pinguo.common.log.a.k("ACTION_MOVE->isSelectorAreaTouch->moveVector:" + vector + ' ', new Object[0]);
                    v(vector);
                }
                invalidate();
            }
            invalidate();
            return super.onTouchEvent(event);
        }
        this.O.x = event.getX();
        this.O.y = event.getY();
        us.pinguo.common.log.a.k(s.q("ACTION_DOWN->downPoint:", this.O), new Object[0]);
        this.f10938f = s(this.O) || o(this.O) || u(this.O) || r(this.O) || n(this.O) || t(this.O);
        return s(this.O) || o(this.O) || u(this.O) || r(this.O) || n(this.O) || t(this.O);
    }

    public final void x() {
        m();
        invalidate();
    }

    public /* synthetic */ StovepipeAreaSelectorView(Context context, AttributeSet attributeSet, int i2, int i3, int i4, o oVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
