package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcuw {
    private final Clock zzbqg;
    private final zzcrq zzfxh;
    private final zzcuy zzgvg;
    private final List<String> zzgvh = Collections.synchronizedList(new ArrayList());
    private final boolean zzgvi = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcza)).booleanValue();

    public zzcuw(Clock clock, zzcuy zzcuyVar, zzcrq zzcrqVar) {
        this.zzbqg = clock;
        this.zzgvg = zzcuyVar;
        this.zzfxh = zzcrqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> zzdzw<T> zza(zzdnb zzdnbVar, zzdmw zzdmwVar, zzdzw<T> zzdzwVar) {
        long a = this.zzbqg.a();
        String str = zzdmwVar.zzdlu;
        if (str != null) {
            zzdzk.zza(zzdzwVar, new zzcuv(this, a, str, zzdmwVar, zzdnbVar), zzazp.zzeih);
        }
        return zzdzwVar;
    }

    public final String zzasc() {
        return TextUtils.join("_", this.zzgvh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, int i2, long j2, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(j2);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzgvh.add(sb2);
    }
}
