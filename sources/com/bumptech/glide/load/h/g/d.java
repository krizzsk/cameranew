package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
import java.io.OutputStream;
/* compiled from: GifBitmapWrapperResourceEncoder.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.load.e<a> {
    private final com.bumptech.glide.load.e<Bitmap> a;
    private final com.bumptech.glide.load.e<com.bumptech.glide.load.resource.gif.b> b;
    private String c;

    public d(com.bumptech.glide.load.e<Bitmap> eVar, com.bumptech.glide.load.e<com.bumptech.glide.load.resource.gif.b> eVar2) {
        this.a = eVar;
        this.b = eVar2;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: b */
    public boolean a(i<a> iVar, OutputStream outputStream) {
        a aVar = iVar.get();
        i<Bitmap> a = aVar.a();
        if (a != null) {
            return this.a.a(a, outputStream);
        }
        return this.b.a(aVar.b(), outputStream);
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        if (this.c == null) {
            this.c = this.a.getId() + this.b.getId();
        }
        return this.c;
    }
}
