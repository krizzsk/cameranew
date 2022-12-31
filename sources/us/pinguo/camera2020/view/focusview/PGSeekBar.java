package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.foundation.utils.n0;
/* compiled from: PGSeekBar.kt */
/* loaded from: classes3.dex */
public abstract class PGSeekBar extends View {
    private float a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f9419d;

    /* renamed from: e  reason: collision with root package name */
    private b f9420e;

    /* renamed from: f  reason: collision with root package name */
    private a f9421f;

    /* renamed from: g  reason: collision with root package name */
    private float f9422g;

    /* renamed from: h  reason: collision with root package name */
    private float f9423h;

    /* renamed from: i  reason: collision with root package name */
    private float f9424i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f9425j;

    /* renamed from: k  reason: collision with root package name */
    private int f9426k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f9427l;
    private Paint m;
    private int n;
    private float o;
    protected GestureDetector p;
    private Scroller q;
    private boolean r;
    private boolean s;

    /* compiled from: PGSeekBar.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a(boolean z);
    }

    /* compiled from: PGSeekBar.kt */
    /* loaded from: classes3.dex */
    public interface b {
        void b();

        void d(PGSeekBar pGSeekBar, float f2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: PGSeekBar.kt */
    /* loaded from: classes3.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ PGSeekBar a;

        public c(PGSeekBar this$0) {
            s.h(this$0, "this$0");
            this.a = this$0;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (this.a.n()) {
                PGSeekBar pGSeekBar = this.a;
                pGSeekBar.t(pGSeekBar.e() + f3);
            } else {
                PGSeekBar pGSeekBar2 = this.a;
                pGSeekBar2.t(pGSeekBar2.e() - f2);
            }
            PGSeekBar pGSeekBar3 = this.a;
            pGSeekBar3.t(pGSeekBar3.f(pGSeekBar3.e()));
            if (this.a.c() != null) {
                if (!(this.a.j() == 0.0f)) {
                    PGSeekBar pGSeekBar4 = this.a;
                    pGSeekBar4.u(pGSeekBar4.e() / this.a.j());
                    b c = this.a.c();
                    if (c != null) {
                        PGSeekBar pGSeekBar5 = this.a;
                        c.d(pGSeekBar5, pGSeekBar5.k());
                    }
                }
            }
            this.a.invalidate();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            float x;
            if (this.a.n()) {
                s.e(motionEvent);
                x = (this.a.j() - this.a.e()) - motionEvent.getY();
                Scroller h2 = this.a.h();
                if (h2 != null) {
                    h2.startScroll(0, (int) this.a.e(), 0, (int) x, 400);
                }
                us.pinguo.common.log.a.e("PGSeekBar.onSingleTapUp.e.y:" + motionEvent.getY() + "  markerOffset:" + this.a.e() + " distance:" + x + " dest:" + (this.a.e() + x), new Object[0]);
            } else {
                s.e(motionEvent);
                x = motionEvent.getX() - this.a.e();
                Scroller h3 = this.a.h();
                if (h3 != null) {
                    h3.startScroll(0, (int) this.a.e(), 0, (int) (motionEvent.getX() - this.a.e()), 400);
                }
            }
            PGSeekBar pGSeekBar = this.a;
            float f2 = pGSeekBar.f(pGSeekBar.e() + x);
            if (this.a.c() != null) {
                if (!(this.a.j() == 0.0f)) {
                    PGSeekBar pGSeekBar2 = this.a;
                    pGSeekBar2.u(f2 / pGSeekBar2.j());
                    b c = this.a.c();
                    if (c != null) {
                        PGSeekBar pGSeekBar3 = this.a;
                        c.d(pGSeekBar3, pGSeekBar3.k());
                    }
                    b c2 = this.a.c();
                    if (c2 != null) {
                        c2.b();
                    }
                    this.a.o();
                }
            }
            this.a.invalidate();
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGSeekBar(Context context) {
        this(context, null);
        s.h(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a a() {
        return this.f9421f;
    }

    protected final GestureDetector b() {
        GestureDetector gestureDetector = this.p;
        if (gestureDetector != null) {
            return gestureDetector;
        }
        s.z("gestureDetector");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b c() {
        return this.f9420e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Drawable d() {
        return this.f9425j;
    }

    protected final float e() {
        return this.f9422g;
    }

    protected final float f(float f2) {
        if (f2 <= 0.0f) {
            f2 = 0.0f;
        }
        float f3 = this.b;
        return f2 >= f3 ? f3 : f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float g() {
        return this.f9423h;
    }

    protected final Scroller h() {
        return this.q;
    }

    protected c i() {
        return new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float j() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float k() {
        return this.a;
    }

    public void l() {
        this.q = new Scroller(getContext());
        r(new GestureDetector(getContext(), i()));
        this.f9427l.setAntiAlias(true);
        int i2 = this.f9426k;
        if (i2 != 0) {
            this.f9427l.setColor(i2);
        } else {
            Drawable drawable = this.f9425j;
            if (drawable != null) {
                s.e(drawable);
                this.f9423h = drawable.getIntrinsicHeight() / 2;
            } else {
                throw new Throwable("both markerColor and markerDrawable have no value");
            }
        }
        this.f9427l.setStrokeWidth(this.f9424i);
        this.f9427l.setStyle(Paint.Style.FILL_AND_STROKE);
        this.m.setAntiAlias(true);
        this.m.setColor(this.n);
        this.m.setAlpha(200);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean m() {
        return this.s;
    }

    protected final boolean n() {
        return this.r;
    }

    public void o() {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float paddingTop;
        float f3;
        if (canvas == null) {
            return;
        }
        if (((int) this.b) == 0) {
            if (this.r) {
                float f4 = 2;
                this.b = (((getHeight() - getPaddingTop()) - getPaddingBottom()) - this.f9424i) - (this.f9423h * f4);
                this.c = ((getHeight() - getPaddingBottom()) - (this.f9424i / f4)) - this.f9423h;
                this.f9419d = getPaddingTop() + (this.f9424i / f4) + this.f9423h;
            } else {
                float f5 = 2;
                this.b = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f9424i) - (this.f9423h * f5);
                this.c = getPaddingLeft() + (this.f9424i / f5) + this.f9423h;
                this.f9419d = ((getWidth() - getPaddingRight()) - (this.f9424i / f5)) - this.f9423h;
            }
            this.f9422g = this.a * this.b;
        }
        if (this.s) {
            if (this.r) {
                float f6 = 2;
                float paddingLeft = ((getPaddingLeft() + (this.f9424i / f6)) + this.f9423h) - (this.o / f6);
                float f7 = this.f9424i;
                float f8 = this.f9423h;
                float paddingLeft2 = getPaddingLeft() + (f7 / f6) + f8 + (this.o / f6);
                float f9 = ((this.c - this.f9422g) - f7) - (f8 * 1.5f);
                float f10 = this.f9419d;
                if (f9 > f10) {
                    canvas.drawRect(paddingLeft, f10, paddingLeft2, f9, this.m);
                }
                float f11 = f9 + this.f9424i + (this.f9423h * 3);
                float f12 = this.c;
                if (f11 <= f12) {
                    canvas.drawRect(paddingLeft, f11, paddingLeft2, f12, this.m);
                }
            } else {
                float f13 = 2;
                float paddingTop2 = ((getPaddingTop() + (this.f9424i / f13)) + this.f9423h) - (this.o / f13);
                float f14 = this.f9423h;
                float paddingTop3 = getPaddingTop() + (this.f9424i / f13) + f14 + (this.o / f13);
                float f15 = this.c;
                float f16 = (float) (((this.f9422g + f15) - (f3 * f13)) - (f14 * 1.5d));
                if (f16 > f15) {
                    canvas.drawRect(f15, paddingTop2, f16, paddingTop3, this.m);
                }
                float f17 = f16 + this.f9424i + (this.f9423h * 4);
                float f18 = this.f9419d;
                if (f17 <= f18) {
                    canvas.drawRect(f17, paddingTop2, f18, paddingTop3, this.m);
                }
            }
        }
        if (this.r) {
            f2 = getPaddingLeft() + (this.f9424i / 2) + this.f9423h;
            paddingTop = this.c - this.f9422g;
        } else {
            f2 = this.c + this.f9422g;
            paddingTop = this.f9423h + getPaddingTop() + (this.f9424i / 2);
        }
        if (this.f9426k != 0) {
            canvas.drawCircle(f2, paddingTop, this.f9423h, this.f9427l);
        } else {
            Drawable drawable = this.f9425j;
            if (drawable != null) {
                float f19 = this.f9423h;
                int i2 = (int) (f2 - f19);
                int i3 = (int) (paddingTop - f19);
                int i4 = (int) (f2 + f19);
                int i5 = (int) (paddingTop + f19);
                if (drawable != null) {
                    drawable.setBounds(i2, i3, i4, i5);
                }
                Drawable drawable2 = this.f9425j;
                if (drawable2 != null) {
                    drawable2.draw(canvas);
                }
            }
        }
        Scroller scroller = this.q;
        if (scroller != null) {
            s.e(scroller);
            if (scroller.computeScrollOffset()) {
                Scroller scroller2 = this.q;
                s.e(scroller2);
                float currY = scroller2.getCurrY();
                this.f9422g = currY;
                this.f9422g = f(currY);
                invalidate();
            }
        }
        super.onDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.r) {
            if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
                int size = View.MeasureSpec.getSize(i3);
                float f2 = this.f9423h;
                float f3 = this.f9424i;
                float f4 = 2;
                float f5 = this.o;
                int i4 = (f2 + f3) * f4 > f5 ? (int) ((f2 + f3) * f4) : (int) f5;
                Drawable drawable = this.f9425j;
                if (drawable != null) {
                    s.e(drawable);
                    if (i4 <= drawable.getIntrinsicWidth()) {
                        Drawable drawable2 = this.f9425j;
                        s.e(drawable2);
                        i4 = drawable2.getIntrinsicWidth();
                    }
                }
                setMeasuredDimension(i4 + getPaddingLeft() + getPaddingRight(), size);
                return;
            }
            super.onMeasure(i2, i3);
        } else if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            int size2 = View.MeasureSpec.getSize(i2);
            float f6 = this.f9423h;
            float f7 = this.f9424i;
            float f8 = 2;
            float f9 = this.o;
            int i5 = (f6 + f7) * f8 > f9 ? (int) ((f6 + f7) * f8) : (int) f9;
            Drawable drawable3 = this.f9425j;
            if (drawable3 != null) {
                s.e(drawable3);
                if (i5 <= drawable3.getIntrinsicHeight()) {
                    Drawable drawable4 = this.f9425j;
                    s.e(drawable4);
                    i5 = drawable4.getIntrinsicHeight();
                }
            }
            setMeasuredDimension(size2, i5 + getPaddingTop() + getPaddingBottom());
        } else {
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent != null && motionEvent.getActionMasked() == 1) {
            z = true;
        }
        if (z) {
            o();
        }
        return b().onTouchEvent(motionEvent);
    }

    public final void p() {
        this.a = 0.5f;
        this.f9422g = this.b * 0.5f;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(boolean z) {
        this.s = z;
    }

    protected final void r(GestureDetector gestureDetector) {
        s.h(gestureDetector, "<set-?>");
        this.p = gestureDetector;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(boolean z) {
        this.r = z;
    }

    public void setCurrentSeekRate(float f2) {
        this.a = f2;
        if (f2 > 1.0f) {
            this.a = 1.0f;
        } else if (f2 < 0.0f) {
            this.a = 0.0f;
        }
        this.f9422g = this.b * this.a;
        invalidate();
    }

    public final void setOnDrawListener(a drawListener) {
        s.h(drawListener, "drawListener");
        this.f9421f = drawListener;
    }

    public final void setOnSeekBarChangeListener(b listener) {
        s.h(listener, "listener");
        this.f9420e = listener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t(float f2) {
        this.f9422g = f2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u(float f2) {
        this.a = f2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PGSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = 0.5f;
        this.f9423h = n0.b(6.0f);
        this.f9424i = n0.b(1.5f);
        this.f9427l = new Paint();
        this.m = new Paint();
        this.o = n0.b(2.0f);
        this.r = true;
        this.s = true;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PGSeekBar, i2, 0);
        s.g(obtainStyledAttributes, "context.theme.obtainStyl…SeekBar, defStyleAttr, 0)");
        try {
            this.f9426k = obtainStyledAttributes.getColor(R.styleable.PGSeekBar_markerBackground, 0);
        } catch (Exception unused) {
            this.f9425j = obtainStyledAttributes.getDrawable(R.styleable.PGSeekBar_markerBackground);
        }
        this.n = obtainStyledAttributes.getColor(R.styleable.PGSeekBar_lineColor, -1);
        l();
    }
}
