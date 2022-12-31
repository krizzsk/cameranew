package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjg<E> extends zzgc<E> implements RandomAccess {
    private static final zzjg<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzjg<Object> zzjgVar = new zzjg<>(new Object[0], 0);
        zza = zzjgVar;
        zzjgVar.zzb();
    }

    zzjg() {
        this(new Object[10], 0);
    }

    public static <E> zzjg<E> zzd() {
        return (zzjg<E>) zza;
    }

    private final void zzf(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
    }

    private final String zzg(int i2) {
        int i3 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        zzbL();
        if (i2 >= 0 && i2 <= (i3 = this.zzc)) {
            E[] eArr = this.zzb;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.zzb, i2, eArr2, i2 + 1, this.zzc - i2);
                this.zzb = eArr2;
            }
            this.zzb[i2] = e2;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        zzf(i2);
        return this.zzb[i2];
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        int i3;
        zzbL();
        zzf(i2);
        E[] eArr = this.zzb;
        E e2 = eArr[i2];
        if (i2 < this.zzc - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        zzbL();
        zzf(i2);
        E[] eArr = this.zzb;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    public final /* bridge */ /* synthetic */ zzhz zze(int i2) {
        if (i2 >= this.zzc) {
            return new zzjg(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzjg(E[] eArr, int i2) {
        this.zzb = eArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgc, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzbL();
        int i2 = this.zzc;
        E[] eArr = this.zzb;
        if (i2 == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }
}
