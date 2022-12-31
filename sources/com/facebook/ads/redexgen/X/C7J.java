package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.7J  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C7J {
    public static AnonymousClass00 A0A;
    public static List<String> A0B;
    public static byte[] A0C;
    public static String[] A0D = {"8gkZjHnxCvZyg7TzwjjGeSdvls9L7Gam", "fcbSC3ja3K2jNylkxCBC51G6bXitMdQ0", "2foOCT", "ocB0m3", "KfMQJM794wt5IuG", "feDb68pnVWWOEqV45c", "KnEa0S3Tnigt4irEXno07XBXpnYxFsFq", "aK1UKkDbG3zR1xh0x3umKxUvmkPLseuR"};
    public static final String A0E;
    public static final Map<String, AnonymousClass06> A0F;
    public long A00;
    public C0937Jb A01;
    public final C7K A03;
    public final C8J A04;
    public final boolean A08;
    public final boolean A09;
    public final Map<String, Bitmap> A07 = Collections.synchronizedMap(new HashMap());
    public final Handler A02 = new Handler(Looper.getMainLooper());
    public final List<Callable<Boolean>> A05 = new ArrayList();
    public final List<Callable<Boolean>> A06 = new ArrayList();

    public static String A08(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A0E() {
        A0C = new byte[]{123, Byte.MAX_VALUE, -80, Byte.MIN_VALUE, -82, 124, 126, Byte.MIN_VALUE, 105, 107, 110, 102, 109, -102, 109, -101, 81, -125, Byte.MAX_VALUE, 126, Byte.MAX_VALUE, 126, Byte.MIN_VALUE, 126, -119, -89, -87, -82, -85, 102, -71, -70, -89, -72, -70, -85, -86, 116, -113, -83, -81, -76, -75, -70, -77, 108, -81, -69, -71, -68, -72, -79, -64, -79, Byte.MAX_VALUE, -99, -97, -92, -91, -86, -93, 92, -94, -99, -91, -88, -95, -96, 100, -126, -124, -119, -118, -113, -120, 65, -108, -107, -126, -109, -107, -122, -123, 79, 79, 79, -116, -65, -86, -84, -73, -69, -80, -74, -75, 103, -66, -81, -80, -77, -84, 103, -84, -65, -84, -86, -68, -69, -80, -75, -82, 103, -86, -88, -86, -81, -84, 103, -85, -74, -66, -75, -77, -74, -88, -85, -70, 117, -79, -81, -79, -74, -77, -111, -67, -69, -66, -70, -77, -62, -73, -67, -68, -106, -67, -67, -71, 120, 118, 120, 125, 122, 91, 118, 126, -127, -118, -121, 122, 93, -124, -124, Byte.MIN_VALUE, -120, -101, -120, -122, -104, -105, -120, -24, -21, -35, -32, -27, -24, -38, -35, -40, -19, -30, -26, -34, -40, -26, -20, -96, -107, -100, -92};
    }

    static {
        A0E();
        A0E = C7J.class.getSimpleName();
        A0F = Collections.synchronizedMap(new HashMap());
    }

    public C7J(C8J c8j) {
        this.A04 = c8j;
        this.A03 = C7K.A06(c8j.A00());
        this.A08 = JD.A1p(c8j);
        this.A09 = JD.A1w(c8j, QJ.A03());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.07] */
    public static synchronized AnonymousClass00 A03(XS xs) {
        AnonymousClass00 anonymousClass00;
        synchronized (C7J.class) {
            if (A0A == null) {
                A0A = AnonymousClass01.A00(xs, new Object() { // from class: com.facebook.ads.redexgen.X.07
                    public int A00;
                    public int A01;
                    public boolean A02;
                    public boolean A03;
                    public boolean A04;

                    public final AnonymousClass07 A00(int i2) {
                        this.A00 = i2;
                        return this;
                    }

                    public final AnonymousClass07 A01(int i2) {
                        this.A01 = i2;
                        return this;
                    }

                    public final AnonymousClass07 A02(boolean z) {
                        this.A02 = z;
                        return this;
                    }

                    public final AnonymousClass07 A03(boolean z) {
                        this.A03 = z;
                        return this;
                    }

                    public final AnonymousClass07 A04(boolean z) {
                        this.A04 = z;
                        return this;
                    }

                    public final AnonymousClass08 A05() {
                        return new AnonymousClass08(this.A00, this.A02, this.A01, this.A03, this.A04);
                    }
                }.A00(JD.A04(xs)).A02(xs.A03().A8H()).A01(-1).A03(JD.A0j(xs)).A04(JD.A1v(xs)).A05(), A05(xs));
            }
            anonymousClass00 = A0A;
        }
        return anonymousClass00;
    }

    public static AnonymousClass06 A04(C8J c8j, String str) {
        AnonymousClass06 anonymousClass06 = A0F.get(str);
        if (C7M.A06(c8j) && anonymousClass06 != null) {
            return new AnonymousClass06(anonymousClass06);
        }
        return new AnonymousClass06(str);
    }

    public static C0L A05(XS xs) {
        return new XW(xs);
    }

    public static synchronized List<String> A09(C8J c8j) {
        List<String> list;
        synchronized (C7J.class) {
            if (A0B == null) {
                A0B = new ArrayList();
                A0H(A0B, c8j);
            }
            list = A0B;
        }
        return list;
    }

    public static AtomicBoolean A0C(ArrayList<Callable<Boolean>> arrayList) {
        ArrayList<Future> arrayList2 = new ArrayList(arrayList.size());
        Iterator<Callable<Boolean>> it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            String[] strArr = A0D;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            A0D[5] = "";
            if (!hasNext) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                try {
                    for (Future future : arrayList2) {
                        Boolean bool = (Boolean) future.get();
                        atomicBoolean.set(atomicBoolean.get() && bool != null && bool.booleanValue());
                    }
                } catch (InterruptedException | ExecutionException e2) {
                    Log.e(A0E, A08(86, 42, 61), e2);
                    atomicBoolean.set(false);
                }
                return atomicBoolean;
            }
            arrayList2.add(MA.A02().submit(it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(EnumC0936Ja enumC0936Ja) {
        if (this.A01 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(A08(174, 12, 111), C1008Ly.A04(this.A00));
        this.A01.A02(enumC0936Ja, hashMap);
    }

    public static void A0H(List<String> list, C8J c8j) {
        A0I(list, C1567dM.A01(c8j));
        A0I(list, C7K.A07(c8j));
    }

    public static void A0I(List<String> list, File file) {
        String path;
        if (file == null || (path = file.getPath()) == null) {
            return;
        }
        String[] strArr = A0D;
        if (strArr[3].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[3] = "Vghlgc";
        strArr2[2] = "qwUey9";
        if (path != A08(0, 0, 127)) {
            list.add(path.toLowerCase(Locale.getDefault()));
        }
    }

    @Nullable
    public final Bitmap A0K(String str) {
        return this.A07.get(str);
    }

    @Nullable
    public final Bitmap A0L(String str, int i2, int i3) {
        if (this.A08) {
            AnonymousClass06 A04 = A04(this.A04, str);
            A04.A03 = A08(186, 4, 35);
            A04.A01 = i3;
            A04.A00 = i2;
            return A03(this.A04.A00()).ADm(A04, true).A00();
        }
        return this.A03.A0E(this.A04, str, i2, i3, A08(170, 4, 114));
    }

    @Nullable
    public final File A0M(String str) {
        AnonymousClass06 A04 = A04(this.A04, str);
        A04.A03 = A08(186, 4, 35);
        return A03(this.A04.A00()).ADn(A04);
    }

    @Nullable
    public final File A0N(String str) {
        if (this.A08) {
            return A0M(str);
        }
        return this.A03.A0F(str);
    }

    public final String A0O(String str) {
        if (this.A08) {
            return A0P(str);
        }
        return this.A03.A0G(str);
    }

    public final String A0P(String cachedUrl) {
        AnonymousClass06 A04 = A04(this.A04, cachedUrl);
        A04.A03 = A08(186, 4, 35);
        String ADp = A03(this.A04.A00()).ADp(A04);
        return ADp != null ? ADp : cachedUrl;
    }

    public final String A0Q(String str) {
        if (this.A09) {
            return str;
        }
        return A0P(str);
    }

    public final void A0R() {
        KI.A05(A08(128, 19, 68), A08(38, 16, 66), A08(16, 8, 19));
    }

    public final void A0S() {
        KI.A05(A08(147, 16, 11), A08(54, 14, 50), A08(0, 8, 64));
    }

    public final void A0T() {
        this.A07.clear();
    }

    public final void A0U(@Nullable C7B c7b, C7C c7c) {
        KI.A05(A08(163, 7, 25), A08(68, 18, 23), A08(8, 8, 44));
        this.A00 = System.currentTimeMillis();
        C7M.A02(this.A04, c7c, C7M.A07, A08(24, 14, 60), -1L);
        MA.A03().execute(new XX(this, new ArrayList(this.A05), c7b, c7c, new ArrayList(this.A06)));
        this.A05.clear();
        this.A06.clear();
    }

    public final void A0V(final C7G c7g) {
        Callable<Boolean> callable = new Callable<Boolean>(c7g) { // from class: com.facebook.ads.redexgen.X.7H
            public static byte[] A02;
            public static String[] A03 = {"jwTNBF52XqMGgcVEiQTwvXvSBsl43Bcu", "zl9XISU", "9LwyCiCzMXmNgkxTRjX8XUqiNT4UlidW", "Jar4Zz8ck96tLH67JFbLbWmYESMeU49V", "Yd8bjyjazIom6Oxe2tnjIAJyfdSlHwWG", "VgUZ5KaBAYbzt3oMIew8EQ4BA2c", "hXTgBapwd4emagenALPcDOSBW5zmdf3H", "17k"};
            public final C7G A00;

            public static String A01(int i2, int i3, int i4) {
                byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
                int i5 = 0;
                while (true) {
                    int length = copyOfRange.length;
                    if (A03[1].length() == 32) {
                        throw new RuntimeException();
                    }
                    A03[3] = "";
                    if (i5 >= length) {
                        return new String(copyOfRange);
                    }
                    copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 48);
                    i5++;
                }
            }

            public static void A02() {
                A02 = new byte[]{-20, -16, -28, -22, -24};
            }

            static {
                A02();
            }

            {
                this.A00 = c7g;
            }

            private final Boolean A00() {
                C8J c8j;
                boolean z;
                C8J c8j2;
                AnonymousClass00 A032;
                boolean z2;
                boolean z3;
                C7K c7k;
                Map map;
                if (C0974Kn.A02(this)) {
                    return null;
                }
                try {
                    TrafficStats.setThreadStatsTag(61453);
                    AnonymousClass06 anonymousClass06 = new AnonymousClass06(this.A00.A07, this.A00.A06, this.A00.A05, A01(0, 5, 83), this.A00.A01, this.A00.A02);
                    anonymousClass06.A01 = this.A00.A04;
                    anonymousClass06.A00 = this.A00.A03;
                    c8j = C7J.this.A04;
                    if (C7M.A06(c8j)) {
                        map = C7J.A0F;
                        map.put(this.A00.A07, anonymousClass06);
                    }
                    z = C7J.this.A08;
                    boolean z4 = false;
                    if (A03[3].length() != 5) {
                        A03[4] = "CZcPy1KhLDdCOlGcBT5xxsnRB32IUDMD";
                        if (!z) {
                            c7k = C7J.this.A03;
                            if (c7k.A0D(this.A00) != null) {
                                z4 = true;
                            }
                        } else {
                            c8j2 = C7J.this.A04;
                            A032 = C7J.A03(c8j2.A00());
                            z4 = A032.ADm(anonymousClass06, false).A01();
                        }
                        C7O c7o = this.A00.A00;
                        if (c7o != null && c7o.A02()) {
                            int A00 = c7o.A00();
                            int A01 = c7o.A01();
                            if (A00 <= 0 || A01 <= 0) {
                                z2 = C7J.this.A08;
                                if (z2) {
                                    A04(this.A00.A07, anonymousClass06);
                                } else {
                                    int i2 = this.A00.A03;
                                    int width = this.A00.A04;
                                    A03(i2, width);
                                }
                            } else {
                                z3 = C7J.this.A08;
                                if (z3) {
                                    anonymousClass06.A00 = A00;
                                    anonymousClass06.A01 = A01;
                                    A04(this.A00.A07, anonymousClass06);
                                } else {
                                    A03(A00, A01);
                                }
                            }
                        }
                        return Boolean.valueOf(z4);
                    }
                    throw new RuntimeException();
                } catch (Throwable th) {
                    C0974Kn.A00(th, this);
                    return null;
                }
            }

            private void A03(int i2, int i3) {
                C7K c7k;
                C8J c8j;
                Map map;
                c7k = C7J.this.A03;
                c8j = C7J.this.A04;
                Bitmap A0E2 = c7k.A0E(c8j, this.A00.A07, i2, i3, this.A00.A01);
                if (A0E2 == null) {
                    return;
                }
                map = C7J.this.A07;
                map.put(this.A00.A07, A0E2);
            }

            private void A04(String str, AnonymousClass06 anonymousClass06) {
                C8J c8j;
                AnonymousClass00 A032;
                Map map;
                c8j = C7J.this.A04;
                A032 = C7J.A03(c8j.A00());
                Bitmap A00 = A032.ADm(anonymousClass06, true).A00();
                if (A00 == null) {
                    return;
                }
                map = C7J.this.A07;
                map.put(str, A00);
            }

            @Override // java.util.concurrent.Callable
            public final /* bridge */ /* synthetic */ Boolean call() throws Exception {
                if (C0974Kn.A02(this)) {
                    return null;
                }
                try {
                    return A00();
                } catch (Throwable th) {
                    C0974Kn.A00(th, this);
                    return null;
                }
            }
        };
        if (!c7g.A02) {
            this.A05.add(callable);
        } else {
            this.A06.add(callable);
        }
    }

    public final void A0W(C7G c7g) {
        c7g.A02 = true;
        A0V(c7g);
    }

    public final void A0X(C7I c7i) {
        this.A05.add(new C7F(this, c7i));
    }

    public final void A0Y(C7I c7i) {
        c7i.A05 = true;
        this.A06.add(new C7F(this, c7i));
    }

    public final void A0Z(C7I c7i) {
        c7i.A05 = true;
        if (this.A09) {
            this.A06.add(new C7E(this, c7i));
        } else {
            this.A06.add(new C7F(this, c7i));
        }
    }

    public final void A0a(C7I c7i) {
        if (this.A09) {
            this.A05.add(new C7E(this, c7i));
        } else {
            this.A05.add(new C7F(this, c7i));
        }
    }

    public final void A0b(C0937Jb c0937Jb) {
        this.A01 = c0937Jb;
    }
}
