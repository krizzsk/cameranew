package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: PacmanIndicator.java */
/* loaded from: classes2.dex */
public class y extends BaseIndicatorController {
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private int f5829d;

    /* renamed from: e  reason: collision with root package name */
    private float f5830e;

    /* renamed from: f  reason: collision with root package name */
    private float f5831f;

    /* compiled from: PacmanIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            y.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            y.this.g();
        }
    }

    /* compiled from: PacmanIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            y.this.f5829d = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            y.this.g();
        }
    }

    /* compiled from: PacmanIndicator.java */
    /* loaded from: classes2.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            y.this.f5830e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            y.this.g();
        }
    }

    /* compiled from: PacmanIndicator.java */
    /* loaded from: classes2.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            y.this.f5831f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            y.this.g();
        }
    }

    private void n(Canvas canvas, Paint paint) {
        paint.setAlpha(this.f5829d);
        canvas.drawCircle(this.c, c() / 2, e() / 11, paint);
    }

    private void o(Canvas canvas, Paint paint) {
        float e2 = e() / 2;
        float c2 = c() / 2;
        canvas.save();
        canvas.translate(e2, c2);
        canvas.rotate(this.f5830e);
        paint.setAlpha(255);
        float f2 = (-e2) / 1.7f;
        float f3 = (-c2) / 1.7f;
        float f4 = e2 / 1.7f;
        float f5 = c2 / 1.7f;
        canvas.drawArc(new RectF(f2, f3, f4, f5), 0.0f, 270.0f, true, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(e2, c2);
        canvas.rotate(this.f5831f);
        paint.setAlpha(255);
        canvas.drawArc(new RectF(f2, f3, f4, f5), 90.0f, 270.0f, true, paint);
        canvas.restore();
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(e() - (e() / 11), e() / 2);
        ofFloat.setDuration(650L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(255, 122);
        ofInt.setDuration(650L);
        ofInt.setRepeatCount(-1);
        ofInt.addUpdateListener(new b());
        ofInt.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 45.0f, 0.0f);
        ofFloat2.setDuration(650L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.addUpdateListener(new c());
        ofFloat2.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, -45.0f, 0.0f);
        ofFloat3.setDuration(650L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.addUpdateListener(new d());
        ofFloat3.start();
        arrayList.add(ofFloat);
        arrayList.add(ofInt);
        arrayList.add(ofFloat2);
        arrayList.add(ofFloat3);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        o(canvas, paint);
        n(canvas, paint);
    }
}
