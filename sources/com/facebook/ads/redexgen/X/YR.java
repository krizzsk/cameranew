package com.facebook.ads.redexgen.X;

import android.content.pm.ActivityInfo;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class YR implements InterfaceC06356k {
    public static byte[] A01;
    public final /* synthetic */ YQ A00;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 81);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{Byte.MIN_VALUE, -28, -29, -43, -68, -57};
    }

    public YR(YQ yq) {
        this.A00 = yq;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06356k
    public final AbstractC06506z A5G() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ActivityInfo[] activityInfoArr;
        ActivityInfo[] activityInfoArr2;
        ActivityInfo[] activityInfoArr3;
        ActivityInfo[] activityInfoArr4;
        activityInfoArr = this.A00.A04;
        if (activityInfoArr != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                activityInfoArr2 = this.A00.A04;
                int i3 = activityInfoArr2.length;
                if (i2 < i3) {
                    activityInfoArr3 = this.A00.A04;
                    sb.append(activityInfoArr3[i2].name);
                    activityInfoArr4 = this.A00.A04;
                    int i4 = activityInfoArr4.length;
                    if (i2 != i4 - 1) {
                        sb.append(A00(0, 1, 37));
                    }
                    i2++;
                } else {
                    AbstractC06506z signalValueTypeDef = this.A00.A08(AnonymousClass78.A08(sb.toString().getBytes(A00(1, 5, 62)), AnonymousClass77.A06));
                    return signalValueTypeDef;
                }
            }
        } else {
            return this.A00.A07(EnumC06466v.A07);
        }
    }
}
