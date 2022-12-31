package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.c;
/* loaded from: classes2.dex */
public class CircularRevealLinearLayout extends LinearLayout implements c {
    @NonNull
    private final b a;

    public CircularRevealLinearLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    @Nullable
    public c.e a() {
        return this.a.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.a.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public int c() {
        return this.a.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public void d() {
        this.a.b();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.b.a
    public void e(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.b.a
    public boolean f() {
        return super.isOpaque();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.i();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.a.j(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.a.k(i2);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@Nullable c.e eVar) {
        this.a.l(eVar);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b(this);
    }
}
