package com.facebook.webpsupport;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import com.facebook.common.c.a;
import com.facebook.common.c.b;
import com.facebook.common.c.c;
import com.facebook.common.internal.d;
import com.facebook.imagepipeline.nativecode.e;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
@d
/* loaded from: classes.dex */
public class WebpBitmapFactoryImpl implements b {
    public static final boolean a;
    private static b.a b;
    private static a c;

    static {
        a = Build.VERSION.SDK_INT >= 11;
    }

    @d
    @Nullable
    private static Bitmap createBitmap(int i2, int i3, @Nullable BitmapFactory.Options options) {
        Bitmap bitmap;
        if (a && options != null && (bitmap = options.inBitmap) != null && bitmap.isMutable()) {
            return options.inBitmap;
        }
        return c.a(i2, i3, Bitmap.Config.ARGB_8888);
    }

    @Nullable
    private static byte[] d(InputStream inputStream, @Nullable BitmapFactory.Options options) {
        byte[] bArr;
        inputStream.mark(20);
        if (options == null || (bArr = options.inTempStorage) == null || bArr.length < 20) {
            bArr = new byte[20];
        }
        try {
            inputStream.read(bArr, 0, 20);
            inputStream.reset();
            return bArr;
        } catch (IOException unused) {
            return null;
        }
    }

    private static void e(String str) {
        b.a aVar = b;
        if (aVar != null) {
            aVar.a(str, "decoding_failure");
        }
    }

    private static void f(@Nullable Bitmap bitmap, @Nullable BitmapFactory.Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i2 = options.inDensity;
        if (i2 != 0) {
            bitmap.setDensity(i2);
            int i3 = options.inTargetDensity;
            if (i3 == 0 || i2 == i3 || i2 == options.inScreenDensity || !options.inScaled) {
                return;
            }
            bitmap.setDensity(i3);
        } else if (!a || options.inBitmap == null) {
        } else {
            bitmap.setDensity(160);
        }
    }

    private static void g(@Nullable Bitmap bitmap, @Nullable BitmapFactory.Options options) {
        f(bitmap, options);
        if (options != null) {
            options.outMimeType = "image/webp";
        }
    }

    @d
    private static byte[] getInTempStorageFromOptions(@Nullable BitmapFactory.Options options) {
        byte[] bArr;
        return (options == null || (bArr = options.inTempStorage) == null) ? new byte[8192] : bArr;
    }

    @d
    private static float getScaleFromOptions(@Nullable BitmapFactory.Options options) {
        if (options != null) {
            int i2 = options.inSampleSize;
            float f2 = i2 > 1 ? 1.0f / i2 : 1.0f;
            if (options.inScaled) {
                int i3 = options.inDensity;
                int i4 = options.inTargetDensity;
                return (i3 == 0 || i4 == 0 || i3 == options.inScreenDensity) ? f2 : i4 / i3;
            }
            return f2;
        }
        return 1.0f;
    }

    private static InputStream h(InputStream inputStream) {
        return !inputStream.markSupported() ? new BufferedInputStream(inputStream, 20) : inputStream;
    }

    @d
    @Nullable
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options) {
        Bitmap originalDecodeByteArray;
        e.a();
        if (c.a && c.h(bArr, i2, i3)) {
            originalDecodeByteArray = nativeDecodeByteArray(bArr, i2, i3, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (originalDecodeByteArray == null) {
                e("webp_direct_decode_array");
            }
            g(originalDecodeByteArray, options);
        } else {
            originalDecodeByteArray = originalDecodeByteArray(bArr, i2, i3, options);
            if (originalDecodeByteArray == null) {
                e("webp_direct_decode_array_failed_on_no_webp");
            }
        }
        return originalDecodeByteArray;
    }

    @d
    @Nullable
    public static Bitmap hookDecodeFile(String str, @Nullable BitmapFactory.Options options) {
        Bitmap bitmap = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            bitmap = hookDecodeStream(fileInputStream, null, options);
            fileInputStream.close();
        } catch (Exception unused) {
        }
        return bitmap;
    }

    @d
    @Nullable
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        Bitmap originalDecodeFileDescriptor;
        e.a();
        long nativeSeek = nativeSeek(fileDescriptor, 0L, false);
        if (nativeSeek != -1) {
            InputStream h2 = h(new FileInputStream(fileDescriptor));
            try {
                byte[] d2 = d(h2, options);
                if (c.a && d2 != null && c.h(d2, 0, 20)) {
                    originalDecodeFileDescriptor = nativeDecodeStream(h2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
                    if (originalDecodeFileDescriptor == null) {
                        e("webp_direct_decode_fd");
                    }
                    setPaddingDefaultValues(rect);
                    g(originalDecodeFileDescriptor, options);
                } else {
                    nativeSeek(fileDescriptor, nativeSeek, true);
                    originalDecodeFileDescriptor = originalDecodeFileDescriptor(fileDescriptor, rect, options);
                    if (originalDecodeFileDescriptor == null) {
                        e("webp_direct_decode_fd_failed_on_no_webp");
                    }
                }
                try {
                } catch (Throwable unused) {
                    return originalDecodeFileDescriptor;
                }
            } finally {
                try {
                    h2.close();
                } catch (Throwable unused2) {
                }
            }
        } else {
            Bitmap hookDecodeStream = hookDecodeStream(new FileInputStream(fileDescriptor), rect, options);
            setPaddingDefaultValues(rect);
            return hookDecodeStream;
        }
    }

    @d
    @Nullable
    public static Bitmap hookDecodeResource(Resources resources, int i2, @Nullable BitmapFactory.Options options) {
        TypedValue typedValue = new TypedValue();
        Bitmap bitmap = null;
        try {
            InputStream openRawResource = resources.openRawResource(i2, typedValue);
            bitmap = hookDecodeResourceStream(resources, typedValue, openRawResource, null, options);
            if (openRawResource != null) {
                openRawResource.close();
            }
        } catch (Exception unused) {
        }
        if (!a || bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    @d
    @Nullable
    public static Bitmap hookDecodeResourceStream(@Nullable Resources resources, @Nullable TypedValue typedValue, InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inDensity == 0 && typedValue != null) {
            int i2 = typedValue.density;
            if (i2 == 0) {
                options.inDensity = 160;
            } else if (i2 != 65535) {
                options.inDensity = i2;
            }
        }
        if (options.inTargetDensity == 0 && resources != null) {
            options.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return hookDecodeStream(inputStream, rect, options);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeStream(InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        Bitmap originalDecodeStream;
        e.a();
        InputStream h2 = h(inputStream);
        byte[] d2 = d(h2, options);
        if (c.a && d2 != null && c.h(d2, 0, 20)) {
            originalDecodeStream = nativeDecodeStream(h2, options, getScaleFromOptions(options), getInTempStorageFromOptions(options));
            if (originalDecodeStream == null) {
                e("webp_direct_decode_stream");
            }
            g(originalDecodeStream, options);
            setPaddingDefaultValues(rect);
        } else {
            originalDecodeStream = originalDecodeStream(h2, rect, options);
            if (originalDecodeStream == null) {
                e("webp_direct_decode_stream_failed_on_no_webp");
            }
        }
        return originalDecodeStream;
    }

    @d
    @Nullable
    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options, float f2, byte[] bArr2);

    @d
    @Nullable
    private static native Bitmap nativeDecodeStream(InputStream inputStream, @Nullable BitmapFactory.Options options, float f2, byte[] bArr);

    @d
    private static native long nativeSeek(FileDescriptor fileDescriptor, long j2, boolean z);

    @d
    @Nullable
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeByteArray(bArr, i2, i3, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeFile(String str, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFile(str, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        return BitmapFactory.decodeResource(resources, i2, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeStream(InputStream inputStream, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        return BitmapFactory.decodeStream(inputStream, rect, options);
    }

    @d
    private static void setBitmapSize(@Nullable BitmapFactory.Options options, int i2, int i3) {
        if (options != null) {
            options.outWidth = i2;
            options.outHeight = i3;
        }
    }

    @d
    private static boolean setOutDimensions(@Nullable BitmapFactory.Options options, int i2, int i3) {
        if (options == null || !options.inJustDecodeBounds) {
            return false;
        }
        options.outWidth = i2;
        options.outHeight = i3;
        return true;
    }

    @d
    private static void setPaddingDefaultValues(@Nullable Rect rect) {
        if (rect != null) {
            rect.top = -1;
            rect.left = -1;
            rect.bottom = -1;
            rect.right = -1;
        }
    }

    @d
    @SuppressLint({"NewApi"})
    private static boolean shouldPremultiply(@Nullable BitmapFactory.Options options) {
        if (Build.VERSION.SDK_INT < 19 || options == null) {
            return true;
        }
        return options.inPremultiplied;
    }

    @Override // com.facebook.common.c.b
    public void a(a aVar) {
        c = aVar;
    }

    @Override // com.facebook.common.c.b
    public void b(b.a aVar) {
        b = aVar;
    }

    @Override // com.facebook.common.c.b
    @Nullable
    public Bitmap c(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options) {
        return hookDecodeFileDescriptor(fileDescriptor, rect, options);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeByteArray(byte[] bArr, int i2, int i3) {
        return BitmapFactory.decodeByteArray(bArr, i2, i3);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeFile(String str) {
        return BitmapFactory.decodeFile(str);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeResource(Resources resources, int i2) {
        return BitmapFactory.decodeResource(resources, i2);
    }

    @d
    @Nullable
    private static Bitmap originalDecodeStream(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeFile(String str) {
        return hookDecodeFile(str, null);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeResource(Resources resources, int i2) {
        return hookDecodeResource(resources, i2, null);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeByteArray(byte[] bArr, int i2, int i3) {
        return hookDecodeByteArray(bArr, i2, i3, null);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeStream(InputStream inputStream) {
        return hookDecodeStream(inputStream, null, null);
    }

    @d
    @Nullable
    public static Bitmap hookDecodeFileDescriptor(FileDescriptor fileDescriptor) {
        return hookDecodeFileDescriptor(fileDescriptor, null, null);
    }
}
