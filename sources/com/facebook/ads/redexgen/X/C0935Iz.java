package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.Arrays;
@TargetApi(16)
/* renamed from: com.facebook.ads.redexgen.X.Iz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0935Iz {
    public static byte[] A0C;
    public static String[] A0D = {"i0Plrx2Nq5R", "0KClt8Z9EM", "nQMuIj2OsVJHQqYmqvawjMpASRVzc92c", "WLkeStMKuRlseW4hkxDKryqccASBMssv", "75mbZl2wj9Oc7L4cfBN0ornHxJ7x4bV4", "cDdFi4obBr6Dm4LziWqhdJNE9f6gL2cC", "Y", "1LOEfBfCv2OZoty488nnb7WvOOH1XlhR"};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public boolean A08;
    public final WindowManager A09;
    public final C0933Ix A0A;
    public final Choreographer$FrameCallbackC0934Iy A0B;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0C, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 124);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{109, 96, 122, 121, 101, 104, 112, 120, 102, 97, 107, 96, 120};
    }

    static {
        A04();
    }

    public C0935Iz() {
        this(null);
    }

    public C0935Iz(@Nullable Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.A09 = (WindowManager) context.getSystemService(A02(7, 6, 115));
        } else {
            this.A09 = null;
        }
        if (this.A09 != null) {
            this.A0A = C0923Il.A02 >= 17 ? A01(context) : null;
            this.A0B = Choreographer$FrameCallbackC0934Iy.A00();
        } else {
            this.A0A = null;
            this.A0B = null;
        }
        this.A06 = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
    }

    public static long A00(long vsyncCount, long j2, long snappedBeforeNs) {
        long snappedTimeNs;
        long snappedTimeNs2 = j2 + (snappedBeforeNs * ((vsyncCount - j2) / snappedBeforeNs));
        if (vsyncCount <= snappedTimeNs2) {
            snappedTimeNs = snappedTimeNs2 - snappedBeforeNs;
        } else {
            snappedTimeNs = snappedTimeNs2;
            snappedTimeNs2 += snappedBeforeNs;
        }
        return snappedTimeNs2 - vsyncCount < vsyncCount - snappedTimeNs ? snappedTimeNs2 : snappedTimeNs;
    }

    @TargetApi(17)
    private C0933Ix A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 117));
        if (displayManager == null) {
            return null;
        }
        return new C0933Ix(this, displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        Display defaultDisplay = this.A09.getDefaultDisplay();
        if (defaultDisplay != null) {
            double defaultDisplayRefreshRate = defaultDisplay.getRefreshRate();
            double d2 = 1.0E9d / defaultDisplayRefreshRate;
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0D[0] = "cQjBVfAMAaWJXkNWf";
            this.A06 = (long) d2;
            this.A07 = (this.A06 * 80) / 100;
        }
    }

    private boolean A06(long j2, long j3) {
        return Math.abs((j3 - this.A05) - (j2 - this.A04)) > 20000000;
    }

    public final long A07(long j2, long j3) {
        long j4 = 1000 * j2;
        long j5 = j4;
        long adjustedReleaseTimeNs = j3;
        if (this.A08) {
            if (j2 != this.A02) {
                this.A01++;
                this.A00 = this.A03;
            }
            long j6 = this.A01;
            if (j6 >= 6) {
                long j7 = this.A00 + ((j4 - this.A04) / j6);
                if (!A06(j7, j3)) {
                    long adjustedFrameTimeNs = this.A04;
                    adjustedReleaseTimeNs = (this.A05 + j7) - adjustedFrameTimeNs;
                    j5 = j7;
                } else {
                    this.A08 = false;
                }
            } else if (A06(j4, j3)) {
                this.A08 = false;
            }
        }
        if (!this.A08) {
            this.A04 = j4;
            this.A05 = j3;
            this.A01 = 0L;
            this.A08 = true;
        }
        this.A02 = j2;
        this.A03 = j5;
        Choreographer$FrameCallbackC0934Iy choreographer$FrameCallbackC0934Iy = this.A0B;
        if (choreographer$FrameCallbackC0934Iy == null || this.A06 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long j8 = choreographer$FrameCallbackC0934Iy.A04;
        if (j8 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long adjustedFrameTimeNs2 = this.A06;
        long adjustedReleaseTimeNs2 = A00(adjustedReleaseTimeNs, j8, adjustedFrameTimeNs2);
        long adjustedFrameTimeNs3 = this.A07;
        return adjustedReleaseTimeNs2 - adjustedFrameTimeNs3;
    }

    public final void A08() {
        if (this.A09 != null) {
            C0933Ix c0933Ix = this.A0A;
            if (c0933Ix != null) {
                c0933Ix.A01();
            }
            this.A0B.A07();
        }
    }

    public final void A09() {
        this.A08 = false;
        if (this.A09 != null) {
            this.A0B.A06();
            C0933Ix c0933Ix = this.A0A;
            if (c0933Ix != null) {
                c0933Ix.A00();
            }
            A03();
        }
    }
}
