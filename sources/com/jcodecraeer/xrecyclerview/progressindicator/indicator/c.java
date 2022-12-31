package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallClipRotateMultipleIndicator.java */
/* loaded from: classes2.dex */
public class c extends BaseIndicatorController {
    float c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    float f5817d;

    /* compiled from: BallClipRotateMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            c.this.g();
        }
    }

    /* compiled from: BallClipRotateMultipleIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f5817d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            c.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.6f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.addUpdateListener(new b());
        ofFloat2.start();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        float e2 = e() / 2;
        float c = c() / 2;
        canvas.save();
        canvas.translate(e2, c);
        float f2 = this.c;
        canvas.scale(f2, f2);
        canvas.rotate(this.f5817d);
        float[] fArr = {135.0f, -45.0f};
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.drawArc(new RectF((-e2) + 12.0f, (-c) + 12.0f, e2 - 12.0f, c - 12.0f), fArr[i2], 90.0f, false, paint);
        }
        canvas.restore();
        canvas.translate(e2, c);
        float f3 = this.c;
        canvas.scale(f3, f3);
        canvas.rotate(-this.f5817d);
        float[] fArr2 = {225.0f, 45.0f};
        for (int i3 = 0; i3 < 2; i3++) {
            canvas.drawArc(new RectF(((-e2) / 1.8f) + 12.0f, ((-c) / 1.8f) + 12.0f, (e2 / 1.8f) - 12.0f, (c / 1.8f) - 12.0f), fArr2[i3], 90.0f, false, paint);
        }
    }
}
