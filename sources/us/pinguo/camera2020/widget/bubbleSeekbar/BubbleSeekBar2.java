package us.pinguo.camera2020.widget.bubbleSeekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import us.pinguo.camera2020.widget.bubbleSeekbar.a;
/* loaded from: classes3.dex */
public class BubbleSeekBar2 extends BubbleSeekBar {
    public BubbleSeekBar2(Context context) {
        super(context);
    }

    @Override // us.pinguo.camera2020.widget.bubbleSeekbar.BubbleSeekBar
    protected void p(Canvas canvas, float f2, boolean z, float f3, float f4) {
        a aVar;
        int i2;
        this.b.setTextAlign(Paint.Align.CENTER);
        float f5 = this.p - this.n;
        float f6 = f5 / aVar.m;
        float f7 = this.f9510e.f9530i;
        int i3 = 0;
        while (true) {
            a aVar2 = this.f9510e;
            if (i3 > aVar2.m) {
                return;
            }
            float f8 = i3;
            float f9 = this.n + (f8 * f6);
            if (aVar2.n) {
                if (f9 == f3) {
                    this.b.setColor(aVar2.f9532k);
                    canvas.drawCircle(f9, this.o, f7, this.b);
                }
            }
            if (z) {
                a.b.C0367a d2 = this.f9510e.q.d(i3);
                c b = this.f9510e.q.b();
                if (d2.a > 0) {
                    Drawable drawable = getResources().getDrawable(d2.a);
                    a aVar3 = this.f9510e;
                    if (aVar3.o) {
                        float f10 = (aVar3.b - aVar3.a) / aVar3.m;
                        if (Math.abs(((float) y(aVar3.c)) - (f8 * f10)) < f10 / 100.0f) {
                            drawable.setColorFilter(null);
                        } else {
                            drawable.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
                        }
                    }
                    int i4 = (int) f9;
                    int i5 = b.a;
                    int i6 = (int) f2;
                    int i7 = this.f9517l;
                    int i8 = b.b;
                    drawable.setBounds(i4 - (i5 / 2), ((i7 - i8) / 2) + i6, i4 + (i5 / 2), i6 + ((i7 - i8) / 2) + i8);
                    drawable.draw(canvas);
                } else if (d2.b != null) {
                    int a = this.f9510e.q.a();
                    a aVar4 = this.f9510e;
                    if (aVar4.o) {
                        float f11 = (aVar4.b - aVar4.a) / aVar4.m;
                        if (!(Math.abs(((float) y(aVar4.c)) - (f8 * f11)) < f11 / 100.0f)) {
                            a = t(a);
                        }
                    }
                    this.b.setColor(a);
                    String str = d2.b;
                    int length = str.length();
                    int i9 = this.f9517l;
                    canvas.drawText(str, 0, length, f9, (this.f9516k * 0.75f) + ((int) f2) + ((i9 - i2) / 2), this.b);
                }
            }
            i3++;
        }
    }

    public BubbleSeekBar2(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleSeekBar2(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
