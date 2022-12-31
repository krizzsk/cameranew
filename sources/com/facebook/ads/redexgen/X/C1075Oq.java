package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1075Oq {
    public static byte[] A00;
    public static String[] A01 = {"CXRchRuqobcH0303RF", "0PvsG2xJSmQLgGTcWH9EYe7sEgRs7pRt", "Ep2muPcKb5OPprn584rkOKVS7ZwPor7u", "ESdTFl6hgzo0PrNou", "ifIc3126Iu24LMQAqXU9MKX3mrrg1qWL", "gYyPZy3RrUjZ7", "cRp6DEQTFSLuVCLvwOm8", "Iag0U1Rq9Q0ZydVPffrz8fjunI2ky4CH"};

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 91);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-119, -68, -8, -14, -50, -16, -16, -14, -3, 1, -70, -33, -18, -5, -12, -14, 0, -46, -2, -3, 3, -12, -3, 3, -68, -37, -12, -3, -10, 3, -9, -17, 27, 26, 32, 17, 26, 32, -39, -2, Draft_75.CR, 26, 19, 17, -71, -75, -49, -32, -15, -13, -24, -32, -21, -97, -62, -18, -19, -13, -28, -19, -13, 9, 30, 9, 17, 20, 9, 10, 20, Draft_75.CR, -7, 16, 11, -4, 10, -50, -27, -32, -47, -33, -116, 4, 16, 5, 6, -15, -2, -2, -5, -2, 21, 28, 19, 19, -7, -24, -11, -18, -20};
    }

    static {
        A04();
    }

    @Nullable
    @RequiresApi(api = 21)
    public static WebResourceResponse A00(XT xt, WebResourceRequest webResourceRequest, Uri uri, String str, HashMap<String, String> hashMap) throws IOException {
        String A02 = A02(85, 5, 49);
        try {
            C1076Or c1076Or = new C1076Or(uri, QN.A05(xt).A0E(xt));
            int available = c1076Or.available();
            if (available <= 0) {
                A05(xt, 1, new Pair[]{new Pair(A02(61, 9, 77), String.valueOf(available))});
                return null;
            }
            String A03 = A03(webResourceRequest.getRequestHeaders());
            if (A03 != null) {
                try {
                    C1074Op A012 = A01(A03);
                    boolean z = A012.A03;
                    String rangeHeader = A01[7];
                    if (rangeHeader.charAt(0) != '8') {
                        String[] strArr = A01;
                        strArr[5] = "V65aPOMRpqA07";
                        strArr[6] = "uUbGIz9l3eQBVw2CYc6n";
                        if (!z) {
                            Pair[] pairArr = new Pair[1];
                            String A022 = A012.A02 != null ? A012.A02 : A02(90, 4, 76);
                            String rangeHeader2 = A02(94, 5, 44);
                            pairArr[0] = new Pair(rangeHeader2, A022);
                            A05(xt, 0, pairArr);
                            return null;
                        }
                        int i2 = A012.A01;
                        int rangeEnd = A012.A00 == -1 ? available - 1 : A012.A00;
                        A06(hashMap, available);
                        hashMap.put(A02(31, 13, 81), A02(75, 6, 17) + i2 + A02(1, 1, 52) + rangeEnd + A02(2, 1, 110) + available);
                        xt.A0D().A51();
                        return new WebResourceResponse(str, null, 206, A02(46, 15, 36), hashMap, c1076Or);
                    }
                    throw new RuntimeException();
                } catch (NumberFormatException e2) {
                    String rangeHeader3 = e2.toString();
                    A05(xt, 3, new Pair[]{new Pair(A02, rangeHeader3)});
                    return null;
                }
            }
            xt.A0D().A51();
            A06(hashMap, available);
            return new WebResourceResponse(str, null, 200, A02(44, 2, 15), hashMap, c1076Or);
        } catch (IOException e3) {
            A05(xt, 2, new Pair[]{new Pair(A02, e3.toString())});
            return null;
        }
    }

    @RequiresApi(api = 21)
    public static C1074Op A01(String str) {
        if (str == null) {
            C1074Op c1074Op = new C1074Op();
            c1074Op.A03 = false;
            c1074Op.A02 = null;
            return c1074Op;
        }
        String[] split = str.split(A02(3, 1, 90));
        if (split.length >= 2) {
            if (A02(70, 5, 60).equals(split[0].toLowerCase(Locale.US).trim())) {
                String[] ranges = split[1].trim().split(A02(0, 1, 2));
                if (ranges.length != 1) {
                    C1074Op c1074Op2 = new C1074Op();
                    c1074Op2.A03 = false;
                    c1074Op2.A02 = str;
                    return c1074Op2;
                }
                String[] split2 = split[1].trim().split(A02(1, 1, 52));
                C1074Op c1074Op3 = new C1074Op();
                c1074Op3.A03 = true;
                c1074Op3.A02 = str;
                c1074Op3.A01 = TextUtils.isEmpty(split2[0]) ? 0 : Integer.parseInt(split2[0]);
                if (split2.length > 1) {
                    c1074Op3.A00 = TextUtils.isEmpty(split2[1]) ? -1 : Integer.parseInt(split2[1]);
                } else {
                    c1074Op3.A00 = -1;
                }
                return c1074Op3;
            }
        }
        C1074Op c1074Op4 = new C1074Op();
        c1074Op4.A03 = false;
        c1074Op4.A02 = str;
        return c1074Op4;
    }

    @Nullable
    public static String A03(Map<String, String> map) {
        for (String str : map.keySet()) {
            String lowerCase = str.toLowerCase(Locale.US);
            String header = A02(94, 5, 44);
            if (header.equals(lowerCase)) {
                String header2 = map.get(str);
                return header2;
            }
        }
        return null;
    }

    public static void A05(XT xt, int i2, Pair<String, String>[] pairArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A02(81, 4, 70), i2);
            for (Pair<String, String> pair : pairArr) {
                jSONObject.put((String) pair.first, pair.second);
            }
        } catch (JSONException unused) {
        }
        xt.A0D().A50(jSONObject.toString());
    }

    public static void A06(HashMap<String, String> hashMap, int i2) {
        hashMap.put(A02(4, 13, 50), A02(70, 5, 60));
        hashMap.put(A02(17, 14, 52), String.valueOf(i2));
    }
}
