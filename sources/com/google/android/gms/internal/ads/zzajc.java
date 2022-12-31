package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajc implements Runnable {
    private final /* synthetic */ zzajb zzdis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajc(zzajb zzajbVar) {
        this.zzdis = zzajbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdis.disconnect();
    }
}
