package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzj {
    private String zzadq;
    private String zzchr;
    private String zzcht;
    private String zzchx;
    private boolean zzchz;
    private AdInfo zzcke;
    private Date zzmx;
    private Location zznb;
    private final HashSet<String> zzcjz = new HashSet<>();
    private final Bundle zzcka = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzckb = new HashMap<>();
    private final HashSet<String> zzckc = new HashSet<>();
    private final Bundle zzchv = new Bundle();
    private final HashSet<String> zzckd = new HashSet<>();
    private final List<String> zzcib = new ArrayList();
    private int zzcho = -1;
    private boolean zzbni = false;
    private int zzado = -1;
    private int zzadp = -1;
    private int zzcic = 60000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zze(zzzj zzzjVar) {
        return zzzjVar.zzcjz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Location zzf(zzzj zzzjVar) {
        return zzzjVar.zznb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzg(zzzj zzzjVar) {
        return zzzjVar.zzbni;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle zzh(zzzj zzzjVar) {
        return zzzjVar.zzcka;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashMap zzi(zzzj zzzjVar) {
        return zzzjVar.zzckb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzj(zzzj zzzjVar) {
        return zzzjVar.zzchr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzk(zzzj zzzjVar) {
        return zzzjVar.zzchx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzl(zzzj zzzjVar) {
        return zzzjVar.zzado;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zzm(zzzj zzzjVar) {
        return zzzjVar.zzckc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Bundle zzn(zzzj zzzjVar) {
        return zzzjVar.zzchv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashSet zzo(zzzj zzzjVar) {
        return zzzjVar.zzckd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean zzp(zzzj zzzjVar) {
        return zzzjVar.zzchz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ AdInfo zzq(zzzj zzzjVar) {
        return zzzjVar.zzcke;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzr(zzzj zzzjVar) {
        return zzzjVar.zzadp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzs(zzzj zzzjVar) {
        return zzzjVar.zzadq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzt(zzzj zzzjVar) {
        return zzzjVar.zzcic;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbni = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzckb.put(networkExtras.getClass(), networkExtras);
        }
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzchz = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcka.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcka.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcka.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzc(List<String> list) {
        this.zzcib.clear();
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                zzazk.zzex("neighboring content URL should not be null or empty");
            } else {
                this.zzcib.add(str);
            }
        }
    }

    public final void zzcf(String str) {
        this.zzcjz.add(str);
    }

    public final void zzcg(String str) {
        this.zzckc.add(str);
    }

    public final void zzch(String str) {
        this.zzckc.remove(str);
    }

    public final void zzci(String str) {
        this.zzcht = str;
    }

    public final void zzcj(String str) {
        this.zzchr = str;
    }

    public final void zzck(String str) {
        this.zzchx = str;
    }

    public final void zzcl(String str) {
        this.zzckd.add(str);
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadq = str;
        }
    }

    @Deprecated
    public final void zzcw(int i2) {
        this.zzcho = i2;
    }

    @Deprecated
    public final void zzcx(int i2) {
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            this.zzadp = i2;
        }
    }

    public final void zzcy(int i2) {
        this.zzcic = i2;
    }

    public final void zzd(String str, String str2) {
        this.zzchv.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzado = z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zzd(zzzj zzzjVar) {
        return zzzjVar.zzcho;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzb(zzzj zzzjVar) {
        return zzzjVar.zzcht;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List zzc(zzzj zzzjVar) {
        return zzzjVar.zzcib;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcka.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzmx = date;
    }

    public final void zza(Location location) {
        this.zznb = location;
    }

    public final void zza(AdInfo adInfo) {
        this.zzcke = adInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Date zza(zzzj zzzjVar) {
        return zzzjVar.zzmx;
    }
}
