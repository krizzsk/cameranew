package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
class zzdxb<E> extends zzdxa<E> {
    int size;
    Object[] zzhxo;
    boolean zzhxp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxb(int i2) {
        zzdwx.zzh(i2, "initialCapacity");
        this.zzhxo = new Object[i2];
        this.size = 0;
    }

    private final void zzeq(int i2) {
        Object[] objArr = this.zzhxo;
        if (objArr.length < i2) {
            int length = objArr.length;
            if (i2 >= 0) {
                int i3 = length + (length >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    i3 = Integer.MAX_VALUE;
                }
                this.zzhxo = Arrays.copyOf(objArr, i3);
                this.zzhxp = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzhxp) {
            this.zzhxo = (Object[]) objArr.clone();
            this.zzhxp = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxa
    /* renamed from: zzab */
    public zzdxb<E> zzaa(E e2) {
        zzdwl.checkNotNull(e2);
        zzeq(this.size + 1);
        Object[] objArr = this.zzhxo;
        int i2 = this.size;
        this.size = i2 + 1;
        objArr[i2] = e2;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdxa
    public zzdxa<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzeq(this.size + collection.size());
            if (collection instanceof zzdwy) {
                this.size = ((zzdwy) collection).zza(this.zzhxo, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
