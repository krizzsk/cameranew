package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;
/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public abstract class d implements com.bumptech.glide.load.resource.bitmap.a<InputStream> {
    private static final Set<ImageHeaderParser.ImageType> a = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);
    private static final Queue<BitmapFactory.Options> b = com.bumptech.glide.l.h.c(0);
    public static final d c = new a();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    static class a extends d {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        @Override // com.bumptech.glide.load.resource.bitmap.d
        protected int h(int i2, int i3, int i4, int i5) {
            return Math.min(i3 / i5, i2 / i4);
        }
    }

    private static Bitmap b(com.bumptech.glide.l.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            fVar.mark(5242880);
        } else {
            recyclableBufferedInputStream.d();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(fVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                fVar.reset();
            }
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e2);
            }
        }
        return decodeStream;
    }

    private Bitmap c(com.bumptech.glide.l.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i2, int i3, int i4, DecodeFormat decodeFormat) {
        Bitmap.Config d2 = d(fVar, decodeFormat);
        options.inSampleSize = i4;
        options.inPreferredConfig = d2;
        if ((i4 == 1 || 19 <= Build.VERSION.SDK_INT) && l(fVar)) {
            double d3 = i4;
            k(options, cVar.e((int) Math.ceil(i2 / d3), (int) Math.ceil(i3 / d3), d2));
        }
        return b(fVar, recyclableBufferedInputStream, options);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        android.util.Log.w("Downsampler", "Cannot reset the input stream", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap.Config d(java.io.InputStream r7, com.bumptech.glide.load.DecodeFormat r8) {
        /*
            java.lang.String r0 = "Cannot reset the input stream"
            java.lang.String r1 = "Downsampler"
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888
            if (r8 == r2) goto L72
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r8 == r2) goto L72
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r2 != r3) goto L13
            goto L72
        L13:
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            r7.mark(r3)
            r3 = 5
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r2 = r4.f()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r7.reset()     // Catch: java.io.IOException -> L27
            goto L5b
        L27:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
        L2e:
            android.util.Log.w(r1, r0, r7)
            goto L5b
        L32:
            r8 = move-exception
            goto L63
        L34:
            r4 = move-exception
            boolean r5 = android.util.Log.isLoggable(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L4f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "Cannot determine whether the image has alpha or not from header for format "
            r5.append(r6)     // Catch: java.lang.Throwable -> L32
            r5.append(r8)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L32
            android.util.Log.w(r1, r8, r4)     // Catch: java.lang.Throwable -> L32
        L4f:
            r7.reset()     // Catch: java.io.IOException -> L53
            goto L5b
        L53:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
            goto L2e
        L5b:
            if (r2 == 0) goto L60
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L62
        L60:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L62:
            return r7
        L63:
            r7.reset()     // Catch: java.io.IOException -> L67
            goto L71
        L67:
            r7 = move-exception
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L71
            android.util.Log.w(r1, r0, r7)
        L71:
            throw r8
        L72:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.d.d(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options e() {
        BitmapFactory.Options poll;
        synchronized (d.class) {
            Queue<BitmapFactory.Options> queue = b;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                j(poll);
            }
        }
        return poll;
    }

    private int g(int i2, int i3, int i4, int i5, int i6) {
        int h2;
        if (i6 == Integer.MIN_VALUE) {
            i6 = i4;
        }
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i2 != 90 && i2 != 270) {
            h2 = h(i3, i4, i5, i6);
        } else {
            h2 = h(i4, i3, i5, i6);
        }
        return Math.max(1, h2 == 0 ? 0 : Integer.highestOneBit(h2));
    }

    private static void i(BitmapFactory.Options options) {
        j(options);
        Queue<BitmapFactory.Options> queue = b;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    @TargetApi(11)
    private static void j(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    @TargetApi(11)
    private static void k(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean l(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(1024);
        try {
            try {
                boolean contains = a.contains(new ImageHeaderParser(inputStream).d());
                try {
                    inputStream.reset();
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e2);
                    }
                }
                return contains;
            } catch (Throwable th) {
                try {
                    inputStream.reset();
                } catch (IOException e3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e3);
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            if (Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Cannot determine the image type from header", e4);
            }
            try {
                inputStream.reset();
                return false;
            } catch (IOException e5) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot reset the input stream", e5);
                    return false;
                }
                return false;
            }
        }
    }

    public Bitmap a(InputStream inputStream, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i2, int i3, DecodeFormat decodeFormat) {
        int i4;
        com.bumptech.glide.l.a a2 = com.bumptech.glide.l.a.a();
        byte[] b2 = a2.b();
        byte[] b3 = a2.b();
        BitmapFactory.Options e2 = e();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, b3);
        com.bumptech.glide.l.c e3 = com.bumptech.glide.l.c.e(recyclableBufferedInputStream);
        com.bumptech.glide.l.f fVar = new com.bumptech.glide.l.f(e3);
        try {
            e3.mark(5242880);
            try {
                int c2 = new ImageHeaderParser(e3).c();
                try {
                    e3.reset();
                } catch (IOException e4) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e4);
                    }
                }
                i4 = c2;
            } catch (IOException e5) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image orientation from header", e5);
                }
                try {
                    e3.reset();
                } catch (IOException e6) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e6);
                    }
                }
                i4 = 0;
            }
            e2.inTempStorage = b2;
            int[] f2 = f(fVar, recyclableBufferedInputStream, e2);
            int i5 = f2[0];
            int i6 = f2[1];
            Bitmap c3 = c(fVar, recyclableBufferedInputStream, e2, cVar, i5, i6, g(k.c(i4), i5, i6, i2, i3), decodeFormat);
            IOException d2 = e3.d();
            if (d2 == null) {
                Bitmap bitmap = null;
                if (c3 != null) {
                    bitmap = k.f(c3, cVar, i4);
                    if (!c3.equals(bitmap) && !cVar.a(c3)) {
                        c3.recycle();
                    }
                }
                return bitmap;
            }
            throw new RuntimeException(d2);
        } finally {
            a2.c(b2);
            a2.c(b3);
            e3.t();
            i(e2);
        }
    }

    public int[] f(com.bumptech.glide.l.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        b(fVar, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    protected abstract int h(int i2, int i3, int i4, int i5);
}
