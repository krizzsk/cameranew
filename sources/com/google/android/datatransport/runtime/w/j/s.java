package com.google.android.datatransport.runtime.w.j;

import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class s implements b0.d {
    private final h0 a;

    private s(h0 h0Var) {
        this.a = h0Var;
    }

    public static b0.d b(h0 h0Var) {
        return new s(h0Var);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.d
    public Object a() {
        return this.a.getWritableDatabase();
    }
}
