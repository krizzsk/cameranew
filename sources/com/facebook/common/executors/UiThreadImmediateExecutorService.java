package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends c {
    @Nullable
    private static UiThreadImmediateExecutorService b;

    private UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static UiThreadImmediateExecutorService getInstance() {
        if (b == null) {
            b = new UiThreadImmediateExecutorService();
        }
        return b;
    }

    @Override // com.facebook.common.executors.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (a()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
