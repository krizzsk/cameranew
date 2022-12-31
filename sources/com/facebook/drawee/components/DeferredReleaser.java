package com.facebook.drawee.components;

import android.os.Looper;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class DeferredReleaser {
    @Nullable
    private static DeferredReleaser a;

    /* loaded from: classes.dex */
    public interface a {
        void release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static synchronized DeferredReleaser getInstance() {
        DeferredReleaser deferredReleaser;
        synchronized (DeferredReleaser.class) {
            if (a == null) {
                a = new com.facebook.drawee.components.a();
            }
            deferredReleaser = a;
        }
        return deferredReleaser;
    }

    public abstract void a(a aVar);

    public abstract void c(a aVar);
}
