package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpo {
    private byte[] data;
    private int zzbki;
    private int zzbkj;
    private int zzbkk;

    public zzpo() {
    }

    public final int zzbl(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = false;
        if (i2 == 0) {
            return 0;
        }
        int i7 = i2 / 8;
        int i8 = 0;
        for (int i9 = 0; i9 < i7; i9++) {
            int i10 = this.zzbkj;
            if (i10 != 0) {
                byte[] bArr = this.data;
                int i11 = this.zzbki;
                i6 = ((bArr[i11 + 1] & Draft_75.END_OF_FRAME) >>> (8 - i10)) | ((bArr[i11] & Draft_75.END_OF_FRAME) << i10);
            } else {
                i6 = this.data[this.zzbki];
            }
            i2 -= 8;
            i8 |= (255 & i6) << i2;
            this.zzbki++;
        }
        if (i2 > 0) {
            int i12 = this.zzbkj + i2;
            byte b = (byte) (255 >> (8 - i2));
            if (i12 > 8) {
                byte[] bArr2 = this.data;
                int i13 = this.zzbki;
                i5 = (b & (((255 & bArr2[i13 + 1]) >> (16 - i12)) | ((bArr2[i13] & Draft_75.END_OF_FRAME) << (i12 - 8)))) | i8;
                this.zzbki = i13 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i14 = this.zzbki;
                i5 = (b & ((255 & bArr3[i14]) >> (8 - i12))) | i8;
                if (i12 == 8) {
                    this.zzbki = i14 + 1;
                }
            }
            i8 = i5;
            this.zzbkj = i12 % 8;
        }
        int i15 = this.zzbki;
        if (i15 >= 0 && (i3 = this.zzbkj) >= 0 && i3 < 8 && (i15 < (i4 = this.zzbkk) || (i15 == i4 && i3 == 0))) {
            z = true;
        }
        zzpg.checkState(z);
        return i8;
    }

    public zzpo(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpo(byte[] bArr, int i2) {
        this.data = bArr;
        this.zzbkk = i2;
    }
}
