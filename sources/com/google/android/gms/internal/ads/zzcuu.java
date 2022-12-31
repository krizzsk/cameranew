package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbqx;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuu extends zzcun<zzchb> {
    private final zzbwg zzezg;
    private final zzbgc zzguy;
    private final zzbqx.zza zzguz;

    public zzcuu(zzbgc zzbgcVar, zzbqx.zza zzaVar, zzbwg zzbwgVar) {
        this.zzguy = zzbgcVar;
        this.zzguz = zzaVar;
        this.zzezg = zzbwgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcun
    protected final zzdzw<zzchb> zza(zzdnp zzdnpVar, Bundle bundle) {
        return this.zzguy.zzafp().zzf(this.zzguz.zza(zzdnpVar).zze(bundle).zzalo()).zzf(this.zzezg).zzaid().zzagj().zzalb();
    }
}
