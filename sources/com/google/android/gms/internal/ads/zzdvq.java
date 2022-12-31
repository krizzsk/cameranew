package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdvq<T> implements Iterator<T> {
    private int zzhvl = zzdvs.zzhvo;
    @NullableDecl
    private T zzhvm;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.zzhvl;
        int i3 = zzdvs.zzhvq;
        if (i2 != i3) {
            int i4 = zzdvp.zzhvk[i2 - 1];
            if (i4 != 1) {
                if (i4 != 2) {
                    this.zzhvl = i3;
                    this.zzhvm = zzaza();
                    if (this.zzhvl != zzdvs.zzhvp) {
                        this.zzhvl = zzdvs.zzhvn;
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.zzhvl = zzdvs.zzhvo;
            T t = this.zzhvm;
            this.zzhvm = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    protected abstract T zzaza();

    /* JADX INFO: Access modifiers changed from: protected */
    @NullableDecl
    public final T zzazb() {
        this.zzhvl = zzdvs.zzhvp;
        return null;
    }
}
