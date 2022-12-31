package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallPulseIndicator.java */
/* loaded from: classes2.dex */
public class g extends BaseIndicatorController {
    private float[] c = {1.0f, 1.0f, 1.0f};

    /* compiled from: BallPulseIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            g.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {120, 240, BaseBlurEffect.ROTATION_360};
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            arrayList.add(ofFloat);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float min = (Math.min(e(), c()) - 8.0f) / 6.0f;
        float f2 = 2.0f * min;
        float e2 = (e() / 2) - (f2 + 4.0f);
        float c = c() / 2;
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            float f3 = i2;
            canvas.translate((f2 * f3) + e2 + (f3 * 4.0f), c);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.drawCircle(0.0f, 0.0f, min, paint);
            canvas.restore();
        }
    }
}
