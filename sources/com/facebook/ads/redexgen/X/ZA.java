package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class ZA implements InterfaceC06426r<String> {
    public final String A00;
    public final boolean A01;

    public ZA(String str) {
        this.A00 = str;
        this.A01 = Z9.A01().hasSystemFeature(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    /* renamed from: A00 */
    public final JSONObject AEz(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final boolean A8K(Object obj) {
        ZA za = (ZA) obj;
        return this.A00.equals(za.A00) && this.A01 == za.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06426r
    public final int AEd() {
        return this.A00.getBytes().length + 8;
    }
}
