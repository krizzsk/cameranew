package com.danikula.videocache.r;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.danikula.videocache.j;
import com.danikula.videocache.n;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: DatabaseSourceInfoStorage.java */
/* loaded from: classes.dex */
class a extends SQLiteOpenHelper implements c {
    private static final String[] a = {"_id", "url", "length", IMediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        j.d(context);
    }

    private ContentValues d(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.a);
        contentValues.put("length", Long.valueOf(nVar.b));
        contentValues.put(IMediaFormat.KEY_MIME, nVar.c);
        return contentValues;
    }

    private n e(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    @Override // com.danikula.videocache.r.c
    public void a(String str, n nVar) {
        j.a(str, nVar);
        boolean z = get(str) != null;
        ContentValues d2 = d(nVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", d2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, d2);
        }
    }

    @Override // com.danikula.videocache.r.c
    public n get(String str) {
        Throwable th;
        Cursor cursor;
        j.d(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = e(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return nVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        j.d(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
