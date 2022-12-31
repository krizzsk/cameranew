package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class V7 implements InterfaceC0890He {
    public static String[] A0C = {"nBGgOhUJr5w54zk2FcSY", "YYZuUd", "gwBohD1o6c6DfEcFdJm47xfjaEoVukk3", "3TNnSL", "hJWvKqQqk09hkKqv49F3L8Ilz7Jhye22", "G8FOHrMAxxSNQBngbaVWxtAhYQnldn5N", "v6FRbmkBAKb4FwdIpHjrHHJWg4k1tULi", "7hirQzfzNIRD79h7knAyc8"};
    public long A00;
    public long A02;
    public HV A03;
    public final Uri A05;
    public final FH A07;
    public final HR A08;
    public final IC A09;
    public volatile boolean A0A;
    public final /* synthetic */ C0755Bk A0B;
    public final CW A06 = new CW();
    public boolean A04 = true;
    public long A01 = -1;

    public V7(C0755Bk c0755Bk, Uri uri, HR hr, FH fh, IC ic) {
        this.A0B = c0755Bk;
        this.A05 = (Uri) I6.A01(uri);
        this.A08 = (HR) I6.A01(hr);
        this.A07 = (FH) I6.A01(fh);
        this.A09 = ic;
    }

    public final void A04(long j2, long j3) {
        this.A06.A00 = j2;
        this.A02 = j3;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0890He
    public final void A3w() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0890He
    public final void A8d() throws IOException, InterruptedException {
        int i2 = 0;
        while (i2 == 0) {
            boolean z = this.A0A;
            if (A0C[0].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "6lKOSY";
            strArr[1] = "aO7eUD";
            if (!z) {
                CQ cq = null;
                try {
                    long j2 = this.A06.A00;
                    this.A03 = new HV(this.A05, j2, -1L, C0755Bk.A08(this.A0B));
                    this.A01 = this.A08.ACf(this.A03);
                    if (this.A01 != -1) {
                        this.A01 += j2;
                    }
                    WR wr = new WR(this.A08, j2, this.A01);
                    CP A02 = this.A07.A02(wr, this.A08.A7d());
                    if (this.A04) {
                        A02.AE9(j2, this.A02);
                        this.A04 = false;
                    }
                    while (i2 == 0 && !this.A0A) {
                        this.A09.A00();
                        i2 = A02.ADD(wr, this.A06);
                        if (wr.A79() > C0755Bk.A03(this.A0B) + j2) {
                            j2 = wr.A79();
                            this.A09.A01();
                            C0755Bk.A04(this.A0B).post(C0755Bk.A06(this.A0B));
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else {
                        this.A06.A00 = wr.A79();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    C0923Il.A0W(this.A08);
                } catch (Throwable th) {
                    if (i2 != 1 && 0 != 0) {
                        this.A06.A00 = cq.A79();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    C0923Il.A0W(this.A08);
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
