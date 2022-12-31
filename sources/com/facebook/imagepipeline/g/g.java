package com.facebook.imagepipeline.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import java.io.OutputStream;
import javax.annotation.Nullable;
/* compiled from: SimpleImageTranscoder.java */
/* loaded from: classes.dex */
public class g implements c {
    private final boolean a;
    private final int b;

    public g(boolean z, int i2) {
        this.a = z;
        this.b = i2;
    }

    private static Bitmap.CompressFormat e(@Nullable com.facebook.imageformat.c cVar) {
        if (cVar == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (cVar == com.facebook.imageformat.b.a) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (cVar == com.facebook.imageformat.b.b) {
            return Bitmap.CompressFormat.PNG;
        }
        if (Build.VERSION.SDK_INT >= 14 && com.facebook.imageformat.b.a(cVar)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    private int f(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar) {
        if (this.a) {
            return a.b(eVar2, dVar, eVar, this.b);
        }
        return 1;
    }

    @Override // com.facebook.imagepipeline.g.c
    public String a() {
        return "SimpleImageTranscoder";
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean b(com.facebook.imagepipeline.image.e eVar, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar) {
        if (eVar2 == null) {
            eVar2 = com.facebook.imagepipeline.common.e.a();
        }
        return this.a && a.b(eVar2, dVar, eVar, this.b) > 1;
    }

    @Override // com.facebook.imagepipeline.g.c
    public b c(com.facebook.imagepipeline.image.e eVar, OutputStream outputStream, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar, @Nullable com.facebook.imageformat.c cVar, @Nullable Integer num) {
        g gVar;
        com.facebook.imagepipeline.common.e eVar3;
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e2;
        Integer num2 = num == null ? 85 : num;
        if (eVar2 == null) {
            eVar3 = com.facebook.imagepipeline.common.e.a();
            gVar = this;
        } else {
            gVar = this;
            eVar3 = eVar2;
        }
        int f2 = gVar.f(eVar, eVar3, dVar);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = f2;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(eVar.N(), null, options);
            if (decodeStream == null) {
                com.facebook.common.logging.a.h("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new b(2);
            }
            Matrix g2 = e.g(eVar, eVar3);
            if (g2 != null) {
                try {
                    bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), g2, false);
                } catch (OutOfMemoryError e3) {
                    e2 = e3;
                    bitmap = decodeStream;
                    com.facebook.common.logging.a.i("SimpleImageTranscoder", "Out-Of-Memory during transcode", e2);
                    b bVar = new b(2);
                    bitmap.recycle();
                    decodeStream.recycle();
                    return bVar;
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = decodeStream;
                    bitmap.recycle();
                    decodeStream.recycle();
                    throw th;
                }
            } else {
                bitmap = decodeStream;
            }
            try {
                try {
                    bitmap.compress(e(cVar), num2.intValue(), outputStream);
                    b bVar2 = new b(f2 > 1 ? 0 : 1);
                    bitmap.recycle();
                    decodeStream.recycle();
                    return bVar2;
                } catch (OutOfMemoryError e4) {
                    e2 = e4;
                    com.facebook.common.logging.a.i("SimpleImageTranscoder", "Out-Of-Memory during transcode", e2);
                    b bVar3 = new b(2);
                    bitmap.recycle();
                    decodeStream.recycle();
                    return bVar3;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmap.recycle();
                decodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e5) {
            com.facebook.common.logging.a.i("SimpleImageTranscoder", "Out-Of-Memory during transcode", e5);
            return new b(2);
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean d(com.facebook.imageformat.c cVar) {
        return cVar == com.facebook.imageformat.b.f2658k || cVar == com.facebook.imageformat.b.a;
    }
}
