package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgt implements Callable<zzcgk> {
    private final Context context;
    private final zzbej zzbqa;
    private final zzckn zzdib;
    private final zzdrz zzdic;
    private final zzcqr zzdie;
    private final zzazn zzdtx;
    private final zzei zzesm;
    private final zzdss zzfrf;
    private final Executor zzfsj;
    private final com.google.android.gms.ads.internal.zzb zzghz;

    public zzcgt(Context context, Executor executor, zzei zzeiVar, zzazn zzaznVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbej zzbejVar, zzcqr zzcqrVar, zzdss zzdssVar, zzckn zzcknVar, zzdrz zzdrzVar) {
        this.context = context;
        this.zzfsj = executor;
        this.zzesm = zzeiVar;
        this.zzdtx = zzaznVar;
        this.zzghz = zzbVar;
        this.zzbqa = zzbejVar;
        this.zzdie = zzcqrVar;
        this.zzfrf = zzdssVar;
        this.zzdib = zzcknVar;
        this.zzdic = zzdrzVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcgk call() throws Exception {
        zzcgk zzcgkVar = new zzcgk(this);
        zzcgkVar.zzapo();
        return zzcgkVar;
    }
}
