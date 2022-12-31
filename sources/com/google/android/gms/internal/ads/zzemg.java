package com.google.android.gms.internal.ads;

import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzemg<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zza(zzekl zzeklVar, zzemf<K, V> zzemfVar, K k2, V v) throws IOException {
        zzeku.zza(zzeklVar, zzemfVar.zzisk, 1, k2);
        zzeku.zza(zzeklVar, zzemfVar.zzism, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zza(zzemf<K, V> zzemfVar, K k2, V v) {
        return zzeku.zza(zzemfVar.zzisk, 1, k2) + zzeku.zza(zzemfVar.zzism, 2, v);
    }
}
