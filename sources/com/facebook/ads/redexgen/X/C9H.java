package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.9H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9H {
    public static C9H A00 = new C9H();

    public static C9H A00() {
        return A00;
    }

    @SuppressLint({"InstanceMethodCanBeStatic"})
    public final C9G A01(C8J c8j, boolean z) {
        return new X0(c8j, z, new C06205v());
    }

    @SuppressLint({"CatchGeneralException"})
    public final Map<String, String> A02(C8J c8j) {
        try {
            return A01(c8j, false).A6S();
        } catch (Throwable th) {
            c8j.A06().A3P(th);
            return C9D.A01(c8j);
        }
    }
}
