package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public final class zzacd {
    private final Map<String, zzaca> zzdbh = new HashMap();
    @Nullable
    private final zzacc zzdbi;

    public zzacd(@Nullable zzacc zzaccVar) {
        this.zzdbi = zzaccVar;
    }

    public final void zza(String str, zzaca zzacaVar) {
        this.zzdbh.put(str, zzacaVar);
    }

    public final void zzb(String str, String str2, long j2) {
        zzacc zzaccVar = this.zzdbi;
        zzaca zzacaVar = this.zzdbh.get(str2);
        String[] strArr = {str};
        if (zzaccVar != null && zzacaVar != null) {
            zzaccVar.zza(zzacaVar, j2, strArr);
        }
        Map<String, zzaca> map = this.zzdbh;
        zzacc zzaccVar2 = this.zzdbi;
        map.put(str, zzaccVar2 == null ? null : zzaccVar2.zzex(j2));
    }

    @Nullable
    public final zzacc zzsp() {
        return this.zzdbi;
    }
}
