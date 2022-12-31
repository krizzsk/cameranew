package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.m0;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.AdjustModule;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.performance.manager.PerformanceLevelManager;
import us.pinguo.u3dengine.edit.ColorOptionMode;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: AdjustController.kt */
/* loaded from: classes4.dex */
public final class AdjustController implements us.pinguo.edit2020.view.p0, us.pinguo.edit2020.view.m0, z2, PGEditBottomTabLayout.a, c3 {
    private final PGEditBottomTabLayout a;
    private final FrameLayout b;
    private final ViewGroup c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f10265d;

    /* renamed from: e  reason: collision with root package name */
    private final NumberTipView f10266e;

    /* renamed from: f  reason: collision with root package name */
    private final us.pinguo.edit2020.view.c0 f10267f;

    /* renamed from: g  reason: collision with root package name */
    private final AdjustModule f10268g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f10269h;

    /* renamed from: i  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.a> f10270i;

    /* renamed from: j  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.w> f10271j;

    /* renamed from: k  reason: collision with root package name */
    private us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> f10272k;

    /* renamed from: l  reason: collision with root package name */
    private ConstraintLayout f10273l;
    private ConstraintLayout m;
    private PGEditBottomTabLayout.a n;
    private ConstraintLayout o;
    private kotlin.jvm.b.a<kotlin.u> p;
    private final boolean q;
    private boolean r;

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditGotoType.values().length];
            iArr[EditGotoType.ADJUST.ordinal()] = 1;
            iArr[EditGotoType.SELECTIVE_COLOR.ordinal()] = 2;
            a = iArr;
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.v b;
        final /* synthetic */ AdjustController c;

        b(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.v vVar, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = vVar;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtHueValue)).setText(String.valueOf(i2));
            us.pinguo.edit2020.bean.w wVar = this.b.o().get(this.b.p());
            kotlin.jvm.internal.s.g(wVar, "function.colorInfo[function.currentColorIndex]");
            wVar.n(i2);
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.v b;
        final /* synthetic */ AdjustController c;

        c(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.v vVar, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = vVar;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtBrightnessValue)).setText(String.valueOf(i2));
            us.pinguo.edit2020.bean.w wVar = this.b.o().get(this.b.p());
            kotlin.jvm.internal.s.g(wVar, "function.colorInfo[function.currentColorIndex]");
            wVar.o(i2);
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.v b;
        final /* synthetic */ AdjustController c;

        d(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.v vVar, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = vVar;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtSaturationValue)).setText(String.valueOf(i2));
            us.pinguo.edit2020.bean.w wVar = this.b.o().get(this.b.p());
            kotlin.jvm.internal.s.g(wVar, "function.colorInfo[function.currentColorIndex]");
            wVar.p(i2);
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.f0 b;
        final /* synthetic */ AdjustController c;

        e(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.f0 f0Var, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = f0Var;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtCyanValue)).setText(String.valueOf(i2));
            int p = this.b.p();
            us.pinguo.edit2020.bean.g0 g0Var = this.b.o().get(p);
            kotlin.jvm.internal.s.g(g0Var, "function.colorInfo[index]");
            us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
            g0Var2.h().c(i2);
            g0Var2.f(this.c.f10268g.d(g0Var2.c(), i2, g0Var2.k().b(), g0Var2.m().b(), g0Var2.g().b(), g0Var2.i(), this.b.q() == ColorOptionMode.Relative));
            us.pinguo.edit2020.adapter.x xVar = this.c.f10272k;
            if (xVar != null) {
                xVar.notifyItemChanged(p);
            }
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class f implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.f0 b;
        final /* synthetic */ AdjustController c;

        f(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.f0 f0Var, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = f0Var;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtMagentaValue)).setText(String.valueOf(i2));
            int p = this.b.p();
            us.pinguo.edit2020.bean.g0 g0Var = this.b.o().get(p);
            kotlin.jvm.internal.s.g(g0Var, "function.colorInfo[index]");
            us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
            g0Var2.k().c(i2);
            g0Var2.f(this.c.f10268g.d(g0Var2.c(), g0Var2.h().b(), i2, g0Var2.m().b(), g0Var2.g().b(), g0Var2.i(), this.b.q() == ColorOptionMode.Relative));
            us.pinguo.edit2020.adapter.x xVar = this.c.f10272k;
            if (xVar != null) {
                xVar.notifyItemChanged(p);
            }
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class g implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.f0 b;
        final /* synthetic */ AdjustController c;

        g(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.f0 f0Var, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = f0Var;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtYellowValue)).setText(String.valueOf(i2));
            int p = this.b.p();
            us.pinguo.edit2020.bean.g0 g0Var = this.b.o().get(p);
            kotlin.jvm.internal.s.g(g0Var, "function.colorInfo[index]");
            us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
            g0Var2.m().c(i2);
            g0Var2.f(this.c.f10268g.d(g0Var2.c(), g0Var2.h().b(), g0Var2.k().b(), i2, g0Var2.g().b(), g0Var2.i(), this.b.q() == ColorOptionMode.Relative));
            us.pinguo.edit2020.adapter.x xVar = this.c.f10272k;
            if (xVar != null) {
                xVar.notifyItemChanged(p);
            }
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.r = true;
                this.c.f10268g.s(this.c.q);
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: AdjustController.kt */
    /* loaded from: classes4.dex */
    public static final class h implements us.pinguo.ui.widget.h {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> a;
        final /* synthetic */ us.pinguo.edit2020.bean.f0 b;
        final /* synthetic */ AdjustController c;

        h(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef, us.pinguo.edit2020.bean.f0 f0Var, AdjustController adjustController) {
            this.a = ref$ObjectRef;
            this.b = f0Var;
            this.c = adjustController;
        }

        private final void a(int i2) {
            ((TextView) this.a.element.findViewById(R.id.txtBlackValue)).setText(String.valueOf(i2));
            int p = this.b.p();
            us.pinguo.edit2020.bean.g0 g0Var = this.b.o().get(p);
            kotlin.jvm.internal.s.g(g0Var, "function.colorInfo[index]");
            us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
            g0Var2.g().c(i2);
            g0Var2.f(this.c.f10268g.d(g0Var2.c(), g0Var2.h().b(), g0Var2.k().b(), g0Var2.m().b(), i2, g0Var2.i(), this.b.q() == ColorOptionMode.Relative));
            us.pinguo.edit2020.adapter.x xVar = this.c.f10272k;
            if (xVar != null) {
                xVar.notifyItemChanged(p);
            }
            kotlin.jvm.b.a<kotlin.u> k2 = this.b.k();
            if (k2 == null) {
                return;
            }
            k2.invoke();
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (this.c.q) {
                this.c.f10268g.s(false);
                this.c.r = false;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (!this.c.r && this.c.q) {
                this.c.f10268g.s(this.c.q);
                this.c.r = true;
            }
            a(i2);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    public AdjustController(PGEditBottomTabLayout tabLayout, FrameLayout flPanelContainer, ViewGroup subItemContainer, ImageView imageView, NumberTipView numberTipView, us.pinguo.edit2020.view.c0 operationController, AdjustModule module) {
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(subItemContainer, "subItemContainer");
        kotlin.jvm.internal.s.h(numberTipView, "numberTipView");
        kotlin.jvm.internal.s.h(operationController, "operationController");
        kotlin.jvm.internal.s.h(module, "module");
        this.a = tabLayout;
        this.b = flPanelContainer;
        this.c = subItemContainer;
        this.f10265d = imageView;
        this.f10266e = numberTipView;
        this.f10267f = operationController;
        this.f10268g = module;
        this.f10270i = new us.pinguo.edit2020.adapter.a0<>();
        Integer g2 = PerformanceLevelManager.a.g();
        this.q = (g2 == null ? 0 : g2.intValue()) < 90;
    }

    private final void A(int i2) {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        if (f2 == null) {
            return;
        }
        f2.l(i2);
        kotlin.jvm.b.a<kotlin.u> k2 = f2.k();
        if (k2 != null) {
            k2.invoke();
        }
        this.f10270i.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2, int i3, us.pinguo.edit2020.bean.a aVar, us.pinguo.edit2020.adapter.b0 b0Var) {
        boolean z = i2 == i3;
        Context b2 = us.pinguo.foundation.e.b();
        Drawable drawable = b2.getDrawable(aVar.d());
        boolean z2 = aVar instanceof us.pinguo.edit2020.bean.f0;
        if (!z2 && drawable != null) {
            drawable.setTint(ContextCompat.getColor(b2, z ? R.color.edit_function_select : R.color.edit_function_unselect));
        }
        b0Var.a().setImageDrawable(drawable);
        b0Var.c().setText(aVar.c());
        b0Var.c().setTextColor(ContextCompat.getColor(b2, z ? R.color.edit_item_enable : R.color.edit_item_unable));
        AppCompatImageView b3 = b0Var.b();
        int i4 = aVar.a() ^ true ? 4 : 0;
        b3.setVisibility(i4);
        VdsAgent.onSetViewVisibility(b3, i4);
        boolean z3 = aVar instanceof us.pinguo.edit2020.bean.v;
        if (!z3 && !z2 && aVar.e()) {
            TextView d2 = b0Var.d();
            d2.setVisibility(0);
            VdsAgent.onSetViewVisibility(d2, 0);
            b0Var.d().setText(String.valueOf(aVar.g()));
            b0Var.d().setTextColor(ContextCompat.getColor(b2, z ? R.color.edit_item_enable : R.color.edit_item_unable));
        } else {
            TextView d3 = b0Var.d();
            d3.setVisibility(4);
            VdsAgent.onSetViewVisibility(d3, 4);
        }
        boolean z4 = (z3 || z2) && aVar.e();
        AppCompatImageView e2 = b0Var.e();
        int i5 = z4 ? 0 : 8;
        e2.setVisibility(i5);
        VdsAgent.onSetViewVisibility(e2, i5);
        b0Var.e().setImageResource(z ? R.drawable.dot_selected : R.drawable.dot_unselect);
    }

    private final void D() {
        RelativeLayout relativeLayout = (RelativeLayout) this.f10267f.g().findViewById(R.id.flSeekBar);
        kotlin.jvm.internal.s.g(relativeLayout, "operationController.container.flSeekBar");
        relativeLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(relativeLayout, 4);
        this.f10267f.D(null);
        this.f10268g.e(false);
        this.f10267f.v(null);
        this.f10266e.a();
        this.f10268g.m();
        this.f10270i.z(0);
        this.f10270i.D();
        us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> xVar = this.f10272k;
        if (xVar != null) {
            xVar.notifyDataSetChanged();
        }
        ConstraintLayout constraintLayout = this.m;
        if (constraintLayout != null) {
            us.pinguo.edit2020.bean.a aVar = this.f10268g.g().get(10);
            us.pinguo.edit2020.bean.f0 f0Var = aVar instanceof us.pinguo.edit2020.bean.f0 ? (us.pinguo.edit2020.bean.f0) aVar : null;
            if (f0Var != null) {
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbCyan)).setProgress(f0Var.h());
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbMagenta)).setProgress(f0Var.h());
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbYellow)).setProgress(f0Var.h());
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbBlack)).setProgress(f0Var.h());
            }
        }
        ConstraintLayout constraintLayout2 = this.f10273l;
        if (constraintLayout2 != null) {
            us.pinguo.edit2020.bean.a aVar2 = this.f10268g.g().get(9);
            us.pinguo.edit2020.bean.v vVar = aVar2 instanceof us.pinguo.edit2020.bean.v ? (us.pinguo.edit2020.bean.v) aVar2 : null;
            if (vVar != null) {
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbHue)).setProgress(vVar.h());
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbSaturation)).setProgress(vVar.h());
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbBrightness)).setProgress(vVar.h());
            }
        }
        FrameLayout frameLayout = this.b;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        layoutParams2.topToBottom = -1;
        frameLayout.setLayoutParams(layoutParams2);
        this.b.removeAllViews();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    private final void G(us.pinguo.edit2020.bean.v vVar) {
        this.n = this.a.m();
        this.a.setOnBottomClickListener(this);
        PGEditBottomTabLayout.h(this.a, new String[]{vVar.c()}, false, null, 6, null);
        int p = vVar.p();
        us.pinguo.edit2020.bean.w wVar = vVar.o().get(vVar.p());
        kotlin.jvm.internal.s.g(wVar, "function.colorInfo[function.currentColorIndex]");
        us.pinguo.edit2020.bean.w wVar2 = wVar;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r3 = this.f10273l;
        ref$ObjectRef.element = r3;
        if (r3 == 0) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_hsl, (ViewGroup) this.b, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ?? r32 = (ConstraintLayout) inflate;
            ref$ObjectRef.element = r32;
            StickySeekBar stickySeekBar = (StickySeekBar) ((ConstraintLayout) r32).findViewById(R.id.sbHue);
            StickySeekBar.DefaultDotStyle defaultDotStyle = StickySeekBar.DefaultDotStyle.RECT;
            stickySeekBar.setDotStyle(defaultDotStyle);
            stickySeekBar.setValues(vVar.j(), vVar.i(), wVar2.g(), Integer.valueOf(vVar.h()));
            stickySeekBar.setTrackListener(new b(ref$ObjectRef, vVar, this));
            StickySeekBar stickySeekBar2 = (StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.sbBrightness);
            stickySeekBar2.setDotStyle(defaultDotStyle);
            stickySeekBar2.setValues(vVar.j(), vVar.i(), wVar2.h(), Integer.valueOf(vVar.h()));
            stickySeekBar2.setTrackListener(new c(ref$ObjectRef, vVar, this));
            StickySeekBar stickySeekBar3 = (StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.sbSaturation);
            stickySeekBar3.setDotStyle(defaultDotStyle);
            stickySeekBar3.setValues(vVar.j(), vVar.i(), wVar2.i(), Integer.valueOf(vVar.h()));
            stickySeekBar3.setTrackListener(new d(ref$ObjectRef, vVar, this));
            RecyclerView recyclerView = (RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rvHslColors);
            recyclerView.setLayoutManager(new LinearLayoutManager(((ConstraintLayout) ref$ObjectRef.element).getContext(), 0, false));
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            recyclerView.addItemDecoration(new us.pinguo.edit2020.adapter.y(((ConstraintLayout) ref$ObjectRef.element).getContext().getResources().getDimensionPixelSize(R.dimen.hsl_color_recyclerview_height), ((ConstraintLayout) ref$ObjectRef.element).getContext().getResources().getDimensionPixelSize(R.dimen.hsl_color_recyclerview_margin), vVar.o().size()));
            this.f10273l = (ConstraintLayout) ref$ObjectRef.element;
        }
        us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.w> xVar = this.f10271j;
        if (xVar == null) {
            xVar = new us.pinguo.edit2020.adapter.x<>(vVar.o());
            xVar.k(new AdjustController$onHslSelected$4(vVar, ref$ObjectRef));
            this.f10271j = xVar;
            ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rvHslColors)).setAdapter(xVar);
        }
        FrameLayout frameLayout = this.b;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
        layoutParams2.topToBottom = R.id.unityContainer;
        frameLayout.setLayoutParams(layoutParams2);
        if (((ConstraintLayout) ref$ObjectRef.element).getParent() == null) {
            this.b.addView((View) ref$ObjectRef.element);
        }
        View view = (View) ref$ObjectRef.element;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        ViewGroup viewGroup = this.c;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.w, kotlin.u> e2 = xVar.e();
        if (e2 == null) {
            return;
        }
        e2.invoke(Integer.valueOf(p), wVar2);
    }

    /* JADX WARN: Type inference failed for: r1v21, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    private final void H(final us.pinguo.edit2020.bean.f0 f0Var) {
        us.pinguo.edit2020.bean.u0 j2 = this.f10268g.j();
        if (j2 == null) {
            return;
        }
        this.n = this.a.m();
        this.a.setOnBottomClickListener(this);
        ConstraintLayout constraintLayout = this.o;
        if (constraintLayout == null) {
            View inflate = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.layout_bottom_title, (ViewGroup) null);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            constraintLayout = (ConstraintLayout) inflate;
            ((TextView) constraintLayout.findViewById(R.id.txtTitle)).setText(f0Var.c());
            int i2 = R.id.imgLeftIcon;
            ((ImageView) constraintLayout.findViewById(i2)).setImageResource(R.drawable.icon_vip_round_label);
            ((ImageView) constraintLayout.findViewById(i2)).setVisibility(0);
            this.o = constraintLayout;
        }
        PGEditBottomTabLayout.g(this.a, new View[]{constraintLayout}, false, null, 6, null);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        int a2 = us.pinguo.util.g.a(b2, 104.0f);
        ImageView imageView = this.f10265d;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += a2;
            imageView.setLayoutParams(layoutParams2);
        }
        float d2 = j2.d();
        float g2 = (j2.g() - d2) * 0.5f;
        float f2 = a2;
        float f3 = f2 - g2;
        if (g2 < f2) {
            this.f10268g.a(new PointF(0.5f, 0.5f), (d2 - (f3 * 2.0f)) / d2, new PointF(0.0f, 0.0f), 200);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.m;
        ref$ObjectRef.element = r1;
        if (r1 == 0) {
            View inflate2 = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_optional_colors, (ViewGroup) this.b, false);
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ?? r12 = (ConstraintLayout) inflate2;
            ref$ObjectRef.element = r12;
            this.m = (ConstraintLayout) r12;
            StickySeekBar stickySeekBar = (StickySeekBar) ((ConstraintLayout) r12).findViewById(R.id.sbCyan);
            stickySeekBar.setValues(f0Var.j(), f0Var.i(), f0Var.h(), Integer.valueOf(f0Var.h()));
            stickySeekBar.setTrackListener(new e(ref$ObjectRef, f0Var, this));
            StickySeekBar stickySeekBar2 = (StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.sbMagenta);
            stickySeekBar2.setValues(f0Var.j(), f0Var.i(), f0Var.h(), Integer.valueOf(f0Var.h()));
            stickySeekBar2.setTrackListener(new f(ref$ObjectRef, f0Var, this));
            StickySeekBar stickySeekBar3 = (StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.sbYellow);
            stickySeekBar3.setValues(f0Var.j(), f0Var.i(), f0Var.h(), Integer.valueOf(f0Var.h()));
            stickySeekBar3.setTrackListener(new g(ref$ObjectRef, f0Var, this));
            StickySeekBar stickySeekBar4 = (StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.sbBlack);
            stickySeekBar4.setValues(f0Var.j(), f0Var.i(), f0Var.h(), Integer.valueOf(f0Var.h()));
            stickySeekBar4.setTrackListener(new h(ref$ObjectRef, f0Var, this));
            RecyclerView recyclerView = (RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rvColors);
            recyclerView.setLayoutManager(new LinearLayoutManager(((ConstraintLayout) ref$ObjectRef.element).getContext(), 0, false));
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            recyclerView.addItemDecoration(new us.pinguo.edit2020.adapter.y(((ConstraintLayout) ref$ObjectRef.element).getContext().getResources().getDimensionPixelSize(R.dimen.color_option_recycler_height), ((ConstraintLayout) ref$ObjectRef.element).getContext().getResources().getDimensionPixelSize(R.dimen.color_option_recycler_margin), f0Var.o().size()));
            ((RadioGroup) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rgTypes)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: us.pinguo.edit2020.controller.a
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup, int i3) {
                    AdjustController.I(us.pinguo.edit2020.bean.f0.this, this, radioGroup, i3);
                }
            });
        }
        ((RadioGroup) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rgTypes)).check(f0Var.q() == ColorOptionMode.Absolute ? R.id.mrbAbsolute : R.id.mrbRelative);
        us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> xVar = this.f10272k;
        if (xVar == null) {
            xVar = new us.pinguo.edit2020.adapter.x<>(f0Var.o());
            this.f10272k = xVar;
            xVar.k(new AdjustController$onOptionalColorSelected$7(f0Var, ref$ObjectRef));
            ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.rvColors)).setAdapter(xVar);
        }
        FrameLayout frameLayout = this.b;
        ViewGroup.LayoutParams layoutParams3 = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = ((ConstraintLayout) ref$ObjectRef.element).getLayoutParams().height;
        layoutParams4.topToBottom = -1;
        frameLayout.setLayoutParams(layoutParams4);
        if (((ConstraintLayout) ref$ObjectRef.element).getParent() == null) {
            this.b.addView((View) ref$ObjectRef.element);
        }
        View view = (View) ref$ObjectRef.element;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        ViewGroup viewGroup = this.c;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
        int p = f0Var.p();
        us.pinguo.edit2020.bean.g0 g0Var = f0Var.o().get(p);
        kotlin.jvm.internal.s.g(g0Var, "function.colorInfo[index]");
        us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
        xVar.j(p);
        kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.g0, kotlin.u> e2 = xVar.e();
        if (e2 == null) {
            return;
        }
        e2.invoke(Integer.valueOf(p), g0Var2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(us.pinguo.edit2020.bean.f0 function, AdjustController this$0, RadioGroup radioGroup, int i2) {
        VdsAgent.lambdaOnCheckedChangeRadioGroup(radioGroup, i2);
        kotlin.jvm.internal.s.h(function, "$function");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        function.s(i2 == R.id.mrbAbsolute ? ColorOptionMode.Absolute : ColorOptionMode.Relative);
        kotlin.jvm.b.a<kotlin.u> k2 = function.k();
        if (k2 != null) {
            k2.invoke();
        }
        int i3 = 0;
        for (Object obj : function.o()) {
            int i4 = i3 + 1;
            if (i3 >= 0) {
                us.pinguo.edit2020.bean.g0 g0Var = (us.pinguo.edit2020.bean.g0) obj;
                g0Var.f(this$0.f10268g.d(g0Var.c(), g0Var.h().b(), g0Var.k().b(), g0Var.m().b(), g0Var.g().b(), g0Var.i(), function.q() == ColorOptionMode.Relative));
                us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> xVar = this$0.f10272k;
                if (xVar != null) {
                    xVar.notifyItemChanged(i3);
                }
                i3 = i4;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(Integer num, us.pinguo.edit2020.bean.a aVar) {
        String f2;
        this.f10268g.r(aVar);
        this.f10266e.a();
        if (num != null && aVar != null) {
            if (aVar instanceof us.pinguo.edit2020.bean.v) {
                G((us.pinguo.edit2020.bean.v) aVar);
            } else if (aVar instanceof us.pinguo.edit2020.bean.f0) {
                H((us.pinguo.edit2020.bean.f0) aVar);
            } else {
                ConstraintLayout constraintLayout = this.f10273l;
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                    VdsAgent.onSetViewVisibility(constraintLayout, 8);
                }
                ConstraintLayout constraintLayout2 = this.m;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(8);
                    VdsAgent.onSetViewVisibility(constraintLayout2, 8);
                }
                ViewGroup viewGroup = this.c;
                viewGroup.setVisibility(0);
                VdsAgent.onSetViewVisibility(viewGroup, 0);
                ((StickySeekBar) this.f10267f.g().findViewById(R.id.seekBar)).setValues(aVar.j(), aVar.i(), aVar.g(), Integer.valueOf(aVar.h()));
                this.f10267f.x(true);
                RecyclerView recyclerView = this.f10269h;
                RecyclerView.LayoutManager layoutManager = recyclerView == null ? null : recyclerView.getLayoutManager();
                CenterLayoutManager centerLayoutManager = layoutManager instanceof CenterLayoutManager ? (CenterLayoutManager) layoutManager : null;
                if (centerLayoutManager != null) {
                    Context context = this.c.getContext();
                    kotlin.jvm.internal.s.g(context, "subItemContainer.context");
                    centerLayoutManager.b(context, num.intValue(), 100.0f);
                }
            }
        } else {
            ConstraintLayout constraintLayout3 = this.f10273l;
            if (constraintLayout3 != null) {
                constraintLayout3.setVisibility(8);
                VdsAgent.onSetViewVisibility(constraintLayout3, 8);
            }
            ConstraintLayout constraintLayout4 = this.m;
            if (constraintLayout4 != null) {
                constraintLayout4.setVisibility(8);
                VdsAgent.onSetViewVisibility(constraintLayout4, 8);
            }
            ViewGroup viewGroup2 = this.c;
            viewGroup2.setVisibility(0);
            VdsAgent.onSetViewVisibility(viewGroup2, 0);
            RelativeLayout relativeLayout = (RelativeLayout) this.f10267f.g().findViewById(R.id.flSeekBar);
            kotlin.jvm.internal.s.g(relativeLayout, "operationController.container.flSeekBar");
            relativeLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(relativeLayout, 4);
            this.f10270i.f();
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        String str = "";
        if (aVar != null && (f2 = aVar.f()) != null) {
            str = f2;
        }
        iVar.q0(str, "click");
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.ADJUST;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        int i2 = a.a[editGoto.a().ordinal()];
        if (i2 == 1) {
            kotlin.jvm.b.a<kotlin.u> aVar = this.p;
            if (aVar == null) {
                return true;
            }
            aVar.invoke();
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            kotlin.jvm.b.a<kotlin.u> aVar2 = this.p;
            if (aVar2 != null) {
                aVar2.invoke();
            }
            this.f10270i.z(10);
            this.f10270i.o();
            return true;
        }
    }

    public final void M(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.p = aVar;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return z2.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return z2.a.c(this);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void a() {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        J(null, null);
        this.a.setOnBottomClickListener(this.n);
        PGEditBottomTabLayout pGEditBottomTabLayout = this.a;
        String string = us.pinguo.foundation.e.b().getString(R.string.pg_sdk_edit_lightzone_class);
        kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…sdk_edit_lightzone_class)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string}, false, null, 6, null);
        if (f2 instanceof us.pinguo.edit2020.bean.v) {
            this.f10268g.u();
        } else if (f2 instanceof us.pinguo.edit2020.bean.f0) {
            ImageView imageView = this.f10265d;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                Context b2 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b2, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2 - us.pinguo.util.g.a(b2, 104.0f);
                imageView.setLayoutParams(layoutParams2);
            }
            this.f10268g.a(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
            this.f10268g.t();
        }
        this.f10268g.r(null);
    }

    @Override // us.pinguo.common.widget.tab.PGEditBottomTabLayout.a
    public void c() {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        J(null, null);
        this.a.setOnBottomClickListener(this.n);
        PGEditBottomTabLayout pGEditBottomTabLayout = this.a;
        String string = us.pinguo.foundation.e.b().getString(R.string.pg_sdk_edit_lightzone_class);
        kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…sdk_edit_lightzone_class)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string}, false, null, 4, null);
        if (f2 instanceof us.pinguo.edit2020.bean.v) {
            if (this.f10268g.i() == null) {
                this.f10268g.o();
                this.f10268g.c();
            } else {
                this.f10268g.q();
            }
            us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.w> xVar = this.f10271j;
            if (xVar != null) {
                xVar.j(((us.pinguo.edit2020.bean.v) f2).p());
            }
            ConstraintLayout constraintLayout = this.f10273l;
            if (constraintLayout != null) {
                us.pinguo.edit2020.bean.v vVar = (us.pinguo.edit2020.bean.v) f2;
                us.pinguo.edit2020.bean.w wVar = vVar.o().get(vVar.p());
                kotlin.jvm.internal.s.g(wVar, "func.colorInfo[func.currentColorIndex]");
                us.pinguo.edit2020.bean.w wVar2 = wVar;
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbHue)).setProgress(wVar2.g());
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbSaturation)).setProgress(wVar2.i());
                ((StickySeekBar) constraintLayout.findViewById(R.id.sbBrightness)).setProgress(wVar2.h());
            }
        } else if (f2 instanceof us.pinguo.edit2020.bean.f0) {
            ImageView imageView = this.f10265d;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                int i2 = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                Context b2 = us.pinguo.foundation.e.b();
                kotlin.jvm.internal.s.g(b2, "getAppContext()");
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = i2 - us.pinguo.util.g.a(b2, 104.0f);
                imageView.setLayoutParams(layoutParams2);
            }
            this.f10268g.a(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
            if (this.f10268g.h() == null) {
                this.f10268g.n();
                kotlin.jvm.b.a<kotlin.u> k2 = ((us.pinguo.edit2020.bean.f0) f2).k();
                if (k2 != null) {
                    k2.invoke();
                }
            } else {
                this.f10268g.p();
            }
            us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> xVar2 = this.f10272k;
            if (xVar2 != null) {
                xVar2.j(((us.pinguo.edit2020.bean.f0) f2).p());
            }
            us.pinguo.edit2020.adapter.x<us.pinguo.edit2020.bean.g0> xVar3 = this.f10272k;
            if (xVar3 != null) {
                xVar3.notifyDataSetChanged();
            }
            ConstraintLayout constraintLayout2 = this.m;
            if (constraintLayout2 != null) {
                us.pinguo.edit2020.bean.f0 f0Var = (us.pinguo.edit2020.bean.f0) f2;
                us.pinguo.edit2020.bean.g0 g0Var = f0Var.o().get(f0Var.p());
                kotlin.jvm.internal.s.g(g0Var, "func.colorInfo[func.currentColorIndex]");
                us.pinguo.edit2020.bean.g0 g0Var2 = g0Var;
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbCyan)).setProgress(g0Var2.h().b());
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbMagenta)).setProgress(g0Var2.k().b());
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbYellow)).setProgress(g0Var2.m().b());
                ((StickySeekBar) constraintLayout2.findViewById(R.id.sbBlack)).setProgress(g0Var2.g().b());
            }
        }
        this.f10268g.r(null);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        if (!(f2 instanceof us.pinguo.edit2020.bean.v) && !(f2 instanceof us.pinguo.edit2020.bean.f0)) {
            boolean z = false;
            for (us.pinguo.edit2020.bean.a aVar : this.f10268g.g()) {
                if (aVar.e()) {
                    us.pinguo.foundation.statistics.h.b.q0(aVar.f(), "save");
                }
                if (aVar.e() && aVar.a()) {
                    z = true;
                }
            }
            us.pinguo.foundation.statistics.h.b.K("edit_panel_adjustment", z ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "save");
            D();
            return;
        }
        PGEditBottomTabLayout.a m = this.a.m();
        if (m == null) {
            return;
        }
        m.a();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        return (f2 instanceof us.pinguo.edit2020.bean.v) || (f2 instanceof us.pinguo.edit2020.bean.f0);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        if (!(f2 instanceof us.pinguo.edit2020.bean.v) && !(f2 instanceof us.pinguo.edit2020.bean.f0)) {
            boolean z = false;
            for (us.pinguo.edit2020.bean.a aVar : this.f10268g.g()) {
                if (aVar.e() && aVar.a()) {
                    z = true;
                }
            }
            us.pinguo.foundation.statistics.h.b.K("edit_panel_adjustment", z ? "use_vip_func_or_material" : "nonuse_vip_func_or_material", "exited");
            D();
            return;
        }
        PGEditBottomTabLayout.a m = this.a.m();
        if (m == null) {
            return;
        }
        m.c();
    }

    @Override // us.pinguo.edit2020.view.m0
    public void h(int i2) {
        us.pinguo.edit2020.bean.a f2 = this.f10268g.f();
        if (f2 == null) {
            return;
        }
        if (!this.r) {
            this.r = true;
            this.f10268g.s(this.q);
        }
        A(i2);
        this.f10266e.i(f2.c(), i2);
    }

    @Override // us.pinguo.edit2020.view.m0
    public void i(float f2) {
        m0.a.a(this, f2);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        p0.a.a(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        UnityEditCaller.Common.showOriginalTexture(z);
    }

    @Override // us.pinguo.edit2020.view.m0
    public void l(int i2) {
        if (this.q) {
            this.f10268g.s(false);
            this.r = false;
        }
        A(i2);
        this.f10266e.a();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return z2.a.d(this);
    }

    public final void show() {
        this.f10268g.b();
        this.f10268g.e(true);
        this.c.removeAllViews();
        Context context = us.pinguo.foundation.e.b();
        RecyclerView recyclerView = this.f10269h;
        if (recyclerView == null) {
            recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.layout_individual_recyclerview, this.c, true).findViewById(R.id.rvFunctions);
            Objects.requireNonNull(recyclerView, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            kotlin.jvm.internal.s.g(context, "context");
            CenterLayoutManager centerLayoutManager = new CenterLayoutManager(context, 0, false);
            recyclerView.setLayoutManager(centerLayoutManager);
            us.pinguo.edit2020.adapter.a0.u(this.f10270i, this.f10268g.g(), 0, false, 4, null);
            this.f10270i.C(new AdjustController$show$1(this));
            this.f10270i.A(new AdjustController$show$2(this));
            recyclerView.setAdapter(this.f10270i);
            us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
            gVar.a(context, this.f10270i.getItemCount(), centerLayoutManager.a(context, this.f10270i.getItemCount()));
            recyclerView.addItemDecoration(gVar);
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            this.f10269h = recyclerView;
        } else {
            this.c.addView(recyclerView);
        }
        recyclerView.scrollToPosition(0);
        this.f10270i.o();
        RelativeLayout relativeLayout = (RelativeLayout) this.f10267f.g().findViewById(R.id.flSeekBar);
        kotlin.jvm.internal.s.g(relativeLayout, "operationController.container.flSeekBar");
        relativeLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(relativeLayout, 0);
        this.f10267f.D(this);
        this.f10267f.v(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        List<us.pinguo.edit2020.bean.a> g2 = this.f10268g.g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : g2) {
            if (((us.pinguo.edit2020.bean.a) obj).e()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        p0.a.b(this);
    }
}
