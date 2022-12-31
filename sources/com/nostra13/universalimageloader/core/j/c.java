package com.nostra13.universalimageloader.core.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
/* compiled from: NonViewAware.java */
/* loaded from: classes3.dex */
public class c implements a {
    protected final String a;
    protected final com.nostra13.universalimageloader.core.assist.c b;
    protected final ViewScaleType c;

    public c(String str, com.nostra13.universalimageloader.core.assist.c cVar, ViewScaleType viewScaleType) {
        if (cVar == null) {
            throw new IllegalArgumentException("imageSize must not be null");
        }
        if (viewScaleType != null) {
            this.a = str;
            this.b = cVar;
            this.c = viewScaleType;
            return;
        }
        throw new IllegalArgumentException("scaleType must not be null");
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getHeight() {
        return this.b.a();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getId() {
        return TextUtils.isEmpty(this.a) ? super.hashCode() : this.a.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public ViewScaleType getScaleType() {
        return this.c;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public int getWidth() {
        return this.b.b();
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public View getWrappedView() {
        return null;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean isCollected() {
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageBitmap(Bitmap bitmap) {
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.j.a
    public boolean setImageDrawable(Drawable drawable) {
        return true;
    }
}
