package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzabx {
    public static boolean zza(@Nullable zzacc zzaccVar, @Nullable zzaca zzacaVar, String... strArr) {
        if (zzaccVar == null || zzacaVar == null || !zzaccVar.zzdbd || zzacaVar == null) {
            return false;
        }
        return zzaccVar.zza(zzacaVar, com.google.android.gms.ads.internal.zzr.zzky().a(), strArr);
    }

    @Nullable
    public static zzaca zzb(@Nullable zzacc zzaccVar) {
        if (zzaccVar == null) {
            return null;
        }
        return zzaccVar.zzex(com.google.android.gms.ads.internal.zzr.zzky().a());
    }
}
