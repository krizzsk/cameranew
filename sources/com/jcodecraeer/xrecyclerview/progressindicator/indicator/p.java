package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallTrianglePathIndicator.java */
/* loaded from: classes2.dex */
public class p extends BaseIndicatorController {
    float[] c = new float[3];

    /* renamed from: d  reason: collision with root package name */
    float[] f5824d = new float[3];

    /* compiled from: BallTrianglePathIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            p.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            p.this.g();
        }
    }

    /* compiled from: BallTrianglePathIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            p.this.f5824d[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            p.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        float e2 = e() / 5;
        float e3 = e() / 5;
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(e() / 2, e() - e2, e2, e() / 2);
            if (i2 == 1) {
                ofFloat = ValueAnimator.ofFloat(e() - e2, e2, e() / 2, e() - e2);
            } else if (i2 == 2) {
                ofFloat = ValueAnimator.ofFloat(e2, e() / 2, e() - e2, e2);
            }
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(e3, c() - e3, c() - e3, e3);
            if (i2 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(c() - e3, c() - e3, e3, c() - e3);
            } else if (i2 == 2) {
                ofFloat2 = ValueAnimator.ofFloat(c() - e3, e3, c() - e3, c() - e3);
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

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            canvas.translate(this.c[i2], this.f5824d[i2]);
            canvas.drawCircle(0.0f, 0.0f, e() / 10, paint);
            canvas.restore();
        }
    }
}
