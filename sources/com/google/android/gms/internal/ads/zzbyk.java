package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbyk extends zzbwf<zzair> implements zzair {
    public zzbyk(Set<zzbya<zzair>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final void zza(final zzavj zzavjVar) {
        zza(new zzbwh(zzavjVar) { // from class: com.google.android.gms.internal.ads.zzbym
            private final zzavj zzgbd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbd = zzavjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzair) obj).zza(this.zzgbd);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final synchronized void zzuc() {
        zza(zzbyj.zzfzg);
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final void zzud() {
        zza(zzbyl.zzfzg);
    }
}
