package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.h0;
/* compiled from: SchemaManager.java */
/* loaded from: classes2.dex */
final /* synthetic */ class f0 implements h0.a {
    private static final f0 a = new f0();

    private f0() {
    }

    public static h0.a b() {
        return a;
    }

    @Override // com.google.android.datatransport.runtime.w.j.h0.a
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
