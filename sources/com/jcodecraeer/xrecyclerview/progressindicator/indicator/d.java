package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallClipRotatePulseIndicator.java */
/* loaded from: classes2.dex */
public class d extends BaseIndicatorController {
    float c;

    /* renamed from: d  reason: collision with root package name */
    float f5818d;

    /* renamed from: e  reason: collision with root package name */
    float f5819e;

    /* compiled from: BallClipRotatePulseIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.g();
        }
    }

    /* compiled from: BallClipRotatePulseIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f5818d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.g();
        }
    }

    /* compiled from: BallClipRotatePulseIndicator.java */
    /* loaded from: classes2.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f5819e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.6f, 1.0f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.addUpdateListener(new b());
        ofFloat2.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f);
        ofFloat3.setDuration(1000L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.addUpdateListener(new c());
        ofFloat3.start();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 2;
        float c2 = c() / 2;
        canvas.save();
        canvas.translate(e2, c2);
        float f2 = this.c;
        canvas.scale(f2, f2);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0.0f, 0.0f, e2 / 2.5f, paint);
        canvas.restore();
        canvas.translate(e2, c2);
        float f3 = this.f5818d;
        canvas.scale(f3, f3);
        canvas.rotate(this.f5819e);
        paint.setStrokeWidth(3.0f);
        paint.setStyle(Paint.Style.STROKE);
        float[] fArr = {225.0f, 45.0f};
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.drawArc(new RectF((-e2) + 12.0f, (-c2) + 12.0f, e2 - 12.0f, c2 - 12.0f), fArr[i2], 90.0f, false, paint);
        }
    }
}
