package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class e {
    @Nullable
    @GuardedBy("MessengerIpcClient.class")

    /* renamed from: e */
    private static e f3584e;
    private final Context a;
    private final ScheduledExecutorService b;
    @GuardedBy("this")
    private f c = new f(this);
    @GuardedBy("this")

    /* renamed from: d */
    private int f3585d = 1;

    @VisibleForTesting
    private e(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i2;
        i2 = this.f3585d;
        this.f3585d = i2 + 1;
        return i2;
    }

    public static /* synthetic */ Context b(e eVar) {
        return eVar.a;
    }

    public static synchronized e c(Context context) {
        e eVar;
        synchronized (e.class) {
            if (f3584e == null) {
                f3584e = new e(context, com.google.android.gms.internal.cloudmessaging.zza.zza().zza(1, new com.google.android.gms.common.util.v.a("MessengerIpcClient"), zzf.zzb));
            }
            eVar = f3584e;
        }
        return eVar;
    }

    private final synchronized <T> com.google.android.gms.tasks.g<T> e(p<T> pVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(pVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.c.e(pVar)) {
            f fVar = new f(this);
            this.c = fVar;
            fVar.e(pVar);
        }
        return pVar.b.a();
    }

    public static /* synthetic */ ScheduledExecutorService g(e eVar) {
        return eVar.b;
    }

    public final com.google.android.gms.tasks.g<Void> d(int i2, Bundle bundle) {
        return e(new n(a(), 2, bundle));
    }

    public final com.google.android.gms.tasks.g<Bundle> f(int i2, Bundle bundle) {
        return e(new q(a(), 1, bundle));
    }
}
