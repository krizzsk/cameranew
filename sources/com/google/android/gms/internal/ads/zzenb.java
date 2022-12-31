package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzenb<E> extends zzejl<E> implements RandomAccess {
    private static final zzenb<Object> zzitn;
    private int size;
    private E[] zzhyj;

    static {
        zzenb<Object> zzenbVar = new zzenb<>(new Object[0], 0);
        zzitn = zzenbVar;
        zzenbVar.zzbgf();
    }

    zzenb() {
        this(new Object[10], 0);
    }

    public static <E> zzenb<E> zzbke() {
        return (zzenb<E>) zzitn;
    }

    private final void zzfw(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(zzfx(i2));
        }
    }

    private final String zzfx(int i2) {
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzbgg();
        int i2 = this.size;
        E[] eArr = this.zzhyj;
        if (i2 == eArr.length) {
            this.zzhyj = (E[]) Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzhyj;
        int i3 = this.size;
        this.size = i3 + 1;
        eArr2[i3] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        zzfw(i2);
        return this.zzhyj[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        int i3;
        zzbgg();
        zzfw(i2);
        E[] eArr = this.zzhyj;
        E e2 = eArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        zzbgg();
        zzfw(i2);
        E[] eArr = this.zzhyj;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzell zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzenb(Arrays.copyOf(this.zzhyj, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzenb(E[] eArr, int i2) {
        this.zzhyj = eArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        int i3;
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            E[] eArr = this.zzhyj;
            if (i3 < eArr.length) {
                System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
            } else {
                E[] eArr2 = (E[]) new Object[((i3 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i2);
                System.arraycopy(this.zzhyj, i2, eArr2, i2 + 1, this.size - i2);
                this.zzhyj = eArr2;
            }
            this.zzhyj[i2] = e2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }
}
