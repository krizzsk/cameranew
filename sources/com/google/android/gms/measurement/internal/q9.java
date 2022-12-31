package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class q9 implements Runnable {
    final /* synthetic */ zzs a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f3919d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, String str, String str2) {
        this.f3919d = appMeasurementDynamiteService;
        this.a = zzsVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3919d.a.P().M(this.a, this.b, this.c);
    }
}
