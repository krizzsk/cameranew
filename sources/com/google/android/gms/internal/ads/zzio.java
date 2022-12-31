package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzio implements Runnable {
    private final /* synthetic */ zzik zzajh;
    private final /* synthetic */ int zzajj;
    private final /* synthetic */ long zzajk;
    private final /* synthetic */ long zzajl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzik zzikVar, int i2, long j2, long j3) {
        this.zzajh = zzikVar;
        this.zzajj = i2;
        this.zzajk = j2;
        this.zzajl = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajh.zzajd;
        zzilVar.zzb(this.zzajj, this.zzajk, this.zzajl);
    }
}
