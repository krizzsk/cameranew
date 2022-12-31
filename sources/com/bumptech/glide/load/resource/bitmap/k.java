package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class k {
    public static Bitmap a(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i2 && bitmap2.getHeight() == i3) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (bitmap2.getWidth() * i3 > bitmap2.getHeight() * i2) {
            width = i3 / bitmap2.getHeight();
            f2 = (i2 - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap2.getWidth();
            height = (i3 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i2, i3, d(bitmap2));
        }
        g(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * min);
        int height = (int) (bitmap.getHeight() * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config d2 = d(bitmap);
        Bitmap d3 = cVar.d(width, height, d2);
        if (d3 == null) {
            d3 = Bitmap.createBitmap(width, height, d2);
        }
        g(bitmap, d3);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i2 + "x" + i3);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + d3.getWidth() + "x" + d3.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(min);
            Log.v("TransformationUtils", sb.toString());
        }
        Canvas canvas = new Canvas(d3);
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return d3;
    }

    public static int c(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return BaseBlurEffect.ROTATION_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return BaseBlurEffect.ROTATION_270;
            default:
                return 0;
        }
    }

    private static Bitmap.Config d(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    static void e(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }

    public static Bitmap f(Bitmap bitmap, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, int i2) {
        Matrix matrix = new Matrix();
        e(i2, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Bitmap.Config d2 = d(bitmap);
        Bitmap d3 = cVar.d(round, round2, d2);
        if (d3 == null) {
            d3 = Bitmap.createBitmap(round, round2, d2);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(d3).drawBitmap(bitmap, matrix, new Paint(6));
        return d3;
    }

    @TargetApi(12)
    public static void g(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT < 12 || bitmap2 == null) {
            return;
        }
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
