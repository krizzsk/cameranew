package com.google.android.gms.internal.ads;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcmp implements zzeqb<List<String>> {
    public static zzcmp zzari() {
        zzcmp zzcmpVar;
        zzcmpVar = zzcms.zzgob;
        return zzcmpVar;
    }

    public static List<String> zzarj() {
        return (List) zzeqh.zza(zzabp.zzsc(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzarj();
    }
}
