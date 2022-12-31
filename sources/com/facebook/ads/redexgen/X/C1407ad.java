package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* renamed from: com.facebook.ads.redexgen.X.ad  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1407ad implements AnonymousClass63 {
    public static String[] A06 = {"9Omy7cax2OJ4", "ulOhDbnf", "JfFg1yjSSK9TQh7N867q1b7oOj16BTWR", "cs88erT1Nmdhof2Vlv4YHjmvLJ5hV6oE", "codoSKf0AAHHcDxXKaV5ItDp", "Lc71QfpBcjqOx3z6Bpry4MoTnJ3L2Amk", "Bxh30V7DNH8aSp9XNgBHezc1nItbXmG0", "iIuCBEGs"};
    public EnumC06366l A00;
    public AnonymousClass79 A01;
    public C7A A02;
    public final AnonymousClass61 A03;
    public final C6W A04;
    public final AtomicBoolean A05 = new AtomicBoolean();

    public C1407ad(AnonymousClass61 anonymousClass61, C6W c6w) {
        this.A03 = anonymousClass61;
        this.A04 = c6w;
    }

    private final synchronized void A04() {
        if (this.A02 != null && this.A05.get()) {
            this.A01.A01(this.A02);
            AnonymousClass75.A00().A04();
            this.A04.A02();
            this.A05.compareAndSet(true, false);
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.facebook.ads.redexgen.X.7A] */
    public final synchronized void A05(final EnumC06366l enumC06366l) {
        if (this.A05.get() || enumC06366l == null) {
            return;
        }
        if (this.A03.A0k() && AnonymousClass78.A0E(enumC06366l)) {
            this.A01 = new AnonymousClass79(AnonymousClass75.A00().A03().getLooper());
            this.A00 = enumC06366l;
            final Runnable runnable = new Runnable(enumC06366l) { // from class: com.facebook.ads.redexgen.X.65
                public EnumC06366l A00;

                {
                    this.A00 = enumC06366l;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C6W c6w;
                    AnonymousClass79 anonymousClass79;
                    C7A c7a;
                    AnonymousClass61 anonymousClass61;
                    if (C0974Kn.A02(this)) {
                        return;
                    }
                    try {
                        c6w = C1407ad.this.A04;
                        c6w.A04(EnumC06386n.A03, this.A00, null);
                        anonymousClass79 = C1407ad.this.A01;
                        c7a = C1407ad.this.A02;
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        anonymousClass61 = C1407ad.this.A03;
                        anonymousClass79.A02(c7a, timeUnit.toMillis(anonymousClass61.A0T()));
                    } catch (Throwable th) {
                        C0974Kn.A00(th, this);
                    }
                }
            };
            this.A02 = new Runnable(runnable) { // from class: com.facebook.ads.redexgen.X.7A
                public static String[] A01 = {"z7DaAYMF8mD5H3Qw6B0df8iWMA5TwaAo", "i1Wz58ppkDzwzyk3vUo3iJD7WEPTUBrQ", "4oPzuaqB78YGGa8PxFst9tbpOvboFZdU", "DouWW69VsyGxi7cZQAT3hM5mkvCiYUWz", "5sMQ3NVw4qAuaNcVNLKcvGJPjeyRgc94", "cawbZ6x1RsnaWkC6S2Mb4x7gKiXWIBBw", "BT64P8yXTg3gcHo3v2kn4U06ifDkl76a", "4iKgaC96n3YCvkeVNFuu4kvW5LMIVzNy"};
                public final Runnable A00;

                {
                    this.A00 = runnable;
                }

                @Override // java.lang.Runnable
                @SuppressLint({"CatchGeneralException"})
                public final void run() {
                    if (C0974Kn.A02(this)) {
                        return;
                    }
                    try {
                        this.A00.run();
                    } catch (Throwable t) {
                        try {
                            C6D.A03(t);
                        } catch (Throwable th) {
                            if (A01[0].charAt(29) != 'a') {
                                Throwable t2 = new RuntimeException();
                                throw t2;
                            }
                            A01[0] = "SMPhcSCea3djEKnuzKFzvQw1eCBqlauj";
                            C0974Kn.A00(th, this);
                        }
                    }
                }
            };
            this.A04.A03(enumC06366l);
            this.A01.A00(this.A02);
            this.A05.compareAndSet(false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass63
    public final synchronized void AF9(EnumC06366l enumC06366l) {
        if (this.A00 == enumC06366l) {
            return;
        }
        this.A00 = enumC06366l;
        if (enumC06366l == EnumC06366l.A04) {
            A04();
        } else {
            A05(enumC06366l);
        }
        String[] strArr = A06;
        if (strArr[5].charAt(25) != strArr[3].charAt(25)) {
            throw new RuntimeException();
        }
        A06[6] = "6KXzTJPK6a3Rx51uMQDwScazunOB6mre";
    }
}
