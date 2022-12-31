package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class j implements b0.b {
    private final long a;
    private final com.google.android.datatransport.runtime.m b;

    private j(long j2, com.google.android.datatransport.runtime.m mVar) {
        this.a = j2;
        this.b = mVar;
    }

    public static b0.b a(long j2, com.google.android.datatransport.runtime.m mVar) {
        return new j(j2, mVar);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.c0(this.a, this.b, (SQLiteDatabase) obj);
    }
}
