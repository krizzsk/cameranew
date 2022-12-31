package com.google.android.gms.common.providers;

import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.internal.common.zze;
import com.google.android.gms.internal.common.zzj;
import java.util.concurrent.ScheduledExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class a implements PooledExecutorsProvider.PooledExecutorFactory {
    @Override // com.google.android.gms.common.providers.PooledExecutorsProvider.PooledExecutorFactory
    public final ScheduledExecutorService a() {
        return zze.zza().zza(1, zzj.zza);
    }
}
