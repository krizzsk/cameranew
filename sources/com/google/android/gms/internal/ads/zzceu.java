package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzceu implements zzdvz {
    static final zzdvz zzeaj = new zzceu();

    private zzceu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvz
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzaed zzaedVar : (List) obj) {
            if (zzaedVar != null) {
                arrayList.add(zzaedVar);
            }
        }
        return arrayList;
    }
}
