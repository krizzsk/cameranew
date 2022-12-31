package us.pinguo.foundation.t.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.IOException;
/* compiled from: PhotoUtil.java */
/* loaded from: classes4.dex */
public class b {
    private static final String a = "b";
    public static int b = 5;

    public static int a(Context context, int i2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return (int) (displayMetrics.density * i2);
    }

    public static Rect b(Rect rect, int i2, int i3, float f2, float f3) {
        if (rect == null) {
            rect = new Rect();
        }
        float f4 = f2 / f3;
        float f5 = i2;
        float f6 = i3;
        float f7 = f5 / f6;
        if (Math.abs(f4 - f7) < 0.01d) {
            rect.left = 0;
            rect.top = 0;
            rect.right = i2;
            rect.bottom = i3;
        } else if (f7 > f4) {
            float f8 = f3 / f6;
            int i4 = (int) ((((f5 * f8) - f2) / f8) / 2.0f);
            rect.left = i4;
            rect.top = 0;
            rect.right = i2 - i4;
            rect.bottom = i3;
        } else {
            float f9 = f2 / f5;
            rect.left = 0;
            int i5 = (int) ((((f6 * f9) - f3) / f9) / 2.0f);
            rect.top = i5;
            rect.right = i2;
            rect.bottom = i3 - i5;
        }
        return rect;
    }

    public static Rect c(Rect rect, int i2, int i3, float f2, float f3) {
        if (rect == null) {
            rect = new Rect();
        }
        float f4 = f2 / f3;
        float f5 = i2;
        float f6 = i3;
        float f7 = f5 / f6;
        if (Math.abs(f4 - f7) < 0.01d) {
            rect.left = 0;
            rect.top = 0;
            rect.right = i2;
            rect.bottom = i3;
        } else if (f7 > f4) {
            float f8 = f3 / f6;
            int i4 = (int) ((((f5 * f8) - f2) / f8) / 2.0f);
            rect.left = i4;
            rect.top = 0;
            rect.right = i2 - i4;
            rect.bottom = i3;
        } else {
            float f9 = f2 / f5;
            rect.left = 0;
            rect.top = 0;
            rect.right = i2;
            rect.bottom = i3 - ((int) (((f6 * f9) - f3) / f9));
        }
        return rect;
    }

    public static int d(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 1) {
                if (attributeInt != 3) {
                    if (attributeInt != 6) {
                        if (attributeInt != 8) {
                            return 0;
                        }
                        return BaseBlurEffect.ROTATION_270;
                    }
                    return 90;
                }
                return BaseBlurEffect.ROTATION_180;
            }
            return 0;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Bitmap e(Bitmap bitmap, Rect rect) {
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || rect == null || rect.width() <= 0 || rect.height() <= 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        Matrix matrix = new Matrix();
        int i2 = 1;
        for (int i3 = 0; i3 < b; i3++) {
            try {
                matrix.setScale(1 / i2, 1 / i2);
                bitmap2 = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                break;
            } catch (Exception unused) {
                return bitmap;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                i2 *= 2;
                String str = a;
                us.pinguo.common.log.a.k(str, "OutOfMemory in safeClipBitmap,set sampleSize to " + i2);
            }
        }
        if (bitmap2 != bitmap) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static Bitmap f(Bitmap bitmap, int i2) {
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || i2 == 0) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        Matrix matrix = new Matrix();
        int i3 = 1;
        for (int i4 = 0; i4 < b; i4++) {
            try {
                matrix.setRotate(i2);
                float f2 = 1.0f / i3;
                matrix.postScale(f2, f2);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                String str = a;
                us.pinguo.common.log.a.k(str, "rotate bitmap,degree:" + i2);
                break;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                i3 *= 2;
                String str2 = a;
                us.pinguo.common.log.a.k(str2, "OutOfMemory in safeRotateBitmap,set sampleSize to " + i3);
            }
        }
        if (bitmap2 != bitmap) {
            bitmap.recycle();
        }
        return bitmap2;
    }

    public static Bitmap g(Bitmap bitmap, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && i4 > 0 && i5 > 0) {
            float height = bitmap.getHeight();
            float f2 = i5;
            float width = bitmap.getWidth();
            float f3 = i4;
            if (height / f2 < width / f3) {
                i4 = (int) (f2 * (width / height));
            } else {
                i5 = (int) (f3 * (height / width));
            }
            Matrix matrix = new Matrix();
            int i6 = i4;
            int i7 = i5;
            Bitmap bitmap2 = null;
            for (int i8 = 0; i8 < b; i8++) {
                try {
                    matrix.setScale(i6 / width, i7 / height);
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    us.pinguo.common.log.a.k("scale bitmap to:" + i6 + "X" + i7, new Object[0]);
                    break;
                } catch (OutOfMemoryError unused) {
                    i6 /= 2;
                    i7 /= 2;
                    if (i6 == 0 || i7 == 0) {
                        break;
                    }
                    us.pinguo.common.log.a.k("OutOfMemory in safeScaleBitmap,set sampleSize to " + i6 + "X" + i7, new Object[0]);
                }
            }
            return bitmap2 == null ? bitmap : bitmap2;
        }
        us.pinguo.common.log.a.f(new IllegalArgumentException("bitmap异常或目标高宽不大于0"));
        return bitmap;
    }
}
