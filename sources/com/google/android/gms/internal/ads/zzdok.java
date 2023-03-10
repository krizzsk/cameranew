package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdok {
    public static zzvg zza(zzdom zzdomVar, zzvg zzvgVar) {
        if (zzdomVar.equals(zzdom.MEDIATION_SHOW_ERROR)) {
            if (((Integer) zzwr.zzqr().zzd(zzabp.zzczy)).intValue() > 0) {
                return zzvgVar;
            }
        }
        return zza(zzdomVar, null, zzvgVar);
    }

    public static zzvg zzh(Throwable th) {
        if (th instanceof zzcrn) {
            zzcrn zzcrnVar = (zzcrn) th;
            return zza(zzcrnVar.zzarh(), zzcrnVar.zzary());
        } else if (th instanceof zzcmb) {
            if (th.getMessage() == null) {
                return zza(((zzcmb) th).zzarh(), null, null);
            }
            return zza(((zzcmb) th).zzarh(), th.getMessage(), null);
        } else if (th instanceof com.google.android.gms.ads.internal.util.zzap) {
            com.google.android.gms.ads.internal.util.zzap zzapVar = (com.google.android.gms.ads.internal.util.zzap) th;
            return new zzvg(zzapVar.getErrorCode(), zzdwt.zzhm(zzapVar.getMessage()), MobileAds.ERROR_DOMAIN, null, null);
        } else {
            return zza(zzdom.INTERNAL_ERROR, null, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzvg zza(zzdom zzdomVar, @Nullable String str, @Nullable zzvg zzvgVar) {
        if (str == null) {
            switch (zzdoj.zzhlt[zzdomVar.ordinal()]) {
                case 1:
                    str = "Invalid request.";
                    break;
                case 2:
                    str = "Invalid request: Invalid ad unit ID.";
                    break;
                case 3:
                    str = "Invalid request: Invalid ad size.";
                    break;
                case 4:
                    str = "Network error.";
                    break;
                case 5:
                    str = "No fill.";
                    break;
                case 6:
                    str = "App ID missing.";
                    break;
                case 7:
                    str = "A mediation adapter failed to show the ad.";
                    break;
                case 8:
                    str = "The ad is not ready.";
                    break;
                case 9:
                    str = "The ad has already been shown.";
                    break;
                case 10:
                    str = "The ad can not be shown when app is not in foreground.";
                    break;
                case 11:
                default:
                    str = "Internal error.";
                    break;
                case 12:
                    if (((Integer) zzwr.zzqr().zzd(zzabp.zzdac)).intValue() <= 0) {
                        str = "The mediation adapter did not return an ad.";
                        break;
                    }
                    str = "No fill.";
                    break;
            }
        }
        String str2 = str;
        int i2 = 0;
        switch (zzdoj.zzhlt[zzdomVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 9:
                i2 = 1;
                break;
            case 4:
            case 8:
                i2 = 2;
                break;
            case 5:
            case 10:
                i2 = 3;
                break;
            case 6:
                i2 = 8;
                break;
            case 7:
                i2 = 4;
                break;
            case 11:
            case 13:
                break;
            case 12:
                if (((Integer) zzwr.zzqr().zzd(zzabp.zzdac)).intValue() <= 0) {
                    i2 = 9;
                    break;
                }
                i2 = 3;
                break;
            default:
                String valueOf = String.valueOf(zzdomVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unknown SdkError: ");
                sb.append(valueOf);
                throw new AssertionError(sb.toString());
        }
        return new zzvg(i2, str2, MobileAds.ERROR_DOMAIN, zzvgVar, null);
    }

    public static zzvg zza(Throwable th, @Nullable zzcrq zzcrqVar) {
        zzvg zzvgVar;
        zzvg zzh = zzh(th);
        int i2 = zzh.errorCode;
        if ((i2 == 3 || i2 == 0) && (zzvgVar = zzh.zzchi) != null && !zzvgVar.zzchh.equals(MobileAds.ERROR_DOMAIN)) {
            zzh.zzchi = null;
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdab)).booleanValue() && zzcrqVar != null) {
            zzh.zzchj = zzcrqVar.zzasa();
        }
        return zzh;
    }
}
