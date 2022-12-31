package com.pinguo.camera360.cloud.cropImage;

import android.content.ContentResolver;
import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: CacheService.java */
@Deprecated
/* loaded from: classes3.dex */
public final class a {
    public static final String[] a = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", "orientation", "bucket_id"};
    public static final String[] b = {"_id", "title", "mime_type", BigAlbumStore.PhotoColumns.LATITUDE, BigAlbumStore.PhotoColumns.LONGITUDE, "datetaken", "date_added", "date_modified", "_data", TypedValues.TransitionType.S_DURATION, "bucket_id"};

    public static String a(String str) {
        return us.pinguo.foundation.e.b().getExternalFilesDir(null).getAbsolutePath() + File.separator + str;
    }

    public static void b(c cVar, ContentResolver contentResolver, Cursor cursor, String str) {
        cVar.a = cursor.getLong(0);
        cVar.b = cursor.getString(1);
        cVar.f6276d = cursor.getString(2);
        cVar.f6278f = cursor.getDouble(3);
        cVar.f6279g = cursor.getDouble(4);
        cVar.f6280h = cursor.getLong(5);
        cVar.f6282j = cursor.getLong(6);
        long j2 = cursor.getLong(7);
        cVar.f6281i = j2;
        if (cVar.f6280h == j2) {
            cVar.f6280h = j2 * 1000;
        }
        cVar.m = cursor.getString(8);
        if (str != null) {
            cVar.c = str + cVar.a;
        }
        int a2 = cVar.a();
        int i2 = cursor.getInt(9);
        if (a2 == 0) {
            cVar.f6284l = i2;
        } else {
            cVar.f6283k = i2;
        }
    }
}
