package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
/* renamed from: com.facebook.ads.redexgen.X.5m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class ServiceConnectionC06115m implements ServiceConnection {
    public static byte[] A02;
    public final BlockingQueue<IBinder> A00;
    public final AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 48);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{31, 52, 51, 57, 56, 47, 125, 60, 49, 47, 56, 60, 57, 36, 125, 62, 50, 51, 46, 40, 48, 56, 57};
    }

    public ServiceConnectionC06115m() {
        this.A01 = new AtomicBoolean(false);
        this.A00 = new LinkedBlockingDeque();
    }

    public final IBinder A02() throws InterruptedException {
        if (!this.A01.compareAndSet(true, true)) {
            return this.A00.take();
        }
        throw new IllegalStateException(A00(0, 23, 109));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                this.A00.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
