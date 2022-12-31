package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzin implements Runnable {
    private final /* synthetic */ zzik zzajh;
    private final /* synthetic */ zzjm zzaji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzik zzikVar, zzjm zzjmVar) {
        this.zzajh = zzikVar;
        this.zzaji = zzjmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajh.zzajd;
        zzilVar.zzc(this.zzaji);
    }
}
