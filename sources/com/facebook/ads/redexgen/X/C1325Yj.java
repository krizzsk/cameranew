package com.facebook.ads.redexgen.X;

import android.content.pm.ServiceInfo;
import java.util.ArrayList;
import java.util.Collections;
/* renamed from: com.facebook.ads.redexgen.X.Yj  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1325Yj implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public C1325Yj(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ServiceInfo[] serviceInfoArr;
        ServiceInfo[] serviceInfoArr2;
        AnonymousClass61 anonymousClass61;
        ServiceInfo[] serviceInfoArr3;
        serviceInfoArr = this.A00.A05;
        if (serviceInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            serviceInfoArr2 = this.A00.A05;
            int length = serviceInfoArr2.length;
            anonymousClass61 = this.A00.A03;
            int min = Math.min(length, anonymousClass61.A0U());
            for (int i2 = 0; i2 < min; i2++) {
                serviceInfoArr3 = this.A00.A05;
                arrayList.add(serviceInfoArr3[i2].name);
            }
            Collections.sort(arrayList);
            return this.A00.A0E(arrayList);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
