package com.google.android.datatransport.runtime.w;

import com.google.android.datatransport.runtime.m;
import com.google.android.datatransport.runtime.synchronization.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultScheduler.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements a.InterfaceC0131a {
    private final c a;
    private final m b;
    private final com.google.android.datatransport.runtime.h c;

    private b(c cVar, m mVar, com.google.android.datatransport.runtime.h hVar) {
        this.a = cVar;
        this.b = mVar;
        this.c = hVar;
    }

    public static a.InterfaceC0131a a(c cVar, m mVar, com.google.android.datatransport.runtime.h hVar) {
        return new b(cVar, mVar, hVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        return c.b(this.a, this.b, this.c);
    }
}
