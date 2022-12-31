package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class q implements b0.d {
    private final SQLiteDatabase a;

    private q(SQLiteDatabase sQLiteDatabase) {
        this.a = sQLiteDatabase;
    }

    public static b0.d b(SQLiteDatabase sQLiteDatabase) {
        return new q(sQLiteDatabase);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.d
    public Object a() {
        return this.a.beginTransaction();
    }
}
