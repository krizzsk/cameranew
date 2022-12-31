package com.facebook.ads.redexgen.X;

import android.content.pm.ServiceInfo;
/* renamed from: com.facebook.ads.redexgen.X.Yi  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1324Yi implements InterfaceC06356k {
    public static String[] A01 = {"Kjl9x1nXLMp", "FYT6FJfE388FncoeBbUW5LDH7Ti6Kpnc", "Yxd2XW5tX0tpbE5v80iFGWNMQ7F", "Eun4caaboMQouomEKTkKbMJy1uWMR8C3", "2B", "gVUv49X3C1I0CRHiCQrxfKc2j3pZm33W", "VtV7HGxoJcmYVE0XtMWfAnTQdxbbthfO", "Muv0aFmfDz7QlEQw1d"};
    public final /* synthetic */ YQ A00;

    public C1324Yi(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ServiceInfo[] serviceInfoArr;
        ServiceInfo[] serviceInfoArr2;
        serviceInfoArr = this.A00.A05;
        if (serviceInfoArr != null) {
            YQ yq = this.A00;
            serviceInfoArr2 = yq.A05;
            return yq.A04(serviceInfoArr2.length);
        }
        YQ yq2 = this.A00;
        String[] strArr = A01;
        if (strArr[7].length() != strArr[4].length()) {
            String[] strArr2 = A01;
            strArr2[0] = "czOc910r7ol";
            strArr2[2] = "WgsI1fVM7Yu7d9q7aeaJmksjNii";
            return yq2.A07(EnumC06466v.A07);
        }
        throw new RuntimeException();
    }
}
