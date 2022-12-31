package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: assets/audience_network.dex */
public final class KU {
    public static byte[] A0F;
    public static String[] A0G = {"D9utVieqpHmzq", "1reJ20tywIkt8c03XFg68iFkPgUpcQh9", "1hiVgm3FzyAWthqubctijKn7iSl8t7OZ", "2MGbhVYWK6vnLzanQZMPK5FLJbU6N2Mg", "tHlP6Jv5sj70nCQXOaNATx3kiWqPf1Tp", "kSrICwDX6P2QTtBsWrInLj9wi3Ca9feR", "Z5GcmA6HHHf7tKUPWv2sbOMAsuTj15Gl", "CZogAanemwBaq"};
    public int A00;
    public C8J A01;
    public K6 A02;
    public K9 A03;
    @Nullable
    public C0993Lj A04;
    @Nullable
    public String A05;
    @Nullable
    public String A06;
    public String A07;
    @Nullable
    public String A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final AdPlacementType A0C;
    public final KE A0D;
    @Nullable
    public final String A0E;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0F, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 87);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{-38, -68, -52, -49, -22, -48, -29, -37, -48, -35, -44, -48, -39, -50, -48, -22, -33, -28, -37, -48, -91, -88, -61, -74, -87, -76, -77, -74, -72, -83, -78, -85, -61, -89, -77, -78, -86, -83, -85, -61, -80, -91, -73, -72, -61, -71, -76, -88, -91, -72, -87, -61, -72, -83, -79, -87, 19, 26, 21, 48, 26, 21, 10, 17, 12, 39, 28, 17, 21, Draft_75.CR, 39, 28, 23, 19, Draft_75.CR, 22, -31, -22, -25, -29, -20, -14, -3, -16, -29, -17, -13, -29, -15, -14, -3, -25, -30, -29, -17, -16, -16, -31, -72, -71, -63, -61, -45, -75, -72, -45, -67, -72, -49, -30, -34, -36, -53, -23, -46, -45, -40, -34, -35, 14, 11, 15, Draft_75.CR, 14, 26, -15, -20, -18, -23, -5, -10, -8, -13, 17, -8, -2, -13, -7, -65, -55, -43, -61, -53, -62, -54, -65, -43, -73, -70, -43, -69, -50, -58, -69, -56, -65, -69, -60, -71, -69, -2, -6, 18, 5, -8, 6, 7, 5, -4, -10, 7, -8, -9, -11, -4, -12, 6, -24, -21, -6, 6, -7, -20, -8, -4, -20, -6, -5, -20, -21, -39, -43, -54, -52, -50, -42, -50, -41, -35, -24, -46, -51, 24, 20, 9, 11, Draft_75.CR, 21, Draft_75.CR, 22, 28, 39, 28, 33, 24, Draft_75.CR, -84, -97, -85, -81, -97, -83, -82, -71, -82, -93, -89, -97, -56, -55, -74, -72, -64, -44, -55, -57, -74, -72, -70, 41, 26, 34, 37, 33, 22, 41, 26, 52, 30, 25, 29, 14, 28, 29, 40, 22, 24, Draft_75.CR, 14, -46, -60, -65, -49, -61};
    }

    static {
        A01();
    }

    public KU(C8J c8j, String str, @Nullable C0993Lj c0993Lj, K9 k9, @Nullable String str2, int i2, boolean z, boolean z2, KE ke, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.A01 = c8j;
        this.A07 = str;
        this.A04 = c0993Lj;
        this.A03 = k9;
        this.A0E = str2;
        this.A00 = i2;
        this.A0B = z;
        this.A09 = z2;
        this.A0D = ke;
        this.A02 = K6.A00(k9);
        this.A0C = this.A02.A03();
        this.A08 = str3;
        this.A06 = str4;
        this.A05 = str5;
    }

    private void A02(Map<String, String> params, String str, String str2) {
        params.put(str, str2);
    }

    public final int A03() {
        return this.A00;
    }

    public final K6 A04() {
        return this.A02;
    }

    public final K9 A05() {
        return this.A03;
    }

    @Nullable
    public final C0993Lj A06() {
        return this.A04;
    }

    public final String A07() {
        return this.A07;
    }

    public final Map<String, String> A08(Map<String, String> map) {
        String A00;
        HashMap hashMap = new HashMap(map);
        A02(hashMap, A00(125, 4, 81), C06075h.A00().A03());
        if (C06075h.A00().A04()) {
            A00 = A00(0, 1, 83);
        } else {
            String[] strArr = A0G;
            if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
                A0G[4] = "OSIYQdAYrqEeuWTToN616ljtMldHOUZ9";
                A00 = A00(1, 1, 19);
            } else {
                String[] strArr2 = A0G;
                strArr2[6] = "BVsBALnWYJGjtGeIFrIyiRvFdf5Nn7Os";
                strArr2[2] = "sOqPRdu1k9TitO9ui6g27cgTpL2HWUa7";
                A00 = A00(1, 1, 52);
            }
        }
        A02(hashMap, A00(129, 9, 91), A00);
        A02(hashMap, A00(93, 5, 73), String.valueOf(this.A09));
        A02(hashMap, A00(190, 12, 50), this.A07);
        if (this.A0C != AdPlacementType.UNKNOWN) {
            A02(hashMap, A00(202, 14, 113), this.A0C.toString().toLowerCase());
        }
        C0993Lj c0993Lj = this.A04;
        if (c0993Lj != null) {
            A02(hashMap, A00(259, 5, 36), String.valueOf(c0993Lj.A01()));
            A02(hashMap, A00(119, 6, 111), String.valueOf(this.A04.A00()));
        }
        K9 k9 = this.A03;
        if (k9 != null) {
            A02(hashMap, A00(239, 11, 126), String.valueOf(k9.A03()));
        }
        boolean z = this.A0B;
        String[] strArr3 = A0G;
        if (strArr3[1].charAt(22) == strArr3[3].charAt(22)) {
            String[] strArr4 = A0G;
            strArr4[1] = "IzDezfH0vo2hFBj3g0HaogFvU1PF9PgW";
            strArr4[3] = "07eFZyxYDfzIdCogAj5SagFmNdTPnXPY";
            if (z) {
                String A002 = A00(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 9, 114);
                String A003 = A00(1, 1, 52);
                String[] strArr5 = A0G;
                if (strArr5[7].length() == strArr5[0].length()) {
                    A0G[5] = "fhkQkDUQCs0vTSuMh05aUEfBswduYuq5";
                    A02(hashMap, A002, A003);
                }
            }
            String str = this.A0E;
            if (str != null) {
                A02(hashMap, A00(98, 10, 29), str);
            }
            int i2 = this.A00;
            if (i2 != 0) {
                A02(hashMap, A00(173, 17, 80), String.valueOf(i2));
            }
            boolean z2 = this.A0A;
            if (z2) {
                A02(hashMap, A00(138, 22, 31), String.valueOf(z2));
            }
            A02(hashMap, A00(160, 13, 92), String.valueOf(M6.A02(this.A01)));
            A02(hashMap, A00(216, 12, 3), C1008Ly.A05(System.currentTimeMillis()));
            if (this.A0D.A06() && this.A0D.A04() != null) {
                A02(hashMap, A00(56, 6, 122), this.A0D.A04());
            }
            String A05 = this.A0D.A05();
            if (!TextUtils.isEmpty(A05)) {
                A02(hashMap, A00(62, 14, 113), A05);
            }
            String str2 = this.A08;
            if (str2 != null) {
                A02(hashMap, A00(228, 11, 30), str2);
            }
            A02(hashMap, A00(76, 17, 71), UUID.randomUUID().toString());
            A02(hashMap, A00(20, 36, 13), C1008Ly.A06(C2A.A00(this.A01.A00())));
            String str3 = this.A06;
            if (str3 != null) {
                A02(hashMap, A00(108, 11, 51), str3);
            }
            String str4 = this.A05;
            if (str4 != null) {
                if (A0G[5].length() == 32) {
                    String[] strArr6 = A0G;
                    strArr6[1] = "oug9irQjulGDcN1zjjec1oFwPujMP8yb";
                    strArr6[3] = "P1fPvVUp9X55Q5Xl2H8DBdFxzWSw3WjN";
                    A02(hashMap, A00(2, 18, 52), str4);
                }
            }
            if (JD.A1b(this.A01)) {
                new MO(this.A01).A05(hashMap);
            }
            return hashMap;
        }
        throw new RuntimeException();
    }
}
