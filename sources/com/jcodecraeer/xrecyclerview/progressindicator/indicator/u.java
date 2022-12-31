package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LineScalePartyIndicator.java */
/* loaded from: classes2.dex */
public class u extends BaseIndicatorController {
    float[] c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* compiled from: LineScalePartyIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            u.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            u.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        long[] jArr = {1260, 430, 1010, 730};
        long[] jArr2 = {770, 290, 280, 740};
        for (int i2 = 0; i2 < 4; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.4f, 1.0f);
            ofFloat.setDuration(jArr[i2]);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr2[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 9;
        float c = c() / 2;
        for (int i2 = 0; i2 < 4; i2++) {
            canvas.save();
            float f2 = e2 / 2.0f;
            canvas.translate((((i2 * 2) + 2) * e2) - f2, c);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.drawRoundRect(new RectF((-e2) / 2.0f, (-c()) / 2.5f, f2, c() / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
