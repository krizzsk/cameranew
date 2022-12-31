package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.ag  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1410ag implements C6C {
    public static String[] A02 = {"iWDBF2OKl3jtj3mE0UZLtkhUaVvUxXqs", "ms2LCEwCyzsqM8QDDj0PRev1P1CSm3w7", "hMtVrOKQMF9h", "gi6PEiuAAOhVuZEccjIoIAk9XYc1uF", "R32JKWcbl7Qu2cyp2LhmQehQDOktlipk", "kBJUlLOX6LAUVPMDIzawXbz3hNZwTKWy", "5r9f7V6KCkM3IvysTdnytDlDBRDUQAcw", "vGzO7SO4CN32udhBb2qyIGFDHHv1hOkX"};
    public final C1408ae A00;
    public final XS A01;

    public C1410ag(XS xs) {
        this.A01 = xs;
        this.A00 = new C1408ae(xs);
    }

    public final C1408ae A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.C6C
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final void ADj(Throwable th) {
        if (th == null || C06235y.A00(this.A01) >= Math.random()) {
            return;
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        C1408ae c1408ae = this.A00;
        String A022 = AnonymousClass67.A04.A02();
        String A023 = AnonymousClass68.A06.A02();
        HashMap hashMap = new HashMap();
        String message = th.getMessage();
        if (stringWriter2 != null) {
            int length = stringWriter2.length();
            if (A02[1].charAt(16) != 'D') {
                throw new RuntimeException();
            }
            A02[5] = "Ct83iaSYEVOHUGfDQtOJkAbKybUxEBTx";
            if (length > 500) {
                stringWriter2 = stringWriter2.substring(0, 500);
            }
        }
        c1408ae.A91(A022, A023, hashMap, null, message, stringWriter2, th.getClass().getSimpleName());
    }
}
