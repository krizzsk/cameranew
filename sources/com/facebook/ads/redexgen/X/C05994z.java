package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4z */
/* loaded from: assets/audience_network.dex */
public class C05994z {
    public static byte[] A04;
    public final Intent A00;
    public final AnonymousClass52 A01;
    public final XT A02;
    public final JT A03;

    static {
        A0P();
    }

    public static String A0O(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A0P() {
        A04 = new byte[]{51, 54, Draft_75.CR, 54, 51, 38, 51, Draft_75.CR, 48, 39, 60, 54, 62, 55, 14, 25, 11, 29, 14, 24, 25, 24, 42, 21, 24, 25, 19, 61, 24, 56, 29, 8, 29, 62, 9, 18, 24, 16, 25, 77, 82, 95, 94, 84, 100, 79, 82, 86, 94, 100, 75, 84, 87, 87, 82, 85, 92, 100, 82, 85, 79, 94, 73, 77, 90, 87};
    }

    public C05994z(AnonymousClass52 anonymousClass52, Intent intent, JT jt, XT xt) {
        this.A01 = anonymousClass52;
        this.A00 = intent;
        this.A03 = jt;
        this.A02 = xt;
    }

    private C1528cj A00() {
        return (C1528cj) this.A00.getSerializableExtra(A0O(0, 14, 29));
    }

    public MV A02() {
        return new S2(this.A02, this.A03, new C1451bL(this.A01), (C1524cf) this.A00.getSerializableExtra(A0O(14, 25, 51)), new C1181Ss(), 0);
    }

    public MV A03() {
        AnonymousClass52 anonymousClass52 = this.A01;
        return new TB(anonymousClass52, this.A02, this.A03, new C1451bL(anonymousClass52));
    }

    public MV A04() {
        return new C06999f(this.A02, this.A03, new C1451bL(this.A01), A00(), new C1182St(), 1);
    }

    public MV A05() {
        return new C06999f(this.A02, this.A03, new C1451bL(this.A01), (C1524cf) this.A00.getSerializableExtra(A0O(14, 25, 51)), new C1181Ss(), 0);
    }

    public MV A06() {
        if (JD.A1s(this.A02)) {
            XT xt = this.A02;
            return new AnonymousClass85(xt, this.A03, new C7J(xt), new C1451bL(this.A01), A00());
        }
        XT xt2 = this.A02;
        return new AnonymousClass84(xt2, this.A03, new C7J(xt2), new C1451bL(this.A01), A00());
    }

    public MV A07() {
        return new C06838p(this.A02, new C1182St(), this.A03, A00(), new C7J(this.A02), new C1451bL(this.A01));
    }

    public MV A08() {
        return new C1185Sw(this.A02, this.A03, new C1451bL(this.A01), A00(), null, new C1182St());
    }

    public MV A09() {
        return new AnonymousClass87(this.A02, new C1182St(), this.A03, A00(), new C7J(this.A02), new C1451bL(this.A01));
    }

    public MV A0A() {
        return new AnonymousClass87(this.A02, new C1181Ss(), this.A03, (C1524cf) this.A00.getSerializableExtra(A0O(14, 25, 51)), new C7J(this.A02), new C0826Eo(this.A01));
    }

    public MV A0B() {
        C1524cf c1524cf = (C1524cf) this.A00.getSerializableExtra(A0O(14, 25, 51));
        return new C1185Sw(this.A02, this.A03, new C0826Eo(this.A01), c1524cf, c1524cf.A0W(), new C1181Ss());
    }

    public MV A0C(RelativeLayout relativeLayout) {
        C1183Su c1183Su = new C1183Su(this.A02, new C1450bK(this), this.A03, new C1451bL(this.A01));
        c1183Su.A05(relativeLayout);
        c1183Su.A04(this.A00.getIntExtra(A0O(39, 27, 116), 200));
        M5.A0M(relativeLayout, ViewCompat.MEASURED_STATE_MASK);
        return c1183Su;
    }
}
