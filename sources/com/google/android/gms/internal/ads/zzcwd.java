package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcwd implements zzeqb<zzcwe> {
    private final zzeqo<zzcxh> zzgwd;

    private zzcwd(zzeqo<zzcxh> zzeqoVar) {
        this.zzgwd = zzeqoVar;
    }

    public static zzcwd zzai(zzeqo<zzcxh> zzeqoVar) {
        return new zzcwd(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcwe(this.zzgwd.get());
    }
}
