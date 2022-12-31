package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class y implements Executor {
    static final Executor a = new y();

    private y() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
