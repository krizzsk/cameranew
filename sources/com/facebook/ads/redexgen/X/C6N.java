package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.SystemClock;
import android.view.OrientationEventListener;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.6N  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6N {
    @Nullable
    public static OrientationEventListener A02;
    public static String[] A03 = {"ciYSwpO57ig7", "AgXvWM7vBAP276b3F", "h3L2uX2266ICJ0F8mxeOzYeo", "sn1Bi96p4g3FJ3lBwfTgs4qOj566", "nEyUaJreiz", "9f6cxckTFidZYnVMHRSclm", "9nbfinSPxnf3N791gNAhDrqxfgbV", "EACetWGUN5dpVn0xkHaZeeKDOZ"};
    public final C6L A00;
    public final EnumC06396o A01;

    public C6N(C6L c6l, EnumC06396o enumC06396o) {
        this.A00 = c6l;
        this.A01 = enumC06396o;
    }

    public final synchronized void A01() {
        if (A02 != null) {
            A02.disable();
            A02 = null;
        }
    }

    public final synchronized void A02(final Context context) {
        final C06486x c06486x;
        if (A02 != null) {
            String[] strArr = A03;
            if (strArr[7].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "WLHhaS1yyOUNNZKQvAoQ3Zw3xj";
            strArr2[1] = "prMYx6h4YCDadOhBb";
            return;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        String packageName = context == null ? "" : context.getPackageName();
        if (this.A01 == EnumC06396o.A0G) {
            c06486x = null;
        } else {
            c06486x = new C06486x(packageName);
        }
        A02 = new OrientationEventListener(context, 3) { // from class: com.facebook.ads.redexgen.X.6M
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i2) {
                C6L c6l;
                C1295Xf c1295Xf = new C1295Xf(elapsedRealtime, c06486x, i2);
                c6l = C6N.this.A00;
                c6l.A02(c1295Xf, C6K.A0A);
            }
        };
        A02.enable();
    }
}
