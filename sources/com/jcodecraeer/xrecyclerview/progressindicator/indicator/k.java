package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallScaleIndicator.java */
/* loaded from: classes2.dex */
public class k extends BaseIndicatorController {
    float c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    int f5821d = 255;

    /* compiled from: BallScaleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            k.this.g();
        }
    }

    /* compiled from: BallScaleIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k.this.f5821d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            k.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(1000L);
        ofInt.setRepeatCount(-1);
        ofInt.addUpdateListener(new b());
        ofInt.start();
        arrayList.add(ofFloat);
        arrayList.add(ofInt);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setAlpha(this.f5821d);
        float f2 = this.c;
        canvas.scale(f2, f2, e() / 2, c() / 2);
        paint.setAlpha(this.f5821d);
        canvas.drawCircle(e() / 2, c() / 2, (e() / 2) - 4.0f, paint);
    }
}
