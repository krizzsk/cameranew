package com.growingio.android.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class SoftWareCanvas extends Canvas {
    private static final String TAG = "GIO.SoftWareCanvas";
    private WeakSet<Bitmap> bitmapWeakSet;
    private Bitmap mBitmap;

    public SoftWareCanvas(@NonNull Bitmap bitmap) {
        super(bitmap);
        this.bitmapWeakSet = new WeakSet<>();
        this.mBitmap = bitmap;
    }

    private Bitmap drawOnSFCanvas(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.bitmapWeakSet.add(copy);
        return copy;
    }

    private Paint replaceBitmapShader(Paint paint) {
        if (paint == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && (paint.getShader() instanceof BitmapShader)) {
            Paint paint2 = new Paint(paint);
            BitmapShader bitmapShader = (BitmapShader) paint2.getShader();
            try {
                Field field = BitmapShader.class.getField("mBitmap");
                field.setAccessible(true);
                if (((Bitmap) field.get(bitmapShader)).getConfig() == Bitmap.Config.HARDWARE) {
                    Field declaredField = BitmapShader.class.getDeclaredField("mTileX");
                    Field declaredField2 = BitmapShader.class.getDeclaredField("mTileY");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    Bitmap copy = ((Bitmap) field.get(bitmapShader)).copy(Bitmap.Config.ARGB_8888, false);
                    this.bitmapWeakSet.add(copy);
                    Class cls = Integer.TYPE;
                    Constructor declaredConstructor = BitmapShader.class.getDeclaredConstructor(Bitmap.class, cls, cls);
                    declaredConstructor.setAccessible(true);
                    BitmapShader bitmapShader2 = (BitmapShader) declaredConstructor.newInstance(copy, declaredField.get(bitmapShader), declaredField2.get(bitmapShader));
                    Matrix matrix = new Matrix();
                    paint.getShader().getLocalMatrix(matrix);
                    bitmapShader2.setLocalMatrix(matrix);
                    paint2.setShader(bitmapShader2);
                    return paint2;
                }
            } catch (Exception e2) {
                LogUtil.e(TAG, e2.toString());
            }
        }
        return paint;
    }

    public void destroy() {
        Iterator<Bitmap> it = this.bitmapWeakSet.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.bitmapWeakSet.clear();
    }

    @Override // android.graphics.Canvas
    public void drawArc(@NonNull RectF rectF, float f2, float f3, boolean z, @NonNull Paint paint) {
        super.drawArc(rectF, f2, f3, z, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull Bitmap bitmap, float f2, float f3, @Nullable Paint paint) {
        Bitmap drawOnSFCanvas = drawOnSFCanvas(bitmap);
        if (drawOnSFCanvas.getDensity() != this.mBitmap.getDensity()) {
            int i2 = (int) f2;
            int i3 = (int) f3;
            Rect rect = new Rect(i2, i3, drawOnSFCanvas.getWidth() + i2, drawOnSFCanvas.getHeight() + i3);
            super.drawBitmap(drawOnSFCanvas, rect, rect, replaceBitmapShader(paint));
            return;
        }
        super.drawBitmap(drawOnSFCanvas, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(@NonNull Bitmap bitmap, int i2, int i3, @NonNull float[] fArr, int i4, @Nullable int[] iArr, int i5, @Nullable Paint paint) {
        super.drawBitmapMesh(drawOnSFCanvas(bitmap), i2, i3, fArr, i4, iArr, i5, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f2, float f3, float f4, @NonNull Paint paint) {
        super.drawCircle(f2, f3, f4, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f2, float f3, float f4, float f5, @NonNull Paint paint) {
        super.drawLine(f2, f3, f4, f5, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawLines(@NonNull float[] fArr, int i2, int i3, @NonNull Paint paint) {
        super.drawLines(fArr, i2, i3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawOval(@NonNull RectF rectF, @NonNull Paint paint) {
        super.drawOval(rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPaint(@NonNull Paint paint) {
        super.drawPaint(replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPath(@NonNull Path path, @NonNull Paint paint) {
        super.drawPath(path, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f2, float f3, @NonNull Paint paint) {
        super.drawPoint(f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i2, int i3, @NonNull Paint paint) {
        super.drawPoints(fArr, i2, i3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPosText(@NonNull char[] cArr, int i2, int i3, @NonNull float[] fArr, @NonNull Paint paint) {
        super.drawPosText(cArr, i2, i3, fArr, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawRect(@NonNull RectF rectF, @NonNull Paint paint) {
        super.drawRect(rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(@NonNull RectF rectF, float f2, float f3, @NonNull Paint paint) {
        super.drawRoundRect(rectF, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawText(@NonNull char[] cArr, int i2, int i3, float f2, float f3, @NonNull Paint paint) {
        super.drawText(cArr, i2, i3, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(@NonNull char[] cArr, int i2, int i3, @NonNull Path path, float f2, float f3, @NonNull Paint paint) {
        super.drawTextOnPath(cArr, i2, i3, path, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(@Nullable RectF rectF, @Nullable Paint paint, int i2) {
        return super.saveLayer(rectF, replaceBitmapShader(paint), i2);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(@Nullable Bitmap bitmap) {
        super.setBitmap(drawOnSFCanvas(bitmap));
    }

    @Override // android.graphics.Canvas
    public void drawLines(@NonNull float[] fArr, @NonNull Paint paint) {
        super.drawLines(fArr, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f2, float f3, float f4, float f5, @NonNull Paint paint) {
        super.drawOval(f2, f3, f4, f5, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPoints(@NonNull float[] fArr, @NonNull Paint paint) {
        super.drawPoints(fArr, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawPosText(@NonNull String str, @NonNull float[] fArr, @NonNull Paint paint) {
        super.drawPosText(str, fArr, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawRect(@NonNull Rect rect, @NonNull Paint paint) {
        super.drawRect(rect, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f2, float f3, float f4, float f5, float f6, float f7, @NonNull Paint paint) {
        super.drawRoundRect(f2, f3, f4, f5, f6, f7, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawText(@NonNull String str, float f2, float f3, @NonNull Paint paint) {
        super.drawText(str, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(@NonNull String str, @NonNull Path path, float f2, float f3, @NonNull Paint paint) {
        super.drawTextOnPath(str, path, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(@Nullable RectF rectF, @Nullable Paint paint) {
        return super.saveLayer(rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f2, float f3, float f4, float f5, @NonNull Paint paint) {
        super.drawRect(f2, f3, f4, f5, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawText(@NonNull String str, int i2, int i3, float f2, float f3, @NonNull Paint paint) {
        super.drawText(str, i2, i3, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f2, float f3, float f4, float f5, @Nullable Paint paint, int i2) {
        return super.saveLayer(f2, f3, f4, f5, replaceBitmapShader(paint), i2);
    }

    @Override // android.graphics.Canvas
    public void drawText(@NonNull CharSequence charSequence, int i2, int i3, float f2, float f3, @NonNull Paint paint) {
        super.drawText(charSequence, i2, i3, f2, f3, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f2, float f3, float f4, float f5, @Nullable Paint paint) {
        return super.saveLayer(f2, f3, f4, f5, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect rect, @NonNull RectF rectF, @Nullable Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rectF, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull Bitmap bitmap, @Nullable Rect rect, @NonNull Rect rect2, @Nullable Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rect2, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull int[] iArr, int i2, int i3, float f2, float f3, int i4, int i5, boolean z, @Nullable Paint paint) {
        super.drawBitmap(iArr, i2, i3, f2, f3, i4, i5, z, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, @Nullable Paint paint) {
        super.drawBitmap(iArr, i2, i3, i4, i5, i6, i7, z, replaceBitmapShader(paint));
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(@NonNull Bitmap bitmap, @NonNull Matrix matrix, @Nullable Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), matrix, replaceBitmapShader(paint));
    }
}
