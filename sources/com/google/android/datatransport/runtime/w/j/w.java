package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class w implements b0.b {
    private final b0 a;
    private final com.google.android.datatransport.runtime.m b;
    private final com.google.android.datatransport.runtime.h c;

    private w(b0 b0Var, com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar) {
        this.a = b0Var;
        this.b = mVar;
        this.c = hVar;
    }

    public static b0.b a(b0 b0Var, com.google.android.datatransport.runtime.m mVar, com.google.android.datatransport.runtime.h hVar) {
        return new w(b0Var, mVar, hVar);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.Z(this.a, this.b, this.c, (SQLiteDatabase) obj);
    }
}
