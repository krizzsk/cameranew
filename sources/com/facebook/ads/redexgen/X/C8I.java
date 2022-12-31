package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.8I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8I {
    public static final AtomicReference<XS> A00 = new AtomicReference<>();

    @Nullable
    public static XS A00() {
        return A00.get();
    }

    public static void A01(XS xs) {
        if (xs == null) {
            return;
        }
        A00.compareAndSet(null, xs);
    }
}
