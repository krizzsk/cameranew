package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallBeatIndicator.java */
/* loaded from: classes2.dex */
public class a extends BaseIndicatorController {
    private float[] c = {1.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    int[] f5815d = {255, 255, 255};

    /* compiled from: BallBeatIndicator.java */
    /* renamed from: com.jcodecraeer.xrecyclerview.progressindicator.indicator.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0221a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        C0221a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.g();
        }
    }

    /* compiled from: BallBeatIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f5815d[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            a.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {350, 0, 350};
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.75f, 1.0f);
            ofFloat.setDuration(700L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i2]);
            ofFloat.addUpdateListener(new C0221a(i2));
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 51, 255);
            ofInt.setDuration(700L);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr[i2]);
            ofInt.addUpdateListener(new b(i2));
            ofInt.start();
            arrayList.add(ofFloat);
            arrayList.add(ofInt);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = (e() - 8.0f) / 6.0f;
        float f2 = 2.0f * e2;
        float e3 = (e() / 2) - (f2 + 4.0f);
        float c = c() / 2;
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            float f3 = i2;
            canvas.translate((f2 * f3) + e3 + (f3 * 4.0f), c);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2]);
            paint.setAlpha(this.f5815d[i2]);
            canvas.drawCircle(0.0f, 0.0f, e2, paint);
            canvas.restore();
        }
    }
}
