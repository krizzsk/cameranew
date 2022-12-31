package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdey implements zzdfi<zzdfj<Bundle>> {
    private final boolean zzhdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdey(@Nullable zzdkv zzdkvVar) {
        if (zzdkvVar != null) {
            this.zzhdd = true;
        } else {
            this.zzhdd = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        return zzdzk.zzag(this.zzhdd ? zzdfb.zzhde : null);
    }
}
