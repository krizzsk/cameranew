package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdco implements zzdfi<zzdct> {
    private final Context zzaad;
    private final zzdzv zzghl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdco(Context context, zzdzv zzdzvVar) {
        this.zzaad = context;
        this.zzghl = zzdzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdct> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcr
            private final zzdco zzhbv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbv = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhbv.zzatf();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdct zzatf() throws Exception {
        com.google.android.gms.ads.internal.zzr.zzkr();
        String zzav = com.google.android.gms.ads.internal.util.zzj.zzav(this.zzaad);
        String string = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcxt)).booleanValue() ? this.zzaad.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzr.zzkr();
        return new zzdct(zzav, string, com.google.android.gms.ads.internal.util.zzj.zzaw(this.zzaad));
    }
}
