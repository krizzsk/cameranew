package us.pinguo.common.db;

import android.content.ContentValues;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DbTemplateTableModel.java */
/* loaded from: classes4.dex */
public class h<T> extends a {
    protected k<T> typeAdapter;

    public h(f fVar, b bVar, Class<? super T> cls) {
        super(fVar, bVar);
        this.typeAdapter = k.a(cls);
    }

    private ContentValues[] changeInsertListToContentValues(List<T> list) {
        ContentValues[] contentValuesArr = new ContentValues[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            contentValuesArr[i2] = this.typeAdapter.e(list.get(i2), this.dbTableDefinition.f9785e);
        }
        return contentValuesArr;
    }

    private void changeUpdateListToContentValues(List<T> list, ContentValues[] contentValuesArr, String[] strArr, List<String[]> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            ContentValues e2 = this.typeAdapter.e(t, this.dbTableDefinition.c);
            StringBuilder sb = new StringBuilder();
            String[] strArr2 = new String[e2.size()];
            g.constructWhere(e2, sb, strArr2);
            contentValuesArr[i2] = this.typeAdapter.e(t, this.dbTableDefinition.f9785e);
            strArr[i2] = sb.toString();
            list2.add(i2, strArr2);
        }
    }

    public List<Integer> bulkInsert(List<T> list) {
        if (list != null && list.size() != 0) {
            return bulkInsert(changeInsertListToContentValues(list));
        }
        return new ArrayList();
    }

    public List<Integer> bulkInsertInTransaction(List<T> list) {
        if (list != null && list.size() != 0) {
            return bulkInsertInTransaction(changeInsertListToContentValues(list));
        }
        return new ArrayList();
    }

    public boolean bulkUpdate(List<T> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        ContentValues[] contentValuesArr = new ContentValues[list.size()];
        String[] strArr = new String[list.size()];
        ArrayList arrayList = new ArrayList(list.size());
        changeUpdateListToContentValues(list, contentValuesArr, strArr, arrayList);
        return bulkUpdate(contentValuesArr, strArr, arrayList);
    }

    public boolean bulkUpdateInTransaction(List<T> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        ContentValues[] contentValuesArr = new ContentValues[list.size()];
        String[] strArr = new String[list.size()];
        ArrayList arrayList = new ArrayList(list.size());
        changeUpdateListToContentValues(list, contentValuesArr, strArr, arrayList);
        return bulkUpdateInTransaction(contentValuesArr, strArr, arrayList);
    }

    public List<Integer> clearThenBulkInsert(List<T> list) {
        if (list != null && list.size() != 0) {
            return clearThenBulkInsert(changeInsertListToContentValues(list));
        }
        return new ArrayList();
    }

    public List<Integer> clearThenBulkInsertInTransaction(List<T> list) {
        if (list != null && list.size() != 0) {
            return clearThenBulkInsertInTransaction(changeInsertListToContentValues(list));
        }
        return new ArrayList();
    }

    public boolean delete(T t) {
        ContentValues e2 = this.typeAdapter.e(t, this.dbTableDefinition.c);
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[e2.size()];
        g.constructWhere(e2, sb, strArr);
        return delete(sb.toString(), strArr);
    }

    public List<T> get(String str, String[] strArr, String str2) {
        return get(str, strArr, null, null, str2);
    }

    public List<T> getAll() {
        return get(null, new String[0], null, null, null);
    }

    public Integer insert(T t) {
        int insert = insert(this.typeAdapter.e(t, this.dbTableDefinition.f9785e));
        if (insert >= 0 && this.dbTableDefinition.f9784d != null) {
            this.typeAdapter.h(t, Long.valueOf(insert).intValue(), this.dbTableDefinition.f9784d);
        }
        return Integer.valueOf(insert);
    }

    public boolean update(T t) {
        ContentValues e2 = this.typeAdapter.e(t, this.dbTableDefinition.c);
        StringBuilder sb = new StringBuilder();
        String[] strArr = new String[e2.size()];
        g.constructWhere(e2, sb, strArr);
        return update(this.typeAdapter.e(t, this.dbTableDefinition.f9785e), sb.toString(), strArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r3 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<T> get(java.lang.String r13, java.lang.String[] r14, java.lang.String r15, java.lang.String r16, java.lang.String r17) {
        /*
            r12 = this;
            r1 = r12
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r3 = 0
            us.pinguo.common.db.b r0 = r1.dbDataBase     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.util.concurrent.locks.Lock r0 = r0.readLock()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.lock()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            us.pinguo.common.db.b r0 = r1.dbDataBase     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            android.database.sqlite.SQLiteDatabase r4 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r4 != 0) goto L22
            us.pinguo.common.db.b r0 = r1.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            return r2
        L22:
            us.pinguo.common.db.f r0 = r1.dbTableDefinition     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r5 = r0.a     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r6 = 0
            r7 = r13
            r8 = r14
            r9 = r15
            r10 = r16
            r11 = r17
            android.database.Cursor r3 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r3 == 0) goto L4d
            boolean r0 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r0 == 0) goto L4d
        L3a:
            us.pinguo.common.db.k<T> r0 = r1.typeAdapter     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            us.pinguo.common.db.f r4 = r1.dbTableDefinition     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.util.List<us.pinguo.common.db.f$c> r4 = r4.b     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.Object r0 = r0.d(r3, r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r2.add(r0)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            boolean r0 = r3.moveToNext()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r0 != 0) goto L3a
        L4d:
            us.pinguo.common.db.b r0 = r1.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r3 == 0) goto L6d
            goto L6a
        L59:
            r0 = move-exception
            goto L6e
        L5b:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L59
            us.pinguo.common.db.b r0 = r1.dbDataBase
            java.util.concurrent.locks.Lock r0 = r0.readLock()
            r0.unlock()
            if (r3 == 0) goto L6d
        L6a:
            r3.close()
        L6d:
            return r2
        L6e:
            us.pinguo.common.db.b r2 = r1.dbDataBase
            java.util.concurrent.locks.Lock r2 = r2.readLock()
            r2.unlock()
            if (r3 == 0) goto L7c
            r3.close()
        L7c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.db.h.get(java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }
}
