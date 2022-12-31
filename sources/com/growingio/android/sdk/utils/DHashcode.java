package com.growingio.android.sdk.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class DHashcode {
    private static final int HASH_SIZE = 8;
    public static final String TAG = "GIO.DHashcode";
    public static Map<Integer, String> cacheHash = new HashMap();

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        if (drawable.getBounds() == null) {
            return null;
        }
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmapFromImageView(View view) throws Throwable {
        NinePatch ninePatch;
        Bitmap bitmap = null;
        Drawable drawable = view instanceof ImageView ? ((ImageView) view).getDrawable() : null;
        if (drawable == null) {
            LogUtil.e(TAG, "imageView.getDrawable() == null");
            return null;
        }
        GConfig config = CoreInitialize.config();
        if (drawable.getIntrinsicHeight() <= config.getImageViewCollectionSize() && drawable.getIntrinsicWidth() <= config.getImageViewCollectionSize()) {
            if (drawable instanceof NinePatchDrawable) {
                NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) drawable;
                try {
                    Field declaredField = NinePatchDrawable.class.getDeclaredField("mNinePatch");
                    declaredField.setAccessible(true);
                    ninePatch = (NinePatch) declaredField.get(ninePatchDrawable);
                } catch (Throwable th) {
                    th.printStackTrace();
                    ninePatch = null;
                }
                if (Build.VERSION.SDK_INT >= 19 && ninePatch != null && ninePatch.getBitmap() == null) {
                    bitmap = ninePatch.getBitmap();
                }
            } else if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            return bitmap == null ? drawableToBitmap(drawable) : bitmap;
        }
        LogUtil.e(TAG, "drawable.getIntrinsicHeight() > BITMAP_SIZE " + drawable.getIntrinsicHeight() + " " + drawable.getIntrinsicWidth());
        return null;
    }

    public static String getDHash(View view) {
        if (view == null) {
            return "";
        }
        try {
            Bitmap bitmapFromImageView = getBitmapFromImageView(view);
            if (bitmapFromImageView == null) {
                LogUtil.e(TAG, "Util.getBitmapFromImageView == null");
                return "";
            }
            return getDhash(bitmapFromImageView);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getDhash(Bitmap bitmap) throws Throwable {
        Bitmap grayscale = toGrayscale(Bitmap.createScaledBitmap(bitmap, 9, 8, true));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = 0;
            while (i3 < 8) {
                int pixel = grayscale.getPixel(i3, i2);
                i3++;
                stringBuffer.append(pixel > grayscale.getPixel(i3, i2) ? "1" : "0");
            }
        }
        return String.valueOf(UnsignedLongs.parseUnsignedLong(stringBuffer.toString(), 2));
    }

    private static Bitmap toGrayscale(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }
}
