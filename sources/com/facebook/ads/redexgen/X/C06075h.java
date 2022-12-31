package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.5h  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06075h {
    public static byte[] A00;
    public static String[] A01 = {"zJ7sRo3sU3MwvYkxVq5sKXU", "uwqdBBQkb", "sk1pAaPClwmr1DZFuM4XEVJDjMgj4luU", "2DEAuAVf", "LM1sVeBw6DNfIdZzIYsj5hqYQDPEhJFy", "hYSBjzGCwuKpFZFqojmwIwdxMJLMCyYz", "BWOi5Qn34m6VEGTMmYfzcDYeX0GTjOOy", "rscTiGR64sMWr7IEiXLU0M2EjoTwZlLg"};
    public static final AtomicReference<C06055f> A02;
    public static final AtomicReference<String> A03;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 52);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-98, -90, -95, -100, -84, -77, -94, -81, -81, -90, -95, -94, -95, -97, -88, -97, -84, -93, -99, -20, -25, -23, -28, -30, -14, -7, -24, -11, -11, -20, -25, -24};
    }

    static {
        A05();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>(A04(0, 0, 68));
    }

    public static C06055f A00() {
        C06055f c06055f = A02.get();
        if (A01[6].charAt(15) == 'M') {
            String[] strArr = A01;
            strArr[3] = "GQnQs3ZS";
            strArr[1] = "yTwJu7KeR";
            C06055f c06055f2 = c06055f;
            if (c06055f2 == null) {
                C06055f A002 = C06055f.A00();
                String[] strArr2 = A01;
                if (strArr2[3].length() != strArr2[1].length()) {
                    A01[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                    return A002;
                }
            } else {
                return c06055f2;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L2;
     */
    @androidx.annotation.Nullable
    @android.annotation.SuppressLint({"CatchGeneralException"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.facebook.ads.redexgen.X.C06055f A01(com.facebook.ads.redexgen.X.C8J r5, com.facebook.ads.redexgen.X.C06055f r6) {
        /*
            if (r6 == 0) goto Lc
            java.lang.String r0 = r6.A03()     // Catch: java.lang.Throwable -> L11
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L11
            if (r0 == 0) goto L28
        Lc:
            com.facebook.ads.redexgen.X.5f r0 = com.facebook.ads.redexgen.X.C06125n.A00(r5)     // Catch: java.lang.Throwable -> L11
            return r0
        L11:
            r0 = move-exception
            com.facebook.ads.redexgen.X.8l r5 = r5.A06()
            int r4 = com.facebook.ads.redexgen.X.C06808m.A1E
            com.facebook.ads.redexgen.X.8n r3 = new com.facebook.ads.redexgen.X.8n
            r3.<init>(r0)
            r2 = 12
            r1 = 7
            r0 = 6
            java.lang.String r0 = A04(r2, r1, r0)
            r5.A8q(r0, r4, r3)
        L28:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C06075h.A01(com.facebook.ads.redexgen.X.8J, com.facebook.ads.redexgen.X.5f):com.facebook.ads.redexgen.X.5f");
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static C06055f A02(C8J c8j, C06055f c06055f, C06065g c06065g) {
        C06085i c06085i = null;
        try {
            if (JC.A06(c8j) && (c06055f == null || TextUtils.isEmpty(c06055f.A03()))) {
                c06085i = C06095j.A00(c8j.getContentResolver());
            }
        } catch (Throwable th) {
            c8j.A06().A8q(A04(12, 7, 6), C06808m.A1G, new C06818n(th));
        }
        if (c06085i != null && c06085i.A01 != null) {
            A03.set(c06085i.A01);
            c06065g.A05(c06085i.A01);
        }
        if (c06055f == null && c06085i != null && !TextUtils.isEmpty(c06085i.A00)) {
            return new C06055f(c06085i.A00, c06085i.A02, EnumC06045e.A05);
        }
        return c06055f;
    }

    public static String A03() {
        String attributionId = A03.get();
        if (attributionId == null) {
            return A04(0, 0, 68);
        }
        return attributionId;
    }

    public static void A06(C06065g c06065g) {
        A02.set(c06065g.A02());
        A03.set(c06065g.A03());
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A07(C8J c8j) {
        long j2;
        C06055f upToDateAdInfo;
        try {
            C06065g c06065g = new C06065g(c8j);
            A06(c06065g);
            if (A08()) {
                return;
            }
            C06055f c06055f = A02.get();
            if (c06055f != null && !TextUtils.isEmpty(c06055f.A03())) {
                j2 = c06055f.A01();
            } else {
                j2 = -1;
            }
            if (j2 > 0 && System.currentTimeMillis() - j2 < JC.A00(c8j)) {
                return;
            }
            if (JC.A07(c8j)) {
                upToDateAdInfo = A01(c8j, A02(c8j, null, c06065g));
            } else {
                upToDateAdInfo = A02(c8j, A01(c8j, null), c06065g);
            }
            if (upToDateAdInfo != null && !TextUtils.isEmpty(upToDateAdInfo.A03())) {
                A02.set(upToDateAdInfo);
                c06065g.A04(upToDateAdInfo);
            }
        } catch (Throwable th) {
            c8j.A06().A8q(A04(12, 7, 6), C06808m.A1F, new C06818n(th));
        }
    }

    public static boolean A08() {
        boolean updated = false;
        if (LJ.A04()) {
            if (A01[0].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "OqjdKmMb";
            strArr[1] = "Sbvi0a9C0";
            String A04 = A04(0, 12, 9);
            if (LJ.A05(A04)) {
                A03.set(LJ.A01(A04));
                updated = true;
            }
        }
        boolean A042 = LJ.A04();
        String[] strArr2 = A01;
        if (strArr2[5].charAt(29) != strArr2[4].charAt(29)) {
            A01[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            if (!A042) {
                return updated;
            }
        } else {
            A01[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            if (!A042) {
                return updated;
            }
        }
        String A043 = A04(19, 13, 79);
        if (LJ.A05(A043)) {
            String A012 = LJ.A01(A043);
            AtomicReference<C06055f> atomicReference = A02;
            if (A012 == null) {
                A012 = A04(0, 0, 68);
            }
            atomicReference.set(new C06055f(A012, false, EnumC06045e.A04));
            return true;
        }
        return updated;
    }
}
