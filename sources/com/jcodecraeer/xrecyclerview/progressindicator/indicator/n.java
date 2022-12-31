package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallScaleRippleMultipleIndicator.java */
/* loaded from: classes2.dex */
public class n extends l {

    /* compiled from: BallScaleRippleMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            n.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            n.this.g();
        }
    }

    /* compiled from: BallScaleRippleMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            n.this.f5822d[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            n.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.l, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {0, 200, 400};
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.setStartDelay(jArr[i2]);
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 255);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(1000L);
            ofInt.setRepeatCount(-1);
            ofInt.addUpdateListener(new b(i2));
            ofFloat.setStartDelay(jArr[i2]);
            ofInt.start();
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.l, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        super.b(canvas, paint);
    }
}
