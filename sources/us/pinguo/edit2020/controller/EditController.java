package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.common.widget.FragmentLoadingView;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.view.BlurringOvalView;
import us.pinguo.edit2020.view.BoldTipView;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.SelectRectAdjustView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.edit2020.view.cropindicator.CropDragView;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule;
import us.pinguo.edit2020.viewmodel.module.EditBackgroundBlurModule;
import us.pinguo.edit2020.viewmodel.module.EditBlurringModule;
import us.pinguo.edit2020.viewmodel.module.StaticStickerModule;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: EditController.kt */
/* loaded from: classes4.dex */
public final class EditController implements z2, a3, c3 {
    private final LifecycleOwner a;
    private final EditViewModel b;
    private final us.pinguo.edit2020.view.c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f10343d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.jvm.b.l<kotlin.jvm.b.a<kotlin.u>, kotlin.u> f10344e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.jvm.b.p<Float, Float, kotlin.u> f10345f;

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.jvm.b.l<Boolean, kotlin.u> f10346g;

    /* renamed from: h  reason: collision with root package name */
    private e3 f10347h;

    /* renamed from: i  reason: collision with root package name */
    private final RecyclerView f10348i;

    /* renamed from: j  reason: collision with root package name */
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.n> f10349j;

    /* renamed from: k  reason: collision with root package name */
    private final HashMap<FunctionType, i3> f10350k;

    /* renamed from: l  reason: collision with root package name */
    private i3 f10351l;
    private g3 m;
    private a3 n;
    private kotlin.jvm.b.a<kotlin.u> o;

    /* compiled from: EditController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.n, kotlin.u> {
        AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.n nVar) {
            invoke(num.intValue(), nVar);
            return kotlin.u.a;
        }

        public final void invoke(int i2, us.pinguo.edit2020.bean.n function) {
            kotlin.jvm.internal.s.h(function, "function");
            EditController.w(EditController.this, function.g(), null, 2, null);
            EditController.this.b.O(true);
        }
    }

    /* compiled from: EditController.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.MOSAIC.ordinal()] = 1;
            iArr[FunctionType.GRAFFITI.ordinal()] = 2;
            iArr[FunctionType.BLUR.ordinal()] = 3;
            iArr[FunctionType.CROP.ordinal()] = 4;
            iArr[FunctionType.ELIMINATION.ordinal()] = 5;
            iArr[FunctionType.STICKER.ordinal()] = 6;
            iArr[FunctionType.BACKGROUND_REPLACEMENT.ordinal()] = 7;
            iArr[FunctionType.BACKGROUND_BLUR.ordinal()] = 8;
            a = iArr;
            int[] iArr2 = new int[EditGotoType.values().length];
            iArr2[EditGotoType.MOSAIC.ordinal()] = 1;
            iArr2[EditGotoType.VACUITY.ordinal()] = 2;
            iArr2[EditGotoType.GRAFFITI.ordinal()] = 3;
            iArr2[EditGotoType.ERASING_PEN.ordinal()] = 4;
            iArr2[EditGotoType.STATIC_STICKER.ordinal()] = 5;
            iArr2[EditGotoType.BACKGROUND_BLUR.ordinal()] = 6;
            b = iArr2;
        }
    }

    /* compiled from: EditController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ Activity b;

        b(Activity activity) {
            this.b = activity;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            EditController.this.f10348i.getViewTreeObserver().removeOnPreDrawListener(this);
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = EditController.this.f10348i.findViewHolderForAdapterPosition(EditController.this.b.k().r("background_blur"));
            if (findViewHolderForAdapterPosition == null) {
                return false;
            }
            GuideHandler k2 = GuideHandler.k(this.b);
            k2.w(false);
            k2.z(-1, 0);
            k2.A(R.drawable.guide_toast_center);
            k2.B(GuideHandler.Gravity.CENTER);
            k2.G(GuideHandler.VGravity.UP);
            k2.m();
            k2.F(us.pinguo.edit2020.utils.d.k(R.string.str_bg_blur_guide));
            k2.x(findViewHolderForAdapterPosition.itemView.findViewById(R.id.imgFunctionIcon));
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditController(LifecycleOwner lifecycleOwner, EditViewModel editViewModel, us.pinguo.edit2020.view.c0 userOperationController, ViewGroup fragmentLayout, kotlin.jvm.b.l<? super kotlin.jvm.b.a<kotlin.u>, kotlin.u> checkUnityPrepareAction, kotlin.jvm.b.p<? super Float, ? super Float, kotlin.u> enterModeAction, kotlin.jvm.b.l<? super Boolean, kotlin.u> resetMastAction) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(editViewModel, "editViewModel");
        kotlin.jvm.internal.s.h(userOperationController, "userOperationController");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(checkUnityPrepareAction, "checkUnityPrepareAction");
        kotlin.jvm.internal.s.h(enterModeAction, "enterModeAction");
        kotlin.jvm.internal.s.h(resetMastAction, "resetMastAction");
        this.a = lifecycleOwner;
        this.b = editViewModel;
        this.c = userOperationController;
        this.f10343d = fragmentLayout;
        this.f10344e = checkUnityPrepareAction;
        this.f10345f = enterModeAction;
        this.f10346g = resetMastAction;
        us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.n> a0Var = new us.pinguo.edit2020.adapter.a0<>();
        this.f10349j = a0Var;
        this.f10350k = new HashMap<>();
        Context context = fragmentLayout.getContext();
        EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(context, 0, false);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.layout_individual_recyclerview, (ViewGroup) null).findViewById(R.id.rvFunctions);
        kotlin.jvm.internal.s.g(recyclerView, "from(context).inflate(R.…erview, null).rvFunctions");
        this.f10348i = recyclerView;
        a0Var.t(editViewModel.k().m(), 0, true);
        us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
        kotlin.jvm.internal.s.g(context, "context");
        gVar.a(context, a0Var.getItemCount(), editFunctionLayoutManager.a(context, a0Var.getItemCount()));
        recyclerView.addItemDecoration(gVar);
        recyclerView.setLayoutManager(editFunctionLayoutManager);
        recyclerView.setAdapter(a0Var);
        a0Var.A(new AnonymousClass1());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final i3 p(FunctionType functionType, us.pinguo.edit2020.viewmodel.module.f fVar, ViewGroup viewGroup) {
        MosaicController mosaicController;
        fVar.i().setValue(functionType);
        switch (a.a[functionType.ordinal()]) {
            case 1:
                us.pinguo.edit2020.viewmodel.module.g o = fVar.o();
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R.id.flIrregularPanelContainer);
                kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flIrregularPanelContainer");
                ShapeDirectionView shapeDirectionView = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout, "fragmentLayout.flMagnifier");
                us.pinguo.edit2020.utils.g gVar = new us.pinguo.edit2020.utils.g(shapeDirectionView, magnifierLayout);
                PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
                BoldTipView boldTipView = (BoldTipView) viewGroup.findViewById(R.id.imgBoldTip);
                kotlin.jvm.internal.s.g(boldTipView, "fragmentLayout.imgBoldTip");
                AppCompatImageView appCompatImageView = (AppCompatImageView) viewGroup.findViewById(R.id.showOriginPicBt);
                kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
                MosaicController mosaicController2 = new MosaicController(o, frameLayout, gVar, pGEditBottomTabLayout, boldTipView, appCompatImageView);
                this.f10347h = mosaicController2;
                this.f10351l = mosaicController2;
                this.n = mosaicController2;
                this.m = mosaicController2;
                mosaicController = mosaicController2;
                break;
            case 2:
                us.pinguo.edit2020.viewmodel.module.d n = fVar.n();
                FrameLayout frameLayout2 = (FrameLayout) viewGroup.findViewById(R.id.flIrregularPanelContainer);
                kotlin.jvm.internal.s.g(frameLayout2, "fragmentLayout.flIrregularPanelContainer");
                ShapeDirectionView shapeDirectionView2 = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView2, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout2 = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout2, "fragmentLayout.flMagnifier");
                us.pinguo.edit2020.utils.g gVar2 = new us.pinguo.edit2020.utils.g(shapeDirectionView2, magnifierLayout2);
                PGEditBottomTabLayout pGEditBottomTabLayout2 = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout2, "fragmentLayout.bottomTabLayout");
                BoldTipView boldTipView2 = (BoldTipView) viewGroup.findViewById(R.id.imgBoldTip);
                kotlin.jvm.internal.s.g(boldTipView2, "fragmentLayout.imgBoldTip");
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewGroup.findViewById(R.id.showOriginPicBt);
                kotlin.jvm.internal.s.g(appCompatImageView2, "fragmentLayout.showOriginPicBt");
                GraffitiController graffitiController = new GraffitiController(n, frameLayout2, gVar2, pGEditBottomTabLayout2, boldTipView2, appCompatImageView2);
                this.f10347h = graffitiController;
                this.f10351l = graffitiController;
                this.n = graffitiController;
                this.m = graffitiController;
                mosaicController = graffitiController;
                break;
            case 3:
                EditBlurringModule l2 = fVar.l();
                FrameLayout frameLayout3 = (FrameLayout) viewGroup.findViewById(R.id.flIrregularPanelContainer);
                kotlin.jvm.internal.s.g(frameLayout3, "fragmentLayout.flIrregularPanelContainer");
                PGEditBottomTabLayout pGEditBottomTabLayout3 = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout3, "fragmentLayout.bottomTabLayout");
                BlurringOvalView blurringOvalView = (BlurringOvalView) viewGroup.findViewById(R.id.blurView);
                kotlin.jvm.internal.s.g(blurringOvalView, "fragmentLayout.blurView");
                FragmentLoadingView fragmentLoadingView = (FragmentLoadingView) viewGroup.findViewById(R.id.loadingView);
                kotlin.jvm.internal.s.g(fragmentLoadingView, "fragmentLayout.loadingView");
                Group group = (Group) viewGroup.findViewById(R.id.loadingGroup);
                kotlin.jvm.internal.s.g(group, "fragmentLayout.loadingGroup");
                FrameLayout frameLayout4 = (FrameLayout) viewGroup.findViewById(R.id.flHintContainer);
                kotlin.jvm.internal.s.g(frameLayout4, "fragmentLayout.flHintContainer");
                BlurringController blurringController = new BlurringController(l2, frameLayout3, pGEditBottomTabLayout3, blurringOvalView, fragmentLoadingView, group, frameLayout4);
                this.f10351l = blurringController;
                this.n = null;
                return blurringController;
            case 4:
                this.n = null;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) viewGroup.findViewById(R.id.showOriginPicBt);
                kotlin.jvm.internal.s.g(appCompatImageView3, "fragmentLayout.showOriginPicBt");
                FrameLayout frameLayout5 = (FrameLayout) viewGroup.findViewById(R.id.flSecondMenuContainer);
                kotlin.jvm.internal.s.g(frameLayout5, "fragmentLayout.flSecondMenuContainer");
                PGEditBottomTabLayout pGEditBottomTabLayout4 = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout4, "fragmentLayout.bottomTabLayout");
                CropDragView cropDragView = (CropDragView) viewGroup.findViewById(R.id.cropDragView);
                kotlin.jvm.internal.s.g(cropDragView, "fragmentLayout.cropDragView");
                FrameLayout frameLayout6 = (FrameLayout) viewGroup.findViewById(R.id.operationLayout);
                kotlin.jvm.internal.s.g(frameLayout6, "fragmentLayout.operationLayout");
                TextView textView = (TextView) viewGroup.findViewById(R.id.cropRecoverBtn);
                kotlin.jvm.internal.s.g(textView, "fragmentLayout.cropRecoverBtn");
                View findViewById = viewGroup.findViewById(R.id.cropScaleBubble);
                kotlin.jvm.internal.s.g(findViewById, "fragmentLayout.cropScaleBubble");
                CropController cropController = new CropController(fVar, appCompatImageView3, frameLayout5, pGEditBottomTabLayout4, cropDragView, frameLayout6, textView, findViewById, this.f10346g, this.a);
                this.f10347h = cropController;
                this.f10351l = cropController;
                return cropController;
            case 5:
                FrameLayout frameLayout7 = (FrameLayout) viewGroup.findViewById(R.id.flIrregularPanelContainer);
                kotlin.jvm.internal.s.g(frameLayout7, "fragmentLayout.flIrregularPanelContainer");
                PGEditBottomTabLayout pGEditBottomTabLayout5 = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout5, "fragmentLayout.bottomTabLayout");
                us.pinguo.edit2020.view.c0 c0Var = this.c;
                BoldTipView boldTipView3 = (BoldTipView) viewGroup.findViewById(R.id.imgBoldTip);
                kotlin.jvm.internal.s.g(boldTipView3, "fragmentLayout.imgBoldTip");
                ShapeDirectionView shapeDirectionView3 = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView3, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout3 = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout3, "fragmentLayout.flMagnifier");
                us.pinguo.edit2020.utils.g gVar3 = new us.pinguo.edit2020.utils.g(shapeDirectionView3, magnifierLayout3);
                Group group2 = (Group) viewGroup.findViewById(R.id.loadingGroup);
                kotlin.jvm.internal.s.g(group2, "fragmentLayout.loadingGroup");
                FragmentLoadingView fragmentLoadingView2 = (FragmentLoadingView) viewGroup.findViewById(R.id.loadingView);
                kotlin.jvm.internal.s.g(fragmentLoadingView2, "fragmentLayout.loadingView");
                FrameLayout frameLayout8 = (FrameLayout) viewGroup.findViewById(R.id.bgEventInterceptor);
                kotlin.jvm.internal.s.g(frameLayout8, "fragmentLayout.bgEventInterceptor");
                EliminationController eliminationController = new EliminationController(fVar, frameLayout7, pGEditBottomTabLayout5, c0Var, boldTipView3, gVar3, group2, fragmentLoadingView2, frameLayout8);
                this.f10347h = eliminationController;
                this.n = eliminationController;
                mosaicController = eliminationController;
                break;
            case 6:
                LifecycleOwner lifecycleOwner = this.a;
                StaticStickerModule p = fVar.p();
                ShapeDirectionView shapeDirectionView4 = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView4, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout4 = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout4, "fragmentLayout.flMagnifier");
                StaticStickerController staticStickerController = new StaticStickerController(lifecycleOwner, p, new us.pinguo.edit2020.utils.g(shapeDirectionView4, magnifierLayout4), this.c, viewGroup);
                this.f10347h = staticStickerController;
                this.f10351l = staticStickerController;
                this.n = staticStickerController;
                return staticStickerController;
            case 7:
                LifecycleOwner lifecycleOwner2 = this.a;
                EditViewModel editViewModel = this.b;
                BackgroundReplacementModule k2 = fVar.k();
                PGEditBottomTabLayout pGEditBottomTabLayout6 = (PGEditBottomTabLayout) viewGroup.findViewById(R.id.bottomTabLayout);
                kotlin.jvm.internal.s.g(pGEditBottomTabLayout6, "fragmentLayout.bottomTabLayout");
                FrameLayout frameLayout9 = (FrameLayout) viewGroup.findViewById(R.id.flIrregularPanelContainer);
                kotlin.jvm.internal.s.g(frameLayout9, "fragmentLayout.flIrregularPanelContainer");
                BoldTipView boldTipView4 = (BoldTipView) viewGroup.findViewById(R.id.imgBoldTip);
                kotlin.jvm.internal.s.g(boldTipView4, "fragmentLayout.imgBoldTip");
                ShapeDirectionView shapeDirectionView5 = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView5, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout5 = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout5, "fragmentLayout.flMagnifier");
                us.pinguo.edit2020.utils.g gVar4 = new us.pinguo.edit2020.utils.g(shapeDirectionView5, magnifierLayout5);
                SelectRectAdjustView selectRectAdjustView = (SelectRectAdjustView) viewGroup.findViewById(R.id.selectRectAdjustView);
                kotlin.jvm.internal.s.g(selectRectAdjustView, "fragmentLayout.selectRectAdjustView");
                TopSnackBar topSnackBar = (TopSnackBar) viewGroup.findViewById(R.id.topSnack);
                kotlin.jvm.internal.s.g(topSnackBar, "fragmentLayout.topSnack");
                BackgroundReplacementController backgroundReplacementController = new BackgroundReplacementController(lifecycleOwner2, editViewModel, k2, pGEditBottomTabLayout6, frameLayout9, boldTipView4, gVar4, selectRectAdjustView, topSnackBar, this.c);
                this.f10347h = backgroundReplacementController;
                this.n = backgroundReplacementController;
                mosaicController = backgroundReplacementController;
                break;
            case 8:
                LifecycleOwner lifecycleOwner3 = this.a;
                EditBackgroundBlurModule j2 = fVar.j();
                ShapeDirectionView shapeDirectionView6 = (ShapeDirectionView) viewGroup.findViewById(R.id.handShapeView);
                kotlin.jvm.internal.s.g(shapeDirectionView6, "fragmentLayout.handShapeView");
                MagnifierLayout magnifierLayout6 = (MagnifierLayout) viewGroup.findViewById(R.id.flMagnifier);
                kotlin.jvm.internal.s.g(magnifierLayout6, "fragmentLayout.flMagnifier");
                BackgroundBlurController backgroundBlurController = new BackgroundBlurController(lifecycleOwner3, viewGroup, j2, new us.pinguo.edit2020.utils.g(shapeDirectionView6, magnifierLayout6), this.c);
                this.f10347h = backgroundBlurController;
                this.f10351l = backgroundBlurController;
                this.n = backgroundBlurController;
                return backgroundBlurController;
            default:
                throw new IllegalStateException("Edit type error".toString());
        }
        return mosaicController;
    }

    private final void q() {
        i3 i3Var = this.f10351l;
        if ((i3Var == null || i3Var.f()) ? false : true) {
            this.c.H(true);
            TextView textView = (TextView) this.f10343d.findViewById(R.id.txtSave);
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            FrameLayout frameLayout = (FrameLayout) this.f10343d.findViewById(R.id.flContainerSubItems);
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            this.b.k().i().setValue(null);
            this.f10347h = null;
        }
    }

    private final void t(FunctionType functionType, us.pinguo.edit2020.model.editgoto.b bVar) {
        if (!this.f10350k.containsKey(functionType)) {
            this.f10350k.put(functionType, p(functionType, this.b.k(), this.f10343d));
        }
        i3 i3Var = this.f10350k.get(functionType);
        this.f10351l = i3Var;
        if (i3Var instanceof a3) {
            Objects.requireNonNull(i3Var, "null cannot be cast to non-null type us.pinguo.edit2020.controller.EditHistoryCallBack");
            this.n = (a3) i3Var;
        }
        this.b.k().i().setValue(functionType);
        u(bVar);
        switch (a.a[functionType.ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.b.K("edit_panel_mosaic", null, "click");
                return;
            case 2:
                us.pinguo.foundation.statistics.h.b.K("edit_panel_graffiti", null, "click");
                return;
            case 3:
                us.pinguo.foundation.statistics.h.b.K("edit_save_blur", null, "click");
                return;
            case 4:
                us.pinguo.foundation.statistics.h.b.K("edit_panel_tailor", null, "click");
                return;
            case 5:
                us.pinguo.foundation.statistics.h.b.K("edit_remover", null, "click");
                return;
            case 6:
                us.pinguo.foundation.statistics.h.b.K("edit_sticker", null, "click");
                return;
            case 7:
                us.pinguo.foundation.statistics.h.b.K("edit_panel_backdrop", null, "click");
                return;
            case 8:
                us.pinguo.foundation.statistics.h.b.K("edit_defocus", null, "click");
                return;
            default:
                return;
        }
    }

    private final void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        this.f10344e.invoke(new EditController$enter$1(this, bVar));
    }

    static /* synthetic */ void w(EditController editController, FunctionType functionType, us.pinguo.edit2020.model.editgoto.b bVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bVar = null;
        }
        editController.t(functionType, bVar);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.EDIT;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        switch (a.b[editGoto.a().ordinal()]) {
            case 1:
                kotlin.jvm.b.a<kotlin.u> aVar = this.o;
                if (aVar != null) {
                    aVar.invoke();
                }
                w(this, FunctionType.MOSAIC, null, 2, null);
                return true;
            case 2:
                kotlin.jvm.b.a<kotlin.u> aVar2 = this.o;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
                w(this, FunctionType.BLUR, null, 2, null);
                return true;
            case 3:
                kotlin.jvm.b.a<kotlin.u> aVar3 = this.o;
                if (aVar3 != null) {
                    aVar3.invoke();
                }
                w(this, FunctionType.GRAFFITI, null, 2, null);
                return true;
            case 4:
                us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
                if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_remover", true, null, 4, null)) {
                    us.pinguo.repository2020.utils.o.n(oVar, "new_to_remover", false, null, 4, null);
                }
                kotlin.jvm.b.a<kotlin.u> aVar4 = this.o;
                if (aVar4 != null) {
                    aVar4.invoke();
                }
                w(this, FunctionType.ELIMINATION, null, 2, null);
                return true;
            case 5:
                kotlin.jvm.b.a<kotlin.u> aVar5 = this.o;
                if (aVar5 != null) {
                    aVar5.invoke();
                }
                t(FunctionType.STICKER, editGoto);
                return true;
            case 6:
                kotlin.jvm.b.a<kotlin.u> aVar6 = this.o;
                if (aVar6 != null) {
                    aVar6.invoke();
                }
                t(FunctionType.BACKGROUND_BLUR, editGoto);
                return true;
            default:
                return false;
        }
    }

    @Override // us.pinguo.edit2020.controller.c3
    public void Q() {
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        i3 i3Var = this.f10351l;
        if (i3Var == null) {
            return false;
        }
        return i3Var.R();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        i3 i3Var = this.f10351l;
        if (i3Var == null) {
            return false;
        }
        return i3Var.S();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    @Override // us.pinguo.edit2020.controller.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditController.d():void");
    }

    public final void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        g3 g3Var = this.m;
        if (g3Var == null) {
            return;
        }
        g3Var.e(unityCanvasStatus);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        i3 i3Var = this.f10351l;
        if (i3Var == null) {
            return false;
        }
        return i3Var.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e  */
    @Override // us.pinguo.edit2020.controller.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditController.g():void");
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        a3 a3Var = this.n;
        if (a3Var == null) {
            return;
        }
        a3Var.i(records);
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(boolean z, boolean z2) {
        a3 a3Var = this.n;
        if (a3Var == null) {
            return;
        }
        a3Var.n(z, z2);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return z2.a.d(this);
    }

    public final void r(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        e3 e3Var = this.f10347h;
        if (e3Var == null) {
            return;
        }
        e3Var.b(event);
    }

    public final void s(kotlin.jvm.b.a<kotlin.u> aVar) {
        this.o = aVar;
    }

    public final void show() {
        ViewGroup viewGroup = this.f10343d;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) viewGroup.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.f10343d.findViewById(i2)).addView(this.f10348i);
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_9910", true, null, 4, null) && us.pinguo.edit2020.manager.d.a.a()) {
            us.pinguo.repository2020.utils.o.n(oVar, "new_to_9910", false, null, 4, null);
            Context context = this.f10343d.getContext();
            Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
            this.f10348i.getViewTreeObserver().addOnPreDrawListener(new b((Activity) context));
        }
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.K("edit_panel_tailor", null, "show");
        iVar.K("edit_remover", null, "show");
        iVar.K("edit_defocus", null, "show");
        iVar.K("edit_panel_backdrop", null, "show");
        iVar.K("edit_save_blur", null, "show");
        iVar.K("edit_panel_mosaic", null, "show");
        iVar.K("edit_panel_graffiti", null, "show");
        iVar.K("edit_panel_sticker", null, "show");
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        i3 i3Var = this.f10351l;
        if (i3Var == null) {
            return null;
        }
        return i3Var.v();
    }
}
