package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class UW extends C0886Ha {
    public static byte[] A01;
    public static String[] A02 = {"ZQ8PuEpoE8gyS3Znd74chKs", "SMR6jCgSs1OLi9k", "9TpefdXfhJ1bgovOujDvo0cycPvHTNeY", "fSCcvv9mQcAxaPQjtTD5J0fX4AU6qoUi", "pC4MzMAjE35JrXvA7GEGwLl", "N4W5wz59KJRM86L2MxAv0qAi54qP6RPf", "ZjburCSFctaP2yxaKgKjejXQTrv5uqRP", "7nU1e349RKnqDnE0EBs6XskGT5MTKO6z"};
    public final String A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Draft_75.CR, 42, 50, 37, 40, 45, 32, 100, 39, 43, 42, 48, 33, 42, 48, 100, 48, 61, 52, 33, 126, 100};
        if (A02[2].charAt(21) == 'I') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "yWaeILMTRyNjMdlGgdEDrDI";
        strArr[0] = "cj1077EILRdS6ZzLpoMmpdb";
    }

    static {
        A01();
    }

    public UW(String str, HV hv) {
        super(A00(0, 22, 123) + str, hv, 1);
        this.A00 = str;
    }
}
