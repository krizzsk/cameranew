package us.pinguo.edit.sdk.core.resource.db.loader;

import android.content.Context;
/* loaded from: classes4.dex */
public class PGEftTextureLoader {
    private final Context a;

    public PGEftTextureLoader(Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<us.pinguo.edit.sdk.core.model.f> a(android.content.ContentValues r11) {
        /*
            r10 = this;
            android.content.Context r0 = r10.a
            if (r0 != 0) goto L6
            r11 = 0
            return r11
        L6:
            us.pinguo.edit.sdk.core.resource.b.b r0 = us.pinguo.edit.sdk.core.resource.b.b.b()
            android.content.Context r1 = r10.a
            android.database.sqlite.SQLiteDatabase r0 = r0.a(r1)
            boolean r1 = r0.inTransaction()
            if (r1 != 0) goto L19
            r0.beginTransaction()
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r11.size()
            java.lang.String[] r6 = new java.lang.String[r3]
            r3 = 0
            java.util.Set r4 = r11.valueSet()
            java.util.Iterator r4 = r4.iterator()
        L2d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L61
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r7 = r5.getKey()
            r2.append(r7)
            java.lang.String r7 = " = ?"
            r2.append(r7)
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r6[r3] = r5
            int r3 = r3 + 1
            java.util.Set r5 = r11.keySet()
            int r5 = r5.size()
            if (r3 >= r5) goto L2d
            java.lang.String r5 = " AND "
            r2.append(r5)
            goto L2d
        L61:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r4 = 0
            java.lang.String r5 = r2.toString()
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r3 = "eft_texture"
            r2 = r0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)
            if (r2 == 0) goto Lbe
            int r3 = r2.getCount()
            if (r3 <= 0) goto Lbe
            r2.moveToFirst()
        L80:
            us.pinguo.edit.sdk.core.model.f r3 = new us.pinguo.edit.sdk.core.model.f
            r3.<init>()
            java.lang.String r4 = "eft_texture_pkg_dir"
            int r4 = r2.getColumnIndex(r4)
            java.lang.String r4 = r2.getString(r4)
            r3.a = r4
            java.lang.String r4 = "type"
            int r4 = r2.getColumnIndex(r4)
            int r4 = r2.getInt(r4)
            r3.b = r4
            java.lang.String r4 = "texture_index"
            int r4 = r2.getColumnIndex(r4)
            int r4 = r2.getInt(r4)
            r3.f10103d = r4
            java.lang.String r4 = "name"
            int r4 = r2.getColumnIndex(r4)
            java.lang.String r4 = r2.getString(r4)
            r3.c = r4
            r11.add(r3)
            boolean r3 = r2.moveToNext()
            if (r3 != 0) goto L80
        Lbe:
            if (r2 == 0) goto Lc3
            r2.close()
        Lc3:
            if (r1 != 0) goto Lce
            r0.setTransactionSuccessful()
            r0.endTransaction()
            r0.close()
        Lce:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit.sdk.core.resource.db.loader.PGEftTextureLoader.a(android.content.ContentValues):java.util.List");
    }
}
