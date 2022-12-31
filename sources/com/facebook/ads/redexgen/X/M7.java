package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import java.util.Arrays;
import java.util.concurrent.Executor;
/* loaded from: assets/audience_network.dex */
public final class M7 {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 118);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-9, 4, -6, 8, 5, -1, -6, -60, 5, 9, -60, -41, 9, 15, 4, -7, -22, -9, 9, 1};
    }

    public static <P, PR, R> AsyncTask<P, PR, R> A00(Executor executor, AsyncTask<P, PR, R> asyncTask, P... pArr) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(executor, pArr);
        } else {
            asyncTask.execute(pArr);
        }
        return asyncTask;
    }

    @SuppressLint({"CatchGeneralException"})
    public static void A02() {
        try {
            Class.forName(A01(0, 20, 32));
        } catch (Throwable unused) {
        }
    }
}
