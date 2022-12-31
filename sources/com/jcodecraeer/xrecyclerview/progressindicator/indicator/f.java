package com.jcodecraeer.xrecyclerview.progressindicator.indicator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BallGridPulseIndicator.java */
/* loaded from: classes2.dex */
public class f extends BaseIndicatorController {
    int[] c = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    /* renamed from: d  reason: collision with root package name */
    float[] f5820d = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    /* compiled from: BallGridPulseIndicator.java */
    /* loaded from: classes2.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.f5820d[this.a] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            f.this.g();
        }
    }

    /* compiled from: BallGridPulseIndicator.java */
    /* loaded from: classes2.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f.this.c[this.a] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            f.this.g();
        }
    }

    @Override // com.jcodecraeer.xrecyclerview.progressindicator.indicator.BaseIndicatorController
    public List<Animator> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {720, PointerIconCompat.TYPE_GRAB, 1280, 1420, 1450, 1180, 870, 1450, 1060};
        int[] iArr2 = {-60, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, -170, 480, 310, 30, 460, 780, 450};
        for (int i2 = 0; i2 < 9; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.5f, 1.0f);
            ofFloat.setDuration(iArr[i2]);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(iArr2[i2]);
            ofFloat.addUpdateListener(new a(i2));
            ofFloat.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 210, 122, 255);
            ofInt.setDuration(iArr[i2]);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay(iArr2[i2]);
            ofInt.addUpdateListener(new b(i2));
            ofInt.start();
            arrayList.add(ofFloat);
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
                float[] fArr = this.f5820d;
                int i4 = (i2 * 3) + i3;
                canvas.scale(fArr[i4], fArr[i4]);
                paint.setAlpha(this.c[i4]);
                canvas.drawCircle(0.0f, 0.0f, e2, paint);
                canvas.restore();
            }
        }
    }
}
