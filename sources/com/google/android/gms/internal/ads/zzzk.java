package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzk {
    private final int zzado;
    private final int zzadp;
    private final String zzadq;
    private final boolean zzbni;
    private final int zzcho;
    private final String zzchr;
    private final String zzcht;
    private final Bundle zzchv;
    private final String zzchx;
    private final boolean zzchz;
    private final List<String> zzcib;
    private final int zzcic;
    private final Bundle zzcka;
    private final AdInfo zzcke;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzckf;
    private final SearchAdRequest zzckg;
    private final Set<String> zzckh;
    private final Set<String> zzcki;
    private final Date zzmx;
    private final Set<String> zzmz;
    private final Location zznb;

    public zzzk(zzzj zzzjVar) {
        this(zzzjVar, null);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzmx;
    }

    public final String getContentUrl() {
        return this.zzcht;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcka.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzchv;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcho;
    }

    public final Set<String> getKeywords() {
        return this.zzmz;
    }

    public final Location getLocation() {
        return this.zznb;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbni;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.zzadq;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzckf.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcka.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzchr;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchz;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzzn.zzrs().getRequestConfiguration();
        zzwr.zzqn();
        String zzbm = zzaza.zzbm(context);
        return this.zzckh.contains(zzbm) || requestConfiguration.getTestDeviceIds().contains(zzbm);
    }

    public final List<String> zzrh() {
        return new ArrayList(this.zzcib);
    }

    public final String zzri() {
        return this.zzchx;
    }

    public final SearchAdRequest zzrj() {
        return this.zzckg;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzrk() {
        return this.zzckf;
    }

    public final Bundle zzrl() {
        return this.zzcka;
    }

    public final int zzrm() {
        return this.zzado;
    }

    public final Set<String> zzrn() {
        return this.zzcki;
    }

    @Nullable
    public final AdInfo zzro() {
        return this.zzcke;
    }

    public final int zzrp() {
        return this.zzadp;
    }

    public final int zzrq() {
        return this.zzcic;
    }

    public zzzk(zzzj zzzjVar, SearchAdRequest searchAdRequest) {
        this.zzmx = zzzj.zza(zzzjVar);
        this.zzcht = zzzj.zzb(zzzjVar);
        this.zzcib = zzzj.zzc(zzzjVar);
        this.zzcho = zzzj.zzd(zzzjVar);
        this.zzmz = Collections.unmodifiableSet(zzzj.zze(zzzjVar));
        this.zznb = zzzj.zzf(zzzjVar);
        this.zzbni = zzzj.zzg(zzzjVar);
        this.zzcka = zzzj.zzh(zzzjVar);
        this.zzckf = Collections.unmodifiableMap(zzzj.zzi(zzzjVar));
        this.zzchr = zzzj.zzj(zzzjVar);
        this.zzchx = zzzj.zzk(zzzjVar);
        this.zzckg = searchAdRequest;
        this.zzado = zzzj.zzl(zzzjVar);
        this.zzckh = Collections.unmodifiableSet(zzzj.zzm(zzzjVar));
        this.zzchv = zzzj.zzn(zzzjVar);
        this.zzcki = Collections.unmodifiableSet(zzzj.zzo(zzzjVar));
        this.zzchz = zzzj.zzp(zzzjVar);
        this.zzcke = zzzj.zzq(zzzjVar);
        this.zzadp = zzzj.zzr(zzzjVar);
        this.zzadq = zzzj.zzs(zzzjVar);
        this.zzcic = zzzj.zzt(zzzjVar);
    }
}
