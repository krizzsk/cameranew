package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public interface zzdzw<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
