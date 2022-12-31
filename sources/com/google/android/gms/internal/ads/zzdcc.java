package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcc implements zzdfi<zzdfj<Bundle>> {
    @Nullable
    private final zzdjx zzhbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdcc(@Nullable zzdjx zzdjxVar) {
        this.zzhbj = zzdjxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        zzdjx zzdjxVar = this.zzhbj;
        return zzdzk.zzag((zzdjxVar == null || zzdjxVar.zzaur() == null || this.zzhbj.zzaur().isEmpty()) ? null : new zzdfj(this) { // from class: com.google.android.gms.internal.ads.zzdcf
            private final zzdcc zzhbk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbk = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Object obj) {
                this.zzhbk.zzo((Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Bundle bundle) {
        bundle.putString("key_schema", this.zzhbj.zzaur());
    }
}
