package com.google.android.gms.internal.measurement;

import java.util.ListIterator;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjz implements ListIterator<String> {
    final ListIterator<String> zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzkb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(zzkb zzkbVar, int i2) {
        zzih zzihVar;
        this.zzc = zzkbVar;
        this.zzb = i2;
        zzihVar = zzkbVar.zza;
        this.zza = zzihVar.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return this.zza.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ String previous() {
        return this.zza.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
