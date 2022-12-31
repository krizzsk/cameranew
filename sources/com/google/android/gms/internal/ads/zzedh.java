package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzedh {
    public static void zza(zzefk zzefkVar) throws GeneralSecurityException {
        zzehx.zza(zza(zzefkVar.zzbcw().zzbdj()));
        zza(zzefkVar.zzbcw().zzbdk());
        if (zzefkVar.zzbcy() != zzefe.UNKNOWN_FORMAT) {
            zzebm.zza(zzefkVar.zzbcx().zzbcr());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzeft zzeftVar) throws NoSuchAlgorithmException {
        int i2 = zzedk.zzidt[zzeftVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return "HmacSha512";
                }
                String valueOf = String.valueOf(zzeftVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
                sb.append("hash unsupported for HMAC: ");
                sb.append(valueOf);
                throw new NoSuchAlgorithmException(sb.toString());
            }
            return "HmacSha256";
        }
        return "HmacSha1";
    }

    public static zzehz zza(zzefs zzefsVar) throws GeneralSecurityException {
        int i2 = zzedk.zzidu[zzefsVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return zzehz.NIST_P521;
                }
                String valueOf = String.valueOf(zzefsVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("unknown curve type: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
            return zzehz.NIST_P384;
        }
        return zzehz.NIST_P256;
    }

    public static zzeic zza(zzefe zzefeVar) throws GeneralSecurityException {
        int i2 = zzedk.zzidv[zzefeVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return zzeic.COMPRESSED;
                }
                String valueOf = String.valueOf(zzefeVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("unknown point format: ");
                sb.append(valueOf);
                throw new GeneralSecurityException(sb.toString());
            }
            return zzeic.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        return zzeic.UNCOMPRESSED;
    }
}
