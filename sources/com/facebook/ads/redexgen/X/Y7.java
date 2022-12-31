package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y7 implements InterfaceC06356k {
    public static String[] A01 = {"Zr9pMbCXDOnIQia1rxNbs", "xgHdKmUla89dgoNlEUmYBSdthljERTVN", "t0eJ9CzsilrQTJZ3mBY5uHdLOToWpPD0", "xn7Df6Bsn6N8b", "nuXOesuXOGqaff6jWjDzzwB48Mr7m9Ru", "HD4PNhpjIErL9f7FhF1L2XB0w8jmfy8z", "GFJMAbd7JtPv78Iw3eZ5GKABpr6j7C", "a6D5eDw1EZzTAa7WvhZLV0FGc6KUpGTS"};
    public final /* synthetic */ C1312Xw A00;

    public Y7(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    @SuppressLint({"MissingPermission"})
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        int A012;
        if (Build.VERSION.SDK_INT < 17) {
            return this.A00.A07(EnumC06466v.A05);
        }
        boolean A0D = AnonymousClass78.A0D();
        if (A01[2].charAt(7) != 's') {
            throw new RuntimeException();
        }
        A01[4] = "7cAAgCcjwnswSonydGODzEoLsKghCJb5";
        if (A0D) {
            boolean A0C = AnonymousClass78.A0C();
            if (A01[1].charAt(23) == 'I') {
                throw new RuntimeException();
            }
            A01[7] = "A1O8dvsw8NjieGbBncMIJ1M47KAaXmaM";
            if (A0C) {
                return this.A00.A07(EnumC06466v.A07);
            }
        }
        telephonyManager = this.A00.A00;
        if (telephonyManager != null) {
            C1312Xw c1312Xw = this.A00;
            telephonyManager2 = c1312Xw.A00;
            A012 = C1312Xw.A01(telephonyManager2.getAllCellInfo().get(0));
            return c1312Xw.A04(A012);
        }
        C1312Xw c1312Xw2 = this.A00;
        EnumC06466v enumC06466v = EnumC06466v.A07;
        String[] strArr = A01;
        if (strArr[3].length() != strArr[6].length()) {
            String[] strArr2 = A01;
            strArr2[3] = "coCM9MFponCPc";
            strArr2[6] = "NV1iD8UH9ErBba9OnjbAeyrfSpL8qw";
            return c1312Xw2.A07(enumC06466v);
        }
        return c1312Xw2.A07(enumC06466v);
    }
}
