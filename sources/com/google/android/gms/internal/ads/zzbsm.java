package com.google.android.gms.internal.ads;

import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbsm extends zzbwf<zzbrm> {
    public zzbsm(Set<zzbya<zzbrm>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbsp.zzfzg);
    }

    public final void onAdLeftApplication() {
        zza(zzbso.zzfzg);
    }

    public final void onAdOpened() {
        zza(zzbsr.zzfzg);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbss.zzfzg);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbsq.zzfzg);
    }

    public final void zzb(final zzauk zzaukVar, final String str, final String str2) {
        zza(new zzbwh(zzaukVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbst
            private final String zzdjf;
            private final String zzdlo;
            private final zzauk zzfzl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzl = zzaukVar;
                this.zzdjf = str;
                this.zzdlo = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzbrm) obj).zzb(this.zzfzl, this.zzdjf, this.zzdlo);
            }
        });
    }
}
