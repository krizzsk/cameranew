package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxl {
    public static <F, T> List<T> zza(List<F> list, zzdvz<? super F, ? extends T> zzdvzVar) {
        if (list instanceof RandomAccess) {
            return new zzdxk(list, zzdvzVar);
        }
        return new zzdxm(list, zzdvzVar);
    }

    public static <E> ArrayList<E> zzet(int i2) {
        zzdwx.zzh(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }
}
