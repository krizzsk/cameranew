package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.Hw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0908Hw {
    public static String[] A00 = {"v79OOCD3rFDrBH3Sw8ccat0nkfR9Jk8K", "zaqJSCMgPr8q8xIyOc2JWspWFv3JOD4h", "Sqp2xVCvxFHsc", "s8GBWRpegr", "t6Y6wcH7Q091ZQl7CdWm1Bgnnklpnco", "XVr0n", "MY0M4GS8ICKTpGygoaRzgsCYiOraPhWK", "Pkt85Yo8hwIimoTAGZdJTyJAkZ2fE06T"};

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0090, code lost:
        return r9;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0088: INVOKE  (r3 I:com.facebook.ads.redexgen.X.HR) type: STATIC call: com.facebook.ads.redexgen.X.Il.A0W(com.facebook.ads.redexgen.X.HR):void, block:B:32:0x0088 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0092: INVOKE  (r3 I:com.facebook.ads.redexgen.X.HR) type: STATIC call: com.facebook.ads.redexgen.X.Il.A0W(com.facebook.ads.redexgen.X.HR):void, block:B:36:0x0092 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long A00(com.facebook.ads.redexgen.X.HV r14, long r15, long r17, com.facebook.ads.redexgen.X.HR r19, byte[] r20, @androidx.annotation.Nullable com.facebook.ads.redexgen.X.IZ r21, int r22, com.facebook.ads.redexgen.X.C0907Hv r23) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r2 = r14
        L1:
            r1 = r21
            if (r1 == 0) goto La
            r0 = r22
            r1.A01(r0)
        La:
            r3 = r19
            boolean r0 = java.lang.Thread.interrupted()     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            if (r0 != 0) goto L82
            com.facebook.ads.redexgen.X.HV r4 = new com.facebook.ads.redexgen.X.HV     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            android.net.Uri r5 = r2.A04     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            byte[] r6 = r2.A06     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r9 = r2.A03     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r7 = r15
            long r9 = r9 + r7
            long r0 = r2.A01     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r9 = r9 - r0
            r11 = -1
            java.lang.String r13 = r2.A05     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            int r0 = r2.A00     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r14 = r0 | 2
            r4.<init>(r5, r6, r7, r9, r11, r13, r14)     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r2 = r4
            long r7 = r3.ACf(r2)     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r6 = r23
            long r4 = r6.A01     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r11 = -1
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 != 0) goto L42
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L42
            long r0 = r2.A01     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r0 = r0 + r7
            r6.A01 = r0     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
        L42:
            r9 = 0
        L44:
            int r0 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r0 == 0) goto L8d
            boolean r0 = java.lang.Thread.interrupted()     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            if (r0 != 0) goto L7c
            r7 = 0
            int r0 = (r17 > r11 ? 1 : (r17 == r11 ? 0 : -1))
            r8 = r20
            if (r0 == 0) goto L5f
            int r0 = r8.length     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r4 = (long) r0     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r0 = r17 - r9
            long r4 = java.lang.Math.min(r4, r0)     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            int r0 = (int) r4     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            goto L60
        L5f:
            int r0 = r8.length     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
        L60:
            int r7 = r3.read(r8, r7, r0)     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r0 = -1
            if (r7 != r0) goto L73
            long r4 = r6.A01     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 != 0) goto L8d
            long r0 = r2.A01     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r0 = r0 + r9
            r6.A01 = r0     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            goto L8d
        L73:
            long r0 = (long) r7     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r9 = r9 + r0
            long r4 = r6.A02     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r0 = (long) r7     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            long r4 = r4 + r0
            r6.A02 = r4     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            goto L44
        L7c:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r0.<init>()     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            throw r0     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
        L82:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            r0.<init>()     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
            throw r0     // Catch: com.facebook.ads.redexgen.X.IY -> L88 java.lang.Throwable -> L91
        L88:
            com.facebook.ads.redexgen.X.C0923Il.A0W(r3)
            goto L1
        L8d:
            com.facebook.ads.redexgen.X.C0923Il.A0W(r3)
            return r9
        L91:
            r0 = move-exception
            com.facebook.ads.redexgen.X.C0923Il.A0W(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0908Hw.A00(com.facebook.ads.redexgen.X.HV, long, long, com.facebook.ads.redexgen.X.HR, byte[], com.facebook.ads.redexgen.X.IZ, int, com.facebook.ads.redexgen.X.Hv):long");
    }

    public static String A01(Uri uri) {
        return uri.toString();
    }

    public static String A02(HV hv) {
        return hv.A05 != null ? hv.A05 : A01(hv.A04);
    }

    public static void A03(HV hv, InterfaceC0902Hq interfaceC0902Hq, UN un, byte[] bArr, @Nullable IZ iz, int i2, @Nullable C0907Hv c0907Hv, @Nullable AtomicBoolean atomicBoolean, boolean z) throws IOException, InterruptedException {
        long left;
        C0907Hv counters = c0907Hv;
        I6.A01(un);
        I6.A01(bArr);
        if (counters != null) {
            A04(hv, interfaceC0902Hq, counters);
        } else {
            counters = new C0907Hv();
        }
        String key = A02(hv);
        long j2 = hv.A01;
        if (hv.A02 != -1) {
            left = hv.A02;
        } else {
            left = interfaceC0902Hq.A64(key);
        }
        while (true) {
            long j3 = 0;
            if (left != 0) {
                if (atomicBoolean != null) {
                    boolean z2 = atomicBoolean.get();
                    if (A00[5].length() == 1) {
                        break;
                    }
                    A00[5] = "EAlW89nW7uOIImzUc5SW8CQaYz84C";
                    if (z2) {
                        throw new InterruptedException();
                    }
                }
                long A5s = interfaceC0902Hq.A5s(key, j2, left != -1 ? left : LocationRequestCompat.PASSIVE_INTERVAL);
                if (A5s <= 0) {
                    long j4 = -A5s;
                    String[] strArr = A00;
                    if (strArr[6].length() != strArr[1].length()) {
                        break;
                    }
                    A00[2] = "OFDha7Ysfl6kB";
                    A5s = j4;
                    if (A00(hv, j2, j4, un, bArr, iz, i2, counters) < A5s) {
                        if (!z || left == -1) {
                            return;
                        }
                        throw new EOFException();
                    }
                }
                j2 += A5s;
                if (left != -1) {
                    j3 = A5s;
                }
                left -= j3;
            } else {
                return;
            }
        }
        throw new RuntimeException();
    }

    public static void A04(HV hv, InterfaceC0902Hq interfaceC0902Hq, C0907Hv c0907Hv) {
        long A64;
        String A02 = A02(hv);
        long j2 = hv.A01;
        if (hv.A02 != -1) {
            A64 = hv.A02;
        } else {
            A64 = interfaceC0902Hq.A64(A02);
        }
        c0907Hv.A01 = A64;
        if (A00[5].length() == 1) {
            throw new RuntimeException();
        }
        A00[4] = "nu";
        c0907Hv.A00 = 0L;
        c0907Hv.A02 = 0L;
        while (A64 != 0) {
            long start = interfaceC0902Hq.A5s(A02, j2, A64 != -1 ? A64 : Long.MAX_VALUE);
            if (start > 0) {
                c0907Hv.A00 += start;
            } else {
                start = -start;
                if (start == LocationRequestCompat.PASSIVE_INTERVAL) {
                    return;
                }
            }
            j2 += start;
            if (A64 == -1) {
                start = 0;
            }
            A64 -= start;
        }
    }

    public static void A05(InterfaceC0902Hq interfaceC0902Hq, String str) {
        for (C0906Hu c0906Hu : interfaceC0902Hq.A5t(str)) {
            if (A00[2].length() != 13) {
                throw new RuntimeException();
            }
            A00[4] = "R4HmvLUlpWi57h";
            try {
                interfaceC0902Hq.ADd(c0906Hu);
            } catch (C0900Ho unused) {
            }
        }
    }
}
