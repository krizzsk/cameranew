package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
/* compiled from: StateDrawable.java */
/* loaded from: classes6.dex */
public abstract class c extends Drawable {
    private ColorStateList a;
    private final Paint b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f12570d = 255;

    public c(@NonNull ColorStateList colorStateList) {
        d(colorStateList);
        this.b = new Paint(1);
    }

    private boolean e(int[] iArr) {
        int colorForState = this.a.getColorForState(iArr, this.c);
        if (colorForState != this.c) {
            this.c = colorForState;
            invalidateSelf();
            return true;
        }
        return false;
    }

    abstract void a(Canvas canvas, Paint paint);

    public int b() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        int i3 = this.f12570d;
        return (i2 * (i3 + (i3 >> 7))) >> 8;
    }

    public void d(@NonNull ColorStateList colorStateList) {
        this.a = colorStateList;
        this.c = colorStateList.getDefaultColor();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.b.setColor(this.c);
        this.b.setAlpha(c(Color.alpha(this.c)));
        a(canvas, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f12570d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.a.isStateful() || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f12570d = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return e(iArr) || super.setState(iArr);
    }
}
