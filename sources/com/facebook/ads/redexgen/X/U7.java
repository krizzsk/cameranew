package com.facebook.ads.redexgen.X;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public final class U7 implements JS {
    public static byte[] A0D;
    public static final String A0E;
    public int A00;
    public long A01;
    public final long A02;
    public final long A03;
    public final ConnectivityManager A04;
    public final XS A06;
    public final JR A07;
    public final InterfaceC1116Qf A08;
    public volatile boolean A0C;
    public final Runnable A0A = new U9(this);
    public final Runnable A09 = new U8(this);
    public final ThreadPoolExecutor A0B = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public final Handler A05 = new Handler(Looper.getMainLooper());

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0D, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 88);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{-39, -22, -48, -44, -73, -36, -26, -29, -44, -25, -42, -37, -36, -31, -38, -109, -40, -23, -40, -31, -25, -109, -101, -45, 6, -15, -13, -2, 2, -9, -3, -4, -82, 5, -10, -9, -6, -13, -82, -14, -9, 1, -2, -17, 2, -15, -10, -9, -4, -11, -82, -13, 4, -13, -4, 2, 1, -68, -28, -10, 3, 7, -10, 3, -79, 1, 3, 0, -12, -10, 4, 4, -10, -11, -79, 1, -14, 3, 5, -6, -14, -3, -79, -13, -14, 5, -12, -7, -67, -79, -12, 0, -1, 5, -6, -1, 6, -6, -1, -8, -79, 5, 0, -79, -1, -10, 9, 5, -79, 0, -1, -10, -65, 27, 45, 58, 62, 45, 58, -24, 58, 45, 59, 56, 55, 54, 59, 45, -24, 49, 59, -24, 45, 53, 56, 60, 65, -10, -17, 1, 14, 18, 1, 14, -68, 14, 1, 16, 17, 14, 10, 1, 0, -68, -3, -68, 10, 11, 10, -55, 15, 17, -1, -1, 1, 15, 15, 2, 17, 8, -68, 15, 16, -3, 16, 17, 15, -68, -1, 11, 0, 1, -68, 11, 2, -68, -61, -43, -30, -26, -43, -30, -112, -25, -47, -29, -112, -27, -34, -47, -46, -36, -43, -112, -28, -33, -112, -32, -30, -33, -45, -43, -29, -29, -112, -47, -36, -36, -112, -43, -26, -43, -34, -28, -29, -100, -112, -28, -30, -23, -39, -34, -41, -112, -47, -41, -47, -39, -34, -98, -17, 7, 5, 12, 12, 5, 10, 3, -68, 0, 5, 15, 12, -3, 16, -1, 4, -68, 0, 17, 1, -68, 16, 11, -68, 8, -3, -1, 7, -68, 11, 2, -68, -1, 11, 10, 10, 1, -1, 16, 5, 18, 5, 16, 21, -54, -31, -12, -12, -27, -19, -16, -12, -59, -47, -48, -48, -57, -59, -42, -53, -40, -53, -42, -37, 47, 44, 63, 44, -22, -5, -22, -13, -7, -8, 36, 21, 45, 32, 35, 21, 24};
    }

    static {
        A07();
        A0E = JS.class.getSimpleName();
    }

    public U7(XS xs, JR jr) {
        this.A07 = jr;
        this.A06 = xs;
        this.A04 = (ConnectivityManager) xs.getSystemService(A03(293, 12, 10));
        this.A08 = C1134Qx.A01(xs);
        this.A03 = JF.A0K(xs);
        this.A02 = JF.A0J(xs);
    }

    public static /* synthetic */ int A00(U7 u7) {
        int i2 = u7.A00 + 1;
        u7.A00 = i2;
        return i2;
    }

    private void A05() {
        BuildConfigApi.isDebug();
        this.A00 = 0;
        this.A01 = 0L;
        if (this.A0B.getQueue().size() == 0) {
            this.A07.A9m();
        }
    }

    private void A06() {
        if (this.A00 >= JF.A09(this.A06)) {
            A05();
            A4o();
            return;
        }
        if (this.A00 == 1) {
            this.A01 = JF.A0I(this.A06);
        } else {
            this.A01 *= 2;
        }
        A4p();
    }

    private void A08(long j2) {
        this.A05.postDelayed(this.A09, j2);
    }

    private void A09(JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, String> entry : this.A06.A02().A4R().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x005b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0B() {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.U7.A0B():void");
    }

    @Override // com.facebook.ads.redexgen.X.JS
    public final void A4o() {
        if (this.A0C) {
            return;
        }
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.JS
    public final void A4p() {
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A03);
    }
}
