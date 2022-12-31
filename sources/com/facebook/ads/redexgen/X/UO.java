package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: assets/audience_network.dex */
public final class UO implements HP {
    public static String[] A0B = {"w20bAWjYMNQBWlbon1lxwLvvC2Wc6aDw", "lwUY3oAzCyDGvzazHVXOHQ3zY7kbNweW", "UaweMkDBVxVyODuJAIk0oAizBiXulMgw", "HCwWhWYnSwS9lU8hovQ66gM", "BSrpyguVpFJpaQafc1NdT7mO3uIgLmFW", "PMiNqiQ4kgs0VWuHsJy6tm47yNuoSJAG", "LFxM2Smyc2PeWHZihlec1nFmzNKIeMAJ", "CwFpegEhQfdxfTMnj3Ot7m2"};
    public long A00;
    public long A01;
    public HV A02;
    public C0914Ic A03;
    public File A04;
    public FileOutputStream A05;
    public OutputStream A06;
    public final int A07;
    public final long A08;
    public final InterfaceC0902Hq A09;
    public final boolean A0A;

    public UO(InterfaceC0902Hq interfaceC0902Hq, long j2) {
        this(interfaceC0902Hq, j2, 20480, true);
    }

    public UO(InterfaceC0902Hq interfaceC0902Hq, long j2, int i2, boolean z) {
        this.A09 = (InterfaceC0902Hq) I6.A01(interfaceC0902Hq);
        this.A08 = j2;
        this.A07 = i2;
        this.A0A = z;
    }

    private void A00() throws IOException {
        OutputStream outputStream = this.A06;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            boolean success = this.A0A;
            if (success) {
                this.A05.getFD().sync();
            }
            C0923Il.A0X(this.A06);
            this.A06 = null;
            File file = this.A04;
            this.A04 = null;
            if (1 != 0) {
                this.A09.A42(file);
            } else {
                file.delete();
            }
        } catch (Throwable th) {
            C0923Il.A0X(this.A06);
            this.A06 = null;
            File file2 = this.A04;
            this.A04 = null;
            if (0 != 0) {
                this.A09.A42(file2);
            } else {
                file2.delete();
            }
            throw th;
        }
    }

    private void A01() throws IOException {
        long min;
        if (this.A02.A02 == -1) {
            min = this.A08;
        } else {
            long j2 = this.A02.A02;
            long maxLength = this.A00;
            long j3 = j2 - maxLength;
            long maxLength2 = this.A08;
            min = Math.min(j3, maxLength2);
        }
        InterfaceC0902Hq interfaceC0902Hq = this.A09;
        String str = this.A02.A05;
        long maxLength3 = this.A02.A01;
        this.A04 = interfaceC0902Hq.AEl(str, this.A00 + maxLength3, min);
        this.A05 = new FileOutputStream(this.A04);
        int i2 = this.A07;
        if (i2 > 0) {
            C0914Ic c0914Ic = this.A03;
            if (c0914Ic == null) {
                this.A03 = new C0914Ic(this.A05, i2);
            } else {
                c0914Ic.A00(this.A05);
            }
            this.A06 = this.A03;
        } else {
            this.A06 = this.A05;
        }
        this.A01 = 0L;
    }

    @Override // com.facebook.ads.redexgen.X.HP
    public final void ACh(HV hv) throws UP {
        if (hv.A02 == -1 && !hv.A02(2)) {
            this.A02 = null;
            return;
        }
        this.A02 = hv;
        this.A00 = 0L;
        try {
            A01();
        } catch (IOException e2) {
            throw new UP(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HP
    public final void close() throws UP {
        if (this.A02 == null) {
            return;
        }
        try {
            A00();
        } catch (IOException e2) {
            throw new UP(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HP
    public final void write(byte[] bArr, int bytesToWrite, int i2) throws UP {
        if (this.A02 == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                int i4 = (this.A01 > this.A08 ? 1 : (this.A01 == this.A08 ? 0 : -1));
                if (A0B[0].charAt(30) != 'D') {
                    throw new RuntimeException();
                }
                A0B[6] = "jgYsfafqQwydOQ8BdugE0IR3OVOgVMqo";
                if (i4 == 0) {
                    A00();
                    A01();
                }
                int min = (int) Math.min(i2 - i3, this.A08 - this.A01);
                this.A06.write(bArr, bytesToWrite + i3, min);
                i3 += min;
                this.A01 += min;
                this.A00 += min;
            } catch (IOException e2) {
                throw new UP(e2);
            }
        }
    }
}
