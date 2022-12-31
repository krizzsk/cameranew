package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcab implements zzeqb<String> {
    public static zzcab zzamx() {
        zzcab zzcabVar;
        zzcabVar = zzcae.zzgbo;
        return zzcabVar;
    }

    public static String zzamy() {
        return (String) zzeqh.zza("interstitial", "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzamy();
    }
}
