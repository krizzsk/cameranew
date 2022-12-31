package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbhk implements zzdic {
    private final /* synthetic */ zzbgz zzffq;
    private Context zzflt;
    private String zzflu;

    private zzbhk(zzbgz zzbgzVar) {
        this.zzffq = zzbgzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdic
    public final zzdid zzahi() {
        zzeqh.zza(this.zzflt, Context.class);
        zzeqh.zza(this.zzflu, String.class);
        return new zzbhn(this.zzffq, this.zzflt, this.zzflu);
    }

    @Override // com.google.android.gms.internal.ads.zzdic
    public final /* synthetic */ zzdic zzbx(Context context) {
        this.zzflt = (Context) zzeqh.checkNotNull(context);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdic
    public final /* synthetic */ zzdic zzfo(String str) {
        this.zzflu = (String) zzeqh.checkNotNull(str);
        return this;
    }
}
