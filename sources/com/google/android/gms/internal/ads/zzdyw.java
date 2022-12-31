package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdyw<V> extends zzdyx<V, List<V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyw(zzdwy<? extends zzdzw<? extends V>> zzdwyVar, boolean z) {
        super(zzdwyVar, true);
        zzazw();
    }

    @Override // com.google.android.gms.internal.ads.zzdyx
    public final /* synthetic */ Object zzl(List list) {
        ArrayList zzet = zzdxl.zzet(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdyz zzdyzVar = (zzdyz) it.next();
            zzet.add(zzdyzVar != null ? zzdyzVar.value : null);
        }
        return Collections.unmodifiableList(zzet);
    }
}
