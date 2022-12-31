package com.bumptech.glide.load.h.g;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.i;
/* compiled from: GifBitmapWrapper.java */
/* loaded from: classes.dex */
public class a {
    private final i<com.bumptech.glide.load.resource.gif.b> a;
    private final i<Bitmap> b;

    public a(i<Bitmap> iVar, i<com.bumptech.glide.load.resource.gif.b> iVar2) {
        if (iVar != null && iVar2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (iVar == null && iVar2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        }
        this.b = iVar;
        this.a = iVar2;
    }

    public i<Bitmap> a() {
        return this.b;
    }

    public i<com.bumptech.glide.load.resource.gif.b> b() {
        return this.a;
    }

    public int c() {
        i<Bitmap> iVar = this.b;
        if (iVar != null) {
            return iVar.getSize();
        }
        return this.a.getSize();
    }
}
