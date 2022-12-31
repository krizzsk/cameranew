package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcgy implements zzeqb<zzcgt> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdss> zzexv;
    private final zzeqo<zzckn> zzexw;
    private final zzeqo<Executor> zzfux;
    private final zzeqo<zzazn> zzfze;
    private final zzeqo<zzei> zzgcz;
    private final zzeqo<com.google.android.gms.ads.internal.zzb> zzgih;
    private final zzeqo<zzbej> zzgjn;
    private final zzeqo<zzcqr> zzgjo;
    private final zzeqo<zzdrz> zzgjp;

    public zzcgy(zzeqo<Context> zzeqoVar, zzeqo<Executor> zzeqoVar2, zzeqo<zzei> zzeqoVar3, zzeqo<zzazn> zzeqoVar4, zzeqo<com.google.android.gms.ads.internal.zzb> zzeqoVar5, zzeqo<zzbej> zzeqoVar6, zzeqo<zzcqr> zzeqoVar7, zzeqo<zzdss> zzeqoVar8, zzeqo<zzckn> zzeqoVar9, zzeqo<zzdrz> zzeqoVar10) {
        this.zzewk = zzeqoVar;
        this.zzfux = zzeqoVar2;
        this.zzgcz = zzeqoVar3;
        this.zzfze = zzeqoVar4;
        this.zzgih = zzeqoVar5;
        this.zzgjn = zzeqoVar6;
        this.zzgjo = zzeqoVar7;
        this.zzexv = zzeqoVar8;
        this.zzexw = zzeqoVar9;
        this.zzgjp = zzeqoVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcgt(this.zzewk.get(), this.zzfux.get(), this.zzgcz.get(), this.zzfze.get(), this.zzgih.get(), this.zzgjn.get(), this.zzgjo.get(), this.zzexv.get(), this.zzexw.get(), this.zzgjp.get());
    }
}
