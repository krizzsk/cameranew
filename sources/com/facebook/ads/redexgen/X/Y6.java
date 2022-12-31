package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y6 implements InterfaceC06356k {
    public static String[] A01 = {"xn6Y4xiAj5nTE1ZX0fcI9", "IuzZJNTC9Fpz", "Zp9uFgGuFlryeSNHyo4T0p", "eRJH2gjtevDtLFu1wMxFEv", "pTKacr9NdWTXHSX", "3c0ViuxMUKEAC", "2WDSEnCYP4spNEJs", "S3q5Kz3J"};
    public final /* synthetic */ C1312Xw A00;

    public Y6(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        if (Build.VERSION.SDK_INT >= 26) {
            telephonyManager = this.A00.A00;
            if (telephonyManager != null) {
                C1312Xw c1312Xw = this.A00;
                telephonyManager2 = c1312Xw.A00;
                return c1312Xw.A0F(telephonyManager2.isDataEnabled());
            }
            return this.A00.A07(EnumC06466v.A07);
        }
        C1312Xw c1312Xw2 = this.A00;
        String[] strArr = A01;
        if (strArr[2].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "x95Rh7kgyGSfBF3YHwpGzi";
        strArr2[3] = "73CHLU13D6YvD39ECjSAyL";
        return c1312Xw2.A07(EnumC06466v.A05);
    }
}
