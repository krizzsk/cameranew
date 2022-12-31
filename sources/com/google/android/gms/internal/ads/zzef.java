package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcb;
import com.google.android.gms.internal.ads.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzef extends zzea {
    private zzef(Context context, String str, boolean z, int i2) {
        super(context, str, z, i2);
    }

    public static zzef zzb(String str, Context context, boolean z) {
        return zzb(str, context, false, zzcv.zznj);
    }

    @Override // com.google.android.gms.internal.ads.zzea
    protected final List<Callable<Void>> zza(zzfc zzfcVar, Context context, zzcf.zza.zzb zzbVar, zzcb.zza zzaVar) {
        if (zzfcVar.zzcg() != null && this.zzxf) {
            int zzbu = zzfcVar.zzbu();
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(super.zza(zzfcVar, context, zzbVar, zzaVar));
            arrayList.add(new zzfw(zzfcVar, "STRTQE1n2Nae56fJRHDsAlh+RkDZLMqz8liSxR9TDmqE0af2eosWM09BrF9F7xVl", "is62fUaYcSmzgiuoZcKcHzaXthoDXTG3NdfDayg76F0=", zzbVar, zzbu, 24));
            return arrayList;
        }
        return super.zza(zzfcVar, context, zzbVar, zzaVar);
    }

    public static zzef zzb(String str, Context context, boolean z, int i2) {
        zzea.zza(context, z);
        zzea.zza(str, context, z, i2);
        return new zzef(context, str, z, i2);
    }
}
