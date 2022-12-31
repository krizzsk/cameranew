package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;
/* loaded from: assets/audience_network.dex */
public class XL extends AbstractRunnableC0981Kv {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C8J A01;
    public final /* synthetic */ InterfaceC06748f A02;
    public final /* synthetic */ C06818n A03;
    public final /* synthetic */ String A04;

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 120);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{-37, -3, 30, 27, 46, 32, -39, 28, 43, 26, 44, 33, -39, 27, 30, 28, 26, 46, 44, 30, -39, 44, -2, 39, 47, 34, 43, 40, 39, 38, 30, 39, 45, -3, 26, 45, 26, 9, 43, 40, 47, 34, 29, 30, 43, -39, 39, 40, 45, -39, 34, 39, 35, 30, 28, 45, 30, 29, -46, -24, -19, -22, -97, -24, -14, -97, -19, -12, -21, -21, -96, 30, 33, 33, 38, 49, 38, 44, 43, 30, 41, 28, 38, 43, 35, 44, 45, 66, 45, 53, 56, 45, 46, 56, 49, 43, 48, 53, 63, 55, 43, 63, 60, 45, 47, 49, 62, 60, 62, 67, 64, 104, 91, 89, 101, 104, 90, 85, 90, 87, 106, 87, 88, 87, 105, 91, -18, -31, -19, -15, -31, -17, -16, -37, -27, -32, 44, 46, 27, 45, 50, 41, 30, 49, 51, 32, 50, 55, 46, 35, 29, 33, 45, 34, 35};
    }

    public XL(C8J c8j, String str, int i2, C06818n c06818n, InterfaceC06748f interfaceC06748f) {
        this.A01 = c8j;
        this.A04 = str;
        this.A00 = i2;
        this.A03 = c06818n;
        this.A02 = interfaceC06748f;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractRunnableC0981Kv
    public final void A06() {
        String stackTrace;
        Map<String, String> A4R;
        String A6m;
        AtomicReference atomicReference;
        try {
            if (C8g.A0J(this.A01, this.A04, this.A00, this.A03)) {
                return;
            }
            C0940Je.A08(this.A01, JW.A0A.toString() + A00(0, 1, 41) + this.A04);
            Throwable cause = this.A03.getCause();
            if (cause != null) {
                stackTrace = C0999Lp.A03(this.A01, cause);
            } else if (JF.A0R(this.A01)) {
                stackTrace = C0999Lp.A03(this.A01, this.A03);
            } else {
                stackTrace = A00(0, 0, 106) + this.A03.getMessage();
            }
            if (JF.A0V(this.A01)) {
                A4R = this.A01.A02().A4R();
            } else if (this.A02 != null) {
                A4R = this.A02.A6T();
            } else if (C8g.A02) {
                String message = A00(1, 57, 65);
                C8g.A0F(new RuntimeException(message, this.A03));
                A4R = new HashMap<>();
            } else {
                A4R = this.A01.A02().A4R();
            }
            A4R.put(A00(136, 7, 65), this.A04);
            A4R.put(A00(143, 12, 70), String.valueOf(this.A00));
            JSONObject A02 = this.A03.A02();
            if (A02 != null) {
                A4R.put(A00(71, 15, 69), A02.toString());
            }
            if ((A00(106, 5, 99).equals(this.A04) || A00(111, 15, 126).equals(this.A04)) && (A6m = this.A01.A02().A6m()) != null) {
                A4R.put(A00(86, 20, 84), A6m);
            }
            String A0A = this.A01.A0A();
            if (A0A != null && !TextUtils.isEmpty(A0A)) {
                A4R.put(A00(126, 10, 4), A0A);
            }
            atomicReference = C8g.A0A;
            InterfaceC06738e interfaceC06738e = (InterfaceC06738e) atomicReference.get();
            if (interfaceC06738e == null) {
                C8g.A0F(new RuntimeException(A00(58, 13, 7)));
            } else {
                interfaceC06738e.AFU(stackTrace, A4R, this.A01);
            }
        } catch (Throwable th) {
            C8g.A0F(th);
        }
    }
}
