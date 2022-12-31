package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ui  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1223Ui implements HR {
    public static byte[] A07;
    public static String[] A08 = {"XY5JZk6rXZ0NPH7SICFbrzLAUaQN4bdH", "HnCNMjQ424yFS", "kyBc0", "GnRsDPDWJf0qkzwG5UAakx0LVXBsKD8t", "8DLCIs9NQKYqN", "T4UYq1MMo7qynT2Sse3Gz88uK5Ayy8ub", "yyLccmqAJUyLoqB1F9xK1icYlgZtX35P", "UgvPXgEXHuOjKzkqR3R9kUCYtrFgRRdg"};
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public FileInputStream A03;
    public boolean A04;
    public final ContentResolver A05;
    @Nullable
    public final InterfaceC0898Hm<? super C1223Ui> A06;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 116);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-38, 6, 12, 3, -5, -73, 5, 6, 11, -73, 6, 7, -4, 5, -73, -3, 0, 3, -4, -73, -5, -4, 10, -6, 9, 0, 7, 11, 6, 9, -73, -3, 6, 9, -47, -73, -14};
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hm != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.ContentDataSource> */
    public C1223Ui(Context context, @Nullable InterfaceC0898Hm<? super C1223Ui> interfaceC0898Hm) {
        this.A05 = context.getContentResolver();
        this.A06 = interfaceC0898Hm;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final Uri A7d() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final long ACf(HV hv) throws HN {
        try {
            this.A02 = hv.A04;
            this.A01 = this.A05.openAssetFileDescriptor(this.A02, A00(36, 1, 12));
            if (this.A01 != null) {
                this.A03 = new FileInputStream(this.A01.getFileDescriptor());
                long startOffset = this.A01.getStartOffset();
                long skip = this.A03.skip(hv.A03 + startOffset) - startOffset;
                long skipped = hv.A03;
                int i2 = (skip > skipped ? 1 : (skip == skipped ? 0 : -1));
                String[] strArr = A08;
                if (strArr[1].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                A08[2] = "hKUpJ";
                if (i2 == 0) {
                    long assetFileDescriptorLength = -1;
                    if (hv.A02 != -1) {
                        long skipped2 = hv.A02;
                        this.A00 = skipped2;
                    } else {
                        long length = this.A01.getLength();
                        if (length == -1) {
                            FileChannel channel = this.A03.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                long channelSize = channel.position();
                                assetFileDescriptorLength = size - channelSize;
                            }
                            this.A00 = assetFileDescriptorLength;
                        } else {
                            this.A00 = length - skip;
                        }
                    }
                    this.A04 = true;
                    InterfaceC0898Hm<? super C1223Ui> interfaceC0898Hm = this.A06;
                    if (interfaceC0898Hm != null) {
                        interfaceC0898Hm.ACK(this, hv);
                    }
                    return this.A00;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException(A00(0, 36, 35) + this.A02);
        } catch (IOException e2) {
            throw new HN(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final void close() throws HN {
        int length;
        int i2;
        this.A02 = null;
        try {
            try {
                if (this.A03 != null) {
                    this.A03.close();
                }
                this.A03 = null;
            } catch (Throwable th) {
                this.A03 = null;
                try {
                    try {
                        if (this.A01 != null) {
                            this.A01.close();
                        }
                        this.A01 = null;
                    } catch (IOException e2) {
                        throw new HN(e2);
                    }
                } finally {
                    if (length == i2) {
                    }
                    throw new RuntimeException();
                }
                if (this.A04) {
                    this.A04 = false;
                    String[] strArr = A08;
                    if (strArr[6].charAt(21) != strArr[3].charAt(21)) {
                        String[] strArr2 = A08;
                        strArr2[5] = "49IvJFCSRSvhrewf7IAXf1OPFzRU50IL";
                        strArr2[0] = "4e2AtDz0XDbCK0xcLVm9895RacU2kPwa";
                        InterfaceC0898Hm<? super C1223Ui> interfaceC0898Hm = this.A06;
                        if (interfaceC0898Hm != null) {
                            interfaceC0898Hm.ACJ(this);
                        }
                    }
                    throw new RuntimeException();
                }
                throw th;
            }
            try {
                try {
                    if (this.A01 != null) {
                        this.A01.close();
                    }
                } catch (IOException e3) {
                    throw new HN(e3);
                }
            } finally {
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    InterfaceC0898Hm<? super C1223Ui> interfaceC0898Hm2 = this.A06;
                    if (interfaceC0898Hm2 != null) {
                        interfaceC0898Hm2.ACJ(this);
                    }
                }
            }
        } catch (IOException e4) {
            throw new HN(e4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HR
    public final int read(byte[] bArr, int i2, int i3) throws HN {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.A00;
        if (A08[7].charAt(11) != 'j') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[1] = "ibErvL6ImcJTe";
        strArr[4] = "i4reTFCBluewh";
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, i3);
            } catch (IOException e2) {
                throw new HN(e2);
            }
        }
        int read = this.A03.read(bArr, i2, i3);
        if (read == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new HN(new EOFException());
        }
        long j3 = this.A00;
        if (j3 != -1) {
            this.A00 = j3 - read;
        }
        InterfaceC0898Hm<? super C1223Ui> interfaceC0898Hm = this.A06;
        if (interfaceC0898Hm != null) {
            interfaceC0898Hm.AA4(this, read);
        }
        return read;
    }
}
