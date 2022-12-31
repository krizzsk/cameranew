package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcvl implements zzcro<zzdog, zzctg> {
    private final zzcin zzgmw;
    @GuardedBy("this")
    private final Map<String, zzcrl<zzdog, zzctg>> zzgvp = new HashMap();

    public zzcvl(zzcin zzcinVar) {
        this.zzgmw = zzcinVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcro
    public final zzcrl<zzdog, zzctg> zzf(String str, JSONObject jSONObject) throws zzdnt {
        synchronized (this) {
            zzcrl<zzdog, zzctg> zzcrlVar = this.zzgvp.get(str);
            if (zzcrlVar == null) {
                zzdog zzd = this.zzgmw.zzd(str, jSONObject);
                if (zzd == null) {
                    return null;
                }
                zzcrlVar = new zzcrl<>(zzd, new zzctg(), str);
                this.zzgvp.put(str, zzcrlVar);
            }
            return zzcrlVar;
        }
    }
}
