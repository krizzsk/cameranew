package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdde implements zzeqb<zzddc> {
    private final zzeqo<Context> zzewk;
    private final zzeqo<zzdzv> zzhak;
    private final zzeqo<Set<String>> zzhax;
    private final zzeqo<ViewGroup> zzhcd;

    private zzdde(zzeqo<zzdzv> zzeqoVar, zzeqo<ViewGroup> zzeqoVar2, zzeqo<Context> zzeqoVar3, zzeqo<Set<String>> zzeqoVar4) {
        this.zzhak = zzeqoVar;
        this.zzhcd = zzeqoVar2;
        this.zzewk = zzeqoVar3;
        this.zzhax = zzeqoVar4;
    }

    public static zzdde zzj(zzeqo<zzdzv> zzeqoVar, zzeqo<ViewGroup> zzeqoVar2, zzeqo<Context> zzeqoVar3, zzeqo<Set<String>> zzeqoVar4) {
        return new zzdde(zzeqoVar, zzeqoVar2, zzeqoVar3, zzeqoVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzddc(this.zzhak.get(), this.zzhcd.get(), this.zzewk.get(), this.zzhax.get());
    }
}
