package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzalv implements zzbae<zzakm> {
    final /* synthetic */ zzalq zzdkl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalv(zzalq zzalqVar) {
        this.zzdkl = zzalqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbae
    public final /* synthetic */ void zzg(zzakm zzakmVar) {
        final zzakm zzakmVar2 = zzakmVar;
        zzazp.zzeig.execute(new Runnable(this, zzakmVar2) { // from class: com.google.android.gms.internal.ads.zzalu
            private final zzalv zzdkj;
            private final zzakm zzdkk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkj = this;
                this.zzdkk = zzakmVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.util.zzar zzarVar;
                zzalv zzalvVar = this.zzdkj;
                zzakm zzakmVar3 = this.zzdkk;
                zzarVar = zzalvVar.zzdkl.zzdjp;
                zzarVar.zzg(zzakmVar3);
                zzakmVar3.destroy();
            }
        });
    }
}
