package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
/* compiled from: RoundedNinePatchDrawable.java */
/* loaded from: classes.dex */
public class n extends m {
    public n(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // com.facebook.drawee.drawable.m, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("RoundedNinePatchDrawable#draw");
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
        canvas.clipPath(this.f2545e);
        super.draw(canvas);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
    }
}
