package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ua  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1215Ua implements HR {
    public static byte[] A05;
    public static String[] A06 = {"l2rBvT9KAEY6yl2SIp", "0cRN39km0cT", "q9WvQr", "pX7zul93kCJ6F7tIXqRnEpKrjeNmhaPh", "ddKujtHDPllkfb3cyYepVcXFvJyDikdo", "gNoa3Z", "AdKzyhJyCrP", "aoyUT4m5l2MLf3LhSWprSpj54sdxW1uC"};
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;
    @Nullable
    public final InterfaceC0898Hm<? super C1215Ua> A04;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 31);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{37};
    }

    static {
        A01();
    }

    public C1215Ua() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.FileDataSource> */
    public C1215Ua(@Nullable InterfaceC0898Hm<? super C1215Ua> interfaceC0898Hm) {
        this.A04 = interfaceC0898Hm;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final Uri A7d() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV hv) throws HY {
        try {
            this.A01 = hv.A04;
            this.A02 = new RandomAccessFile(hv.A04.getPath(), A00(0, 1, 72));
            this.A02.seek(hv.A03);
            this.A00 = hv.A02 == -1 ? this.A02.length() - hv.A03 : hv.A02;
            if (this.A00 >= 0) {
                this.A03 = true;
                InterfaceC0898Hm<? super C1215Ua> interfaceC0898Hm = this.A04;
                if (interfaceC0898Hm != null) {
                    interfaceC0898Hm.ACK(this, hv);
                }
                long j2 = this.A00;
                if (A06[0].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[7] = "qz0up6ppIELboyns2CZBgMvSr8RDOOhA";
                strArr[3] = "iQKzkqELqDYakLKWZdfSUnFo9DHl6nVv";
                return j2;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new HY(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws HY {
        this.A01 = null;
        try {
            try {
                if (this.A02 != null) {
                    this.A02.close();
                }
            } catch (IOException e2) {
                throw new HY(e2);
            }
        } finally {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                InterfaceC0898Hm<? super C1215Ua> interfaceC0898Hm = this.A04;
                if (interfaceC0898Hm != null) {
                    interfaceC0898Hm.ACJ(this);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws HY {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.A00;
        if (j2 == 0) {
            return -1;
        }
        try {
            int read = this.A02.read(bArr, i2, (int) Math.min(j2, i3));
            if (read > 0) {
                this.A00 -= read;
                InterfaceC0898Hm<? super C1215Ua> interfaceC0898Hm = this.A04;
                if (interfaceC0898Hm != null) {
                    interfaceC0898Hm.AA4(this, read);
                }
            }
            return read;
        } catch (IOException e2) {
            throw new HY(e2);
        }
    }
}
