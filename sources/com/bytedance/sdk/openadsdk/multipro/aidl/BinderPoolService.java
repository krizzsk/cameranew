package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.b;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.c;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.utils.o;
/* loaded from: classes.dex */
public class BinderPoolService extends Service {
    private Binder a = new a();

    /* loaded from: classes.dex */
    public static class a extends IBinderPool.Stub {
        @Override // com.bytedance.sdk.openadsdk.IBinderPool
        public IBinder queryBinder(int i2) throws RemoteException {
            o.c("MultiProcess", "queryBinder...........binderCode=" + i2);
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 4) {
                            return null;
                        }
                        return c.a();
                    }
                    return b.a();
                }
                return d.a();
            }
            return e.a();
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        o.b("MultiProcess", "BinderPoolService onBind ! ");
        return this.a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        o.b("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        o.b("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
