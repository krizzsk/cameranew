package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbju {
    private final Executor executor;
    private final String zzbro;
    private final zzamo zzfry;
    private zzbjz zzfrz;
    private final zzaif<Object> zzfsa = new zzbjt(this);
    private final zzaif<Object> zzfsb = new zzbjv(this);

    public zzbju(String str, zzamo zzamoVar, Executor executor) {
        this.zzbro = str;
        this.zzfry = zzamoVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzn(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(this.zzbro);
    }

    public final void zza(zzbjz zzbjzVar) {
        this.zzfry.zzc("/updateActiveView", this.zzfsa);
        this.zzfry.zzc("/untrackActiveViewUnit", this.zzfsb);
        this.zzfrz = zzbjzVar;
    }

    public final void zzaix() {
        this.zzfry.zzd("/updateActiveView", this.zzfsa);
        this.zzfry.zzd("/untrackActiveViewUnit", this.zzfsb);
    }

    public final void zzb(zzbeb zzbebVar) {
        zzbebVar.zzb("/updateActiveView", this.zzfsa);
        zzbebVar.zzb("/untrackActiveViewUnit", this.zzfsb);
    }

    public final void zza(zzbeb zzbebVar) {
        zzbebVar.zza("/updateActiveView", this.zzfsa);
        zzbebVar.zza("/untrackActiveViewUnit", this.zzfsb);
    }
}
