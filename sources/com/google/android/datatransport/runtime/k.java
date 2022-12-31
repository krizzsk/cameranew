package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
/* compiled from: SafeLoggingExecutor.java */
/* loaded from: classes2.dex */
class k implements Executor {
    private final Executor a;

    /* compiled from: SafeLoggingExecutor.java */
    /* loaded from: classes2.dex */
    static class a implements Runnable {
        private final Runnable a;

        a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e2) {
                com.google.android.datatransport.runtime.u.a.c("Executor", "Background execution failure.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Executor executor) {
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.a.execute(new a(runnable));
    }
}
