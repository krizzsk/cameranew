package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxu extends zzdxd<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxu(Object[] objArr, int i2, int i3) {
        this.zzhyh = objArr;
        this.offset = i2;
        this.size = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzdwl.zzt(i2, this.size);
        return this.zzhyh[(i2 * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdwy
    public final boolean zzazl() {
        return true;
    }
}
