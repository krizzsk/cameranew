package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjq implements Iterator<Map.Entry> {
    final /* synthetic */ zzjs zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzjq(zzjs zzjsVar, zzjl zzjlVar) {
        this.zza = zzjsVar;
    }

    private final Iterator<Map.Entry> zza() {
        Map map;
        if (this.zzd == null) {
            map = this.zza.zzc;
            this.zzd = map.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.zzb + 1;
        list = this.zza.zzb;
        if (i2 >= list.size()) {
            map = this.zza.zzc;
            return !map.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Map.Entry next() {
        List list;
        Object next;
        List list2;
        this.zzc = true;
        int i2 = this.zzb + 1;
        this.zzb = i2;
        list = this.zza.zzb;
        if (i2 < list.size()) {
            list2 = this.zza.zzb;
            next = list2.get(this.zzb);
        } else {
            next = zza().next();
        }
        return (Map.Entry) next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzm();
            int i2 = this.zzb;
            list = this.zza.zzb;
            if (i2 < list.size()) {
                zzjs zzjsVar = this.zza;
                int i3 = this.zzb;
                this.zzb = i3 - 1;
                zzjsVar.zzk(i3);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
