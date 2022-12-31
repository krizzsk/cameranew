package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;
@TargetApi(14)
/* loaded from: assets/audience_network.dex */
public final class QJ {
    public static byte[] A02;
    public static String[] A03 = {"WzijvlAd9RP1HJzMxCKzeYHnMs2QP54v", "kfrqpsiELz0FvZTPYg", "hAwPDz", "OryCsPOoCbEZ1Kjw18", "JoqBI6chV", "rfkFyJ13DXugB3RLj6H", "rQvj", "kthZXjW83"};
    public final DA A00;
    public final C1220Uf A01 = new C1220Uf();

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 10);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-114, -104, -116, -114, -49, -51, -31, -33, -47, -114, -116, -90, -116, -114, -96, -86, -98, -96, -16, -29, -20, -30, -29, -16, -29, -16, -57, -20, -30, -29, -10, -96, -98, -72, -98, -96, -114, -23, 111, 114, -127, -68, 99, -75, -70, -79, -90, 99, 97, 123, 97, 99};
    }

    static {
        A02();
    }

    public QJ(XT xt) {
        this.A00 = AB.A00(new C1279Wp(xt), new B6(new C1227Um(this.A01)), new C1281Wr());
    }

    @VisibleForTesting
    public static String A01(A9 a9) {
        return A00(41, 11, 55) + a9.A01 + A00(14, 22, 116) + a9.A00 + A00(0, 14, 98) + a9.getCause() + A00(36, 2, 98);
    }

    public static boolean A03() {
        if (A03[0].charAt(3) != 'z') {
            A03[6] = "p35x";
            return true;
        }
        throw new RuntimeException();
    }

    public final int A04() {
        return this.A00.A0J();
    }

    public final int A05() {
        return this.A00.A5o();
    }

    public final long A06() {
        return this.A00.A6B();
    }

    public final long A07() {
        return this.A00.A6N();
    }

    @Nullable
    public final QH A08() {
        Format A0L = this.A00.A0L();
        if (A0L == null) {
            return null;
        }
        return new QH(A0L.A0F, A0L.A08);
    }

    public final void A09() {
        this.A00.ADS();
    }

    public final void A0A() {
        this.A00.AEC();
    }

    public final void A0B() {
        this.A00.A0M();
    }

    public final void A0C(float f2) {
        this.A00.A0N(f2);
    }

    public final void A0D(long j2) {
        this.A00.AEB(j2);
    }

    public final void A0E(Context context, Uri uri) {
        if (JD.A1w(context, A03())) {
            this.A00.A0P(new V5(QN.A05(context).A0E(context)).A00(uri));
            return;
        }
        this.A00.A0P(new V5(new C1218Ud(context, C0923Il.A0K(context, A00(38, 3, 4)), this.A01)).A00(uri));
    }

    public final void A0F(@Nullable Surface surface) {
        this.A00.A0O(surface);
    }

    public final void A0G(QG qg) {
        this.A00.A3D(new C0899Hn(this, qg));
    }

    public final void A0H(QI qi) {
        this.A00.A0Q(new C0903Hr(this, qi));
    }

    public final void A0I(boolean z) {
        this.A00.AES(z);
    }

    public final boolean A0J() {
        return this.A00.A77();
    }

    public final boolean A0K() {
        return this.A00.A0K() != null;
    }
}
