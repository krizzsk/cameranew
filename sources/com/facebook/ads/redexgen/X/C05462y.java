package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2y  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05462y extends AbstractC0791Df implements Handler.Callback {
    public static String[] A0B = {"03Bqi0KbTszfVpZRuJU3ds8C", "k1GP5ixeRS7AgIgDUeTgx", "4NCpljRKbMpI7nrSCbEL8iNDtCMdRKX", "14neR4MzrfGB8mqjKcaUOPf9qenZk", "2yEqk33zpOnAOPOYE0N2JJzqUjZjGZ3w", "pyvhSQAAYlr5mafzJ0Hik2RvaYh4S", "eoJA2AjfdFBVMgfGYGogvo8ECKzj9gDa", "xUrUxSkwRZIOD3qEvYK8t45D"};
    public int A00;
    public int A01;
    public E3 A02;
    public boolean A03;
    public final Handler A04;
    public final AM A05;
    public final E5 A06;
    public final C0775Cp A07;
    public final E6 A08;
    public final long[] A09;
    public final Metadata[] A0A;

    public C05462y(E6 e6, Looper looper) {
        this(e6, looper, E5.A00);
    }

    public C05462y(E6 e6, Looper looper, E5 e5) {
        super(4);
        this.A08 = (E6) I6.A01(e6);
        this.A04 = looper == null ? null : new Handler(looper, this);
        this.A06 = (E5) I6.A01(e5);
        this.A05 = new AM();
        this.A07 = new C0775Cp();
        this.A0A = new Metadata[5];
        this.A09 = new long[5];
    }

    private void A00() {
        Arrays.fill(this.A0A, (Object) null);
        this.A01 = 0;
        this.A00 = 0;
    }

    private void A01(Metadata metadata) {
        Handler handler = this.A04;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            A02(metadata);
        }
    }

    private void A02(Metadata metadata) {
        this.A08.ABJ(metadata);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A12() {
        A00();
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A15(long j2, boolean z) {
        A00();
        this.A03 = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A17(Format[] formatArr, long j2) throws A9 {
        this.A02 = this.A06.A4D(formatArr[0]);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8J() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8U() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final void ADf(long j2, long j3) throws A9 {
        if (!this.A03 && this.A00 < 5) {
            this.A07.A07();
            if (A10(this.A05, this.A07, false) == -4) {
                if (this.A07.A04()) {
                    this.A03 = true;
                } else if (!this.A07.A03()) {
                    C0775Cp c0775Cp = this.A07;
                    String[] strArr = A0B;
                    if (strArr[0].length() != strArr[7].length()) {
                        String[] strArr2 = A0B;
                        strArr2[6] = "oJNy7wvRq4TsnN4Ik7JOHneCelTjV3TM";
                        strArr2[4] = "4f5lGS7X1G5JYf6Usji5tJWLoKljCGYJ";
                        c0775Cp.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    } else {
                        String[] strArr3 = A0B;
                        strArr3[0] = "JrbxqibW71vJtGIxmKNzu0gc";
                        strArr3[7] = "aBslXCcOqyoFcXReLJb0k0eg";
                        c0775Cp.A00 = this.A05.A00.A0G;
                        this.A07.A08();
                    }
                    try {
                        int i2 = (this.A01 + this.A00) % 5;
                        this.A0A[i2] = this.A02.A4f(this.A07);
                        this.A09[i2] = ((WZ) this.A07).A00;
                        this.A00++;
                    } catch (E4 e2) {
                        throw A9.A01(e2, A0y());
                    }
                }
            }
        }
        int i3 = this.A00;
        String[] strArr4 = A0B;
        if (strArr4[0].length() != strArr4[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr5 = A0B;
        strArr5[2] = "FI5ou6JhGKfNQASG6lr2Dh53KdKmMJ1";
        strArr5[1] = "8nK6Ac79BLzTFAHCrRK9v";
        if (i3 > 0) {
            long[] jArr = this.A09;
            int i4 = this.A01;
            if (jArr[i4] <= j2) {
                A01(this.A0A[i4]);
                Metadata[] metadataArr = this.A0A;
                int i5 = this.A01;
                metadataArr[i5] = null;
                this.A01 = (i5 + 1) % 5;
                this.A00--;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0727Ah
    public final int AEv(Format format) {
        if (this.A06.AEw(format)) {
            return AbstractC0791Df.A0x(null, format.A0H) ? 4 : 2;
        }
        return 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A02((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
