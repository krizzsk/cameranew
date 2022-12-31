package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: assets/audience_network.dex */
public final class DT implements Handler.Callback, V4, HF, FM, A6, InterfaceC0723Ad {
    public static byte[] A0V;
    public static String[] A0W = {"86glHvEVsTHsOarjgO3yrK", "TuAJpp7uzbfmMtpdLTRiZnKK78MiZtWb", "2J1ujHTPZohQZteX1j6kCS7zhajZ8mZI", "eCxkC7v7XtRVNueTNXvbthBaIEqCwNNl", "l3Yyub2xLFiYeWCCac", "TG0XkoHYQCfebcNj4J", "6SVWI1Jvh0Z3jrcRBB9hLc8AjjQAtTry", "lVbeqNrXIfO7zu9EZv7JtI"};
    public int A00;
    public int A01;
    public int A02;
    public long A03;
    public AI A04;
    public AT A05;
    public FN A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public InterfaceC1277Wn[] A0C;
    public final long A0D;
    public final Handler A0E;
    public final HandlerThread A0F;
    public final C1280Wq A0G;
    public final InterfaceC1278Wo A0H;
    public final AO A0J;
    public final C0731Am A0L;
    public final C0732An A0M;
    public final HG A0N;
    public final HH A0O;
    public final I9 A0P;
    public final IJ A0Q;
    public final ArrayList<AG> A0R;
    public final boolean A0S;
    public final InterfaceC1277Wn[] A0T;
    public final InterfaceC0727Ah[] A0U;
    public final AR A0K = new AR();
    public C0730Ak A06 = C0730Ak.A03;
    public final AH A0I = new AH(null);

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0V, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 98);
        }
        return new String(copyOfRange);
    }

    public static void A0K() {
        A0V = new byte[]{40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 40, 21, 2, 61, 1, 12, 20, 8, 31, 36, 0, 29, 1, 36, 3, 25, 8, 31, 3, 12, 1, 87, 37, 12, 3, 9, 1, 8, 31, 25, 55, 62, 63, 34, 57, 62, 55, 112, 61, 53, 35, 35, 49, 55, 53, 35, 112, 35, 53, 62, 36, 112, 49, 54, 36, 53, 34, 112, 34, 53, 60, 53, 49, 35, 53, 126, 71, 96, 122, 107, 124, 96, 111, 98, 46, 124, 123, 96, 122, 103, 99, 107, 46, 107, 124, 124, 97, 124, 32, 50, 14, 3, 27, 0, 3, 1, 9, 66, 7, 16, 16, Draft_75.CR, 16, 76, 102, 90, 64, 71, 86, 80, 21, 80, 71, 71, 90, 71, 27, 74, 109, 118, 105, 57, Byte.MAX_VALUE, 120, 112, 117, 124, 125, 55, 119, 124, 64, 124, 126, 118, 68, 124, 97, 120};
    }

    static {
        A0K();
    }

    public DT(InterfaceC1277Wn[] interfaceC1277WnArr, HG hg, HH hh, AO ao, boolean z, int i2, boolean z2, Handler handler, InterfaceC1278Wo interfaceC1278Wo, I9 i9) {
        this.A0T = interfaceC1277WnArr;
        this.A0N = hg;
        this.A0O = hh;
        this.A0J = ao;
        this.A08 = z;
        this.A02 = i2;
        this.A0B = z2;
        this.A0E = handler;
        this.A0H = interfaceC1278Wo;
        this.A0P = i9;
        this.A0D = ao.A5j();
        this.A0S = ao.ADt();
        this.A05 = new AT(AbstractC0733Ao.A01, -9223372036854775807L, TrackGroupArray.A04, hh);
        this.A0U = new InterfaceC0727Ah[interfaceC1277WnArr.length];
        for (int i3 = 0; i3 < interfaceC1277WnArr.length; i3++) {
            interfaceC1277WnArr[i3].AEN(i3);
            this.A0U[i3] = interfaceC1277WnArr[i3].A5u();
        }
        this.A0G = new C1280Wq(this, i9);
        this.A0R = new ArrayList<>();
        this.A0C = new InterfaceC1277Wn[0];
        this.A0M = new C0732An();
        this.A0L = new C0731Am();
        hg.A00(this);
        this.A0F = new HandlerThread(A06(21, 29, 15), -16);
        this.A0F.start();
        this.A0Q = i9.A4H(this.A0F.getLooper(), this);
    }

    private int A00() {
        AbstractC0733Ao abstractC0733Ao = this.A05.A03;
        if (abstractC0733Ao.A0E()) {
            return 0;
        }
        return abstractC0733Ao.A0B(abstractC0733Ao.A05(this.A0B), this.A0M).A00;
    }

    private int A01(int i2, AbstractC0733Ao abstractC0733Ao, AbstractC0733Ao abstractC0733Ao2) {
        int maxIterations = i2;
        int i3 = -1;
        int A00 = abstractC0733Ao.A00();
        for (int i4 = 0; i4 < A00 && i3 == -1; i4++) {
            maxIterations = abstractC0733Ao.A03(maxIterations, this.A0L, this.A0M, this.A02, this.A0B);
            if (maxIterations == -1) {
                break;
            }
            i3 = abstractC0733Ao2.A04(abstractC0733Ao.A0A(maxIterations, this.A0L, true).A03);
        }
        return i3;
    }

    private long A02(FL fl, long j2) throws A9 {
        return A03(fl, j2, this.A0K.A0G() != this.A0K.A0H());
    }

    private long A03(FL fl, long j2, boolean z) throws A9 {
        A0H();
        this.A09 = false;
        A0N(2);
        AP A0G = this.A0K.A0G();
        AP newPlayingPeriodHolder = A0G;
        while (true) {
            if (newPlayingPeriodHolder == null) {
                break;
            } else if (A0t(fl, j2, newPlayingPeriodHolder)) {
                this.A0K.A0S(newPlayingPeriodHolder);
                break;
            } else {
                newPlayingPeriodHolder = this.A0K.A0C();
            }
        }
        if (A0G != newPlayingPeriodHolder || z) {
            InterfaceC1277Wn[] interfaceC1277WnArr = this.A0C;
            if (A0W[5].length() == 18) {
                A0W[4] = "MfZ5b0v7S5HL";
                for (InterfaceC1277Wn interfaceC1277Wn : interfaceC1277WnArr) {
                    if (A0W[6].charAt(23) == 'j') {
                        break;
                    }
                    A0W[4] = "gre2iAEzIfwakAGQE6Y0w4gvRDGAgj";
                    A0b(interfaceC1277Wn);
                }
                this.A0C = new InterfaceC1277Wn[0];
                A0G = null;
            }
            throw new RuntimeException();
        }
        if (newPlayingPeriodHolder != null) {
            A0V(A0G);
            boolean z2 = newPlayingPeriodHolder.A05;
            String[] strArr = A0W;
            if (strArr[1].charAt(27) != strArr[2].charAt(27)) {
                A0W[5] = "xpv6IUpjcorvZnU437";
                if (z2) {
                    j2 = newPlayingPeriodHolder.A08.AED(j2);
                    newPlayingPeriodHolder.A08.A4n(j2 - this.A0D, this.A0S);
                }
                A0P(j2);
                A09();
            }
            throw new RuntimeException();
        }
        this.A0K.A0O(true);
        A0P(j2);
        this.A0Q.AEF(2);
        return j2;
    }

    private Pair<Integer, Long> A04(AI ai, boolean z) {
        int A01;
        AbstractC0733Ao abstractC0733Ao = this.A05.A03;
        AbstractC0733Ao abstractC0733Ao2 = ai.A02;
        if (abstractC0733Ao.A0E()) {
            return null;
        }
        if (abstractC0733Ao2.A0E()) {
            abstractC0733Ao2 = abstractC0733Ao;
        }
        try {
            Pair<Integer, Long> A07 = abstractC0733Ao2.A07(this.A0M, this.A0L, ai.A00, ai.A01);
            if (abstractC0733Ao == abstractC0733Ao2) {
                return A07;
            }
            int A04 = abstractC0733Ao.A04(abstractC0733Ao2.A0A(((Integer) A07.first).intValue(), this.A0L, true).A03);
            if (A04 != -1) {
                Integer valueOf = Integer.valueOf(A04);
                Object obj = A07.second;
                if (A0W[5].length() != 18) {
                    throw new RuntimeException();
                }
                A0W[4] = "NzmvKaw5D7qN";
                return Pair.create(valueOf, obj);
            } else if (!z || (A01 = A01(((Integer) A07.first).intValue(), abstractC0733Ao2, abstractC0733Ao)) == -1) {
                return null;
            } else {
                int i2 = abstractC0733Ao.A09(A01, this.A0L).A00;
                String[] strArr = A0W;
                if (strArr[1].charAt(27) != strArr[2].charAt(27)) {
                    A0W[4] = "Yw40DLhiFndXC7wfBusX4OUMnHZHVu";
                    return A05(abstractC0733Ao, i2, -9223372036854775807L);
                }
                return A05(abstractC0733Ao, i2, -9223372036854775807L);
            }
        } catch (IndexOutOfBoundsException unused) {
            throw new AN(abstractC0733Ao, ai.A00, ai.A01);
        }
    }

    private Pair<Integer, Long> A05(AbstractC0733Ao abstractC0733Ao, int i2, long j2) {
        return abstractC0733Ao.A07(this.A0M, this.A0L, i2, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0196, code lost:
        if (r8 != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019c, code lost:
        if (r16.A05.A00 == 3) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a2, code lost:
        if (r16.A05.A00 != 2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a4, code lost:
        A0R(r2, 10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a9, code lost:
        com.facebook.ads.redexgen.X.C0920Ii.A00();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ac, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b0, code lost:
        if (r16.A0C.length == 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01b6, code lost:
        if (r16.A05.A00 == 4) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01b8, code lost:
        A0R(r2, 1000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01be, code lost:
        r16.A0Q.ADc(2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01d0, code lost:
        if (r8 != false) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x008e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A07() throws com.facebook.ads.redexgen.X.A9, java.io.IOException {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DT.A07():void");
    }

    private void A08() {
        A0N(4);
        A0o(false, true, false);
    }

    private void A09() {
        AP A0F = this.A0K.A0F();
        long A06 = A0F.A06();
        if (A06 == Long.MIN_VALUE) {
            A0k(false);
            return;
        }
        long bufferedDurationUs = A06 - A0F.A08(this.A03);
        boolean AEZ = this.A0J.AEZ(bufferedDurationUs, this.A0G.A78().A01);
        A0k(AEZ);
        if (AEZ) {
            long nextLoadPositionUs = this.A03;
            A0F.A0F(nextLoadPositionUs);
        }
    }

    private void A0A() {
        int i2;
        if (this.A0I.A06(this.A05)) {
            Handler handler = this.A0E;
            int A00 = AH.A00(this.A0I);
            if (AH.A02(this.A0I)) {
                i2 = AH.A01(this.A0I);
            } else {
                i2 = -1;
            }
            handler.obtainMessage(0, A00, i2, this.A05).sendToTarget();
            this.A0I.A05(this.A05);
        }
    }

    private void A0B() throws IOException {
        InterfaceC1277Wn[] interfaceC1277WnArr;
        AP A0F = this.A0K.A0F();
        AP A0H = this.A0K.A0H();
        if (A0F != null && !A0F.A06) {
            if (A0H != null) {
                AP readingPeriodHolder = A0H.A01;
                if (readingPeriodHolder != A0F) {
                    return;
                }
            }
            for (InterfaceC1277Wn renderer : this.A0C) {
                if (!renderer.A7w()) {
                    return;
                }
            }
            A0F.A08.A9O();
        }
    }

    private void A0C() throws IOException {
        this.A0K.A0M(this.A03);
        if (this.A0K.A0Q()) {
            AQ A0I = this.A0K.A0I(this.A03, this.A05);
            if (A0I == null) {
                this.A07.A9P();
                return;
            }
            this.A0K.A0K(this.A0U, this.A0N, this.A0J.A5e(), this.A07, this.A05.A03.A0A(A0I.A04.A02, this.A0L, true).A03, A0I).ACy(this, A0I.A03);
            A0k(true);
        }
    }

    private void A0D() {
        A0o(true, true, true);
        this.A0J.ABq();
        A0N(1);
        this.A0F.quit();
        synchronized (this) {
            this.A0A = true;
            notifyAll();
        }
    }

    private void A0E() throws A9 {
        if (!this.A0K.A0P()) {
            return;
        }
        float f2 = this.A0G.A78().A01;
        AP A0H = this.A0K.A0H();
        boolean z = true;
        for (AP A0G = this.A0K.A0G(); A0G != null; A0G = A0G.A01) {
            boolean selectionsChangedForReadPeriod = A0G.A06;
            if (!selectionsChangedForReadPeriod) {
                return;
            }
            if (!A0G.A0I(f2)) {
                if (A0G == A0H) {
                    z = false;
                }
            } else {
                if (z) {
                    AP A0G2 = this.A0K.A0G();
                    boolean A0S = this.A0K.A0S(A0G2);
                    boolean[] zArr = new boolean[this.A0T.length];
                    long A0B = A0G2.A0B(this.A05.A0A, A0S, zArr);
                    A0i(A0G2.A03, A0G2.A04);
                    if (this.A05.A00 != 4 && A0B != this.A05.A0A) {
                        AT at = this.A05;
                        this.A05 = at.A04(at.A04, A0B, this.A05.A01);
                        this.A0I.A04(4);
                        A0P(A0B);
                    }
                    int i2 = 0;
                    int enabledRendererCount = this.A0T.length;
                    boolean[] zArr2 = new boolean[enabledRendererCount];
                    int i3 = 0;
                    while (true) {
                        InterfaceC1277Wn[] interfaceC1277WnArr = this.A0T;
                        if (i3 >= interfaceC1277WnArr.length) {
                            this.A05 = this.A05.A05(A0G2.A03, A0G2.A04);
                            A0p(zArr2, i2);
                            break;
                        }
                        InterfaceC1277Wn interfaceC1277Wn = interfaceC1277WnArr[i3];
                        zArr2[i3] = interfaceC1277Wn.A7Q() != 0;
                        InterfaceC0844Fi interfaceC0844Fi = A0G2.A0A[i3];
                        if (interfaceC0844Fi != null) {
                            i2++;
                        }
                        if (zArr2[i3]) {
                            InterfaceC0844Fi A7V = interfaceC1277Wn.A7V();
                            if (A0W[4].length() == 29) {
                                throw new RuntimeException();
                            }
                            A0W[4] = "CIOLNyaJNw";
                            if (interfaceC0844Fi != A7V) {
                                A0b(interfaceC1277Wn);
                            } else if (zArr[i3]) {
                                interfaceC1277Wn.ADs(this.A03);
                            }
                        }
                        i3++;
                    }
                } else {
                    this.A0K.A0S(A0G);
                    if (A0G.A06) {
                        A0G.A0A(Math.max(A0G.A02.A03, A0G.A08(this.A03)), false);
                        A0i(A0G.A03, A0G.A04);
                    }
                }
                if (this.A05.A00 != 4) {
                    A09();
                    A0J();
                    this.A0Q.AEF(2);
                    return;
                }
                return;
            }
        }
    }

    private void A0F() {
        for (int size = this.A0R.size() - 1; size >= 0; size--) {
            if (!A0r(this.A0R.get(size))) {
                this.A0R.get(size).A03.A0A(false);
                this.A0R.remove(size);
            }
        }
        Collections.sort(this.A0R);
    }

    private void A0G() throws A9 {
        this.A09 = false;
        this.A0G.A05();
        for (InterfaceC1277Wn interfaceC1277Wn : this.A0C) {
            interfaceC1277Wn.start();
        }
    }

    private void A0H() throws A9 {
        this.A0G.A06();
        for (InterfaceC1277Wn interfaceC1277Wn : this.A0C) {
            A0c(interfaceC1277Wn);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01d6, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01de, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e4, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e5, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (r4.A02.A05 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
        r2 = r1.A0T;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ae, code lost:
        if (r5 >= r2.length) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b0, code lost:
        r3 = r2[r5];
        r2 = r4.A0A[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b6, code lost:
        if (r2 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b8, code lost:
        r0 = r3.A7V();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bc, code lost:
        if (r0 != r2) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c2, code lost:
        if (r3.A7w() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c4, code lost:
        r3.AEL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c7, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ca, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
        if (r4.A01 == null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d3, code lost:
        if (r4.A01.A06 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d5, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d6, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d7, code lost:
        r7 = r1.A0T;
        r6 = r7.length;
        r2 = com.facebook.ads.redexgen.X.DT.A0W[3].charAt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e6, code lost:
        if (r2 == 99) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e8, code lost:
        com.facebook.ads.redexgen.X.DT.A0W[4] = "ghsgso7PHHKUfGJDBRDWa58h1rLx";
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ef, code lost:
        if (r5 >= r6) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f1, code lost:
        r3 = r7[r5];
        r2 = r4.A0A[r5];
        r0 = r3.A7V();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00fb, code lost:
        if (r0 != r2) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00fd, code lost:
        if (r2 == null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0103, code lost:
        if (r3.A7w() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0105, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0106, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0109, code lost:
        r3 = com.facebook.ads.redexgen.X.DT.A0W;
        r3[1] = "W3Zxvi1uQeiwcOM1a3uIixoX4KFWrQEX";
        r3[2] = "hMjrL9hJ9zdobOz7Vqnbeo3Jken9e002";
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0115, code lost:
        if (r5 >= r6) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0118, code lost:
        r8 = r4.A04;
        r7 = r1.A0K.A0D();
        r6 = r7.A04;
        r4 = (r7.A08.ADH() > (-9223372036854775807L) ? 1 : (r7.A08.ADH() == (-9223372036854775807L) ? 0 : -1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013a, code lost:
        if (com.facebook.ads.redexgen.X.DT.A0W[4].length() == 29) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013c, code lost:
        com.facebook.ads.redexgen.X.DT.A0W[6] = "vjt4oSs9hMr9NwWN4mwojUjVUYrN8cQ6";
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0143, code lost:
        if (r4 == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0145, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0146, code lost:
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0147, code lost:
        r2 = r1.A0T;
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x014a, code lost:
        if (r5 >= r0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x014c, code lost:
        r4 = r2[r5];
        r0 = r8.A00(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0152, code lost:
        if (r0 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0154, code lost:
        r5 = r5 + 1;
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0158, code lost:
        if (r13 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x015a, code lost:
        r4.AEL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0162, code lost:
        if (r4.A8G() != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0164, code lost:
        r12 = r6.A01.A00(r5);
        r11 = r6.A00(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0177, code lost:
        if (r1.A0U[r5].A7b() != 5) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0179, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017a, code lost:
        r3 = r8.A03[r5];
        r9 = r6.A03;
        r2 = com.facebook.ads.redexgen.X.DT.A0W;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0192, code lost:
        if (r2[1].charAt(27) == r2[2].charAt(27)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0194, code lost:
        com.facebook.ads.redexgen.X.DT.A0W[5] = "Ap10Ra2l8gLZ0YRne2";
        r0 = r9[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019d, code lost:
        if (r11 == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01a3, code lost:
        if (r0.equals(r3) == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a5, code lost:
        if (r10 != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01a7, code lost:
        r3 = A0v(r12);
        r9 = r7.A0A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b9, code lost:
        if (com.facebook.ads.redexgen.X.DT.A0W[3].charAt(0) == 'c') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01bb, code lost:
        com.facebook.ads.redexgen.X.DT.A0W[5] = "P6QWonkpaKbLAx4pgk";
        r4.ADh(r3, r9[r5], r7.A07());
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01cc, code lost:
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ce, code lost:
        r4.AEL();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d2, code lost:
        if (r4 == 0) goto L120;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0I() throws com.facebook.ads.redexgen.X.A9, java.io.IOException {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DT.A0I():void");
    }

    private void A0J() throws A9 {
        long A0C;
        if (!this.A0K.A0P()) {
            return;
        }
        AP A0G = this.A0K.A0G();
        long ADH = A0G.A08.ADH();
        if (ADH != -9223372036854775807L) {
            A0P(ADH);
            long periodPositionUs = this.A05.A0A;
            if (ADH != periodPositionUs) {
                AT at = this.A05;
                this.A05 = at.A04(at.A04, ADH, this.A05.A01);
                this.A0I.A04(4);
            }
        } else {
            this.A03 = this.A0G.A04();
            long A08 = A0G.A08(this.A03);
            A0Q(this.A05.A0A, A08);
            this.A05.A0A = A08;
        }
        AT at2 = this.A05;
        if (this.A0C.length == 0) {
            A0C = A0G.A02.A01;
        } else {
            A0C = A0G.A0C(true);
        }
        at2.A09 = A0C;
    }

    private void A0L(float f2) {
        HD[] A01;
        for (AP A0E = this.A0K.A0E(); A0E != null; A0E = A0E.A01) {
            if (A0E.A04 != null) {
                for (HD trackSelection : A0E.A04.A01.A01()) {
                    if (trackSelection != null) {
                        trackSelection.ABa(f2);
                    }
                }
            }
        }
    }

    private void A0M(int i2) throws A9 {
        this.A02 = i2;
        if (!this.A0K.A0R(i2)) {
            A0j(true);
        }
    }

    private void A0N(int i2) {
        if (this.A05.A00 != i2) {
            this.A05 = this.A05.A02(i2);
        }
    }

    private void A0O(int i2, boolean z, int i3) throws A9 {
        AP A0G = this.A0K.A0G();
        InterfaceC1277Wn interfaceC1277Wn = this.A0T[i2];
        this.A0C[i3] = interfaceC1277Wn;
        if (interfaceC1277Wn.A7Q() == 0) {
            C0728Ai c0728Ai = A0G.A04.A03[i2];
            Format[] A0v = A0v(A0G.A04.A01.A00(i2));
            boolean z2 = this.A08 && this.A05.A00 == 3;
            interfaceC1277Wn.A57(c0728Ai, A0v, A0G.A0A[i2], this.A03, !z && z2, A0G.A07());
            this.A0G.A09(interfaceC1277Wn);
            if (z2) {
                interfaceC1277Wn.start();
            }
        }
    }

    private void A0P(long j2) throws A9 {
        if (this.A0K.A0P()) {
            AP A0G = this.A0K.A0G();
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[0] = "3Dp2X759xi1gKy2gc8ykMJ";
            strArr[7] = "GcHSrS1OF4oxjH6XmPjhKR";
            j2 = A0G.A09(j2);
        }
        this.A03 = j2;
        this.A0G.A07(this.A03);
        for (InterfaceC1277Wn interfaceC1277Wn : this.A0C) {
            interfaceC1277Wn.ADs(this.A03);
        }
    }

    private void A0Q(long j2, long j3) throws A9 {
        AG ag;
        if (this.A0R.isEmpty() || this.A05.A04.A01()) {
            return;
        }
        if (this.A05.A02 == j2) {
            j2--;
        }
        int i2 = this.A05.A04.A02;
        int i3 = this.A00;
        AG ag2 = i3 > 0 ? this.A0R.get(i3 - 1) : null;
        while (ag2 != null) {
            if (ag2.A00 <= i2) {
                int i4 = ag2.A00;
                if (A0W[3].charAt(0) == 'c') {
                    throw new RuntimeException();
                }
                String[] strArr = A0W;
                strArr[0] = "ZbbXGQ7fBHqOH9bFx5EieA";
                strArr[7] = "wqQaVgv9yDX8FIaCovLxd4";
                if (i4 == i2) {
                    if (ag2.A01 <= j2) {
                        break;
                    }
                } else {
                    break;
                }
            }
            this.A00--;
            int i5 = this.A00;
            ag2 = i5 > 0 ? this.A0R.get(i5 - 1) : null;
        }
        if (this.A00 < this.A0R.size()) {
            ag = this.A0R.get(this.A00);
        } else {
            ag = null;
        }
        while (ag != null && ag.A02 != null && (ag.A00 < i2 || (ag.A00 == i2 && ag.A01 <= j2))) {
            this.A00++;
            if (this.A00 < this.A0R.size()) {
                ag = this.A0R.get(this.A00);
            } else {
                ag = null;
            }
        }
        while (ag != null && ag.A02 != null && ag.A00 == i2 && ag.A01 > j2 && ag.A01 <= j3) {
            A0Z(ag.A03);
            if (ag.A03.A0B() || ag.A03.A0D()) {
                this.A0R.remove(this.A00);
            } else {
                this.A00++;
            }
            if (this.A00 < this.A0R.size()) {
                ag = this.A0R.get(this.A00);
            } else {
                ag = null;
            }
        }
    }

    private void A0R(long j2, long j3) {
        this.A0Q.ADc(2);
        this.A0Q.AEG(2, j2 + j3);
    }

    private void A0S(AF af) throws A9 {
        Object playingPeriodUid;
        if (af.A01 != this.A07) {
            return;
        }
        AbstractC0733Ao abstractC0733Ao = this.A05.A03;
        AbstractC0733Ao abstractC0733Ao2 = af.A00;
        Object manifest = af.A02;
        this.A0K.A0N(abstractC0733Ao2);
        this.A05 = this.A05.A03(abstractC0733Ao2, manifest);
        A0F();
        int i2 = this.A01;
        if (i2 > 0) {
            this.A0I.A03(i2);
            this.A01 = 0;
            AI ai = this.A04;
            if (ai != null) {
                Pair<Integer, Long> A04 = A04(ai, true);
                this.A04 = null;
                if (A04 == null) {
                    A08();
                    return;
                }
                int intValue = ((Integer) A04.first).intValue();
                long longValue = ((Long) A04.second).longValue();
                FL A0L = this.A0K.A0L(intValue, longValue);
                this.A05 = this.A05.A04(A0L, A0L.A01() ? 0L : longValue, longValue);
                return;
            } else if (this.A05.A02 != -9223372036854775807L) {
                return;
            } else {
                boolean A0E = abstractC0733Ao2.A0E();
                String[] strArr = A0W;
                if (strArr[1].charAt(27) == strArr[2].charAt(27)) {
                    throw new RuntimeException();
                }
                A0W[4] = "lH2oXw2RUPBHBuRA0";
                if (A0E) {
                    A08();
                    return;
                }
                Pair<Integer, Long> A05 = A05(abstractC0733Ao2, abstractC0733Ao2.A05(this.A0B), -9223372036854775807L);
                int intValue2 = ((Integer) A05.first).intValue();
                long longValue2 = ((Long) A05.second).longValue();
                FL A0L2 = this.A0K.A0L(intValue2, longValue2);
                this.A05 = this.A05.A04(A0L2, A0L2.A01() ? 0L : longValue2, longValue2);
                return;
            }
        }
        int i3 = this.A05.A04.A02;
        long j2 = this.A05.A01;
        if (abstractC0733Ao.A0E()) {
            if (!abstractC0733Ao2.A0E()) {
                FL A0L3 = this.A0K.A0L(i3, j2);
                AT at = this.A05;
                long startPositionUs = A0L3.A01() ? 0L : j2;
                this.A05 = at.A04(A0L3, startPositionUs, j2);
                return;
            }
            return;
        }
        AP A0E2 = this.A0K.A0E();
        if (A0E2 == null) {
            C0731Am c0731Am = this.A0L;
            if (A0W[3].charAt(0) != 'c') {
                String[] strArr2 = A0W;
                strArr2[0] = "AIgzGczszMkheYOO0l2WDA";
                strArr2[7] = "AQm6fITMTu1q9a2hy8bL0W";
                playingPeriodUid = abstractC0733Ao.A0A(i3, c0731Am, true).A03;
            } else {
                A0W[6] = "kxPd1uECtZJZCmNWUxsBgkB7loYAAl3C";
                playingPeriodUid = abstractC0733Ao.A0A(i3, c0731Am, true).A03;
            }
        } else {
            playingPeriodUid = A0E2.A09;
        }
        int A042 = abstractC0733Ao2.A04(playingPeriodUid);
        if (A042 == -1) {
            int A01 = A01(i3, abstractC0733Ao, abstractC0733Ao2);
            if (A01 == -1) {
                A08();
                return;
            }
            Pair<Integer, Long> A052 = A05(abstractC0733Ao2, abstractC0733Ao2.A09(A01, this.A0L).A00, -9223372036854775807L);
            int intValue3 = ((Integer) A052.first).intValue();
            long longValue3 = ((Long) A052.second).longValue();
            FL A0L4 = this.A0K.A0L(intValue3, longValue3);
            abstractC0733Ao2.A0A(intValue3, this.A0L, true);
            if (A0E2 != null) {
                Object obj = this.A0L.A03;
                A0E2.A02 = A0E2.A02.A00(-1);
                while (A0E2.A01 != null) {
                    A0E2 = A0E2.A01;
                    if (A0E2.A09.equals(obj)) {
                        A0E2.A02 = this.A0K.A0J(A0E2.A02, intValue3);
                    } else {
                        A0E2.A02 = A0E2.A02.A00(-1);
                    }
                }
            }
            this.A05 = this.A05.A04(A0L4, A02(A0L4, A0L4.A01() ? 0L : longValue3), longValue3);
            return;
        }
        if (A042 != i3) {
            AT A012 = this.A05.A01(A042);
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            A0W[4] = "bxSLNYRWzgoGTszax8Z4I";
            this.A05 = A012;
        }
        FL fl = this.A05.A04;
        if (fl.A01()) {
            FL A0L5 = this.A0K.A0L(A042, j2);
            if (!A0L5.equals(fl)) {
                this.A05 = this.A05.A04(A0L5, A02(A0L5, A0L5.A01() ? 0L : j2), j2);
                return;
            }
        }
        if (!this.A0K.A0U(fl, this.A03)) {
            A0j(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0T(com.facebook.ads.redexgen.X.AI r20) throws com.facebook.ads.redexgen.X.A9 {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DT.A0T(com.facebook.ads.redexgen.X.AI):void");
    }

    private void A0V(@Nullable AP ap) throws A9 {
        AP A0G = this.A0K.A0G();
        if (A0G == null || ap == A0G) {
            return;
        }
        int i2 = 0;
        boolean[] zArr = new boolean[this.A0T.length];
        int i3 = 0;
        while (true) {
            InterfaceC1277Wn[] interfaceC1277WnArr = this.A0T;
            if (i3 >= interfaceC1277WnArr.length) {
                break;
            }
            InterfaceC1277Wn interfaceC1277Wn = interfaceC1277WnArr[i3];
            zArr[i3] = interfaceC1277Wn.A7Q() != 0;
            if (A0G.A04.A00(i3)) {
                i2++;
            }
            if (zArr[i3] && (!A0G.A04.A00(i3) || (interfaceC1277Wn.A8G() && interfaceC1277Wn.A7V() == ap.A0A[i3]))) {
                A0b(interfaceC1277Wn);
            }
            i3++;
        }
        AT at = this.A05;
        if (A0W[6].charAt(23) == 'j') {
            throw new RuntimeException();
        }
        String[] strArr = A0W;
        strArr[0] = "YeyTuc4hJN2cviDoFTSuVw";
        strArr[7] = "y3cCzPpceybwtUTWhAu8hu";
        this.A05 = at.A05(A0G.A03, A0G.A04);
        A0p(zArr, i2);
    }

    private void A0W(AU au) {
        this.A0G.AET(au);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0X(C0725Af c0725Af) throws A9 {
        if (c0725Af.A0D()) {
            return;
        }
        try {
            c0725Af.A04().A7q(c0725Af.A00(), c0725Af.A09());
        } finally {
            c0725Af.A0A(true);
        }
    }

    private void A0Y(C0725Af c0725Af) throws A9 {
        if (c0725Af.A02() == -9223372036854775807L) {
            A0Z(c0725Af);
        } else if (this.A07 == null || this.A01 > 0) {
            this.A0R.add(new AG(c0725Af));
        } else {
            AG ag = new AG(c0725Af);
            if (A0r(ag)) {
                ArrayList<AG> arrayList = this.A0R;
                String[] strArr = A0W;
                if (strArr[0].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A0W[6] = "bdowkwDe22b4JBVUMCxt2Emm6YTTpUJh";
                arrayList.add(ag);
                Collections.sort(this.A0R);
                return;
            }
            c0725Af.A0A(false);
        }
    }

    private void A0Z(C0725Af c0725Af) throws A9 {
        if (c0725Af.A03().getLooper() == this.A0Q.A6q()) {
            A0X(c0725Af);
            if (this.A05.A00 == 3 || this.A05.A00 == 2) {
                this.A0Q.AEF(2);
                return;
            }
            return;
        }
        this.A0Q.A9b(15, c0725Af).sendToTarget();
    }

    private void A0a(C0725Af c0725Af) {
        c0725Af.A03().post(new AE(this, c0725Af));
    }

    private void A0b(InterfaceC1277Wn interfaceC1277Wn) throws A9 {
        this.A0G.A08(interfaceC1277Wn);
        A0c(interfaceC1277Wn);
        interfaceC1277Wn.A4l();
    }

    private void A0c(InterfaceC1277Wn interfaceC1277Wn) throws A9 {
        if (interfaceC1277Wn.A7Q() == 2) {
            interfaceC1277Wn.stop();
        }
    }

    private void A0d(C0730Ak c0730Ak) {
        this.A06 = c0730Ak;
    }

    private void A0e(V3 v3) {
        if (!this.A0K.A0T(v3)) {
            return;
        }
        this.A0K.A0M(this.A03);
        A09();
    }

    private void A0f(V3 v3) throws A9 {
        if (!this.A0K.A0T(v3)) {
            return;
        }
        AP A0F = this.A0K.A0F();
        A0F.A0E(this.A0G.A78().A01);
        A0i(A0F.A03, A0F.A04);
        if (!this.A0K.A0P()) {
            A0P(this.A0K.A0C().A02.A03);
            A0V(null);
        }
        A09();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC0845Fj
    /* renamed from: A0g */
    public final void AAD(V3 v3) {
        this.A0Q.A9b(10, v3).sendToTarget();
    }

    private void A0h(FN fn, boolean z, boolean z2) {
        this.A01++;
        A0o(true, z, z2);
        this.A0J.onPrepared();
        this.A07 = fn;
        A0N(2);
        fn.AD1(this.A0H, true, this);
        this.A0Q.AEF(2);
    }

    private void A0i(TrackGroupArray trackGroupArray, HH hh) {
        this.A0J.ACI(this.A0T, trackGroupArray, hh.A01);
    }

    private void A0j(boolean z) throws A9 {
        FL fl = this.A0K.A0G().A02.A04;
        long A03 = A03(fl, this.A05.A0A, true);
        long newPositionUs = this.A05.A0A;
        if (A03 != newPositionUs) {
            AT at = this.A05;
            this.A05 = at.A04(fl, A03, at.A01);
            if (z) {
                this.A0I.A04(4);
            }
        }
    }

    private void A0k(boolean z) {
        if (this.A05.A08 != z) {
            this.A05 = this.A05.A06(z);
        }
    }

    private void A0l(boolean z) throws A9 {
        this.A09 = false;
        this.A08 = z;
        if (!z) {
            A0H();
            A0J();
        } else if (this.A05.A00 == 3) {
            A0G();
            if (A0W[4].length() == 29) {
                throw new RuntimeException();
            }
            A0W[6] = "X2QfJ1e23pCpGilE5nvaFXYxLnWx3Vax";
            this.A0Q.AEF(2);
        } else if (this.A05.A00 != 2) {
        } else {
            this.A0Q.AEF(2);
        }
    }

    private void A0m(boolean z) throws A9 {
        this.A0B = z;
        if (!this.A0K.A0V(z)) {
            A0j(true);
        }
    }

    private void A0n(boolean z, boolean z2) {
        A0o(true, z, z);
        this.A0I.A03(this.A01 + (z2 ? 1 : 0));
        this.A01 = 0;
        this.A0J.ACB();
        A0N(1);
    }

    private void A0o(boolean z, boolean z2, boolean z3) {
        InterfaceC1277Wn[] interfaceC1277WnArr;
        Object obj;
        long j2;
        TrackGroupArray trackGroupArray;
        HH hh;
        FN fn;
        this.A0Q.ADc(2);
        this.A09 = false;
        this.A0G.A06();
        this.A03 = 0L;
        for (InterfaceC1277Wn renderer : this.A0C) {
            try {
                A0b(renderer);
            } catch (A9 | RuntimeException e2) {
                Log.e(A06(0, 21, 15), A06(138, 12, 123), e2);
            }
        }
        this.A0C = new InterfaceC1277Wn[0];
        AR ar = this.A0K;
        String[] strArr = A0W;
        if (strArr[1].charAt(27) == strArr[2].charAt(27)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0W;
        strArr2[0] = "2WNzaDjkqcOaPFAy0QOPwI";
        strArr2[7] = "unAKX8spYNQMyMddShLfR5";
        ar.A0O(!z2);
        A0k(false);
        if (z2) {
            this.A04 = null;
        }
        if (z3) {
            this.A0K.A0N(AbstractC0733Ao.A01);
            Iterator<AG> it = this.A0R.iterator();
            while (it.hasNext()) {
                AG next = it.next();
                if (A0W[5].length() != 18) {
                    throw new RuntimeException();
                }
                A0W[6] = "oYGfQB8mGDj6jmVX6XAe4nZE0DoRm7Og";
                next.A03.A0A(false);
            }
            this.A0R.clear();
            this.A00 = 0;
        }
        AbstractC0733Ao abstractC0733Ao = z3 ? AbstractC0733Ao.A01 : this.A05.A03;
        if (z3) {
            obj = null;
        } else {
            obj = this.A05.A07;
        }
        FL fl = z2 ? new FL(A00()) : this.A05.A04;
        long j3 = -9223372036854775807L;
        if (z2) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.A05.A0A;
        }
        if (!z2) {
            j3 = this.A05.A01;
        }
        int i2 = this.A05.A00;
        if (z3) {
            trackGroupArray = TrackGroupArray.A04;
        } else {
            AT at = this.A05;
            if (A0W[5].length() != 18) {
                trackGroupArray = at.A05;
            } else {
                String[] strArr3 = A0W;
                strArr3[1] = "udHBd6VluCWpjwypGpbQkm44C5lEXr7W";
                strArr3[2] = "ikIjUWR3chEMULYYaopllYxVSgtPleKx";
                trackGroupArray = at.A05;
            }
        }
        if (z3) {
            hh = this.A0O;
        } else {
            hh = this.A05.A06;
        }
        this.A05 = new AT(abstractC0733Ao, obj, fl, j2, j3, i2, false, trackGroupArray, hh);
        if (z && (fn = this.A07) != null) {
            fn.ADZ(this);
            this.A07 = null;
        }
    }

    private void A0p(boolean[] zArr, int i2) throws A9 {
        this.A0C = new InterfaceC1277Wn[i2];
        int enabledRendererCount = 0;
        AP A0G = this.A0K.A0G();
        for (int i3 = 0; i3 < this.A0T.length; i3++) {
            if (A0G.A04.A00(i3)) {
                A0O(i3, zArr[i3], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A0q() {
        AP A0G = this.A0K.A0G();
        long j2 = A0G.A02.A01;
        return j2 == -9223372036854775807L || this.A05.A0A < j2 || (A0G.A01 != null && (A0G.A01.A06 || A0G.A01.A02.A04.A01()));
    }

    private boolean A0r(AG ag) {
        if (ag.A02 == null) {
            Pair<Integer, Long> A04 = A04(new AI(ag.A03.A08(), ag.A03.A01(), A3.A00(ag.A03.A02())), false);
            if (A04 == null) {
                return false;
            }
            ag.A01(((Integer) A04.first).intValue(), ((Long) A04.second).longValue(), this.A05.A03.A0A(((Integer) A04.first).intValue(), this.A0L, true).A03);
        } else {
            int A042 = this.A05.A03.A04(ag.A02);
            if (A042 == -1) {
                return false;
            }
            ag.A00 = A042;
        }
        return true;
    }

    private boolean A0s(InterfaceC1277Wn interfaceC1277Wn) {
        AP A0H = this.A0K.A0H();
        return A0H.A01 != null && A0H.A01.A06 && interfaceC1277Wn.A7w();
    }

    private boolean A0t(FL fl, long j2, AP ap) {
        if (fl.equals(ap.A02.A04) && ap.A06) {
            this.A05.A03.A09(ap.A02.A04.A02, this.A0L);
            int A04 = this.A0L.A04(j2);
            if (A04 == -1 || this.A0L.A09(A04) == ap.A02.A02) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r3 != Long.MIN_VALUE) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        r2 = r7.A0J;
        r0 = r7.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0081, code lost:
        if (r2.AEc(r3 - r5.A08(r0), r7.A0G.A78().A01, r7.A09) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0083, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009e, code lost:
        if (r3 != Long.MIN_VALUE) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean A0u(boolean r8) {
        /*
            r7 = this;
            com.facebook.ads.redexgen.X.Wn[] r0 = r7.A0C
            int r0 = r0.length
            if (r0 != 0) goto La
            boolean r0 = r7.A0q()
            return r0
        La:
            r6 = 0
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.DT.A0W
            r0 = 0
            r1 = r2[r0]
            r0 = 7
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L23
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L23:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.DT.A0W
            java.lang.String r1 = "XitCw2lYTMNoWfZ3MNfhmS"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "pjSmPGutCkFid20LDJR8Tk"
            r0 = 7
            r2[r0] = r1
            if (r8 != 0) goto L32
            return r6
        L32:
            com.facebook.ads.redexgen.X.AT r0 = r7.A05
            boolean r0 = r0.A08
            r3 = 1
            if (r0 != 0) goto L3a
            return r3
        L3a:
            com.facebook.ads.redexgen.X.AR r0 = r7.A0K
            com.facebook.ads.redexgen.X.AP r5 = r0.A0F()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.DT.A0W
            r0 = 1
            r1 = r2[r0]
            r0 = 2
            r2 = r2[r0]
            r0 = 27
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L85
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.DT.A0W
            java.lang.String r1 = "c9QtbAseiMx42ehTAZ"
            r0 = 5
            r2[r0] = r1
            com.facebook.ads.redexgen.X.AQ r0 = r5.A02
            boolean r0 = r0.A05
            r0 = r0 ^ r3
            long r3 = r5.A0C(r0)
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L83
        L6a:
            com.facebook.ads.redexgen.X.AO r2 = r7.A0J
            long r0 = r7.A03
            long r0 = r5.A08(r0)
            long r3 = r3 - r0
            com.facebook.ads.redexgen.X.Wq r0 = r7.A0G
            com.facebook.ads.redexgen.X.AU r0 = r0.A78()
            float r1 = r0.A01
            boolean r0 = r7.A09
            boolean r0 = r2.AEc(r3, r1, r0)
            if (r0 == 0) goto L84
        L83:
            r6 = 1
        L84:
            return r6
        L85:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.DT.A0W
            java.lang.String r1 = "5BPuibQqZ5NKjWZyuTION1z1lHkA3o6b"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "lue4BzZmQF8ChJf2GK4Pk4NwU097v1o6"
            r0 = 2
            r2[r0] = r1
            com.facebook.ads.redexgen.X.AQ r0 = r5.A02
            boolean r0 = r0.A05
            r0 = r0 ^ r3
            long r3 = r5.A0C(r0)
            r1 = -9223372036854775808
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L83
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.DT.A0u(boolean):boolean");
    }

    @NonNull
    public static Format[] A0v(HD hd) {
        int length = hd != null ? hd.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i2 = 0; i2 < length; i2++) {
            formatArr[i2] = hd.A6d(i2);
            if (A0W[3].charAt(0) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A0W;
            strArr[1] = "cHoAaTwhCyKnC5gIlgOheFkD17ImOLE4";
            strArr[2] = "NdVO49IoL7wvUQC4on3mokgCd3AJvc50";
        }
        return formatArr;
    }

    public final Looper A0w() {
        return this.A0F.getLooper();
    }

    public final synchronized void A0x() {
        if (this.A0A) {
            return;
        }
        this.A0Q.AEF(7);
        boolean z = false;
        while (!this.A0A) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        if (A0W[3].charAt(0) == 'c') {
            throw new RuntimeException();
        }
        A0W[5] = "ci8xVCbgf6WZorAiSg";
    }

    public final void A0y(AbstractC0733Ao abstractC0733Ao, int i2, long j2) {
        this.A0Q.A9b(3, new AI(abstractC0733Ao, i2, j2)).sendToTarget();
    }

    public final void A0z(FN fn, boolean z, boolean z2) {
        this.A0Q.A9a(0, z ? 1 : 0, z2 ? 1 : 0, fn).sendToTarget();
    }

    public final void A10(boolean z) {
        this.A0Q.A9Z(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void A11(boolean z) {
        this.A0Q.A9Z(6, z ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.A6
    public final void ABZ(AU au) {
        this.A0E.obtainMessage(1, au).sendToTarget();
        A0L(au.A01);
    }

    @Override // com.facebook.ads.redexgen.X.V4
    public final void ABh(V3 v3) {
        this.A0Q.A9b(9, v3).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.FM
    public final void AC6(FN fn, AbstractC0733Ao abstractC0733Ao, Object obj) {
        this.A0Q.A9b(8, new AF(fn, abstractC0733Ao, obj)).sendToTarget();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0723Ad
    public final synchronized void AEH(C0725Af c0725Af) {
        if (this.A0A) {
            Log.w(A06(0, 21, 15), A06(50, 37, 50));
            c0725Af.A0A(false);
            return;
        }
        this.A0Q.A9b(14, c0725Af).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String A06 = A06(0, 21, 15);
        try {
            switch (message.what) {
                case 0:
                    A0h((FN) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    A0l(message.arg1 != 0);
                    break;
                case 2:
                    A07();
                    break;
                case 3:
                    A0T((AI) message.obj);
                    break;
                case 4:
                    A0W((AU) message.obj);
                    break;
                case 5:
                    A0d((C0730Ak) message.obj);
                    break;
                case 6:
                    A0n(message.arg1 != 0, true);
                    break;
                case 7:
                    A0D();
                    return true;
                case 8:
                    A0S((AF) message.obj);
                    break;
                case 9:
                    A0f((V3) message.obj);
                    break;
                case 10:
                    A0e((V3) message.obj);
                    break;
                case 11:
                    A0E();
                    break;
                case 12:
                    A0M(message.arg1);
                    break;
                case 13:
                    A0m(message.arg1 != 0);
                    break;
                case 14:
                    A0Y((C0725Af) message.obj);
                    break;
                case 15:
                    A0a((C0725Af) message.obj);
                    break;
                default:
                    return false;
            }
            A0A();
        } catch (A9 e2) {
            Log.e(A06, A06(110, 15, 0), e2);
            A0n(false, false);
            this.A0E.obtainMessage(2, e2).sendToTarget();
            A0A();
        } catch (IOException e3) {
            Log.e(A06, A06(125, 13, 87), e3);
            A0n(false, false);
            this.A0E.obtainMessage(2, A9.A00(e3)).sendToTarget();
            A0A();
        } catch (RuntimeException e4) {
            Log.e(A06, A06(87, 23, 108), e4);
            A0n(false, false);
            this.A0E.obtainMessage(2, A9.A02(e4)).sendToTarget();
            if (A0W[6].charAt(23) == 'j') {
                throw new RuntimeException();
            }
            A0W[5] = "BLVAUEtDSJNWXrvjpr";
            A0A();
        }
        return true;
    }
}
