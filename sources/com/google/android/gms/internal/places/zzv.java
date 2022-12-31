package com.google.android.gms.internal.places;

import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzv extends zzx {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzw zzef;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzw zzwVar) {
        this.zzef = zzwVar;
        this.limit = zzwVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.places.zzab
    public final byte nextByte() {
        int i2 = this.position;
        if (i2 < this.limit) {
            this.position = i2 + 1;
            return this.zzef.zzj(i2);
        }
        throw new NoSuchElementException();
    }
}
