package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.gesture.a;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.BlurringType;
import us.pinguo.edit2020.bean.l0;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.BlurringOvalView;
import us.pinguo.edit2020.viewmodel.module.EditBlurringModule;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: BlurringController.kt */
/* loaded from: classes4.dex */
public final class BlurringController implements i3, e3, PGEditTabLayout.d, a.InterfaceC0379a {
    private final EditBlurringModule a;
    private final FrameLayout b;
    private final PGEditBottomTabLayout c;

    /* renamed from: d  reason: collision with root package name */
    private final BlurringOvalView f10292d;

    /* renamed from: e  reason: collision with root package name */
    private final FragmentLoadingView f10293e;

    /* renamed from: f  reason: collision with root package name */
    private final Group f10294f;

    /* renamed from: g  reason: collision with root package name */
    private final FrameLayout f10295g;

    /* renamed from: h  reason: collision with root package name */
    private ConstraintLayout f10296h;

    /* renamed from: i  reason: collision with root package name */
    private final us.pinguo.common.gesture.a f10297i;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f10298j;

    /* renamed from: k  reason: collision with root package name */
    private int f10299k;

    /* renamed from: l  reason: collision with root package name */
    private PointF f10300l;
    private int m;
    private PointF n;
    private final Matrix o;
    private Runnable p;

    /* compiled from: BlurringController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        a() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            us.pinguo.edit2020.bean.u0 f2;
            us.pinguo.edit2020.bean.j d2 = BlurringController.this.a.d();
            if (d2 == null || (f2 = BlurringController.this.a.f()) == null) {
                return;
            }
            BlurringController.this.f10292d.a();
            kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = d2.m();
            if (m == null) {
                return;
            }
            m.invoke(Boolean.FALSE, d2, Float.valueOf(f2.e()), Float.valueOf(f2.d()), Float.valueOf(f2.h()), Float.valueOf(f2.g()));
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            us.pinguo.edit2020.bean.u0 f2;
            us.pinguo.edit2020.bean.j d2 = BlurringController.this.a.d();
            if (d2 == null || (f2 = BlurringController.this.a.f()) == null) {
                return;
            }
            us.pinguo.edit2020.bean.l0 l2 = d2.l();
            d2.t(i2);
            if (d2.q() == BlurringType.Oval) {
                l2.t(BlurringController.this.a.h(i2, l2.i(), l2.j()));
                l2.u(BlurringController.this.a.i(i2, l2.i(), l2.j()));
                BlurringController.this.f10292d.c(l2.e(), l2.f(), l2.i(), l2.j(), l2.k(), l2.l(), l2.m());
            } else {
                l2.q(BlurringController.this.a.b(i2));
                BlurringController.this.f10292d.b(l2.e(), l2.f(), l2.g(), l2.h(), l2.m());
            }
            kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = d2.m();
            if (m == null) {
                return;
            }
            m.invoke(Boolean.TRUE, d2, Float.valueOf(f2.e()), Float.valueOf(f2.d()), Float.valueOf(f2.h()), Float.valueOf(f2.g()));
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: BlurringController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        b() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            us.pinguo.edit2020.bean.j d2 = BlurringController.this.a.d();
            if (d2 == null) {
                return;
            }
            d2.r(i2);
            UnityEditCaller.Blur.updateBlurStrength(i2 / d2.i());
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    public BlurringController(EditBlurringModule module, FrameLayout flPanelContainer, PGEditBottomTabLayout tabLayout, BlurringOvalView blurOvalView, FragmentLoadingView loadingView, Group loadingGroup, FrameLayout hintContainer) {
        kotlin.jvm.internal.s.h(module, "module");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(blurOvalView, "blurOvalView");
        kotlin.jvm.internal.s.h(loadingView, "loadingView");
        kotlin.jvm.internal.s.h(loadingGroup, "loadingGroup");
        kotlin.jvm.internal.s.h(hintContainer, "hintContainer");
        this.a = module;
        this.b = flPanelContainer;
        this.c = tabLayout;
        this.f10292d = blurOvalView;
        this.f10293e = loadingView;
        this.f10294f = loadingGroup;
        this.f10295g = hintContainer;
        this.f10297i = new us.pinguo.common.gesture.a(us.pinguo.foundation.e.b(), this);
        this.f10298j = new Handler(Looper.getMainLooper());
        this.f10299k = -1;
        this.m = -1;
        this.o = new Matrix();
    }

    private final void A(ConstraintLayout constraintLayout) {
        Context context = constraintLayout.getContext();
        kotlin.jvm.internal.s.g(context, "controlLayout.context");
        int i2 = us.pinguo.util.h.i(context);
        Context context2 = constraintLayout.getContext();
        kotlin.jvm.internal.s.g(context2, "controlLayout.context");
        int a2 = (i2 - (us.pinguo.util.g.a(context2, 20.0f) * 3)) - ((ConstraintLayout) constraintLayout.findViewById(R.id.clSeekBar)).getLayoutParams().width;
        int i3 = R.id.clTextView;
        ((AutofitTextView) ((ConstraintLayout) constraintLayout.findViewById(i3)).findViewById(R.id.txtTransition)).setMaxWidth(a2);
        ((AutofitTextView) ((ConstraintLayout) constraintLayout.findViewById(i3)).findViewById(R.id.txtFacula)).setMaxWidth(a2);
    }

    private final void C(us.pinguo.edit2020.bean.l0 l0Var, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (f2 <= f6) {
            if (f4 > f2) {
                l0Var.n(f4);
            }
        } else if (f4 <= f6) {
            l0Var.n(f6);
        } else if (f4 <= f8) {
            l0Var.n(f4);
        }
        if (f2 >= f8) {
            if (f4 <= f6) {
                l0Var.n(f6);
            } else if (f4 < f2) {
                l0Var.n(f4);
            }
        } else if (f4 >= f8) {
            l0Var.n(f8);
        } else if (f4 >= f6) {
            l0Var.n(f4);
        }
        if (f3 <= f7) {
            if (f5 > f3) {
                l0Var.o(f5);
            }
        } else if (f5 <= f7) {
            l0Var.o(f7);
        } else if (f5 <= f9) {
            l0Var.o(f5);
        }
        if (f3 >= f9) {
            if (f5 <= f7) {
                l0Var.o(f7);
            } else if (f5 < f3) {
                l0Var.o(f5);
            }
        } else if (f5 >= f9) {
            l0Var.o(f9);
        } else if (f5 >= f7) {
            l0Var.o(f5);
        }
    }

    private final void D(final us.pinguo.edit2020.bean.j jVar, boolean z) {
        final us.pinguo.edit2020.bean.u0 f2;
        ConstraintLayout constraintLayout = this.f10296h;
        if (constraintLayout == null) {
            return;
        }
        ((StickySeekBar) constraintLayout.findViewById(R.id.sbTransition)).setValues(jVar.o(), jVar.n(), jVar.p(), Integer.valueOf(jVar.h()));
        ((StickySeekBar) constraintLayout.findViewById(R.id.sbFacula)).setValues(jVar.j(), jVar.i(), jVar.k(), Integer.valueOf(jVar.g()));
        this.a.k(jVar);
        if (!z || (f2 = this.a.f()) == null) {
            return;
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            this.f10298j.removeCallbacks(runnable);
        }
        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = jVar.m();
        if (m != null) {
            m.invoke(Boolean.TRUE, jVar, Float.valueOf(f2.e()), Float.valueOf(f2.d()), Float.valueOf(f2.h()), Float.valueOf(f2.g()));
        }
        us.pinguo.edit2020.bean.l0 l2 = jVar.l();
        if (jVar.q() == BlurringType.Oval) {
            this.f10292d.c(l2.e(), l2.f(), l2.i(), l2.j(), l2.k(), l2.l(), l2.m());
        } else {
            this.f10292d.b(l2.e(), l2.f(), l2.g(), l2.h(), l2.m());
        }
        Runnable runnable2 = new Runnable() { // from class: us.pinguo.edit2020.controller.f0
            @Override // java.lang.Runnable
            public final void run() {
                BlurringController.E(us.pinguo.edit2020.bean.j.this, f2, this);
            }
        };
        this.p = runnable2;
        this.f10298j.postDelayed(runnable2, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(us.pinguo.edit2020.bean.j function, us.pinguo.edit2020.bean.u0 canvasStatus, BlurringController this$0) {
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.internal.s.h(canvasStatus, "$canvasStatus");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = function.m();
        if (m != null) {
            m.invoke(Boolean.FALSE, function, Float.valueOf(canvasStatus.e()), Float.valueOf(canvasStatus.d()), Float.valueOf(canvasStatus.h()), Float.valueOf(canvasStatus.g()));
        }
        this$0.f10292d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(boolean z, float f2, float f3, float f4, float f5, float f6) {
        us.pinguo.edit2020.bean.u0 f7;
        final us.pinguo.edit2020.bean.j d2 = this.a.d();
        if (d2 == null || (f7 = this.a.f()) == null) {
            return;
        }
        BlurringOvalView blurringOvalView = this.f10292d;
        blurringOvalView.setVisibility(0);
        VdsAgent.onSetViewVisibility(blurringOvalView, 0);
        this.f10292d.setConsumer(this);
        us.pinguo.edit2020.bean.l0 l2 = d2.l();
        l2.v(f2);
        final float e2 = f7.e();
        final float d3 = f7.d();
        final float h2 = f7.h();
        final float g2 = f7.g();
        float f8 = (g2 - d3) * 0.5f;
        float f9 = z ? (f3 * e2) + ((h2 - e2) * 0.5f) : h2 * 0.5f;
        float f10 = z ? ((1 - f4) * d3) + f8 : g2 * 0.5f;
        l2.n(f9);
        l2.o(f10);
        float b2 = z ? f5 * 0.5f * e2 : us.pinguo.edit2020.bean.l0.f10223j.b();
        float b3 = z ? 0.5f * f6 * d3 : us.pinguo.edit2020.bean.l0.f10223j.b();
        l2.r(b2);
        l2.s(b3);
        float h3 = this.a.h(d2.p(), b2, b3);
        float i2 = this.a.i(d2.p(), b2, b3);
        l2.t(h3);
        l2.u(i2);
        this.f10292d.c(f9, f10, b2, b3, h3, i2, f2);
        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = d2.m();
        if (m != null) {
            m.invoke(Boolean.TRUE, d2, Float.valueOf(e2), Float.valueOf(d3), Float.valueOf(h2), Float.valueOf(g2));
        }
        Runnable runnable = new Runnable() { // from class: us.pinguo.edit2020.controller.e0
            @Override // java.lang.Runnable
            public final void run() {
                BlurringController.s(us.pinguo.edit2020.bean.j.this, e2, d3, h2, g2, this);
            }
        };
        this.p = runnable;
        this.f10298j.postDelayed(runnable, 1000L);
        this.f10293e.b();
        FragmentLoadingView fragmentLoadingView = this.f10293e;
        fragmentLoadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(fragmentLoadingView, 8);
        Group group = this.f10294f;
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (!us.pinguo.repository2020.utils.o.b(oVar, "blur_hint", false, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "blur_hint", true, null, 4, null);
            LayoutInflater.from(this.f10295g.getContext()).inflate(R.layout.layout_blur_hint, (ViewGroup) this.f10295g, true);
            FrameLayout frameLayout = this.f10295g;
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
        }
        this.f10298j.postDelayed(new Runnable() { // from class: us.pinguo.edit2020.controller.g0
            @Override // java.lang.Runnable
            public final void run() {
                BlurringController.t(BlurringController.this);
            }
        }, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(us.pinguo.edit2020.bean.j function, float f2, float f3, float f4, float f5, BlurringController this$0) {
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = function.m();
        if (m != null) {
            m.invoke(Boolean.FALSE, function, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5));
        }
        this$0.f10292d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(BlurringController this$0) {
        View f2;
        View f3;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f10295g.getVisibility() == 0) {
            this$0.f10295g.removeAllViews();
            FrameLayout frameLayout = this$0.f10295g;
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
        }
        PGEditTabLayout pGEditTabLayout = (PGEditTabLayout) this$0.c.findViewById(R.id.tab_edit_workflow_name);
        PGEditTabLayout.f D = pGEditTabLayout.D(0);
        ViewParent parent = (D == null || (f2 = D.f()) == null) ? null : f2.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setClickable(true);
        }
        PGEditTabLayout.f D2 = pGEditTabLayout.D(1);
        ViewParent parent2 = (D2 == null || (f3 = D2.f()) == null) ? null : f3.getParent();
        View view2 = parent2 instanceof View ? (View) parent2 : null;
        if (view2 != null) {
            view2.setClickable(true);
        }
        ConstraintLayout constraintLayout = this$0.f10296h;
        StickySeekBar stickySeekBar = constraintLayout == null ? null : (StickySeekBar) constraintLayout.findViewById(R.id.sbTransition);
        if (stickySeekBar != null) {
            stickySeekBar.setEnabled(true);
        }
        ConstraintLayout constraintLayout2 = this$0.f10296h;
        StickySeekBar stickySeekBar2 = constraintLayout2 != null ? (StickySeekBar) constraintLayout2.findViewById(R.id.sbFacula) : null;
        if (stickySeekBar2 == null) {
            return;
        }
        stickySeekBar2.setEnabled(true);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return i3.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return i3.a.c(this);
    }

    @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
    public /* synthetic */ void a(PGEditTabLayout.f fVar) {
        us.pinguo.common.widget.tab.l.c(this, fVar);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        us.pinguo.edit2020.bean.u0 f2;
        int i2;
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.j d2 = this.a.d();
        if (d2 == null || (f2 = this.a.f()) == null) {
            return false;
        }
        us.pinguo.edit2020.bean.l0 l2 = d2.l();
        float e2 = f2.e();
        float d3 = f2.d();
        float h2 = f2.h();
        float g2 = f2.g();
        float f3 = (h2 - e2) * 0.5f;
        float f4 = (g2 - d3) * 0.5f;
        float f5 = (h2 + e2) * 0.5f;
        float f6 = (g2 + d3) * 0.5f;
        Runnable runnable = this.p;
        if (runnable != null) {
            this.f10298j.removeCallbacks(runnable);
            this.p = null;
            kotlin.u uVar = kotlin.u.a;
        }
        this.f10297i.c(event);
        int action = event.getAction() & event.getActionMasked();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    PointF pointF = this.f10300l;
                    kotlin.jvm.internal.s.e(pointF);
                    PointF pointF2 = this.n;
                    if (pointF2 == null) {
                        float x = event.getX(event.getActionIndex());
                        float y = event.getY(event.getActionIndex());
                        float e3 = l2.e();
                        float f7 = l2.f();
                        C(l2, e3, f7, e3 + (x - pointF.x), f7 + (y - pointF.y), f3, f4, f5, f6);
                        pointF.x = x;
                        pointF.y = y;
                        if (d2.q() == BlurringType.Oval) {
                            this.f10292d.c(l2.e(), l2.f(), l2.i(), l2.j(), l2.k(), l2.l(), l2.m());
                        } else {
                            this.f10292d.b(l2.e(), l2.f(), l2.g(), l2.h(), l2.m());
                        }
                        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m = d2.m();
                        if (m == null) {
                            return true;
                        }
                        m.invoke(Boolean.TRUE, d2, Float.valueOf(e2), Float.valueOf(d3), Float.valueOf(h2), Float.valueOf(g2));
                        kotlin.u uVar2 = kotlin.u.a;
                        return true;
                    }
                    int findPointerIndex = event.findPointerIndex(this.f10299k);
                    float x2 = event.getX(findPointerIndex);
                    float y2 = event.getY(findPointerIndex);
                    int findPointerIndex2 = event.findPointerIndex(this.m);
                    float x3 = event.getX(findPointerIndex2);
                    float y3 = event.getY(findPointerIndex2);
                    this.o.setRotate(-l2.m(), (pointF.x + pointF2.x) * 0.5f, (pointF.y + pointF2.y) * 0.5f);
                    float[] fArr = {pointF.x, pointF.y, pointF2.x, pointF2.y};
                    this.o.mapPoints(fArr);
                    float f8 = fArr[0];
                    float f9 = fArr[1];
                    float f10 = fArr[2];
                    float f11 = fArr[3];
                    fArr[0] = x2;
                    fArr[1] = y2;
                    fArr[2] = x3;
                    fArr[3] = y3;
                    this.o.mapPoints(fArr);
                    float f12 = fArr[0];
                    float f13 = fArr[1];
                    float f14 = fArr[2];
                    float f15 = fArr[3];
                    pointF.x = x2;
                    pointF.y = y2;
                    pointF2.x = x3;
                    pointF2.y = y3;
                    float abs = Math.abs(f14 - f12) - Math.abs(f10 - f8);
                    float abs2 = Math.abs(f15 - f13) - Math.abs(f11 - f9);
                    BlurringType q = d2.q();
                    BlurringType blurringType = BlurringType.Oval;
                    if (q == blurringType) {
                        float f16 = (e2 > d3 ? e2 : d3) * 0.5f;
                        float i3 = l2.i() + (abs * 0.5f);
                        l0.a aVar = us.pinguo.edit2020.bean.l0.f10223j;
                        if (i3 <= aVar.d()) {
                            i3 = aVar.d();
                        }
                        if (i3 >= f16) {
                            i3 = f16;
                        }
                        l2.r(i3);
                        float j2 = l2.j() + (abs2 * 0.5f);
                        if (j2 <= aVar.d()) {
                            j2 = aVar.d();
                        }
                        if (j2 < f16) {
                            f16 = j2;
                        }
                        l2.s(f16);
                        l2.t(this.a.h(d2.p(), i3, f16));
                        l2.u(this.a.i(d2.p(), i3, f16));
                    } else {
                        float g3 = l2.g() + (abs2 * 0.5f * 0.75f);
                        l0.a aVar2 = us.pinguo.edit2020.bean.l0.f10223j;
                        if (g3 < aVar2.c()) {
                            g3 = aVar2.c();
                        }
                        l2.p(g3);
                    }
                    if (d2.q() == blurringType) {
                        this.f10292d.c(l2.e(), l2.f(), l2.i(), l2.j(), l2.k(), l2.l(), l2.m());
                    } else {
                        this.f10292d.b(l2.e(), l2.f(), l2.g(), l2.h(), l2.m());
                    }
                    kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m2 = d2.m();
                    if (m2 == null) {
                        return true;
                    }
                    m2.invoke(Boolean.TRUE, d2, Float.valueOf(e2), Float.valueOf(d3), Float.valueOf(h2), Float.valueOf(g2));
                    kotlin.u uVar3 = kotlin.u.a;
                    return true;
                } else if (action != 3) {
                    if (action == 5) {
                        int pointerId = event.getPointerId(event.getActionIndex());
                        this.m = pointerId;
                        int findPointerIndex3 = event.findPointerIndex(pointerId);
                        PointF pointF3 = this.n;
                        if (pointF3 == null) {
                            pointF3 = new PointF();
                            this.n = pointF3;
                        }
                        pointF3.x = event.getX(findPointerIndex3);
                        pointF3.y = event.getY(findPointerIndex3);
                    } else if (action == 6) {
                        if (event.getPointerId(event.getActionIndex()) == this.f10299k && (i2 = this.m) > -1) {
                            this.f10299k = i2;
                            this.m = -1;
                            PointF pointF4 = this.f10300l;
                            if (pointF4 != null) {
                                pointF4.x = event.getX(event.findPointerIndex(i2));
                            }
                            PointF pointF5 = this.f10300l;
                            if (pointF5 != null) {
                                pointF5.y = event.getY(event.findPointerIndex(this.f10299k));
                            }
                        } else if (event.getPointerId(event.getActionIndex()) == this.m) {
                            this.m = -1;
                        }
                        this.n = null;
                    }
                    return true;
                }
            }
            this.f10299k = -1;
            this.f10300l = null;
            this.m = -1;
            this.n = null;
            this.f10292d.a();
            kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m3 = d2.m();
            if (m3 == null) {
                return true;
            }
            m3.invoke(Boolean.FALSE, d2, Float.valueOf(e2), Float.valueOf(d3), Float.valueOf(h2), Float.valueOf(g2));
            kotlin.u uVar4 = kotlin.u.a;
            return true;
        }
        int pointerId2 = event.getPointerId(event.getActionIndex());
        this.f10299k = pointerId2;
        int findPointerIndex4 = event.findPointerIndex(pointerId2);
        PointF pointF6 = this.f10300l;
        if (pointF6 == null) {
            pointF6 = new PointF();
            this.f10300l = pointF6;
        }
        pointF6.x = event.getX(findPointerIndex4);
        pointF6.y = event.getY(findPointerIndex4);
        kotlin.jvm.b.t<Boolean, us.pinguo.edit2020.bean.j, Float, Float, Float, Float, kotlin.u> m4 = d2.m();
        if (m4 != null) {
            m4.invoke(Boolean.TRUE, d2, Float.valueOf(e2), Float.valueOf(d3), Float.valueOf(h2), Float.valueOf(g2));
            kotlin.u uVar5 = kotlin.u.a;
        }
        if (d2.q() == BlurringType.Oval) {
            this.f10292d.c(l2.e(), l2.f(), l2.i(), l2.j(), l2.k(), l2.l(), l2.m());
            return true;
        }
        this.f10292d.b(l2.e(), l2.f(), l2.g(), l2.h(), l2.m());
        return true;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public void c(us.pinguo.common.gesture.a aVar) {
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        us.pinguo.edit2020.bean.j d2 = this.a.d();
        if (d2 != null) {
            us.pinguo.foundation.statistics.h.b.y(d2.f());
        }
        q();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        q();
    }

    @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
    public void h(PGEditTabLayout.f tab) {
        kotlin.jvm.internal.s.h(tab, "tab");
        D(this.a.e().get(tab.i()), true);
    }

    @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
    public /* synthetic */ void i(PGEditTabLayout.f fVar) {
        us.pinguo.common.widget.tab.l.a(this, fVar);
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean j(us.pinguo.common.gesture.a aVar) {
        return true;
    }

    @Override // us.pinguo.common.gesture.a.InterfaceC0379a
    public boolean k(us.pinguo.common.gesture.a detector) {
        kotlin.jvm.internal.s.h(detector, "detector");
        us.pinguo.edit2020.bean.j d2 = this.a.d();
        if (d2 == null) {
            return false;
        }
        float i2 = detector.i();
        us.pinguo.edit2020.bean.l0 l2 = d2.l();
        l2.v(l2.m() - i2);
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    public void q() {
        if (this.f10295g.getVisibility() == 0) {
            this.f10295g.removeAllViews();
            FrameLayout frameLayout = this.f10295g;
            frameLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(frameLayout, 8);
        }
        Runnable runnable = this.p;
        if (runnable != null) {
            this.f10298j.removeCallbacks(runnable);
        }
        ConstraintLayout constraintLayout = this.f10296h;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        BlurringOvalView blurringOvalView = this.f10292d;
        blurringOvalView.setVisibility(4);
        VdsAgent.onSetViewVisibility(blurringOvalView, 4);
        this.a.j();
        this.a.c(false);
        this.b.removeAllViews();
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        int o;
        View f2;
        View f3;
        Group group = this.f10294f;
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        FragmentLoadingView fragmentLoadingView = this.f10293e;
        fragmentLoadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(fragmentLoadingView, 0);
        this.f10293e.f(false);
        this.f10293e.d(true);
        this.f10293e.g();
        this.a.g();
        this.a.c(true);
        this.a.l(new BlurringController$enter$1(this));
        ConstraintLayout constraintLayout = this.f10296h;
        if (constraintLayout == null) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_blurring_control, (ViewGroup) this.b, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            constraintLayout = (ConstraintLayout) inflate;
            this.f10296h = constraintLayout;
            A(constraintLayout);
            int i2 = R.id.sbTransition;
            StickySeekBar stickySeekBar = (StickySeekBar) constraintLayout.findViewById(i2);
            if (stickySeekBar != null) {
                stickySeekBar.setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
            }
            StickySeekBar stickySeekBar2 = (StickySeekBar) constraintLayout.findViewById(i2);
            if (stickySeekBar2 != null) {
                stickySeekBar2.setTrackListener(new a());
            }
            int i3 = R.id.sbFacula;
            StickySeekBar stickySeekBar3 = (StickySeekBar) constraintLayout.findViewById(i3);
            if (stickySeekBar3 != null) {
                stickySeekBar3.setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
            }
            StickySeekBar stickySeekBar4 = (StickySeekBar) constraintLayout.findViewById(i3);
            if (stickySeekBar4 != null) {
                stickySeekBar4.setTrackListener(new b());
            }
        }
        StickySeekBar stickySeekBar5 = (StickySeekBar) constraintLayout.findViewById(R.id.sbTransition);
        if (stickySeekBar5 != null) {
            stickySeekBar5.setEnabled(false);
        }
        StickySeekBar stickySeekBar6 = (StickySeekBar) constraintLayout.findViewById(R.id.sbFacula);
        if (stickySeekBar6 != null) {
            stickySeekBar6.setEnabled(false);
        }
        if (constraintLayout.getParent() == null) {
            this.b.addView(constraintLayout);
        }
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        PGEditBottomTabLayout pGEditBottomTabLayout = this.c;
        List<us.pinguo.edit2020.bean.j> e2 = this.a.e();
        o = kotlin.collections.v.o(e2, 10);
        ArrayList arrayList = new ArrayList(o);
        for (us.pinguo.edit2020.bean.j jVar : e2) {
            arrayList.add(jVar.c());
        }
        Object[] array = arrayList.toArray(new String[0]);
        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, (String[]) array, true, null, 4, null);
        this.c.d(this);
        this.c.B();
        D(this.a.e().get(0), false);
        PGEditTabLayout pGEditTabLayout = (PGEditTabLayout) this.c.findViewById(R.id.tab_edit_workflow_name);
        PGEditTabLayout.f D = pGEditTabLayout.D(0);
        ViewParent parent = (D == null || (f2 = D.f()) == null) ? null : f2.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setClickable(false);
        }
        PGEditTabLayout.f D2 = pGEditTabLayout.D(1);
        ViewParent parent2 = (D2 == null || (f3 = D2.f()) == null) ? null : f3.getParent();
        View view2 = parent2 instanceof View ? (View) parent2 : null;
        if (view2 != null) {
            view2.setClickable(false);
        }
        this.a.a();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        ArrayList f2;
        if (this.a.d() == null) {
            return null;
        }
        us.pinguo.edit2020.bean.j d2 = this.a.d();
        kotlin.jvm.internal.s.e(d2);
        f2 = kotlin.collections.u.f(d2);
        return f2;
    }
}
