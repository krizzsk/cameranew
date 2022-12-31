package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdzj<V> extends zzdzg<V> implements zzdzw<V> {
    @Override // com.google.android.gms.internal.ads.zzdzw
    public void addListener(Runnable runnable, Executor executor) {
        zzbad().addListener(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdzg
    /* renamed from: zzbae */
    public abstract zzdzw<? extends V> zzbad();
}
