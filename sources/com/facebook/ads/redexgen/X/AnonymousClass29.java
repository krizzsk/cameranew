package com.facebook.ads.redexgen.X;

import java.io.Serializable;
/* renamed from: com.facebook.ads.redexgen.X.29  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass29 implements Serializable {
    public AnonymousClass28 A00;
    public AnonymousClass28 A01;

    public AnonymousClass29() {
        this(0.5d, 0.5d);
    }

    public AnonymousClass29(double d2) {
        this(d2, 0.5d);
    }

    public AnonymousClass29(double d2, double d3) {
        this.A00 = new AnonymousClass28(d2);
        this.A01 = new AnonymousClass28(d3);
        A02();
    }

    public final AnonymousClass28 A00() {
        return this.A00;
    }

    public final AnonymousClass28 A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A06();
        this.A01.A06();
    }

    public final void A03() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A04(double d2, double d3) {
        this.A00.A08(d2, d3);
    }

    public final void A05(double d2, double d3) {
        this.A01.A08(d2, d3);
    }
}
