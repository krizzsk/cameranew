package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfg implements Runnable {
    private final /* synthetic */ zzfc zzzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfg(zzfc zzfcVar) {
        this.zzzo = zzfcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzabp.initialize(this.zzzo.context);
    }
}
