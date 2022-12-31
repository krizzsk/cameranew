package us.pinguo.advconfigdata.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.ExifInterface;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class AdvBitmapUtils {
    private static final float DEVIATION = 0.002f;
    private static final float PRECISION = 0.01f;
    private static final int UNCONSTRAINED = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        public int a;
        public int b;
        public int c;

        private b() {
        }

        public void a(int i2, int i3, int i4) {
            this.c = i4;
            this.a = i2;
            this.b = i3;
        }
    }

    private AdvBitmapUtils() {
    }

    public static byte[] Bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i2, int i3) {
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

    public static int computeSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i2, i3);
        if (computeInitialSampleSize <= 8) {
            int i4 = 1;
            while (i4 < computeInitialSampleSize) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((computeInitialSampleSize + 7) / 8) * 8;
    }

    public static Bitmap drawShadow(Bitmap bitmap, int i2) {
        AdvLog.Log("drawShadow start");
        if (bitmap == null) {
            return null;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(i2, BlurMaskFilter.Blur.NORMAL);
        Paint paint = new Paint();
        paint.setMaskFilter(blurMaskFilter);
        Bitmap extractAlpha = bitmap.extractAlpha(paint, new int[2]);
        AdvLog.Log("drawShadow shadowImage width = " + extractAlpha.getWidth() + " height =- " + extractAlpha.getHeight());
        Bitmap copy = extractAlpha.copy(Bitmap.Config.ARGB_8888, true);
        if (Build.VERSION.SDK_INT >= 19 && !copy.isPremultiplied()) {
            copy.setPremultiplied(true);
        }
        new Canvas(copy).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        AdvLog.Log("drawShadow end org bitmap width " + bitmap.getWidth() + " height = " + bitmap.getHeight());
        return copy;
    }

    public static Bitmap extractMiniThumb(Bitmap bitmap, int i2, int i3, boolean z) {
        float f2;
        int height;
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() < bitmap.getHeight()) {
            f2 = i2;
            height = bitmap.getWidth();
        } else {
            f2 = i3;
            height = bitmap.getHeight();
        }
        float f3 = f2 / height;
        Matrix matrix = new Matrix();
        matrix.setScale(f3, f3);
        Bitmap transform = transform(matrix, bitmap, i2, i3, false);
        if (z && transform != bitmap) {
            bitmap.recycle();
        }
        return transform;
    }

    public static b getCenterClipInfo(int i2, int i3) {
        b bVar = new b();
        int abs = Math.abs(i3 - i2) >> 1;
        if (i2 < i3) {
            bVar.a(0, abs, i2);
        } else {
            bVar.a(abs, 0, i3);
        }
        return bVar;
    }

    public static Bitmap getCropImage(Bitmap bitmap, float f2) {
        if (f2 == 0.0f) {
            return bitmap;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                if (width < height) {
                    float f3 = height;
                    float f4 = width;
                    float f5 = f3 / f4;
                    if (isEqual(f5, f2)) {
                        return bitmap;
                    }
                    if (f5 > f2) {
                        int i2 = (int) ((f4 * f2) + 0.5f);
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, (height - i2) / 2, width, i2);
                        bitmap.recycle();
                        return createBitmap;
                    }
                    int i3 = (int) ((f3 / f2) + 0.5f);
                    Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, (width - i3) / 2, 0, i3, height);
                    bitmap.recycle();
                    return createBitmap2;
                }
                float f6 = width;
                float f7 = height;
                float f8 = f6 / f7;
                if (isEqual(f8, f2)) {
                    return bitmap;
                }
                if (f8 > f2) {
                    int i4 = (int) ((f7 * f2) + 0.5f);
                    Bitmap createBitmap3 = Bitmap.createBitmap(bitmap, (width - i4) / 2, 0, i4, height);
                    bitmap.recycle();
                    return createBitmap3;
                }
                int i5 = (int) ((f6 / f2) + 0.5f);
                Bitmap createBitmap4 = Bitmap.createBitmap(bitmap, 0, (height - i5) / 2, width, i5);
                bitmap.recycle();
                return createBitmap4;
            }
        }
        return null;
    }

    public static Bitmap getMirrorBitmap(Bitmap bitmap) {
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(createBitmap);
        Camera camera = new Camera();
        Matrix matrix = new Matrix();
        camera.rotateY(180.0f);
        camera.getMatrix(matrix);
        matrix.postTranslate(bitmap.getWidth(), 0.0f);
        canvas.save();
        canvas.drawBitmap(bitmap, matrix, paint);
        canvas.restore();
        return createBitmap;
    }

    private static int getOrientation(int i2) {
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

    public static Bitmap getRotateBitmap(Bitmap bitmap, String str) {
        int i2 = 0;
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt == 3) {
                i2 = BaseBlurEffect.ROTATION_180;
            } else if (attributeInt == 6) {
                i2 = 90;
            } else if (attributeInt == 8) {
                i2 = BaseBlurEffect.ROTATION_270;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (bitmap != null && i2 > 0) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != null && createBitmap != bitmap) {
                bitmap.recycle();
                return createBitmap;
            }
        }
        return bitmap;
    }

    public static int getSampleSize(BitmapFactory.Options options, int i2, boolean z) {
        int i3;
        int i4;
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

    public static Bitmap getScaleCropImage(Bitmap bitmap, float f2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > 0 && height > 0) {
                float f3 = height;
                float f4 = width;
                float f5 = f3 / f4;
                AdvLog.Log("onImageAvailable", "oldScale -= " + f5 + " scale = " + f2);
                if (isEqual(f5, f2)) {
                    return bitmap;
                }
                if (f5 > f2) {
                    int i2 = (int) ((f4 * f2) + 0.5f);
                    int i3 = (height - i2) / 2;
                    AdvLog.Log("onImageAvailable", "1111 h = " + i2 + " w = " + width + " x = 0 y = " + i3);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, i3, width, i2);
                    bitmap.recycle();
                    return createBitmap;
                }
                int i4 = (int) ((f3 / f2) + 0.5f);
                int i5 = (width - i4) / 2;
                AdvLog.Log("onImageAvailable", "2222 h = " + height + " w = " + i4 + " x = " + i5 + " y = 0");
                Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, i5, 0, i4, height);
                bitmap.recycle();
                return createBitmap2;
            }
        }
        return null;
    }

    private static boolean isEqual(float f2, float f3) {
        return Math.abs(f2 - f3) <= 0.002f;
    }

    public static Bitmap makeBitmap(byte[] bArr, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                options.inSampleSize = computeSampleSize(options, -1, i2);
                options.inJustDecodeBounds = false;
                options.inDither = false;
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            }
            return null;
        } catch (OutOfMemoryError e2) {
            AdvLog.Log(e2.getMessage());
            return null;
        }
    }

    public static Bitmap makeTextBitmap(String str, float f2) {
        Rect rect = new Rect();
        Typeface create = Typeface.create("黑体", 0);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setTypeface(create);
        paint.setTextSize(f2);
        paint.setShadowLayer(0.5f, 1.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
        paint.getTextBounds(str, 0, str.length(), rect);
        int height = rect.height() + 6;
        Bitmap createBitmap = Bitmap.createBitmap(rect.width() + 6, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(0);
        canvas.drawARGB(0, 255, 255, 255);
        canvas.drawText(str, 2.0f, height - 3, paint);
        return createBitmap;
    }

    public static Bitmap makeThumbnail(Bitmap bitmap, int i2, int i3) {
        if (i2 >= 10 && i2 <= 5000) {
            b centerClipInfo = getCenterClipInfo(bitmap.getWidth(), bitmap.getHeight());
            int i4 = centerClipInfo.a;
            int i5 = centerClipInfo.b;
            int i6 = centerClipInfo.c;
            return zoomAndRotate(Bitmap.createBitmap(bitmap, i4, i5, i6, i6), i2, i2, i3);
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }

    public static Bitmap resizeImage(Bitmap bitmap, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i2 / width, i3 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap rotate(Bitmap bitmap, int i2) {
        if (i2 == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap != createBitmap) {
                bitmap.recycle();
                return createBitmap;
            }
            return bitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i2) {
        if (bitmap == null || i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap rotateBitmapIntate(Bitmap bitmap, int i2) {
        if (bitmap == null || i2 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
        } else if (bitmap == null) {
            return null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width >= height) {
                f2 = i2;
                f3 = width;
            } else {
                f2 = i2;
                f3 = height;
            }
            float f4 = f2 / f3;
            if (Math.abs(f4 - 1.0f) < PRECISION) {
                return i3 % BaseBlurEffect.ROTATION_360 == 0 ? bitmap : rotateBitmap(bitmap, i3);
            }
            return scaleBitmap(bitmap, f4, f4, i3);
        }
    }

    public static Bitmap scaleBitmapNoRecycle(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
        } else if (bitmap == null) {
            return null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width >= height) {
                f2 = i2;
                f3 = width;
            } else {
                f2 = i2;
                f3 = height;
            }
            float f4 = f2 / f3;
            if (Math.abs(f4 - 1.0f) < PRECISION) {
                return i3 % BaseBlurEffect.ROTATION_360 == 0 ? bitmap : rotateBitmap(bitmap, i3);
            }
            return scaleBitmapNoRecycle(bitmap, f4, f4, i3);
        }
    }

    public static Bitmap scaleJpegPath(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = (int) (((float) Math.sqrt(((options.outWidth * options.outHeight) * 1.0d) / (i2 * i3))) + 0.8d);
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap scaleMinBitmap(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
        } else if (bitmap == null) {
            return null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width < height) {
                f2 = i2;
                f3 = width;
            } else {
                f2 = i2;
                f3 = height;
            }
            float f4 = f2 / f3;
            if (Math.abs(f4 - 1.0f) < PRECISION) {
                return i3 % BaseBlurEffect.ROTATION_360 == 0 ? bitmap : rotateBitmap(bitmap, i3);
            }
            return scaleBitmap(bitmap, f4, f4, i3);
        }
    }

    public static Bitmap scalePicture(byte[] bArr, int i2, boolean z) {
        if (bArr == null) {
            return null;
        }
        if (i2 >= 10 && i2 <= 5000) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = getSampleSize(options, i2, true);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return scaleBitmap(BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options), i2, z ? AdvBitmapExif.getOrientation(bArr) : 0);
                }
                return null;
            } catch (OutOfMemoryError e2) {
                AdvLog.Log(e2.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }

    private static Bitmap scalePreviewBitmap(Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (i2 < 10 || i2 > 5000) {
            throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
        } else if (bitmap == null) {
            return null;
        } else {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width >= height) {
                f2 = i2;
                f3 = width;
            } else {
                f2 = i2;
                f3 = height;
            }
            float f4 = f2 / f3;
            if (f4 > 0.95f) {
                return i3 == 0 ? bitmap : getRotateBitmap(bitmap, i3);
            }
            return scaleBitmap(bitmap, f4, f4, i3);
        }
    }

    public static Bitmap scalePreviewJpegData(byte[] bArr, int i2, int i3) {
        if (i2 >= 10 && i2 <= 5000) {
            try {
                AdvLog.Log("scalePreviewJpegData begin");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = getSampleSize(options, i2, true);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap decodeStream = BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                    AdvLog.Log("scalePreviewJpegData end ");
                    AdvLog.Log("scalePreviewBitmap start ");
                    return scalePreviewBitmap(decodeStream, i2, i3);
                }
                return null;
            } catch (OutOfMemoryError e2) {
                AdvLog.Log(e2.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap transform(android.graphics.Matrix r14, android.graphics.Bitmap r15, int r16, int r17, boolean r18) {
        /*
            r0 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            int r1 = r15.getWidth()
            int r1 = r1 - r8
            int r2 = r15.getHeight()
            int r2 = r2 - r9
            r3 = 0
            r10 = 0
            if (r18 != 0) goto L61
            if (r1 < 0) goto L18
            if (r2 >= 0) goto L61
        L18:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r8, r9, r0)
            android.graphics.Canvas r4 = new android.graphics.Canvas
            r4.<init>(r0)
            int r1 = r1 / 2
            int r1 = java.lang.Math.max(r10, r1)
            int r2 = r2 / 2
            int r2 = java.lang.Math.max(r10, r2)
            android.graphics.Rect r5 = new android.graphics.Rect
            int r6 = r15.getWidth()
            int r6 = java.lang.Math.min(r8, r6)
            int r6 = r6 + r1
            int r10 = r15.getHeight()
            int r10 = java.lang.Math.min(r9, r10)
            int r10 = r10 + r2
            r5.<init>(r1, r2, r6, r10)
            int r1 = r5.width()
            int r1 = r8 - r1
            int r1 = r1 / 2
            int r2 = r5.height()
            int r2 = r9 - r2
            int r2 = r2 / 2
            android.graphics.Rect r6 = new android.graphics.Rect
            int r8 = r8 - r1
            int r9 = r9 - r2
            r6.<init>(r1, r2, r8, r9)
            r4.drawBitmap(r15, r5, r6, r3)
            return r0
        L61:
            int r1 = r15.getWidth()
            float r1 = (float) r1
            int r2 = r15.getHeight()
            float r2 = (float) r2
            float r4 = r1 / r2
            float r5 = (float) r8
            float r6 = (float) r9
            float r11 = r5 / r6
            r12 = 1065353216(0x3f800000, float:1.0)
            r13 = 1063675494(0x3f666666, float:0.9)
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 <= 0) goto L8a
            float r6 = r6 / r2
            int r1 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r1 < 0) goto L86
            int r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r1 <= 0) goto L84
            goto L86
        L84:
            r0 = r3
            goto L99
        L86:
            r14.setScale(r6, r6)
            goto L99
        L8a:
            float r5 = r5 / r1
            int r1 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r1 < 0) goto L96
            int r1 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r1 <= 0) goto L94
            goto L96
        L94:
            r5 = r3
            goto L9a
        L96:
            r14.setScale(r5, r5)
        L99:
            r5 = r0
        L9a:
            if (r5 == 0) goto Lad
            r1 = 0
            r2 = 0
            int r3 = r15.getWidth()
            int r4 = r15.getHeight()
            r6 = 1
            r0 = r15
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            goto Lae
        Lad:
            r0 = r7
        Lae:
            int r1 = r0.getWidth()
            int r1 = r1 - r8
            int r1 = java.lang.Math.max(r10, r1)
            int r2 = r0.getHeight()
            int r2 = r2 - r9
            int r2 = java.lang.Math.max(r10, r2)
            int r1 = r1 / 2
            int r2 = r2 / 2
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r8, r9)
            if (r0 == r7) goto Lcd
            r0.recycle()
        Lcd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.advconfigdata.Utils.AdvBitmapUtils.transform(android.graphics.Matrix, android.graphics.Bitmap, int, int, boolean):android.graphics.Bitmap");
    }

    public static Bitmap zoomAndRotate(Bitmap bitmap, int i2, int i3, int i4) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        float f2 = i2 / width;
        float f3 = i3 / height;
        matrix.reset();
        if (i4 != 0) {
            matrix.postRotate(i4);
        }
        matrix.postScale(f2, f3);
        if (height > 0 && width > 0) {
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (Exception e2) {
                AdvLog.Log(e2.getMessage());
                throw new IllegalStateException("orgSize : " + width + "x" + height + ", size : " + i2 + "x" + i3 + ", matrix : " + matrix.toShortString());
            }
        }
        throw new IllegalArgumentException("Width or Heigth < 0:" + height + "/" + width + "/" + matrix.toString() + "/" + i2 + "/" + i3 + "/" + i4);
    }

    public static Bitmap makeThumbnail(byte[] bArr, int i2, int i3) {
        if (i2 >= 10 && i2 <= 5000) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = getSampleSize(options, i2, true);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return makeThumbnail(BitmapFactory.decodeStream(new ByteArrayInputStream(bArr), null, options), i2, i3);
                }
                return null;
            } catch (OutOfMemoryError e2) {
                AdvLog.Log(e2.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }

    public static Bitmap getRotateBitmap(Bitmap bitmap, int i2) {
        if (bitmap == null || i2 <= 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float f2, float f3, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        if (i2 != 0) {
            matrix.postRotate(i2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap scaleBitmapNoRecycle(Bitmap bitmap, float f2, float f3, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f2, f3);
        if (i2 != 0) {
            matrix.postRotate(i2);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap scalePicture(String str, int i2, boolean z) {
        if (i2 >= 10 && i2 <= 5000) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = getSampleSize(options, i2, true);
                    int i3 = 0;
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    if (z) {
                        try {
                            i3 = getOrientation(new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1));
                        } catch (IOException unused) {
                        }
                    }
                    return scaleBitmap(decodeFile, i2, i3);
                }
                return null;
            } catch (OutOfMemoryError e2) {
                AdvLog.Log(e2.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }

    public static Bitmap makeThumbnail(String str, int i2, int i3) {
        if (i2 >= 10 && i2 <= 5000) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 1;
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                if (!options.mCancel && options.outWidth != -1 && options.outHeight != -1) {
                    options.inSampleSize = getSampleSize(options, i2, true);
                    options.inJustDecodeBounds = false;
                    options.inDither = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return makeThumbnail(BitmapFactory.decodeFile(str, options), i2, i3);
                }
                return null;
            } catch (OutOfMemoryError e2) {
                AdvLog.Log(e2.getMessage());
                return null;
            }
        }
        throw new IllegalArgumentException("length must between [10,5000],but value is:" + i2);
    }
}
