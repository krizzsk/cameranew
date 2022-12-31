package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.3Q  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C3Q {
    public static byte[] A02;
    public static String[] A03 = {"IVmNZ4K5ijrEy03SUyZllrwYfGsSidsw", "uaVeZCSsPKZMiFLhWQ93bkOuh7Bkr", "fj8UDgC4HzdO2kuBNBPUB7GtanmKKm25", "SYZpn4btE2JdKC0jqJVDdFV7Ab7Ex928", "9XKyAy0QwW2RAbyuAC0HJ7gQU9o6NjRH", "LWQKQsADjd8kwxodkBq3bJfZv3R2tuNQ", "ttD9SROXIamLqNqjpH0jHeP07ZacbL3Q", "0sQtHWJTsFmoyuVwvJXQHcjInEg1c"};
    public static final C3M A04;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int A00 = -1;
    public final AccessibilityNodeInfo A01;

    public static String A08(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 123);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A02 = new byte[]{107, 103, 90, 65, 58, 53, 46, 108, 97, 123, 96, 106, 125, 71, 96, 94, 111, 124, 107, 96, 122, 52, 46, 43, 48, 114, Byte.MAX_VALUE, 101, 126, 116, 99, 89, 126, 67, 115, 98, 117, 117, 126, 42, 48, 52, 47, 108, 103, 106, 108, 100, 110, 109, 99, 106, 53, 47, 56, 35, 96, 107, 102, 96, 104, 102, 103, 57, 35, 59, 32, 99, 108, 97, 115, 115, 78, 97, 109, 101, 58, 32, 50, 41, 106, 101, 96, 106, 98, 104, 107, 101, 108, 51, 41, 88, 67, 0, 12, Draft_75.CR, 23, 6, Draft_75.CR, 23, 39, 6, 16, 0, 17, 10, 19, 23, 10, 12, Draft_75.CR, 89, 67, 49, 42, 111, 100, 107, 104, 102, 111, 110, 48, 42, 64, 91, 29, 20, 24, 14, 8, 26, 25, 23, 30, 65, 91, 52, 47, 105, 96, 108, 122, 124, 106, 107, 53, 47, 60, 39, 107, 104, 105, 96, 68, 107, 110, 100, 108, 102, 101, 107, 98, 61, 39, 36, 63, 111, 126, 124, 116, 126, 120, 122, 81, 126, 114, 122, 37, 63, 7, 28, 76, 93, 79, 79, 75, 83, 78, 88, 6, 28, 22, Draft_75.CR, 94, 78, 95, 66, 65, 65, 76, 79, 65, 72, 23, Draft_75.CR, 29, 6, 85, 67, 74, 67, 69, 82, 67, 66, 28, 6, 80, 75, 31, 14, 19, 31, 81, 75, Byte.MAX_VALUE, 100, 50, 45, 33, 51, Draft_75.CR, 32, 126, 100, 33, 35, 52, 41, 47, 46, 63, 33, 35, 35, 37, 51, 51, 41, 34, 41, 44, 41, 52, 57, 63, 38, 47, 35, 53, 51, 109, 111, 120, 101, 99, 98, 115, 111, 96, 105, 109, 126, 115, 109, 111, 111, 105, Byte.MAX_VALUE, Byte.MAX_VALUE, 101, 110, 101, 96, 101, 120, 117, 115, 106, 99, 111, 121, Byte.MAX_VALUE, 32, 34, 53, 40, 46, 47, 62, 34, 45, 36, 32, 51, 62, 39, 46, 34, 52, 50, 51, 49, 38, 59, 61, 60, 45, 49, 62, 55, 51, 32, 45, 33, 55, 62, 55, 49, 38, 59, 61, 60, 25, 27, 12, 17, 23, 22, 7, 27, 20, 17, 27, 19, 69, 71, 80, 77, 75, 74, 91, 71, 75, 84, 93, 107, 105, 126, 99, 101, 100, 117, 105, Byte.MAX_VALUE, 126, 8, 10, 29, 0, 6, 7, 22, 15, 6, 10, 28, 26, 63, 61, 42, 55, 49, 48, 33, 50, 49, 48, 57, 33, 61, 50, 55, 61, 53, 90, 88, 79, 82, 84, 85, 68, 85, 94, 67, 79, 68, 90, 79, 68, 86, 84, 77, 94, 86, 94, 85, 79, 68, 92, 73, 90, 85, 78, 87, 90, 73, 82, 79, 66, 78, 76, 91, 70, 64, 65, 80, 65, 74, 87, 91, 80, 71, 91, 66, 67, 80, 74, 67, 74, 66, 74, 65, 91, 34, 32, 55, 42, 44, 45, 60, 51, 34, 48, 55, 38, 21, 23, 0, 29, 27, 26, 11, 4, 6, 17, 2, 29, 27, 1, 7, 11, 21, 0, 11, 25, 27, 2, 17, 25, 17, 26, 0, 11, 19, 6, 21, 26, 1, 24, 21, 6, 29, 0, Draft_75.CR, 45, 47, 56, 37, 35, 34, 51, 60, 62, 41, 58, 37, 35, 57, 63, 51, 36, 56, 33, 32, 51, 41, 32, 41, 33, 41, 34, 56, 14, 12, 27, 6, 0, 1, 16, 28, 12, 29, 0, 3, 3, 16, Draft_75.CR, 14, 12, 4, 24, 14, 29, 11, 4, 6, 17, 12, 10, 11, 26, 22, 6, 23, 10, 9, 9, 26, 3, 10, 23, 18, 4, 23, 1, 34, 32, 55, 42, 44, 45, 60, 48, 38, 47, 38, 32, 55, 52, 54, 33, 60, 58, 59, 42, 38, 48, 33, 42, 38, 48, 57, 48, 54, 33, 60, 58, 59, 24, 26, Draft_75.CR, 16, 22, 23, 6, 12, 23, 18, 23, 22, 14, 23, 87};
    }

    static {
        A09();
        if (Build.VERSION.SDK_INT >= 24) {
            A04 = new C0P() { // from class: com.facebook.ads.redexgen.X.05
            };
        } else if (Build.VERSION.SDK_INT >= 23) {
            A04 = new C0P();
        } else if (Build.VERSION.SDK_INT >= 22) {
            A04 = new C0Z();
        } else if (Build.VERSION.SDK_INT >= 21) {
            A04 = new C04730b();
        } else if (Build.VERSION.SDK_INT >= 19) {
            A04 = new C05001d();
        } else if (Build.VERSION.SDK_INT >= 18) {
            A04 = new C3L();
        } else if (Build.VERSION.SDK_INT >= 17) {
            A04 = new C0834Ey();
        } else if (Build.VERSION.SDK_INT >= 16) {
            A04 = new C1476bl();
        } else {
            A04 = new C3M();
        }
    }

    public C3Q(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.A01 = accessibilityNodeInfo;
    }

    private final int A00() {
        return this.A01.getActions();
    }

    public static C3Q A01(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C3Q(accessibilityNodeInfo);
    }

    private final CharSequence A02() {
        return this.A01.getClassName();
    }

    private final CharSequence A03() {
        return this.A01.getContentDescription();
    }

    private final CharSequence A04() {
        return this.A01.getPackageName();
    }

    private final CharSequence A05() {
        return this.A01.getText();
    }

    private final String A06() {
        return A04.A02(this.A01);
    }

    public static String A07(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                switch (i2) {
                    case 4:
                        return A08(577, 13, 24);
                    case 8:
                        return A08(312, 22, 9);
                    case 16:
                        return A08(334, 12, 35);
                    case 32:
                        return A08(379, 17, 5);
                    case 64:
                        return A08(236, 26, 27);
                    case 128:
                        String[] strArr = A03;
                        if (strArr[2].charAt(30) != strArr[6].charAt(30)) {
                            String[] strArr2 = A03;
                            strArr2[0] = "Wsn1vJkw9zMZ1dCIcpdhA48NRIlsHibC";
                            strArr2[3] = "yyZsxnBpb3hGEtLyBJQzoNk7OwP5So5E";
                            return A08(262, 32, 87);
                        }
                        throw new RuntimeException();
                    case 256:
                        return A08(396, 35, 96);
                    case 512:
                        return A08(467, 39, 47);
                    case 1024:
                        return A08(431, 24, 116);
                    case 2048:
                        return A08(TypedValues.PositionType.TYPE_PERCENT_X, 28, 23);
                    case 4096:
                        return A08(556, 21, 62);
                    case 8192:
                        return A08(534, 22, 52);
                    case 16384:
                        return A08(346, 11, 127);
                    case 32768:
                        return A08(455, 12, 24);
                    case 65536:
                        return A08(357, 10, 81);
                    case 131072:
                        return A08(590, 20, 14);
                    default:
                        return A08(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 14, 34);
                }
            }
            return A08(294, 18, 26);
        }
        return A08(367, 12, 50);
    }

    private final void A0A(Rect rect) {
        this.A01.getBoundsInParent(rect);
    }

    private final void A0B(Rect rect) {
        this.A01.getBoundsInScreen(rect);
    }

    private final boolean A0C() {
        return this.A01.isCheckable();
    }

    private final boolean A0D() {
        return this.A01.isChecked();
    }

    private final boolean A0E() {
        return this.A01.isClickable();
    }

    private final boolean A0F() {
        return this.A01.isEnabled();
    }

    private final boolean A0G() {
        return this.A01.isFocusable();
    }

    private final boolean A0H() {
        return this.A01.isFocused();
    }

    private final boolean A0I() {
        return this.A01.isLongClickable();
    }

    private final boolean A0J() {
        return this.A01.isPassword();
    }

    private final boolean A0K() {
        return this.A01.isScrollable();
    }

    private final boolean A0L() {
        return this.A01.isSelected();
    }

    public final AccessibilityNodeInfo A0M() {
        return this.A01;
    }

    public final void A0N(int i2) {
        this.A01.addAction(i2);
    }

    public final void A0O(CharSequence charSequence) {
        this.A01.setClassName(charSequence);
    }

    public final void A0P(Object obj) {
        A04.A03(this.A01, ((C3N) obj).A00);
    }

    public final void A0Q(Object obj) {
        A04.A04(this.A01, ((C3O) obj).A00);
    }

    public final void A0R(boolean z) {
        this.A01.setScrollable(z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C3Q c3q = (C3Q) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.A01;
        if (accessibilityNodeInfo == null) {
            if (c3q.A01 != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(c3q.A01)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.A01;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        A0A(rect);
        sb.append(A08(5, 18, 117) + rect);
        A0B(rect);
        sb.append(A08(23, 18, 107) + rect);
        sb.append(A08(165, 15, 100));
        sb.append(A04());
        sb.append(A08(65, 13, 123));
        sb.append(A02());
        sb.append(A08(218, 8, 16));
        sb.append(A05());
        sb.append(A08(91, 22, 24));
        sb.append(A03());
        sb.append(A08(226, 10, 63));
        sb.append(A06());
        sb.append(A08(41, 13, 116));
        sb.append(A0C());
        sb.append(A08(54, 11, 120));
        sb.append(A0D());
        sb.append(A08(124, 13, 0));
        sb.append(A0G());
        sb.append(A08(137, 11, 116));
        sb.append(A0H());
        sb.append(A08(206, 12, 93));
        sb.append(A0L());
        sb.append(A08(78, 13, 114));
        sb.append(A0E());
        sb.append(A08(148, 17, 124));
        sb.append(A0I());
        sb.append(A08(113, 11, 113));
        sb.append(A0F());
        sb.append(A08(BaseBlurEffect.ROTATION_180, 12, 71));
        sb.append(A0J());
        sb.append(A08(192, 14, 86) + A0K());
        sb.append(A08(2, 3, 26));
        int A00 = A00();
        while (A00 != 0) {
            int actionBits = Integer.numberOfTrailingZeros(A00);
            int i2 = 1 << actionBits;
            int actionBits2 = i2 ^ (-1);
            A00 &= actionBits2;
            sb.append(A07(i2));
            if (A00 != 0) {
                sb.append(A08(0, 2, 60));
            }
        }
        sb.append(A08(624, 1, 113));
        return sb.toString();
    }
}
