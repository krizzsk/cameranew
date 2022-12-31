package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;
import java.util.ArrayList;
/* loaded from: assets/audience_network.dex */
public class YT implements InterfaceC06356k {
    public final /* synthetic */ YQ A00;

    public YT(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityInfo[] activityInfoArr;
        ActivityInfo[] activityInfoArr2;
        AnonymousClass61 anonymousClass61;
        ActivityInfo[] activityInfoArr3;
        activityInfoArr = this.A00.A04;
        if (activityInfoArr != null) {
            ArrayList arrayList = new ArrayList();
            activityInfoArr2 = this.A00.A04;
            int length = activityInfoArr2.length;
            anonymousClass61 = this.A00.A03;
            int min = Math.min(length, anonymousClass61.A0U());
            for (int i2 = 0; i2 < min; i2++) {
                activityInfoArr3 = this.A00.A04;
                arrayList.add(activityInfoArr3[i2].name);
            }
            return this.A00.A0E(arrayList);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
