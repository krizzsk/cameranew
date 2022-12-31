package com.facebook.ads.redexgen.X;

import java.lang.ref.WeakReference;
/* loaded from: assets/audience_network.dex */
public abstract class TI<T> extends AbstractRunnableC0981Kv {
    public final WeakReference<T> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TI != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public TI(T t) {
        this.A00 = new WeakReference<>(t);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.TI != com.facebook.ads.internal.util.common.WeakRunnable<T> */
    public final T A07() {
        return this.A00.get();
    }
}
