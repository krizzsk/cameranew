package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class L0 {
    public static String[] A01 = {"vWOWhJ9TqiA1ty478f", "MWb8A3Nd6tPLcAimCp0hVAmYX6QHiaZm", "Xd3YBUkiMhOleC4V056rVyOXhinwtSii", "tT8mJINbcEXXPPmKiWyTepfA0JHaFg93", "WoudJsrKOqRuVhNYSdRTZjqc00A0B3WY", "YTheXaZSxrm1KPF5Yd", "huHeChgRkwF7QVPgKoMeW6tLhEc13T9K", "ASVM8zHOtJrSOKsDwpZwweqDqvgS8KFW"};
    public static final ThreadLocal<L0> A02 = new ThreadLocal<>();
    public final C0970Kj A00 = new C0970Kj();

    public static C0970Kj A00() {
        return A02().A00;
    }

    public static C0970Kj A01(C0985Kz c0985Kz) {
        C0970Kj c0970Kj = new C0970Kj(A00());
        c0970Kj.add(c0985Kz);
        return c0970Kj;
    }

    public static L0 A02() {
        L0 l0 = A02.get();
        String[] strArr = A01;
        if (strArr[6].charAt(1) != strArr[2].charAt(1)) {
            String[] strArr2 = A01;
            strArr2[7] = "JnfSkSuIf6osqUQGv4Nkh0Vi2QZsQFPV";
            strArr2[4] = "e9u3CRl6fKpCeCDR9nRPR0cml03xK1Bs";
            if (l0 == null) {
                L0 l02 = new L0();
                A02.set(l02);
                return l02;
            }
            return l0;
        }
        throw new RuntimeException();
    }

    public static void A03(AbstractRunnableC0981Kv abstractRunnableC0981Kv) {
        C0970Kj createRunnableAsyncStackTrace = abstractRunnableC0981Kv.A05();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.addAll(createRunnableAsyncStackTrace);
        }
    }

    public static void A04(AbstractRunnableC0981Kv abstractRunnableC0981Kv) {
        C0970Kj createRunnableAsyncStackTrace = abstractRunnableC0981Kv.A05();
        if (createRunnableAsyncStackTrace != null) {
            A02().A00.removeAll(createRunnableAsyncStackTrace);
        }
    }
}
