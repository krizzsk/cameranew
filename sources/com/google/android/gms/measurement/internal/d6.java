package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class d6 implements Runnable {
    final /* synthetic */ zzs a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d6(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar) {
        this.b = appMeasurementDynamiteService;
        this.a = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.P().S(this.a);
    }
}
