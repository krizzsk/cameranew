package com.bumptech.glide.request.g;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: DrawableImageViewTarget.java */
/* loaded from: classes.dex */
public class c extends e<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.g.e
    /* renamed from: m */
    public void l(Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }
}
