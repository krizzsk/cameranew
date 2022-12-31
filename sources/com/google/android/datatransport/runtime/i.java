package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;
/* compiled from: ExecutionModule.java */
/* loaded from: classes2.dex */
abstract class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Singleton
    public static Executor a() {
        return new k(Executors.newSingleThreadExecutor());
    }
}
