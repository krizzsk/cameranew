package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdxg<E> extends zzdwy<E> implements Set<E> {
    @NullableDecl
    private transient zzdxd<E> zzhxt;

    @SafeVarargs
    public static <E> zzdxg<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        zzdwl.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(length, objArr);
    }

    public static <E> zzdxg<E> zzad(E e2) {
        return new zzdxz(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzer(int i2) {
        int max = Math.max(i2, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        zzdwl.checkArgument(max < 1073741824, "collection too large");
        return 1073741824;
    }

    public static <E> zzdxj<E> zzes(int i2) {
        zzdwx.zzh(i2, "expectedSize");
        return new zzdxj<>(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i2, int i3) {
        return i2 < (i3 >> 1) + (i3 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdxg) && zzazn() && ((zzdxg) obj).zzazn() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzdxw.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdxw.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdwy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public zzdxd<E> zzazk() {
        zzdxd<E> zzdxdVar = this.zzhxt;
        if (zzdxdVar == null) {
            zzdxd<E> zzazo = zzazo();
            this.zzhxt = zzazo;
            return zzazo;
        }
        return zzdxdVar;
    }

    boolean zzazn() {
        return false;
    }

    zzdxd<E> zzazo() {
        return zzdxd.zzc(toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> zzdxg<E> zza(int i2, Object... objArr) {
        while (i2 != 0) {
            if (i2 != 1) {
                int zzer = zzer(i2);
                Object[] objArr2 = new Object[zzer];
                int i3 = zzer - 1;
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < i2; i6++) {
                    Object zzd = zzdxo.zzd(objArr[i6], i6);
                    int hashCode = zzd.hashCode();
                    int zzep = zzdwz.zzep(hashCode);
                    while (true) {
                        int i7 = zzep & i3;
                        Object obj = objArr2[i7];
                        if (obj == null) {
                            objArr[i5] = zzd;
                            objArr2[i7] = zzd;
                            i4 += hashCode;
                            i5++;
                            break;
                        } else if (!obj.equals(zzd)) {
                            zzep++;
                        }
                    }
                }
                Arrays.fill(objArr, i5, i2, (Object) null);
                if (i5 == 1) {
                    return new zzdxz(objArr[0], i4);
                }
                if (zzer(i5) >= zzer / 2) {
                    if (zzw(i5, objArr.length)) {
                        objArr = Arrays.copyOf(objArr, i5);
                    }
                    return new zzdxx(objArr, i4, objArr2, i3, i5);
                }
                i2 = i5;
            } else {
                return zzad(objArr[0]);
            }
        }
        return zzdxx.zzhyn;
    }
}
