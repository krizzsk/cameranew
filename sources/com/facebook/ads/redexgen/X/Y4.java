package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y4 implements InterfaceC06356k {
    public static String[] A01 = {"YvgwWocx1FADdeAzbpsmJqKucTKVrLw8", "IN5yo6alVzQxSBDS0LSAMVLc9G2MRZFn", "HAZTu6IPNZsD1qj0M1i9utr9DJx5S0QZ", "N5cGJfQ0ESKW2WKzc5hPaTPWXOaKWBwf", "tNMXMhxZjOCLmtsXwerOChNpJkA4NIz8", "qe3nCZLHllYVPimtyVQbZz0eRg0vYsPF", "hksQgw", "nUQ4NN4k5WyfvhfMBfttwidjpDAXB5K7"};
    public final /* synthetic */ C1312Xw A00;

    public Y4(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        TelephonyManager telephonyManager3;
        telephonyManager = this.A00.A00;
        if (telephonyManager == null) {
            return this.A00.A07(EnumC06466v.A07);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            C1312Xw c1312Xw = this.A00;
            telephonyManager3 = c1312Xw.A00;
            return c1312Xw.A04(telephonyManager3.getVoiceNetworkType());
        }
        C1312Xw c1312Xw2 = this.A00;
        telephonyManager2 = c1312Xw2.A00;
        if (A01[2].charAt(0) != 'L') {
            A01[1] = "ynGeEoYIomGmDWEGPoJ89qRpE67tUZnz";
            return c1312Xw2.A04(telephonyManager2.getNetworkType());
        }
        throw new RuntimeException();
    }
}
