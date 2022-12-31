package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdu implements zzduy {
    private final /* synthetic */ zzdsx zzwa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzds zzdsVar, zzdsx zzdsxVar) {
        this.zzwa = zzdsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzduy
    public final boolean zzb(File file) {
        try {
            return this.zzwa.zzb(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
