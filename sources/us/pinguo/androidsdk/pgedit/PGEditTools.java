package us.pinguo.androidsdk.pgedit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.os.StatFs;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.File;
/* loaded from: classes3.dex */
public class PGEditTools {
    public static void deleteAll(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteAll(file2);
            }
        }
        file.delete();
    }

    public static boolean deleteFileAndFolder(String str) {
        File file = new File(str);
        deleteAll(file);
        return !file.exists();
    }

    public static Bitmap getBitmap(String str, int i2) {
        return getBitmap(str, i2, getRotatedDegree(str));
    }

    public static Bitmap getRotateBitmap(Bitmap bitmap, int i2) {
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

    public static int getRotatedDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
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
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static long getSDFreeSize() {
        String path = Environment.getExternalStorageDirectory().getPath();
        if (path == null) {
            return 0L;
        }
        StatFs statFs = new StatFs(path);
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static boolean hasSD() {
        try {
            return getSDFreeSize() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Bitmap getBitmap(String str, int i2, int i3) {
        int i4;
        Bitmap rotateBitmap;
        if (i2 > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i5 = options.outWidth;
            if (i5 <= 0 || (i4 = options.outHeight) <= 0) {
                return null;
            }
            int max = Math.max(i5, i4) / i2;
            options.inSampleSize = max;
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                return null;
            }
            if (max != 0) {
                Matrix matrix = new Matrix();
                if (i3 != 0) {
                    matrix.setRotate(i3);
                }
                float max2 = i2 / Math.max(decodeFile.getWidth(), decodeFile.getHeight());
                matrix.postScale(max2, max2);
                rotateBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            } else {
                rotateBitmap = getRotateBitmap(decodeFile, i3);
            }
            if (rotateBitmap != decodeFile) {
                decodeFile.recycle();
            }
            return rotateBitmap;
        }
        throw new IllegalArgumentException("size is error");
    }
}
