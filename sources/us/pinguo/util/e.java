package us.pinguo.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: BitmapUtils.kt */
/* loaded from: classes6.dex */
public final class e {
    public static final e a = new e();

    /* compiled from: BitmapUtils.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private int a;
        private int b;
        private int c;

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public final void d(int i2, int i3, int i4) {
            this.c = i4;
            this.a = i2;
            this.b = i3;
        }
    }

    /* compiled from: BitmapUtils.kt */
    /* loaded from: classes6.dex */
    public static final class b extends com.facebook.imagepipeline.a.b {
        final /* synthetic */ kotlin.jvm.b.l<Bitmap, kotlin.u> a;
        final /* synthetic */ com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b;

        /* JADX WARN: Multi-variable type inference failed */
        b(kotlin.jvm.b.l<? super Bitmap, kotlin.u> lVar, com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> bVar) {
            this.a = lVar;
            this.b = bVar;
        }

        @Override // com.facebook.datasource.a
        protected void e(com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> dataSource) {
            kotlin.jvm.internal.s.h(dataSource, "dataSource");
            this.a.invoke(null);
            dataSource.close();
        }

        @Override // com.facebook.imagepipeline.a.b
        protected void g(Bitmap bitmap) {
            this.a.invoke(bitmap);
            this.b.close();
        }
    }

    private e() {
    }

    public static final Bitmap a(byte[] bytes) {
        kotlin.jvm.internal.s.h(bytes, "bytes");
        if (!(bytes.length == 0)) {
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        return null;
    }

    public static final void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final int c(BitmapFactory.Options options, int i2, int i3) {
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
        if (i2 == -1) {
            min = 128;
        } else {
            double d4 = i2;
            min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i3 == -1 && i2 == -1) {
            return 1;
        }
        return i2 == -1 ? ceil : min;
    }

    public static final int d(BitmapFactory.Options options, int i2, int i3) {
        kotlin.jvm.internal.s.h(options, "options");
        int c = a.c(options, i2, i3);
        if (c <= 8) {
            int i4 = 1;
            while (i4 < c) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((c + 7) / 8) * 8;
    }

    public static final Bitmap f(String path, int i2, int i3) {
        kotlin.jvm.internal.s.h(path, "path");
        byte[] a2 = kotlin.io.e.a(new File(path));
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(a2, 0, a2.length, options);
        int i4 = options.outWidth * options.outHeight;
        if (i4 < 10000) {
            return null;
        }
        float f2 = i4 / i2;
        options.inSampleSize = f2 >= 3.5f ? f2 < 7.0f ? 2 : f2 < 28.0f ? 4 : 8 : 1;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length, options);
        return i3 == 0 ? decodeByteArray : p(decodeByteArray, i3);
    }

    public static /* synthetic */ Bitmap g(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return f(str, i2, i3);
    }

    private final a i(int i2, int i3) {
        a aVar = new a();
        int abs = Math.abs(i3 - i2) >> 1;
        if (i2 < i3) {
            aVar.d(0, abs, i2);
        } else {
            aVar.d(abs, 0, i3);
        }
        return aVar;
    }

    public static final Bitmap j(Object obj, int i2, int i3) {
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException(kotlin.jvm.internal.s.q("length must between [10,5000],but value is:", Integer.valueOf(i2)));
        }
        boolean z = true;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("limitTarget must be LIMIT_MAXIMUM_LENGTH or LIMIT_SHORTEST_LENGTH ");
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            options.inJustDecodeBounds = true;
            if (obj instanceof String) {
                if (TextUtils.isEmpty((CharSequence) obj)) {
                    return null;
                }
                BitmapFactory.decodeFile((String) obj, options);
            } else if (obj instanceof byte[]) {
                if (obj == null) {
                    return null;
                }
                BitmapFactory.decodeStream(new ByteArrayInputStream((byte[]) obj), null, options);
            }
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                if (i3 != 1) {
                    z = false;
                }
                options.inSampleSize = l(options, i2, z);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if (obj instanceof String) {
                    return BitmapFactory.decodeFile((String) obj, options);
                }
                if (obj instanceof byte[]) {
                    return BitmapFactory.decodeStream(new ByteArrayInputStream((byte[]) obj), null, options);
                }
                return null;
            }
            return null;
        } catch (OutOfMemoryError e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    private final int k(int i2) {
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 != 6) {
                    if (i2 != 8) {
                        return 0;
                    }
                    return BaseBlurEffect.ROTATION_270;
                }
                return 90;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 0;
    }

    public static final int l(BitmapFactory.Options options, int i2, boolean z) {
        int i3;
        int i4;
        kotlin.jvm.internal.s.h(options, "options");
        int i5 = options.outWidth;
        if (z && i5 < (i4 = options.outHeight)) {
            i5 = i4;
        } else if (!z && i5 > (i3 = options.outHeight)) {
            i5 = i3;
        }
        int i6 = 1;
        while (i5 / i2 >= 2) {
            i6 <<= 1;
            i5 >>= 1;
        }
        return i6;
    }

    public static final Point m(Object picIndicate) {
        kotlin.jvm.internal.s.h(picIndicate, "picIndicate");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        if (picIndicate instanceof String) {
            BitmapFactory.decodeFile((String) picIndicate, options);
        } else if (picIndicate instanceof byte[]) {
            BitmapFactory.decodeStream(new ByteArrayInputStream((byte[]) picIndicate), null, options);
        } else if (picIndicate instanceof FileDescriptor) {
            BitmapFactory.decodeFileDescriptor((FileDescriptor) picIndicate, new Rect(-1, -1, -1, -1), options);
        } else {
            throw new Exception(kotlin.jvm.internal.s.q("not support this picture type of ", picIndicate.getClass()));
        }
        if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
            return new Point(options.outWidth, options.outHeight);
        }
        return new Point(-1, -1);
    }

    public static final Bitmap n(String filePath) throws Exception {
        kotlin.jvm.internal.s.h(filePath, "filePath");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                try {
                    mediaMetadataRetriever.setDataSource(filePath);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                    try {
                        mediaMetadataRetriever.release();
                        return frameAtTime;
                    } catch (RuntimeException e2) {
                        throw e2;
                    }
                } catch (IllegalArgumentException e3) {
                    throw e3;
                }
            } catch (RuntimeException e4) {
                throw e4;
            }
        } catch (Throwable th) {
            try {
                mediaMetadataRetriever.release();
                throw th;
            } catch (RuntimeException e5) {
                throw e5;
            }
        }
    }

    public static final Bitmap o(Bitmap bitmap, int i2, int i3) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        if (i2 >= 10 && i2 <= 5000) {
            a i4 = a.i(bitmap.getWidth(), bitmap.getHeight());
            float f2 = i2;
            return u(Bitmap.createBitmap(bitmap, i4.b(), i4.c(), i4.a(), i4.a()), f2 / createBitmap.getWidth(), f2 / createBitmap.getHeight(), i3);
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.s.q("length must between [10,5000],but value is:", Integer.valueOf(i2)));
    }

    public static final Bitmap p(Bitmap bitmap, int i2) {
        return (bitmap == null || i2 == 0) ? bitmap : u(bitmap, 1.0f, 1.0f, i2);
    }

    public static final Bitmap q(String str, BitmapFactory.Options options) {
        Bitmap decodeFile;
        if (str == null) {
            return null;
        }
        if (options != null) {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } else {
            decodeFile = BitmapFactory.decodeFile(str);
        }
        int rotationDegrees = new ExifInterface(str).getRotationDegrees();
        Bitmap p = rotationDegrees % BaseBlurEffect.ROTATION_360 != 0 ? p(decodeFile, rotationDegrees) : decodeFile;
        if (!kotlin.jvm.internal.s.c(p, decodeFile) && !decodeFile.isRecycled()) {
            decodeFile.recycle();
        }
        return p;
    }

    public static /* synthetic */ Bitmap r(String str, BitmapFactory.Options options, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            options = null;
        }
        return q(str, options);
    }

    public static final Bitmap s(Bitmap bitmap, int i2) {
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f2 = 2;
        matrix.setRotate(i2, bitmap.getWidth() / f2, bitmap.getHeight() / f2);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return !kotlin.jvm.internal.s.c(bitmap, createBitmap) ? createBitmap : bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static final void t(String path, Bitmap bitmap, int i2) throws IOException {
        kotlin.jvm.internal.s.h(path, "path");
        if (!TextUtils.isEmpty(path) && bitmap != null) {
            BufferedOutputStream bufferedOutputStream = null;
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(path));
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                    b(bufferedOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    b(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IOException("参数错误:path=" + path + " /bitmap:" + bitmap);
        }
    }

    public static final Bitmap u(Bitmap bitmap, float f2, float f3, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        if (i2 != 0) {
            matrix.postRotate(i2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        kotlin.jvm.internal.s.c(createBitmap, bitmap);
        return createBitmap;
    }

    public static final Bitmap v(Bitmap bitmap, int i2, int i3, int i4) {
        float f2;
        float f3;
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException(kotlin.jvm.internal.s.q("length must between [10,5000],but value is:", Integer.valueOf(i2)));
        }
        if (bitmap == null) {
            return null;
        }
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("limitTarget must be LIMIT_MAXIMUM_LENGTH or LIMIT_SHORTEST_LENGTH ");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height ? i3 != 1 : i3 == 1) {
            f2 = i2;
            f3 = width;
        } else {
            f2 = i2;
            f3 = height;
        }
        float f4 = f2 / f3;
        if (Math.abs(f4 - 1) < 0.01f) {
            return i4 % BaseBlurEffect.ROTATION_360 == 0 ? bitmap : p(bitmap, i4);
        }
        return u(bitmap, f4, f4, i4);
    }

    public static final Bitmap w(Object obj, int i2, int i3, boolean z) {
        if (i2 >= 10 && i2 <= 5000) {
            e eVar = a;
            if (i3 != 1 && i3 != 2) {
                throw new IllegalArgumentException("limitTarget must be LIMIT_MAXIMUM_LENGTH or LIMIT_SHORTEST_LENGTH ");
            }
            Bitmap j2 = j(obj, i2, i3);
            try {
                int i4 = 0;
                if (obj instanceof String) {
                    if (z) {
                        try {
                            i4 = eVar.k(new android.media.ExifInterface((String) obj).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
                        } catch (IOException unused) {
                        }
                    }
                } else if ((obj instanceof byte[]) && z) {
                    i4 = j.j((byte[]) obj);
                }
                return v(j2, i2, i3, i4);
            } catch (OutOfMemoryError e2) {
                us.pinguo.common.log.a.f(e2);
                return null;
            }
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.s.q("length must between [10,5000],but value is:", Integer.valueOf(i2)));
    }

    public static final Bitmap x(Matrix matrix, Bitmap source, int i2, int i3, boolean z) {
        Matrix matrix2;
        Bitmap bitmap;
        kotlin.jvm.internal.s.h(source, "source");
        int width = source.getWidth() - i2;
        int height = source.getHeight() - i3;
        if (!z && (width < 0 || height < 0)) {
            Bitmap b2 = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(b2);
            int max = Math.max(0, width / 2);
            int max2 = Math.max(0, height / 2);
            Rect rect = new Rect(max, max2, Math.min(i2, source.getWidth()) + max, Math.min(i3, source.getHeight()) + max2);
            int width2 = (i2 - rect.width()) / 2;
            int height2 = (i3 - rect.height()) / 2;
            canvas.drawBitmap(source, rect, new Rect(width2, height2, i2 - width2, i3 - height2), (Paint) null);
            kotlin.jvm.internal.s.g(b2, "b2");
            return b2;
        }
        float width3 = source.getWidth();
        float height3 = source.getHeight();
        float f2 = i2;
        float f3 = i3;
        if (width3 / height3 > f2 / f3) {
            float f4 = f3 / height3;
            if (f4 < 0.9f || f4 > 1.0f) {
                kotlin.jvm.internal.s.e(matrix);
                matrix.setScale(f4, f4);
                matrix2 = matrix;
            }
            matrix2 = null;
        } else {
            float f5 = f2 / width3;
            if (f5 < 0.9f || f5 > 1.0f) {
                kotlin.jvm.internal.s.e(matrix);
                matrix.setScale(f5, f5);
                matrix2 = matrix;
            }
            matrix2 = null;
        }
        if (matrix2 != null) {
            bitmap = Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix2, true);
            kotlin.jvm.internal.s.g(bitmap, "createBitmap(source, 0, …rce.height, scaler, true)");
        } else {
            bitmap = source;
        }
        Bitmap b22 = Bitmap.createBitmap(bitmap, Math.max(0, bitmap.getWidth() - i2) / 2, Math.max(0, bitmap.getHeight() - i3) / 2, i2, i3);
        kotlin.jvm.internal.s.c(bitmap, source);
        kotlin.jvm.internal.s.g(b22, "b2");
        return b22;
    }

    public final Bitmap e(String path, BitmapFactory.Options options, int i2) {
        int c;
        kotlin.jvm.internal.s.h(path, "path");
        kotlin.jvm.internal.s.h(options, "options");
        byte[] a2 = kotlin.io.e.a(new File(path));
        options.inSampleSize = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(a2, 0, a2.length, options);
        int max = Math.max(options.outWidth, options.outHeight);
        if (max < 10) {
            return null;
        }
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        c = kotlin.z.j.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
        float f2 = max / c;
        options.inSampleSize = f2 >= 1.75f ? f2 < 3.5f ? 2 : f2 < 7.0f ? 4 : 8 : 1;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length, options);
        return i2 == 0 ? decodeByteArray : p(decodeByteArray, i2);
    }

    public final void h(String url, kotlin.jvm.b.l<? super Bitmap, kotlin.u> onBitmapDecoded) {
        kotlin.jvm.internal.s.h(url, "url");
        kotlin.jvm.internal.s.h(onBitmapDecoded, "onBitmapDecoded");
        Uri parse = Uri.parse(url);
        Context a2 = v.a();
        com.facebook.datasource.b<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b2 = com.facebook.drawee.backends.pipeline.c.a().b(ImageRequest.a(parse), a2);
        if (b2 == null) {
            return;
        }
        b2.d(new b(onBitmapDecoded, b2), CallerThreadExecutor.getInstance());
    }
}
