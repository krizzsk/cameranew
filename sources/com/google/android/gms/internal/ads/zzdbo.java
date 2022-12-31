package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdbo implements zzdvz {
    static final zzdvz zzeaj = new zzdbo();

    private zzdbo() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final Object apply(Object obj) {
        final ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdfj(arrayList) { // from class: com.google.android.gms.internal.ads.zzdbr
            private final ArrayList zzhau;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhau = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdfj
            public final void zzr(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.zzhau);
            }
        };
    }
}
