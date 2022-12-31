package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzenw implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeno zzius;
    private Iterator<Map.Entry<K, V>> zziut;
    private boolean zziux;

    private zzenw(zzeno zzenoVar) {
        this.zzius = zzenoVar;
        this.pos = -1;
    }

    private final Iterator<Map.Entry<K, V>> zzbkv() {
        Map map;
        if (this.zziut == null) {
            map = this.zzius.zziuo;
            this.zziut = map.entrySet().iterator();
        }
        return this.zziut;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.pos + 1;
        list = this.zzius.zziun;
        if (i2 >= list.size()) {
            map = this.zzius.zziuo;
            if (map.isEmpty() || !zzbkv().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.zziux = true;
        int i2 = this.pos + 1;
        this.pos = i2;
        list = this.zzius.zziun;
        if (i2 < list.size()) {
            list2 = this.zzius.zziun;
            return (Map.Entry) list2.get(this.pos);
        }
        return (Map.Entry) zzbkv().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.zziux) {
            this.zziux = false;
            this.zzius.zzbkt();
            int i2 = this.pos;
            list = this.zzius.zziun;
            if (i2 < list.size()) {
                zzeno zzenoVar = this.zzius;
                int i3 = this.pos;
                this.pos = i3 - 1;
                zzenoVar.zzhv(i3);
                return;
            }
            zzbkv().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzenw(zzeno zzenoVar, zzenn zzennVar) {
        this(zzenoVar);
    }
}
