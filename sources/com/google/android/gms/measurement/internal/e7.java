package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class e7 implements Runnable {
    final /* synthetic */ zzs a;
    final /* synthetic */ zzas b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f3781d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e7(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, zzas zzasVar, String str) {
        this.f3781d = appMeasurementDynamiteService;
        this.a = zzsVar;
        this.b = zzasVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3781d.a.P().s(this.a, this.b, this.c);
    }
}
