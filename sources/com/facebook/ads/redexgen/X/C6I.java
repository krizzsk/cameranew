package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.6I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6I {
    public final List<C6S> A00 = new ArrayList();

    public final void A00() {
        for (C6S biometricSignalLifecycleHandler : this.A00) {
            biometricSignalLifecycleHandler.ACo();
        }
    }

    public final void A01(C6S c6s) {
        this.A00.add(c6s);
    }
}
