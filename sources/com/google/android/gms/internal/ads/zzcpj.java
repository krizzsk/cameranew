package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpj implements zzbxl {
    private final zzdrz zzdic;
    private final String zzgml;
    @GuardedBy("this")
    private boolean zzgmj = false;
    @GuardedBy("this")
    private boolean zzgmk = false;
    private final com.google.android.gms.ads.internal.util.zzf zzeaw = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();

    public zzcpj(String str, zzdrz zzdrzVar) {
        this.zzgml = str;
        this.zzdic = zzdrzVar;
    }

    private final zzdsa zzgl(String str) {
        return zzdsa.zzgx(str).zzu("tms", Long.toString(com.google.android.gms.ads.internal.zzr.zzky().a(), 10)).zzu("tid", this.zzeaw.zzyu() ? "" : this.zzgml);
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final synchronized void zzamm() {
        if (!this.zzgmj) {
            this.zzdic.zzb(zzgl("init_started"));
            this.zzgmj = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final synchronized void zzamn() {
        if (!this.zzgmk) {
            this.zzdic.zzb(zzgl("init_finished"));
            this.zzgmk = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzft(String str) {
        this.zzdic.zzb(zzgl("adapter_init_started").zzu("ancn", str));
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzfu(String str) {
        this.zzdic.zzb(zzgl("adapter_init_finished").zzu("ancn", str));
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzm(String str, String str2) {
        this.zzdic.zzb(zzgl("adapter_init_finished").zzu("ancn", str).zzu("rqe", str2));
    }
}
