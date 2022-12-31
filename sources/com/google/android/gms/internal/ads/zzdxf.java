package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxf<E> extends zzdwu<E> {
    private final zzdxd<E> zzhxs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxf(zzdxd<E> zzdxdVar, int i2) {
        super(zzdxdVar.size(), i2);
        this.zzhxs = zzdxdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwu
    protected final E get(int i2) {
        return this.zzhxs.get(i2);
    }
}
