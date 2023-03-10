package com.mob.commons.logcollector;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mob.MobSDK;
/* compiled from: DBHelp.java */
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    public a() {
        super(MobSDK.getContext(), "ThrowalbeLog.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table if not exists table_exception(_id integer primary key autoincrement,exception_level integer not null, exception_msg text not null,exception_time timestamp not null, exception_md5 text not null, exception_counts integer DEFAULT 1, exception_sending bit);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
