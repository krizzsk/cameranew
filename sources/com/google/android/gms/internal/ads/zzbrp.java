package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrp extends zzbwf<zzbrr> implements zzbrr {
    public zzbrp(Set<zzbya<zzbrr>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(final zzvg zzvgVar) {
        zza(new zzbwh(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzbro
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbrr) obj).zzc(this.zzfzh);
            }
        });
    }
}
