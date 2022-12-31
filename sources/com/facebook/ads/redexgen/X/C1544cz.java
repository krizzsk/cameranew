package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.cz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1544cz extends AbstractRunnableC0981Kv {
    public final /* synthetic */ C1543cy A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public C1544cz(C1543cy c1543cy, Map map, Map map2) {
        this.A00 = c1543cy;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        String str;
        JT jt;
        JT jt2;
        String str2;
        str = this.A00.A0N;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(this.A02);
            hashMap.putAll(this.A01);
            jt = this.A00.A0F;
            if (jt != null) {
                jt2 = this.A00.A0F;
                str2 = this.A00.A0N;
                jt2.A9B(str2, hashMap);
            }
        }
    }
}
