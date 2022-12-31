package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcim {
    @GuardedBy("this")
    private final Map<String, zzcij> zzgkj = new HashMap();

    @Nullable
    private final synchronized zzcij zzgd(String str) {
        return this.zzgkj.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdog zzdogVar) {
        if (this.zzgkj.containsKey(str)) {
            return;
        }
        try {
            this.zzgkj.put(str, new zzcij(str, zzdogVar.zzvc(), zzdogVar.zzvd()));
        } catch (zzdnt unused) {
        }
    }

    @Nullable
    public final zzcij zzi(List<String> list) {
        for (String str : list) {
            zzcij zzgd = zzgd(str);
            if (zzgd != null) {
                return zzgd;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzapk zzapkVar) {
        if (this.zzgkj.containsKey(str)) {
            return;
        }
        try {
            this.zzgkj.put(str, new zzcij(str, zzapkVar.zzvc(), zzapkVar.zzvd()));
        } catch (Throwable unused) {
        }
    }
}
