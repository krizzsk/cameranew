package com.sina.weibo.sdk.b;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a {
    private static final int J;
    private static final int K;
    private static final int L;
    private static final Comparator<Runnable> N;
    ThreadPoolExecutor M;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        J = availableProcessors;
        K = availableProcessors + 1;
        L = (availableProcessors * 2) + 1;
        N = new Comparator<Runnable>() { // from class: com.sina.weibo.sdk.b.a.1
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
                return 0;
            }
        };
    }

    public a() {
        if (this.M == null) {
            this.M = new ThreadPoolExecutor(K, L, 1L, TimeUnit.SECONDS, new PriorityBlockingQueue(5, N));
        }
    }
}
