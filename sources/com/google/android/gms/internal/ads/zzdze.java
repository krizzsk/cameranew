package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyk;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzdze<V> extends zzdzf<V> implements zzdyk.zzi<V> {
    @Override // com.google.android.gms.internal.ads.zzdyk, java.util.concurrent.Future
    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (V) super.get(j2, timeUnit);
    }
}
