package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzazr implements ThreadFactory {
    private final /* synthetic */ String zzeii;
    private final AtomicInteger zzyx = new AtomicInteger(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazr(String str) {
        this.zzeii = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.zzeii;
        int andIncrement = this.zzyx.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
