package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: assets/audience_network.dex */
public final class VB implements InterfaceC0829Er {
    public static String[] A06 = {"0vmpU1QtAhI6qjIdcVId", "klBv", "qKjW3ego541fEYihs", "NuBFx4EY8fIgWeMvZ", "vAKBh2R", "FoB4J1nu", "9b5WU1uKCw6g3SYcMdOb", "twQXN8Z"};
    public final HV A00;
    public final InterfaceC0902Hq A01;
    public final UN A02;
    public final IZ A04;
    public final C0907Hv A03 = new C0907Hv();
    public final AtomicBoolean A05 = new AtomicBoolean();

    public VB(Uri uri, String str, C0830Es c0830Es) {
        this.A00 = new HV(uri, 0L, -1L, str, 0);
        this.A01 = c0830Es.A00();
        this.A02 = c0830Es.A01(false);
        this.A04 = c0830Es.A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0829Er
    public final void A4r() throws InterruptedException, IOException {
        this.A04.A00(-1000);
        try {
            C0908Hw.A03(this.A00, this.A01, this.A02, new byte[131072], this.A04, -1000, this.A03, this.A05, true);
            IZ iz = this.A04;
            String[] strArr = A06;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "qX3fQQGAY3dTsBjdyBPn";
            strArr2[6] = "Z0TFAaYyqvVnxMY9deNw";
            iz.A03(-1000);
        } catch (Throwable th) {
            this.A04.A03(-1000);
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0829Er
    public final float A6L() {
        long j2 = this.A03.A01;
        if (j2 == -1) {
            return -1.0f;
        }
        return (((float) this.A03.A00()) * 100.0f) / ((float) j2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0829Er
    public final long A6M() {
        return this.A03.A00();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0829Er
    public final void cancel() {
        this.A05.set(true);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0829Er
    public final void remove() {
        C0908Hw.A05(this.A01, C0908Hw.A02(this.A00));
    }
}
