package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.c;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class x implements c.a {
    private final /* synthetic */ com.google.android.gms.common.api.internal.e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(com.google.android.gms.common.api.internal.e eVar) {
        this.a = eVar;
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(@Nullable Bundle bundle) {
        this.a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
        this.a.onConnectionSuspended(i2);
    }
}
