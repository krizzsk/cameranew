package com.google.android.datatransport.runtime.w.j;

import android.database.Cursor;
import com.google.android.datatransport.runtime.w.j.b0;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class p implements b0.b {
    private final Map a;

    private p(Map map) {
        this.a = map;
    }

    public static b0.b a(Map map) {
        return new p(map);
    }

    @Override // com.google.android.datatransport.runtime.w.j.b0.b
    public Object apply(Object obj) {
        return b0.Y(this.a, (Cursor) obj);
    }
}
