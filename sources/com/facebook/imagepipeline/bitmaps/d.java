package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.internal.h;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.b0;
import com.facebook.imagepipeline.memory.p;
/* compiled from: HoneycombBitmapCreator.java */
/* loaded from: classes.dex */
public class d implements com.facebook.common.c.a {
    private final b a;
    private final p b;

    public d(b0 b0Var) {
        this.b = b0Var.d();
        this.a = new b(b0Var.h());
    }

    private static BitmapFactory.Options b(int i2, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        if (Build.VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }

    @Override // com.facebook.common.c.a
    @TargetApi(12)
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        com.facebook.imagepipeline.image.e eVar;
        com.facebook.common.references.a<PooledByteBuffer> a = this.a.a((short) i2, (short) i3);
        com.facebook.common.references.a<byte[]> aVar = null;
        try {
            eVar = new com.facebook.imagepipeline.image.e(a);
            try {
                eVar.h0(com.facebook.imageformat.b.a);
                BitmapFactory.Options b = b(eVar.R(), config);
                int size = a.A().size();
                aVar = this.b.a(size + 2);
                byte[] A = aVar.A();
                a.A().b(0, A, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(A, 0, size, b);
                h.g(decodeByteArray);
                Bitmap bitmap = decodeByteArray;
                bitmap.setHasAlpha(true);
                bitmap.eraseColor(0);
                com.facebook.common.references.a.y(aVar);
                com.facebook.imagepipeline.image.e.h(eVar);
                com.facebook.common.references.a.y(a);
                return bitmap;
            } catch (Throwable th) {
                th = th;
                com.facebook.common.references.a.y(aVar);
                com.facebook.imagepipeline.image.e.h(eVar);
                com.facebook.common.references.a.y(a);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            eVar = null;
        }
    }
}
