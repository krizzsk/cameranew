package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxx<E> extends zzdxg<E> {
    static final zzdxx<Object> zzhyn = new zzdxx<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzahx;
    private final transient Object[] zzhyo;
    private final transient Object[] zzhyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxx(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.zzhyo = objArr;
        this.zzhyp = objArr2;
        this.mask = i3;
        this.zzahx = i2;
        this.size = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.zzhyp;
        if (obj == null || objArr == null) {
            return false;
        }
        int zzep = zzdwz.zzep(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i2 = zzep & this.mask;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            zzep = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxg, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzahx;
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
        System.arraycopy(this.zzhyo, 0, objArr, i2, this.size);
        return i2 + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final zzdya<E> zzazg() {
        return (zzdya) zzazk().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Object[] zzazh() {
        return this.zzhyo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zzazi() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    final int zzazj() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    final boolean zzazn() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdxg
    final zzdxd<E> zzazo() {
        return zzdxd.zzb(this.zzhyo, this.size);
    }
}
