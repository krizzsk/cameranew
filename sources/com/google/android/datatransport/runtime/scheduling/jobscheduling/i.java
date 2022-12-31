package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class i implements a.InterfaceC0131a {
    private final l a;
    private final BackendResponse b;
    private final Iterable c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.m f3402d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3403e;

    private i(l lVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.m mVar, int i2) {
        this.a = lVar;
        this.b = backendResponse;
        this.c = iterable;
        this.f3402d = mVar;
        this.f3403e = i2;
    }

    public static a.InterfaceC0131a a(l lVar, BackendResponse backendResponse, Iterable iterable, com.google.android.datatransport.runtime.m mVar, int i2) {
        return new i(lVar, backendResponse, iterable, mVar, i2);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a.InterfaceC0131a
    public Object execute() {
        return l.c(this.a, this.b, this.c, this.f3402d, this.f3403e);
    }
}
