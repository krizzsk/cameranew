package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzff {
    static zzeat zzzp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(zzfc zzfcVar) throws IllegalAccessException, InvocationTargetException {
        Method zza;
        zzeat zza2;
        if (zzzp != null) {
            return true;
        }
        String str = (String) zzwr.zzqr().zzd(zzabp.zzcsg);
        if (str == null || str.length() == 0) {
            str = (zzfcVar == null || (zza = zzfcVar.zza("/TbyeKn5BCGoFXpEYkmkevBjYiDI2cU9nEifSIchqqD5aWfWy6v5sZTpifn+5AIL", "PJXTpPH5Q3JP8R736KmmofmTne3UwIW4eaifsKPbWk4=")) == null) ? null : (String) zza.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzebc zzl = zzebg.zzl(zzcy.zzb(str, true));
            for (zzegk zzegkVar : zzedc.zzicr.zzbfj()) {
                if (!zzegkVar.zzbdx().isEmpty()) {
                    if (!zzegkVar.zzbef().isEmpty()) {
                        if (!zzegkVar.zzbei().isEmpty()) {
                            if (!zzegkVar.zzbei().equals("TinkAead") && !zzegkVar.zzbei().equals("TinkMac") && !zzegkVar.zzbei().equals("TinkHybridDecrypt") && !zzegkVar.zzbei().equals("TinkHybridEncrypt") && !zzegkVar.zzbei().equals("TinkPublicKeySign") && !zzegkVar.zzbei().equals("TinkPublicKeyVerify") && !zzegkVar.zzbei().equals("TinkStreamingAead") && !zzegkVar.zzbei().equals("TinkDeterministicAead")) {
                                zzeap<?> zzhr = zzebm.zzhr(zzegkVar.zzbei());
                                zzebm.zza(zzhr.zzbah());
                                zzebm.zza(zzhr.zzb(zzegkVar.zzbdx(), zzegkVar.zzbef(), zzegkVar.zzbeg()), zzegkVar.zzbeh());
                            }
                        } else {
                            throw new GeneralSecurityException("Missing catalogue_name.");
                        }
                    } else {
                        throw new GeneralSecurityException("Missing primitive_name.");
                    }
                } else {
                    throw new GeneralSecurityException("Missing type_url.");
                }
            }
            zza2 = zzedg.zza(zzl, null);
            zzzp = zza2;
        } catch (IllegalArgumentException | GeneralSecurityException unused) {
        }
        return zza2 != null;
    }
}
