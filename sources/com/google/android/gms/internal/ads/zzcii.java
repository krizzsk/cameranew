package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcii implements zzeqb<zzcif> {
    private final zzeqo<zzbeb> zzfuu;

    private zzcii(zzeqo<zzbeb> zzeqoVar) {
        this.zzfuu = zzeqoVar;
    }

    public static zzcii zzaa(zzeqo<zzbeb> zzeqoVar) {
        return new zzcii(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzcif(this.zzfuu.get());
    }
}
