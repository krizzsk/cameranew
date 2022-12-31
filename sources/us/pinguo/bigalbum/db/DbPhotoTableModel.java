package us.pinguo.bigalbum.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.bigalbum.entity.Photo;
import us.pinguo.common.db.b;
import us.pinguo.common.db.h;
/* loaded from: classes3.dex */
public class DbPhotoTableModel extends h<Photo> {
    public DbPhotoTableModel(b bVar) {
        super(BigAlbumStore.BIG_ALBUM_TABLE_PHOTO, bVar, Photo.class);
    }

    public void bulkInsertAndUpdateSysId(List<Photo> list, List<Photo> list2) {
        ContentValues[] contentValuesArr;
        if (list == null || list.size() <= 0) {
            contentValuesArr = null;
        } else {
            contentValuesArr = new ContentValues[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                contentValuesArr[i2] = this.typeAdapter.e(list.get(i2), this.dbTableDefinition.f9785e);
            }
        }
        bulkInsertAndUpdateSysId(contentValuesArr, list2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[Catch: all -> 0x00d3, Exception -> 0x00d8, LOOP:1: B:23:0x008d->B:25:0x0093, LOOP_END, TryCatch #8 {Exception -> 0x00d8, all -> 0x00d3, blocks: (B:16:0x0052, B:18:0x0072, B:20:0x0078, B:22:0x0089, B:23:0x008d, B:25:0x0093, B:26:0x00ba), top: B:74:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteByPathOrUrl(java.lang.String r16, java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbPhotoTableModel.deleteByPathOrUrl(java.lang.String, java.lang.String):void");
    }

    public Photo get(int i2) {
        List<Photo> list = get("_id = ?", new String[]{String.valueOf(i2)}, null);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public List<Photo> getAllAfterSystemDbId(int i2) {
        return get("systemDbID > ?", new String[]{String.valueOf(i2)}, null, null, "systemDbID ASC");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0058, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006a, code lost:
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.Long> getAllCreateDate() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            us.pinguo.common.db.b r2 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.util.concurrent.locks.Lock r2 = r2.readLock()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r2.lock()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            us.pinguo.common.db.b r2 = r11.dbDataBase     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r3 != 0) goto L21
            us.pinguo.common.db.b r1 = r11.dbDataBase
            java.util.concurrent.locks.Lock r1 = r1.readLock()
            r1.unlock()
            return r0
        L21:
            us.pinguo.common.db.f r2 = r11.dbTableDefinition     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r4 = r2.a     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r2 = "createDate"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r6 = 0
            r2 = 0
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r1 == 0) goto L4f
            boolean r3 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r3 == 0) goto L4f
        L3e:
            long r3 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r0.add(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r3 != 0) goto L3e
        L4f:
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L6f
            goto L6c
        L5b:
            r0 = move-exception
            goto L70
        L5d:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L5b
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L6f
        L6c:
            r1.close()
        L6f:
            return r0
        L70:
            us.pinguo.common.db.b r2 = r11.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r1 == 0) goto L7e
            r1.close()
        L7e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbPhotoTableModel.getAllCreateDate():java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006f, code lost:
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
        if (r10 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
        return r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<us.pinguo.bigalbum.util.DataPair<java.lang.Integer, java.lang.Integer>> getAllIdsBeforeSystemDbId(int r12) {
        /*
            r11 = this;
            java.lang.String r3 = "systemDbID >= 0 AND systemDbID <= ?"
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r9 = 0
            r4[r9] = r12
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r10 = 0
            us.pinguo.common.db.b r0 = r11.dbDataBase     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.util.concurrent.locks.Lock r0 = r0.readLock()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r0.lock()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            us.pinguo.common.db.b r0 = r11.dbDataBase     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r0 != 0) goto L2d
            us.pinguo.common.db.b r0 = r11.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            return r12
        L2d:
            us.pinguo.common.db.f r1 = r11.dbTableDefinition     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r1 = r1.a     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.String r2 = "systemDbID"
            java.lang.String r5 = "_id"
            java.lang.String[] r2 = new java.lang.String[]{r2, r5}     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r10 == 0) goto L66
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r0 == 0) goto L66
        L48:
            us.pinguo.bigalbum.util.DataPair r0 = new us.pinguo.bigalbum.util.DataPair     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r1 = r10.getInt(r9)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            int r2 = r10.getInt(r8)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            r12.add(r0)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L74
            if (r0 != 0) goto L48
        L66:
            us.pinguo.common.db.b r0 = r11.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r10 == 0) goto L86
            goto L83
        L72:
            r12 = move-exception
            goto L87
        L74:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L72
            us.pinguo.common.db.b r0 = r11.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r10 == 0) goto L86
        L83:
            r10.close()
        L86:
            return r12
        L87:
            us.pinguo.common.db.b r0 = r11.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r10 == 0) goto L95
            r10.close()
        L95:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbPhotoTableModel.getAllIdsBeforeSystemDbId(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a5, code lost:
        if (r1 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
        if (r1 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bc, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.Integer> getAllInSystemDbId(java.util.List<java.lang.Integer> r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r9 == 0) goto Lcc
            int r1 = r9.size()
            if (r1 != 0) goto Lf
            goto Lcc
        Lf:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "systemDbID in( "
            r2.append(r3)
            r3 = 0
            r4 = 0
        L1c:
            int r5 = r9.size()
            if (r4 >= r5) goto L31
            java.lang.Object r5 = r9.get(r4)
            r2.append(r5)
            java.lang.String r5 = ","
            r2.append(r5)
            int r4 = r4 + 1
            goto L1c
        L31:
            int r9 = r2.length()
            if (r9 <= 0) goto L40
            int r9 = r2.length()
            int r9 = r9 + (-1)
            r2.deleteCharAt(r9)
        L40:
            java.lang.String r9 = " )"
            r2.append(r9)
            us.pinguo.common.db.b r9 = r8.dbDataBase     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.util.concurrent.locks.Lock r9 = r9.readLock()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            r9.lock()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            us.pinguo.common.db.b r9 = r8.dbDataBase     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            android.database.sqlite.SQLiteDatabase r9 = r9.getReadableDatabase()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            if (r9 != 0) goto L60
            us.pinguo.common.db.b r9 = r8.dbDataBase
            java.util.concurrent.locks.Lock r9 = r9.readLock()
            r9.unlock()
            return r0
        L60:
            us.pinguo.common.db.d r4 = new us.pinguo.common.db.d     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            r4.<init>()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            us.pinguo.common.db.f r5 = r8.dbTableDefinition     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.String r6 = r5.a     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.String r7 = "_id"
            java.util.List r5 = r5.c(r7)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            r4.e(r6, r5)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            r4.g(r2)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.String r2 = r4.c()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            android.database.Cursor r1 = r9.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            if (r1 == 0) goto L9c
            boolean r9 = r1.moveToFirst()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            if (r9 == 0) goto L9c
        L8b:
            int r9 = r1.getInt(r3)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            r0.add(r9)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            boolean r9 = r1.moveToNext()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            if (r9 != 0) goto L8b
        L9c:
            us.pinguo.common.db.b r9 = r8.dbDataBase
            java.util.concurrent.locks.Lock r9 = r9.readLock()
            r9.unlock()
            if (r1 == 0) goto Lbc
            goto Lb9
        La8:
            r9 = move-exception
            goto Lbd
        Laa:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> La8
            us.pinguo.common.db.b r9 = r8.dbDataBase
            java.util.concurrent.locks.Lock r9 = r9.readLock()
            r9.unlock()
            if (r1 == 0) goto Lbc
        Lb9:
            r1.close()
        Lbc:
            return r0
        Lbd:
            us.pinguo.common.db.b r0 = r8.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r1 == 0) goto Lcb
            r1.close()
        Lcb:
            throw r9
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbPhotoTableModel.getAllInSystemDbId(java.util.List):java.util.List");
    }

    public List<Photo> getAllNotToCloud() {
        return get("localID IS NULL ", null, null, null, null);
    }

    public List<Photo> getAllOrderBy(String str) {
        return get(null, new String[0], null, null, str);
    }

    public Photo getBySystemId(int i2) {
        List<Photo> list = get("systemDbID = ?", new String[]{String.valueOf(i2)}, null);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        SQLiteDatabase readableDatabase;
        Cursor cursor = null;
        try {
            try {
                this.dbDataBase.readLock().lock();
                readableDatabase = this.dbDataBase.getReadableDatabase();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (readableDatabase == null) {
                return null;
            }
            cursor = readableDatabase.query(this.dbTableDefinition.a, strArr, str, strArr2, str2, str3, str4);
            return cursor;
        } finally {
            this.dbDataBase.readLock().unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009b, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
        if (r2 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00af, code lost:
        r2.endTransaction();
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007a A[Catch: all -> 0x0051, Exception -> 0x0055, TRY_ENTER, TryCatch #1 {all -> 0x0051, blocks: (B:14:0x0046, B:16:0x004c, B:24:0x005b, B:29:0x0093, B:28:0x007a), top: B:57:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int replaceByLocalPath(us.pinguo.bigalbum.entity.Photo r14) {
        /*
            r13 = this;
            r0 = -1
            if (r14 != 0) goto L4
            return r0
        L4:
            r1 = 0
            us.pinguo.common.db.b r2 = r13.dbDataBase     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.util.concurrent.locks.Lock r2 = r2.writeLock()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            r2.lock()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            us.pinguo.common.db.b r2 = r13.dbDataBase     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            if (r2 != 0) goto L25
            if (r2 == 0) goto L1b
            r2.endTransaction()     // Catch: java.lang.Exception -> L1b
        L1b:
            us.pinguo.common.db.b r14 = r13.dbDataBase
            java.util.concurrent.locks.Lock r14 = r14.writeLock()
            r14.unlock()
            return r0
        L25:
            r2.beginTransaction()     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            us.pinguo.common.db.f r3 = r13.dbTableDefinition     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            java.lang.String r4 = r3.a     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            java.lang.String r3 = "_id"
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            java.lang.String r6 = "localPath = ?"
            r11 = 1
            java.lang.String[] r7 = new java.lang.String[r11]     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            java.lang.String r3 = r14.localPath     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            r12 = 0
            r7[r12] = r3     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> Lbc
            if (r3 == 0) goto L58
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            if (r4 == 0) goto L58
            int r4 = r3.getInt(r12)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            goto L59
        L51:
            r14 = move-exception
            r1 = r3
            goto Lbd
        L55:
            r14 = move-exception
            r1 = r3
            goto La5
        L58:
            r4 = -1
        L59:
            if (r4 < 0) goto L7a
            us.pinguo.common.db.f r0 = r13.dbTableDefinition     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            java.lang.String r1 = r0.a     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            us.pinguo.common.db.k<T> r5 = r13.typeAdapter     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            java.util.List<us.pinguo.common.db.f$c> r0 = r0.f9785e     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            android.content.ContentValues r14 = r5.e(r14, r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            java.lang.String r0 = "_id = ? "
            java.lang.String[] r5 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            java.lang.String r6 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            r5[r12] = r6     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            r2.update(r1, r14, r0, r5)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L76
            r0 = r4
            goto L93
        L76:
            r14 = move-exception
            r1 = r3
            r0 = r4
            goto La5
        L7a:
            us.pinguo.common.db.f r4 = r13.dbTableDefinition     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            java.lang.String r5 = r4.a     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            us.pinguo.common.db.k<T> r6 = r13.typeAdapter     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            java.util.List<us.pinguo.common.db.f$c> r4 = r4.f9785e     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            android.content.ContentValues r14 = r6.e(r14, r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            long r4 = r2.insert(r5, r1, r14)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            java.lang.Long r14 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            int r14 = r14.intValue()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            r0 = r14
        L93:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L55
            if (r3 == 0) goto L9b
            r3.close()
        L9b:
            if (r2 == 0) goto Lb2
            goto Laf
        L9e:
            r14 = move-exception
            goto La5
        La0:
            r14 = move-exception
            r2 = r1
            goto Lbd
        La3:
            r14 = move-exception
            r2 = r1
        La5:
            r14.printStackTrace()     // Catch: java.lang.Throwable -> Lbc
            if (r1 == 0) goto Lad
            r1.close()
        Lad:
            if (r2 == 0) goto Lb2
        Laf:
            r2.endTransaction()     // Catch: java.lang.Exception -> Lb2
        Lb2:
            us.pinguo.common.db.b r14 = r13.dbDataBase
            java.util.concurrent.locks.Lock r14 = r14.writeLock()
            r14.unlock()
            return r0
        Lbc:
            r14 = move-exception
        Lbd:
            if (r1 == 0) goto Lc2
            r1.close()
        Lc2:
            if (r2 == 0) goto Lc7
            r2.endTransaction()     // Catch: java.lang.Exception -> Lc7
        Lc7:
            us.pinguo.common.db.b r0 = r13.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.writeLock()
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.bigalbum.db.DbPhotoTableModel.replaceByLocalPath(us.pinguo.bigalbum.entity.Photo):int");
    }

    public void bulkInsertAndUpdateSysId(ContentValues[] contentValuesArr, List<Photo> list) {
        SQLiteDatabase writableDatabase;
        if (contentValuesArr == null && (list == null || list.size() == 0)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                this.dbDataBase.writeLock().lock();
                writableDatabase = this.dbDataBase.getWritableDatabase();
            } catch (Exception e2) {
                e = e2;
            }
            if (writableDatabase == null) {
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                return;
            }
            try {
                writableDatabase.beginTransaction();
                if (contentValuesArr != null) {
                    for (ContentValues contentValues : contentValuesArr) {
                        writableDatabase.insert(this.dbTableDefinition.a, null, contentValues);
                    }
                }
                if (list != null && list.size() > 0) {
                    for (Photo photo : list) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put(BigAlbumStore.PhotoColumns.SYSTEM_DB_ID, Integer.valueOf(photo.systemDbID));
                        writableDatabase.update(this.dbTableDefinition.a, contentValues2, "_id = ?", new String[]{String.valueOf(photo.id)});
                    }
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = writableDatabase;
                e.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
                this.dbDataBase.writeLock().unlock();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception unused2) {
                    }
                }
                this.dbDataBase.writeLock().unlock();
                throw th;
            }
            if (writableDatabase != null) {
                writableDatabase.endTransaction();
            }
            this.dbDataBase.writeLock().unlock();
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
