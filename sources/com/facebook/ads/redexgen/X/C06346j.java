package com.facebook.ads.redexgen.X;

import android.os.Build;
/* renamed from: com.facebook.ads.redexgen.X.6j  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06346j<T> {
    public final int A00;
    public final int A01;
    public final T A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6j != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public C06346j(T bundledSignalMetadataKey, int i2, int i3) {
        this.A02 = bundledSignalMetadataKey;
        this.A00 = i2;
        this.A01 = i3;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6j != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    private boolean A00() {
        int i2;
        int i3 = this.A00;
        return i3 > 0 && i3 < 9999 && (i2 = this.A01) > 0 && i2 < 10000 && i3 < i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6j != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public final T A01() {
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6j != com.facebook.ads.internal.botdetection.signals.model.BundledSignalMetadata<T> */
    public final boolean A02() {
        return A00() && Build.VERSION.SDK_INT >= this.A00 && Build.VERSION.SDK_INT < this.A01;
    }
}
