package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class HH {
    public final int A00;
    public final HE A01;
    @Nullable
    public final Object A02;
    public final C0728Ai[] A03;

    public HH(C0728Ai[] c0728AiArr, HD[] hdArr, @Nullable Object obj) {
        this.A03 = c0728AiArr;
        this.A01 = new HE(hdArr);
        this.A02 = obj;
        this.A00 = c0728AiArr.length;
    }

    public final boolean A00(int i2) {
        return this.A03[i2] != null;
    }

    public final boolean A01(HH hh) {
        if (hh == null || hh.A01.A01 != this.A01.A01) {
            return false;
        }
        for (int i2 = 0; i2 < this.A01.A01; i2++) {
            if (!A02(hh, i2)) {
                return false;
            }
        }
        return true;
    }

    public final boolean A02(HH hh, int i2) {
        return hh != null && C0923Il.A0g(this.A03[i2], hh.A03[i2]) && C0923Il.A0g(this.A01.A00(i2), hh.A01.A00(i2));
    }
}
