package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxr<E> extends zzdxd<E> {
    static final zzdxd<Object> zzhyi = new zzdxr(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxr(Object[] objArr, int i2) {
        this.zzhyj = objArr;
        this.size = i2;
    }

    @Override // java.util.List
    public final E get(int i2) {
        zzdwl.zzt(i2, this.size);
        return (E) this.zzhyj[i2];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdxd, com.google.android.gms.internal.ads.zzdwy
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzhyj, 0, objArr, i2, this.size);
        return i2 + this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final Object[] zzazh() {
        return this.zzhyj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final int zzazi() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    final int zzazj() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return false;
    }
}
