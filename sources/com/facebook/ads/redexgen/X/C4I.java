package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.androidx.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* renamed from: com.facebook.ads.redexgen.X.4I  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public abstract class C4I {
    public static byte[] A06;
    public static String[] A07 = {"wCFFy4v0UHolBGzubHhtaTK0KlaK5TU8", "WXL", "veTi", "n3", "rW28yUWMMTgiQlEcIz6smwE3e87Fn5Ax", "QU5acghFPGL2KQJts4swUt9W5A9MK8iM", "qIZlYUWuFA6tmX766BSANKSPkXlWbMWT", "RhPzJuizv3JTUr3AZhw4zLdz5ZpO"};
    public C4G A04 = null;
    public ArrayList<RecyclerView.ItemAnimator.ItemAnimatorFinishedListener> A05 = new ArrayList<>();
    public long A00 = 120;
    public long A03 = 120;
    public long A02 = 250;
    public long A01 = 250;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 42);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{85, 84, 123, 84, 83, 87, 91, 78, 83, 85, 84, 73, 124, 83, 84, 83, 73, 82, 95, 94};
    }

    public abstract boolean A0E(@NonNull AbstractC05784e abstractC05784e, @Nullable C4H c4h, @NonNull C4H c4h2);

    public abstract boolean A0F(@NonNull AbstractC05784e abstractC05784e, @NonNull C4H c4h, @Nullable C4H c4h2);

    public abstract boolean A0G(@NonNull AbstractC05784e abstractC05784e, @NonNull C4H c4h, @NonNull C4H c4h2);

    public abstract boolean A0H(@NonNull AbstractC05784e abstractC05784e, @NonNull AbstractC05784e abstractC05784e2, @NonNull C4H c4h, @NonNull C4H c4h2);

    public abstract void A0I();

    public abstract void A0J();

    public abstract void A0K(AbstractC05784e abstractC05784e);

    public abstract boolean A0L();

    static {
        A03();
    }

    public static int A00(AbstractC05784e abstractC05784e) {
        int i2;
        i2 = abstractC05784e.A0C;
        int pos = i2 & 14;
        if (abstractC05784e.A0b()) {
            return 4;
        }
        if ((pos & 4) == 0) {
            int A0J = abstractC05784e.A0J();
            int A0G = abstractC05784e.A0G();
            String[] strArr = A07;
            String str = strArr[3];
            String str2 = strArr[1];
            int length = str.length();
            int oldPos = str2.length();
            if (length != oldPos) {
                A07[0] = "z6mPnscAmNwlAliMzxZ9cFQDVALsWjfG";
                if (A0J != -1 && A0G != -1 && A0J != A0G) {
                    return pos | 2048;
                }
                return pos;
            }
            throw new RuntimeException();
        }
        return pos;
    }

    private final C4H A01() {
        return new C4H();
    }

    public final long A04() {
        return this.A00;
    }

    public final long A05() {
        return this.A01;
    }

    public final long A06() {
        return this.A02;
    }

    public final long A07() {
        return this.A03;
    }

    @NonNull
    public final C4H A08(@NonNull C05754b c05754b, @NonNull AbstractC05784e abstractC05784e) {
        return A01().A01(abstractC05784e);
    }

    @NonNull
    public final C4H A09(@NonNull C05754b c05754b, @NonNull AbstractC05784e abstractC05784e, int i2, @NonNull List<Object> list) {
        return A01().A01(abstractC05784e);
    }

    public final void A0A() {
        int i2 = this.A05.size();
        if (0 < i2) {
            this.A05.get(0);
            throw new NullPointerException(A02(0, 20, 16));
        } else {
            this.A05.clear();
        }
    }

    public final void A0B(C4G c4g) {
        this.A04 = c4g;
    }

    public final void A0C(AbstractC05784e abstractC05784e) {
        C4G c4g = this.A04;
        if (c4g != null) {
            c4g.A9n(abstractC05784e);
        }
    }

    public boolean A0D(@NonNull AbstractC05784e abstractC05784e) {
        return true;
    }

    public boolean A0M(@NonNull AbstractC05784e abstractC05784e, @NonNull List<Object> list) {
        return A0D(abstractC05784e);
    }
}
