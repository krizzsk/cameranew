package com.google.android.gms.internal.places;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzak extends zzai {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzet;
    private int zzeu;
    private int zzev;
    private int zzew;

    private zzak(byte[] bArr, int i2, int i3, boolean z) {
        super();
        this.zzew = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i3 + i2;
        this.pos = i2;
        this.zzev = i2;
        this.zzet = z;
    }

    @Override // com.google.android.gms.internal.places.zzai
    public final int zzaj() {
        return this.pos - this.zzev;
    }

    @Override // com.google.android.gms.internal.places.zzai
    public final int zzl(int i2) throws zzbk {
        if (i2 >= 0) {
            int zzaj = i2 + zzaj();
            int i3 = this.zzew;
            if (zzaj <= i3) {
                this.zzew = zzaj;
                int i4 = this.limit + this.zzeu;
                this.limit = i4;
                int i5 = i4 - this.zzev;
                if (i5 > zzaj) {
                    int i6 = i5 - zzaj;
                    this.zzeu = i6;
                    this.limit = i4 - i6;
                } else {
                    this.zzeu = 0;
                }
                return i3;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }
}
