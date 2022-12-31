package com.facebook.drawee.generic;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.facebook.drawee.drawable.g;
import com.facebook.drawee.drawable.s;
import com.facebook.drawee.drawable.t;
import javax.annotation.Nullable;
/* compiled from: RootDrawable.java */
/* loaded from: classes.dex */
public class d extends g implements s {
    @Nullable
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    Drawable f2598d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private t f2599e;

    public d(Drawable drawable) {
        super(drawable);
        this.f2598d = null;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            t tVar = this.f2599e;
            if (tVar != null) {
                tVar.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.f2598d;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.f2598d.draw(canvas);
            }
        }
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // com.facebook.drawee.drawable.s
    public void l(@Nullable t tVar) {
        this.f2599e = tVar;
    }

    public void q(@Nullable Drawable drawable) {
        this.f2598d = drawable;
        invalidateSelf();
    }

    @Override // com.facebook.drawee.drawable.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        t tVar = this.f2599e;
        if (tVar != null) {
            tVar.a(z);
        }
        return super.setVisible(z, z2);
    }
}
