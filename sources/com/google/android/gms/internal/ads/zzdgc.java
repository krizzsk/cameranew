package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgc implements zzdfi<zzdgd> {
    private final Executor executor;
    @Nullable
    private final PackageInfo zzdue;
    private final int zzgqc;
    private final zzayk zzhdv;
    private final String zzhea;

    public zzdgc(zzayk zzaykVar, Executor executor, String str, @Nullable PackageInfo packageInfo, int i2) {
        this.zzhdv = zzaykVar;
        this.executor = executor;
        this.zzhea = str;
        this.zzdue = packageInfo;
        this.zzgqc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdgd> zzasy() {
        return zzdzk.zzb(zzdzk.zzb(this.zzhdv.zza(this.zzhea, this.zzdue, this.zzgqc), zzdgf.zzeaj, this.executor), Throwable.class, new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzdge
            private final zzdgc zzhec;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhec = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzhec.zzg((Throwable) obj);
            }
        }, this.executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzg(Throwable th) throws Exception {
        return zzdzk.zzag(new zzdgd(this.zzhea));
    }
}
