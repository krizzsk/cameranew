package com.pinguo.camera360.cloud.cropImage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.utils.n0;
/* loaded from: classes3.dex */
public class ImageManager {
    public static final String a;
    private static final Uri b;

    /* loaded from: classes3.dex */
    public enum DataLocation {
        NONE,
        INTERNAL,
        EXTERNAL,
        ALL
    }

    static {
        Bitmap.createBitmap(32, 32, Bitmap.Config.RGB_565);
        Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        String str = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
        a = str;
        b(str);
        b = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00ef: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:35:0x00ef */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [long] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static Uri a(ContentResolver contentResolver, String str, long j2, long j3, Double d2, Double d3, String str2, String str3, Bitmap bitmap, byte[] bArr, int[] iArr) {
        ?? r6;
        Closeable closeable;
        String str4 = str2 + "/" + str3;
        Closeable closeable2 = null;
        r4 = 0;
        r4 = 0;
        r4 = 0;
        ?? r4 = 0;
        try {
            try {
                File file = new File(str2);
                if (!file.exists() && !file.mkdirs()) {
                    us.pinguo.common.log.a.u("ImageManager", "Create dir failed!", new Object[0]);
                }
                r6 = new FileOutputStream(new File(str2, str3));
                try {
                    if (bitmap != 0) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, r6);
                        iArr[0] = 0;
                    } else {
                        r6.write(bArr);
                        iArr[0] = c(str4);
                    }
                    n0.a(r6);
                    r4 = new File(str2, str3).length();
                    ContentValues contentValues = new ContentValues(11);
                    r6 = str;
                    contentValues.put("title", str);
                    contentValues.put("_display_name", str3);
                    contentValues.put("datetaken", Long.valueOf(j3));
                    contentValues.put("date_modified", Long.valueOf(j3));
                    contentValues.put("date_added", Long.valueOf(j2));
                    contentValues.put("mime_type", "image/jpeg");
                    contentValues.put("orientation", Integer.valueOf(iArr[0]));
                    contentValues.put("_data", str4);
                    contentValues.put("_size", Long.valueOf((long) r4));
                    if (d2 != null && d3 != null) {
                        contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Float.valueOf(d2.floatValue()));
                        contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Float.valueOf(d3.floatValue()));
                    }
                    return contentResolver.insert(b, contentValues);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    us.pinguo.common.log.a.t(e);
                    n0.a(r6);
                    return r4;
                } catch (IOException e3) {
                    e = e3;
                    us.pinguo.common.log.a.t(e);
                    n0.a(r6);
                    return r4;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                n0.a(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            r6 = 0;
        } catch (IOException e5) {
            e = e5;
            r6 = 0;
        } catch (Throwable th2) {
            th = th2;
            n0.a(closeable2);
            throw th;
        }
    }

    public static String b(String str) {
        return String.valueOf(str.toLowerCase(Locale.ENGLISH).hashCode());
    }

    public static int c(String str) {
        ExifInterface exifInterface;
        int attributeInt;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e2) {
            us.pinguo.common.log.a.g("ImageManager", "cannot read exif", e2);
            exifInterface = null;
        }
        if (exifInterface == null || (attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, -1)) == -1) {
            return 0;
        }
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                if (attributeInt != 8) {
                    us.pinguo.common.log.a.u("ImageManager", "Invalid orientation:" + attributeInt, new Object[0]);
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return 90;
        }
        return BaseBlurEffect.ROTATION_180;
    }
}
