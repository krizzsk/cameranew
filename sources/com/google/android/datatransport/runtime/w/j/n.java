package com.google.android.datatransport.runtime.w.j;

import android.database.Cursor;
import com.google.android.datatransport.runtime.w.j.b0;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements b0.b {
    private final b0 a;
    private final List b;
    private final com.google.android.datatransport.runtime.m c;

    private n(b0 b0Var, List list, com.google.android.datatransport.runtime.m mVar) {
        this.a = b0Var;
        this.b = list;
        this.c = mVar;
    }

    public static b0.b a(b0 b0Var, List list, com.google.android.datatransport.runtime.m mVar) {
        return new n(b0Var, list, mVar);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.X(this.a, this.b, this.c, (Cursor) obj);
    }
}
