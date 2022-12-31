package com.facebook.ads.redexgen.X;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.4o  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C05884o extends Thread {
    public static byte[] A07;
    public static String[] A08 = {"22scehDHoaCOvZMprlsBZA8XDImDmfKB", "weKghC0VptQmI5ngiGaEXX", "Hf9H6", "FJiPG4ANJnN6", "MZm2fX9OE1lWAQp9g7i9e16yKVjr6LaO", "qv5p39sFFmKE2Upe5HhwzyNbLjT31UC6", "BSHanWyHkNGNXcGKwO9o06mFf", "6OihQTIk4xH7HyNYKpu4LMiaEL1fh7ec"};
    public static final String A09;
    public final int A00;
    public final Handler A01;
    public final C05904q A02;
    public final XT A03;
    public final Runnable A04;
    public volatile long A05;
    public volatile boolean A06;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{97, 101, 10, 102, 105, 117, 10, 99, 66, 83, 66, 68, 83, 72, 85, 103, 101, 110, 101, 114, 105, 99};
    }

    static {
        A02();
        A09 = C05884o.class.getName();
    }

    public C05884o(XT xt, C05904q c05904q) {
        this(xt, c05904q, JD.A06(xt));
    }

    public C05884o(XT xt, C05904q c05904q, int i2) {
        this.A01 = new Handler(Looper.getMainLooper());
        this.A04 = new Runnable() { // from class: com.facebook.ads.redexgen.X.4n
            @Override // java.lang.Runnable
            public final void run() {
                if (C0974Kn.A02(this)) {
                    return;
                }
                try {
                    C05884o.this.A05 = 0L;
                    C05884o.this.A06 = false;
                } catch (Throwable th) {
                    C0974Kn.A00(th, this);
                }
            }
        };
        this.A05 = 0L;
        this.A06 = false;
        setName(A01(0, 15, 83));
        this.A00 = i2;
        this.A03 = xt;
        this.A02 = c05904q;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            long j2 = this.A00;
            while (!isInterrupted()) {
                long j3 = this.A05;
                String[] strArr = A08;
                if (strArr[1].length() != strArr[2].length()) {
                    String[] strArr2 = A08;
                    strArr2[3] = "QDJRY7exkP3l";
                    strArr2[6] = "zyOVtGNErBmKt3HrtbWcAlOC0";
                    boolean needPost = j3 == 0;
                    this.A05 = j2;
                    if (needPost) {
                        this.A01.post(this.A04);
                    }
                    try {
                        Thread.sleep(j2);
                        if (this.A05 != 0) {
                            boolean needPost2 = this.A06;
                            if (!needPost2) {
                                boolean needPost3 = Debug.isDebuggerConnected();
                                if (!needPost3) {
                                    boolean needPost4 = this.A02.A05();
                                    if (needPost4) {
                                        this.A03.A06().A8q(A01(15, 7, 116), C06808m.A12, new C06818n(this.A02.A04()));
                                    }
                                    this.A06 = true;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        BuildConfigApi.isDebug();
                        return;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
