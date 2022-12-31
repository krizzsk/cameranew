package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxt<K, V> extends zzdxg<Map.Entry<K, V>> {
    private final transient int size;
    private final transient Object[] zzhyh;
    private final transient zzdxh<K, V> zzhyl;
    private final transient int zzhym = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxt(zzdxh<K, V> zzdxhVar, Object[] objArr, int i2, int i3) {
        this.zzhyl = zzdxhVar;
        this.zzhyh = objArr;
        this.size = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzhyl.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zza(Object[] objArr, int i2) {
        return zzazk().zza(objArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdya<Map.Entry<K, V>> zzazg() {
        return (zzdya) zzazk().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    final zzdxd<Map.Entry<K, V>> zzazo() {
        return new zzdxs(this);
    }
}
