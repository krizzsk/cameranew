package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzig extends zzgc<String> implements RandomAccess, zzih {
    public static final zzih zza;
    private static final zzig zzb;
    private final List<Object> zzc;

    static {
        zzig zzigVar = new zzig(10);
        zzb = zzigVar;
        zzigVar.zzb();
        zza = zzigVar;
    }

    public zzig() {
        this(10);
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgs) {
            return ((zzgs) obj).zzl(zzia.zza);
        }
        return zzia.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i2, Object obj) {
        zzbL();
        this.zzc.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        zzbL();
        if (collection instanceof zzih) {
            collection = ((zzih) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbL();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i2) {
        zzbL();
        Object remove = this.zzc.remove(i2);
        ((AbstractList) this).modCount++;
        return zzj(remove);
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        zzbL();
        return zzj(this.zzc.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzd */
    public final String get(int i2) {
        Object obj = this.zzc.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgs) {
            zzgs zzgsVar = (zzgs) obj;
            String zzl = zzgsVar.zzl(zzia.zza);
            if (zzgsVar.zzh()) {
                this.zzc.set(i2, zzl);
            }
            return zzl;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzia.zzd(bArr);
        if (zzia.zzc(bArr)) {
            this.zzc.set(i2, zzd);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final /* bridge */ /* synthetic */ zzhz zze(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.zzc);
            return new zzig(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final void zzf(zzgs zzgsVar) {
        zzbL();
        this.zzc.add(zzgsVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final Object zzg(int i2) {
        return this.zzc.get(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final zzih zzi() {
        return zza() ? new zzkb(this) : this;
    }

    public zzig(int i2) {
        this.zzc = new ArrayList(i2);
    }

    private zzig(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
