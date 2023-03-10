package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdgz implements zzdfi<zzdgw> {
    private String packageName;
    private zzdzv zzghl;
    private zzayg zzhep;

    public zzdgz(zzayg zzaygVar, zzdzv zzdzvVar, String str) {
        this.zzhep = zzaygVar;
        this.zzghl = zzdzvVar;
        this.packageName = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdgw> zzasy() {
        new zzbaa();
        final zzdzw<String> zzag = zzdzk.zzag(null);
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcxc)).booleanValue()) {
            zzag = this.zzhep.zzdz(this.packageName);
        }
        final zzdzw<String> zzea = this.zzhep.zzea(this.packageName);
        return zzdzk.zzb(zzag, zzea).zzb(new Callable(zzag, zzea) { // from class: com.google.android.gms.internal.ads.zzdgy
            private final zzdzw zzfym;
            private final zzdzw zzgig;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgig = zzag;
                this.zzfym = zzea;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzdgw((String) this.zzgig.get(), (String) this.zzfym.get());
            }
        }, zzazp.zzeic);
    }
}
