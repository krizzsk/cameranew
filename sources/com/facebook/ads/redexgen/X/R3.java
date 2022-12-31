package com.facebook.ads.redexgen.X;

import org.json.JSONArray;
/* loaded from: assets/audience_network.dex */
public final class R3 {
    public static boolean A00(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            R2 A00 = R2.A00(jSONArray, i2);
            R2 t2 = R2.A00(jSONArray2, i2);
            if (A00 != t2 || !A00.A05(jSONArray, jSONArray2, i2)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean A01(JSONArray jSONArray, JSONArray jSONArray2) {
        return A00(jSONArray, jSONArray2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A02(org.json.JSONObject r5, org.json.JSONObject r6) {
        /*
            int r1 = r5.length()
            int r0 = r6.length()
            r4 = 0
            if (r1 == r0) goto Lc
            return r4
        Lc:
            java.util.Iterator r3 = r5.keys()
        L10:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L35
            java.lang.Object r2 = r3.next()
            java.lang.String r2 = (java.lang.String) r2
            boolean r0 = r6.has(r2)
            if (r0 != 0) goto L23
            return r4
        L23:
            com.facebook.ads.redexgen.X.R2 r1 = com.facebook.ads.redexgen.X.R2.A01(r5, r2)
            com.facebook.ads.redexgen.X.R2 r0 = com.facebook.ads.redexgen.X.R2.A01(r6, r2)
            if (r1 == r0) goto L2e
            return r4
        L2e:
            boolean r0 = r1.A07(r5, r6, r2)
            if (r0 != 0) goto L10
            return r4
        L35:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.R3.A02(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
