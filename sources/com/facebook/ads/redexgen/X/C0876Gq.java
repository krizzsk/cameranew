package com.facebook.ads.redexgen.X;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Gq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0876Gq implements InterfaceC1132Qv {
    public static byte[] A00;
    public static String[] A01 = {"pV4qaXw6VxHe7sBZO1Jm7", "tYmmDZR", "QxtgKachTN194eYcwGU9LkTJFmNVHEQq", "xizWbh8OYfs2b3YS4RQSAfdZXrf", "ZGXkvbP8ihMVuHVBPcyrpbYPgwlZhzIP", "8ikrsMyeeixNpMm9GyoBY2XQC58AAuyp", "5oOpXt9UGuRFEd", "RP1a17xo5hy9tsnm95xYo1Dg0S3kboh6"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{18, 74, 16, 16, 16, Draft_75.CR, 101, 121, 121, 125, Draft_75.CR, Byte.MAX_VALUE, 72, 92, 88, 72, 94, 89, Draft_75.CR, 16, 16, 16, 124, 124, 124, 97, 9, 21, 21, 17, 97, 19, 36, 50, 49, 46, 47, 50, 36, 97, 124, 124, 124, 28, 48, 49, 43, 58, 49, 43, 101, 85, 87, 123, 122, 96, 113, 122, 96, 46, 52, 103, 80, 86, 80, 92, 67, 80, 21, 64, 71, 89, 15, 21, 36, 3, 22, 3, 2, 4, 77, 87};
    }

    static {
        A01();
    }

    private void A02(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                List<String> headers = map.get(str);
                for (String str2 : headers) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    String header = A00(1, 1, 79);
                    sb.append(header);
                    sb.append(str2);
                    String header2 = sb.toString();
                    A8h(header2);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1132Qv
    public final boolean A8R() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1132Qv
    public final void A8h(String str) {
        System.out.println(str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1132Qv
    public final void A95(HttpURLConnection httpURLConnection, Object obj) throws IOException {
        A8h(A00(2, 20, 18));
        A8h(httpURLConnection.getRequestMethod() + A00(0, 1, 13) + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            A8h(A00(52, 9, 43) + ((String) obj));
        }
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        String[] strArr = A01;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "GaHF5freueg6l7URhKCrm47FqBCtqYBi";
        strArr2[5] = "OrzNjk0gyiryng1un1TYaQe8BXJyjneo";
        A02(requestProperties);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1132Qv
    public final void A96(InterfaceC1115Qe interfaceC1115Qe) {
        if (interfaceC1115Qe != null) {
            A8h(A00(22, 21, 126));
            A8h(A00(61, 13, 10) + interfaceC1115Qe.getUrl());
            A8h(A00(74, 8, 72) + interfaceC1115Qe.A7U());
            A02(interfaceC1115Qe.A6g());
            A8h(A00(43, 9, 96) + interfaceC1115Qe.A5m());
        }
    }
}
