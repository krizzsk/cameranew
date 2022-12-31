package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* renamed from: com.facebook.ads.redexgen.X.8g  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C8g {
    @VisibleForTesting
    public static SparseIntArray A00;
    @VisibleForTesting
    public static Executor A01;
    public static boolean A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"lfqbOpCQc8eNVWWSF0ti", "aQ5ZOD0I", "7f7up0GBGRCd1p0enpCjG4lcj76", "dHBYXWbpLBdqteinvxBO5bOixoP3oT04", "DPNUUQYEctncegz3shse9IBb8Vdl47", "4q0rwT09y0cbatV7Yp", "6l64E9SK9p5G", "edaEIeRSccYYgTnyelVwcwdzoe4C2sfO"};
    public static final List<Integer> A06;
    public static final List<C06758h> A07;
    public static final AtomicBoolean A08;
    public static final AtomicInteger A09;
    public static final AtomicReference<InterfaceC06738e> A0A;
    public static final AtomicReference<InterfaceC06748f> A0B;
    public static final AtomicReference<Boolean> A0C;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 39);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A04 = new byte[]{-93, -105, -40, -37, -37, -32, -21, -32, -26, -27, -40, -29, -64, -27, -35, -26, -105, -76, -105, -110, -122, -45, -53, -39, -39, -57, -51, -53, -122, -93, -122, 91, 79, -94, -92, -111, -93, -88, -97, -108, 114, -98, -109, -108, 79, 108, 79, 116, -66, -36, -23, -94, -17, -101, -25, -22, -30, -101, -65, -32, -35, -16, -30, -101, -64, -15, -32, -23, -17, -87, -101, -66, -22, -23, -17, -32, -13, -17, -101, -28, -18, -101, -23, -16, -25, -25, -87, 119, -93, -87, -94, -88, -103, -90, 110, 84, -79, -46, -49, -30, -44, -115, -48, -33, -50, -32, -43, -115, -49, -46, -48, -50, -30, -32, -46, -115, -36, -45, -115, -46, -29, -46, -37, -31, -115, -28, -42, -31, -43, -115, -32, -30, -49, -31, -26, -35, -46, -115, -86, -115, 108, -97, -118, -116, -116, -117, -116, -117, 71, -112, -107, 84, -108, -116, -108, -106, -103, -96, 71, -109, -106, -114, 71, -109, -112, -108, -112, -101, 72, 71, 115, -120, -102, -101, 71, -116, -99, -116, -107, -101, 97, 71, -108, -57, -78, -76, -65, -61, -72, -66, -67, 111, -109, -76, -79, -60, -74, 111, -108, -59, -76, -67, -61, 111, -58, -72, -61, -73, 111, -62, -60, -79, -61, -56, -65, -76, 111, -116, 111, -97, -46, -67, -65, -54, -50, -61, -55, -56, 122, -66, -49, -52, -61, -56, -63, 122, -58, -55, -63, -63, -61, -56, -63, 122, -66, -65, -68, -49, -63, 122, -65, -48, -65, -56, -50, -120, -27, 24, 3, 5, 16, 20, 9, 15, 14, -64, 19, 8, 15, 21, 12, 4, -64, 14, 15, 20, -64, 8, 1, 16, 16, 5, 14, -64, 8, 5, 18, 5, -50, -101, -105, -106, -54, -71, -66, -70, -61, -72, -70, -93, -70, -55, -52, -60, -57, -64, -28, 9, 1, 10, -69, -33, 0, -3, 16, 2, -69, -32, 17, 0, 9, 15, -69, 18, 4, 15, 3, -69, 14, 16, -3, 15, 20, 11, 0, -69, -40, -69, -53, -26, -26, -105, -28, -40, -27, -16, -105, -36, -19, -36, -27, -21, -22, -105, -26, -35, -105, -22, -20, -39, -21, -16, -25, -36, -105, -38, -26, -37, -36, -79, -105, -101, -99, -104, -99, -102, -83, -102, -104, -91, -88, -96, -96, -94, -89, -96, -21, -8, -3, -24, -19, -18, -3, -18, -20, -3, -14, -8, -9, -24, 0, -8, -24, -4, -14, -16, -9, -22, -11, -24, -19, -22, -3, -22, -24, -11, -8, -16, -16, -14, -9, -16, -62, -64, -62, -57, -60, -57, -56, -62, -49, -46, -54, -54, -52, -47, -54, -2, Draft_75.CR, 6, 6, -3, 4, -49, -42, -55, -59, -36, -57, -46, -49, -54, -57, -38, -49, -43, -44, -36, -45, -30, -27, -35, -32, -39};
    }

    static {
        A04();
        A00 = new SparseIntArray();
        A03 = false;
        A0B = new AtomicReference<>();
        A0A = new AtomicReference<>();
        A01 = Executors.newSingleThreadExecutor();
        A06 = Arrays.asList(10, 50, 100, 1000);
        A07 = Collections.synchronizedList(new ArrayList());
        A09 = new AtomicInteger();
        A08 = new AtomicBoolean();
        A0C = new AtomicReference<>();
        A02 = false;
    }

    public static int A00(String str, int i2, C8J c8j) {
        if ((A01(457, 7, 71).equals(str) && C06808m.A1n == i2) || A01(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 5, 56).equals(str) || A01(437, 6, 113).equals(str)) {
            return 200;
        }
        if (A01(386, 36, 98).equals(str)) {
            return 50;
        }
        if (A01(371, 15, 18).equals(str)) {
            return JF.A05(c8j);
        }
        if (A05[3].charAt(3) != 'Y') {
            throw new RuntimeException();
        }
        A05[7] = "MSKlPe4okWTggpeViHGlBF3nlCraGBz9";
        return -1;
    }

    public static /* synthetic */ List A02() {
        List<C06758h> list = A07;
        String[] strArr = A05;
        if (strArr[4].length() != strArr[0].length()) {
            A05[1] = "TV2BvPAOYvnRV0R5I88rwwfNZOOU8";
            return list;
        }
        throw new RuntimeException();
    }

    public static void A05(C8J c8j, int i2, int i3) {
        c8j.A06().A8q(A01(427, 10, 60), C06808m.A2J, new C06818n(A01(338, 33, 80) + i2, A01(87, 9, 13) + i3));
    }

    @Deprecated
    public static void A06(@Nullable C8J c8j, String str, int i2, C06818n c06818n) {
        if (c8j == null) {
            A0F(new RuntimeException(A01(48, 39, 84)));
            return;
        }
        C8I.A01(c8j.A00());
        if (A02 && c06818n.A00() == 0) {
            A0D(new RuntimeException(A01(96, 44, 70) + str + A01(31, 16, 8) + i2, c06818n));
        }
        try {
            if (A0I(c8j, str, i2, Math.random(), c06818n)) {
                A09(c8j, str, i2, c06818n);
            }
        } catch (Throwable th) {
            A0F(th);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    @Deprecated
    public static void A07(C8J c8j, String str, int i2, C06818n c06818n) {
        try {
            c06818n.A03(2);
            c06818n.A08(false);
            c06818n.A04(1);
            if (JF.A0Q(c8j)) {
                c06818n.A06(true);
            } else {
                c06818n.A06(false);
            }
            A06(c8j, str, i2, c06818n);
        } catch (Throwable th) {
            A0F(th);
        }
    }

    @Deprecated
    public static void A08(C8J c8j, String str, int i2, C06818n c06818n) {
        try {
            c06818n.A03(2);
            c06818n.A06(false);
            A06(c8j, str, i2, c06818n);
        } catch (Throwable th) {
            A0F(th);
        }
    }

    public static void A09(C8J c8j, String str, int i2, C06818n c06818n) {
        synchronized (C8g.class) {
            if (!A03) {
                int A012 = JF.A01(c8j);
                if (A09.getAndIncrement() < A012 - 1) {
                    A07.add(new C06758h(str, i2, c06818n));
                } else if (A09.get() == A012) {
                    List<C06758h> list = A07;
                    String A013 = A01(427, 10, 60);
                    int i3 = C06808m.A2G;
                    list.add(new C06758h(A013, i3, new C06818n(A01(InspirePublishFragment.MAX_DESC_COUNT, 42, 0) + str + A01(47, 1, 19) + i2)));
                }
            } else {
                A0A(c8j, str, i2, c06818n, true);
            }
        }
    }

    public static void A0A(C8J c8j, String str, int i2, C06818n c06818n, boolean z) {
        InterfaceC06748f interfaceC06748f = A0B.get();
        boolean z2 = interfaceC06748f != null && interfaceC06748f.A8W();
        if (A08.get() || z2) {
            int A002 = c06818n.A00();
            String A012 = A01(289, 17, 46);
            String A013 = A01(31, 16, 8);
            if (A002 == 0) {
                Log.e(A012, A01(182, 37, 40) + str + A013 + i2, c06818n);
            } else {
                Log.i(A012, A01(306, 32, 116) + str + A013 + i2 + A01(19, 12, 63) + c06818n.getMessage() + A01(0, 19, 80) + c06818n.A02());
            }
        }
        XL xl = new XL(c8j, str, i2, c06818n, interfaceC06748f);
        if (z) {
            A01.execute(xl);
        } else {
            xl.run();
        }
    }

    public static void A0C(XS xs, InterfaceC06748f interfaceC06748f, InterfaceC06738e interfaceC06738e, boolean z) {
        A0A.set(interfaceC06738e);
        A0B.set(interfaceC06748f);
        A08.set(z);
        synchronized (C8g.class) {
            if (!A03) {
                A03 = true;
                A01.execute(new XM(xs));
            }
        }
    }

    public static void A0D(final RuntimeException runtimeException) {
        if (A02) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.ads.redexgen.X.8d
                @Override // java.lang.Runnable
                public final void run() {
                    throw runtimeException;
                }
            });
        }
    }

    @Deprecated
    public static void A0E(Throwable th) {
        if (A02) {
            A0D(new RuntimeException(A01(256, 33, 121), th));
        }
    }

    public static void A0F(Throwable th) {
        Log.e(A01(289, 17, 46), A01(219, 37, 51), th);
        if (A02) {
            A0D(new RuntimeException(th));
        }
    }

    public static boolean A0H(C8J c8j) {
        Boolean bool = A0C.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        return JF.A0A(c8j) != 0;
    }

    @SuppressLint({"CatchGeneralException"})
    @VisibleForTesting
    public static boolean A0I(C8J c8j, String str, int i2, double d2, C06818n c06818n) {
        double logProbability;
        int A0E;
        int A032;
        try {
            int A042 = JF.A04(c8j);
            if (A042 < 1) {
                return false;
            }
            HashMap<String, Integer> A0M = JF.A0M(c8j);
            String str2 = str + A01(47, 1, 19) + i2;
            boolean contains = A0M.keySet().contains(str2);
            if (contains) {
                Integer num = A0M.get(str2);
                int intValue = num != null ? num.intValue() : -1;
                if (intValue == 0) {
                    return false;
                }
                if (intValue > 0) {
                    return d2 <= 1.0d / ((double) intValue);
                }
                if (JF.A03(c8j) < 1) {
                    return false;
                }
                logProbability = (A042 * A032) / 10000.0d;
            } else if (!c06818n.A09()) {
                logProbability = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                double logProbability2 = A042;
                logProbability = logProbability2 / 100.0d;
            }
            double A002 = c8j.A07().A00();
            if (A01(TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, 5, 56).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    return true;
                }
                int A062 = JF.A06(c8j);
                if (A062 == 0) {
                    return false;
                }
                if (A062 > 0) {
                    double d3 = 1.0d / A062;
                    return contains ? A002 <= d3 * logProbability : A002 <= d3;
                }
            }
            if (A01(457, 7, 71).equals(str) && C06808m.A1n == i2) {
                if (!A08.get()) {
                    A0E = JF.A0E(c8j);
                } else {
                    A0E = 1;
                }
                if (A0E == 0) {
                    return false;
                }
                if (A0E > 0) {
                    double d4 = 1.0d / A0E;
                    return contains ? A002 <= d4 * logProbability : A002 <= d4;
                }
            }
            if (A01(437, 6, 113).equals(str)) {
                if (JF.A0S(c8j) && c06818n.A0A()) {
                    return !contains || d2 >= 1.0d - logProbability;
                }
                Boolean bool = A0C.get();
                if (bool != null) {
                    return bool.booleanValue();
                }
                int A0A2 = JF.A0A(c8j);
                if (A0A2 == 0) {
                    A0C.set(false);
                    return false;
                } else if (A0A2 > 0) {
                    double d5 = 1.0d / A0A2;
                    if (!contains) {
                        return A002 <= d5;
                    }
                    double d6 = d5 * logProbability;
                    if (A05[7].charAt(14) != 'T') {
                        A05[1] = "";
                        return A002 <= d6;
                    }
                    throw new RuntimeException();
                }
            }
            if (A01(WebSocket.DEFAULT_WSS_PORT, 14, 63).equals(str)) {
                if (BuildConfigApi.isDebug()) {
                    if (A05[3].charAt(3) != 'Y') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[4] = "KJjq974XMuOG6VE2UuXyW1KY5FJsZ9";
                    strArr[0] = "oDF6i4FckldRw4UZ8099";
                    return true;
                }
                int A0B2 = JF.A0B(c8j);
                if (A0B2 == 0) {
                    return false;
                }
                if (A0B2 > 0) {
                    double d7 = 1.0d / A0B2;
                    return contains ? A002 <= d7 * logProbability : A002 <= d7;
                }
            }
            return d2 >= 1.0d - logProbability;
        } catch (Throwable th) {
            A0F(th);
            return false;
        }
    }

    @VisibleForTesting
    public static boolean A0J(C8J c8j, String str, int eventsLimit, C06818n c06818n) {
        if (JF.A0P(c8j)) {
            int i2 = A00.get(eventsLimit);
            int A002 = JF.A00(c8j);
            if (c06818n.A01() != -1) {
                A002 = c06818n.A01();
            } else {
                int A003 = A00(str, eventsLimit, c8j);
                if (A002 < A003) {
                    A002 = A003;
                }
            }
            if (i2 >= A002) {
                if (A06.contains(Integer.valueOf(i2))) {
                    boolean A0B2 = c06818n.A0B();
                    if (A05[3].charAt(3) != 'Y') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[5] = "DtDXz8TrFQQZw1pkgy";
                    strArr[2] = "wKGFu6BM2pQR03pr0dyvmA98nTz";
                    if (A0B2) {
                        A05(c8j, eventsLimit, i2);
                    }
                }
                A00.put(eventsLimit, i2 + 1);
                return true;
            }
            A00.put(eventsLimit, i2 + 1);
            return false;
        }
        return true;
    }
}
