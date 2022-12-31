package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallSpinFadeLoaderIndicator.java */
/* loaded from: classes2.dex */
public class o extends BaseIndicatorController {
    float[] c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    int[] f5823d = {255, 255, 255, 255, 255, 255, 255, 255};

    /* compiled from: BallSpinFadeLoaderIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            o.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            o.this.g();
        }
    }

    /* compiled from: BallSpinFadeLoaderIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            o.this.f5823d[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            o.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BallSpinFadeLoaderIndicator.java */
    /* loaded from: classes2.dex */
    public final class c {
        public float a;
        public float b;

        public c(o oVar, float f2, float f3) {
            this.a = f2;
            this.b = f3;
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {0, 120, 240, BaseBlurEffect.ROTATION_360, 480, 600, 720, 780, 840};
        for (int i2 = 0; i2 < 8; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 77, 255);
            ofInt.setDuration(1000L);
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
        float e2 = e() / 10;
        for (int i2 = 0; i2 < 8; i2++) {
            canvas.save();
            c j2 = j(e(), c(), (e() / 2) - e2, 0.7853981633974483d * i2);
            canvas.translate(j2.a, j2.b);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2]);
            paint.setAlpha(this.f5823d[i2]);
            canvas.drawCircle(0.0f, 0.0f, e2, paint);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(int i2, int i3, float f2, double d2) {
        double d3 = f2;
        return new c(this, (float) ((i2 / 2) + (Math.cos(d2) * d3)), (float) ((i3 / 2) + (d3 * Math.sin(d2))));
    }
}
