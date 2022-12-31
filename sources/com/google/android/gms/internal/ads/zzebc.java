package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzebc {
    private final zzegl zzibn;

    private zzebc(zzegl zzeglVar) {
        this.zzibn = zzeglVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzebc zza(zzegl zzeglVar) throws GeneralSecurityException {
        if (zzeglVar != null && zzeglVar.zzbem() > 0) {
            return new zzebc(zzeglVar);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        return zzebq.zzb(this.zzibn).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzegl zzbaq() {
        return this.zzibn;
    }
}
