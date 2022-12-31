package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbbg extends zzbay {
    @Override // com.google.android.gms.internal.ads.zzbay
    @Nullable
    public final zzbav zza(Context context, zzbbo zzbboVar, int i2, boolean z, zzacc zzaccVar, zzbbl zzbblVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null || applicationInfo.targetSdkVersion >= 11) {
            zzbbn zzbbnVar = new zzbbn(context, zzbboVar.zzabj(), zzbboVar.getRequestId(), zzaccVar, zzbboVar.zzabd());
            if (i2 == 2) {
                return new zzbbr(context, zzbbnVar, zzbboVar, z, zzbay.zzb(zzbboVar), zzbblVar);
            }
            return new zzbam(context, zzbboVar, z, zzbay.zzb(zzbboVar), zzbblVar, new zzbbn(context, zzbboVar.zzabj(), zzbboVar.getRequestId(), zzaccVar, zzbboVar.zzabd()));
        }
        return null;
    }
}
