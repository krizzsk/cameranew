package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public final class zzacc {
    private final Object lock;
    final boolean zzdbd;
    private final List<zzaca> zzdbe = new LinkedList();
    private final Map<String, String> zzdbf;
    @Nullable
    private zzacc zzdbg;

    public zzacc(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzdbf = linkedHashMap;
        this.lock = new Object();
        this.zzdbd = true;
        linkedHashMap.put(AuthActivity.ACTION_KEY, str);
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public final boolean zza(zzaca zzacaVar, long j2, String... strArr) {
        synchronized (this.lock) {
            for (String str : strArr) {
                this.zzdbe.add(new zzaca(j2, str, zzacaVar));
            }
        }
        return true;
    }

    public final void zzc(@Nullable zzacc zzaccVar) {
        synchronized (this.lock) {
            this.zzdbg = zzaccVar;
        }
    }

    @Nullable
    public final zzaca zzex(long j2) {
        if (this.zzdbd) {
            return new zzaca(j2, null, null);
        }
        return null;
    }

    public final void zzg(String str, String str2) {
        zzabs zzxm;
        if (!this.zzdbd || TextUtils.isEmpty(str2) || (zzxm = com.google.android.gms.ads.internal.zzr.zzkv().zzxm()) == null) {
            return;
        }
        synchronized (this.lock) {
            zzabw zzcq = zzxm.zzcq(str);
            Map<String, String> map = this.zzdbf;
            map.put(str, zzcq.zzf(map.get(str), str2));
        }
    }

    public final zzacf zzsn() {
        zzacf zzacfVar;
        boolean booleanValue = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.lock) {
            for (zzaca zzacaVar : this.zzdbe) {
                long time = zzacaVar.getTime();
                String zzsl = zzacaVar.zzsl();
                zzaca zzsm = zzacaVar.zzsm();
                if (zzsm != null && time > 0) {
                    sb.append(zzsl);
                    sb.append('.');
                    sb.append(time - zzsm.getTime());
                    sb.append(',');
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzsm.getTime()))) {
                            hashMap.put(Long.valueOf(zzsm.getTime()), new StringBuilder(zzsl));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzsm.getTime()));
                            sb2.append('+');
                            sb2.append(zzsl);
                        }
                    }
                }
            }
            this.zzdbe.clear();
            String str = null;
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis() + (((Long) entry.getKey()).longValue() - com.google.android.gms.ads.internal.zzr.zzky().a()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzacfVar = new zzacf(sb.toString(), str);
        }
        return zzacfVar;
    }

    public final Map<String, String> zzso() {
        zzacc zzaccVar;
        synchronized (this.lock) {
            zzabs zzxm = com.google.android.gms.ads.internal.zzr.zzkv().zzxm();
            if (zzxm != null && (zzaccVar = this.zzdbg) != null) {
                return zzxm.zza(this.zzdbf, zzaccVar.zzso());
            }
            return this.zzdbf;
        }
    }
}
