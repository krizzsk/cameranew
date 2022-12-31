package com.facebook.drawee.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.ViewGroup;
import com.facebook.drawee.drawable.p;
import javax.annotation.Nullable;
/* compiled from: DraweeTransition.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class c extends Transition {
    private final p.c a;
    private final p.c b;
    @Nullable
    private final PointF c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final PointF f2612d;

    /* compiled from: DraweeTransition.java */
    /* loaded from: classes.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ p.b a;

        a(c cVar, p.b bVar) {
            this.a = bVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: DraweeTransition.java */
    /* loaded from: classes.dex */
    class b extends AnimatorListenerAdapter {
        final /* synthetic */ GenericDraweeView a;

        b(GenericDraweeView genericDraweeView) {
            this.a = genericDraweeView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.e().u(c.this.b);
            if (c.this.f2612d != null) {
                this.a.e().t(c.this.f2612d);
            }
        }
    }

    public c(p.c cVar, p.c cVar2, @Nullable PointF pointF, @Nullable PointF pointF2) {
        this.a = cVar;
        this.b = cVar2;
        this.c = pointF;
        this.f2612d = pointF2;
    }

    private void c(TransitionValues transitionValues) {
        if (transitionValues.view instanceof GenericDraweeView) {
            transitionValues.values.put("draweeTransition:bounds", new Rect(0, 0, transitionValues.view.getWidth(), transitionValues.view.getHeight()));
        }
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        c(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        c(transitionValues);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues != null && transitionValues2 != null) {
            Rect rect = (Rect) transitionValues.values.get("draweeTransition:bounds");
            Rect rect2 = (Rect) transitionValues2.values.get("draweeTransition:bounds");
            if (rect != null && rect2 != null) {
                if (this.a == this.b && this.c == this.f2612d) {
                    return null;
                }
                GenericDraweeView genericDraweeView = (GenericDraweeView) transitionValues.view;
                p.b bVar = new p.b(this.a, this.b, rect, rect2, this.c, this.f2612d);
                genericDraweeView.e().u(bVar);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.addUpdateListener(new a(this, bVar));
                ofFloat.addListener(new b(genericDraweeView));
                return ofFloat;
            }
        }
        return null;
    }

    public c(p.c cVar, p.c cVar2) {
        this(cVar, cVar2, null, null);
    }
}
