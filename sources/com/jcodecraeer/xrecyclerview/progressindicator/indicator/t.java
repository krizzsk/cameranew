package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LineScaleIndicator.java */
/* loaded from: classes2.dex */
public class t extends BaseIndicatorController {
    float[] c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* compiled from: LineScaleIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            t.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            t.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {100, 200, 300, 400, 500};
        for (int i2 = 0; i2 < 5; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(1000L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 11;
        float c = c() / 2;
        for (int i2 = 0; i2 < 5; i2++) {
            canvas.save();
            float f2 = e2 / 2.0f;
            canvas.translate((((i2 * 2) + 2) * e2) - f2, c);
            canvas.scale(1.0f, this.c[i2]);
            canvas.drawRoundRect(new RectF((-e2) / 2.0f, (-c()) / 2.5f, f2, c() / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
