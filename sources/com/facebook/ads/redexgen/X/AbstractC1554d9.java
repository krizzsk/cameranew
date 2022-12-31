package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.d9  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1554d9 extends AbstractC04770f {
    public static byte[] A02;
    public static String[] A03 = {"1", "OJ2IOsbUnCKybSqk53zM3JXcifahO", "e4RldewFXKwYCBzcZ5CwWZ5XjhlRHNiJ", "729G42gqUNiz5ZAUAxRhvFZ2YWMhTd0L", "J1Ql0tv9onNfDvsMKNTgjNyaDa6Pnzub", "9fBm", "mbPUpspz4Nj5AFGqwEe2w9x9WWs", "2uSYGuFAJgr"};
    public final C04830m A00;
    public final boolean A01;

    public static String A09(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 30);
            if (A03[3].charAt(0) != '7') {
                throw new RuntimeException();
            }
            A03[5] = "PWjD";
        }
        return new String(copyOfRange);
    }

    public static void A0A() {
        A02 = new byte[]{93, 114, 119, 125, 117, 62, 114, 113, 121, 121, 123, 122, 71, 68, 70, 78, 122, 81, 76, 72, 64, 22, 31, 27, 12, 31, 37, 14, 19, 23, 31, 45, 55, 54, 33, 45, 47, 39};
    }

    public abstract void A0C();

    static {
        A0A();
    }

    public AbstractC1554d9(XT xt, JT jt, String str, @Nullable C04830m c04830m, boolean z) {
        super(xt, jt, str);
        this.A00 = c04830m;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04770f
    public final void A0B() {
        C04830m c04830m = this.A00;
        if (c04830m != null) {
            c04830m.A07(this.A02);
        }
        A0C();
    }

    public final void A0D(Map<String, String> userReturnDataMap, @Nullable EnumC04760e enumC04760e) {
        if (!TextUtils.isEmpty(this.A02)) {
            if (this instanceof C0838Fc) {
                super.A01.A9C(this.A02, userReturnDataMap);
            } else {
                JT jt = super.A01;
                String str = this.A02;
                if (A03[6].length() != 8) {
                    A03[6] = "4hYdj7INWre5bef3R1byHGHBMmQCX";
                    jt.A8y(str, userReturnDataMap);
                } else {
                    A03[5] = "IMSq";
                    jt.A8y(str, userReturnDataMap);
                }
            }
            boolean A022 = EnumC04760e.A02(enumC04760e);
            if (A03[1].length() == 32) {
                throw new RuntimeException();
            }
            A03[0] = "X";
            C04830m c04830m = this.A00;
            if (c04830m != null) {
                c04830m.A06(enumC04760e);
                if (A022) {
                    this.A00.A05();
                }
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put(A09(21, 10, 100), Long.toString(-1L));
                hashMap.put(A09(12, 9, 59), Long.toString(-1L));
                hashMap.put(A09(31, 7, 92), EnumC04760e.A03.name());
                super.A01.A9F(this.A02, hashMap);
            }
        }
        LN.A02(super.A00, A09(0, 12, 0));
    }
}
