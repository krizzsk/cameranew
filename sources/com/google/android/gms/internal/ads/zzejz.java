package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzejz {
    private final byte[] buffer;
    private final zzekl zzime;

    private zzejz(int i2) {
        byte[] bArr = new byte[i2];
        this.buffer = bArr;
        this.zzime = zzekl.zzv(bArr);
    }

    public final zzejr zzbgq() {
        this.zzime.zzbht();
        return new zzekb(this.buffer);
    }

    public final zzekl zzbgr() {
        return this.zzime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzejz(int i2, zzejq zzejqVar) {
        this(i2);
    }
}
