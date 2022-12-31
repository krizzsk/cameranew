package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzkb extends AbstractList<String> implements RandomAccess, zzih {
    private final zzih zza;

    public zzkb(zzih zzihVar) {
        this.zza = zzihVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return ((zzig) this.zza).get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzka(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new zzjz(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final void zzf(zzgs zzgsVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final Object zzg(int i2) {
        return this.zza.zzg(i2);
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final List<?> zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final zzih zzi() {
        return this;
    }
}
