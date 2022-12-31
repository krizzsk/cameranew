package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.6L  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6L {
    public final AnonymousClass61 A00;
    public final Map<Integer, C06326h> A01;
    public final AtomicBoolean A02 = new AtomicBoolean();

    public C6L(AnonymousClass61 anonymousClass61, Map<Integer, C06326h> map) {
        this.A00 = anonymousClass61;
        this.A01 = map;
        this.A02.compareAndSet(false, true);
    }

    private int A00(int i2) {
        if (this.A00.A0e(i2) != null) {
            return this.A00.A0e(i2).intValue();
        }
        return this.A00.A0R();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.66 != com.facebook.ads.internal.botdetection.interval.buffer.CircularBuffer<com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef> */
    private synchronized void A01(AbstractC06506z abstractC06506z, C06326h c06326h) {
        int A00 = c06326h.A00();
        Map<Integer, AnonymousClass66<AbstractC06506z>> A03 = C06376m.A01().A03();
        if (A03.containsKey(Integer.valueOf(A00))) {
            AnonymousClass66<AbstractC06506z> anonymousClass66 = A03.get(Integer.valueOf(A00));
            AbstractC06506z A02 = anonymousClass66 != null ? anonymousClass66.A02() : null;
            if (anonymousClass66 == null) {
                anonymousClass66 = new AnonymousClass66<>(A00(A00));
            }
            if (!abstractC06506z.A0B(A02, c06326h.A03())) {
                anonymousClass66.A04(abstractC06506z);
                C06376m.A01().A04(A00, anonymousClass66, abstractC06506z.A05());
            }
        } else {
            AnonymousClass66<AbstractC06506z> anonymousClass662 = new AnonymousClass66<>(A00(A00));
            anonymousClass662.A04(abstractC06506z);
            C06376m.A01().A04(A00, anonymousClass662, abstractC06506z.A05());
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public final void A02(AbstractC06506z abstractC06506z, C6K c6k) {
        if (!this.A02.get()) {
            return;
        }
        try {
            switch (c6k) {
                case A0E:
                    C06326h c06326h = this.A01.get(10800);
                    if (abstractC06506z != null && c06326h != null) {
                        A01(abstractC06506z, c06326h);
                        break;
                    } else {
                        return;
                    }
                case A03:
                    C06326h c06326h2 = this.A01.get(10810);
                    if (abstractC06506z != null && c06326h2 != null) {
                        A01(abstractC06506z, c06326h2);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A09:
                    C06326h c06326h3 = this.A01.get(10812);
                    if (abstractC06506z != null && c06326h3 != null) {
                        A01(abstractC06506z, c06326h3);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A06:
                    C06326h c06326h4 = this.A01.get(10813);
                    if (abstractC06506z != null && c06326h4 != null) {
                        A01(abstractC06506z, c06326h4);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A0A:
                    C06326h c06326h5 = this.A01.get(10814);
                    if (abstractC06506z != null && c06326h5 != null) {
                        A01(abstractC06506z, c06326h5);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A0B:
                    C06326h c06326h6 = this.A01.get(10815);
                    if (abstractC06506z != null && c06326h6 != null) {
                        A01(abstractC06506z, c06326h6);
                        break;
                    } else {
                        return;
                    }
                case A0D:
                    C06326h c06326h7 = this.A01.get(10816);
                    if (abstractC06506z != null && c06326h7 != null) {
                        A01(abstractC06506z, c06326h7);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A08:
                    C06326h c06326h8 = this.A01.get(10817);
                    if (abstractC06506z != null && c06326h8 != null) {
                        A01(abstractC06506z, c06326h8);
                        break;
                    } else {
                        return;
                    }
                case A05:
                    C06326h c06326h9 = this.A01.get(10818);
                    if (abstractC06506z != null && c06326h9 != null) {
                        A01(abstractC06506z, c06326h9);
                        break;
                    } else {
                        return;
                    }
                    break;
                case A04:
                    C06326h c06326h10 = this.A01.get(10819);
                    if (abstractC06506z != null && c06326h10 != null) {
                        A01(abstractC06506z, c06326h10);
                        break;
                    } else {
                        return;
                    }
                case A0C:
                    C06326h c06326h11 = this.A01.get(10820);
                    if (abstractC06506z != null && c06326h11 != null) {
                        A01(abstractC06506z, c06326h11);
                        break;
                    } else {
                        return;
                    }
                    break;
            }
        } catch (Throwable th) {
            C6D.A03(th);
        }
    }
}
