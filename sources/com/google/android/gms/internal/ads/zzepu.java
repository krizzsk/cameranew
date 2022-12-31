package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzepu implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzepr zzjbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzepu(zzepr zzeprVar) {
        this.zzjbm = zzeprVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos < this.zzjbm.zzjbk.size() || this.zzjbm.zzjbl.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.lang.Object] */
    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zzjbm.zzjbk.size()) {
            zzepr zzeprVar = this.zzjbm;
            zzeprVar.zzjbk.add(zzeprVar.zzjbl.next());
        }
        List<E> list = this.zzjbm.zzjbk;
        int i2 = this.pos;
        this.pos = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
