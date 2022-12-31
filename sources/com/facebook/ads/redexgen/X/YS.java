package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;
/* loaded from: assets/audience_network.dex */
public class YS implements InterfaceC06356k {
    public static String[] A01 = {"BjEOBj6HSQS8i4DRK2qoJX27hoC0R4DA", "kauKwe7CVPrqe4cOgSIwGmxqelbhToEk", "XZC7QZo7Jtp8ceyvJGPCObnucv7Agiw", "JUan8YMmX5ogxlB6aq0dkHVlKOHTqFeF", "IuTolVrjy7qRtOK6QcTLTodgNQuY61bU", "4L2hIP4Kb6m", "Yg6y90VIZ7Ah3ybSxqXW6wOi2HMwnGfT", "hl8KcVIJUlPiTEXEjbalUYczznSZgz62"};
    public final /* synthetic */ YQ A00;

    public YS(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ActivityInfo[] activityInfoArr;
        ActivityInfo[] activityInfoArr2;
        activityInfoArr = this.A00.A04;
        if (activityInfoArr != null) {
            YQ yq = this.A00;
            activityInfoArr2 = yq.A04;
            if (A01[3].charAt(20) != 'k') {
                throw new RuntimeException();
            }
            A01[4] = "ZFJR0DMAu8l3jjK6mMcKAcH3eLfgQnHb";
            return yq.A04(activityInfoArr2.length);
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
