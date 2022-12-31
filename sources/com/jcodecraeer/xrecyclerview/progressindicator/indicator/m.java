package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallScaleRippleIndicator.java */
/* loaded from: classes2.dex */
public class m extends k {

    /* compiled from: BallScaleRippleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            m.this.g();
        }
    }

    /* compiled from: BallScaleRippleIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            m.this.f5821d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            m.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.k, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(1000L);
        ofInt.setRepeatCount(-1);
        ofInt.addUpdateListener(new b());
        ofInt.start();
        arrayList.add(ofFloat);
        arrayList.add(ofInt);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.k, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        super.b(canvas, paint);
    }
}
