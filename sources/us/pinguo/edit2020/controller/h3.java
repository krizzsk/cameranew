package us.pinguo.edit2020.controller;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.edit2020.viewmodel.module.EditBeautyModule;
/* compiled from: SkinRefreshManualGestureController.kt */
/* loaded from: classes4.dex */
public final class h3 implements e3 {
    private final EditBeautyModule a;
    private final ConstraintLayout b;
    private final us.pinguo.edit2020.view.c0 c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10451d;

    /* renamed from: e  reason: collision with root package name */
    private final ValueAnimator f10452e;

    public h3(EditBeautyModule module, ConstraintLayout fragmentLayout, us.pinguo.edit2020.view.c0 operationLayout) {
        kotlin.jvm.internal.s.h(module, "module");
        kotlin.jvm.internal.s.h(fragmentLayout, "fragmentLayout");
        kotlin.jvm.internal.s.h(operationLayout, "operationLayout");
        this.a = module;
        this.b = fragmentLayout;
        this.c = operationLayout;
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        this.f10451d = us.pinguo.util.h.i(b) - us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f10452e = valueAnimator;
        ((ShapeDirectionView) fragmentLayout.findViewById(R.id.handShapeView)).setSinglePointMode(true);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.controller.o2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                h3.a(h3.this, valueAnimator2);
            }
        });
        valueAnimator.setDuration(100L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(h3 this$0, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        ((MagnifierLayout) this$0.b.findViewById(R.id.flMagnifier)).setTranslationX(((Float) animatedValue).floatValue());
    }

    private final void c(us.pinguo.edit2020.bean.u0 u0Var, float f2, float f3) {
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

    private final void d() {
        ConstraintLayout constraintLayout = this.b;
        int i2 = R.id.flMagnifier;
        ((MagnifierLayout) constraintLayout.findViewById(i2)).setClicked(false);
        this.a.s0(0.5f, 0.5f);
        ((MagnifierLayout) this.b.findViewById(i2)).animate().cancel();
        MagnifierLayout magnifierLayout = (MagnifierLayout) this.b.findViewById(i2);
        kotlin.jvm.internal.s.g(magnifierLayout, "fragmentLayout.flMagnifier");
        magnifierLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(magnifierLayout, 4);
    }

    private final void f() {
        ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setClicked(true);
        this.a.h0();
    }

    @Override // us.pinguo.edit2020.controller.e3
    public boolean b(MotionEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        if (event.getPointerCount() > 1) {
            d();
            return false;
        }
        ((ShapeDirectionView) this.b.findViewById(R.id.handShapeView)).l(event);
        us.pinguo.edit2020.bean.u0 value = this.a.o().getValue();
        if (value == null) {
            return false;
        }
        float h2 = value.h();
        float x = event.getX();
        float y = event.getY();
        float dimension = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.magnifier_width);
        Context b = us.pinguo.foundation.e.b();
        kotlin.jvm.internal.s.g(b, "getAppContext()");
        float b2 = dimension + us.pinguo.util.g.b(b, 30.0f);
        int action = event.getAction();
        if (action == 0) {
            this.c.F(false);
            this.c.u(false);
            if (x <= b2 && y <= b2) {
                ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setTranslationX(this.f10451d);
            } else {
                ((MagnifierLayout) this.b.findViewById(R.id.flMagnifier)).setTranslationX(0.0f);
            }
            c(value, x, y);
            f();
        } else if (action == 1) {
            this.c.F(true);
            this.c.u(true);
            d();
        } else if (action == 2) {
            ConstraintLayout constraintLayout = this.b;
            int i2 = R.id.flMagnifier;
            boolean z = ((MagnifierLayout) constraintLayout.findViewById(i2)).getTranslationX() == 0.0f;
            boolean z2 = ((MagnifierLayout) this.b.findViewById(i2)).getTranslationX() == this.f10451d;
            if (x <= b2 && y <= b2 && z) {
                if (!this.f10452e.isStarted()) {
                    this.f10452e.setFloatValues(0.0f, this.f10451d);
                    this.f10452e.start();
                }
            } else if (x >= h2 - b2 && y <= b2 && z2 && !this.f10452e.isStarted()) {
                this.f10452e.setFloatValues(this.f10451d, 0.0f);
                this.f10452e.start();
            }
            c(value, x, y);
        }
        return true;
    }
}
