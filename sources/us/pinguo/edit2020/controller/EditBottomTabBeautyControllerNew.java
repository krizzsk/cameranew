package us.pinguo.edit2020.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.LowerResolutionCpuMobile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.activity.CommonVideoTutorialActivity;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.bean.TutorialModel;
import us.pinguo.edit2020.controller.d3;
import us.pinguo.edit2020.model.editgoto.EditGotoType;
import us.pinguo.edit2020.view.BodyShapingGestureView;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.NumberTipView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.edit2020.view.m0;
import us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView;
import us.pinguo.edit2020.view.menuview.BeautyNewMenuView;
import us.pinguo.edit2020.viewmodel.FunctionType;
import us.pinguo.edit2020.viewmodel.module.EditAutoBeautifyModule;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
import us.pinguo.edit2020.viewmodel.module.EditBodyShapeModule;
import us.pinguo.edit2020.viewmodel.module.EditMakeupModule;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.repository2020.entity.BeautyEditData;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.ui.widget.StickySeekBar;
/* compiled from: EditBottomTabBeautyControllerNew.kt */
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyControllerNew implements d3 {
    private final LifecycleOwner a;
    private final ConstraintLayout b;
    private final us.pinguo.edit2020.view.c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final b3 f10334d;

    /* renamed from: e  reason: collision with root package name */
    private final EditBeautyModule f10335e;

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.jvm.b.l<kotlin.jvm.b.a<kotlin.u>, kotlin.u> f10336f;

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.jvm.b.p<Float, Float, kotlin.u> f10337g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> f10338h;

    /* renamed from: i  reason: collision with root package name */
    private kotlin.jvm.b.l<? super us.pinguo.edit2020.bean.x, kotlin.u> f10339i;

    /* renamed from: j  reason: collision with root package name */
    private final Context f10340j;

    /* renamed from: k  reason: collision with root package name */
    private final EnumMap<FunctionType, View> f10341k;

    /* renamed from: l  reason: collision with root package name */
    private MultiFunctionController f10342l;
    private SkinRefreshController m;
    private Facial3DController n;
    private y2 o;
    private EditBodyShapingController p;
    private MakeupController q;
    private us.pinguo.facedetector.c r;
    private us.pinguo.edit2020.b.c s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private HashMap<Integer, Integer> x;
    private e3 y;
    private final us.pinguo.edit2020.view.m0 z;

    /* compiled from: EditBottomTabBeautyControllerNew.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[FunctionType.values().length];
            iArr[FunctionType.FacialFeatures.ordinal()] = 1;
            iArr[FunctionType.NEW_SKIN_REFRESH.ordinal()] = 2;
            iArr[FunctionType.AutoBeauty.ordinal()] = 3;
            iArr[FunctionType.BodyShaping.ordinal()] = 4;
            iArr[FunctionType.FACIAL_3D.ordinal()] = 5;
            a = iArr;
            int[] iArr2 = new int[EditGotoType.values().length];
            iArr2[EditGotoType.HOME.ordinal()] = 1;
            iArr2[EditGotoType.ONE_KEY_BEAUTY.ordinal()] = 2;
            iArr2[EditGotoType.BODY_SHAPE.ordinal()] = 3;
            iArr2[EditGotoType.FACIAL_FEATURES.ordinal()] = 4;
            iArr2[EditGotoType.MAKEUP.ordinal()] = 5;
            iArr2[EditGotoType.FACIAL3D.ordinal()] = 6;
            b = iArr2;
        }
    }

    /* compiled from: EditBottomTabBeautyControllerNew.kt */
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
            CommonVideoTutorialActivity.a aVar = CommonVideoTutorialActivity.f10109d;
            Context context = ((PGEditBottomTabLayout) EditBottomTabBeautyControllerNew.this.b.findViewById(R.id.bottomTabLayout)).getContext();
            kotlin.jvm.internal.s.g(context, "fragmentLayout.bottomTabLayout.context");
            aVar.a(context, TutorialModel.VIDEO_TYPE_BODY_SHAPING);
            Context context2 = EditBottomTabBeautyControllerNew.this.f10340j;
            Objects.requireNonNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.bottom_in, 0);
        }
    }

    /* compiled from: EditBottomTabBeautyControllerNew.kt */
    /* loaded from: classes4.dex */
    public static final class c implements PGEditTabLayout.d {
        final /* synthetic */ BeautyAdjustFacialFeaturesView b;

        c(BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView) {
            this.b = beautyAdjustFacialFeaturesView;
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void a(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            EditBottomTabBeautyControllerNew.this.x.put(Integer.valueOf(tab.i()), Integer.valueOf(EditBottomTabBeautyControllerNew.this.v));
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            EditBottomTabBeautyControllerNew.this.u = tab.i();
            ArrayList<us.pinguo.edit2020.bean.r> arrayList = EditBottomTabBeautyControllerNew.this.f10335e.y().get(EditBottomTabBeautyControllerNew.this.f10335e.z()[tab.i()]);
            if (arrayList == null) {
                return;
            }
            BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView = this.b;
            Integer num = (Integer) EditBottomTabBeautyControllerNew.this.x.get(Integer.valueOf(tab.i()));
            if (num == null) {
                num = 1;
            }
            beautyAdjustFacialFeaturesView.j(arrayList, num.intValue());
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    /* compiled from: EditBottomTabBeautyControllerNew.kt */
    /* loaded from: classes4.dex */
    public static final class d implements us.pinguo.edit2020.view.m0 {
        d() {
        }

        @Override // us.pinguo.edit2020.view.m0
        public void h(int i2) {
            BeautyEditData value = EditBottomTabBeautyControllerNew.this.f10335e.p().getValue();
            if (value == null) {
                return;
            }
            EditBottomTabBeautyControllerNew editBottomTabBeautyControllerNew = EditBottomTabBeautyControllerNew.this;
            value.setCurrentValue(i2);
            if (LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList()) {
                return;
            }
            editBottomTabBeautyControllerNew.f10335e.q0(value);
        }

        @Override // us.pinguo.edit2020.view.m0
        public void i(float f2) {
            m0.a.a(this, f2);
        }

        @Override // us.pinguo.edit2020.view.m0
        public void l(int i2) {
            BeautyEditData value;
            View view = (View) EditBottomTabBeautyControllerNew.this.f10341k.get(FunctionType.FacialFeatures);
            if (view != null && view.getParent() != null) {
                Objects.requireNonNull(view, "null cannot be cast to non-null type us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView");
                ((BeautyAdjustFacialFeaturesView) view).m();
            }
            EditBottomTabBeautyControllerNew.this.Z(i2);
            if (!LowerResolutionCpuMobile.INSTANCE.isInLowerResolutionList() || (value = EditBottomTabBeautyControllerNew.this.f10335e.p().getValue()) == null) {
                return;
            }
            EditBottomTabBeautyControllerNew editBottomTabBeautyControllerNew = EditBottomTabBeautyControllerNew.this;
            value.setCurrentValue(i2);
            editBottomTabBeautyControllerNew.f10335e.q0(value);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditBottomTabBeautyControllerNew(LifecycleOwner lifecycleOwner, ConstraintLayout fragmentLayout, us.pinguo.edit2020.view.c0 operationLayout, b3 faceCurveController, EditBeautyModule bottomModule, kotlin.jvm.b.l<? super kotlin.jvm.b.a<kotlin.u>, kotlin.u> checkUnityPrepareAction, kotlin.jvm.b.p<? super Float, ? super Float, kotlin.u> enterModeAction) {
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(operationLayout, "operationLayout");
        kotlin.jvm.internal.s.h(faceCurveController, "faceCurveController");
        kotlin.jvm.internal.s.h(bottomModule, "bottomModule");
        kotlin.jvm.internal.s.h(checkUnityPrepareAction, "checkUnityPrepareAction");
        kotlin.jvm.internal.s.h(enterModeAction, "enterModeAction");
        this.a = lifecycleOwner;
        this.b = fragmentLayout;
        this.c = operationLayout;
        this.f10334d = faceCurveController;
        this.f10335e = bottomModule;
        this.f10336f = checkUnityPrepareAction;
        this.f10337g = enterModeAction;
        this.f10340j = fragmentLayout.getContext();
        this.f10341k = new EnumMap<>(FunctionType.class);
        this.x = new HashMap<>();
        P(lifecycleOwner);
        this.z = new d();
    }

    private final void H() {
        if (this.o == null) {
            EditAutoBeautifyModule k2 = this.f10335e.k();
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.flIrregularPanelContainer);
            kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flIrregularPanelContainer");
            NumberTipView numberTipView = (NumberTipView) this.b.findViewById(R.id.numberTipView);
            kotlin.jvm.internal.s.g(numberTipView, "fragmentLayout.numberTipView");
            this.o = new y2(k2, frameLayout, numberTipView);
        }
    }

    private final RecyclerView I() {
        String str;
        if (this.p == null) {
            View inflate = LayoutInflater.from(this.f10340j).inflate(R.layout.layout_individual_recyclerview, (ViewGroup) ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)), false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) inflate;
            View inflate2 = ((ViewStub) this.b.findViewById(R.id.stubBodyShapeControl)).inflate();
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate2;
            LifecycleOwner lifecycleOwner = this.a;
            EditBodyShapeModule n = this.f10335e.n();
            TextView textView = (TextView) this.b.findViewById(R.id.txtEditHint);
            kotlin.jvm.internal.s.g(textView, "fragmentLayout.txtEditHint");
            TopSnackBar topSnackBar = (TopSnackBar) this.b.findViewById(R.id.topSnack);
            kotlin.jvm.internal.s.g(topSnackBar, "fragmentLayout.topSnack");
            ShapeDirectionView shapeDirectionView = (ShapeDirectionView) this.b.findViewById(R.id.handShapeView);
            kotlin.jvm.internal.s.g(shapeDirectionView, "fragmentLayout.handShapeView");
            BodyShapingGestureView bodyShapingGestureView = (BodyShapingGestureView) this.b.findViewById(R.id.narrowExpandView);
            kotlin.jvm.internal.s.g(bodyShapingGestureView, "fragmentLayout.narrowExpandView");
            MagnifierLayout magnifierLayout = (MagnifierLayout) this.b.findViewById(R.id.flMagnifier);
            kotlin.jvm.internal.s.g(magnifierLayout, "fragmentLayout.flMagnifier");
            ImageView imageView = (ImageView) this.b.findViewById(R.id.editInnerUndo);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.editInnerUndo");
            ImageView imageView2 = (ImageView) this.b.findViewById(R.id.editInnerRedo);
            kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.editInnerRedo");
            str = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView";
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.b.findViewById(R.id.showOriginPicBt);
            kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
            EditBodyShapingController editBodyShapingController = new EditBodyShapingController(lifecycleOwner, n, constraintLayout, textView, topSnackBar, recyclerView, shapeDirectionView, bodyShapingGestureView, magnifierLayout, new us.pinguo.edit2020.manager.b(imageView, imageView2, appCompatImageView));
            editBodyShapingController.M(new EditBottomTabBeautyControllerNew$createBodyShapingView$1(this));
            this.f10341k.put((EnumMap<FunctionType, View>) FunctionType.BodyShaping, (FunctionType) recyclerView);
            this.p = editBodyShapingController;
        } else {
            str = "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView";
        }
        View view = this.f10341k.get(FunctionType.BodyShaping);
        Objects.requireNonNull(view, str);
        return (RecyclerView) view;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [us.pinguo.edit2020.view.menuview.BeautyAdjustFacialFeaturesView, T] */
    private final View J() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        EnumMap<FunctionType, View> enumMap = this.f10341k;
        FunctionType functionType = FunctionType.FacialFeatures;
        ?? r1 = enumMap.get(functionType);
        ref$ObjectRef.element = r1;
        if (r1 == 0) {
            Context context = this.f10340j;
            kotlin.jvm.internal.s.g(context, "context");
            ?? beautyAdjustFacialFeaturesView = new BeautyAdjustFacialFeaturesView(context);
            ref$ObjectRef.element = beautyAdjustFacialFeaturesView;
            ((BeautyAdjustFacialFeaturesView) beautyAdjustFacialFeaturesView).setOnItemChanged(new EditBottomTabBeautyControllerNew$createFacialFeaturesView$1(this, ref$ObjectRef));
            ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10335e.y().get(this.f10340j.getString(R.string.edit_facialfeatures_tab_face));
            if (arrayList != null) {
                BeautyAdjustFacialFeaturesView.k((BeautyAdjustFacialFeaturesView) ref$ObjectRef.element, arrayList, 0, 2, null);
            }
            this.f10341k.put(functionType, ref$ObjectRef.element);
        }
        return (View) ref$ObjectRef.element;
    }

    private final void M() {
        if (this.q == null) {
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.stubMakeupAdjust);
            if (viewStub != null) {
                View inflate = viewStub.inflate();
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout");
                PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) inflate;
            }
            this.q = new MakeupController(this.f10335e.D(), this.b, this.f10334d, this.f10336f);
        }
    }

    private final View O() {
        EnumMap<FunctionType, View> enumMap = this.f10341k;
        FunctionType functionType = FunctionType.BeautyMenu;
        BeautyNewMenuView beautyNewMenuView = (BeautyNewMenuView) enumMap.get(functionType);
        if (beautyNewMenuView == null) {
            Context context = this.f10340j;
            kotlin.jvm.internal.s.g(context, "context");
            BeautyNewMenuView beautyNewMenuView2 = new BeautyNewMenuView(context, null, 0, 6, null);
            this.f10341k.put((EnumMap<FunctionType, View>) functionType, (FunctionType) beautyNewMenuView2);
            beautyNewMenuView2.e(this.f10335e.m());
            beautyNewMenuView2.setOnItemChangeListener(new BeautyNewMenuView.a() { // from class: us.pinguo.edit2020.controller.EditBottomTabBeautyControllerNew$createMenuView$1$1
                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void a() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$onFacial3DClick$1(EditBottomTabBeautyControllerNew.this));
                    us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_contour", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void b() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$onAutoBeautyClick$1(EditBottomTabBeautyControllerNew.this));
                    us.pinguo.foundation.statistics.h.b.m0("edit_panel_instant_beauty", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void c() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$onHandShapeClick$1(EditBottomTabBeautyControllerNew.this));
                    us.pinguo.foundation.statistics.h.b.m0("edit_panel_face_lift", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void d() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$onFacialFeaturesClick$1(EditBottomTabBeautyControllerNew.this));
                    us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_remodel", null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void e() {
                    kotlin.jvm.b.l lVar;
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$onMakeupClick$1(EditBottomTabBeautyControllerNew.this));
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void f(us.pinguo.edit2020.bean.h function) {
                    kotlin.jvm.b.l lVar;
                    kotlin.jvm.internal.s.h(function, "function");
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$newSkinRefreshClick$1(EditBottomTabBeautyControllerNew.this, function));
                    us.pinguo.foundation.statistics.h.b.m0(us.pinguo.edit2020.repository.a.e(function.f()), null, "click");
                }

                @Override // us.pinguo.edit2020.view.menuview.BeautyNewMenuView.a
                public void g(us.pinguo.edit2020.bean.h function) {
                    kotlin.jvm.b.l lVar;
                    kotlin.jvm.internal.s.h(function, "function");
                    lVar = EditBottomTabBeautyControllerNew.this.f10336f;
                    lVar.invoke(new EditBottomTabBeautyControllerNew$createMenuView$1$1$multiFunctionTabClick$1(EditBottomTabBeautyControllerNew.this));
                    us.pinguo.foundation.statistics.h.b.m0("edit_panel_fuse", null, "click");
                }
            });
            beautyNewMenuView2.b();
            return beautyNewMenuView2;
        }
        return beautyNewMenuView;
    }

    private final void P(LifecycleOwner lifecycleOwner) {
        this.f10335e.p().observe(lifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.controller.b1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditBottomTabBeautyControllerNew.T(EditBottomTabBeautyControllerNew.this, (BeautyEditData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(EditBottomTabBeautyControllerNew this$0, BeautyEditData it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.c.I(it.getMinValue(), it.getMaxValue(), it.getCurrentValue(), it.getDefaultValue());
        EditBeautyModule editBeautyModule = this$0.f10335e;
        kotlin.jvm.internal.s.g(it, "it");
        editBeautyModule.q0(it);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this$0.f10338h;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.valueOf(it.getNeedFace()));
    }

    private final void W() {
        TextView textView = (TextView) this.b.findViewById(R.id.txtSave);
        textView.setVisibility(4);
        VdsAgent.onSetViewVisibility(textView, 4);
        this.c.H(false);
        this.f10335e.f(true);
    }

    private final void X() {
        this.y = null;
        TextView textView = (TextView) this.b.findViewById(R.id.txtSave);
        textView.setVisibility(0);
        VdsAgent.onSetViewVisibility(textView, 0);
        this.c.J(false, false);
        this.c.F(false);
        this.c.v(null);
        this.c.y(StickySeekBar.DefaultDotStyle.CIRCLE);
        this.c.B(us.pinguo.edit2020.utils.d.h(R.color.edit_seekbar_default));
        this.c.C(true);
        this.f10335e.H().clear();
        ((NumberTipView) this.b.findViewById(R.id.numberTipView)).a();
        this.t = 0;
        this.f10335e.x0(null);
        this.f10335e.w0(null);
        this.f10335e.f(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(EditBottomTabBeautyControllerNew this$0, boolean z, boolean z2) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.b0(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(int i2) {
        us.pinguo.edit2020.bean.i I;
        HashMap<String, Integer> hashMap = this.f10335e.H().get(Integer.valueOf(this.t));
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f10335e.H().put(Integer.valueOf(this.t), hashMap);
        }
        String str = null;
        if (this.f10335e.t().getValue() == FunctionType.NEW_SKIN_REFRESH) {
            SkinRefreshController skinRefreshController = this.m;
            if (skinRefreshController != null && (I = skinRefreshController.I()) != null) {
                str = I.f();
            }
        } else {
            BeautyEditData value = this.f10335e.p().getValue();
            if (value != null) {
                str = value.getBeautyKey();
            }
        }
        if (str == null) {
            return;
        }
        hashMap.put(str, Integer.valueOf(i2));
    }

    private final void a0() {
        BeautyEditData value;
        HashMap<String, Integer> hashMap = this.f10335e.H().get(Integer.valueOf(this.t));
        FunctionType value2 = this.f10335e.t().getValue();
        int i2 = value2 == null ? -1 : a.a[value2.ordinal()];
        if (i2 == 1) {
            View view = this.f10341k.get(FunctionType.FacialFeatures);
            if (view == null) {
                return;
            }
            Collection<ArrayList<us.pinguo.edit2020.bean.r>> values = this.f10335e.y().values();
            kotlin.jvm.internal.s.g(values, "bottomModule.getFacialFeaturesData().values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                ArrayList<us.pinguo.edit2020.bean.r> it2 = (ArrayList) it.next();
                kotlin.jvm.internal.s.g(it2, "it");
                for (us.pinguo.edit2020.bean.r rVar : it2) {
                    Integer num = hashMap == null ? null : hashMap.get(rVar.f());
                    if (num == null) {
                        num = Integer.valueOf(rVar.g().getDefaultValue());
                    }
                    rVar.g().setCurrentValue(num.intValue());
                }
            }
            ((BeautyAdjustFacialFeaturesView) view).l();
            value = this.f10335e.p().getValue();
            if (value == null) {
                return;
            }
        } else if (i2 != 2) {
            value = this.f10335e.p().getValue();
            if (value == null) {
                return;
            }
        } else {
            SkinRefreshController skinRefreshController = this.m;
            us.pinguo.edit2020.bean.i I = skinRefreshController == null ? null : skinRefreshController.I();
            if (I == null) {
                return;
            }
            BeautyEditData g2 = I.g();
            Integer num2 = hashMap != null ? hashMap.get(I.f()) : null;
            if (num2 == null) {
                num2 = Integer.valueOf(I.g().getDefaultValue());
            }
            I.g().setCurrentValue(num2.intValue());
            value = g2;
        }
        this.c.I(value.getMinValue(), value.getMaxValue(), value.getCurrentValue(), value.getDefaultValue());
        this.f10335e.q0(value);
    }

    private final void b0(boolean z, boolean z2) {
        Drawable drawable = ContextCompat.getDrawable(this.f10340j, z ? R.drawable.ic_inner_undo_enable : R.drawable.ic_inner_undo_unable);
        if (drawable != null) {
            this.c.i().setImageDrawable(drawable);
        }
        Drawable drawable2 = ContextCompat.getDrawable(this.f10340j, z2 ? R.drawable.ic_inner_redo_enable : R.drawable.ic_inner_redo_unable);
        if (drawable2 == null) {
            return;
        }
        this.c.h().setImageDrawable(drawable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        this.f10335e.c(EditModel.OneStepToBeauty);
        d0();
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f10338h;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        this.f10335e.t().setValue(FunctionType.AutoBeauty);
        n0();
    }

    private final void d0() {
        H();
        ((FrameLayout) this.b.findViewById(R.id.flContainerSubItems)).removeAllViews();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout.findViewById(i2)).B();
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.f10335e.k().b(), false, null, 6, null);
        y2 y2Var = this.o;
        this.y = y2Var;
        this.s = y2Var;
        W();
        us.pinguo.edit2020.b.c cVar = this.s;
        if (cVar == null) {
            return;
        }
        c.a.e(cVar, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        this.f10335e.c(EditModel.ManualDeformation);
        this.c.E();
        f0();
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f10338h;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        this.f10335e.t().setValue(FunctionType.BodyShaping);
    }

    private final void f0() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(I());
        W();
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.bottomTabLayout;
        ((PGEditBottomTabLayout) constraintLayout2.findViewById(i3)).l();
        Context context = this.f10340j;
        kotlin.jvm.internal.s.g(context, "context");
        View a2 = us.pinguo.edit2020.utils.d.a(context, R.string.main_menu_beauty_handshape, false, true);
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(i3);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.g(pGEditBottomTabLayout, new View[]{a2}, false, null, 6, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).d(new b());
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).B();
        this.y = this.p;
        this.c.I(0, 100, 25, 25);
        this.c.D(this.p);
        this.c.F(true);
        this.c.x(false);
        this.s = this.p;
        b0(false, false);
        us.pinguo.edit2020.b.c cVar = this.s;
        if (cVar != null) {
            c.a.e(cVar, null, 1, null);
        }
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        if (us.pinguo.repository2020.utils.o.b(oVar, "new_to_body_shaping", true, null, 4, null)) {
            us.pinguo.repository2020.utils.o.n(oVar, "new_to_body_shaping", false, null, 4, null);
            Context context2 = this.b.getContext();
            kotlin.jvm.internal.s.g(context2, "fragmentLayout.context");
            us.pinguo.edit2020.widget.k kVar = new us.pinguo.edit2020.widget.k(context2, TutorialModel.VIDEO_TYPE_BODY_SHAPING);
            kVar.show();
            VdsAgent.showDialog(kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        this.f10335e.c(EditModel.Facial3D);
        if (this.n == null) {
            EditBeautyModule editBeautyModule = this.f10335e;
            FrameLayout frameLayout = (FrameLayout) this.b.findViewById(R.id.flContainerSubItems);
            kotlin.jvm.internal.s.g(frameLayout, "fragmentLayout.flContainerSubItems");
            PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout);
            kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
            ViewStub viewStub = (ViewStub) this.b.findViewById(R.id.stubFacial3DAdjust);
            kotlin.jvm.internal.s.g(viewStub, "fragmentLayout.stubFacial3DAdjust");
            this.n = new Facial3DController(editBeautyModule, frameLayout, pGEditBottomTabLayout, viewStub);
        }
        this.c.E();
        Facial3DController facial3DController = this.n;
        this.y = facial3DController;
        this.s = facial3DController;
        if (facial3DController != null) {
            c.a.e(facial3DController, null, 1, null);
        }
        W();
        this.f10335e.t().setValue(FunctionType.FACIAL_3D);
        n0();
    }

    private final void h0() {
        this.u = 0;
        this.x.clear();
        this.f10334d.r(false);
        this.f10334d.u(-1);
        BeautyAdjustFacialFeaturesView beautyAdjustFacialFeaturesView = (BeautyAdjustFacialFeaturesView) J();
        this.c.v(this.z);
        this.c.x(true);
        if (this.f10335e.v() >= 2) {
            beautyAdjustFacialFeaturesView.setFaceSelectTipVisible(true);
            this.c.C(false);
        } else {
            beautyAdjustFacialFeaturesView.setFaceSelectTipVisible(false);
            this.c.C(true);
        }
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(beautyAdjustFacialFeaturesView);
        W();
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.bottomTabLayout;
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) constraintLayout2.findViewById(i3);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.f10335e.z(), true, null, 4, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).B();
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).y(this.u);
        ((PGEditBottomTabLayout) this.b.findViewById(i3)).d(new c(beautyAdjustFacialFeaturesView));
        ArrayList<us.pinguo.edit2020.bean.r> arrayList = this.f10335e.y().get(this.f10340j.getString(R.string.edit_facialfeatures_tab_face));
        if (arrayList == null) {
            return;
        }
        BeautyAdjustFacialFeaturesView.k(beautyAdjustFacialFeaturesView, arrayList, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        this.f10335e.c(EditModel.AutoDeformation);
        this.c.E();
        h0();
        this.f10335e.r0(true);
        n0();
        this.f10335e.t().setValue(FunctionType.FacialFeatures);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f10338h;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Boolean.TRUE);
    }

    private final void k0(String str) {
        M();
        MakeupController makeupController = this.q;
        this.y = makeupController;
        this.s = makeupController;
        this.f10334d.r(false);
        W();
        MakeupController makeupController2 = this.q;
        if (makeupController2 != null) {
            makeupController2.K(this.r);
        }
        us.pinguo.edit2020.b.c cVar = this.s;
        if (cVar != null) {
            cVar.z(str);
        }
        y2 y2Var = this.o;
        if (y2Var != null) {
            y2Var.h(false);
        }
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        this.f10335e.c(EditModel.SoftSkin);
        if (this.f10342l == null) {
            this.f10342l = new MultiFunctionController(this.b, this.f10335e);
        }
        MultiFunctionController multiFunctionController = this.f10342l;
        this.s = multiFunctionController;
        if (multiFunctionController != null) {
            c.a.e(multiFunctionController, null, 1, null);
        }
        this.f10335e.t().setValue(FunctionType.NEW_SKIN_REFRESH);
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(us.pinguo.edit2020.bean.h hVar) {
        this.f10335e.c(EditModel.SoftSkin);
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.f10338h;
        if (lVar != null) {
            lVar.invoke(Boolean.TRUE);
        }
        this.f10334d.r(true);
        if (this.m == null) {
            Context context = this.f10340j;
            kotlin.jvm.internal.s.g(context, "context");
            SkinRefreshController skinRefreshController = new SkinRefreshController(context, this.b, this.c, this.f10335e, this.a);
            this.m = skinRefreshController;
            if (skinRefreshController != null) {
                skinRefreshController.i0(new EditBottomTabBeautyControllerNew$showNewSkinRefresh$1(this));
            }
            SkinRefreshController skinRefreshController2 = this.m;
            if (skinRefreshController2 != null) {
                skinRefreshController2.h0(this.f10339i);
            }
            SkinRefreshController skinRefreshController3 = this.m;
            if (skinRefreshController3 != null) {
                skinRefreshController3.g0(this.f10338h);
            }
        }
        this.y = this.m;
        List<us.pinguo.edit2020.bean.i> l2 = this.f10335e.l(hVar.f());
        SkinRefreshController skinRefreshController4 = this.m;
        if (skinRefreshController4 != null) {
            SkinRefreshController.l0(skinRefreshController4, hVar, l2, 0, 4, null);
        }
        W();
        SkinRefreshController skinRefreshController5 = this.m;
        this.s = skinRefreshController5;
        if (skinRefreshController5 != null) {
            c.a.e(skinRefreshController5, null, 1, null);
        }
        this.f10335e.t().setValue(FunctionType.NEW_SKIN_REFRESH);
    }

    private final void n0() {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.a), kotlinx.coroutines.z0.c(), null, new EditBottomTabBeautyControllerNew$showNoFaceDialog$1(this, null), 2, null);
    }

    private final void o0() {
        String J;
        Boolean x;
        FunctionType value = this.f10335e.t().getValue();
        int i2 = value == null ? -1 : a.a[value.ordinal()];
        if (i2 == 1) {
            us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_remodel", null, "exited");
        } else if (i2 != 2) {
            if (i2 == 3) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_instant_beauty", null, "exited");
            } else if (i2 == 4) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_face_lift", null, "exited");
            } else if (i2 != 5) {
            } else {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_contour", null, "exited");
            }
        } else {
            MultiFunctionController multiFunctionController = this.f10342l;
            boolean z = false;
            if (multiFunctionController != null && (x = multiFunctionController.x()) != null) {
                z = x.booleanValue();
            }
            if (z) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_fuse", null, "exited");
                return;
            }
            SkinRefreshController skinRefreshController = this.m;
            String str = "";
            if (skinRefreshController != null && (J = skinRefreshController.J()) != null) {
                str = J;
            }
            us.pinguo.foundation.statistics.h.b.m0(us.pinguo.edit2020.repository.a.e(str), null, "exited");
        }
    }

    private final void p0() {
        String J;
        Boolean x;
        FunctionType value = this.f10335e.t().getValue();
        int i2 = value == null ? -1 : a.a[value.ordinal()];
        if (i2 == 1) {
            us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_remodel", null, "save");
        } else if (i2 != 2) {
            if (i2 == 3) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_instant_beauty", null, "save");
            } else if (i2 == 4) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_face_lift", null, "save");
            } else if (i2 != 5) {
            } else {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_facial_contour", null, "save");
            }
        } else {
            MultiFunctionController multiFunctionController = this.f10342l;
            boolean z = false;
            if (multiFunctionController != null && (x = multiFunctionController.x()) != null) {
                z = x.booleanValue();
            }
            if (z) {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_fuse", null, "save");
                return;
            }
            SkinRefreshController skinRefreshController = this.m;
            String str = "";
            if (skinRefreshController != null && (J = skinRefreshController.J()) != null) {
                str = J;
            }
            us.pinguo.foundation.statistics.h.b.m0(us.pinguo.edit2020.repository.a.e(str), null, "save");
        }
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void B(boolean z) {
        MakeupController makeupController;
        if (!(this.s instanceof MakeupController) || (makeupController = this.q) == null) {
            return;
        }
        makeupController.B(z);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void K(us.pinguo.facedetector.c cVar) {
        this.r = cVar;
        int c2 = cVar == null ? -1 : cVar.c();
        if (c2 > 0) {
            EditMakeupModule D = this.f10335e.D();
            Long[] lArr = new Long[c2];
            for (int i2 = 0; i2 < c2; i2++) {
                lArr[i2] = 0L;
            }
            D.n0(lArr);
            EditMakeupModule D2 = this.f10335e.D();
            StyleMakeup[] styleMakeupArr = new StyleMakeup[c2];
            for (int i3 = 0; i3 < c2; i3++) {
                styleMakeupArr[i3] = null;
            }
            D2.v0(styleMakeupArr);
        }
    }

    @Override // us.pinguo.edit2020.controller.c3
    public boolean L(us.pinguo.edit2020.model.editgoto.b editGoto) {
        kotlin.jvm.internal.s.h(editGoto, "editGoto");
        switch (a.b[editGoto.a().ordinal()]) {
            case 1:
                show();
                return true;
            case 2:
                this.f10336f.invoke(new EditBottomTabBeautyControllerNew$onGotoEvent$1(this));
                return true;
            case 3:
                this.f10336f.invoke(new EditBottomTabBeautyControllerNew$onGotoEvent$2(this));
                return true;
            case 4:
                this.f10336f.invoke(new EditBottomTabBeautyControllerNew$onGotoEvent$3(this));
                return true;
            case 5:
                this.f10336f.invoke(new EditBottomTabBeautyControllerNew$onGotoEvent$4(this, editGoto));
                return true;
            case 6:
                this.f10336f.invoke(new EditBottomTabBeautyControllerNew$onGotoEvent$5(this));
                return true;
            default:
                return false;
        }
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void N(kotlin.jvm.b.l<? super Boolean, kotlin.u> outFun) {
        kotlin.jvm.internal.s.h(outFun, "outFun");
        this.f10338h = outFun;
    }

    @Override // us.pinguo.edit2020.controller.c3
    public void Q() {
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return d3.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        FunctionType value = this.f10335e.t().getValue();
        if (FunctionType.NEW_SKIN_REFRESH == value) {
            return this.f10335e.Z(EditBottomTabBeautyControllerNew$needExitCheck$1.INSTANCE);
        }
        if (FunctionType.BodyShaping == value) {
            return this.w;
        }
        if (FunctionType.FACIAL_3D == value) {
            return this.f10335e.V();
        }
        if (FunctionType.MakeupMenu == value) {
            return this.f10335e.Y();
        }
        if (FunctionType.FacialFeatures == value) {
            return this.f10335e.W();
        }
        return d3.a.b(this);
    }

    @Override // us.pinguo.edit2020.controller.d3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        e3 e3Var = this.y;
        if (e3Var == null) {
            return true;
        }
        return e3Var.b(event);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        us.pinguo.edit2020.b.c cVar = this.s;
        if (!(cVar != null && cVar.f())) {
            this.f10341k.remove(FunctionType.SKIN_COLOR);
            X();
            p0();
            us.pinguo.edit2020.b.c cVar2 = this.s;
            if (cVar2 != null) {
                cVar2.d();
            }
            this.s = null;
            this.f10335e.i0();
            this.f10335e.m0();
            show();
            this.c.z(false);
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).f();
            return;
        }
        us.pinguo.edit2020.b.c cVar3 = this.s;
        if (cVar3 == null) {
            return;
        }
        cVar3.d();
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        MakeupController makeupController = this.q;
        if (makeupController == null) {
            return;
        }
        makeupController.e(unityCanvasStatus);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        us.pinguo.edit2020.b.c cVar = this.s;
        if (cVar == null) {
            return false;
        }
        return cVar.f();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        us.pinguo.edit2020.b.c cVar = this.s;
        if (!(cVar != null && cVar.f())) {
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).f();
            this.c.z(false);
            X();
            o0();
            us.pinguo.edit2020.b.c cVar2 = this.s;
            if (cVar2 != null) {
                cVar2.g();
            }
            this.s = null;
            this.f10335e.i0();
            this.f10335e.y0(null);
            show();
            return;
        }
        us.pinguo.edit2020.b.c cVar3 = this.s;
        if (cVar3 == null) {
            return;
        }
        cVar3.g();
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void i(String records) {
        kotlin.jvm.internal.s.h(records, "records");
        this.f10335e.n().j(records);
    }

    public final void j0(String str) {
        this.f10337g.invoke(null, null);
        this.f10335e.c(EditModel.Makeup);
        this.c.E();
        k0(str);
        this.f10335e.t().setValue(FunctionType.MakeupMenu);
        us.pinguo.foundation.statistics.h.b.m0("edit_panel_makeup", null, "click");
    }

    @Override // us.pinguo.edit2020.controller.a3
    public void n(final boolean z, final boolean z2) {
        this.w = z;
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.edit2020.controller.d1
            @Override // java.lang.Runnable
            public final void run() {
                EditBottomTabBeautyControllerNew.Y(EditBottomTabBeautyControllerNew.this, z, z2);
            }
        });
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void o(int i2) {
        View view;
        this.t = i2;
        a0();
        FunctionType value = this.f10335e.t().getValue();
        FunctionType functionType = FunctionType.FacialFeatures;
        if (value != functionType || (view = this.f10341k.get(functionType)) == null) {
            return;
        }
        ((BeautyAdjustFacialFeaturesView) view).setFaceSelectTipVisible(false);
        this.c.C(true);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        us.pinguo.edit2020.b.c cVar = this.s;
        if (cVar == null) {
            return false;
        }
        return cVar.onBackPressed();
    }

    @Override // us.pinguo.edit2020.controller.d3
    public void show() {
        View O = O();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout.findViewById(i2)).removeAllViews();
        ((FrameLayout) this.b.findViewById(i2)).addView(O);
        this.c.x(false);
        this.f10335e.r0(false);
        this.f10335e.t().setValue(FunctionType.BeautyMenu);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.f10335e.R();
    }
}
