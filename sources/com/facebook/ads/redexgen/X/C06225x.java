package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* renamed from: com.facebook.ads.redexgen.X.5x  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C06225x {
    public static byte[] A00;
    public static String[] A01 = {"r7c1s5U0efOStYGowMowhUbuYlQTG1Tt", "4N5luf2P5Kce0fziMzoENYJ9JUsEy4RG", "Zwxj", "L2KmiKnie6D54jPyz7fJn9CofNiJStjg", "Reipc3PbxUqE4G7HYurM4m8tamMVkuwI", "qFHCxa5Kyhox8u", "zslT757DGHQcDkpTRw1DlpZ4hqoBSQOy", "oFLB5GUqllb2V05SIM"};
    public static final AtomicReference<AnonymousClass62> A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[4].charAt(15) != 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "ewynTuX5etTUvRbKneAORAXWy6m3gfja";
            strArr[0] = "MEXbvG7De7lT0m7kyXT3Vo2bJU5t0LAQ";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 28);
            i5++;
        }
    }

    public static void A01() {
        A00 = new byte[]{60, 40, 57, 52, 56, 51, 62, 56, 2, 51, 56, 41, 42, 50, 47, 54, 115, 57, 56, 37, 45, 47, 36, 47, 56, 35, 41};
    }

    static {
        A01();
        A02 = new AtomicReference<>();
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02(@Nullable Activity activity, MotionEvent motionEvent) {
        AnonymousClass62 anonymousClass62;
        try {
            if (C06235y.A0P(activity) && (anonymousClass62 = A02.get()) != null) {
                anonymousClass62.A05(motionEvent);
            }
        } catch (Throwable th) {
            XS A002 = C8I.A00();
            if (A002 != null) {
                A002.A06().A8q(A00(20, 7, 86), C06808m.A14, new C06818n(th));
            }
        }
    }

    public static void A03(Context context) {
        if (!(context instanceof Application)) {
            return;
        }
        ActivityUtils.A05(new C1411ah());
    }

    public static void A04(XS xs, @Nullable String str) {
        MA.A06.execute(new C1414ak(xs, str));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A05(XS xs, String str) {
        if (!C06235y.A0P(xs)) {
            return;
        }
        if (A02.get() == null && AnonymousClass78.A0E(AnonymousClass78.A03(str))) {
            A04(xs, str);
            return;
        }
        AnonymousClass62 anonymousClass62 = A02.get();
        if (anonymousClass62 != null) {
            MA.A06.execute(new C1413aj(anonymousClass62, str, xs));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.facebook.ads.redexgen.X.60] */
    @SuppressLint({"CatchGeneralException"})
    public static synchronized void A07(XS xs, @Nullable String str) {
        synchronized (C06225x.class) {
            try {
            } finally {
            }
            if (A02.get() != null) {
                return;
            }
            if (C06235y.A0P(xs)) {
                C1409af c1409af = new C1409af(xs);
                C1410ag c1410ag = new C1410ag(xs);
                AnonymousClass61 A0J = new Object() { // from class: com.facebook.ads.redexgen.X.60
                    public double A00;
                    public float A01;
                    public int A02;
                    public int A03;
                    public int A04;
                    public int A05;
                    public int A06;
                    public long A07;
                    public long A08;
                    public long A09;
                    public C6A A0A;
                    public C6B A0B;
                    public C6C A0C;
                    public EnumC06396o A0D;
                    public AnonymousClass70 A0E;
                    public AnonymousClass71 A0F;
                    public Class A0G;
                    @Nullable
                    public String A0H;
                    @Nullable
                    public String A0I;
                    public String A0J;
                    public HashMap<Integer, Integer> A0K;
                    public Map<Integer, String> A0L;
                    public ScheduledExecutorService A0M;
                    public boolean A0N;

                    public final AnonymousClass60 A00(double d2) {
                        this.A00 = d2;
                        return this;
                    }

                    public final AnonymousClass60 A01(float f2) {
                        this.A01 = f2;
                        return this;
                    }

                    public final AnonymousClass60 A02(int i2) {
                        this.A02 = i2;
                        return this;
                    }

                    public final AnonymousClass60 A03(int i2) {
                        this.A03 = i2;
                        return this;
                    }

                    public final AnonymousClass60 A04(int i2) {
                        this.A04 = i2;
                        return this;
                    }

                    public final AnonymousClass60 A05(int i2) {
                        this.A05 = i2;
                        return this;
                    }

                    public final AnonymousClass60 A06(int i2) {
                        this.A06 = i2;
                        return this;
                    }

                    public final AnonymousClass60 A07(long j2) {
                        this.A07 = j2;
                        return this;
                    }

                    public final AnonymousClass60 A08(long j2) {
                        this.A08 = j2;
                        return this;
                    }

                    public final AnonymousClass60 A09(C6A c6a) {
                        this.A0A = c6a;
                        return this;
                    }

                    public final AnonymousClass60 A0A(C6B c6b) {
                        this.A0B = c6b;
                        return this;
                    }

                    public final AnonymousClass60 A0B(C6C c6c) {
                        this.A0C = c6c;
                        return this;
                    }

                    public final AnonymousClass60 A0C(EnumC06396o enumC06396o) {
                        this.A0D = enumC06396o;
                        return this;
                    }

                    public final AnonymousClass60 A0D(Class cls) {
                        this.A0G = cls;
                        return this;
                    }

                    public final AnonymousClass60 A0E(@Nullable String str2) {
                        this.A0I = str2;
                        return this;
                    }

                    public final AnonymousClass60 A0F(String str2) {
                        this.A0J = str2;
                        return this;
                    }

                    public final AnonymousClass60 A0G(HashMap<Integer, Integer> circularBufferLengthMap) {
                        this.A0K = circularBufferLengthMap;
                        return this;
                    }

                    public final AnonymousClass60 A0H(Map map) {
                        this.A0L = map;
                        return this;
                    }

                    public final AnonymousClass60 A0I(boolean z) {
                        this.A0N = z;
                        return this;
                    }

                    public final AnonymousClass61 A0J() {
                        AnonymousClass61 anonymousClass61 = new AnonymousClass61();
                        anonymousClass61.A0J = this.A0N;
                        anonymousClass61.A02 = this.A04;
                        anonymousClass61.A0G = this.A0K;
                        anonymousClass61.A01 = this.A03;
                        anonymousClass61.A00 = this.A02;
                        anonymousClass61.A04 = this.A06;
                        anonymousClass61.A0F = this.A0J;
                        anonymousClass61.A07 = this.A0B;
                        anonymousClass61.A06 = this.A0A;
                        double unused = AnonymousClass61.A0K = this.A00;
                        anonymousClass61.A09 = this.A0D;
                        anonymousClass61.A0H = this.A0L;
                        anonymousClass61.A03 = this.A05;
                        anonymousClass61.A0C = this.A0G;
                        anonymousClass61.A08 = this.A0C;
                        float unused2 = AnonymousClass61.A0L = this.A01;
                        long unused3 = AnonymousClass61.A0N = this.A08;
                        long unused4 = AnonymousClass61.A0M = this.A07;
                        anonymousClass61.A05 = this.A09;
                        anonymousClass61.A0B = this.A0F;
                        anonymousClass61.A0A = this.A0E;
                        anonymousClass61.A0I = this.A0M;
                        anonymousClass61.A0D = this.A0H;
                        anonymousClass61.A0E = this.A0I;
                        return anonymousClass61;
                    }
                }.A0I(true).A04(C06235y.A05(xs)).A02(C06235y.A03(xs)).A03(C06235y.A04(xs)).A06(C06235y.A07(xs)).A0G(C06235y.A0M()).A0A(c1409af).A09(c1410ag.A00()).A00(C06235y.A01(xs)).A0C(EnumC06396o.A0G).A0F(C06235y.A0D(xs)).A0H(C06235y.A0N(xs)).A05(C06235y.A06(xs)).A0D(Build.class).A01(C06235y.A02(xs)).A08(C06235y.A09(xs)).A07(C06235y.A08(xs)).A0B(c1410ag).A0E(A00(0, 20, 65)).A0J();
                if (C06235y.A0Q(xs)) {
                    A03(xs.getApplicationContext());
                }
                AnonymousClass62 anonymousClass62 = new AnonymousClass62(xs, A0J, C06235y.A0A(xs));
                if (str != null) {
                    anonymousClass62.A06(str);
                }
                A02.set(anonymousClass62);
            }
        }
    }
}
