package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgf extends zzagq {
    @Nullable
    private final String zzcio;
    private final zzccd zzgch;
    private final zzcbu zzgfm;

    public zzcgf(@Nullable String str, zzcbu zzcbuVar, zzccd zzccdVar) {
        this.zzcio = str;
        this.zzgfm = zzcbuVar;
        this.zzgch = zzccdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzgfm.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void destroy() throws RemoteException {
        this.zzgfm.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getAdvertiser() throws RemoteException {
        return this.zzgch.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getBody() throws RemoteException {
        return this.zzgch.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getCallToAction() throws RemoteException {
        return this.zzgch.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final Bundle getExtras() throws RemoteException {
        return this.zzgch.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getHeadline() throws RemoteException {
        return this.zzgch.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final List<?> getImages() throws RemoteException {
        return this.zzgch.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzcio;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final List<?> getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzgch.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getPrice() throws RemoteException {
        return this.zzgch.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final double getStarRating() throws RemoteException {
        return this.zzgch.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String getStore() throws RemoteException {
        return this.zzgch.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final zzzc getVideoController() throws RemoteException {
        return this.zzgch.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final boolean isCustomClickGestureEnabled() {
        return this.zzgfm.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return (this.zzgch.getMuteThisAdReasons().isEmpty() || this.zzgch.zzanx() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzgfm.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void recordCustomClickGesture() {
        this.zzgfm.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzgfm.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzgfm.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void zza(zzagm zzagmVar) throws RemoteException {
        this.zzgfm.zza(zzagmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final zzyx zzki() throws RemoteException {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcyy)).booleanValue()) {
            return this.zzgfm.zzakr();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final b zztm() throws RemoteException {
        return d.z0(this.zzgfm);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final zzaer zztn() throws RemoteException {
        return this.zzgch.zztn();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final zzaej zzto() throws RemoteException {
        return this.zzgch.zzto();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final b zztp() throws RemoteException {
        return this.zzgch.zztp();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void zztx() {
        this.zzgfm.zztx();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final zzaem zzty() throws RemoteException {
        return this.zzgfm.zzanr().zzty();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void zza(@Nullable zzyn zzynVar) throws RemoteException {
        this.zzgfm.zza(zzynVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void zza(zzyj zzyjVar) throws RemoteException {
        this.zzgfm.zza(zzyjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final void zza(zzyw zzywVar) throws RemoteException {
        this.zzgfm.zza(zzywVar);
    }
}
