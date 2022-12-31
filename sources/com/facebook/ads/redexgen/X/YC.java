package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public class YC implements InterfaceC06356k {
    public final /* synthetic */ YA A00;
    public final /* synthetic */ List A01;

    public YC(YA ya, List list) {
        this.A00 = ya;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        AbstractC06506z A02;
        HashMap hashMap = new HashMap();
        for (C06346j c06346j : this.A01) {
            if (c06346j.A02()) {
                String str = (String) c06346j.A01();
                YB systemProperty = new YB(str);
                hashMap.put(str, systemProperty);
            }
        }
        A02 = this.A00.A02(hashMap);
        return A02;
    }
}
