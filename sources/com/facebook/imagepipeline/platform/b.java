package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.facebook.common.internal.h;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: DefaultDecoder.java */
@ThreadSafe
@TargetApi(11)
/* loaded from: classes.dex */
public abstract class b implements d {

    /* renamed from: d  reason: collision with root package name */
    private static final Class<?> f2863d = b.class;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f2864e = {-1, -39};
    private final com.facebook.imagepipeline.memory.d a;
    @Nullable
    private final PreverificationHelper b;
    @VisibleForTesting
    final Pools.SynchronizedPool<ByteBuffer> c;

    public b(com.facebook.imagepipeline.memory.d dVar, int i2, Pools.SynchronizedPool synchronizedPool) {
        this.b = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.a = dVar;
        this.c = synchronizedPool;
        for (int i3 = 0; i3 < i2; i3++) {
            this.c.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ae A[Catch: all -> 0x00d1, RuntimeException -> 0x00d3, IllegalArgumentException -> 0x00dc, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x00d3, blocks: (B:29:0x006e, B:37:0x008b, B:52:0x00ae, B:44:0x009f, B:48:0x00a7, B:49:0x00aa), top: B:80:0x006e, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.facebook.common.references.a<android.graphics.Bitmap> d(java.io.InputStream r10, android.graphics.BitmapFactory.Options r11, @javax.annotation.Nullable android.graphics.Rect r12, @javax.annotation.Nullable android.graphics.ColorSpace r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.b.d(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.a");
    }

    private static BitmapFactory.Options f(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = eVar.R();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(eVar.N(), null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inMutable = true;
            return options;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2, @Nullable ColorSpace colorSpace) {
        boolean W = eVar.W(i2);
        BitmapFactory.Options f2 = f(eVar, config);
        com.facebook.common.b.b N = eVar.N();
        h.g(N);
        if (eVar.S() > i2) {
            N = new com.facebook.common.b.a(N, i2);
        }
        if (!W) {
            N = new com.facebook.common.b.b(N, f2864e);
        }
        boolean z = f2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            try {
                com.facebook.common.references.a<Bitmap> d2 = d(N, f2, rect, colorSpace);
                try {
                    N.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return d2;
            } catch (RuntimeException e3) {
                if (z) {
                    com.facebook.common.references.a<Bitmap> a = a(eVar, Bitmap.Config.ARGB_8888, rect, i2, colorSpace);
                    try {
                        N.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    return a;
                }
                throw e3;
            }
        } catch (Throwable th) {
            try {
                N.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> b(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options f2 = f(eVar, config);
        boolean z = f2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            InputStream N = eVar.N();
            h.g(N);
            return d(N, f2, rect, colorSpace);
        } catch (RuntimeException e2) {
            if (z) {
                return b(eVar, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e2;
        }
    }

    @Override // com.facebook.imagepipeline.platform.d
    public com.facebook.common.references.a<Bitmap> c(com.facebook.imagepipeline.image.e eVar, Bitmap.Config config, @Nullable Rect rect, int i2) {
        return a(eVar, config, rect, i2, null);
    }

    public abstract int e(int i2, int i3, BitmapFactory.Options options);
}
