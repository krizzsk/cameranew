package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzeaz<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzibj;

    public zzeaz(Class<PrimitiveT> cls) {
        this.zzibj = cls;
    }

    public abstract PrimitiveT zzah(KeyT keyt) throws GeneralSecurityException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Class<PrimitiveT> zzbai() {
        return this.zzibj;
    }
}
