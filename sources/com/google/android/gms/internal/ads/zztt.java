package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztt implements c.b {
    private final /* synthetic */ zztn zzbvu;
    private final /* synthetic */ zzbaa zzbwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztt(zztn zztnVar, zzbaa zzbaaVar) {
        this.zzbvu = zztnVar;
        this.zzbwb = zzbaaVar;
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        obj = this.zzbvu.lock;
        synchronized (obj) {
            this.zzbwb.setException(new RuntimeException("Connection failed."));
        }
    }
}
