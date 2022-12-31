package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class a implements ServiceConnection {
    private boolean a = false;
    private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();

    public IBinder a(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        com.google.android.gms.common.internal.q.i("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.a) {
            this.a = true;
            IBinder poll = this.b.poll(j2, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b.add(iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
