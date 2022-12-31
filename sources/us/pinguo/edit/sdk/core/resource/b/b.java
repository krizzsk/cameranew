package us.pinguo.edit.sdk.core.resource.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* compiled from: PGEftDbHolder.java */
/* loaded from: classes4.dex */
public class b {
    private static final b c = new b();
    private a a;
    private SQLiteDatabase b;

    private b() {
    }

    public static b b() {
        return c;
    }

    public SQLiteDatabase a(Context context) {
        if (this.a == null) {
            this.a = new a(context, "pg_effect.db", null, 2);
        }
        SQLiteDatabase sQLiteDatabase = this.b;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.b;
        }
        SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
        this.b = writableDatabase;
        return writableDatabase;
    }
}
