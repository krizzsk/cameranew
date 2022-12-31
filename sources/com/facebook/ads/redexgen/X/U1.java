package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class U1 implements InterfaceC1117Qg {
    public static byte[] A00;
    public static String[] A01 = {"XEdsDf1ZbmPdObC9OTEW2z8", "P58GYLlTlw8ULSmid4", "Mge4MDnEmweXwYPX4YofvB", "Ml9Qgu3DLJEhAVMYvCD1k2vZQtwOfhBB", "E1ltw8QxIeAvk6pflmFLXm8YnaEq6i", "JKuYCHjaj2TXENBLxEiyXLq9QhlooG47", "FRLGU9mx00WiiljPewQioxO6UtPhxOrA", "0cr7cMD0TGsotYn7hqiGPP2awzQMRhBn"};

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            int i6 = (copyOfRange[i5] - i4) - 117;
            String[] strArr = A01;
            if (strArr[3].charAt(0) == strArr[6].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "sKECfnlovjgTE3hUnC6hiyxfwSx6iZYU";
            strArr2[6] = "FWGh7KUlNSgjRKrBTTVWdRGVuB2lw617";
            copyOfRange[i5] = (byte) i6;
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-12, 18, 31, -40, 37, -47, 21, 26, 36, 33, 18, 37, 20, 25, -47, 20, 32, 38, 31, 37, 22, 35, 36, -33, 1, 38, 48, 45, 30, 49, 32, 37, 34, 33, -35, 32, 44, 50, 43, 49, 34, 47, 48, -21, -35, 15, 34, 48, 45, 44, 43, 48, 34, -9, -35};
    }

    static {
        A01();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAA(InterfaceC1115Qe interfaceC1115Qe) {
        if (BuildConfigApi.isDebug() && interfaceC1115Qe != null) {
            String str = A00(24, 31, 72) + interfaceC1115Qe.A5m();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1117Qg
    public final void AAX(Exception exc) {
        if (BuildConfigApi.isDebug()) {
            Log.e(C0940Je.A00(), A00(0, 24, 60), exc);
        }
    }
}
