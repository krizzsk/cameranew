package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgo implements Runnable {
    private final /* synthetic */ zzgl zzabq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgl zzglVar) {
        this.zzabq = zzglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzabq.zzda();
    }
}
