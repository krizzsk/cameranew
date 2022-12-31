package com.google.android.material.g;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.TintAwareDrawable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.m;
import com.google.android.material.shape.o;
/* compiled from: RippleDrawableCompat.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends Drawable implements o, TintAwareDrawable {
    private b a;

    @NonNull
    public a a() {
        this.a = new b(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.a;
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public /* bridge */ /* synthetic */ Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.a.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NonNull int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.a.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean e2 = com.google.android.material.g.b.e(iArr);
        b bVar = this.a;
        if (bVar.b != e2) {
            bVar.b = e2;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.a.a.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull m mVar) {
        this.a.a.setShapeAppearanceModel(mVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        this.a.a.setTint(i2);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.a.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        this.a.a.setTintMode(mode);
    }

    public a(m mVar) {
        this(new b(new h(mVar)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RippleDrawableCompat.java */
    /* loaded from: classes2.dex */
    public static final class b extends Drawable.ConstantState {
        @NonNull
        h a;
        boolean b;

        public b(h hVar) {
            this.a = hVar;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        /* renamed from: a */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public b(@NonNull b bVar) {
            this.a = (h) bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }
    }

    private a(b bVar) {
        this.a = bVar;
    }
}
