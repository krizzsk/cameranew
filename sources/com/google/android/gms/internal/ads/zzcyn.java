package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcyn implements zzeqb<zzcxy> {
    private final zzeqo<zzdrz> zzgjp;

    private zzcyn(zzeqo<zzdrz> zzeqoVar) {
        this.zzgjp = zzeqoVar;
    }

    public static zzcyn zzak(zzeqo<zzdrz> zzeqoVar) {
        return new zzcyn(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcxy(this.zzgjp.get());
    }
}
