package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcfn {
    private final Executor zzfsj;
    private final zzbxz zzgcm;
    private final zzbkm zzgim;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfn(Executor executor, zzbkm zzbkmVar, zzbxz zzbxzVar) {
        this.zzfsj = executor;
        this.zzgcm = zzbxzVar;
        this.zzgim = zzbkmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzbeb zzbebVar, Map map) {
        this.zzgim.disable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzbeb zzbebVar, Map map) {
        this.zzgim.enable();
    }

    public final void zzi(final zzbeb zzbebVar) {
        if (zzbebVar == null) {
            return;
        }
        this.zzgcm.zzv(zzbebVar.getView());
        this.zzgcm.zza(new zzqw(zzbebVar) { // from class: com.google.android.gms.internal.ads.zzcfq
            private final zzbeb zzeuk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeuk = zzbebVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqw
            public final void zza(zzqx zzqxVar) {
                zzbfn zzacx = this.zzeuk.zzacx();
                Rect rect = zzqxVar.zzbrx;
                zzacx.zza(rect.left, rect.top, false);
            }
        }, this.zzfsj);
        this.zzgcm.zza(new zzqw(zzbebVar) { // from class: com.google.android.gms.internal.ads.zzcfp
            private final zzbeb zzeuk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeuk = zzbebVar;
            }

            @Override // com.google.android.gms.internal.ads.zzqw
            public final void zza(zzqx zzqxVar) {
                zzbeb zzbebVar2 = this.zzeuk;
                HashMap hashMap = new HashMap();
                hashMap.put("isVisible", zzqxVar.zzbrj ? "1" : "0");
                zzbebVar2.zza("onAdVisibilityChanged", hashMap);
            }
        }, this.zzfsj);
        this.zzgcm.zza(this.zzgim, this.zzfsj);
        this.zzgim.zzd(zzbebVar);
        zzbebVar.zza("/trackActiveViewUnit", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcfs
            private final zzcfn zzgin;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgin = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzgin.zzg((zzbeb) obj, map);
            }
        });
        zzbebVar.zza("/untrackActiveViewUnit", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcfr
            private final zzcfn zzgin;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgin = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzgin.zzf((zzbeb) obj, map);
            }
        });
    }
}
