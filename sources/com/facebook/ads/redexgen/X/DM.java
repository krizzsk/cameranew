package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* loaded from: assets/audience_network.dex */
public final class DM {
    public int A00;
    public int A01;
    public final int A02;
    public final byte[] A03;

    public DM(byte[] bArr) {
        this.A03 = bArr;
        this.A02 = bArr.length;
    }

    private void A00() {
        int i2;
        int i3 = this.A01;
        I6.A04(i3 >= 0 && (i3 < (i2 = this.A02) || (i3 == i2 && this.A00 == 0)));
    }

    public final int A01() {
        return (this.A01 * 8) + this.A00;
    }

    public final int A02(int bitsRead) {
        int i2 = this.A01;
        int tempByteOffset = Math.min(bitsRead, 8 - this.A00);
        int i3 = i2 + 1;
        int i4 = ((this.A03[i2] & Draft_75.END_OF_FRAME) >> this.A00) & (255 >> (8 - tempByteOffset));
        while (tempByteOffset < bitsRead) {
            i4 |= (this.A03[i3] & 255) << tempByteOffset;
            tempByteOffset += 8;
            i3++;
        }
        int i5 = i4 & ((-1) >>> (32 - bitsRead));
        A03(bitsRead);
        return i5;
    }

    public final void A03(int i2) {
        int i3 = i2 / 8;
        this.A01 += i3;
        this.A00 += i2 - (i3 * 8);
        int i4 = this.A00;
        if (i4 > 7) {
            this.A01++;
            this.A00 = i4 - 8;
        }
        A00();
    }

    public final boolean A04() {
        boolean z = (((this.A03[this.A01] & Draft_75.END_OF_FRAME) >> this.A00) & 1) == 1;
        A03(1);
        return z;
    }
}
