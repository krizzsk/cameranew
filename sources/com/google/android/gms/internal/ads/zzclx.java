package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzclx implements zzdzl<String> {
    final /* synthetic */ zzclq zzgng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzclx(zzclq zzclqVar) {
        this.zzgng = zzclqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@Nullable String str) {
        long j2;
        Executor executor;
        final String str2 = str;
        synchronized (this) {
            this.zzgng.zzgms = true;
            zzclq zzclqVar = this.zzgng;
            long a = com.google.android.gms.ads.internal.zzr.zzky().a();
            j2 = this.zzgng.zzgmt;
            zzclqVar.zza("com.google.android.gms.ads.MobileAds", true, "", (int) (a - j2));
            executor = this.zzgng.executor;
            executor.execute(new Runnable(this, str2) { // from class: com.google.android.gms.internal.ads.zzcma
                private final String zzdjf;
                private final zzclx zzgnl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgnl = this;
                    this.zzdjf = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzclx zzclxVar = this.zzgnl;
                    zzclxVar.zzgng.zzgh(this.zzdjf);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        long j2;
        zzbaa zzbaaVar;
        synchronized (this) {
            this.zzgng.zzgms = true;
            zzclq zzclqVar = this.zzgng;
            long a = com.google.android.gms.ads.internal.zzr.zzky().a();
            j2 = this.zzgng.zzgmt;
            zzclqVar.zza("com.google.android.gms.ads.MobileAds", false, "Internal Error.", (int) (a - j2));
            zzbaaVar = this.zzgng.zzgmu;
            zzbaaVar.setException(new Exception());
        }
    }
}
