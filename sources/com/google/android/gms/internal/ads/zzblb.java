package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblb implements zzeqb<String> {
    public static zzblb zzajm() {
        zzblb zzblbVar;
        zzblbVar = zzble.zzfub;
        return zzblbVar;
    }

    public static String zzajn() {
        return (String) zzeqh.zza("app_open_ad", "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzajn();
    }
}
