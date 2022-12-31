package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.1U  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C1U implements Serializable {
    public static byte[] A0D = null;
    public static String[] A0E = {"U8UpqfD5GcCjHjfawFZje9GDKAZv", "HUavThSyJs21QkbQiVkA2MVijDNZ2nZM", "IARTRQxD0JaHLqaDLyMBN", "Hsg2CAAgFk1Vd6W6cseJD0UtB0g0pB8N", "UbckorOyb4FxR7xZ8GphAvSWlQBuZ4z3", "t3UgO82iTBj4Je3asj0XN1i1cbfA", "fleIFkN77EtPYIR4IZjCzdODP1NyIKiN", "OPDxW3mvsrdjNTdOIjiPk89aFloqol7I"};
    public static final C1V A0F;
    public static final EnumC1056Nv A0G;
    public static final long serialVersionUID = -5352540123250859603L;
    public String A00;
    public final int A01;
    public final int A02;
    public final C1V A03;
    public final EnumC1056Nv A04;
    public final String A05;
    public final String A06;
    public final String A07;
    @Nullable
    public final String A08;
    public final String A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = copyOfRange[i5] ^ i4;
            if (A0E[6].charAt(18) == 'U') {
                throw new RuntimeException();
            }
            A0E[2] = "FjEz07QReKngvCKAACpwo";
            copyOfRange[i5] = (byte) (i6 ^ 118);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A0D = new byte[]{124, 64, 77, 85, 12, Byte.MAX_VALUE, 88, 67, 94, 73, 12, 91, 69, 64, 64, 12, 77, 89, 88, 67, 65, 77, 88, 69, 79, 77, 64, 64, 85, 12, 67, 92, 73, 66, 12, 69, 66, 12, 119, 95, 73, 79, 95, 113, 95, 65, 118, 100, 114, 97, 119, 118, 119, 51, 67, Byte.MAX_VALUE, 114, 106, 80, 95, 90, 86, 93, 71, 108, 71, 92, 88, 86, 93, 82, 69, 111, 110, 103, 106, 114, 84, 104, 103, 98, 104, 96, 84, Byte.MAX_VALUE, 110, 115, Byte.MAX_VALUE, 54, 61, 50, 49, 63, 54, 12, 54, 61, 55, 12, 48, 50, 33, 55, 68, 79, 64, 67, 77, 68, 126, 72, 79, 85, 83, 78, 126, 66, 64, 83, 69, 20, 22, 29, 22, 1, 26, 16, 44, 7, 22, 11, 7, 112, 119, 106, 109, 120, 119, 122, 124, 70, 112, 125, 34, 37, 63, 57, 36, 20, 40, 42, 57, 47, 20, 34, 40, 36, 37, 20, 62, 57, 39, 112, 106, 70, 105, 117, 120, 96, 120, 123, 117, 124, 70, 107, 124, 116, 118, 109, 124, 70, Byte.MAX_VALUE, 118, 107, 116, 120, 109, 83, 78, 85, 89, 82, 72, 93, 72, 85, 83, 82, 56, 36, 41, 49, 41, 42, 36, 45, 23, 44, 41, 60, 41, 52, 54, 33, 39, 37, 39, 44, 45, 42, 35, 27, 41, 33, 48, 44, 43, 32, 2, 21, 7, 17, 2, 20, 21, 20, 47, 0, 28, 17, 9, 47, 4, 21, 8, 4, 87, 79, 77, 84, 84, 69, 70, 72, 65, 123, 87, 65, 71, 75, 74, 64, 87, 101, 126, 99, 123, 121, 96, 96, 113, 114, 124, 117, 79, 99, 117, 115, Byte.MAX_VALUE, 126, 116, 99, 75, 76, 87, 1, 19, 20, 41, 0, 31, 19, 1, 41, 2, 31, 27, 19, 25, 3, 2, 41, 31, 24, 41, 27, 31, 26, 26, 31, 5, 19, 21, 25, 24, 18, 5};
    }

    static {
        A06();
        A0G = EnumC1056Nv.A05;
        A0F = C1V.A03;
    }

    public C1U(String str, String str2, int i2, String str3, String str4, EnumC1056Nv enumC1056Nv, int i3, boolean z, boolean z2, C1V c1v, boolean z3, String str5) {
        if (z3) {
            this.A08 = UUID.randomUUID().toString();
            this.A07 = Uri.parse(str).buildUpon().appendQueryParameter(A03(132, 11, 111), this.A08).appendQueryParameter(A03(58, 12, 69), str5).build().toString();
        } else {
            this.A07 = str;
            this.A08 = null;
        }
        this.A06 = str2;
        this.A01 = i2;
        this.A09 = str3;
        this.A05 = str4;
        this.A04 = enumC1056Nv;
        this.A02 = i3;
        this.A0B = z;
        this.A0A = z2;
        this.A03 = c1v;
        this.A0C = z3;
    }

    public static int A00(JSONObject jSONObject) {
        String A03 = A03(246, 17, 82);
        if (jSONObject.has(A03)) {
            return jSONObject.optInt(A03);
        }
        return jSONObject.optInt(A03(263, 19, 102), 0);
    }

    @Nullable
    public static C1U A01(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(A03(198, 13, 62));
        if (optJSONObject == null) {
            return null;
        }
        return new C1U(optJSONObject.optString(A03(282, 3, 72)), optJSONObject.optString(A03(143, 19, 61)), A00(jSONObject), A05(optJSONObject), A04(optJSONObject), A02(optJSONObject), optJSONObject.optInt(A03(285, 32, 0), 5000), optJSONObject.optBoolean(A03(103, 17, 87), true), optJSONObject.optBoolean(A03(88, 15, 37)), C1V.A00(optJSONObject.optString(A03(211, 17, 50), A0F.name())), optJSONObject.optBoolean(A03(162, 25, 111)), jSONObject.optString(A03(70, 2, 71)));
    }

    public static EnumC1056Nv A02(JSONObject jSONObject) {
        return EnumC1056Nv.A00(jSONObject.optInt(A03(187, 11, 74), A0G.A03()));
    }

    public static String A04(JSONObject jSONObject) {
        JSONObject genericTextObject = jSONObject.optJSONObject(A03(120, 12, 5));
        String A03 = A03(0, 45, 90);
        return genericTextObject == null ? A03 : genericTextObject.optString(A03(72, 16, 125), A03);
    }

    public static String A05(JSONObject jSONObject) {
        JSONObject genericTextObject = jSONObject.optJSONObject(A03(120, 12, 5));
        String A03 = A03(45, 13, 101);
        return genericTextObject == null ? A03 : genericTextObject.optString(A03(228, 18, 6), A03);
    }

    public final int A07() {
        return this.A01;
    }

    public final int A08() {
        return this.A02;
    }

    public final C1V A09() {
        return this.A03;
    }

    public final EnumC1056Nv A0A() {
        return this.A04;
    }

    public final String A0B() {
        return this.A00;
    }

    public final String A0C() {
        return this.A05;
    }

    public final String A0D() {
        return this.A06;
    }

    public final String A0E() {
        return this.A07;
    }

    @Nullable
    public final String A0F() {
        return this.A08;
    }

    public final String A0G() {
        return this.A09;
    }

    public final void A0H(String str) {
        this.A00 = str;
    }

    public final boolean A0I() {
        return this.A0B;
    }

    public final boolean A0J() {
        return this.A0C;
    }
}
