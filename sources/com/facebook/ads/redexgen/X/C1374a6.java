package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.a6  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1374a6 implements InterfaceC06356k {
    public static String[] A01 = {"9CH7FUr60fjSOu0uDtam6QWrW1LAXcO0", "MGZ5NGAJYsXrcQ530Rpa4mq072uYsiXm", "FSEpTqAJrXrPXD8Cb", "YDmM9nsCETgUfJB46tzDOSpydcNxEQ3F", "VGv8Kw1xSq2totQkDwmbaDQvoJVXTwia", "PqLjk4LqC3tC9ytXEM059nB67sHSnsxP", "xjbenFCMrkBs7EfKqhSnYCZ0lRG62qii", "xgMaaa53aLKiV09tKVXK6rj7dvlbsjte"};
    public final /* synthetic */ C1371a3 A00;

    public C1374a6(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        if (Build.VERSION.SDK_INT >= 24) {
            applicationInfo = this.A00.A01;
            if (applicationInfo != null) {
                C1371a3 c1371a3 = this.A00;
                applicationInfo2 = c1371a3.A01;
                return c1371a3.A08(applicationInfo2.deviceProtectedDataDir);
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        C1371a3 c1371a32 = this.A00;
        EnumC06466v enumC06466v = EnumC06466v.A05;
        String[] strArr = A01;
        if (strArr[4].charAt(20) != strArr[5].charAt(20)) {
            String[] strArr2 = A01;
            strArr2[3] = "fnZh3TS8JAEKtifjP4n7RBztgRvZoar8";
            strArr2[2] = "4XQjD71oxr9tiB6pv";
            return c1371a32.A07(enumC06466v);
        }
        throw new RuntimeException();
    }
}
