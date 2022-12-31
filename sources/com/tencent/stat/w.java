package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class w extends SQLiteOpenHelper {
    public w(Context context) {
        super(context, com.tencent.stat.common.k.v(context), (SQLiteDatabase.CursorFactory) null, 3);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StatLogger statLogger;
        Cursor cursor = null;
        String str = null;
        try {
            Cursor query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put("uid", com.tencent.stat.common.k.c(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = query;
                try {
                    statLogger = n.f8308e;
                    statLogger.e(th);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        StatLogger statLogger;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<x> arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(new x(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (x xVar : arrayList) {
                contentValues.put(FirebaseAnalytics.Param.CONTENT, com.tencent.stat.common.k.c(xVar.b));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(xVar.a)});
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                statLogger = n.f8308e;
                statLogger.e(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        StatLogger statLogger;
        statLogger = n.f8308e;
        statLogger.debug("upgrade DB from oldVersion " + i2 + " to newVersion " + i3);
        if (i2 == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            d(sQLiteDatabase);
        }
        if (i2 == 2) {
            a(sQLiteDatabase);
            d(sQLiteDatabase);
        }
    }
}
