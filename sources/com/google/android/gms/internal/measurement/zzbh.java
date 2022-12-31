package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.p5;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzbh extends zzu {
    private final p5 zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbh(p5 p5Var) {
        this.zza = p5Var;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zzd(String str, String str2, Bundle bundle, long j2) {
        this.zza.a(str, str2, bundle, j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final int zze() {
        return System.identityHashCode(this.zza);
    }
}
