package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.46  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class AnonymousClass46 {
    public static byte[] A03;
    public int A00;
    public final Rect A01;
    public final C4M A02;

    static {
        A04();
    }

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 54);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A03 = new byte[]{84, 83, 75, 92, 81, 84, 89, 29, 82, 79, 84, 88, 83, 73, 92, 73, 84, 82, 83};
    }

    public abstract int A06();

    public abstract int A07();

    public abstract int A08();

    public abstract int A09();

    public abstract int A0A();

    public abstract int A0B();

    public abstract int A0C(View view);

    public abstract int A0D(View view);

    public abstract int A0E(View view);

    public abstract int A0F(View view);

    public abstract int A0G(View view);

    public abstract int A0H(View view);

    public abstract void A0J(int i2);

    public AnonymousClass46(C4M c4m) {
        this.A00 = Integer.MIN_VALUE;
        this.A01 = new Rect();
        this.A02 = c4m;
    }

    public /* synthetic */ AnonymousClass46(C4M c4m, C1467bc c1467bc) {
        this(c4m);
    }

    public static AnonymousClass46 A00(C4M c4m) {
        return new C1467bc(c4m);
    }

    public static AnonymousClass46 A01(C4M c4m) {
        return new C1466bb(c4m);
    }

    public static AnonymousClass46 A02(C4M c4m, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return A01(c4m);
            }
            throw new IllegalArgumentException(A03(0, 19, 11));
        }
        return A00(c4m);
    }

    public final int A05() {
        if (Integer.MIN_VALUE == this.A00) {
            return 0;
        }
        return A0B() - this.A00;
    }

    public final void A0I() {
        this.A00 = A0B();
    }
}
