package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajf implements c.a {
    private final /* synthetic */ zzbaa zzbwb;
    private final /* synthetic */ zzajb zzdis;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajf(zzajb zzajbVar, zzbaa zzbaaVar) {
        this.zzdis = zzajbVar;
        this.zzbwb = zzbaaVar;
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(@Nullable Bundle bundle) {
        zzaiq zzaiqVar;
        try {
            zzbaa zzbaaVar = this.zzbwb;
            zzaiqVar = this.zzdis.zzdir;
            zzbaaVar.set(zzaiqVar.zzub());
        } catch (DeadObjectException e2) {
            this.zzbwb.setException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
        zzbaa zzbaaVar = this.zzbwb;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i2);
        zzbaaVar.setException(new RuntimeException(sb.toString()));
    }
}
