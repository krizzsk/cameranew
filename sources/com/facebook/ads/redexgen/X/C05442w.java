package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.location.LocationRequestCompat;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Collections;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.2w  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05442w extends AbstractC0791Df implements Handler.Callback {
    public static String[] A0D = {"fagSsoac43UJSJG", "PL0Df5XObPsMjoFT3sU6Lp83XbviyP8R", "k75ap2fxOZvkqr2FjEQ9d3Y", "qEZm9kPptvCV49j1bDgJYwonF92a", "8QH8MqTnW7KMzd9bL", "CjrIcpNXno9M2QOeMZvTD2WdktHrPs5P", "AfT76Pf2kDJi2th", "sZbuEqgSWLt9Albo4x4yfDH"};
    public int A00;
    public int A01;
    public Format A02;
    public InterfaceC1240Uz A03;
    public C0745Ba A04;
    public BX A05;
    public BX A06;
    public boolean A07;
    public boolean A08;
    public final Handler A09;
    public final AM A0A;
    public final GN A0B;
    public final GO A0C;

    public C05442w(GO go, Looper looper) {
        this(go, looper, GN.A00);
    }

    public C05442w(GO go, Looper looper, GN gn) {
        super(3);
        this.A0C = (GO) I6.A01(go);
        this.A09 = looper == null ? null : new Handler(looper, this);
        this.A0B = gn;
        this.A0A = new AM();
    }

    private long A00() {
        int i2 = this.A01;
        if (i2 == -1 || i2 >= this.A06.A6Y()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return this.A06.A6X(this.A01);
    }

    private void A01() {
        A06(Collections.emptyList());
    }

    private void A02() {
        this.A04 = null;
        this.A01 = -1;
        BX bx = this.A06;
        if (bx != null) {
            bx.A08();
            this.A06 = null;
        }
        BX bx2 = this.A05;
        if (bx2 != null) {
            bx2.A08();
            this.A05 = null;
        }
    }

    private void A03() {
        A02();
        this.A03.ADS();
        this.A03 = null;
        this.A00 = 0;
    }

    private void A04() {
        A03();
        this.A03 = this.A0B.A4E(this.A02);
    }

    private void A05(List<GK> list) {
        this.A0C.AAG(list);
    }

    private void A06(List<GK> list) {
        Handler handler = this.A09;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            A05(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A12() {
        this.A02 = null;
        A01();
        A03();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A15(long j2, boolean z) {
        A01();
        this.A07 = false;
        this.A08 = false;
        if (this.A00 != 0) {
            A04();
            return;
        }
        A02();
        InterfaceC1240Uz interfaceC1240Uz = this.A03;
        String[] strArr = A0D;
        if (strArr[2].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A0D[1] = "SIdEizz9oP1X0InrrFd2Zym6xF4ie8Hi";
        interfaceC1240Uz.flush();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC0791Df
    public final void A17(Format[] formatArr, long j2) throws A9 {
        this.A02 = formatArr[0];
        if (this.A03 != null) {
            this.A00 = 1;
        } else {
            this.A03 = this.A0B.A4E(this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8J() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    public final boolean A8U() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r6 == 2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0099, code lost:
        A04();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b8, code lost:
        if (r6 == 2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bb, code lost:
        A02();
        r9.A08 = true;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1277Wn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ADf(long r10, long r12) throws com.facebook.ads.redexgen.X.A9 {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C05442w.ADf(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0727Ah
    public final int AEv(Format format) {
        if (this.A0B.AEw(format)) {
            return AbstractC0791Df.A0x(null, format.A0H) ? 4 : 2;
        } else if (IO.A0A(format.A0O)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 0) {
            A05((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }
}
