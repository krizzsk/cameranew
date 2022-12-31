package com.facebook.common.executors;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
/* compiled from: DefaultSerialExecutorService.java */
/* loaded from: classes.dex */
public class b extends a implements e {
    public b(Executor executor) {
        super("SerialExecutor", 1, executor, new LinkedBlockingQueue());
    }

    @Override // com.facebook.common.executors.a, java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        super.execute(runnable);
    }
}
