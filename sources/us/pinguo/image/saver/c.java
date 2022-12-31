package us.pinguo.image.saver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.foundation.d;
import us.pinguo.foundation.k;
import us.pinguo.librouter.b.c.f;
import us.pinguo.util.r;
import us.pinguo.util.v;
/* compiled from: Storage.java */
/* loaded from: classes4.dex */
public final class c {
    private static final String a = "c";
    public static final String b;
    public static final String c;

    static {
        String file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        b = file;
        String str = file + "/Camera";
        c = k.f11022f;
    }

    public static Uri a(ContentResolver contentResolver, String str, long j2, f fVar, int i2, File file, String str2) {
        return b(contentResolver, str, j2, fVar, i2, file, null, str2);
    }

    private static Uri b(ContentResolver contentResolver, String str, long j2, f fVar, int i2, File file, r rVar, String str2) {
        String path = file.getPath();
        String name = file.getName();
        long length = file.length();
        String str3 = a;
        us.pinguo.common.log.a.m(str3, "Add image:" + j2, new Object[0]);
        ContentValues contentValues = new ContentValues(9);
        int lastIndexOf = name.lastIndexOf(46);
        String substring = lastIndexOf > 0 ? name.substring(0, lastIndexOf) : str;
        String substring2 = name.substring(lastIndexOf + 1);
        contentValues.put("title", substring);
        contentValues.put("_display_name", name);
        contentValues.put("datetaken", Long.valueOf(j2));
        contentValues.put("mime_type", "image/" + substring2);
        contentValues.put("orientation", Integer.valueOf(i2));
        if (Build.VERSION.SDK_INT >= 29) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/" + str2 + "/");
        } else {
            contentValues.put("_data", path);
        }
        contentValues.put("_size", Long.valueOf(length));
        if (fVar != null) {
            contentValues.put(BigAlbumStore.PhotoColumns.LATITUDE, Double.valueOf(fVar.c()));
            contentValues.put(BigAlbumStore.PhotoColumns.LONGITUDE, Double.valueOf(fVar.d()));
        }
        if (rVar != null && us.pinguo.util.c.m) {
            contentValues.put("width", Integer.valueOf(rVar.c()));
            contentValues.put("height", Integer.valueOf(rVar.b()));
        }
        if (d.f10987f) {
            us.pinguo.common.log.a.m(str3, "Save image info :", new Object[0]);
            us.pinguo.common.log.a.m(str3, "Title(" + str + ")", new Object[0]);
            us.pinguo.common.log.a.m(str3, "Display name(" + name + ")", new Object[0]);
            us.pinguo.common.log.a.m(str3, "Date taken(" + j2 + ")", new Object[0]);
            us.pinguo.common.log.a.m(str3, "Orientation(" + i2 + ")", new Object[0]);
            us.pinguo.common.log.a.m(str3, "Data(" + path + ")", new Object[0]);
            if (fVar != null) {
                us.pinguo.common.log.a.m(str3, "Latitude(" + fVar.c() + ")", new Object[0]);
                us.pinguo.common.log.a.m(str3, "Longitude(" + fVar.d() + ")", new Object[0]);
            }
        }
        try {
            return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Throwable th) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(file));
            v.a().sendBroadcast(intent);
            String str4 = a;
            us.pinguo.common.log.a.g(str4, "Failed to write MediaStore" + th, new Object[0]);
            return null;
        }
    }
}
