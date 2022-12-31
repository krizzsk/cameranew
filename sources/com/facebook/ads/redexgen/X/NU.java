package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: assets/audience_network.dex */
public class NU implements View.OnClickListener {
    public static byte[] A02;
    public final /* synthetic */ XT A00;
    public final /* synthetic */ NW A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 66);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 20, 33, 23, 37, 34, 28, 23, -31, 28, 33, 39, 24, 33, 39, -31, 20, 22, 39, 28, 34, 33, -31, 9, -4, -8, 10};
    }

    public NU(NW nw, XT xt) {
        this.A01 = nw;
        this.A00 = xt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        String str2;
        String str3;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            str = this.A01.A06;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String A00 = A00(0, 11, 35);
            str2 = this.A01.A06;
            if (!A00.equals(str2)) {
                String A002 = A00(11, 26, 113);
                str3 = this.A01.A06;
                Intent intent = new Intent(A002, Uri.parse(str3));
                intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                this.A00.A0D().A82();
                L9.A0B(this.A00, intent);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
