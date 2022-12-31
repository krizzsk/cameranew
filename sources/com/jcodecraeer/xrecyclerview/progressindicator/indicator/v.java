package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LineScalePulseOutIndicator.java */
/* loaded from: classes2.dex */
public class v extends t {

    /* compiled from: LineScalePulseOutIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            v.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            v.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.t, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {500, 250, 0, 250, 500};
        for (int i2 = 0; i2 < 5; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(900L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
