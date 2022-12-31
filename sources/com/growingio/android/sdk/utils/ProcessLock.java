package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes2.dex */
public class ProcessLock extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    public ProcessLock(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @TargetApi(11)
    public boolean acquire(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        while (true) {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                this.db = writableDatabase;
                writableDatabase.beginTransaction();
                return true;
            } catch (SQLiteDatabaseLockedException unused) {
                if (System.currentTimeMillis() - currentTimeMillis >= i2) {
                    return false;
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @TargetApi(11)
    public boolean isHold() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            this.db = writableDatabase;
            writableDatabase.beginTransaction();
            this.db.endTransaction();
            return false;
        } catch (SQLiteDatabaseLockedException unused) {
            return true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    public void release() {
        SQLiteDatabase sQLiteDatabase = this.db;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.db = null;
        }
    }
}
