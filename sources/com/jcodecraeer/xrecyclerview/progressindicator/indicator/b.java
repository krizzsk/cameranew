package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallClipRotateIndicator.java */
/* loaded from: classes2.dex */
public class b extends BaseIndicatorController {
    float c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    float f5816d;

    /* compiled from: BallClipRotateIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.g();
        }
    }

    /* compiled from: BallClipRotateIndicator.java */
    /* renamed from: com.jcodecraeer.xrecyclerview.progressindicator.indicator.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0222b implements ValueAnimator.AnimatorUpdateListener {
        C0222b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f5816d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.6f, 0.5f, 1.0f);
        ofFloat.setDuration(750L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f);
        ofFloat2.setDuration(750L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.addUpdateListener(new C0222b());
        ofFloat2.start();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        float e2 = e() / 2;
        float c = c() / 2;
        canvas.translate(e2, c);
        float f2 = this.c;
        canvas.scale(f2, f2);
        canvas.rotate(this.f5816d);
        canvas.drawArc(new RectF((-e2) + 12.0f, (-c) + 12.0f, (e2 + 0.0f) - 12.0f, (c + 0.0f) - 12.0f), -45.0f, 270.0f, false, paint);
    }
}
