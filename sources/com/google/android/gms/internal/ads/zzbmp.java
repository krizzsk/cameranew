package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbmp implements zzeqb<zzbya<zzbvn>> {
    private final zzbmc zzfvc;
    private final zzeqo<zzbts> zzfvg;

    public zzbmp(zzbmc zzbmcVar, zzeqo<zzbts> zzeqoVar) {
        this.zzfvc = zzbmcVar;
        this.zzfvg = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        final zzbts zzbtsVar = this.zzfvg.get();
        return (zzbya) zzeqh.zza(new zzbya(new zzbvn(zzbtsVar) { // from class: com.google.android.gms.internal.ads.zzbme
            private final zzbts zzfve;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfve = zzbtsVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvn
            public final void zzakf() {
                this.zzfve.zzals();
            }
        }, zzazp.zzeih), "Cannot return null from a non-@Nullable @Provides method");
    }
}
