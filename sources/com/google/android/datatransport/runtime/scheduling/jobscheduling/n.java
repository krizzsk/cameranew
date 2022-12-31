package com.google.android.datatransport.runtime.scheduling.jobscheduling;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WorkInitializer.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements Runnable {
    private final p a;

    private n(p pVar) {
        this.a = pVar;
    }

    public static Runnable a(p pVar) {
        return new n(pVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.f3412d.a(o.a(this.a));
    }
}
