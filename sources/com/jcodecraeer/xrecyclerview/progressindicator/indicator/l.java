package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallScaleMultipleIndicator.java */
/* loaded from: classes2.dex */
public class l extends BaseIndicatorController {
    float[] c = {1.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    int[] f5822d = {255, 255, 255};

    /* compiled from: BallScaleMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            l.this.g();
        }
    }

    /* compiled from: BallScaleMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            l.this.f5822d[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            l.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
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
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            ofInt.setInterpolator(new LinearInterpolator());
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

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        for (int i2 = 0; i2 < 3; i2++) {
            paint.setAlpha(this.f5822d[i2]);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2], e() / 2, c() / 2);
            canvas.drawCircle(e() / 2, c() / 2, (e() / 2) - 4.0f, paint);
        }
    }
}
