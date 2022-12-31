package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdxi extends zzdya<T> {
    private boolean zzhxy;
    private final /* synthetic */ Object zzhxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxi(Object obj) {
        this.zzhxz = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzhxy;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public final T next() {
        if (!this.zzhxy) {
            this.zzhxy = true;
            return this.zzhxz;
        }
        throw new NoSuchElementException();
    }
}
