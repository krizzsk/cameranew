package com.google.android.datatransport.runtime.w;

import com.google.android.datatransport.runtime.m;
/* compiled from: DefaultScheduler.java */
/* loaded from: classes2.dex */
final /* synthetic */ class a implements Runnable {
    private final c a;
    private final m b;
    private final com.google.android.datatransport.g c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.datatransport.runtime.h f3416d;

    private a(c cVar, m mVar, com.google.android.datatransport.g gVar, com.google.android.datatransport.runtime.h hVar) {
        this.a = cVar;
        this.b = mVar;
        this.c = gVar;
        this.f3416d = hVar;
    }

    public static Runnable a(c cVar, m mVar, com.google.android.datatransport.g gVar, com.google.android.datatransport.runtime.h hVar) {
        return new a(cVar, mVar, gVar, hVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.a, this.b, this.c, this.f3416d);
    }
}
