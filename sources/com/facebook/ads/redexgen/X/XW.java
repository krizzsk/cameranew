package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public class XW implements C0L {
    public static byte[] A01;
    public static String[] A02 = {"aROWSCJTZ7USEA9NykDAgKPqU9Hz2yMC", "Zqbs868sBagHNlYScp55lXssWh10RIQa", "mbYc5GC1jhCg", "AuzesFDqytnerPl8cSxQvwaSTNgSXgGN", "J34OJh55Zf7CVcps1JZJSO0d6JwePACZ", "sgVYwbqUus7", "7dh0o4NaZc6u8WRc1KGfxvMUmypAWeMQ", "ZE0swazaf"};
    public final /* synthetic */ XS A00;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            byte b = copyOfRange[i5];
            if (A02[3].charAt(2) == 'x') {
                throw new RuntimeException();
            }
            A02[0] = "5v5qZEzKm5dZGLy7lyhruzHwv9U4ulwR";
            copyOfRange[i5] = (byte) ((b ^ i4) ^ 108);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{5, 1, Draft_75.CR, 11, 9};
    }

    static {
        A01();
    }

    public XW(XS xs) {
        this.A00 = xs;
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void A8j(Throwable th) {
        this.A00.A06().A8q(A00(0, 5, 0), C06808m.A1R, new C06818n(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void A8u(Throwable th) {
        this.A00.A06().A8q(A00(0, 5, 0), C06808m.A1T, new C06818n(th));
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void ADL(String str, int i2, @Nullable String str2, @Nullable Integer num, @Nullable Long l2, AnonymousClass06 anonymousClass06) {
        C7M.A05(this.A00, anonymousClass06.A06, anonymousClass06.A08, anonymousClass06.A09, anonymousClass06.A07, anonymousClass06.A03, i2, str2, num, l2, null);
    }

    @Override // com.facebook.ads.redexgen.X.C0L
    public final void ADM(String str, boolean z, AnonymousClass06 anonymousClass06) {
        C7M.A04(this.A00, new C7L(anonymousClass06.A06, anonymousClass06.A08, anonymousClass06.A07, anonymousClass06.A03, str), z);
    }
}
