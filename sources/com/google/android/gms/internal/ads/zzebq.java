package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import com.google.android.gms.internal.ads.zzegl;
import com.google.android.gms.internal.ads.zzego;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzebq {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzego zzb(zzegl zzeglVar) {
        zzego.zzb zzfn = zzego.zzbes().zzfn(zzeglVar.zzbek());
        for (zzegl.zzb zzbVar : zzeglVar.zzbel()) {
            zzfn.zzb((zzego.zza) ((zzelb) zzego.zza.zzbeu().zzhv(zzbVar.zzbep().zzbdx()).zzb(zzbVar.zzbau()).zzb(zzbVar.zzbav()).zzfo(zzbVar.zzbeq()).zzbiw()));
        }
        return (zzego) ((zzelb) zzfn.zzbiw());
    }

    public static void zzc(zzegl zzeglVar) throws GeneralSecurityException {
        int zzbek = zzeglVar.zzbek();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzegl.zzb zzbVar : zzeglVar.zzbel()) {
            if (zzbVar.zzbau() == zzege.ENABLED) {
                if (zzbVar.zzbeo()) {
                    if (zzbVar.zzbav() != zzegx.UNKNOWN_PREFIX) {
                        if (zzbVar.zzbau() != zzege.UNKNOWN_STATUS) {
                            if (zzbVar.zzbeq() == zzbek) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            if (zzbVar.zzbep().zzbdz() != zzegd.zza.ASYMMETRIC_PUBLIC) {
                                z2 = false;
                            }
                            i2++;
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zzbeq())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zzbeq())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zzbeq())));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
