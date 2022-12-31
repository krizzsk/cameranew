package com.google.android.gms.internal.places;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzdd implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzlz;
    private final /* synthetic */ zzdb zzma;

    private zzdd(zzdb zzdbVar) {
        List list;
        this.zzma = zzdbVar;
        list = zzdbVar.zzlq;
        this.pos = list.size();
    }

    private final Iterator<Map.Entry<K, V>> zzde() {
        Map map;
        if (this.zzlz == null) {
            map = this.zzma.zzlt;
            this.zzlz = map.entrySet().iterator();
        }
        return this.zzlz;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.pos;
        if (i2 > 0) {
            list = this.zzma.zzlq;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return zzde().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (!zzde().hasNext()) {
            list = this.zzma.zzlq;
            int i2 = this.pos - 1;
            this.pos = i2;
            return (Map.Entry) list.get(i2);
        }
        return (Map.Entry) zzde().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzdd(zzdb zzdbVar, zzde zzdeVar) {
        this(zzdbVar);
    }
}
