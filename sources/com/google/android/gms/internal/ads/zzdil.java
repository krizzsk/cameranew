package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdil implements com.google.android.gms.ads.internal.overlay.zzq, zzbrr, zzbtg, zzdkk {
    private final zzdov zzhfs;
    private final AtomicReference<zzsp> zzhft = new AtomicReference<>();
    private final AtomicReference<zzsq> zzhfu = new AtomicReference<>();
    private final AtomicReference<zzsv> zzhfv = new AtomicReference<>();
    private final AtomicReference<zzbtg> zzhfw = new AtomicReference<>();
    private final AtomicReference<com.google.android.gms.ads.internal.overlay.zzq> zzhfx = new AtomicReference<>();
    private zzdil zzhfy = null;

    public zzdil(zzdov zzdovVar) {
        this.zzhfs = zzdovVar;
    }

    public static zzdil zzb(zzdil zzdilVar) {
        zzdil zzdilVar2 = new zzdil(zzdilVar.zzhfs);
        zzdilVar2.zzb((zzdkk) zzdilVar);
        return zzdilVar2;
    }

    public final void onAdClosed() {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdilVar.zzhfs.onAdClosed();
                zzdkd.zza(zzdilVar.zzhfu, zzdip.zzgya);
                zzdkd.zza(zzdilVar.zzhfv, zzdio.zzgya);
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhfx, zzdiv.zzgya);
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    public final void zza(zzsv zzsvVar) {
        this.zzhfv.set(zzsvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtg
    public final void zzalq() {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhfw, zzdir.zzgya);
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(final zzvg zzvgVar) {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhft, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzdin
                    private final zzvg zzfzh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzh = zzvgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzsp) obj).zza(this.zzfzh);
                    }
                });
                zzdkd.zza(zzdilVar.zzhft, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzdim
                    private final zzvg zzfzh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzh = zzvgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzsp) obj).onAppOpenAdFailedToLoad(this.zzfzh.errorCode);
                    }
                });
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhfx, zzdiq.zzgya);
                zzdkd.zza(zzdilVar.zzhfv, zzdit.zzgya);
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    public final void zza(zzbtg zzbtgVar) {
        this.zzhfw.set(zzbtgVar);
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzq zzqVar) {
        this.zzhfx.set(zzqVar);
    }

    public final void zzb(zzsp zzspVar) {
        this.zzhft.set(zzspVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(final com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhfx, new zzdkc(zznVar) { // from class: com.google.android.gms.internal.ads.zzdis
                    private final com.google.android.gms.ads.internal.overlay.zzn zzfzn;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzn = zznVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((com.google.android.gms.ads.internal.overlay.zzq) obj).zza(this.zzfzn);
                    }
                });
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    public final void zzb(zzsq zzsqVar) {
        this.zzhfu.set(zzsqVar);
    }

    public final void zzb(final zzsk zzskVar) {
        zzdil zzdilVar = this;
        while (true) {
            zzdil zzdilVar2 = zzdilVar.zzhfy;
            if (zzdilVar2 == null) {
                zzdkd.zza(zzdilVar.zzhft, new zzdkc(zzskVar) { // from class: com.google.android.gms.internal.ads.zzdik
                    private final zzsk zzhfr;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzhfr = zzskVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzsp) obj).zza(this.zzhfr);
                    }
                });
                return;
            }
            zzdilVar = zzdilVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkk
    public final void zzb(zzdkk zzdkkVar) {
        this.zzhfy = (zzdil) zzdkkVar;
    }
}
