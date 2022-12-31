package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class u {
    private static Handler a;

    public static synchronized Handler a() {
        Handler handler;
        synchronized (u.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            handler = a;
        }
        return handler;
    }

    public static ba a(final Handler handler) {
        return new ba() { // from class: com.tapjoy.internal.u.1
            @Override // com.tapjoy.internal.ba
            public final boolean a(Runnable runnable) {
                return handler.post(runnable);
            }
        };
    }
}
