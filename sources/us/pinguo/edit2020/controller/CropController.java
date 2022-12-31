package us.pinguo.edit2020.controller;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.coremedia.iso.boxes.FreeBox;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.lib.AppContextProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.v1;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.CropController;
import us.pinguo.edit2020.controller.i3;
import us.pinguo.edit2020.view.ProgressWheelView;
import us.pinguo.edit2020.view.cropindicator.CropDragView;
import us.pinguo.edit2020.widget.CenterLayoutManager;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: CropController.kt */
/* loaded from: classes4.dex */
public final class CropController implements i3, e3 {
    private final CenterLayoutManager A;
    private final Observer<us.pinguo.edit2020.bean.u0> B;
    private kotlinx.coroutines.v1 C;
    private final Rational D;
    private final us.pinguo.edit2020.viewmodel.module.f a;
    private final View b;
    private final ViewGroup c;

    /* renamed from: d  reason: collision with root package name */
    private final PGEditBottomTabLayout f10301d;

    /* renamed from: e  reason: collision with root package name */
    private final CropDragView f10302e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewGroup f10303f;

    /* renamed from: g  reason: collision with root package name */
    private final View f10304g;

    /* renamed from: h  reason: collision with root package name */
    private final View f10305h;

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.jvm.b.l<Boolean, kotlin.u> f10306i;

    /* renamed from: j  reason: collision with root package name */
    private final LifecycleOwner f10307j;

    /* renamed from: k  reason: collision with root package name */
    private final RecyclerView f10308k;

    /* renamed from: l  reason: collision with root package name */
    private final us.pinguo.common.widget.g f10309l;
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.x> m;
    private final List<List<us.pinguo.edit2020.bean.m>> n;
    private final List<Integer> o;
    private final Integer[] p;
    private int q;
    private Rational r;
    private boolean s;
    private HashMap<String, String> t;
    private ScaleBarFunction u;
    private ScaleBarFunction v;
    private final kotlin.f w;
    private final kotlin.f x;
    private final Map<ScaleBarFunction, Float> y;
    private final String[] z;

    /* compiled from: CropController.kt */
    /* renamed from: us.pinguo.edit2020.controller.CropController$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass3 extends Lambda implements kotlin.jvm.b.q<Float, Boolean, Boolean, kotlin.u> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CropController.kt */
        @DebugMetadata(c = "us.pinguo.edit2020.controller.CropController$3$1", f = "CropController.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.edit2020.controller.CropController$3$1  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
            int label;
            final /* synthetic */ CropController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CropController cropController, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = cropController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    kotlin.j.b(obj);
                    this.label = 1;
                    if (DelayKt.b(2000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.j.b(obj);
                }
                if (this.this$0.f10305h.getVisibility() == 0) {
                    CropController cropController = this.this$0;
                    cropController.V(cropController.f10305h, 1.0f, 0.0f, 80L);
                }
                return kotlin.u.a;
            }
        }

        AnonymousClass3() {
            super(3);
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2, Boolean bool, Boolean bool2) {
            invoke(f2.floatValue(), bool.booleanValue(), bool2.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(float f2, boolean z, boolean z2) {
            kotlinx.coroutines.v1 d2;
            if ((f2 == 0.0f) && !z) {
                kotlinx.coroutines.v1 v1Var = CropController.this.C;
                if (v1Var != null) {
                    v1.a.a(v1Var, null, 1, null);
                }
                CropController cropController = CropController.this;
                d2 = kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(cropController.f10307j), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(CropController.this, null), 2, null);
                cropController.C = d2;
            }
            if (z2) {
                return;
            }
            CropController.this.f10302e.setShowDividerLine(z);
            CropController.this.f10302e.invalidate();
        }
    }

    /* compiled from: CropController.kt */
    /* renamed from: us.pinguo.edit2020.controller.CropController$7  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass7 extends Lambda implements kotlin.jvm.b.s<Float, Float, Float, Float, Boolean, kotlin.u> {
        AnonymousClass7() {
            super(5);
        }

        @Override // kotlin.jvm.b.s
        public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2, Float f3, Float f4, Float f5, Boolean bool) {
            invoke(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue(), bool.booleanValue());
            return kotlin.u.a;
        }

        public final void invoke(float f2, float f3, float f4, float f5, boolean z) {
            us.pinguo.common.log.a.c("rectUpdate", new Object[0]);
            CropController.this.a.D(f2, f3, f4, f5, z);
        }
    }

    /* compiled from: CropController.kt */
    /* renamed from: us.pinguo.edit2020.controller.CropController$9  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass9 extends Lambda implements kotlin.jvm.b.r<Float, Float, Float, Float, kotlin.u> {
        AnonymousClass9() {
            super(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invoke$lambda-0  reason: not valid java name */
        public static final void m85invoke$lambda0(CropController this$0, float f2, float f3, float f4, float f5) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            float f6 = 1;
            this$0.f10302e.v(f2, f6 - f3, f4, f6 - f5);
        }

        @Override // kotlin.jvm.b.r
        public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2, Float f3, Float f4, Float f5) {
            invoke(f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue());
            return kotlin.u.a;
        }

        public final void invoke(final float f2, final float f3, final float f4, final float f5) {
            CropDragView cropDragView = CropController.this.f10302e;
            final CropController cropController = CropController.this;
            cropDragView.post(new Runnable() { // from class: us.pinguo.edit2020.controller.i0
                @Override // java.lang.Runnable
                public final void run() {
                    CropController.AnonymousClass9.m85invoke$lambda0(CropController.this, f2, f3, f4, f5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CropController.kt */
    /* loaded from: classes4.dex */
    public enum ScaleBarFunction {
        SCALE_FUNCTION_ROTATE,
        SCALE_FUNCTION_H_PERSPECTIVE,
        SCALE_FUNCTION_V_PERSPECTIVE,
        SCALE_FUNCTION_H_STRETCH,
        SCALE_FUNCTION_V_STRETCH
    }

    /* compiled from: CropController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.edit2020.view.j0 {

        /* compiled from: CropController.kt */
        /* renamed from: us.pinguo.edit2020.controller.CropController$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public /* synthetic */ class C0384a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ScaleBarFunction.values().length];
                iArr[ScaleBarFunction.SCALE_FUNCTION_ROTATE.ordinal()] = 1;
                iArr[ScaleBarFunction.SCALE_FUNCTION_H_PERSPECTIVE.ordinal()] = 2;
                iArr[ScaleBarFunction.SCALE_FUNCTION_V_PERSPECTIVE.ordinal()] = 3;
                iArr[ScaleBarFunction.SCALE_FUNCTION_H_STRETCH.ordinal()] = 4;
                iArr[ScaleBarFunction.SCALE_FUNCTION_V_STRETCH.ordinal()] = 5;
                a = iArr;
            }
        }

        a() {
        }

        @Override // us.pinguo.edit2020.view.j0
        public void a(float f2, float f3, boolean z) {
            us.pinguo.common.log.a.c("onWheelChanged:oldValue=" + f2 + ", newValue=" + f3 + ", stopped=" + z, new Object[0]);
            if ((!(f3 == 0.0f) || !z) && CropController.this.f10305h.getVisibility() != 0) {
                CropController cropController = CropController.this;
                cropController.V(cropController.f10305h, 0.0f, 1.0f, 200L);
            }
            if (kotlin.jvm.internal.s.a((Float) CropController.this.y.get(CropController.this.u), f3)) {
                return;
            }
            CropController.this.X();
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("cropRecoverBtn.y=", Float.valueOf(CropController.this.f10304g.getY())), new Object[0]);
            CropController.this.y.put(CropController.this.u, Float.valueOf(f3));
            int i2 = C0384a.a[CropController.this.u.ordinal()];
            if (i2 == 1) {
                CropController.this.a.F(f3);
            } else if (i2 == 2) {
                CropController.this.a.H(f3 / 45);
            } else if (i2 == 3) {
                CropController.this.a.I(f3 / 45);
            } else if (i2 == 4) {
                CropController.this.a.L(f3 / 45);
            } else if (i2 == 5) {
                CropController.this.a.M(f3 / 45);
            }
            ((TextView) CropController.this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(CropController.this.l0(f3));
        }
    }

    /* compiled from: CropController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements CropDragView.b {
        final /* synthetic */ Context b;

        b(Context context) {
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(CropController this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            this$0.V(this$0.f10304g, 0.0f, 1.0f, 200L);
        }

        @Override // us.pinguo.edit2020.view.cropindicator.CropDragView.b
        public void a() {
            us.pinguo.common.log.a.c("onViewStartUpdate", new Object[0]);
            CropController.this.s = true;
            UnityEditCaller.Crop.INSTANCE.setGassViewOpacity(0.0f);
            View view = CropController.this.f10304g;
            view.setVisibility(4);
            VdsAgent.onSetViewVisibility(view, 4);
            CropController.this.a.E(true);
        }

        @Override // us.pinguo.edit2020.view.cropindicator.CropDragView.b
        public void b(float f2) {
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("onViewUpdateEnd, drawRectBottom=", Float.valueOf(f2)), new Object[0]);
            UnityEditCaller.Crop.INSTANCE.setGassViewOpacity(1.0f);
            CropController.this.f10304g.setTranslationY((f2 - CropController.this.f10302e.getHeight()) - this.b.getResources().getDimension(R.dimen.crop_recover_btn_bottom_margin));
            us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("cropRecoverBtn.y=", Float.valueOf(CropController.this.f10304g.getY())), new Object[0]);
            if (CropController.this.a.t()) {
                View view = CropController.this.f10304g;
                final CropController cropController = CropController.this;
                view.postDelayed(new Runnable() { // from class: us.pinguo.edit2020.controller.h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CropController.b.e(CropController.this);
                    }
                }, 100L);
            }
        }

        @Override // us.pinguo.edit2020.view.cropindicator.CropDragView.b
        public void c(float f2) {
            UnityEditCaller.Crop.INSTANCE.setGassViewOpacity(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CropController.kt */
    /* loaded from: classes4.dex */
    public static final class c {
        public static final c a = new c();
        private static final Rational b = new Rational(1, 1);
        private static final Rational c = new Rational(3, 4);

        /* renamed from: d  reason: collision with root package name */
        private static final Rational f10310d = new Rational(4, 3);

        /* renamed from: e  reason: collision with root package name */
        private static final Rational f10311e = new Rational(2, 3);

        /* renamed from: f  reason: collision with root package name */
        private static final Rational f10312f = new Rational(3, 2);

        /* renamed from: g  reason: collision with root package name */
        private static final Rational f10313g = new Rational(9, 16);

        /* renamed from: h  reason: collision with root package name */
        private static final Rational f10314h = new Rational(16, 9);

        private c() {
        }

        public final Rational a() {
            return f10314h;
        }

        public final Rational b() {
            return b;
        }

        public final Rational c() {
            return f10311e;
        }

        public final Rational d() {
            return f10312f;
        }

        public final Rational e() {
            return c;
        }

        public final Rational f() {
            return f10310d;
        }

        public final Rational g() {
            return f10313g;
        }
    }

    /* compiled from: Animator.kt */
    /* loaded from: classes4.dex */
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ float a;
        final /* synthetic */ View b;
        final /* synthetic */ float c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f10315d;

        public d(float f2, View view, float f3, View view2) {
            this.a = f2;
            this.b = view;
            this.c = f3;
            this.f10315d = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            if (this.a == 0.0f) {
                View view = this.b;
                view.setVisibility(4);
                VdsAgent.onSetViewVisibility(view, 4);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            if (this.c == 0.0f) {
                View view = this.f10315d;
                view.setVisibility(0);
                VdsAgent.onSetViewVisibility(view, 0);
            }
        }
    }

    /* compiled from: CropController.kt */
    /* loaded from: classes4.dex */
    public static final class e implements PGEditTabLayout.d {
        e() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f fVar) {
            CropController.this.q = fVar == null ? 0 : fVar.i();
            CropController.this.m.t((List) CropController.this.n.get(CropController.this.q), CropController.this.p[CropController.this.q], false);
            CenterLayoutManager centerLayoutManager = CropController.this.A;
            Context context = CropController.this.f10301d.getContext();
            kotlin.jvm.internal.s.g(context, "tabLayout.context");
            centerLayoutManager.b(context, CropController.this.p[CropController.this.q].intValue(), 1.0f);
            us.pinguo.common.widget.g gVar = CropController.this.f10309l;
            AppContextProvider appContextProvider = AppContextProvider.INSTANCE;
            gVar.a(appContextProvider.getContext(), CropController.this.m.getItemCount(), CropController.this.A.a(appContextProvider.getContext(), CropController.this.m.getItemCount()));
            int i2 = CropController.this.q;
            if (i2 == 0) {
                CropController.this.U();
                CropController.this.f10302e.setShowTouchIndicator(true);
                CropController.this.f10302e.invalidate();
                CropController.this.u = ScaleBarFunction.SCALE_FUNCTION_ROTATE;
            } else if (i2 == 1) {
                CropController.this.g0();
                CropController.this.f10302e.setShowTouchIndicator(false);
                CropController.this.f10302e.invalidate();
                CropController cropController = CropController.this;
                cropController.u = cropController.v;
            }
            Float f2 = (Float) CropController.this.y.get(CropController.this.u);
            float floatValue = f2 == null ? 0.0f : f2.floatValue();
            ViewGroup viewGroup = CropController.this.f10303f;
            int i3 = R.id.scaleSeekBar;
            ProgressWheelView progressWheelView = (ProgressWheelView) viewGroup.findViewById(i3);
            kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
            ProgressWheelView.setValue$edit2020_release$default(progressWheelView, floatValue, false, false, 4, null);
            CropController cropController2 = CropController.this;
            ((TextView) CropController.this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(cropController2.l0(((ProgressWheelView) cropController2.f10303f.findViewById(i3)).d()));
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void i(PGEditTabLayout.f fVar) {
            us.pinguo.common.widget.tab.l.a(this, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CropController(us.pinguo.edit2020.viewmodel.module.f editModule, View showOriginBtn, ViewGroup secondMenuContainer, PGEditBottomTabLayout tabLayout, CropDragView cropDragView, ViewGroup seekBarContainer, View cropRecoverBtn, View cropScaleBubble, kotlin.jvm.b.l<? super Boolean, kotlin.u> resetMastAction, LifecycleOwner lifecycleOwner) {
        kotlin.f b2;
        kotlin.f b3;
        Map<ScaleBarFunction, Float> i2;
        int o;
        kotlin.jvm.internal.s.h(editModule, "editModule");
        kotlin.jvm.internal.s.h(showOriginBtn, "showOriginBtn");
        kotlin.jvm.internal.s.h(secondMenuContainer, "secondMenuContainer");
        kotlin.jvm.internal.s.h(tabLayout, "tabLayout");
        kotlin.jvm.internal.s.h(cropDragView, "cropDragView");
        kotlin.jvm.internal.s.h(seekBarContainer, "seekBarContainer");
        kotlin.jvm.internal.s.h(cropRecoverBtn, "cropRecoverBtn");
        kotlin.jvm.internal.s.h(cropScaleBubble, "cropScaleBubble");
        kotlin.jvm.internal.s.h(resetMastAction, "resetMastAction");
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        this.a = editModule;
        this.b = showOriginBtn;
        this.c = secondMenuContainer;
        this.f10301d = tabLayout;
        this.f10302e = cropDragView;
        this.f10303f = seekBarContainer;
        this.f10304g = cropRecoverBtn;
        this.f10305h = cropScaleBubble;
        this.f10306i = resetMastAction;
        this.f10307j = lifecycleOwner;
        this.f10309l = new us.pinguo.common.widget.g();
        this.m = new us.pinguo.edit2020.adapter.a0<>();
        this.n = editModule.g();
        ArrayList<Integer> h2 = editModule.h();
        this.o = h2;
        this.p = new Integer[]{0, 0};
        this.r = new Rational(3, 4);
        this.t = new HashMap<>();
        ScaleBarFunction scaleBarFunction = ScaleBarFunction.SCALE_FUNCTION_ROTATE;
        this.u = scaleBarFunction;
        ScaleBarFunction scaleBarFunction2 = ScaleBarFunction.SCALE_FUNCTION_H_PERSPECTIVE;
        this.v = scaleBarFunction2;
        b2 = kotlin.h.b(new CropController$ivHorizontalRotation$2(this));
        this.w = b2;
        b3 = kotlin.h.b(new CropController$ivAngleRotation$2(this));
        this.x = b3;
        Float valueOf = Float.valueOf(0.0f);
        i2 = kotlin.collections.m0.i(kotlin.k.a(scaleBarFunction, valueOf), kotlin.k.a(scaleBarFunction2, valueOf), kotlin.k.a(ScaleBarFunction.SCALE_FUNCTION_V_PERSPECTIVE, valueOf), kotlin.k.a(ScaleBarFunction.SCALE_FUNCTION_H_STRETCH, valueOf), kotlin.k.a(ScaleBarFunction.SCALE_FUNCTION_V_STRETCH, valueOf));
        this.y = i2;
        this.B = new Observer() { // from class: us.pinguo.edit2020.controller.j0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CropController.j0(CropController.this, (us.pinguo.edit2020.bean.u0) obj);
            }
        };
        Context context = secondMenuContainer.getContext();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.D = new Rational(point.x, point.y);
        kotlin.jvm.internal.s.g(context, "context");
        this.A = new CenterLayoutManager(context, 0, false);
        o = kotlin.collections.v.o(h2, 10);
        ArrayList arrayList = new ArrayList(o);
        for (Number number : h2) {
            arrayList.add(context.getString(number.intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        kotlin.jvm.internal.s.f(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.z = (String[]) array;
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(this.A);
        recyclerView.setAdapter(this.m);
        this.m.A(new CropController$2$1(this, context));
        this.f10308k = recyclerView;
        recyclerView.addItemDecoration(this.f10309l);
        ViewGroup viewGroup = this.f10303f;
        int i3 = R.id.scaleSeekBar;
        ((ProgressWheelView) viewGroup.findViewById(i3)).setTouchMovingStatus(new AnonymousClass3());
        ((ProgressWheelView) this.f10303f.findViewById(i3)).setOnWheelChangedListener$edit2020_release(new a());
        ((ImageView) this.f10305h.findViewById(R.id.cropRotateResetBtn)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CropController.a(CropController.this, view);
            }
        });
        this.f10304g.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CropController.c(CropController.this, view);
            }
        });
        this.f10302e.setRectUpdateListener(new AnonymousClass7());
        this.f10302e.setViewUpdateListener(new b(context));
        this.a.G(new AnonymousClass9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        ProgressWheelView progressWheelView = (ProgressWheelView) this.f10303f.findViewById(R.id.scaleSeekBar);
        kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
        ViewGroup.LayoutParams layoutParams = progressWheelView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        int a2 = us.pinguo.util.g.a(b2, 32.5f);
        layoutParams2.leftMargin = a2;
        layoutParams2.rightMargin = a2;
        Context b3 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b3, "getAppContext()");
        int a3 = us.pinguo.util.g.a(b3, 29.0f);
        Context b4 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b4, "getAppContext()");
        int a4 = us.pinguo.util.g.a(b4, 6.5f);
        if (us.pinguo.edit2020.utils.d.e(b0().getParent())) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(a3, a3);
            layoutParams3.gravity = 16;
            layoutParams3.leftMargin = a4;
            b0();
            ((FrameLayout) this.f10303f.findViewById(R.id.flScaleSeekBar)).addView(b0(), layoutParams3);
        }
        if (us.pinguo.edit2020.utils.d.e(a0().getParent())) {
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(a3, a3);
            layoutParams4.gravity = 8388629;
            layoutParams4.rightMargin = a4;
            ((FrameLayout) this.f10303f.findViewById(R.id.flScaleSeekBar)).addView(a0(), layoutParams4);
        }
        progressWheelView.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(View view, float f2, float f3, long j2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", f2, f3);
        ofFloat.setDuration(j2);
        kotlin.jvm.internal.s.g(ofFloat, "");
        ofFloat.addListener(new d(f3, view, f2, view));
        ofFloat.start();
    }

    static /* synthetic */ void W(CropController cropController, View view, float f2, float f3, long j2, int i2, Object obj) {
        float f4 = (i2 & 2) != 0 ? 0.0f : f2;
        float f5 = (i2 & 4) != 0 ? 1.0f : f3;
        if ((i2 & 8) != 0) {
            j2 = 700;
        }
        cropController.V(view, f4, f5, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
        this.a.E(true);
        this.f10304g.setTranslationY((this.f10302e.n() - this.f10302e.getHeight()) - AppContextProvider.INSTANCE.getContext().getResources().getDimension(R.dimen.crop_recover_btn_bottom_margin));
        View view = this.f10304g;
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CropController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ViewGroup viewGroup = this$0.f10303f;
        int i2 = R.id.scaleSeekBar;
        ProgressWheelView progressWheelView = (ProgressWheelView) viewGroup.findViewById(i2);
        kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
        ProgressWheelView.setValue$edit2020_release$default(progressWheelView, 0.0f, false, false, 4, null);
        ((ProgressWheelView) this$0.f10303f.findViewById(i2)).f();
        ((TextView) this$0.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(this$0.l0(((ProgressWheelView) this$0.f10303f.findViewById(i2)).d()));
    }

    private final ImageView a0() {
        return (ImageView) this.x.getValue();
    }

    private final ImageView b0() {
        return (ImageView) this.w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CropController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String str) {
        switch (str.hashCode()) {
            case -1879437132:
                if (str.equals("hPerspective")) {
                    ScaleBarFunction scaleBarFunction = ScaleBarFunction.SCALE_FUNCTION_H_PERSPECTIVE;
                    this.v = scaleBarFunction;
                    this.u = scaleBarFunction;
                    ViewGroup viewGroup = this.f10303f;
                    int i2 = R.id.scaleSeekBar;
                    ProgressWheelView progressWheelView = (ProgressWheelView) viewGroup.findViewById(i2);
                    kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
                    Float f2 = this.y.get(this.u);
                    ProgressWheelView.setValue$edit2020_release$default(progressWheelView, f2 == null ? 0.0f : f2.floatValue(), false, false, 4, null);
                    ((TextView) this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(l0(((ProgressWheelView) this.f10303f.findViewById(i2)).d()));
                    return;
                }
                return;
            case -724030033:
                if (str.equals("vStretch")) {
                    ScaleBarFunction scaleBarFunction2 = ScaleBarFunction.SCALE_FUNCTION_V_STRETCH;
                    this.v = scaleBarFunction2;
                    this.u = scaleBarFunction2;
                    ViewGroup viewGroup2 = this.f10303f;
                    int i3 = R.id.scaleSeekBar;
                    ProgressWheelView progressWheelView2 = (ProgressWheelView) viewGroup2.findViewById(i3);
                    kotlin.jvm.internal.s.g(progressWheelView2, "seekBarContainer.scaleSeekBar");
                    Float f3 = this.y.get(this.u);
                    ProgressWheelView.setValue$edit2020_release$default(progressWheelView2, f3 == null ? 0.0f : f3.floatValue(), false, false, 4, null);
                    ((TextView) this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(l0(((ProgressWheelView) this.f10303f.findViewById(i3)).d()));
                    return;
                }
                return;
            case -72279066:
                if (str.equals("vPerspective")) {
                    ScaleBarFunction scaleBarFunction3 = ScaleBarFunction.SCALE_FUNCTION_V_PERSPECTIVE;
                    this.v = scaleBarFunction3;
                    this.u = scaleBarFunction3;
                    ViewGroup viewGroup3 = this.f10303f;
                    int i4 = R.id.scaleSeekBar;
                    ProgressWheelView progressWheelView3 = (ProgressWheelView) viewGroup3.findViewById(i4);
                    kotlin.jvm.internal.s.g(progressWheelView3, "seekBarContainer.scaleSeekBar");
                    Float f4 = this.y.get(this.u);
                    ProgressWheelView.setValue$edit2020_release$default(progressWheelView3, f4 == null ? 0.0f : f4.floatValue(), false, false, 4, null);
                    ((TextView) this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(l0(((ProgressWheelView) this.f10303f.findViewById(i4)).d()));
                    return;
                }
                return;
            case 646429053:
                if (str.equals("hStretch")) {
                    ScaleBarFunction scaleBarFunction4 = ScaleBarFunction.SCALE_FUNCTION_H_STRETCH;
                    this.v = scaleBarFunction4;
                    this.u = scaleBarFunction4;
                    ViewGroup viewGroup4 = this.f10303f;
                    int i5 = R.id.scaleSeekBar;
                    ProgressWheelView progressWheelView4 = (ProgressWheelView) viewGroup4.findViewById(i5);
                    kotlin.jvm.internal.s.g(progressWheelView4, "seekBarContainer.scaleSeekBar");
                    Float f5 = this.y.get(this.u);
                    ProgressWheelView.setValue$edit2020_release$default(progressWheelView4, f5 == null ? 0.0f : f5.floatValue(), false, false, 4, null);
                    ((TextView) this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(l0(((ProgressWheelView) this.f10303f.findViewById(i5)).d()));
                    return;
                }
                return;
            case 671914246:
                if (str.equals("cropDevice")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, this.D, false, 2, null);
                    this.t.put("crop", "deviceRate");
                    return;
                }
                return;
            case 1038172016:
                if (str.equals("crop1b1")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.b(), false, 2, null);
                    this.t.put("crop", "1:1");
                    return;
                }
                return;
            case 1038172979:
                if (str.equals("crop2b3")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.c(), false, 2, null);
                    this.t.put("crop", "2:3");
                    return;
                }
                return;
            case 1038173939:
                if (str.equals("crop3b2")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.d(), false, 2, null);
                    this.t.put("crop", "3:2");
                    return;
                }
                return;
            case 1038173941:
                if (str.equals("crop3b4")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.e(), false, 2, null);
                    this.t.put("crop", "3:4");
                    return;
                }
                return;
            case 1038174901:
                if (str.equals("crop4b3")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.f(), false, 2, null);
                    this.t.put("crop", "4:3");
                    return;
                }
                return;
            case 1734350977:
                if (str.equals("cropOriginal")) {
                    CropDragView.setFixedRate$default(this.f10302e, this.r, false, 2, null);
                    this.t.put("crop", "original");
                    return;
                }
                return;
            case 2118520716:
                if (str.equals("crop16b9")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.a(), false, 2, null);
                    this.t.put("crop", "16:9");
                    return;
                }
                return;
            case 2118799806:
                if (str.equals("crop9b16")) {
                    this.a.E(true);
                    CropDragView.setFixedRate$default(this.f10302e, c.a.g(), false, 2, null);
                    this.t.put("crop", "9:16");
                    return;
                }
                return;
            case 2119204124:
                if (str.equals("cropFree")) {
                    this.f10302e.setToFreeRate();
                    this.t.put("crop", FreeBox.TYPE);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        ProgressWheelView progressWheelView = (ProgressWheelView) this.f10303f.findViewById(R.id.scaleSeekBar);
        kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
        ViewGroup.LayoutParams layoutParams = progressWheelView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        ViewGroup viewGroup = this.f10303f;
        int i2 = R.id.flScaleSeekBar;
        ((FrameLayout) viewGroup.findViewById(i2)).removeView(a0());
        ((FrameLayout) this.f10303f.findViewById(i2)).removeView(b0());
        layoutParams2.leftMargin = 0;
        layoutParams2.rightMargin = 0;
        progressWheelView.setLayoutParams(layoutParams2);
    }

    private final void h0() {
        this.a.E(false);
        i0();
        View view = this.f10304g;
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
        if (this.q == 0) {
            this.m.z(0);
            this.m.o();
        }
        ProgressWheelView progressWheelView = (ProgressWheelView) this.f10303f.findViewById(R.id.scaleSeekBar);
        kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
        ProgressWheelView.setValue$edit2020_release$default(progressWheelView, 0.0f, false, false, 4, null);
        View view2 = this.f10305h;
        view2.setVisibility(4);
        VdsAgent.onSetViewVisibility(view2, 4);
        this.f10302e.setFixedRate(this.r, false);
        this.f10302e.setToFreeRate();
        this.a.z(this.f10302e.m());
    }

    private final void i0() {
        Map<ScaleBarFunction, Float> map = this.y;
        ScaleBarFunction scaleBarFunction = ScaleBarFunction.SCALE_FUNCTION_ROTATE;
        Float valueOf = Float.valueOf(0.0f);
        map.put(scaleBarFunction, valueOf);
        this.y.put(ScaleBarFunction.SCALE_FUNCTION_H_PERSPECTIVE, valueOf);
        this.y.put(ScaleBarFunction.SCALE_FUNCTION_V_PERSPECTIVE, valueOf);
        this.y.put(ScaleBarFunction.SCALE_FUNCTION_H_STRETCH, valueOf);
        this.y.put(ScaleBarFunction.SCALE_FUNCTION_V_STRETCH, valueOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(CropController this$0, us.pinguo.edit2020.bean.u0 u0Var) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.common.log.a.c(kotlin.jvm.internal.s.q("scaleObserver:", Float.valueOf(u0Var.c())), new Object[0]);
        if (u0Var.c() > 1.0f) {
            this$0.X();
        }
    }

    private final void k0() {
        String str = this.t.get("crop");
        if (str != null) {
            us.pinguo.foundation.statistics.h.b.b0(str);
        }
        String str2 = this.t.get("rotateHoriz");
        if ((str2 == null ? 0 : Integer.parseInt(str2)) != 0) {
            us.pinguo.foundation.statistics.h.b.E0("rotate");
        }
        String str3 = this.t.get("vertic");
        if ((str3 != null ? Integer.parseInt(str3) : 0) != 0) {
            us.pinguo.foundation.statistics.h.b.E0("flip");
        }
        if (!kotlin.jvm.internal.s.a(this.y.get(ScaleBarFunction.SCALE_FUNCTION_H_PERSPECTIVE), 0.0f)) {
            us.pinguo.foundation.statistics.h.b.c("horizontal_perspective");
        }
        if (!kotlin.jvm.internal.s.a(this.y.get(ScaleBarFunction.SCALE_FUNCTION_V_PERSPECTIVE), 0.0f)) {
            us.pinguo.foundation.statistics.h.b.c("vertical_perspective");
        }
        if (!kotlin.jvm.internal.s.a(this.y.get(ScaleBarFunction.SCALE_FUNCTION_H_STRETCH), 0.0f)) {
            us.pinguo.foundation.statistics.h.b.c("lateral_stretching");
        }
        if (kotlin.jvm.internal.s.a(this.y.get(ScaleBarFunction.SCALE_FUNCTION_V_STRETCH), 0.0f)) {
            return;
        }
        us.pinguo.foundation.statistics.h.b.c("vertical_stretching");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l0(float f2) {
        kotlin.jvm.internal.x xVar = kotlin.jvm.internal.x.a;
        String format = String.format("%.1f°", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
        kotlin.jvm.internal.s.g(format, "format(format, *args)");
        return format;
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

    public void Y() {
        this.f10306i.invoke(Boolean.valueOf(!this.s));
        this.s = false;
        this.f10302e.setShowTouchIndicator(true);
        this.a.f().removeObserver(this.B);
        this.a.c(false);
        i0();
        View view = this.f10304g;
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
        View view2 = this.b;
        view2.setVisibility(0);
        VdsAgent.onSetViewVisibility(view2, 0);
        ViewGroup viewGroup = this.f10303f;
        viewGroup.setVisibility(4);
        VdsAgent.onSetViewVisibility(viewGroup, 4);
        CropDragView cropDragView = this.f10302e;
        cropDragView.setVisibility(4);
        VdsAgent.onSetViewVisibility(cropDragView, 4);
        Integer[] numArr = this.p;
        int length = numArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            numArr[i2].intValue();
            this.p[i3] = 0;
            i2++;
            i3++;
        }
        FrameLayout frameLayout = (FrameLayout) this.f10303f.findViewById(R.id.flScaleSeekBar);
        frameLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(frameLayout, 4);
        View view3 = this.f10305h;
        view3.setVisibility(4);
        VdsAgent.onSetViewVisibility(view3, 4);
        this.f10301d.j();
        this.c.removeAllViews();
        Set<String> keySet = this.t.keySet();
        kotlin.jvm.internal.s.g(keySet, "usedFunctionRecord.keys");
        for (String it : keySet) {
            HashMap<String, String> hashMap = this.t;
            kotlin.jvm.internal.s.g(it, "it");
            hashMap.put(it, null);
        }
    }

    public final RectF Z() {
        return this.f10302e.m();
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        int action = event.getAction();
        if (action == 0) {
            UnityEditCaller.Crop.INSTANCE.setGassViewOpacity(0.0f);
            this.f10302e.setShowDividerLine(true);
            this.f10302e.setIsDrawOutRect(true);
        } else if (action == 1) {
            UnityEditCaller.Crop.INSTANCE.setGassViewOpacity(1.0f);
            this.f10302e.setShowDividerLine(false);
            this.f10302e.setIsDrawOutRect(false);
        }
        return true;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void d() {
        k0();
        Y();
    }

    @Override // us.pinguo.edit2020.controller.i3, us.pinguo.edit2020.controller.z2
    public boolean f() {
        return false;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public void g() {
        Y();
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return i3.a.d(this);
    }

    @Override // us.pinguo.edit2020.controller.i3
    public void u(us.pinguo.edit2020.model.editgoto.b bVar) {
        this.a.E(false);
        this.a.f().observeForever(this.B);
        this.a.c(true);
        this.q = 0;
        this.m.t(this.n.get(0), this.p[this.q], false);
        us.pinguo.common.widget.g gVar = this.f10309l;
        AppContextProvider appContextProvider = AppContextProvider.INSTANCE;
        gVar.a(appContextProvider.getContext(), this.m.getItemCount(), this.A.a(appContextProvider.getContext(), this.m.getItemCount()));
        View view = this.b;
        view.setVisibility(4);
        VdsAgent.onSetViewVisibility(view, 4);
        ViewGroup viewGroup = this.f10303f;
        int i2 = R.id.scaleSeekBar;
        ((TextView) this.f10305h.findViewById(R.id.cropScaleIndicatorText)).setText(l0(((ProgressWheelView) viewGroup.findViewById(i2)).d()));
        Size s = this.a.s();
        Rational rational = s == null ? null : new Rational(s.getWidth(), s.getHeight());
        if (rational == null) {
            rational = this.r;
        }
        this.r = rational;
        CropDragView cropDragView = this.f10302e;
        cropDragView.setVisibility(0);
        VdsAgent.onSetViewVisibility(cropDragView, 0);
        CropDragView.setFixedRate$default(this.f10302e, this.r, false, 2, null);
        this.f10302e.setToFreeRate();
        W(this, this.f10302e, 0.0f, 0.0f, 0L, 14, null);
        this.a.b(new CropController$enter$2(this));
        ViewGroup viewGroup2 = this.f10303f;
        viewGroup2.setVisibility(0);
        VdsAgent.onSetViewVisibility(viewGroup2, 0);
        ProgressWheelView progressWheelView = (ProgressWheelView) this.f10303f.findViewById(i2);
        kotlin.jvm.internal.s.g(progressWheelView, "seekBarContainer.scaleSeekBar");
        ProgressWheelView.setValue$edit2020_release$default(progressWheelView, 0.0f, false, false, 4, null);
        U();
        FrameLayout frameLayout = (FrameLayout) this.f10303f.findViewById(R.id.flScaleSeekBar);
        frameLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(frameLayout, 0);
        PGEditBottomTabLayout.h(this.f10301d, this.z, true, null, 4, null);
        this.f10301d.d(new e());
        this.f10301d.B();
        this.c.removeAllViews();
        this.c.addView(this.f10308k);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        ArrayList arrayList = new ArrayList();
        if (this.a.t()) {
            arrayList.add(new us.pinguo.edit2020.bean.m("crop", 0, 0));
        }
        return arrayList;
    }
}
