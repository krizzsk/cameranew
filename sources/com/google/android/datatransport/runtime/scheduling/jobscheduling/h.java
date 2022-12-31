package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class h implements a.InterfaceC0131a {
    private final l a;
    private final com.google.android.datatransport.runtime.m b;

    private h(l lVar, com.google.android.datatransport.runtime.m mVar) {
        this.a = lVar;
        this.b = mVar;
    }

    public static a.InterfaceC0131a a(l lVar, com.google.android.datatransport.runtime.m mVar) {
        return new h(lVar, mVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        Iterable L;
        L = this.a.c.L(this.b);
        return L;
    }
}
