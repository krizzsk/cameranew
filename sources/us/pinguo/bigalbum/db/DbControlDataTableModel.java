package us.pinguo.bigalbum.db;

import us.pinguo.bigalbum.entity.DbControlData;
import us.pinguo.common.db.b;
import us.pinguo.common.db.f;
import us.pinguo.common.db.g;
import us.pinguo.common.db.k;
/* loaded from: classes3.dex */
public class DbControlDataTableModel extends g {
    f dbControlDataTableDefinition;
    protected k<DbControlData> dbControlDataTypeAdapter;

    public DbControlDataTableModel(b bVar) {
        super(bVar);
        this.dbControlDataTableDefinition = BigAlbumStore.BIG_ALBUM_TABLE_DB_CONTROL_DATA;
        this.dbControlDataTypeAdapter = k.a(DbControlData.class);
    }

    public int getInt(String str, int i2) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i2)));
        } catch (Exception unused) {
            return i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
        if (r6 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r6 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
        if (r0 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (android.text.TextUtils.isEmpty(r0.controlValue) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        return r0.controlValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
        return r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getString(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L7
            return r7
        L7:
            r0 = 0
            us.pinguo.common.db.b r1 = r5.dbDataBase     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.util.concurrent.locks.Lock r1 = r1.readLock()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r1.lock()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            us.pinguo.common.db.b r1 = r5.dbDataBase     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            if (r1 != 0) goto L23
            us.pinguo.common.db.b r6 = r5.dbDataBase
            java.util.concurrent.locks.Lock r6 = r6.readLock()
            r6.unlock()
            return r7
        L23:
            us.pinguo.common.db.d r2 = new us.pinguo.common.db.d     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r2.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            us.pinguo.common.db.f r3 = r5.dbControlDataTableDefinition     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.lang.String r3 = r3.a     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r2.d(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.lang.String r3 = "controlKey = ? "
            r2.g(r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            java.lang.String r2 = r2.c()     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            android.database.Cursor r6 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L69 java.lang.Exception -> L6b
            if (r6 == 0) goto L5a
            boolean r1 = r6.moveToFirst()     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            if (r1 == 0) goto L5a
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.DbControlData> r1 = r5.dbControlDataTypeAdapter     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            us.pinguo.common.db.f r2 = r5.dbControlDataTableDefinition     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            java.util.List<us.pinguo.common.db.f$c> r2 = r2.b     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            java.lang.Object r1 = r1.d(r6, r2)     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            us.pinguo.bigalbum.entity.DbControlData r1 = (us.pinguo.bigalbum.entity.DbControlData) r1     // Catch: java.lang.Exception -> L58 java.lang.Throwable -> L8a
            r0 = r1
            goto L5a
        L58:
            r1 = move-exception
            goto L6d
        L5a:
            us.pinguo.common.db.b r1 = r5.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r6 == 0) goto L7c
        L65:
            r6.close()
            goto L7c
        L69:
            r7 = move-exception
            goto L8c
        L6b:
            r1 = move-exception
            r6 = r0
        L6d:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L8a
            us.pinguo.common.db.b r1 = r5.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            if (r6 == 0) goto L7c
            goto L65
        L7c:
            if (r0 == 0) goto L89
            java.lang.String r6 = r0.controlValue
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L89
            java.lang.String r6 = r0.controlValue
            return r6
        L89:
            return r7
        L8a:
            r7 = move-exception
            r0 = r6
        L8c:
            us.pinguo.common.db.b r6 = r5.dbDataBase
            java.util.concurrent.locks.Lock r6 = r6.readLock()
            r6.unlock()
            if (r0 == 0) goto L9a
            r0.close()
        L9a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbControlDataTableModel.getString(java.lang.String, java.lang.String):java.lang.String");
    }

    public void putInt(String str, int i2) {
        putString(str, String.valueOf(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void putString(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L7
            return
        L7:
            r0 = 0
            us.pinguo.common.db.b r1 = r6.dbDataBase     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.util.concurrent.locks.Lock r1 = r1.writeLock()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r1.lock()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            us.pinguo.common.db.b r1 = r6.dbDataBase     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r1 != 0) goto L28
            if (r1 == 0) goto L1e
            r1.endTransaction()     // Catch: java.lang.Exception -> L1e
        L1e:
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.writeLock()
            r7.unlock()
            return
        L28:
            if (r8 != 0) goto L2c
            java.lang.String r8 = ""
        L2c:
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            java.lang.String r2 = "controlKey = ? "
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            r4 = 0
            r3[r4] = r7     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            us.pinguo.common.db.d r4 = new us.pinguo.common.db.d     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            r4.<init>()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            us.pinguo.common.db.f r5 = r6.dbControlDataTableDefinition     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            java.lang.String r5 = r5.a     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            r4.d(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            r4.g(r2)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            java.lang.String r4 = r4.c()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            android.database.Cursor r4 = r1.rawQuery(r4, r3)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9c
            us.pinguo.bigalbum.entity.DbControlData r5 = new us.pinguo.bigalbum.entity.DbControlData     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            r5.<init>()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            r5.controlKey = r7     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            r5.controlValue = r8     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            if (r4 == 0) goto L6f
            int r7 = r4.getCount()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            if (r7 <= 0) goto L6f
            us.pinguo.common.db.f r7 = r6.dbControlDataTableDefinition     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            java.lang.String r8 = r7.a     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.DbControlData> r0 = r6.dbControlDataTypeAdapter     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            java.util.List<us.pinguo.common.db.f$c> r7 = r7.f9785e     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            android.content.ContentValues r7 = r0.e(r5, r7)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            r1.update(r8, r7, r2, r3)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            goto L7e
        L6f:
            us.pinguo.common.db.f r7 = r6.dbControlDataTableDefinition     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            java.lang.String r8 = r7.a     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            us.pinguo.common.db.k<us.pinguo.bigalbum.entity.DbControlData> r2 = r6.dbControlDataTypeAdapter     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            java.util.List<us.pinguo.common.db.f$c> r7 = r7.f9785e     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            android.content.ContentValues r7 = r2.e(r5, r7)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            r1.insert(r8, r0, r7)     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
        L7e:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L94 java.lang.Exception -> L96
            if (r1 == 0) goto L88
            r1.endTransaction()     // Catch: java.lang.Exception -> L87
            goto L88
        L87:
        L88:
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.writeLock()
            r7.unlock()
            if (r4 == 0) goto Lbd
            goto Lba
        L94:
            r7 = move-exception
            goto L9a
        L96:
            r7 = move-exception
            goto L9e
        L98:
            r7 = move-exception
            r4 = r0
        L9a:
            r0 = r1
            goto Lbf
        L9c:
            r7 = move-exception
            r4 = r0
        L9e:
            r0 = r1
            goto La5
        La0:
            r7 = move-exception
            r4 = r0
            goto Lbf
        La3:
            r7 = move-exception
            r4 = r0
        La5:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lbe
            if (r0 == 0) goto Laf
            r0.endTransaction()     // Catch: java.lang.Exception -> Lae
            goto Laf
        Lae:
        Laf:
            us.pinguo.common.db.b r7 = r6.dbDataBase
            java.util.concurrent.locks.Lock r7 = r7.writeLock()
            r7.unlock()
            if (r4 == 0) goto Lbd
        Lba:
            r4.close()
        Lbd:
            return
        Lbe:
            r7 = move-exception
        Lbf:
            if (r0 == 0) goto Lc6
            r0.endTransaction()     // Catch: java.lang.Exception -> Lc5
            goto Lc6
        Lc5:
        Lc6:
            us.pinguo.common.db.b r8 = r6.dbDataBase
            java.util.concurrent.locks.Lock r8 = r8.writeLock()
            r8.unlock()
            if (r4 == 0) goto Ld4
            r4.close()
        Ld4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbControlDataTableModel.putString(java.lang.String, java.lang.String):void");
    }
}
