package com.facebook.ads.redexgen.X;

import java.nio.ByteBuffer;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Bb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC0746Bb extends WX<C0745Ba, BX, GM> implements InterfaceC1240Uz {
    public static byte[] A01;
    public final String A00;

    static {
        A0J();
    }

    public static String A0I(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 125);
        }
        return new String(copyOfRange);
    }

    public static void A0J() {
        A01 = new byte[]{63, 88, 79, 98, 90, 79, 77, 94, 79, 78, 10, 78, 79, 77, 89, 78, 79, 10, 79, 92, 92, 89, 92};
    }

    public abstract GL A0b(byte[] bArr, int i2, boolean z) throws GM;

    public AbstractC0746Bb(String str) {
        super(new C0745Ba[2], new BX[2]);
        this.A00 = str;
        A0Y(1024);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.WX
    /* renamed from: A0E */
    public final GM A0W(C0745Ba c0745Ba, BX bx, boolean z) {
        try {
            ByteBuffer byteBuffer = c0745Ba.A01;
            bx.A09(((WZ) c0745Ba).A00, A0b(byteBuffer.array(), byteBuffer.limit(), z), c0745Ba.A00);
            bx.A01(Integer.MIN_VALUE);
            return null;
        } catch (GM e2) {
            return e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.WX
    /* renamed from: A0F */
    public final GM A0X(Throwable th) {
        return new GM(A0I(0, 23, 109), th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.WX
    /* renamed from: A0G */
    public final C0745Ba A0T() {
        return new C0745Ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.WX
    /* renamed from: A0H */
    public final BX A0V() {
        return new BX(this) { // from class: com.facebook.ads.redexgen.X.2x
            public final AbstractC0746Bb A00;

            {
                this.A00 = this;
            }

            @Override // com.facebook.ads.redexgen.X.BX
            public final void A08() {
                this.A00.A0a(this);
            }
        };
    }

    @Override // com.facebook.ads.redexgen.X.WX
    /* renamed from: A0c */
    public final void A0a(BX bx) {
        super.A0a(bx);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1240Uz
    public final void AEU(long j2) {
    }
}
