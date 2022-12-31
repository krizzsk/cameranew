package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzejq extends zzejs {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzejr zzily;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzejq(zzejr zzejrVar) {
        this.zzily = zzejrVar;
        this.limit = zzejrVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzejw
    public final byte nextByte() {
        int i2 = this.position;
        if (i2 < this.limit) {
            this.position = i2 + 1;
            return this.zzily.zzga(i2);
        }
        throw new NoSuchElementException();
    }
}
