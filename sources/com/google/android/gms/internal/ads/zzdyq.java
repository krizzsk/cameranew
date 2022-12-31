package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyq implements Runnable {
    private final /* synthetic */ zzdwy zzhzu;
    private final /* synthetic */ zzdyo zzhzv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyq(zzdyo zzdyoVar, zzdwy zzdwyVar) {
        this.zzhzv = zzdyoVar;
        this.zzhzu = zzdwyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhzv.zza(this.zzhzu);
    }
}
