package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzip implements Runnable {
    private final /* synthetic */ zzik zzajh;
    private final /* synthetic */ zzht zzajm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzip(zzik zzikVar, zzht zzhtVar) {
        this.zzajh = zzikVar;
        this.zzajm = zzhtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajh.zzajd;
        zzilVar.zzc(this.zzajm);
    }
}
