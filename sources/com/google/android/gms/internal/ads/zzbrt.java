package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbrt extends zzbwf<zzbrq> implements zzbrq {
    public zzbrt(zzbrx zzbrxVar, Set<zzbya<zzbrq>> set, Executor executor) {
        super(set);
        zza(zzbrxVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zza(final zzcaf zzcafVar) {
        zza(new zzbwh(zzcafVar) { // from class: com.google.android.gms.internal.ads.zzbrv
            private final zzcaf zzfzi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzi = zzcafVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbrq) obj).zza(this.zzfzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzalp() {
        zza(zzbru.zzfzg);
    }

    @Override // com.google.android.gms.internal.ads.zzbrq
    public final void zzl(final zzvg zzvgVar) {
        zza(new zzbwh(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzbrs
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbrq) obj).zzl(this.zzfzh);
            }
        });
    }
}
