package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzenq implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeno zzius;
    private Iterator<Map.Entry<K, V>> zziut;

    private zzenq(zzeno zzenoVar) {
        List list;
        this.zzius = zzenoVar;
        list = zzenoVar.zziun;
        this.pos = list.size();
    }

    private final Iterator<Map.Entry<K, V>> zzbkv() {
        Map map;
        if (this.zziut == null) {
            map = this.zzius.zziuq;
            this.zziut = map.entrySet().iterator();
        }
        return this.zziut;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.pos;
        if (i2 > 0) {
            list = this.zzius.zziun;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return zzbkv().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (!zzbkv().hasNext()) {
            list = this.zzius.zziun;
            int i2 = this.pos - 1;
            this.pos = i2;
            return (Map.Entry) list.get(i2);
        }
        return (Map.Entry) zzbkv().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzenq(zzeno zzenoVar, zzenn zzennVar) {
        this(zzenoVar);
    }
}
