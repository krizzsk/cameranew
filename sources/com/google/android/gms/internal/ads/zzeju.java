package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzeju extends zzekb {
    private final int zzimc;
    private final int zzimd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeju(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzejr.zzi(i2, i2 + i3, bArr.length);
        this.zzimc = i2;
        this.zzimd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzekb, com.google.android.gms.internal.ads.zzejr
    public final int size() {
        return this.zzimd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzekb, com.google.android.gms.internal.ads.zzejr
    public final void zzb(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zzimk, zzbgp() + i2, bArr, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzekb
    public final int zzbgp() {
        return this.zzimc;
    }

    @Override // com.google.android.gms.internal.ads.zzekb, com.google.android.gms.internal.ads.zzejr
    public final byte zzfz(int i2) {
        zzejr.zzab(i2, size());
        return this.zzimk[this.zzimc + i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzekb, com.google.android.gms.internal.ads.zzejr
    public final byte zzga(int i2) {
        return this.zzimk[this.zzimc + i2];
    }
}
