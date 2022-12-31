package com.facebook.drawee.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
/* compiled from: RoundedBitmapDrawable.java */
/* loaded from: classes.dex */
public class k extends m {
    private final Paint D;
    private final Paint E;
    @Nullable
    private final Bitmap F;
    @Nullable
    private WeakReference<Bitmap> G;

    public k(Resources resources, @Nullable Bitmap bitmap, @Nullable Paint paint) {
        super(new BitmapDrawable(resources, bitmap));
        Paint paint2 = new Paint();
        this.D = paint2;
        Paint paint3 = new Paint(1);
        this.E = paint3;
        this.F = bitmap;
        if (paint != null) {
            paint2.set(paint);
        }
        paint2.setFlags(1);
        paint3.setStyle(Paint.Style.STROKE);
    }

    private void l() {
        WeakReference<Bitmap> weakReference = this.G;
        if (weakReference == null || weakReference.get() != this.F) {
            this.G = new WeakReference<>(this.F);
            Paint paint = this.D;
            Bitmap bitmap = this.F;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
            this.f2546f = true;
        }
        if (this.f2546f) {
            this.D.getShader().setLocalMatrix(this.x);
            this.f2546f = false;
        }
        this.D.setFilterBitmap(a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.facebook.drawee.drawable.m
    @VisibleForTesting
    public boolean b() {
        return super.b() && this.F != null;
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("RoundedBitmapDrawable#draw");
        }
        if (!b()) {
            super.draw(canvas);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
                return;
            }
            return;
        }
        k();
        e();
        l();
        int save = canvas.save();
        canvas.concat(this.u);
        canvas.drawPath(this.f2545e, this.D);
        float f2 = this.f2544d;
        if (f2 > 0.0f) {
            this.E.setStrokeWidth(f2);
            this.E.setColor(e.c(this.f2547g, this.D.getAlpha()));
            canvas.drawPath(this.f2548h, this.E);
        }
        canvas.restoreToCount(save);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        super.setAlpha(i2);
        if (i2 != this.D.getAlpha()) {
            this.D.setAlpha(i2);
            super.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
        this.D.setColorFilter(colorFilter);
    }
}
