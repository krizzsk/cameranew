package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: assets/audience_network.dex */
public final class FY {
    public static String[] A04 = {"HGHzNcawqnVFgJx8ceQNwcxcn1SDkpDb", "AD2ta0a", "biSUTEi4nYJndXTTLsT", "38FOXeSW4cnwnxdXp60to", "WtyRCcfaPM", "iLolo35", "fvJAwdggv90DLF", "FbA7S8K"};
    public final int A00;
    @Nullable
    public final FL A01;
    public final long A02;
    public final CopyOnWriteArrayList<FX> A03;

    public FY() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public FY(CopyOnWriteArrayList<FX> copyOnWriteArrayList, int i2, @Nullable FL fl, long j2) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i2;
        this.A01 = fl;
        this.A02 = j2;
    }

    private long A00(long j2) {
        long A01 = A3.A01(j2);
        if (A01 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.A02;
        if (A04[2].length() != 19) {
            throw new RuntimeException();
        }
        A04[7] = "vQJR5ZN";
        return j3 + A01;
    }

    private void A01(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    @CheckResult
    public final FY A02(int i2, @Nullable FL fl, long j2) {
        return new FY(this.A03, i2, fl, j2);
    }

    public final void A03() {
        I6.A04(this.A01 != null);
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX listenerAndHandler = it.next();
            A01(listenerAndHandler.A00, new FO(this, listenerAndHandler.A01));
        }
    }

    public final void A04() {
        I6.A04(this.A01 != null);
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX listenerAndHandler = it.next();
            A01(listenerAndHandler.A00, new FP(this, listenerAndHandler.A01));
        }
    }

    public final void A05() {
        I6.A04(this.A01 != null);
        Iterator<FX> it = this.A03.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A04[7].length() != 7) {
                throw new RuntimeException();
            }
            A04[2] = "JAadAeVCHcunsRCfoQL";
            if (hasNext) {
                FX listenerAndHandler = it.next();
                A01(listenerAndHandler.A00, new FU(this, listenerAndHandler.A01));
            } else {
                return;
            }
        }
    }

    public final void A06(int i2, @Nullable Format format, int i3, @Nullable Object obj, long j2) {
        A0C(new C0836Fa(1, i2, format, i3, obj, A00(j2), -9223372036854775807L));
    }

    public final void A07(Handler handler, InterfaceC0837Fb interfaceC0837Fb) {
        I6.A03((handler == null || interfaceC0837Fb == null) ? false : true);
        this.A03.add(new FX(handler, interfaceC0837Fb));
    }

    public final void A08(FZ fz, C0836Fa c0836Fa) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX next = it.next();
            A01(next.A00, new FS(this, next.A01, fz, c0836Fa));
        }
    }

    public final void A09(FZ fz, C0836Fa c0836Fa) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX next = it.next();
            A01(next.A00, new FR(this, next.A01, fz, c0836Fa));
        }
    }

    public final void A0A(FZ fz, C0836Fa c0836Fa) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX next = it.next();
            A01(next.A00, new FQ(this, next.A01, fz, c0836Fa));
        }
    }

    public final void A0B(FZ fz, C0836Fa c0836Fa, IOException iOException, boolean z) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX listenerAndHandler = it.next();
            A01(listenerAndHandler.A00, new FT(this, listenerAndHandler.A01, fz, c0836Fa, iOException, z));
        }
    }

    public final void A0C(C0836Fa c0836Fa) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX next = it.next();
            A01(next.A00, new FW(this, next.A01, c0836Fa));
        }
    }

    public final void A0D(InterfaceC0837Fb interfaceC0837Fb) {
        Iterator<FX> it = this.A03.iterator();
        while (it.hasNext()) {
            FX next = it.next();
            if (next.A01 == interfaceC0837Fb) {
                this.A03.remove(next);
            }
        }
    }

    public final void A0E(HV hv, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3, long j4) {
        A0A(new FZ(hv, j4, 0L, 0L), new C0836Fa(i2, i3, format, i4, obj, A00(j2), A00(j3)));
    }

    public final void A0F(HV hv, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6) {
        A08(new FZ(hv, j4, j5, j6), new C0836Fa(i2, i3, format, i4, obj, A00(j2), A00(j3)));
    }

    public final void A0G(HV hv, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6) {
        A09(new FZ(hv, j4, j5, j6), new C0836Fa(i2, i3, format, i4, obj, A00(j2), A00(j3)));
    }

    public final void A0H(HV hv, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z) {
        A0B(new FZ(hv, j4, j5, j6), new C0836Fa(i2, i3, format, i4, obj, A00(j2), A00(j3)), iOException, z);
    }
}
