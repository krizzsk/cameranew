package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallRotateIndicator.java */
/* loaded from: classes2.dex */
public class j extends BaseIndicatorController {
    float c = 0.5f;

    /* compiled from: BallRotateIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.this.c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            j.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f, 0.5f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(d(), Key.ROTATION, 0.0f, 180.0f, 360.0f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.start();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 10;
        float e3 = e() / 2;
        float c = c() / 2;
        canvas.save();
        float f2 = 2.0f * e2;
        canvas.translate((e3 - f2) - e2, c);
        float f3 = this.c;
        canvas.scale(f3, f3);
        canvas.drawCircle(0.0f, 0.0f, e2, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(e3, c);
        float f4 = this.c;
        canvas.scale(f4, f4);
        canvas.drawCircle(0.0f, 0.0f, e2, paint);
        canvas.restore();
        canvas.save();
        canvas.translate(e3 + f2 + e2, c);
        float f5 = this.c;
        canvas.scale(f5, f5);
        canvas.drawCircle(0.0f, 0.0f, e2, paint);
        canvas.restore();
    }
}
