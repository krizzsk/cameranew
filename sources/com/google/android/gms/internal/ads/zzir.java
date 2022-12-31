package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzir implements Runnable {
    private final /* synthetic */ zzik zzajh;
    private final /* synthetic */ zzjm zzajo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzir(zzik zzikVar, zzjm zzjmVar) {
        this.zzajh = zzikVar;
        this.zzajo = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        this.zzajo.zzgn();
        zzilVar = this.zzajh.zzajd;
        zzilVar.zzd(this.zzajo);
    }
}
