package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.h.a;
/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
class a implements a.InterfaceC0026a {
    private final com.bumptech.glide.load.engine.bitmap_recycle.c a;

    public a(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        this.a = cVar;
    }

    @Override // com.bumptech.glide.h.a.InterfaceC0026a
    public void a(Bitmap bitmap) {
        if (this.a.a(bitmap)) {
            return;
        }
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.h.a.InterfaceC0026a
    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return this.a.e(i2, i3, config);
    }
}
