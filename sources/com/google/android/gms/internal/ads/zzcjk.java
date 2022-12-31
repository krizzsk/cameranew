package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztw;
import com.google.android.gms.internal.ads.zzug;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcjk implements zzbrr, zzbse, zzbtb, zzbua, zzbwc, zzvc {
    private final zztu zzgkx;
    @GuardedBy("this")
    private boolean zzgky = false;

    public zzcjk(zztu zztuVar, @Nullable zzdkv zzdkvVar) {
        this.zzgkx = zztuVar;
        zztuVar.zza(zztw.zza.EnumC0159zza.AD_REQUEST);
        if (zzdkvVar != null) {
            zztuVar.zza(zztw.zza.EnumC0159zza.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final synchronized void onAdClicked() {
        if (!this.zzgky) {
            this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FIRST_CLICK);
            this.zzgky = true;
            return;
        }
        this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_SUBSEQUENT_CLICK);
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final synchronized void onAdImpression() {
        this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void onAdLoaded() {
        this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zzalx() {
        this.zzgkx.zza(zztw.zza.EnumC0159zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzb(final zzdnl zzdnlVar) {
        this.zzgkx.zza(new zztx(zzdnlVar) { // from class: com.google.android.gms.internal.ads.zzcjj
            private final zzdnl zzfzt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzt = zzdnlVar;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzaVar.zza(zzaVar.zzoe().zzbij().zza(zzaVar.zzoe().zzni().zzbij().zzbu(this.zzfzt.zzhks.zzess.zzbvs)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zzbg(boolean z) {
        zztw.zza.EnumC0159zza enumC0159zza;
        zztu zztuVar = this.zzgkx;
        if (z) {
            enumC0159zza = zztw.zza.EnumC0159zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED;
        } else {
            enumC0159zza = zztw.zza.EnumC0159zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED;
        }
        zztuVar.zza(enumC0159zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zzbh(boolean z) {
        zztw.zza.EnumC0159zza enumC0159zza;
        zztu zztuVar = this.zzgkx;
        if (z) {
            enumC0159zza = zztw.zza.EnumC0159zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED;
        } else {
            enumC0159zza = zztw.zza.EnumC0159zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED;
        }
        zztuVar.zza(enumC0159zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(zzvg zzvgVar) {
        switch (zzvgVar.errorCode) {
            case 1:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.zzgkx.zza(zztw.zza.EnumC0159zza.AD_FAILED_TO_LOAD);
                return;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzd(zzatq zzatqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zzd(final zzug.zzb zzbVar) {
        this.zzgkx.zza(new zztx(zzbVar) { // from class: com.google.android.gms.internal.ads.zzcjl
            private final zzug.zzb zzgad;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgad = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzaVar.zzb(this.zzgad);
            }
        });
        this.zzgkx.zza(zztw.zza.EnumC0159zza.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zze(final zzug.zzb zzbVar) {
        this.zzgkx.zza(new zztx(zzbVar) { // from class: com.google.android.gms.internal.ads.zzcjo
            private final zzug.zzb zzgad;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgad = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzaVar.zzb(this.zzgad);
            }
        });
        this.zzgkx.zza(zztw.zza.EnumC0159zza.REQUEST_PREFETCH_INTERCEPTED);
    }

    @Override // com.google.android.gms.internal.ads.zzbwc
    public final void zzc(final zzug.zzb zzbVar) {
        this.zzgkx.zza(new zztx(zzbVar) { // from class: com.google.android.gms.internal.ads.zzcjm
            private final zzug.zzb zzgad;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgad = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztx
            public final void zza(zzug.zzi.zza zzaVar) {
                zzaVar.zzb(this.zzgad);
            }
        });
        this.zzgkx.zza(zztw.zza.EnumC0159zza.REQUEST_LOADED_FROM_CACHE);
    }
}
