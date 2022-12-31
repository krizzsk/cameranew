package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
/* compiled from: WorkInitializer.java */
/* loaded from: classes2.dex */
final /* synthetic */ class o implements a.InterfaceC0131a {
    private final p a;

    private o(p pVar) {
        this.a = pVar;
    }

    public static a.InterfaceC0131a a(p pVar) {
        return new o(pVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        return p.b(this.a);
    }
}
