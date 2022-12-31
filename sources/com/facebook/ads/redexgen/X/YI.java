package com.facebook.ads.redexgen.X;

import android.content.Context;
import java.util.HashMap;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public class YI implements InterfaceC06356k {
    public final /* synthetic */ EnumC06316g A00;
    public final /* synthetic */ YG A01;
    public final /* synthetic */ List A02;

    public YI(YG yg, List list, EnumC06316g enumC06316g) {
        this.A01 = yg;
        this.A02 = list;
        this.A00 = enumC06316g;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        AbstractC06506z A03;
        Context context;
        HashMap hashMap = new HashMap();
        for (C06346j c06346j : this.A02) {
            if (c06346j.A02()) {
                String str = (String) c06346j.A01();
                context = this.A01.A00;
                YH systemSettings = new YH(context, str, this.A00);
                hashMap.put(str, systemSettings);
            }
        }
        A03 = this.A01.A03(hashMap);
        return A03;
    }
}
