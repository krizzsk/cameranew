package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.bd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1468bd extends C4Z {
    public static byte[] A06;
    public static String[] A07 = {"vpHxNEEeQqkPH9sKp8BAFlo", "ddQd8aXmX57TCv5syYSnMf6Vla22KopM", "0YXj", "UC9R5IJXbgu82zo5LhenPlKKwn23Fltm", "uFeOec4n0AGL9Kfrmk6ECW0KKbKvD", "RgZAHFrUyN4TqtmKiyvyL8Y", "g7LT7F9fn5p79lPzLzvRECTowfucfQY3", "UaBPk1errz52kF5dIu80Mei9ciV9Nkpb"};
    public PointF A02;
    public final float A03;
    public final LinearInterpolator A05 = new LinearInterpolator();
    public final DecelerateInterpolator A04 = new DecelerateInterpolator();
    public int A00 = 0;
    public int A01 = 0;

    public static String A04(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 35);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A06 = new byte[]{41, 12, 11, 0, 4, 23, 54, 8, 10, 10, 17, Draft_75.CR, 54, 6, 23, 10, 9, 9, 0, 23, 21, 35, 57, 108, 63, 36, 35, 57, 32, 40, 108, 35, 58, 41, 62, 62, 37, 40, 41, 108, 47, 35, 33, 60, 57, 56, 41, 31, 47, 62, 35, 32, 32, 26, 41, 47, 56, 35, 62, 10, 35, 62, 28, 35, 63, 37, 56, 37, 35, 34, 108, 59, 36, 41, 34, 108, 56, 36, 41, 108, 0, 45, 53, 35, 57, 56, 1, 45, 34, 45, 43, 41, 62, 108, 40, 35, 41, 63, 108, 34, 35, 56, 108, 37, 33, 60, 32, 41, 33, 41, 34, 56, 108, 42, 55, 56, 41, 121, 41, 43, 60, 63, 60, 43, 60, 55, 58, 60, 121, 42, 49, 54, 44, 53, 61, 121, 59, 60, 121, 54, 55, 60, 121, 54, 63, 121, 45, 49, 60, 121, 58, 54, 55, 42, 45, 56, 55, 45, 42, 121, 61, 60, 63, 48, 55, 60, 61, 121, 48, 55, 121, 10, 52, 54, 54, 45, 49, 10, 58, 43, 54, 53, 53, 60, 43, 117, 121, 42, 45, 56, 43, 45, 48, 55, 62, 121, 46, 48, 45, 49, 121, 10, 23, 24, 9, 6};
    }

    static {
        A06();
    }

    public C1468bd(Context context) {
        this.A03 = A0J(context.getResources().getDisplayMetrics());
    }

    private final int A00() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.y == 0.0f) {
            return 0;
        }
        return this.A02.y > 0.0f ? 1 : -1;
    }

    private int A01(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    private final int A03(View view, int top) {
        C4M A08 = A08();
        if (A08 == null || !A08.A25()) {
            return 0;
        }
        C4N c4n = (C4N) view.getLayoutParams();
        int start = A08.A0o(view) - c4n.topMargin;
        int end = A08.A0j(view) + c4n.bottomMargin;
        return A0N(start, end, A08.A0g(), A08.A0X() - A08.A0d(), top);
    }

    private final void A07(C4X c4x) {
        PointF A0P = A0P(A07());
        if (A0P == null || (A0P.x == 0.0f && A0P.y == 0.0f)) {
            c4x.A03(A07());
            A09();
            return;
        }
        A0B(A0P);
        this.A02 = A0P;
        this.A00 = (int) (A0P.x * 10000.0f);
        this.A01 = (int) (A0P.y * 10000.0f);
        c4x.A04((int) (this.A00 * 1.2f), (int) (this.A01 * 1.2f), (int) (A0L(10000) * 1.2f), this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final void A0G() {
        this.A01 = 0;
        this.A00 = 0;
        this.A02 = null;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final void A0H(int i2, int i3, C05754b c05754b, C4X c4x) {
        if (A06() == 0) {
            A09();
            return;
        }
        this.A00 = A01(this.A00, i2);
        this.A01 = A01(this.A01, i3);
        if (this.A00 == 0 && this.A01 == 0) {
            A07(c4x);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public void A0I(View view, C05754b c05754b, C4X c4x) {
        int A0O = A0O(view, A0K());
        int A03 = A03(view, A00());
        int A0M = A0M((int) Math.sqrt((A0O * A0O) + (A03 * A03)));
        if (A0M > 0) {
            c4x.A04(-A0O, -A03, A0M, this.A04);
        }
    }

    public float A0J(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int A0K() {
        PointF pointF = this.A02;
        if (pointF == null || pointF.x == 0.0f) {
            return 0;
        }
        return this.A02.x > 0.0f ? 1 : -1;
    }

    public int A0L(int i2) {
        return (int) Math.ceil(Math.abs(i2) * this.A03);
    }

    public final int A0M(int i2) {
        return (int) Math.ceil(A0L(i2) / 0.3356d);
    }

    public final int A0N(int i2, int i3, int i4, int i5, int i6) {
        if (i6 != -1) {
            if (i6 != 0) {
                if (i6 == 1) {
                    return i5 - i3;
                }
                throw new IllegalArgumentException(A04(113, 93, 122));
            }
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            String[] strArr = A07;
            if (strArr[3].charAt(24) != strArr[6].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "99CH8cQKDxQi0SdQwcjuhFHBueIBqbiA";
            strArr2[4] = "Y2Wuw9nWVBLC0K9LHKlenTQ1gtNyD";
            return 0;
        }
        return i4 - i2;
    }

    public int A0O(View view, int left) {
        C4M A08 = A08();
        if (A08 == null || !A08.A24()) {
            return 0;
        }
        C4N c4n = (C4N) view.getLayoutParams();
        int start = A08.A0k(view) - c4n.leftMargin;
        int end = A08.A0n(view) + c4n.rightMargin;
        return A0N(start, end, A08.A0e(), A08.A0h() - A08.A0f(), left);
    }

    @Nullable
    public PointF A0P(int i2) {
        C4M A08 = A08();
        if (A08 instanceof C4Y) {
            return ((C4Y) A08).A43(i2);
        }
        Log.w(A04(0, 20, 70), A04(20, 93, 111) + C4Y.class.getCanonicalName());
        return null;
    }
}
