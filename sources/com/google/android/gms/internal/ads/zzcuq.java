package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqx;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuq extends zzcun<zzblv> {
    private final zzcaq zzezb;
    private final zzbwg zzezg;
    private final zzcxa zzfmf;
    private final ViewGroup zzfum;
    private final zzbts zzfwb;
    private final zzbgc zzguy;
    private final zzbqx.zza zzguz;

    public zzcuq(zzbgc zzbgcVar, zzbqx.zza zzaVar, zzcxa zzcxaVar, zzbwg zzbwgVar, zzcaq zzcaqVar, zzbts zzbtsVar, @Nullable ViewGroup viewGroup) {
        this.zzguy = zzbgcVar;
        this.zzguz = zzaVar;
        this.zzfmf = zzcxaVar;
        this.zzezg = zzbwgVar;
        this.zzezb = zzcaqVar;
        this.zzfwb = zzbtsVar;
        this.zzfum = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcun
    protected final zzdzw<zzblv> zza(zzdnp zzdnpVar, Bundle bundle) {
        return this.zzguy.zzafh().zzd(this.zzguz.zza(zzdnpVar).zze(bundle).zzalo()).zzd(this.zzezg).zza(this.zzfmf).zzb(this.zzezb).zza(new zzbnq(this.zzfwb)).zzd(new zzblu(this.zzfum)).zzahk().zzagj().zzalb();
    }
}
