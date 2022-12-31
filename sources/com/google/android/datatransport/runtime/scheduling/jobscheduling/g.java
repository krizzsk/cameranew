package com.google.android.datatransport.runtime.scheduling.jobscheduling;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Uploader.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {
    private final l a;
    private final com.google.android.datatransport.runtime.m b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f3401d;

    private g(l lVar, com.google.android.datatransport.runtime.m mVar, int i2, Runnable runnable) {
        this.a = lVar;
        this.b = mVar;
        this.c = i2;
        this.f3401d = runnable;
    }

    public static Runnable a(l lVar, com.google.android.datatransport.runtime.m mVar, int i2, Runnable runnable) {
        return new g(lVar, mVar, i2, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        l.e(this.a, this.b, this.c, this.f3401d);
    }
}
