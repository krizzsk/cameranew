package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzbr;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.2 */
/* loaded from: classes2.dex */
final class zzb implements Callable<String> {
    final /* synthetic */ FirebaseAnalytics zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ String call() throws Exception {
        zzbr zzbrVar;
        zzbrVar = this.zza.zzb;
        return zzbrVar.zzF();
    }
}
