package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.widget.EditFunctionLayoutManager;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.b.c;
import us.pinguo.edit2020.view.BodyShapingGestureView;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.view.TopSnackBar;
import us.pinguo.edit2020.view.p0;
import us.pinguo.edit2020.viewmodel.module.BoldType;
import us.pinguo.edit2020.viewmodel.module.EditBodyShapeModule;
import us.pinguo.edit2020.widget.AreaProtectionBoldAdjustView;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.ui.widget.StickySeekBar;
import us.pinguo.ui.widget.h;
/* compiled from: EditBodyShapingController.kt */
/* loaded from: classes4.dex */
public final class EditBodyShapingController extends GestureDetector.SimpleOnGestureListener implements e3, us.pinguo.edit2020.view.p0, us.pinguo.edit2020.b.c {
    private final LifecycleOwner a;
    private final EditBodyShapeModule b;
    private final ConstraintLayout c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f10316d;

    /* renamed from: e  reason: collision with root package name */
    private final TopSnackBar f10317e;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerView f10318f;

    /* renamed from: g  reason: collision with root package name */
    private final ShapeDirectionView f10319g;

    /* renamed from: h  reason: collision with root package name */
    private final BodyShapingGestureView f10320h;

    /* renamed from: i  reason: collision with root package name */
    private final MagnifierLayout f10321i;

    /* renamed from: j  reason: collision with root package name */
    private final us.pinguo.edit2020.manager.b f10322j;

    /* renamed from: k  reason: collision with root package name */
    private final float f10323k;

    /* renamed from: l  reason: collision with root package name */
    private final ValueAnimator f10324l;
    private final us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.k> m;
    private final GestureDetector n;
    private final int o;
    private final Handler p;
    private kotlin.jvm.b.p<? super Integer, ? super us.pinguo.edit2020.bean.k, kotlin.u> q;
    private List<String> r;
    private final b s;

    /* compiled from: EditBodyShapingController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBodyShapingController$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.k, kotlin.u> {
        AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.u invoke(Integer num, us.pinguo.edit2020.bean.k kVar) {
            invoke(num.intValue(), kVar);
            return kotlin.u.a;
        }

        public final void invoke(int i2, us.pinguo.edit2020.bean.k f2) {
            kotlin.jvm.internal.s.h(f2, "f");
            EditBodyShapingController.this.b.d().setValue(f2);
            kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.k, kotlin.u> r = EditBodyShapingController.this.r();
            if (r == null) {
                return;
            }
            r.invoke(Integer.valueOf(i2), f2);
        }
    }

    /* compiled from: EditBodyShapingController.kt */
    /* renamed from: us.pinguo.edit2020.controller.EditBodyShapingController$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass4 extends Lambda implements kotlin.jvm.b.l<us.pinguo.edit2020.viewmodel.module.c, kotlin.u> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(us.pinguo.edit2020.viewmodel.module.c cVar) {
            invoke2(cVar);
            return kotlin.u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(us.pinguo.edit2020.viewmodel.module.c it) {
            kotlin.jvm.internal.s.h(it, "it");
            us.pinguo.edit2020.bean.k value = EditBodyShapingController.this.b.d().getValue();
            if (value != null && kotlin.jvm.internal.s.c(value.f(), this.$context.getString(R.string.key_push))) {
                EditBodyShapingController.this.b.c().setValue(it);
                if (it.e()) {
                    ((MagnifierView) EditBodyShapingController.this.f10321i.a(R.id.magnifierView)).setSize(it.a().getIndicatorSize());
                    EditBodyShapingController.this.f10319g.setIndicatorSize(it.a().getIndicatorSize());
                    value.r(it.a());
                }
            }
        }
    }

    /* compiled from: EditBodyShapingController.kt */
    /* loaded from: classes4.dex */
    public static final class a implements us.pinguo.ui.widget.h {
        final /* synthetic */ float b;

        a(float f2) {
            this.b = f2;
        }

        @Override // us.pinguo.ui.widget.h
        public void b(int i2) {
            us.pinguo.edit2020.bean.k value = EditBodyShapingController.this.b.d().getValue();
            us.pinguo.edit2020.bean.b bVar = value instanceof us.pinguo.edit2020.bean.b ? (us.pinguo.edit2020.bean.b) value : null;
            if (bVar == null) {
                return;
            }
            ((MagnifierView) EditBodyShapingController.this.f10321i.a(R.id.magnifierView)).setSize(bVar.g().getIndicatorSize());
            EditBodyShapingController.this.f10319g.setIndicatorSize(bVar.g().getIndicatorSize());
            if (bVar.C() == 0) {
                UnityEditCaller.Brush.setBrushSize(BasicBrushMode.Brush, bVar.g().getBrushSize());
            } else {
                UnityEditCaller.Brush.setBrushSize(BasicBrushMode.Erasing, bVar.g().getBrushSize());
            }
            us.pinguo.edit2020.viewmodel.module.c B = bVar.B();
            B.i(true);
            EditBodyShapingController.this.b.c().setValue(B);
        }

        @Override // us.pinguo.ui.widget.h
        public void c(int i2) {
            us.pinguo.edit2020.bean.k value = EditBodyShapingController.this.b.d().getValue();
            us.pinguo.edit2020.bean.b bVar = value instanceof us.pinguo.edit2020.bean.b ? (us.pinguo.edit2020.bean.b) value : null;
            if (bVar == null) {
                return;
            }
            BoldType g2 = bVar.g();
            BoldType boldType = BoldType.SMALL;
            float indicatorSize = boldType.getIndicatorSize();
            BoldType boldType2 = BoldType.BOLD3;
            g2.setIndicatorSize(indicatorSize + ((i2 / 100.0f) * (boldType2.getIndicatorSize() - boldType.getIndicatorSize())));
            g2.setScaleFactor(g2.getIndicatorSize() / boldType2.getIndicatorSize());
            g2.setBrushSize(g2.getIndicatorSize() / this.b);
            us.pinguo.edit2020.viewmodel.module.c B = bVar.B();
            B.i(false);
            B.g(g2.getScaleFactor());
            EditBodyShapingController.this.b.c().setValue(B);
        }

        @Override // us.pinguo.ui.widget.h
        public void k(float f2) {
            h.a.a(this, f2);
        }
    }

    /* compiled from: EditBodyShapingController.kt */
    /* loaded from: classes4.dex */
    public static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            us.pinguo.edit2020.bean.k value = EditBodyShapingController.this.b.d().getValue();
            if (value != null && value.j()) {
                if (!(value instanceof us.pinguo.edit2020.bean.p)) {
                    if (kotlin.jvm.internal.s.c(value.f(), EditBodyShapingController.this.f10319g.getResources().getString(R.string.key_reduction))) {
                        kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n = value.n();
                        if (n != null) {
                            n.invoke(null, null, Float.valueOf(0.0f), Boolean.FALSE, Float.valueOf(0.1f));
                        }
                        EditBodyShapingController.this.b.k();
                        EditBodyShapingController.this.p.postDelayed(this, 100L);
                        return;
                    }
                    return;
                }
                PointF o = value.o();
                kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n2 = value.n();
                if (n2 != null) {
                    n2.invoke(o, null, Float.valueOf(value.g().getBrushSize()), Boolean.FALSE, Float.valueOf(1.0f));
                }
                EditBodyShapingController.this.b.k();
                EditBodyShapingController.this.p.postDelayed(this, 100L);
            }
        }
    }

    public EditBodyShapingController(LifecycleOwner lifecycleOwner, EditBodyShapeModule module, ConstraintLayout bodyShapeControlView, TextView txtEditHint, TopSnackBar topSnack, RecyclerView bodyShapeLayout, ShapeDirectionView handShapeView, BodyShapingGestureView narrowExpandView, MagnifierLayout flMagnifier, us.pinguo.edit2020.manager.b operationManager) {
        float floatValue;
        kotlin.jvm.internal.s.h(lifecycleOwner, "lifecycleOwner");
        kotlin.jvm.internal.s.h(module, "module");
        kotlin.jvm.internal.s.h(bodyShapeControlView, "bodyShapeControlView");
        kotlin.jvm.internal.s.h(txtEditHint, "txtEditHint");
        kotlin.jvm.internal.s.h(topSnack, "topSnack");
        kotlin.jvm.internal.s.h(bodyShapeLayout, "bodyShapeLayout");
        kotlin.jvm.internal.s.h(handShapeView, "handShapeView");
        kotlin.jvm.internal.s.h(narrowExpandView, "narrowExpandView");
        kotlin.jvm.internal.s.h(flMagnifier, "flMagnifier");
        kotlin.jvm.internal.s.h(operationManager, "operationManager");
        this.a = lifecycleOwner;
        this.b = module;
        this.c = bodyShapeControlView;
        this.f10316d = txtEditHint;
        this.f10317e = topSnack;
        this.f10318f = bodyShapeLayout;
        this.f10319g = handShapeView;
        this.f10320h = narrowExpandView;
        this.f10321i = flMagnifier;
        this.f10322j = operationManager;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f10324l = valueAnimator;
        us.pinguo.edit2020.adapter.a0<us.pinguo.edit2020.bean.k> a0Var = new us.pinguo.edit2020.adapter.a0<>();
        this.m = a0Var;
        this.n = new GestureDetector(us.pinguo.foundation.e.b(), this);
        this.o = ViewConfiguration.get(us.pinguo.foundation.e.b()).getScaledTouchSlop();
        this.p = new Handler();
        Context context = us.pinguo.foundation.e.b();
        us.pinguo.edit2020.bean.u0 f2 = module.f();
        Float valueOf = f2 == null ? null : Float.valueOf(f2.h());
        if (valueOf == null) {
            kotlin.jvm.internal.s.g(context, "context");
            floatValue = us.pinguo.util.h.i(context);
        } else {
            floatValue = valueOf.floatValue();
        }
        float f3 = floatValue;
        BoldType boldType = BoldType.SMALL;
        boldType.setBrushSize(boldType.getIndicatorSize() / f3);
        BoldType boldType2 = BoldType.NORMAL;
        boldType2.setBrushSize(boldType2.getIndicatorSize() / f3);
        BoldType boldType3 = BoldType.BOLD;
        boldType3.setBrushSize(boldType3.getIndicatorSize() / f3);
        BoldType boldType4 = BoldType.BOLD2;
        boldType4.setBrushSize(boldType4.getIndicatorSize() / f3);
        BoldType boldType5 = BoldType.BOLD3;
        boldType5.setBrushSize(boldType5.getIndicatorSize() / f3);
        BoldType boldType6 = BoldType.BOLD_SWELL;
        boldType6.setBrushSize(0.25f);
        boldType6.setScaleFactor(0.25f);
        float f4 = f3 * 0.25f;
        boldType6.setIndicatorSize(f4);
        BoldType boldType7 = BoldType.BOLD_NARROW;
        boldType7.setBrushSize(0.25f);
        boldType7.setScaleFactor(0.25f);
        boldType7.setIndicatorSize(f4);
        BoldType boldType8 = BoldType.BOLD_PUSH_SMALL;
        boldType8.setBrushSize(boldType8.getIndicatorSize() / f3);
        BoldType boldType9 = BoldType.BOLD_PUSH_NORMAL;
        boldType9.setBrushSize(boldType9.getIndicatorSize() / f3);
        BoldType boldType10 = BoldType.BOLD_PUSH_BOLD;
        boldType10.setBrushSize(boldType10.getIndicatorSize() / f3);
        BoldType boldType11 = BoldType.BOLD_PUSH_BOLD2;
        boldType11.setBrushSize(boldType11.getIndicatorSize() / f3);
        BoldType boldType12 = BoldType.BOLD_PUSH_BOLD3;
        boldType12.setBrushSize(boldType12.getIndicatorSize() / f3);
        a0Var.A(new AnonymousClass1());
        EditFunctionLayoutManager editFunctionLayoutManager = new EditFunctionLayoutManager(bodyShapeLayout.getContext(), 0, false);
        us.pinguo.common.widget.g gVar = new us.pinguo.common.widget.g();
        Context context2 = bodyShapeLayout.getContext();
        kotlin.jvm.internal.s.g(context2, "bodyShapeLayout.context");
        int size = module.e().size();
        Context context3 = bodyShapeLayout.getContext();
        kotlin.jvm.internal.s.g(context3, "bodyShapeLayout.context");
        gVar.a(context2, size, editFunctionLayoutManager.a(context3, module.e().size()));
        RecyclerView.ItemAnimator itemAnimator = bodyShapeLayout.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        bodyShapeLayout.addItemDecoration(gVar);
        bodyShapeLayout.setLayoutManager(editFunctionLayoutManager);
        us.pinguo.edit2020.adapter.a0.u(a0Var, module.e(), null, false, 6, null);
        a0Var.z(0);
        bodyShapeLayout.setAdapter(a0Var);
        ((FrameLayout) bodyShapeControlView.findViewById(R.id.btRange)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditBodyShapingController.a(EditBodyShapingController.this, view);
            }
        });
        ((FrameLayout) bodyShapeControlView.findViewById(R.id.btEraser)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.edit2020.controller.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EditBodyShapingController.c(EditBodyShapingController.this, view);
            }
        });
        ((AreaProtectionBoldAdjustView) bodyShapeControlView.findViewById(R.id.boldAdjustView)).setCallBack(new AnonymousClass4(context));
        int i2 = R.id.seekBar;
        ((StickySeekBar) bodyShapeControlView.findViewById(i2)).setValues(0, 100, 50, null);
        ((StickySeekBar) bodyShapeControlView.findViewById(i2)).setTrackListener(new a(f3));
        module.d().observe(lifecycleOwner, new Observer() { // from class: us.pinguo.edit2020.controller.r0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                EditBodyShapingController.h(EditBodyShapingController.this, (us.pinguo.edit2020.bean.k) obj);
            }
        });
        kotlin.jvm.internal.s.g(context, "context");
        this.f10323k = us.pinguo.util.h.i(context) - context.getResources().getDimension(R.dimen.magnifier_width);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.controller.q0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                EditBodyShapingController.i(EditBodyShapingController.this, valueAnimator2);
            }
        });
        valueAnimator.setDuration(100L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.s = new b();
    }

    private final boolean A(MotionEvent motionEvent) {
        us.pinguo.edit2020.bean.k value;
        kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n;
        us.pinguo.edit2020.bean.u0 f2 = this.b.f();
        if (f2 == null || (value = this.b.d().getValue()) == null) {
            return false;
        }
        boolean c = kotlin.jvm.internal.s.c(value.f(), this.f10319g.getResources().getString(R.string.key_reduction));
        if (c) {
            this.n.onTouchEvent(motionEvent);
        }
        float h2 = f2.h();
        float g2 = f2.g();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        float b3 = dimension + us.pinguo.util.g.b(b2, 30.0f);
        int action = motionEvent.getAction() & motionEvent.getActionMasked();
        if (action == 0) {
            this.f10322j.a(false);
            this.f10319g.l(motionEvent);
            PointF pointF = new PointF(x / h2, (g2 - y) / g2);
            value.z(pointF);
            value.w(new PointF(pointF.x, pointF.y));
            value.v(new PointF(x, y));
            if (value.m()) {
                if (x <= b3 && y <= b3) {
                    this.f10321i.setTranslationX(this.f10323k);
                } else {
                    this.f10321i.setTranslationX(0.0f);
                }
                this.b.n(1);
                L(x, y);
                this.b.n(0);
                Q(this, false, 1, null);
                x(f2, x, y);
                return true;
            }
        } else if (action == 1) {
            this.f10322j.a(true);
            this.f10319g.l(motionEvent);
            if (value.o() == null && value.h() == null && value.l() == null) {
                return true;
            }
            if (c) {
                if (value.j()) {
                    value.u(false);
                    kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n2 = value.n();
                    if (n2 != null) {
                        n2.invoke(null, null, Float.valueOf(0.0f), Boolean.TRUE, Float.valueOf(0.1f));
                    }
                } else {
                    kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n3 = value.n();
                    if (n3 != null) {
                        n3.invoke(null, new PointF(x / h2, (g2 - y) / g2), Float.valueOf(value.g().getBrushSize()), Boolean.TRUE, null);
                    }
                }
            } else {
                kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n4 = value.n();
                if (n4 != null) {
                    n4.invoke(value.l(), value.h(), Float.valueOf(value.g().getBrushSize()), Boolean.TRUE, null);
                }
            }
            value.z(null);
            value.s(null);
            value.w(null);
            value.v(null);
            E();
        } else if (action != 2) {
            if (action == 3) {
                this.f10319g.l(motionEvent);
                value.z(null);
                value.s(null);
                value.w(null);
                value.v(null);
                value.u(false);
                E();
            } else if (action == 5) {
                this.f10319g.l(motionEvent);
                if (c && value.j()) {
                    value.u(false);
                    kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n5 = value.n();
                    if (n5 != null) {
                        n5.invoke(null, null, Float.valueOf(0.0f), Boolean.TRUE, Float.valueOf(0.1f));
                    }
                }
                value.z(null);
                value.s(null);
                value.w(null);
                value.v(null);
                value.u(false);
                E();
            }
        } else if (motionEvent.getPointerCount() != 1 || (n = value.n()) == null) {
            return false;
        } else {
            this.f10319g.l(motionEvent);
            PointF l2 = value.l();
            PointF k2 = value.k();
            if (l2 != null && k2 != null && (Math.abs(x - k2.x) >= this.o || Math.abs(y - k2.y) >= this.o)) {
                PointF h3 = value.h();
                if (h3 == null) {
                    h3 = new PointF();
                    value.s(h3);
                }
                h3.x = x / h2;
                h3.y = (g2 - y) / g2;
                n.invoke(l2, h3, Float.valueOf(value.g().getBrushSize()), Boolean.FALSE, null);
                l2.x = h3.x;
                l2.y = h3.y;
                k2.x = x;
                k2.y = x;
            }
            if (value.m()) {
                boolean z = this.f10321i.getTranslationX() == 0.0f;
                boolean z2 = this.f10321i.getTranslationX() == this.f10323k;
                if (x <= b3 && y <= b3 && z) {
                    if (!this.f10324l.isStarted()) {
                        this.f10324l.setFloatValues(0.0f, this.f10323k);
                        this.f10324l.start();
                    }
                } else if (x >= h2 - b3 && y <= b3 && z2 && !this.f10324l.isStarted()) {
                    this.f10324l.setFloatValues(this.f10323k, 0.0f);
                    this.f10324l.start();
                }
                x(f2, x, y);
            }
        }
        return true;
    }

    private final void C(MotionEvent motionEvent, us.pinguo.edit2020.bean.k kVar, us.pinguo.edit2020.bean.u0 u0Var) {
        kVar.u(true);
        this.b.b(false);
        this.p.postDelayed(this.s, 100L);
    }

    private final boolean D(MotionEvent motionEvent) {
        kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n;
        float floatValue;
        this.n.onTouchEvent(motionEvent);
        us.pinguo.edit2020.bean.u0 f2 = this.b.f();
        if (f2 == null) {
            return false;
        }
        us.pinguo.edit2020.bean.k value = this.b.d().getValue();
        us.pinguo.edit2020.bean.p pVar = value instanceof us.pinguo.edit2020.bean.p ? (us.pinguo.edit2020.bean.p) value : null;
        if (pVar == null) {
            return false;
        }
        float h2 = f2.h();
        float g2 = f2.g();
        int action = motionEvent.getAction() & motionEvent.getActionMasked();
        if (action == 0) {
            this.f10320h.d(motionEvent);
            pVar.B().x = this.f10320h.a().x;
            pVar.B().y = this.f10320h.a().y;
            PointF o = pVar.o();
            if (o == null) {
                o = new PointF();
                pVar.z(o);
            }
            o.x = pVar.B().x / h2;
            o.y = (g2 - pVar.B().y) / g2;
            PointF k2 = pVar.k();
            if (k2 == null) {
                k2 = new PointF();
                pVar.v(k2);
            }
            k2.x = motionEvent.getX();
            k2.y = motionEvent.getY();
            this.f10322j.a(false);
            if (this.b.h(pVar)) {
                us.pinguo.repository2020.utils.o.n(us.pinguo.repository2020.utils.o.a, pVar.f(), false, null, 4, null);
                this.f10317e.a();
            }
        } else if (action == 1) {
            E();
            this.f10322j.a(true);
            PointF o2 = pVar.o();
            if (o2 == null) {
                return true;
            }
            if (pVar.j() && this.f10320h.b() == 2) {
                pVar.u(false);
                kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n2 = pVar.n();
                if (n2 != null) {
                    n2.invoke(o2, null, Float.valueOf(pVar.g().getBrushSize()), Boolean.TRUE, Float.valueOf(1.0f));
                }
            } else if (this.f10320h.b() == 3) {
                int scaledTouchSlop = ViewConfiguration.get(this.f10320h.getContext()).getScaledTouchSlop();
                PointF k3 = pVar.k();
                if (k3 != null) {
                    float f3 = scaledTouchSlop;
                    if (Math.abs(k3.x - motionEvent.getX()) < f3 && Math.abs(k3.y - motionEvent.getY()) < f3 && (n = pVar.n()) != null) {
                        n.invoke(o2, null, Float.valueOf(pVar.g().getBrushSize()), Boolean.TRUE, null);
                    }
                }
            }
            this.b.b(true);
            this.f10320h.setFreezed(false);
            this.f10320h.setDragMode(3);
            this.f10320h.invalidate();
            pVar.z(null);
        } else if (action == 2) {
            this.f10320h.d(motionEvent);
            if (this.f10320h.b() == 2 || this.f10320h.b() == 3) {
                return true;
            }
            pVar.B().x = this.f10320h.a().x;
            pVar.B().y = this.f10320h.a().y;
            pVar.G(this.f10320h.c());
            PointF o3 = pVar.o();
            if (o3 != null) {
                o3.x = pVar.B().x / h2;
            }
            PointF o4 = pVar.o();
            if (o4 != null) {
                o4.y = (g2 - pVar.B().y) / g2;
            }
            float F = pVar.F() * 2.0f;
            BoldType g3 = pVar.g();
            Context context = us.pinguo.foundation.e.b();
            us.pinguo.edit2020.bean.u0 f4 = this.b.f();
            Float valueOf = f4 != null ? Float.valueOf(f4.h()) : null;
            if (valueOf == null) {
                kotlin.jvm.internal.s.g(context, "context");
                floatValue = us.pinguo.util.h.i(context);
            } else {
                floatValue = valueOf.floatValue();
            }
            g3.setBrushSize(F / floatValue);
            g3.setScaleFactor(g3.getBrushSize());
            g3.setIndicatorSize(F);
            if (pVar.F() <= pVar.C()) {
                pVar.x(true);
                ((MagnifierView) this.f10321i.a(R.id.magnifierView)).setSize(F);
                if (this.f10320h.b() == 0) {
                    this.b.b(false);
                    L(pVar.B().x, pVar.B().y);
                    O(true);
                }
            } else {
                pVar.x(false);
                E();
            }
        } else if (action == 3) {
            this.f10320h.setFreezed(false);
            this.f10320h.setDragMode(3);
            this.f10320h.invalidate();
            this.b.b(true);
            pVar.u(false);
            pVar.z(null);
            E();
        } else if (action == 5) {
            if (pVar.j() && this.f10320h.b() == 2) {
                PointF pointF = new PointF(pVar.B().x / h2, (g2 - pVar.B().y) / g2);
                kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n3 = pVar.n();
                if (n3 != null) {
                    n3.invoke(pointF, null, Float.valueOf(pVar.g().getBrushSize()), Boolean.TRUE, Float.valueOf(1.0f));
                }
            }
            this.f10320h.setFreezed(true);
            this.f10320h.setDragMode(3);
            this.f10320h.invalidate();
            this.b.b(true);
            pVar.u(false);
            pVar.z(null);
            E();
        }
        return true;
    }

    private final void E() {
        this.f10321i.animate().cancel();
        MagnifierLayout magnifierLayout = this.f10321i;
        magnifierLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(magnifierLayout, 4);
        this.f10321i.setClicked(false);
    }

    private final void L(float f2, float f3) {
        float floatValue;
        float floatValue2;
        Context context = us.pinguo.foundation.e.b();
        us.pinguo.edit2020.bean.u0 f4 = this.b.f();
        Float valueOf = f4 == null ? null : Float.valueOf(f4.h());
        if (valueOf == null) {
            kotlin.jvm.internal.s.g(context, "context");
            floatValue = us.pinguo.util.h.i(context);
        } else {
            floatValue = valueOf.floatValue();
        }
        us.pinguo.edit2020.bean.u0 f5 = this.b.f();
        Float valueOf2 = f5 != null ? Float.valueOf(f5.g()) : null;
        if (valueOf2 == null) {
            kotlin.jvm.internal.s.g(context, "context");
            floatValue2 = us.pinguo.util.h.g(context);
        } else {
            floatValue2 = valueOf2.floatValue();
        }
        this.b.m(f2 / floatValue, 1 - (f3 / floatValue2));
    }

    private final void O(boolean z) {
        this.f10321i.setClicked(true);
        if (z) {
            this.f10321i.setAlpha(1.0f);
            MagnifierLayout magnifierLayout = this.f10321i;
            magnifierLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(magnifierLayout, 0);
            this.b.k();
        }
    }

    static /* synthetic */ void Q(EditBodyShapingController editBodyShapingController, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        editBodyShapingController.O(z);
    }

    private final void T() {
        us.pinguo.edit2020.bean.k value = this.b.d().getValue();
        if (value == null) {
            return;
        }
        Context b2 = us.pinguo.foundation.e.b();
        AreaProtectionBoldAdjustView boldAdjustView = (AreaProtectionBoldAdjustView) this.c.findViewById(R.id.boldAdjustView);
        us.pinguo.edit2020.viewmodel.module.c g2 = boldAdjustView.g();
        g2.i(true);
        g2.j(true);
        g2.f(value.g());
        g2.g(value.g().getScaleFactor());
        E();
        MagnifierLayout magnifierLayout = this.f10321i;
        int i2 = R.id.magnifierView;
        MagnifierView magnifierView = (MagnifierView) magnifierLayout.a(i2);
        kotlin.jvm.internal.s.g(magnifierView, "flMagnifier.magnifierView");
        magnifierView.setVisibility(0);
        VdsAgent.onSetViewVisibility(magnifierView, 0);
        ((MagnifierView) this.f10321i.a(i2)).setSize(value.g().getIndicatorSize());
        ((MagnifierView) this.f10321i.a(i2)).setStrokeWidth(value.p());
        BodyShapingGestureView bodyShapingGestureView = this.f10320h;
        bodyShapingGestureView.setVisibility(4);
        VdsAgent.onSetViewVisibility(bodyShapingGestureView, 4);
        ShapeDirectionView shapeDirectionView = this.f10319g;
        shapeDirectionView.setVisibility(4);
        VdsAgent.onSetViewVisibility(shapeDirectionView, 4);
        this.f10319g.setLineWidth(value.p());
        this.f10319g.setIndicatorSize(value.g().getIndicatorSize());
        if (value.i().length() == 0) {
            TextView textView = this.f10316d;
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        } else {
            TextView textView2 = this.f10316d;
            textView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView2, 0);
            this.f10316d.setText(value.i());
        }
        this.b.n(0);
        if (value instanceof us.pinguo.edit2020.bean.b) {
            g2.h(b2.getResources().getDimension(R.dimen.bold_tip_size_max_in_discrete_mode));
            this.f10317e.a();
            ConstraintLayout constraintLayout = this.c;
            constraintLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout, 0);
            TextView textView3 = (TextView) this.c.findViewById(R.id.txtBrushSize);
            kotlin.jvm.internal.s.g(textView3, "bodyShapeControlView.txtBrushSize");
            textView3.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView3, 4);
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.btRange);
            kotlin.jvm.internal.s.g(frameLayout, "bodyShapeControlView.btRange");
            frameLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout, 0);
            FrameLayout frameLayout2 = (FrameLayout) this.c.findViewById(R.id.btEraser);
            kotlin.jvm.internal.s.g(frameLayout2, "bodyShapeControlView.btEraser");
            frameLayout2.setVisibility(0);
            VdsAgent.onSetViewVisibility(frameLayout2, 0);
            View findViewById = this.c.findViewById(R.id.divider);
            kotlin.jvm.internal.s.g(findViewById, "bodyShapeControlView.divider");
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
            kotlin.jvm.internal.s.g(boldAdjustView, "boldAdjustView");
            boldAdjustView.setVisibility(4);
            VdsAgent.onSetViewVisibility(boldAdjustView, 4);
            StickySeekBar stickySeekBar = (StickySeekBar) this.c.findViewById(R.id.seekBar);
            kotlin.jvm.internal.s.g(stickySeekBar, "bodyShapeControlView.seekBar");
            stickySeekBar.setVisibility(0);
            VdsAgent.onSetViewVisibility(stickySeekBar, 0);
            this.f10319g.setSinglePointMode(true);
            ((MagnifierView) this.f10321i.a(i2)).setSize(value.g().getIndicatorSize());
            us.pinguo.edit2020.bean.b bVar = (us.pinguo.edit2020.bean.b) value;
            if (bVar.C() == 0) {
                BasicBrushMode basicBrushMode = BasicBrushMode.Brush;
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode);
                UnityEditCaller.Brush.setBrushSize(basicBrushMode, value.g().getBrushSize());
                ConstraintLayout constraintLayout2 = this.c;
                int i3 = R.id.txtRange;
                Context context = this.c.getContext();
                kotlin.jvm.internal.s.g(context, "bodyShapeControlView.context");
                ((TextView) constraintLayout2.findViewById(i3)).setTextColor(us.pinguo.edit2020.utils.d.c(context, R.color.color_camera_theme_black));
                ((TextView) this.c.findViewById(i3)).setBackgroundResource(R.drawable.half_circle_bg);
                ConstraintLayout constraintLayout3 = this.c;
                int i4 = R.id.txtEraser;
                Context context2 = this.c.getContext();
                kotlin.jvm.internal.s.g(context2, "bodyShapeControlView.context");
                ((TextView) constraintLayout3.findViewById(i4)).setTextColor(us.pinguo.edit2020.utils.d.c(context2, R.color.color_camera_theme_dark));
                ((TextView) this.c.findViewById(i4)).setBackgroundResource(0);
                return;
            } else if (bVar.C() == 1) {
                BasicBrushMode basicBrushMode2 = BasicBrushMode.Erasing;
                UnityEditCaller.Brush.setCurrentBrushMode(basicBrushMode2);
                UnityEditCaller.Brush.setBrushSize(basicBrushMode2, value.g().getBrushSize());
                ConstraintLayout constraintLayout4 = this.c;
                int i5 = R.id.txtEraser;
                Context context3 = this.c.getContext();
                kotlin.jvm.internal.s.g(context3, "bodyShapeControlView.context");
                ((TextView) constraintLayout4.findViewById(i5)).setTextColor(us.pinguo.edit2020.utils.d.c(context3, R.color.color_camera_theme_black));
                ((TextView) this.c.findViewById(i5)).setBackgroundResource(R.drawable.half_circle_bg);
                ConstraintLayout constraintLayout5 = this.c;
                int i6 = R.id.txtRange;
                Context context4 = this.c.getContext();
                kotlin.jvm.internal.s.g(context4, "bodyShapeControlView.context");
                ((TextView) constraintLayout5.findViewById(i6)).setTextColor(us.pinguo.edit2020.utils.d.c(context4, R.color.color_camera_theme_dark));
                ((TextView) this.c.findViewById(i6)).setBackgroundResource(0);
                return;
            } else {
                return;
            }
        }
        UnityEditCaller.Brush.setCurrentBrushMode(BasicBrushMode.None);
        ConstraintLayout constraintLayout6 = this.c;
        constraintLayout6.setVisibility(4);
        VdsAgent.onSetViewVisibility(constraintLayout6, 4);
        if (value instanceof us.pinguo.edit2020.bean.p) {
            this.b.n(1);
            MagnifierView magnifierView2 = (MagnifierView) this.f10321i.a(i2);
            kotlin.jvm.internal.s.g(magnifierView2, "flMagnifier.magnifierView");
            magnifierView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(magnifierView2, 4);
            ShapeDirectionView shapeDirectionView2 = this.f10319g;
            shapeDirectionView2.setVisibility(4);
            VdsAgent.onSetViewVisibility(shapeDirectionView2, 4);
            us.pinguo.edit2020.bean.p pVar = (us.pinguo.edit2020.bean.p) value;
            this.f10320h.setRadius(pVar.F());
            this.f10320h.setMaxRadius(pVar.D());
            this.f10320h.setMinRadius(pVar.E());
            if (!Float.isNaN(pVar.B().x) && !Float.isNaN(pVar.B().y)) {
                this.f10320h.a().x = pVar.B().x;
                this.f10320h.a().y = pVar.B().y;
            } else {
                float measuredWidth = this.f10320h.getMeasuredWidth() * 0.5f;
                float measuredHeight = this.f10320h.getMeasuredHeight() * 0.5f;
                pVar.B().x = measuredWidth;
                pVar.B().y = measuredHeight;
                this.f10320h.a().x = measuredWidth;
                this.f10320h.a().y = measuredHeight;
            }
            BodyShapingGestureView bodyShapingGestureView2 = this.f10320h;
            bodyShapingGestureView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(bodyShapingGestureView2, 0);
            this.f10320h.invalidate();
            if (this.b.h(value)) {
                this.f10317e.d(kotlin.jvm.internal.s.c(value.f(), b2.getString(R.string.key_expand)) ? R.string.press_to_expand : R.string.press_to_narrow);
            } else {
                this.f10317e.a();
            }
        } else if (kotlin.jvm.internal.s.c(value.f(), b2.getString(R.string.key_push))) {
            g2.h(b2.getResources().getDimension(R.dimen.bold_tip_size_max_in_push_mode));
            this.f10317e.a();
            TextView textView4 = this.f10316d;
            textView4.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView4, 8);
            this.f10319g.setSinglePointMode(true);
            ConstraintLayout constraintLayout7 = this.c;
            constraintLayout7.setVisibility(0);
            VdsAgent.onSetViewVisibility(constraintLayout7, 0);
            ConstraintLayout constraintLayout8 = this.c;
            int i7 = R.id.txtBrushSize;
            TextView textView5 = (TextView) constraintLayout8.findViewById(i7);
            kotlin.jvm.internal.s.g(textView5, "bodyShapeControlView.txtBrushSize");
            textView5.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView5, 0);
            FrameLayout frameLayout3 = (FrameLayout) this.c.findViewById(R.id.btRange);
            kotlin.jvm.internal.s.g(frameLayout3, "bodyShapeControlView.btRange");
            frameLayout3.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout3, 4);
            FrameLayout frameLayout4 = (FrameLayout) this.c.findViewById(R.id.btEraser);
            kotlin.jvm.internal.s.g(frameLayout4, "bodyShapeControlView.btEraser");
            frameLayout4.setVisibility(4);
            VdsAgent.onSetViewVisibility(frameLayout4, 4);
            View findViewById2 = this.c.findViewById(R.id.divider);
            kotlin.jvm.internal.s.g(findViewById2, "bodyShapeControlView.divider");
            findViewById2.setVisibility(4);
            VdsAgent.onSetViewVisibility(findViewById2, 4);
            StickySeekBar stickySeekBar2 = (StickySeekBar) this.c.findViewById(R.id.seekBar);
            kotlin.jvm.internal.s.g(stickySeekBar2, "bodyShapeControlView.seekBar");
            stickySeekBar2.setVisibility(4);
            VdsAgent.onSetViewVisibility(stickySeekBar2, 4);
            kotlin.jvm.internal.s.g(boldAdjustView, "boldAdjustView");
            boldAdjustView.setVisibility(0);
            VdsAgent.onSetViewVisibility(boldAdjustView, 0);
            boldAdjustView.h()[0] = BoldType.BOLD_PUSH_SMALL;
            boldAdjustView.h()[1] = BoldType.BOLD_PUSH_NORMAL;
            boldAdjustView.h()[2] = BoldType.BOLD_PUSH_BOLD;
            boldAdjustView.h()[3] = BoldType.BOLD_PUSH_BOLD2;
            boldAdjustView.h()[4] = BoldType.BOLD_PUSH_BOLD3;
            boldAdjustView.setMappingsArr(boldAdjustView.j());
            ViewGroup.LayoutParams layoutParams = boldAdjustView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.startToEnd = i7;
            boldAdjustView.setLayoutParams(layoutParams2);
            boldAdjustView.setCurrentBold(value.g());
            if (this.b.c().getValue() == null) {
                this.b.c().setValue(g2);
            }
        } else {
            this.f10317e.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EditBodyShapingController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.edit2020.bean.b bVar = (us.pinguo.edit2020.bean.b) this$0.b.e().get(3);
        if (bVar.C() == 0) {
            return;
        }
        bVar.D(0);
        this$0.T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditBodyShapingController this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.edit2020.bean.b bVar = (us.pinguo.edit2020.bean.b) this$0.b.e().get(3);
        if (bVar.C() == 1) {
            return;
        }
        bVar.D(1);
        this$0.T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(EditBodyShapingController this$0, us.pinguo.edit2020.bean.k kVar) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.T();
        if (kVar == null) {
            return;
        }
        if (this$0.r == null) {
            this$0.r = new ArrayList();
        }
        List<String> list = this$0.r;
        if (list != null) {
            list.add(kVar.f());
        }
        us.pinguo.foundation.statistics.h.b.M(kVar.f(), "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(EditBodyShapingController this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        MagnifierLayout magnifierLayout = this$0.f10321i;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        magnifierLayout.setTranslationX(((Float) animatedValue).floatValue());
    }

    private final boolean s(MotionEvent motionEvent) {
        us.pinguo.edit2020.bean.u0 f2 = this.b.f();
        if (f2 == null) {
            return false;
        }
        float h2 = f2.h();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        Context b2 = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b2, "getAppContext()");
        float b3 = dimension + us.pinguo.util.g.b(b2, 30.0f);
        int action = motionEvent.getAction() & motionEvent.getActionMasked();
        if (action == 0) {
            this.f10322j.a(false);
            this.b.n(1);
            L(x, y);
            this.b.n(0);
            this.f10319g.l(motionEvent);
            if (x <= b3 && y <= b3) {
                this.f10321i.setTranslationX(this.f10323k);
            } else {
                this.f10321i.setTranslationX(0.0f);
            }
            O(true);
            x(f2, x, y);
        } else if (action == 1) {
            this.f10319g.l(motionEvent);
            E();
            this.f10322j.a(true);
        } else if (action != 2) {
            if (action == 3 || action == 5) {
                this.f10319g.l(motionEvent);
                E();
            }
        } else if (motionEvent.getPointerCount() != 1) {
            return false;
        } else {
            this.f10319g.l(motionEvent);
            boolean z = this.f10321i.getTranslationX() == 0.0f;
            boolean z2 = this.f10321i.getTranslationX() == this.f10323k;
            if (x <= b3 && y <= b3 && z) {
                if (!this.f10324l.isStarted()) {
                    this.f10324l.setFloatValues(0.0f, this.f10323k);
                    this.f10324l.start();
                }
            } else if (x >= h2 - b3 && y <= b3 && z2 && !this.f10324l.isStarted()) {
                this.f10324l.setFloatValues(this.f10323k, 0.0f);
                this.f10324l.start();
            }
            x(f2, x, y);
        }
        return true;
    }

    private final void w(MotionEvent motionEvent, us.pinguo.edit2020.bean.p pVar, us.pinguo.edit2020.bean.u0 u0Var) {
        PointF o = pVar.o();
        if (o == null) {
            return;
        }
        pVar.u(true);
        this.f10320h.setDragMode(2);
        this.f10320h.invalidate();
        this.b.b(false);
        float h2 = u0Var.h();
        float g2 = u0Var.g();
        float f2 = pVar.B().x;
        float f3 = pVar.B().y;
        o.x = f2 / h2;
        o.y = (g2 - f3) / g2;
        this.p.postDelayed(this.s, 100L);
        if (pVar.m()) {
            float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
            Context b2 = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b2, "getAppContext()");
            float b3 = dimension + us.pinguo.util.g.b(b2, 30.0f);
            if (f2 <= b3 && f3 <= b3) {
                this.f10321i.setTranslationX(this.f10323k);
            } else {
                this.f10321i.setTranslationX(0.0f);
            }
            L(f2, f3);
            O(true);
            x(u0Var, f2, f3);
        }
    }

    private final void x(us.pinguo.edit2020.bean.u0 u0Var, float f2, float f3) {
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
        ((MagnifierView) this.f10321i.a(R.id.magnifierView)).b(f5, f4);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public EditTabType F() {
        return EditTabType.BEAUTY;
    }

    public final void M(kotlin.jvm.b.p<? super Integer, ? super us.pinguo.edit2020.bean.k, kotlin.u> pVar) {
        this.q = pVar;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void P() {
        p0.a.d(this);
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
        if (this.b.c().getValue() != null) {
            this.b.c().setValue(null);
        }
        us.pinguo.edit2020.bean.k value = this.b.d().getValue();
        return value instanceof us.pinguo.edit2020.bean.b ? s(event) : value instanceof us.pinguo.edit2020.bean.p ? D(event) : A(event);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void d() {
        int i2;
        List O;
        String J;
        this.m.z(0);
        this.b.l();
        this.f10317e.a();
        BoldType boldType = BoldType.BOLD;
        ((MagnifierView) this.f10321i.a(R.id.magnifierView)).setSize(boldType.getIndicatorSize());
        this.f10319g.setIndicatorSize(boldType.getIndicatorSize());
        ShapeDirectionView shapeDirectionView = this.f10319g;
        shapeDirectionView.setVisibility(8);
        VdsAgent.onSetViewVisibility(shapeDirectionView, 8);
        BodyShapingGestureView bodyShapingGestureView = this.f10320h;
        bodyShapingGestureView.setVisibility(4);
        VdsAgent.onSetViewVisibility(bodyShapingGestureView, 4);
        ((AreaProtectionBoldAdjustView) this.c.findViewById(R.id.boldAdjustView)).l();
        ConstraintLayout constraintLayout = this.c;
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        TextView textView = this.f10316d;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.b.n(1);
        E();
        this.b.n(0);
        List<String> list = this.r;
        if (list != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            i2 = kotlin.collections.u.i(list);
            if (i2 >= 0) {
                while (true) {
                    int i3 = i2 - 1;
                    linkedHashSet.add(list.get(i2));
                    if (i3 < 0) {
                        break;
                    }
                    i2 = i3;
                }
            }
            O = kotlin.collections.c0.O(linkedHashSet);
            J = kotlin.collections.c0.J(O, PGTransHeader.CONNECTOR, null, null, 0, null, null, 62, null);
            us.pinguo.foundation.statistics.h.b.M(J, "save");
        }
        this.r = null;
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean f() {
        return c.a.b(this);
    }

    @Override // us.pinguo.edit2020.b.c, us.pinguo.edit2020.controller.z2
    public void g() {
        this.m.z(0);
        this.b.l();
        this.f10317e.a();
        BoldType boldType = BoldType.BOLD;
        ((MagnifierView) this.f10321i.a(R.id.magnifierView)).setSize(boldType.getIndicatorSize());
        this.f10319g.setIndicatorSize(boldType.getIndicatorSize());
        ShapeDirectionView shapeDirectionView = this.f10319g;
        shapeDirectionView.setVisibility(8);
        VdsAgent.onSetViewVisibility(shapeDirectionView, 8);
        BodyShapingGestureView bodyShapingGestureView = this.f10320h;
        bodyShapingGestureView.setVisibility(4);
        VdsAgent.onSetViewVisibility(bodyShapingGestureView, 4);
        ((AreaProtectionBoldAdjustView) this.c.findViewById(R.id.boldAdjustView)).l();
        ConstraintLayout constraintLayout = this.c;
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
        TextView textView = this.f10316d;
        textView.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView, 8);
        this.b.n(1);
        E();
        this.b.n(0);
    }

    @Override // us.pinguo.edit2020.view.p0
    public void j() {
        UnityEditCaller.Common.moveNext();
    }

    @Override // us.pinguo.edit2020.view.p0
    public void k(boolean z) {
        UnityEditCaller.Common.showOriginalTexture(z);
        if (this.b.d().getValue() instanceof us.pinguo.edit2020.bean.p) {
            if (z) {
                BodyShapingGestureView bodyShapingGestureView = this.f10320h;
                bodyShapingGestureView.setVisibility(4);
                VdsAgent.onSetViewVisibility(bodyShapingGestureView, 4);
                return;
            }
            BodyShapingGestureView bodyShapingGestureView2 = this.f10320h;
            bodyShapingGestureView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(bodyShapingGestureView2, 0);
        }
    }

    @Override // us.pinguo.edit2020.view.p0
    public void m() {
        p0.a.f(this);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public boolean onBackPressed() {
        return c.a.d(this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e2) {
        us.pinguo.edit2020.bean.k value;
        kotlin.jvm.internal.s.h(e2, "e");
        us.pinguo.edit2020.bean.u0 f2 = this.b.f();
        if (f2 == null || (value = this.b.d().getValue()) == null) {
            return;
        }
        if (value instanceof us.pinguo.edit2020.bean.p) {
            w(e2, (us.pinguo.edit2020.bean.p) value, f2);
        } else if (kotlin.jvm.internal.s.c(value.f(), this.f10319g.getResources().getString(R.string.key_reduction))) {
            C(e2, value, f2);
        }
    }

    public final kotlin.jvm.b.p<Integer, us.pinguo.edit2020.bean.k, kotlin.u> r() {
        return this.q;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void t(boolean z) {
        p0.a.c(this, z);
    }

    @Override // us.pinguo.edit2020.controller.z2
    public List<us.pinguo.edit2020.bean.x> v() {
        return null;
    }

    @Override // us.pinguo.edit2020.view.p0
    public void y() {
        UnityEditCaller.Common.movePrevious();
    }

    @Override // us.pinguo.edit2020.b.c
    public void z(String str) {
        this.b.d().setValue(this.b.e().get(0));
    }
}
