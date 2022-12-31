package us.pinguo.widget.discreteseekbar.internal.a;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import us.pinguo.widget.discreteseekbar.internal.a.a;
/* compiled from: AnimatorCompatV11.java */
@TargetApi(11)
/* loaded from: classes6.dex */
public class b extends us.pinguo.widget.discreteseekbar.internal.a.a {
    ValueAnimator a;

    /* compiled from: AnimatorCompatV11.java */
    /* loaded from: classes6.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ a.InterfaceC0467a a;

        a(b bVar, a.InterfaceC0467a interfaceC0467a) {
            this.a = interfaceC0467a;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public b(float f2, float f3, a.InterfaceC0467a interfaceC0467a) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        this.a = ofFloat;
        ofFloat.addUpdateListener(new a(this, interfaceC0467a));
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.a.a
    public void a() {
        this.a.cancel();
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.a.a
    public boolean c() {
        return this.a.isRunning();
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.a.a
    public void d(int i2) {
        this.a.setDuration(i2);
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.a.a
    public void e() {
        this.a.start();
    }
}
