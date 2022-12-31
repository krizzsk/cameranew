package com.facebook.ads.redexgen.X;

import android.content.pm.ApplicationInfo;
/* renamed from: com.facebook.ads.redexgen.X.a7  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1375a7 implements InterfaceC06356k {
    public static String[] A01 = {"b1sQJ", "SIF58uGHe7qyLmHU2z0R0", "OwOBv3ZEKz2Te88ibAl3d47J53q2OGoK", "esWFBpscKVup9jNI8XCXNCETTdpqRq5Z", "zivB8", "FBi4O7QrEsFNvdqkgZ6MOGJI", "H45EAoAIvQ1szMaGMHC8haArjN6", "w12X6M1S0qfh4A3JJ2wkr2WlTLMqdjE1"};
    public final /* synthetic */ C1371a3 A00;

    public C1375a7(C1371a3 c1371a3) {
        this.A00 = c1371a3;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        ApplicationInfo applicationInfo;
        ApplicationInfo applicationInfo2;
        applicationInfo = this.A00.A01;
        if (applicationInfo != null) {
            C1371a3 c1371a3 = this.A00;
            applicationInfo2 = c1371a3.A01;
            return c1371a3.A08(applicationInfo2.publicSourceDir);
        }
        C1371a3 c1371a32 = this.A00;
        String[] strArr = A01;
        if (strArr[4].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[4] = "DiCvH";
        strArr2[0] = "OWYZT";
        return c1371a32.A07(EnumC06466v.A07);
    }
}
