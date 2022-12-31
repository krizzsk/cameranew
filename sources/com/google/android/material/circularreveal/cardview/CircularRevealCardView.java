package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;
/* loaded from: classes2.dex */
public class CircularRevealCardView extends MaterialCardView implements c {
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final b f4199j;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.c
    @Nullable
    public c.e a() {
        return this.f4199j.g();
    }

    @Override // com.google.android.material.circularreveal.c
    public void b() {
        this.f4199j.a();
    }

    @Override // com.google.android.material.circularreveal.c
    public int c() {
        return this.f4199j.e();
    }

    @Override // com.google.android.material.circularreveal.c
    public void d() {
        this.f4199j.b();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        b bVar = this.f4199j;
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
        b bVar = this.f4199j;
        if (bVar != null) {
            return bVar.i();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f4199j.j(drawable);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.f4199j.k(i2);
    }

    @Override // com.google.android.material.circularreveal.c
    public void setRevealInfo(@Nullable c.e eVar) {
        this.f4199j.l(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4199j = new b(this);
    }
}
