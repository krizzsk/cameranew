package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrx extends zzbwf<zzbsa> implements zzbrq {
    public zzbrx(Set<zzbya<zzbsa>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zza(zzcaf zzcafVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzalp() {
        zza(zzbrz.zzfzg);
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzl(final zzvg zzvgVar) {
        zza(new zzbwh(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzbrw
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbsa) obj).zzk(this.zzfzh);
            }
        });
    }
}
