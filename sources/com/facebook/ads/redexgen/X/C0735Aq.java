package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Aq  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0735Aq {
    public static String[] A06 = {"KiEP2P9b6TLdkEYwaN5ndNVtk9NQ5Y9p", "yrQkoPMIPCp0FUw5bDslSTdDJuyK", "OV0qCkDU4pR0s48LAW0LoXOWDo4ZunO9", "CNzCLbPvty9jTQMUswZxpqZWQtb7JEv9", "Vf", "ol3MR5ayifXszMqJK7WjfrE4Lr8bJhi8", "Hh8EscwfVF04VFT3j4sJSJqD2SmetI3K", "DN3PdRai96zSFxDytd4qNigxYecPuw8S"};
    public C0736Ar A01;
    public C0736Ar A02;
    public boolean A03;
    public final ArrayList<C0736Ar> A05 = new ArrayList<>();
    public final C0731Am A04 = new C0731Am();
    public AbstractC0733Ao A00 = AbstractC0733Ao.A01;

    private C0736Ar A00(C0736Ar c0736Ar, AbstractC0733Ao abstractC0733Ao) {
        if (abstractC0733Ao.A0E() || this.A00.A0E()) {
            return c0736Ar;
        }
        int A04 = abstractC0733Ao.A04(this.A00.A0A(c0736Ar.A01.A02, this.A04, true).A03);
        if (A04 == -1) {
            return c0736Ar;
        }
        return new C0736Ar(abstractC0733Ao.A09(A04, this.A04).A00, c0736Ar.A01.A00(A04));
    }

    private void A02() {
        if (!this.A05.isEmpty()) {
            this.A01 = this.A05.get(0);
        }
    }

    @Nullable
    public final C0736Ar A03() {
        return this.A01;
    }

    @Nullable
    public final C0736Ar A04() {
        if (this.A05.isEmpty()) {
            return null;
        }
        ArrayList<C0736Ar> arrayList = this.A05;
        return arrayList.get(arrayList.size() - 1);
    }

    @Nullable
    public final C0736Ar A05() {
        if (this.A05.isEmpty() || this.A00.A0E() || this.A03) {
            return null;
        }
        return this.A05.get(0);
    }

    @Nullable
    public final C0736Ar A06() {
        return this.A02;
    }

    @Nullable
    public final FL A07(int timelinePeriodCount) {
        FL fl = null;
        AbstractC0733Ao abstractC0733Ao = this.A00;
        if (abstractC0733Ao != null) {
            int periodIndex = abstractC0733Ao.A00();
            for (int i2 = 0; i2 < this.A05.size(); i2++) {
                C0736Ar c0736Ar = this.A05.get(i2);
                int i3 = c0736Ar.A01.A02;
                if (i3 < periodIndex && this.A00.A09(i3, this.A04).A00 == timelinePeriodCount) {
                    if (fl != null) {
                        return null;
                    }
                    fl = c0736Ar.A01;
                }
            }
        }
        return fl;
    }

    public final void A08() {
        this.A03 = false;
        A02();
    }

    public final void A09() {
        this.A03 = true;
    }

    public final void A0A(int i2) {
        A02();
    }

    public final void A0B(int i2, FL fl) {
        this.A05.add(new C0736Ar(i2, fl));
        if (this.A05.size() == 1) {
            boolean A0E = this.A00.A0E();
            if (A06[0].charAt(21) == 'U') {
                throw new RuntimeException();
            }
            A06[0] = "SFS5Xb2c2LrmqtbhPrHYALinOi1MehvJ";
            if (!A0E) {
                A02();
            }
        }
    }

    public final void A0C(int i2, FL fl) {
        C0736Ar c0736Ar = new C0736Ar(i2, fl);
        this.A05.remove(c0736Ar);
        if (!c0736Ar.equals(this.A02)) {
            return;
        }
        this.A02 = this.A05.isEmpty() ? null : this.A05.get(0);
    }

    public final void A0D(int i2, FL fl) {
        this.A02 = new C0736Ar(i2, fl);
    }

    public final void A0E(AbstractC0733Ao abstractC0733Ao) {
        for (int i2 = 0; i2 < this.A05.size(); i2++) {
            ArrayList<C0736Ar> arrayList = this.A05;
            arrayList.set(i2, A00(arrayList.get(i2), abstractC0733Ao));
        }
        C0736Ar c0736Ar = this.A02;
        if (A06[0].charAt(21) == 'U') {
            throw new RuntimeException();
        }
        A06[1] = "OE27bQwCbSc4SHZoCTNTYydrCDTv";
        if (c0736Ar != null) {
            this.A02 = A00(c0736Ar, abstractC0733Ao);
        }
        this.A00 = abstractC0733Ao;
        A02();
    }

    public final boolean A0F() {
        return this.A03;
    }
}
