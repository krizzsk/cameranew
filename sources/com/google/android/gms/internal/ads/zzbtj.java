package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbtj extends zzbwf<com.google.android.gms.ads.internal.overlay.zzq> implements com.google.android.gms.ads.internal.overlay.zzq {
    public zzbtj(Set<zzbya<com.google.android.gms.ads.internal.overlay.zzq>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onPause() {
        zza(zzbtk.zzfzg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onResume() {
        zza(zzbtn.zzfzg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void onUserLeaveHint() {
        zza(zzbtl.zzfzg);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void zza(final com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        zza(new zzbwh(zznVar) { // from class: com.google.android.gms.internal.ads.zzbti
            private final com.google.android.gms.ads.internal.overlay.zzn zzfzn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzn = zznVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzq) obj).zza(this.zzfzn);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final synchronized void zzvo() {
        zza(zzbtm.zzfzg);
    }
}
