package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: assets/audience_network.dex */
public final class DU implements InterfaceC1278Wo {
    public static byte[] A0M;
    public static String[] A0N = {"FdQu0fmyjo2y", "53g7H5tUmq98heWq", "c", "OWB4F6Jbct6Ly4JY", "NHyc4CVBcI41", "VuRuzyUBfoaB1KqcrIY9ro", "m", "Ea4pNsdJDJP"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    @Nullable
    public A9 A05;
    public AT A06;
    public AU A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final Handler A0C;
    public final Handler A0D;
    public final DT A0E;
    public final C0731Am A0F;
    public final C0732An A0G;
    public final HG A0H;
    public final HH A0I;
    public final ArrayDeque<AD> A0J;
    public final CopyOnWriteArraySet<AX> A0K;
    public final InterfaceC1277Wn[] A0L;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0M, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A0N[7].length() == 1) {
                throw new RuntimeException();
            }
            A0N[7] = "NVWBbKH";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 75);
            i5++;
        }
    }

    public static void A03() {
        A0M = new byte[]{108, 23, 126, 67, 84, 107, 87, 90, 66, 94, 73, 114, 86, 75, 87, 64, 125, 106, 85, 105, 100, 124, 96, 119, 73, 108, 103, 42, 55, 43, 61, 43, 49, 54, 17, 22, 11, 95, 27, 44, 37, 44, 40, 58, 44, 105, 64, 72, 53, 78, 50, 36, 36, 42, 21, 46, 97, 40, 38, 47, 46, 51, 36, 37, 97, 35, 36, 34, 32, 52, 50, 36, 97, 32, 47, 97, 32, 37, 97, 40, 50, 97, 49, 45, 32, 56, 40, 47, 38};
    }

    static {
        A03();
    }

    @SuppressLint({"HandlerLeak"})
    public DU(InterfaceC1277Wn[] interfaceC1277WnArr, HG hg, AO ao, I9 i9) {
        Log.i(A02(2, 13, 112), A02(33, 5, 52) + Integer.toHexString(System.identityHashCode(this)) + A02(0, 2, 7) + A02(15, 18, 78) + A02(47, 3, 94) + C0923Il.A04 + A02(46, 1, 86));
        I6.A04(interfaceC1277WnArr.length > 0);
        this.A0L = (InterfaceC1277Wn[]) I6.A01(interfaceC1277WnArr);
        this.A0H = (HG) I6.A01(hg);
        this.A0A = false;
        this.A03 = 0;
        this.A0B = false;
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0I = new HH(new C0728Ai[interfaceC1277WnArr.length], new HD[interfaceC1277WnArr.length], null);
        this.A0G = new C0732An();
        this.A0F = new C0731Am();
        this.A07 = AU.A04;
        this.A0C = new AC(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.A06 = new AT(AbstractC0733Ao.A01, 0L, TrackGroupArray.A04, this.A0I);
        this.A0J = new ArrayDeque<>();
        this.A0E = new DT(interfaceC1277WnArr, hg, this.A0I, ao, this.A0A, this.A03, this.A0B, this.A0C, this, i9);
        this.A0D = new Handler(this.A0E.A0w());
    }

    private long A00(long j2) {
        long A01 = A3.A01(j2);
        if (!this.A06.A04.A01()) {
            this.A06.A03.A09(this.A06.A04.A02, this.A0F);
            return A01 + this.A0F.A08();
        }
        return A01;
    }

    private AT A01(boolean z, boolean z2, int i2) {
        if (z) {
            this.A01 = 0;
            this.A00 = 0;
            this.A04 = 0L;
        } else {
            this.A01 = A6E();
            this.A00 = A07();
            this.A04 = A6B();
        }
        AT at = new AT(z2 ? AbstractC0733Ao.A01 : this.A06.A03, z2 ? null : this.A06.A07, this.A06.A04, this.A06.A02, this.A06.A01, i2, false, z2 ? TrackGroupArray.A04 : this.A06.A05, z2 ? this.A0I : this.A06.A06);
        String[] strArr = A0N;
        if (strArr[6].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        A0N[7] = "Xqr2ExcYOBi8j1Q";
        return at;
    }

    private void A04(AT at, int i2, boolean z, int timelineChangeReason) {
        int i3;
        AT at2 = at;
        this.A02 -= i2;
        if (this.A02 == 0) {
            if (at2.A02 == -9223372036854775807L) {
                at2 = at2.A04(at2.A04, 0L, at2.A01);
            }
            if (!this.A06.A03.A0E() || this.A08) {
                AbstractC0733Ao abstractC0733Ao = at2.A03;
                String[] strArr = A0N;
                if (strArr[1].length() == strArr[3].length()) {
                    A0N[7] = "oGDG41JiAsT7PCq0";
                    if (abstractC0733Ao.A0E()) {
                        this.A00 = 0;
                        this.A01 = 0;
                        String[] strArr2 = A0N;
                        if (strArr2[6].length() == strArr2[2].length()) {
                            String[] strArr3 = A0N;
                            strArr3[1] = "vrOcQin3pszluGLq";
                            strArr3[3] = "REI4M31lEJcbEC2a";
                            this.A04 = 0L;
                        }
                    }
                }
                throw new RuntimeException();
            }
            if (this.A08) {
                i3 = 0;
            } else {
                i3 = 2;
            }
            boolean z2 = this.A09;
            this.A08 = false;
            this.A09 = false;
            A05(at2, z, timelineChangeReason, i3, z2, false);
        }
    }

    private void A05(AT at, boolean z, int i2, int i3, boolean z2, boolean z3) {
        boolean z4 = !this.A0J.isEmpty();
        this.A0J.addLast(new AD(at, this.A06, this.A0K, this.A0H, z, i2, i3, z2, this.A0A, z3));
        this.A06 = at;
        if (z4) {
            return;
        }
        while (!this.A0J.isEmpty()) {
            this.A0J.peekFirst().A00();
            this.A0J.removeFirst();
        }
    }

    private boolean A06() {
        return this.A06.A03.A0E() || this.A02 > 0;
    }

    public final int A07() {
        if (A06()) {
            return this.A00;
        }
        return this.A06.A04.A02;
    }

    public final void A08(int i2) {
        A09(i2, -9223372036854775807L);
    }

    public final void A09(int i2, long j2) {
        long A00;
        AbstractC0733Ao abstractC0733Ao = this.A06.A03;
        if (i2 >= 0) {
            boolean A0E = abstractC0733Ao.A0E();
            if (A0N[5].length() == 22) {
                String[] strArr = A0N;
                strArr[6] = "k";
                strArr[2] = "F";
                if (A0E || i2 < abstractC0733Ao.A01()) {
                    this.A09 = true;
                    this.A02++;
                    boolean A0B = A0B();
                    if (A0N[7].length() != 1) {
                        String[] strArr2 = A0N;
                        strArr2[1] = "iOLxdGxzjtj8VTTv";
                        strArr2[3] = "k2rTYfByBhCiNj1b";
                        if (A0B) {
                            String A02 = A02(2, 13, 112);
                            String[] strArr3 = A0N;
                            if (strArr3[4].length() == strArr3[0].length()) {
                                A0N[7] = "fs0FIhTd6T569fWM98lB5KOUS";
                                Log.w(A02, A02(50, 39, 10));
                                this.A0C.obtainMessage(0, 1, -1, this.A06).sendToTarget();
                                return;
                            }
                        } else {
                            this.A01 = i2;
                            if (abstractC0733Ao.A0E()) {
                                int i3 = (j2 > (-9223372036854775807L) ? 1 : (j2 == (-9223372036854775807L) ? 0 : -1));
                                if (A0N[7].length() == 1) {
                                    throw new RuntimeException();
                                }
                                A0N[5] = "dOqGbPzaS7jKfyvdUFqkQf";
                                this.A04 = i3 == 0 ? 0L : j2;
                                this.A00 = 0;
                            } else {
                                if (j2 == -9223372036854775807L) {
                                    A00 = abstractC0733Ao.A0B(i2, this.A0G).A01();
                                } else {
                                    A00 = A3.A00(j2);
                                }
                                Pair<Integer, Long> A07 = abstractC0733Ao.A07(this.A0G, this.A0F, i2, A00);
                                this.A04 = A3.A01(A00);
                                this.A00 = ((Integer) A07.first).intValue();
                            }
                            this.A0E.A0y(abstractC0733Ao, i2, A3.A00(j2));
                            Iterator<AX> it = this.A0K.iterator();
                            while (it.hasNext()) {
                                AX next = it.next();
                                String[] strArr4 = A0N;
                                if (strArr4[4].length() != strArr4[0].length()) {
                                    throw new RuntimeException();
                                }
                                String[] strArr5 = A0N;
                                strArr5[1] = "l5NWk5x9vooO50uu";
                                strArr5[3] = "FcAzQ8glamB386Jq";
                                next.ABf(1);
                            }
                            return;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        throw new AN(abstractC0733Ao, i2, j2);
    }

    public final void A0A(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            A04((AT) message.obj, message.arg1, message.arg2 != -1, message.arg2);
            return;
        }
        if (i2 != 1) {
            String[] strArr = A0N;
            if (strArr[4].length() == strArr[0].length()) {
                A0N[5] = "7KT5lT3IIkvardi0cOE285";
                if (i2 == 2) {
                    A9 a9 = (A9) message.obj;
                    this.A05 = a9;
                    Iterator<AX> it = this.A0K.iterator();
                    while (true) {
                        boolean hasNext = it.hasNext();
                        String[] strArr2 = A0N;
                        if (strArr2[4].length() != strArr2[0].length()) {
                            throw new RuntimeException();
                        }
                        A0N[7] = "lr70Wm3MPuK1";
                        if (hasNext) {
                            it.next().ABb(a9);
                        } else {
                            return;
                        }
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        } else {
            AU au = (AU) message.obj;
            if (!this.A07.equals(au)) {
                this.A07 = au;
                CopyOnWriteArraySet<AX> copyOnWriteArraySet = this.A0K;
                String[] strArr3 = A0N;
                if (strArr3[6].length() == strArr3[2].length()) {
                    String[] strArr4 = A0N;
                    strArr4[1] = "XPkhdR3hZ8JGZkbg";
                    strArr4[3] = "HitM1md97HqEAHyx";
                    Iterator<AX> it2 = copyOnWriteArraySet.iterator();
                    while (it2.hasNext()) {
                        it2.next().ABZ(au);
                    }
                    return;
                }
            } else {
                return;
            }
        }
        throw new RuntimeException();
    }

    public final boolean A0B() {
        return !A06() && this.A06.A04.A01();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void A3D(AX ax) {
        this.A0K.add(ax);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1278Wo
    public final C0725Af A4J(InterfaceC0724Ae interfaceC0724Ae) {
        return new C0725Af(this.A0E, interfaceC0724Ae, this.A06.A03, A6E(), this.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A5o() {
        long A5p = A5p();
        long A6N = A6N();
        if (A5p != -9223372036854775807L) {
            int i2 = (A6N > (-9223372036854775807L) ? 1 : (A6N == (-9223372036854775807L) ? 0 : -1));
            String[] strArr = A0N;
            if (strArr[6].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0N;
            strArr2[6] = "7";
            strArr2[2] = "n";
            if (i2 != 0) {
                String[] strArr3 = A0N;
                if (strArr3[4].length() != strArr3[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0N;
                strArr4[6] = PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W;
                strArr4[2] = "D";
                if (A6N == 0) {
                    return 100;
                }
                return C0923Il.A06((int) ((100 * A5p) / A6N), 0, 100);
            }
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A5p() {
        if (A06()) {
            return this.A04;
        }
        return A00(this.A06.A09);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A66() {
        if (A0B()) {
            this.A06.A03.A09(this.A06.A04.A02, this.A0F);
            return this.A0F.A08() + A3.A01(this.A06.A01);
        }
        return A6B();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A68() {
        if (A0B()) {
            return this.A06.A04.A00;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A69() {
        if (A0B()) {
            return this.A06.A04.A01;
        }
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A6B() {
        if (A06()) {
            return this.A04;
        }
        return A00(this.A06.A0A);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final AbstractC0733Ao A6D() {
        return this.A06.A03;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final int A6E() {
        if (A06()) {
            return this.A01;
        }
        return this.A06.A03.A09(this.A06.A04.A02, this.A0F).A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final long A6N() {
        AbstractC0733Ao abstractC0733Ao = this.A06.A03;
        if (abstractC0733Ao.A0E()) {
            return -9223372036854775807L;
        }
        if (A0B()) {
            FL fl = this.A06.A04;
            abstractC0733Ao.A09(fl.A02, this.A0F);
            return A3.A01(this.A0F.A0A(fl.A00, fl.A01));
        }
        return abstractC0733Ao.A0B(A6E(), this.A0G).A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final boolean A77() {
        return this.A0A;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1278Wo
    public final void ACz(FN fn, boolean z, boolean z2) {
        this.A05 = null;
        AT A01 = A01(z, z2, 2);
        this.A08 = true;
        this.A02++;
        this.A0E.A0z(fn, z, z2);
        A05(A01, false, 4, 1, false, false);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void ADS() {
        StringBuilder sb = new StringBuilder();
        sb.append(A02(38, 8, 2));
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(A02(0, 2, 7));
        sb.append(A02(15, 18, 78));
        String A02 = A02(47, 3, 94);
        sb.append(A02);
        sb.append(C0923Il.A04);
        sb.append(A02);
        sb.append(AJ.A00());
        sb.append(A02(46, 1, 86));
        Log.i(A02(2, 13, 112), sb.toString());
        this.A0E.A0x();
        this.A0C.removeCallbacksAndMessages(null);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEB(long j2) {
        A09(A6E(), j2);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEC() {
        A08(A6E());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AES(boolean z) {
        if (this.A0A != z) {
            this.A0A = z;
            this.A0E.A10(z);
            A05(this.A06, false, 4, 1, false, true);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0722Ac
    public final void AEs(boolean z) {
        if (z) {
            this.A05 = null;
        }
        AT A01 = A01(z, z, 1);
        this.A02++;
        this.A0E.A11(z);
        A05(A01, false, 4, 1, false, false);
    }
}
