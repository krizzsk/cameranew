package com.google.android.gms.internal.common;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class zzg implements zzf {
    private zzg() {
    }

    @Override // com.google.android.gms.internal.common.zzf
    @NonNull
    public final ScheduledExecutorService zza(int i2, int i3) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
