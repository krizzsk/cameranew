package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.InterfaceC0890He;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Hd  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class HandlerC0889Hd<T extends InterfaceC0890He> extends Handler implements Runnable {
    public static byte[] A0A;
    public int A00;
    @Nullable
    public InterfaceC0888Hc<T> A01;
    public IOException A02;
    public final int A03;
    public final long A04;
    public final T A05;
    public volatile Thread A06;
    public volatile boolean A07;
    public volatile boolean A08;
    public final /* synthetic */ UT A09;

    static {
        A04();
    }

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 16);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0A = new byte[]{-96, -61, -75, -72, -88, -75, -57, -65, -113, -75, -76, -113, -90, -115, -91, -83, -81, -78, -71, 96, -91, -78, -78, -81, -78, 96, -84, -81, -95, -92, -87, -82, -89, 96, -77, -76, -78, -91, -95, -83, -70, -45, -54, -35, -43, -54, -56, -39, -54, -55, -123, -54, -41, -41, -44, -41, -123, -47, -44, -58, -55, -50, -45, -52, -123, -40, -39, -41, -54, -58, -46, -87, -62, -71, -52, -60, -71, -73, -56, -71, -72, 116, -71, -52, -73, -71, -60, -56, -67, -61, -62, 116, -68, -75, -62, -72, -64, -67, -62, -69, 116, -64, -61, -75, -72, 116, -73, -61, -63, -60, -64, -71, -56, -71, -72, -38, -13, -22, -3, -11, -22, -24, -7, -22, -23, -91, -22, -3, -24, -22, -11, -7, -18, -12, -13, -91, -15, -12, -26, -23, -18, -13, -20, -91, -8, -7, -9, -22, -26, -14, -94, -91, -105, -102, 112};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hc != com.facebook.ads.internal.exoplayer2.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.He> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    public HandlerC0889Hd(UT ut, Looper looper, T loadable, InterfaceC0888Hc<T> interfaceC0888Hc, int i2, long j2) {
        super(looper);
        this.A09 = ut;
        this.A05 = loadable;
        this.A01 = interfaceC0888Hc;
        this.A03 = i2;
        this.A04 = j2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    private long A00() {
        return Math.min((this.A00 - 1) * 1000, 5000);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    private void A02() {
        ExecutorService executorService;
        HandlerC0889Hd handlerC0889Hd;
        this.A02 = null;
        executorService = this.A09.A02;
        handlerC0889Hd = this.A09.A00;
        executorService.execute(handlerC0889Hd);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    private void A03() {
        this.A09.A00 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    public final void A05(int i2) throws IOException {
        IOException iOException = this.A02;
        if (iOException == null || this.A00 <= i2) {
            return;
        }
        throw iOException;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    public final void A06(long j2) {
        HandlerC0889Hd handlerC0889Hd;
        handlerC0889Hd = this.A09.A00;
        I6.A04(handlerC0889Hd == null);
        this.A09.A00 = this;
        if (j2 > 0) {
            sendEmptyMessageDelayed(0, j2);
        } else {
            A02();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    public final void A07(boolean z) {
        this.A08 = z;
        this.A02 = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.A07 = true;
            this.A05.A3w();
            if (this.A06 != null) {
                this.A06.interrupt();
            }
        }
        if (z) {
            A03();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.A01.AB0(this.A05, elapsedRealtime, elapsedRealtime - this.A04, true);
            this.A01 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (this.A08) {
                return;
            }
            if (message.what == 0) {
                A02();
            } else if (message.what != 4) {
                A03();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime - this.A04;
                if (this.A07) {
                    this.A01.AB0(this.A05, elapsedRealtime, j2, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    this.A01.AB0(this.A05, elapsedRealtime, j2, false);
                } else if (i2 == 2) {
                    try {
                        this.A01.AB2(this.A05, elapsedRealtime, j2);
                    } catch (RuntimeException e2) {
                        Log.e(A01(0, 8, 68), A01(71, 44, 68), e2);
                        this.A09.A01 = new C0894Hi(e2);
                    }
                } else if (i2 != 3) {
                } else {
                    this.A02 = (IOException) message.obj;
                    int AB3 = this.A01.AB3(this.A05, elapsedRealtime, j2, this.A02);
                    if (AB3 != 3) {
                        if (AB3 == 2) {
                            return;
                        }
                        this.A00 = AB3 == 1 ? 1 : this.A00 + 1;
                        A06(A00());
                        return;
                    }
                    this.A09.A01 = this.A02;
                }
            } else {
                throw ((Error) message.obj);
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Hd != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.He> */
    @Override // java.lang.Runnable
    public final void run() {
        String A01 = A01(0, 8, 68);
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            this.A06 = Thread.currentThread();
                            if (!this.A07) {
                                C0920Ii.A02(A01(150, 5, 38) + this.A05.getClass().getSimpleName());
                                try {
                                    this.A05.A8d();
                                } finally {
                                    C0920Ii.A00();
                                }
                            }
                            if (!this.A08) {
                                sendEmptyMessage(2);
                            }
                        } catch (IOException e2) {
                            if (!this.A08) {
                                obtainMessage(3, e2).sendToTarget();
                            }
                        }
                    } catch (Exception e3) {
                        Log.e(A01, A01(115, 35, 117), e3);
                        if (!this.A08) {
                            obtainMessage(3, new C0894Hi(e3)).sendToTarget();
                        }
                    }
                } catch (OutOfMemoryError e4) {
                    Log.e(A01, A01(8, 32, 48), e4);
                    if (!this.A08) {
                        obtainMessage(3, new C0894Hi(e4)).sendToTarget();
                    }
                }
            } catch (Error e5) {
                Log.e(A01, A01(40, 31, 85), e5);
                if (!this.A08) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (InterruptedException unused) {
                I6.A04(this.A07);
                if (!this.A08) {
                    sendEmptyMessage(2);
                }
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
