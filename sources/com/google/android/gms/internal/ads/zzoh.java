package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzoh {
    private zzok zzbhv;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidate() {
        zzok zzokVar = this.zzbhv;
        if (zzokVar != null) {
            zzokVar.zzep();
        }
    }

    public abstract zzoj zza(zzib[] zzibVarArr, zznu zznuVar) throws zzhe;

    public final void zza(zzok zzokVar) {
        this.zzbhv = zzokVar;
    }

    public abstract void zzd(Object obj);
}
