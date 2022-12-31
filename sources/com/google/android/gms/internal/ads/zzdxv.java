package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxv<K> extends zzdxg<K> {
    private final transient zzdxd<K> zzhxs;
    private final transient zzdxh<K, ?> zzhyl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxv(zzdxh<K, ?> zzdxhVar, zzdxd<K> zzdxdVar) {
        this.zzhyl = zzdxhVar;
        this.zzhxs = zzdxdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzhyl.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzhyl.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zza(Object[] objArr, int i2) {
        return zzazk().zza(objArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdya<K> zzazg() {
        return (zzdya) zzazk().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, com.google.android.gms.internal.ads.zzdwy
    public final zzdxd<K> zzazk() {
        return this.zzhxs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return true;
    }
}
