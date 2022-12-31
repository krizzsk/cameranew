package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;
import javax.annotation.Nonnull;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzczz implements zzdzl<Uri> {
    private final /* synthetic */ zzasj zzgzx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzczz(zzczo zzczoVar, zzasj zzasjVar) {
        this.zzgzx = zzasjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(@Nonnull Uri uri) {
        try {
            this.zzgzx.onSuccess(Collections.singletonList(uri));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        try {
            zzasj zzasjVar = this.zzgzx;
            String valueOf = String.valueOf(th.getMessage());
            zzasjVar.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }
}
