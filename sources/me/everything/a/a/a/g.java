package me.everything.a.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
/* compiled from: OverScrollBounceEffectDecoratorBase.java */
/* loaded from: classes9.dex */
public abstract class g implements me.everything.a.a.a.b, View.OnTouchListener {
    protected final me.everything.a.a.a.h.a b;
    protected final d c;

    /* renamed from: d  reason: collision with root package name */
    protected final C0326g f8851d;

    /* renamed from: e  reason: collision with root package name */
    protected final b f8852e;

    /* renamed from: f  reason: collision with root package name */
    protected c f8853f;

    /* renamed from: i  reason: collision with root package name */
    protected float f8856i;
    protected final f a = new f();

    /* renamed from: g  reason: collision with root package name */
    protected me.everything.a.a.a.c f8854g = new me.everything.a.a.a.e();

    /* renamed from: h  reason: collision with root package name */
    protected me.everything.a.a.a.d f8855h = new me.everything.a.a.a.f();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public static abstract class a {
        public Property<View, Float> a;
        public float b;
        public float c;

        protected abstract void a(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public class b implements c, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
        protected final Interpolator a = new DecelerateInterpolator();
        protected final float b;
        protected final float c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f8857d;

        public b(float f2) {
            this.b = f2;
            this.c = f2 * 2.0f;
            this.f8857d = g.this.c();
        }

        @Override // me.everything.a.a.a.g.c
        public boolean a(MotionEvent motionEvent) {
            return true;
        }

        @Override // me.everything.a.a.a.g.c
        public int b() {
            return 3;
        }

        @Override // me.everything.a.a.a.g.c
        public void c(c cVar) {
            g gVar = g.this;
            gVar.f8854g.onOverScrollStateChange(gVar, cVar.b(), b());
            Animator e2 = e();
            e2.addListener(this);
            e2.start();
        }

        @Override // me.everything.a.a.a.g.c
        public boolean d(MotionEvent motionEvent) {
            return true;
        }

        protected Animator e() {
            View view = g.this.b.getView();
            this.f8857d.a(view);
            g gVar = g.this;
            float f2 = gVar.f8856i;
            if (f2 != 0.0f && ((f2 >= 0.0f || !gVar.a.c) && (f2 <= 0.0f || gVar.a.c))) {
                float f3 = (-f2) / this.b;
                float f4 = f3 >= 0.0f ? f3 : 0.0f;
                float f5 = this.f8857d.b + (((-f2) * f2) / this.c);
                ObjectAnimator g2 = g(view, (int) f4, f5);
                ObjectAnimator f6 = f(f5);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(g2, f6);
                return animatorSet;
            }
            return f(this.f8857d.b);
        }

        protected ObjectAnimator f(float f2) {
            View view = g.this.b.getView();
            float abs = Math.abs(f2);
            a aVar = this.f8857d;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, aVar.a, g.this.a.b);
            ofFloat.setDuration(Math.max((int) ((abs / aVar.c) * 800.0f), 200));
            ofFloat.setInterpolator(this.a);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        protected ObjectAnimator g(View view, int i2, float f2) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, this.f8857d.a, f2);
            ofFloat.setDuration(i2);
            ofFloat.setInterpolator(this.a);
            ofFloat.addUpdateListener(this);
            return ofFloat;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            gVar.f(gVar.c);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g gVar = g.this;
            gVar.f8855h.a(gVar, 3, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public interface c {
        boolean a(MotionEvent motionEvent);

        int b();

        void c(c cVar);

        boolean d(MotionEvent motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public class d implements c {
        final e a;

        public d() {
            this.a = g.this.d();
        }

        @Override // me.everything.a.a.a.g.c
        public boolean a(MotionEvent motionEvent) {
            return false;
        }

        @Override // me.everything.a.a.a.g.c
        public int b() {
            return 0;
        }

        @Override // me.everything.a.a.a.g.c
        public void c(c cVar) {
            g gVar = g.this;
            gVar.f8854g.onOverScrollStateChange(gVar, cVar.b(), b());
        }

        @Override // me.everything.a.a.a.g.c
        public boolean d(MotionEvent motionEvent) {
            if (this.a.a(g.this.b.getView(), motionEvent)) {
                if (!(g.this.b.b() && this.a.c) && (!g.this.b.a() || this.a.c)) {
                    return false;
                }
                g.this.a.a = motionEvent.getPointerId(0);
                g gVar = g.this;
                f fVar = gVar.a;
                e eVar = this.a;
                fVar.b = eVar.a;
                fVar.c = eVar.c;
                gVar.f(gVar.f8851d);
                return g.this.f8851d.d(motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public static abstract class e {
        public float a;
        public float b;
        public boolean c;

        protected abstract boolean a(View view, MotionEvent motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* loaded from: classes9.dex */
    public static class f {
        protected int a;
        protected float b;
        protected boolean c;

        protected f() {
        }
    }

    /* compiled from: OverScrollBounceEffectDecoratorBase.java */
    /* renamed from: me.everything.a.a.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    protected class C0326g implements c {
        protected final float a;
        protected final float b;
        final e c;

        /* renamed from: d  reason: collision with root package name */
        int f8859d;

        public C0326g(float f2, float f3) {
            this.c = g.this.d();
            this.a = f2;
            this.b = f3;
        }

        @Override // me.everything.a.a.a.g.c
        public boolean a(MotionEvent motionEvent) {
            g gVar = g.this;
            gVar.f(gVar.f8852e);
            return false;
        }

        @Override // me.everything.a.a.a.g.c
        public int b() {
            return this.f8859d;
        }

        @Override // me.everything.a.a.a.g.c
        public void c(c cVar) {
            g gVar = g.this;
            this.f8859d = gVar.a.c ? 1 : 2;
            gVar.f8854g.onOverScrollStateChange(gVar, cVar.b(), b());
        }

        @Override // me.everything.a.a.a.g.c
        public boolean d(MotionEvent motionEvent) {
            if (g.this.a.a != motionEvent.getPointerId(0)) {
                g gVar = g.this;
                gVar.f(gVar.f8852e);
                return true;
            }
            View view = g.this.b.getView();
            if (this.c.a(view, motionEvent)) {
                e eVar = this.c;
                float f2 = eVar.b;
                boolean z = eVar.c;
                g gVar2 = g.this;
                f fVar = gVar2.a;
                boolean z2 = fVar.c;
                float f3 = f2 / (z == z2 ? this.a : this.b);
                float f4 = eVar.a + f3;
                if ((z2 && !z && f4 <= fVar.b) || (!z2 && z && f4 >= fVar.b)) {
                    gVar2.h(view, fVar.b, motionEvent);
                    g gVar3 = g.this;
                    gVar3.f8855h.a(gVar3, this.f8859d, 0.0f);
                    g gVar4 = g.this;
                    gVar4.f(gVar4.c);
                    return true;
                }
                if (view.getParent() != null) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                }
                long eventTime = motionEvent.getEventTime() - motionEvent.getHistoricalEventTime(0);
                if (eventTime > 0) {
                    g.this.f8856i = f3 / ((float) eventTime);
                }
                g.this.g(view, f4);
                g gVar5 = g.this;
                gVar5.f8855h.a(gVar5, this.f8859d, f4);
                return true;
            }
            return true;
        }
    }

    public g(me.everything.a.a.a.h.a aVar, float f2, float f3, float f4) {
        this.b = aVar;
        this.f8852e = new b(f2);
        this.f8851d = new C0326g(f3, f4);
        d dVar = new d();
        this.c = dVar;
        this.f8853f = dVar;
        b();
    }

    @Override // me.everything.a.a.a.b
    public void a(me.everything.a.a.a.c cVar) {
        if (cVar == null) {
            cVar = new me.everything.a.a.a.e();
        }
        this.f8854g = cVar;
    }

    protected void b() {
        e().setOnTouchListener(this);
        e().setOverScrollMode(2);
    }

    protected abstract a c();

    protected abstract e d();

    public View e() {
        return this.b.getView();
    }

    protected void f(c cVar) {
        c cVar2 = this.f8853f;
        this.f8853f = cVar;
        cVar.c(cVar2);
    }

    protected abstract void g(View view, float f2);

    protected abstract void h(View view, float f2, MotionEvent motionEvent);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                return this.f8853f.d(motionEvent);
            }
            if (action != 3) {
                return false;
            }
        }
        return this.f8853f.a(motionEvent);
    }
}
