package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zziq implements Runnable {
    private final /* synthetic */ zzik zzajh;
    private final /* synthetic */ int zzajn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzik zzikVar, int i2) {
        this.zzajh = zzikVar;
        this.zzajn = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzil zzilVar;
        zzilVar = this.zzajh.zzajd;
        zzilVar.zzx(this.zzajn);
    }
}
