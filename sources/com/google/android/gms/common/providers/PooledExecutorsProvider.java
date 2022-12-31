package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@Deprecated
/* loaded from: classes2.dex */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public interface PooledExecutorFactory {
        @Deprecated
        ScheduledExecutorService a();
    }

    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (a == null) {
                a = new a();
            }
            pooledExecutorFactory = a;
        }
        return pooledExecutorFactory;
    }
}
