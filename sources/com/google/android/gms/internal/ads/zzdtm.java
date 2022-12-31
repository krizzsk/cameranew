package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzdua;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdtm {
    private final Context context;
    private final Looper zzhsz;

    public zzdtm(@NonNull Context context, @NonNull Looper looper) {
        this.context = context;
        this.zzhsz = looper;
    }

    public final void zzhf(@NonNull String str) {
        new zzdtl(this.context, this.zzhsz, (zzdua) ((zzelb) zzdua.zzayc().zzhi(this.context.getPackageName()).zzb(zzdua.zza.BLOCKED_IMPRESSION).zza(zzdtt.zzaya().zzhh(str).zzb(zzdtt.zza.BLOCKED_REASON_BACKGROUND)).zzbiw())).zzaxv();
    }
}
