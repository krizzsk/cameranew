package com.pinguo.album.data.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import com.pinguo.album.a;
import java.io.FileDescriptor;
import java.io.FileInputStream;
/* compiled from: AlbumBitmapDecodeUtils.java */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumBitmapDecodeUtils.java */
    /* renamed from: com.pinguo.album.data.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0231a implements a.InterfaceC0229a {
        BitmapFactory.Options a;

        public C0231a(BitmapFactory.Options options) {
            this.a = options;
        }

        @Override // com.pinguo.album.a.InterfaceC0229a
        public void onCancel() {
            this.a.requestCancelDecode();
        }
    }

    public static BitmapRegionDecoder a(a.c cVar, String str, boolean z) {
        try {
            return BitmapRegionDecoder.newInstance(str, z);
        } catch (Throwable th) {
            us.pinguo.common.log.a.f(th);
            return null;
        }
    }

    public static Bitmap b(a.c cVar, byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        cVar.a(new C0231a(options));
        i(options);
        return g(BitmapFactory.decodeByteArray(bArr, i2, i3, options));
    }

    private static void c(a.c cVar, byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        com.pinguo.album.j.a.a(options != null);
        options.inJustDecodeBounds = true;
        cVar.a(new C0231a(options));
        BitmapFactory.decodeByteArray(bArr, i2, i3, options);
        options.inJustDecodeBounds = false;
    }

    public static Bitmap d(a.c cVar, FileDescriptor fileDescriptor, BitmapFactory.Options options, int i2, int i3) {
        int max;
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        cVar.a(new C0231a(options));
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        if (cVar.isCancelled()) {
            return null;
        }
        int i4 = options.outWidth;
        int i5 = options.outHeight;
        if (i3 == 2) {
            int d2 = b.d(i2 / Math.min(i4, i5));
            options.inSampleSize = d2;
            if ((i4 / d2) * (i5 / d2) > 640000) {
                float sqrt = (float) Math.sqrt(640000 / (i4 * i5));
                if (sqrt > 0.0f) {
                    options.inSampleSize = b.c(sqrt);
                }
            }
        } else {
            options.inSampleSize = b.d(i2 / Math.max(i4, i5));
        }
        options.inJustDecodeBounds = false;
        i(options);
        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        if (decodeFileDescriptor == null) {
            return null;
        }
        float f2 = i2;
        if (i3 == 2) {
            max = Math.min(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight());
        } else {
            max = Math.max(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight());
        }
        float f3 = f2 / max;
        if (f3 <= 0.5d) {
            decodeFileDescriptor = b.i(decodeFileDescriptor, f3, true);
        }
        return g(decodeFileDescriptor);
    }

    public static Bitmap e(a.c cVar, String str, BitmapFactory.Options options, int i2, int i3) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    Bitmap d2 = d(cVar, fileInputStream.getFD(), options, i2, i3);
                    com.pinguo.album.j.a.f(fileInputStream);
                    return d2;
                } catch (Exception e2) {
                    e = e2;
                    us.pinguo.common.log.a.f(e);
                    com.pinguo.album.j.a.f(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                com.pinguo.album.j.a.f(fileInputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.pinguo.album.j.a.f(fileInputStream2);
            throw th;
        }
    }

    @TargetApi(11)
    public static Bitmap f(a.c cVar, byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (options.inSampleSize < 1) {
            options.inSampleSize = 1;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inBitmap = options.inSampleSize == 1 ? h(cVar, bArr, i2, i3, options) : null;
        try {
            Bitmap b = b(cVar, bArr, i2, i3, options);
            Bitmap bitmap = options.inBitmap;
            if (bitmap != null && bitmap != b) {
                PGAlbumBitmapPool.getInstance().f(options.inBitmap);
                options.inBitmap = null;
            }
            return b;
        } catch (IllegalArgumentException e2) {
            if (options.inBitmap != null) {
                us.pinguo.common.log.a.s("decode fail with a given bitmap, try decode to a new bitmap", new Object[0]);
                PGAlbumBitmapPool.getInstance().f(options.inBitmap);
                options.inBitmap = null;
                return b(cVar, bArr, i2, i3, options);
            }
            throw e2;
        }
    }

    public static Bitmap g(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != null) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        bitmap.recycle();
        return copy;
    }

    private static Bitmap h(a.c cVar, byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        c(cVar, bArr, i2, i3, options);
        return PGAlbumBitmapPool.getInstance().b(options.outWidth, options.outHeight);
    }

    @TargetApi(11)
    public static void i(BitmapFactory.Options options) {
        if (com.pinguo.album.common.a.f6016e) {
            options.inMutable = true;
        }
    }
}
