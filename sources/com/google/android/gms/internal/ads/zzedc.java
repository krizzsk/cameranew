package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzedc {
    private static final String zzidl = new zzeda().getKeyType();
    private static final String zzidm = new zzecz().getKeyType();
    @Deprecated
    public static final zzegy zzicr = zzegy.zzbfk();
    @Deprecated
    private static final zzegy zzics = zzegy.zzbfk();
    @Deprecated
    private static final zzegy zzict = zzegy.zzbfk();

    static {
        try {
            zzebs.zzbba();
            zzebm.zza((zzebj) new zzecz(), (zzeax) new zzeda(), true);
            zzebm.zza(new zzede());
            zzebm.zza(new zzedf());
        } catch (GeneralSecurityException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }
}
