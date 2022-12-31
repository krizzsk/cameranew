package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* renamed from: com.facebook.ads.redexgen.X.3x  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class RunnableC05713x implements Runnable {
    public static Comparator<C05703w> A04;
    public static byte[] A05;
    public static String[] A06 = {"C", "g", "thIgEQWd9nx", "UJ", "nKFIv9xSQBz", "WKzZJ6F0j2u08DpGCnjDR9E", "2Nt4JwZoKXCf4OpJNcF1oxTto7W5gJbD", "RW"};
    public static final ThreadLocal<RunnableC05713x> A07;
    public long A00;
    public long A01;
    public ArrayList<C0828Eq> A02 = new ArrayList<>();
    public ArrayList<C05703w> A03 = new ArrayList<>();

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 8);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{97, 101, 47, 93, 116, -126, -125, 116, 115, 47, 95, -127, 116, 117, 116, -125, 114, 119, 92, 96, 42, 90, 124, 111, 112, 111, 126, 109, 114};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new Comparator<C05703w>() { // from class: com.facebook.ads.redexgen.X.3v
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* renamed from: A00 */
            public final int compare(C05703w c05703w, C05703w c05703w2) {
                if ((c05703w.A03 == null) != (c05703w2.A03 == null)) {
                    return c05703w.A03 == null ? 1 : -1;
                } else if (c05703w.A04 != c05703w2.A04) {
                    return c05703w.A04 ? -1 : 1;
                } else {
                    int i2 = c05703w2.A02 - c05703w.A02;
                    if (i2 != 0) {
                        return i2;
                    }
                    int i3 = c05703w.A00 - c05703w2.A00;
                    if (i3 != 0) {
                        return i3;
                    }
                    return 0;
                }
            }
        };
    }

    private AbstractC05784e A00(C0828Eq c0828Eq, int i2, long j2) {
        if (A08(c0828Eq, i2)) {
            return null;
        }
        C4U c4u = c0828Eq.A0r;
        try {
            c0828Eq.A1L();
            AbstractC05784e A0I = c4u.A0I(i2, false, j2);
            if (A0I != null) {
                if (A0I.A0a() && !A0I.A0b()) {
                    c4u.A0X(A0I.A0H);
                } else {
                    c4u.A0d(A0I, false);
                }
            }
            return A0I;
        } finally {
            c0828Eq.A1q(false);
        }
    }

    private void A02() {
        C05703w task;
        int i2 = this.A02.size();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            C0828Eq c0828Eq = this.A02.get(i4);
            int totalTaskCount = c0828Eq.getWindowVisibility();
            if (totalTaskCount == 0) {
                c0828Eq.A02.A04(c0828Eq, false);
                int totalTaskCount2 = c0828Eq.A02.A00;
                i3 += totalTaskCount2;
            }
        }
        this.A03.ensureCapacity(i3);
        int i5 = 0;
        String[] strArr = A06;
        String str = strArr[3];
        String str2 = strArr[7];
        int length = str.length();
        int totalTaskCount3 = str2.length();
        if (length != totalTaskCount3) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[3] = "OH";
        strArr2[7] = "7S";
        for (int i6 = 0; i6 < i2; i6++) {
            C0828Eq c0828Eq2 = this.A02.get(i6);
            int totalTaskCount4 = c0828Eq2.getWindowVisibility();
            if (totalTaskCount4 == 0) {
                C1470bf c1470bf = c0828Eq2.A02;
                int abs = Math.abs(c1470bf.A01) + Math.abs(c1470bf.A02);
                for (int i7 = 0; i7 < c1470bf.A00 * 2; i7 += 2) {
                    if (i5 >= this.A03.size()) {
                        task = new C05703w();
                        this.A03.add(task);
                    } else {
                        task = this.A03.get(i5);
                    }
                    int j2 = i7 + 1;
                    int i8 = c1470bf.A03[j2];
                    task.A04 = i8 <= abs;
                    task.A02 = abs;
                    task.A00 = i8;
                    task.A03 = c0828Eq2;
                    int j3 = c1470bf.A03[i7];
                    task.A01 = j3;
                    i5++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    private void A04(long j2) {
        for (int i2 = 0; i2 < this.A03.size(); i2++) {
            C05703w c05703w = this.A03.get(i2);
            if (c05703w.A03 == null) {
                return;
            }
            A06(c05703w, j2);
            c05703w.A00();
        }
    }

    private final void A05(long j2) {
        A02();
        A04(j2);
    }

    private void A06(C05703w c05703w, long j2) {
        AbstractC05784e A00 = A00(c05703w.A03, c05703w.A01, c05703w.A04 ? LocationRequestCompat.PASSIVE_INTERVAL : j2);
        if (A00 != null && A00.A09 != null && A00.A0a() && !A00.A0b()) {
            A07(A00.A09.get(), j2);
        }
    }

    private void A07(@Nullable C0828Eq c0828Eq, long j2) {
        if (c0828Eq == null) {
            return;
        }
        if (c0828Eq.A0C) {
            C05583k c05583k = c0828Eq.A01;
            if (A06[5].length() != 17) {
                A06[6] = "t2x0aSlbBonOFe0N5m1ttILNz4IaYpUW";
                if (c05583k.A06() != 0) {
                    c0828Eq.A1O();
                }
            }
            throw new RuntimeException();
        }
        C1470bf c1470bf = c0828Eq.A02;
        c1470bf.A04(c0828Eq, true);
        if (c1470bf.A00 != 0) {
            try {
                C2O.A01(A01(0, 18, 7));
                c0828Eq.A0s.A05(c0828Eq.A04);
                int i2 = 0;
                while (true) {
                    int i3 = c1470bf.A00 * 2;
                    if (A06[6].charAt(8) == 'I') {
                        break;
                    }
                    String[] strArr = A06;
                    strArr[3] = "nG";
                    strArr[7] = "TD";
                    if (i2 < i3) {
                        A00(c0828Eq, c1470bf.A03[i2], j2);
                        i2 += 2;
                    } else {
                        return;
                    }
                }
                throw new RuntimeException();
            } finally {
                C2O.A00();
            }
        }
    }

    public static boolean A08(C0828Eq c0828Eq, int i2) {
        int A062 = c0828Eq.A01.A06();
        for (int i3 = 0; i3 < A062; i3++) {
            View attachedView = c0828Eq.A01.A0A(i3);
            AbstractC05784e A0G = C0828Eq.A0G(attachedView);
            if (A0G.A03 == i2 && !A0G.A0b()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C0828Eq c0828Eq) {
        this.A02.add(c0828Eq);
    }

    public final void A0A(C0828Eq c0828Eq) {
        this.A02.remove(c0828Eq);
    }

    public final void A0B(C0828Eq c0828Eq, int i2, int i3) {
        if (c0828Eq.isAttachedToWindow() && this.A01 == 0) {
            this.A01 = c0828Eq.getNanoTime();
            c0828Eq.post(this);
        }
        c0828Eq.A02.A03(i2, i3);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C2O.A01(A01(18, 11, 2));
            if (this.A02.isEmpty()) {
                return;
            }
            int size = this.A02.size();
            long j2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C0828Eq c0828Eq = this.A02.get(i2);
                int i3 = c0828Eq.getWindowVisibility();
                if (i3 == 0) {
                    j2 = Math.max(c0828Eq.getDrawingTime(), j2);
                }
            }
            if (j2 == 0) {
                this.A01 = 0L;
                if (A06[5].length() == 17) {
                    throw new RuntimeException();
                }
                A06[5] = "H4nD1dOrFb1";
                C2O.A00();
                return;
            }
            long latestFrameVsyncMs = TimeUnit.MILLISECONDS.toNanos(j2);
            A05(latestFrameVsyncMs + this.A00);
        } finally {
            this.A01 = 0L;
            C2O.A00();
        }
    }
}
