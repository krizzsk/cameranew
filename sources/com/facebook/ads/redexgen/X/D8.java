package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.UUID;
/* loaded from: assets/audience_network.dex */
public final class D8 {
    public static byte[] A00;
    public static String[] A01 = {"kk3S4O13iVXJvtm5AjTeD8rK", "Zu4hi0TCs3bKXIhBk2aWCiDe3xK", "JowY5N4XtyrwAA9epoNCHGChZ5QJHmq", "OOxBqRpXIUSrAU80JlBeMYgVyXHV", "tCZgrksHUVK4eCN8oQ7yIu", "GrKlMP1w4PgYrm5YCKNZqmcWRop33Hln", "0sCqI3ucQZfe3Uil9qNltLDWT8T5PAU", "ug"};

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 3);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{76, 111, 111, 116, 93, 104, 115, 113, 73, 104, 117, 112, 109, 86, 75, 77, 72, 72, 87, 74, 76, 93, 92, 24, 72, 75, 75, 80, 24, 78, 93, 74, 75, 81, 87, 86, 2, 24};
    }

    static {
        A04();
    }

    public static int A00(byte[] bArr) {
        int i2;
        D7 parsedAtom = A01(bArr);
        if (parsedAtom != null) {
            i2 = parsedAtom.A00;
            return i2;
        }
        return -1;
    }

    @Nullable
    public static D7 A01(byte[] bArr) {
        IV iv = new IV(bArr);
        if (iv.A07() < 32) {
            return null;
        }
        iv.A0Y(0);
        if (iv.A08() != iv.A04() + 4) {
            return null;
        }
        int A08 = iv.A08();
        int i2 = AbstractC0776Cq.A0r;
        String[] strArr = A01;
        String str = strArr[0];
        String str2 = strArr[7];
        int length = str.length();
        int atomType = str2.length();
        if (length != atomType) {
            A01[6] = "KiHnRKSUZsnBoZKY996tMhDtZ8Gdi7J";
            if (A08 != i2) {
                return null;
            }
            int atomType2 = iv.A08();
            int A012 = AbstractC0776Cq.A01(atomType2);
            if (A012 > 1) {
                Log.w(A02(0, 12, 31), A02(12, 26, 59) + A012);
                return null;
            }
            UUID uuid = new UUID(iv.A0L(), iv.A0L());
            if (A012 == 1) {
                iv.A0Z(iv.A0H() * 16);
            }
            int A0H = iv.A0H();
            if (A0H != iv.A04()) {
                return null;
            }
            byte[] data = new byte[A0H];
            iv.A0c(data, 0, A0H);
            return new D7(uuid, A012, data);
        }
        throw new RuntimeException();
    }

    @Nullable
    public static UUID A03(byte[] bArr) {
        UUID uuid;
        D7 A012 = A01(bArr);
        if (A012 != null) {
            uuid = A012.A01;
            return uuid;
        } else if (A01[6].length() != 31) {
            throw new RuntimeException();
        } else {
            String[] strArr = A01;
            strArr[2] = "A19aWphbBlm9ojDJQ1W47aeMdyevB22";
            strArr[1] = "rfVibYQBAeR1UXfUamieG6t7la8";
            return null;
        }
    }
}
