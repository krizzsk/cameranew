package com.google.android.gms.internal.places;

import java.io.IOException;
/* loaded from: classes2.dex */
public final class zzcc<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zzb(zzaj zzajVar, zzcb<K, V> zzcbVar, K k2, V v) throws IOException {
        zzav.zzb(zzajVar, zzcbVar.zzkj, 1, k2);
        zzav.zzb(zzajVar, zzcbVar.zzkl, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zzb(zzcb<K, V> zzcbVar, K k2, V v) {
        return zzav.zzb(zzcbVar.zzkj, 1, k2) + zzav.zzb(zzcbVar.zzkl, 2, v);
    }
}
