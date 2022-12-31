package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdSize;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: assets/audience_network.dex */
public final class LM {
    public static byte[] A00;
    public static String[] A01 = {"gFe3mTVqEc", "o3XICwck3thy8t5khkuFfgIyTYcE10rb", "CXZamXhEArpjjLRWzP01hTJHhdHKIPhL", "oFEH5ENhqq8Jzm18l75xaKQx7AXJNwzV", "R1QKRY6v8stJjzPTGoE1sFm3d511QSKK", "fRlItu1oZcW1vgjv2TfsauDW1x1gg146", "rMZj8KW6uJSswCV0wJ61u4oJuHgPLcpr", "VRcOG4k1oxgWu574CIBxVkEWQ"};
    public static final Map<K8, K9> A02;

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{125, 95, 80, 25, 74, 30, 93, 76, 91, 95, 74, 91, 30, Byte.MAX_VALUE, 90, 109, 87, 68, 91, 30, 75, 77, 87, 80, 89, 30, 74, 86, 87, 77, 30, 73, 87, 90, 74, 86, 30, 95, 80, 90, 30, 86, 91, 87, 89, 86, 74, 16, 115, 72, 77, 72, 73, 81, 72, 6, 103, 66, 117, 79, 92, 67, 6, 82, 95, 86, 67, 8};
    }

    static {
        A07();
        A02 = new HashMap();
        A02.put(K8.A08, K9.A08);
        A02.put(K8.A06, K9.A0A);
        A02.put(K8.A05, K9.A09);
    }

    public static AdSize A00(K8 k8) {
        return AdSize.fromWidthAndHeight(k8.A03(), k8.A02());
    }

    public static AdSize A01(K9 k9) {
        for (Map.Entry<K8, K9> entry : A02.entrySet()) {
            if (entry.getValue() == k9) {
                return A00(entry.getKey());
            }
        }
        AdSize adSize = AdSize.BANNER_320_50;
        if (A01[2].charAt(13) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[3] = "8yxIcOBY3dyXYw8tx9RnPYEelWv3PiEU";
        strArr[5] = "RuT7gwLbx9UlwnZGushHq4GsGVsr9kdh";
        return adSize;
    }

    public static K8 A02(int i2) {
        if (i2 != 4) {
            if (i2 != 5) {
                if (i2 != 6) {
                    if (i2 != 7) {
                        if (i2 == 100) {
                            return K8.A07;
                        }
                        throw new IllegalArgumentException(A06(48, 20, 63));
                    }
                    return K8.A08;
                }
                return K8.A06;
            }
            return K8.A05;
        }
        return K8.A04;
    }

    public static K8 A03(int i2, int i3) {
        if (K8.A07.A02() == i3 && K8.A07.A03() == i2) {
            K8 k8 = K8.A07;
            if (A01[2].charAt(13) != 'L') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "oPyqycdUDaMLkpnFUSD1lOVVut5Ak4ux";
            strArr[6] = "t44MnsVi8idfM7jbHI01veBsrnLqKP4H";
            return k8;
        } else if (K8.A04.A02() == i3 && K8.A04.A03() == i2) {
            return K8.A04;
        } else {
            if (K8.A05.A02() == i3 && K8.A05.A03() == i2) {
                K8 k82 = K8.A05;
                if (A01[1].charAt(1) != 'd') {
                    String[] strArr2 = A01;
                    strArr2[4] = "zTuOoFSTcjvo6siKnZ91TQqR6FN8Kxgy";
                    strArr2[6] = "bIxUq8CGRMwo1zGvdui1T5X5wsDAfXTH";
                    return k82;
                }
                throw new RuntimeException();
            } else if (K8.A06.A02() == i3 && K8.A06.A03() == i2) {
                return K8.A06;
            } else {
                if (K8.A08.A02() == i3 && K8.A08.A03() == i2) {
                    return K8.A08;
                }
                throw new IllegalArgumentException(A06(0, 48, 39));
            }
        }
    }

    public static K8 A04(AdSize adSize) {
        return A03(adSize.getWidth(), adSize.getHeight());
    }

    public static K9 A05(K8 k8) {
        K9 k9 = A02.get(k8);
        if (k9 == null) {
            K9 adTemplate = K9.A0B;
            if (A01[1].charAt(1) != 'd') {
                String[] strArr = A01;
                strArr[3] = "UG6JCyDXDBzWMb76AfK0hQ3l3bgkgswO";
                strArr[5] = "9YhmwLNWXnVy8pTRO5fFllqJZ4ALiPvn";
                return adTemplate;
            }
            throw new RuntimeException();
        }
        return k9;
    }
}
