package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaoa extends zzani {
    private final Object zzdnl;
    private zzaof zzdnm;
    private zzavf zzdnn;
    private b zzdno;
    private MediationRewardedAd zzdnp;

    public zzaoa(@NonNull MediationAdapter mediationAdapter) {
        this.zzdnl = mediationAdapter;
    }

    private final Bundle zzd(zzvl zzvlVar) {
        Bundle bundle;
        Bundle bundle2 = zzvlVar.zzchu;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zzdnl.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void destroy() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdnl;
        if (!(obj instanceof zzbga)) {
            String canonicalName = zzbga.class.getCanonicalName();
            String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazk.zzex(sb.toString());
            return new Bundle();
        }
        return ((zzbga) obj).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzzc getVideoController() {
        Object obj = this.zzdnl;
        if (obj instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean isInitialized() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazk.zzdy("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdnl).isInitialized();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzdnn != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazk.zzex(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void pause() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void resume() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Object obj = this.zzdnl;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazk.zzdy(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzazk.zzc("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showInterstitial() throws RemoteException {
        if (this.zzdnl instanceof MediationInterstitialAdapter) {
            zzazk.zzdy("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdnl).showInterstitial();
                return;
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showVideo() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazk.zzdy("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdnl).showVideo();
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdnp;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) d.y0(this.zzdno));
            } else {
                zzazk.zzev("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazk.zzex(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        zza(bVar, zzvsVar, zzvlVar, str, null, zzankVar);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzb(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        if (this.zzdnl instanceof Adapter) {
            zzazk.zzdy("Requesting rewarded ad from adapter.");
            try {
                ((Adapter) this.zzdnl).loadRewardedAd(new MediationRewardedAdConfiguration((Context) d.y0(bVar), "", zza(str, zzvlVar, (String) null), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str, zzvlVar), ""), zza(zzankVar));
                return;
            } catch (Exception e2) {
                zzazk.zzc("", e2);
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzc(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        if (this.zzdnl instanceof Adapter) {
            zzazk.zzdy("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) this.zzdnl).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) d.y0(bVar), "", zza(str, zzvlVar, (String) null), zzd(zzvlVar), zzc(zzvlVar), zzvlVar.zznb, zzvlVar.zzado, zzvlVar.zzadp, zza(str, zzvlVar), ""), zza(zzankVar));
                return;
            } catch (Exception e2) {
                zzazk.zzc("", e2);
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzs(b bVar) throws RemoteException {
        Context context = (Context) d.y0(bVar);
        Object obj = this.zzdnl;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzt(b bVar) throws RemoteException {
        if (this.zzdnl instanceof Adapter) {
            zzazk.zzdy("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdnp;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) d.y0(bVar));
                return;
            } else {
                zzazk.zzev("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final b zzuu() throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return d.z0(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanr zzuv() {
        NativeAdMapper zzvi = this.zzdnm.zzvi();
        if (zzvi instanceof NativeAppInstallAdMapper) {
            return new zzaoh((NativeAppInstallAdMapper) zzvi);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzans zzuw() {
        NativeAdMapper zzvi = this.zzdnm.zzvi();
        if (zzvi instanceof NativeContentAdMapper) {
            return new zzaog((NativeContentAdMapper) zzvi);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzux() {
        Object obj = this.zzdnl;
        if (!(obj instanceof zzbfz)) {
            String canonicalName = zzbfz.class.getCanonicalName();
            String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzazk.zzex(sb.toString());
            return new Bundle();
        }
        return ((zzbfz) obj).zzux();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzuy() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean zzuz() {
        return this.zzdnl instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzafn zzva() {
        NativeCustomTemplateAd zzvk = this.zzdnm.zzvk();
        if (zzvk instanceof zzafo) {
            return ((zzafo) zzvk).zztv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanx zzvb() {
        UnifiedNativeAdMapper zzvj = this.zzdnm.zzvj();
        if (zzvj != null) {
            return new zzaoz(zzvj);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvc() {
        Object obj = this.zzdnl;
        if (obj instanceof Adapter) {
            return zzapy.zza(((Adapter) obj).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvd() {
        Object obj = this.zzdnl;
        if (obj instanceof Adapter) {
            return zzapy.zza(((Adapter) obj).getSDKVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        AdSize zza;
        if (this.zzdnl instanceof MediationBannerAdapter) {
            zzazk.zzdy("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdnl;
                zzaob zzaobVar = new zzaob(zzvlVar.zzchn == -1 ? null : new Date(zzvlVar.zzchn), zzvlVar.zzcho, zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null, zzvlVar.zznb, zzc(zzvlVar), zzvlVar.zzado, zzvlVar.zzchz, zzvlVar.zzadp, zza(str, zzvlVar));
                Bundle bundle = zzvlVar.zzchu;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null;
                if (zzvsVar.zzcin) {
                    zza = com.google.android.gms.ads.zza.zza(zzvsVar.width, zzvsVar.height);
                } else {
                    zza = com.google.android.gms.ads.zza.zza(zzvsVar.width, zzvsVar.height, zzvsVar.zzacy);
                }
                mediationBannerAdapter.requestBannerAd((Context) d.y0(bVar), new zzaof(zzankVar), zza(str, zzvlVar, str2), zza, zzaobVar, bundle2);
                return;
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    public zzaoa(@NonNull Adapter adapter) {
        this.zzdnl = adapter;
    }

    private static boolean zzc(zzvl zzvlVar) {
        if (zzvlVar.zzchq) {
            return true;
        }
        zzwr.zzqn();
        return zzaza.zzzw();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        zza(bVar, zzvlVar, str, (String) null, zzankVar);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        if (this.zzdnl instanceof MediationInterstitialAdapter) {
            zzazk.zzdy("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdnl;
                zzaob zzaobVar = new zzaob(zzvlVar.zzchn == -1 ? null : new Date(zzvlVar.zzchn), zzvlVar.zzcho, zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null, zzvlVar.zznb, zzc(zzvlVar), zzvlVar.zzado, zzvlVar.zzchz, zzvlVar.zzadp, zza(str, zzvlVar));
                Bundle bundle = zzvlVar.zzchu;
                mediationInterstitialAdapter.requestInterstitialAd((Context) d.y0(bVar), new zzaof(zzankVar), zza(str, zzvlVar, str2), zzaobVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                return;
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar, zzaeh zzaehVar, List<String> list) throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                zzaoj zzaojVar = new zzaoj(zzvlVar.zzchn == -1 ? null : new Date(zzvlVar.zzchn), zzvlVar.zzcho, zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null, zzvlVar.zznb, zzc(zzvlVar), zzvlVar.zzado, zzaehVar, list, zzvlVar.zzchz, zzvlVar.zzadp, zza(str, zzvlVar));
                Bundle bundle = zzvlVar.zzchu;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzdnm = new zzaof(zzankVar);
                mediationNativeAdapter.requestNativeAd((Context) d.y0(bVar), this.zzdnm, zza(str, zzvlVar, str2), zzaojVar, bundle2);
                return;
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationNativeAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzvl zzvlVar, String str, zzavf zzavfVar, String str2) throws RemoteException {
        zzaob zzaobVar;
        Bundle bundle;
        Object obj = this.zzdnl;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazk.zzdy("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnl;
                Bundle zza = zza(str2, zzvlVar, (String) null);
                if (zzvlVar != null) {
                    zzaob zzaobVar2 = new zzaob(zzvlVar.zzchn == -1 ? null : new Date(zzvlVar.zzchn), zzvlVar.zzcho, zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null, zzvlVar.zznb, zzc(zzvlVar), zzvlVar.zzado, zzvlVar.zzchz, zzvlVar.zzadp, zza(str2, zzvlVar));
                    Bundle bundle2 = zzvlVar.zzchu;
                    bundle = bundle2 != null ? bundle2.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaobVar = zzaobVar2;
                } else {
                    zzaobVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) d.y0(bVar), zzaobVar, str, new zzavg(zzavfVar), zza, bundle);
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.zzdno = bVar;
            this.zzdnn = zzavfVar;
            zzavfVar.zzaf(d.z0(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazk.zzex(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzavf zzavfVar, List<String> list) throws RemoteException {
        if (this.zzdnl instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzazk.zzdy("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdnl;
                ArrayList arrayList = new ArrayList();
                for (String str : list) {
                    arrayList.add(zza(str, (zzvl) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) d.y0(bVar), new zzavg(zzavfVar), arrayList);
                return;
            } catch (Throwable th) {
                zzazk.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        }
        String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
        String canonicalName2 = this.zzdnl.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzazk.zzex(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str) throws RemoteException {
        zza(zzvlVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str, String str2) throws RemoteException {
        Object obj = this.zzdnl;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzazk.zzdy("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdnl;
                zzaob zzaobVar = new zzaob(zzvlVar.zzchn == -1 ? null : new Date(zzvlVar.zzchn), zzvlVar.zzcho, zzvlVar.zzchp != null ? new HashSet(zzvlVar.zzchp) : null, zzvlVar.zznb, zzc(zzvlVar), zzvlVar.zzado, zzvlVar.zzchz, zzvlVar.zzadp, zza(str, zzvlVar));
                Bundle bundle = zzvlVar.zzchu;
                mediationRewardedVideoAdAdapter.loadAd(zzaobVar, zza(str, zzvlVar, str2), bundle != null ? bundle.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzazk.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzdno, zzvlVar, str, new zzaoe((Adapter) obj, this.zzdnn));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdnl.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzazk.zzex(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(b bVar, zzajj zzajjVar, List<zzajr> list) throws RemoteException {
        AdFormat adFormat;
        if (this.zzdnl instanceof Adapter) {
            zzaod zzaodVar = new zzaod(this, zzajjVar);
            ArrayList arrayList = new ArrayList();
            for (zzajr zzajrVar : list) {
                String str = zzajrVar.zzdiy;
                str.hashCode();
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
                            c = 1;
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
                            c = 3;
                            break;
                        }
                        break;
                    case 1911491517:
                        if (str.equals("rewarded_interstitial")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        adFormat = AdFormat.BANNER;
                        break;
                    case 1:
                        adFormat = AdFormat.NATIVE;
                        break;
                    case 2:
                        adFormat = AdFormat.REWARDED;
                        break;
                    case 3:
                        adFormat = AdFormat.INTERSTITIAL;
                        break;
                    case 4:
                        adFormat = AdFormat.REWARDED_INTERSTITIAL;
                        break;
                    default:
                        adFormat = null;
                        break;
                }
                if (adFormat != null) {
                    arrayList.add(new MediationConfiguration(adFormat, zzajrVar.extras));
                }
            }
            ((Adapter) this.zzdnl).initialize((Context) d.y0(bVar), zzaodVar, arrayList);
            return;
        }
        throw new RemoteException();
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzank zzankVar) {
        return new zzaoc(this, zzankVar);
    }

    private final Bundle zza(String str, zzvl zzvlVar, String str2) throws RemoteException {
        String valueOf = String.valueOf(str);
        zzazk.zzdy(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
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
                bundle = bundle2;
            }
            if (this.zzdnl instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvlVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvlVar.zzado);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
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
