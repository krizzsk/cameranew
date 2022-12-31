package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbol implements zzeqb<String> {
    private final zzboj zzfwt;

    private zzbol(zzboj zzbojVar) {
        this.zzfwt = zzbojVar;
    }

    public static zzbol zza(zzboj zzbojVar) {
        return new zzbol(zzbojVar);
    }

    public static String zzb(zzboj zzbojVar) {
        return (String) zzeqh.zza(zzbojVar.zzakz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzb(this.zzfwt);
    }
}
