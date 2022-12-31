package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedr {
    @Deprecated
    private static final zzegy zzicr;
    @Deprecated
    private static final zzegy zzics;
    @Deprecated
    private static final zzegy zzict;
    private static final String zzidx = new zzedn().getKeyType();

    static {
        zzegy zzbfk = zzegy.zzbfk();
        zzicr = zzbfk;
        zzics = zzbfk;
        zzict = zzbfk;
        try {
            zzbba();
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static void zzbba() throws GeneralSecurityException {
        zzebm.zza((zzeax) new zzedn(), true);
        zzebm.zza((zzeax) new zzedm(), true);
        zzebm.zza(new zzedu());
    }
}
