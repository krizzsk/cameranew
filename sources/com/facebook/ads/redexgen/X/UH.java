package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class UH implements IM {
    public static String[] A05 = {"JbcDsPAiqgb9rsViVRKehTXv1iFS9Alt", "AfEyeuF2jCfkWNmIQlP22Iq9vQ5XDBZo", "cIPTiq2qkEqnYzKxb3sH3HOJO6VigB4N", "bIuwftDwBGArWYVN2grLSP1kPnHfbgfq", "1GGMxn0jatOJtlepcpEnLiyqpa0L6Zpp", "dBndgbsmlMbgteIClih73P1Nf1skDdlq", "kMZcBPwOEd1j6nxu2sFbdi5kLjNzhQnH", "M7tzCbQcNsxxyZ9EacAqZIMXmH340eiG"};
    public long A00;
    public long A01;
    public AU A02 = AU.A04;
    public boolean A03;
    public final I9 A04;

    public UH(I9 i9) {
        this.A04 = i9;
    }

    public final void A00() {
        if (!this.A03) {
            this.A00 = this.A04.A55();
            this.A03 = true;
        }
    }

    public final void A01() {
        if (this.A03) {
            long A7B = A7B();
            if (A05[0].charAt(9) == 'F') {
                throw new RuntimeException();
            }
            A05[0] = "yV0nDN2yEP24GlsqsYFBRUnmoDIsFkRQ";
            A02(A7B);
            this.A03 = false;
        }
    }

    public final void A02(long j2) {
        this.A01 = j2;
        if (this.A03) {
            this.A00 = this.A04.A55();
        }
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU A78() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final long A7B() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long A55 = this.A04.A55();
            if (A05[0].charAt(9) != 'F') {
                A05[1] = "ixlqsHFDPmeKY4bwdkSegalU4BLtdIOn";
                long j2 = A55 - this.A00;
                if (this.A02.A01 == 1.0f) {
                    long A00 = A3.A00(j2);
                    if (A05[3].charAt(4) != 'j') {
                        A05[0] = "AIwpqv7aDt0R5Z0o8sSBDj22LkfdUh0v";
                        return elapsedSinceBaseMs + A00;
                    }
                    A05[0] = "vgrMGSSY4L8ja71DPmzZRGyrcWnnIJj3";
                    return elapsedSinceBaseMs + A00;
                }
                return elapsedSinceBaseMs + this.A02.A00(j2);
            }
            throw new RuntimeException();
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.facebook.ads.redexgen.X.IM
    public final AU AET(AU au) {
        if (this.A03) {
            A02(A7B());
        }
        this.A02 = au;
        return au;
    }
}
