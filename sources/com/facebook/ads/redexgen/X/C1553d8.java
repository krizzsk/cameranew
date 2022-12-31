package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.d8  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1553d8 extends AbstractC04770f {
    public static byte[] A02;
    public static String[] A03 = {"jy5CHS8ciK95qvgyZPKNzTZ", "EsJYGwS5VmRo2OpDKfhEPxAAyWa", "TXamSNcIJ7UnME9", "aAqXHcETEDrJIQ0", "iKc7fPJ", "AeuUMR7bsIhvkygvb", "MOi5LCZvXht1yXQHfTxaoFALkw", "2sehTzR2RD89PLQKMZ0CUhyomJdrMDfZ"};
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 96);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        byte[] bArr = {42, 40, 51, 53, 40, 51, 46, 35, 75, 70, 79, 90};
        String[] strArr = A03;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        A03[5] = "wR51MZdRiuTx9tajcMEJR1ABXy";
        A02 = bArr;
    }

    static {
        A01();
        A04 = C1553d8.class.getSimpleName();
    }

    public C1553d8(XT xt, JT jt, String str, Uri uri, Map<String, String> mExtraData) {
        super(xt, jt, str);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC04770f
    public final void A0B() {
        JV jv = JV.A05;
        String queryParameter = this.A00.getQueryParameter(A00(0, 8, 58));
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                jv = JV.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception unused) {
            }
        }
        super.A01.A92(this.A02, this.A01, this.A00.getQueryParameter(A00(8, 4, 95)), jv);
    }
}
