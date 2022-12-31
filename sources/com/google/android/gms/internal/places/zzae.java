package com.google.android.gms.internal.places;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzae {
    private final byte[] buffer;
    private final zzaj zzem;

    private zzae(int i2) {
        byte[] bArr = new byte[i2];
        this.buffer = bArr;
        this.zzem = zzaj.zzc(bArr);
    }

    public final zzw zzah() {
        if (this.zzem.zzak() == 0) {
            return new zzag(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzaj zzai() {
        return this.zzem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzae(int i2, zzv zzvVar) {
        this(i2);
    }
}
