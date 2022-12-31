package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes2.dex */
final /* synthetic */ class n3 implements ThreadFactory {
    static final ThreadFactory a = new n3();

    private n3() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
