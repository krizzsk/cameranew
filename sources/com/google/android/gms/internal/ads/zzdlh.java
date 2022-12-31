package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdlh extends AdMetadataListener implements zzbrm, zzbrr, zzbsa, zzbtb, zzbtt, zzdkk {
    private final zzdov zzhfs;
    private final AtomicReference<AdMetadataListener> zzhia = new AtomicReference<>();
    private final AtomicReference<zzavu> zzhib = new AtomicReference<>();
    private final AtomicReference<zzavr> zzhic = new AtomicReference<>();
    private final AtomicReference<zzauu> zzhid = new AtomicReference<>();
    private final AtomicReference<zzavz> zzhie = new AtomicReference<>();
    private final AtomicReference<zzaup> zzhif = new AtomicReference<>();
    private final AtomicReference<zzyw> zzhig = new AtomicReference<>();
    private zzdlh zzhih = null;

    public zzdlh(zzdov zzdovVar) {
        this.zzhfs = zzdovVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdClosed() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdlhVar.zzhfs.onAdClosed();
                zzdkd.zza(zzdlhVar.zzhic, zzdlz.zzgya);
                zzdkd.zza(zzdlhVar.zzhid, zzdly.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdLeftApplication() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhid, zzdmb.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void onAdLoaded() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhib, zzdlg.zzgya);
                zzdkd.zza(zzdlhVar.zzhid, zzdlj.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        zzdlh zzdlhVar = this.zzhih;
        if (zzdlhVar != null) {
            zzdlhVar.onAdMetadataChanged();
        } else {
            zzdkd.zza(this.zzhia, zzdlq.zzgya);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdOpened() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhic, zzdlx.zzgya);
                zzdkd.zza(zzdlhVar.zzhid, zzdlw.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoCompleted() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhid, zzdlp.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoStarted() {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhid, zzdli.zzgya);
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzhia.set(adMetadataListener);
    }

    public final void zzb(zzavu zzavuVar) {
        this.zzhib.set(zzavuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(final zzvg zzvgVar) {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                final int i2 = zzvgVar.errorCode;
                zzdkd.zza(zzdlhVar.zzhib, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzdls
                    private final zzvg zzfzh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzh = zzvgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzavu) obj).zzj(this.zzfzh);
                    }
                });
                zzdkd.zza(zzdlhVar.zzhib, new zzdkc(i2) { // from class: com.google.android.gms.internal.ads.zzdlv
                    private final int zzehw;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzehw = i2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzavu) obj).onRewardedAdFailedToLoad(this.zzehw);
                    }
                });
                zzdkd.zza(zzdlhVar.zzhid, new zzdkc(i2) { // from class: com.google.android.gms.internal.ads.zzdlu
                    private final int zzehw;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzehw = i2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzauu) obj).onRewardedVideoAdFailedToLoad(this.zzehw);
                    }
                });
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    public final void zzd(zzyw zzywVar) {
        this.zzhig.set(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbsa
    public final void zzk(final zzvg zzvgVar) {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhic, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzdlo
                    private final zzvg zzfzh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzh = zzvgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzavr) obj).zzi(this.zzfzh);
                    }
                });
                zzdkd.zza(zzdlhVar.zzhic, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzdlr
                    private final zzvg zzfzh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzh = zzvgVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzavr) obj).onRewardedAdFailedToShow(this.zzfzh.errorCode);
                    }
                });
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    public final void zzb(zzavr zzavrVar) {
        this.zzhic.set(zzavrVar);
    }

    public final void zzb(zzavz zzavzVar) {
        this.zzhie.set(zzavzVar);
    }

    @Deprecated
    public final void zzb(zzauu zzauuVar) {
        this.zzhid.set(zzauuVar);
    }

    @Deprecated
    public final void zzb(zzaup zzaupVar) {
        this.zzhif.set(zzaupVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzb(final zzauk zzaukVar, final String str, final String str2) {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhic, new zzdkc(zzaukVar) { // from class: com.google.android.gms.internal.ads.zzdll
                    private final zzauk zzfzl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzl = zzaukVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        zzauk zzaukVar2 = this.zzfzl;
                        ((zzavr) obj).zza(new zzawi(zzaukVar2.getType(), zzaukVar2.getAmount()));
                    }
                });
                zzdkd.zza(zzdlhVar.zzhie, new zzdkc(zzaukVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdlk
                    private final String zzdjf;
                    private final String zzdlo;
                    private final zzauk zzfzl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzl = zzaukVar;
                        this.zzdjf = str;
                        this.zzdlo = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        zzauk zzaukVar2 = this.zzfzl;
                        ((zzavz) obj).zza(new zzawi(zzaukVar2.getType(), zzaukVar2.getAmount()), this.zzdjf, this.zzdlo);
                    }
                });
                zzdkd.zza(zzdlhVar.zzhid, new zzdkc(zzaukVar) { // from class: com.google.android.gms.internal.ads.zzdln
                    private final zzauk zzfzl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzl = zzaukVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzauu) obj).zza(this.zzfzl);
                    }
                });
                zzdkd.zza(zzdlhVar.zzhif, new zzdkc(zzaukVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzdlm
                    private final String zzdjf;
                    private final String zzdlo;
                    private final zzauk zzfzl;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfzl = zzaukVar;
                        this.zzdjf = str;
                        this.zzdlo = str2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzaup) obj).zza(this.zzfzl, this.zzdjf, this.zzdlo);
                    }
                });
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtt
    public final void zzb(@NonNull final zzvu zzvuVar) {
        zzdlh zzdlhVar = this;
        while (true) {
            zzdlh zzdlhVar2 = zzdlhVar.zzhih;
            if (zzdlhVar2 == null) {
                zzdkd.zza(zzdlhVar.zzhig, new zzdkc(zzvuVar) { // from class: com.google.android.gms.internal.ads.zzdlt
                    private final zzvu zzgaa;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgaa = zzvuVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdkc
                    public final void zzp(Object obj) {
                        ((zzyw) obj).zza(this.zzgaa);
                    }
                });
                return;
            }
            zzdlhVar = zzdlhVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdkk
    public final void zzb(zzdkk zzdkkVar) {
        this.zzhih = (zzdlh) zzdkkVar;
    }
}
