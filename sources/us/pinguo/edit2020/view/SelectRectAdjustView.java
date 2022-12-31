package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.u0;
/* compiled from: SelectRectAdjustView.kt */
/* loaded from: classes4.dex */
public final class SelectRectAdjustView extends View {
    private final Paint A;
    private final b A0;
    private final Paint B;
    private final ScaleGestureDetector B0;
    private final Paint C;
    private final DashPathEffect D;
    private boolean E;
    private final HashMap<String, PointF> F;
    private boolean G;
    private PointF H;
    private PointF I;
    private PointF J;
    private float K;
    private String L;
    private String M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private int R;
    private int S;
    private PointF T;
    private double U;
    private float V;
    private final int W;
    private final int a;
    private final int b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10718d;
    private final int d0;

    /* renamed from: e  reason: collision with root package name */
    private final int f10719e;
    private final int e0;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f10720f;
    private final float f0;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f10721g;
    private final float g0;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f10722h;
    private boolean h0;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f10723i;
    private kotlin.jvm.b.r<? super String, ? super Float, ? super PointF, ? super PointF, kotlin.u> i0;

    /* renamed from: j  reason: collision with root package name */
    private final PointF f10724j;
    private a j0;

    /* renamed from: k  reason: collision with root package name */
    private final PointF f10725k;
    private boolean k0;

    /* renamed from: l  reason: collision with root package name */
    private final PointF f10726l;
    private boolean l0;
    private final PointF m;
    private boolean m0;
    private final PointF n;
    private boolean n0;
    private final PointF o;
    private boolean o0;
    private final PointF p;
    private boolean p0;
    private final PointF q;
    private float q0;
    private final PointF r;
    private long r0;
    private final PointF s;
    private PointSide s0;
    private final PointF t;
    private kotlin.jvm.b.r<? super PointF, ? super PointF, ? super PointF, ? super PointF, kotlin.u> t0;
    private final PointF u;
    private boolean u0;
    private final PointF v;
    private final int v0;
    private final PointF w;
    private float w0;
    private final PointF x;
    private float x0;
    private final PointF y;
    private final c y0;
    private final Paint z;
    private GestureDetector z0;

    /* compiled from: SelectRectAdjustView.kt */
    /* loaded from: classes4.dex */
    public enum PointSide {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }

    /* compiled from: SelectRectAdjustView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f(PointF pointF);
    }

    /* compiled from: SelectRectAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {
        b() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null) {
                SelectRectAdjustView selectRectAdjustView = SelectRectAdjustView.this;
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Math.abs(scaleFactor - 1) < 0.005d) {
                    return false;
                }
                PointF pointF = selectRectAdjustView.J;
                if (pointF != null) {
                    pointF.set(pointF.x * scaleFactor, pointF.y * scaleFactor);
                    selectRectAdjustView.E = false;
                }
                selectRectAdjustView.R();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* compiled from: SelectRectAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        /* compiled from: SelectRectAdjustView.kt */
        /* loaded from: classes4.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[PointSide.values().length];
                iArr[PointSide.LEFT.ordinal()] = 1;
                iArr[PointSide.TOP.ordinal()] = 2;
                iArr[PointSide.RIGHT.ordinal()] = 3;
                iArr[PointSide.BOTTOM.ordinal()] = 4;
                a = iArr;
            }
        }

        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e2) {
            kotlin.jvm.b.r<PointF, PointF, PointF, PointF, kotlin.u> J;
            kotlin.jvm.internal.s.h(e2, "e");
            if (SelectRectAdjustView.this.o0 || !SelectRectAdjustView.this.P(e2.getX(), e2.getY())) {
                return;
            }
            if (!(SelectRectAdjustView.this.F().length() > 0) || SelectRectAdjustView.this.p0 || (J = SelectRectAdjustView.this.J()) == null) {
                return;
            }
            J.invoke(SelectRectAdjustView.this.f10724j, SelectRectAdjustView.this.f10725k, SelectRectAdjustView.this.f10726l, SelectRectAdjustView.this.m);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            SelectRectAdjustView.this.o0 = true;
            if (SelectRectAdjustView.this.G) {
                return false;
            }
            if (SelectRectAdjustView.this.s0 == null) {
                float f4 = f2 / SelectRectAdjustView.this.R;
                float f5 = f3 / SelectRectAdjustView.this.S;
                PointF pointF = SelectRectAdjustView.this.I;
                if (pointF != null) {
                    SelectRectAdjustView selectRectAdjustView = SelectRectAdjustView.this;
                    pointF.set(pointF.x - f4, pointF.y - f5);
                    selectRectAdjustView.E = false;
                }
            } else {
                PointSide pointSide = SelectRectAdjustView.this.s0;
                int i2 = pointSide == null ? -1 : a.a[pointSide.ordinal()];
                if (i2 == 1) {
                    float f6 = (f2 / SelectRectAdjustView.this.R) * 2;
                    PointF pointF2 = SelectRectAdjustView.this.J;
                    if (pointF2 != null) {
                        pointF2.x += f6;
                    }
                } else if (i2 == 2) {
                    float f7 = (f3 / SelectRectAdjustView.this.S) * 2;
                    PointF pointF3 = SelectRectAdjustView.this.J;
                    if (pointF3 != null) {
                        pointF3.y += f7;
                    }
                } else if (i2 == 3) {
                    float f8 = (f2 / SelectRectAdjustView.this.R) * 2;
                    PointF pointF4 = SelectRectAdjustView.this.J;
                    if (pointF4 != null) {
                        pointF4.x -= f8;
                    }
                } else if (i2 == 4) {
                    float f9 = (f3 / SelectRectAdjustView.this.S) * 2;
                    PointF pointF5 = SelectRectAdjustView.this.J;
                    if (pointF5 != null) {
                        pointF5.y -= f9;
                    }
                }
                if (SelectRectAdjustView.this.S()) {
                    SelectRectAdjustView.this.E = false;
                    SelectRectAdjustView.this.m0 = true;
                } else {
                    SelectRectAdjustView.this.Z(null);
                    SelectRectAdjustView.this.E = true;
                }
            }
            SelectRectAdjustView.this.T();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            a H;
            if (motionEvent != null) {
                SelectRectAdjustView selectRectAdjustView = SelectRectAdjustView.this;
                if (motionEvent.getX() < selectRectAdjustView.f10724j.x + (selectRectAdjustView.f10720f.getWidth() / 2) && motionEvent.getX() > selectRectAdjustView.f10724j.x - (selectRectAdjustView.f10720f.getWidth() / 2) && motionEvent.getY() < selectRectAdjustView.f10724j.y + (selectRectAdjustView.f10720f.getHeight() / 2) && motionEvent.getY() > selectRectAdjustView.f10724j.y - (selectRectAdjustView.f10720f.getHeight() / 2)) {
                    if (selectRectAdjustView.F().length() > 0) {
                        a H2 = selectRectAdjustView.H();
                        if (H2 != null) {
                            H2.d();
                        }
                    }
                }
                if (motionEvent.getX() < selectRectAdjustView.f10726l.x + (selectRectAdjustView.f10721g.getWidth() / 2) && motionEvent.getX() > selectRectAdjustView.f10726l.x - (selectRectAdjustView.f10721g.getWidth() / 2) && motionEvent.getY() < selectRectAdjustView.f10726l.y + (selectRectAdjustView.f10721g.getHeight() / 2) && motionEvent.getY() > selectRectAdjustView.f10726l.y - (selectRectAdjustView.f10721g.getHeight() / 2)) {
                    if (selectRectAdjustView.F().length() > 0) {
                        a H3 = selectRectAdjustView.H();
                        if (H3 != null) {
                            H3.e();
                        }
                    }
                }
                if (motionEvent.getX() < selectRectAdjustView.f10725k.x + (selectRectAdjustView.f10722h.getWidth() / 2) && motionEvent.getX() > selectRectAdjustView.f10725k.x - (selectRectAdjustView.f10722h.getWidth() / 2) && motionEvent.getY() < selectRectAdjustView.f10725k.y + (selectRectAdjustView.f10722h.getHeight() / 2) && motionEvent.getY() > selectRectAdjustView.f10725k.y - (selectRectAdjustView.f10722h.getHeight() / 2)) {
                    if (selectRectAdjustView.F().length() > 0) {
                        a H4 = selectRectAdjustView.H();
                        if (H4 != null) {
                            H4.b();
                        }
                    }
                }
                if (motionEvent.getX() < selectRectAdjustView.m.x + (selectRectAdjustView.f10723i.getWidth() / 2) && motionEvent.getX() > selectRectAdjustView.m.x - (selectRectAdjustView.f10723i.getWidth() / 2) && motionEvent.getY() < selectRectAdjustView.m.y + (selectRectAdjustView.f10723i.getHeight() / 2) && motionEvent.getY() > selectRectAdjustView.m.y - (selectRectAdjustView.f10723i.getHeight() / 2)) {
                    if (selectRectAdjustView.F().length() > 0) {
                        a H5 = selectRectAdjustView.H();
                        if (H5 != null) {
                            H5.a();
                        }
                    }
                }
                if (System.currentTimeMillis() - selectRectAdjustView.r0 < 600) {
                    a H6 = selectRectAdjustView.H();
                    if (H6 != null) {
                        H6.f(new PointF(motionEvent.getX(), motionEvent.getY()));
                    }
                    if (selectRectAdjustView.I().length() > 0) {
                        if ((selectRectAdjustView.F().length() == 0) && selectRectAdjustView.P(motionEvent.getX(), motionEvent.getY()) && (H = selectRectAdjustView.H()) != null) {
                            H.c();
                        }
                    }
                }
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectAdjustView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = 5;
        this.b = 5;
        this.c = 0.03f;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10718d = us.pinguo.util.g.a(context2, 2.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.f10719e = us.pinguo.util.g.a(context3, 17.0f);
        this.f10724j = new PointF(0.0f, 0.0f);
        this.f10725k = new PointF(0.0f, 0.0f);
        this.f10726l = new PointF(0.0f, 0.0f);
        this.m = new PointF(0.0f, 0.0f);
        this.n = new PointF(0.0f, 0.0f);
        this.o = new PointF(0.0f, 0.0f);
        this.p = new PointF(0.0f, 0.0f);
        this.q = new PointF(0.0f, 0.0f);
        this.r = new PointF(0.0f, 0.0f);
        this.s = new PointF(0.0f, 0.0f);
        this.t = new PointF(0.0f, 0.0f);
        this.u = new PointF(0.0f, 0.0f);
        this.v = new PointF(0.0f, 0.0f);
        this.w = new PointF(0.0f, 0.0f);
        this.x = new PointF(0.0f, 0.0f);
        this.y = new PointF(0.0f, 0.0f);
        Paint paint = new Paint();
        this.z = paint;
        Paint paint2 = new Paint();
        this.A = paint2;
        Paint paint3 = new Paint();
        this.B = paint3;
        Paint paint4 = new Paint();
        this.C = paint4;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{8.0f, 4.0f}, 0.0f);
        this.D = dashPathEffect;
        this.F = new HashMap<>();
        this.H = new PointF(0.0f, 0.0f);
        this.L = "";
        this.M = "";
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.W = us.pinguo.util.g.a(context4, 59.0f);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.d0 = us.pinguo.util.g.a(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.e0 = us.pinguo.util.g.a(context6, 25.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f0 = us.pinguo.util.g.a(context7, 15.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.g0 = us.pinguo.util.g.a(context8, 1.0f);
        this.k0 = true;
        this.v0 = 5;
        this.w0 = -1.0f;
        this.x0 = -1.0f;
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        paint.setStrokeWidth(us.pinguo.util.g.a(context9, 1.0f));
        paint2.setColor(Color.parseColor("#fab615"));
        paint2.setStyle(Paint.Style.STROKE);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        paint2.setStrokeWidth(us.pinguo.util.g.a(context10, 1.0f));
        paint3.setColor(Color.parseColor("#ffffff"));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint4.setColor(Color.argb(255, 255, 255, 255));
        paint4.setStyle(Paint.Style.STROKE);
        Context context11 = getContext();
        kotlin.jvm.internal.s.g(context11, "context");
        paint4.setStrokeWidth(us.pinguo.util.g.a(context11, 1.0f));
        paint4.setPathEffect(dashPathEffect);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_tihuan);
        kotlin.jvm.internal.s.g(decodeResource, "decodeResource(context.r…rawable.edit_icon_tihuan)");
        this.f10720f = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_jingxiang);
        kotlin.jvm.internal.s.g(decodeResource2, "decodeResource(context.r…able.edit_icon_jingxiang)");
        this.f10721g = decodeResource2;
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_koutu);
        kotlin.jvm.internal.s.g(decodeResource3, "decodeResource(context.r…drawable.edit_icon_koutu)");
        this.f10722h = decodeResource3;
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_xuanzhuan);
        kotlin.jvm.internal.s.g(decodeResource4, "decodeResource(context.r…able.edit_icon_xuanzhuan)");
        this.f10723i = decodeResource4;
        c cVar = new c();
        this.y0 = cVar;
        this.z0 = new GestureDetector(getContext(), cVar);
        b bVar = new b();
        this.A0 = bVar;
        this.B0 = new ScaleGestureDetector(getContext(), bVar);
    }

    private final void B(MotionEvent motionEvent) {
        double atan2 = Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1));
        double d2 = this.U;
        if (!(d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) && Math.abs(d2 - atan2) < 0.2d) {
            float degrees = this.q0 - ((float) Math.toDegrees(this.U - atan2));
            this.q0 = degrees;
            float f2 = degrees % ((float) BaseBlurEffect.ROTATION_360);
            this.q0 = f2;
            this.K = f2;
            this.E = false;
        }
        this.U = atan2;
        y();
    }

    private final void C(Canvas canvas) {
        Z(new PointF[]{this.r, this.t, this.s, this.u});
        if (canvas != null) {
            PointF pointF = this.r;
            float f2 = pointF.x;
            float f3 = pointF.y;
            PointF pointF2 = this.s;
            canvas.drawLine(f2, f3, pointF2.x, pointF2.y, this.A);
        }
        if (canvas != null) {
            PointF pointF3 = this.r;
            float f4 = pointF3.x;
            float f5 = pointF3.y;
            PointF pointF4 = this.t;
            canvas.drawLine(f4, f5, pointF4.x, pointF4.y, this.A);
        }
        if (canvas != null) {
            PointF pointF5 = this.t;
            float f6 = pointF5.x;
            float f7 = pointF5.y;
            PointF pointF6 = this.u;
            canvas.drawLine(f6, f7, pointF6.x, pointF6.y, this.A);
        }
        if (canvas == null) {
            return;
        }
        PointF pointF7 = this.u;
        float f8 = pointF7.x;
        float f9 = pointF7.y;
        PointF pointF8 = this.s;
        canvas.drawLine(f8, f9, pointF8.x, pointF8.y, this.A);
    }

    private final void D(Canvas canvas) {
        if (canvas != null) {
            PointF pointF = this.f10724j;
            float f2 = pointF.x;
            float f3 = pointF.y;
            PointF pointF2 = this.f10725k;
            canvas.drawLine(f2, f3, pointF2.x, pointF2.y, this.z);
        }
        if (canvas != null) {
            PointF pointF3 = this.f10724j;
            float f4 = pointF3.x;
            float f5 = pointF3.y;
            PointF pointF4 = this.f10726l;
            canvas.drawLine(f4, f5, pointF4.x, pointF4.y, this.z);
        }
        if (canvas != null) {
            PointF pointF5 = this.f10726l;
            float f6 = pointF5.x;
            float f7 = pointF5.y;
            PointF pointF6 = this.m;
            canvas.drawLine(f6, f7, pointF6.x, pointF6.y, this.z);
        }
        if (canvas != null) {
            PointF pointF7 = this.m;
            float f8 = pointF7.x;
            float f9 = pointF7.y;
            PointF pointF8 = this.f10725k;
            canvas.drawLine(f8, f9, pointF8.x, pointF8.y, this.z);
        }
        z();
        if (canvas != null) {
            PointF pointF9 = this.v;
            canvas.drawCircle(pointF9.x, pointF9.y, this.f10718d, this.B);
        }
        if (canvas != null) {
            PointF pointF10 = this.w;
            canvas.drawCircle(pointF10.x, pointF10.y, this.f10718d, this.B);
        }
        if (canvas != null) {
            PointF pointF11 = this.x;
            canvas.drawCircle(pointF11.x, pointF11.y, this.f10718d, this.B);
        }
        if (canvas != null) {
            PointF pointF12 = this.y;
            canvas.drawCircle(pointF12.x, pointF12.y, this.f10718d, this.B);
        }
        if (canvas != null) {
            Bitmap bitmap = this.f10720f;
            canvas.drawBitmap(bitmap, this.f10724j.x - (bitmap.getWidth() / 2), this.f10724j.y - (this.f10720f.getHeight() / 2), this.z);
        }
        if (canvas != null) {
            Bitmap bitmap2 = this.f10722h;
            canvas.drawBitmap(bitmap2, this.f10725k.x - (bitmap2.getWidth() / 2), this.f10725k.y - (this.f10722h.getHeight() / 2), this.z);
        }
        if (canvas != null) {
            Bitmap bitmap3 = this.f10721g;
            canvas.drawBitmap(bitmap3, this.f10726l.x - (bitmap3.getWidth() / 2), this.f10726l.y - (this.f10721g.getHeight() / 2), this.z);
        }
        if (canvas != null) {
            Bitmap bitmap4 = this.f10723i;
            canvas.drawBitmap(bitmap4, this.m.x - (bitmap4.getWidth() / 2), this.m.y - (this.f10723i.getHeight() / 2), this.z);
        }
        if (this.h0) {
            if (canvas != null) {
                PointF pointF13 = this.n;
                float f10 = pointF13.x;
                float f11 = pointF13.y;
                PointF pointF14 = this.o;
                canvas.drawLine(f10, f11, pointF14.x, pointF14.y, this.C);
            }
            if (canvas != null) {
                PointF pointF15 = this.n;
                float f12 = pointF15.x;
                float f13 = pointF15.y;
                PointF pointF16 = this.p;
                canvas.drawLine(f12, f13, pointF16.x, pointF16.y, this.C);
            }
            if (canvas != null) {
                PointF pointF17 = this.p;
                float f14 = pointF17.x;
                float f15 = pointF17.y;
                PointF pointF18 = this.q;
                canvas.drawLine(f14, f15, pointF18.x, pointF18.y, this.C);
            }
            if (canvas == null) {
                return;
            }
            PointF pointF19 = this.q;
            float f16 = pointF19.x;
            float f17 = pointF19.y;
            PointF pointF20 = this.o;
            canvas.drawLine(f16, f17, pointF20.x, pointF20.y, this.C);
        }
    }

    private final void M() {
        PointF pointF;
        PointF pointF2 = this.J;
        if (pointF2 == null || (pointF = this.I) == null) {
            return;
        }
        float abs = Math.abs(pointF2.x);
        float f2 = pointF.x;
        if (f2 > 0.5d) {
            float f3 = (abs / 2) + 1;
            int i2 = this.R;
            float f4 = (f3 - f2) * i2;
            float f5 = this.g0;
            if (f4 < f5) {
                pointF.x = f3 - (f5 / i2);
            }
        } else {
            float f6 = abs / 2;
            int i3 = this.R;
            float f7 = (f2 + f6) * i3;
            float f8 = this.g0;
            if (f7 < f8) {
                pointF.x = (f8 / i3) - f6;
            }
        }
        float f9 = pointF.y;
        if (f9 > 0.5d) {
            float f10 = pointF2.y;
            float f11 = 2;
            float f12 = 1;
            float f13 = ((f10 / f11) + f12) - f9;
            int i4 = this.S;
            float f14 = f13 * i4;
            float f15 = this.g0;
            if (f14 < f15) {
                pointF.y = ((f10 / f11) + f12) - (f15 / i4);
                return;
            }
            return;
        }
        float f16 = pointF2.y;
        float f17 = 2;
        float f18 = (f16 / f17) + f9;
        int i5 = this.S;
        float f19 = f18 * i5;
        float f20 = this.g0;
        if (f19 < f20) {
            pointF.y = (f20 / i5) - (f16 / f17);
        }
    }

    private final PointSide N(MotionEvent motionEvent) {
        z();
        if (O(motionEvent, this.v)) {
            PointF pointF = this.J;
            kotlin.jvm.internal.s.e(pointF);
            return pointF.y > 0.0f ? PointSide.TOP : PointSide.BOTTOM;
        } else if (O(motionEvent, this.w)) {
            PointF pointF2 = this.J;
            kotlin.jvm.internal.s.e(pointF2);
            return pointF2.y > 0.0f ? PointSide.BOTTOM : PointSide.TOP;
        } else if (O(motionEvent, this.x)) {
            PointF pointF3 = this.J;
            kotlin.jvm.internal.s.e(pointF3);
            return pointF3.x > 0.0f ? PointSide.LEFT : PointSide.RIGHT;
        } else if (O(motionEvent, this.y)) {
            PointF pointF4 = this.J;
            kotlin.jvm.internal.s.e(pointF4);
            return pointF4.x > 0.0f ? PointSide.RIGHT : PointSide.LEFT;
        } else {
            return null;
        }
    }

    private final boolean O(MotionEvent motionEvent, PointF pointF) {
        return Math.abs(motionEvent.getX() - pointF.x) < ((float) this.f10719e) && Math.abs(motionEvent.getY() - pointF.y) < ((float) this.f10719e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean P(float f2, float f3) {
        return this.f10724j.x + ((float) (this.f10720f.getWidth() / 2)) < f2 && f2 < this.f10725k.x - ((float) (this.f10722h.getWidth() / 2)) && this.f10724j.y + ((float) (this.f10720f.getHeight() / 2)) < f3 && f3 < this.f10726l.y - ((float) (this.f10721g.getHeight() / 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        PointF pointF;
        PointF pointF2 = this.J;
        if (pointF2 == null || (pointF = this.F.get(this.L)) == null) {
            return;
        }
        this.m0 = Math.abs(pointF2.x - pointF.x) * ((float) this.R) < ((float) this.b) && Math.abs(pointF2.y - pointF.y) * ((float) this.S) < ((float) this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S() {
        PointF pointF;
        PointF pointF2 = this.J;
        return (pointF2 == null || (pointF = this.F.get(this.L)) == null || Math.abs((pointF.x / pointF.y) - (pointF2.x / pointF2.y)) >= this.c) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.SelectRectAdjustView.X(android.view.MotionEvent):void");
    }

    private final void Y(PointF pointF, MotionEvent motionEvent) {
        PointF pointF2 = this.f10724j;
        float f2 = 2;
        float f3 = (pointF2.x + this.f10725k.x) / f2;
        float f4 = (pointF2.y + this.f10726l.y) / f2;
        float sqrt = ((float) Math.sqrt((Math.abs(motionEvent.getX() - f3) * Math.abs(motionEvent.getX() - f3)) + (Math.abs(motionEvent.getY() - f4) * Math.abs(motionEvent.getY() - f4)))) / ((float) Math.sqrt((Math.abs(this.m.x - f3) * Math.abs(this.m.x - f3)) + (Math.abs(this.m.y - f4) * Math.abs(this.m.y - f4))));
        PointF pointF3 = this.J;
        if (pointF3 != null) {
            pointF3.set(pointF.x * sqrt, pointF.y * sqrt);
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(android.graphics.PointF[] r20) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.view.SelectRectAdjustView.Z(android.graphics.PointF[]):void");
    }

    private final void y() {
        float f2 = 90;
        float min = Math.min(Math.abs(f2 - (this.K % f2)), Math.abs(this.K % f2));
        if (min < this.a) {
            float f3 = this.K;
            if (f3 % f2 < 45.0f) {
                this.K = f3 - min;
            } else {
                this.K = f3 + min;
            }
            this.l0 = true;
            return;
        }
        this.l0 = false;
    }

    private final void z() {
        PointF pointF = this.v;
        PointF pointF2 = this.f10724j;
        float f2 = 2;
        pointF.set((pointF2.x + this.f10725k.x) / f2, pointF2.y);
        PointF pointF3 = this.w;
        float f3 = this.f10726l.x;
        PointF pointF4 = this.m;
        pointF3.set((f3 + pointF4.x) / f2, pointF4.y);
        PointF pointF5 = this.x;
        PointF pointF6 = this.f10724j;
        pointF5.set(pointF6.x, (pointF6.y + this.f10726l.y) / f2);
        PointF pointF7 = this.y;
        PointF pointF8 = this.m;
        pointF7.set(pointF8.x, (pointF8.y + this.f10725k.y) / f2);
    }

    public final void A() {
        this.E = false;
        this.L = "";
        this.M = "";
        invalidate();
    }

    public final void E() {
        PointF pointF = this.J;
        if (pointF == null) {
            return;
        }
        pointF.x = -pointF.x;
        T();
    }

    public final String F() {
        return this.L;
    }

    public final float G() {
        return this.K;
    }

    public final a H() {
        return this.j0;
    }

    public final String I() {
        return this.M;
    }

    public final kotlin.jvm.b.r<PointF, PointF, PointF, PointF, kotlin.u> J() {
        return this.t0;
    }

    public final PointF K() {
        PointF pointF = this.I;
        return new PointF(pointF == null ? 0.0f : pointF.x, pointF != null ? pointF.y : 0.0f);
    }

    public final PointF L() {
        PointF pointF = this.J;
        return new PointF(pointF == null ? 0.0f : pointF.x, pointF != null ? pointF.y : 0.0f);
    }

    public final void Q(Bitmap leftTop, Bitmap leftBottom, Bitmap rightTop, Bitmap rightBottom) {
        kotlin.jvm.internal.s.h(leftTop, "leftTop");
        kotlin.jvm.internal.s.h(leftBottom, "leftBottom");
        kotlin.jvm.internal.s.h(rightTop, "rightTop");
        kotlin.jvm.internal.s.h(rightBottom, "rightBottom");
        this.f10720f = leftTop;
        this.f10721g = leftBottom;
        this.f10722h = rightTop;
        this.f10723i = rightBottom;
    }

    public final void T() {
        if (this.s0 == null) {
            PointF pointF = this.J;
            if (pointF == null || this.I == null) {
                return;
            }
            float abs = Math.abs(pointF.x * this.R);
            float abs2 = Math.abs(pointF.y * this.S);
            int i2 = this.d0;
            if (abs < i2) {
                float f2 = i2 / this.R;
                float f3 = (i2 * (abs2 / abs)) / this.S;
                PointF pointF2 = this.J;
                if (pointF2 != null) {
                    pointF2.set(f2, f3);
                }
            } else if (abs2 < i2) {
                float f4 = i2 / this.S;
                float f5 = (i2 * (abs / abs2)) / this.R;
                PointF pointF3 = this.J;
                if (pointF3 != null) {
                    pointF3.set(f5, f4);
                }
            }
            M();
        }
        kotlin.jvm.b.r<? super String, ? super Float, ? super PointF, ? super PointF, kotlin.u> rVar = this.i0;
        if (rVar == null) {
            return;
        }
        rVar.invoke(this.L, Float.valueOf(this.K), this.I, this.J);
    }

    public final void U(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        boolean z = false;
        if (!(getVisibility() == 0) || this.n0) {
            return;
        }
        if (event.getPointerCount() == 2) {
            this.B0.onTouchEvent(event);
            B(event);
            T();
            this.p0 = true;
        }
        int action = event.getAction();
        if (action == 0) {
            this.r0 = System.currentTimeMillis();
            this.k0 = false;
            this.s0 = N(event);
            this.w0 = event.getX();
            this.x0 = event.getY();
            if (event.getPointerCount() == 1) {
                if (event.getX() < this.m.x + (this.f10723i.getWidth() / 2) && event.getX() > this.m.x - (this.f10723i.getWidth() / 2) && event.getY() < this.m.y + (this.f10723i.getHeight() / 2) && event.getY() > this.m.y - (this.f10723i.getHeight() / 2)) {
                    z = true;
                }
                this.G = z;
            }
            this.V = this.K;
        } else if (action == 1) {
            if (this.G) {
                if (this.L.length() > 0) {
                    if (kotlin.jvm.internal.s.c(this.L, "photoItem")) {
                        us.pinguo.foundation.statistics.h.b.j0("scaling", "template_cutout_layer", "click");
                    } else {
                        us.pinguo.foundation.statistics.h.b.j0("scaling", "template_material_layer", "click");
                    }
                }
            }
            this.k0 = true;
            Z(null);
            this.E = true;
            this.G = false;
            this.l0 = false;
            this.T = null;
            this.s0 = null;
            this.o0 = false;
            this.p0 = false;
            this.u0 = false;
            invalidate();
        } else if (action == 2) {
            invalidate();
            if (Math.abs(event.getX() - this.w0) > this.v0 || Math.abs(event.getY() - this.x0) > this.v0) {
                this.u0 = true;
            }
            if (this.G && this.u0) {
                X(event);
                T();
            }
        }
        if (event.getPointerCount() == 1) {
            this.z0.onTouchEvent(event);
        }
    }

    public final void V(boolean z) {
        int i2 = z ? 0 : 8;
        setVisibility(i2);
        VdsAgent.onSetViewVisibility(this, i2);
    }

    public final void W() {
        if (getVisibility() == 0) {
            return;
        }
        V(true);
    }

    public final void a0(u0 canvasStatus) {
        kotlin.jvm.internal.s.h(canvasStatus, "canvasStatus");
        this.H.set(canvasStatus.e(), canvasStatus.d());
        this.N = canvasStatus.a();
        this.O = canvasStatus.b();
        invalidate();
    }

    public final void b0(String key, float f2, PointF rectCenter, PointF rectSize, u0 canvasStatus, boolean z, int i2) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(rectCenter, "rectCenter");
        kotlin.jvm.internal.s.h(rectSize, "rectSize");
        kotlin.jvm.internal.s.h(canvasStatus, "canvasStatus");
        if (i2 == 0) {
            this.L = key;
            this.M = key;
            if (!this.F.containsKey(key)) {
                this.F.put(this.L, new PointF(rectSize.x, rectSize.y));
            }
            if (this.k0) {
                this.K = f2;
                this.q0 = f2;
                this.I = rectCenter;
                this.J = rectSize;
                this.H.set(canvasStatus.e(), canvasStatus.d());
                this.N = canvasStatus.a();
                this.O = canvasStatus.b();
                Z(null);
                this.E = z;
                invalidate();
            }
        } else if (kotlin.jvm.internal.s.c(this.L, key)) {
            this.L = "";
            this.E = false;
            invalidate();
        }
    }

    public final void d0() {
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(z0.a()), null, null, new SelectRectAdjustView$updateSize$1(this, null), 3, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.L.length() == 0) {
            return;
        }
        if (this.n0) {
            this.A.setColor(Color.parseColor("#ffffff"));
            this.A.setAlpha(85);
            C(canvas);
        } else if (this.E) {
            D(canvas);
        } else if (this.l0 || this.m0) {
            this.A.setColor(Color.parseColor("#fab615"));
            this.A.setAlpha(255);
            C(canvas);
        }
    }

    public final void setCurrentKey(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.L = str;
    }

    public final void setFuntionClickListener(a aVar) {
        this.j0 = aVar;
    }

    public final void setLastSelectKey(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.M = str;
    }

    public final void setLongPressCallback(kotlin.jvm.b.r<? super PointF, ? super PointF, ? super PointF, ? super PointF, kotlin.u> rVar) {
        this.t0 = rVar;
    }

    public final void setOnLayerStatusChange(kotlin.jvm.b.r<? super String, ? super Float, ? super PointF, ? super PointF, kotlin.u> rVar) {
        this.i0 = rVar;
    }

    public final void setShowSizeRect(boolean z) {
        this.n0 = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectAdjustView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 5;
        this.b = 5;
        this.c = 0.03f;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10718d = us.pinguo.util.g.a(context2, 2.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.f10719e = us.pinguo.util.g.a(context3, 17.0f);
        this.f10724j = new PointF(0.0f, 0.0f);
        this.f10725k = new PointF(0.0f, 0.0f);
        this.f10726l = new PointF(0.0f, 0.0f);
        this.m = new PointF(0.0f, 0.0f);
        this.n = new PointF(0.0f, 0.0f);
        this.o = new PointF(0.0f, 0.0f);
        this.p = new PointF(0.0f, 0.0f);
        this.q = new PointF(0.0f, 0.0f);
        this.r = new PointF(0.0f, 0.0f);
        this.s = new PointF(0.0f, 0.0f);
        this.t = new PointF(0.0f, 0.0f);
        this.u = new PointF(0.0f, 0.0f);
        this.v = new PointF(0.0f, 0.0f);
        this.w = new PointF(0.0f, 0.0f);
        this.x = new PointF(0.0f, 0.0f);
        this.y = new PointF(0.0f, 0.0f);
        Paint paint = new Paint();
        this.z = paint;
        Paint paint2 = new Paint();
        this.A = paint2;
        Paint paint3 = new Paint();
        this.B = paint3;
        Paint paint4 = new Paint();
        this.C = paint4;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{8.0f, 4.0f}, 0.0f);
        this.D = dashPathEffect;
        this.F = new HashMap<>();
        this.H = new PointF(0.0f, 0.0f);
        this.L = "";
        this.M = "";
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.W = us.pinguo.util.g.a(context4, 59.0f);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.d0 = us.pinguo.util.g.a(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.e0 = us.pinguo.util.g.a(context6, 25.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f0 = us.pinguo.util.g.a(context7, 15.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.g0 = us.pinguo.util.g.a(context8, 1.0f);
        this.k0 = true;
        this.v0 = 5;
        this.w0 = -1.0f;
        this.x0 = -1.0f;
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        paint.setStrokeWidth(us.pinguo.util.g.a(context9, 1.0f));
        paint2.setColor(Color.parseColor("#fab615"));
        paint2.setStyle(Paint.Style.STROKE);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        paint2.setStrokeWidth(us.pinguo.util.g.a(context10, 1.0f));
        paint3.setColor(Color.parseColor("#ffffff"));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint4.setColor(Color.argb(255, 255, 255, 255));
        paint4.setStyle(Paint.Style.STROKE);
        Context context11 = getContext();
        kotlin.jvm.internal.s.g(context11, "context");
        paint4.setStrokeWidth(us.pinguo.util.g.a(context11, 1.0f));
        paint4.setPathEffect(dashPathEffect);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_tihuan);
        kotlin.jvm.internal.s.g(decodeResource, "decodeResource(context.r…rawable.edit_icon_tihuan)");
        this.f10720f = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_jingxiang);
        kotlin.jvm.internal.s.g(decodeResource2, "decodeResource(context.r…able.edit_icon_jingxiang)");
        this.f10721g = decodeResource2;
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_koutu);
        kotlin.jvm.internal.s.g(decodeResource3, "decodeResource(context.r…drawable.edit_icon_koutu)");
        this.f10722h = decodeResource3;
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_xuanzhuan);
        kotlin.jvm.internal.s.g(decodeResource4, "decodeResource(context.r…able.edit_icon_xuanzhuan)");
        this.f10723i = decodeResource4;
        c cVar = new c();
        this.y0 = cVar;
        this.z0 = new GestureDetector(getContext(), cVar);
        b bVar = new b();
        this.A0 = bVar;
        this.B0 = new ScaleGestureDetector(getContext(), bVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectRectAdjustView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = 5;
        this.b = 5;
        this.c = 0.03f;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10718d = us.pinguo.util.g.a(context2, 2.0f);
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.f10719e = us.pinguo.util.g.a(context3, 17.0f);
        this.f10724j = new PointF(0.0f, 0.0f);
        this.f10725k = new PointF(0.0f, 0.0f);
        this.f10726l = new PointF(0.0f, 0.0f);
        this.m = new PointF(0.0f, 0.0f);
        this.n = new PointF(0.0f, 0.0f);
        this.o = new PointF(0.0f, 0.0f);
        this.p = new PointF(0.0f, 0.0f);
        this.q = new PointF(0.0f, 0.0f);
        this.r = new PointF(0.0f, 0.0f);
        this.s = new PointF(0.0f, 0.0f);
        this.t = new PointF(0.0f, 0.0f);
        this.u = new PointF(0.0f, 0.0f);
        this.v = new PointF(0.0f, 0.0f);
        this.w = new PointF(0.0f, 0.0f);
        this.x = new PointF(0.0f, 0.0f);
        this.y = new PointF(0.0f, 0.0f);
        Paint paint = new Paint();
        this.z = paint;
        Paint paint2 = new Paint();
        this.A = paint2;
        Paint paint3 = new Paint();
        this.B = paint3;
        Paint paint4 = new Paint();
        this.C = paint4;
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{8.0f, 4.0f}, 0.0f);
        this.D = dashPathEffect;
        this.F = new HashMap<>();
        this.H = new PointF(0.0f, 0.0f);
        this.L = "";
        this.M = "";
        Context context4 = getContext();
        kotlin.jvm.internal.s.g(context4, "context");
        this.W = us.pinguo.util.g.a(context4, 59.0f);
        Context context5 = getContext();
        kotlin.jvm.internal.s.g(context5, "context");
        this.d0 = us.pinguo.util.g.a(context5, 12.0f);
        Context context6 = getContext();
        kotlin.jvm.internal.s.g(context6, "context");
        this.e0 = us.pinguo.util.g.a(context6, 25.0f);
        Context context7 = getContext();
        kotlin.jvm.internal.s.g(context7, "context");
        this.f0 = us.pinguo.util.g.a(context7, 15.0f);
        Context context8 = getContext();
        kotlin.jvm.internal.s.g(context8, "context");
        this.g0 = us.pinguo.util.g.a(context8, 1.0f);
        this.k0 = true;
        this.v0 = 5;
        this.w0 = -1.0f;
        this.x0 = -1.0f;
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.STROKE);
        Context context9 = getContext();
        kotlin.jvm.internal.s.g(context9, "context");
        paint.setStrokeWidth(us.pinguo.util.g.a(context9, 1.0f));
        paint2.setColor(Color.parseColor("#fab615"));
        paint2.setStyle(Paint.Style.STROKE);
        Context context10 = getContext();
        kotlin.jvm.internal.s.g(context10, "context");
        paint2.setStrokeWidth(us.pinguo.util.g.a(context10, 1.0f));
        paint3.setColor(Color.parseColor("#ffffff"));
        paint3.setStyle(Paint.Style.FILL);
        paint3.setAntiAlias(true);
        paint4.setColor(Color.argb(255, 255, 255, 255));
        paint4.setStyle(Paint.Style.STROKE);
        Context context11 = getContext();
        kotlin.jvm.internal.s.g(context11, "context");
        paint4.setStrokeWidth(us.pinguo.util.g.a(context11, 1.0f));
        paint4.setPathEffect(dashPathEffect);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_tihuan);
        kotlin.jvm.internal.s.g(decodeResource, "decodeResource(context.r…rawable.edit_icon_tihuan)");
        this.f10720f = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_jingxiang);
        kotlin.jvm.internal.s.g(decodeResource2, "decodeResource(context.r…able.edit_icon_jingxiang)");
        this.f10721g = decodeResource2;
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_koutu);
        kotlin.jvm.internal.s.g(decodeResource3, "decodeResource(context.r…drawable.edit_icon_koutu)");
        this.f10722h = decodeResource3;
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.edit_icon_xuanzhuan);
        kotlin.jvm.internal.s.g(decodeResource4, "decodeResource(context.r…able.edit_icon_xuanzhuan)");
        this.f10723i = decodeResource4;
        c cVar = new c();
        this.y0 = cVar;
        this.z0 = new GestureDetector(getContext(), cVar);
        b bVar = new b();
        this.A0 = bVar;
        this.B0 = new ScaleGestureDetector(getContext(), bVar);
    }
}
