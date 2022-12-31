package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallGridBeatIndicator.java */
/* loaded from: classes2.dex */
public class e extends BaseIndicatorController {
    int[] c = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    /* compiled from: BallGridBeatIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e.this.c[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            e.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {960, 930, 1190, 1130, 1340, 940, 1200, 820, 1190};
        int[] iArr2 = {BaseBlurEffect.ROTATION_360, 400, 680, 410, 710, -150, -120, 10, 320};
        for (int i2 = 0; i2 < 9; i2++) {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 168, 255);
            ofInt.setDuration(iArr[i2]);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr2[i2]);
            ofInt.addUpdateListener(new a(i2));
            ofInt.start();
            arrayList.add(ofInt);
        }
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = (e() - 16.0f) / 6.0f;
        float f2 = 2.0f * e2;
        float f3 = f2 + 4.0f;
        float e3 = (e() / 2) - f3;
        float e4 = (e() / 2) - f3;
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                canvas.save();
                float f4 = i3;
                float f5 = (f2 * f4) + e3 + (f4 * 4.0f);
                float f6 = i2;
                canvas.translate(f5, (f2 * f6) + e4 + (f6 * 4.0f));
                paint.setAlpha(this.c[(i2 * 3) + i3]);
                canvas.drawCircle(0.0f, 0.0f, e2, paint);
                canvas.restore();
            }
        }
    }
}
