package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.b;
import com.google.ads.mediation.e;
import com.google.android.gms.dynamic.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaoi<NETWORK_EXTRAS extends e, SERVER_PARAMETERS extends MediationServerParameters> extends zzani {
    private final b<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdoc;
    private final NETWORK_EXTRAS zzdod;

    public zzaoi(b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar, NETWORK_EXTRAS network_extras) {
        this.zzdoc = bVar;
        this.zzdod = network_extras;
    }

    private static boolean zzc(zzvl zzvlVar) {
        if (zzvlVar.zzchq) {
            return true;
        }
        zzwr.zzqn();
        return zzaza.zzzw();
    }

    private final SERVER_PARAMETERS zzdk(String str) throws RemoteException {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzdoc.getServerParametersType();
            if (serverParametersType != null) {
                SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
                newInstance.a(hashMap);
                return newInstance;
            }
            return null;
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void destroy() throws RemoteException {
        try {
            this.zzdoc.destroy();
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzzc getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void resume() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showInterstitial() throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdoc;
        if (!(bVar instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazk.zzex(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazk.zzdy("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdoc).showInterstitial();
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzajj zzajjVar, List<zzajr> list) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzavf zzavfVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, zzavf zzavfVar, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar, zzaeh zzaehVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        zza(bVar, zzvsVar, zzvlVar, str, null, zzankVar);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(zzvl zzvlVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzb(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzc(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzs(com.google.android.gms.dynamic.b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zzt(com.google.android.gms.dynamic.b bVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final com.google.android.gms.dynamic.b zzuu() throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar = this.zzdoc;
        if (!(bVar instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(bVar.getClass().getCanonicalName());
            zzazk.zzex(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return d.z0(((MediationBannerAdapter) bVar).getBannerView());
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanr zzuv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzans zzuw() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzux() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final Bundle zzuy() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final boolean zzuz() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzafn zzva() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzanx zzvb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final zzapy zzvd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        a aVar;
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar2 = this.zzdoc;
        if (!(bVar2 instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(bVar2.getClass().getCanonicalName());
            zzazk.zzex(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzazk.zzdy("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdoc;
            zzaol zzaolVar = new zzaol(zzankVar);
            Activity activity = (Activity) d.y0(bVar);
            SERVER_PARAMETERS zzdk = zzdk(str);
            int i2 = 0;
            a[] aVarArr = {a.b, a.c, a.f3310d, a.f3311e, a.f3312f, a.f3313g};
            while (true) {
                if (i2 < 6) {
                    if (aVarArr[i2].b() == zzvsVar.width && aVarArr[i2].a() == zzvsVar.height) {
                        aVar = aVarArr[i2];
                        break;
                    }
                    i2++;
                } else {
                    aVar = new a(com.google.android.gms.ads.zza.zza(zzvsVar.width, zzvsVar.height, zzvsVar.zzacy));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzaolVar, activity, zzdk, aVar, zzaox.zza(zzvlVar, zzc(zzvlVar)), this.zzdod);
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, zzank zzankVar) throws RemoteException {
        zza(bVar, zzvlVar, str, (String) null, zzankVar);
    }

    @Override // com.google.android.gms.internal.ads.zzanj
    public final void zza(com.google.android.gms.dynamic.b bVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws RemoteException {
        b<NETWORK_EXTRAS, SERVER_PARAMETERS> bVar2 = this.zzdoc;
        if (!(bVar2 instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(bVar2.getClass().getCanonicalName());
            zzazk.zzex(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzazk.zzdy("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdoc).requestInterstitialAd(new zzaol(zzankVar), (Activity) d.y0(bVar), zzdk(str), zzaox.zza(zzvlVar, zzc(zzvlVar)), this.zzdod);
        } catch (Throwable th) {
            zzazk.zzc("", th);
            throw new RemoteException();
        }
    }
}
