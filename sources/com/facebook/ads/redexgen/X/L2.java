package com.facebook.ads.redexgen.X;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: assets/audience_network.dex */
public final class L2 {
    public static String[] A00 = {"XnOcKNlJJ8CDQQR", "VGhv6FkZrITxQRu9gbMUemqcetkh7B5f", "vVz2BTpV32jHfI", "d8hV", "Sy49NQqrKXgvTEWwSBtXX6HecYQBIBGU", "Db46iG0BOxvexN4G9aNEWNZ9mU0XJx13", "mKukGrwwCcIhJco4KmzrvmgYUSCtT5hL", "T8hiTRn5Amgadg81lccjSSIUWb1StHzV"};
    public static final AtomicReference<L1> A01 = new AtomicReference<>(null);

    public static L1 A00() {
        L1 l1 = A01.get();
        if (A00[5].charAt(26) != '0') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[7] = "JAkiPTeS8Sgp4wJmZ2cE1Xuhf0WoAHfE";
        strArr[4] = "TWyum6rZOmg61QmMcVNeRxvFtffIUfDC";
        if (l1 == null) {
            L1 errorLogger = new TU();
            return errorLogger;
        }
        return l1;
    }

    public static void A01(L1 l1) {
        A01.set(l1);
    }
}
