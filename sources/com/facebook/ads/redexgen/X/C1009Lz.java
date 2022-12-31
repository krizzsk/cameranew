package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.facebook.ads.redexgen.X.Lz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1009Lz {
    public static byte[] A0I;
    public static String[] A0J = {"UAfRYX1IJYK1F4gMurnkVir00q2Lzr", "W9rWnfjKrefpB8hDj8decpkzvyqzW", "KuE77vVQtzCska5bvEw0ie6MMkaH2LqI", "aCUXypAv16RVdaAbRrmoDPgF0pJQTLdN", "UhONC0e0tLrj", "Xpoa", "YCNHKjVOQFwEe4MjzAzWrTTEWfFYaS", "tXFOakpgFhvHBQhEUyJ4FZAKQx0U"};
    public static final String A0K;
    @Nullable
    public View A0F;
    @Nullable
    public View A0G;
    public boolean A0H;
    public int A04 = -1;
    public int A05 = -1;
    public int A06 = -1;
    public int A03 = -1;
    public long A0C = -1;
    public int A09 = -1;
    public long A0E = -1;
    public long A0D = -1;
    public int A0A = -1;
    public int A0B = -1;
    public int A07 = -1;
    public int A08 = -1;
    public float A00 = -1.0f;
    public float A02 = -1.0f;
    public float A01 = -1.0f;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0I, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 45);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-48, -60, -124, 120, -69, -60, -63, -69, -61, -65, -51, -71, -54, -68, -84, -63, -59, -67, -110, 120, -8, -5, -25, 6, 10, 0, 11, 0, 6, 5, -17, -16, -13, -33, -2, 2, -8, 3, -8, -2, -3, -24, -79, -70, -73, -79, -71, -110, -77, -70, -81, -57, -94, -73, -69, -77, 5, 14, 11, 5, Draft_75.CR, -6, -4, 5, 2, -4, 4, -14, -88, -79, -82, -88, -80, -86, -87, -101, -82, -86, -68, -103, -90, -84, -69, -60, -70, -86, -65, -61, -69, -16, -7, -17, -29, -94, -85, -95, -106, -97, -88, -85, -100, -98, -91, -94, -90, -92, -91, -79, 10, 20, -28, Draft_75.CR, 10, 4, 12, -24, 22, 2, 19, 5, -26, 15, 2, 3, Draft_75.CR, 6, 5, -37, -63, -20, -37, -34, -29, -17, -19, -46, 20, 3, 6, 11, 23, 21, -5, -53, -66, -68, -56, -53, -67, -62, -57, -64, 121, -62, -58, -55, -53, -66, -52, -52, -62, -56, -57, -109, 121, -59, -58, -77, -60, -58, -90, -69, -65, -73, -52, -51, -70, -53, -51, -79, 7, 8, -11, 6, 8, -19, 4, -10, -15, 1, -11};
        if (A0J[6].length() == 24) {
            throw new RuntimeException();
        }
        A0J[5] = "KWAi";
        A0I = bArr;
    }

    static {
        A02();
        A0K = C1009Lz.class.getSimpleName();
    }

    private Ld A00() {
        View view;
        View view2 = this.A0G;
        if (view2 == null || (view = this.A0F) == null) {
            return Ld.A0I;
        }
        if (view2 != view) {
            return Ld.A0G;
        }
        if (Build.VERSION.SDK_INT < 4) {
            return Ld.A0F;
        }
        Object tag = this.A0G.getTag(Ld.A02);
        if (tag == null) {
            return Ld.A0H;
        }
        if (!(tag instanceof Ld)) {
            return Ld.A0J;
        }
        return (Ld) tag;
    }

    public final long A03() {
        if (A07()) {
            return System.currentTimeMillis() - this.A0C;
        }
        if (A0J[6].length() != 24) {
            A0J[5] = "dmN9";
            return -1L;
        }
        throw new RuntimeException();
    }

    public final Map<String, String> A04() {
        long j2;
        if (!this.A0H) {
            return null;
        }
        String valueOf = String.valueOf((this.A02 * this.A01) / 2.0f);
        long j3 = this.A0C;
        if (j3 > 0) {
            long j4 = this.A0D;
            if (j4 > j3) {
                j2 = j4 - j3;
                HashMap hashMap = new HashMap();
                hashMap.put(A01(20, 11, 106), String.valueOf(this.A04));
                hashMap.put(A01(31, 11, 98), String.valueOf(this.A05));
                hashMap.put(A01(186, 5, 96), String.valueOf(this.A06));
                hashMap.put(A01(102, 6, 16), String.valueOf(this.A03));
                hashMap.put(A01(42, 14, 33), String.valueOf(j2));
                long clickDelayMs = this.A0E;
                hashMap.put(A01(165, 9, 37), String.valueOf(clickDelayMs));
                long clickDelayMs2 = this.A0D;
                hashMap.put(A01(82, 7, 41), String.valueOf(clickDelayMs2));
                hashMap.put(A01(174, 6, 44), String.valueOf(this.A0A));
                hashMap.put(A01(BaseBlurEffect.ROTATION_180, 6, 103), String.valueOf(this.A0B));
                hashMap.put(A01(56, 6, 117), String.valueOf(this.A07));
                hashMap.put(A01(62, 6, 108), String.valueOf(this.A08));
                hashMap.put(A01(89, 4, 94), String.valueOf(this.A07));
                hashMap.put(A01(93, 4, 16), String.valueOf(this.A08));
                hashMap.put(A01(97, 5, 12), String.valueOf(this.A00));
                hashMap.put(A01(129, 7, 77), valueOf);
                hashMap.put(A01(136, 7, 117), valueOf);
                hashMap.put(A01(68, 14, 24), String.valueOf(A00().A05()));
                return hashMap;
            }
        }
        j2 = -1;
        HashMap hashMap2 = new HashMap();
        hashMap2.put(A01(20, 11, 106), String.valueOf(this.A04));
        hashMap2.put(A01(31, 11, 98), String.valueOf(this.A05));
        hashMap2.put(A01(186, 5, 96), String.valueOf(this.A06));
        hashMap2.put(A01(102, 6, 16), String.valueOf(this.A03));
        hashMap2.put(A01(42, 14, 33), String.valueOf(j2));
        long clickDelayMs3 = this.A0E;
        hashMap2.put(A01(165, 9, 37), String.valueOf(clickDelayMs3));
        long clickDelayMs22 = this.A0D;
        hashMap2.put(A01(82, 7, 41), String.valueOf(clickDelayMs22));
        hashMap2.put(A01(174, 6, 44), String.valueOf(this.A0A));
        hashMap2.put(A01(BaseBlurEffect.ROTATION_180, 6, 103), String.valueOf(this.A0B));
        hashMap2.put(A01(56, 6, 117), String.valueOf(this.A07));
        hashMap2.put(A01(62, 6, 108), String.valueOf(this.A08));
        hashMap2.put(A01(89, 4, 94), String.valueOf(this.A07));
        hashMap2.put(A01(93, 4, 16), String.valueOf(this.A08));
        hashMap2.put(A01(97, 5, 12), String.valueOf(this.A00));
        hashMap2.put(A01(129, 7, 77), valueOf);
        hashMap2.put(A01(136, 7, 117), valueOf);
        hashMap2.put(A01(68, 14, 24), String.valueOf(A00().A05()));
        return hashMap2;
    }

    public final void A05() {
        if (BuildConfigApi.isDebug()) {
            String str = A01(143, 22, 44) + this.A0C;
        }
        this.A0C = System.currentTimeMillis();
        if (A0J[5].length() != 4) {
            throw new RuntimeException();
        }
        A0J[4] = "EYcKv4oYFgPr199sh97";
    }

    public final void A06(MotionEvent motionEvent, View view, View view2) {
        if (!this.A0H) {
            this.A0H = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                InputDevice.MotionRange motionRange = device.getMotionRange(0);
                InputDevice.MotionRange yr = device.getMotionRange(1);
                if (motionRange != null && yr != null) {
                    this.A01 = Math.min(motionRange.getRange(), yr.getRange());
                }
            }
            if (this.A01 <= 0.0f) {
                this.A01 = Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr2);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f2 = this.A00;
                    this.A00 = f2 - (f2 / this.A09);
                    float f3 = this.A00;
                    float pressure = motionEvent.getPressure();
                    int i2 = this.A09;
                    this.A00 = f3 + (pressure / i2);
                    float f4 = this.A02;
                    this.A02 = f4 - (f4 / i2);
                    float f5 = this.A02;
                    float size = motionEvent.getSize();
                    int i3 = this.A09;
                    this.A02 = f5 + (size / i3);
                    this.A09 = i3 + 1;
                    return;
                } else if (action != 3) {
                    return;
                }
            }
            this.A0D = System.currentTimeMillis();
            this.A07 = (int) (((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0]) / LY.A00);
            this.A08 = (int) (((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1]) / LY.A00);
            this.A0F = view2;
            return;
        }
        this.A04 = (int) (iArr[0] / LY.A00);
        this.A05 = (int) (iArr[1] / LY.A00);
        this.A06 = (int) (view.getWidth() / LY.A00);
        this.A03 = (int) (view.getHeight() / LY.A00);
        this.A09 = 1;
        this.A0E = System.currentTimeMillis();
        this.A0A = (int) (((((int) (motionEvent.getX() + 0.5f)) + iArr2[0]) - iArr[0]) / LY.A00);
        this.A0B = (int) (((((int) (motionEvent.getY() + 0.5f)) + iArr2[1]) - iArr[1]) / LY.A00);
        this.A00 = motionEvent.getPressure();
        this.A02 = motionEvent.getSize();
        this.A0G = view2;
    }

    public final boolean A07() {
        return this.A0C != -1;
    }

    public final boolean A08() {
        return this.A0H;
    }

    public final boolean A09(Context context) {
        boolean z;
        int A05 = JD.A05(context);
        long A03 = A03();
        if (A05 >= 0 && A03 < A05) {
            z = true;
        } else {
            z = false;
        }
        if (BuildConfigApi.isDebug()) {
            String str = A01(108, 21, 116) + z + A01(2, 18, 43) + A05 + A01(0, 2, 119) + A03;
        }
        return z;
    }
}
