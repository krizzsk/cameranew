package com.camera360.dynamic_feature_splice;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.jvm.internal.Ref$IntRef;
/* compiled from: DragLinearLayout.kt */
/* loaded from: classes8.dex */
public final class DragLinearLayout extends LinearLayout {
    public static final a u = new a(null);
    private f a;
    private e b;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutTransition f2123d;

    /* renamed from: e  reason: collision with root package name */
    private final SparseArray<c> f2124e;

    /* renamed from: f  reason: collision with root package name */
    private final f1 f2125f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2126g;

    /* renamed from: h  reason: collision with root package name */
    private int f2127h;

    /* renamed from: i  reason: collision with root package name */
    private int f2128i;

    /* renamed from: j  reason: collision with root package name */
    private final Drawable f2129j;

    /* renamed from: k  reason: collision with root package name */
    private final Drawable f2130k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2131l;
    private SpliceScrollView m;
    private AnimatorSet n;
    private final float o;
    private Runnable p;
    private float q;
    private float r;
    private boolean s;
    private kotlin.z.d t;

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(float f2, float f3, float f4) {
            float max = Math.max(0.0f, Math.min((f4 - f2) / (f3 - f2), 1.0f));
            return max * max * max * ((max * ((6 * max) - 15)) + 10);
        }
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    private final class b implements View.OnTouchListener {
        private final View a;
        private final GestureDetector.SimpleOnGestureListener b;
        private final GestureDetector c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DragLinearLayout f2132d;

        /* compiled from: DragLinearLayout.kt */
        /* loaded from: classes8.dex */
        public static final class a extends GestureDetector.SimpleOnGestureListener {
            final /* synthetic */ DragLinearLayout a;
            final /* synthetic */ b b;

            a(DragLinearLayout dragLinearLayout, b bVar) {
                this.a = dragLinearLayout;
                this.b = bVar;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e2) {
                kotlin.jvm.internal.s.h(e2, "e");
                int indexOfChild = this.a.indexOfChild(this.b.a);
                e t = this.a.t();
                Integer valueOf = t == null ? null : Integer.valueOf(t.b());
                if ((valueOf != null && valueOf.intValue() == -1) || valueOf == null || valueOf.intValue() != indexOfChild) {
                    this.a.s = false;
                    return !this.a.y();
                }
                this.a.s = true;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent e2) {
                kotlin.jvm.internal.s.h(e2, "e");
                if (this.a.r()) {
                    e t = this.a.t();
                    boolean z = false;
                    if (t != null && t.b() == -1) {
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                }
                us.pinguo.foundation.statistics.h.a.x();
                float y = e2.getY();
                this.a.N(this.b.a, y);
                this.a.m(this.b.a, y);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e2) {
                kotlin.jvm.internal.s.h(e2, "e");
                e t = this.a.t();
                if (t == null) {
                    return false;
                }
                int indexOfChild = this.a.indexOfChild(this.b.a);
                if (indexOfChild != -1) {
                    t.a(this.b.a, indexOfChild);
                    return true;
                }
                t.a(null, -1);
                return true;
            }
        }

        public b(DragLinearLayout this$0, View view) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
            kotlin.jvm.internal.s.h(view, "view");
            this.f2132d = this$0;
            this.a = view;
            a aVar = new a(this$0, this);
            this.b = aVar;
            this.c = new GestureDetector(view.getContext(), aVar);
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            kotlin.jvm.internal.s.h(v, "v");
            kotlin.jvm.internal.s.h(event, "event");
            boolean onTouchEvent = this.c.onTouchEvent(event);
            SpliceScrollView spliceScrollView = this.f2132d.m;
            boolean z = false;
            if (spliceScrollView != null && spliceScrollView.j()) {
                z = true;
            }
            if (z) {
                return true;
            }
            return onTouchEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public final class c {
        private ValueAnimator a;

        public c(DragLinearLayout this$0) {
            kotlin.jvm.internal.s.h(this$0, "this$0");
        }

        public final void a() {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null) {
                return;
            }
            valueAnimator.cancel();
        }

        public final void b() {
            ValueAnimator valueAnimator = this.a;
            if (valueAnimator == null) {
                return;
            }
            valueAnimator.end();
        }

        public final void c(ValueAnimator valueAnimator) {
            this.a = valueAnimator;
        }
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public interface d {
        void a();

        void b();

        void c();

        void d();
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public interface e {
        void a(View view, int i2);

        int b();
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public interface f {
        void c(View view, int i2, View view2, int i3);
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public static final class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DragLinearLayout dragLinearLayout = DragLinearLayout.this;
            dragLinearLayout.setPivotY(dragLinearLayout.getHeight() / 2.0f);
        }
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public static final class h implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver a;
        final /* synthetic */ View b;
        final /* synthetic */ float c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DragLinearLayout f2133d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f2134e;

        /* compiled from: DragLinearLayout.kt */
        /* loaded from: classes8.dex */
        public static final class a extends AnimatorListenerAdapter {
            final /* synthetic */ DragLinearLayout a;
            final /* synthetic */ int b;
            final /* synthetic */ ObjectAnimator c;

            a(DragLinearLayout dragLinearLayout, int i2, ObjectAnimator objectAnimator) {
                this.a = dragLinearLayout;
                this.b = i2;
                this.c = objectAnimator;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                kotlin.jvm.internal.s.h(animation, "animation");
                ((c) this.a.f2124e.get(this.b)).c(null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                kotlin.jvm.internal.s.h(animation, "animation");
                ((c) this.a.f2124e.get(this.b)).c(this.c);
            }
        }

        h(ViewTreeObserver viewTreeObserver, View view, float f2, DragLinearLayout dragLinearLayout, int i2) {
            this.a = viewTreeObserver;
            this.b = view;
            this.c = f2;
            this.f2133d = dragLinearLayout;
            this.f2134e = i2;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.removeOnPreDrawListener(this);
            View view = this.b;
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "y", this.c, view.getTop()).setDuration(this.f2133d.v(this.b.getTop() - this.c));
            kotlin.jvm.internal.s.g(duration, "ofFloat(switchView, \"y\",….top - switchViewStartY))");
            duration.addListener(new a(this.f2133d, this.f2134e, duration));
            duration.start();
            return true;
        }
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public static final class i implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ ViewTreeObserver a;
        final /* synthetic */ DragLinearLayout b;

        i(ViewTreeObserver viewTreeObserver, DragLinearLayout dragLinearLayout) {
            this.a = viewTreeObserver;
            this.b = dragLinearLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.removeOnPreDrawListener(this);
            this.b.f2125f.w();
            ValueAnimator g2 = this.b.f2125f.g();
            if (g2 == null) {
                return true;
            }
            DragLinearLayout dragLinearLayout = this.b;
            Log.d("DragLinearLayout", "Updating settle animation");
            g2.removeAllListeners();
            g2.cancel();
            dragLinearLayout.G();
            return true;
        }
    }

    /* compiled from: DragLinearLayout.kt */
    /* loaded from: classes8.dex */
    public static final class j extends AnimatorListenerAdapter {
        j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.s.h(animation, "animation");
            if (DragLinearLayout.this.f2125f.a()) {
                DragLinearLayout.this.f2125f.r(null);
                DragLinearLayout.this.I();
                Drawable drawable = DragLinearLayout.this.f2129j;
                if (drawable != null) {
                    drawable.setAlpha(255);
                }
                Drawable drawable2 = DragLinearLayout.this.f2130k;
                if (drawable2 != null) {
                    drawable2.setAlpha(255);
                }
                if (DragLinearLayout.this.f2123d == null || DragLinearLayout.this.getLayoutTransition() != null) {
                    return;
                }
                DragLinearLayout dragLinearLayout = DragLinearLayout.this;
                dragLinearLayout.setLayoutTransition(dragLinearLayout.f2123d);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            kotlin.jvm.internal.s.h(animation, "animation");
            DragLinearLayout.this.f2125f.o();
            d s = DragLinearLayout.this.s();
            if (s == null) {
                return;
            }
            s.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.f2124e = new SparseArray<>();
        this.f2125f = new f1();
        this.f2127h = -1;
        this.f2128i = -1;
        this.q = 1.0f;
        this.r = 1.5f;
        setOrientation(1);
        this.f2126g = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.f2129j = ContextCompat.getDrawable(context, vStudio.Android.Camera360.R.drawable.ab_solid_shadow_holo_flipped);
        this.f2130k = ContextCompat.getDrawable(context, vStudio.Android.Camera360.R.drawable.ab_solid_shadow_holo);
        this.f2131l = resources.getDimensionPixelSize(vStudio.Android.Camera360.R.dimen.downwards_drop_shadow_height);
        float f2 = resources.getDisplayMetrics().density;
        this.r = f2;
        this.o = (int) ((f2 * 20.0f) + 0.5f);
    }

    private final int E(int i2) {
        int indexOfKey = this.f2124e.indexOfKey(i2);
        if (indexOfKey < -1 || indexOfKey > this.f2124e.size() - 2) {
            return -1;
        }
        return this.f2124e.keyAt(indexOfKey + 1);
    }

    private final void F(int i2) {
        this.f2125f.s(i2);
        invalidate();
        int h2 = this.f2125f.h() + this.f2125f.j();
        w(h2);
        int E = E(this.f2125f.f());
        int K = K(this.f2125f.f());
        View childAt = getChildAt(E);
        View childAt2 = getChildAt(K);
        boolean z = false;
        boolean z2 = childAt != null && this.f2125f.e() + h2 > childAt.getTop() + (childAt.getHeight() / 2);
        if (childAt2 != null && h2 < childAt2.getTop() + (childAt2.getHeight() / 2)) {
            z = true;
        }
        if (z2 || z) {
            View switchView = z2 ? childAt : childAt2;
            int f2 = this.f2125f.f();
            if (!z2) {
                E = K;
            }
            this.f2124e.get(E).a();
            float y = switchView.getY();
            f fVar = this.a;
            if (fVar != null) {
                View l2 = this.f2125f.l();
                int f3 = this.f2125f.f();
                kotlin.jvm.internal.s.g(switchView, "switchView");
                fVar.c(l2, f3, switchView, E);
            }
            if (z2) {
                removeViewAt(f2);
                removeViewAt(E - 1);
                addView(childAt, f2);
                addView(this.f2125f.l(), E);
            } else {
                removeViewAt(E);
                removeViewAt(f2 - 1);
                addView(this.f2125f.l(), E);
                addView(childAt2, f2);
            }
            this.f2125f.q(E);
            ViewTreeObserver viewTreeObserver = switchView.getViewTreeObserver();
            viewTreeObserver.addOnPreDrawListener(new h(viewTreeObserver, switchView, y, this, f2));
            View l3 = this.f2125f.l();
            kotlin.jvm.internal.s.e(l3);
            ViewTreeObserver viewTreeObserver2 = l3.getViewTreeObserver();
            viewTreeObserver2.addOnPreDrawListener(new i(viewTreeObserver2, this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        ValueAnimator duration = ValueAnimator.ofFloat(this.f2125f.j(), this.f2125f.j() - this.f2125f.i()).setDuration(v(this.f2125f.i()));
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragLinearLayout.H(DragLinearLayout.this, valueAnimator);
            }
        });
        duration.addListener(new j());
        duration.start();
        this.f2125f.r(duration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(DragLinearLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.f2125f.a()) {
            f1 f1Var = this$0.f2125f;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            f1Var.s((int) ((Float) animatedValue).floatValue());
            int animatedFraction = (int) ((1 - valueAnimator.getAnimatedFraction()) * 255);
            Drawable drawable = this$0.f2129j;
            if (drawable != null) {
                drawable.setAlpha(animatedFraction);
            }
            Drawable drawable2 = this$0.f2130k;
            if (drawable2 != null) {
                drawable2.setAlpha(animatedFraction);
            }
            this$0.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        Integer valueOf;
        View l2 = this.f2125f.l();
        if (l2 == null) {
            valueOf = null;
        } else {
            int top = l2.getTop();
            SpliceScrollView spliceScrollView = this.m;
            valueOf = Integer.valueOf(top - (((spliceScrollView == null ? 0 : spliceScrollView.getHeight()) / 2) - (l2.getHeight() / 2)));
        }
        this.f2125f.p(valueOf);
        this.f2125f.v();
        d dVar = this.c;
        if (dVar != null) {
            dVar.b();
        }
        o();
    }

    private final void J() {
        this.f2127h = -1;
        this.f2128i = -1;
    }

    private final int K(int i2) {
        int indexOfKey = this.f2124e.indexOfKey(i2);
        if (indexOfKey < 1 || indexOfKey > this.f2124e.size()) {
            return -1;
        }
        return this.f2124e.keyAt(indexOfKey - 1);
    }

    private final void L(float f2, Float f3) {
        int b2;
        int b3;
        kotlin.z.d dVar;
        int b4;
        this.q = f2;
        setScaleX(f2);
        setScaleY(f2);
        float pivotY = f3 == null ? getPivotY() : f3.floatValue();
        setPivotY(pivotY);
        setPivotX(getWidth() / 2.0f);
        int height = getHeight();
        SpliceScrollView spliceScrollView = this.m;
        int height2 = spliceScrollView == null ? 0 : spliceScrollView.getHeight();
        if (f2 >= 0.9999f) {
            dVar = new kotlin.z.d(0, height - height2);
        } else {
            b2 = kotlin.y.c.b(height * f2);
            if (b2 < height2) {
                b4 = kotlin.y.c.b((pivotY - (f2 * pivotY)) - ((height2 - b2) / 2.0f));
                int i2 = b4 > 0 ? b4 : 0;
                dVar = new kotlin.z.d(i2, i2);
            } else {
                b3 = kotlin.y.c.b(pivotY - (f2 * pivotY));
                dVar = new kotlin.z.d(b3, (b2 + b3) - height2);
            }
        }
        this.t = dVar;
    }

    static /* synthetic */ void M(DragLinearLayout dragLinearLayout, float f2, Float f3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = null;
        }
        dragLinearLayout.L(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(View view, float f2) {
        if (this.f2125f.a()) {
            return;
        }
        int indexOfChild = indexOfChild(view);
        this.f2124e.get(indexOfChild).b();
        this.f2125f.u(view, indexOfChild, f2);
        d dVar = this.c;
        if (dVar != null) {
            dVar.c();
        }
        SpliceScrollView spliceScrollView = this.m;
        if (spliceScrollView != null) {
            spliceScrollView.requestDisallowInterceptTouchEvent(true);
        }
        invalidate();
    }

    private final void O() {
        LayoutTransition layoutTransition = getLayoutTransition();
        this.f2123d = layoutTransition;
        if (layoutTransition != null) {
            setLayoutTransition(null);
        }
        this.f2125f.n();
        d dVar = this.c;
        if (dVar != null) {
            dVar.d();
        }
        requestDisallowInterceptTouchEvent(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(View view, float f2) {
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        final float top = view.getTop() + f2;
        float scaleX = getScaleX();
        long j2 = ((scaleX - 0.54f) / 0.45999998f) * ((float) 300);
        if (j2 < 20) {
            M(this, 0.54f, null, 2, null);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(scaleX, 0.54f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DragLinearLayout.n(DragLinearLayout.this, top, valueAnimator);
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(j2);
        animatorSet2.play(ofFloat);
        this.n = animatorSet2;
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(DragLinearLayout this$0, float f2, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.L(((Float) animatedValue).floatValue(), Float.valueOf(f2));
    }

    private final void o() {
        SpliceScrollView spliceScrollView;
        AnimatorSet animatorSet = this.n;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        float scaleX = getScaleX();
        SpliceScrollView spliceScrollView2 = this.m;
        int scrollY = spliceScrollView2 == null ? 0 : spliceScrollView2.getScrollY();
        Integer d2 = this.f2125f.d();
        long j2 = ((1.0f - scaleX) / 0.45999998f) * ((float) 300);
        ValueAnimator valueAnimator = null;
        if (j2 < 20) {
            M(this, 1.0f, null, 2, null);
            if (d2 != null && (spliceScrollView = this.m) != null) {
                spliceScrollView.setScrollY(d2.intValue());
            }
            setPivotY(getHeight() / 2.0f);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(scaleX, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DragLinearLayout.p(DragLinearLayout.this, valueAnimator2);
            }
        });
        if (d2 != null) {
            valueAnimator = ValueAnimator.ofInt(scrollY, d2.intValue());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.camera360.dynamic_feature_splice.c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    DragLinearLayout.q(DragLinearLayout.this, valueAnimator2);
                }
            });
        }
        ofFloat.addListener(new g());
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(j2);
        if (valueAnimator == null) {
            animatorSet2.play(ofFloat);
        } else {
            animatorSet2.play(ofFloat).with(valueAnimator);
        }
        this.n = animatorSet2;
        animatorSet2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(DragLinearLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        M(this$0, ((Float) animatedValue).floatValue(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DragLinearLayout this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        SpliceScrollView spliceScrollView = this$0.m;
        if (spliceScrollView == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        spliceScrollView.setScrollY(((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long v(float f2) {
        return Math.min(300L, Math.max(150L, (((float) 150) * Math.abs(f2)) / this.o));
    }

    private final void w(int i2) {
        kotlin.z.d u2;
        float f2;
        int b2;
        final SpliceScrollView spliceScrollView = this.m;
        if (spliceScrollView == null) {
            return;
        }
        final int scrollY = spliceScrollView.getScrollY();
        float height = spliceScrollView.getHeight();
        float f3 = height / 4.0f;
        Float k2 = this.f2125f.k();
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        if (k2 != null) {
            float top = (getTop() - scrollY) + ((i2 + k2.floatValue()) * this.q) + (u() == null ? 0 : u2.a());
            if (top < f3) {
                b2 = kotlin.y.c.b((((int) ((-8) * u.b(f3, 0.0f, top))) - 2) * this.r);
            } else {
                b2 = top > height - f3 ? kotlin.y.c.b((((int) (8 * u.b(f2, height, top))) + 2) * this.r) : 0;
            }
            ref$IntRef.element = b2;
            kotlin.z.d u3 = u();
            if (u3 != null) {
                int i3 = ref$IntRef.element;
                int i4 = i3 + scrollY;
                if (i3 < 0) {
                    if (i4 < u3.a()) {
                        ref$IntRef.element = 0;
                    }
                } else if (i3 > 0 && i4 > u3.b()) {
                    ref$IntRef.element = 0;
                }
            }
        }
        spliceScrollView.removeCallbacks(this.p);
        int i5 = ref$IntRef.element;
        if (i5 != 0) {
            spliceScrollView.smoothScrollBy(0, i5);
        }
        Runnable runnable = new Runnable() { // from class: com.camera360.dynamic_feature_splice.f
            @Override // java.lang.Runnable
            public final void run() {
                DragLinearLayout.x(DragLinearLayout.this, scrollY, spliceScrollView, ref$IntRef);
            }
        };
        this.p = runnable;
        spliceScrollView.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(DragLinearLayout this$0, int i2, SpliceScrollView scrollView, Ref$IntRef delta) {
        int b2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(scrollView, "$scrollView");
        kotlin.jvm.internal.s.h(delta, "$delta");
        if (!this$0.f2125f.c() || i2 == scrollView.getScrollY()) {
            return;
        }
        int j2 = this$0.f2125f.j();
        b2 = kotlin.y.c.b(delta.element / this$0.q);
        this$0.F(j2 + b2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.s.h(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.f2125f.a()) {
            canvas.save();
            canvas.translate(0.0f, this.f2125f.j());
            BitmapDrawable m = this.f2125f.m();
            kotlin.jvm.internal.s.e(m);
            m.setAlpha(100);
            BitmapDrawable m2 = this.f2125f.m();
            kotlin.jvm.internal.s.e(m2);
            m2.draw(canvas);
            BitmapDrawable m3 = this.f2125f.m();
            kotlin.jvm.internal.s.e(m3);
            int i2 = m3.getBounds().left;
            BitmapDrawable m4 = this.f2125f.m();
            kotlin.jvm.internal.s.e(m4);
            int i3 = m4.getBounds().right;
            BitmapDrawable m5 = this.f2125f.m();
            kotlin.jvm.internal.s.e(m5);
            int i4 = m5.getBounds().top;
            BitmapDrawable m6 = this.f2125f.m();
            kotlin.jvm.internal.s.e(m6);
            int i5 = m6.getBounds().bottom;
            Drawable drawable = this.f2130k;
            kotlin.jvm.internal.s.e(drawable);
            drawable.setBounds(i2, i5, i3, this.f2131l + i5);
            this.f2130k.draw(canvas);
            Drawable drawable2 = this.f2129j;
            if (drawable2 != null) {
                drawable2.setBounds(i2, i4 - this.f2131l, i3, i4);
                this.f2129j.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int i2;
        kotlin.jvm.internal.s.h(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f2125f.a() && -1 != (i2 = this.f2128i) && Math.abs(event.getY(event.findPointerIndex(i2)) - this.f2127h) > this.f2126g) {
                        O();
                        return true;
                    }
                    return false;
                } else if (action != 3) {
                    if (action == 6 && event.getPointerId(event.getActionIndex()) == this.f2128i) {
                        J();
                        if (this.f2125f.a()) {
                            I();
                        }
                    }
                    return false;
                }
            }
            J();
            if (this.f2125f.a()) {
                I();
            }
            return false;
        } else if (this.f2125f.a()) {
            return false;
        } else {
            this.f2127h = (int) event.getY(0);
            this.f2128i = event.getPointerId(0);
            return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int i2;
        kotlin.jvm.internal.s.h(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f2125f.c() && -1 != (i2 = this.f2128i)) {
                        F(((int) event.getY(event.findPointerIndex(i2))) - this.f2127h);
                        return true;
                    }
                    return false;
                } else if (action != 3) {
                    if (action == 6 && event.getPointerId(event.getActionIndex()) == this.f2128i) {
                        J();
                        if (this.f2125f.c()) {
                            G();
                        } else if (this.f2125f.a()) {
                            I();
                        }
                        return true;
                    }
                    return false;
                }
            }
            J();
            if (this.f2125f.c()) {
                G();
            } else if (this.f2125f.a()) {
                I();
            }
            return true;
        } else if (!this.f2125f.a() || this.f2125f.t()) {
            return false;
        } else {
            O();
            return true;
        }
    }

    public final boolean r() {
        return this.s;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f2124e.clear();
    }

    public final d s() {
        return this.c;
    }

    public final void setContainerScrollView(SpliceScrollView scrollView) {
        kotlin.jvm.internal.s.h(scrollView, "scrollView");
        this.m = scrollView;
    }

    public final void setOnDragStatusChangedListsner(d dVar) {
        this.c = dVar;
    }

    public final void setOnItemSelectedCtrl(e eVar) {
        this.b = eVar;
    }

    public final void setOnSwapListener(f fVar) {
        this.a = fVar;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 0) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("DragLinearLayout must be VERTICAL.");
    }

    public final void setViewDraggable(View child, View dragHandle) {
        kotlin.jvm.internal.s.h(child, "child");
        kotlin.jvm.internal.s.h(dragHandle, "dragHandle");
        if (this == child.getParent()) {
            dragHandle.setOnTouchListener(new b(this, child));
            this.f2124e.put(indexOfChild(child), new c(this));
            return;
        }
        Log.e("DragLinearLayout", kotlin.jvm.internal.s.q(child.toString(), " is not a child, cannot make draggable."));
    }

    public final e t() {
        return this.b;
    }

    public final kotlin.z.d u() {
        return this.t;
    }

    public final boolean y() {
        return this.f2125f.a() || this.f2125f.c();
    }

    public /* synthetic */ DragLinearLayout(Context context, AttributeSet attributeSet, int i2, kotlin.jvm.internal.o oVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }
}
