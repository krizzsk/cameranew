package com.pinguo.tintlibrary;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.TintableBackgroundView;
/* loaded from: classes3.dex */
public class TintImageView extends ImageView implements TintableBackgroundView {
    private a a;

    public TintImageView(Context context) {
        super(context);
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        a aVar = new a(this);
        this.a = aVar;
        if (attributeSet != null) {
            aVar.g(attributeSet);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.a;
        if (aVar != null) {
            aVar.b();
            this.a.a();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        a aVar = this.a;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.k(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.l(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.i(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.j(mode);
        }
    }

    public TintImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public TintImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
