package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class X0 implements C9G {
    @Nullable
    public static PackageInfo A03;
    public static LT A04;
    @Nullable
    public static String A05;
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"rjWu3o3XUIKJimpXtRLH", "N3hUjd9gC1zTrolrzHWDwio6K0KaeF7v", "V8BOZxTrBek9nlJry76rEN1tEiA1lgnf", "2kaCuDD1e44XjFqxj97oS3bW7Y4jUXps", "VcJxC1jbHxk7XwGyeCWvHwY9E4qRcx1x", "dO6RHNbAuKw0kDbwpnJR", "8jPNINbp0cYAxxIn", "ugIdyp1aSJPFHYCiUHctz2XPYC5YD6Ud"};
    public static final C0T[] A09;
    public static final AtomicBoolean A0A;
    public static final AtomicInteger A0B;
    public final C06205v A00;
    public final C8J A01;
    public final C06908w A02;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A08[6].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[1] = "AJGqtkftO03LFXDJsHlFXR4ujVWNfKsn";
            strArr[7] = "0weTThgY8dzMPuXGgH30KJvXs1017h9U";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 73);
            i5++;
        }
    }

    public static void A08() {
        A07 = new byte[]{40, Draft_75.CR, 21, 23, 23, 17, 7, 7, 29, 22, 29, 24, 29, 0, Draft_75.CR, 11, 17, 26, 21, 22, 24, 17, 16, 41, 46, 56, 45, 42, 60, 87, 98, 109, 98, 111, 108, 100, 85, 68, 68, 75, 89, 93, 90, 75, 71, 80, 95, 75, 66, 81, 70, 71, 93, 91, 90, 78, 92, 71, 78, 92, 44, 62, 36, 41, 86, 67, 67, 69, 94, 85, 66, 67, 94, 88, 89, 72, 94, 83, 106, 97, 108, 108, 109, 122, 119, 124, 103, 99, 109, 102, 119, 109, 112, 124, 122, 105, 123, 62, 41, 50, 56, 48, 57, 79, 77, 92, 92, 73, 72, 83, 69, 72, 95, 21, 23, 4, 4, 31, 19, 4, 67, 70, 83, 70, 88, 87, 85, 72, 68, 66, 84, 84, 78, 73, 64, 88, 72, 87, 83, 78, 72, 73, 84, 92, 89, 76, 89, 71, 72, 74, 87, 91, 93, 75, 75, 81, 86, 95, 71, 87, 72, 76, 81, 87, 86, 75, 71, 91, 87, 77, 86, 76, 74, 65, 111, 106, Byte.MAX_VALUE, 106, 116, 123, 121, 100, 104, 110, 120, 120, 98, 101, 108, 116, 100, 123, Byte.MAX_VALUE, 98, 100, 101, 120, 116, 120, Byte.MAX_VALUE, 106, Byte.MAX_VALUE, 110, 28, 29, 22, 11, 17, 12, 1, Draft_75.CR, 30, 5, 5, 14, 7, 20, 8, 4, 25, 14, 20, 14, 29, 14, 5, 31, 24, 48, 35, 56, 56, 51, 58, 41, 58, 57, 49, 49, 51, 50, 30, 57, 49, 52, 61, 60, 120, 44, 55, 120, 58, 45, 49, 52, 60, 120, 45, 43, 61, 42, 120, 44, 55, 51, 61, 54, 95, 86, 68, 72, 82, 79, 88, 71, 91, 86, 78, 82, 69, 52, 57, 59, 60, 48, 61, 38, 58, 56, 58, 49, 60, 38, 45, 42, 38, 52, 42, 37, 40, 51, 63, 35, 57, 62, 47, 41, 47, 40, 53, 50, 39, 42, 42, 35, 52, 75, 72, 68, 70, 75, 66, 109, 97, 107, 101, 5, Draft_75.CR, 12, 1, 9, 28, 1, 7, 6, 23, 27, Draft_75.CR, 26, 30, 1, 11, Draft_75.CR, 72, 67, 82, 81, 73, 84, 77, 89, 82, 95, 86, 67, 93, 64, 64, 91, 74, 75, 15, 9, 27, 2, 27, 31, 2, 28, Draft_75.CR, Draft_75.CR, 2, 20, 19, 14, 9, 28, 17, 17, 24, 25, 96, 102, 116, 109, 116, 112, 109, 115, 98, 98, 109, 100, 119, 96, 97, 123, 125, 124, 97, 113, 96, 119, 119, 124, 109, 122, 119, 123, 117, 122, 102, 63, 47, 62, 41, 41, 34, 51, 59, 37, 40, 56, 36, Byte.MAX_VALUE, 104, 103, 115, 111, 109, 124, 109, 110, 101, 96, 101, 120, 117, 53, 35, 53, 53, 47, 41, 40, 57, 50, 47, 43, 35, 26, 1, 6, 27, 22, 70, 64, 86, 65, 76, 82, 84, 86, 93, 71, 33, 54, 59, 39, 54, 37, 54, 58, 36, 115, 113, 122, 113, 102, 125, 119, 118, 109, 116, 116};
    }

    static {
        A08();
        A0A = new AtomicBoolean();
        A0B = new AtomicInteger(0);
        A05 = null;
        A06 = false;
        A09 = new C0T[]{C0T.A10, C0T.A0e, C0T.A11, C0T.A19, C0T.A0v, C0T.A0x, C0T.A1u, C0T.A1v, C0T.A1w};
    }

    public X0(C8J c8j, boolean z, C06205v c06205v) {
        this.A01 = c8j;
        this.A02 = new C06908w(c8j);
        this.A00 = c06205v;
        A09(c8j, z);
    }

    @Nullable
    public static synchronized PackageInfo A00(C8J c8j) {
        PackageInfo packageInfo;
        synchronized (X0.class) {
            if (!A06) {
                A03 = C0989Lf.A00(c8j);
                A06 = true;
            }
            packageInfo = A03;
        }
        return packageInfo;
    }

    public static synchronized LT A01(C8J c8j) {
        LT lt;
        synchronized (X0.class) {
            if (A04 == null) {
                A04 = LU.A00(c8j.A03().A8H());
            }
            lt = A04;
        }
        return lt;
    }

    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public static String A04(C8J c8j, String str) {
        try {
            PackageManager packageManager = c8j.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return C0987Lb.A03(packageManager.getApplicationInfo(str, 0).sourceDir);
        } catch (Exception e2) {
            if (A0A.compareAndSet(false, true)) {
                c8j.A06().A8q(A03(474, 7, 93), C06808m.A1D, new C06818n(e2));
            }
            return null;
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A09(final C8J c8j, boolean z) {
        if (!A0B.compareAndSet(0, 1)) {
            return;
        }
        A01(c8j);
        try {
            final SharedPreferences A00 = C0967Kg.A00(c8j);
            C06908w c06908w = new C06908w(c8j);
            final String str = A03(26, 4, 37) + c06908w.A05();
            A05 = A00.getString(str, null);
            FutureTask futureTask = new FutureTask(new Callable<Boolean>() { // from class: com.facebook.ads.redexgen.X.9I
                public static byte[] A03;
                public static String[] A04 = {"XdxsWQHKmAYrPa6mv803llFsbG6xUBv1", "0ZMGl2pSIAaZIEqvxPmnMQII5PMyDfzp", "xK6bN8ERsE3qlK", "WJOztIfqKvqLg1zb8DcclROO5I1m6hYl", "NZ35AS4Ok4U2uFg9Bn0RAVLmEZFAhNaA", "i6NGDYiwjEbiTB59W8H8ewYatIcL2Rm5", "tt3j", "3tQ5yRyF2hXRO3n7qZm1zDaXW"};

                public static String A01(int i2, int i3, int i4) {
                    byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
                    int i5 = 0;
                    while (true) {
                        int length = copyOfRange.length;
                        if (A04[2].length() != 14) {
                            throw new RuntimeException();
                        }
                        A04[0] = "ijq86j9eF5Bfako4vk0V9m1lrfYXSgO1";
                        if (i5 >= length) {
                            return new String(copyOfRange);
                        }
                        copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 105);
                        i5++;
                    }
                }

                public static void A02() {
                    A03 = new byte[]{124};
                }

                static {
                    A02();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
                    if (A01(0, 1, 70).equals(android.os.Build.VERSION.CODENAME) != false) goto L11;
                 */
                @Override // java.util.concurrent.Callable
                /* renamed from: A00 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Boolean call() throws java.lang.Exception {
                    /*
                        r5 = this;
                        r4 = 0
                        int r1 = android.os.Build.VERSION.SDK_INT
                        r0 = 31
                        if (r1 >= r0) goto L17
                        java.lang.String r3 = android.os.Build.VERSION.CODENAME
                        r2 = 0
                        r1 = 1
                        r0 = 70
                        java.lang.String r0 = A01(r2, r1, r0)
                        boolean r0 = r0.equals(r3)
                        if (r0 == 0) goto L25
                    L17:
                        com.facebook.ads.redexgen.X.8J r0 = com.facebook.ads.redexgen.X.C8J.this
                        boolean r0 = com.facebook.ads.redexgen.X.JD.A1n(r0)
                        if (r0 == 0) goto L25
                        com.facebook.ads.redexgen.X.8J r0 = com.facebook.ads.redexgen.X.C8J.this
                        java.lang.String r4 = com.facebook.ads.redexgen.X.C0987Lb.A01(r0)
                    L25:
                        if (r4 != 0) goto L55
                        com.facebook.ads.redexgen.X.8J r1 = com.facebook.ads.redexgen.X.C8J.this
                        java.lang.String r0 = r1.getPackageName()
                        java.lang.String r0 = com.facebook.ads.redexgen.X.X0.A05(r1, r0)
                        com.facebook.ads.redexgen.X.X0.A06(r0)
                    L34:
                        android.content.SharedPreferences r0 = r2
                        android.content.SharedPreferences$Editor r2 = r0.edit()
                        java.lang.String r1 = r3
                        java.lang.String r0 = com.facebook.ads.redexgen.X.X0.A02()
                        android.content.SharedPreferences$Editor r0 = r2.putString(r1, r0)
                        r0.apply()
                        java.util.concurrent.atomic.AtomicInteger r1 = com.facebook.ads.redexgen.X.X0.A07()
                        r0 = 2
                        r1.set(r0)
                        r0 = 1
                        java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                        return r0
                    L55:
                        com.facebook.ads.redexgen.X.X0.A06(r4)
                        goto L34
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C9I.call():java.lang.Boolean");
                }
            });
            Executors.newSingleThreadExecutor().submit(futureTask);
            if (z) {
                futureTask.get();
            }
        } catch (Exception unused) {
            A0B.set(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x01b9, code lost:
        if (r4 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x01bb, code lost:
        r5.put(A03(55, 5, 70), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x01c7, code lost:
        r5.put(A03(450, 5, 6), java.lang.String.valueOf(com.facebook.ads.redexgen.X.LZ.A05(r9.A01)));
        r4 = r9.A01.A03().A6u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x01e6, code lost:
        if (r4 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x01e8, code lost:
        r0 = A03(326, 17, 1);
        r5.put(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x01f4, code lost:
        r4 = java.lang.String.valueOf(r9.A02.A0B());
        r0 = A03(2, 21, 29);
        r5.put(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0211, code lost:
        if (r9.A02.A02() == (-1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0213, code lost:
        r4 = java.lang.String.valueOf(r9.A02.A02());
        r0 = A03(36, 19, 93);
        r5.put(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x022a, code lost:
        r4 = com.facebook.ads.redexgen.X.C9B.A05(r9.A01);
        r0 = A03(465, 9, 62);
        r5.put(r0, r4);
        r4 = com.facebook.ads.redexgen.X.C0988Le.A01(com.facebook.ads.redexgen.X.C06898v.A02());
        r0 = A03(30, 6, 106);
        r5.put(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0257, code lost:
        if (com.facebook.ads.redexgen.X.JC.A05(r9.A01) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0259, code lost:
        r4 = r9.A01.A03().A6b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0263, code lost:
        if (r4 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0265, code lost:
        r0 = A03(60, 4, 36);
        r5.put(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0271, code lost:
        r8 = r9.A01.A05().A6G();
        r6 = A03(174, 29, 98);
        r7 = A03(143, 31, 81);
        r4 = A03(120, 23, 78);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0299, code lost:
        if (r8 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x029b, code lost:
        r5.put(r4, r8.A08());
        r5.put(r7, java.lang.String.valueOf(r8.A05()));
        r5.put(r6, java.lang.String.valueOf(r8.A06()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x02b8, code lost:
        r5.put(A03(103, 10, 69), com.facebook.ads.redexgen.X.C04910u.A00());
        r4 = r9.A00.A03(r9.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x02d1, code lost:
        if (r4 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x02d7, code lost:
        if (android.text.TextUtils.isEmpty(r4) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x02d9, code lost:
        r5.put(A03(78, 19, 97), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x02e6, code lost:
        r5.put(A03(267, 13, 94), java.lang.String.valueOf(r9.A01.A02().A7u()));
        r5.put(A03(228, 13, 63), java.lang.String.valueOf(com.facebook.ads.redexgen.X.C8g.A0H(r9.A01)));
        r7 = new java.lang.StringBuilder();
        r6 = com.facebook.ads.redexgen.X.X0.A09;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0320, code lost:
        r0 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0322, code lost:
        if (r4 >= r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0324, code lost:
        r0 = r6[r4].A02();
        r7.append(r0 + com.tencent.matrix.trace.constants.Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM);
        r0 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0331, code lost:
        if (r4 == (r0 - 1)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0333, code lost:
        r7.append(A03(1, 1, 104));
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x033e, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0341, code lost:
        r0 = A03(481, 4, 81);
        r5.put(r4, r0);
        r5.put(r7, r0);
        r5.put(r6, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0361, code lost:
        if (r4 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0365, code lost:
        r4 = r7.toString();
        r2 = com.facebook.ads.redexgen.X.X0.A08;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x037b, code lost:
        if (r2[0].length() == r2[5].length()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0382, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0383, code lost:
        com.facebook.ads.redexgen.X.X0.A08[6] = "RdA";
        r5.put(A03(210, 18, 2), r4);
        r4 = A00(r9.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x039a, code lost:
        if (r4 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x039c, code lost:
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x039d, code lost:
        r5.put(A03(361, 20, 20), java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x03ae, code lost:
        if (r4 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x03b0, code lost:
        r5.put(A03(381, 18, 123), java.lang.String.valueOf(r4.versionCode));
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x03c3, code lost:
        return r5;
     */
    @Override // com.facebook.ads.redexgen.X.C9G
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.String, java.lang.String> A6S() {
        /*
            Method dump skipped, instructions count: 964
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.X0.A6S():java.util.Map");
    }

    @Override // com.facebook.ads.redexgen.X.C9G
    public final String A7S() {
        return A7T(C9F.A00());
    }

    @Override // com.facebook.ads.redexgen.X.C9G
    public final String A7T(C9E c9e) {
        A09(this.A01, true);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map<String, String> A6S = A6S();
                if (TextUtils.isEmpty(C06075h.A00().A03())) {
                    C06075h.A07(this.A01);
                }
                A6S.put(A03(280, 4, 52), C06075h.A00().A03());
                A6S.put(A03(455, 10, 90), C9L.A06(this.A02, this.A01, false));
                if (JD.A1E(this.A01)) {
                    A6S.put(A03(103, 10, 69), C04910u.A00());
                }
                Iterator<Map.Entry<String, String>> it = A6S.entrySet().iterator();
                while (it.hasNext()) {
                    if (!c9e.A2N(it.next().getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(A6S).toString().getBytes());
                deflaterOutputStream.close();
                String replaceAll = byteArrayOutputStream.toString().replaceAll(A03(0, 1, 107), A03(0, 0, 37));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return replaceAll;
            } catch (IOException e2) {
                throw new RuntimeException(A03(241, 26, 17), e2);
            }
        } catch (Throwable th) {
            String[] strArr = A08;
            if (strArr[1].charAt(17) != strArr[7].charAt(17)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "tBEywTa582eygB6ZDfuZ";
            strArr2[5] = "t5OASyUSxnrvHDDzBp0B";
            if (deflaterOutputStream != null) {
                try {
                    deflaterOutputStream.close();
                } catch (IOException unused2) {
                    throw th;
                }
            }
            if (base64OutputStream != null) {
                base64OutputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }
}
