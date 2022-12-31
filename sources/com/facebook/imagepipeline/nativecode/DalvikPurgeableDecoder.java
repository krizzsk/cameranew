package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.h;
import com.facebook.common.internal.m;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import java.util.Locale;
import javax.annotation.Nullable;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public abstract class DalvikPurgeableDecoder implements com.facebook.imagepipeline.platform.d {
    protected static final byte[] b;
    private final com.facebook.imagepipeline.memory.b a = com.facebook.imagepipeline.memory.c.a();

    /* JADX INFO: Access modifiers changed from: private */
    @com.facebook.soloader.d
    /* loaded from: classes.dex */
    public static class OreoUtils {
        private OreoUtils() {
        }

        @TargetApi(26)
        static void a(BitmapFactory.Options options, @Nullable ColorSpace colorSpace) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
    }

    static {
        a.a();
        b = new byte[]{-1, -39};
    }

    @VisibleForTesting
    public static boolean f(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2) {
        PooledByteBuffer A = aVar.A();
        return i2 >= 2 && A.D(i2 + (-2)) == -1 && A.D(i2 - 1) == -39;
    }

    @VisibleForTesting
    public static BitmapFactory.Options g(int i2, Bitmap.Config config) {
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

    @com.facebook.common.internal.d
    private static native void nativePinBitmap(Bitmap bitmap);

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options g2 = g(eVar.R(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(g2, colorSpace);
        }
        com.facebook.common.references.a<PooledByteBuffer> t = eVar.t();
        h.g(t);
        try {
            return h(e(t, i2, g2));
        } finally {
            com.facebook.common.references.a.y(t);
        }
    }

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> b(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options g2 = g(eVar.R(), config);
        if (Build.VERSION.SDK_INT >= 26) {
            OreoUtils.a(g2, colorSpace);
        }
        com.facebook.common.references.a<PooledByteBuffer> t = eVar.t();
        h.g(t);
        try {
            return h(d(t, g2));
        } finally {
            com.facebook.common.references.a.y(t);
        }
    }

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> c(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2) {
        return a(eVar, config, rect, i2, null);
    }

    protected abstract Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    protected abstract Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options);

    public com.facebook.common.references.a<Bitmap> h(Bitmap bitmap) {
        h.g(bitmap);
        try {
            nativePinBitmap(bitmap);
            if (this.a.g(bitmap)) {
                return com.facebook.common.references.a.T(bitmap, this.a.e());
            }
            int e2 = com.facebook.imageutils.a.e(bitmap);
            bitmap.recycle();
            throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(e2), Integer.valueOf(this.a.b()), Long.valueOf(this.a.f()), Integer.valueOf(this.a.c()), Integer.valueOf(this.a.d())));
        } catch (Exception e3) {
            bitmap.recycle();
            m.a(e3);
            throw null;
        }
    }
}
