package us.pinguo.loc;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* compiled from: LocNetworkSegmentation.kt */
/* loaded from: classes5.dex */
public final class r {
    public static final byte[] a(String inputPath) {
        kotlin.jvm.internal.s.h(inputPath, "inputPath");
        s sVar = new s(inputPath);
        FutureTask futureTask = new FutureTask(sVar);
        new Thread(futureTask).start();
        byte[] bArr = (byte[]) futureTask.get(15L, TimeUnit.SECONDS);
        sVar.m(true);
        return bArr;
    }
}
