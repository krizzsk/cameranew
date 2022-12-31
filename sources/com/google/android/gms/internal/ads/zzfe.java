package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfe implements Runnable {
    private final /* synthetic */ zzfc zzzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(zzfc zzfcVar) {
        this.zzzo = zzfcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzzo.zzcq();
    }
}
