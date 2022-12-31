package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bO  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1454bO extends C4P {
    public static byte[] A03;
    public static String[] A04 = {"WP5CpU5dCfM1vj2iCgRczyLeS833jqA7", "f0t6mABNpir4NiI1IJBR", "VMSqLwjWc3fXvu7D9B7JwatTJSWiKmSt", "2kGOlvpEajHcc9JJ5BV7kSrV8Uhb9VDh", "BGGgbgkg4NpzKA2XjpG6Q8iHB2GG9zH0", "ziOTckvigWpUqNYWulExTvMWDfbzI1Sq", "WkLWBkQ13lLgYVln8HDaQ7gYbGPRUWfj", "hZJ2tRP2pGaevCKAXmW2Fr9GhnOGACBf"};
    public C0828Eq A00;
    public Scroller A01;
    public final C4R A02 = new C1455bP(this);

    public static String A06(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 53);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        byte[] bArr = {-35, 10, -68, 5, 10, 15, 16, -3, 10, -1, 1, -68, 11, 2, -68, -21, 10, -30, 8, 5, 10, 3, -24, 5, 15, 16, 1, 10, 1, 14, -68, -3, 8, 14, 1, -3, 0, 21, -68, 15, 1, 16, -54};
        if (A04[2].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[3] = "Gfsvb5V6ZkZ1EjPhJmDEOg0wCX37AMGK";
        strArr[5] = "BogmwpJuEiSgKohE6B9VLJKkNQC2pxlX";
        A03 = bArr;
    }

    public abstract int A0C(C4M c4m, int i2, int i3);

    @Nullable
    public abstract View A0D(C4M c4m);

    @Nullable
    public abstract int[] A0H(@NonNull C4M c4m, @NonNull View view);

    static {
        A09();
    }

    @Nullable
    private final C4Z A05(C4M c4m) {
        return A0E(c4m);
    }

    private void A07() {
        this.A00.A1k(this.A02);
        this.A00.setOnFlingListener(null);
    }

    private void A08() throws IllegalStateException {
        if (this.A00.getOnFlingListener() == null) {
            this.A00.A1j(this.A02);
            this.A00.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException(A06(0, 43, 103));
    }

    private boolean A0A(@NonNull C4M c4m, int i2, int i3) {
        C4Z A05;
        if ((c4m instanceof C4Y) && (A05 = A05(c4m)) != null) {
            int A0C = A0C(c4m, i2, i3);
            String[] strArr = A04;
            if (strArr[0].charAt(25) != strArr[7].charAt(25)) {
                String[] strArr2 = A04;
                strArr2[0] = "3QNQgzU1MIdfo8xP0zEWa1SfaSPVi8u7";
                strArr2[7] = "BhxrOivCOMjMD1hwED78TbVHZR3oyoMb";
                if (A0C == -1) {
                    return false;
                }
                A05.A0A(A0C);
                c4m.A1L(A05);
                return true;
            }
            throw new RuntimeException();
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4P
    public final boolean A0B(int i2, int i3) {
        C4M layoutManager = this.A00.getLayoutManager();
        if (layoutManager == null || this.A00.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.A00.getMinFlingVelocity();
        int minFlingVelocity2 = Math.abs(i3);
        if (minFlingVelocity2 <= minFlingVelocity) {
            int minFlingVelocity3 = Math.abs(i2);
            if (minFlingVelocity3 <= minFlingVelocity) {
                return false;
            }
        }
        return A0A(layoutManager, i2, i3);
    }

    @Nullable
    @Deprecated
    public C1468bd A0E(C4M c4m) {
        if (!(c4m instanceof C4Y)) {
            return null;
        }
        return new C0827Ep(this, this.A00.getContext());
    }

    public final void A0F() {
        C4M layoutManager;
        View snapView;
        C0828Eq c0828Eq = this.A00;
        if (c0828Eq == null || (layoutManager = c0828Eq.getLayoutManager()) == null || (snapView = A0D(layoutManager)) == null) {
            return;
        }
        int[] A0H = A0H(layoutManager, snapView);
        if (A0H[0] != 0 || A0H[1] != 0) {
            this.A00.A1e(A0H[0], A0H[1]);
        }
    }

    public final void A0G(@Nullable C0828Eq c0828Eq) throws IllegalStateException {
        C0828Eq c0828Eq2 = this.A00;
        if (c0828Eq2 == c0828Eq) {
            return;
        }
        if (c0828Eq2 != null) {
            A07();
        }
        this.A00 = c0828Eq;
        if (this.A00 != null) {
            A08();
            this.A01 = new Scroller(this.A00.getContext(), new DecelerateInterpolator());
            A0F();
        }
    }
}
