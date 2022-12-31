package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: BallPulseSyncIndicator.java */
/* loaded from: classes2.dex */
public class i extends BaseIndicatorController {
    float[] c = new float[3];

    /* compiled from: BallPulseSyncIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i.this.c[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            i.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        float e2 = (e() - 8.0f) / 6.0f;
        int[] iArr = {70, InspirePublishFragment.MAX_DESC_COUNT, 210};
        for (int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(c() / 2, (c() / 2) - (2.0f * e2), c() / 2);
            ofFloat.setDuration(600L);
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
        float e2 = (e() - 8.0f) / 6.0f;
        float f2 = 2.0f * e2;
        float e3 = (e() / 2) - (f2 + 4.0f);
        for (int i2 = 0; i2 < 3; i2++) {
            canvas.save();
            float f3 = i2;
            canvas.translate((f2 * f3) + e3 + (f3 * 4.0f), this.c[i2]);
            canvas.drawCircle(0.0f, 0.0f, e2, paint);
            canvas.restore();
        }
    }
}
