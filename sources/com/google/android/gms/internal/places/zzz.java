package com.google.android.gms.internal.places;
/* loaded from: classes2.dex */
final class zzz extends zzag {
    private final int zzek;
    private final int zzel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzw.zzc(i2, i2 + i3, bArr.length);
        this.zzek = i2;
        this.zzel = i3;
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final int size() {
        return this.zzel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.places.zzag
    public final int zzag() {
        return this.zzek;
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    protected final void zzb(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zzen, zzag(), bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final byte zzi(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) < 0) {
            if (i2 < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        return this.zzen[this.zzek + i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzag, com.google.android.gms.internal.places.zzw
    public final byte zzj(int i2) {
        return this.zzen[this.zzek + i2];
    }
}
