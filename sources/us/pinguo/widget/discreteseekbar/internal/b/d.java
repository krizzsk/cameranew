package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
/* compiled from: ThumbCenterDrawable.java */
/* loaded from: classes6.dex */
public class d extends e {

    /* renamed from: i  reason: collision with root package name */
    private final int f12571i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12572j;

    public d(@NonNull ColorStateList colorStateList, int i2, int i3) {
        super(colorStateList, i2);
        this.f12572j = false;
        this.f12571i = i3;
    }

    @Override // us.pinguo.widget.discreteseekbar.internal.b.e, us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        if (this.f12572j) {
            paint.setColor(this.f12571i);
        } else {
            paint.setColor(b());
        }
        super.a(canvas, paint);
    }

    public void i(boolean z) {
        this.f12572j = z;
    }
}
