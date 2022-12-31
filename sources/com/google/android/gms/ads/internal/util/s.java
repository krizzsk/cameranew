package com.google.android.gms.ads.internal.util;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class s implements Runnable {
    private final /* synthetic */ zza a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zza zzaVar) {
        this.a = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.thread = Thread.currentThread();
        this.a.zzwe();
    }
}
