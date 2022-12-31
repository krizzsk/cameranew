package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.telephony.TelephonyManager;
/* loaded from: assets/audience_network.dex */
public class Y5 implements InterfaceC06356k {
    public static String[] A01 = {"fhgAKr3d26sPe206xi", "SjffeijJA1Vv6PcXWUgct", "EsQusZwl1jUwipz2lU1dtOeOynoqp4qu", "0VpWGFYwNM1shdn7oayU", "oGsU7X9gn8B3aKKKnK6Um4C", "3PuUzv37NfYax6hYz8jf", "w27NqvUy0J9VzwNZKDXUsnO8qh2oDxhJ", "FZXbTPmbge4RvKyxAzubgHD8Txvy8Otv"};
    public final /* synthetic */ C1312Xw A00;

    public Y5(C1312Xw c1312Xw) {
        this.A00 = c1312Xw;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() {
        TelephonyManager telephonyManager;
        TelephonyManager telephonyManager2;
        TelephonyManager telephonyManager3;
        TelephonyManager telephonyManager4;
        telephonyManager = this.A00.A00;
        if (telephonyManager == null) {
            AbstractC06506z A07 = this.A00.A07(EnumC06466v.A07);
            if (A01[6].charAt(19) != 'U') {
                throw new RuntimeException();
            }
            A01[6] = "mdGsZgeczhjsROxHbS4UhtOI0ggMdB2A";
            return A07;
        } else if (Build.VERSION.SDK_INT >= 24) {
            C1312Xw c1312Xw = this.A00;
            telephonyManager4 = c1312Xw.A00;
            String[] strArr = A01;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[1] = "gYbGBXsMnQLVbPxH35aVX";
            strArr2[4] = "c9uQZVFrEkdSbUXAtWNBNx9";
            return c1312Xw.A04(telephonyManager4.getDataNetworkType());
        } else {
            C1312Xw c1312Xw2 = this.A00;
            String[] strArr3 = A01;
            if (strArr3[2].length() != strArr3[0].length()) {
                A01[6] = "dEMR1C0fCLJEsmN6YStUhJGVUagFQ5EF";
                telephonyManager3 = c1312Xw2.A00;
                return c1312Xw2.A04(telephonyManager3.getNetworkType());
            }
            A01[7] = "IeVVB4pQAR4pX23W54Z95CGRKG6wHZI8";
            telephonyManager2 = c1312Xw2.A00;
            return c1312Xw2.A04(telephonyManager2.getNetworkType());
        }
    }
}
