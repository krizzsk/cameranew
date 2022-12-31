package us.pinguo.camera2020.view.focusview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.view.focusview.PGFocusRect;
import us.pinguo.camera2020.view.focusview.PGSeekBar;
/* compiled from: PGFocusView.kt */
/* loaded from: classes3.dex */
public final class PGFocusView extends RelativeLayout {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private final us.pinguo.camera2020.view.focusview.c G;
    private long H;
    public Map<Integer, View> a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f9410d;

    /* renamed from: e  reason: collision with root package name */
    private int f9411e;

    /* renamed from: f  reason: collision with root package name */
    private int f9412f;

    /* renamed from: g  reason: collision with root package name */
    private int f9413g;

    /* renamed from: h  reason: collision with root package name */
    private int f9414h;

    /* renamed from: i  reason: collision with root package name */
    private int f9415i;

    /* renamed from: j  reason: collision with root package name */
    private float f9416j;

    /* renamed from: k  reason: collision with root package name */
    private float f9417k;

    /* renamed from: l  reason: collision with root package name */
    private float f9418l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private float t;
    private boolean u;
    private us.pinguo.camera2020.view.focusview.a v;
    private float w;
    private boolean x;
    private float y;
    private float z;

    /* compiled from: PGFocusView.kt */
    /* loaded from: classes3.dex */
    public static final class a implements PGSeekBar.b {
        a() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
        public void b() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
        public void d(PGSeekBar seekBar, float f2) {
            s.h(seekBar, "seekBar");
        }
    }

    /* compiled from: PGFocusView.kt */
    /* loaded from: classes3.dex */
    public static final class b implements PGSeekBar.b {
        b() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
        public void b() {
            PGFocusView.this.W();
            if (((PGFocusCircle) PGFocusView.this.a(R.id.pg_focus_circle)).getVisibility() == 0 || ((PGFocusRect) PGFocusView.this.a(R.id.pg_focus_rect)).getVisibility() == 0) {
                PGFocusView.this.j0();
            }
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
        public void d(PGSeekBar seekBar, float f2) {
            s.h(seekBar, "seekBar");
            us.pinguo.camera2020.view.focusview.a aVar = PGFocusView.this.v;
            if (aVar != null) {
                aVar.E(f2);
            }
            PGFocusView.this.W();
        }
    }

    /* compiled from: PGFocusView.kt */
    /* loaded from: classes3.dex */
    public static final class c implements PGSeekBar.a {
        c() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.a
        public void a(boolean z) {
            if (z) {
                PGFocusView.this.z();
            }
        }
    }

    /* compiled from: PGFocusView.kt */
    /* loaded from: classes3.dex */
    public static final class d implements PGFocusRect.a {
        d() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGFocusRect.a
        public void a() {
            if (((PGBlurView) PGFocusView.this.a(R.id.pg_focus_blur)).getVisibility() != 0) {
                PGFocusView.this.j0();
            }
            if (((PGFocusRect) PGFocusView.this.a(R.id.pg_focus_rect)).getVisibility() != 0) {
                return;
            }
            PGFocusView.this.m0();
            PGFocusView.this.k0();
            PGFocusView.this.n0();
        }

        @Override // us.pinguo.camera2020.view.focusview.PGFocusRect.a
        public void b() {
        }

        @Override // us.pinguo.camera2020.view.focusview.PGFocusRect.a
        public void c(int i2) {
            PGFocusView.this.E = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusView(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.m = -1;
        this.o = true;
        this.p = true;
        this.y = 1.0f;
        this.z = 1.0f;
        this.A = 1.0f;
        this.B = 1.0f;
        this.G = new us.pinguo.camera2020.view.focusview.c(this);
    }

    private final boolean A() {
        int i2 = R.id.pg_focus_exposure;
        if (((VerticalSeekBar) a(i2)) == null || ((VerticalSeekBar) a(i2)).getVisibility() != 0) {
            return false;
        }
        VerticalSeekBar verticalSeekBar = (VerticalSeekBar) a(i2);
        verticalSeekBar.setVisibility(4);
        VdsAgent.onSetViewVisibility(verticalSeekBar, 4);
        return true;
    }

    private final boolean B() {
        int i2 = R.id.pg_focus_circle;
        if (((PGFocusCircle) a(i2)) == null || ((PGFocusCircle) a(i2)).getVisibility() != 0) {
            return false;
        }
        PGFocusCircle pGFocusCircle = (PGFocusCircle) a(i2);
        pGFocusCircle.setVisibility(4);
        VdsAgent.onSetViewVisibility(pGFocusCircle, 4);
        return true;
    }

    private final boolean C() {
        int i2 = R.id.pg_focus_distance;
        if (((HorizontalSeekBar) a(i2)) == null || ((HorizontalSeekBar) a(i2)).getVisibility() != 0) {
            return false;
        }
        HorizontalSeekBar horizontalSeekBar = (HorizontalSeekBar) a(i2);
        horizontalSeekBar.setVisibility(4);
        VdsAgent.onSetViewVisibility(horizontalSeekBar, 4);
        return true;
    }

    private final boolean D() {
        int i2 = R.id.pg_focus_lock_tips;
        if (((TextView) a(i2)) == null || ((TextView) a(i2)).getVisibility() != 0) {
            return false;
        }
        TextView textView = (TextView) a(i2);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        return true;
    }

    private final boolean E() {
        int i2 = R.id.pg_focus_rect;
        if (((PGFocusRect) a(i2)) == null || ((PGFocusRect) a(i2)).getVisibility() != 0) {
            return false;
        }
        PGFocusRect pGFocusRect = (PGFocusRect) a(i2);
        pGFocusRect.setVisibility(4);
        VdsAgent.onSetViewVisibility(pGFocusRect, 4);
        return true;
    }

    private final void F() {
        E();
        D();
        C();
        y();
    }

    private final void H() {
        ((HorizontalSeekBar) a(R.id.pg_focus_distance)).setOnSeekBarChangeListener(new a());
    }

    private final void I() {
        int i2 = R.id.pg_focus_exposure;
        ((VerticalSeekBar) a(i2)).setOnSeekBarChangeListener(new b());
        ((VerticalSeekBar) a(i2)).setOnDrawListener(new c());
    }

    private final void J() {
        I();
        H();
    }

    private final void K(boolean z) {
        if (this.x) {
            return;
        }
        float f2 = 2;
        float measuredWidth = getMeasuredWidth() / f2;
        this.f9416j = measuredWidth;
        this.s = measuredWidth;
        float measuredHeight = getMeasuredHeight() / f2;
        this.f9417k = measuredHeight;
        this.t = measuredHeight;
        this.x = z;
    }

    private final void Q() {
        int i2 = R.id.pg_focus_blur;
        ((PGBlurView) a(i2)).getMeasuredWidth();
        ((PGBlurView) a(i2)).getMeasuredHeight();
    }

    private final void R() {
        int i2 = R.id.pg_focus_exposure;
        this.f9410d = ((VerticalSeekBar) a(i2)).getMeasuredWidth();
        this.f9411e = ((VerticalSeekBar) a(i2)).getMeasuredHeight();
    }

    private final void S() {
        int i2 = R.id.pg_focus_circle;
        this.b = ((PGFocusCircle) a(i2)).getMeasuredWidth();
        this.c = ((PGFocusCircle) a(i2)).getMeasuredHeight();
    }

    private final void T() {
        int i2 = R.id.pg_focus_distance;
        this.f9412f = ((HorizontalSeekBar) a(i2)).getMeasuredWidth();
        this.f9413g = ((HorizontalSeekBar) a(i2)).getMeasuredHeight();
    }

    private final void U() {
        int i2 = R.id.pg_focus_rect;
        this.f9414h = ((PGFocusRect) a(i2)).getMeasuredWidth();
        this.f9415i = ((PGFocusRect) a(i2)).getMeasuredHeight();
    }

    private final void V() {
        s(t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W() {
        this.G.removeMessages(2);
    }

    private final void Y(float f2) {
        Z(f2);
        ((PGBlurView) a(R.id.pg_focus_blur)).setScale(f2);
        s(f2);
    }

    private final void Z(float f2) {
        int i2 = this.F;
        if (i2 == 2) {
            this.z = f2;
        } else if (i2 == 3) {
            this.y = f2;
        }
    }

    private final void a0(float f2, float f3) {
        ((PGBlurView) a(R.id.pg_focus_blur)).j(f2, f3);
    }

    private final void b0(float f2, float f3) {
        int i2;
        float f4 = this.b / 2;
        int i3 = this.f9410d;
        float f5 = (f2 + f4) - (i3 / 3);
        float f6 = (f3 - f4) - ((i2 - this.c) / 2);
        float f7 = i3 + f5;
        float f8 = this.f9411e + f6;
        if (f2 > getWidth() / 2) {
            float f9 = f2 - f4;
            int i4 = this.f9410d;
            f5 = (i4 / 3) + (f9 - i4);
            f7 = f5 + i4;
        }
        ((VerticalSeekBar) a(R.id.pg_focus_exposure)).layout((int) f5, (int) f6, (int) f7, (int) f8);
    }

    private final void c0(float f2, float f3) {
        int i2 = this.b;
        float f4 = f2 - (i2 / 2);
        int i3 = this.c;
        float f5 = f3 - (i3 / 2);
        ((PGFocusCircle) a(R.id.pg_focus_circle)).layout((int) f4, (int) f5, (int) (i2 + f4), (int) (i3 + f5));
    }

    private final void d0(float f2, float f3) {
        int i2 = this.f9412f;
        float f4 = f2 - (i2 / 2);
        int i3 = this.f9413g;
        float f5 = f3 + (i3 / 2);
        ((HorizontalSeekBar) a(R.id.pg_focus_distance)).layout((int) f4, (int) f5, (int) (i2 + f4), (int) (i3 + f5));
    }

    private final void e0(float f2, float f3) {
        int i2 = this.f9414h;
        float f4 = f2 - (i2 / 2);
        int i3 = this.f9415i;
        float f5 = f3 - (i3 / 2);
        ((PGFocusRect) a(R.id.pg_focus_rect)).layout((int) f4, (int) f5, (int) (i2 + f4), (int) (i3 + f5));
    }

    private final void f0(float f2, float f3) {
        this.f9416j = f2;
        this.f9417k = f3;
    }

    private final void g0(float f2) {
        int i2 = this.F;
        if (i2 == 2) {
            this.A = f2;
        } else if (i2 == 3) {
            this.B = f2;
        }
    }

    private final void h0(float f2, float f3) {
        c0(f2, f3);
        a0(f2, f3);
        b0(f2, f3);
        e0(f2, f3);
        d0(f2, f3);
        f0(f2, f3);
        invalidate();
    }

    private final void i0() {
        int i2 = R.id.pg_focus_circle;
        ((PGFocusCircle) a(i2)).setIsDrawRect(true);
        ((PGFocusCircle) a(i2)).invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        if (this.o) {
            int i2 = R.id.pg_focus_exposure;
            if (((VerticalSeekBar) a(i2)) == null || ((VerticalSeekBar) a(i2)).getVisibility() == 0) {
                return;
            }
            ((VerticalSeekBar) a(i2)).v();
            VerticalSeekBar verticalSeekBar = (VerticalSeekBar) a(i2);
            verticalSeekBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(verticalSeekBar, 0);
        }
    }

    private final void l0() {
        if (this.n) {
            u0();
        }
        int i2 = R.id.pg_focus_circle;
        ((PGFocusCircle) a(i2)).setIsDrawRect(true);
        ((PGFocusCircle) a(i2)).setFocusState(Integer.valueOf(PGFocusShape.q.a()));
        if (((PGFocusCircle) a(i2)) == null || ((PGFocusCircle) a(i2)).getVisibility() == 0) {
            return;
        }
        PGFocusCircle pGFocusCircle = (PGFocusCircle) a(i2);
        pGFocusCircle.setVisibility(0);
        VdsAgent.onSetViewVisibility(pGFocusCircle, 0);
    }

    private final void n() {
        int i2 = R.id.pg_focus_circle;
        if (((PGFocusCircle) a(i2)) != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat((PGFocusCircle) a(i2), "scaleX", 1.0f, 0.7f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(300L);
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat((PGFocusCircle) a(i2), "scaleY", 1.0f, 0.7f);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.setDuration(300L);
            ofFloat2.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        TextView textView = (TextView) a(R.id.pg_focus_lock_tips);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
    }

    private final void o0() {
        int i2 = R.id.pg_focus_rect;
        if (((PGFocusRect) a(i2)) == null || ((PGFocusRect) a(i2)).getVisibility() == 0) {
            return;
        }
        PGFocusRect pGFocusRect = (PGFocusRect) a(i2);
        pGFocusRect.setVisibility(0);
        VdsAgent.onSetViewVisibility(pGFocusRect, 0);
    }

    private final void p0() {
        o0();
        C();
        i0();
        B();
        A();
    }

    private final void q0() {
        l0();
    }

    private final void r0() {
        ((PGFocusCircle) a(R.id.pg_focus_circle)).t();
    }

    private final float s(float f2) {
        float f3;
        float f4;
        float f5 = ((PGBlurView) a(R.id.pg_focus_blur)).f();
        int i2 = this.F;
        if (i2 == 2) {
            f3 = f5 * f2;
            f4 = this.f9418l / 2;
        } else if (i2 != 3) {
            return 0.0f;
        } else {
            f3 = f5 * f2;
            f4 = this.f9418l;
        }
        return f3 / f4;
    }

    private final void s0() {
        int i2 = R.id.pg_focus_rect;
        if (((PGFocusRect) a(i2)).getVisibility() != 0) {
            return;
        }
        ((PGFocusRect) a(i2)).t();
        ((PGFocusRect) a(i2)).setAnimationStateListener(new d());
    }

    private final float t() {
        int i2 = this.F;
        if (i2 == 2) {
            return this.z;
        }
        if (i2 == 3) {
            return this.y;
        }
        return 1.0f;
    }

    private final void t0() {
        n();
        A();
        ((PGBlurView) a(R.id.pg_focus_blur)).c(t());
    }

    private final float u() {
        int i2 = this.F;
        if (i2 == 2) {
            return this.A;
        }
        if (i2 == 3) {
            return this.B;
        }
        return 1.0f;
    }

    private final void u0() {
        n();
        A();
        ((PGBlurView) a(R.id.pg_focus_blur)).d(t());
    }

    public static /* synthetic */ void x(PGFocusView pGFocusView, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        pGFocusView.w(z);
    }

    private final void y() {
        int i2 = R.id.pg_focus_circle;
        ((PGFocusCircle) a(i2)).setIsDrawRect(false);
        ((PGFocusCircle) a(i2)).invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z() {
        int i2 = R.id.pg_focus_blur;
        if (((PGBlurView) a(i2)) == null || ((PGBlurView) a(i2)).getVisibility() != 0) {
            return false;
        }
        PGBlurView pGBlurView = (PGBlurView) a(i2);
        pGBlurView.setVisibility(4);
        VdsAgent.onSetViewVisibility(pGBlurView, 4);
        return true;
    }

    public final void G(long j2) {
        us.pinguo.camera2020.view.focusview.c cVar = this.G;
        if (cVar == null) {
            return;
        }
        cVar.removeMessages(2);
        if (j2 == 0) {
            this.G.sendEmptyMessage(2);
        } else {
            this.G.sendEmptyMessageDelayed(2, j2);
        }
    }

    public final boolean L() {
        return ((PGFocusCircle) a(R.id.pg_focus_circle)).getVisibility() == 0;
    }

    public final boolean M() {
        return this.q && P();
    }

    public final void N(boolean z) {
        this.o = z;
    }

    public final boolean O() {
        return this.p;
    }

    public final boolean P() {
        PGFocusCircle pg_focus_circle = (PGFocusCircle) a(R.id.pg_focus_circle);
        s.g(pg_focus_circle, "pg_focus_circle");
        if (pg_focus_circle.getVisibility() == 0) {
            return true;
        }
        VerticalSeekBar pg_focus_exposure = (VerticalSeekBar) a(R.id.pg_focus_exposure);
        s.g(pg_focus_exposure, "pg_focus_exposure");
        if (pg_focus_exposure.getVisibility() == 0) {
            return true;
        }
        PGFocusRect pg_focus_rect = (PGFocusRect) a(R.id.pg_focus_rect);
        s.g(pg_focus_rect, "pg_focus_rect");
        if (pg_focus_rect.getVisibility() == 0) {
            return true;
        }
        TextView pg_focus_lock_tips = (TextView) a(R.id.pg_focus_lock_tips);
        s.g(pg_focus_lock_tips, "pg_focus_lock_tips");
        if (pg_focus_lock_tips.getVisibility() == 0) {
            return true;
        }
        HorizontalSeekBar pg_focus_distance = (HorizontalSeekBar) a(R.id.pg_focus_distance);
        s.g(pg_focus_distance, "pg_focus_distance");
        if (pg_focus_distance.getVisibility() == 0) {
            return true;
        }
        PGBlurView pg_focus_blur = (PGBlurView) a(R.id.pg_focus_blur);
        s.g(pg_focus_blur, "pg_focus_blur");
        return pg_focus_blur.getVisibility() == 0;
    }

    public final void X() {
        if (this.o) {
            ((VerticalSeekBar) a(R.id.pg_focus_exposure)).p();
        }
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void h(float f2) {
        this.w -= f2;
        ((PGBlurView) a(R.id.pg_focus_blur)).setRotate(this.w);
    }

    public final void i() {
        W();
        A();
    }

    public final void j() {
        k0();
    }

    public final void j0() {
        int i2 = R.id.pg_focus_blur;
        if (((PGBlurView) a(i2)) == null) {
            return;
        }
        ((PGBlurView) a(i2)).h();
        if (this.q && ((PGBlurView) a(i2)).getVisibility() != 0) {
            PGBlurView pGBlurView = (PGBlurView) a(i2);
            pGBlurView.setVisibility(0);
            VdsAgent.onSetViewVisibility(pGBlurView, 0);
            ObjectAnimator.ofFloat((PGBlurView) a(i2), "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
        if (this.q) {
            Y(t());
        }
    }

    public final boolean k(float f2) {
        if (P() && this.q) {
            Y(Math.max(0.7f, Math.min(f2 * u(), 2.0f)));
            g0(t());
            return true;
        }
        return false;
    }

    public final void l() {
        W();
        A();
    }

    public final void m() {
        g0(t());
        if (this.n) {
            u0();
        }
        k0();
    }

    public final void m0() {
        if (this.r) {
            int i2 = R.id.pg_focus_distance;
            if (((HorizontalSeekBar) a(i2)) == null || ((HorizontalSeekBar) a(i2)).getVisibility() == 0) {
                return;
            }
            HorizontalSeekBar horizontalSeekBar = (HorizontalSeekBar) a(i2);
            horizontalSeekBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(horizontalSeekBar, 0);
            ObjectAnimator.ofFloat((HorizontalSeekBar) a(i2), "alpha", 0.2f, 1.0f).setDuration(300L).start();
        }
    }

    public final void o() {
        if (this.p) {
            setVisibility(0);
            VdsAgent.onSetViewVisibility(this, 0);
            W();
            this.m = 2;
            p0();
            h0(this.s, this.t);
            if (this.q) {
                ((PGBlurView) a(R.id.pg_focus_blur)).h();
                V();
            }
            s0();
            us.pinguo.camera2020.view.focusview.a aVar = this.v;
            if (aVar == null) {
                return;
            }
            aVar.n(this.s, this.t, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        J();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        h0(this.s, this.t);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f9418l = (float) Math.hypot(measuredHeight, measuredWidth);
        S();
        Q();
        R();
        T();
        U();
        if (this.x) {
            this.x = measuredWidth == this.C && measuredHeight == this.D;
        }
        this.C = measuredWidth;
        this.D = measuredHeight;
        K(false);
    }

    public final void p() {
        if ((this.u && ((PGFocusCircle) a(R.id.pg_focus_circle)).getVisibility() == 0) || ((PGBlurView) a(R.id.pg_focus_blur)).getVisibility() == 0) {
            this.m = 3;
            W();
        }
    }

    public final void q() {
        setVisibility(0);
        VdsAgent.onSetViewVisibility(this, 0);
        K(true);
        this.m = 1;
        h0(this.s, this.t);
        F();
        W();
        q0();
        k0();
        r0();
        j0();
        this.u = false;
        us.pinguo.camera2020.view.focusview.a aVar = this.v;
        if (aVar != null) {
            aVar.n(this.s, this.t, getWidth(), getHeight());
        }
        this.H = SystemClock.elapsedRealtime();
    }

    public final void r(float f2, float f3) {
        int i2 = R.id.pg_focus_circle;
        if ((((PGFocusCircle) a(i2)).getVisibility() == 0 || ((PGBlurView) a(R.id.pg_focus_blur)).getVisibility() == 0) && this.u) {
            int i3 = this.m;
            if (i3 == 3 || i3 == 1) {
                h0(f2, f3);
                ((PGFocusCircle) a(i2)).setTouchDownPaintSize();
                if (this.n) {
                    return;
                }
                this.n = true;
                t0();
            }
        }
    }

    public final void setDistanceSeekValue(float f2) {
        if (this.r) {
            ((HorizontalSeekBar) a(R.id.pg_focus_distance)).setCurrentSeekRate(f2);
        }
    }

    public final void setExposureSeekRate(float f2) {
        if (this.o) {
            ((VerticalSeekBar) a(R.id.pg_focus_exposure)).setCurrentSeekRate(f2);
        }
    }

    public final void setFocusViewCurrentPosition(float f2, float f3) {
        this.x = true;
        this.s = f2;
        this.t = f3;
    }

    public final void setIFocusViewCallBack(us.pinguo.camera2020.view.focusview.a focusViewCallBack) {
        s.h(focusViewCallBack, "focusViewCallBack");
        this.v = focusViewCallBack;
    }

    public final void setSupportFocus(boolean z) {
        this.p = z;
    }

    public final long v() {
        return Math.abs(SystemClock.elapsedRealtime() - this.H);
    }

    public final void w(boolean z) {
        us.pinguo.camera2020.view.focusview.a aVar;
        boolean B = B();
        boolean A = A();
        boolean z2 = z();
        boolean E = E();
        boolean D = D();
        if ((B || A || z2 || E || D) && z && (aVar = this.v) != null) {
            aVar.l();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.m = -1;
        this.o = true;
        this.p = true;
        this.y = 1.0f;
        this.z = 1.0f;
        this.A = 1.0f;
        this.B = 1.0f;
        this.G = new us.pinguo.camera2020.view.focusview.c(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        this.m = -1;
        this.o = true;
        this.p = true;
        this.y = 1.0f;
        this.z = 1.0f;
        this.A = 1.0f;
        this.B = 1.0f;
        this.G = new us.pinguo.camera2020.view.focusview.c(this);
    }
}
