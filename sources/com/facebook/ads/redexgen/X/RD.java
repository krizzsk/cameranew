package com.facebook.ads.redexgen.X;

import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum RD {
    A05(A00(27, 7, 82)),
    A04(A00(17, 10, 36));
    
    public static byte[] A01;
    public static String[] A02 = {"eivXn7WqkaVyJ2amCalRVsu1nM81zzOL", "IY1PhTJan2YjTy3m27KNizUeB7qtWqJm", "bXOqwPMBCrH3s0bMCsL", "ZrI87R5JnQfkseZsVS85jpDDhrZappEb", "OQXnNqOlJnUzzklcWSYX2hAjXl5kV5w8", "Z35xfMoNmr9cRx2xWokc9BX7TfFFuzqW", "OPmwzWKlqSIpSWAXYRalqZxxZOaDZn32", "DtHbWGOE2Bmy5zeMr4BSgc5m3XVIvhqE"};
    public String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 28);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{90, 91, 75, 87, 92, 85, 90, 83, 81, 71, 19, 17, 12, 21, 10, 7, 6, 86, 87, 21, 91, 80, 89, 86, 95, 93, 75, 62, 60, 33, 56, 39, 42, 43};
    }

    static {
        A01();
    }

    RD(String str) {
        this.A00 = str;
    }

    public final String A02() {
        return this.A00;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static RD[] valuesCustom() {
        Object clone = values().clone();
        if (A02[0].charAt(13) != 'T') {
            A02[5] = "jZZ0FxASmyF6MQQ2nA29dubjFSBlMvOs";
            return (RD[]) clone;
        }
        throw new RuntimeException();
    }
}
