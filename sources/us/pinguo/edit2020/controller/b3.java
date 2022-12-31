package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.edit2020.widget.FaceCurveView;
/* compiled from: FaceCurveController.kt */
/* loaded from: classes4.dex */
public final class b3 {
    private final FaceCurveView a;
    private PointF[] b;
    private PointF[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f10435d;

    /* renamed from: e  reason: collision with root package name */
    private int f10436e;

    /* renamed from: f  reason: collision with root package name */
    private int f10437f;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Integer, kotlin.u> f10438g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> f10439h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10440i;

    /* renamed from: j  reason: collision with root package name */
    private us.pinguo.facedetector.c f10441j;

    /* renamed from: k  reason: collision with root package name */
    private us.pinguo.edit2020.bean.u0 f10442k;

    /* renamed from: l  reason: collision with root package name */
    private final a f10443l;
    private GestureDetector m;

    /* compiled from: FaceCurveController.kt */
    /* loaded from: classes4.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (motionEvent != null) {
                b3 b3Var = b3.this;
                int f2 = b3Var.h().f(new PointF(motionEvent.getX(), motionEvent.getY()));
                if (f2 >= 0) {
                    kotlin.jvm.b.l<Integer, kotlin.u> k2 = b3Var.k();
                    if (k2 != null) {
                        k2.invoke(Integer.valueOf(f2));
                    }
                    b3Var.f10435d = f2;
                    PointF e2 = FaceCurveView.e(b3Var.h(), null, 1, null);
                    if (e2 != null) {
                        float e3 = b3Var.e(f2);
                        if (e3 > 1.0f) {
                            b3Var.m(e2, e3);
                        }
                    }
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public b3(FaceCurveView faceCurveView) {
        kotlin.jvm.internal.s.h(faceCurveView, "faceCurveView");
        this.a = faceCurveView;
        a aVar = new a();
        this.f10443l = aVar;
        this.m = new GestureDetector(faceCurveView.getContext(), aVar);
    }

    private final float d(Integer num) {
        int a2;
        us.pinguo.facedetector.b[] d2;
        us.pinguo.facedetector.c cVar = this.f10441j;
        us.pinguo.facedetector.b bVar = null;
        if (cVar != null && (d2 = cVar.d()) != null) {
            bVar = d2[num == null ? 0 : num.intValue()];
        }
        if (bVar == null) {
            return 3.0f;
        }
        Rect g2 = bVar.g();
        int abs = Math.abs(g2.right - g2.left);
        a2 = kotlin.z.j.a(this.f10436e, this.f10437f);
        float f2 = a2 / 2;
        float f3 = abs;
        if (f3 >= f2) {
            return 1.0f;
        }
        return f2 / f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float e(int i2) {
        int c;
        us.pinguo.facedetector.b[] d2;
        us.pinguo.facedetector.c cVar = this.f10441j;
        us.pinguo.facedetector.b bVar = null;
        if (cVar != null && (d2 = cVar.d()) != null) {
            bVar = d2[i2];
        }
        if (bVar == null) {
            return 1.5f;
        }
        Rect g2 = bVar.g();
        int abs = Math.abs(g2.right - g2.left);
        c = kotlin.z.j.c(this.f10436e, this.f10437f);
        float f2 = c / 3.0f;
        float f3 = abs;
        if (f3 >= f2) {
            return 1.0f;
        }
        return f2 / f3;
    }

    private final PointF f(PointF pointF, PointF pointF2, int i2, int i3, float f2, float f3, float f4, float f5) {
        float f6 = f3 / i3;
        float width = this.a.getWidth() - f2;
        float f7 = 2;
        pointF2.set((width / f7) + (pointF.x * f6) + f4, (((this.a.getHeight() - f3) / f7) + (pointF.y * f6)) - f5);
        return pointF2;
    }

    private final void i(us.pinguo.facedetector.c cVar) {
        Integer[] numArr = {3, 8, 13, 29, 24, 19};
        int c = cVar.c() * 8;
        PointF[] pointFArr = new PointF[c];
        for (int i2 = 0; i2 < c; i2++) {
            PointF pointF = new PointF();
            int i3 = i2 % 8;
            us.pinguo.facedetector.b bVar = cVar.d()[i2 / 8];
            if (i3 == 0) {
                pointF.x = bVar.g().left;
                pointF.y = bVar.g().top;
            } else if (i3 != 1) {
                int intValue = numArr[i3 - 2].intValue();
                pointF.x = bVar.l(intValue);
                pointF.y = bVar.m(intValue);
            } else {
                pointF.x = bVar.g().right;
                pointF.y = bVar.g().bottom;
            }
            pointFArr[i2] = pointF;
        }
        this.b = pointFArr;
        w();
        PointF[] pointFArr2 = this.b;
        kotlin.jvm.internal.s.e(pointFArr2);
        int length = pointFArr2.length;
        PointF[] pointFArr3 = new PointF[length];
        for (int i4 = 0; i4 < length; i4++) {
            pointFArr3[i4] = new PointF();
        }
        this.c = pointFArr3;
        this.f10436e = cVar.e();
        this.f10437f = cVar.f();
        this.f10441j = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PointF pointF, float f2) {
        float width = ((this.a.getWidth() / 2) - pointF.x) / this.a.getWidth();
        float height = (pointF.y - (this.a.getHeight() / 2)) / this.a.getHeight();
        pointF.x /= this.a.getWidth();
        pointF.y = 1 - (pointF.y / this.a.getHeight());
        kotlin.jvm.b.r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> rVar = this.f10439h;
        if (rVar == null) {
            return;
        }
        rVar.invoke(pointF, Float.valueOf(f2), new PointF(width, height), 500);
    }

    private final void p(PointF pointF, float f2) {
        float width = ((this.a.getWidth() / 2) - pointF.x) / this.a.getWidth();
        float height = (pointF.y - (this.a.getHeight() / 2)) / this.a.getHeight();
        pointF.x /= this.a.getWidth();
        pointF.y = 1 - (pointF.y / this.a.getHeight());
        kotlin.jvm.b.r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> rVar = this.f10439h;
        if (rVar == null) {
            return;
        }
        rVar.invoke(pointF, Float.valueOf(f2), new PointF(width, height), 500);
    }

    private final void w() {
        PointF[] pointFArr = this.b;
        if (pointFArr == null) {
            return;
        }
        int length = pointFArr.length;
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < length) {
            PointF pointF = pointFArr[i2];
            int i4 = i3 + 1;
            int i5 = i3 % 8;
            if (i5 == 0) {
                float f4 = 2;
                f2 = (pointFArr[i4].x + pointFArr[i3].x) / f4;
                f3 = (pointFArr[i4].y + pointFArr[i3].y) / f4;
            }
            if (i5 > 1) {
                PointF pointF2 = pointFArr[i3];
                float abs = Math.abs(pointF2.x - f2) * 0.1f;
                float abs2 = Math.abs(pointF2.y - f3) * 0.1f;
                float f5 = pointF2.x;
                float f6 = f5 < f2 ? f5 - abs : f5 + abs;
                float f7 = pointF2.y;
                pointF2.set(f6, f7 < f3 ? f7 - abs2 : f7 + abs2);
            }
            i2++;
            i3 = i4;
        }
    }

    public final void g(us.pinguo.facedetector.c cVar) {
        if (cVar == null || cVar.c() <= 0) {
            return;
        }
        if (cVar.c() == 1) {
            l();
        }
        i(cVar);
        us.pinguo.edit2020.bean.u0 u0Var = this.f10442k;
        if (u0Var == null) {
            return;
        }
        n(u0Var);
    }

    public final FaceCurveView h() {
        return this.a;
    }

    public final boolean j() {
        return this.f10440i;
    }

    public final kotlin.jvm.b.l<Integer, kotlin.u> k() {
        return this.f10438g;
    }

    public final void l() {
        FaceCurveView faceCurveView = this.a;
        faceCurveView.setVisibility(4);
        VdsAgent.onSetViewVisibility(faceCurveView, 4);
    }

    public final void n(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        PointF[] pointFArr = this.b;
        if (pointFArr != null) {
            int length = pointFArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                PointF pointF = pointFArr[i3];
                int i4 = i2 + 1;
                PointF[] pointFArr2 = this.c;
                if (pointFArr2 == null) {
                    kotlin.jvm.internal.s.z("currentFacePoint");
                    throw null;
                }
                f(pointF, pointFArr2[i2], this.f10437f, this.f10436e, unityCanvasStatus.e(), unityCanvasStatus.d(), unityCanvasStatus.a(), unityCanvasStatus.b());
                i3++;
                i2 = i4;
            }
            FaceCurveView h2 = h();
            PointF[] pointFArr3 = this.c;
            if (pointFArr3 == null) {
                kotlin.jvm.internal.s.z("currentFacePoint");
                throw null;
            }
            h2.c(pointFArr3, j());
        }
        this.f10442k = unityCanvasStatus;
    }

    public final boolean o(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (this.a.getVisibility() == 0) {
            return this.m.onTouchEvent(event);
        }
        return false;
    }

    public final void q(Integer num) {
        PointF d2 = this.a.d(num);
        if (d2 == null) {
            return;
        }
        float d3 = d(num);
        if (d3 > 1.0f) {
            p(d2, d3);
        }
    }

    public final void r(boolean z) {
        this.f10440i = z;
    }

    public final void s(kotlin.jvm.b.l<? super Integer, kotlin.u> lVar) {
        this.f10438g = lVar;
    }

    public final void t(kotlin.jvm.b.r<? super PointF, ? super Float, ? super PointF, ? super Integer, kotlin.u> rVar) {
        this.f10439h = rVar;
    }

    public final void u(int i2) {
        this.a.setSelectFace(i2);
    }

    public final void v() {
        FaceCurveView faceCurveView = this.a;
        faceCurveView.setVisibility(0);
        VdsAgent.onSetViewVisibility(faceCurveView, 0);
        PointF[] pointFArr = this.c;
        if (pointFArr != null) {
            FaceCurveView faceCurveView2 = this.a;
            if (pointFArr != null) {
                faceCurveView2.c(pointFArr, this.f10440i);
            } else {
                kotlin.jvm.internal.s.z("currentFacePoint");
                throw null;
            }
        }
    }
}
