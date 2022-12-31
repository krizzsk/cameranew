package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;
/* renamed from: com.facebook.ads.redexgen.X.Xx  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1313Xx implements InterfaceC06356k {
    public static String[] A01 = {"Vh7d3JLClPU6O6M8cwd6Jw", "qoTOEE24iOX0Q2iJnmkuihyFZ58dtUeG", "nAWEC03NDSwq9NkCe2EWt", "lKLCTUg5DoQjO8iCafmP2M1qyzkHzRyN", "zIUGSnqgNQBLElYl1akNx9HRDEYjixyz", "g15BZq0dmNsNcXFZVGLSC", "388jVMFAtK4Tm3JKA9SjxAcbz1TvPoye", "A1Sv5qAzVDWgkr4HaP1"};
    public final /* synthetic */ C1312Xw A00;

    public C1313Xx(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        if (Build.VERSION.SDK_INT < 28) {
            return this.A00.A07(EnumC06466v.A05);
        }
        C1312Xw c1312Xw = this.A00;
        String[] strArr = A01;
        if (strArr[4].charAt(18) != strArr[1].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "bZz0x6nk4wqsfLm60KBH7nDut9sP39y5";
        strArr2[3] = "KyjNNUgB1DvvpLcjDLXdCxQbayCmxayp";
        telephonyManager = c1312Xw.A00;
        if (telephonyManager != null) {
            C1312Xw c1312Xw2 = this.A00;
            telephonyManager2 = c1312Xw2.A00;
            return c1312Xw2.A04(telephonyManager2.getSimCarrierId());
        }
        return this.A00.A07(EnumC06466v.A07);
    }
}
