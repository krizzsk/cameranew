package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpq {
    private byte[] data;
    private int zzbki;
    private int zzbkj = 0;
    private int zzbkk;

    public zzpq(byte[] bArr, int i2, int i3) {
        this.data = bArr;
        this.zzbki = i2;
        this.zzbkk = i3;
        zzjh();
    }

    private final boolean zzbn(int i2) {
        if (2 > i2 || i2 >= this.zzbkk) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i2] == 3 && bArr[i2 + (-2)] == 0 && bArr[i2 - 1] == 0;
    }

    private final int zzjg() {
        int i2 = 0;
        while (!zzjd()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? zzbl(i2) : 0);
    }

    private final void zzjh() {
        int i2;
        int i3;
        int i4 = this.zzbki;
        zzpg.checkState(i4 >= 0 && (i2 = this.zzbkj) >= 0 && i2 < 8 && (i4 < (i3 = this.zzbkk) || (i4 == i3 && i2 == 0)));
    }

    public final int zzbl(int i2) {
        int i3;
        int i4;
        if (i2 == 0) {
            return 0;
        }
        int i5 = i2 / 8;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = zzbn(this.zzbki + 1) ? this.zzbki + 2 : this.zzbki + 1;
            int i9 = this.zzbkj;
            if (i9 != 0) {
                byte[] bArr = this.data;
                i4 = ((bArr[i8] & Draft_75.END_OF_FRAME) >>> (8 - i9)) | ((bArr[this.zzbki] & Draft_75.END_OF_FRAME) << i9);
            } else {
                i4 = this.data[this.zzbki];
            }
            i2 -= 8;
            i6 |= (255 & i4) << i2;
            this.zzbki = i8;
        }
        if (i2 > 0) {
            int i10 = this.zzbkj + i2;
            byte b = (byte) (255 >> (8 - i2));
            int i11 = zzbn(this.zzbki + 1) ? this.zzbki + 2 : this.zzbki + 1;
            if (i10 > 8) {
                byte[] bArr2 = this.data;
                i3 = (b & (((255 & bArr2[i11]) >> (16 - i10)) | ((bArr2[this.zzbki] & Draft_75.END_OF_FRAME) << (i10 - 8)))) | i6;
                this.zzbki = i11;
            } else {
                i3 = (b & ((255 & this.data[this.zzbki]) >> (8 - i10))) | i6;
                if (i10 == 8) {
                    this.zzbki = i11;
                }
            }
            i6 = i3;
            this.zzbkj = i10 % 8;
        }
        zzjh();
        return i6;
    }

    public final void zzbm(int i2) {
        int i3 = this.zzbki;
        int i4 = (i2 / 8) + i3;
        this.zzbki = i4;
        int i5 = this.zzbkj + (i2 % 8);
        this.zzbkj = i5;
        if (i5 > 7) {
            this.zzbki = i4 + 1;
            this.zzbkj = i5 - 8;
        }
        while (true) {
            i3++;
            if (i3 <= this.zzbki) {
                if (zzbn(i3)) {
                    this.zzbki++;
                    i3 += 2;
                }
            } else {
                zzjh();
                return;
            }
        }
    }

    public final boolean zzjd() {
        return zzbl(1) == 1;
    }

    public final int zzje() {
        return zzjg();
    }

    public final int zzjf() {
        int zzjg = zzjg();
        return (zzjg % 2 == 0 ? -1 : 1) * ((zzjg + 1) / 2);
    }
}
