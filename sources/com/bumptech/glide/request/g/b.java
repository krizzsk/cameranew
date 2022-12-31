package com.bumptech.glide.request.g;

import android.graphics.Bitmap;
import android.widget.ImageView;
/* compiled from: BitmapImageViewTarget.java */
/* loaded from: classes.dex */
public class b extends e<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.g.e
    /* renamed from: m */
    public void l(Bitmap bitmap) {
        ((ImageView) this.b).setImageBitmap(bitmap);
    }
}
