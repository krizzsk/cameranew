package com.google.android.gms.internal.ads;

import android.content.Context;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbhq implements zzdjn {
    private final /* synthetic */ zzbgz zzffq;
    private Context zzflt;
    private String zzflu;
    private zzvs zzfnv;

    private zzbhq(zzbgz zzbgzVar) {
        this.zzffq = zzbgzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjn
    public final zzdjk zzaht() {
        zzeqh.zza(this.zzflt, Context.class);
        zzeqh.zza(this.zzflu, String.class);
        zzeqh.zza(this.zzfnv, zzvs.class);
        return new zzbht(this.zzffq, this.zzflt, this.zzflu, this.zzfnv);
    }

    @Override // com.google.android.gms.internal.ads.zzdjn
    public final /* synthetic */ zzdjn zzby(Context context) {
        this.zzflt = (Context) zzeqh.checkNotNull(context);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjn
    public final /* synthetic */ zzdjn zzc(zzvs zzvsVar) {
        this.zzfnv = (zzvs) zzeqh.checkNotNull(zzvsVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdjn
    public final /* synthetic */ zzdjn zzfp(String str) {
        this.zzflu = (String) zzeqh.checkNotNull(str);
        return this;
    }
}
