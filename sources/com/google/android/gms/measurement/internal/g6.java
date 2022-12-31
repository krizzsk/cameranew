package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class g6 implements m9 {
    final /* synthetic */ r6 a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g6(r6 r6Var) {
        this.a = r6Var;
    }

    @Override // com.google.android.gms.measurement.internal.m9
    public final void zza(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.a.V("auto", "_err", bundle);
        } else {
            o4.s();
            throw null;
        }
    }
}
