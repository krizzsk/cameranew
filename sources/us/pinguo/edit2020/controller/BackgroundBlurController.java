package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.CommonVideoTutorialActivity;
import us.pinguo.edit2020.adapter.BackgroundBlurMaterialAdapter$Companion$MaterialType;
import us.pinguo.edit2020.adapter.t;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.ManualMattingView;
import us.pinguo.edit2020.view.ProgressWheelView;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.repository2020.entity.BackgroundBlur;
import us.pinguo.repository2020.entity.BackgroundBlurMaterial;
import us.pinguo.repository2020.entity.BackgroundBlurShape;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.manager.BackgroundBlurDataManager;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: BackgroundBlurController.kt */
/* loaded from: classes4.dex */
public final class BackgroundBlurController implements i3, us.pinguo.edit2020.view.p0, a3, e3 {
    private final LifecycleOwner a;
    private final ViewGroup b;
    private final EditBackgroundBlurModule c;

    /* renamed from: d  reason: collision with root package name */
    private final us.pinguo.edit2020.utils.g f10274d;

    /* renamed from: e  reason: collision with root package name */
    private final us.pinguo.edit2020.view.c0 f10275e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f10276f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10277g;

    /* renamed from: h  reason: collision with root package name */
    private final View f10278h;

    /* renamed from: i  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.t f10279i;

    /* renamed from: j  reason: collision with root package name */
    private final View f10280j;

    /* renamed from: k  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.t f10281k;

    /* renamed from: l  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.e> f10282l;
    private ManualMattingView m;
    private float n;
    private final GuideHandler o;
    private final GuideHandler p;
    private AppCompatImageView q;
    private TextView r;
    private us.pinguo.edit2020.model.editgoto.b s;
    private boolean t;
    private final kotlin.jvm.b.l<EditModel, kotlin.u> u;

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements ManualMattingView.a {
        final /* synthetic */ BoldTipView b;
        final /* synthetic */ Runnable c;

        a(BoldTipView boldTipView, Runnable runnable) {
            this.b = boldTipView;
            this.c = runnable;
        }

        @Override // us.pinguo.edit2020.view.ManualMattingView.a
        public void a(boolean z, us.pinguo.edit2020.bean.c0 function) {
            kotlin.jvm.internal.s.h(function, "function");
            BackgroundBlurController.this.c.s0(z ? BasicBrushMode.Erasing : BasicBrushMode.Brush, Float.valueOf(BackgroundBlurController.this.c.F(function.h())), Float.valueOf(function.g() / 100.0f));
            if (BackgroundBlurController.this.m.r()) {
                float F = BackgroundBlurController.this.c.F(BackgroundBlurController.this.m.k()) * BackgroundBlurController.this.n * 0.85f;
                BackgroundBlurController.this.f10274d.n(F);
                this.b.setSize(F);
                BackgroundBlurController.this.m.postDelayed(this.c, 500L);
            }
        }

        @Override // us.pinguo.edit2020.view.ManualMattingView.a
        public void b(boolean z, us.pinguo.edit2020.bean.c0 function) {
            kotlin.jvm.internal.s.h(function, "function");
            if (BackgroundBlurController.this.m.r()) {
                float F = BackgroundBlurController.this.c.F(BackgroundBlurController.this.m.k()) * BackgroundBlurController.this.n * 0.85f;
                this.b.animate().cancel();
                this.b.setAlpha(1.0f);
                BoldTipView boldTipView = this.b;
                boldTipView.setVisibility(0);
                VdsAgent.onSetViewVisibility(boldTipView, 0);
                this.b.setSize(F);
                BackgroundBlurController.this.f10274d.o(F);
            }
        }
    }

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements t.b {
        b() {
        }

        @Override // us.pinguo.edit2020.adapter.t.b
        public void a(View view, int i2, BackgroundBlurMaterial backgroundBlurMaterial) {
            if (backgroundBlurMaterial == null) {
                return;
            }
            BackgroundBlurController.this.c.t0(backgroundBlurMaterial);
            if (backgroundBlurMaterial.isInstalled()) {
                BackgroundBlurController.this.X(backgroundBlurMaterial);
                return;
            }
            BackgroundBlurController backgroundBlurController = BackgroundBlurController.this;
            Context context = backgroundBlurController.f10276f;
            kotlin.jvm.internal.s.g(context, "context");
            backgroundBlurController.g1(context, backgroundBlurMaterial);
        }
    }

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements us.pinguo.edit2020.view.j0 {
        c() {
        }

        @Override // us.pinguo.edit2020.view.j0
        public void a(float f2, float f3, boolean z) {
            if (((float) ((int) f3)) == f3) {
                BackgroundBlurController.this.c.i0(f3);
            }
        }
    }

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements t.b {
        d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0026, code lost:
            if ((r0 != null && r0.get()) == false) goto L19;
         */
        @Override // us.pinguo.edit2020.adapter.t.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(android.view.View r4, int r5, us.pinguo.repository2020.entity.BackgroundBlurMaterial r6) {
            /*
                r3 = this;
                r4 = 1
                if (r6 != 0) goto L5
                r5 = 1
                goto L7
            L5:
                boolean r5 = r6 instanceof us.pinguo.repository2020.entity.BackgroundBlur
            L7:
                if (r5 == 0) goto L75
                r5 = r6
                us.pinguo.repository2020.entity.BackgroundBlur r5 = (us.pinguo.repository2020.entity.BackgroundBlur) r5
                if (r5 != 0) goto Lf
                return
            Lf:
                boolean r0 = r5.isCustomizeItem()
                java.lang.String r1 = "click"
                if (r0 == 0) goto L28
                androidx.databinding.ObservableBoolean r0 = r5.isSelected()
                r2 = 0
                if (r0 != 0) goto L20
            L1e:
                r4 = 0
                goto L26
            L20:
                boolean r0 = r0.get()
                if (r0 != r4) goto L1e
            L26:
                if (r4 != 0) goto L34
            L28:
                java.lang.String r4 = r5.getPid()
                java.lang.String r0 = "customization"
                boolean r4 = kotlin.jvm.internal.s.c(r4, r0)
                if (r4 == 0) goto L45
            L34:
                us.pinguo.edit2020.controller.BackgroundBlurController r4 = us.pinguo.edit2020.controller.BackgroundBlurController.this
                us.pinguo.edit2020.controller.BackgroundBlurController.c(r4, r5)
                us.pinguo.foundation.statistics.i r4 = us.pinguo.foundation.statistics.h.b
                us.pinguo.edit2020.controller.BackgroundBlurController r6 = us.pinguo.edit2020.controller.BackgroundBlurController.this
                java.lang.String r5 = us.pinguo.edit2020.controller.BackgroundBlurController.x(r6, r5)
                r4.W(r5, r1)
                goto L75
            L45:
                us.pinguo.edit2020.controller.BackgroundBlurController r4 = us.pinguo.edit2020.controller.BackgroundBlurController.this
                us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule r4 = us.pinguo.edit2020.controller.BackgroundBlurController.q(r4)
                r4.t0(r6)
                boolean r4 = r5.isInstalled()
                if (r4 == 0) goto L5a
                us.pinguo.edit2020.controller.BackgroundBlurController r4 = us.pinguo.edit2020.controller.BackgroundBlurController.this
                us.pinguo.edit2020.controller.BackgroundBlurController.a(r4, r6)
                goto L68
            L5a:
                us.pinguo.edit2020.controller.BackgroundBlurController r4 = us.pinguo.edit2020.controller.BackgroundBlurController.this
                android.content.Context r6 = us.pinguo.edit2020.controller.BackgroundBlurController.w(r4)
                java.lang.String r0 = "context"
                kotlin.jvm.internal.s.g(r6, r0)
                us.pinguo.edit2020.controller.BackgroundBlurController.T(r4, r6, r5)
            L68:
                us.pinguo.foundation.statistics.i r4 = us.pinguo.foundation.statistics.h.b
                java.lang.String r5 = r5.getPid()
                if (r5 != 0) goto L72
                java.lang.String r5 = "N/A"
            L72:
                r4.x(r5, r1)
            L75:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.BackgroundBlurController.d.a(android.view.View, int, us.pinguo.repository2020.entity.BackgroundBlurMaterial):void");
        }
    }

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements us.pinguo.edit2020.view.j0 {
        e() {
        }

        @Override // us.pinguo.edit2020.view.j0
        public void a(float f2, float f3, boolean z) {
            if (((float) ((int) f3)) == f3) {
                BackgroundBlurController.this.c.i0(f3);
            }
        }
    }

    /* compiled from: BackgroundBlurController.kt */
    /* loaded from: classes4.dex */
    public static final class f implements PGEditTabLayout.d {
        f() {
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
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = BackgroundBlurController.this.f10276f;
            kotlin.jvm.internal.s.g(context, "context");
            aVar.a(context, TutorialModel.VIDEO_TYPE_BG_BLUR);
            Context context2 = BackgroundBlurController.this.f10276f;
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    public BackgroundBlurController(LifecycleOwner lifecycleOwner, ViewGroup fragmentLayout, EditBackgroundBlurModule backgroundBlurModule, us.pinguo.edit2020.utils.g magnifierUtils, us.pinguo.edit2020.view.c0 userOperationController) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(backgroundBlurModule, "backgroundBlurModule");
        kotlin.jvm.internal.s.h(magnifierUtils, "magnifierUtils");
        kotlin.jvm.internal.s.h(userOperationController, "userOperationController");
        this.a = lifecycleOwner;
        this.b = fragmentLayout;
        this.c = backgroundBlurModule;
        this.f10274d = magnifierUtils;
        this.f10275e = userOperationController;
        Context context = fragmentLayout.getContext();
        this.f10276f = context;
        LayoutInflater from = LayoutInflater.from(context);
        int i2 = R.layout.layout_background_blur_panel;
        int i3 = R.id.flIrregularPanelContainer;
        this.f10278h = from.inflate(i2, (ViewGroup) ((FrameLayout) fragmentLayout.findViewById(i3)), false);
        this.f10279i = new us.pinguo.edit2020.adapter.t(backgroundBlurModule.C(), BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR);
        this.f10280j = LayoutInflater.from(context).inflate(R.layout.layout_background_blur_customize_lens, (ViewGroup) ((FrameLayout) fragmentLayout.findViewById(i3)), false);
        this.f10281k = new us.pinguo.edit2020.adapter.t(backgroundBlurModule.D(), BackgroundBlurMaterialAdapter$Companion$MaterialType.BACKGROUND_BLUR_SHAPE);
        this.f10282l = new us.pinguo.edit2020.adapter.a0<>();
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_manual_matting_view, (ViewGroup) ((FrameLayout) fragmentLayout.findViewById(i3)), false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.view.ManualMattingView");
        this.m = (ManualMattingView) inflate;
        this.n = us.pinguo.foundation.utils.n0.i();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuideHandler k2 = GuideHandler.k((Activity) context);
        k2.H("user_handle_matting", Integer.MAX_VALUE);
        GuideHandler.Gravity gravity = GuideHandler.Gravity.LEFT;
        k2.B(gravity);
        GuideHandler.VGravity vGravity = GuideHandler.VGravity.UP;
        k2.G(vGravity);
        k2.w(false);
        int i4 = R.drawable.guide_toast_left;
        k2.A(i4);
        k2.z(32, 8);
        int i5 = R.string.background_blur_try_hand_matting;
        k2.F(context.getString(i5));
        k2.E(true);
        k2.D(us.pinguo.foundation.utils.n0.c(8), 0, us.pinguo.foundation.utils.n0.c(8), 0);
        this.o = k2;
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuideHandler k3 = GuideHandler.k((Activity) context);
        k3.H("user_handle_matting_once", 1);
        k3.B(gravity);
        k3.G(vGravity);
        k3.w(false);
        k3.A(i4);
        k3.z(32, 8);
        k3.F(context.getString(i5));
        k3.E(true);
        k3.D(us.pinguo.foundation.utils.n0.c(8), 0, us.pinguo.foundation.utils.n0.c(8), 0);
        this.p = k3;
        v0();
        this.t = us.pinguo.repository2020.utils.o.b(us.pinguo.repository2020.utils.o.a, "new_to_bg_blur", true, null, 4, null);
        this.u = new BackgroundBlurController$moduleChangePreparedCallback$1(this);
    }

    private final void N0(BackgroundBlurMaterial backgroundBlurMaterial) {
        Integer valueOf;
        ObservableBoolean isSelected;
        ObservableBoolean isSelected2;
        if (backgroundBlurMaterial instanceof BackgroundBlur) {
            BackgroundBlur O = this.c.O();
            if (O != null && (isSelected2 = O.isSelected()) != null) {
                isSelected2.set(false);
            }
            EditBackgroundBlurModule editBackgroundBlurModule = this.c;
            editBackgroundBlurModule.A0(editBackgroundBlurModule.O());
            BackgroundBlur backgroundBlur = (BackgroundBlur) backgroundBlurMaterial;
            this.c.u0(backgroundBlur);
            this.c.C0(backgroundBlur);
            ObservableBoolean isSelected3 = backgroundBlurMaterial.isSelected();
            if (isSelected3 != null) {
                isSelected3.set(true);
            }
            List<BackgroundBlur> C = this.c.C();
            valueOf = C != null ? Integer.valueOf(C.indexOf(backgroundBlurMaterial)) : null;
            if (valueOf == null) {
                return;
            }
            int intValue = valueOf.intValue();
            RecyclerView rvBackgroundBlur = (RecyclerView) this.f10278h.findViewById(R.id.rvBackgroundBlur);
            kotlin.jvm.internal.s.g(rvBackgroundBlur, "rvBackgroundBlur");
            V0(rvBackgroundBlur, intValue);
        } else if (backgroundBlurMaterial instanceof BackgroundBlurShape) {
            BackgroundBlurShape P = this.c.P();
            if (P != null && (isSelected = P.isSelected()) != null) {
                isSelected.set(false);
            }
            BackgroundBlurShape backgroundBlurShape = (BackgroundBlurShape) backgroundBlurMaterial;
            this.c.w0(backgroundBlurShape);
            this.c.D0(backgroundBlurShape);
            ObservableBoolean isSelected4 = backgroundBlurMaterial.isSelected();
            if (isSelected4 != null) {
                isSelected4.set(true);
            }
            List<BackgroundBlurShape> D = this.c.D();
            valueOf = D != null ? Integer.valueOf(D.indexOf(backgroundBlurMaterial)) : null;
            if (valueOf == null) {
                return;
            }
            int intValue2 = valueOf.intValue();
            RecyclerView rvBackgroundBlurShape = (RecyclerView) this.f10280j.findViewById(R.id.rvBackgroundBlurShape);
            kotlin.jvm.internal.s.g(rvBackgroundBlurShape, "rvBackgroundBlurShape");
            V0(rvBackgroundBlurShape, intValue2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(BackgroundBlurController this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.j0();
            us.pinguo.foundation.statistics.h.b.W("my_lens", "exited");
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(BackgroundBlurController this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.Y();
            us.pinguo.foundation.statistics.h.b.W("create", "exited");
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(BackgroundBlurController this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.T0();
            us.pinguo.foundation.statistics.h.b.W("my_lens", "save");
        }
        dialogInterface.cancel();
    }

    private final void R0() {
        AppCompatImageView appCompatImageView = this.q;
        if (appCompatImageView == null) {
            return;
        }
        this.b.removeView(appCompatImageView);
    }

    private final void S0() {
        TextView textView = this.r;
        if (textView == null) {
            return;
        }
        this.b.removeView(textView);
    }

    private final void T0() {
        this.c.c0(new BackgroundBlurController$requestBokehIconTextureWithCurrentBokehValue$1(this));
    }

    private final void U() {
        int a2 = us.pinguo.common.widget.i.a.a(52);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(a2, a2);
        layoutParams.endToStart = ((AppCompatImageView) this.b.findViewById(R.id.showOriginPicBt)).getId();
        layoutParams.topToBottom = ((ConstraintLayout) this.b.findViewById(R.id.clHeader)).getId();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = us.pinguo.common.widget.i.a.a(20);
        if (this.q == null) {
            AppCompatImageView appCompatImageView = new AppCompatImageView(this.b.getContext());
            int a3 = us.pinguo.common.widget.i.a.a(10);
            appCompatImageView.setPadding(a3, a3, a3, a3);
            appCompatImageView.setImageResource(R.drawable.ic_delete_customized_lens);
            appCompatImageView.setTranslationY(-us.pinguo.edit2020.utils.d.i(R.dimen.diff_icon_move_distance));
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BackgroundBlurController.V(BackgroundBlurController.this, view);
                }
            });
            appCompatImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            appCompatImageView.setLayoutParams(layoutParams);
            this.q = appCompatImageView;
        }
        AppCompatImageView appCompatImageView2 = this.q;
        if (appCompatImageView2 == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) appCompatImageView2.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(appCompatImageView2);
        }
        this.b.addView(appCompatImageView2);
    }

    private final void U0() {
        this.c.g0();
        this.m.x();
        this.m.setCurrentBrushSize(40);
        this.m.setDefaultBrushSize(40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(BackgroundBlurController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.Z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(RecyclerView recyclerView, int i2) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        View findViewByPosition = layoutManager == null ? null : layoutManager.findViewByPosition(i2);
        if (findViewByPosition == null) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new BackgroundBlurController$scrollRecyclerView$1(recyclerView, i2, null), 3, null);
        } else {
            recyclerView.smoothScrollBy((findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2)) - (us.pinguo.foundation.utils.n0.i() / 2), 0);
        }
    }

    private final void W() {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, us.pinguo.common.widget.i.a.a(40));
        layoutParams.startToStart = this.b.getId();
        layoutParams.endToEnd = this.b.getId();
        layoutParams.topToBottom = this.b.findViewById(R.id.viewHairCut).getId();
        TextView textView = this.r;
        if (textView == null) {
            textView = new TextView(this.b.getContext());
            textView.setPadding(12, 12, 12, 12);
            textView.setText(textView.getContext().getString(R.string.background_blur_manual_hint));
            textView.setTextSize(14.0f);
            textView.setTextColor(us.pinguo.edit2020.utils.d.h(R.color.white));
            textView.setGravity(17);
            textView.setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.black_80));
            this.r = textView;
        }
        if (textView == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) textView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(textView);
        }
        this.b.addView(textView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W0(BasicBrushMode basicBrushMode, us.pinguo.edit2020.bean.c0 c0Var) {
        EditBackgroundBlurModule editBackgroundBlurModule = this.c;
        editBackgroundBlurModule.s0(basicBrushMode, Float.valueOf(editBackgroundBlurModule.F(c0Var.h())), Float.valueOf(c0Var.g() / 100.0f));
        float F = this.c.F(this.m.k()) * this.n * 0.85f;
        ((BoldTipView) this.b.findViewById(R.id.imgBoldTip)).setSize(F);
        this.f10274d.o(F);
        this.f10274d.n(F);
        this.f10274d.j(BackgroundBlurController$setPaintOrEraser$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(BackgroundBlurMaterial backgroundBlurMaterial) {
        if (kotlin.jvm.internal.s.c(this.c.I(), backgroundBlurMaterial)) {
            this.c.h(backgroundBlurMaterial);
            N0(backgroundBlurMaterial);
        }
    }

    private final void X0() {
        Y0();
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).d(new f());
    }

    private final void Y() {
        EditBackgroundBlurModule editBackgroundBlurModule = this.c;
        editBackgroundBlurModule.u0(editBackgroundBlurModule.N());
        EditBackgroundBlurModule editBackgroundBlurModule2 = this.c;
        editBackgroundBlurModule2.t0(editBackgroundBlurModule2.N());
        BackgroundBlur J = this.c.J();
        if (J != null) {
            X(J);
        }
        m0();
    }

    private final void Y0() {
        Context context = this.f10276f;
        kotlin.jvm.internal.s.g(context, "context");
        View a2 = us.pinguo.edit2020.utils.d.a(context, R.string.background_blur, false, true);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{a2}, false, null, 6, null);
    }

    private final void Z(BackgroundBlurMaterial backgroundBlurMaterial) {
        if (backgroundBlurMaterial == null) {
            return;
        }
        ObservableField<MaterialInstallState> installState = backgroundBlurMaterial.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        BackgroundBlurDataManager.a.h(backgroundBlurMaterial, new BackgroundBlurController$downloadBackgroundBlurMaterial$1(this));
    }

    private final void Z0() {
        String name;
        Context context = this.f10278h.getContext();
        String string = context.getString(R.string.delete_lens_title);
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String string2 = context.getString(R.string.delete_lens_message);
        kotlin.jvm.internal.s.g(string2, "context.getString(R.string.delete_lens_message)");
        Object[] objArr = new Object[1];
        BackgroundBlur Q = this.c.Q();
        String str = "";
        if (Q != null && (name = Q.getName()) != null) {
            str = name;
        }
        objArr[0] = str;
        String format = String.format(string2, Arrays.copyOf(objArr, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        AlertDialog h2 = us.pinguo.foundation.utils.w.h(context, string, format, context.getString(R.string.confirm), context.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                BackgroundBlurController.a1(BackgroundBlurController.this, dialogInterface, i2);
            }
        });
        h2.show();
        VdsAgent.showDialog(h2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(BackgroundBlurController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(BackgroundBlurController this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.c.x();
            this$0.f10279i.notifyDataSetChanged();
            List<BackgroundBlur> C = this$0.c.C();
            if (this$0.c.N() != null && !kotlin.jvm.internal.s.c(this$0.c.N(), this$0.c.J())) {
                EditBackgroundBlurModule editBackgroundBlurModule = this$0.c;
                editBackgroundBlurModule.u0(editBackgroundBlurModule.N());
                EditBackgroundBlurModule editBackgroundBlurModule2 = this$0.c;
                editBackgroundBlurModule2.t0(editBackgroundBlurModule2.J());
            } else {
                if (!(C == null || C.isEmpty())) {
                    this$0.c.u0(C.get(0));
                    EditBackgroundBlurModule editBackgroundBlurModule3 = this$0.c;
                    editBackgroundBlurModule3.t0(editBackgroundBlurModule3.J());
                }
            }
            BackgroundBlur J = this$0.c.J();
            if (J != null) {
                this$0.X(J);
            }
            this$0.m0();
            us.pinguo.foundation.statistics.h.b.W("my_lens", "delete");
        }
        dialogInterface.cancel();
    }

    private final void b0() {
        ViewGroup viewGroup = this.b;
        int i2 = R.id.adjustLayout;
        PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout, "fragmentLayout.adjustLayout");
        paintEraserAdjustLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout, 0);
        ConstraintLayout constraintLayout = (ConstraintLayout) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.clUndoRedo);
        kotlin.jvm.internal.s.g(constraintLayout, "fragmentLayout.adjustLayout.clUndoRedo");
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivUndo);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivUndo");
        imageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView, 8);
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivRedo);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivRedo");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        this.f10277g = false;
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).E(false);
        ImageView imageView3 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView3, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView3.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView3, 8);
        ImageView imageView4 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivBackgroundHide);
        kotlin.jvm.internal.s.g(imageView4, "fragmentLayout.adjustLayout.ivBackgroundHide");
        imageView4.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView4, 0);
        ManualMattingView manualMattingView = this.m;
        manualMattingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(manualMattingView, 0);
        this.f10275e.F(true);
        this.f10275e.u(false);
        this.m.w(1);
        W();
    }

    private final void b1(final BackgroundBlurMaterial backgroundBlurMaterial) {
        if (backgroundBlurMaterial == null) {
            return;
        }
        Context context = this.f10276f;
        if (context != null) {
            us.pinguo.foundation.utils.d0.b(context);
        }
        us.pinguo.foundation.utils.w.i(this.f10276f, R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                BackgroundBlurController.c1(BackgroundBlurController.this, backgroundBlurMaterial, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.o
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                BackgroundBlurController.d1(BackgroundBlurController.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091 A[LOOP:0: B:22:0x0053->B:48:0x0091, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0094 A[EDGE_INSN: B:98:0x0094->B:50:0x0094 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c0(us.pinguo.repository2020.entity.BackgroundBlur r31) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.BackgroundBlurController.c0(us.pinguo.repository2020.entity.BackgroundBlur):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(BackgroundBlurController this$0, BackgroundBlurMaterial backgroundBlurMaterial, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -1) {
            this$0.Z(backgroundBlurMaterial);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RecyclerView recyclerView) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(BackgroundBlurController this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Context context = this$0.f10276f;
        if (context == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(BackgroundBlur newCustomizeBlur, RecyclerView recyclerView) {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        View view;
        kotlin.jvm.internal.s.h(newCustomizeBlur, "$newCustomizeBlur");
        ObservableField<MaterialInstallState> installState = newCustomizeBlur.getInstallState();
        if ((installState == null ? null : installState.get()) == MaterialInstallState.STATE_INSTALLED || (findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0)) == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    private final void e1() {
        Group group = (Group) this.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(0);
        VdsAgent.onSetViewVisibility(group, 0);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.bgEventInterceptor");
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        FragmentLoadingView loadingView = (FragmentLoadingView) this.b.findViewById(R.id.loadingView);
        loadingView.d(true);
        loadingView.f(true);
        String string = this.f10276f.getString(R.string.bg_loading_detecting);
        kotlin.jvm.internal.s.g(string, "context.getString(R.string.bg_loading_detecting)");
        loadingView.setTipText(string);
        kotlin.jvm.internal.s.g(loadingView, "loadingView");
        loadingView.setVisibility(0);
        VdsAgent.onSetViewVisibility(loadingView, 0);
        loadingView.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(RecyclerView recyclerView, int i2) {
        View view;
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i2);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        if (this.t) {
            kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), null, null, new BackgroundBlurController$showLoadingOrTutorial$1(this, null), 3, null);
        } else {
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(BackgroundBlurController this$0) {
        View view;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = ((RecyclerView) this$0.f10280j.findViewById(R.id.rvBackgroundBlurCustomize)).findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(Context context, BackgroundBlurMaterial backgroundBlurMaterial) {
        if (us.pinguo.util.q.f(context)) {
            if (!us.pinguo.util.q.h(context) && !us.pinguo.repository2020.m.a.C()) {
                b1(backgroundBlurMaterial);
                return;
            } else {
                Z(backgroundBlurMaterial);
                return;
            }
        }
        us.pinguo.foundation.utils.k0.a.a(R.string.download_not_network);
    }

    private final void i0() {
        this.f10277g = false;
        l0(false);
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).E(true);
        ViewGroup viewGroup = this.b;
        int i2 = R.id.adjustLayout;
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) viewGroup.findViewById(i2)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivBackgroundHide);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivBackgroundHide");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        ManualMattingView manualMattingView = this.m;
        manualMattingView.setVisibility(4);
        VdsAgent.onSetViewVisibility(manualMattingView, 4);
        this.c.z();
        this.f10275e.u(true);
        this.f10275e.F(false);
        S0();
        this.c.A().get(1).m(40);
        this.c.A().get(2).m(40);
        this.m.setCurrentBrushSize(40);
        this.m.setDefaultBrushSize(40);
    }

    private final void j0() {
        this.c.h0();
        EditBackgroundBlurModule editBackgroundBlurModule = this.c;
        editBackgroundBlurModule.t0(editBackgroundBlurModule.J());
        BackgroundBlur J = this.c.J();
        if (J != null) {
            X(J);
        }
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k0(BackgroundBlurMaterial backgroundBlurMaterial) {
        return kotlin.jvm.internal.s.c(Material.MATERIAL_CUSTOMIZATION, backgroundBlurMaterial.getPid()) ? "create" : "my_lens";
    }

    private final void l0(boolean z) {
        if (z) {
            ((ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(R.id.adjustLayout)).a(R.id.ivBackgroundHide)).setImageResource(R.drawable.ic_toggle_marked_area_off);
        } else {
            ((ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(R.id.adjustLayout)).a(R.id.ivBackgroundHide)).setImageResource(R.drawable.ic_toggle_marked_area_on);
        }
        this.c.V(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        ViewGroup viewGroup = this.b;
        int i2 = R.id.adjustLayout;
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) viewGroup.findViewById(i2)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivBackgroundHide);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivBackgroundHide");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        X0();
        R0();
        if (x0()) {
            View backgroundBlurCustomizeView = this.f10280j;
            kotlin.jvm.internal.s.g(backgroundBlurCustomizeView, "backgroundBlurCustomizeView");
            backgroundBlurCustomizeView.setVisibility(4);
            VdsAgent.onSetViewVisibility(backgroundBlurCustomizeView, 4);
        }
        View backgroundBlurCustomizeView2 = this.f10280j;
        kotlin.jvm.internal.s.g(backgroundBlurCustomizeView2, "backgroundBlurCustomizeView");
        backgroundBlurCustomizeView2.setVisibility(4);
        VdsAgent.onSetViewVisibility(backgroundBlurCustomizeView2, 4);
        ((ProgressWheelView) this.f10278h.findViewById(R.id.sbBackgroundBlur)).setValue$edit2020_release(this.c.H(), false, false);
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.f10280j.findViewById(R.id.rvBackgroundBlurCustomize)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
        this.c.f0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        Group group = (Group) this.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        group.setVisibility(8);
        VdsAgent.onSetViewVisibility(group, 8);
        FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.bgEventInterceptor);
        kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.bgEventInterceptor");
        frameLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(frameLayout, 8);
        FragmentLoadingView loadingView = (FragmentLoadingView) this.b.findViewById(R.id.loadingView);
        if (loadingView.c()) {
            loadingView.b();
            kotlin.jvm.internal.s.g(loadingView, "loadingView");
            loadingView.setVisibility(8);
            VdsAgent.onSetViewVisibility(loadingView, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        e1();
        this.c.W(new BackgroundBlurController$initBackgroundBlur$1(this));
    }

    private final void p0() {
        ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.stubMakeupAdjust);
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout");
            PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) inflate;
        }
        ViewGroup viewGroup = this.b;
        int i2 = R.id.adjustLayout;
        PaintEraserAdjustLayout paintEraserAdjustLayout2 = (PaintEraserAdjustLayout) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout2, "fragmentLayout.adjustLayout");
        paintEraserAdjustLayout2.setVisibility(8);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout2, 8);
        int i3 = R.id.llAdjust;
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3)).getLayoutParams();
        layoutParams.height = this.b.getResources().getDimensionPixelSize(R.dimen.user_operation_height);
        PaintEraserAdjustLayout paintEraserAdjustLayout3 = (PaintEraserAdjustLayout) this.b.findViewById(i2);
        ((LinearLayout) paintEraserAdjustLayout3.a(i3)).setLayoutParams(layoutParams);
        ((LinearLayout) paintEraserAdjustLayout3.a(i3)).setBackgroundColor(us.pinguo.edit2020.utils.d.h(R.color.white));
        ConstraintLayout constraintLayout = (ConstraintLayout) paintEraserAdjustLayout3.a(R.id.clUndoRedo);
        kotlin.jvm.internal.s.g(constraintLayout, "adjustLayout.clUndoRedo");
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        ImageView imageView = (ImageView) paintEraserAdjustLayout3.a(R.id.ivUndo);
        kotlin.jvm.internal.s.g(imageView, "adjustLayout.ivUndo");
        imageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView, 8);
        ImageView imageView2 = (ImageView) paintEraserAdjustLayout3.a(R.id.ivRedo);
        kotlin.jvm.internal.s.g(imageView2, "adjustLayout.ivRedo");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        ((ImageView) paintEraserAdjustLayout3.a(R.id.ivBackgroundHide)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackgroundBlurController.q0(BackgroundBlurController.this, view);
            }
        });
        final BoldTipView boldTipView = (BoldTipView) this.b.findViewById(R.id.imgBoldTip);
        Runnable runnable = new Runnable() { // from class: us.pinguo.edit2020.controller.i
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundBlurController.r0(BoldTipView.this);
            }
        };
        this.m.setOnItemChangedListener(new BackgroundBlurController$initBackgroundBlurAdjustView$2(this));
        this.m.setOnTrackListener(new a(boldTipView, runnable));
        this.m.setOnlySize(true);
        this.c.A().get(1).m(40);
        this.c.A().get(2).m(40);
        this.m.u(this.c.A(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(BackgroundBlurController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        boolean z = !this$0.f10277g;
        this$0.f10277g = z;
        this$0.l0(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(final BoldTipView boldTipView) {
        boldTipView.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.controller.s
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundBlurController.s0(BoldTipView.this);
            }
        }).setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BoldTipView imgBoldTip) {
        kotlin.jvm.internal.s.g(imgBoldTip, "imgBoldTip");
        imgBoldTip.setVisibility(4);
        VdsAgent.onSetViewVisibility(imgBoldTip, 4);
    }

    private final void t0() {
        final TextureView textureView = (TextureView) this.b.findViewById(R.id.texViewHint);
        textureView.setOutlineProvider(new us.pinguo.edit2020.widget.l.a(us.pinguo.common.widget.i.a.b(4)));
        textureView.setClipToOutline(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f10276f);
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = (RecyclerView) this.f10280j.findViewById(R.id.rvBackgroundBlurShape);
        ProgressWheelView progressWheelView = (ProgressWheelView) this.f10280j.findViewById(R.id.sbBackgroundBlurIntensity);
        StickySeekBar stickySeekBar = (StickySeekBar) this.f10280j.findViewById(R.id.sbBackgroundBlurCustomize);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.f10281k);
        this.f10281k.j(new b());
        Context context = this.f10276f;
        kotlin.jvm.internal.s.g(context, "context");
        EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(context);
        editFunctionLayoutManager.setOrientation(0);
        RecyclerView recyclerView2 = (RecyclerView) this.f10280j.findViewById(R.id.rvBackgroundBlurCustomize);
        recyclerView2.setLayoutManager(editFunctionLayoutManager);
        recyclerView2.addItemDecoration(new us.pinguo.edit2020.adapter.d0());
        recyclerView2.setAdapter(this.f10282l);
        us.pinguo.edit2020.adapter.a0.u(this.f10282l, this.c.B(), null, false, 6, null);
        this.f10282l.A(new BackgroundBlurController$initBackgroundBlurCustomizeView$2(this, recyclerView2, recyclerView, progressWheelView, stickySeekBar));
        progressWheelView.setOnWheelChangedListener$edit2020_release(new c());
        stickySeekBar.setTrackListener(new us.pinguo.ui.widget.h() { // from class: us.pinguo.edit2020.controller.BackgroundBlurController$initBackgroundBlurCustomizeView$4
            @Override // us.pinguo.ui.widget.h
            public void b(int i2) {
                BackgroundBlurController.this.c.q(i2, new BackgroundBlurController$initBackgroundBlurCustomizeView$4$onTrackStop$1(BackgroundBlurController.this, textureView));
            }

            @Override // us.pinguo.ui.widget.h
            public void c(int i2) {
                us.pinguo.edit2020.adapter.a0 a0Var;
                BackgroundBlurController.this.c.q(i2, new BackgroundBlurController$initBackgroundBlurCustomizeView$4$onTracking$1(BackgroundBlurController.this, textureView));
                a0Var = BackgroundBlurController.this.f10282l;
                a0Var.E();
            }

            @Override // us.pinguo.ui.widget.h
            public void k(float f2) {
                h.a.a(this, f2);
            }
        });
    }

    private final void u0() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f10276f);
        linearLayoutManager.setOrientation(0);
        RecyclerView recyclerView = (RecyclerView) this.f10278h.findViewById(R.id.rvBackgroundBlur);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(this.f10279i);
        this.f10279i.j(new d());
        ((ProgressWheelView) this.f10278h.findViewById(R.id.sbBackgroundBlur)).setOnWheelChangedListener$edit2020_release(new e());
    }

    private final void v0() {
        u0();
        t0();
        p0();
    }

    private final boolean w0() {
        return this.m.getVisibility() == 0;
    }

    private final boolean x0() {
        View backgroundBlurCustomizeView = this.f10280j;
        kotlin.jvm.internal.s.g(backgroundBlurCustomizeView, "backgroundBlurCustomizeView");
        return backgroundBlurCustomizeView.getVisibility() == 0;
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
        Group group = (Group) this.b.findViewById(R.id.loadingGroup);
        kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
        return group.getVisibility() == 0;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return i3.a.c(this);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        us.pinguo.edit2020.bean.u0 value = this.c.G().getValue();
        if (value == null) {
            return false;
        }
        if (w0()) {
            this.f10274d.f(value, event);
            this.f10275e.F(false);
            this.f10275e.u(false);
            S0();
        }
        int action = event.getAction();
        if (action != 0) {
            if ((action == 1 || action == 3 || action == 5) && w0()) {
                this.f10275e.F(true);
                this.f10275e.u(true);
                ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(R.id.adjustLayout)).a(R.id.ivBackgroundHide);
                kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivBackgroundHide");
                imageView.setVisibility(0);
                VdsAgent.onSetViewVisibility(imageView, 0);
                AppCompatImageView appCompatImageView = this.q;
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(0);
                    VdsAgent.onSetViewVisibility(appCompatImageView, 0);
                }
            }
        } else if (w0()) {
            this.f10274d.f(value, event);
            this.f10275e.F(false);
            this.f10275e.u(false);
            ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(R.id.adjustLayout)).a(R.id.ivBackgroundHide);
            kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivBackgroundHide");
            imageView2.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView2, 8);
            AppCompatImageView appCompatImageView2 = this.q;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(8);
                VdsAgent.onSetViewVisibility(appCompatImageView2, 8);
            }
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        String pid;
        if (f()) {
            if (w0()) {
                this.c.m0(true);
                i0();
                return;
            } else if (x0()) {
                BackgroundBlur Q = this.c.Q();
                if (Q != null && Q.isInstalled()) {
                    Context context = this.f10278h.getContext();
                    kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                    String string = context.getString(R.string.adjust_lens_message);
                    kotlin.jvm.internal.s.g(string, "context.getString(R.string.adjust_lens_message)");
                    Object[] objArr = new Object[1];
                    BackgroundBlur Q2 = this.c.Q();
                    objArr[0] = Q2 == null ? null : Q2.getName();
                    String format = String.format(string, Arrays.copyOf(objArr, 1));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                    AlertDialog l2 = us.pinguo.foundation.utils.w.l(context, format, context.getString(R.string.confirm), context.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.n
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            BackgroundBlurController.Q0(BackgroundBlurController.this, dialogInterface, i2);
                        }
                    });
                    l2.show();
                    VdsAgent.showDialog(l2);
                    return;
                }
                T0();
                us.pinguo.foundation.statistics.h.b.W("create", "save");
                return;
            } else {
                return;
            }
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        BackgroundBlur J = this.c.J();
        String str = "N/A";
        if (J != null && (pid = J.getPid()) != null) {
            str = pid;
        }
        iVar.x(str, "save");
        h0();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        View backgroundBlurCustomizeView = this.f10280j;
        kotlin.jvm.internal.s.g(backgroundBlurCustomizeView, "backgroundBlurCustomizeView");
        if (backgroundBlurCustomizeView.getVisibility() == 0) {
            return true;
        }
        return this.m.getVisibility() == 0;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        String name;
        if (f()) {
            if (w0()) {
                this.c.m0(false);
                i0();
                return;
            } else if (x0()) {
                BackgroundBlur Q = this.c.Q();
                if (Q != null && Q.isInstalled()) {
                    if (this.c.Z()) {
                        Context context = this.f10278h.getContext();
                        String string = context.getString(R.string.quit_adjust_lens_title);
                        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
                        String string2 = context.getString(R.string.quit_adjust_lens_message);
                        kotlin.jvm.internal.s.g(string2, "context.getString(R.stri…quit_adjust_lens_message)");
                        Object[] objArr = new Object[1];
                        BackgroundBlur Q2 = this.c.Q();
                        String str = "";
                        if (Q2 != null && (name = Q2.getName()) != null) {
                            str = name;
                        }
                        objArr[0] = str;
                        String format = String.format(string2, Arrays.copyOf(objArr, 1));
                        kotlin.jvm.internal.s.g(format, "format(format, *args)");
                        AlertDialog h2 = us.pinguo.foundation.utils.w.h(context, string, format, context.getString(R.string.confirm), context.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.t
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                BackgroundBlurController.O0(BackgroundBlurController.this, dialogInterface, i2);
                            }
                        });
                        h2.show();
                        VdsAgent.showDialog(h2);
                        return;
                    }
                    j0();
                    us.pinguo.foundation.statistics.h.b.W("my_lens", "exited");
                    return;
                } else if (this.c.Z()) {
                    Context context2 = this.f10278h.getContext();
                    AlertDialog h3 = us.pinguo.foundation.utils.w.h(context2, context2.getString(R.string.quit_save_lens_title), context2.getString(R.string.quit_save_lens_message), context2.getString(R.string.confirm), context2.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.f
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            BackgroundBlurController.P0(BackgroundBlurController.this, dialogInterface, i2);
                        }
                    });
                    h3.show();
                    VdsAgent.showDialog(h3);
                    return;
                } else {
                    Y();
                    us.pinguo.foundation.statistics.h.b.W("create", "exited");
                    return;
                }
            } else {
                return;
            }
        }
        h0();
    }

    public void h0() {
        U0();
        this.q = null;
        this.c.i();
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.b.findViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        appCompatImageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView, 0);
        this.f10275e.J(false, false);
        this.f10275e.k();
        ((FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer)).removeAllViews();
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).j();
        PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) this.b.findViewById(R.id.adjustLayout);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout, "fragmentLayout.adjustLayout");
        paintEraserAdjustLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout, 8);
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.f10278h.findViewById(R.id.rvBackgroundBlur)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        us.pinguo.common.log.a.c("onUnityRecordsCallBack", new Object[0]);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
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
        this.f10275e.J(z, z2);
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
        this.s = bVar;
        this.c.w(this.u);
        kotlin.jvm.b.a<kotlin.u> L = this.c.L();
        if (L != null) {
            L.invoke();
        }
        ((FrameLayout) this.b.findViewById(R.id.operationLayout)).setBackgroundColor(0);
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).B();
        this.f10275e.D(this);
        this.f10275e.E();
        ViewGroup viewGroup = this.b;
        int i2 = R.id.adjustLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ((PaintEraserAdjustLayout) viewGroup.findViewById(i2)).a(R.id.clUndoRedo);
        kotlin.jvm.internal.s.g(constraintLayout, "fragmentLayout.adjustLayout.clUndoRedo");
        constraintLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(constraintLayout, 0);
        int i3 = R.id.ivAdjustFace;
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView, 0);
        ViewGroup viewGroup2 = this.b;
        int i4 = R.id.flIrregularPanelContainer;
        ((FrameLayout) viewGroup2.findViewById(i4)).addView(this.f10278h);
        ((FrameLayout) this.b.findViewById(i4)).addView(this.f10280j);
        ((FrameLayout) this.b.findViewById(i4)).addView(this.m);
        ProgressWheelView progressWheelView = (ProgressWheelView) this.b.findViewById(R.id.sbBackgroundBlur);
        kotlin.jvm.internal.s.g(progressWheelView, "fragmentLayout.sbBackgroundBlur");
        ProgressWheelView.setValue$edit2020_release$default(progressWheelView, this.c.H(), false, false, 4, null);
        View backgroundBlurCustomizeView = this.f10280j;
        kotlin.jvm.internal.s.g(backgroundBlurCustomizeView, "backgroundBlurCustomizeView");
        backgroundBlurCustomizeView.setVisibility(8);
        VdsAgent.onSetViewVisibility(backgroundBlurCustomizeView, 8);
        ManualMattingView manualMattingView = this.m;
        manualMattingView.setVisibility(8);
        VdsAgent.onSetViewVisibility(manualMattingView, 8);
        PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout, "fragmentLayout.adjustLayout");
        paintEraserAdjustLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout, 0);
        ((ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackgroundBlurController.a0(BackgroundBlurController.this, view);
            }
        });
        X0();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.c.T();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        UnityEditCaller.Common.movePrevious();
    }
}
