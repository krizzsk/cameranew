package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class k implements a.InterfaceC0131a {
    private final l a;
    private final com.google.android.datatransport.runtime.m b;
    private final int c;

    private k(l lVar, com.google.android.datatransport.runtime.m mVar, int i2) {
        this.a = lVar;
        this.b = mVar;
        this.c = i2;
    }

    public static a.InterfaceC0131a a(l lVar, com.google.android.datatransport.runtime.m mVar, int i2) {
        return new k(lVar, mVar, i2);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        return this.a.f3404d.a(this.b, this.c + 1);
    }
}
