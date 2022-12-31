package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.a;
import com.google.android.gms.tasks.g;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public final /* synthetic */ class Utils$$Lambda$1 implements a {
    private final CountDownLatch arg$1;

    private Utils$$Lambda$1(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    public static a lambdaFactory$(CountDownLatch countDownLatch) {
        return new Utils$$Lambda$1(countDownLatch);
    }

    @Override // com.google.android.gms.tasks.a
    public Object then(g gVar) {
        return this.arg$1.countDown();
    }
}
