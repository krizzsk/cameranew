package com.google.android.gms.internal.ads;

import java.util.ListIterator;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxn extends zzdyb<F, T> {
    private final /* synthetic */ zzdxk zzhyd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdxn(zzdxk zzdxkVar, ListIterator listIterator) {
        super(listIterator);
        this.zzhyd = zzdxkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdxy
    public final T zzae(F f2) {
        return this.zzhyd.zzhyc.apply(f2);
    }
}
