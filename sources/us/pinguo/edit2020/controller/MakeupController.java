package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.abtest.Plan;
import com.pinguo.lib.AppContextProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.common.m.g;
import us.pinguo.common.m.h;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.view.FacePointView;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.WithFadingEdgeRecyclerView;
import us.pinguo.edit2020.viewmodel.module.EditMakeupModule;
import us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout;
import us.pinguo.repository2020.BeautyDataRepository;
import us.pinguo.repository2020.entity.MaterialColor;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.SelfDefMakeup;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
import us.pinguo.repository2020.entity.StyleMakeup;
import us.pinguo.repository2020.entity.Topic;
import us.pinguo.repository2020.manager.BeautyDataManager;
import us.pinguo.ui.widget.AutofitTextView;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
import us.pinguo.widget.common.guide.GuideHandler;
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController implements us.pinguo.edit2020.b.c, e3, g3 {
    private final EditMakeupModule a;
    private final ConstraintLayout b;
    private b3 c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.jvm.b.l<kotlin.jvm.b.a<kotlin.u>, kotlin.u> f10390d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.common.m.h f10391e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.common.m.g<SelfDefMakeup> f10392f;

    /* renamed from: g  reason: collision with root package name */
    private us.pinguo.common.m.g<MaterialColor> f10393g;

    /* renamed from: h  reason: collision with root package name */
    private ObservableInt f10394h;

    /* renamed from: i  reason: collision with root package name */
    private int f10395i;

    /* renamed from: j  reason: collision with root package name */
    private final View f10396j;

    /* renamed from: k  reason: collision with root package name */
    private final float f10397k;

    /* renamed from: l  reason: collision with root package name */
    private final ValueAnimator f10398l;
    private HashMap<Integer, PointF[]> m;
    private HashMap<Integer, PointF[]> n;
    private us.pinguo.edit2020.bean.u0 o;
    private final GuideHandler p;
    private final f q;
    private final int r;
    private final g s;

    /* compiled from: MakeupController.kt */
    /* renamed from: us.pinguo.edit2020.controller.MakeupController$8  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass8 extends Lambda implements kotlin.jvm.b.r<PointF, Float, PointF, Integer, kotlin.u> {
        AnonymousClass8() {
            super(4);
        }

        @Override // kotlin.jvm.b.r
        public /* bridge */ /* synthetic */ kotlin.u invoke(PointF pointF, Float f2, PointF pointF2, Integer num) {
            invoke(pointF, f2.floatValue(), pointF2, num.intValue());
            return kotlin.u.a;
        }

        public final void invoke(PointF normalizedFocusPoint, float f2, PointF normalizedOffset, int i2) {
            kotlin.jvm.internal.s.h(normalizedFocusPoint, "normalizedFocusPoint");
            kotlin.jvm.internal.s.h(normalizedOffset, "normalizedOffset");
            kotlin.jvm.b.r<PointF, Float, PointF, Integer, kotlin.u> s = MakeupController.this.a.s();
            if (s == null) {
                return;
            }
            s.invoke(normalizedFocusPoint, Float.valueOf(f2), normalizedOffset, Integer.valueOf(i2));
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements g.a {
        a() {
        }

        @Override // us.pinguo.common.m.g.a
        public void a() {
            MakeupController makeupController = MakeupController.this;
            makeupController.D(makeupController.a.o());
            MakeupController makeupController2 = MakeupController.this;
            makeupController2.k0(makeupController2.a.o());
        }

        @Override // us.pinguo.common.m.g.a
        public void b(View view, SelfDefMakeupMaterial selfDefMakeupMaterial) {
            MakeupController makeupController = MakeupController.this;
            makeupController.e0(makeupController.a.o(), MakeupController.this.a.C(), MakeupController.this.a.F(), view, selfDefMakeupMaterial);
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements g.a {
        b() {
        }

        @Override // us.pinguo.common.m.g.a
        public void a() {
        }

        @Override // us.pinguo.common.m.g.a
        public void b(View view, SelfDefMakeupMaterial selfDefMakeupMaterial) {
            SelfDefMakeup[] selfDefMakeupArr;
            if (selfDefMakeupMaterial instanceof MaterialColor) {
                EditMakeupModule editMakeupModule = MakeupController.this.a;
                int C = MakeupController.this.a.C();
                String hex = ((MaterialColor) selfDefMakeupMaterial).getHex();
                if (hex == null) {
                    hex = "";
                }
                SelfDefMakeup[][] x = MakeupController.this.a.x();
                SelfDefMakeup selfDefMakeup = null;
                if (x != null && (selfDefMakeupArr = x[MakeupController.this.a.o()]) != null) {
                    selfDefMakeup = selfDefMakeupArr[MakeupController.this.a.C()];
                }
                editMakeupModule.j(C, hex, selfDefMakeup);
                MakeupController makeupController = MakeupController.this;
                makeupController.d0(makeupController.a.o(), MakeupController.this.a.C(), MakeupController.this.a.F(), view, selfDefMakeupMaterial);
            }
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class c implements FacePointView.a {
        c() {
        }

        @Override // us.pinguo.edit2020.view.FacePointView.a
        public void a(int i2, PointF pointF, boolean z) {
            kotlin.jvm.internal.s.h(pointF, "pointF");
            MakeupController.this.a.w0(MakeupController.this.a.C(), i2, pointF);
            ((MagnifierView) MakeupController.this.b.findViewById(R.id.magnifierView)).setShowCross(!z);
            ((ShapeDirectionView) MakeupController.this.b.findViewById(R.id.handShapeView)).setShowCross(!z);
        }

        @Override // us.pinguo.edit2020.view.FacePointView.a
        public void b(HashMap<Integer, PointF[]> changedPoints) {
            kotlin.jvm.internal.s.h(changedPoints, "changedPoints");
            MakeupController.this.a.n(MakeupController.this.m, MakeupController.this.n);
            MakeupController.this.a.n(changedPoints, MakeupController.this.m);
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class d implements us.pinguo.ui.widget.h {
        d() {
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            Integer[] editMakeupLastValues;
            SelfDefMakeup[] selfDefMakeupArr;
            SelfDefMakeup selfDefMakeup;
            Integer[] editMakeupCurrentValues;
            Integer[] editFilterLastValues;
            int C = MakeupController.this.a.C();
            int i3 = MakeupController.this.f10394h.get();
            if (i3 == 0) {
                MakeupController.this.a.m(i2, false);
                StyleMakeup value = MakeupController.this.a.y().getValue();
                if (value == null || (editMakeupLastValues = value.getEditMakeupLastValues()) == null) {
                    return;
                }
                editMakeupLastValues[C] = Integer.valueOf(i2);
            } else if (i3 == 1) {
                MakeupController.this.a.k(i2, false);
                SelfDefMakeup[][] x = MakeupController.this.a.x();
                if (x == null || (selfDefMakeupArr = x[MakeupController.this.a.o()]) == null || (selfDefMakeup = selfDefMakeupArr[C]) == null || (editMakeupCurrentValues = selfDefMakeup.getEditMakeupCurrentValues()) == null) {
                    return;
                }
                editMakeupCurrentValues[C] = Integer.valueOf(i2);
            } else if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                MakeupController.this.a.k(i2, false);
            } else {
                MakeupController.this.a.l(i2, false);
                StyleMakeup value2 = MakeupController.this.a.y().getValue();
                if (value2 == null || (editFilterLastValues = value2.getEditFilterLastValues()) == null) {
                    return;
                }
                editFilterLastValues[C] = Integer.valueOf(i2);
            }
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            SelfDefMakeup[] selfDefMakeupArr;
            StyleMakeup value = MakeupController.this.a.y().getValue();
            SelfDefMakeup selfDefMakeup = null;
            Integer[] editMakeupCurrentValues = value == null ? null : value.getEditMakeupCurrentValues();
            int C = MakeupController.this.a.C();
            SelfDefMakeup[][] x = MakeupController.this.a.x();
            if (x != null && (selfDefMakeupArr = x[MakeupController.this.a.o()]) != null) {
                selfDefMakeup = (SelfDefMakeup) kotlin.collections.j.t(selfDefMakeupArr, MakeupController.this.a.C());
            }
            int i3 = MakeupController.this.f10394h.get();
            if (i3 == 0) {
                if (editMakeupCurrentValues != null) {
                    editMakeupCurrentValues[C] = Integer.valueOf(i2);
                }
                MakeupController.this.a.m(i2, true);
            } else if (i3 == 1) {
                if (selfDefMakeup != null) {
                    Integer[] editMakeupCurrentValues2 = selfDefMakeup.getEditMakeupCurrentValues();
                    if (editMakeupCurrentValues2 != null) {
                        editMakeupCurrentValues2[C] = Integer.valueOf(i2);
                    }
                    MakeupController.this.a.k(i2, true);
                }
            } else if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                MakeupController.this.a.k(i2, true);
            } else {
                if (editMakeupCurrentValues != null) {
                    editMakeupCurrentValues[C] = Integer.valueOf(i2);
                }
                MakeupController.this.a.l(i2, true);
            }
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements PaintEraserAdjustLayout.a {
        e() {
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout.a
        public void a() {
            MakeupController.this.f10394h.set(0);
            MakeupController makeupController = MakeupController.this;
            makeupController.f10395i = makeupController.f10394h.get();
            MakeupController.this.P();
        }

        @Override // us.pinguo.edit2020.widget.adjust.PaintEraserAdjustLayout.a
        public void b() {
            MakeupController.this.f10394h.set(3);
            MakeupController makeupController = MakeupController.this;
            makeupController.f10395i = makeupController.f10394h.get();
            MakeupController.this.P();
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class f extends RecyclerView.ItemDecoration {
        f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.s.h(outRect, "outRect");
            kotlin.jvm.internal.s.h(view, "view");
            kotlin.jvm.internal.s.h(parent, "parent");
            kotlin.jvm.internal.s.h(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
            if (valueOf == null) {
                return;
            }
            int intValue = valueOf.intValue();
            if (childAdapterPosition == 0) {
                outRect.left = us.pinguo.foundation.utils.n0.c(12);
            } else if (childAdapterPosition == intValue - 1) {
                outRect.right = us.pinguo.foundation.utils.n0.c(12);
            }
            us.pinguo.common.log.a.k("itemDecoration: itemPosition:" + childAdapterPosition + "  left->" + outRect.left + " right->" + outRect.right + "  childCount:" + intValue, new Object[0]);
        }
    }

    /* compiled from: MakeupController.kt */
    /* loaded from: classes4.dex */
    public static final class g implements PGEditTabLayout.d {
        g() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            MakeupController.this.f0(tab.i());
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f tab) {
            kotlin.jvm.internal.s.h(tab, "tab");
            MakeupController.this.f0(tab.i());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MakeupController(EditMakeupModule makeupModule, ConstraintLayout fragmentLayout, b3 faceCurveController, kotlin.jvm.b.l<? super kotlin.jvm.b.a<kotlin.u>, kotlin.u> checkUnityPrepareAction) {
        List<StyleMakeup> suites;
        kotlin.jvm.internal.s.h(makeupModule, "makeupModule");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(faceCurveController, "faceCurveController");
        kotlin.jvm.internal.s.h(checkUnityPrepareAction, "checkUnityPrepareAction");
        this.a = makeupModule;
        this.b = fragmentLayout;
        this.c = faceCurveController;
        this.f10390d = checkUnityPrepareAction;
        MaterialResponse<StyleMakeup> value = BeautyDataManager.a.p().getValue();
        this.f10391e = (value == null || (suites = value.getSuites()) == null) ? null : new us.pinguo.common.m.h(suites, true, true);
        this.f10392f = new us.pinguo.common.m.g<>();
        this.f10393g = new us.pinguo.common.m.g<>();
        this.f10394h = new ObservableInt(0);
        View inflate = LayoutInflater.from(fragmentLayout.getContext()).inflate(R.layout.layout_stylemakeup_panel, (ViewGroup) null, false);
        this.f10396j = inflate;
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        this.f10397k = us.pinguo.util.h.i(b2) - us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f10398l = valueAnimator;
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        us.pinguo.foundation.utils.n0.i();
        Context context = inflate.getContext();
        Objects.requireNonNull(context, "null cannot be cast to non-null type android.app.Activity");
        GuideHandler k2 = GuideHandler.k((Activity) context);
        k2.H("adjust_face_tint", 1);
        k2.B(GuideHandler.Gravity.LEFT);
        k2.G(GuideHandler.VGravity.UP);
        k2.w(false);
        k2.A(R.drawable.guide_toast_left);
        k2.z(32, 8);
        k2.F(inflate.getContext().getString(R.string.edit_adjust_face_point_hint));
        k2.E(true);
        k2.D(us.pinguo.foundation.utils.n0.c(8), 0, us.pinguo.foundation.utils.n0.c(8), 0);
        this.p = k2;
        f fVar = new f();
        this.q = fVar;
        int i2 = R.id.flContainerSubItems;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(((FrameLayout) fragmentLayout.findViewById(i2)).getContext());
        linearLayoutManager.setOrientation(0);
        int i3 = R.id.rvStyleMakeup;
        ((RecyclerView) inflate.findViewById(i3)).setLayoutManager(linearLayoutManager);
        us.pinguo.common.m.h hVar = this.f10391e;
        if (hVar != null) {
            hVar.j(makeupModule.W());
        }
        ((RecyclerView) inflate.findViewById(i3)).setAdapter(this.f10391e);
        ((RecyclerView) inflate.findViewById(i3)).addItemDecoration(fVar);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(((FrameLayout) fragmentLayout.findViewById(i2)).getContext());
        linearLayoutManager2.setOrientation(0);
        int i4 = R.id.rvSelfDefMakeup;
        ((WithFadingEdgeRecyclerView) inflate.findViewById(i4)).setLayoutManager(linearLayoutManager2);
        us.pinguo.common.m.h hVar2 = this.f10391e;
        us.pinguo.common.m.h hVar3 = hVar2 instanceof us.pinguo.common.m.e ? hVar2 : null;
        if (hVar3 != null) {
            hVar3.d(true);
        }
        ((WithFadingEdgeRecyclerView) inflate.findViewById(i4)).setAdapter(this.f10392f);
        ((WithFadingEdgeRecyclerView) inflate.findViewById(i4)).addItemDecoration(fVar);
        us.pinguo.common.m.h hVar4 = this.f10391e;
        if (hVar4 != null) {
            hVar4.l(new h.b() { // from class: us.pinguo.edit2020.controller.MakeupController.1
                @Override // us.pinguo.common.m.h.b
                public void a() {
                    ObservableBoolean isSelected;
                    boolean z = true;
                    MakeupController.this.a.W().set(true);
                    StyleMakeup value2 = MakeupController.this.a.y().getValue();
                    if (value2 != null && (isSelected = value2.isSelected()) != null) {
                        isSelected.set(false);
                    }
                    MakeupController.this.a.y().setValue(null);
                    MakeupController makeupController = MakeupController.this;
                    makeupController.c0(makeupController.a.y().getValue(), false);
                    MakeupController.this.a.h(MakeupController.this.a.v());
                    List<Topic> O = MakeupController.this.a.O();
                    if (O != null && !O.isEmpty()) {
                        z = false;
                    }
                    if (z) {
                        return;
                    }
                    int size = O.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        MakeupController.this.D(i5);
                    }
                }

                @Override // us.pinguo.common.m.h.b
                public void f(View view, StyleMakeup styleMakeup, boolean z) {
                    boolean z2 = !MakeupController.this.a.X(styleMakeup);
                    Plan icon_ab = styleMakeup == null ? null : styleMakeup.getIcon_ab();
                    if (icon_ab != null) {
                        if (!kotlin.jvm.internal.s.c(icon_ab.getGid(), "gid_default")) {
                            if (!kotlin.jvm.internal.s.c(icon_ab.getTid(), "tid_default")) {
                                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                                String gid = icon_ab.getGid();
                                String str = gid != null ? gid : "gid_default";
                                String tid = icon_ab.getTid();
                                iVar.D(str, "edit_page", tid != null ? tid : "tid_default", "click");
                            }
                        }
                    }
                    EditMakeupModule editMakeupModule = MakeupController.this.a;
                    if (styleMakeup == null) {
                        return;
                    }
                    editMakeupModule.h0(styleMakeup);
                    if (view != null) {
                        MakeupController.this.a.c0(styleMakeup, new MakeupController$1$onStyleMakeupItemClick$1(MakeupController.this, styleMakeup));
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        ObservableField<MaterialInstallState> installState = styleMakeup.getInstallState();
                        if ((installState != null ? installState.get() : null) != MaterialInstallState.STATE_DOWNLOADING) {
                            if (us.pinguo.util.q.f(us.pinguo.foundation.e.b())) {
                                Context b3 = us.pinguo.foundation.e.b();
                                kotlin.jvm.internal.s.g(b3, "getAppContext()");
                                if (us.pinguo.util.q.h(b3) || us.pinguo.repository2020.m.a.C()) {
                                    MakeupController.this.I(styleMakeup);
                                    return;
                                } else {
                                    MakeupController.this.r0(styleMakeup);
                                    return;
                                }
                            }
                            us.pinguo.foundation.utils.k0.a.a(R.string.no_network_connection_toast);
                        }
                    }
                }
            });
        }
        this.f10392f.l(new a());
        this.f10393g.m(false);
        this.f10393g.l(new b());
        ((FacePointView) fragmentLayout.findViewById(R.id.facePointView)).setOnFacePointChangedListener(new c());
        int i5 = R.id.adjustLayout;
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(R.id.ivUndo);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivUndo");
        imageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView, 8);
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(R.id.ivRedo);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivRedo");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        int i6 = R.id.ivSwitchFace;
        ImageView imageView3 = (ImageView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i6);
        kotlin.jvm.internal.s.g(imageView3, "fragmentLayout.adjustLayout.ivSwitchFace");
        imageView3.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView3, 8);
        AppContextProvider appContextProvider = AppContextProvider.INSTANCE;
        ((TextView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(R.id.tvPaint)).setText(appContextProvider.getContext().getResources().getString(R.string.filter));
        int i7 = R.id.tvEraser;
        ((TextView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i7)).setText(appContextProvider.getContext().getResources().getString(R.string.text_looks));
        int i8 = R.id.sbAdjust;
        ((StickySeekBar) fragmentLayout.findViewById(i8)).setValues(0, 100, 100, 80);
        ((StickySeekBar) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i8)).setEnableDiscrete(true);
        ConstraintLayout constraintLayout = (ConstraintLayout) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(R.id.hideableAdjust);
        constraintLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout, 4);
        ((LinearLayout) inflate.findViewById(R.id.llFacePointReset)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.y1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeupController.a(MakeupController.this, view);
            }
        });
        int i9 = R.id.llAdjust;
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i9)).getLayoutParams();
        layoutParams.height = fragmentLayout.getResources().getDimensionPixelSize(R.dimen.user_operation_height);
        ((LinearLayout) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i9)).setLayoutParams(layoutParams);
        ((LinearLayout) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i9)).setBackgroundColor(fragmentLayout.getContext().getResources().getColor(R.color.white));
        us.pinguo.edit2020.databinding.m mVar = (us.pinguo.edit2020.databinding.m) DataBindingUtil.bind((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5));
        if (mVar != null) {
            mVar.a(this.f10394h);
        }
        ((StickySeekBar) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i8)).setTrackListener(new d());
        ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).setOnPaintEraseClickListener(new e());
        this.c.t(new AnonymousClass8());
        ((ImageView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i6)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.d2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeupController.c(MakeupController.this, view);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MakeupController.h(MakeupController.this, view);
            }
        };
        ((AppCompatImageView) inflate.findViewById(R.id.ivColorPick)).setOnClickListener(onClickListener);
        ((TextView) inflate.findViewById(R.id.tvColorPick)).setOnClickListener(onClickListener);
        ((TextView) ((PaintEraserAdjustLayout) fragmentLayout.findViewById(i5)).a(i7)).performClick();
        ((ShapeDirectionView) fragmentLayout.findViewById(R.id.handShapeView)).setSinglePointMode(true);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.controller.c2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                MakeupController.i(MakeupController.this, valueAnimator2);
            }
        });
        valueAnimator.setDuration(100L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        Context context2 = fragmentLayout.getContext();
        kotlin.jvm.internal.s.g(context2, "fragmentLayout.context");
        this.r = us.pinguo.util.g.a(context2, 20.0f);
        this.s = new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.MakeupController.E():void");
    }

    private final void G(boolean z) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.f10396j.findViewById(R.id.ivColorPick);
        kotlin.jvm.internal.s.g(appCompatImageView, "makeupView.ivColorPick");
        int i2 = z ? 0 : 8;
        appCompatImageView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(appCompatImageView, i2);
        TextView textView = (TextView) this.f10396j.findViewById(R.id.tvColorPick);
        kotlin.jvm.internal.s.g(textView, "makeupView.tvColorPick");
        int i3 = z ? 0 : 8;
        textView.setVisibility(i3);
        VdsAgent.onSetViewVisibility(textView, i3);
        View findViewById = this.f10396j.findViewById(R.id.divider);
        kotlin.jvm.internal.s.g(findViewById, "makeupView.divider");
        int i4 = z ? 0 : 8;
        findViewById.setVisibility(i4);
        VdsAgent.onSetViewVisibility(findViewById, i4);
    }

    private final void H(View view, SelfDefMakeup selfDefMakeup) {
        ObservableField<MaterialInstallState> installState = selfDefMakeup.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        this.a.p(selfDefMakeup, new MakeupController$downSelfDefMakeup$1(this, selfDefMakeup, view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(StyleMakeup styleMakeup) {
        String pid = styleMakeup.getPid();
        if (pid == null) {
            return;
        }
        ObservableField<MaterialInstallState> installState = styleMakeup.getInstallState();
        if (installState != null) {
            installState.set(MaterialInstallState.STATE_DOWNLOADING);
        }
        this.a.q(pid, new MakeupController$downStyleMakeup$1$1(this, styleMakeup));
    }

    private final void J() {
        ObservableBoolean e2;
        this.c.u(-1);
        this.c.l();
        ((MagnifierView) this.b.findViewById(R.id.magnifierView)).setShowCross(false);
        this.f10394h.set(0);
        this.f10395i = 0;
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.adjustLayout;
        ((PaintEraserAdjustLayout) constraintLayout.findViewById(i2)).m();
        AutofitTextView autofitTextView = (AutofitTextView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.tvSelectFaceHint);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.adjustLayout.tvSelectFaceHint");
        autofitTextView.setVisibility(8);
        VdsAgent.onSetViewVisibility(autofitTextView, 8);
        AppCompatImageView appCompatImageView = (AppCompatImageView) this.b.findViewById(R.id.showOriginPicBt);
        kotlin.jvm.internal.s.g(appCompatImageView, "fragmentLayout.showOriginPicBt");
        appCompatImageView.setVisibility(0);
        VdsAgent.onSetViewVisibility(appCompatImageView, 0);
        PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout, "fragmentLayout.adjustLayout");
        paintEraserAdjustLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout, 8);
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView, 8);
        ((FrameLayout) this.b.findViewById(R.id.operationLayout)).setBackgroundColor(-1);
        View view = this.f10396j;
        int i3 = R.id.rvStyleMakeup;
        RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(i3)).getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPosition(0);
        RecyclerView recyclerView = (RecyclerView) this.f10396j.findViewById(i3);
        kotlin.jvm.internal.s.g(recyclerView, "makeupView.rvStyleMakeup");
        recyclerView.setVisibility(0);
        VdsAgent.onSetViewVisibility(recyclerView, 0);
        WithFadingEdgeRecyclerView withFadingEdgeRecyclerView = (WithFadingEdgeRecyclerView) this.f10396j.findViewById(R.id.rvSelfDefMakeup);
        kotlin.jvm.internal.s.g(withFadingEdgeRecyclerView, "makeupView.rvSelfDefMakeup");
        withFadingEdgeRecyclerView.setVisibility(8);
        VdsAgent.onSetViewVisibility(withFadingEdgeRecyclerView, 8);
        G(false);
        us.pinguo.common.m.h hVar = this.f10391e;
        if (hVar != null && (e2 = hVar.e()) != null) {
            e2.set(true);
        }
        this.f10392f.e().set(true);
        E();
        this.a.d0();
    }

    private final int L(int i2) {
        Topic topic;
        String tag;
        HashMap<String, Integer> b2 = BeautyDataRepository.D.b();
        List<Topic> O = this.a.O();
        String str = "";
        if (O != null && (topic = O.get(i2)) != null && (tag = topic.getTag()) != null) {
            str = tag;
        }
        Integer num = b2.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private final void M(us.pinguo.edit2020.bean.u0 u0Var, float f2, float f3) {
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width) * 0.5f;
        float h2 = ((u0Var.h() - u0Var.e()) * 0.5f) + dimension + u0Var.a();
        float h3 = (((u0Var.h() + u0Var.e()) * 0.5f) - dimension) + u0Var.a();
        float f4 = 0.0f;
        float f5 = f2 < h2 ? f2 - h2 : f2 > h3 ? f2 - h3 : 0.0f;
        float g2 = (((u0Var.g() - u0Var.d()) * 0.5f) + dimension) - u0Var.b();
        float g3 = (((u0Var.g() + u0Var.d()) * 0.5f) - dimension) - u0Var.b();
        if (f3 < g2) {
            f4 = f3 - g2;
        } else if (f3 > g3) {
            f4 = f3 - g3;
        }
        ((MagnifierView) ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView)).b(f5, f4);
    }

    private final void O() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flMagnifier;
        ((MagnifierLayout) constraintLayout.findViewById(i2)).animate().cancel();
        MagnifierLayout magnifierLayout = (MagnifierLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(magnifierLayout, "fragmentLayout.flMagnifier");
        magnifierLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(magnifierLayout, 4);
        ((MagnifierLayout) this.b.findViewById(i2)).setClicked(false);
    }

    private final void Q(int i2, int i3, int i4, View view, SelfDefMakeup selfDefMakeup) {
        ObservableBoolean isSelected;
        String hex;
        MaterialColor[] materialColorArr;
        MaterialColor[] materialColorArr2;
        ObservableBoolean isSelected2;
        MaterialColor[] materialColorArr3;
        MaterialColor[][] w = this.a.w();
        MaterialColor materialColor = null;
        if (w != null && (materialColorArr3 = w[i2]) != null) {
            materialColor = materialColorArr3[i3];
        }
        if (!((materialColor == null || (isSelected = materialColor.isSelected()) == null || !isSelected.get()) ? false : true) && view != null) {
            EditMakeupModule editMakeupModule = this.a;
            if (!editMakeupModule.K(editMakeupModule.o()).isEmpty()) {
                materialColor = this.a.K(i2).get(0);
            }
        }
        if (materialColor != null && (isSelected2 = materialColor.isSelected()) != null) {
            isSelected2.set(true);
        }
        MaterialColor[][] w2 = this.a.w();
        if (w2 != null && (materialColorArr2 = w2[i2]) != null) {
            materialColorArr2[i3] = materialColor;
        }
        MaterialColor[][] G = this.a.G();
        if (G != null && (materialColorArr = G[i2]) != null) {
            materialColorArr[i4] = materialColor;
        }
        EditMakeupModule editMakeupModule2 = this.a;
        String str = "";
        if (materialColor != null && (hex = materialColor.getHex()) != null) {
            str = hex;
        }
        editMakeupModule2.j(i3, str, selfDefMakeup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MakeupController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MakeupController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.a.Y();
        this$0.c.v();
        AutofitTextView autofitTextView = (AutofitTextView) ((PaintEraserAdjustLayout) this$0.b.findViewById(R.id.adjustLayout)).a(R.id.tvSelectFaceHint);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.adjustLayout.tvSelectFaceHint");
        autofitTextView.setVisibility(0);
        VdsAgent.onSetViewVisibility(autofitTextView, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(int i2, int i3, int i4, View view, SelfDefMakeupMaterial selfDefMakeupMaterial) {
        SelfDefMakeup[] selfDefMakeupArr;
        if (selfDefMakeupMaterial instanceof SelfDefMakeup) {
            SelfDefMakeup selfDefMakeup = (SelfDefMakeup) selfDefMakeupMaterial;
            this.a.g0(selfDefMakeup);
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = !this.a.V(selfDefMakeup);
            SelfDefMakeup[][] x = this.a.x();
            if (x != null && (selfDefMakeupArr = x[i2]) != null) {
                selfDefMakeupArr[i3] = selfDefMakeup;
            }
            if (view != null) {
                this.a.a0(i3, selfDefMakeup, new MakeupController$onSelfDefMakeupItemClicked$1(ref$BooleanRef, this, i2, i3, i4, view, selfDefMakeupMaterial));
            } else {
                ref$BooleanRef.element = false;
            }
            if (ref$BooleanRef.element) {
                ObservableField<MaterialInstallState> installState = selfDefMakeup.getInstallState();
                if ((installState == null ? null : installState.get()) != MaterialInstallState.STATE_DOWNLOADING) {
                    if (us.pinguo.util.q.f(AppContextProvider.INSTANCE.getContext())) {
                        Context b2 = us.pinguo.foundation.e.b();
                        kotlin.jvm.internal.s.g(b2, "getAppContext()");
                        if (!us.pinguo.util.q.h(b2) && !us.pinguo.repository2020.m.a.C()) {
                            o0(view, selfDefMakeup);
                            return;
                        } else {
                            H(view, selfDefMakeup);
                            return;
                        }
                    }
                    us.pinguo.foundation.utils.k0.a.a(R.string.no_network_connection_toast);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(int r11) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.MakeupController.f0(int):void");
    }

    private final void g0() {
        this.a.r(false);
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.facePointView;
        FacePointView facePointView = (FacePointView) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(facePointView, "fragmentLayout.facePointView");
        facePointView.setVisibility(0);
        VdsAgent.onSetViewVisibility(facePointView, 0);
        ((FacePointView) this.b.findViewById(i2)).setFaceIndex(this.a.C());
        ((FacePointView) this.b.findViewById(i2)).n(this.m);
        this.a.n(this.m, this.n);
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.adjustLayout;
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) constraintLayout2.findViewById(i3)).a(R.id.ivSwitchFace);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivSwitchFace");
        imageView.getVisibility();
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        AppContextProvider appContextProvider = AppContextProvider.INSTANCE;
        String string = appContextProvider.getContext().getString(R.string.edit_adjust_face_point);
        kotlin.jvm.internal.s.g(string, "context.getString(R.string.edit_adjust_face_point)");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, new String[]{string}, false, null, 4, null);
        LinearLayout linearLayout = (LinearLayout) this.f10396j.findViewById(R.id.llReset);
        kotlin.jvm.internal.s.g(linearLayout, "makeupView.llReset");
        linearLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(linearLayout, 0);
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i3)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView2.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView2, 8);
        int i4 = R.id.tvSelectFaceHint;
        AutofitTextView autofitTextView = (AutofitTextView) ((PaintEraserAdjustLayout) this.b.findViewById(i3)).a(i4);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.adjustLayout.tvSelectFaceHint");
        autofitTextView.setVisibility(0);
        VdsAgent.onSetViewVisibility(autofitTextView, 0);
        ((AutofitTextView) ((PaintEraserAdjustLayout) this.b.findViewById(i3)).a(i4)).setText(appContextProvider.getContext().getString(R.string.edit_adjust_face_point_hint));
        this.c.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MakeupController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ObservableInt observableInt = this$0.f10394h;
        int i2 = 4;
        if (observableInt.get() == 4) {
            ((AppCompatImageView) this$0.f10396j.findViewById(R.id.ivColorPick)).setImageResource(R.drawable.ic_edit_beauty_makeup_color);
            ((TextView) this$0.f10396j.findViewById(R.id.tvColorPick)).setText(R.string.str_pick_color);
            ((WithFadingEdgeRecyclerView) this$0.f10396j.findViewById(R.id.rvSelfDefMakeup)).setAdapter(this$0.f10392f);
            i2 = 1;
        } else {
            ((AppCompatImageView) this$0.f10396j.findViewById(R.id.ivColorPick)).setImageResource(this$0.L(this$0.a.o()));
            ((TextView) this$0.f10396j.findViewById(R.id.tvColorPick)).setText(R.string.str_style);
            ((WithFadingEdgeRecyclerView) this$0.f10396j.findViewById(R.id.rvSelfDefMakeup)).setAdapter(this$0.f10393g);
        }
        observableInt.set(i2);
    }

    private final void h0() {
        this.a.r(true);
        x0();
        ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).y(this.a.z());
        LinearLayout linearLayout = (LinearLayout) this.f10396j.findViewById(R.id.llReset);
        kotlin.jvm.internal.s.g(linearLayout, "makeupView.llReset");
        linearLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(linearLayout, 8);
        i0();
        FacePointView facePointView = (FacePointView) this.b.findViewById(R.id.facePointView);
        kotlin.jvm.internal.s.g(facePointView, "fragmentLayout.facePointView");
        facePointView.setVisibility(8);
        VdsAgent.onSetViewVisibility(facePointView, 8);
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.adjustLayout;
        int i3 = R.id.tvSelectFaceHint;
        AutofitTextView autofitTextView = (AutofitTextView) ((PaintEraserAdjustLayout) constraintLayout.findViewById(i2)).a(i3);
        kotlin.jvm.internal.s.g(autofitTextView, "fragmentLayout.adjustLayout.tvSelectFaceHint");
        autofitTextView.setVisibility(8);
        VdsAgent.onSetViewVisibility(autofitTextView, 8);
        ((AutofitTextView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3)).setText(AppContextProvider.INSTANCE.getContext().getString(R.string.edit_select_face_hint));
        if (this.a.B() > 1) {
            this.c.v();
            ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivSwitchFace);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivSwitchFace");
            imageView.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView, 8);
        }
        ImageView imageView2 = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.adjustLayout.ivAdjustFace");
        imageView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView2, 0);
        this.a.Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MakeupController this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        ((MagnifierLayout) this$0.b.findViewById(R.id.flMagnifier)).setTranslationX(((Float) animatedValue).floatValue());
    }

    private final void i0() {
        this.a.n(this.n, this.m);
        ((FacePointView) this.b.findViewById(R.id.facePointView)).n(this.m);
    }

    private final void j0() {
        SelfDefMakeup[][] x = this.a.x();
        if (x == null) {
            return;
        }
        int length = x.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            SelfDefMakeup[] selfDefMakeupArr = x[i2];
            k0(i3);
            i2++;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(int i2) {
        MaterialColor[] materialColorArr;
        MaterialColor[] materialColorArr2;
        MaterialColor materialColor;
        ObservableBoolean isSelected;
        MaterialColor[] materialColorArr3;
        MaterialColor[] materialColorArr4;
        MaterialColor materialColor2;
        ObservableBoolean isSelected2;
        SelfDefMakeup[] selfDefMakeupArr;
        SelfDefMakeup[] selfDefMakeupArr2;
        SelfDefMakeup selfDefMakeup;
        ObservableBoolean isSelected3;
        SelfDefMakeup[] selfDefMakeupArr3;
        SelfDefMakeup[] selfDefMakeupArr4;
        SelfDefMakeup selfDefMakeup2;
        ObservableBoolean isSelected4;
        int C = this.a.C();
        SelfDefMakeup[][] x = this.a.x();
        if (x != null && (selfDefMakeupArr4 = x[i2]) != null && (selfDefMakeup2 = selfDefMakeupArr4[C]) != null && (isSelected4 = selfDefMakeup2.isSelected()) != null) {
            isSelected4.set(false);
        }
        SelfDefMakeup[][] x2 = this.a.x();
        if (x2 != null && (selfDefMakeupArr3 = x2[i2]) != null) {
            selfDefMakeupArr3[C] = null;
        }
        SelfDefMakeup[][] H = this.a.H();
        if (H != null && (selfDefMakeupArr2 = H[i2]) != null && (selfDefMakeup = selfDefMakeupArr2[C]) != null && (isSelected3 = selfDefMakeup.isSelected()) != null) {
            isSelected3.set(false);
        }
        SelfDefMakeup[][] H2 = this.a.H();
        if (H2 != null && (selfDefMakeupArr = H2[i2]) != null) {
            selfDefMakeupArr[C] = null;
        }
        MaterialColor[][] w = this.a.w();
        if (w != null && (materialColorArr4 = w[i2]) != null && (materialColor2 = materialColorArr4[C]) != null && (isSelected2 = materialColor2.isSelected()) != null) {
            isSelected2.set(false);
        }
        MaterialColor[][] w2 = this.a.w();
        if (w2 != null && (materialColorArr3 = w2[i2]) != null) {
            materialColorArr3[C] = null;
        }
        MaterialColor[][] G = this.a.G();
        if (G != null && (materialColorArr2 = G[i2]) != null && (materialColor = materialColorArr2[C]) != null && (isSelected = materialColor.isSelected()) != null) {
            isSelected.set(false);
        }
        MaterialColor[][] G2 = this.a.G();
        if (G2 != null && (materialColorArr = G2[i2]) != null) {
            materialColorArr[C] = null;
        }
        Boolean[] T = this.a.T();
        if (T != null) {
            us.pinguo.repository2020.utils.e.a(T, i2, Boolean.TRUE);
        }
        this.f10392f.e().set(true);
    }

    private final PointF l0(PointF pointF, us.pinguo.edit2020.bean.u0 u0Var) {
        float a2 = pointF.x - u0Var.a();
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.facePointView;
        float f2 = 2;
        return new PointF(a2 - ((((FacePointView) constraintLayout.findViewById(i2)).getWidth() - u0Var.e()) / f2), (pointF.y + u0Var.b()) - ((((FacePointView) this.b.findViewById(i2)).getHeight() - u0Var.d()) / f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(boolean z) {
        int E = ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).n().E();
        int i2 = 0;
        while (i2 < E) {
            int i3 = i2 + 1;
            PGEditTabLayout.f D = ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).n().D(i2);
            if (D != null) {
                D.x(z);
            }
            i2 = i3;
        }
        if (z && this.a.E() == -1) {
            ((PGEditBottomTabLayout) this.b.findViewById(R.id.bottomTabLayout)).y(this.a.z());
        }
    }

    private final void o0(final View view, final SelfDefMakeup selfDefMakeup) {
        final Context context = this.f10396j.getContext();
        Activity activity = (Activity) context;
        if (activity != null) {
            us.pinguo.foundation.utils.d0.b(activity);
        }
        us.pinguo.foundation.utils.w.i(context, R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.h2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MakeupController.p0(MakeupController.this, view, selfDefMakeup, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.z1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MakeupController.q0(context, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(MakeupController this$0, View view, SelfDefMakeup selfDefMakeup, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(selfDefMakeup, "$selfDefMakeup");
        if (i2 == -1) {
            this$0.H(view, selfDefMakeup);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(Context context, DialogInterface dialogInterface) {
        if (context == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(final StyleMakeup styleMakeup) {
        final Context context = this.f10396j.getContext();
        Activity activity = (Activity) context;
        if (activity != null) {
            us.pinguo.foundation.utils.d0.b(activity);
        }
        us.pinguo.foundation.utils.w.i(context, R.string.filter_download_dialog_content, R.string.filter_download_dialog_bt_pos, R.string.filter_download_dialog_bt_neg, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.b2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MakeupController.s0(MakeupController.this, styleMakeup, dialogInterface, i2);
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: us.pinguo.edit2020.controller.a2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                MakeupController.t0(context, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(MakeupController this$0, StyleMakeup styleMakeup, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(styleMakeup, "$styleMakeup");
        if (i2 == -1) {
            this$0.I(styleMakeup);
            us.pinguo.repository2020.m.a.S(true);
        }
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Context context, DialogInterface dialogInterface) {
        if (context == null) {
            return;
        }
        us.pinguo.foundation.utils.d0.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        if (this.a.v() > -1 || this.a.B() == 1) {
            ConstraintLayout constraintLayout = this.b;
            int i2 = R.id.adjustLayout;
            int i3 = R.id.ivAdjustFace;
            ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) constraintLayout.findViewById(i2)).a(i3);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivAdjustFace");
            imageView.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView, 0);
            ((ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.e2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MakeupController.v0(MakeupController.this, view);
                }
            });
            this.p.x((ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(MakeupController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.c.q(Integer.valueOf(this$0.a.C()));
        this$0.g0();
    }

    private final void w0() {
        ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setClicked(true);
    }

    private final void x0() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.bottomTabLayout;
        PGEditBottomTabLayout pGEditBottomTabLayout = (PGEditBottomTabLayout) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(pGEditBottomTabLayout, "fragmentLayout.bottomTabLayout");
        PGEditBottomTabLayout.h(pGEditBottomTabLayout, this.a.J(), true, null, 4, null);
        ((PGEditBottomTabLayout) this.b.findViewById(i2)).d(this.s);
        ((PGEditBottomTabLayout) this.b.findViewById(i2)).B();
    }

    public final void B(boolean z) {
        if (z) {
            this.c.l();
            FacePointView facePointView = (FacePointView) this.b.findViewById(R.id.facePointView);
            kotlin.jvm.internal.s.g(facePointView, "fragmentLayout.facePointView");
            facePointView.setVisibility(8);
            VdsAgent.onSetViewVisibility(facePointView, 8);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.ivAdjustFace);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.ivAdjustFace");
            imageView.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView, 8);
            return;
        }
        if (this.a.B() > 1 && !f()) {
            this.c.v();
        }
        if (f()) {
            FacePointView facePointView2 = (FacePointView) this.b.findViewById(R.id.facePointView);
            kotlin.jvm.internal.s.g(facePointView2, "fragmentLayout.facePointView");
            facePointView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(facePointView2, 0);
            return;
        }
        ImageView imageView2 = (ImageView) this.b.findViewById(R.id.ivAdjustFace);
        kotlin.jvm.internal.s.g(imageView2, "fragmentLayout.ivAdjustFace");
        imageView2.setVisibility(0);
        VdsAgent.onSetViewVisibility(imageView2, 0);
    }

    public final void D(int i2) {
        SelfDefMakeup[] selfDefMakeupArr;
        SelfDefMakeup selfDefMakeup;
        int C = this.a.C();
        EditMakeupModule editMakeupModule = this.a;
        SelfDefMakeup[][] x = editMakeupModule.x();
        int i3 = 0;
        if (x != null && (selfDefMakeupArr = x[i2]) != null && (selfDefMakeup = selfDefMakeupArr[C]) != null) {
            i3 = selfDefMakeup.getType();
        }
        editMakeupModule.g(C, i3);
        k0(i2);
        P();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0196 A[LOOP:16: B:99:0x0194->B:100:0x0196, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K(us.pinguo.facedetector.c r11) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.MakeupController.K(us.pinguo.facedetector.c):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0216, code lost:
        if (kotlin.jvm.internal.s.c(r4, java.lang.Boolean.FALSE) != false) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P() {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.MakeupController.P():void");
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean R() {
        return c.a.a(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean S() {
        return c.a.c(this);
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        this.c.o(event);
        if (f()) {
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).l(event);
        }
        us.pinguo.edit2020.bean.u0 u0Var = this.o;
        if (u0Var == null) {
            return false;
        }
        float h2 = u0Var.h();
        float x = event.getX();
        float y = event.getY();
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        float b3 = dimension + us.pinguo.util.g.b(b2, 30.0f);
        int action = event.getAction() & 255;
        if (action == 0) {
            float x2 = event.getX();
            float y2 = event.getY();
            if (x <= b3 && y <= b3) {
                ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setTranslationX(this.f10397k);
            } else {
                ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setTranslationX(0.0f);
            }
            us.pinguo.edit2020.bean.u0 u0Var2 = this.o;
            if (u0Var2 != null) {
                PointF l0 = l0(new PointF(x2, y2), u0Var2);
                float f2 = l0.x;
                us.pinguo.edit2020.bean.u0 u0Var3 = this.o;
                float e2 = f2 / (u0Var3 == null ? 1.0f : u0Var3.e());
                float f3 = l0.y;
                us.pinguo.edit2020.bean.u0 u0Var4 = this.o;
                PointF pointF = new PointF(e2, f3 / (u0Var4 != null ? u0Var4.d() : 1.0f));
                this.a.r0(pointF.x, pointF.y);
            }
            M(u0Var, x, y);
            if (f()) {
                w0();
            }
        } else if (action == 1) {
            ((MagnifierView) this.b.findViewById(R.id.magnifierView)).setShowCross(false);
            ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).setShowCross(false);
            O();
        } else if (action == 2) {
            ConstraintLayout constraintLayout = this.b;
            int i2 = R.id.flMagnifier;
            boolean z = ((MagnifierLayout) constraintLayout.findViewById(i2)).getTranslationX() == 0.0f;
            boolean z2 = ((MagnifierLayout) this.b.findViewById(i2)).getTranslationX() == this.f10397k;
            if (x <= b3 && y <= b3 && z) {
                if (!this.f10398l.isStarted()) {
                    this.f10398l.setFloatValues(0.0f, this.f10397k);
                    this.f10398l.start();
                }
            } else if (x >= h2 - b3 && y <= b3 && z2 && !this.f10398l.isStarted()) {
                this.f10398l.setFloatValues(this.f10397k, 0.0f);
                this.f10398l.start();
            }
            M(u0Var, x, y);
        } else if (action == 3) {
            O();
        } else if (action == 5) {
            O();
        }
        return true;
    }

    public final void c0(StyleMakeup styleMakeup, boolean z) {
        List<StyleMakeup> suites;
        int F;
        Integer valueOf;
        ObservableBoolean isSelected;
        ObservableBoolean isSelected2;
        if (styleMakeup != null) {
            ConstraintLayout constraintLayout = this.b;
            int i2 = R.id.adjustLayout;
            PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) constraintLayout.findViewById(i2);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) paintEraserAdjustLayout.a(R.id.clUndoRedo);
            kotlin.jvm.internal.s.g(constraintLayout2, "adjustLayout.clUndoRedo");
            constraintLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout2, 0);
            AutofitTextView autofitTextView = (AutofitTextView) paintEraserAdjustLayout.a(R.id.tvSelectFaceHint);
            kotlin.jvm.internal.s.g(autofitTextView, "adjustLayout.tvSelectFaceHint");
            autofitTextView.setVisibility(8);
            VdsAgent.onSetViewVisibility(autofitTextView, 8);
            this.a.y().setValue(styleMakeup);
            StyleMakeup value = this.a.y().getValue();
            if (value != null && (isSelected2 = value.isSelected()) != null) {
                isSelected2.set(true);
            }
            this.a.W().set(false);
            us.pinguo.common.m.h hVar = this.f10391e;
            if (hVar != null) {
                hVar.k(this.a.A());
            }
            if (!kotlin.jvm.internal.s.c(this.a.I().getValue(), this.a.y().getValue())) {
                StyleMakeup value2 = this.a.I().getValue();
                if (value2 != null && (isSelected = value2.isSelected()) != null) {
                    isSelected.set(false);
                }
                this.a.I().setValue(this.a.y().getValue());
            }
            if (z) {
                j0();
            }
            ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivSwitchFace);
            kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivSwitchFace");
            imageView.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView, 8);
            MaterialResponse<StyleMakeup> value3 = BeautyDataManager.a.p().getValue();
            if (value3 == null || (suites = value3.getSuites()) == null) {
                valueOf = null;
            } else {
                F = kotlin.collections.c0.F(suites, this.a.y().getValue());
                valueOf = Integer.valueOf(F);
            }
            if (valueOf != null) {
                valueOf.intValue();
                View view = this.f10396j;
                int i3 = R.id.rvStyleMakeup;
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) view.findViewById(i3)).getLayoutManager();
                View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(valueOf.intValue() + 1) : null;
                if (findViewByPosition != null) {
                    ((RecyclerView) this.f10396j.findViewById(i3)).smoothScrollBy(((findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2)) - us.pinguo.foundation.utils.n0.c(6)) - (us.pinguo.foundation.utils.n0.i() / 2), 0);
                } else {
                    int i4 = (us.pinguo.foundation.utils.n0.i() / 2) - (this.f10396j.getResources().getDimensionPixelSize(R.dimen.stylemakeup_rv_item_size) / 2);
                    RecyclerView.LayoutManager layoutManager2 = ((RecyclerView) this.f10396j.findViewById(i3)).getLayoutManager();
                    Objects.requireNonNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(valueOf.intValue(), i4);
                }
            }
            us.pinguo.foundation.statistics.h.b.w("", styleMakeup.getPid());
        }
        P();
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        Iterator<T> it;
        String i0;
        if (!f()) {
            ArrayList<us.pinguo.edit2020.bean.x> P = this.a.P();
            boolean z = false;
            if (!(P instanceof Collection) || !P.isEmpty()) {
                Iterator<T> it2 = P.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (((us.pinguo.edit2020.bean.x) it2.next()).a()) {
                        z = true;
                        break;
                    }
                }
            }
            String str = z ? "use_vip_func_or_material" : "nonuse_vip_func_or_material";
            if (us.pinguo.repository2020.abtest.a.a.c()) {
                us.pinguo.foundation.statistics.h.b.K("edit_panel_makeup", str, "save");
            } else {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_makeup", null, "save");
            }
            String str2 = "";
            while (this.a.P().iterator().hasNext()) {
                str2 = str2 + ((us.pinguo.edit2020.bean.x) it.next()).f() + '-';
            }
            i0 = StringsKt__StringsKt.i0(str2, PGTransHeader.CONNECTOR);
            us.pinguo.foundation.statistics.h.b.L("edit_looks", i0);
            J();
            return;
        }
        ((FacePointView) this.b.findViewById(R.id.facePointView)).b();
        h0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x033c, code lost:
        if ((r0.length == 0) != false) goto L184;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(int r14, int r15, int r16, android.view.View r17, us.pinguo.repository2020.entity.SelfDefMakeupMaterial r18) {
        /*
            Method dump skipped, instructions count: 879
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.MakeupController.d0(int, int, int, android.view.View, us.pinguo.repository2020.entity.SelfDefMakeupMaterial):void");
    }

    @Override // us.pinguo.edit2020.controller.g3
    public void e(us.pinguo.edit2020.bean.u0 unityCanvasStatus) {
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        this.o = unityCanvasStatus;
        this.c.r(false);
        this.c.n(unityCanvasStatus);
        ((FacePointView) this.b.findViewById(R.id.facePointView)).j(unityCanvasStatus);
        unityCanvasStatus.h();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        LinearLayout linearLayout = (LinearLayout) this.f10396j.findViewById(R.id.llReset);
        kotlin.jvm.internal.s.g(linearLayout, "makeupView.llReset");
        return linearLayout.getVisibility() == 0;
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        if (!f()) {
            ArrayList<us.pinguo.edit2020.bean.x> P = this.a.P();
            boolean z = false;
            if (!(P instanceof Collection) || !P.isEmpty()) {
                Iterator<T> it = P.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((us.pinguo.edit2020.bean.x) it.next()).a()) {
                        z = true;
                        break;
                    }
                }
            }
            String str = z ? "use_vip_func_or_material" : "nonuse_vip_func_or_material";
            if (us.pinguo.repository2020.abtest.a.a.c()) {
                us.pinguo.foundation.statistics.h.b.K("edit_panel_makeup", str, "exited");
            } else {
                us.pinguo.foundation.statistics.h.b.m0("edit_panel_makeup", null, "exited");
            }
            J();
            return;
        }
        h0();
    }

    public final void n0(String str) {
        ((MagnifierView) ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).a(R.id.magnifierView)).setSize(this.r);
        ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).setIndicatorSize(this.r);
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.adjustLayout;
        PaintEraserAdjustLayout paintEraserAdjustLayout = (PaintEraserAdjustLayout) constraintLayout.findViewById(i2);
        kotlin.jvm.internal.s.g(paintEraserAdjustLayout, "fragmentLayout.adjustLayout");
        boolean z = false;
        paintEraserAdjustLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(paintEraserAdjustLayout, 0);
        ImageView imageView = (ImageView) ((PaintEraserAdjustLayout) this.b.findViewById(i2)).a(R.id.ivSwitchFace);
        kotlin.jvm.internal.s.g(imageView, "fragmentLayout.adjustLayout.ivSwitchFace");
        imageView.setVisibility(8);
        VdsAgent.onSetViewVisibility(imageView, 8);
        ConstraintLayout constraintLayout2 = this.b;
        int i3 = R.id.flContainerSubItems;
        ((FrameLayout) constraintLayout2.findViewById(i3)).removeAllViews();
        ((FrameLayout) this.b.findViewById(R.id.operationLayout)).setBackgroundColor(0);
        this.c.s(new MakeupController$show$1(this));
        this.c.r(false);
        this.c.u(-1);
        if (this.a.B() > 1) {
            this.c.v();
        }
        if (!((str == null || str.length() == 0) ? true : true)) {
            this.f10390d.invoke(new MakeupController$show$2(this, str));
        }
        ((FrameLayout) this.b.findViewById(i3)).addView(this.f10396j);
        u0();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        if (this.p.r()) {
            this.p.l();
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return this.a.P();
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        x0();
        m0(this.a.B() == 1);
        n0(str);
    }
}
