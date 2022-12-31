package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxz extends zzbwf<zzqw> implements zzqw {
    private final Context context;
    private final zzdmw zzesr;
    @GuardedBy("this")
    private Map<View, zzqs> zzgaz;

    public zzbxz(Context context, Set<zzbya<zzqw>> set, zzdmw zzdmwVar) {
        super(set);
        this.zzgaz = new WeakHashMap(1);
        this.context = context;
        this.zzesr = zzdmwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final synchronized void zza(final zzqx zzqxVar) {
        zza(new zzbwh(zzqxVar) { // from class: com.google.android.gms.internal.ads.zzbyc
            private final zzqx zzgbb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbb = zzqxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwh
            public final void zzo(Object obj) {
                ((zzqw) obj).zza(this.zzgbb);
            }
        });
    }

    public final synchronized void zzv(View view) {
        zzqs zzqsVar = this.zzgaz.get(view);
        if (zzqsVar == null) {
            zzqsVar = new zzqs(this.context, view);
            zzqsVar.zza(this);
            this.zzgaz.put(view, zzqsVar);
        }
        zzdmw zzdmwVar = this.zzesr;
        if (zzdmwVar != null && zzdmwVar.zzdxa) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcqt)).booleanValue()) {
                zzqsVar.zzen(((Long) zzwr.zzqr().zzd(zzabp.zzcqs)).longValue());
                return;
            }
        }
        zzqsVar.zzlt();
    }

    public final synchronized void zzw(View view) {
        if (this.zzgaz.containsKey(view)) {
            this.zzgaz.get(view).zzb(this);
            this.zzgaz.remove(view);
        }
    }
}
