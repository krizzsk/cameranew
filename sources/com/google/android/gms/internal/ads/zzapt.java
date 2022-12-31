package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzapt extends zzapn {
    private MediationRewardedAd zzdnp;
    private final RtbAdapter zzdoo;
    private MediationInterstitialAd zzdop;
    private String zzdoq = "";

    public zzapt(RtbAdapter rtbAdapter) {
        this.zzdoo = rtbAdapter;
    }

    private static boolean zzc(zzvl zzvlVar) {
        if (zzvlVar.zzchq) {
            return true;
        }
        zzwr.zzqn();
        return zzaza.zzzw();
    }

    private final Bundle zzd(zzvl zzvlVar) {
        Bundle bundle;
        Bundle bundle2 = zzvlVar.zzchu;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zzdoo.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static Bundle zzdp(String str) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzazk.zzex(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                return bundle2;
            }
            return bundle;
        } catch (JSONException e2) {
            zzazk.zzc("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzzc getVideoController() {
        RtbAdapter rtbAdapter = this.zzdoo;
        if (rtbAdapter instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) rtbAdapter).getVideoController();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzaoy zzaoyVar, zzank zzankVar, zzvs zzvsVar) throws RemoteException {
        try {
            this.zzdoo.loadBannerAd(new MediationBannerAdConfiguration((Context) d.y0(bVar), str, zzdp(str2), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str2, zzvlVar), com.google.android.gms.ads.zza.zza(zzvsVar.width, zzvsVar.height, zzvsVar.zzacy), this.zzdoq), new zzaps(this, zzaoyVar, zzankVar));
        } catch (Throwable th) {
            zzazk.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final boolean zzaa(b bVar) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzdnp;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) d.y0(bVar));
            return true;
        } catch (Throwable th) {
            zzazk.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzb(String str, String str2, zzvl zzvlVar, b bVar, zzapj zzapjVar, zzank zzankVar) throws RemoteException {
        try {
            this.zzdoo.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) d.y0(bVar), str, zzdp(str2), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str2, zzvlVar), this.zzdoq), zza(zzapjVar, zzankVar));
        } catch (Throwable th) {
            zzazk.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzdm(String str) {
        this.zzdoq = str;
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzapy zzvc() throws RemoteException {
        return zzapy.zza(this.zzdoo.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final zzapy zzvd() throws RemoteException {
        return zzapy.zza(this.zzdoo.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zzy(b bVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final boolean zzz(b bVar) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzdop;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) d.y0(bVar));
            return true;
        } catch (Throwable th) {
            zzazk.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzapd zzapdVar, zzank zzankVar) throws RemoteException {
        try {
            this.zzdoo.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) d.y0(bVar), str, zzdp(str2), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str2, zzvlVar), this.zzdoq), new zzapv(this, zzapdVar, zzankVar));
        } catch (Throwable th) {
            zzazk.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzapj zzapjVar, zzank zzankVar) throws RemoteException {
        try {
            this.zzdoo.loadRewardedAd(new MediationRewardedAdConfiguration((Context) d.y0(bVar), str, zzdp(str2), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str2, zzvlVar), this.zzdoq), zza(zzapjVar, zzankVar));
        } catch (Throwable th) {
            zzazk.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(String str, String str2, zzvl zzvlVar, b bVar, zzape zzapeVar, zzank zzankVar) throws RemoteException {
        try {
            this.zzdoo.loadNativeAd(new MediationNativeAdConfiguration((Context) d.y0(bVar), str, zzdp(str2), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str2, zzvlVar), this.zzdoq), new zzapu(this, zzapeVar, zzankVar));
        } catch (Throwable th) {
            zzazk.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapk
    public final void zza(b bVar, String str, Bundle bundle, Bundle bundle2, zzvs zzvsVar, zzapp zzappVar) throws RemoteException {
        AdFormat adFormat;
        try {
            zzapx zzapxVar = new zzapx(this, zzappVar);
            RtbAdapter rtbAdapter = this.zzdoo;
            char c = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals(TapjoyConstants.TJC_PLUGIN_NATIVE)) {
                        c = 4;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1911491517:
                    if (str.equals("rewarded_interstitial")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c == 3) {
                adFormat = AdFormat.REWARDED_INTERSTITIAL;
            } else if (c == 4) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) d.y0(bVar), arrayList, bundle, com.google.android.gms.ads.zza.zza(zzvsVar.width, zzvsVar.height, zzvsVar.zzacy)), zzapxVar);
        } catch (Throwable th) {
            zzazk.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzapj zzapjVar, zzank zzankVar) {
        return new zzapw(this, zzapjVar, zzankVar);
    }

    @Nullable
    private static String zza(String str, zzvl zzvlVar) {
        String str2 = zzvlVar.zzadq;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }
}
