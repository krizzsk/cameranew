package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CubeTransitionIndicator.java */
/* loaded from: classes2.dex */
public class s extends BaseIndicatorController {

    /* renamed from: e  reason: collision with root package name */
    float f5827e;
    float[] c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    float[] f5826d = new float[2];

    /* renamed from: f  reason: collision with root package name */
    float f5828f = 1.0f;

    /* compiled from: CubeTransitionIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            s.this.g();
        }
    }

    /* compiled from: CubeTransitionIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s.this.f5826d[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            s.this.g();
        }
    }

    /* compiled from: CubeTransitionIndicator.java */
    /* loaded from: classes2.dex */
    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s.this.f5828f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            s.this.g();
        }
    }

    /* compiled from: CubeTransitionIndicator.java */
    /* loaded from: classes2.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            s.this.f5827e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            s.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        float e2 = e() / 5;
        float c2 = c() / 5;
        for (int i2 = 0; i2 < 2; i2++) {
            this.c[i2] = e2;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(e2, e() - e2, e() - e2, e2, e2);
            if (i2 == 1) {
                ofFloat = ValueAnimator.ofFloat(e() - e2, e2, e2, e() - e2, e() - e2);
            }
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(1600L);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            this.f5826d[i2] = c2;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(c2, c2, c() - c2, c() - c2, c2);
            if (i2 == 1) {
                ofFloat2 = ValueAnimator.ofFloat(c() - c2, c() - c2, c2, c2, c() - c2);
            }
            ofFloat2.setDuration(1600L);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setRepeatCount(-1);
            ofFloat2.addUpdateListener(new b(i2));
            ofFloat2.start();
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.5f, 1.0f, 0.5f, 1.0f);
        ofFloat3.setDuration(1600L);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.setRepeatCount(-1);
        ofFloat3.addUpdateListener(new c());
        ofFloat3.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 180.0f, 360.0f, 540.0f, 720.0f);
        ofFloat4.setDuration(1600L);
        ofFloat4.setInterpolator(new LinearInterpolator());
        ofFloat4.setRepeatCount(-1);
        ofFloat4.addUpdateListener(new d());
        ofFloat4.start();
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 5;
        float c2 = c() / 5;
        for (int i2 = 0; i2 < 2; i2++) {
            canvas.save();
            canvas.translate(this.c[i2], this.f5826d[i2]);
            canvas.rotate(this.f5827e);
            float f2 = this.f5828f;
            canvas.scale(f2, f2);
            canvas.drawRect(new RectF((-e2) / 2.0f, (-c2) / 2.0f, e2 / 2.0f, c2 / 2.0f), paint);
            canvas.restore();
        }
    }
}
