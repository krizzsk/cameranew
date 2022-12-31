package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LineScalePulseOutRapidIndicator.java */
/* loaded from: classes2.dex */
public class w extends t {

    /* compiled from: LineScalePulseOutRapidIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            w.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            w.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.t, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {400, 200, 0, 200, 400};
        for (int i2 = 0; i2 < 5; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
