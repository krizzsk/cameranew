package com.facebook.ads.redexgen.X;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
/* loaded from: assets/audience_network.dex */
public final class UT implements InterfaceC0895Hj {
    public static String[] A03 = {"zA1HDLVhPd9PsL9PenCbpcrAKXxlN0d6", "FLS1DqH1RbizqOpj", "1z8O9NEtb5xyjYGA", "8w8GUSv0BTEQmaLhHrYTkFjQIFXWxu0p", "o1jGjvwpoOOHSDmJh0w1BZ4ZQReO8O7V", "", "IXAYHKYtOagUrLCRc2OBPi2ErH2JE5Q2", "ufrZt7t49gDVq6vRzV1VlqPqnp3Kfu3W"};
    public HandlerC0889Hd<? extends InterfaceC0890He> A00;
    public IOException A01;
    public final ExecutorService A02;

    public UT(String str) {
        this.A02 = C0923Il.A0T(str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hc != com.facebook.ads.internal.exoplayer2.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.He> */
    public final <T extends InterfaceC0890He> long A04(T loadable, InterfaceC0888Hc<T> interfaceC0888Hc, int i2) {
        Looper myLooper = Looper.myLooper();
        I6.A04(myLooper != null);
        this.A01 = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new HandlerC0889Hd(this, myLooper, loadable, interfaceC0888Hc, i2, elapsedRealtime).A06(0L);
        return elapsedRealtime;
    }

    public final void A05() {
        this.A00.A07(false);
    }

    public final void A06(int i2) throws IOException {
        IOException iOException = this.A01;
        if (iOException == null) {
            HandlerC0889Hd<? extends InterfaceC0890He> handlerC0889Hd = this.A00;
            if (handlerC0889Hd != null) {
                if (A03[0].charAt(1) != 'f') {
                    String[] strArr = A03;
                    strArr[2] = "ShO16ogjgPVIHMzl";
                    strArr[1] = "8gZONBnlwtDMou1V";
                    if (i2 == Integer.MIN_VALUE) {
                        i2 = handlerC0889Hd.A03;
                    }
                    handlerC0889Hd.A05(i2);
                    return;
                }
                throw new RuntimeException();
            }
            return;
        }
        throw iOException;
    }

    public final void A07(@Nullable InterfaceC0891Hf interfaceC0891Hf) {
        HandlerC0889Hd<? extends InterfaceC0890He> handlerC0889Hd = this.A00;
        if (handlerC0889Hd != null) {
            handlerC0889Hd.A07(true);
        }
        if (interfaceC0891Hf != null) {
            this.A02.execute(new RunnableC0892Hg(interfaceC0891Hf));
        }
        this.A02.shutdown();
    }

    public final boolean A08() {
        return this.A00 != null;
    }
}
