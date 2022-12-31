package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsw {
    private final Context context;
    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzzk zzacw;
    private final String zzbut;
    private zzxl zzbuz;
    private final AppOpenAd.AppOpenAdLoadCallback zzbva;
    private final zzanf zzbvb = new zzanf();
    private final zzvq zzact = zzvq.zzcif;

    public zzsw(Context context, String str, zzzk zzzkVar, @AppOpenAd.AppOpenAdOrientation int i2, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.context = context;
        this.zzbut = str;
        this.zzacw = zzzkVar;
        this.orientation = i2;
        this.zzbva = appOpenAdLoadCallback;
    }

    public final void zzmu() {
        try {
            this.zzbuz = zzwr.zzqo().zza(this.context, zzvs.zzqg(), this.zzbut, this.zzbvb);
            this.zzbuz.zza(new zzvx(this.orientation));
            this.zzbuz.zza(new zzsg(this.zzbva, this.zzbut));
            this.zzbuz.zza(zzvq.zza(this.context, this.zzacw));
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }
}
