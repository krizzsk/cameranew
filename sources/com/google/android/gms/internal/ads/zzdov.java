package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdov {
    private zzdoy zzhmm = null;
    private zzdoy zzhmn = null;
    private zzdoy zzhmo = null;
    private zzdoy zzhmp = null;
    private zzdoy zzhmq = null;
    private zzdoy zzhmr = null;
    private zzdoy zzhms = null;
    private zzdoy zzhmt = null;

    public final void onAdClosed() {
        zzdoy zzdoyVar = this.zzhmp;
        if (zzdoyVar != null) {
            zzdoyVar.execute();
        }
    }

    public final void zza(zzdoy zzdoyVar) {
        this.zzhmp = zzdoyVar;
    }
}
