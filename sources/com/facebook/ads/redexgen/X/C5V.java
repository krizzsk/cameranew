package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.5V  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C5V {
    public static byte[] A07;
    public static String[] A08 = {"QC6ROF3GbFPL6U2BchtfuOIlWA", "mAXyphBg0ZoA2", "nmk1i7vNQUMlLTVPnMJLcVhB6M", "xf2dPS9SncVtV17kxTxgHOfrSuJpis3", "Y24xgR3", "pU5dMF2zEzzc2yzou8JPWDE5BQxzeO1x", "dnQEZ1usH0f6s5VsA3sVBX2XHmBfQenJ", "5qnsTvKOcggfe9NlhRnI8aAzom1PIzJ"};
    public final Handler A00;
    public final C5U A01;
    public final C7J A02;
    public final String A03;
    public final String A04;
    public final JSONObject A05;
    public final boolean A06;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 52);
        }
        return new String(copyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{72, 90, 90, 76, 93, 90, 78, 65, 68, 77, 105, 109, 97, 103, 101, 0, 31, 18, 19, 25};
    }

    static {
        A07();
    }

    public C5V(C7J c7j, JSONObject jSONObject, String str, String str2, boolean z, C5U c5u) {
        this.A02 = c7j;
        this.A05 = jSONObject;
        this.A03 = str;
        this.A04 = str2;
        this.A06 = z && A0A(this.A05);
        this.A01 = c5u;
        this.A00 = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09(boolean z, C5T c5t) {
        String A03 = A03(6, 4, 28);
        String A032 = A03(15, 5, 66);
        String A033 = A03(10, 5, 52);
        if (z) {
            boolean equals = A033.equals(c5t.A02);
            if (A08[6].charAt(22) == 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[3] = "Ngd5gA2SMQ4Pqx2mjoy1oHjbJUKCicI";
            strArr[7] = "LorLYeRbgteEMpgZiQ82pTGbH7n24yI";
            if (equals) {
                this.A02.A0W(new C7G(c5t.A03, -1, -1, this.A04, this.A03));
            } else if (A032.equals(c5t.A02)) {
                this.A02.A0Z(new C7I(c5t.A03, this.A04, this.A03));
            } else if (!A03.equals(c5t.A02)) {
            } else {
                this.A02.A0Y(new C7I(c5t.A03, this.A04, this.A03));
            }
        } else if (A033.equals(c5t.A02)) {
            this.A02.A0V(new C7G(c5t.A03, -1, -1, this.A04, this.A03));
        } else if (A032.equals(c5t.A02)) {
            this.A02.A0a(new C7I(c5t.A03, this.A04, this.A03));
        } else if (!A03.equals(c5t.A02)) {
        } else {
            this.A02.A0X(new C7I(c5t.A03, this.A04, this.A03));
        }
    }

    public static boolean A0A(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has(A03(0, 6, 29));
    }

    public final void A0B() {
        if (!this.A06) {
            this.A01.A9q();
        }
        MA.A06.execute(new C1426aw(this));
    }
}
