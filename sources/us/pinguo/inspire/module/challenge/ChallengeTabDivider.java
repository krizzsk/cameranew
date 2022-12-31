package us.pinguo.inspire.module.challenge;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.s;
/* compiled from: ChallengeTabDivider.kt */
/* loaded from: classes9.dex */
public final class ChallengeTabDivider extends Drawable {
    private final int height;
    private final Paint paint;
    private final Rect rect;
    private final int width;

    public ChallengeTabDivider() {
        Paint paint = new Paint();
        this.paint = paint;
        this.rect = new Rect();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(124151398);
        this.width = us.pinguo.foundation.t.b.a.a(us.pinguo.foundation.e.b(), 0.5f);
        this.height = us.pinguo.foundation.t.b.a.a(us.pinguo.foundation.e.b(), 8.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s.h(canvas, "canvas");
        int centerY = getBounds().centerY();
        this.rect.set(getBounds().left, centerY - (this.height / 2), getBounds().right, centerY + (this.height / 2));
        canvas.drawRect(this.rect, this.paint);
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final Rect getRect() {
        return this.rect;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.paint.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }
}
