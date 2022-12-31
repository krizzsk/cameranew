package com.facebook.ads.redexgen.X;

import android.os.Handler;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ee  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class RunnableC0816Ee implements Runnable {
    public static byte[] A01;
    public final /* synthetic */ C0825En A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-73, -39, -22, -33, -27, -28, -106, -36, -33, -30, -37, -106, -30, -27, -41, -38, -33, -28, -35, -106, -36, -41, -33, -30, -37, -38, -92, -66, -23, -15, -24, -26, -23, -37, -34, -57, -37, -24, -37, -31, -33, -20};
    }

    public RunnableC0816Ee(C0825En c0825En) {
        this.A00 = c0825En;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ET et;
        DownloadAction.Deserializer[] deserializerArr;
        Handler handler;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            et = this.A00.A09;
            deserializerArr = this.A00.A0E;
            DownloadAction[] A03 = et.A03(deserializerArr);
            handler = this.A00.A07;
            handler.post(new RunnableC0815Ed(this, A03));
        }
    }
}
