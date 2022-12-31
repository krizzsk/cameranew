package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.database.Cursor;
import com.mob.tools.MobLog;
/* compiled from: DBProvider.java */
/* loaded from: classes2.dex */
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

    public long a(String str, ContentValues contentValues) {
        try {
            return this.a.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e2) {
            MobLog.getInstance().w(e2, "when insert database occur error table:%s,", str);
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
            MobLog.getInstance().d("Deleted %d rows from table: %s", Integer.valueOf(i2), str);
        } catch (Exception e3) {
            e = e3;
            MobLog.getInstance().w(e, "when delete database occur error table:%s,", str);
            return i2;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
        if (r10 == null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(java.lang.String r10) {
        /*
            r9 = this;
            com.mob.commons.logcollector.a r0 = r9.a
            android.database.sqlite.SQLiteDatabase r1 = r0.getWritableDatabase()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r0 = 0
            r2 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L21
            if (r10 != 0) goto L15
            goto L19
        L15:
            int r0 = r10.getCount()     // Catch: java.lang.Throwable -> L1f
        L19:
            if (r10 == 0) goto L2d
        L1b:
            r10.close()
            goto L2d
        L1f:
            r1 = move-exception
            goto L23
        L21:
            r1 = move-exception
            r10 = 0
        L23:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L2e
            r2.w(r1)     // Catch: java.lang.Throwable -> L2e
            if (r10 == 0) goto L2d
            goto L1b
        L2d:
            return r0
        L2e:
            r0 = move-exception
            if (r10 == 0) goto L34
            r10.close()
        L34:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.logcollector.b.a(java.lang.String):int");
    }

    public Cursor a(String str, String[] strArr) {
        try {
            return this.a.getWritableDatabase().rawQuery(str, strArr);
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return null;
        }
    }
}
