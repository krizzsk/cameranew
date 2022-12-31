package us.pinguo.inspire_proxy.media;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.IOException;
/* compiled from: ImageUtils.java */
/* loaded from: classes4.dex */
public class h {
    public static String a(String str, String str2) {
        Bitmap c = c(str, 1600);
        if (c == null) {
            return str;
        }
        Bitmap b = b(c, 1600);
        String a = new d.f.a.a.a.d.c().a(str2);
        File a2 = j.a(us.pinguo.foundation.e.b());
        String file = new File(a2, a + ".jpg").toString();
        us.pinguo.common.log.a.k("FFF", "zoom Image path：" + file);
        if (b != null) {
            c = b;
        }
        try {
            us.pinguo.util.e.t(file, c, 80);
            try {
                String attribute = new ExifInterface(str).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION);
                ExifInterface exifInterface = new ExifInterface(file);
                exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, attribute);
                exifInterface.saveAttributes();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return file;
        } catch (IOException e3) {
            us.pinguo.foundation.e.e(e3);
            return str;
        }
    }

    public static Bitmap b(Bitmap bitmap, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height || i2 < height) {
            if (height <= width || i2 < width) {
                float f2 = i2 * 1.0f;
                float f3 = f2 / width;
                float f4 = f2 / height;
                if (f3 > f4) {
                    f3 = f4;
                }
                Matrix matrix = new Matrix();
                matrix.postScale(f3, f3);
                try {
                    return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                } catch (OutOfMemoryError e2) {
                    us.pinguo.foundation.e.e(e2);
                    us.pinguo.common.log.a.k("zhouwei", "OOM了 ，返回原图吧！！");
                    return bitmap;
                }
            }
            return bitmap;
        }
        return bitmap;
    }

    public static Bitmap c(String str, int i2) {
        return us.pinguo.util.e.w(str, i2, 1, false);
    }
}
