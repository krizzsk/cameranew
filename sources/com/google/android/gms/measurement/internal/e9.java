package com.google.android.gms.measurement.internal;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class e9 implements Runnable {
    final /* synthetic */ s9 a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e9(AppMeasurementDynamiteService appMeasurementDynamiteService, s9 s9Var) {
        this.b = appMeasurementDynamiteService;
        this.a = s9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a.D().t(this.a);
    }
}
