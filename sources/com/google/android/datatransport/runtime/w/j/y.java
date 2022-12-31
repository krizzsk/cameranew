package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class y implements b0.b {
    private final String a;

    private y(String str) {
        this.a = str;
    }

    public static b0.b a(String str) {
        return new y(str);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.b0(this.a, (SQLiteDatabase) obj);
    }
}
