package com.google.android.gms.internal.ads;

import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdxa<E> {
    public zzdxa<E> zza(Iterator<? extends E> it) {
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    public abstract zzdxa<E> zzaa(E e2);

    public zzdxa<E> zzg(Iterable<? extends E> iterable) {
        for (E e2 : iterable) {
            zzaa(e2);
        }
        return this;
    }
}
