package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class l implements b0.b {
    private static final l a = new l();

    private l() {
    }

    public static b0.b a() {
        return a;
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.V((SQLiteDatabase) obj);
    }
}
