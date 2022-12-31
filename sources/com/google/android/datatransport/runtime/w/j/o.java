package com.google.android.datatransport.runtime.w.j;

import android.database.Cursor;
import com.google.android.datatransport.runtime.w.j.b0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class o implements b0.b {
    private static final o a = new o();

    private o() {
    }

    public static b0.b a() {
        return a;
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.a0((Cursor) obj);
    }
}
