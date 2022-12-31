package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: assets/audience_network.dex */
public final class US implements HR {
    public final int A00;
    public final HR A01;
    public final IZ A02;

    public US(HR hr, IZ iz, int i2) {
        this.A01 = (HR) I6.A01(hr);
        this.A02 = (IZ) I6.A01(iz);
        this.A00 = i2;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    @Nullable
    public final Uri A7d() {
        return this.A01.A7d();
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV hv) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ACf(hv);
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i2, i3);
    }
}
