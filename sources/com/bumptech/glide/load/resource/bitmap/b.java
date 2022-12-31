package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.OutputStream;
/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class b implements com.bumptech.glide.load.e<Bitmap> {
    private Bitmap.CompressFormat a;
    private int b;

    public b() {
        this(null, 90);
    }

    private Bitmap.CompressFormat c(Bitmap bitmap) {
        Bitmap.CompressFormat compressFormat = this.a;
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: b */
    public boolean a(com.bumptech.glide.load.engine.i<Bitmap> iVar, OutputStream outputStream) {
        Bitmap bitmap = iVar.get();
        long b = com.bumptech.glide.l.d.b();
        Bitmap.CompressFormat c = c(bitmap);
        bitmap.compress(c, this.b, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + c + " of size " + com.bumptech.glide.l.h.e(bitmap) + " in " + com.bumptech.glide.l.d.a(b));
            return true;
        }
        return true;
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public b(Bitmap.CompressFormat compressFormat, int i2) {
        this.a = compressFormat;
        this.b = i2;
    }
}
