package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqk<T> implements zzeqb<Set<T>> {
    private static final zzeqb<Set<Object>> zzjcc = zzeqe.zzbb(Collections.emptySet());
    private final List<zzeqo<T>> zzjcd;
    private final List<zzeqo<Collection<T>>> zzjce;

    private zzeqk(List<zzeqo<T>> list, List<zzeqo<Collection<T>>> list2) {
        this.zzjcd = list;
        this.zzjce = list2;
    }

    public static <T> zzeqm<T> zzas(int i2, int i3) {
        return new zzeqm<>(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        int size = this.zzjcd.size();
        ArrayList arrayList = new ArrayList(this.zzjce.size());
        int size2 = this.zzjce.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> collection = this.zzjce.get(i2).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet zzie = zzeqa.zzie(size);
        int size3 = this.zzjcd.size();
        for (int i3 = 0; i3 < size3; i3++) {
            zzie.add(zzeqh.checkNotNull(this.zzjcd.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object obj : (Collection) arrayList.get(i4)) {
                zzie.add(zzeqh.checkNotNull(obj));
            }
        }
        return Collections.unmodifiableSet(zzie);
    }
}
