package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcln implements zzeqb<zzclo> {
    private final zzeqo<zzbgc> zzewg;
    private final zzeqo<zzclc> zzgjp;

    private zzcln(zzeqo<zzclc> zzeqoVar, zzeqo<zzbgc> zzeqoVar2) {
        this.zzgjp = zzeqoVar;
        this.zzewg = zzeqoVar2;
    }

    public static zzcln zzah(zzeqo<zzclc> zzeqoVar, zzeqo<zzbgc> zzeqoVar2) {
        return new zzcln(zzeqoVar, zzeqoVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzclo(this.zzgjp.get(), this.zzewg.get());
    }
}
