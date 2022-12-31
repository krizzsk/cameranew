package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;
/* compiled from: SemiCircleSpinIndicator.java */
/* loaded from: classes2.dex */
public class z extends BaseIndicatorController {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(d(), Key.ROTATION, 0.0f, 180.0f, 360.0f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatCount(-1);
        ofFloat.start();
        arrayList.add(ofFloat);
        return arrayList;
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        canvas.drawArc(new RectF(0.0f, 0.0f, e(), c()), -60.0f, 120.0f, false, paint);
    }
}
