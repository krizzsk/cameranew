package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.9A  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C9A {
    public static boolean A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03 = {"qrNp1wG", "4f9SKAEMWw8LBpPH9ClfYFaSVVluVAOE", "62aVnpwn360RV3u8SEcmxFYidJmBvefX", "Gce9ySP9MgoEln4cNVrEo5sJO8CSkBrv", "GAv6eBsy68sSiadtgyjEU9blJSusD372", "OMedkGV5dbFzDsS0dZcen", "wlEAAxVLaYYUt0VSnPi", "2B4l1t7rFez9Iyb0KdS6JKEUq9HBo8Fu"};
    public static final AtomicBoolean A04;
    public static final AtomicBoolean A05;
    public static final AtomicBoolean A06;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A03[1].charAt(3) == 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "IDfTBPjSyvL4biEe7dLkbKSavqcQmadb";
            strArr[2] = "Oy3yacq1X2KDRnpIDSUXWs28RTZJmhMt";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 60);
            i5++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-60, -60, -57, -10, -59, -10, -59, -11, -66, -70, -71, -19, -36, -31, -35, -26, -37, -35, -58, -35, -20, -17, -25, -22, -29, -62, -77, -70, -113, -40, -35, -40, -29, -40, -48, -37, -40, -23, -48, -29, -40, -34, -35, -113, -30, -29, -48, -31, -29, -44, -45, -60, -43, -36, -111, -24, -46, -28, -111, -46, -35, -29, -42, -46, -43, -22, -111, -38, -33, -38, -27, -38, -46, -35, -38, -21, -42, -43, -110, -111, -60, -36, -38, -31, -31, -38, -33, -40, -97, -62, -40, -34, -119, -51, -40, -41, -112, -35, -119, -52, -54, -43, -43, -119, -86, -34, -51, -46, -50, -41, -52, -50, -73, -50, -35, -32, -40, -37, -44, -86, -51, -36, -105, -46, -41, -46, -35, -46, -54, -43, -46, -29, -50, -111, -110, -105, -119, -68, -40, -42, -50, -119, -49, -34, -41, -52, -35, -46, -40, -41, -54, -43, -46, -35, -30, -119, -42, -54, -30, -119, -41, -40, -35, -119, -32, -40, -37, -44, -119, -39, -37, -40, -39, -50, -37, -43, -30, -105, -66, -51, -58, -31, -33, -24, -33, -20, -29, -35, -9, -4, -9, 2, -9, -17, -6, -9, 8, -13, 5, 10, 5, 16, 5, -3, 8, 5, 22, 1, -60, -59, -68, 10, 11, 16, -68, -1, -3, 8, 8, 1, 0, -54};
    }

    static {
        A03();
        A06 = new AtomicBoolean();
        A04 = new AtomicBoolean();
        A05 = new AtomicBoolean();
    }

    public static InterfaceC0972Kl A00() {
        return new XF();
    }

    public static L1 A01(XS xs) {
        return new XE(xs);
    }

    public static void A04(AudienceNetworkAds.InitListener initListener, AudienceNetworkAds.InitResult initResult) {
        M1.A01.execute(new XG(initListener, initResult));
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A06(XS xs) {
        if (JF.A0P(xs) && !A05.getAndSet(true)) {
            try {
                C06718c reportHandler = new C06718c(Thread.getDefaultUncaughtExceptionHandler(), xs, new XC());
                Thread.setDefaultUncaughtExceptionHandler(reportHandler);
            } catch (Exception e2) {
                xs.A06().A8q(A02(181, 7, 62), C06808m.A1L, new C06818n(e2));
            }
        }
    }

    public static void A07(XS xs) {
        A0G(xs, null, null, 3);
    }

    public static void A08(XS xs) {
        A0G(xs, null, null, 3);
    }

    public static void A09(XS xs) {
        if (JD.A1U(xs)) {
            A0E(xs, 0);
        }
        if (JD.A1Y(xs)) {
            A0B(xs);
        }
    }

    public static void A0A(XS xs) {
        if (JD.A1V(xs)) {
            A0F(xs, null, 3);
        }
    }

    public static void A0B(XS xs) {
        MA.A06.execute(new XH(xs));
    }

    public static void A0C(XS xs) {
        C8g.A0C(xs, new XB(xs), new XA(), BuildConfigApi.isDebug());
        xs.A08();
        C06225x.A04(xs, null);
    }

    public static void A0E(XS xs, int i2) {
        C8I.A01(xs);
        if (A04.getAndSet(true)) {
            return;
        }
        if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isDebuggerOn()) {
            KI.A02();
        }
        A06(xs);
        C0984Ky.A00(JD.A0k(xs), BuildConfigApi.isDebug(), A00(), A01(xs));
        C06155q.A03(JD.A02(xs));
        C1134Qx.A09(new XD(xs));
        if (i2 == 3) {
            Log.e(A02(8, 17, 60), A02(89, 89, 45));
            xs.A06().A98(A02(178, 3, 33), C06808m.A0J, new C06818n(A02(198, 24, 96)));
        }
        ActivityUtils.A04(xs, AudienceNetworkActivity.class);
        MA.A05(xs);
        C0940Je.A05(xs);
        C04910u.A0C(xs);
        if (JD.A0s(xs)) {
            C05914r.A00(xs);
        }
        if (JD.A1D(xs)) {
            X3.A02().A7H(xs);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A0F(XS xs, @Nullable AudienceNetworkAds.InitListener initListener, int i2) {
        C8I.A01(xs);
        boolean z = false;
        synchronized (C9A.class) {
            if (!A00) {
                if (i2 != 1 && i2 != 2) {
                    if (i2 == 3 && !A01) {
                        A01 = true;
                        z = true;
                    }
                }
                A00 = true;
                z = true;
            }
        }
        if (z) {
            A0E(xs, i2);
            MA.A08.execute(new XI(xs, initListener));
        } else if (i2 != 1) {
        } else {
            String A022 = A02(51, 38, 53);
            if (initListener != null) {
                A04(initListener, new AnonymousClass99(true, A022));
            } else {
                Log.w(A02(8, 17, 60), A022);
            }
        }
    }

    public static void A0G(XS xs, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i2) {
        KI.A05(A02(188, 10, 82), A02(25, 26, 51), A02(0, 8, 87));
        C1134Qx.A06();
        A0F(xs, initListener, i2);
    }

    public static synchronized boolean A0H() {
        boolean z;
        synchronized (C9A.class) {
            z = A00;
        }
        return z;
    }
}
