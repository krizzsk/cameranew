package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class e8 implements Runnable {
    final /* synthetic */ zzs a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ boolean f3782d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f3783e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e8(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, String str, String str2, boolean z) {
        this.f3783e = appMeasurementDynamiteService;
        this.a = zzsVar;
        this.b = str;
        this.c = str2;
        this.f3782d = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3783e.a.P().O(this.a, this.b, this.c, this.f3782d);
    }
}
