package us.pinguo.edit2020.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Objects;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.view.MagnifierLayout;
import us.pinguo.edit2020.view.MagnifierView;
import us.pinguo.edit2020.view.ShapeDirectionView;
import us.pinguo.foundation.utils.n0;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: MagnifierUtils.kt */
/* loaded from: classes4.dex */
public final class g {
    private final ShapeDirectionView a;
    private final MagnifierLayout b;
    private f c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10580d;

    /* renamed from: e  reason: collision with root package name */
    private final float f10581e;

    /* renamed from: f  reason: collision with root package name */
    private final ValueAnimator f10582f;

    public g(ShapeDirectionView handIndicatorView, MagnifierLayout flMagnifier) {
        s.h(handIndicatorView, "handIndicatorView");
        s.h(flMagnifier, "flMagnifier");
        this.a = handIndicatorView;
        this.b = flMagnifier;
        this.f10580d = true;
        n0.i();
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f10582f = valueAnimator;
        Context context = us.pinguo.foundation.e.b();
        s.g(context, "context");
        this.f10581e = us.pinguo.util.h.i(context) - context.getResources().getDimension(R.dimen.magnifier_width);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.utils.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                g.a(g.this, valueAnimator2);
            }
        });
        valueAnimator.setDuration(100L);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(g this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        MagnifierLayout magnifierLayout = this$0.b;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        magnifierLayout.setTranslationX(((Float) animatedValue).floatValue());
    }

    private final void b(u0 u0Var, float f2, float f3) {
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
        ((MagnifierView) this.b.a(R.id.magnifierView)).b(f5, f4);
    }

    private final void i(float f2, float f3) {
        u0 a;
        float floatValue;
        float floatValue2;
        u0 a2;
        Context context = us.pinguo.foundation.e.b();
        f fVar = this.c;
        Float f4 = null;
        Float valueOf = (fVar == null || (a = fVar.a()) == null) ? null : Float.valueOf(a.h());
        if (valueOf == null) {
            s.g(context, "context");
            floatValue = us.pinguo.util.h.i(context);
        } else {
            floatValue = valueOf.floatValue();
        }
        f fVar2 = this.c;
        if (fVar2 != null && (a2 = fVar2.a()) != null) {
            f4 = Float.valueOf(a2.g());
        }
        if (f4 == null) {
            s.g(context, "context");
            floatValue2 = us.pinguo.util.h.g(context);
        } else {
            floatValue2 = f4.floatValue();
        }
        UnityEditCaller.Common.INSTANCE.setMagnifierPosition(f2 / floatValue, 1 - (f3 / floatValue2));
    }

    private final void l(boolean z) {
        this.b.setClicked(true);
        if (z) {
            this.b.setAlpha(1.0f);
            MagnifierLayout magnifierLayout = this.b;
            magnifierLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(magnifierLayout, 0);
            f fVar = this.c;
            if (fVar == null) {
                return;
            }
            fVar.b();
        }
    }

    static /* synthetic */ void m(g gVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        gVar.l(z);
    }

    public final void c() {
        UnityEditCaller.Common.INSTANCE.setMagnifierPosition(0.5f, 0.5f);
        this.b.setClicked(false);
        this.b.animate().cancel();
        MagnifierLayout magnifierLayout = this.b;
        magnifierLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(magnifierLayout, 4);
        ((MagnifierView) this.b.a(R.id.magnifierView)).b(0.0f, 0.0f);
    }

    public final boolean d(u0 canvasStatus, float f2, float f3) {
        s.h(canvasStatus, "canvasStatus");
        float h2 = canvasStatus.h();
        float g2 = canvasStatus.g();
        float e2 = canvasStatus.e();
        float d2 = canvasStatus.d();
        float a = canvasStatus.a();
        float b = canvasStatus.b();
        return f2 >= ((h2 - e2) * 0.5f) + a && f2 <= ((h2 + e2) * 0.5f) + a && f3 >= ((g2 - d2) * 0.5f) - b && f3 <= ((g2 + d2) * 0.5f) - b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        if (r5 != 5) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(us.pinguo.edit2020.bean.u0 r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.utils.g.f(us.pinguo.edit2020.bean.u0, android.view.MotionEvent):boolean");
    }

    public final void g(boolean z) {
        this.f10580d = z;
    }

    public final void h(f fVar) {
        this.c = fVar;
    }

    public final void j(l<? super ShapeDirectionView, u> initHandIndicator) {
        s.h(initHandIndicator, "initHandIndicator");
        initHandIndicator.invoke(this.a);
    }

    public final void k(l<? super MagnifierLayout, u> initMagnifierLayout) {
        s.h(initMagnifierLayout, "initMagnifierLayout");
        initMagnifierLayout.invoke(this.b);
    }

    public final void n(float f2) {
        this.a.setIndicatorSize(f2);
    }

    public final void o(float f2) {
        ((MagnifierView) this.b.a(R.id.magnifierView)).setSize(f2);
    }
}
