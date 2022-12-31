package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.In  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0925In {
    public static byte[] A05;
    public static String[] A06 = {"6HhNm3cPNapwaqbb", "rETS2R3vEEslStUJRpCBgfLkJK0S9xqh", "MEYGBk1oMmhBWHD5huW8XB9PkOXmJxmW", "Ebyfs41o5airltqaiKadsdL394JDYdET", "45eNA9gLGf59sMGZ1iMI", "", "A0Zue4QITY9ZnpF1VrB6IK97BmW1DYMt", "lY4WeGl5g11cW0QvoH9uVkbc4B0XWsja"};
    public final float A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final List<byte[]> A04;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = copyOfRange[i5];
            String[] strArr = A06;
            if (strArr[2].charAt(1) != strArr[1].charAt(1)) {
                throw new RuntimeException();
            }
            A06[3] = "kNkKJeUYPfq8eMd2tA59MaBH22H8N5Ts";
            copyOfRange[i5] = (byte) ((b - i4) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{Draft_75.CR, 58, 58, 55, 58, -24, 56, 41, 58, 59, 49, 54, 47, -24, 9, 30, 11, -24, 43, 55, 54, 46, 49, 47};
    }

    static {
        A02();
    }

    public C0925In(List<byte[]> initializationData, int i2, int i3, int i4, float f2) {
        this.A04 = initializationData;
        this.A02 = i2;
        this.A03 = i3;
        this.A01 = i4;
        this.A00 = f2;
    }

    public static C0925In A00(IV iv) throws AS {
        try {
            iv.A0Z(4);
            int A0E = (iv.A0E() & 3) + 1;
            if (A0E != 3) {
                ArrayList arrayList = new ArrayList();
                int numSequenceParameterSets = iv.A0E() & 31;
                for (int j2 = 0; j2 < numSequenceParameterSets; j2++) {
                    arrayList.add(A03(iv));
                }
                int A0E2 = iv.A0E();
                for (int numPictureParameterSets = 0; numPictureParameterSets < A0E2; numPictureParameterSets++) {
                    arrayList.add(A03(iv));
                }
                int i2 = -1;
                int i3 = -1;
                float f2 = 1.0f;
                int width = A06[4].length();
                if (width != 27) {
                    String[] strArr = A06;
                    strArr[2] = "yEkjaL4nSOxIxbdygxb0eg7rmaPMv2Rh";
                    strArr[1] = "JEi8k2PtpDNktftvz60xHr0NAbywlG3U";
                    if (numSequenceParameterSets > 0) {
                        int height = ((byte[]) arrayList.get(0)).length;
                        IQ A062 = IR.A06((byte[]) arrayList.get(0), A0E, height);
                        i2 = A062.A06;
                        i3 = A062.A02;
                        f2 = A062.A00;
                    }
                    return new C0925In(arrayList, A0E, i2, i3, f2);
                }
                throw new RuntimeException();
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new AS(A01(0, 24, 119), e2);
        }
    }

    public static byte[] A03(IV iv) {
        int offset = iv.A0I();
        int A062 = iv.A06();
        iv.A0Z(offset);
        return IA.A08(iv.A00, A062, offset);
    }
}
