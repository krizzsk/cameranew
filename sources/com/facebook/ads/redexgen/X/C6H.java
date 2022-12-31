package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.6H  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C6H {
    @Nullable
    public static C6H A07;
    public static String[] A08 = {"lhELmGRUtbYPcwJFNCjn5HfCntRtzqQU", "Mt1hbHTlPicMeG4rtX3JBcBhsjGdj", "WXTUL6dhKmyeG13MmR9X1nSF3ta0T4v7", "pnvqG2PyjZWupJIeMnGxGNF5M9wfPV2M", "tVIu8wQwIUzvrLJUsX9QEkuDOevngDVu", "qDTAVfu3jvCTQwnOSiE3SjcB7mVx4hBM", "klm6aBATY902pfwdRKxrpHOkJcym9ne5", "D4wxrsR0ab6WquJuKpvZlDWLQMdeNXqb"};
    public static final AtomicBoolean A09 = new AtomicBoolean();
    public C6G A00 = new C6G(this, AnonymousClass75.A00().A03().getLooper());
    public C6Q A01;
    public C6R A02;
    public List<C6U> A03;
    public final Context A04;
    public final AnonymousClass61 A05;
    public final EnumC06396o A06;

    public C6H(AnonymousClass61 anonymousClass61, Context context) {
        this.A05 = anonymousClass61;
        this.A04 = context;
        this.A06 = anonymousClass61.A0a();
    }

    public static synchronized C6H A00(Context context, AnonymousClass61 anonymousClass61) {
        C6H c6h;
        synchronized (C6H.class) {
            if (A07 == null) {
                A07 = new C6H(anonymousClass61, context);
            }
            c6h = A07;
        }
        return c6h;
    }

    private synchronized void A02() {
        A09.set(false);
        this.A03 = new ArrayList();
        String[] strArr = A08;
        if (strArr[2].charAt(18) != strArr[4].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "OJ9tJzFQNQxQ8qaEQfi4ar7y8Z5YVilt";
        strArr2[1] = "oKX4c494QlidqOlhH9QFYLNn1ihcq";
    }

    public final synchronized void A03() {
        if (this.A01 != null) {
            this.A01.A03(this.A03);
        }
        A02();
    }

    public final synchronized void A04(Map<Integer, C06326h> map, EnumC06366l enumC06366l) {
        A02();
        C6L c6l = new C6L(this.A05, map);
        for (Map.Entry<Integer, C06326h> entry : map.entrySet()) {
            C06326h value = entry.getValue();
            if (value != null && value.A04(enumC06366l)) {
                int intValue = entry.getKey().intValue();
                if (intValue != 10800) {
                    switch (intValue) {
                        case 10810:
                            this.A03.add(C6U.A04);
                            continue;
                        case 10811:
                            this.A03.add(C6U.A08);
                            continue;
                        case 10812:
                            this.A03.add(C6U.A0A);
                            continue;
                        case 10813:
                            this.A03.add(C6U.A07);
                            continue;
                        case 10814:
                            this.A03.add(C6U.A0B);
                            continue;
                        case 10815:
                            this.A03.add(C6U.A0C);
                            continue;
                        case 10816:
                            this.A03.add(C6U.A0E);
                            continue;
                        case 10817:
                            this.A03.add(C6U.A09);
                            continue;
                        case 10818:
                            this.A03.add(C6U.A06);
                            continue;
                        case 10819:
                            this.A03.add(C6U.A05);
                            continue;
                        case 10820:
                            this.A03.add(C6U.A0D);
                            continue;
                        default:
                            continue;
                    }
                } else {
                    this.A02 = new C6R(this.A04, c6l, this.A06);
                    A09.set(true);
                }
            }
        }
        this.A01 = new C6Q(this.A04, c6l, this.A06);
        this.A01.A02(this.A03);
        if (!this.A00.getLooper().getThread().isAlive()) {
            this.A00 = new C6G(this, AnonymousClass75.A00().A03().getLooper());
        }
    }

    public final synchronized boolean A05(MotionEvent motionEvent) {
        if (!A09.get()) {
            return false;
        }
        Message message = new Message();
        message.what = C6F.A03.ordinal();
        message.obj = motionEvent;
        this.A00.sendMessage(message);
        return true;
    }
}
