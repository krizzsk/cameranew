package us.pinguo.edit2020.controller;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.AwesomeConstraintLayout;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.ManualMattingView;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.edit2020.view.loading.BgReplacementLoading;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.repository2020.database.background.Background;
import us.pinguo.repository2020.database.background.BackgroundCategory;
import us.pinguo.repository2020.database.background.MaterialState;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: BackgroundReplacementController.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementController implements e3, a3, i3, us.pinguo.edit2020.view.p0 {
    private final Bitmap A;
    private float B;
    private final CenterLayoutManager C;
    private final int[] D;
    private final int E;
    private final kotlin.f F;
    private final kotlin.f G;
    private final PointF H;
    private final kotlin.jvm.b.l<EditModel, kotlin.u> I;
    private final LifecycleOwner a;
    private final EditViewModel b;
    private final BackgroundReplacementModule c;

    /* renamed from: d  reason: collision with root package name */
    private final PGEditBottomTabLayout f10283d;

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f10284e;

    /* renamed from: f  reason: collision with root package name */
    private final BoldTipView f10285f;

    /* renamed from: g  reason: collision with root package name */
    private final us.pinguo.edit2020.utils.g f10286g;

    /* renamed from: h  reason: collision with root package name */
    private final SelectRectAdjustView f10287h;

    /* renamed from: i  reason: collision with root package name */
    private final TopSnackBar f10288i;

    /* renamed from: j  reason: collision with root package name */
    private final us.pinguo.edit2020.view.c0 f10289j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10290k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10291l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Boolean q;
    private Boolean r;
    private ManualMattingView s;
    private ConstraintLayout t;
    private final us.pinguo.edit2020.adapter.u u;
    private final Bitmap v;
    private final Bitmap w;
    private final Bitmap x;
    private final Bitmap y;
    private final Bitmap z;

    /* compiled from: BackgroundReplacementController.kt */
    /* renamed from: us.pinguo.edit2020.controller.BackgroundReplacementController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BackgroundReplacementController.this.f10287h.d0();
        }
    }

    /* compiled from: BackgroundReplacementController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements ManualMattingView.a {
        final /* synthetic */ Runnable b;

        a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // us.pinguo.edit2020.view.ManualMattingView.a
        public void a(boolean z, us.pinguo.edit2020.bean.c0 function) {
            kotlin.jvm.internal.s.h(function, "function");
            BackgroundReplacementController.this.c.v0(z ? BasicBrushMode.Erasing : BasicBrushMode.Brush, Float.valueOf(BackgroundReplacementController.this.c.N(function.h())), Float.valueOf(function.g() / 100.0f));
            ManualMattingView manualMattingView = BackgroundReplacementController.this.s;
            kotlin.jvm.internal.s.e(manualMattingView);
            if (manualMattingView.r()) {
                BackgroundReplacementModule backgroundReplacementModule = BackgroundReplacementController.this.c;
                ManualMattingView manualMattingView2 = BackgroundReplacementController.this.s;
                kotlin.jvm.internal.s.e(manualMattingView2);
                float N = backgroundReplacementModule.N(manualMattingView2.k()) * BackgroundReplacementController.this.B * 0.85f;
                BackgroundReplacementController.this.f10286g.n(N);
                BackgroundReplacementController.this.f10285f.setSize(N);
                ManualMattingView manualMattingView3 = BackgroundReplacementController.this.s;
                kotlin.jvm.internal.s.e(manualMattingView3);
                manualMattingView3.postDelayed(this.b, 500L);
            }
        }

        @Override // us.pinguo.edit2020.view.ManualMattingView.a
        public void b(boolean z, us.pinguo.edit2020.bean.c0 function) {
            kotlin.jvm.internal.s.h(function, "function");
            ManualMattingView manualMattingView = BackgroundReplacementController.this.s;
            kotlin.jvm.internal.s.e(manualMattingView);
            if (manualMattingView.r()) {
                BackgroundReplacementModule backgroundReplacementModule = BackgroundReplacementController.this.c;
                ManualMattingView manualMattingView2 = BackgroundReplacementController.this.s;
                kotlin.jvm.internal.s.e(manualMattingView2);
                float N = backgroundReplacementModule.N(manualMattingView2.k()) * BackgroundReplacementController.this.B * 0.85f;
                BackgroundReplacementController.this.f10285f.animate().cancel();
                BackgroundReplacementController.this.f10285f.setAlpha(1.0f);
                BoldTipView boldTipView = BackgroundReplacementController.this.f10285f;
                boldTipView.setVisibility(0);
                VdsAgent.onSetViewVisibility(boldTipView, 0);
                BackgroundReplacementController.this.f10285f.setSize(N);
                BackgroundReplacementController.this.f10286g.o(N);
            }
        }
    }

    /* compiled from: BackgroundReplacementController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements SelectRectAdjustView.a {
        b() {
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void a() {
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void b() {
            if (kotlin.jvm.internal.s.c(BackgroundReplacementController.this.f10287h.F(), "photoItem")) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                iVar.j0("cutout", "template_cutout_layer", "click");
                BackgroundReplacementController.this.z0();
                iVar.Y("bg_add_cutout", "show");
                return;
            }
            us.pinguo.foundation.statistics.h.b.j0("copy", "template_material_layer", "click");
            BackgroundReplacementController.this.c.w(BackgroundReplacementController.this.f10287h.F(), BackgroundReplacementController.this.f10287h.K(), BackgroundReplacementController.this.f10287h.L(), Integer.valueOf((int) BackgroundReplacementController.this.f10287h.G()));
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void c() {
            BackgroundReplacementController.this.c.t0(BackgroundReplacementController.this.f10287h.I());
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void d() {
            if (kotlin.jvm.internal.s.c("photoItem", BackgroundReplacementController.this.f10287h.F())) {
                if (BackgroundReplacementController.this.f10287h.F().length() > 0) {
                    if (kotlin.jvm.internal.s.c(BackgroundReplacementController.this.f10287h.F(), "photoItem")) {
                        us.pinguo.foundation.statistics.h.b.j0("replace", "template_cutout_layer", "click");
                    } else {
                        us.pinguo.foundation.statistics.h.b.j0("replace", "template_material_layer", "click");
                    }
                }
                BackgroundReplacementController.this.b.G();
                return;
            }
            if (BackgroundReplacementController.this.f10287h.F().length() > 0) {
                us.pinguo.foundation.statistics.h.b.j0("delete", "template_material_layer", "click");
            }
            BackgroundReplacementController.this.c.x(BackgroundReplacementController.this.f10287h.F());
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void e() {
            if (BackgroundReplacementController.this.f10287h.F().length() > 0) {
                if (kotlin.jvm.internal.s.c(BackgroundReplacementController.this.f10287h.F(), "photoItem")) {
                    us.pinguo.foundation.statistics.h.b.j0("flip", "template_cutout_layer", "click");
                } else {
                    us.pinguo.foundation.statistics.h.b.j0("flip", "template_material_layer", "click");
                }
                BackgroundReplacementController.this.f10287h.E();
                BackgroundReplacementController.this.c.a0(BackgroundReplacementController.this.f10287h.F(), BackgroundReplacementController.this.f10287h.L());
            }
        }

        @Override // us.pinguo.edit2020.view.SelectRectAdjustView.a
        public void f(PointF pointF) {
            kotlin.jvm.internal.s.h(pointF, "pointF");
            pointF.set(pointF.x / BackgroundReplacementController.this.f10287h.getWidth(), 1 - (pointF.y / BackgroundReplacementController.this.f10287h.getHeight()));
            if (BackgroundReplacementController.this.f10290k) {
                return;
            }
            BackgroundReplacementController.this.c.s0(pointF);
        }
    }

    /* compiled from: BackgroundReplacementController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements TabLayout.d {
        private int a;
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> c;

        c(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
            this.c = ref$ObjectRef;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            List<BackgroundCategory> H = BackgroundReplacementController.this.c.H();
            BackgroundCategory backgroundCategory = H.get(tab.g());
            int g2 = tab.g();
            if (kotlin.jvm.internal.s.c(backgroundCategory, BackgroundReplacementController.this.c.Q())) {
                return;
            }
            BackgroundReplacementController.this.c.x0(backgroundCategory);
            int i2 = 0;
            BackgroundReplacementController backgroundReplacementController = BackgroundReplacementController.this;
            Ref$ObjectRef<ConstraintLayout> ref$ObjectRef = this.c;
            for (BackgroundCategory backgroundCategory2 : H) {
                if (kotlin.jvm.internal.s.c(backgroundCategory2, backgroundCategory)) {
                    int i3 = i2 + 1;
                    int i4 = this.a;
                    if (g2 == i4 - 1 || g2 == i4 + 1) {
                        CenterLayoutManager centerLayoutManager = backgroundReplacementController.C;
                        Context context = ref$ObjectRef.element.getContext();
                        kotlin.jvm.internal.s.g(context, "layout.context");
                        centerLayoutManager.b(context, i3, 50.0f);
                        return;
                    }
                    backgroundReplacementController.C.scrollToPositionWithOffset(i3, us.pinguo.common.widget.i.a.a(138));
                    return;
                }
                i2 += backgroundCategory2.getPids().length;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f fVar) {
            this.a = fVar == null ? 0 : fVar.g();
        }
    }

    /* compiled from: BackgroundReplacementController.kt */
    /* loaded from: classes4.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        final /* synthetic */ Ref$ObjectRef<ConstraintLayout> b;

        d(Ref$ObjectRef<ConstraintLayout> ref$ObjectRef) {
            this.b = ref$ObjectRef;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
            if (i2 == 0) {
                BackgroundReplacementController backgroundReplacementController = BackgroundReplacementController.this;
                TabLayout tabLayout = (TabLayout) this.b.element.findViewById(R.id.tabTemplateCategory);
                kotlin.jvm.internal.s.g(tabLayout, "layout.tabTemplateCategory");
                backgroundReplacementController.r0(recyclerView, tabLayout);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            kotlin.jvm.internal.s.h(recyclerView, "recyclerView");
            if (recyclerView.getScrollState() != 1) {
                return;
            }
            BackgroundReplacementController backgroundReplacementController = BackgroundReplacementController.this;
            TabLayout tabLayout = (TabLayout) this.b.element.findViewById(R.id.tabTemplateCategory);
            kotlin.jvm.internal.s.g(tabLayout, "layout.tabTemplateCategory");
            backgroundReplacementController.r0(recyclerView, tabLayout);
        }
    }

    /* compiled from: BackgroundReplacementController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements us.pinguo.ui.widget.h {
        e() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            BackgroundCategory Q;
            us.pinguo.edit2020.bean.f R = BackgroundReplacementController.this.c.R();
            if (R == null || (Q = BackgroundReplacementController.this.c.Q()) == null) {
                return;
            }
            if (R.g() == 0) {
                us.pinguo.foundation.statistics.h.b.z0(Q.getTid(), R.f(), "adjust_color");
            } else {
                us.pinguo.foundation.statistics.h.b.z0(Q.getTid(), R.f(), "adjust_filter");
            }
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            us.pinguo.edit2020.bean.f R = BackgroundReplacementController.this.c.R();
            if (R == null) {
                return;
            }
            if (R.g() == 0) {
                R.q(i2);
                BackgroundReplacementController.this.c.D0(i2 / 100.0f);
                return;
            }
            R.r(i2);
            BackgroundReplacementController.this.c.A0(i2 / 100.0f);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    public BackgroundReplacementController(LifecycleOwner lifecycleOwner, EditViewModel editViewModel, BackgroundReplacementModule module, PGEditBottomTabLayout tabLayout, FrameLayout flPanelContainer, BoldTipView imgBoldTip, us.pinguo.edit2020.utils.g magnifierUtils, SelectRectAdjustView selectRectAdjustView, TopSnackBar topSnackBar, us.pinguo.edit2020.view.c0 userOperationController) {
        kotlin.f b2;
        kotlin.f a2;
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(editViewModel, "editViewModel");
        kotlin.jvm.internal.s.h(module, "module");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(imgBoldTip, "imgBoldTip");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(selectRectAdjustView, "selectRectAdjustView");
        kotlin.jvm.internal.s.h(topSnackBar, "topSnackBar");
        kotlin.jvm.internal.s.h(userOperationController, "userOperationController");
        this.a = lifecycleOwner;
        this.b = editViewModel;
        this.c = module;
        this.f10283d = tabLayout;
        this.f10284e = flPanelContainer;
        this.f10285f = imgBoldTip;
        this.f10286g = magnifierUtils;
        this.f10287h = selectRectAdjustView;
        this.f10288i = topSnackBar;
        this.f10289j = userOperationController;
        this.m = true;
        this.u = new us.pinguo.edit2020.adapter.u();
        this.v = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_tihuan);
        this.w = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_koutu);
        this.x = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_jingxiang);
        this.y = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_xuanzhuan);
        this.z = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_add);
        this.A = BitmapFactory.decodeResource(tabLayout.getContext().getResources(), R.drawable.edit_icon_delete);
        this.B = us.pinguo.foundation.utils.n0.i();
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        this.C = new CenterLayoutManager(b3, 0, false);
        this.D = new int[]{Color.parseColor("#ee5e50"), Color.parseColor("#d48df8"), Color.parseColor("#3a64bf"), Color.parseColor("#abedf1"), Color.parseColor("#aad772"), Color.parseColor("#f8cd46")};
        this.E = Color.parseColor("#FF999999");
        b2 = kotlin.h.b(new BackgroundReplacementController$newLoadingControl$2(this));
        this.F = b2;
        a2 = kotlin.h.a(LazyThreadSafetyMode.NONE, new BackgroundReplacementController$ivToggleMarkedArea$2(this));
        this.G = a2;
        this.H = new PointF(0.0f, 0.0f);
        module.E0(new AnonymousClass1());
        editViewModel.q().observe(lifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.controller.y
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BackgroundReplacementController.a(BackgroundReplacementController.this, (String) obj);
            }
        });
        magnifierUtils.h(module);
        this.I = new BackgroundReplacementController$moduleChangePreparedCallback$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(int i2, us.pinguo.edit2020.bean.f fVar, boolean z) {
        ConstraintLayout constraintLayout = this.t;
        if (constraintLayout == null) {
            return;
        }
        int P = this.c.P(i2);
        BackgroundCategory backgroundCategory = this.c.H().get(P);
        this.c.x0(backgroundCategory);
        TabLayout.f z2 = ((TabLayout) constraintLayout.findViewById(R.id.tabTemplateCategory)).z(P);
        if (z2 != null) {
            z2.l();
        }
        CenterLayoutManager centerLayoutManager = this.C;
        Context context = constraintLayout.getContext();
        kotlin.jvm.internal.s.g(context, "layout.context");
        centerLayoutManager.b(context, i2, 80.0f);
        if (!z) {
            B0(constraintLayout);
        }
        if (z && fVar.h() != null) {
            int i3 = R.id.clControl;
            AwesomeConstraintLayout awesomeConstraintLayout = (AwesomeConstraintLayout) constraintLayout.findViewById(i3);
            kotlin.jvm.internal.s.g(awesomeConstraintLayout, "layout.clControl");
            if (awesomeConstraintLayout.getVisibility() == 0) {
                B0(constraintLayout);
                return;
            }
            AwesomeConstraintLayout awesomeConstraintLayout2 = (AwesomeConstraintLayout) constraintLayout.findViewById(i3);
            kotlin.jvm.internal.s.g(awesomeConstraintLayout2, "layout.clControl");
            awesomeConstraintLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(awesomeConstraintLayout2, 0);
            View findViewById = constraintLayout.findViewById(R.id.viewDivider);
            kotlin.jvm.internal.s.g(findViewById, "layout.viewDivider");
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
            if (fVar.h().getSupport_color() == 1) {
                LinearLayout linearLayout = (LinearLayout) constraintLayout.findViewById(R.id.llColorAndFilter);
                kotlin.jvm.internal.s.g(linearLayout, "layout.llColorAndFilter");
                linearLayout.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout, 0);
                TextView textView = (TextView) constraintLayout.findViewById(R.id.txtSingleFilter);
                kotlin.jvm.internal.s.g(textView, "layout.txtSingleFilter");
                textView.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView, 8);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) constraintLayout.findViewById(R.id.llColorAndFilter);
                kotlin.jvm.internal.s.g(linearLayout2, "layout.llColorAndFilter");
                linearLayout2.setVisibility(8);
                VdsAgent.onSetViewVisibility(linearLayout2, 8);
                TextView textView2 = (TextView) constraintLayout.findViewById(R.id.txtSingleFilter);
                kotlin.jvm.internal.s.g(textView2, "layout.txtSingleFilter");
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
            }
            us.pinguo.foundation.statistics.h.b.z0(backgroundCategory.getTid(), fVar.f(), "show_adjust");
            return;
        }
        Background h2 = fVar.h();
        if ((h2 == null ? null : h2.getState()) == MaterialState.NOT_DOWNLOADED) {
            this.c.A(fVar, new BackgroundReplacementController$handleTemplateSelected$1(fVar, this), new BackgroundReplacementController$handleTemplateSelected$2(this, fVar));
        } else {
            v0(fVar.f(), fVar);
        }
        us.pinguo.foundation.statistics.h.b.z0(fVar.i(), fVar.f(), "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0(ConstraintLayout constraintLayout) {
        BackgroundCategory Q;
        if (constraintLayout.getVisibility() == 0) {
            AwesomeConstraintLayout awesomeConstraintLayout = (AwesomeConstraintLayout) constraintLayout.findViewById(R.id.clControl);
            kotlin.jvm.internal.s.g(awesomeConstraintLayout, "layout.clControl");
            awesomeConstraintLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(awesomeConstraintLayout, 4);
            View findViewById = constraintLayout.findViewById(R.id.viewDivider);
            kotlin.jvm.internal.s.g(findViewById, "layout.viewDivider");
            findViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(findViewById, 4);
            us.pinguo.edit2020.bean.f R = this.c.R();
            if (R == null || (Q = this.c.Q()) == null) {
                return;
            }
            us.pinguo.foundation.statistics.h.b.z0(Q.getTid(), R.f(), "hide_adjust");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        this.f10287h.setFuntionClickListener(new b());
        this.f10287h.setOnLayerStatusChange(new BackgroundReplacementController$initSelectRectView$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(String str, float f2, float f3, float f4, float f5, float f6, float f7, int i2, int i3) {
        us.pinguo.common.log.a.m(TJAdUnitConstants.String.VIDEO_INFO, "==================key=" + str + ",normalizedSizeX=" + f2 + ",normalizedSizeY=" + f3 + ",stickerStatus=" + i3 + "，normalizedCenterX=" + f4 + ",normalizedCenterY=" + f5, new Object[0]);
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new BackgroundReplacementController$onBgItemChanged$1(this, str, i3, f6, f4, f5, f2, f3, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K0() {
        N0();
        this.f10286g.c();
        this.r = null;
        this.q = null;
        this.f10290k = false;
        this.c.J0(false);
        this.f10288i.a();
        this.f10287h.V(true);
        this.f10283d.E(true);
        this.f10289j.F(false);
        this.f10289j.u(false);
        this.c.p0();
        this.c.v0(BasicBrushMode.None, null, null);
        ConstraintLayout constraintLayout = this.t;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout, 0);
        }
        us.pinguo.edit2020.bean.f R = this.c.R();
        if (kotlin.jvm.internal.s.c(R != null ? R.f() : null, "original")) {
            this.c.j0();
            BackgroundReplacementModule backgroundReplacementModule = this.c;
            backgroundReplacementModule.P0("photoItem", backgroundReplacementModule.Y().b(), this.c.Y().a(), 0);
        }
        ManualMattingView manualMattingView = this.s;
        if (manualMattingView == null) {
            return;
        }
        manualMattingView.x();
        manualMattingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(manualMattingView, 8);
    }

    private final void L0() {
        this.c.m0();
        this.c.q(new BackgroundReplacementController$quitWithApplyManualMatting$1(this));
        us.pinguo.foundation.statistics.h.b.Y("", "save");
    }

    private final void M0() {
        this.c.w0(false);
        if (this.f10287h.F().length() == 0) {
            this.c.K0();
            this.c.t0("photoItem");
        }
        K0();
    }

    private final void N0() {
        ViewParent parent = x0().getParent();
        if (us.pinguo.edit2020.utils.d.e(parent)) {
            return;
        }
        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).removeView(x0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(us.pinguo.edit2020.bean.c0 c0Var) {
        BackgroundReplacementModule backgroundReplacementModule = this.c;
        backgroundReplacementModule.v0(BasicBrushMode.Erasing, Float.valueOf(backgroundReplacementModule.N(c0Var.h())), Float.valueOf(c0Var.g() / 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r1v9, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    public final void P0() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.t;
        ref$ObjectRef.element = r1;
        if (r1 == 0) {
            View inflate = LayoutInflater.from(this.f10284e.getContext()).inflate(R.layout.layout_background_template_panel, (ViewGroup) this.f10284e, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ?? r12 = (ConstraintLayout) inflate;
            ref$ObjectRef.element = r12;
            this.t = (ConstraintLayout) r12;
            us.pinguo.edit2020.adapter.v vVar = new us.pinguo.edit2020.adapter.v();
            vVar.e(true);
            vVar.a(Color.parseColor("#eeeeee"));
            Context context = ((ConstraintLayout) ref$ObjectRef.element).getContext();
            kotlin.jvm.internal.s.g(context, "layout.context");
            vVar.b(us.pinguo.util.g.b(context, 20.0f));
            Context context2 = ((ConstraintLayout) ref$ObjectRef.element).getContext();
            kotlin.jvm.internal.s.g(context2, "layout.context");
            vVar.d(us.pinguo.util.g.b(context2, 0.5f));
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = this.c.H().iterator();
            int i2 = 0;
            int i3 = 1;
            while (true) {
                if (it.hasNext()) {
                    Object next = it.next();
                    int i4 = i2 + 1;
                    if (i2 >= 0) {
                        BackgroundCategory backgroundCategory = (BackgroundCategory) next;
                        i3 += backgroundCategory.getPids().length;
                        arrayList.add(Integer.valueOf(i3 - 1));
                        int i5 = R.id.tabTemplateCategory;
                        TabLayout.f F = ((TabLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i5)).F();
                        kotlin.jvm.internal.s.g(F, "layout.tabTemplateCategory.newTab()");
                        F.r(backgroundCategory.getName());
                        ((TabLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i5)).g(F, i2 == 0);
                        i2 = i4;
                    } else {
                        kotlin.collections.s.n();
                        throw null;
                    }
                } else {
                    ((TabLayout) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.tabTemplateCategory)).d(new c(ref$ObjectRef));
                    if (true ^ arrayList.isEmpty()) {
                        kotlin.collections.s.v(arrayList);
                    }
                    vVar.c(arrayList);
                    this.u.j(this.c.G());
                    this.u.m(new BackgroundReplacementController$showBackgroundTemplatePanel$3(this));
                    int i6 = R.id.rvBackgroundTemplate;
                    ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).setLayoutManager(this.C);
                    ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).addItemDecoration(vVar);
                    ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).setAdapter(this.u);
                    RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).getItemAnimator();
                    SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
                    if (simpleItemAnimator != null) {
                        simpleItemAnimator.setSupportsChangeAnimations(false);
                    }
                    ((RecyclerView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i6)).addOnScrollListener(new d(ref$ObjectRef));
                    ((TextView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.txtAdjustColor)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.u
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BackgroundReplacementController.Q0(BackgroundReplacementController.this, ref$ObjectRef, view);
                        }
                    });
                    ((TextView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.txtAdjustFilter)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.z
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BackgroundReplacementController.R0(BackgroundReplacementController.this, ref$ObjectRef, view);
                        }
                    });
                    int i7 = R.id.seekBar;
                    ((StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i7)).setDotStyle(StickySeekBar.DefaultDotStyle.RECT);
                    ((StickySeekBar) ((ConstraintLayout) ref$ObjectRef.element).findViewById(i7)).setTrackListener(new e());
                }
            }
        }
        if (((ConstraintLayout) ref$ObjectRef.element).getParent() == null) {
            this.f10284e.addView((View) ref$ObjectRef.element);
        }
        View view = (View) ref$ObjectRef.element;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(BackgroundReplacementController this$0, Ref$ObjectRef layout, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(layout, "$layout");
        us.pinguo.edit2020.bean.f R = this$0.c.R();
        if (R == null || R.g() == 0) {
            return;
        }
        R.n(0);
        int i2 = R.id.seekBar;
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setValues(-100, 100, R.j(), 0);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setDotStyle(StickySeekBar.DefaultDotStyle.RECT);
        int[] iArr = this$0.D;
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setTrackColor(iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setDotColor(-1);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Resources resources = textView.getResources();
        textView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_color_filter_selected, null));
        textView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_black, null));
        int i3 = R.id.txtAdjustFilter;
        ((TextView) ((ConstraintLayout) layout.element).findViewById(i3)).setBackground(null);
        ((TextView) ((ConstraintLayout) layout.element).findViewById(i3)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_light, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(BackgroundReplacementController this$0, Ref$ObjectRef layout, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(layout, "$layout");
        us.pinguo.edit2020.bean.f R = this$0.c.R();
        if (R == null || R.g() == 1) {
            return;
        }
        R.n(1);
        int i2 = R.id.seekBar;
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setValues(0, 100, R.k(), 50);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setTrackColor(this$0.E);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(i2)).setDotColor(this$0.E);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Resources resources = textView.getResources();
        textView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_color_filter_selected, null));
        textView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_black, null));
        int i3 = R.id.txtAdjustColor;
        ((TextView) ((ConstraintLayout) layout.element).findViewById(i3)).setBackground(null);
        ((TextView) ((ConstraintLayout) layout.element).findViewById(i3)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_light, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0() {
        this.f10283d.E(false);
        ManualMattingView s0 = s0();
        if (s0.getParent() == null) {
            this.f10284e.addView(s0);
        }
        s0.setVisibility(0);
        VdsAgent.onSetViewVisibility(s0, 0);
        ManualMattingView.v(s0, this.c.W(), null, 2, null);
        this.f10289j.u(true);
        p0();
        float N = this.c.N(s0.k()) * this.B * 0.85f;
        this.f10286g.j(new BackgroundReplacementController$showManualMatting$1(N));
        this.f10286g.k(new BackgroundReplacementController$showManualMatting$2(N));
        us.pinguo.foundation.statistics.h.b.Y("show_mask", "click");
    }

    private final void T0(boolean z, boolean z2) {
        if (z) {
            y0().i();
            this.f10283d.setOnlyCancelBtCanClick(true);
            return;
        }
        y0().d(z2);
        this.f10283d.setOnlyCancelBtCanClick(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void U0(BackgroundReplacementController backgroundReplacementController, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        backgroundReplacementController.T0(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BackgroundReplacementController this$0, String str) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this$0.a), kotlinx.coroutines.z0.b(), null, new BackgroundReplacementController$2$1(str, this$0, null), 2, null);
    }

    private final void p0() {
        ViewParent parent = this.f10289j.i().getParent();
        Objects.requireNonNull(parent, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        ViewGroup.LayoutParams layoutParams = this.f10289j.i().getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        int a2 = us.pinguo.common.widget.i.a.a(40);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(a2, a2);
        layoutParams2.endToEnd = constraintLayout.getId();
        layoutParams2.bottomToTop = ((ConstraintLayout.LayoutParams) layoutParams).bottomToTop;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = us.pinguo.common.widget.i.a.a(10);
        layoutParams2.setMarginEnd(us.pinguo.common.widget.i.a.a(12));
        x0().setSelected(false);
        x0().setImageResource(R.drawable.ic_toggle_marked_area_on);
        x0().setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackgroundReplacementController.q0(BackgroundReplacementController.this, view);
            }
        });
        constraintLayout.addView(x0(), layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(BackgroundReplacementController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.x0().isSelected()) {
            this$0.x0().setSelected(false);
            this$0.x0().setImageResource(R.drawable.ic_toggle_marked_area_on);
            this$0.c.I0(false);
            us.pinguo.foundation.statistics.h.b.Y("show_mask", "click");
            return;
        }
        this$0.x0().setSelected(true);
        this$0.x0().setImageResource(R.drawable.ic_toggle_marked_area_off);
        this$0.c.I0(true);
        us.pinguo.foundation.statistics.h.b.Y("show_cutout", "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(RecyclerView recyclerView, TabLayout tabLayout) {
        String[] pids;
        int i2;
        int measuredWidth = (int) ((recyclerView.getMeasuredWidth() - recyclerView.getResources().getDimension(R.dimen.background_template_item_width)) * 0.5f);
        int childCount = recyclerView.getChildCount();
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = -1;
        while (i4 < childCount) {
            int i6 = i4 + 1;
            View childAt = recyclerView.getChildAt(i4);
            int left = childAt.getLeft();
            if (left > measuredWidth || (i2 = measuredWidth - left) >= i3) {
                i4 = i6;
            } else {
                i5 = recyclerView.getChildAdapterPosition(childAt);
                i4 = i6;
                i3 = i2;
            }
        }
        int i7 = i5 - 1;
        if (i7 == -1) {
            return;
        }
        int i8 = 0;
        int i9 = 0;
        for (Object obj : this.c.H()) {
            int i10 = i8 + 1;
            if (i8 >= 0) {
                BackgroundCategory backgroundCategory = (BackgroundCategory) obj;
                for (String str : backgroundCategory.getPids()) {
                    if (i9 == i7) {
                        if (kotlin.jvm.internal.s.c(this.c.Q(), backgroundCategory)) {
                            return;
                        }
                        this.c.x0(backgroundCategory);
                        TabLayout.f z = tabLayout.z(i8);
                        if (z == null) {
                            return;
                        }
                        z.l();
                        return;
                    }
                    i9++;
                }
                i8 = i10;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, us.pinguo.edit2020.view.ManualMattingView] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, us.pinguo.edit2020.view.ManualMattingView] */
    private final ManualMattingView s0() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = this.s;
        ref$ObjectRef.element = r1;
        if (r1 == 0) {
            View inflate = LayoutInflater.from(this.f10284e.getContext()).inflate(R.layout.layout_manual_matting_view, (ViewGroup) this.f10284e, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.ManualMattingView");
            ?? r12 = (ManualMattingView) inflate;
            ref$ObjectRef.element = r12;
            this.s = (ManualMattingView) r12;
            ((ManualMattingView) r12).setOnItemChangedListener(new BackgroundReplacementController$createManualMattingView$1(this, ref$ObjectRef));
            ((ManualMattingView) ref$ObjectRef.element).setOnTrackListener(new a(new Runnable() { // from class: us.pinguo.edit2020.controller.v
                @Override // java.lang.Runnable
                public final void run() {
                    BackgroundReplacementController.t0(BackgroundReplacementController.this);
                }
            }));
        }
        return (ManualMattingView) ref$ObjectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(final BackgroundReplacementController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10285f.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.x
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundReplacementController.u0(BackgroundReplacementController.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(BackgroundReplacementController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView boldTipView = this$0.f10285f;
        boldTipView.setVisibility(4);
        VdsAgent.onSetViewVisibility(boldTipView, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(String str, us.pinguo.edit2020.bean.f fVar) {
        int k2;
        int i2;
        int i3 = 0;
        this.f10291l = false;
        if (!this.m) {
            this.c.K0();
        } else {
            this.m = false;
        }
        us.pinguo.edit2020.bean.f R = this.c.R();
        if (R != null) {
            R.o(false);
        }
        this.c.y0(fVar);
        this.u.k(str);
        if (R != null) {
            this.c.H0(R, str);
        }
        ConstraintLayout constraintLayout = this.t;
        if (constraintLayout == null) {
            return;
        }
        Resources resources = constraintLayout.getResources();
        if (kotlin.jvm.internal.s.c(str, "original")) {
            AwesomeConstraintLayout awesomeConstraintLayout = (AwesomeConstraintLayout) constraintLayout.findViewById(R.id.clControl);
            kotlin.jvm.internal.s.g(awesomeConstraintLayout, "layout.clControl");
            awesomeConstraintLayout.setVisibility(4);
            VdsAgent.onSetViewVisibility(awesomeConstraintLayout, 4);
            View findViewById = constraintLayout.findViewById(R.id.viewDivider);
            kotlin.jvm.internal.s.g(findViewById, "layout.viewDivider");
            findViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(findViewById, 4);
            return;
        }
        AwesomeConstraintLayout awesomeConstraintLayout2 = (AwesomeConstraintLayout) constraintLayout.findViewById(R.id.clControl);
        kotlin.jvm.internal.s.g(awesomeConstraintLayout2, "layout.clControl");
        if (awesomeConstraintLayout2.getVisibility() == 0) {
            Background h2 = fVar.h();
            if (h2 != null && h2.getSupport_color() == 1) {
                LinearLayout linearLayout = (LinearLayout) constraintLayout.findViewById(R.id.llColorAndFilter);
                kotlin.jvm.internal.s.g(linearLayout, "layout.llColorAndFilter");
                linearLayout.setVisibility(0);
                VdsAgent.onSetViewVisibility(linearLayout, 0);
                TextView textView = (TextView) constraintLayout.findViewById(R.id.txtSingleFilter);
                kotlin.jvm.internal.s.g(textView, "layout.txtSingleFilter");
                textView.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView, 8);
            } else {
                LinearLayout linearLayout2 = (LinearLayout) constraintLayout.findViewById(R.id.llColorAndFilter);
                kotlin.jvm.internal.s.g(linearLayout2, "layout.llColorAndFilter");
                linearLayout2.setVisibility(8);
                VdsAgent.onSetViewVisibility(linearLayout2, 8);
                TextView textView2 = (TextView) constraintLayout.findViewById(R.id.txtSingleFilter);
                kotlin.jvm.internal.s.g(textView2, "layout.txtSingleFilter");
                textView2.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView2, 0);
            }
        }
        Background h3 = fVar.h();
        if (h3 != null && h3.getSupport_color() == 1) {
            if (fVar.g() == 0) {
                k2 = fVar.j();
                i2 = 0;
                int i4 = R.id.txtAdjustColor;
                ((TextView) constraintLayout.findViewById(i4)).setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_color_filter_selected, null));
                ((TextView) constraintLayout.findViewById(i4)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_black, null));
                int i5 = R.id.txtAdjustFilter;
                ((TextView) constraintLayout.findViewById(i5)).setBackground(null);
                ((TextView) constraintLayout.findViewById(i5)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_light, null));
                int i6 = R.id.seekBar;
                int[] iArr = this.D;
                ((StickySeekBar) constraintLayout.findViewById(i6)).setTrackColor(iArr[0], iArr[1], iArr[2], iArr[3], iArr[4], iArr[5]);
                ((StickySeekBar) constraintLayout.findViewById(i6)).setDotStyle(StickySeekBar.DefaultDotStyle.RECT);
                ((StickySeekBar) constraintLayout.findViewById(i6)).setDotColor(-1);
                i3 = -100;
            } else {
                k2 = fVar.k();
                i2 = 50;
                int i7 = R.id.txtAdjustFilter;
                ((TextView) constraintLayout.findViewById(i7)).setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_color_filter_selected, null));
                ((TextView) constraintLayout.findViewById(i7)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_black, null));
                int i8 = R.id.txtAdjustColor;
                ((TextView) constraintLayout.findViewById(i8)).setBackground(null);
                ((TextView) constraintLayout.findViewById(i8)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_light, null));
                int i9 = R.id.seekBar;
                ((StickySeekBar) constraintLayout.findViewById(i9)).setTrackColor(this.E);
                ((StickySeekBar) constraintLayout.findViewById(i9)).setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
                ((StickySeekBar) constraintLayout.findViewById(i9)).setDotColor(this.E);
            }
        } else {
            k2 = fVar.k();
            i2 = 50;
            int i10 = R.id.seekBar;
            ((StickySeekBar) constraintLayout.findViewById(i10)).setTrackColor(this.E);
            ((StickySeekBar) constraintLayout.findViewById(i10)).setDotStyle(StickySeekBar.DefaultDotStyle.CIRCLE);
            ((StickySeekBar) constraintLayout.findViewById(i10)).setDotColor(this.E);
        }
        ((StickySeekBar) constraintLayout.findViewById(R.id.seekBar)).setValues(i3, 100, k2, i2);
    }

    private final AppCompatImageView x0() {
        return (AppCompatImageView) this.G.getValue();
    }

    private final BgReplacementLoading y0() {
        return (BgReplacementLoading) this.F.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0() {
        this.c.t0("photoItem");
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new BackgroundReplacementController$gotoManualMatting$1(this, null), 2, null);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return i3.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return i3.a.c(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    @Override // us.pinguo.edit2020.controller.e3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.s.h(r5, r0)
            us.pinguo.edit2020.view.SelectRectAdjustView r0 = r4.f10287h
            r0.U(r5)
            us.pinguo.edit2020.view.ManualMattingView r0 = r4.s
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L12
        L10:
            r0 = 0
            goto L1e
        L12:
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != r1) goto L10
            r0 = 1
        L1e:
            if (r0 != 0) goto L21
            return r2
        L21:
            us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule r0 = r4.c
            us.pinguo.repository2020.u r0 = r0.O()
            java.lang.Object r0 = r0.getValue()
            us.pinguo.edit2020.bean.u0 r0 = (us.pinguo.edit2020.bean.u0) r0
            if (r0 != 0) goto L30
            return r2
        L30:
            us.pinguo.edit2020.utils.g r3 = r4.f10286g
            r3.f(r0, r5)
            int r0 = r5.getAction()
            int r5 = r5.getActionMasked()
            r5 = r5 & r0
            if (r5 == 0) goto L6d
            if (r5 == r1) goto L49
            r0 = 3
            if (r5 == r0) goto L49
            r0 = 5
            if (r5 == r0) goto L49
            goto L84
        L49:
            us.pinguo.edit2020.view.c0 r5 = r4.f10289j
            r5.F(r1)
            us.pinguo.edit2020.view.c0 r5 = r4.f10289j
            r5.u(r1)
            androidx.appcompat.widget.AppCompatImageView r5 = r4.x0()
            int r5 = r5.getVisibility()
            if (r5 != 0) goto L5f
            r5 = 1
            goto L60
        L5f:
            r5 = 0
        L60:
            if (r5 != 0) goto L84
            androidx.appcompat.widget.AppCompatImageView r5 = r4.x0()
            r5.setVisibility(r2)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r5, r2)
            goto L84
        L6d:
            r4.n = r1
            us.pinguo.edit2020.view.c0 r5 = r4.f10289j
            r5.F(r2)
            us.pinguo.edit2020.view.c0 r5 = r4.f10289j
            r5.u(r2)
            androidx.appcompat.widget.AppCompatImageView r5 = r4.x0()
            r0 = 4
            r5.setVisibility(r0)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r5, r0)
        L84:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.BackgroundReplacementController.b(android.view.MotionEvent):boolean");
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        if (f()) {
            L0();
            return;
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.h(this.f10291l ? "inconsistent" : "consistent");
        BackgroundCategory Q = this.c.Q();
        us.pinguo.edit2020.bean.f R = this.c.R();
        if (Q != null && R != null) {
            iVar.z0(Q.getTid(), R.f(), "save");
        }
        this.f10283d.j();
        w0();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        ManualMattingView manualMattingView = this.s;
        if (manualMattingView != null) {
            if (manualMattingView.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        String f2;
        String str = "";
        if (f()) {
            M0();
            us.pinguo.foundation.statistics.h.b.Y("", TJAdUnitConstants.String.CLOSE);
            return;
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        us.pinguo.edit2020.bean.f R = this.c.R();
        if (R != null && (f2 = R.f()) != null) {
            str = f2;
        }
        iVar.s(str, y0().f() ? "loading" : "done");
        this.f10283d.j();
        this.c.k0();
        this.c.t(true);
        this.c.n0();
        w0();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        us.pinguo.common.log.a.c("onUnityRecordsCallBack", new Object[0]);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        if (this.p) {
            this.n = true;
            UnityEditCaller.Common.moveNext();
        }
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        UnityEditCaller.Common.showOriginalTexture(z);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(boolean z, boolean z2) {
        this.o = z;
        this.p = z2;
        this.f10289j.J(z, z2);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.b(), null, new BackgroundReplacementController$enter$1(this, null), 2, null);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        ArrayList f2;
        us.pinguo.edit2020.bean.f R = this.c.R();
        if (R == null) {
            return null;
        }
        f2 = kotlin.collections.u.f(R);
        return f2;
    }

    public void w0() {
        TabLayout.f z;
        T0(false, true);
        this.m = true;
        this.n = false;
        this.p = false;
        this.o = false;
        this.c.B(false);
        this.u.e();
        ConstraintLayout constraintLayout = this.t;
        if (constraintLayout != null) {
            B0(constraintLayout);
            TabLayout tabLayout = (TabLayout) constraintLayout.findViewById(R.id.tabTemplateCategory);
            if (tabLayout != null && (z = tabLayout.z(0)) != null) {
                z.l();
            }
            RecyclerView recyclerView = (RecyclerView) constraintLayout.findViewById(R.id.rvBackgroundTemplate);
            if (recyclerView != null) {
                recyclerView.scrollToPosition(0);
            }
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        this.f10287h.A();
        this.f10287h.V(false);
        this.f10288i.setDismissListener(null);
        this.f10289j.u(true);
        this.f10284e.removeAllViews();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        if (this.o) {
            this.n = true;
            UnityEditCaller.Common.movePrevious();
        }
    }
}
