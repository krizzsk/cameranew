package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzv;
/* compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.2 */
/* loaded from: classes2.dex */
final class t9 implements q5 {
    public final zzv a;
    final /* synthetic */ AppMeasurementDynamiteService b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzv zzvVar) {
        this.b = appMeasurementDynamiteService;
        this.a = zzvVar;
    }

    @Override // com.google.android.gms.measurement.internal.q5
    public final void onEvent(String str, String str2, Bundle bundle, long j2) {
        try {
            this.a.zzd(str, str2, bundle, j2);
        } catch (RemoteException e2) {
            o4 o4Var = this.b.a;
            if (o4Var != null) {
                o4Var.a().p().b("Event listener threw exception", e2);
            }
        }
    }
}
