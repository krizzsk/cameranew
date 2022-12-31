package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class UQ implements HR {
    public static String[] A04 = {"jlvJAgNeHWnJa3dPhRRd4EpOWMdB4X8x", "basxIWwUdkqjCj33WkHPX1XLcRlnz9UL", "EJ8jlkQXjQdwyr2PvL7NnSmrIKvSoKH9", "vRfpY4dXxgFvSAkqLCYO6SFKljAHuCzv", "ygfsCaK9ODNV1JdDOAbtF6as7T2mwjea", "kZYhIpAIarjEuyurYojB34Vr8jYSU6r4", "j4JmDL8bElApoe2AoNbHhKsqdvNkVwQT", "xpYPLrN7DnWMQWubBysNzF9"};
    public long A00;
    public boolean A01;
    public final HP A02;
    public final HR A03;

    public UQ(HR hr, HP hp) {
        this.A03 = (HR) I6.A01(hr);
        this.A02 = (HP) I6.A01(hp);
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final Uri A7d() {
        return this.A03.A7d();
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV dataSpec) throws IOException {
        this.A00 = this.A03.ACf(dataSpec);
        if (this.A00 == 0) {
            return 0L;
        }
        int i2 = (dataSpec.A02 > (-1L) ? 1 : (dataSpec.A02 == (-1L) ? 0 : -1));
        if (A04[4].charAt(25) != 'd') {
            A04[4] = "5eBqCtKJCfmd3joSOHW3VJl5u39JA8K8";
            if (i2 == 0 && this.A00 != -1) {
                dataSpec = new HV(dataSpec.A04, dataSpec.A01, dataSpec.A03, this.A00, dataSpec.A05, dataSpec.A00);
            }
            this.A01 = true;
            this.A02.ACh(dataSpec);
            return this.A00;
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws IOException {
        try {
            this.A03.close();
        } finally {
            if (this.A01) {
                this.A01 = false;
                this.A02.close();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.A00 == 0) {
            return -1;
        }
        int read = this.A03.read(bArr, i2, i3);
        if (read > 0) {
            this.A02.write(bArr, i2, read);
            long j2 = this.A00;
            if (j2 != -1) {
                long j3 = read;
                if (A04[2].charAt(20) == 'R') {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[0] = "pjLm1ZauVMrHAqpQAI7gN0n14eRh7O52";
                strArr[5] = "T96N4GskjcbGLsEcsrwL44bvdnkYKV6X";
                this.A00 = j2 - j3;
            }
        }
        return read;
    }
}
