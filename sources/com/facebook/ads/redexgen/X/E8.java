package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaViewVideoRenderer;
/* loaded from: assets/audience_network.dex */
public class E8 extends M3 {
    public static String[] A01 = {"LKWkJLHWeQBpKWa7UOr", "n3GVMd2hYWvpJPgcK7G8gwhDICX0QRvF", "xWguot5bGbOrngmksJGOGVnUcrOeX8Yq", "Ofa75S47Yg9dCpk5kJ8", "1S7QAm0fWcEMmp0r33MjAmGaqGODAsQ1", "zqFnCLlNx7sTkxdlo9MHaJoU5FTNnDPM", "mLEAh1LmjQI6neJU4JsNwDaurLCI0CwU", "tuKdoZnhl5Xw"};
    public final /* synthetic */ C5E A00;

    public E8(C5E c5e) {
        this.A00 = c5e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.C9P
    /* renamed from: A00 */
    public final void A03(C1017Mh c1017Mh) {
        MediaViewVideoRenderer mediaViewVideoRenderer;
        if (this.A00.A08 != null) {
            C1198Tj.A0J(this.A00.A08.getInternalNativeAd()).A1a(false, true);
        }
        mediaViewVideoRenderer = this.A00.A00;
        mediaViewVideoRenderer.onError();
        String[] strArr = A01;
        if (strArr[6].charAt(12) != strArr[2].charAt(12)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "vYhRUt1P8SC0fadBpCg";
        strArr2[3] = "IJBm98yQ9J9eGhRKk2w";
    }
}
