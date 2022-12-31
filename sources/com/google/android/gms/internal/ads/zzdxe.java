package com.google.android.gms.internal.ads;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxe extends zzdxd<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdxd zzhxr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxe(zzdxd zzdxdVar, int i2, int i3) {
        this.zzhxr = zzdxdVar;
        this.offset = i2;
        this.length = i3;
    }

    @Override // java.util.List
    public final E get(int i2) {
        zzdwl.zzt(i2, this.length);
        return this.zzhxr.get(i2 + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdxd, java.util.List
    public final /* synthetic */ List subList(int i2, int i3) {
        return subList(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Object[] zzazh() {
        return this.zzhxr.zzazh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zzazi() {
        return this.zzhxr.zzazi() + this.offset;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    final int zzazj() {
        return this.zzhxr.zzazi() + this.offset + this.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdxd
    public final zzdxd<E> zzv(int i2, int i3) {
        zzdwl.zzf(i2, i3, this.length);
        zzdxd zzdxdVar = this.zzhxr;
        int i4 = this.offset;
        return (zzdxd) zzdxdVar.subList(i2 + i4, i3 + i4);
    }
}
