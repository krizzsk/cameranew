package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class w implements c.b {
    private final /* synthetic */ com.google.android.gms.common.api.internal.l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(com.google.android.gms.common.api.internal.l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.a.onConnectionFailed(connectionResult);
    }
}
