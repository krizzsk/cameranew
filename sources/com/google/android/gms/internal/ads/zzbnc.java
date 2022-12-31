package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbnc implements zzeqb<Boolean> {
    private final zzeqo<zzdnp> zzfvf;

    public zzbnc(zzeqo<zzdnp> zzeqoVar) {
        this.zzfvf = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        boolean booleanValue;
        if (this.zzfvf.get().zzavc() != null) {
            booleanValue = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcpz)).booleanValue();
        } else {
            booleanValue = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcwo)).booleanValue();
        }
        return Boolean.valueOf(booleanValue);
    }
}
