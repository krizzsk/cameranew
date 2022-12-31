package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzelw extends zzejl<String> implements zzelv, RandomAccess {
    private static final zzelw zzirz;
    private static final zzelv zzisa;
    private final List<Object> zzisb;

    static {
        zzelw zzelwVar = new zzelw();
        zzirz = zzelwVar;
        zzelwVar.zzbgf();
        zzisa = zzelwVar;
    }

    public zzelw() {
        this(10);
    }

    private static String zzam(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzejr) {
            return ((zzejr) obj).zzbgi();
        }
        return zzeld.zzy((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        zzbgg();
        this.zzisb.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbgg();
        this.zzisb.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.zzisb.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzejr) {
            zzejr zzejrVar = (zzejr) obj;
            String zzbgi = zzejrVar.zzbgi();
            if (zzejrVar.zzbgj()) {
                this.zzisb.set(i2, zzbgi);
            }
            return zzbgi;
        }
        byte[] bArr = (byte[]) obj;
        String zzy = zzeld.zzy(bArr);
        if (zzeld.zzx(bArr)) {
            this.zzisb.set(i2, zzy);
        }
        return zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        zzbgg();
        return zzam(this.zzisb.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzisb.size();
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final void zzak(zzejr zzejrVar) {
        zzbgg();
        this.zzisb.add(zzejrVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, com.google.android.gms.internal.ads.zzell
    public final /* bridge */ /* synthetic */ boolean zzbge() {
        return super.zzbge();
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final List<?> zzbjm() {
        return Collections.unmodifiableList(this.zzisb);
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final zzelv zzbjn() {
        return zzbge() ? new zzeog(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzell zzfy(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.zzisb);
            return new zzelw(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzelv
    public final Object zzhj(int i2) {
        return this.zzisb.get(i2);
    }

    public zzelw(int i2) {
        this(new ArrayList(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        zzbgg();
        if (collection instanceof zzelv) {
            collection = ((zzelv) collection).zzbjm();
        }
        boolean addAll = this.zzisb.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        zzbgg();
        Object remove = this.zzisb.remove(i2);
        ((AbstractList) this).modCount++;
        return zzam(remove);
    }

    private zzelw(ArrayList<Object> arrayList) {
        this.zzisb = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
