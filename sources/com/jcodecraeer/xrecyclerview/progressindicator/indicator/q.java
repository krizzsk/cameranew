package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallZigZagDeflectIndicator.java */
/* loaded from: classes2.dex */
public class q extends r {

    /* compiled from: BallZigZagDeflectIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            q.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            q.this.g();
        }
    }

    /* compiled from: BallZigZagDeflectIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            q.this.f5825d[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            q.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.r, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        float e2 = e() / 6;
        float e3 = e() / 6;
        for (int i2 = 0; i2 < 2; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(e2, e() - e2, e2, e() - e2, e2);
            if (i2 == 1) {
                ofFloat = ValueAnimator.ofFloat(e() - e2, e2, e() - e2, e2, e() - e2);
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(e3, e3, c() - e3, c() - e3, e3);
            if (i2 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(c() - e3, c() - e3, e3, e3, c() - e3);
            }
            ofFloat.setDuration(2000L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            ofFloat2.setDuration(2000L);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            ofFloat2.addUpdateListener(new b(i2));
            ofFloat2.start();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        return arrayList;
    }
}
