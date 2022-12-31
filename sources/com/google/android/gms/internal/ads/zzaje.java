package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaje implements c.b {
    private final /* synthetic */ zzbaa zzbwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaje(zzajb zzajbVar, zzbaa zzbaaVar) {
        this.zzbwb = zzbaaVar;
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        this.zzbwb.setException(new RuntimeException("Connection failed."));
    }
}
