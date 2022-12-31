package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.Uw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1237Uw implements GL {
    public static String[] A01 = {"uyzG6nZhYmNB4VufbjNeT4Wu24aJjB", "gpgsRAJrUCyLiJ0U4KQoajYft8d2IWSs", "V6tp6oNeuWY4Rz4wk", "QxLD6Qr0", "n2jYEAQ7ylPlmaGFo", "iuLvneSMbLfhzIa7Pvm7Ht11vKly078I", "9KvTRZ4e8scFY8IRtC8ize1aHWfIVCyu", "s0mDJJaIHWanY7Mz7gNVqOFT5NJr2uCg"};
    public final List<GK> A00;

    public C1237Uw(List<GK> list) {
        this.A00 = list;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final List<GK> A67(long j2) {
        return j2 >= 0 ? this.A00 : Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final long A6X(int i2) {
        I6.A03(i2 == 0);
        String[] strArr = A01;
        if (strArr[6].charAt(12) != strArr[7].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "k5niKSSkUsmLECakjkbMaTYSf6uR41";
        strArr2[3] = "iDI18Hfk";
        return 0L;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6Y() {
        return 1;
    }

    @Override // com.facebook.ads.redexgen.X.GL
    public final int A6v(long j2) {
        return j2 < 0 ? 0 : -1;
    }
}
