package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzelk<F, T> extends AbstractList<T> {
    private final List<F> zzhyb;
    private final zzelj<F, T> zzire;

    public zzelk(List<F> list, zzelj<F, T> zzeljVar) {
        this.zzhyb = list;
        this.zzire = zzeljVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i2) {
        return this.zzire.convert(this.zzhyb.get(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhyb.size();
    }
}
