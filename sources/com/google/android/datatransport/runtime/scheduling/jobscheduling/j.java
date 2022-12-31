package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class j implements a.InterfaceC0131a {
    private final com.google.android.datatransport.runtime.w.j.c a;

    private j(com.google.android.datatransport.runtime.w.j.c cVar) {
        this.a = cVar;
    }

    public static a.InterfaceC0131a a(com.google.android.datatransport.runtime.w.j.c cVar) {
        return new j(cVar);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        return Integer.valueOf(this.a.B());
    }
}
