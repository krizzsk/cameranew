package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhi implements zzeqb<String> {
    private final zzdhj zzheu;

    public zzdhi(zzdhj zzdhjVar) {
        this.zzheu = zzdhjVar;
    }

    public static String zzb(zzdhj zzdhjVar) {
        return (String) zzeqh.zza(zzdhjVar.zzatv(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzb(this.zzheu);
    }
}
