package cn.sharesdk.framework.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.SSDKLog;
/* compiled from: DBProvider.java */
/* loaded from: classes.dex */
public class b {
    private static b b;
    private a a = new a();

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        SSDKLog.b().d("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Exception e2) {
            SSDKLog.b().w(e2, "when query database occur error table:%s,", str);
            return null;
        }
    }

    public long a(String str, ContentValues contentValues) {
        try {
            return this.a.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e2) {
            SSDKLog.b().w(e2, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    public int a(String str, String str2, String[] strArr) {
        int i2;
        try {
            i2 = this.a.getWritableDatabase().delete(str, str2, strArr);
        } catch (Exception e2) {
            e = e2;
            i2 = 0;
        }
        try {
            SSDKLog.b().d("Deleted %d rows from table: %s", Integer.valueOf(i2), str);
        } catch (Exception e3) {
            e = e3;
            SSDKLog.b().w(e, "when delete database occur error table:%s,", str);
            return i2;
        }
        return i2;
    }

    public int a(String str) {
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        Cursor cursor = null;
        int i2 = 0;
        try {
            try {
                cursor = writableDatabase.rawQuery("select count(*) from " + str, null);
                if (cursor.moveToNext()) {
                    i2 = cursor.getInt(0);
                }
            } catch (Exception e2) {
                SSDKLog.b().w(e2);
            }
            return i2;
        } finally {
            cursor.close();
        }
    }
}
