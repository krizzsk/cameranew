package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
/* compiled from: TrackCustomDrawable.java */
/* loaded from: classes6.dex */
public class f extends h {

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f12577e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12578f;

    public f(@NonNull ColorStateList colorStateList, Drawable drawable, int i2) {
        super(colorStateList);
        this.f12577e = drawable;
        this.f12578f = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // us.pinguo.widget.discreteseekbar.internal.b.h, us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        Rect bounds = getBounds();
        this.f12577e.setBounds(bounds);
        this.f12577e.draw(canvas);
        int color = paint.getColor();
        paint.setColor(this.f12578f);
        canvas.drawCircle(bounds.left + (bounds.width() / 2), bounds.top + (bounds.height() / 2), bounds.height(), paint);
        paint.setColor(color);
    }
}
