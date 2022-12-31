package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class k implements b0.b {
    private final b0 a;
    private final com.google.android.datatransport.runtime.m b;

    private k(b0 b0Var, com.google.android.datatransport.runtime.m mVar) {
        this.a = b0Var;
        this.b = mVar;
    }

    public static b0.b a(b0 b0Var, com.google.android.datatransport.runtime.m mVar) {
        return new k(b0Var, mVar);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.W(this.a, this.b, (SQLiteDatabase) obj);
    }
}
