package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
/* compiled from: TrackRectCircleDrawable.java */
/* loaded from: classes6.dex */
public class g extends h {

    /* renamed from: e  reason: collision with root package name */
    private final int f12579e;

    /* renamed from: f  reason: collision with root package name */
    private int f12580f;

    public g(@NonNull ColorStateList colorStateList, int i2, int i3) {
        super(colorStateList);
        this.f12579e = i2;
        this.f12580f = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // us.pinguo.widget.discreteseekbar.internal.b.h, us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        super.a(canvas, paint);
        int color = paint.getColor();
        paint.setColor(this.f12579e);
        float max = Math.max(this.f12580f, getBounds().height());
        canvas.drawCircle(getBounds().left + (getBounds().width() / 2), getBounds().top + (getBounds().height() / 2), max, paint);
        paint.setColor(color);
    }
}
