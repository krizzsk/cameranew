package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbir implements zzeqb<zzazo> {
    private final zzeqo<String> zzfqs;

    public zzbir(zzeqo<String> zzeqoVar) {
        this.zzfqs = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzazo) zzeqh.zza(new zzazo(this.zzfqs.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
