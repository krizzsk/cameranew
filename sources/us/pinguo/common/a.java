package us.pinguo.common;

import android.content.Context;
import android.widget.EdgeEffect;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.s;
/* compiled from: BounceEdgeEffect.kt */
/* loaded from: classes4.dex */
public final class a extends RecyclerView.EdgeEffectFactory {
    @Override // androidx.recyclerview.widget.RecyclerView.EdgeEffectFactory
    protected EdgeEffect createEdgeEffect(RecyclerView view, int i2) {
        s.h(view, "view");
        return new C0373a(new SpringAnimation(view, DynamicAnimation.TRANSLATION_X).setSpring(new SpringForce().setFinalPosition(0.0f).setDampingRatio(1.0f).setStiffness(200.0f)), i2, view, view.getContext());
    }

    /* compiled from: BounceEdgeEffect.kt */
    /* renamed from: us.pinguo.common.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0373a extends EdgeEffect {
        final /* synthetic */ SpringAnimation a;
        final /* synthetic */ int b;
        final /* synthetic */ RecyclerView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0373a(SpringAnimation springAnimation, int i2, RecyclerView recyclerView, Context context) {
            super(context);
            this.a = springAnimation;
            this.b = i2;
            this.c = recyclerView;
        }

        private final void a(float f2) {
            int i2 = this.b == 2 ? -1 : 1;
            this.a.cancel();
            RecyclerView recyclerView = this.c;
            recyclerView.setTranslationX(recyclerView.getTranslationX() + (i2 * this.c.getWidth() * f2 * 0.6f));
        }

        @Override // android.widget.EdgeEffect
        public void onAbsorb(int i2) {
            super.onAbsorb(i2);
            this.a.setStartVelocity((this.b == 2 ? -1 : 1) * i2 * 1.0f).start();
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f2, float f3) {
            super.onPull(f2, f3);
            if (this.a.isRunning()) {
                return;
            }
            a(f2);
        }

        @Override // android.widget.EdgeEffect
        public void onRelease() {
            super.onRelease();
            this.a.start();
        }

        @Override // android.widget.EdgeEffect
        public void onPull(float f2) {
            super.onPull(f2);
            if (this.a.isRunning()) {
                return;
            }
            a(f2);
        }
    }
}
