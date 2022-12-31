package us.pinguo.ui.b;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
/* compiled from: TextAutoFitHelper.java */
/* loaded from: classes6.dex */
public class b {
    private TextView a;
    private TextPaint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private float f12096d;

    public b(TextView textView, int i2, float f2) {
        TextPaint textPaint = new TextPaint();
        this.b = textPaint;
        this.a = textView;
        textPaint.set(textView.getPaint());
        this.c = i2;
        this.f12096d = f2;
    }

    private boolean b(float f2, CharSequence charSequence, TextPaint textPaint, int i2, int i3, int i4, float f3, float f4) {
        textPaint.setTextSize(f2);
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, i2, Layout.Alignment.ALIGN_NORMAL, f3, f4, true);
        return staticLayout.getLineCount() <= i4 && staticLayout.getHeight() <= i3;
    }

    public void a(int i2, int i3) {
        float f2;
        float f3;
        float f4;
        if (!TextUtils.isEmpty(this.a.getText()) && i2 > 0 && i3 > 0) {
            float textSize = this.a.getTextSize();
            float f5 = textSize * this.f12096d;
            float f6 = this.a.getResources().getDisplayMetrics().density;
            if (Build.VERSION.SDK_INT >= 16) {
                f3 = this.a.getLineSpacingMultiplier();
                f4 = this.a.getLineSpacingExtra();
                f2 = textSize;
            } else {
                f2 = textSize;
                f3 = 1.0f;
                f4 = 0.0f;
            }
            while (!b(f2, this.a.getText(), this.b, i2, i3, this.c, f3, f4) && f2 > f5) {
                f2 -= f6;
            }
            if (f2 >= f5) {
                f5 = f2;
            }
            if (f5 != textSize) {
                this.a.setTextSize(0, f5);
            }
        }
    }
}
