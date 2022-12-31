package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcxy implements AppEventListener, zzbrm, zzbrr, zzbsa, zzbse, zzbtb, zzbtt, zzbua, zzvc {
    @Nullable
    private final zzdrz zzdic;
    private final AtomicReference<zzwx> zzgyb = new AtomicReference<>();
    private final AtomicReference<zzxt> zzgyc = new AtomicReference<>();
    private final AtomicReference<zzyw> zzgyd = new AtomicReference<>();
    private final AtomicReference<zzxc> zzgye = new AtomicReference<>();
    private final AtomicReference<zzyb> zzgyf = new AtomicReference<>();
    private final AtomicBoolean zzgyg = new AtomicBoolean(true);
    private final BlockingQueue<Pair<String, String>> zzgyh = new ArrayBlockingQueue(((Integer) zzwr.zzqr().zzd(zzabp.zzdap)).intValue());

    public zzcxy(@Nullable zzdrz zzdrzVar) {
        this.zzdic = zzdrzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvc
    public final void onAdClicked() {
        zzdkd.zza(this.zzgyb, zzcxz.zzgya);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdClosed() {
        zzdkd.zza(this.zzgyb, zzcxx.zzgya);
        zzdkd.zza(this.zzgyf, zzcya.zzgya);
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final void onAdImpression() {
        zzdkd.zza(this.zzgyb, zzcyc.zzgya);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdLeftApplication() {
        zzdkd.zza(this.zzgyb, zzcyk.zzgya);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final synchronized void onAdLoaded() {
        zzdkd.zza(this.zzgyb, zzcyj.zzgya);
        zzdkd.zza(this.zzgye, zzcym.zzgya);
        Iterator it = this.zzgyh.iterator();
        while (it.hasNext()) {
            final Pair pair = (Pair) it.next();
            zzdkd.zza(this.zzgyc, new zzdkc(pair) { // from class: com.google.android.gms.internal.ads.zzcyg
                private final Pair zzgyi;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgyi = pair;
                }

                @Override // com.google.android.gms.internal.ads.zzdkc
                public final void zzp(Object obj) {
                    Pair pair2 = this.zzgyi;
                    ((zzxt) obj).onAppEvent((String) pair2.first, (String) pair2.second);
                }
            });
        }
        this.zzgyh.clear();
        this.zzgyg.set(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onAdOpened() {
        zzdkd.zza(this.zzgyb, zzcyl.zzgya);
        zzdkd.zza(this.zzgyf, zzcyo.zzgya);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    @TargetApi(5)
    public final synchronized void onAppEvent(final String str, final String str2) {
        if (this.zzgyg.get()) {
            if (!this.zzgyh.offer(new Pair<>(str, str2))) {
                zzazk.zzdy("The queue for app events is full, dropping the new event.");
                zzdrz zzdrzVar = this.zzdic;
                if (zzdrzVar != null) {
                    zzdrzVar.zzb(zzdsa.zzgx("dae_action").zzu("dae_name", str).zzu("dae_data", str2));
                }
            }
            return;
        }
        zzdkd.zza(this.zzgyc, new zzdkc(str, str2) { // from class: com.google.android.gms.internal.ads.zzcye
            private final String zzdjf;
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
                this.zzdjf = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdkc
            public final void zzp(Object obj) {
                ((zzxt) obj).onAppEvent(this.zzdlh, this.zzdjf);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void onRewardedVideoStarted() {
    }

    public final void zza(zzxc zzxcVar) {
        this.zzgye.set(zzxcVar);
    }

    public final synchronized zzwx zzasj() {
        return this.zzgyb.get();
    }

    public final synchronized zzxt zzask() {
        return this.zzgyc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzb(zzauk zzaukVar, String str, String str2) {
    }

    public final void zzb(zzxt zzxtVar) {
        this.zzgyc.set(zzxtVar);
    }

    public final void zzc(zzwx zzwxVar) {
        this.zzgyb.set(zzwxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzd(zzatq zzatqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsa
    public final void zzk(final zzvg zzvgVar) {
        zzdkd.zza(this.zzgyf, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzcyd
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdkc
            public final void zzp(Object obj) {
                ((zzyb) obj).zzb(this.zzfzh);
            }
        });
    }

    public final void zzb(zzyw zzywVar) {
        this.zzgyd.set(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrr
    public final void zzc(final zzvg zzvgVar) {
        zzdkd.zza(this.zzgyb, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzcyf
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdkc
            public final void zzp(Object obj) {
                ((zzwx) obj).zzd(this.zzfzh);
            }
        });
        zzdkd.zza(this.zzgyb, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzcyi
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdkc
            public final void zzp(Object obj) {
                ((zzwx) obj).onAdFailedToLoad(this.zzfzh.errorCode);
            }
        });
        zzdkd.zza(this.zzgye, new zzdkc(zzvgVar) { // from class: com.google.android.gms.internal.ads.zzcyh
            private final zzvg zzfzh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfzh = zzvgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdkc
            public final void zzp(Object obj) {
                ((zzxc) obj).zzc(this.zzfzh);
            }
        });
        this.zzgyg.set(false);
        this.zzgyh.clear();
    }

    public final void zzb(zzyb zzybVar) {
        this.zzgyf.set(zzybVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzb(zzdnl zzdnlVar) {
        this.zzgyg.set(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbtt
    public final void zzb(@NonNull final zzvu zzvuVar) {
        zzdkd.zza(this.zzgyd, new zzdkc(zzvuVar) { // from class: com.google.android.gms.internal.ads.zzcyb
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
    }
}
