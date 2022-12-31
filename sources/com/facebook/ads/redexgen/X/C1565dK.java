package com.facebook.ads.redexgen.X;

import java.io.ByteArrayInputStream;
/* renamed from: com.facebook.ads.redexgen.X.dK  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1565dK implements C0K {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C1565dK(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void ACg(int i2) throws C1564dJ {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip(i2);
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void close() throws C1564dJ {
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int length() throws C1564dJ {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int read(byte[] bArr) throws C1564dJ {
        return this.A00.read(bArr, 0, bArr.length);
    }
}
