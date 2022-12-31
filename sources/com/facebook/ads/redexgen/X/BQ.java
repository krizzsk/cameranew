package com.facebook.ads.redexgen.X;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
/* loaded from: assets/audience_network.dex */
public abstract class BQ implements InterfaceC1240Uz {
    public static String[] A06 = {"xrToQ1M30eypgaiDt2KcbeXQSJmH4zEy", "FOMm0GJvPogulFgRKU73d9QQGInBRxBZ", "DAifx7fz7Oznb", "tEspMkbIuGZVzgapMfnbK02RMeMH6P5b", "hnmT", "jbKY175w2AZdEkpyONR9SNFucMTvW6Vd", "vt70xpgsPpIXmuxmiV", "wsDuhCL"};
    public long A00;
    public long A01;
    public C05412t A02;
    public final ArrayDeque<C05412t> A03 = new ArrayDeque<>();
    public final ArrayDeque<BX> A04;
    public final PriorityQueue<C05412t> A05;

    public abstract GL A0L();

    public abstract void A0P(C0745Ba c0745Ba);

    public abstract boolean A0R();

    public BQ() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.A03.add(new C05412t());
        }
        this.A04 = new ArrayDeque<>();
        for (int i3 = 0; i3 < 2; i3++) {
            this.A04.add(new C05402s(this));
        }
        this.A05 = new PriorityQueue<>();
    }

    private void A0K(C05412t c05412t) {
        c05412t.A07();
        this.A03.add(c05412t);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0M */
    public C0745Ba A4i() throws GM {
        I6.A04(this.A02 == null);
        if (this.A03.isEmpty()) {
            return null;
        }
        this.A02 = this.A03.pollFirst();
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0N */
    public BX A4j() throws GM {
        if (this.A04.isEmpty()) {
            return null;
        }
        while (!this.A05.isEmpty() && ((WZ) this.A05.peek()).A00 <= this.A00) {
            C05412t poll = this.A05.poll();
            if (poll.A04()) {
                BX pollFirst = this.A04.pollFirst();
                pollFirst.A00(4);
                if (A06[6].length() != 18) {
                    throw new RuntimeException();
                }
                A06[4] = "hAEA";
                A0K(poll);
                return pollFirst;
            }
            A0P(poll);
            if (A0R()) {
                GL A0L = A0L();
                if (!poll.A03()) {
                    BX pollFirst2 = this.A04.pollFirst();
                    pollFirst2.A09(((WZ) poll).A00, A0L, LocationRequestCompat.PASSIVE_INTERVAL);
                    A0K(poll);
                    return pollFirst2;
                }
            }
            A0K(poll);
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    /* renamed from: A0O */
    public void ADC(C0745Ba c0745Ba) throws GM {
        I6.A03(c0745Ba == this.A02);
        if (c0745Ba.A03()) {
            C05412t c05412t = this.A02;
            String[] strArr = A06;
            if (strArr[5].charAt(10) != strArr[3].charAt(10)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[5] = "0mhI93daunZi59PwiuGO0KbLyKVCPwQH";
            strArr2[3] = "r2E3xZENv7Zr1SQt92aJBQoSxSc5nrbU";
            A0K(c05412t);
        } else {
            C05412t c05412t2 = this.A02;
            long j2 = this.A01;
            this.A01 = 1 + j2;
            c05412t2.A00 = j2;
            this.A05.add(this.A02);
        }
        this.A02 = null;
    }

    public final void A0Q(BX bx) {
        bx.A07();
        this.A04.add(bx);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    public void ADS() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1240Uz
    public void AEU(long j2) {
        this.A00 = j2;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0753Bi
    public void flush() {
        this.A01 = 0L;
        this.A00 = 0L;
        while (!this.A05.isEmpty()) {
            A0K(this.A05.poll());
        }
        C05412t c05412t = this.A02;
        if (c05412t != null) {
            A0K(c05412t);
            this.A02 = null;
        }
    }
}
