package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class GG implements R4 {
    public static byte[] A05;
    public static String[] A06 = {"yJwczGSbba5UrkwzZOW60Je1LUoZxQIl", "oZp", "SLRT1bjVboXCxkvYGWPu27FVIHxKKecJ", "WHpvXVjPup", "", "gRWAa43vtpEz38T6Kt4HiTmitjJp6SmI", "", "QpBNbg2dQWhW"};
    @Nullable
    public JSONObject A00;
    @Nullable
    public JSONObject A01;
    public final R5 A03;
    public final List<R6> A04 = new ArrayList();
    public boolean A02 = false;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 27);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        if (A06[7].length() != 12) {
            throw new RuntimeException();
        }
        A06[3] = "GbTE4j9vTw";
        A05 = new byte[]{58, Draft_75.CR, 22, 28, 20, 29, 88, 93, 11, 88, 28, 25, 12, 25, 88, Draft_75.CR, 8, 28, 25, 12, 29, 66, 114, 82, 82, 88, 28, 25, 12, 25, 88, 82, 82, 114, 93, 11, 114, 82, 82, 88, 30, 17, 22, 31, 29, 10, 8, 10, 17, 22, 12, 88, 82, 82, 114, 93, 11, 89, 110, 117, Byte.MAX_VALUE, 119, 126, 59, 115, 122, 104, 59, 117, 116, 59, 125, 114, 117, 124, 126, 105, 107, 105, 114, 117, 111, 32, 23, 12, 6, 14, 7, 66, 11, 17, 66, 12, Draft_75.CR, 22, 66, 16, 7, 3, 6, 27, 43, 46, 59, 46, 111, 114, 114, 111, 33, 58, 35, 35, 107, 100, 99, 106, 104, Byte.MAX_VALUE, 125, Byte.MAX_VALUE, 100, 99, 121, 45, 44, 48, 45, 99, 120, 97, 97, 125, 114, 117, 124, 126, 105, 107, 105, 114, 117, 111, 59, 38, 38, 59, 117, 110, 119, 119, 77, 86, 79, 79};
    }

    static {
        A03();
    }

    public GG(R5 r5) {
        this.A03 = r5;
    }

    private boolean A04(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return false;
        }
        if (jSONObject == null || jSONObject2 == null) {
            return true;
        }
        boolean A02 = R3.A02(jSONObject, jSONObject2);
        String[] strArr = A06;
        if (strArr[0].charAt(8) != strArr[2].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[4] = "";
        strArr2[6] = "";
        return true ^ A02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r8.A03.A04() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
        throw new java.lang.IllegalArgumentException(A02(113, 19, 22));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean A05(org.json.JSONObject r9, @androidx.annotation.Nullable org.json.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GG.A05(org.json.JSONObject, org.json.JSONObject):boolean");
    }

    @Override // com.facebook.ads.redexgen.X.R4
    public final synchronized void A3E(R6 r6) {
        this.A04.add(r6);
    }

    @Override // com.facebook.ads.redexgen.X.R4
    public final synchronized JSONObject A6F() {
        if (this.A00 != null) {
        } else {
            throw new IllegalStateException(A02(82, 19, 121));
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.R4
    public final synchronized JSONObject A6c() {
        if (this.A03.A04()) {
            if (this.A01 != null) {
            } else {
                throw new IllegalStateException(A02(82, 19, 121));
            }
        } else {
            throw new IllegalStateException(A02(57, 25, 0));
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.R4
    public final R5 A6h() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.R4
    public final synchronized boolean A8U() {
        return this.A02;
    }
}
