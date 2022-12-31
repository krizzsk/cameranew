package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.content.Context;
/* renamed from: com.facebook.ads.redexgen.X.59  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass59 {
    public static C0R A00(Context context, C8L c8l) {
        XS sdkContext = A07(context);
        C0U A6e = c8l.A6e(sdkContext);
        if (A6e != null) {
            return A6e.A9J();
        }
        return new C1555dA();
    }

    public static XT A01(Activity activity) {
        return new XT(activity, A08(), A00(activity, A08()));
    }

    public static XT A02(Context context) {
        return new XT(context, A08(), new C1555dA());
    }

    public static XT A03(Context context) {
        return new XT(context, A08(), A00(context, A08()));
    }

    public static XT A04(Context context) {
        if (JD.A0o(context)) {
            return new XT(context, A08(), A00(context, A08()));
        }
        return A02(context);
    }

    public static XT A05(Context context) {
        return new XT(context, A08(), A00(context, A08()));
    }

    public static C0803Dr A06(Context context) {
        return new C0803Dr(context, A08(), A08().A6e(A07(context)));
    }

    public static XS A07(Context context) {
        return new XS(context, A08());
    }

    public static synchronized C8L A08() {
        X3 A02;
        synchronized (AnonymousClass59.class) {
            A02 = X3.A02();
        }
        return A02;
    }
}
