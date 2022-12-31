package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpm implements zzeqb<zzcpj> {
    private final zzeqo<zzdrz> zzgjp;
    private final zzeqo<String> zzgmg;

    public zzcpm(zzeqo<String> zzeqoVar, zzeqo<zzdrz> zzeqoVar2) {
        this.zzgmg = zzeqoVar;
        this.zzgjp = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcpj(this.zzgmg.get(), this.zzgjp.get());
    }
}
