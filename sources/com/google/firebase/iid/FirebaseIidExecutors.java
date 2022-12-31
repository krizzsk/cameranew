package com.google.firebase.iid;

import com.google.android.gms.common.util.v.a;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@21.0.1 */
/* loaded from: classes2.dex */
public class FirebaseIidExecutors {
    private static final Executor DIRECT_EXECUTOR = FirebaseIidExecutors$$Lambda$0.$instance;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor directExecutor() {
        return DIRECT_EXECUTOR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExecutorService newCachedSingleThreadExecutor() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("firebase-iid-executor"));
    }
}
