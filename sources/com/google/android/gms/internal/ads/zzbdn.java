package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdn extends zzbdd {
    public zzbdn(zzbbo zzbboVar) {
        super(zzbboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbdd
    public final boolean zzfg(String str) {
        zzbbo zzbboVar = this.zzepn.get();
        if (zzbboVar != null) {
            zzbboVar.zza(zzfh(str), this);
        }
        zzazk.zzex("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfh(str), "noop", "Noop cache is a noop.");
        return false;
    }
}
