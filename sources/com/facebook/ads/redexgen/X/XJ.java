package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
@SuppressLint({"DeprecatedMethod"})
/* loaded from: assets/audience_network.dex */
public final class XJ implements InterfaceC06798l {
    public final C8J A00;

    public XJ(C8J c8j) {
        this.A00 = c8j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A3P(Throwable th) {
        C8g.A0E(th);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A87(String str) {
        C0940Je.A08(this.A00, str);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A8q(String str, int i2, C06818n c06818n) {
        C8g.A06(this.A00, str, i2, c06818n);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A8r(String str, int i2, C06818n c06818n) {
        C8g.A06(this.A00, str, i2, c06818n);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A8z(long j2, long j3, long j4, long j5, int i2, @Nullable Exception exc) {
        C06858r.A03(this.A00, j2, j3, j4, j5, i2, exc);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A98(String str, int i2, C06818n c06818n) {
        C8g.A07(this.A00, str, i2, c06818n);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A9G(String str, int i2, C06818n c06818n) {
        C8g.A08(this.A00, str, i2, c06818n);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC06798l
    public final void A9M() {
        DynamicLoaderFactory.makeLoader(this.A00).getInitApi().maybeAttachCrashListener(this.A00);
    }
}
