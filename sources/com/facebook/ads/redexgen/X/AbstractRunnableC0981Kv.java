package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
@SuppressLint({"CatchGeneralException"})
/* renamed from: com.facebook.ads.redexgen.X.Kv  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractRunnableC0981Kv implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<InterfaceC0972Kl> A04;
    @Nullable
    public final C0970Kj A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A01, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 116);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{124, 91, 64, 64, 79, 76, 66, 75, 14, 77, 92, 75, 79, 90, 75, 74, 0, 14, 122, 70, 92, 75, 79, 74, 20, 14};
    }

    public abstract void A06();

    static {
        A02();
        A02 = new AtomicBoolean();
        A03 = new AtomicBoolean(false);
        A04 = new AtomicReference<>();
    }

    public AbstractRunnableC0981Kv() {
        if (A03.get()) {
            this.A00 = L0.A01(new C0985Kz(A01(0, 26, 90) + Thread.currentThread().getName()));
            return;
        }
        this.A00 = null;
    }

    public static void A03(boolean z) {
        A03.set(z);
    }

    public static void A04(boolean z, InterfaceC0972Kl interfaceC0972Kl) {
        A02.set(z);
        A04.set(interfaceC0972Kl);
    }

    @Nullable
    public final C0970Kj A05() {
        return this.A00;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (A03.get()) {
                L0.A03(this);
            }
            A06();
            if (A03.get()) {
                L0.A04(this);
            }
        } catch (Throwable t) {
            C0974Kn.A00(t, this);
        }
    }
}
