package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class g9 implements m9 {
    final /* synthetic */ i9 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g9(i9 i9Var) {
        this.a = i9Var;
    }

    @Override // com.google.android.gms.measurement.internal.m9
    public final void zza(String str, Bundle bundle) {
        o4 o4Var;
        if (TextUtils.isEmpty(str)) {
            o4Var = this.a.f3842j;
            o4Var.a().m().a("AppId not known when logging error event");
            return;
        }
        this.a.c().p(new f9(this, str, bundle));
    }
}
