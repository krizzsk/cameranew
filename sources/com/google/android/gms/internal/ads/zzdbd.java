package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdbd implements zzdfi<zzdfj<Bundle>> {
    private final Set<String> zzhav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbd(Set<String> set) {
        this.zzhav = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        final ArrayList arrayList = new ArrayList();
        for (String str : this.zzhav) {
            arrayList.add(str);
        }
        return zzdzk.zzag(new zzdfj(arrayList) { // from class: com.google.android.gms.internal.ads.zzdbc
            private final ArrayList zzhau;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhau = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.zzhau);
            }
        });
    }
}
