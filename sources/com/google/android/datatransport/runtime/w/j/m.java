package com.google.android.datatransport.runtime.w.j;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.w.j.b0;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
final /* synthetic */ class m implements b0.b {
    private final long a;

    private m(long j2) {
        this.a = j2;
    }

    public static b0.b a(long j2) {
        return new m(j2);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        Integer valueOf;
        valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.a)}));
        return valueOf;
    }
}
