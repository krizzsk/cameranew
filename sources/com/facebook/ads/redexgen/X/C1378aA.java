package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
/* renamed from: com.facebook.ads.redexgen.X.aA  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1378aA implements InterfaceC06356k {
    public static String[] A01 = {"CyYconlRA", "Z99FvxWAH", "r", "I6nMbGSwO", "f1HEaIkkO6UN2Wyn2K6t6YhOL5YQHMub", "q7TOnFp8MDH9pVcAi7q7X5O", "kHDnEbJrZHu3VwOwnck16fHaeHzzt8", "W41og5bN"};
    public final /* synthetic */ C1371a3 A00;

    public C1378aA(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        applicationInfo = this.A00.A01;
        if (applicationInfo != null) {
            C1371a3 c1371a3 = this.A00;
            String[] strArr = A01;
            if (strArr[3].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A01[2] = "ZWV";
            applicationInfo2 = c1371a3.A01;
            return c1371a3.A08(applicationInfo2.sourceDir);
        }
        C1371a3 c1371a32 = this.A00;
        if (A01[6].length() != 14) {
            A01[6] = "1VAENbmq7tYIb9ZQI0D0jEbiw3q";
            return c1371a32.A07(EnumC06466v.A07);
        }
        return c1371a32.A07(EnumC06466v.A07);
    }
}
