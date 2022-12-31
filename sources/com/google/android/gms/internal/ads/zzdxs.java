package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxs extends zzdxd<Map.Entry<K, V>> {
    private final /* synthetic */ zzdxt zzhyk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxs(zzdxt zzdxtVar) {
        this.zzhyk = zzdxtVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i2) {
        int i3;
        Object[] objArr;
        Object[] objArr2;
        i3 = this.zzhyk.size;
        zzdwl.zzt(i2, i3);
        objArr = this.zzhyk.zzhyh;
        int i4 = i2 * 2;
        Object obj = objArr[i4];
        objArr2 = this.zzhyk.zzhyh;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i4 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i2;
        i2 = this.zzhyk.size;
        return i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return true;
    }
}
