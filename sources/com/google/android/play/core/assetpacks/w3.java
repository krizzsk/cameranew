package com.google.android.play.core.assetpacks;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public final class w3 implements com.google.android.play.core.internal.n1<Executor> {
    public static Executor b() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(n3.a);
        com.google.android.play.core.internal.t0.p(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    @Override // com.google.android.play.core.internal.n1
    public final /* bridge */ /* synthetic */ Executor a() {
        return b();
    }
}
