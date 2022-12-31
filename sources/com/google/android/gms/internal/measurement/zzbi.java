package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.q5;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzbi extends zzu {
    private final q5 zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(q5 q5Var) {
        this.zza = q5Var;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zzd(String str, String str2, Bundle bundle, long j2) {
        this.zza.onEvent(str, str2, bundle, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
