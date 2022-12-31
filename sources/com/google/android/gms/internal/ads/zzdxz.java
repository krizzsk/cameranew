package com.google.android.gms.internal.ads;

import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxz<E> extends zzdxg<E> {
    private final transient E zzhyr;
    private transient int zzhys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxz(E e2) {
        this.zzhyr = (E) zzdwl.checkNotNull(e2);
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzhyr.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i2 = this.zzhys;
        if (i2 == 0) {
            int hashCode = this.zzhyr.hashCode();
            this.zzhys = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.zzhyr.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zza(Object[] objArr, int i2) {
        objArr[i2] = this.zzhyr;
        return i2 + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdya<E> zzazg() {
        return new zzdxi(this.zzhyr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    final boolean zzazn() {
        return this.zzhys != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    final zzdxd<E> zzazo() {
        return zzdxd.zzac(this.zzhyr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxz(E e2, int i2) {
        this.zzhyr = e2;
        this.zzhys = i2;
    }
}
