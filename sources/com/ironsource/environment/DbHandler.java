package com.ironsource.environment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context) {
        super(context, "reports", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static void a(f fVar) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = new DbHandler(CrashReporter.getInstance().g()).getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                ContentValues contentValues = new ContentValues();
                String d2 = fVar.d();
                String b = fVar.b();
                String c = fVar.c();
                contentValues.put("stack_trace", d2);
                contentValues.put("crash_date", b);
                contentValues.put("crashType", c);
                writableDatabase.insert("REPORTS", null, contentValues);
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    writableDatabase.endTransaction();
                    writableDatabase.close();
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void d() {
        SQLiteDatabase writableDatabase = new DbHandler(CrashReporter.getInstance().g()).getWritableDatabase();
        writableDatabase.execSQL("DELETE FROM REPORTS WHERE id >= 0;");
        writableDatabase.close();
    }

    public static List<f> t() {
        DbHandler dbHandler = new DbHandler(CrashReporter.getInstance().g());
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase readableDatabase = dbHandler.getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT * FROM REPORTS ;", null);
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(new f(rawQuery.getInt(0), rawQuery.getString(1), rawQuery.getString(2), rawQuery.getString(3)));
            } while (rawQuery.moveToNext());
            rawQuery.close();
            readableDatabase.close();
            return arrayList;
        }
        rawQuery.close();
        readableDatabase.close();
        return arrayList;
    }

    public static Cursor u(int i2) {
        SQLiteDatabase readableDatabase = new DbHandler(CrashReporter.getInstance().g()).getReadableDatabase();
        return readableDatabase.rawQuery("SELECT * FROM REPORTSWHERE id= " + i2 + ";", null);
    }

    public static Cursor v() {
        DbHandler dbHandler = new DbHandler(CrashReporter.getInstance().g());
        new ArrayList();
        return dbHandler.getReadableDatabase().rawQuery("SELECT * FROM REPORTS;", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS REPORTS(id INTEGER PRIMARY KEY AUTOINCREMENT , stack_trace TEXT NOT NULL, crash_date TEXT NOT NULL,crashType TEXT NOT NULL );");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
