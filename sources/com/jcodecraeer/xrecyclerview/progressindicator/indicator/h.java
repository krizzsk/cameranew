package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallPulseRiseIndicator.java */
/* loaded from: classes2.dex */
public class h extends BaseIndicatorController {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(d(), PropertyValuesHolder.ofFloat("rotationX", 0.0f, 360.0f));
        ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setDuration(1500L);
        ofPropertyValuesHolder.start();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofPropertyValuesHolder);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 10;
        float f2 = 2.0f * e2;
        canvas.drawCircle(e() / 4, f2, e2, paint);
        canvas.drawCircle((e() * 3) / 4, f2, e2, paint);
        canvas.drawCircle(e2, c() - f2, e2, paint);
        canvas.drawCircle(e() / 2, c() - f2, e2, paint);
        canvas.drawCircle(e() - e2, c() - f2, e2, paint);
    }
}
