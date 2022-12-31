package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqv;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdke<RequestComponentT extends zzbqv<AdT>, AdT> implements zzdkn<RequestComponentT, AdT> {
    @Nullable
    @GuardedBy("this")
    private RequestComponentT zzhhb;
    private final zzdkn<RequestComponentT, AdT> zzhho;

    public zzdke(zzdkn<RequestComponentT, AdT> zzdknVar) {
        this.zzhho = zzdknVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdkn
    /* renamed from: zzauo */
    public final synchronized RequestComponentT zzaun() {
        return this.zzhhb;
    }

    @Override // com.google.android.gms.internal.ads.zzdkn
    public final synchronized zzdzw<AdT> zza(zzdko zzdkoVar, zzdkp<RequestComponentT> zzdkpVar) {
        if (zzdkoVar.zzhhs != null) {
            RequestComponentT zzagm = zzdkpVar.zzc(zzdkoVar.zzhht).zzagm();
            this.zzhhb = zzagm;
            return zzagm.zzagj().zzb(zzdkoVar.zzhhs);
        }
        zzdzw<AdT> zza = this.zzhho.zza(zzdkoVar, zzdkpVar);
        this.zzhhb = this.zzhho.zzaun();
        return zza;
    }
}
