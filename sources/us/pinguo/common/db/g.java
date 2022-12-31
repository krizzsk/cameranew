package us.pinguo.common.db;

import android.content.ContentValues;
/* compiled from: DbTableModel.java */
/* loaded from: classes4.dex */
public abstract class g {
    protected final b dbDataBase;

    public g(b bVar) {
        this.dbDataBase = bVar;
    }

    public static void constructWhere(ContentValues contentValues, StringBuilder sb, String[] strArr) {
        int i2 = 0;
        for (String str : contentValues.keySet()) {
            if (i2 != 0) {
                sb.append(" AND");
            }
            sb.append(str);
            sb.append(" = ?");
            strArr[i2] = contentValues.getAsString(str);
            i2++;
        }
    }
}
