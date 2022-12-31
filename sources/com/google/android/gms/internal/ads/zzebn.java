package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebm;
import java.security.GeneralSecurityException;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzebn implements zzebm.zzb {
    private final /* synthetic */ zzebj zzicf;
    private final /* synthetic */ zzeax zzicg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzebn(zzebj zzebjVar, zzeax zzeaxVar) {
        this.zzicf = zzebjVar;
        this.zzicg = zzeaxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebm.zzb
    public final <Q> zzeaw<Q> zzb(Class<Q> cls) throws GeneralSecurityException {
        try {
            return new zzebk(this.zzicf, this.zzicg, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebm.zzb
    public final Set<Class<?>> zzbam() {
        return this.zzicf.zzbam();
    }

    @Override // com.google.android.gms.internal.ads.zzebm.zzb
    public final zzeaw<?> zzbax() {
        zzebj zzebjVar = this.zzicf;
        return new zzebk(zzebjVar, this.zzicg, zzebjVar.zzban());
    }

    @Override // com.google.android.gms.internal.ads.zzebm.zzb
    public final Class<?> zzbay() {
        return this.zzicf.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzebm.zzb
    public final Class<?> zzbaz() {
        return this.zzicg.getClass();
    }
}
