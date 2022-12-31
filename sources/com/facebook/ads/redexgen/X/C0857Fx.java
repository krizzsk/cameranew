package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Fx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0857Fx extends AbstractC1556dB<C0Q> {
    public static byte[] A00;
    public static String[] A01 = {"jR7SgdIzlKHk76CXDj7yskV4BbEyGCpu", "dz14xHNKN2eKa", "osoaj0nOm4U0DksUsx9ydi6yveTqdDmo", "CW4NBbEoC8f", "oKML8tkCm175rZI2zBYjmvrxKy9flX2h", "0JuTJ32H1trbcwgA0tUu0T5MtnfghwR4", "xx3SSYxbJNPIpDYr1BHpXDm7lAtLM5T8", "wtTCE0DbZnhIRkOUKlXj85m9jjBjTzDL"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = (byte) ((copyOfRange[i5] ^ i4) ^ 53);
            String[] strArr = A01;
            if (strArr[6].charAt(28) == strArr[4].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[6] = "RdAktgh8TRx4T7uGZoOvXD5Nm8OQ26SP";
            strArr2[4] = "NAulEfMGB5fp7nDMqJdUUmABB5JXpKUM";
            copyOfRange[i5] = b;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{17, 10, 19, 19};
    }

    static {
        A01();
    }

    public C0857Fx(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1556dB
    /* renamed from: A06 */
    public final C0W A05(@Nullable C0Q c0q) {
        String str;
        if (c0q == null) {
            str = A00(0, 4, 74);
        } else {
            str = A00(0, 0, 56) + c0q.A02();
        }
        return new C0W(this, str);
    }
}
