package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.jcodecraeer.xrecyclerview.progressindicator.indicator.o;
/* compiled from: LineSpinFadeLoaderIndicator.java */
/* loaded from: classes2.dex */
public class x extends o {
    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.o, com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public void b(Canvas canvas, Paint paint) {
        float e2 = e() / 10;
        for (int i2 = 0; i2 < 8; i2++) {
            canvas.save();
            o.c j2 = j(e(), c(), (e() / 2.5f) - e2, 0.7853981633974483d * i2);
            canvas.translate(j2.a, j2.b);
            float[] fArr = this.c;
            canvas.scale(fArr[i2], fArr[i2]);
            canvas.rotate(i2 * 45);
            paint.setAlpha(this.f5823d[i2]);
            float f2 = -e2;
            canvas.drawRoundRect(new RectF(f2, f2 / 1.5f, e2 * 1.5f, e2 / 1.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }
}
