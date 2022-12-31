package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import com.tencent.tauth.AuthActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcla {
    private String zzgml;
    private zzckw zzgmm;
    @GuardedBy("this")
    private List<Map<String, String>> zzgmi = new ArrayList();
    @GuardedBy("this")
    private boolean zzgmj = false;
    @GuardedBy("this")
    private boolean zzgmk = false;
    private final com.google.android.gms.ads.internal.util.zzf zzeaw = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();

    public zzcla(String str, zzckw zzckwVar) {
        this.zzgml = str;
        this.zzgmm = zzckwVar;
    }

    private final Map<String, String> zzara() {
        Map<String, String> zzaqx = this.zzgmm.zzaqx();
        zzaqx.put("tms", Long.toString(com.google.android.gms.ads.internal.zzr.zzky().a(), 10));
        zzaqx.put("tid", this.zzeaw.zzyu() ? "" : this.zzgml);
        return zzaqx;
    }

    public final synchronized void zzaqy() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcro)).booleanValue()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
                if (!this.zzgmj) {
                    Map<String, String> zzara = zzara();
                    zzara.put(AuthActivity.ACTION_KEY, "init_started");
                    this.zzgmi.add(zzara);
                    this.zzgmj = true;
                }
            }
        }
    }

    public final synchronized void zzaqz() {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcro)).booleanValue()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
                if (!this.zzgmk) {
                    Map<String, String> zzara = zzara();
                    zzara.put(AuthActivity.ACTION_KEY, "init_finished");
                    this.zzgmi.add(zzara);
                    for (Map<String, String> map : this.zzgmi) {
                        this.zzgmm.zzo(map);
                    }
                    this.zzgmk = true;
                }
            }
        }
    }

    public final synchronized void zzgf(String str) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcro)).booleanValue()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
                Map<String, String> zzara = zzara();
                zzara.put(AuthActivity.ACTION_KEY, "adapter_init_started");
                zzara.put("ancn", str);
                this.zzgmi.add(zzara);
            }
        }
    }

    public final synchronized void zzgg(String str) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcro)).booleanValue()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
                Map<String, String> zzara = zzara();
                zzara.put(AuthActivity.ACTION_KEY, "adapter_init_finished");
                zzara.put("ancn", str);
                this.zzgmi.add(zzara);
            }
        }
    }

    public final synchronized void zzs(String str, String str2) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcro)).booleanValue()) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
                Map<String, String> zzara = zzara();
                zzara.put(AuthActivity.ACTION_KEY, "adapter_init_finished");
                zzara.put("ancn", str);
                zzara.put("rqe", str2);
                this.zzgmi.add(zzara);
            }
        }
    }
}
