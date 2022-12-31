package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.CommonVideoTutorialActivity;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.LanFitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: EliminationController.kt */
/* loaded from: classes4.dex */
public final class EliminationController implements i3, us.pinguo.edit2020.view.p0, a3, e3 {
    private final us.pinguo.edit2020.viewmodel.module.f a;
    private final FrameLayout b;
    private final PGEditBottomTabLayout c;

    /* renamed from: d  reason: collision with root package name */
    private final us.pinguo.edit2020.view.c0 f10352d;

    /* renamed from: e  reason: collision with root package name */
    private final BoldTipView f10353e;

    /* renamed from: f  reason: collision with root package name */
    private final us.pinguo.edit2020.utils.g f10354f;

    /* renamed from: g  reason: collision with root package name */
    private final Group f10355g;

    /* renamed from: h  reason: collision with root package name */
    private final FragmentLoadingView f10356h;

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f10357i;

    /* renamed from: j  reason: collision with root package name */
    private ConstraintLayout f10358j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10359k;

    /* renamed from: l  reason: collision with root package name */
    private float f10360l;
    private final Handler m;
    private final int n;
    private final int o;
    private final ValueAnimator p;
    private us.pinguo.edit2020.bean.o q;
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.o> r;
    private boolean s;
    private boolean t;
    private boolean u;

    /* compiled from: EliminationController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        final /* synthetic */ Runnable b;

        a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            if (EliminationController.this.q.l() == 0) {
                UnityEditCaller.Common.INSTANCE.setMagnifierRenderUpdateMode(0);
                UnityEditCaller.RemoveSpot.setBrushSize(EliminationController.this.M());
                EliminationController.this.m.postDelayed(this.b, 500L);
                EliminationController.this.f10354f.n(EliminationController.this.M() * EliminationController.this.f10360l * 0.85f);
                EliminationController.this.f10354f.c();
                return;
            }
            UnityEditCaller.RemoveSpot.setMinBrushView(0, 0.2f, 0.2f);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            if (EliminationController.this.q.l() == 0) {
                EliminationController.this.q.o(i2);
                EliminationController.this.f10353e.animate().cancel();
                EliminationController.this.f10353e.setAlpha(1.0f);
                EliminationController.this.m.removeCallbacks(this.b);
                BoldTipView boldTipView = EliminationController.this.f10353e;
                boldTipView.setVisibility(0);
                VdsAgent.onSetViewVisibility(boldTipView, 0);
                EliminationController.this.f10353e.setSize(EliminationController.this.M() * EliminationController.this.f10360l * 0.85f);
                EliminationController.this.f10354f.o(EliminationController.this.f10353e.a());
                return;
            }
            EliminationController.this.q.n(i2);
            UnityEditCaller.RemoveSpot.setBrushGassIntensity(i2 / 100.0f);
            UnityEditCaller.RemoveSpot.setMinBrushView(1, 0.2f, 0.2f);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: EliminationController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements PGEditTabLayout.d {
        b() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void h(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.b(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            if (fVar == null) {
                return;
            }
            EliminationController eliminationController = EliminationController.this;
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = eliminationController.c.getContext();
            kotlin.jvm.internal.s.g(context, "tabLayout.context");
            aVar.a(context, TutorialModel.VIDEO_TYPE_REMOVE_PEN);
            Context context2 = eliminationController.c.getContext();
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    public EliminationController(us.pinguo.edit2020.viewmodel.module.f editModule, FrameLayout flPanelContainer, PGEditBottomTabLayout tabLayout, us.pinguo.edit2020.view.c0 userOperationController, BoldTipView imgBoldTip, us.pinguo.edit2020.utils.g magnifierUtils, Group loadingGroup, FragmentLoadingView loadingView, FrameLayout interceptor) {
        kotlin.jvm.internal.s.h(editModule, "editModule");
        kotlin.jvm.internal.s.h(flPanelContainer, "flPanelContainer");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(userOperationController, "userOperationController");
        kotlin.jvm.internal.s.h(imgBoldTip, "imgBoldTip");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(loadingGroup, "loadingGroup");
        kotlin.jvm.internal.s.h(loadingView, "loadingView");
        kotlin.jvm.internal.s.h(interceptor, "interceptor");
        this.a = editModule;
        this.b = flPanelContainer;
        this.c = tabLayout;
        this.f10352d = userOperationController;
        this.f10353e = imgBoldTip;
        this.f10354f = magnifierUtils;
        this.f10355g = loadingGroup;
        this.f10356h = loadingView;
        this.f10357i = interceptor;
        this.f10360l = us.pinguo.foundation.utils.n0.i();
        this.m = new Handler();
        this.n = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_max_in_discrete_mode);
        this.o = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_min_in_discrete_mode);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.p = valueAnimator;
        us.pinguo.edit2020.bean.o oVar = editModule.q().get(1);
        kotlin.jvm.internal.s.g(oVar, "editModule.eliminationFunctions[1]");
        this.q = oVar;
        this.r = new us.pinguo.edit2020.adapter.a0<>();
        valueAnimator.setFloatValues(0.0f, 0.5f, 0.0f);
        valueAnimator.setDuration(800L);
        valueAnimator.addUpdateListener(h1.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(EliminationController this$0, Ref$ObjectRef layout, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(layout, "$layout");
        this$0.q.p(0);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(R.id.seekBar)).setValues(0, 100, this$0.q.i(), null);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Resources resources = textView.getResources();
        textView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_tv_paint_or_eraser, null));
        textView.setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_black, null));
        int i2 = R.id.tvHardness;
        ((LanFitTextView) ((ConstraintLayout) layout.element).findViewById(i2)).setBackground(null);
        ((LanFitTextView) ((ConstraintLayout) layout.element).findViewById(i2)).setTextColor(us.pinguo.edit2020.utils.d.h(R.color.color_camera_theme_dark));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(EliminationController this$0, Ref$ObjectRef layout, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(layout, "$layout");
        this$0.q.p(1);
        ((StickySeekBar) ((ConstraintLayout) layout.element).findViewById(R.id.seekBar)).setValues(0, 100, this$0.q.h(), null);
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        Resources resources = textView.getResources();
        textView.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.bg_tv_paint_or_eraser, null));
        textView.setTextColor(resources.getColor(R.color.color_camera_theme_black));
        int i2 = R.id.tvSize;
        ((LanFitTextView) ((ConstraintLayout) layout.element).findViewById(i2)).setBackground(null);
        ((LanFitTextView) ((ConstraintLayout) layout.element).findViewById(i2)).setTextColor(ResourcesCompat.getColor(resources, R.color.color_camera_theme_dark, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float M() {
        int i2 = this.n;
        int i3 = this.o;
        return (((this.q.i() / 100.0f) * (i2 - i3)) + i3) / this.f10360l;
    }

    private final void O() {
        ConstraintLayout constraintLayout = this.f10358j;
        if (constraintLayout == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: us.pinguo.edit2020.controller.k1
            @Override // java.lang.Runnable
            public final void run() {
                EliminationController.Q(EliminationController.this);
            }
        };
        int i2 = R.id.seekBar;
        ((StickySeekBar) constraintLayout.findViewById(i2)).setValues(0, 100, this.q.i(), null);
        ((StickySeekBar) constraintLayout.findViewById(i2)).setTrackListener(new a(runnable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(final EliminationController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.f10353e.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.n1
            @Override // java.lang.Runnable
            public final void run() {
                EliminationController.T(EliminationController.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(EliminationController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        BoldTipView boldTipView = this$0.f10353e;
        boldTipView.setVisibility(4);
        VdsAgent.onSetViewVisibility(boldTipView, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        UnityEditCaller.RemoveSpot.setTotalMaskViewOpacity(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.l1
            @Override // java.lang.Runnable
            public final void run() {
                EliminationController.e0(EliminationController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(EliminationController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.u = false;
        this$0.f10356h.b();
        FragmentLoadingView fragmentLoadingView = this$0.f10356h;
        fragmentLoadingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(fragmentLoadingView, 8);
        FrameLayout frameLayout = this$0.f10357i;
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        Group group = this$0.f10355g;
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.j1
            @Override // java.lang.Runnable
            public final void run() {
                EliminationController.g0(EliminationController.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(EliminationController this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.u = true;
        Group group = this$0.f10355g;
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        FragmentLoadingView fragmentLoadingView = this$0.f10356h;
        fragmentLoadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(fragmentLoadingView, 0);
        this$0.f10356h.f(false);
        FrameLayout frameLayout = this$0.f10357i;
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        this$0.f10356h.d(true);
        this$0.f10356h.g();
    }

    private final void h0() {
        ConstraintLayout constraintLayout = this.f10358j;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        if (this.f10359k) {
            return;
        }
        this.f10359k = true;
        EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(constraintLayout.getContext(), 0, false);
        int i2 = R.id.recyclerView;
        ((RecyclerView) constraintLayout.findViewById(i2)).setLayoutManager(editFunctionLayoutManager);
        this.r.A(new EliminationController$showFunctions$1(this, constraintLayout));
        this.r.e(true, 0, 2);
        us.pinguo.edit2020.adapter.a0.u(this.r, this.a.q(), null, false, 6, null);
        this.r.z(1);
        ((RecyclerView) constraintLayout.findViewById(i2)).setAdapter(this.r);
        us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
        Context context = constraintLayout.getContext();
        kotlin.jvm.internal.s.g(context, "layout.context");
        int itemCount = this.r.getItemCount();
        Context context2 = constraintLayout.getContext();
        kotlin.jvm.internal.s.g(context2, "layout.context");
        gVar.a(context, itemCount, editFunctionLayoutManager.a(context2, this.r.getItemCount()));
        ((RecyclerView) constraintLayout.findViewById(i2)).addItemDecoration(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(final Context context) {
        us.pinguo.foundation.utils.d0.b(context);
        us.pinguo.foundation.utils.w.i(context, R.string.edit_elimination_reset, R.string.edit_elimination_reset_reset, R.string.edit_elimination_reset_cancel, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.f1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                EliminationController.k0(EliminationController.this, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.i1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                EliminationController.j0(context, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Context context, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(context, "$context");
        us.pinguo.foundation.utils.d0.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(EliminationController this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.s = true;
            UnityEditCaller.RemoveSpot.restoreToDefault();
        }
        dialogInterface.dismiss();
    }

    private final void l0() {
        View tabView = View.inflate(this.c.getContext(), R.layout.elimination_tab_item_layout, null);
        PGEditBottomTabLayout pGEditBottomTabLayout = this.c;
        kotlin.jvm.internal.s.g(tabView, "tabView");
        PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{tabView}, false, null, 6, null);
        this.c.d(new b());
        this.c.B();
    }

    private final void show() {
        LanFitTextView lanFitTextView;
        float M = M() * this.f10360l * 0.85f;
        this.f10354f.j(new EliminationController$show$1(M));
        this.f10354f.k(new EliminationController$show$2(M));
        this.f10353e.setSize(M);
        h0();
        O();
        l0();
        this.f10352d.D(this);
        this.f10352d.F(true);
        UnityEditCaller.RemoveSpot.setSpotRemoveMode(UnityEditCaller.RemoveSpot.BrushMode.BRUSH);
        UnityEditCaller.Brush.INSTANCE.setBrushMaskHighlightColor(1073676288, 1073676288);
        UnityEditCaller.RemoveSpot.setBrushSize(M());
        UnityEditCaller.RemoveSpot.setBrushGassIntensity(this.q.h() / 100.0f);
        this.a.K(new EliminationController$show$3(this));
        this.a.J(new EliminationController$show$4(this));
        ConstraintLayout constraintLayout = this.f10358j;
        if (constraintLayout != null && (lanFitTextView = (LanFitTextView) constraintLayout.findViewById(R.id.tvSize)) != null) {
            lanFitTextView.performClick();
        }
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_remove", true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "new_to_remove", false, null, 4, null);
            ConstraintLayout constraintLayout2 = this.f10358j;
            kotlin.jvm.internal.s.e(constraintLayout2);
            Context context = constraintLayout2.getContext();
            kotlin.jvm.internal.s.g(context, "contentView!!.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context, TutorialModel.VIDEO_TYPE_REMOVE_PEN);
            kVar.show();
            VdsAgent.showDialog(kVar);
        }
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    public void L() {
        ConstraintLayout constraintLayout = this.f10358j;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
            VdsAgent.onSetViewVisibility(constraintLayout, 8);
        }
        this.f10352d.F(false);
        this.s = false;
        this.t = false;
        this.a.C(false);
        for (us.pinguo.edit2020.bean.o oVar : this.a.q()) {
            oVar.n(oVar.j());
            oVar.o(oVar.k());
            oVar.m(false);
        }
        us.pinguo.edit2020.bean.o oVar2 = this.a.q().get(1);
        kotlin.jvm.internal.s.g(oVar2, "editModule.eliminationFunctions[1]");
        this.q = oVar2;
        this.r.z(1);
        this.f10354f.o(M() * this.f10360l * 0.85f);
        this.f10354f.c();
        this.a.K(null);
        this.a.J(null);
        this.a.c(false);
        this.b.removeAllViews();
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
        return this.a.e();
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.u0 value = this.a.f().getValue();
        if (value == null) {
            return false;
        }
        this.f10354f.f(value, event);
        float x = event.getX();
        float y = event.getY();
        int actionMasked = event.getActionMasked() & event.getAction();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3 || actionMasked == 5) {
                this.f10352d.F(true);
                this.f10352d.u(true);
                if (this.u) {
                    FrameLayout frameLayout = this.f10357i;
                    frameLayout.setVisibility(0);
                    VdsAgent.onSetViewVisibility(frameLayout, 0);
                }
            }
        } else if (!this.f10354f.d(value, x, y)) {
            return false;
        } else {
            this.s = false;
            this.f10352d.F(false);
            this.f10352d.u(false);
            this.r.e(true, 0);
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        L();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        L();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        this.a.x(records);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        this.s = false;
        UnityEditCaller.Common.moveNext();
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
        this.t = z;
        this.a.C(!this.s && z);
        this.f10352d.J(z, z2);
        if (z || this.r.l() == 1) {
            return;
        }
        this.r.z(1);
        this.r.o();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, androidx.constraintlayout.widget.ConstraintLayout] */
    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r0 = this.f10358j;
        ref$ObjectRef.element = r0;
        if (r0 == 0) {
            View inflate = LayoutInflater.from(this.b.getContext()).inflate(R.layout.layout_elimination, (ViewGroup) this.b, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ?? r02 = (ConstraintLayout) inflate;
            ref$ObjectRef.element = r02;
            this.f10358j = (ConstraintLayout) r02;
            ((LanFitTextView) ((ConstraintLayout) r02).findViewById(R.id.tvSize)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.g1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EliminationController.I(EliminationController.this, ref$ObjectRef, view);
                }
            });
            ((LanFitTextView) ((ConstraintLayout) ref$ObjectRef.element).findViewById(R.id.tvHardness)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.m1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EliminationController.J(EliminationController.this, ref$ObjectRef, view);
                }
            });
        }
        if (((ConstraintLayout) ref$ObjectRef.element).getParent() == null) {
            this.b.addView((View) ref$ObjectRef.element);
        }
        this.a.a(EditModel.SpotRemove);
        this.a.c(true);
        show();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        ArrayList<us.pinguo.edit2020.bean.o> q = this.a.q();
        ArrayList arrayList = new ArrayList();
        for (Object obj : q) {
            if (((us.pinguo.edit2020.bean.o) obj).e()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        this.s = false;
        UnityEditCaller.Common.movePrevious();
    }
}
