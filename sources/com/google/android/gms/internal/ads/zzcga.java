package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcga extends zzafe {
    @Nullable
    private final String zzcio;
    private final zzccd zzgch;
    private final zzcbu zzgfm;

    public zzcga(@Nullable String str, zzcbu zzcbuVar, zzccd zzccdVar) {
        this.zzcio = str;
        this.zzgfm = zzcbuVar;
        this.zzgch = zzccdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void destroy() throws RemoteException {
        this.zzgfm.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getBody() throws RemoteException {
        return this.zzgch.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getCallToAction() throws RemoteException {
        return this.zzgch.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final Bundle getExtras() throws RemoteException {
        return this.zzgch.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getHeadline() throws RemoteException {
        return this.zzgch.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final List<?> getImages() throws RemoteException {
        return this.zzgch.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzcio;
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getPrice() throws RemoteException {
        return this.zzgch.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final double getStarRating() throws RemoteException {
        return this.zzgch.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final String getStore() throws RemoteException {
        return this.zzgch.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzzc getVideoController() throws RemoteException {
        return this.zzgch.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzgfm.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzgfm.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzgfm.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final b zztm() throws RemoteException {
        return d.z0(this.zzgfm);
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzaer zztn() throws RemoteException {
        return this.zzgch.zztn();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final zzaej zzto() throws RemoteException {
        return this.zzgch.zzto();
    }

    @Override // com.google.android.gms.internal.ads.zzaff
    public final b zztp() throws RemoteException {
        return this.zzgch.zztp();
    }
}
