package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.concurrent.CountDownLatch;
/* compiled from: BinderPool.java */
/* loaded from: classes.dex */
public class a {
    private static volatile a c;
    private Context a;
    private IBinderPool b;

    /* renamed from: d  reason: collision with root package name */
    private CountDownLatch f2087d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f2088e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private long f2089f = 0;

    /* renamed from: g  reason: collision with root package name */
    private ServiceConnection f2090g = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.b.asBinder().linkToDeath(a.this.f2091h, 0);
            } catch (RemoteException e2) {
                o.c("MultiProcess", "onServiceConnected throws :", e2);
            }
            a.this.f2087d.countDown();
            o.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f2089f));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            o.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private IBinder.DeathRecipient f2091h = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            o.d("MultiProcess", "binder died.");
            a.this.b.asBinder().unlinkToDeath(a.this.f2091h, 0);
            a.this.b = null;
            a.this.a();
        }
    };

    private a(Context context) {
        this.a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public IBinder a(int i2) {
        try {
            IBinderPool iBinderPool = this.b;
            if (iBinderPool != null) {
                return iBinderPool.queryBinder(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        o.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f2087d = new CountDownLatch(1);
        this.a.bindService(new Intent(this.a, BinderPoolService.class), this.f2090g, 1);
        this.f2089f = System.currentTimeMillis();
        try {
            this.f2087d.await();
        } catch (InterruptedException e2) {
            o.c("MultiProcess", "connectBinderPoolService throws: ", e2);
        }
    }
}
