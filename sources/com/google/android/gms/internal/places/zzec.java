package com.google.android.gms.internal.places;
/* loaded from: classes2.dex */
abstract class zzec {
    abstract int zzc(int i2, byte[] bArr, int i3, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzc(CharSequence charSequence, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzf(byte[] bArr, int i2, int i3) {
        return zzc(0, bArr, i2, i3) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String zzh(byte[] bArr, int i2, int i3) throws zzbk;
}
